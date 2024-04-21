import java.sql.*;

public class HelloWorld {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to MySQL database!");

            String sql = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(255), email VARCHAR(255) UNIQUE)";
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

            sql = "INSERT INTO users (username, email) VALUES ('John', 'john@example.com')";
            int rowsInserted = statement.executeUpdate(sql);

            if (rowsInserted > 0) {
                System.out.println("Hello World! User 'John' created successfully.");
            } else {
                System.out.println("Failed to create user 'John'.");
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}