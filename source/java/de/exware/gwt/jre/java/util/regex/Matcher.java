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

import com.google.gwt.regexp.shared.MatchResult;

/**
 * Matcher replacement for GWT Applications. Regular Expressions will be mapped
 * to GWTs RegExp class. So expect not everything to work 100% the same.
 */
public class Matcher
{
    private Pattern pattern;
    private String input;
    private MatchResult matchResult;

    protected Matcher(Pattern pattern, String input)
    {
        this.pattern = pattern;
        this.input = input;
    }

    public boolean matches()
    {
        matchResult = pattern.regex.exec(input);
        return matchResult != null;
    }

    public boolean find()
    {
        Pattern partPattern = Pattern.compile(".*" + pattern.pattern() + ".*");
        matchResult = partPattern.regex.exec(input);
        return matchResult != null;
    }

    public Pattern pattern()
    {
        return pattern;
    }

    public String group(int group)
    {
        return matchResult.getGroup(group);
    }

    public int groupCount()
    {
        return matchResult.getGroupCount();
    }
}
