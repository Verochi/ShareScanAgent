package com.google.common.escape;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ArrayBasedUnicodeEscaper extends com.google.common.escape.UnicodeEscaper {
    public final char[][] b;
    public final int c;
    public final int d;
    public final int e;
    public final char f;
    public final char g;

    public ArrayBasedUnicodeEscaper(com.google.common.escape.ArrayBasedEscaperMap arrayBasedEscaperMap, int i, int i2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(arrayBasedEscaperMap);
        char[][] b = arrayBasedEscaperMap.b();
        this.b = b;
        this.c = b.length;
        if (i2 < i) {
            i2 = -1;
            i = Integer.MAX_VALUE;
        }
        this.d = i;
        this.e = i2;
        if (i >= 55296) {
            this.f = kotlin.jvm.internal.CharCompanionObject.MAX_VALUE;
            this.g = (char) 0;
        } else {
            this.f = (char) i;
            this.g = (char) java.lang.Math.min(i2, 55295);
        }
    }

    public ArrayBasedUnicodeEscaper(java.util.Map<java.lang.Character, java.lang.String> map, int i, int i2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str) {
        this(com.google.common.escape.ArrayBasedEscaperMap.create(map), i, i2, str);
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public final java.lang.String escape(java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(str);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < this.c && this.b[charAt] != null) || charAt > this.g || charAt < this.f) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    public final char[] escape(int i) {
        char[] cArr;
        if (i < this.c && (cArr = this.b[i]) != null) {
            return cArr;
        }
        if (i < this.d || i > this.e) {
            return escapeUnsafe(i);
        }
        return null;
    }

    public abstract char[] escapeUnsafe(int i);

    @Override // com.google.common.escape.UnicodeEscaper
    public final int nextEscapeIndex(java.lang.CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if ((charAt < this.c && this.b[charAt] != null) || charAt > this.g || charAt < this.f) {
                break;
            }
            i++;
        }
        return i;
    }
}
