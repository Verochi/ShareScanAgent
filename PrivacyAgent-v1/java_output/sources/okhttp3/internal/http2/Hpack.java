package okhttp3.internal.http2;

/* loaded from: classes24.dex */
final class Hpack {
    public static final okhttp3.internal.http2.Header[] a;
    public static final java.util.Map<okio.ByteString, java.lang.Integer> b;

    public static final class Reader {
        public final java.util.List<okhttp3.internal.http2.Header> a;
        public final okio.BufferedSource b;
        public final int c;
        public int d;
        public okhttp3.internal.http2.Header[] e;
        public int f;
        public int g;
        public int h;

        public Reader(int i, int i2, okio.Source source) {
            this.a = new java.util.ArrayList();
            this.e = new okhttp3.internal.http2.Header[8];
            this.f = r0.length - 1;
            this.g = 0;
            this.h = 0;
            this.c = i;
            this.d = i2;
            this.b = okio.Okio.buffer(source);
        }

        public Reader(int i, okio.Source source) {
            this(i, i, source);
        }

        public final void a() {
            int i = this.d;
            int i2 = this.h;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    d(i2 - i);
                }
            }
        }

        public final void b() {
            java.util.Arrays.fill(this.e, (java.lang.Object) null);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
        }

        public final int c(int i) {
            return this.f + 1 + i;
        }

        public final int d(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.e.length;
                while (true) {
                    length--;
                    i2 = this.f;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.e[length].a;
                    i -= i4;
                    this.h -= i4;
                    this.g--;
                    i3++;
                }
                okhttp3.internal.http2.Header[] headerArr = this.e;
                java.lang.System.arraycopy(headerArr, i2 + 1, headerArr, i2 + 1 + i3, this.g);
                this.f += i3;
            }
            return i3;
        }

        public java.util.List<okhttp3.internal.http2.Header> e() {
            java.util.ArrayList arrayList = new java.util.ArrayList(this.a);
            this.a.clear();
            return arrayList;
        }

        public final okio.ByteString f(int i) throws java.io.IOException {
            if (h(i)) {
                return okhttp3.internal.http2.Hpack.a[i].name;
            }
            int c = c(i - okhttp3.internal.http2.Hpack.a.length);
            if (c >= 0) {
                okhttp3.internal.http2.Header[] headerArr = this.e;
                if (c < headerArr.length) {
                    return headerArr[c].name;
                }
            }
            throw new java.io.IOException("Header index too large " + (i + 1));
        }

        public final void g(int i, okhttp3.internal.http2.Header header) {
            this.a.add(header);
            int i2 = header.a;
            if (i != -1) {
                i2 -= this.e[c(i)].a;
            }
            int i3 = this.d;
            if (i2 > i3) {
                b();
                return;
            }
            int d = d((this.h + i2) - i3);
            if (i == -1) {
                int i4 = this.g + 1;
                okhttp3.internal.http2.Header[] headerArr = this.e;
                if (i4 > headerArr.length) {
                    okhttp3.internal.http2.Header[] headerArr2 = new okhttp3.internal.http2.Header[headerArr.length * 2];
                    java.lang.System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.f = this.e.length - 1;
                    this.e = headerArr2;
                }
                int i5 = this.f;
                this.f = i5 - 1;
                this.e[i5] = header;
                this.g++;
            } else {
                this.e[i + c(i) + d] = header;
            }
            this.h += i2;
        }

        public final boolean h(int i) {
            return i >= 0 && i <= okhttp3.internal.http2.Hpack.a.length - 1;
        }

        public final int i() throws java.io.IOException {
            return this.b.readByte() & 255;
        }

        public okio.ByteString j() throws java.io.IOException {
            int i = i();
            boolean z = (i & 128) == 128;
            int m = m(i, 127);
            return z ? okio.ByteString.of(okhttp3.internal.http2.Huffman.f().c(this.b.readByteArray(m))) : this.b.readByteString(m);
        }

        public void k() throws java.io.IOException {
            while (!this.b.exhausted()) {
                int readByte = this.b.readByte() & 255;
                if (readByte == 128) {
                    throw new java.io.IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    l(m(readByte, 127) - 1);
                } else if (readByte == 64) {
                    o();
                } else if ((readByte & 64) == 64) {
                    n(m(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int m = m(readByte, 31);
                    this.d = m;
                    if (m < 0 || m > this.c) {
                        throw new java.io.IOException("Invalid dynamic table size update " + this.d);
                    }
                    a();
                } else if (readByte == 16 || readByte == 0) {
                    q();
                } else {
                    p(m(readByte, 15) - 1);
                }
            }
        }

        public final void l(int i) throws java.io.IOException {
            if (h(i)) {
                this.a.add(okhttp3.internal.http2.Hpack.a[i]);
                return;
            }
            int c = c(i - okhttp3.internal.http2.Hpack.a.length);
            if (c >= 0) {
                okhttp3.internal.http2.Header[] headerArr = this.e;
                if (c < headerArr.length) {
                    this.a.add(headerArr[c]);
                    return;
                }
            }
            throw new java.io.IOException("Header index too large " + (i + 1));
        }

        public int m(int i, int i2) throws java.io.IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = i();
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & 127) << i4;
                i4 += 7;
            }
        }

        public final void n(int i) throws java.io.IOException {
            g(-1, new okhttp3.internal.http2.Header(f(i), j()));
        }

        public final void o() throws java.io.IOException {
            g(-1, new okhttp3.internal.http2.Header(okhttp3.internal.http2.Hpack.a(j()), j()));
        }

        public final void p(int i) throws java.io.IOException {
            this.a.add(new okhttp3.internal.http2.Header(f(i), j()));
        }

        public final void q() throws java.io.IOException {
            this.a.add(new okhttp3.internal.http2.Header(okhttp3.internal.http2.Hpack.a(j()), j()));
        }
    }

    public static final class Writer {
        public final okio.Buffer a;
        public final boolean b;
        public int c;
        public boolean d;
        public int e;
        public int f;
        public okhttp3.internal.http2.Header[] g;
        public int h;
        public int i;
        public int j;

        public Writer(int i, boolean z, okio.Buffer buffer) {
            this.c = Integer.MAX_VALUE;
            this.g = new okhttp3.internal.http2.Header[8];
            this.h = r0.length - 1;
            this.i = 0;
            this.j = 0;
            this.e = i;
            this.f = i;
            this.b = z;
            this.a = buffer;
        }

        public Writer(okio.Buffer buffer) {
            this(4096, true, buffer);
        }

        public final void a() {
            int i = this.f;
            int i2 = this.j;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    c(i2 - i);
                }
            }
        }

        public final void b() {
            java.util.Arrays.fill(this.g, (java.lang.Object) null);
            this.h = this.g.length - 1;
            this.i = 0;
            this.j = 0;
        }

        public final int c(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.g.length;
                while (true) {
                    length--;
                    i2 = this.h;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.g[length].a;
                    i -= i4;
                    this.j -= i4;
                    this.i--;
                    i3++;
                }
                okhttp3.internal.http2.Header[] headerArr = this.g;
                java.lang.System.arraycopy(headerArr, i2 + 1, headerArr, i2 + 1 + i3, this.i);
                okhttp3.internal.http2.Header[] headerArr2 = this.g;
                int i5 = this.h;
                java.util.Arrays.fill(headerArr2, i5 + 1, i5 + 1 + i3, (java.lang.Object) null);
                this.h += i3;
            }
            return i3;
        }

        public final void d(okhttp3.internal.http2.Header header) {
            int i = header.a;
            int i2 = this.f;
            if (i > i2) {
                b();
                return;
            }
            c((this.j + i) - i2);
            int i3 = this.i + 1;
            okhttp3.internal.http2.Header[] headerArr = this.g;
            if (i3 > headerArr.length) {
                okhttp3.internal.http2.Header[] headerArr2 = new okhttp3.internal.http2.Header[headerArr.length * 2];
                java.lang.System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.h = this.g.length - 1;
                this.g = headerArr2;
            }
            int i4 = this.h;
            this.h = i4 - 1;
            this.g[i4] = header;
            this.i++;
            this.j += i;
        }

        public void e(int i) {
            this.e = i;
            int min = java.lang.Math.min(i, 16384);
            int i2 = this.f;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.c = java.lang.Math.min(this.c, min);
            }
            this.d = true;
            this.f = min;
            a();
        }

        public void f(okio.ByteString byteString) throws java.io.IOException {
            if (!this.b || okhttp3.internal.http2.Huffman.f().e(byteString) >= byteString.size()) {
                h(byteString.size(), 127, 0);
                this.a.write(byteString);
                return;
            }
            okio.Buffer buffer = new okio.Buffer();
            okhttp3.internal.http2.Huffman.f().d(byteString, buffer);
            okio.ByteString readByteString = buffer.readByteString();
            h(readByteString.size(), 127, 128);
            this.a.write(readByteString);
        }

        public void g(java.util.List<okhttp3.internal.http2.Header> list) throws java.io.IOException {
            int i;
            int i2;
            if (this.d) {
                int i3 = this.c;
                if (i3 < this.f) {
                    h(i3, 31, 32);
                }
                this.d = false;
                this.c = Integer.MAX_VALUE;
                h(this.f, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                okhttp3.internal.http2.Header header = list.get(i4);
                okio.ByteString asciiLowercase = header.name.toAsciiLowercase();
                okio.ByteString byteString = header.value;
                java.lang.Integer num = okhttp3.internal.http2.Hpack.b.get(asciiLowercase);
                if (num != null) {
                    i = num.intValue() + 1;
                    if (i > 1 && i < 8) {
                        okhttp3.internal.http2.Header[] headerArr = okhttp3.internal.http2.Hpack.a;
                        if (java.util.Objects.equals(headerArr[i - 1].value, byteString)) {
                            i2 = i;
                        } else if (java.util.Objects.equals(headerArr[i].value, byteString)) {
                            i2 = i;
                            i++;
                        }
                    }
                    i2 = i;
                    i = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                if (i == -1) {
                    int i5 = this.h + 1;
                    int length = this.g.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (java.util.Objects.equals(this.g[i5].name, asciiLowercase)) {
                            if (java.util.Objects.equals(this.g[i5].value, byteString)) {
                                i = okhttp3.internal.http2.Hpack.a.length + (i5 - this.h);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i5 - this.h) + okhttp3.internal.http2.Hpack.a.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i != -1) {
                    h(i, 127, 128);
                } else if (i2 == -1) {
                    this.a.writeByte(64);
                    f(asciiLowercase);
                    f(byteString);
                    d(header);
                } else if (!asciiLowercase.startsWith(okhttp3.internal.http2.Header.PSEUDO_PREFIX) || okhttp3.internal.http2.Header.TARGET_AUTHORITY.equals(asciiLowercase)) {
                    h(i2, 63, 64);
                    f(byteString);
                    d(header);
                } else {
                    h(i2, 15, 0);
                    f(byteString);
                }
            }
        }

        public void h(int i, int i2, int i3) {
            if (i < i2) {
                this.a.writeByte(i | i3);
                return;
            }
            this.a.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.a.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.a.writeByte(i4);
        }
    }

    static {
        okio.ByteString byteString = okhttp3.internal.http2.Header.TARGET_METHOD;
        okio.ByteString byteString2 = okhttp3.internal.http2.Header.TARGET_PATH;
        okio.ByteString byteString3 = okhttp3.internal.http2.Header.TARGET_SCHEME;
        okio.ByteString byteString4 = okhttp3.internal.http2.Header.RESPONSE_STATUS;
        a = new okhttp3.internal.http2.Header[]{new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.TARGET_AUTHORITY, ""), new okhttp3.internal.http2.Header(byteString, "GET"), new okhttp3.internal.http2.Header(byteString, "POST"), new okhttp3.internal.http2.Header(byteString2, net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR), new okhttp3.internal.http2.Header(byteString2, "/index.html"), new okhttp3.internal.http2.Header(byteString3, com.alipay.sdk.m.l.a.q), new okhttp3.internal.http2.Header(byteString3, "https"), new okhttp3.internal.http2.Header(byteString4, com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE), new okhttp3.internal.http2.Header(byteString4, "204"), new okhttp3.internal.http2.Header(byteString4, "206"), new okhttp3.internal.http2.Header(byteString4, "304"), new okhttp3.internal.http2.Header(byteString4, "400"), new okhttp3.internal.http2.Header(byteString4, com.baidu.mobads.sdk.internal.ck.b), new okhttp3.internal.http2.Header(byteString4, "500"), new okhttp3.internal.http2.Header("accept-charset", ""), new okhttp3.internal.http2.Header("accept-encoding", "gzip, deflate"), new okhttp3.internal.http2.Header("accept-language", ""), new okhttp3.internal.http2.Header("accept-ranges", ""), new okhttp3.internal.http2.Header("accept", ""), new okhttp3.internal.http2.Header("access-control-allow-origin", ""), new okhttp3.internal.http2.Header(com.anythink.core.api.ATCustomRuleKeys.AGE, ""), new okhttp3.internal.http2.Header("allow", ""), new okhttp3.internal.http2.Header("authorization", ""), new okhttp3.internal.http2.Header(com.ss.android.socialbase.downloader.constants.SpJsonConstants.CACHE_CONTROL, ""), new okhttp3.internal.http2.Header("content-disposition", ""), new okhttp3.internal.http2.Header("content-encoding", ""), new okhttp3.internal.http2.Header("content-language", ""), new okhttp3.internal.http2.Header("content-length", ""), new okhttp3.internal.http2.Header("content-location", ""), new okhttp3.internal.http2.Header("content-range", ""), new okhttp3.internal.http2.Header(com.alipay.sdk.m.p.e.f, ""), new okhttp3.internal.http2.Header("cookie", ""), new okhttp3.internal.http2.Header("date", ""), new okhttp3.internal.http2.Header(com.liulishuo.filedownloader.model.FileDownloadModel.ETAG, ""), new okhttp3.internal.http2.Header("expect", ""), new okhttp3.internal.http2.Header("expires", ""), new okhttp3.internal.http2.Header("from", ""), new okhttp3.internal.http2.Header(com.alipay.sdk.m.l.c.f, ""), new okhttp3.internal.http2.Header("if-match", ""), new okhttp3.internal.http2.Header(com.ss.android.socialbase.downloader.utils.DownloadUtils.IF_MODIFIED_SINCE, ""), new okhttp3.internal.http2.Header("if-none-match", ""), new okhttp3.internal.http2.Header("if-range", ""), new okhttp3.internal.http2.Header("if-unmodified-since", ""), new okhttp3.internal.http2.Header("last-modified", ""), new okhttp3.internal.http2.Header(com.sensorsdata.sf.ui.view.UIProperty.type_link, ""), new okhttp3.internal.http2.Header(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION, ""), new okhttp3.internal.http2.Header("max-forwards", ""), new okhttp3.internal.http2.Header("proxy-authenticate", ""), new okhttp3.internal.http2.Header("proxy-authorization", ""), new okhttp3.internal.http2.Header("range", ""), new okhttp3.internal.http2.Header(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_REFERER, ""), new okhttp3.internal.http2.Header(com.alipay.sdk.m.x.d.w, ""), new okhttp3.internal.http2.Header("retry-after", ""), new okhttp3.internal.http2.Header("server", ""), new okhttp3.internal.http2.Header("set-cookie", ""), new okhttp3.internal.http2.Header("strict-transport-security", ""), new okhttp3.internal.http2.Header("transfer-encoding", ""), new okhttp3.internal.http2.Header("user-agent", ""), new okhttp3.internal.http2.Header("vary", ""), new okhttp3.internal.http2.Header("via", ""), new okhttp3.internal.http2.Header("www-authenticate", "")};
        b = b();
    }

    public static okio.ByteString a(okio.ByteString byteString) throws java.io.IOException {
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b2 = byteString.getByte(i);
            if (b2 >= 65 && b2 <= 90) {
                throw new java.io.IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    public static java.util.Map<okio.ByteString, java.lang.Integer> b() {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(a.length);
        int i = 0;
        while (true) {
            okhttp3.internal.http2.Header[] headerArr = a;
            if (i >= headerArr.length) {
                return java.util.Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i].name)) {
                linkedHashMap.put(headerArr[i].name, java.lang.Integer.valueOf(i));
            }
            i++;
        }
    }
}
