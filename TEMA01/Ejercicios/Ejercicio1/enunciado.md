## Caso práctico: Copiar contenido de un archivo utilizando buffers

Crea un programa en Java que permita a los usuarios copiar el contenido de un archivo de texto llamado archivo_origen.txt en otro archivo de texto llamado archivo_destino.txt, utilizando buffers para mejorar la eficiencia en la lectura y escritura de archivos.
El programa debe seguir estos pasos:

Abre el archivo archivo_origen.txt en modo lectura.

Abre el archivo archivo_destino.txt en modo escritura.

Si el archivo ya existe, se debe sobrescribir su contenido.

Define un buffer de lectura y escritura (por ejemplo, de 1024 bytes).

Mientras haya datos disponibles en el archivo de origen:

Lee un bloque de datos en el buffer de lectura.

Escribe ese bloque en el archivo de destino utilizando el buffer de escritura.

Después de escribir cada bloque, muestra por consola un mensaje como:
"Fin copia bloque 1", "Fin copia bloque 2", etc.

Al finalizar la copia, añade al final del archivo destino la cadena:
Última modificación: 25-09-2023 15:04:01

Cierra ambos archivos correctamente.

Asegúrate de manejar adecuadamente las excepciones, en caso de que:

El archivo de origen no exista.

Ocurra un error durante la lectura o escritura de los archivos.