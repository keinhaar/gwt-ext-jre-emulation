package com.google.gwt.user.client.rpc.core.java.net;

import java.net.MalformedURLException;
import java.net.URL;

import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public class URL_CustomFieldSerializer extends CustomFieldSerializer<URL>
{
    @Override
    public void deserializeInstance(SerializationStreamReader streamReader, URL instance) throws SerializationException
    {
        deserialize(streamReader, instance);
    }

    public static void deserialize(SerializationStreamReader streamReader, URL instance) throws SerializationException
    {
    }

    @Override
    public void serializeInstance(SerializationStreamWriter streamWriter, URL instance) throws SerializationException
    {
        serialize(streamWriter, instance);
    }
    
    @Override
    public URL instantiateInstance(SerializationStreamReader streamReader) throws SerializationException
    {
        return super.instantiateInstance(streamReader);
    }
    
    public static URL instantiate(SerializationStreamReader streamReader) throws SerializationException
    {
        try
        {
            return new URL(streamReader.readString());
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void serialize(SerializationStreamWriter streamWriter, URL instance) throws SerializationException
    {
        streamWriter.writeString(instance.toExternalForm());
    }
}
