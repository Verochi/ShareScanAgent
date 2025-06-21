package org.apache.commons.codec.binary;

/* loaded from: classes24.dex */
public class StringUtils {
    public static java.lang.IllegalStateException a(java.lang.String str, java.io.UnsupportedEncodingException unsupportedEncodingException) {
        return new java.lang.IllegalStateException(str + ": " + unsupportedEncodingException);
    }

    public static byte[] getBytesIso8859_1(java.lang.String str) {
        return getBytesUnchecked(str, "ISO-8859-1");
    }

    public static byte[] getBytesUnchecked(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (java.io.UnsupportedEncodingException e) {
            throw a(str2, e);
        }
    }

    public static byte[] getBytesUsAscii(java.lang.String str) {
        return getBytesUnchecked(str, "US-ASCII");
    }

    public static byte[] getBytesUtf16(java.lang.String str) {
        return getBytesUnchecked(str, "UTF-16");
    }

    public static byte[] getBytesUtf16Be(java.lang.String str) {
        return getBytesUnchecked(str, org.apache.commons.codec.CharEncoding.UTF_16BE);
    }

    public static byte[] getBytesUtf16Le(java.lang.String str) {
        return getBytesUnchecked(str, "UTF-16LE");
    }

    public static byte[] getBytesUtf8(java.lang.String str) {
        return getBytesUnchecked(str, "UTF-8");
    }

    public static java.lang.String newString(byte[] bArr, java.lang.String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new java.lang.String(bArr, str);
        } catch (java.io.UnsupportedEncodingException e) {
            throw a(str, e);
        }
    }

    public static java.lang.String newStringIso8859_1(byte[] bArr) {
        return newString(bArr, "ISO-8859-1");
    }

    public static java.lang.String newStringUsAscii(byte[] bArr) {
        return newString(bArr, "US-ASCII");
    }

    public static java.lang.String newStringUtf16(byte[] bArr) {
        return newString(bArr, "UTF-16");
    }

    public static java.lang.String newStringUtf16Be(byte[] bArr) {
        return newString(bArr, org.apache.commons.codec.CharEncoding.UTF_16BE);
    }

    public static java.lang.String newStringUtf16Le(byte[] bArr) {
        return newString(bArr, "UTF-16LE");
    }

    public static java.lang.String newStringUtf8(byte[] bArr) {
        return newString(bArr, "UTF-8");
    }
}
