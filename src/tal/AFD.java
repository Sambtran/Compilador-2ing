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

    //while
    else if(isChar('e')){
        state(this::else1);
    }
    //if
    else if(isChar('i')){
        state(this::if1);
    }
    //while
    else if(isChar('w')){
        state(this::While);
    }
    //string
    else if (isChar('"')){
        state(this::string);
    }
    //do
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
private void While(){
    if(isChar('h')){
        state(this::while2);
    }
    else{
        error();
    }
}
private void while2(){
    if(isChar('i')){
        state(this::while3);
    }
    else{
        error();
    }
}
private void while3(){
    if(isChar('l')){
        state(this::while4);
    }
    else{
        error();
    }
}
private void while4(){
    if(isChar('e')){
        state(this::while5);
    }
    else {
        error();
    }
}
private void while5(){
    if(isSpaceChar()||isEofChar()){
        token(WHILE);
    }
    else{
        error();
    }
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
    private void string(){
    if(isChar('"')){
        state(this::string2);
    }else{
        state(this::string);
    }
    }
    private void string2(){
        token(STRING);
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
    private void if1(){
        if(isChar('f')){
            state(this::if2);
        }
        else{
            error();
        }
    }
    private void if2(){
        if(isSpaceChar()||isEofChar()){
            token(IF);
        }
        else{
            error();
        }
    }
    //else
    private void else1(){
        if(isChar('l')){
            state(this::else2);
        } else if (isChar('n')) {
            state(this::end1);
        }else if (isChar('c')) {
            state(this::echo1);
        }
        else{
            error();
        }
    }
    private void end1(){
        if(isChar('d')){
            state(this::end2);
        }
        else{
            error();
        }
    }
    private void echo1(){
        if(isChar('h')){
            state(this::echo2);
        }
        else{
            error();
        }
    }
    private void echo2(){
        if(isChar('o')){
            state(this::echo3);
        }
        else{
            error();
        }
    }
    private void echo3(){
        if(isSpaceChar()||isEofChar()){
            token(ECHO);
        }
        else{
            error();
        }
    }
    private void end2(){
        if(isSpaceChar()||isEofChar()){
            token(END);
        }
        else{
            error();
        }
    }
    private void else2(){
        if(isChar('s')){
            state(this::else3);
        }
        else{
            error();
        }
    }
    private void else3(){
        if(isChar('e')){
            state(this::else4);
        }
        else{
            error();
        }
    }
    private void else4(){
        if(isSpaceChar()||isEofChar()){
            token(ELSE);
        }
        else{
            error();
        }
    }
} // AFD
