
# Tema 1: Acceso a Datos en Java

## Contenido
1. [Introducción](#-introducción)
2. [Tipos de ficheros](#-tipos-de-ficheros)
   - [Clase `File` (java.io.File)](#-clase-file-javaiofile)
4. [Formas de acceso](#-formas-de-acceso)
   - Secuencial (bytes / caracteres)
   - Aleatorio
5. [Gestión de ficheros](#-gestión-de-ficheros)
6. [Operaciones con Buffer](#-operaciones-con-buffer)
7. [Casos prácticos](#-casos-prácticos)
8. [Recursos](#-recursos)

---

## 1. Introducción
En este tema aprenderemos a:
- Crear, modificar y borrar **ficheros y directorios**.
- Diferenciar entre **acceso secuencial** y **acceso aleatorio**.
- Usar clases de la librería `java.io`.

📎 [Audio Intro: Lectura y escritura fichero](https://bit.ly/3dwGW6X)

---

## 2. Tipos de ficheros
- **Texto (ASCII):** código legible, ej. `.txt`, `.java`, `.html`.
- **Binarios:** representados en binario, ej. `.bin`, `.dat`.

---

## 2.1. Clase `File` (java.io.File)
Permite crear, borrar, mover y consultar información sobre un fichero.

### Crear un fichero
```java
import java.io.File;

public class crearFichero {

    public static void main(String[] args) {
        try {
            File fichero = new File(".\\TEMA01\\Ejemplos\\crearFichero.txt");
            if (fichero.createNewFile()) {
                System.out.println("Fichero creado: " + fichero.getName());
            } else {
                System.out.println("El fichero ya existe.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Mover un fichero
```java
import java.io.File;

public class moverFichero {

    public static void main(String[] args) {
        try {
            File ficheroOrigen = new File(".\\TEMA01\\Ejemplos\\crearFichero.txt");
            String nombreCarpeta = "Backup";
            File carpeta = new File (".\\TEMA01\\Ejemplos", nombreCarpeta);
            carpeta.mkdirs();
            
            File ficheroDestino = new File (".\\TEMA01\\Ejemplos\\Backup\\fichero_movido.txt");
            if (ficheroOrigen.renameTo(ficheroDestino))
                System.out.println("El fichero se movió correctamente");
            else
                System.out.println("El fichero no pudo moverse");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 2.2. Métodos útiles
| Método               | Descripción                            |
|----------------------|----------------------------------------|
| `createNewFile()`    | Crea un nuevo fichero                  |
| `delete()`           | Elimina el fichero o directorio        |
| `mkdirs()`           | Crea directorio(s)                     |
| `getName()`          | Devuelve nombre                        |
| `getPath()`          | Devuelve ruta relativa                 |
| `getAbsolutePath()`  | Ruta absoluta                          |
| `exists()`           | Comprueba si existe                    |
| `renameTo()`   | Mueve/renombra un fichero              |
| `canRead()`/`canWrite()` | Permisos de lectura/escritura       |
| `listFiles()`        | Array con los ficheros directorio       |

---

## 3. Formas de acceso
### Acceso secuencial
Recorre el fichero **byte a byte** o **carácter a carácter**.

#### Con bytes → `FileInputStream`
```java
import java.io.FileInputStream;

public class LeerBytes {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("imagen.png")) {
            int b;
            while ((b = fis.read()) != -1) {
                System.out.print(b + " "); // imprime valores binarios
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

#### Con caracteres → `FileReader`
```java
import java.io.FileReader;

public class LeerTexto {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("texto.txt")) {
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Acceso aleatorio → `RandomAccessFile`
Permite **leer y escribir en posiciones concretas** del fichero.

```java
import java.io.RandomAccessFile;

public class Aleatorio {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("datos.dat", "rw")) {
            raf.seek(10);           // Ir a la posición 10
            raf.write('A');         // Escribir un byte
            raf.seek(10);
            int valor = raf.read(); // Leer desde esa posición
            System.out.println("Byte leído: " + (char)valor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## ⚡ Gestión de ficheros
- **Entrada/salida con caracteres:** `FileReader`, `FileWriter`.
- **Entrada/salida con bytes:** `FileInputStream`, `FileOutputStream`.

Ejemplo de escritura:
```java
import java.io.FileWriter;

public class EscribirTexto {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("salida.txt")) {
            fw.write("Hola mundo\n");
            fw.write("Acceso a datos en Java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## Operaciones con Buffer
Los buffers almacenan datos temporalmente en **memoria** → mejoran rendimiento.

Clases:
- `BufferedReader`, `BufferedWriter`
- `BufferedInputStream`, `BufferedOutputStream`

Ejemplo:
```java
import java.io.BufferedReader;
import java.io.FileReader;

public class LeerConBuffer {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## Casos prácticos
1. **Gestor de archivos**: Crear directorios, ficheros y moverlos → usar `File`.  
2. **Lectura secuencial de texto**: Usar `FileReader` y `FileWriter`.  
3. **Acceso a registros binarios concretos**: Usar `RandomAccessFile`.  

📺 [Vídeo: Escritura con FileOutputStream](https://bit.ly/2U3CBQX)  
📺 [Vídeo: RandomAccessFile read](https://bit.ly/2MqSY66)  

---

## Recursos
- [Documentación oficial Java IO](https://docs.oracle.com/javase/8/docs/api/?java/io)  
- [Audio: Método Close automático](https://bit.ly/3dyeWjm)  

---

