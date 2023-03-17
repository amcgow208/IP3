package org.me.gcu.ip3;
import java.sql.*;


public class sqlConnect{

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "";
    private static final String DB_USRNME = "";
    private static final String DB_PSWRD = "";

    public sqlConnect(){
        Connection conn = null;
        try{
            Class.forName(DB_DRIVER);
            DriverManager.getConnection(DB_URL, DB_USRNME, DB_PSWRD);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
    }
}
