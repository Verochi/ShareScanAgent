package okhttp3;

/* loaded from: classes23.dex */
public final class FormBody extends okhttp3.RequestBody {
    public static final okhttp3.MediaType c = okhttp3.MediaType.get(com.anythink.expressad.foundation.g.f.g.b.e);
    public final java.util.List<java.lang.String> a;
    public final java.util.List<java.lang.String> b;

    public static final class Builder {
        public final java.util.List<java.lang.String> a;
        public final java.util.List<java.lang.String> b;

        @javax.annotation.Nullable
        public final java.nio.charset.Charset c;

        public Builder() {
            this(null);
        }

        public Builder(@javax.annotation.Nullable java.nio.charset.Charset charset) {
            this.a = new java.util.ArrayList();
            this.b = new java.util.ArrayList();
            this.c = charset;
        }

        public okhttp3.FormBody.Builder add(java.lang.String str, java.lang.String str2) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new java.lang.NullPointerException("value == null");
            }
            this.a.add(okhttp3.HttpUrl.c(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.c));
            this.b.add(okhttp3.HttpUrl.c(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.c));
            return this;
        }

        public okhttp3.FormBody.Builder addEncoded(java.lang.String str, java.lang.String str2) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new java.lang.NullPointerException("value == null");
            }
            this.a.add(okhttp3.HttpUrl.c(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.c));
            this.b.add(okhttp3.HttpUrl.c(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.c));
            return this;
        }

        public okhttp3.FormBody build() {
            return new okhttp3.FormBody(this.a, this.b);
        }
    }

    public FormBody(java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2) {
        this.a = okhttp3.internal.Util.immutableList(list);
        this.b = okhttp3.internal.Util.immutableList(list2);
    }

    public final long a(@javax.annotation.Nullable okio.BufferedSink bufferedSink, boolean z) {
        okio.Buffer buffer = z ? new okio.Buffer() : bufferedSink.buffer();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.a.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8(this.b.get(i));
        }
        if (!z) {
            return 0L;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return a(null, true);
    }

    @Override // okhttp3.RequestBody
    public okhttp3.MediaType contentType() {
        return c;
    }

    public java.lang.String encodedName(int i) {
        return this.a.get(i);
    }

    public java.lang.String encodedValue(int i) {
        return this.b.get(i);
    }

    public java.lang.String name(int i) {
        return okhttp3.HttpUrl.h(encodedName(i), true);
    }

    public int size() {
        return this.a.size();
    }

    public java.lang.String value(int i) {
        return okhttp3.HttpUrl.h(encodedValue(i), true);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
        a(bufferedSink, false);
    }
}
