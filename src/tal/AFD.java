package tal;

import java.io.*;
import static tal.Token.Type.*;

/**
 * Analizador léxico implementado mediante un
 * autómata finito determinista.
 * <p>Cada estado del autómata se implementa con un objeto Runnable.
 */
public class AFD extends ALex
{
/**
 * Construye el autómata.
 * @param fichero Fichero de texto que se debe analizar.
 * @throws IOException
 */
public AFD(String fichero) throws IOException
{
    super(fichero);
    setStart(this::inicio);
}

private void inicio()
{
    if(isDigitChar())
        state(this::intval);
    else if(isChar(('d'))){
        state(this::do1);
    }
    else if(isSpaceChar())
        restart();
    else if(isEofChar())
        token(EOF);
    else
        error();
}
private void do1(){
    if(isChar('o')){
        state(this::do2);
    }
    else{
        error();
    }
}
    private void do2(){
        if(isSpaceChar()||isEofChar()){
            token(DO);
        }
        else{
            error();
        }
    }
private void intval()
{
    if(isDigitChar())
        state(this::intval);
    else if(isIdChar())
        error();
    else
        token(INTVAL);
}

} // AFD
