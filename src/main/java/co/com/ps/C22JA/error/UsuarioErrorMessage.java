package co.com.ps.C22JA.error;

public class UsuarioErrorMessage extends RuntimeException{

    UsuarioErrorMessage(String mensaje){
        super("Error en Usuario " + mensaje);
    }

}