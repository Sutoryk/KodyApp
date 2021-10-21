package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RedeemDAO {
    public static boolean validate(Integer kod){
        boolean status=false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/storedb", "admin", "Password123#");

            PreparedStatement ps=con.prepareStatement(
                    "select * from kody where kod=?");
            ps.setInt(1,kod);

            ResultSet rs=ps.executeQuery();
            status=rs.next();

        }catch(Exception e){System.out.println(e);}
        return status;
    }
}
