package com.aliyun.vod.jasonparse;

/* loaded from: classes12.dex */
public abstract class JSONSupport {
    public abstract <T> T readListValue(java.lang.String str, java.lang.reflect.Type type) throws java.lang.Exception;

    public abstract <T> T readValue(java.io.File file, java.lang.Class<? extends T> cls) throws java.lang.Exception;

    public abstract <T> T readValue(java.io.InputStream inputStream, java.lang.Class<? extends T> cls) throws java.lang.Exception;

    public abstract <T> T readValue(java.lang.String str, java.lang.Class<? extends T> cls) throws java.lang.Exception;

    public abstract <T> java.lang.String writeValue(T t) throws java.lang.Exception;

    public abstract <T> void writeValue(java.io.File file, T t) throws java.lang.Exception;

    public abstract <T> void writeValue(java.io.OutputStream outputStream, T t) throws java.lang.Exception;
}
