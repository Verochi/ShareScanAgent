package com.airbnb.lottie.parser.moshi;

/* loaded from: classes.dex */
public abstract class JsonReader implements java.io.Closeable {
    public static final java.lang.String[] y = new java.lang.String[128];
    public int n;
    public int[] t = new int[32];
    public java.lang.String[] u = new java.lang.String[32];
    public int[] v = new int[32];
    public boolean w;
    public boolean x;

    public static final class Options {
        public final java.lang.String[] a;
        public final okio.Options b;

        public Options(java.lang.String[] strArr, okio.Options options) {
            this.a = strArr;
            this.b = options;
        }

        public static com.airbnb.lottie.parser.moshi.JsonReader.Options of(java.lang.String... strArr) {
            try {
                okio.ByteString[] byteStringArr = new okio.ByteString[strArr.length];
                okio.Buffer buffer = new okio.Buffer();
                for (int i = 0; i < strArr.length; i++) {
                    com.airbnb.lottie.parser.moshi.JsonReader.c(buffer, strArr[i]);
                    buffer.readByte();
                    byteStringArr[i] = buffer.readByteString();
                }
                return new com.airbnb.lottie.parser.moshi.JsonReader.Options((java.lang.String[]) strArr.clone(), okio.Options.of(byteStringArr));
            } catch (java.io.IOException e) {
                throw new java.lang.AssertionError(e);
            }
        }
    }

    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i = 0; i <= 31; i++) {
            y[i] = java.lang.String.format("\\u%04x", java.lang.Integer.valueOf(i));
        }
        java.lang.String[] strArr = y;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(okio.BufferedSink bufferedSink, java.lang.String str) throws java.io.IOException {
        int i;
        java.lang.String str2;
        java.lang.String[] strArr = y;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    bufferedSink.writeUtf8(str, i2, i);
                }
                bufferedSink.writeUtf8(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                bufferedSink.writeUtf8(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            bufferedSink.writeUtf8(str, i2, length);
        }
        bufferedSink.writeByte(34);
    }

    public static com.airbnb.lottie.parser.moshi.JsonReader of(okio.BufferedSource bufferedSource) {
        return new com.airbnb.lottie.parser.moshi.JsonUtf8Reader(bufferedSource);
    }

    public final void b(int i) {
        int i2 = this.n;
        int[] iArr = this.t;
        if (i2 == iArr.length) {
            if (i2 == 256) {
                throw new com.airbnb.lottie.parser.moshi.JsonDataException("Nesting too deep at " + getPath());
            }
            this.t = java.util.Arrays.copyOf(iArr, iArr.length * 2);
            java.lang.String[] strArr = this.u;
            this.u = (java.lang.String[]) java.util.Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.v;
            this.v = java.util.Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.t;
        int i3 = this.n;
        this.n = i3 + 1;
        iArr3[i3] = i;
    }

    public abstract void beginArray() throws java.io.IOException;

    public abstract void beginObject() throws java.io.IOException;

    public final com.airbnb.lottie.parser.moshi.JsonEncodingException d(java.lang.String str) throws com.airbnb.lottie.parser.moshi.JsonEncodingException {
        throw new com.airbnb.lottie.parser.moshi.JsonEncodingException(str + " at path " + getPath());
    }

    public abstract void endArray() throws java.io.IOException;

    public abstract void endObject() throws java.io.IOException;

    public final java.lang.String getPath() {
        return com.airbnb.lottie.parser.moshi.JsonScope.a(this.n, this.t, this.u, this.v);
    }

    public abstract boolean hasNext() throws java.io.IOException;

    public abstract boolean nextBoolean() throws java.io.IOException;

    public abstract double nextDouble() throws java.io.IOException;

    public abstract int nextInt() throws java.io.IOException;

    public abstract java.lang.String nextName() throws java.io.IOException;

    public abstract java.lang.String nextString() throws java.io.IOException;

    public abstract com.airbnb.lottie.parser.moshi.JsonReader.Token peek() throws java.io.IOException;

    public abstract int selectName(com.airbnb.lottie.parser.moshi.JsonReader.Options options) throws java.io.IOException;

    public abstract void skipName() throws java.io.IOException;

    public abstract void skipValue() throws java.io.IOException;
}
