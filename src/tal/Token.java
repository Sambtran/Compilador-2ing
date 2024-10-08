package tal;

/**
 * Elementos básicos del lenguaje.
 */
public class Token
{
/** Tipos posibles de los tokens. */
public static enum Type
{
    /** Palabra reservada {@code integer}. */
    INTEGER,
    /** Palabra reservada {@code string}. */
    STRING,
    /** Palabra reservada {@code if}. */
    IF,
    /** Palabra reservada {@code then}. */
    THEN,
    /** Palabra reservada {@code else}. */
    ELSE,
    /** Palabra reservada {@code while}. */
    WHILE,
    /** Palabra reservada {@code do}. */
    DO,
    /** Palabra reservada {@code end}. */
    END,
    /** Palabra reservada {@code echo}. */
    ECHO,
    /** Identificadores (nombres de variables). */
    ID,
    /** Número entero. */
    INTVAL,
    /** Cadena de caracteres entre dobles comillas. */
    STRVAL,
    /** Operador de asignación: {@code =} */
    ASSIGN,
    /** Operadores de suma y resta: {@code +}, {@code -} */
    SUM,
    /** Operadores de multiplicación y división: {@code *}, {@code /} */
    MUL,
    /** Operadores relacionales:
     *  {@code ==}, {@code !=},
     *  {@code <}, {@code <=},
     *  {@code >}, {@code >=} */
    REL,
    /** Operador de negación: {@code !} */
    NEG,
    /** Operador de disyunción: {@code ||} */
    OR,
    /** Operador de conjunción: {@code &&} */
    AND,
    /** Paréntesis izquierdo: {@code (} */
    IPAR,
    /** Paréntesis derecho: {@code )} */
    DPAR,
    /** Fin de fichero. */
    EOF
}

/** Tipo del token. */
public final Type type;
/** Nombre del token. */
public final String name;
/** Fila donde está el token en el fichero analizado. */
public final int row;
/** Columna donde está el token en el fichero analizado. */
public final int column;

/**
 * Construye un token.
 * @param type
 * @param name
 * @param row
 * @param column
 */
public Token(Type type, String name, int row, int column)
{
    this.type   = type;
    this.name   = name;
    this.row    = row;
    this.column = column;
}

//------------------------------------------------------------------------
@Override public String toString()
{
    StringBuilder sb = new StringBuilder();
    sb.append("Token ");
    sb.append(type);
    sb.append(": ");
    sb.append(name);
    return sb.toString();
}

} // Token
