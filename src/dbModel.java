import javax.swing.plaf.nimbus.State;
import java.sql.*;
    

public class dbModel {

    public void dbStore(String name, int score) throws SQLException{
        Connection conn = null;
        Statement stmt;

        conn = DriverManager.getConnection(
                "jdbc:mysql://" + databaseConfig.DBURL + ":" + databaseConfig.port + "/" + databaseConfig.DBname +
                        "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                databaseConfig.user, databaseConfig.password);

        stmt = conn.createStatement();

        String save = "INSERT INTO score (name, score) VALUES ( '" + name + "','" + score + "')";
        stmt.executeUpdate(save);

    }

    public user[] dbShow() throws SQLException{
        user users[] = new user[10];

        Connection conn = null;
        Statement stmt;

        conn = DriverManager.getConnection(
                "jdbc:mysql://" + databaseConfig.DBURL + ":" + databaseConfig.port + "/" + databaseConfig.DBname +
                        "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                databaseConfig.user, databaseConfig.password);
        stmt = conn.createStatement();

        String get = "SELECT * FROM score ORDER BY score DESC LIMIT 10";

        ResultSet rset = stmt.executeQuery(get);

        for (int i = 0; rset.next(); i++){
            users[i] = new user(rset.getString("name"), rset.getInt("score"));
        }

        return users;
    }
}
