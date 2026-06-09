package es.etg.dam.examen.util.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.etg.dam.examen.util.LogUtil;
import es.etg.dam.examen.util.exception.ServidorException;

public class Servidor {
   private static final String MSG_SERVIDOR ="escuchando en %d";
   public static final int PUERTO = 8888;
   public static final String HOST = "localhost";
    private static final String FICHERO_LOG ="servidor.log";

   
   public static void main(String[] args)throws ServidorException {
    Logger logger=null;

    try (ServerSocket server = new ServerSocket(PUERTO)) {
        logger= LogUtil.crearLog(FICHERO_LOG);
        LogUtil.escribirLog(logger,Level.INFO, String.format(MSG_SERVIDOR, PUERTO));

        while (true) {
            Socket cliente= server.accept();
            Thread hilo = new Thread(new GestionCliente(cliente));
            hilo.start();
        }
    } catch (IOException e) {
    LogUtil.escribirLog(logger,Level.SEVERE,e.getMessage(),e); 
        throw new ServidorException(e.getMessage());
    }
        
    }
   }

