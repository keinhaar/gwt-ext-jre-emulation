package java.text;

/**
 * Emulation of Java SE java.text.ParseException
 */
public class ParseException extends Exception
{
    private static final long serialVersionUID = 1242476284255442L;
    private int errorIndex;
    
    public ParseException()
    {
    }

    public ParseException(String message, int errorIndex)
    {
        super(message);
    }

    public int getErrorOffset () 
    {
        return errorIndex;
    }
}
