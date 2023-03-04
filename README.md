# gwt-ext-jre-emulation
Additional emulated classes for GWT

The main goals of this project are 
- to provide commonly used classes that are currently not available in the jre-emulation of GWT. Like LocalDate.
- to wrap some existing GWT classes that force users to learn different API. Like Pattern vs. RegEx.

The implemented classes may, or may not implement all methods of the original classes. Just like GWTs JRE Emulation.

Any contributions are welcome.

# Classes Emulated
- java.util.regex.Pattern
- java.util.regex.Matcher
- java.util.Calendar
- java.util.GregorianCalendar
- java.time.LocalDate
- java.text.SimpleDateFormat
- java.net.URL
