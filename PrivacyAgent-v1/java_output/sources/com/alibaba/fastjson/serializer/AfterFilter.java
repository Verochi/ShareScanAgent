package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public abstract class AfterFilter implements com.alibaba.fastjson.serializer.SerializeFilter {
    private static final java.lang.ThreadLocal<com.alibaba.fastjson.serializer.JSONSerializer> serializerLocal = new java.lang.ThreadLocal<>();
    private static final java.lang.ThreadLocal<java.lang.Character> seperatorLocal = new java.lang.ThreadLocal<>();
    private static final java.lang.Character COMMA = ',';

    public final char writeAfter(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, char c) {
        java.lang.ThreadLocal<com.alibaba.fastjson.serializer.JSONSerializer> threadLocal = serializerLocal;
        threadLocal.set(jSONSerializer);
        java.lang.ThreadLocal<java.lang.Character> threadLocal2 = seperatorLocal;
        threadLocal2.set(java.lang.Character.valueOf(c));
        writeAfter(obj);
        threadLocal.set(null);
        return threadLocal2.get().charValue();
    }

    public abstract void writeAfter(java.lang.Object obj);

    public final void writeKeyValue(java.lang.String str, java.lang.Object obj) {
        com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer = serializerLocal.get();
        java.lang.ThreadLocal<java.lang.Character> threadLocal = seperatorLocal;
        char charValue = threadLocal.get().charValue();
        jSONSerializer.writeKeyValue(charValue, str, obj);
        if (charValue != ',') {
            threadLocal.set(COMMA);
        }
    }
}
