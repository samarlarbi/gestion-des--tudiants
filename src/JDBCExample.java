import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
   static final String DB_URL = "jdbc:mysql://localhost:3306/db";
   static final String USER = "root";
   static final String PASS = "123321";

   public static void main(String[] args) {
      // Open a connection
      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();) {
         String sql = " INSERT INTO etudiant (id, cin)         VALUES (2, '03254632');";
         stmt.executeUpdate(sql);
         String sql2 = " SELECT COUNT(*) AS num_rows FROM etudiant;";

         ResultSet rs = stmt.executeQuery(sql2);
         rs.next();
         String Id = rs.getString(1);
         System.out.println(" Id is " + Id + "query excuted successfully ...");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
