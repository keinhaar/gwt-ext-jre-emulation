package java.util;

public class GregorianCalendar extends Calendar
{
    private static final int MILLIS_PER_MINUTE = 1000 * 60;
    private static final int MILLIS_PER_HOUR = MILLIS_PER_MINUTE * 60;
    private static final int MILLIS_PER_DAY = MILLIS_PER_HOUR * 24;
    private int timeZoneOffset;
    private long time;
    
    public GregorianCalendar()
    {
        setTime(System.currentTimeMillis());
        timeZoneOffset = new Date().getTimezoneOffset() * MILLIS_PER_MINUTE;
    }
    
    public GregorianCalendar(int year, int month, int day)
    {
        this(year, month, day, 0, 0, 0);
    }
    
    public GregorianCalendar(int year, int month, int day,
        int hour, int minute, int second)
    {
        long time = getTimeForYear(year);
        for(int i=0;i<month;i++)
        {
            time += getDaysInMonth(year, i) * MILLIS_PER_DAY;
        }
        time += (day-1) * MILLIS_PER_DAY;
        time += hour * MILLIS_PER_HOUR;
        time += (minute) * MILLIS_PER_MINUTE;
        time += second * 1000;
        timeZoneOffset = new Date(time).getTimezoneOffset() * MILLIS_PER_MINUTE;
        time += timeZoneOffset;
        setTime(time);
    }
    
    private long getTimeForYear(int year)
    {
        int previousYear = year - 1;
        long days = previousYear * 365 + previousYear / 4 - previousYear / 100 + previousYear / 400;
        days -= 1969 * 365 + 1969 / 4 - 1969 / 100 + 1969 / 400;
        long time = days * MILLIS_PER_DAY;
        return time;
    }

    private int getDaysInMonth(int year, int month)
    {
        int days = 0;
        if(month == 1)
        {
            days = isLeapYear(year) ? 29 : 28;
        }
        else if(month < 7)
        {
            days = month % 2 == 0 ? 31 : 30;
        }
        else
        {
            days = month % 2 == 1 ? 31 : 30;
        }
        return days;
    }
    
    public boolean isLeapYear(int year)
    {
        boolean leapYear = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        return leapYear;
    }
 
    @Override
    public Date getTime()
    {
        return new Date(time);
    }

    @Override
    public int get(int field)
    {
        int value = 0;
        if(DAY_OF_WEEK == field)
        {
            long days = time / MILLIS_PER_DAY;
            value = (int) (days % 7) + 5;
            if(value > 6) value -= 7;
        }
        else if(WEEK_OF_YEAR == field)
        {
            int year = get(YEAR);
            GregorianCalendar cal = new GregorianCalendar(year, 0, 1);
            long yearStart = cal.time;
            int month = get(MONTH);
            cal.set(MONTH, month);
            cal.set(DAY_OF_MONTH, get(DAY_OF_MONTH));
            long thisDay = cal.time;
            int days = (int) ((thisDay - yearStart) / MILLIS_PER_DAY);
            int dayOfWeek = cal.get(DAY_OF_WEEK);
            int week = days / 7;
            value = week;
        }
        else if(MILLISECOND == field)
        {
            value = (int) (time % 1000);
        }
        else if(SECOND == field)
        {
            value = (int) ((time % MILLIS_PER_MINUTE) / 1000);
        }
        else if(MINUTE == field)
        {
            value = (int) ((time % (MILLIS_PER_HOUR)) / MILLIS_PER_MINUTE);
        }
        else if(HOUR_OF_DAY == field)
        {
            value = (int) ((time % (24*MILLIS_PER_HOUR)) / (MILLIS_PER_HOUR));
            value -= timeZoneOffset / MILLIS_PER_HOUR;
            if(value == 24) value = 0;
        }
        else if(MONTH == field)
        {
            Date d = new Date(time);
            value = d.getMonth();
        }
        else if(YEAR == field)
        {
            Date d = new Date(time);
            value = d.getYear() + 1900;
        }
        else if(DAY_OF_MONTH == field
            || DATE == field)
        {
            Date d = new Date(time);
            value = d.getDate();
        }
        else if(DAY_OF_WEEK == field)
        {
            Date d = new Date(time);
            value = d.getDay();
        }
        return value;
    }

    @Override
    public long getTimeInMillis()
    {
        return time;
    }

    @Override
    public String toString()
    {
        return get(YEAR) + "-" + (get(MONTH)+1) + "-" + get(DAY_OF_MONTH) + " " + get(HOUR_OF_DAY) + ":" + get(MINUTE) + ":" + get(SECOND);
    }
    
    @Override
    public void set(int field, int value)
    {
        if(MILLISECOND == field)
        {
            time += value - time % 1000;
        }
        else if(SECOND == field)
        {
            time += value * 1000 - time % MILLIS_PER_MINUTE;
        }
        else if(MINUTE == field)
        {
            time += value * MILLIS_PER_MINUTE - time % MILLIS_PER_HOUR;
        }
        else if(HOUR_OF_DAY == field)
        {
            time += value * MILLIS_PER_HOUR - time % MILLIS_PER_DAY;
            time += timeZoneOffset;
        }
        else if(DAY_OF_MONTH == field 
            || DATE == field)
        {
            int day = get(DAY_OF_MONTH);
            time = time - (MILLIS_PER_DAY * day);
            time = time + (MILLIS_PER_DAY * value);
        }
        else if(MONTH == field)
        {
            while(value < 0)
            {
                int year = get(YEAR);
                set(YEAR, year-1);
                value += 12;
            }
            int year = get(YEAR);
            int month = get(MONTH);
            for(int i=0;i<month;i++)
            {
                time -= getDaysInMonth(year, i) * MILLIS_PER_DAY;
            }
            for(int i=0;i<value;i++)
            {
                time += getDaysInMonth(year, i) * MILLIS_PER_DAY;
            }
        }
        else if(YEAR == field)
        {
            int year = get(YEAR);
            long oldYearMillis = getTimeForYear(year);
            long newYearMillis = getTimeForYear(value);
            time = time - oldYearMillis + newYearMillis;
        }
    }

    @Override
    public void add(int field, int value)
    {
        if(MILLISECOND == field)
        {
            time += value;
        }
        else if(SECOND == field)
        {
            time += value * 1000;
        }
        else if(MINUTE == field)
        {
            time += value * MILLIS_PER_MINUTE;
        }
        else if(HOUR_OF_DAY == field)
        {
            time += value * MILLIS_PER_HOUR;
        }
        else if(DAY_OF_MONTH == field
            || DATE == field)
        {
            time += value * MILLIS_PER_DAY;
        }
        else if(YEAR == field)
        {
            int year = get(YEAR);
            long oldYearMillis = getTimeForYear(year);
            long newYearMillis = getTimeForYear(year+value);
            time = time - oldYearMillis + newYearMillis;
        }
    }

    @Override
    public void setTime(Date date)
    {
        setTime(date.getTime());
    }
    
    private void setTime(long time)
    {
        this.time = time;
    }
}
