package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public interface JSONSerializable {
    void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.reflect.Type type) throws java.io.IOException;
}
