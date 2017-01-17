package Wycieki;
import java.util.Map;
public class WyciekiPamięci {
    public final String key;
    
    public WyciekiPamięci(String key){
        this.key = key;
    }
    public static void main(String args[]){
        try{
            Map map = System.getProperties();
            
            for(;;){
                map.put(new WyciekiPamięci("key"), "value");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
