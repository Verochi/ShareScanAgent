package com.google.gson;

/* loaded from: classes22.dex */
public interface JsonDeserializer<T> {
    T deserialize(com.google.gson.JsonElement jsonElement, java.lang.reflect.Type type, com.google.gson.JsonDeserializationContext jsonDeserializationContext) throws com.google.gson.JsonParseException;
}
