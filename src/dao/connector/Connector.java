package dao.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    public Connection connectar(){
        try{
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "daegon32";
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}

