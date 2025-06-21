package com.google.common.net;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class PercentEscaper extends com.google.common.escape.UnicodeEscaper {
    public static final char[] d = {'+'};
    public static final char[] e = "0123456789ABCDEF".toCharArray();
    public final boolean b;
    public final boolean[] c;

    public PercentEscaper(java.lang.String str, boolean z) {
        com.google.common.base.Preconditions.checkNotNull(str);
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new java.lang.IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        java.lang.String str2 = str + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        if (z && str2.contains(" ")) {
            throw new java.lang.IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        this.b = z;
        this.c = b(str2);
    }

    public static boolean[] b(java.lang.String str) {
        char[] charArray = str.toCharArray();
        int i = -1;
        for (char c : charArray) {
            i = java.lang.Math.max((int) c, i);
        }
        boolean[] zArr = new boolean[i + 1];
        for (char c2 : charArray) {
            zArr[c2] = true;
        }
        return zArr;
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public java.lang.String escape(java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(str);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            boolean[] zArr = this.c;
            if (charAt >= zArr.length || !zArr[charAt]) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    public char[] escape(int i) {
        boolean[] zArr = this.c;
        if (i < zArr.length && zArr[i]) {
            return null;
        }
        if (i == 32 && this.b) {
            return d;
        }
        if (i <= 127) {
            char[] cArr = e;
            return new char[]{'%', cArr[i >>> 4], cArr[i & 15]};
        }
        if (i <= 2047) {
            char[] cArr2 = e;
            char[] cArr3 = {'%', cArr2[(r14 >>> 4) | 12], cArr2[r14 & 15], '%', cArr2[(r14 & 3) | 8], cArr2[i & 15]};
            int i2 = i >>> 4;
            int i3 = i2 >>> 2;
            return cArr3;
        }
        if (i <= 65535) {
            char[] cArr4 = e;
            char[] cArr5 = {'%', 'E', cArr4[r14 >>> 2], '%', cArr4[(r14 & 3) | 8], cArr4[r14 & 15], '%', cArr4[(r14 & 3) | 8], cArr4[i & 15]};
            int i4 = i >>> 4;
            int i5 = i4 >>> 2;
            int i6 = i5 >>> 4;
            return cArr5;
        }
        if (i > 1114111) {
            throw new java.lang.IllegalArgumentException("Invalid unicode character value " + i);
        }
        char[] cArr6 = e;
        char[] cArr7 = {'%', 'F', cArr6[(r14 >>> 2) & 7], '%', cArr6[(r14 & 3) | 8], cArr6[r14 & 15], '%', cArr6[(r14 & 3) | 8], cArr6[r14 & 15], '%', cArr6[(r14 & 3) | 8], cArr6[i & 15]};
        int i7 = i >>> 4;
        int i8 = i7 >>> 2;
        int i9 = i8 >>> 4;
        int i10 = i9 >>> 2;
        int i11 = i10 >>> 4;
        return cArr7;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    public int nextEscapeIndex(java.lang.CharSequence charSequence, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(charSequence);
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            boolean[] zArr = this.c;
            if (charAt >= zArr.length || !zArr[charAt]) {
                break;
            }
            i++;
        }
        return i;
    }
}
