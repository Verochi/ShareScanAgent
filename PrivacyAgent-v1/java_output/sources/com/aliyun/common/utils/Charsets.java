package com.aliyun.common.utils;

/* loaded from: classes.dex */
public class Charsets {
    public static final java.nio.charset.Charset ISO_8859_1 = java.nio.charset.Charset.forName("ISO-8859-1");
    public static final java.nio.charset.Charset US_ASCII = java.nio.charset.Charset.forName("US-ASCII");
    public static final java.nio.charset.Charset UTF_16 = java.nio.charset.Charset.forName("UTF-16");
    public static final java.nio.charset.Charset UTF_16BE = java.nio.charset.Charset.forName(org.apache.commons.codec.CharEncoding.UTF_16BE);
    public static final java.nio.charset.Charset UTF_16LE = java.nio.charset.Charset.forName("UTF-16LE");
    public static final java.nio.charset.Charset UTF_8 = java.nio.charset.Charset.forName("UTF-8");

    public static java.nio.charset.Charset toCharset(java.lang.String str) {
        return str == null ? java.nio.charset.Charset.defaultCharset() : java.nio.charset.Charset.forName(str);
    }

    public static java.nio.charset.Charset toCharset(java.nio.charset.Charset charset) {
        return charset == null ? java.nio.charset.Charset.defaultCharset() : charset;
    }
}
