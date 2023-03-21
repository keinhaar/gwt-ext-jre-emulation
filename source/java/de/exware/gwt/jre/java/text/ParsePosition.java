package java.text;

/**
 * Emulation of Java SE java.text.ParsePosition
 */
public class ParsePosition
{
    private int index;
    private int errorIndex;
    
    public ParsePosition()
    {
    }

    public ParsePosition(int index)
    {
        this.index = index;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public int getErrorIndex()
    {
        return errorIndex;
    }

    public void setErrorIndex(int errorIndex)
    {
        this.errorIndex = errorIndex;
    }
}
