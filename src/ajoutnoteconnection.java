import java.awt.List;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ajoutnoteconnection {
   static final String DB_URL = "jdbc:mysql://localhost:3306/db";
   static final String USER = "root";
   static final String PASS = "123321";



    public static void exportToCsv(String filePath) {
        String url = "jdbc:mysql://localhost:3306/db";
        String user = "root";
        String password = "123321";

        String query = "SELECT  id, nom, prenom,cin,email,tel, genre,  , fr, arb, math, eng, info, phy,moyenn,admis  FROM etudiant";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query);
             FileWriter fw = new FileWriter(filePath)) {

            fw.append("id;nom;prenom;fr;arb;math;eng;info;phy\n");

            while (rs.next()) {
                fw.append(String.valueOf(rs.getInt("id")));
                fw.append(';');
                fw.append(rs.getString("nom"));
                fw.append(';');
                fw.append(rs.getString("prenom"));
                fw.append(';'); fw.append(rs.getString("cin"));
                fw.append(';');
                fw.append(rs.getString("email"));
                fw.append(';');
                fw.append(rs.getString("tel"));
                fw.append(';');
                fw.append(rs.getString("genre"));
                fw.append(';');
                fw.append(String.valueOf(rs.getDouble("fr")));
                fw.append(';');
                fw.append(String.valueOf(rs.getDouble("arb")));
                fw.append(';');
                fw.append(String.valueOf(rs.getDouble("math")));
                fw.append(';');
                fw.append(String.valueOf(rs.getDouble("eng")));
                fw.append(';');
                fw.append(String.valueOf(rs.getDouble("info")));
                fw.append(';');
                fw.append(String.valueOf(rs.getDouble("phy")));
                fw.append(';');

                fw.append(String.valueOf(rs.getDouble("moyenn")));
                fw.append(';');
                fw.append(String.valueOf(rs.getDouble("admis")));
                fw.append('\n');
            }

            System.out.println("Data exported to " + filePath);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
   public void sup(int idp) {
      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();) {
               stmt.executeUpdate("DELETE FROM etudiant where id = " + idp);

        

      } catch (SQLException er) {
         er.printStackTrace();
      }
   }

   public Etudiant fetch(int idp) {
      Etudiant e = new Etudiant();
      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();) {
         ResultSet rs = stmt.executeQuery(
               "SELECT  id, nom, prenom, fr, arb, math, eng, info, phy FROM etudiant where id = " + idp);

         if (rs.next()) {
            e.setNom(rs.getString("nom"));
            e.setPrenom(rs.getString("prenom"));
            e.setId(rs.getInt("id"));
            e.setFr(rs.getFloat("fr"));
            e.setArb(rs.getFloat("arb"));
            e.setMath(rs.getFloat("math"));
            e.setEng(rs.getFloat("eng"));
            e.setInfo(rs.getFloat("info"));
            e.setPhy(rs.getFloat("phy"));
            e.setMoyenne();
            e.setAdmis();
         }
         else{
            return null;
         }

      } catch (SQLException er) {
         er.printStackTrace();
      }
      return e;
   }

   public ArrayList<Etudiant> affname(String name) {
      ArrayList<Etudiant> dataList = new ArrayList<>(); 
      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement()) {
         ResultSet rs;
         if (name.length() == 0) {
            rs = stmt.executeQuery(
                  "SELECT id, nom, prenom, fr, arb, math, eng, info, phy, email, tel, genre, cin ,moyenn,admis FROM etudiant");
         } else {
            rs = stmt.executeQuery(
                  "SELECT id, nom, prenom, fr, arb, math, eng, info, phy, email, tel, genre, cin, moyenn,admis FROM etudiant where nom = `"
                        + name + "`");
         }

         while (rs.next()) {
            Etudiant e = new Etudiant();

            e.setNom(rs.getString("nom"));
            e.setPrenom(rs.getString("prenom"));
            e.setEmail(rs.getString("email"));
            e.setCin(rs.getString("cin"));
            e.setGenre(rs.getString("genre"));
            e.setTel(rs.getString("tel"));
            e.setId(rs.getInt("id"));
            e.setFr(rs.getFloat("fr"));
            e.setArb(rs.getFloat("arb"));
            e.setMath(rs.getFloat("math"));
            e.setEng(rs.getFloat("eng"));
            e.setInfo(rs.getFloat("info"));
            e.setPhy(rs.getFloat("phy"));
            e.setMoyenne();
            e.setAdmis();
            dataList.add(e);

         }
         System.out.println(dataList);
      } catch (SQLException er) {
         er.printStackTrace();
      }
     

      return dataList;
   }

   public ArrayList<Etudiant> AffID(int ID) {
      ArrayList<Etudiant> dataList = new ArrayList<>();
      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement()) {
         ResultSet rs;
         if (ID == -1) {
            rs = stmt.executeQuery(
                  "SELECT id, nom, prenom, fr, arb, math, eng, info, phy, email, tel, genre, cin , moyenn,admis  FROM etudiant");
         } else {
            rs = stmt.executeQuery(
                  "SELECT id, nom, prenom, fr, arb, math, eng, info, phy, email, tel, genre, cin , moyenn , admis FROM etudiant where id="
                        + ID);
         }

         while (rs.next()) {
            Etudiant e = new Etudiant();

            e.setNom(rs.getString("nom"));
            e.setPrenom(rs.getString("prenom"));
            e.setEmail(rs.getString("email"));
            e.setCin(rs.getString("cin"));
            e.setGenre(rs.getString("genre"));
            e.setTel(rs.getString("tel"));
            e.setId(rs.getInt("id"));
            e.setFr(rs.getFloat("fr"));
            e.setArb(rs.getFloat("arb"));
            e.setMath(rs.getFloat("math"));
            e.setEng(rs.getFloat("eng"));
            e.setInfo(rs.getFloat("info"));
            e.setPhy(rs.getFloat("phy"));
            e.setMoyenne();
            e.setAdmis();
            dataList.add(e);

         }
         System.out.println(dataList);
      } catch (SQLException er) {
         er.printStackTrace();
      }
      

      return dataList;
   }

   public ArrayList<Etudiant> sortup(int ID) {
      ArrayList<Etudiant> dataList = new ArrayList<>(); 
      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement()) {
         ResultSet rs;
         if (ID == -1) {
            rs = stmt.executeQuery(
                  "SELECT id, nom, prenom, fr, arb, math, eng, info, phy, email, tel, genre, cin , moyenn,admis  FROM etudiant ORDER BY moyenn ");
         } else {
            rs = stmt.executeQuery(
                  "SELECT id, nom, prenom, fr, arb, math, eng, info, phy, email, tel, genre, cin , moyenn , admis FROM etudiant where id="
                        + ID+"ORDER BY moyenn");
         }

         while (rs.next()) {
            Etudiant e = new Etudiant();

            e.setNom(rs.getString("nom"));
            e.setPrenom(rs.getString("prenom"));
            e.setEmail(rs.getString("email"));
            e.setCin(rs.getString("cin"));
            e.setGenre(rs.getString("genre"));
            e.setTel(rs.getString("tel"));
            e.setId(rs.getInt("id"));
            e.setFr(rs.getFloat("fr"));
            e.setArb(rs.getFloat("arb"));
            e.setMath(rs.getFloat("math"));
            e.setEng(rs.getFloat("eng"));
            e.setInfo(rs.getFloat("info"));
            e.setPhy(rs.getFloat("phy"));
            e.setMoyenne();
            e.setAdmis();
            dataList.add(e);

         }
         System.out.println(dataList);
      } catch (SQLException er) {
         er.printStackTrace();
      }

      return dataList;
   }
   public ArrayList<Etudiant> sortdw(int ID) {
      ArrayList<Etudiant> dataList = new ArrayList<>(); 
      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement()) {
         ResultSet rs;
         if (ID == -1) {
            rs = stmt.executeQuery(
                  "SELECT id, nom, prenom, fr, arb, math, eng, info, phy, email, tel, genre, cin , moyenn,admis  FROM etudiant ORDER BY moyenn  DESC");
         } else {
            rs = stmt.executeQuery(
                  "SELECT id, nom, prenom, fr, arb, math, eng, info, phy, email, tel, genre, cin , moyenn , admis FROM etudiant where id="
                        + ID+"ORDER BY moyenn DESC");
         }

         while (rs.next()) {
            Etudiant e = new Etudiant();

            e.setNom(rs.getString("nom"));
            e.setPrenom(rs.getString("prenom"));
            e.setEmail(rs.getString("email"));
            e.setCin(rs.getString("cin"));
            e.setGenre(rs.getString("genre"));
            e.setTel(rs.getString("tel"));
            e.setId(rs.getInt("id"));
            e.setFr(rs.getFloat("fr"));
            e.setArb(rs.getFloat("arb"));
            e.setMath(rs.getFloat("math"));
            e.setEng(rs.getFloat("eng"));
            e.setInfo(rs.getFloat("info"));
            e.setPhy(rs.getFloat("phy"));
            e.setMoyenne();
            e.setAdmis();
            dataList.add(e);

         }
         System.out.println(dataList);
      } catch (SQLException er) {
         er.printStackTrace();
      }
      

      return dataList;
   }


   public int update(Etudiant et) {
      int x = -1;
      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();) {
         String sql = "UPDATE etudiant SET  fr = ?, arb = ?, math = ?, eng = ?, info = ?, phy = ? , moyenn = ? , admis=?  WHERE id = "
               + et.getID();

         try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setFloat(1, et.getFr());
            pstmt.setFloat(2, et.getArb());
            pstmt.setFloat(3, et.getMath());
            pstmt.setFloat(4, et.getEng());
            pstmt.setFloat(5, et.getInfo());

            pstmt.setFloat(6, et.getPhy());
            et.setMoyenne();
            et.setAdmis();
            pstmt.setFloat(7, et.getMoyenne());
            pstmt.setFloat(8, et.getAdmis());

            x = pstmt.executeUpdate();

         }

      } catch (SQLException er) {
         er.printStackTrace();
      }
      return x;
   }

}
