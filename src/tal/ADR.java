package tal;

import static tal.Token.Type.*;

/**
 * Analizador sintáctico implementado mediante el método
 * descendente recursivo.
 * <p>En esta clase se debe implementar la gramática del lenguaje.
 */
public class ADR extends ASin
{
/**
 * Construye un analizador descendente recursivo.
 * @param lex Analizador léxico.
 */
public ADR(ALex lex)
{
    super(lex);
}

/**
 * Símbolo inicial de la gramática.
 */
public void programa()
{
    declaracion();
    bloque();
    tokenRead(EOF);
}

private void declaracion()
{
    switch(tokenType())
    {
        case INTEGER:
            tokenRead(INTEGER);
            tokenRead(ID);
            declaracion();
            break;

        case STRING:
            tokenRead(STRING);
            tokenRead(ID);
            declaracion();
            break;
    }
}

private void bloque()
{
}

} // ADR
