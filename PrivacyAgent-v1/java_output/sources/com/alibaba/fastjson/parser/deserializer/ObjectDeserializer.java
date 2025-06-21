package com.alibaba.fastjson.parser.deserializer;

/* loaded from: classes.dex */
public interface ObjectDeserializer {
    <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj);
}
