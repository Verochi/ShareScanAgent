package com.google.common.escape;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class Escapers {
    public static final com.google.common.escape.Escaper a = new com.google.common.escape.Escapers.AnonymousClass1();

    /* renamed from: com.google.common.escape.Escapers$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.google.common.escape.CharEscaper {
        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public java.lang.String escape(java.lang.String str) {
            return (java.lang.String) com.google.common.base.Preconditions.checkNotNull(str);
        }

        @Override // com.google.common.escape.CharEscaper
        public char[] escape(char c) {
            return null;
        }
    }

    /* renamed from: com.google.common.escape.Escapers$2, reason: invalid class name */
    final class AnonymousClass2 extends com.google.common.escape.UnicodeEscaper {
        public final /* synthetic */ com.google.common.escape.CharEscaper b;

        @Override // com.google.common.escape.UnicodeEscaper
        public char[] escape(int i) {
            if (i < 65536) {
                return this.b.escape((char) i);
            }
            char[] cArr = new char[2];
            java.lang.Character.toChars(i, cArr, 0);
            char[] escape = this.b.escape(cArr[0]);
            char[] escape2 = this.b.escape(cArr[1]);
            if (escape == null && escape2 == null) {
                return null;
            }
            int length = escape != null ? escape.length : 1;
            char[] cArr2 = new char[(escape2 != null ? escape2.length : 1) + length];
            if (escape != null) {
                for (int i2 = 0; i2 < escape.length; i2++) {
                    cArr2[i2] = escape[i2];
                }
            } else {
                cArr2[0] = cArr[0];
            }
            if (escape2 != null) {
                for (int i3 = 0; i3 < escape2.length; i3++) {
                    cArr2[length + i3] = escape2[i3];
                }
            } else {
                cArr2[length] = cArr[1];
            }
            return cArr2;
        }
    }

    @com.google.common.annotations.Beta
    public static final class Builder {
        public final java.util.Map<java.lang.Character, java.lang.String> a;
        public char b;
        public char c;
        public java.lang.String d;

        /* renamed from: com.google.common.escape.Escapers$Builder$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.escape.ArrayBasedCharEscaper {
            public final char[] f;

            public AnonymousClass1(java.util.Map map, char c, char c2) {
                super((java.util.Map<java.lang.Character, java.lang.String>) map, c, c2);
                this.f = com.google.common.escape.Escapers.Builder.this.d != null ? com.google.common.escape.Escapers.Builder.this.d.toCharArray() : null;
            }

            @Override // com.google.common.escape.ArrayBasedCharEscaper
            public char[] escapeUnsafe(char c) {
                return this.f;
            }
        }

        public Builder() {
            this.a = new java.util.HashMap();
            this.b = (char) 0;
            this.c = kotlin.jvm.internal.CharCompanionObject.MAX_VALUE;
            this.d = null;
        }

        public /* synthetic */ Builder(com.google.common.escape.Escapers.AnonymousClass1 anonymousClass1) {
            this();
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.escape.Escapers.Builder addEscape(char c, java.lang.String str) {
            com.google.common.base.Preconditions.checkNotNull(str);
            this.a.put(java.lang.Character.valueOf(c), str);
            return this;
        }

        public com.google.common.escape.Escaper build() {
            return new com.google.common.escape.Escapers.Builder.AnonymousClass1(this.a, this.b, this.c);
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.escape.Escapers.Builder setSafeRange(char c, char c2) {
            this.b = c;
            this.c = c2;
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.escape.Escapers.Builder setUnsafeReplacement(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str) {
            this.d = str;
            return this;
        }
    }

    public static java.lang.String a(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new java.lang.String(cArr);
    }

    public static com.google.common.escape.Escapers.Builder builder() {
        return new com.google.common.escape.Escapers.Builder(null);
    }

    public static java.lang.String computeReplacement(com.google.common.escape.CharEscaper charEscaper, char c) {
        return a(charEscaper.escape(c));
    }

    public static java.lang.String computeReplacement(com.google.common.escape.UnicodeEscaper unicodeEscaper, int i) {
        return a(unicodeEscaper.escape(i));
    }

    public static com.google.common.escape.Escaper nullEscaper() {
        return a;
    }
}
