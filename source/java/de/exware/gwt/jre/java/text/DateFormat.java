package java.text;

import java.util.Date;

/**
 * Emulation of Java SE java.text.DateFormat
 */
abstract public class DateFormat extends Format
{
    public Date parse(String sdate) throws ParseException
    {
        ParsePosition ppos = new ParsePosition(0);
        Date date = parse(sdate, ppos);
        if(ppos.getIndex() == 0)
        {
            throw new ParseException("Unable to parse date '" + sdate + "'", ppos.getErrorIndex());
        }
        return date;
    }
    
    public abstract Date parse(String sdate, ParsePosition ppos);

    @Override
    public String format(Object obj)
    {
        return obj.toString();
    }
}
