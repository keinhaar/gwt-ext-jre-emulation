package java.text;

import java.util.Locale;

/**
 * Emulation of Java SE java.text.DecimalFormat
 */
public class DecimalFormat extends NumberFormat
{
    private com.google.gwt.i18n.client.NumberFormat numberFormat;
    private Locale locale;

    /**
    * 
    */
    public DecimalFormat()
    {
    }

    public DecimalFormat(Locale locale)
    {
        this.locale = locale;
    }

    public DecimalFormat(String pattern)
    {
        this(pattern, (Locale) null);
    }

    public DecimalFormat(String pattern, DecimalFormatSymbols dfs)
    {
        this.numberFormat = com.google.gwt.i18n.client.NumberFormat.getFormat(pattern);
    }

    DecimalFormat(com.google.gwt.i18n.client.NumberFormat format)
    {
        this(format, null);
    }

    DecimalFormat(com.google.gwt.i18n.client.NumberFormat format, Locale locale)
    {
        this.numberFormat = format;
        this.locale = locale;
    }

    public DecimalFormat(String pattern, Locale locale)
    {
        this.numberFormat = com.google.gwt.i18n.client.NumberFormat.getFormat(pattern);
        this.locale = locale;
    }

    public void applyPattern(String pattern)
    {
        this.numberFormat = com.google.gwt.i18n.client.NumberFormat.getFormat(pattern);
    }

    public void setPositivePrefix(String prefix)
    {
        throw new UnsupportedOperationException("Unsupported in GWT");
    }

    @Override
    public StringBuffer format(Object number, StringBuffer result, FieldPosition fieldPosition)
    {
        result.append(getNumberFormat().format((Number) number));
        return result;
    }

    @Override
    public Number parse(String snumber, ParsePosition pos)
    {
        int[] inout = new int[] { 0 };
        Number num = getNumberFormat().parse(snumber, inout);
        pos.setIndex(inout[0]);
        return num;
    }

    public String toPattern()
    {
        return getNumberFormat().getPattern();
    }

    public DecimalFormatSymbols getDecimalFormatSymbols()
    {
        return DecimalFormatSymbols.getInstance(locale);
    }

    @Override
    public void setMaximumFractionDigits(int digits)
    {
        super.setMaximumFractionDigits(digits);
        numberFormat = null;
    }
    
    @Override
    public void setMinimumIntegerDigits(int digits)
    {
        super.setMaximumIntegerDigits(digits);
        numberFormat = null;
    }
    
    @Override
    public void setGroupingSize(int size)
    {
        super.setGroupingSize(size);
        numberFormat = null;
    }
    
    private com.google.gwt.i18n.client.NumberFormat getNumberFormat()
    {
        if (numberFormat == null)
        {
            DecimalFormatSymbols symbols = getDecimalFormatSymbols();
            StringBuilder pattern = new StringBuilder();
            char[] integerDigits = new char[getMaximumIntegerDigits()];

            for (int i = 1, index = integerDigits.length - 1; i < getMaximumIntegerDigits(); i++, index--)
            {
                if (i <= getMinimumIntegerDigits())
                {
                    integerDigits[index] = '0';
                }
                else
                {
                    integerDigits[index] = '#';
                }
                if (i % getGroupingSize() == 0)
                {
                    index--;
                    integerDigits[index] = symbols.getGroupingSeparator();
                }
            }
            pattern.append(integerDigits);

            if (getMinimumFractionDigits() > 0 || getMaximumFractionDigits() > 0)
            {
                pattern.append(symbols.getDecimalSeparator());
                for (int i = 0; i < getMinimumFractionDigits(); i++)
                {
                    pattern.append("0");
                }
                for (int i = getMinimumFractionDigits(); i < getMaximumFractionDigits(); i++)
                {
                    pattern.append("#");
                }
            }
            numberFormat = com.google.gwt.i18n.client.NumberFormat.getFormat(pattern.toString());
        }

        return numberFormat;
    }

    public void setDecimalFormatSymbols(DecimalFormatSymbols dfs)
    {
        throw new UnsupportedOperationException("Unsupported in GWT");
    }

}
