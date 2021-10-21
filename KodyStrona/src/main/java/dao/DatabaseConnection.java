package dao;

import entity.Kody;
import entity.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/storedb", "admin", "Password123#");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static List<Users> checkBalance(String email) {
        List<Users> list = new ArrayList<Users>();
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * from users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users e = new Users();
                e.setUser_id(rs.getInt(1));
                e.setEmail(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setBalance(rs.getDouble(4));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int update(Users e) {
        int status = 0;
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("update users set balance=? where email=?");
            ps.setDouble(1, e.getBalance());
            ps.setString(2, e.getEmail());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static List<Kody> getKod(Kody kody) {
        int status = 0;
        List<Kody> list = new ArrayList<Kody>();
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("   SELECT * FROM kody WHERE kod_id=(SELECT max(kod_id) FROM kody)");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Kody e = new Kody();
                e.setKod_id(rs.getInt(1));
                e.setKod(rs.getInt(2));
                e.setValue(rs.getDouble(3));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
}


