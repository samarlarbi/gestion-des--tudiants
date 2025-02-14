
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Etudiantconnection {
    Connection con;

    public Etudiantconnection() {
        try (Connection connection = DatabaseConnector.getConnection()) {
            con = DatabaseConnector.getConnection();
            System.out.println("Connected to the database!");
        }

        catch (SQLException e) {
            System.err.println("Failed to connect to the database!");
            e.printStackTrace();
        }
    }

    public int Ajouter(Etudiant e) {
        int test = 0;
        try {

            String req = "INSERT INTO etudiant (nom, prenom,email,tel,dte,genre,cin,fr,arb,phy,math,info,eng,moyenn,admis) VALUES (?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            // Create PreparedStatement object
            PreparedStatement stmt = con.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            // Set parameters
            stmt.setString(1, e.getNom());
            stmt.setString(2, e.getPrenom());
            stmt.setString(3, e.getEmail());
            stmt.setString(4, e.getTel());
            stmt.setString(5, e.getDte());
            stmt.setString(6, e.getGenre());
            stmt.setString(7, e.getCin());
            stmt.setFloat(8, e.getFr()); // Assuming e.getFr() returns a float value
            stmt.setFloat(9, e.getArb()); // Assuming e.getArb() returns a float value
            stmt.setFloat(10, e.getPhy()); // Assuming e.getPhy() returns a float value
            stmt.setFloat(11, e.getMath()); // Assuming e.getMath() returns a float value
            stmt.setFloat(12, e.getInfo()); // Assuming e.getInfo() returns a float value
            stmt.setFloat(13, e.getEng()); // Assuming e.getEng() returns a float value
            stmt.setFloat(14, e.getMoyenne());
            stmt.setFloat(15, e.getAdmis());

            // Execute the prepared statement
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);

                    e.setId(generatedId);
                    System.out.println("Insertion réussie avec l'id: " + generatedId);
                    System.out.println(e);
                } else {
                    System.out.println("Aucune clé générée");
                }
                test = 0;
            } else {
                System.out.println("Aucune ligne insérée");
                test = 1;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur d'insertion " + ex.getMessage());
            test = 1;
        }

        return test;

    }

}
