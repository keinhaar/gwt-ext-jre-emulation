package java.util;

import com.google.gwt.i18n.client.LocaleInfo;

public class Locale
{
    public static final Locale ROOT = new Locale("", "");
    static public final Locale ENGLISH = new Locale("en", "");
    static public final Locale FRENCH = new Locale("fr", "");
    static public final Locale GERMAN = new Locale("de", "");
    static public final Locale ITALIAN = new Locale("it", "");
    static public final Locale JAPANESE = new Locale("jp", "");
    static public final Locale UK = new Locale("en", "GB");
    static public final Locale FRANCE = new Locale("fr", "FR");
    static public final Locale GERMANY = new Locale("de", "DE");
    static public final Locale ITALY = new Locale("it", "IT");
    static public final Locale JAPAN = new Locale("jp", "JP");
    private static Locale defaultLocale;
    
    private String language;
    private String country;

    public Locale(String language, String country)
    {
        this.language = language;
        this.country = country;
    }

    public String getLanguage()
    {
        return language;
    }

    public String getCountry()
    {
        return country;
    }
    
    @Override
    public String toString()
    {
        return language + "_" + country;
    }
    
    public static Locale getDefault()
    {
        if(defaultLocale == null)
        {
            String lname = LocaleInfo.getCurrentLocale().getLocaleName();
            if(lname.contains("_"))
            {
                defaultLocale = new Locale(lname.substring(0, 2), lname.substring(3, 5));
            }
            else
            {
                defaultLocale = new Locale(lname, "");
            }
        }
        return defaultLocale;
    }
}
