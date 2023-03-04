package java.text;

import java.time.LocalDate;
import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;

public class SimpleDateFormat
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
}
