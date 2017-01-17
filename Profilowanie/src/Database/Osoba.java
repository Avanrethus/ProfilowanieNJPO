package Database;
public class Osoba implements Comparable<Osoba>  {
    
    public static String imie;
    public static String nazwisko;
    public static String miasto;
    public static String ulica;
    public static int numer;
    public static String kodpocztowy;
    
    public Osoba(String imie, String nazwisko, String ulica,  String miasto,  int numer, String kodpocztowy){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.miasto = miasto;
        this.ulica = ulica;
        this.numer = numer;
        this.kodpocztowy = kodpocztowy;
    }    
    
    @Override
        public String toString() {
        return imie + " " + nazwisko + " " + numer + " " + ulica + " " + miasto + " "+ kodpocztowy;
    }
    
    @Override
    public int compareTo(Osoba o) {
        int porownanieN = nazwisko.compareTo(o.nazwisko);
        if(porownanieN == 0){
            return imie.compareTo(o.imie);
        }
        else{
            return porownanieN;
        }
    }
}


