package com.google.common.escape;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ArrayBasedCharEscaper extends com.google.common.escape.CharEscaper {
    public final char[][] b;
    public final int c;
    public final char d;
    public final char e;

    public ArrayBasedCharEscaper(com.google.common.escape.ArrayBasedEscaperMap arrayBasedEscaperMap, char c, char c2) {
        com.google.common.base.Preconditions.checkNotNull(arrayBasedEscaperMap);
        char[][] b = arrayBasedEscaperMap.b();
        this.b = b;
        this.c = b.length;
        if (c2 < c) {
            c2 = 0;
            c = kotlin.jvm.internal.CharCompanionObject.MAX_VALUE;
        }
        this.d = c;
        this.e = c2;
    }

    public ArrayBasedCharEscaper(java.util.Map<java.lang.Character, java.lang.String> map, char c, char c2) {
        this(com.google.common.escape.ArrayBasedEscaperMap.create(map), c, c2);
    }

    @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
    public final java.lang.String escape(java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(str);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < this.c && this.b[charAt] != null) || charAt > this.e || charAt < this.d) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.CharEscaper
    public final char[] escape(char c) {
        char[] cArr;
        if (c < this.c && (cArr = this.b[c]) != null) {
            return cArr;
        }
        if (c < this.d || c > this.e) {
            return escapeUnsafe(c);
        }
        return null;
    }

    public abstract char[] escapeUnsafe(char c);
}
