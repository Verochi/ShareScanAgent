package com.google.gson;

/* loaded from: classes22.dex */
public interface JsonDeserializationContext {
    <T> T deserialize(com.google.gson.JsonElement jsonElement, java.lang.reflect.Type type) throws com.google.gson.JsonParseException;
}
