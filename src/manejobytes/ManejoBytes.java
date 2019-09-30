
package manejobytes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejoBytes {
 
    //Neste array recóllesen os bytes lidos e se almacenan
    //Empregaranse varios try-catch a fin de recoller certas excpeciones
    //COmo FileNotFound, etc
    public static ArrayList<Integer> bytes = new ArrayList<>();
    public static void main(String[] args) {
    FileInputStream lectura = null;

        try {
           
            lectura = new FileInputStream("/home/oracle/Desktop/texto1.txt");

           //Esta parte de código lee o arquivo byte a byte
            //Cando a lectura do arquivo lle devolva -1 
            // deixara de leer
            int valueByte = 0;

            while (valueByte != -1) {

                try {
                    valueByte = lectura.read();
                   bytes.add(valueByte);

                } catch (IOException ex) {
                    Logger.getLogger(ManejoBytes.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejoBytes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                lectura.close();
            } catch (IOException ex) {
Logger.getLogger(ManejoBytes.class.getName()).log(Level.SEVERE, null, ex);
    }
}
        //Mediante o array que temos craedo
        //(onde se almacenaron todos os bytes lidos do arquivo)
        //Recorremos a lista cun for
        // e nun novo arquivo vanse copiando os bytes un a un
        FileOutputStream write = null;

        try {
            write = new FileOutputStream("/home/oracle/Desktop/texto2.txt");

            for (Integer i : bytes) {
//cando se estea lendo os bytes e devolva cero
                //parara o programa de leer
                
                if (i == -1) {

                    try {
                        write.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ManejoBytes.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    try {
                        write.write(i);
                    } catch (IOException ex) {
                        Logger.getLogger(ManejoBytes.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejoBytes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
               write.close();
            } catch (IOException ex) {
                Logger.getLogger(ManejoBytes.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
    
    



