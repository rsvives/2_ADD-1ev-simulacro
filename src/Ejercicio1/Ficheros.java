package Ejercicio1;

import java.io.*;
import java.util.ArrayList;

public class Ficheros {

    public static void main(String[] args) throws IOException {
        File ftexto = new File("./archivos/1_notas.txt");
        File binarioNotas = notasEnBinario(ftexto);

        aumentarNotaBin(binarioNotas);
    }


   /*
   Método notasEnBinario(File)
   */
    public static File notasEnBinario(File f) throws IOException {
        //leer el .txt
        FileReader fileReader = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String primeraLinea;
        primeraLinea= bufferedReader.readLine();// se lee la primera línea para "saltarla", ya que no contiene datos relevantes
//        System.out.println(primeraLinea); //se comprueba que se ha leido correctamente


        //se crea un archivo binario con el nombre del archivo de texto, pero cambiando la extensión
//        System.out.println(f.getPath().replace(".txt",".bin")); //para comprobar el nombre que se le va a dar al archivo binario
        File ficheroBin =  new File(f.getPath().replace(".txt",".dat"));
        FileOutputStream fileout = new FileOutputStream(ficheroBin);
        DataOutputStream dataOutputStream = new DataOutputStream(fileout);

        String linea ;
        while((linea=bufferedReader.readLine())!=null){
//            System.out.println(linea);
            String[] datos = linea.split(" "); //Se separa cada línea por los espacios, lo que resulta en un array de tres elementos por línea (id,alumno,nota)
//            System.out.println(datos[0]); // aquí tendría que verse cada id
//            System.out.println(datos[1]); // aquí cada nombre
//            System.out.println(datos[2]); // y aquí cada nota
            dataOutputStream.writeInt(Integer.parseInt(datos[0]));
            dataOutputStream.writeUTF(datos[1]);
            dataOutputStream.writeFloat(Float.parseFloat((datos[2])));
        }
        bufferedReader.close();
        fileReader.close();

        dataOutputStream.close();
        fileout.close();

        return ficheroBin;
    }

    /*
    Método aumentarNotaBin(File)
    */
    public static void aumentarNotaBin(File fbin) throws IOException {
        //se crea el nuevo fichero de texto resultante
        File nuevoFicheroTexto = new File("./archivos/1_notas-modificado.txt");
        FileWriter fileWriter = new FileWriter(nuevoFicheroTexto);
        BufferedWriter bufferedWriter =  new BufferedWriter(fileWriter);

        bufferedWriter.write("Las notas actualizadas son:");
        bufferedWriter.newLine();

        //se prepara la lectura del fichero binario
        FileInputStream fileInputStream = new FileInputStream(fbin);
        DataInputStream dataInputStream =  new DataInputStream(fileInputStream);

        int id;
        String alumno;
        float nota;
        float nuevaNota;
        try {
            while(true){
                id=dataInputStream.readInt();
                alumno=dataInputStream.readUTF();
                nota=dataInputStream.readFloat();
                nuevaNota = nota +1;
                if (nuevaNota>10) nuevaNota =10;

//                System.out.println("id: " + id + " alumno: " + alumno + " nota: " + nuevaNota );//se comprueba que salen los datos correctos
                bufferedWriter.write(id + " " + alumno + " " + nuevaNota );
                bufferedWriter.newLine();
            }
        }catch (EOFException eo){
            System.err.println("End of file:" + eo);
        }
        dataInputStream.close();
        fileInputStream.close();

        bufferedWriter.close();
        fileWriter.close();

    }
}
