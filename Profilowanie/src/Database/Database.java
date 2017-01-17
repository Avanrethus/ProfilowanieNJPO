
package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    

 class Database {
    private static Database dbInstance;
    private static Connection con;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String host = "jdbc:mysql://localhost:3306/njpo";
    private static String login = "root";
    private static String pass = "1234kokos";

    public static Database getInstance(){
        if(dbInstance == null){
            dbInstance = new Database();
        }
    return dbInstance;
    }
    public static Connection getConnection(){
        if(con == null){
            try{
                
                Class.forName(driver);
                con = DriverManager.getConnection(host, login, pass);
            }
            catch (SQLException ex){
                System.out.println("Błąd SQLa "+ ex.getMessage());
            }
            catch (ClassNotFoundException e){
                System.out.println("Bląd sterownika JDBC: " + e.getMessage());
            }
        }
        return con;
    }
    public static ResultSet executeQuery(String query){
        try{
            con = Database.getConnection();
            PreparedStatement p = con.prepareStatement(query);
            con.close();
            return p.executeQuery();
        }
        catch(SQLException e){
            System.out.println("Błąd w składni: " + e.getMessage());
        }
      return null;
    }
    public static int executeUpdate(String update){
       try{
           con = Database.getConnection();
           try(PreparedStatement p = con.prepareStatement(update)){
               con.close();
               return p.executeUpdate();
               
           }
           
        }
        catch(SQLException e){
            System.out.println("Błąd w składni: " + e.getMessage());
        }
       return -1;
    }
    public static void zczytajZBazy() throws SQLException{
        try{
            Class.forName(driver);
            try{
                con = Database.getConnection();
                String query = "Select * from ksiazkaadresowa";
                try(PreparedStatement p = con.prepareStatement(query)){
                    try(ResultSet r =p.executeQuery()){
                        while(r.next()){
                            System.out.println(r.getString(2));
                            con.close();
                        }
                    }
                }
            }
            catch(SQLException e){
                System.out.println("Błąd składni SQL: " + e.getMessage());
            }
        }
        catch(ClassNotFoundException ex){
                System.out.println("Bład sterownika JDBC" + ex.getMessage());
        }
    }
    public static void zapiszDoBazy(Osoba osoba){
        try{
            Class.forName(driver);
            try{
                con = Database.getConnection();
                String query = "Insert into ksiazkaadresowa (imie, nazwisko, miasto, ulica, numer, kodpocztowy) values ('"
                        + Osoba.imie + "', '"
                        + Osoba.nazwisko + "', '"
                        + Osoba.miasto + "', '"
                        + Osoba.ulica +"', "
                        + Osoba.numer +", '"
                        + Osoba.kodpocztowy + "')";
                try(PreparedStatement p = con.prepareStatement(query)){
                    int update = p.executeUpdate();
                    con.close();
                }
            }
            catch(SQLException e){
                System.out.println("Bład składni SQL: " + e.getMessage());
            }
        }
        catch(ClassNotFoundException ex){
            System.out.println("Błąd sterownika JDBC: " + ex.getMessage());
        }
    }    
 }
