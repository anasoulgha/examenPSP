package es.etg.dam.examen.util.server;

import java.net.Socket;
import java.util.logging.Logger;

import es.etg.dam.examen.util.conexion.Conexion;

public class GestionCliente implements Runnable {

    private static final Logger logger = Logger.getLogger("Logger");

    private Socket socket;

    public GestionCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Conexion conn = new Conexion();
            String msg = conn.leer(socket);
            String resultado;

            if (msg == "Luces") {
                resultado ="simple";

            }else{
                resultado ="Error";

            }
            conn.escribir(resultado, socket);
        } catch (Exception e) {
            // no me da tiempo
        }

    }
}
