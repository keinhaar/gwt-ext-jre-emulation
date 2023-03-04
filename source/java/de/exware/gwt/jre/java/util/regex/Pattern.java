/**
 * Copyright (c) 2017 eXware
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * eXware ("Confidential Information").  You shall not disclose such
 * Confidential Information and shall use it only in accordance with
 * the terms of the license agreement you entered into with eXware.
 */
package java.util.regex;

import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.regexp.shared.SplitResult;

/**
 * Pattern replacement for GWT Applications.
 * Regular Expressions will be mapped to GWTs RegExp class. So expect not everything to work
 * 100% the same.
 * @author martin
 *
 */
public class Pattern
{
   RegExp regex;
   
   private Pattern()
   {
       
   }
   
   private Pattern(String regex)
   {
       String flags = "";
       if (regex.startsWith("(?"))
       {
           flags = regex.substring(2, regex.indexOf(')'));
           regex = regex.substring(regex.indexOf(')') + 1);
       }
       else if (regex.startsWith("^(?"))
       {
           flags = regex.substring(3, regex.indexOf(')'));
           regex = regex.substring(regex.indexOf(')') + 1);
       }
       this.regex = RegExp.compile(regex, flags);
   }
   
   public Matcher matcher(CharSequence input)
   {
      return new Matcher(this, input.toString());
   }
   
   public static String quote(String reg)
   {
       return RegExp.quote(reg);
   }
   
   public String[] split(CharSequence input) 
   {
      SplitResult result = regex.split(input.toString());
      String[] ret = new String[result.length()];
      for(int i=0;i<result.length();i++)
      {
         ret[i] = result.get(i);
      }
      return ret;
   }

   public String pattern() 
   {
      return regex.getSource();
   }

   public static Pattern compile(String regex)
   {
      Pattern p = new Pattern(regex);
      return p;
   }
   
   public static boolean matches(String regex, CharSequence input)
   {
      Pattern p = new Pattern(regex);
      return p.regex.test(input.toString());
   }
}
