package okhttp3;

/* loaded from: classes23.dex */
public final class Cookie {
    public static final java.util.regex.Pattern j = java.util.regex.Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final java.util.regex.Pattern k = java.util.regex.Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final java.util.regex.Pattern l = java.util.regex.Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final java.util.regex.Pattern m = java.util.regex.Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    public final java.lang.String a;
    public final java.lang.String b;
    public final long c;
    public final java.lang.String d;
    public final java.lang.String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public static final class Builder {

        @javax.annotation.Nullable
        public java.lang.String a;

        @javax.annotation.Nullable
        public java.lang.String b;

        @javax.annotation.Nullable
        public java.lang.String d;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public long c = okhttp3.internal.http.HttpDate.MAX_DATE;
        public java.lang.String e = net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;

        public final okhttp3.Cookie.Builder a(java.lang.String str, boolean z) {
            if (str == null) {
                throw new java.lang.NullPointerException("domain == null");
            }
            java.lang.String canonicalizeHost = okhttp3.internal.Util.canonicalizeHost(str);
            if (canonicalizeHost != null) {
                this.d = canonicalizeHost;
                this.i = z;
                return this;
            }
            throw new java.lang.IllegalArgumentException("unexpected domain: " + str);
        }

        public okhttp3.Cookie build() {
            return new okhttp3.Cookie(this);
        }

        public okhttp3.Cookie.Builder domain(java.lang.String str) {
            return a(str, false);
        }

        public okhttp3.Cookie.Builder expiresAt(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > okhttp3.internal.http.HttpDate.MAX_DATE) {
                j = 253402300799999L;
            }
            this.c = j;
            this.h = true;
            return this;
        }

        public okhttp3.Cookie.Builder hostOnlyDomain(java.lang.String str) {
            return a(str, true);
        }

        public okhttp3.Cookie.Builder httpOnly() {
            this.g = true;
            return this;
        }

        public okhttp3.Cookie.Builder name(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            if (!str.trim().equals(str)) {
                throw new java.lang.IllegalArgumentException("name is not trimmed");
            }
            this.a = str;
            return this;
        }

        public okhttp3.Cookie.Builder path(java.lang.String str) {
            if (!str.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                throw new java.lang.IllegalArgumentException("path must start with '/'");
            }
            this.e = str;
            return this;
        }

        public okhttp3.Cookie.Builder secure() {
            this.f = true;
            return this;
        }

        public okhttp3.Cookie.Builder value(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("value == null");
            }
            if (!str.trim().equals(str)) {
                throw new java.lang.IllegalArgumentException("value is not trimmed");
            }
            this.b = str;
            return this;
        }
    }

    public Cookie(java.lang.String str, java.lang.String str2, long j2, java.lang.String str3, java.lang.String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = str;
        this.b = str2;
        this.c = j2;
        this.d = str3;
        this.e = str4;
        this.f = z;
        this.g = z2;
        this.i = z3;
        this.h = z4;
    }

    public Cookie(okhttp3.Cookie.Builder builder) {
        java.lang.String str = builder.a;
        if (str == null) {
            throw new java.lang.NullPointerException("builder.name == null");
        }
        java.lang.String str2 = builder.b;
        if (str2 == null) {
            throw new java.lang.NullPointerException("builder.value == null");
        }
        java.lang.String str3 = builder.d;
        if (str3 == null) {
            throw new java.lang.NullPointerException("builder.domain == null");
        }
        this.a = str;
        this.b = str2;
        this.c = builder.c;
        this.d = str3;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
    }

    public static int a(java.lang.String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static boolean b(java.lang.String str, java.lang.String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !okhttp3.internal.Util.verifyAsIpAddress(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f0  */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static okhttp3.Cookie c(long j2, okhttp3.HttpUrl httpUrl, java.lang.String str) {
        long j3;
        java.lang.String host;
        okhttp3.Cookie cookie;
        java.lang.String str2;
        java.lang.String str3;
        int lastIndexOf;
        java.lang.String str4;
        int length = str.length();
        char c = ';';
        int delimiterOffset = okhttp3.internal.Util.delimiterOffset(str, 0, length, ';');
        char c2 = com.alipay.sdk.m.n.a.h;
        int delimiterOffset2 = okhttp3.internal.Util.delimiterOffset(str, 0, delimiterOffset, com.alipay.sdk.m.n.a.h);
        if (delimiterOffset2 == delimiterOffset) {
            return null;
        }
        java.lang.String trimSubstring = okhttp3.internal.Util.trimSubstring(str, 0, delimiterOffset2);
        if (trimSubstring.isEmpty() || okhttp3.internal.Util.indexOfControlOrNonAscii(trimSubstring) != -1) {
            return null;
        }
        java.lang.String trimSubstring2 = okhttp3.internal.Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset);
        if (okhttp3.internal.Util.indexOfControlOrNonAscii(trimSubstring2) != -1) {
            return null;
        }
        int i = delimiterOffset + 1;
        java.lang.String str5 = null;
        java.lang.String str6 = null;
        long j4 = -1;
        long j5 = 253402300799999L;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        while (i < length) {
            int delimiterOffset3 = okhttp3.internal.Util.delimiterOffset(str, i, length, c);
            int delimiterOffset4 = okhttp3.internal.Util.delimiterOffset(str, i, delimiterOffset3, c2);
            java.lang.String trimSubstring3 = okhttp3.internal.Util.trimSubstring(str, i, delimiterOffset4);
            java.lang.String trimSubstring4 = delimiterOffset4 < delimiterOffset3 ? okhttp3.internal.Util.trimSubstring(str, delimiterOffset4 + 1, delimiterOffset3) : "";
            if (trimSubstring3.equalsIgnoreCase("expires")) {
                try {
                    j5 = e(trimSubstring4, 0, trimSubstring4.length());
                } catch (java.lang.NumberFormatException | java.lang.IllegalArgumentException unused) {
                }
            } else if (trimSubstring3.equalsIgnoreCase("max-age")) {
                j4 = f(trimSubstring4);
            } else {
                if (trimSubstring3.equalsIgnoreCase("domain")) {
                    str6 = d(trimSubstring4);
                    z3 = false;
                } else if (trimSubstring3.equalsIgnoreCase("path")) {
                    str5 = trimSubstring4;
                } else if (trimSubstring3.equalsIgnoreCase("secure")) {
                    z = true;
                } else if (trimSubstring3.equalsIgnoreCase("httponly")) {
                    z2 = true;
                }
                i = delimiterOffset3 + 1;
                c = ';';
                c2 = com.alipay.sdk.m.n.a.h;
            }
            z4 = true;
            i = delimiterOffset3 + 1;
            c = ';';
            c2 = com.alipay.sdk.m.n.a.h;
        }
        long j6 = Long.MIN_VALUE;
        if (j4 != Long.MIN_VALUE) {
            if (j4 != -1) {
                j6 = j2 + (j4 <= 9223372036854775L ? j4 * 1000 : Long.MAX_VALUE);
                if (j6 < j2 || j6 > okhttp3.internal.http.HttpDate.MAX_DATE) {
                    j3 = 253402300799999L;
                }
            } else {
                j3 = j5;
            }
            host = httpUrl.host();
            if (str6 != null) {
                str2 = host;
                cookie = null;
            } else {
                if (!b(host, str6)) {
                    return null;
                }
                cookie = null;
                str2 = str6;
            }
            if (host.length() == str2.length() && okhttp3.internal.publicsuffix.PublicSuffixDatabase.get().getEffectiveTldPlusOne(str2) == null) {
                return cookie;
            }
            str3 = net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
            if (str5 == null && str5.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                str4 = str5;
            } else {
                java.lang.String encodedPath = httpUrl.encodedPath();
                lastIndexOf = encodedPath.lastIndexOf(47);
                if (lastIndexOf != 0) {
                    str3 = encodedPath.substring(0, lastIndexOf);
                }
                str4 = str3;
            }
            return new okhttp3.Cookie(trimSubstring, trimSubstring2, j3, str2, str4, z, z2, z3, z4);
        }
        j3 = j6;
        host = httpUrl.host();
        if (str6 != null) {
        }
        if (host.length() == str2.length()) {
        }
        str3 = net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        if (str5 == null) {
        }
        java.lang.String encodedPath2 = httpUrl.encodedPath();
        lastIndexOf = encodedPath2.lastIndexOf(47);
        if (lastIndexOf != 0) {
        }
        str4 = str3;
        return new okhttp3.Cookie(trimSubstring, trimSubstring2, j3, str2, str4, z, z2, z3, z4);
    }

    public static java.lang.String d(java.lang.String str) {
        if (str.endsWith(".")) {
            throw new java.lang.IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        java.lang.String canonicalizeHost = okhttp3.internal.Util.canonicalizeHost(str);
        if (canonicalizeHost != null) {
            return canonicalizeHost;
        }
        throw new java.lang.IllegalArgumentException();
    }

    public static long e(java.lang.String str, int i, int i2) {
        int a = a(str, i, i2, false);
        java.util.regex.Matcher matcher = m.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (a < i2) {
            int a2 = a(str, a + 1, i2, true);
            matcher.region(a, a2);
            if (i4 == -1 && matcher.usePattern(m).matches()) {
                i4 = java.lang.Integer.parseInt(matcher.group(1));
                i7 = java.lang.Integer.parseInt(matcher.group(2));
                i8 = java.lang.Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(l).matches()) {
                i5 = java.lang.Integer.parseInt(matcher.group(1));
            } else {
                if (i6 == -1) {
                    java.util.regex.Pattern pattern = k;
                    if (matcher.usePattern(pattern).matches()) {
                        i6 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(java.util.Locale.US)) / 4;
                    }
                }
                if (i3 == -1 && matcher.usePattern(j).matches()) {
                    i3 = java.lang.Integer.parseInt(matcher.group(1));
                }
            }
            a = a(str, a2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i6 == -1) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i5 < 1 || i5 > 31) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i4 < 0 || i4 > 23) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i7 < 0 || i7 > 59) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i8 < 0 || i8 > 59) {
            throw new java.lang.IllegalArgumentException();
        }
        java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar(okhttp3.internal.Util.UTC);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i3);
        gregorianCalendar.set(2, i6 - 1);
        gregorianCalendar.set(5, i5);
        gregorianCalendar.set(11, i4);
        gregorianCalendar.set(12, i7);
        gregorianCalendar.set(13, i8);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    public static long f(java.lang.String str) {
        try {
            long parseLong = java.lang.Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (java.lang.NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER) ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    public static boolean g(okhttp3.HttpUrl httpUrl, java.lang.String str) {
        java.lang.String encodedPath = httpUrl.encodedPath();
        if (encodedPath.equals(str)) {
            return true;
        }
        if (encodedPath.startsWith(str)) {
            return str.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) || encodedPath.charAt(str.length()) == '/';
        }
        return false;
    }

    @javax.annotation.Nullable
    public static okhttp3.Cookie parse(okhttp3.HttpUrl httpUrl, java.lang.String str) {
        return c(java.lang.System.currentTimeMillis(), httpUrl, str);
    }

    public static java.util.List<okhttp3.Cookie> parseAll(okhttp3.HttpUrl httpUrl, okhttp3.Headers headers) {
        java.util.List<java.lang.String> values = headers.values(com.google.common.net.HttpHeaders.SET_COOKIE);
        int size = values.size();
        java.util.ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            okhttp3.Cookie parse = parse(httpUrl, values.get(i));
            if (parse != null) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList();
                }
                arrayList.add(parse);
            }
        }
        return arrayList != null ? java.util.Collections.unmodifiableList(arrayList) : java.util.Collections.emptyList();
    }

    public java.lang.String domain() {
        return this.d;
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (!(obj instanceof okhttp3.Cookie)) {
            return false;
        }
        okhttp3.Cookie cookie = (okhttp3.Cookie) obj;
        return cookie.a.equals(this.a) && cookie.b.equals(this.b) && cookie.d.equals(this.d) && cookie.e.equals(this.e) && cookie.c == this.c && cookie.f == this.f && cookie.g == this.g && cookie.h == this.h && cookie.i == this.i;
    }

    public long expiresAt() {
        return this.c;
    }

    public java.lang.String h(boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.a);
        sb.append(com.alipay.sdk.m.n.a.h);
        sb.append(this.b);
        if (this.h) {
            if (this.c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(okhttp3.internal.http.HttpDate.format(new java.util.Date(this.c)));
            }
        }
        if (!this.i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.d);
        }
        sb.append("; path=");
        sb.append(this.e);
        if (this.f) {
            sb.append("; secure");
        }
        if (this.g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public int hashCode() {
        int hashCode = (((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        long j2 = this.c;
        return ((((((((hashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (!this.f ? 1 : 0)) * 31) + (!this.g ? 1 : 0)) * 31) + (!this.h ? 1 : 0)) * 31) + (!this.i ? 1 : 0);
    }

    public boolean hostOnly() {
        return this.i;
    }

    public boolean httpOnly() {
        return this.g;
    }

    public boolean matches(okhttp3.HttpUrl httpUrl) {
        if ((this.i ? httpUrl.host().equals(this.d) : b(httpUrl.host(), this.d)) && g(httpUrl, this.e)) {
            return !this.f || httpUrl.isHttps();
        }
        return false;
    }

    public java.lang.String name() {
        return this.a;
    }

    public java.lang.String path() {
        return this.e;
    }

    public boolean persistent() {
        return this.h;
    }

    public boolean secure() {
        return this.f;
    }

    public java.lang.String toString() {
        return h(false);
    }

    public java.lang.String value() {
        return this.b;
    }
}
