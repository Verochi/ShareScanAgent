package com.google.common.base;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Charsets {

    @com.google.common.annotations.GwtIncompatible
    public static final java.nio.charset.Charset US_ASCII = java.nio.charset.Charset.forName("US-ASCII");
    public static final java.nio.charset.Charset ISO_8859_1 = java.nio.charset.Charset.forName("ISO-8859-1");
    public static final java.nio.charset.Charset UTF_8 = java.nio.charset.Charset.forName("UTF-8");

    @com.google.common.annotations.GwtIncompatible
    public static final java.nio.charset.Charset UTF_16BE = java.nio.charset.Charset.forName(org.apache.commons.codec.CharEncoding.UTF_16BE);

    @com.google.common.annotations.GwtIncompatible
    public static final java.nio.charset.Charset UTF_16LE = java.nio.charset.Charset.forName("UTF-16LE");

    @com.google.common.annotations.GwtIncompatible
    public static final java.nio.charset.Charset UTF_16 = java.nio.charset.Charset.forName("UTF-16");
}
