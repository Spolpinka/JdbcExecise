package pro.sky;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        final String user = "postgres";
        final String pass = "421243266";
        String query = "t";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement statement = connection.prepareStatement("SELECT * FROM post WHERE title LIKE '%(?)%'"))
        {
            statement.set
            ResultSet resultSet = statement.executeQuery();
            //System.out.println(resultSet.next());
            //System.out.println(resultSet.getString(2));
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + "|" +
                        resultSet.getString("title") + "|" +
                        resultSet.getString("body"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}