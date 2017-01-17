package ZipBomb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Watek implements Runnable {
    String name;
    Watek(String name) throws FileNotFoundException, IOException{
        this.name = name;
        Random r = new Random();
        int rozmiar = r.nextInt(999000)+1000;
        byte[] tablicabyte = new byte[rozmiar];
        String plik = name;
        FileOutputStream fos = new FileOutputStream(plik);
        fos.write(tablicabyte);
        fos.close();
    }
    @Override
    public void run() {
        System.out.println("Wątek "+name+" rozpoczyna pracę.");
                
    }
}
