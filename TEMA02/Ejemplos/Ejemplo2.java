package TEMA02.Ejemplos;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;


/* El código demuestra el uso de las clases CharArrayWriter y CharArrayReader en Java para escribir y leer datos en un array de caracteres (char array) */
public class Ejemplo2 {
    public static void main(String[] args) throws Exception {

        /* Se crea un objeto CharArrayWriter llamado charArrayWriter. Esta clase se utiliza para escribir caracteres en un array de caracteres.*/
        CharArrayWriter charArrayWriter = new CharArrayWriter();

        /* Se declara una variable charArrayReader de tipo CharArrayReader. Esta variable se utilizará más adelante para leer caracteres del array que se escribirá en charArrayWriter.*/
        CharArrayReader charArrayReader;

        int data;
        try {
            /* Se escribe la cadena "Hola amigo" en el CharArrayWriter. Esto significa que los caracteres se están escribiendo en un array interno dentro de charArrayWriter.*/
            charArrayWriter.write("Hola amigo");
            /*Se cierra el CharArrayWriter después de haber escrito la cadena. Cerrarlo indica que no se escribirán más caracteres en él. */
            charArrayWriter.close();

            /* Se crea un objeto CharArrayReader llamado charArrayReader y se le pasa como argumento el array de caracteres obtenido de charArrayWriter mediante toCharArray(). Esto establece charArrayReader para leer desde el mismo array que fue escrito en charArrayWriter.*/
            charArrayReader = new CharArrayReader(charArrayWriter.toCharArray());
            /*Se lee el primer carácter del CharArrayReader y se almacena en la variable data */
            data = charArrayReader.read();
            /* Se inicia un bucle while que se ejecutará mientras data no sea igual a -1, lo que indica que todavía hay caracteres por leer.*/
            while(data != -1){
                /*Dentro del bucle, se imprime el carácter actual que se ha leído en la consola. */
                System.out.print((char)data);
                /*Se lee el siguiente carácter en el CharArrayReader y se almacena en data para la próxima iteración del bucle. */
                data=charArrayReader.read();
            }
            /* Finalmente, después de haber leído todos los caracteres, se cierra el CharArrayReader*/
            charArrayReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
