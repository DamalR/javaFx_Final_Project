package db;

import java.sql.*;

public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;
    public DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/service_center","root","Damal@100709");
    }

    public static DBConnection getInstance() throws ClassNotFoundException, SQLException {
        return dbConnection!=null ? dbConnection : (dbConnection=new DBConnection());
    }

    public Connection getConnection(){
        return connection;
    }

}