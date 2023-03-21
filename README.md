# gwt-ext-jre-emulation
Additional emulated classes for GWT

The main goals of this project are 
- to provide commonly used classes that are currently not available in the jre-emulation of GWT. Like LocalDate.
- to wrap some existing GWT classes that force users to learn different API. Like Pattern vs. RegEx.

The implemented classes may, or may not implement all methods of the original classes. Just like GWTs JRE Emulation.

Any contributions are welcome.

# Classes Emulated

## java.net
- URL
  - URL(String)
  - toExternalForm()
  
## java.text
- DateFormat
  - parse(String)
  - parse(String, ParsePosition)
  - format(Object)
- DecimalFormat
  - DecimalFormat()
  - DecimalFormat(Locale)
  - DecimalFormat(String)
  - isGroupingUsed()
  - format(Object, StringBuffer, FieldPosition)
  - parse(String, ParsePosition)
  - toPattern()
  - getDecimalFormatSymbols()
  - setMaximumFractionDigits(int)
  - setMinimumIntegerDigits(int)
  - setGroupingSize(int)
- Format
  - format(Object)
- NumberFormat
  - getIntegerInstance()
  - getIntegerInstance(Locale)
  - getNumberInstance()
  - getNumberInstance(Locale)
  - format(Object)
  - parse(String)
- ParseException
- ParsePosition
- SimpleDateFormat
  - SimpleDateFormat(String)
  - format(Object)
  - format(Date)
  - parse(String, ParsePosition)

## java.time
- LocalDate
  - LocalDate(int, int, int)
  - of(int, int, int)
  - now()
  - minusDays(long)
  - getYear()
  - getMonth()
  - getDayOfMonth()

## java.util
- Calendar
  - get(int)
  - getTimeInMillis()
  - getTime()
  - set(int, int)
  - add(int, int)
  - setTime(Date)
  - set(int, int, int)
- GregorianCalendar
  - GregorianCalendar()
  - GregorianCalendar(int, int, int)
  - GregorianCalendar(int, int, int, int, int, int)
  - isLeapYear()
  - get(int)
  - getTimeInMillis()
  - getTime()
  - set(int, int)
  - add(int, int)
  - setTime(Date)
  - set(int, int, int)
- Locale
  - Locale(String, String)
  - getLanguage()
  - getCountry()
  - getDefault()

## java.util.regex
- Pattern
  - Pattern(String)
  - matcher(CharSequence)
  - quote(String)
  - split(CharSequence) 
  - pattern()
  - compile(String)
  - matches(String, CharSequence)
- Matcher
  - matches()
  - find()
  - pattern()
  - group(int)
  - groupCount()

  