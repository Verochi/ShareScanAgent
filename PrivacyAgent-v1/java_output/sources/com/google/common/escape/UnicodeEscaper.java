package com.google.common.escape;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class UnicodeEscaper extends com.google.common.escape.Escaper {
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

    public static int codePointAt(java.lang.CharSequence charSequence, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(charSequence);
        if (i >= i2) {
            throw new java.lang.IndexOutOfBoundsException("Index exceeds specified range");
        }
        int i3 = i + 1;
        char charAt = charSequence.charAt(i);
        if (charAt < 55296 || charAt > 57343) {
            return charAt;
        }
        if (charAt > 56319) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Unexpected low surrogate character '");
            sb.append(charAt);
            sb.append("' with value ");
            sb.append((int) charAt);
            sb.append(" at index ");
            sb.append(i3 - 1);
            sb.append(" in '");
            sb.append((java.lang.Object) charSequence);
            sb.append("'");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }
        if (i3 == i2) {
            return -charAt;
        }
        char charAt2 = charSequence.charAt(i3);
        if (java.lang.Character.isLowSurrogate(charAt2)) {
            return java.lang.Character.toCodePoint(charAt, charAt2);
        }
        throw new java.lang.IllegalArgumentException("Expected low surrogate but got char '" + charAt2 + "' with value " + ((int) charAt2) + " at index " + i3 + " in '" + ((java.lang.Object) charSequence) + "'");
    }

    @Override // com.google.common.escape.Escaper
    public java.lang.String escape(java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(str);
        int length = str.length();
        int nextEscapeIndex = nextEscapeIndex(str, 0, length);
        return nextEscapeIndex == length ? str : escapeSlow(str, nextEscapeIndex);
    }

    public abstract char[] escape(int i);

    public final java.lang.String escapeSlow(java.lang.String str, int i) {
        int length = str.length();
        char[] a = com.google.common.escape.Platform.a();
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int codePointAt = codePointAt(str, i, length);
            if (codePointAt < 0) {
                throw new java.lang.IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] escape = escape(codePointAt);
            int i4 = (java.lang.Character.isSupplementaryCodePoint(codePointAt) ? 2 : 1) + i;
            if (escape != null) {
                int i5 = i - i2;
                int i6 = i3 + i5;
                int length2 = escape.length + i6;
                if (a.length < length2) {
                    a = a(a, i3, length2 + (length - i) + 32);
                }
                if (i5 > 0) {
                    str.getChars(i2, i, a, i3);
                    i3 = i6;
                }
                if (escape.length > 0) {
                    java.lang.System.arraycopy(escape, 0, a, i3, escape.length);
                    i3 += escape.length;
                }
                i2 = i4;
            }
            i = nextEscapeIndex(str, i4, length);
        }
        int i7 = length - i2;
        if (i7 > 0) {
            int i8 = i7 + i3;
            if (a.length < i8) {
                a = a(a, i3, i8);
            }
            str.getChars(i2, length, a, i3);
            i3 = i8;
        }
        return new java.lang.String(a, 0, i3);
    }

    public int nextEscapeIndex(java.lang.CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            int codePointAt = codePointAt(charSequence, i, i2);
            if (codePointAt < 0 || escape(codePointAt) != null) {
                break;
            }
            i += java.lang.Character.isSupplementaryCodePoint(codePointAt) ? 2 : 1;
        }
        return i;
    }
}
