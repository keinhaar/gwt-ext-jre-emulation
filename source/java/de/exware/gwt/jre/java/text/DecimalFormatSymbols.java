package java.text;

import java.util.Locale;

/**
 * Emulation of Java SE java.text.DecimalFormatSymbols
 */
public class DecimalFormatSymbols
{
    private static final DecimalFormatSymbols ENGLISH = new DecimalFormatSymbols(',', '.');
    private static final DecimalFormatSymbols GERMAN = new DecimalFormatSymbols('.', ',');
    private char groupingChar;
    private char decimalSeparator;

    private DecimalFormatSymbols(char groupingChar, char decimalSeparator)
    {
        this.groupingChar = groupingChar;
        this.decimalSeparator = decimalSeparator;
    }

    static public DecimalFormatSymbols getInstance(Locale locale)
    {
        if (locale == null)
        {
            locale = Locale.getDefault();
        }
        else if (locale.getLanguage().equals(Locale.GERMAN.getLanguage())
            || locale.getLanguage().equals(Locale.GERMANY.getLanguage())
            || locale.getLanguage().equals(Locale.FRANCE.getLanguage())
            || locale.getLanguage().equals(Locale.FRENCH.getLanguage()))
        {
            return GERMAN;
        }
        return ENGLISH;
    }

    public char getGroupingSeparator()
    {
        return groupingChar;
    }

    public char getDecimalSeparator()
    {
        return decimalSeparator;
    }
}
