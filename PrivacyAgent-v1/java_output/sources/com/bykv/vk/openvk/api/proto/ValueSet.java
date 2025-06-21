package com.bykv.vk.openvk.api.proto;

/* loaded from: classes.dex */
public interface ValueSet {

    public interface ValueGetter<T> {
        T get();
    }

    <T> T[] arrayValue(int i, java.lang.Class<T> cls);

    boolean booleanValue(int i);

    boolean booleanValue(int i, boolean z);

    boolean containsKey(int i);

    double doubleValue(int i);

    float floatValue(int i);

    float floatValue(int i, float f);

    int intValue(int i);

    int intValue(int i, int i2);

    boolean isEmpty();

    java.util.Set<java.lang.Integer> keys();

    long longValue(int i);

    long longValue(int i, long j);

    <T> T objectValue(int i, java.lang.Class<T> cls);

    int size();

    java.lang.String stringValue(int i);

    java.lang.String stringValue(int i, java.lang.String str);
}
