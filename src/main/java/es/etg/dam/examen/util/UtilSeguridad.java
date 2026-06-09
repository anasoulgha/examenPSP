package es.etg.dam.examen.util;

import java.util.Base64;

public class UtilSeguridad {
        public static final String PUNTOS =":";


  public static String prepararPaquete(String msg) throws Exception{
    String cifrado=UtilSimetrico.cifrar(msg);
    byte[] hash= UtliHash.generarHash(msg.getBytes(UtilSimetrico.UTF));
    String hashStr=Base64.getEncoder().encodeToString(hash);
    return cifrado + PUNTOS + hashStr;

  }  
 public static String  desempaquetar(String paquete) throws Exception{
    String[] partes = paquete.split(PUNTOS);
    String msgDescifrado = UtilSimetrico.descifrar(partes[0]);
    byte[] hashCalc = UtliHash.generarHash(msgDescifrado.getBytes(UtilSimetrico.UTF));
    String hashCalcStr= Base64.getEncoder().encodeToString(hashCalc);
    return msgDescifrado;
 }
}
