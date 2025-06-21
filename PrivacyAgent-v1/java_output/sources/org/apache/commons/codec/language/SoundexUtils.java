package org.apache.commons.codec.language;

/* loaded from: classes24.dex */
final class SoundexUtils {
    public static java.lang.String a(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (java.lang.Character.isLetter(str.charAt(i2))) {
                cArr[i] = str.charAt(i2);
                i++;
            }
        }
        return i == length ? str.toUpperCase(java.util.Locale.ENGLISH) : new java.lang.String(cArr, 0, i).toUpperCase(java.util.Locale.ENGLISH);
    }

    public static int b(org.apache.commons.codec.StringEncoder stringEncoder, java.lang.String str, java.lang.String str2) throws org.apache.commons.codec.EncoderException {
        return c(stringEncoder.encode(str), stringEncoder.encode(str2));
    }

    public static int c(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        int min = java.lang.Math.min(str.length(), str2.length());
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            if (str.charAt(i2) == str2.charAt(i2)) {
                i++;
            }
        }
        return i;
    }
}
