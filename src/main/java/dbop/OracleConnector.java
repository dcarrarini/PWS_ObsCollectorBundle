package dbop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnector {
    private static final String ORACLE_JDBC_DRIVER   = "oracle.jdbc.driver.OracleDriver";
    private static final String ORACLE_DB_CONNECTION = "jdbc:oracle:thin:@192.168.20.61:1521:ELECDB";
    private static final String ORACLE_DB_USER       = "User";
    private static final String ORACLE_DB_PASSWORD   = "Password";

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(ORACLE_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            dbConnection = DriverManager.getConnection(ORACLE_DB_CONNECTION, ORACLE_DB_USER, ORACLE_DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }
}