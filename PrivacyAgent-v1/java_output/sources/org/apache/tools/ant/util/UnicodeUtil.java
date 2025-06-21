package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class UnicodeUtil {
    public static java.lang.StringBuffer EscapeUnicode(char c) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("u0000");
        java.lang.String hexString = java.lang.Integer.toHexString(c);
        for (int i = 0; i < hexString.length(); i++) {
            stringBuffer.setCharAt((stringBuffer.length() - hexString.length()) + i, hexString.charAt(i));
        }
        return stringBuffer;
    }
}
