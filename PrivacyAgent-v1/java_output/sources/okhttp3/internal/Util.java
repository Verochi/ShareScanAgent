package okhttp3.internal;

/* loaded from: classes23.dex */
public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final okhttp3.RequestBody EMPTY_REQUEST;
    public static final okhttp3.ResponseBody EMPTY_RESPONSE;
    public static final java.lang.reflect.Method d;
    public static final java.util.regex.Pattern e;
    public static final java.lang.String[] EMPTY_STRING_ARRAY = new java.lang.String[0];
    public static final okhttp3.Headers EMPTY_HEADERS = okhttp3.Headers.of(new java.lang.String[0]);
    public static final okio.Options a = okio.Options.of(okio.ByteString.decodeHex("efbbbf"), okio.ByteString.decodeHex("feff"), okio.ByteString.decodeHex("fffe"), okio.ByteString.decodeHex("0000ffff"), okio.ByteString.decodeHex("ffff0000"));
    public static final java.nio.charset.Charset b = java.nio.charset.Charset.forName("UTF-32BE");
    public static final java.nio.charset.Charset c = java.nio.charset.Charset.forName("UTF-32LE");
    public static final java.util.TimeZone UTC = java.util.TimeZone.getTimeZone("GMT");
    public static final java.util.Comparator<java.lang.String> NATURAL_ORDER = new defpackage.x73();

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        java.lang.reflect.Method method = null;
        EMPTY_RESPONSE = okhttp3.ResponseBody.create((okhttp3.MediaType) null, bArr);
        EMPTY_REQUEST = okhttp3.RequestBody.create((okhttp3.MediaType) null, bArr);
        try {
            method = java.lang.Throwable.class.getDeclaredMethod("addSuppressed", java.lang.Throwable.class);
        } catch (java.lang.Exception unused) {
        }
        d = method;
        e = java.util.regex.Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static void addSuppressedIfPossible(java.lang.Throwable th, java.lang.Throwable th2) {
        java.lang.reflect.Method method = d;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            }
        }
    }

    public static boolean b(java.lang.String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static java.nio.charset.Charset bomAwareCharset(okio.BufferedSource bufferedSource, java.nio.charset.Charset charset) throws java.io.IOException {
        int select = bufferedSource.select(a);
        if (select == -1) {
            return charset;
        }
        if (select == 0) {
            return java.nio.charset.StandardCharsets.UTF_8;
        }
        if (select == 1) {
            return java.nio.charset.StandardCharsets.UTF_16BE;
        }
        if (select == 2) {
            return java.nio.charset.StandardCharsets.UTF_16LE;
        }
        if (select == 3) {
            return b;
        }
        if (select == 4) {
            return c;
        }
        throw new java.lang.AssertionError();
    }

    public static boolean c(java.lang.String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = str.charAt(i5);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    public static java.lang.String canonicalizeHost(java.lang.String str) {
        if (!str.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
            try {
                java.lang.String lowerCase = java.net.IDN.toASCII(str).toLowerCase(java.util.Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (b(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (java.lang.IllegalArgumentException unused) {
                return null;
            }
        }
        java.net.InetAddress d2 = (str.startsWith("[") && str.endsWith("]")) ? d(str, 1, str.length() - 1) : d(str, 0, str.length());
        if (d2 == null) {
            return null;
        }
        byte[] address = d2.getAddress();
        if (address.length == 16) {
            return e(address);
        }
        if (address.length == 4) {
            return d2.getHostAddress();
        }
        throw new java.lang.AssertionError("Invalid IPv6 address: '" + str + "'");
    }

    public static int checkDuration(java.lang.String str, long j, java.util.concurrent.TimeUnit timeUnit) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(str + " < 0");
        }
        if (timeUnit == null) {
            throw new java.lang.NullPointerException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new java.lang.IllegalArgumentException(str + " too large.");
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new java.lang.IllegalArgumentException(str + " too small.");
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
    }

    public static void closeQuietly(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.RuntimeException e2) {
                throw e2;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void closeQuietly(java.net.ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (java.lang.RuntimeException e2) {
                throw e2;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void closeQuietly(java.net.Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (java.lang.AssertionError e2) {
                if (!isAndroidGetsocknameError(e2)) {
                    throw e2;
                }
            } catch (java.lang.RuntimeException e3) {
                throw e3;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static java.lang.String[] concat(java.lang.String[] strArr, java.lang.String str) {
        int length = strArr.length + 1;
        java.lang.String[] strArr2 = new java.lang.String[length];
        java.lang.System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.net.InetAddress d(java.lang.String str, int i, int i2) {
        int i3;
        byte[] bArr = new byte[16];
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i < i2) {
                if (i4 != 16) {
                    int i7 = i + 2;
                    if (i7 <= i2 && str.regionMatches(i, "::", 0, 2)) {
                        if (i5 == -1) {
                            i4 += 2;
                            i5 = i4;
                            if (i7 != i2) {
                                i6 = i7;
                                i = i6;
                                int i8 = 0;
                                while (i < i2) {
                                }
                                i3 = i - i6;
                                if (i3 == 0) {
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        return null;
                    }
                    if (i4 != 0) {
                        if (str.regionMatches(i, com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, 0, 1)) {
                            i++;
                        } else {
                            if (!str.regionMatches(i, ".", 0, 1) || !c(str, i6, i2, bArr, i4 - 2)) {
                                return null;
                            }
                            i4 += 2;
                        }
                    }
                    i6 = i;
                    i = i6;
                    int i82 = 0;
                    while (i < i2) {
                        int decodeHexDigit = decodeHexDigit(str.charAt(i));
                        if (decodeHexDigit == -1) {
                            break;
                        }
                        i82 = (i82 << 4) + decodeHexDigit;
                        i++;
                    }
                    i3 = i - i6;
                    if (i3 == 0 || i3 > 4) {
                        break;
                    }
                    int i9 = i4 + 1;
                    bArr[i4] = (byte) ((i82 >>> 8) & 255);
                    i4 = i9 + 1;
                    bArr[i9] = (byte) (i82 & 255);
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        if (i4 != 16) {
            if (i5 == -1) {
                return null;
            }
            int i10 = i4 - i5;
            java.lang.System.arraycopy(bArr, i5, bArr, 16 - i10, i10);
            java.util.Arrays.fill(bArr, i5, (16 - i4) + i5, (byte) 0);
        }
        try {
            return java.net.InetAddress.getByAddress(bArr);
        } catch (java.net.UnknownHostException unused) {
            throw new java.lang.AssertionError();
        }
    }

    public static int decodeHexDigit(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static int delimiterOffset(java.lang.String str, int i, int i2, char c2) {
        while (i < i2) {
            if (str.charAt(i) == c2) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int delimiterOffset(java.lang.String str, int i, int i2, java.lang.String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static boolean discard(okio.Source source, int i, java.util.concurrent.TimeUnit timeUnit) {
        try {
            return skipAll(source, i, timeUnit);
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    public static java.lang.String e(byte[] bArr) {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        okio.Buffer buffer = new okio.Buffer();
        while (i2 < bArr.length) {
            if (i2 == i) {
                buffer.writeByte(58);
                i2 += i4;
                if (i2 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return buffer.readUtf8();
    }

    public static /* synthetic */ java.lang.Thread f(java.lang.String str, boolean z, java.lang.Runnable runnable) {
        java.lang.Thread thread = new java.lang.Thread(runnable, str);
        thread.setDaemon(z);
        return thread;
    }

    public static java.lang.String format(java.lang.String str, java.lang.Object... objArr) {
        return java.lang.String.format(java.util.Locale.US, str, objArr);
    }

    public static java.lang.String getSystemProperty(java.lang.String str, @javax.annotation.Nullable java.lang.String str2) {
        try {
            java.lang.String property = java.lang.System.getProperty(str);
            return property != null ? property : str2;
        } catch (java.security.AccessControlException unused) {
            return str2;
        }
    }

    public static java.lang.String hostHeader(okhttp3.HttpUrl httpUrl, boolean z) {
        java.lang.String host;
        if (httpUrl.host().contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
            host = "[" + httpUrl.host() + "]";
        } else {
            host = httpUrl.host();
        }
        if (!z && httpUrl.port() == okhttp3.HttpUrl.defaultPort(httpUrl.scheme())) {
            return host;
        }
        return host + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + httpUrl.port();
    }

    public static <T> java.util.List<T> immutableList(java.util.List<T> list) {
        return java.util.Collections.unmodifiableList(new java.util.ArrayList(list));
    }

    @java.lang.SafeVarargs
    public static <T> java.util.List<T> immutableList(T... tArr) {
        return java.util.Collections.unmodifiableList(java.util.Arrays.asList((java.lang.Object[]) tArr.clone()));
    }

    public static <K, V> java.util.Map<K, V> immutableMap(java.util.Map<K, V> map) {
        return map.isEmpty() ? java.util.Collections.emptyMap() : java.util.Collections.unmodifiableMap(new java.util.LinkedHashMap(map));
    }

    public static int indexOf(java.util.Comparator<java.lang.String> comparator, java.lang.String[] strArr, java.lang.String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOfControlOrNonAscii(java.lang.String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    public static java.lang.String[] intersect(java.util.Comparator<? super java.lang.String> comparator, java.lang.String[] strArr, java.lang.String[] strArr2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    public static boolean isAndroidGetsocknameError(java.lang.AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean nonEmptyIntersection(java.util.Comparator<java.lang.String> comparator, java.lang.String[] strArr, java.lang.String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (java.lang.String str : strArr) {
                for (java.lang.String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static javax.net.ssl.X509TrustManager platformTrustManager() {
        try {
            javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((java.security.KeyStore) null);
            javax.net.ssl.TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                javax.net.ssl.TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof javax.net.ssl.X509TrustManager) {
                    return (javax.net.ssl.X509TrustManager) trustManager;
                }
            }
            throw new java.lang.IllegalStateException("Unexpected default trust managers:" + java.util.Arrays.toString(trustManagers));
        } catch (java.security.GeneralSecurityException e2) {
            throw new java.lang.AssertionError("No System TLS", e2);
        }
    }

    public static boolean sameConnection(okhttp3.HttpUrl httpUrl, okhttp3.HttpUrl httpUrl2) {
        return httpUrl.host().equals(httpUrl2.host()) && httpUrl.port() == httpUrl2.port() && httpUrl.scheme().equals(httpUrl2.scheme());
    }

    public static boolean skipAll(okio.Source source, int i, java.util.concurrent.TimeUnit timeUnit) throws java.io.IOException {
        long nanoTime = java.lang.System.nanoTime();
        long deadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(java.lang.Math.min(deadlineNanoTime, timeUnit.toNanos(i)) + nanoTime);
        try {
            okio.Buffer buffer = new okio.Buffer();
            while (source.read(buffer, 8192L) != -1) {
                buffer.clear();
            }
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
                return true;
            }
            source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            return true;
        } catch (java.io.InterruptedIOException unused) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
                return false;
            }
            source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            return false;
        } catch (java.lang.Throwable th) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    public static int skipLeadingAsciiWhitespace(java.lang.String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int skipTrailingAsciiWhitespace(java.lang.String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    public static java.util.concurrent.ThreadFactory threadFactory(java.lang.String str, boolean z) {
        return new defpackage.w73(str, z);
    }

    public static java.util.List<okhttp3.internal.http2.Header> toHeaderBlock(okhttp3.Headers headers) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < headers.size(); i++) {
            arrayList.add(new okhttp3.internal.http2.Header(headers.name(i), headers.value(i)));
        }
        return arrayList;
    }

    public static okhttp3.Headers toHeaders(java.util.List<okhttp3.internal.http2.Header> list) {
        okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
        for (okhttp3.internal.http2.Header header : list) {
            okhttp3.internal.Internal.instance.addLenient(builder, header.name.utf8(), header.value.utf8());
        }
        return builder.build();
    }

    public static java.lang.String trimSubstring(java.lang.String str, int i, int i2) {
        int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str, i, i2);
        return str.substring(skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, i2));
    }

    public static boolean verifyAsIpAddress(java.lang.String str) {
        return e.matcher(str).matches();
    }
}
