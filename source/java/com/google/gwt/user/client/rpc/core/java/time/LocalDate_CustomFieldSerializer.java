package com.google.gwt.user.client.rpc.core.java.time;

import java.time.LocalDate;

import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public class LocalDate_CustomFieldSerializer extends CustomFieldSerializer<LocalDate>
{
    @Override
    public void deserializeInstance(SerializationStreamReader streamReader, LocalDate instance) throws SerializationException
    {
        deserialize(streamReader, instance);
    }

    public static void deserialize(SerializationStreamReader streamReader, LocalDate instance) throws SerializationException
    {
    }

    @Override
    public void serializeInstance(SerializationStreamWriter streamWriter, LocalDate instance) throws SerializationException
    {
        serialize(streamWriter, instance);
    }
    
    @Override
    public LocalDate instantiateInstance(SerializationStreamReader streamReader) throws SerializationException
    {
        return instantiate(streamReader);
    }
    
    public static LocalDate instantiate(SerializationStreamReader streamReader) throws SerializationException
    {
        return LocalDate.of(streamReader.readInt(), streamReader.readInt(), streamReader.readInt());
    }
    
    @Override
    public boolean hasCustomInstantiateInstance()
    {
        return true;
    }
    
    public static void serialize(SerializationStreamWriter streamWriter, LocalDate instance) throws SerializationException
    {
        streamWriter.writeInt(instance.getYear());
        streamWriter.writeInt(instance.getMonthValue());
        streamWriter.writeInt(instance.getDayOfMonth());
    }
}
