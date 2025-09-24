import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;


public class accesoAleatorio {
    
    public static void main(String[] args) {

         try {
            RandomAccessFile file = new RandomAccessFile("./TEMA01/Ejemplos/texto.txt", "rw"); 
            //El método seek posicionamos el puntero
            file.seek(5);
            //Nos devuelve la posicion
            long filePointer = file.getFilePointer();
            //Leemos un byte en esa posicion
            int unByte = file.read();

            System.out.println((char)unByte);
            System.out.println(filePointer);
            file.write('X');

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
