package com.google.common.io;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public abstract class BaseEncoding {
    public static final com.google.common.io.BaseEncoding a;
    public static final com.google.common.io.BaseEncoding b;
    public static final com.google.common.io.BaseEncoding c;
    public static final com.google.common.io.BaseEncoding d;
    public static final com.google.common.io.BaseEncoding e;

    /* renamed from: com.google.common.io.BaseEncoding$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.io.ByteSink {
        public final /* synthetic */ com.google.common.io.CharSink a;

        public AnonymousClass1(com.google.common.io.CharSink charSink) {
            this.a = charSink;
        }

        @Override // com.google.common.io.ByteSink
        public java.io.OutputStream openStream() throws java.io.IOException {
            return com.google.common.io.BaseEncoding.this.encodingStream(this.a.openStream());
        }
    }

    /* renamed from: com.google.common.io.BaseEncoding$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.io.ByteSource {
        public final /* synthetic */ com.google.common.io.CharSource a;

        public AnonymousClass2(com.google.common.io.CharSource charSource) {
            this.a = charSource;
        }

        @Override // com.google.common.io.ByteSource
        public java.io.InputStream openStream() throws java.io.IOException {
            return com.google.common.io.BaseEncoding.this.decodingStream(this.a.openStream());
        }
    }

    /* renamed from: com.google.common.io.BaseEncoding$3, reason: invalid class name */
    public static class AnonymousClass3 extends java.io.Reader {
        public final /* synthetic */ java.io.Reader n;
        public final /* synthetic */ java.lang.String t;

        public AnonymousClass3(java.io.Reader reader, java.lang.String str) {
            this.n = reader;
            this.t = str;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            this.n.close();
        }

        @Override // java.io.Reader
        public int read() throws java.io.IOException {
            int read;
            do {
                read = this.n.read();
                if (read == -1) {
                    break;
                }
            } while (this.t.indexOf((char) read) >= 0);
            return read;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.common.io.BaseEncoding$4, reason: invalid class name */
    public static class AnonymousClass4 implements java.lang.Appendable {
        public int n;
        public final /* synthetic */ int t;
        public final /* synthetic */ java.lang.Appendable u;
        public final /* synthetic */ java.lang.String v;

        public AnonymousClass4(int i, java.lang.Appendable appendable, java.lang.String str) {
            this.t = i;
            this.u = appendable;
            this.v = str;
            this.n = i;
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(char c) throws java.io.IOException {
            if (this.n == 0) {
                this.u.append(this.v);
                this.n = this.t;
            }
            this.u.append(c);
            this.n--;
            return this;
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.CharSequence charSequence) throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.CharSequence charSequence, int i, int i2) throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.common.io.BaseEncoding$5, reason: invalid class name */
    public static class AnonymousClass5 extends java.io.Writer {
        public final /* synthetic */ java.lang.Appendable n;
        public final /* synthetic */ java.io.Writer t;

        public AnonymousClass5(java.lang.Appendable appendable, java.io.Writer writer) {
            this.n = appendable;
            this.t = writer;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            this.t.close();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws java.io.IOException {
            this.t.flush();
        }

        @Override // java.io.Writer
        public void write(int i) throws java.io.IOException {
            this.n.append((char) i);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public static final class Alphabet {
        public final java.lang.String a;
        public final char[] b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final byte[] g;
        public final boolean[] h;

        public Alphabet(java.lang.String str, char[] cArr) {
            this.a = (java.lang.String) com.google.common.base.Preconditions.checkNotNull(str);
            this.b = (char[]) com.google.common.base.Preconditions.checkNotNull(cArr);
            try {
                int log2 = com.google.common.math.IntMath.log2(cArr.length, java.math.RoundingMode.UNNECESSARY);
                this.d = log2;
                int min = java.lang.Math.min(8, java.lang.Integer.lowestOneBit(log2));
                try {
                    this.e = 8 / min;
                    this.f = log2 / min;
                    this.c = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    java.util.Arrays.fill(bArr, (byte) -1);
                    for (int i = 0; i < cArr.length; i++) {
                        char c = cArr[i];
                        com.google.common.base.Preconditions.checkArgument(c < 128, "Non-ASCII character: %s", c);
                        com.google.common.base.Preconditions.checkArgument(bArr[c] == -1, "Duplicate character: %s", c);
                        bArr[c] = (byte) i;
                    }
                    this.g = bArr;
                    boolean[] zArr = new boolean[this.e];
                    for (int i2 = 0; i2 < this.f; i2++) {
                        zArr[com.google.common.math.IntMath.divide(i2 * 8, this.d, java.math.RoundingMode.CEILING)] = true;
                    }
                    this.h = zArr;
                } catch (java.lang.ArithmeticException e) {
                    throw new java.lang.IllegalArgumentException("Illegal alphabet " + new java.lang.String(cArr), e);
                }
            } catch (java.lang.ArithmeticException e2) {
                throw new java.lang.IllegalArgumentException("Illegal alphabet length " + cArr.length, e2);
            }
        }

        public boolean b(char c) {
            return c <= 127 && this.g[c] != -1;
        }

        public int c(char c) throws com.google.common.io.BaseEncoding.DecodingException {
            if (c > 127) {
                throw new com.google.common.io.BaseEncoding.DecodingException("Unrecognized character: 0x" + java.lang.Integer.toHexString(c));
            }
            byte b = this.g[c];
            if (b != -1) {
                return b;
            }
            if (c <= ' ' || c == 127) {
                throw new com.google.common.io.BaseEncoding.DecodingException("Unrecognized character: 0x" + java.lang.Integer.toHexString(c));
            }
            throw new com.google.common.io.BaseEncoding.DecodingException("Unrecognized character: " + c);
        }

        public char d(int i) {
            return this.b[i];
        }

        public final boolean e() {
            for (char c : this.b) {
                if (com.google.common.base.Ascii.isLowerCase(c)) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.io.BaseEncoding.Alphabet) {
                return java.util.Arrays.equals(this.b, ((com.google.common.io.BaseEncoding.Alphabet) obj).b);
            }
            return false;
        }

        public final boolean f() {
            for (char c : this.b) {
                if (com.google.common.base.Ascii.isUpperCase(c)) {
                    return true;
                }
            }
            return false;
        }

        public boolean g(int i) {
            return this.h[i % this.e];
        }

        public com.google.common.io.BaseEncoding.Alphabet h() {
            if (!f()) {
                return this;
            }
            com.google.common.base.Preconditions.checkState(!e(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.b.length];
            int i = 0;
            while (true) {
                char[] cArr2 = this.b;
                if (i >= cArr2.length) {
                    return new com.google.common.io.BaseEncoding.Alphabet(this.a + ".lowerCase()", cArr);
                }
                cArr[i] = com.google.common.base.Ascii.toLowerCase(cArr2[i]);
                i++;
            }
        }

        public int hashCode() {
            return java.util.Arrays.hashCode(this.b);
        }

        public boolean i(char c) {
            byte[] bArr = this.g;
            return c < bArr.length && bArr[c] != -1;
        }

        public com.google.common.io.BaseEncoding.Alphabet j() {
            if (!e()) {
                return this;
            }
            com.google.common.base.Preconditions.checkState(!f(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.b.length];
            int i = 0;
            while (true) {
                char[] cArr2 = this.b;
                if (i >= cArr2.length) {
                    return new com.google.common.io.BaseEncoding.Alphabet(this.a + ".upperCase()", cArr);
                }
                cArr[i] = com.google.common.base.Ascii.toUpperCase(cArr2[i]);
                i++;
            }
        }

        public java.lang.String toString() {
            return this.a;
        }
    }

    public static final class Base16Encoding extends com.google.common.io.BaseEncoding.StandardBaseEncoding {
        public final char[] j;

        public Base16Encoding(com.google.common.io.BaseEncoding.Alphabet alphabet) {
            super(alphabet, null);
            this.j = new char[512];
            com.google.common.base.Preconditions.checkArgument(alphabet.b.length == 16);
            for (int i = 0; i < 256; i++) {
                this.j[i] = alphabet.d(i >>> 4);
                this.j[i | 256] = alphabet.d(i & 15);
            }
        }

        public Base16Encoding(java.lang.String str, java.lang.String str2) {
            this(new com.google.common.io.BaseEncoding.Alphabet(str, str2.toCharArray()));
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        public int b(byte[] bArr, java.lang.CharSequence charSequence) throws com.google.common.io.BaseEncoding.DecodingException {
            com.google.common.base.Preconditions.checkNotNull(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new com.google.common.io.BaseEncoding.DecodingException("Invalid input length " + charSequence.length());
            }
            int i = 0;
            int i2 = 0;
            while (i < charSequence.length()) {
                bArr[i2] = (byte) ((this.f.c(charSequence.charAt(i)) << 4) | this.f.c(charSequence.charAt(i + 1)));
                i += 2;
                i2++;
            }
            return i2;
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        public void c(java.lang.Appendable appendable, byte[] bArr, int i, int i2) throws java.io.IOException {
            com.google.common.base.Preconditions.checkNotNull(appendable);
            com.google.common.base.Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = bArr[i + i3] & 255;
                appendable.append(this.j[i4]);
                appendable.append(this.j[i4 | 256]);
            }
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        public com.google.common.io.BaseEncoding l(com.google.common.io.BaseEncoding.Alphabet alphabet, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Character ch) {
            return new com.google.common.io.BaseEncoding.Base16Encoding(alphabet);
        }
    }

    public static final class Base64Encoding extends com.google.common.io.BaseEncoding.StandardBaseEncoding {
        public Base64Encoding(com.google.common.io.BaseEncoding.Alphabet alphabet, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Character ch) {
            super(alphabet, ch);
            com.google.common.base.Preconditions.checkArgument(alphabet.b.length == 64);
        }

        public Base64Encoding(java.lang.String str, java.lang.String str2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Character ch) {
            this(new com.google.common.io.BaseEncoding.Alphabet(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        public int b(byte[] bArr, java.lang.CharSequence charSequence) throws com.google.common.io.BaseEncoding.DecodingException {
            com.google.common.base.Preconditions.checkNotNull(bArr);
            java.lang.CharSequence j = j(charSequence);
            if (!this.f.g(j.length())) {
                throw new com.google.common.io.BaseEncoding.DecodingException("Invalid input length " + j.length());
            }
            int i = 0;
            int i2 = 0;
            while (i < j.length()) {
                int i3 = i + 1;
                int i4 = i3 + 1;
                int c = (this.f.c(j.charAt(i)) << 18) | (this.f.c(j.charAt(i3)) << 12);
                int i5 = i2 + 1;
                bArr[i2] = (byte) (c >>> 16);
                if (i4 < j.length()) {
                    int i6 = i4 + 1;
                    int c2 = c | (this.f.c(j.charAt(i4)) << 6);
                    i2 = i5 + 1;
                    bArr[i5] = (byte) ((c2 >>> 8) & 255);
                    if (i6 < j.length()) {
                        i4 = i6 + 1;
                        i5 = i2 + 1;
                        bArr[i2] = (byte) ((c2 | this.f.c(j.charAt(i6))) & 255);
                    } else {
                        i = i6;
                    }
                }
                i2 = i5;
                i = i4;
            }
            return i2;
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        public void c(java.lang.Appendable appendable, byte[] bArr, int i, int i2) throws java.io.IOException {
            com.google.common.base.Preconditions.checkNotNull(appendable);
            int i3 = i + i2;
            com.google.common.base.Preconditions.checkPositionIndexes(i, i3, bArr.length);
            while (i2 >= 3) {
                int i4 = i + 1;
                int i5 = i4 + 1;
                int i6 = ((bArr[i] & 255) << 16) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                appendable.append(this.f.d(i6 >>> 18));
                appendable.append(this.f.d((i6 >>> 12) & 63));
                appendable.append(this.f.d((i6 >>> 6) & 63));
                appendable.append(this.f.d(i6 & 63));
                i2 -= 3;
                i = i5 + 1;
            }
            if (i < i3) {
                k(appendable, bArr, i, i3 - i);
            }
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        public com.google.common.io.BaseEncoding l(com.google.common.io.BaseEncoding.Alphabet alphabet, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Character ch) {
            return new com.google.common.io.BaseEncoding.Base64Encoding(alphabet, ch);
        }
    }

    public static final class DecodingException extends java.io.IOException {
        public DecodingException(java.lang.String str) {
            super(str);
        }

        public DecodingException(java.lang.Throwable th) {
            super(th);
        }
    }

    public static final class SeparatedBaseEncoding extends com.google.common.io.BaseEncoding {
        public final com.google.common.io.BaseEncoding f;
        public final java.lang.String g;
        public final int h;

        public SeparatedBaseEncoding(com.google.common.io.BaseEncoding baseEncoding, java.lang.String str, int i) {
            this.f = (com.google.common.io.BaseEncoding) com.google.common.base.Preconditions.checkNotNull(baseEncoding);
            this.g = (java.lang.String) com.google.common.base.Preconditions.checkNotNull(str);
            this.h = i;
            com.google.common.base.Preconditions.checkArgument(i > 0, "Cannot add a separator after every %s chars", i);
        }

        @Override // com.google.common.io.BaseEncoding
        public int b(byte[] bArr, java.lang.CharSequence charSequence) throws com.google.common.io.BaseEncoding.DecodingException {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(charSequence.length());
            for (int i = 0; i < charSequence.length(); i++) {
                char charAt = charSequence.charAt(i);
                if (this.g.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.f.b(bArr, sb);
        }

        @Override // com.google.common.io.BaseEncoding
        public void c(java.lang.Appendable appendable, byte[] bArr, int i, int i2) throws java.io.IOException {
            this.f.c(com.google.common.io.BaseEncoding.h(appendable, this.g, this.h), bArr, i, i2);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(java.lang.CharSequence charSequence) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (int i = 0; i < charSequence.length(); i++) {
                char charAt = charSequence.charAt(i);
                if (this.g.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.f.canDecode(sb);
        }

        @Override // com.google.common.io.BaseEncoding
        @com.google.common.annotations.GwtIncompatible
        public java.io.InputStream decodingStream(java.io.Reader reader) {
            return this.f.decodingStream(com.google.common.io.BaseEncoding.e(reader, this.g));
        }

        @Override // com.google.common.io.BaseEncoding
        @com.google.common.annotations.GwtIncompatible
        public java.io.OutputStream encodingStream(java.io.Writer writer) {
            return this.f.encodingStream(com.google.common.io.BaseEncoding.i(writer, this.g, this.h));
        }

        @Override // com.google.common.io.BaseEncoding
        public int f(int i) {
            return this.f.f(i);
        }

        @Override // com.google.common.io.BaseEncoding
        public int g(int i) {
            int g = this.f.g(i);
            return g + (this.g.length() * com.google.common.math.IntMath.divide(java.lang.Math.max(0, g - 1), this.h, java.math.RoundingMode.FLOOR));
        }

        @Override // com.google.common.io.BaseEncoding
        public java.lang.CharSequence j(java.lang.CharSequence charSequence) {
            return this.f.j(charSequence);
        }

        @Override // com.google.common.io.BaseEncoding
        public com.google.common.io.BaseEncoding lowerCase() {
            return this.f.lowerCase().withSeparator(this.g, this.h);
        }

        @Override // com.google.common.io.BaseEncoding
        public com.google.common.io.BaseEncoding omitPadding() {
            return this.f.omitPadding().withSeparator(this.g, this.h);
        }

        public java.lang.String toString() {
            return this.f + ".withSeparator(\"" + this.g + "\", " + this.h + ")";
        }

        @Override // com.google.common.io.BaseEncoding
        public com.google.common.io.BaseEncoding upperCase() {
            return this.f.upperCase().withSeparator(this.g, this.h);
        }

        @Override // com.google.common.io.BaseEncoding
        public com.google.common.io.BaseEncoding withPadChar(char c) {
            return this.f.withPadChar(c).withSeparator(this.g, this.h);
        }

        @Override // com.google.common.io.BaseEncoding
        public com.google.common.io.BaseEncoding withSeparator(java.lang.String str, int i) {
            throw new java.lang.UnsupportedOperationException("Already have a separator");
        }
    }

    public static class StandardBaseEncoding extends com.google.common.io.BaseEncoding {
        public final com.google.common.io.BaseEncoding.Alphabet f;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final java.lang.Character g;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public transient com.google.common.io.BaseEncoding h;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public transient com.google.common.io.BaseEncoding i;

        /* renamed from: com.google.common.io.BaseEncoding$StandardBaseEncoding$1, reason: invalid class name */
        public class AnonymousClass1 extends java.io.OutputStream {
            public int n = 0;
            public int t = 0;
            public int u = 0;
            public final /* synthetic */ java.io.Writer v;

            public AnonymousClass1(java.io.Writer writer) {
                this.v = writer;
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                int i = this.t;
                if (i > 0) {
                    int i2 = this.n;
                    com.google.common.io.BaseEncoding.Alphabet alphabet = com.google.common.io.BaseEncoding.StandardBaseEncoding.this.f;
                    this.v.write(alphabet.d((i2 << (alphabet.d - i)) & alphabet.c));
                    this.u++;
                    if (com.google.common.io.BaseEncoding.StandardBaseEncoding.this.g != null) {
                        while (true) {
                            int i3 = this.u;
                            com.google.common.io.BaseEncoding.StandardBaseEncoding standardBaseEncoding = com.google.common.io.BaseEncoding.StandardBaseEncoding.this;
                            if (i3 % standardBaseEncoding.f.e == 0) {
                                break;
                            }
                            this.v.write(standardBaseEncoding.g.charValue());
                            this.u++;
                        }
                    }
                }
                this.v.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws java.io.IOException {
                this.v.flush();
            }

            @Override // java.io.OutputStream
            public void write(int i) throws java.io.IOException {
                this.n = (i & 255) | (this.n << 8);
                this.t += 8;
                while (true) {
                    int i2 = this.t;
                    com.google.common.io.BaseEncoding.Alphabet alphabet = com.google.common.io.BaseEncoding.StandardBaseEncoding.this.f;
                    int i3 = alphabet.d;
                    if (i2 < i3) {
                        return;
                    }
                    this.v.write(alphabet.d((this.n >> (i2 - i3)) & alphabet.c));
                    this.u++;
                    this.t -= com.google.common.io.BaseEncoding.StandardBaseEncoding.this.f.d;
                }
            }
        }

        /* renamed from: com.google.common.io.BaseEncoding$StandardBaseEncoding$2, reason: invalid class name */
        public class AnonymousClass2 extends java.io.InputStream {
            public int n = 0;
            public int t = 0;
            public int u = 0;
            public boolean v = false;
            public final /* synthetic */ java.io.Reader w;

            public AnonymousClass2(java.io.Reader reader) {
                this.w = reader;
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                this.w.close();
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
            
                throw new com.google.common.io.BaseEncoding.DecodingException("Padding cannot start at index " + r4.u);
             */
            @Override // java.io.InputStream
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public int read() throws java.io.IOException {
                int i;
                while (true) {
                    int read = this.w.read();
                    if (read == -1) {
                        if (this.v || com.google.common.io.BaseEncoding.StandardBaseEncoding.this.f.g(this.u)) {
                            return -1;
                        }
                        throw new com.google.common.io.BaseEncoding.DecodingException("Invalid input length " + this.u);
                    }
                    this.u++;
                    char c = (char) read;
                    java.lang.Character ch = com.google.common.io.BaseEncoding.StandardBaseEncoding.this.g;
                    if (ch == null || ch.charValue() != c) {
                        if (this.v) {
                            throw new com.google.common.io.BaseEncoding.DecodingException("Expected padding character but found '" + c + "' at index " + this.u);
                        }
                        int i2 = this.n;
                        com.google.common.io.BaseEncoding.Alphabet alphabet = com.google.common.io.BaseEncoding.StandardBaseEncoding.this.f;
                        int i3 = i2 << alphabet.d;
                        this.n = i3;
                        int c2 = alphabet.c(c) | i3;
                        this.n = c2;
                        int i4 = this.t + com.google.common.io.BaseEncoding.StandardBaseEncoding.this.f.d;
                        this.t = i4;
                        if (i4 >= 8) {
                            int i5 = i4 - 8;
                            this.t = i5;
                            return (c2 >> i5) & 255;
                        }
                    } else if (this.v || ((i = this.u) != 1 && com.google.common.io.BaseEncoding.StandardBaseEncoding.this.f.g(i - 1))) {
                        this.v = true;
                    }
                }
            }
        }

        public StandardBaseEncoding(com.google.common.io.BaseEncoding.Alphabet alphabet, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Character ch) {
            this.f = (com.google.common.io.BaseEncoding.Alphabet) com.google.common.base.Preconditions.checkNotNull(alphabet);
            com.google.common.base.Preconditions.checkArgument(ch == null || !alphabet.i(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.g = ch;
        }

        public StandardBaseEncoding(java.lang.String str, java.lang.String str2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Character ch) {
            this(new com.google.common.io.BaseEncoding.Alphabet(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding
        public int b(byte[] bArr, java.lang.CharSequence charSequence) throws com.google.common.io.BaseEncoding.DecodingException {
            com.google.common.io.BaseEncoding.Alphabet alphabet;
            com.google.common.base.Preconditions.checkNotNull(bArr);
            java.lang.CharSequence j = j(charSequence);
            if (!this.f.g(j.length())) {
                throw new com.google.common.io.BaseEncoding.DecodingException("Invalid input length " + j.length());
            }
            int i = 0;
            int i2 = 0;
            while (i < j.length()) {
                long j2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    alphabet = this.f;
                    if (i3 >= alphabet.e) {
                        break;
                    }
                    j2 <<= alphabet.d;
                    if (i + i3 < j.length()) {
                        j2 |= this.f.c(j.charAt(i4 + i));
                        i4++;
                    }
                    i3++;
                }
                int i5 = alphabet.f;
                int i6 = (i5 * 8) - (i4 * alphabet.d);
                int i7 = (i5 - 1) * 8;
                while (i7 >= i6) {
                    bArr[i2] = (byte) ((j2 >>> i7) & 255);
                    i7 -= 8;
                    i2++;
                }
                i += this.f.e;
            }
            return i2;
        }

        @Override // com.google.common.io.BaseEncoding
        public void c(java.lang.Appendable appendable, byte[] bArr, int i, int i2) throws java.io.IOException {
            com.google.common.base.Preconditions.checkNotNull(appendable);
            com.google.common.base.Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = 0;
            while (i3 < i2) {
                k(appendable, bArr, i + i3, java.lang.Math.min(this.f.f, i2 - i3));
                i3 += this.f.f;
            }
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(java.lang.CharSequence charSequence) {
            com.google.common.base.Preconditions.checkNotNull(charSequence);
            java.lang.CharSequence j = j(charSequence);
            if (!this.f.g(j.length())) {
                return false;
            }
            for (int i = 0; i < j.length(); i++) {
                if (!this.f.b(j.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.BaseEncoding
        @com.google.common.annotations.GwtIncompatible
        public java.io.InputStream decodingStream(java.io.Reader reader) {
            com.google.common.base.Preconditions.checkNotNull(reader);
            return new com.google.common.io.BaseEncoding.StandardBaseEncoding.AnonymousClass2(reader);
        }

        @Override // com.google.common.io.BaseEncoding
        @com.google.common.annotations.GwtIncompatible
        public java.io.OutputStream encodingStream(java.io.Writer writer) {
            com.google.common.base.Preconditions.checkNotNull(writer);
            return new com.google.common.io.BaseEncoding.StandardBaseEncoding.AnonymousClass1(writer);
        }

        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.io.BaseEncoding.StandardBaseEncoding)) {
                return false;
            }
            com.google.common.io.BaseEncoding.StandardBaseEncoding standardBaseEncoding = (com.google.common.io.BaseEncoding.StandardBaseEncoding) obj;
            return this.f.equals(standardBaseEncoding.f) && com.google.common.base.Objects.equal(this.g, standardBaseEncoding.g);
        }

        @Override // com.google.common.io.BaseEncoding
        public int f(int i) {
            return (int) (((this.f.d * i) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        public int g(int i) {
            com.google.common.io.BaseEncoding.Alphabet alphabet = this.f;
            return alphabet.e * com.google.common.math.IntMath.divide(i, alphabet.f, java.math.RoundingMode.CEILING);
        }

        public int hashCode() {
            return this.f.hashCode() ^ com.google.common.base.Objects.hashCode(this.g);
        }

        @Override // com.google.common.io.BaseEncoding
        public java.lang.CharSequence j(java.lang.CharSequence charSequence) {
            com.google.common.base.Preconditions.checkNotNull(charSequence);
            java.lang.Character ch = this.g;
            if (ch == null) {
                return charSequence;
            }
            char charValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == charValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        public void k(java.lang.Appendable appendable, byte[] bArr, int i, int i2) throws java.io.IOException {
            com.google.common.base.Preconditions.checkNotNull(appendable);
            com.google.common.base.Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = 0;
            com.google.common.base.Preconditions.checkArgument(i2 <= this.f.f);
            long j = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                j = (j | (bArr[i + i4] & 255)) << 8;
            }
            int i5 = ((i2 + 1) * 8) - this.f.d;
            while (i3 < i2 * 8) {
                com.google.common.io.BaseEncoding.Alphabet alphabet = this.f;
                appendable.append(alphabet.d(((int) (j >>> (i5 - i3))) & alphabet.c));
                i3 += this.f.d;
            }
            if (this.g != null) {
                while (i3 < this.f.f * 8) {
                    appendable.append(this.g.charValue());
                    i3 += this.f.d;
                }
            }
        }

        public com.google.common.io.BaseEncoding l(com.google.common.io.BaseEncoding.Alphabet alphabet, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Character ch) {
            return new com.google.common.io.BaseEncoding.StandardBaseEncoding(alphabet, ch);
        }

        @Override // com.google.common.io.BaseEncoding
        public com.google.common.io.BaseEncoding lowerCase() {
            com.google.common.io.BaseEncoding baseEncoding = this.i;
            if (baseEncoding == null) {
                com.google.common.io.BaseEncoding.Alphabet h = this.f.h();
                baseEncoding = h == this.f ? this : l(h, this.g);
                this.i = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        public com.google.common.io.BaseEncoding omitPadding() {
            return this.g == null ? this : l(this.f, null);
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("BaseEncoding.");
            sb.append(this.f.toString());
            if (8 % this.f.d != 0) {
                if (this.g == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.g);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        @Override // com.google.common.io.BaseEncoding
        public com.google.common.io.BaseEncoding upperCase() {
            com.google.common.io.BaseEncoding baseEncoding = this.h;
            if (baseEncoding == null) {
                com.google.common.io.BaseEncoding.Alphabet j = this.f.j();
                baseEncoding = j == this.f ? this : l(j, this.g);
                this.h = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        public com.google.common.io.BaseEncoding withPadChar(char c) {
            java.lang.Character ch;
            return (8 % this.f.d == 0 || ((ch = this.g) != null && ch.charValue() == c)) ? this : l(this.f, java.lang.Character.valueOf(c));
        }

        @Override // com.google.common.io.BaseEncoding
        public com.google.common.io.BaseEncoding withSeparator(java.lang.String str, int i) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                com.google.common.base.Preconditions.checkArgument(!this.f.i(str.charAt(i2)), "Separator (%s) cannot contain alphabet characters", str);
            }
            java.lang.Character ch = this.g;
            if (ch != null) {
                com.google.common.base.Preconditions.checkArgument(str.indexOf(ch.charValue()) < 0, "Separator (%s) cannot contain padding character", str);
            }
            return new com.google.common.io.BaseEncoding.SeparatedBaseEncoding(this, str, i);
        }
    }

    static {
        java.lang.Character valueOf = java.lang.Character.valueOf(com.alipay.sdk.m.n.a.h);
        a = new com.google.common.io.BaseEncoding.Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", valueOf);
        b = new com.google.common.io.BaseEncoding.Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", valueOf);
        c = new com.google.common.io.BaseEncoding.StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", valueOf);
        d = new com.google.common.io.BaseEncoding.StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", valueOf);
        e = new com.google.common.io.BaseEncoding.Base16Encoding("base16()", "0123456789ABCDEF");
    }

    public static com.google.common.io.BaseEncoding base16() {
        return e;
    }

    public static com.google.common.io.BaseEncoding base32() {
        return c;
    }

    public static com.google.common.io.BaseEncoding base32Hex() {
        return d;
    }

    public static com.google.common.io.BaseEncoding base64() {
        return a;
    }

    public static com.google.common.io.BaseEncoding base64Url() {
        return b;
    }

    public static byte[] d(byte[] bArr, int i) {
        if (i == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    @com.google.common.annotations.GwtIncompatible
    public static java.io.Reader e(java.io.Reader reader, java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(reader);
        com.google.common.base.Preconditions.checkNotNull(str);
        return new com.google.common.io.BaseEncoding.AnonymousClass3(reader, str);
    }

    public static java.lang.Appendable h(java.lang.Appendable appendable, java.lang.String str, int i) {
        com.google.common.base.Preconditions.checkNotNull(appendable);
        com.google.common.base.Preconditions.checkNotNull(str);
        com.google.common.base.Preconditions.checkArgument(i > 0);
        return new com.google.common.io.BaseEncoding.AnonymousClass4(i, appendable, str);
    }

    @com.google.common.annotations.GwtIncompatible
    public static java.io.Writer i(java.io.Writer writer, java.lang.String str, int i) {
        return new com.google.common.io.BaseEncoding.AnonymousClass5(h(writer, str, i), writer);
    }

    public final byte[] a(java.lang.CharSequence charSequence) throws com.google.common.io.BaseEncoding.DecodingException {
        java.lang.CharSequence j = j(charSequence);
        byte[] bArr = new byte[f(j.length())];
        return d(bArr, b(bArr, j));
    }

    public abstract int b(byte[] bArr, java.lang.CharSequence charSequence) throws com.google.common.io.BaseEncoding.DecodingException;

    public abstract void c(java.lang.Appendable appendable, byte[] bArr, int i, int i2) throws java.io.IOException;

    public abstract boolean canDecode(java.lang.CharSequence charSequence);

    public final byte[] decode(java.lang.CharSequence charSequence) {
        try {
            return a(charSequence);
        } catch (com.google.common.io.BaseEncoding.DecodingException e2) {
            throw new java.lang.IllegalArgumentException(e2);
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public final com.google.common.io.ByteSource decodingSource(com.google.common.io.CharSource charSource) {
        com.google.common.base.Preconditions.checkNotNull(charSource);
        return new com.google.common.io.BaseEncoding.AnonymousClass2(charSource);
    }

    @com.google.common.annotations.GwtIncompatible
    public abstract java.io.InputStream decodingStream(java.io.Reader reader);

    public java.lang.String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public final java.lang.String encode(byte[] bArr, int i, int i2) {
        com.google.common.base.Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(g(i2));
        try {
            c(sb, bArr, i, i2);
            return sb.toString();
        } catch (java.io.IOException e2) {
            throw new java.lang.AssertionError(e2);
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public final com.google.common.io.ByteSink encodingSink(com.google.common.io.CharSink charSink) {
        com.google.common.base.Preconditions.checkNotNull(charSink);
        return new com.google.common.io.BaseEncoding.AnonymousClass1(charSink);
    }

    @com.google.common.annotations.GwtIncompatible
    public abstract java.io.OutputStream encodingStream(java.io.Writer writer);

    public abstract int f(int i);

    public abstract int g(int i);

    public java.lang.CharSequence j(java.lang.CharSequence charSequence) {
        return (java.lang.CharSequence) com.google.common.base.Preconditions.checkNotNull(charSequence);
    }

    public abstract com.google.common.io.BaseEncoding lowerCase();

    public abstract com.google.common.io.BaseEncoding omitPadding();

    public abstract com.google.common.io.BaseEncoding upperCase();

    public abstract com.google.common.io.BaseEncoding withPadChar(char c2);

    public abstract com.google.common.io.BaseEncoding withSeparator(java.lang.String str, int i);
}
