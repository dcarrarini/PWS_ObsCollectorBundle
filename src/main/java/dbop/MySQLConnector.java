package dbop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

    static final String MYSQL_JDBC_DRIVER   = "com.mysql.jdbc.Driver";
    static final String MYSQL_DB_CONNECTION = "jdbc:mysql://66.45.250.213/momolosi_dca";
    static final String MYSQL_DB_USER       = "momolosi_dca";
    static final String MYSQL_DB_PASSWORD   = "Delco1978";

    public static Connection getMYSQLDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());
        }

        try {

            dbConnection = DriverManager.getConnection(MYSQL_DB_CONNECTION, MYSQL_DB_USER, MYSQL_DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

}
