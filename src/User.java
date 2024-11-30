
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    public Connection conectarBD() {
        Connection conn = null; //4
        try { //5
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); //6
            String url = "jdbc:my   sql://localhost:3308/atividadeux?user=root&password=usbw"; //7
            conn = DriverManager.getConnection(url); //8
        } catch (Exception e)  { //9
        }
        return conn; //10
    }
    public String nome = ""; //1
    public boolean result = false; //1

    public boolean verificarUsuario(String login, String senha) {
        String sql = ""; //2
        Connection conn = conectarBD(); //3
        sql = "select nome from usuarios "; //11
        sql += "where login = '" + login + "'"; //11
        sql += " and senha = '" + senha + "'";//11

        try { //12
            Statement st = conn.createStatement(); //13
            ResultSet rs = st.executeQuery(sql); //14
            if (rs.next()) { //15
                result = true; //16
                nome = rs.getString("nome"); //17
            }
        } catch (Exception e) { //18
        }
        return result; //19
    }


}