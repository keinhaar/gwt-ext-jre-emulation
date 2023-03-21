package java.text;

import java.io.Serializable;

/**
 * Emulation of Java SE java.text.Format
 */
public abstract class Format implements Serializable, Cloneable
{
    abstract public String format(Object obj);
}
