import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe responsavel por gerenciar a conexao com o banco de dados
 * e a verificacao de usuarios.
 * <p>Essa classe fornece metodos para conectar ao banco de dados e validar usuario.</p>
 *
 * @version 1.0
 */

public class User {
    /**
     * Conecta ao banco de dados usando o driver MySQL JDBC.
     *
     * @return Um objeto Connection se a conexao for bem-sucedida; caso contrario, retorna null.
     */
    public Connection conectarBD() {
        Connection conn = null; // Conexao inicializada como nula
        try {
            // Carrega a classe do driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            // String de conexao com o banco de dados
            String url = "jdbc:mysql://localhost:3308/atividadeux?user=root&password=usbw";

            // Estabelece a conexao com o banco de dados
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Excecao capturada (nenhuma acao especifica e tomada)
        }
        return conn; // Retorna a conexao (pode ser null se houver erro)
    }

    /**
     * Nome do usuario autenticado. Preenchido apos uma verificacao bem-sucedida.
     */
    public String nome = ""; // Inicialmente vazio

    /**
     * Resultado da verificacao de login. True se o usuario for autenticado com sucesso.
     */
    public boolean result = false; // Inicialmente falso

    //---------------------------

    /**
     * Verifica as credenciais de login e senha de um usuario no banco de dados.
     *
     * @param login O login do usuario.
     * @param senha A senha do usuario.
     * @return true se o login e a senha corresponderem a um usuario no banco de dados; false caso contrario.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = ""; // String SQL inicializada
        Connection conn = conectarBD(); // Conecta ao banco de dados

        // Monta a consulta SQL para buscar o usuario com o login e senha fornecidos
        sql = "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "'";

        try {
            // Cria um Statement para executar a consulta SQL
            Statement st = conn.createStatement();

            // Executa a consulta e obtem os resultados
            ResultSet rs = st.executeQuery(sql);

            // Se encontrar um resultado, autentica o usuario e armazena o nome
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Excecao capturada (nenhuma acao especifica e tomada)
        }
        return result; // Retorna o resultado da verificacao
    }
}
