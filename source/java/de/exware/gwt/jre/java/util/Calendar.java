package java.util;

public abstract class Calendar
{
    public final static int SUNDAY = 0;
    public final static int MONDAY = 1;
    public final static int TUESDAY = 2;
    public final static int WEDNESDAY = 3;
    public final static int THURSDAY = 4;
    public final static int FRIDAY = 5;
    public final static int SATURDAY = 6;

    public final static int JANUARY = 0;
    public final static int DECEMBER = 11;
    
    public final static int ERA = 0;
    public final static int DAY_OF_WEEK = 1;
    public final static int DAY_OF_MONTH = 2;
    public final static int HOUR_OF_DAY = 3;
    public final static int YEAR = 4;
    public final static int MINUTE = 5;
    public final static int SECOND = 6;
    public final static int MILLISECOND = 7;
    public final static int MONTH = 8;
    public final static int DATE = 9;
    public final static int WEEK_OF_YEAR = 10;
    
    public abstract int get(int field);
    
    public abstract long getTimeInMillis();

    public abstract Date getTime();

    public abstract void set(int field, int value);
    public abstract void add(int field, int value);
    
    public abstract void setTime(Date date);
    
    public void set(int year, int month, int day)
    {
        set(YEAR, year);
        set(MONTH, month);
        set(DAY_OF_MONTH, day);
    }
}
