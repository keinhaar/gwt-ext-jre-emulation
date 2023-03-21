package java.text;

import java.time.LocalDate;
import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;

public class SimpleDateFormat extends DateFormat
{
    private DateTimeFormat df;
    
    public SimpleDateFormat(String pattern)
    {
        df = DateTimeFormat.getFormat(pattern);
    }
    
    public String format(Date date)
    {
        return df.format(date);
    }

    @Override
    public String format(Object date)
    {
        if(date instanceof Date)
        {
            return format((Date) date);
        }
        else if(date instanceof LocalDate)
        {
            return format((LocalDate) date);
        }
        return null;
    }

    public String format(LocalDate date)
    {
        return df.format(date.toDate());
    }

    @Override
    public Date parse(String sdate, ParsePosition ppos)
    {
        Date date = null;
        Date tdate = new Date(0, 1, 0, 0, 0, 0);
        int charsConsumed = df.parse(sdate, 0, tdate);
        if(charsConsumed > 0)
        {
            date = tdate;
        }
        ppos.setIndex(charsConsumed);
        return date;
    }
}
