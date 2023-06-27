import java.sql.*;
import java.util.ArrayList;

public class File {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3307/chickens";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "";

    private Connection conn;

    public File() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connecting to database...");
        } catch (Exception exp) {
            System.out.println("Database Exception : \n" + exp.toString());
            System.exit(0);
        }
    }

    public static void saveScore(int score) {
        String insertQuery = "INSERT INTO score (id, score) VALUES (  ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM score");
            int max = 0;
            while (resultSet.next()) {
                max = resultSet.getInt(1);
            }
            max += 1;
            statement.setInt(1, max);
            statement.setInt(2, score);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Integer> loadScore() {
        ArrayList<Integer> allScores = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = connection.createStatement()) {

            String sql = "SELECT score FROM chickens ORDER BY score DESC";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int score = rs.getInt("score");
                allScores.add(score);
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return allScores;
    }


}
