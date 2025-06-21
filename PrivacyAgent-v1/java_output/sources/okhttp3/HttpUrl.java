package okhttp3;

/* loaded from: classes23.dex */
public final class HttpUrl {
    public static final char[] j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final java.lang.String a;
    public final java.lang.String b;
    public final java.lang.String c;
    public final java.lang.String d;
    public final int e;
    public final java.util.List<java.lang.String> f;

    @javax.annotation.Nullable
    public final java.util.List<java.lang.String> g;

    @javax.annotation.Nullable
    public final java.lang.String h;
    public final java.lang.String i;

    public static final class Builder {

        @javax.annotation.Nullable
        public java.lang.String a;

        @javax.annotation.Nullable
        public java.lang.String d;
        public final java.util.List<java.lang.String> f;

        @javax.annotation.Nullable
        public java.util.List<java.lang.String> g;

        @javax.annotation.Nullable
        public java.lang.String h;
        public java.lang.String b = "";
        public java.lang.String c = "";
        public int e = -1;

        public Builder() {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        @javax.annotation.Nullable
        public static java.lang.String b(java.lang.String str, int i, int i2) {
            return okhttp3.internal.Util.canonicalizeHost(okhttp3.HttpUrl.g(str, i, i2, false));
        }

        public static int g(java.lang.String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = java.lang.Integer.parseInt(okhttp3.HttpUrl.a(str, i, i2, "", false, false, false, true, null));
            } catch (java.lang.NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        public static int i(java.lang.String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        public static int n(java.lang.String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public static int o(java.lang.String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        public final okhttp3.HttpUrl.Builder a(java.lang.String str, boolean z) {
            int i = 0;
            do {
                int delimiterOffset = okhttp3.internal.Util.delimiterOffset(str, i, str.length(), "/\\");
                j(str, i, delimiterOffset, delimiterOffset < str.length(), z);
                i = delimiterOffset + 1;
            } while (i <= str.length());
            return this;
        }

        public okhttp3.HttpUrl.Builder addEncodedPathSegment(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedPathSegment == null");
            }
            j(str, 0, str.length(), false, true);
            return this;
        }

        public okhttp3.HttpUrl.Builder addEncodedPathSegments(java.lang.String str) {
            if (str != null) {
                return a(str, true);
            }
            throw new java.lang.NullPointerException("encodedPathSegments == null");
        }

        public okhttp3.HttpUrl.Builder addEncodedQueryParameter(java.lang.String str, @javax.annotation.Nullable java.lang.String str2) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedName == null");
            }
            if (this.g == null) {
                this.g = new java.util.ArrayList();
            }
            this.g.add(okhttp3.HttpUrl.b(str, " \"'<>#&=", true, false, true, true));
            this.g.add(str2 != null ? okhttp3.HttpUrl.b(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        public okhttp3.HttpUrl.Builder addPathSegment(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("pathSegment == null");
            }
            j(str, 0, str.length(), false, false);
            return this;
        }

        public okhttp3.HttpUrl.Builder addPathSegments(java.lang.String str) {
            if (str != null) {
                return a(str, false);
            }
            throw new java.lang.NullPointerException("pathSegments == null");
        }

        public okhttp3.HttpUrl.Builder addQueryParameter(java.lang.String str, @javax.annotation.Nullable java.lang.String str2) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            if (this.g == null) {
                this.g = new java.util.ArrayList();
            }
            this.g.add(okhttp3.HttpUrl.b(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            this.g.add(str2 != null ? okhttp3.HttpUrl.b(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
            return this;
        }

        public okhttp3.HttpUrl build() {
            if (this.a == null) {
                throw new java.lang.IllegalStateException("scheme == null");
            }
            if (this.d != null) {
                return new okhttp3.HttpUrl(this);
            }
            throw new java.lang.IllegalStateException("host == null");
        }

        public int c() {
            int i = this.e;
            return i != -1 ? i : okhttp3.HttpUrl.defaultPort(this.a);
        }

        public final boolean d(java.lang.String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        public final boolean e(java.lang.String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public okhttp3.HttpUrl.Builder encodedFragment(@javax.annotation.Nullable java.lang.String str) {
            this.h = str != null ? okhttp3.HttpUrl.b(str, "", true, false, false, false) : null;
            return this;
        }

        public okhttp3.HttpUrl.Builder encodedPassword(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedPassword == null");
            }
            this.c = okhttp3.HttpUrl.b(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public okhttp3.HttpUrl.Builder encodedPath(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedPath == null");
            }
            if (str.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                m(str, 0, str.length());
                return this;
            }
            throw new java.lang.IllegalArgumentException("unexpected encodedPath: " + str);
        }

        public okhttp3.HttpUrl.Builder encodedQuery(@javax.annotation.Nullable java.lang.String str) {
            this.g = str != null ? okhttp3.HttpUrl.l(okhttp3.HttpUrl.b(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public okhttp3.HttpUrl.Builder encodedUsername(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedUsername == null");
            }
            this.b = okhttp3.HttpUrl.b(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public okhttp3.HttpUrl.Builder f(@javax.annotation.Nullable okhttp3.HttpUrl httpUrl, java.lang.String str) {
            int delimiterOffset;
            int i;
            int skipLeadingAsciiWhitespace = okhttp3.internal.Util.skipLeadingAsciiWhitespace(str, 0, str.length());
            int skipTrailingAsciiWhitespace = okhttp3.internal.Util.skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, str.length());
            int n = n(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            if (n != -1) {
                if (str.regionMatches(true, skipLeadingAsciiWhitespace, "https:", 0, 6)) {
                    this.a = "https";
                    skipLeadingAsciiWhitespace += 6;
                } else {
                    if (!str.regionMatches(true, skipLeadingAsciiWhitespace, "http:", 0, 5)) {
                        throw new java.lang.IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, n) + "'");
                    }
                    this.a = com.alipay.sdk.m.l.a.q;
                    skipLeadingAsciiWhitespace += 5;
                }
            } else {
                if (httpUrl == null) {
                    throw new java.lang.IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.a = httpUrl.a;
            }
            int o = o(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            char c = '?';
            char c2 = '#';
            if (o >= 2 || httpUrl == null || !httpUrl.a.equals(this.a)) {
                int i2 = skipLeadingAsciiWhitespace + o;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    delimiterOffset = okhttp3.internal.Util.delimiterOffset(str, i2, skipTrailingAsciiWhitespace, "@/\\?#");
                    char charAt = delimiterOffset != skipTrailingAsciiWhitespace ? str.charAt(delimiterOffset) : (char) 65535;
                    if (charAt == 65535 || charAt == c2 || charAt == '/' || charAt == '\\' || charAt == c) {
                        break;
                    }
                    if (charAt == '@') {
                        if (z) {
                            i = delimiterOffset;
                            this.c += "%40" + okhttp3.HttpUrl.a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int delimiterOffset2 = okhttp3.internal.Util.delimiterOffset(str, i2, delimiterOffset, ':');
                            i = delimiterOffset;
                            java.lang.String a = okhttp3.HttpUrl.a(str, i2, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                a = this.b + "%40" + a;
                            }
                            this.b = a;
                            if (delimiterOffset2 != i) {
                                this.c = okhttp3.HttpUrl.a(str, delimiterOffset2 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        }
                        i2 = i + 1;
                    }
                    c = '?';
                    c2 = '#';
                }
                int i3 = i(str, i2, delimiterOffset);
                int i4 = i3 + 1;
                if (i4 < delimiterOffset) {
                    this.d = b(str, i2, i3);
                    int g = g(str, i4, delimiterOffset);
                    this.e = g;
                    if (g == -1) {
                        throw new java.lang.IllegalArgumentException("Invalid URL port: \"" + str.substring(i4, delimiterOffset) + kotlin.text.Typography.quote);
                    }
                } else {
                    this.d = b(str, i2, i3);
                    this.e = okhttp3.HttpUrl.defaultPort(this.a);
                }
                if (this.d == null) {
                    throw new java.lang.IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, i3) + kotlin.text.Typography.quote);
                }
                skipLeadingAsciiWhitespace = delimiterOffset;
            } else {
                this.b = httpUrl.encodedUsername();
                this.c = httpUrl.encodedPassword();
                this.d = httpUrl.d;
                this.e = httpUrl.e;
                this.f.clear();
                this.f.addAll(httpUrl.encodedPathSegments());
                if (skipLeadingAsciiWhitespace == skipTrailingAsciiWhitespace || str.charAt(skipLeadingAsciiWhitespace) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
            }
            int delimiterOffset3 = okhttp3.internal.Util.delimiterOffset(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace, "?#");
            m(str, skipLeadingAsciiWhitespace, delimiterOffset3);
            if (delimiterOffset3 < skipTrailingAsciiWhitespace && str.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = okhttp3.internal.Util.delimiterOffset(str, delimiterOffset3, skipTrailingAsciiWhitespace, '#');
                this.g = okhttp3.HttpUrl.l(okhttp3.HttpUrl.a(str, delimiterOffset3 + 1, delimiterOffset4, " \"'<>#", true, false, true, true, null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < skipTrailingAsciiWhitespace && str.charAt(delimiterOffset3) == '#') {
                this.h = okhttp3.HttpUrl.a(str, 1 + delimiterOffset3, skipTrailingAsciiWhitespace, "", true, false, false, false, null);
            }
            return this;
        }

        public okhttp3.HttpUrl.Builder fragment(@javax.annotation.Nullable java.lang.String str) {
            this.h = str != null ? okhttp3.HttpUrl.b(str, "", false, false, false, false) : null;
            return this;
        }

        public final void h() {
            if (!this.f.remove(r0.size() - 1).isEmpty() || this.f.isEmpty()) {
                this.f.add("");
            } else {
                this.f.set(r0.size() - 1, "");
            }
        }

        public okhttp3.HttpUrl.Builder host(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("host == null");
            }
            java.lang.String b = b(str, 0, str.length());
            if (b != null) {
                this.d = b;
                return this;
            }
            throw new java.lang.IllegalArgumentException("unexpected host: " + str);
        }

        public final void j(java.lang.String str, int i, int i2, boolean z, boolean z2) {
            java.lang.String a = okhttp3.HttpUrl.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (d(a)) {
                return;
            }
            if (e(a)) {
                h();
                return;
            }
            if (this.f.get(r11.size() - 1).isEmpty()) {
                this.f.set(r11.size() - 1, a);
            } else {
                this.f.add(a);
            }
            if (z) {
                this.f.add("");
            }
        }

        public okhttp3.HttpUrl.Builder k() {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.set(i, okhttp3.HttpUrl.b(this.f.get(i), "[]", true, true, false, true));
            }
            java.util.List<java.lang.String> list = this.g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    java.lang.String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, okhttp3.HttpUrl.b(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            java.lang.String str2 = this.h;
            if (str2 != null) {
                this.h = okhttp3.HttpUrl.b(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public final void l(java.lang.String str) {
            for (int size = this.g.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.g.get(size))) {
                    this.g.remove(size + 1);
                    this.g.remove(size);
                    if (this.g.isEmpty()) {
                        this.g = null;
                        return;
                    }
                }
            }
        }

        public final void m(java.lang.String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '\\') {
                this.f.clear();
                this.f.add("");
                i++;
            } else {
                java.util.List<java.lang.String> list = this.f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = okhttp3.internal.Util.delimiterOffset(str, i3, i2, "/\\");
                boolean z = i < i2;
                j(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        public okhttp3.HttpUrl.Builder password(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("password == null");
            }
            this.c = okhttp3.HttpUrl.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public okhttp3.HttpUrl.Builder port(int i) {
            if (i > 0 && i <= 65535) {
                this.e = i;
                return this;
            }
            throw new java.lang.IllegalArgumentException("unexpected port: " + i);
        }

        public okhttp3.HttpUrl.Builder query(@javax.annotation.Nullable java.lang.String str) {
            this.g = str != null ? okhttp3.HttpUrl.l(okhttp3.HttpUrl.b(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public okhttp3.HttpUrl.Builder removeAllEncodedQueryParameters(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedName == null");
            }
            if (this.g == null) {
                return this;
            }
            l(okhttp3.HttpUrl.b(str, " \"'<>#&=", true, false, true, true));
            return this;
        }

        public okhttp3.HttpUrl.Builder removeAllQueryParameters(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            if (this.g == null) {
                return this;
            }
            l(okhttp3.HttpUrl.b(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            return this;
        }

        public okhttp3.HttpUrl.Builder removePathSegment(int i) {
            this.f.remove(i);
            if (this.f.isEmpty()) {
                this.f.add("");
            }
            return this;
        }

        public okhttp3.HttpUrl.Builder scheme(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase(com.alipay.sdk.m.l.a.q)) {
                this.a = com.alipay.sdk.m.l.a.q;
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new java.lang.IllegalArgumentException("unexpected scheme: " + str);
                }
                this.a = "https";
            }
            return this;
        }

        public okhttp3.HttpUrl.Builder setEncodedPathSegment(int i, java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedPathSegment == null");
            }
            java.lang.String a = okhttp3.HttpUrl.a(str, 0, str.length(), " \"<>^`{}|/\\?#", true, false, false, true, null);
            this.f.set(i, a);
            if (!d(a) && !e(a)) {
                return this;
            }
            throw new java.lang.IllegalArgumentException("unexpected path segment: " + str);
        }

        public okhttp3.HttpUrl.Builder setEncodedQueryParameter(java.lang.String str, @javax.annotation.Nullable java.lang.String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public okhttp3.HttpUrl.Builder setPathSegment(int i, java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("pathSegment == null");
            }
            java.lang.String a = okhttp3.HttpUrl.a(str, 0, str.length(), " \"<>^`{}|/\\?#", false, false, false, true, null);
            if (!d(a) && !e(a)) {
                this.f.set(i, a);
                return this;
            }
            throw new java.lang.IllegalArgumentException("unexpected path segment: " + str);
        }

        public okhttp3.HttpUrl.Builder setQueryParameter(java.lang.String str, @javax.annotation.Nullable java.lang.String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String str = this.a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.b);
                if (!this.c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.c);
                }
                sb.append('@');
            }
            java.lang.String str2 = this.d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.d);
                    sb.append(']');
                } else {
                    sb.append(this.d);
                }
            }
            if (this.e != -1 || this.a != null) {
                int c = c();
                java.lang.String str3 = this.a;
                if (str3 == null || c != okhttp3.HttpUrl.defaultPort(str3)) {
                    sb.append(':');
                    sb.append(c);
                }
            }
            okhttp3.HttpUrl.f(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                okhttp3.HttpUrl.e(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        public okhttp3.HttpUrl.Builder username(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("username == null");
            }
            this.b = okhttp3.HttpUrl.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }
    }

    public HttpUrl(okhttp3.HttpUrl.Builder builder) {
        this.a = builder.a;
        this.b = h(builder.b, false);
        this.c = h(builder.c, false);
        this.d = builder.d;
        this.e = builder.c();
        this.f = i(builder.f, false);
        java.util.List<java.lang.String> list = builder.g;
        this.g = list != null ? i(list, true) : null;
        java.lang.String str = builder.h;
        this.h = str != null ? h(str, false) : null;
        this.i = builder.toString();
    }

    public static java.lang.String a(java.lang.String str, int i, int i2, java.lang.String str2, boolean z, boolean z2, boolean z3, boolean z4, @javax.annotation.Nullable java.nio.charset.Charset charset) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || k(str, i3, i2)))) && (codePointAt != 43 || !z3))) {
                    i3 += java.lang.Character.charCount(codePointAt);
                }
            }
            okio.Buffer buffer = new okio.Buffer();
            buffer.writeUtf8(str, i, i3);
            d(buffer, str, i3, i2, str2, z, z2, z3, z4, charset);
            return buffer.readUtf8();
        }
        return str.substring(i, i2);
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }

    public static java.lang.String c(java.lang.String str, java.lang.String str2, boolean z, boolean z2, boolean z3, boolean z4, @javax.annotation.Nullable java.nio.charset.Charset charset) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    public static void d(okio.Buffer buffer, java.lang.String str, int i, int i2, java.lang.String str2, boolean z, boolean z2, boolean z3, boolean z4, @javax.annotation.Nullable java.nio.charset.Charset charset) {
        okio.Buffer buffer2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    buffer.writeUtf8(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !k(str, i, i2)))))) {
                    if (buffer2 == null) {
                        buffer2 = new okio.Buffer();
                    }
                    if (charset == null || charset.equals(java.nio.charset.StandardCharsets.UTF_8)) {
                        buffer2.writeUtf8CodePoint(codePointAt);
                    } else {
                        buffer2.writeString(str, i, java.lang.Character.charCount(codePointAt) + i, charset);
                    }
                    while (!buffer2.exhausted()) {
                        int readByte = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        char[] cArr = j;
                        buffer.writeByte((int) cArr[(readByte >> 4) & 15]);
                        buffer.writeByte((int) cArr[readByte & 15]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(codePointAt);
                }
            }
            i += java.lang.Character.charCount(codePointAt);
        }
    }

    public static int defaultPort(java.lang.String str) {
        if (str.equals(com.alipay.sdk.m.l.a.q)) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static void e(java.lang.StringBuilder sb, java.util.List<java.lang.String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            java.lang.String str = list.get(i);
            java.lang.String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(kotlin.text.Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(com.alipay.sdk.m.n.a.h);
                sb.append(str2);
            }
        }
    }

    public static void f(java.lang.StringBuilder sb, java.util.List<java.lang.String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public static java.lang.String g(java.lang.String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                okio.Buffer buffer = new okio.Buffer();
                buffer.writeUtf8(str, i, i3);
                j(buffer, str, i3, i2, z);
                return buffer.readUtf8();
            }
        }
        return str.substring(i, i2);
    }

    public static okhttp3.HttpUrl get(java.lang.String str) {
        return new okhttp3.HttpUrl.Builder().f(null, str).build();
    }

    @javax.annotation.Nullable
    public static okhttp3.HttpUrl get(java.net.URI uri) {
        return parse(uri.toString());
    }

    @javax.annotation.Nullable
    public static okhttp3.HttpUrl get(java.net.URL url) {
        return parse(url.toString());
    }

    public static java.lang.String h(java.lang.String str, boolean z) {
        return g(str, 0, str.length(), z);
    }

    public static void j(okio.Buffer buffer, java.lang.String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt != 37 || (i3 = i + 2) >= i2) {
                if (codePointAt == 43 && z) {
                    buffer.writeByte(32);
                }
                buffer.writeUtf8CodePoint(codePointAt);
            } else {
                int decodeHexDigit = okhttp3.internal.Util.decodeHexDigit(str.charAt(i + 1));
                int decodeHexDigit2 = okhttp3.internal.Util.decodeHexDigit(str.charAt(i3));
                if (decodeHexDigit != -1 && decodeHexDigit2 != -1) {
                    buffer.writeByte((decodeHexDigit << 4) + decodeHexDigit2);
                    i = i3;
                }
                buffer.writeUtf8CodePoint(codePointAt);
            }
            i += java.lang.Character.charCount(codePointAt);
        }
    }

    public static boolean k(java.lang.String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && okhttp3.internal.Util.decodeHexDigit(str.charAt(i + 1)) != -1 && okhttp3.internal.Util.decodeHexDigit(str.charAt(i3)) != -1;
    }

    public static java.util.List<java.lang.String> l(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    @javax.annotation.Nullable
    public static okhttp3.HttpUrl parse(java.lang.String str) {
        try {
            return get(str);
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    @javax.annotation.Nullable
    public java.lang.String encodedFragment() {
        if (this.h == null) {
            return null;
        }
        return this.i.substring(this.i.indexOf(35) + 1);
    }

    public java.lang.String encodedPassword() {
        if (this.c.isEmpty()) {
            return "";
        }
        return this.i.substring(this.i.indexOf(58, this.a.length() + 3) + 1, this.i.indexOf(64));
    }

    public java.lang.String encodedPath() {
        int indexOf = this.i.indexOf(47, this.a.length() + 3);
        java.lang.String str = this.i;
        return this.i.substring(indexOf, okhttp3.internal.Util.delimiterOffset(str, indexOf, str.length(), "?#"));
    }

    public java.util.List<java.lang.String> encodedPathSegments() {
        int indexOf = this.i.indexOf(47, this.a.length() + 3);
        java.lang.String str = this.i;
        int delimiterOffset = okhttp3.internal.Util.delimiterOffset(str, indexOf, str.length(), "?#");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (indexOf < delimiterOffset) {
            int i = indexOf + 1;
            int delimiterOffset2 = okhttp3.internal.Util.delimiterOffset(this.i, i, delimiterOffset, '/');
            arrayList.add(this.i.substring(i, delimiterOffset2));
            indexOf = delimiterOffset2;
        }
        return arrayList;
    }

    @javax.annotation.Nullable
    public java.lang.String encodedQuery() {
        if (this.g == null) {
            return null;
        }
        int indexOf = this.i.indexOf(63) + 1;
        java.lang.String str = this.i;
        return this.i.substring(indexOf, okhttp3.internal.Util.delimiterOffset(str, indexOf, str.length(), '#'));
    }

    public java.lang.String encodedUsername() {
        if (this.b.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        java.lang.String str = this.i;
        return this.i.substring(length, okhttp3.internal.Util.delimiterOffset(str, length, str.length(), ":@"));
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        return (obj instanceof okhttp3.HttpUrl) && ((okhttp3.HttpUrl) obj).i.equals(this.i);
    }

    @javax.annotation.Nullable
    public java.lang.String fragment() {
        return this.h;
    }

    public int hashCode() {
        return this.i.hashCode();
    }

    public java.lang.String host() {
        return this.d;
    }

    public final java.util.List<java.lang.String> i(java.util.List<java.lang.String> list, boolean z) {
        int size = list.size();
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        for (int i = 0; i < size; i++) {
            java.lang.String str = list.get(i);
            arrayList.add(str != null ? h(str, z) : null);
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public boolean isHttps() {
        return this.a.equals("https");
    }

    public okhttp3.HttpUrl.Builder newBuilder() {
        okhttp3.HttpUrl.Builder builder = new okhttp3.HttpUrl.Builder();
        builder.a = this.a;
        builder.b = encodedUsername();
        builder.c = encodedPassword();
        builder.d = this.d;
        builder.e = this.e != defaultPort(this.a) ? this.e : -1;
        builder.f.clear();
        builder.f.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.h = encodedFragment();
        return builder;
    }

    @javax.annotation.Nullable
    public okhttp3.HttpUrl.Builder newBuilder(java.lang.String str) {
        try {
            return new okhttp3.HttpUrl.Builder().f(this, str);
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    public java.lang.String password() {
        return this.c;
    }

    public java.util.List<java.lang.String> pathSegments() {
        return this.f;
    }

    public int pathSize() {
        return this.f.size();
    }

    public int port() {
        return this.e;
    }

    @javax.annotation.Nullable
    public java.lang.String query() {
        if (this.g == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        e(sb, this.g);
        return sb.toString();
    }

    @javax.annotation.Nullable
    public java.lang.String queryParameter(java.lang.String str) {
        java.util.List<java.lang.String> list = this.g;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.g.get(i))) {
                return this.g.get(i + 1);
            }
        }
        return null;
    }

    public java.lang.String queryParameterName(int i) {
        java.util.List<java.lang.String> list = this.g;
        if (list != null) {
            return list.get(i * 2);
        }
        throw new java.lang.IndexOutOfBoundsException();
    }

    public java.util.Set<java.lang.String> queryParameterNames() {
        if (this.g == null) {
            return java.util.Collections.emptySet();
        }
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        int size = this.g.size();
        for (int i = 0; i < size; i += 2) {
            linkedHashSet.add(this.g.get(i));
        }
        return java.util.Collections.unmodifiableSet(linkedHashSet);
    }

    public java.lang.String queryParameterValue(int i) {
        java.util.List<java.lang.String> list = this.g;
        if (list != null) {
            return list.get((i * 2) + 1);
        }
        throw new java.lang.IndexOutOfBoundsException();
    }

    public java.util.List<java.lang.String> queryParameterValues(java.lang.String str) {
        if (this.g == null) {
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int size = this.g.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.g.get(i))) {
                arrayList.add(this.g.get(i + 1));
            }
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public int querySize() {
        java.util.List<java.lang.String> list = this.g;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public java.lang.String redact() {
        return newBuilder("/...").username("").password("").build().toString();
    }

    @javax.annotation.Nullable
    public okhttp3.HttpUrl resolve(java.lang.String str) {
        okhttp3.HttpUrl.Builder newBuilder = newBuilder(str);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public java.lang.String scheme() {
        return this.a;
    }

    public java.lang.String toString() {
        return this.i;
    }

    @javax.annotation.Nullable
    public java.lang.String topPrivateDomain() {
        if (okhttp3.internal.Util.verifyAsIpAddress(this.d)) {
            return null;
        }
        return okhttp3.internal.publicsuffix.PublicSuffixDatabase.get().getEffectiveTldPlusOne(this.d);
    }

    public java.net.URI uri() {
        java.lang.String builder = newBuilder().k().toString();
        try {
            return new java.net.URI(builder);
        } catch (java.net.URISyntaxException e) {
            try {
                return java.net.URI.create(builder.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (java.lang.Exception unused) {
                throw new java.lang.RuntimeException(e);
            }
        }
    }

    public java.net.URL url() {
        try {
            return new java.net.URL(this.i);
        } catch (java.net.MalformedURLException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public java.lang.String username() {
        return this.b;
    }
}
