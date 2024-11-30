
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados
 * e a verificação de usuários.
 * <p>Essa classe fornece métodos para conectar ao banco de dados e validar usuario.</p>
 * @author Pedro Luiz Vidal Athayde
 * @version 1.0
 */

public class User {
    /**
     * Conecta ao banco de dados usando o driver MySQL JDBC.
     *
     * @return Um objeto Connection se a conexão for bem-sucedida; caso contrário, retorna null.
     */

    public Connection conectarBD() {
        Connection conn = null; // Conexão inicializada como nula
        try {
            // Carrega a classe do driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            // String de conexão com o banco de dados
            String url = "jdbc:mysql://localhost:3308/atividadeux?user=root&password=usbw";

            // Estabelece a conexão com o banco de dados
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Exceção capturada (nenhuma ação específica é tomada)
        }
        return conn; // Retorna a conexão (pode ser null se houver erro)
    }

    /**
     * Nome do usuário autenticado. Preenchido após uma verificação bem-sucedida.
     */
    public String nome = ""; // Inicialmente vazio

    /**
     * Resultado da verificação de login. True se o usuário for autenticado com sucesso.
     */
    public boolean result = false; // Inicialmente falso

    //---------------------------

    /**
     * Verifica as credenciais de login e senha de um usuário no banco de dados.
     *
     * @param login O login do usuário.
     * @param senha A senha do usuário.
     * @return true se o login e a senha corresponderem a um usuário no banco de dados; false caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = ""; // String SQL inicializada
        Connection conn = conectarBD(); // Conecta ao banco de dados

        // Monta a consulta SQL para buscar o usuário com o login e senha fornecidos
        sql = "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "'";

        try {
            // Cria um Statement para executar a consulta SQL
            Statement st = conn.createStatement();

            // Executa a consulta e obtém os resultados
            ResultSet rs = st.executeQuery(sql);

            // Se encontrar um resultado, autentica o usuário e armazena o nome
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Exceção capturada (nenhuma ação específica é tomada)
        }
        return result; // Retorna o resultado da verificação
    }
}