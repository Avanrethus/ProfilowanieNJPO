package Database;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KsiazkaAdresowa {
    
    public static void main(String[] args) throws SQLException{
        
        
        Database.zczytajZBazy();
        Database.zapiszDoBazy(new Osoba("Przemek","Jarosz","Lwowska","Olkusz",505678908,"34-678"));
    }
}

