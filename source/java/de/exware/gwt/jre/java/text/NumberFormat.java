package java.text;

import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;

abstract public class NumberFormat extends Format
{
    private int minimumFractionDigits = 0;
    private int maximumFractionDigits = 3;
    private int minimumIntegerDigits = 1;
    private int maximumIntegerDigits = 40;
    private int groupingSize = 3;
    private boolean groupingUsed = true;

    public boolean isGroupingUsed()
    {
        return groupingUsed;
    }

    public void setMaximumFractionDigits(int digits)
    {
        maximumFractionDigits = digits;
    }

    public void setMinimumIntegerDigits(int digits)
    {
        minimumIntegerDigits = digits;
    }

    public void setGroupingSize(int size)
    {
        groupingSize = size;
    }

    public int getGroupingSize()
    {
        return groupingSize;
    }

    public int getMaximumFractionDigits()
    {
        return maximumFractionDigits;
    }

    public int getMaximumIntegerDigits()
    {
        return maximumIntegerDigits;
    }

    public static NumberFormat getInstance()
    {
        return new DecimalFormat();
    }

    public static NumberFormat getInstance(Locale locale)
    {
        return new DecimalFormat(locale);
    }

    public static NumberFormat getNumberInstance()
    {
        return new DecimalFormat();
    }

    public static NumberFormat getNumberInstance(Locale locale)
    {
        return new DecimalFormat(locale);
    }

    public static NumberFormat getCurrencyInstance()
    {
        return new DecimalFormat(com.google.gwt.i18n.client.NumberFormat.getCurrencyFormat());
    }

    public static NumberFormat getCurrencyInstance(Locale locale)
    {
        return new DecimalFormat(com.google.gwt.i18n.client.NumberFormat.getCurrencyFormat(), locale);
    }

    public static NumberFormat getPercentInstance(Locale locale)
    {
        return new DecimalFormat(com.google.gwt.i18n.client.NumberFormat.getPercentFormat(), locale);
    }

    public static NumberFormat getPercentInstance()
    {
        return new DecimalFormat(com.google.gwt.i18n.client.NumberFormat.getPercentFormat());
    }

    public static NumberFormat getIntegerInstance(Locale locale)
    {
        return new DecimalFormat("#", locale);
    }

    public static NumberFormat getIntegerInstance()
    {
        return new DecimalFormat("#");
    }

    @Override
    public final String format(Object obj)
    {
        return format(obj, new StringBuffer(), null).toString();
    }

    public Number parse(String snumber) throws ParseException
    {
        ParsePosition pos = new ParsePosition(0);
        Number result = parse(snumber, pos);
        if (pos.getIndex() == 0)
        {
            throw new ParseException("Unable to parse number '" + snumber + "'", pos.getErrorIndex());
        }
        return result;
    }

    abstract public Number parse(String source, ParsePosition pos);

    public boolean isParseIntegerOnly()
    {
        throw new UnsupportedOperationException("Unsupported in GWT");
    }

    public void setParseIntegerOnly(boolean b)
    {
        throw new UnsupportedOperationException("Unsupported in GWT");
    }

    public void setMinimumFractionDigits(int newValue)
    {
        throw new UnsupportedOperationException("Unsupported in GWT");
    }

    public void setMaximumIntegerDigits(int newValue)
    {
        throw new UnsupportedOperationException("Unsupported in GWT");
    }

    public int getMinimumIntegerDigits()
    {
        throw new UnsupportedOperationException("Unsupported in GWT");
    }

    public int getMinimumFractionDigits()
    {
        throw new UnsupportedOperationException("Unsupported in GWT");
    }

    public Currency getCurrency()
    {
        throw new UnsupportedOperationException("Unsupported in GWT");
    }

    public void setCurrency(Currency c)
    {
        throw new UnsupportedOperationException("Unsupported in GWT");
    }

    public void setGroupingUsed(boolean b)
    {
        throw new UnsupportedOperationException("Unsupported in GWT");
    }

    public RoundingMode getRoundingMode()
    {
        throw new UnsupportedOperationException("Unsupported in GWT");
    }

    public void setRoundingMode(RoundingMode mode)
    {
        throw new UnsupportedOperationException("Unsupported in GWT");
    }

    public StringBuffer format(long number, StringBuffer buffer, FieldPosition fieldPosition)
    {
        throw new UnsupportedOperationException("Unsupported in GWT");
    }

    public StringBuffer format(double number, StringBuffer buffer, FieldPosition fieldPosition)
    {
        throw new UnsupportedOperationException("Unsupported in GWT");
    }

    public StringBuffer format(Object number, StringBuffer buffer, FieldPosition fieldPosition)
    {
        throw new UnsupportedOperationException("Unsupported in GWT");
    }

}
