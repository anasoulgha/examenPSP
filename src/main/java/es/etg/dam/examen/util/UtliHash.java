package es.etg.dam.examen.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UtliHash {
    
    private static final String FORMATO_HASH="SHA-256";
    //private static final int MASCARA_BYTE= 0xff;
    //private static final int LONGUITUD_SIMPLE =1;

    public static byte[] generarHash(byte[] contenido) throws NoSuchAlgorithmException{
        MessageDigest mg = MessageDigest.getInstance(FORMATO_HASH);
        return mg.digest(contenido);

    }
}
