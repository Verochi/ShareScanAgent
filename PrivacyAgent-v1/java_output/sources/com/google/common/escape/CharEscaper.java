package com.google.common.escape;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class CharEscaper extends com.google.common.escape.Escaper {
    public static char[] a(char[] cArr, int i, int i2) {
        if (i2 < 0) {
            throw new java.lang.AssertionError("Cannot increase internal buffer any further");
        }
        char[] cArr2 = new char[i2];
        if (i > 0) {
            java.lang.System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }

    @Override // com.google.common.escape.Escaper
    public java.lang.String escape(java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(str);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (escape(str.charAt(i)) != null) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    public abstract char[] escape(char c);

    public final java.lang.String escapeSlow(java.lang.String str, int i) {
        int length = str.length();
        char[] a = com.google.common.escape.Platform.a();
        int length2 = a.length;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            char[] escape = escape(str.charAt(i));
            if (escape != null) {
                int length3 = escape.length;
                int i4 = i - i2;
                int i5 = i3 + i4;
                int i6 = i5 + length3;
                if (length2 < i6) {
                    length2 = ((length - i) * 2) + i6;
                    a = a(a, i3, length2);
                }
                if (i4 > 0) {
                    str.getChars(i2, i, a, i3);
                    i3 = i5;
                }
                if (length3 > 0) {
                    java.lang.System.arraycopy(escape, 0, a, i3, length3);
                    i3 += length3;
                }
                i2 = i + 1;
            }
            i++;
        }
        int i7 = length - i2;
        if (i7 > 0) {
            int i8 = i7 + i3;
            if (length2 < i8) {
                a = a(a, i3, i8);
            }
            str.getChars(i2, length, a, i3);
            i3 = i8;
        }
        return new java.lang.String(a, 0, i3);
    }
}
