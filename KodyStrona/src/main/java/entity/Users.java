package entity;

import dao.UserDAO;
import jakarta.persistence.*;
import jakarta.resource.cci.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries(
        {
                @NamedQuery(name = "Users.findAll", query = "Select u FROM Users u ORDER BY u.user_id"),
                @NamedQuery(name="Users.countAll",query="SELECT Count(x) FROM Users x"),
                @NamedQuery(name="Users.findByEmail",query="SELECT u from Users u where u.email = :email")

        }

)
@Table(name = "users")
public class Users {
    private Integer user_id;
    private String email;
    private String password;
    private Double balance;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Users(String email, String password, Double balance) {
        super();
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public Users() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users findEmail(String email) {
        List<Users> listUsers = new ArrayList<Users>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storedb", "admin", "Password123#");
            PreparedStatement create = con.prepareStatement("SELECT email from users");

            ResultSet rs;
            rs = (ResultSet) create.executeQuery();
            while (rs.next()) {
                Users user = new Users(); // Creating a user object to fill with user data (I imagine that you have a user class in your model)
                //Add the retrived user to the list
                listUsers.add(user);

            }
            //Returning the list of users.
            return listUsers.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}

