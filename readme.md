# Acceso a datos - Simulacro 1ªEv

Contenidos:

- **Ficheros:**
  - Ficheros binarios
  - Ficheros de texto
  - Ficheros de acceso aleatorio
- **Bases de datos relacionales:**
  - Sentencias parametrizadas
  - Transacciones
  - Lotes
  - Funciones y procedimientos

### Ejercicio 1:
Dentro del archivo de java Ejercicio1/Ficheros, crear distintos métodos que luego se llamen desde el main:
- **[ 1 pt ] notasEnBinario(File):** Método que lee el archivo de texto 1_notas.txt y lo convierte a binario
- **[ 1pt ] aumentarNotaBin(File):** leer el binario generado anteriormente y a cada alumno subirle la nota en un punto, hasta la nota máxima(10). Una vez cambiadas las notas, crear un fichero de texto con dichos resultados

### Ejercicio 2:
Realizar una conexión a una base de datos. Los datos de la conexión están en bbdd.txt
- Crear un método que cree la conexión a la base de datos.
- Método para crear una tabla llamada por vuestro nombre y tres últimos dígitos de vuestro DNI (Ej: tizziano534Z) que contenga los campos:
  - id
  - nombre
  - apellidos
  - email