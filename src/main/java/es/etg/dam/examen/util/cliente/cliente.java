package es.etg.dam.examen.util.cliente;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.etg.dam.examen.util.LogUtil;
import es.etg.dam.examen.util.conexion.Conexion;
import es.etg.dam.examen.util.exception.ClienteException;
import es.etg.dam.examen.util.server.Servidor;

public class cliente{
    private static final int TIPO = 0;
    private static final String MSG_SERVIDOR_RESPUESTA = "respueta del server %s mensaje:%s";
    private static final String FICHERO_LOG = "clente.log";

    public static void main(String[] args) throws Exception{
        Logger logger = null;
        try (Socket socket = new Socket(Servidor.HOST, Servidor.PUERTO)) {
            logger = LogUtil.crearLog(FICHERO_LOG);
            Conexion conn = new Conexion();
            String mensaje = args[TIPO];
            conn.escribir(mensaje, socket);
            String respuesta = conn.leer(socket);
             LogUtil.escribirLog(logger,Level.INFO, String.format(MSG_SERVIDOR_RESPUESTA, respuesta, mensaje));


        } catch (IOException e) {
        LogUtil.escribirLog(logger,Level.SEVERE,e.getMessage(),e); 

            throw new ClienteException(e.getMessage());
        }
    }
}
