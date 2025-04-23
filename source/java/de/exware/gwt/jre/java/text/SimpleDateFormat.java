package java.text;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_de;
import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.i18n.shared.DateTimeFormatInfo;
import com.google.gwt.i18n.shared.impl.cldr.DateTimeFormatInfoImpl_en;

public class SimpleDateFormat extends DateFormat
{
    private DateTimeFormat df;
    
    public SimpleDateFormat(String pattern)
    {
        this(pattern, Locale.getDefault());
    }
    
    public SimpleDateFormat(String pattern, Locale locale)
    {
        DateTimeFormatInfo info = null;
        if("de".equals( locale.getLanguage()))
        {
            info = new DateTimeFormatInfoImpl_de();
        }
        else
        {
            info = new DateTimeFormatInfoImpl_en();
        }
        df = new LocalizedDateTimeFormat(pattern, info);
    }
    
    class LocalizedDateTimeFormat extends DateTimeFormat
    {

        public LocalizedDateTimeFormat(String pattern, DateTimeFormatInfo info)
        {
            super(pattern, info);
        }
        
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
