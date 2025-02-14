
import java.util.Vector;

/**
 * s Etudiant
 */
public class Etudiant {
    int id;
    private String nom, prenom, email, tel, dte, genre, cin;
    private float fr=0, arb=0, math=0, eng=0, info=0, phy=0, tp=0 , moyenne=0;
    int admis=0;

    public Etudiant(String nom, String prenom, String email, String tel, String dte, String genre, String cin, float fr,
            float arb, float math, float eng, float info, float phy, float tp) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.dte = dte;
        this.genre = genre;
        this.cin = cin;
        this.fr = fr;
        this.arb = arb;
        this.math = math;
        this.eng = eng;
        this.info = info;
        this.phy = phy;
        this.tp = tp;
this.moyenne= (fr+arb+eng+math+phy+info)/6;
this.admis=this.moyenne>=10 ? 1 : 0;


    }

    public Etudiant() {
        // TODO Auto-generated constructor stub
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public int getID() {
return this.id;    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDte() {
        return this.dte;
    }

    public void setDte(String dte) {
        this.dte = dte;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public float getFr() {
        return this.fr;
    }

    public void setFr(float fr) {
        this.fr = fr;
    }

    public float getArb() {
        return this.arb;
    }

    public void setArb(float arb) {
        this.arb = arb;
    }

    public float getMath() {
        return this.math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getEng() {
        return this.eng;
    }

    public void setEng(float eng) {
        this.eng = eng;
    }

    public float getInfo() {
        return this.info;
    }

    public void setInfo(float info) {
        this.info = info;
    }

    public float getPhy() {
        return this.phy;
    }

    public void setPhy(float phy) {
        this.phy = phy;
    }

    public float getTp() {
        return this.tp;
    }

    public void setTp(float tp) {
        this.tp = tp;
    }
    public int getAdmis() {
        return this.admis ;
    }

    public void setAdmis() {
        this.admis=this.moyenne>=10 ? 1 : 0;
    }

    public void setMoyenne() {
        this.moyenne= (fr+arb+eng+math+phy+info)/6;
    }

    public Float getMoyenne() {
       return  this.moyenne;
    }
    
    

    @Override
    public String toString() {
        return "{" +
        " id='" + getID() + "'" +
        " nom='" + getNom() + "'" +
        ", prenom='" + getPrenom() + "'" +
                ", email='" + getEmail() + "'" +
                ", tel='" + getTel() + "'" +
                ", dte='" + getDte() + "'" +
                ", genre='" + getGenre() + "'" +
                ", cin='" + getCin() + "'" +
                ", fr='" + getFr() + "'" +
                ", arb='" + getArb() + "'" +
                ", math='" + getMath() + "'" +
                ", eng='" + getEng() + "'" +
                ", info='" + getInfo() + "'" +
                ", phy='" + getPhy() + "'" +
                ", tp='" + getTp() + "'" +
                "}";
    }
  

}

/**
 * EtudiantTerminale
 */
/**
 * TableEtudi
 * //
 */
// class TableEtudian {
// public ArrayList<Etudiant> tabetud = new ArrayList<>();

// public void ajout(Etudiant e) {
// tabetud.add(e);
// }

// public void affichage() {
// for (int i = 0; i < tabetud.size(); i++) {
// tabetud.get(i).affichage();
// }
// }

// }
