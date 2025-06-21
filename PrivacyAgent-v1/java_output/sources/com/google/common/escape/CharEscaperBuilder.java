package com.google.common.escape;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class CharEscaperBuilder {
    public int b = -1;
    public final java.util.Map<java.lang.Character, java.lang.String> a = new java.util.HashMap();

    public static class CharArrayDecorator extends com.google.common.escape.CharEscaper {
        public final char[][] b;
        public final int c;

        public CharArrayDecorator(char[][] cArr) {
            this.b = cArr;
            this.c = cArr.length;
        }

        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public java.lang.String escape(java.lang.String str) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                char[][] cArr = this.b;
                if (charAt < cArr.length && cArr[charAt] != null) {
                    return escapeSlow(str, i);
                }
            }
            return str;
        }

        @Override // com.google.common.escape.CharEscaper
        public char[] escape(char c) {
            if (c < this.c) {
                return this.b[c];
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public com.google.common.escape.CharEscaperBuilder addEscape(char c, java.lang.String str) {
        this.a.put(java.lang.Character.valueOf(c), com.google.common.base.Preconditions.checkNotNull(str));
        if (c > this.b) {
            this.b = c;
        }
        return this;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public com.google.common.escape.CharEscaperBuilder addEscapes(char[] cArr, java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(str);
        for (char c : cArr) {
            addEscape(c, str);
        }
        return this;
    }

    public char[][] toArray() {
        char[][] cArr = new char[this.b + 1][];
        for (java.util.Map.Entry<java.lang.Character, java.lang.String> entry : this.a.entrySet()) {
            cArr[entry.getKey().charValue()] = entry.getValue().toCharArray();
        }
        return cArr;
    }

    public com.google.common.escape.Escaper toEscaper() {
        return new com.google.common.escape.CharEscaperBuilder.CharArrayDecorator(toArray());
    }
}
