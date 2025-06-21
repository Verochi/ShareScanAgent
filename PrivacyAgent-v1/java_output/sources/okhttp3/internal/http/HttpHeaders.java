package okhttp3.internal.http;

/* loaded from: classes24.dex */
public final class HttpHeaders {
    public static final okio.ByteString a = okio.ByteString.encodeUtf8("\"\\");
    public static final okio.ByteString b = okio.ByteString.encodeUtf8("\t ,=");

    /* JADX WARN: Code restructure failed: missing block: B:24:0x007d, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x007d, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(java.util.List<okhttp3.Challenge> list, okio.Buffer buffer) {
        java.lang.String c;
        int e;
        while (true) {
            java.lang.String str = null;
            while (true) {
                if (str == null) {
                    f(buffer);
                    str = c(buffer);
                    if (str == null) {
                        return;
                    }
                }
                boolean f = f(buffer);
                c = c(buffer);
                if (c == null) {
                    if (buffer.exhausted()) {
                        list.add(new okhttp3.Challenge(str, (java.util.Map<java.lang.String, java.lang.String>) java.util.Collections.emptyMap()));
                        return;
                    }
                    return;
                }
                e = e(buffer, (byte) 61);
                boolean f2 = f(buffer);
                if (f || (!f2 && !buffer.exhausted())) {
                    java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
                    int e2 = e + e(buffer, (byte) 61);
                    while (true) {
                        if (c == null) {
                            c = c(buffer);
                            if (f(buffer)) {
                                break;
                            } else {
                                e2 = e(buffer, (byte) 61);
                            }
                        }
                        if (e2 == 0) {
                            break;
                        }
                        if (e2 > 1 || f(buffer)) {
                            return;
                        }
                        java.lang.String c2 = (buffer.exhausted() || buffer.getByte(0L) != 34) ? c(buffer) : b(buffer);
                        if (c2 == null || ((java.lang.String) linkedHashMap.put(c, c2)) != null) {
                            return;
                        }
                        if (!f(buffer) && !buffer.exhausted()) {
                            return;
                        } else {
                            c = null;
                        }
                    }
                    list.add(new okhttp3.Challenge(str, linkedHashMap));
                    str = c;
                }
            }
            list.add(new okhttp3.Challenge(str, (java.util.Map<java.lang.String, java.lang.String>) java.util.Collections.singletonMap(null, c + d(com.alipay.sdk.m.n.a.h, e))));
        }
    }

    public static java.lang.String b(okio.Buffer buffer) {
        if (buffer.readByte() != 34) {
            throw new java.lang.IllegalArgumentException();
        }
        okio.Buffer buffer2 = new okio.Buffer();
        while (true) {
            long indexOfElement = buffer.indexOfElement(a);
            if (indexOfElement == -1) {
                return null;
            }
            if (buffer.getByte(indexOfElement) == 34) {
                buffer2.write(buffer, indexOfElement);
                buffer.readByte();
                return buffer2.readUtf8();
            }
            if (buffer.size() == indexOfElement + 1) {
                return null;
            }
            buffer2.write(buffer, indexOfElement);
            buffer.readByte();
            buffer2.write(buffer, 1L);
        }
    }

    public static java.lang.String c(okio.Buffer buffer) {
        try {
            long indexOfElement = buffer.indexOfElement(b);
            if (indexOfElement == -1) {
                indexOfElement = buffer.size();
            }
            if (indexOfElement != 0) {
                return buffer.readUtf8(indexOfElement);
            }
            return null;
        } catch (java.io.EOFException unused) {
            throw new java.lang.AssertionError();
        }
    }

    public static long contentLength(okhttp3.Headers headers) {
        return g(headers.get("Content-Length"));
    }

    public static long contentLength(okhttp3.Response response) {
        return contentLength(response.headers());
    }

    public static java.lang.String d(char c, int i) {
        char[] cArr = new char[i];
        java.util.Arrays.fill(cArr, c);
        return new java.lang.String(cArr);
    }

    public static int e(okio.Buffer buffer, byte b2) {
        int i = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b2) {
            i++;
            buffer.readByte();
        }
        return i;
    }

    public static boolean f(okio.Buffer buffer) {
        boolean z = false;
        while (!buffer.exhausted()) {
            byte b2 = buffer.getByte(0L);
            if (b2 != 44) {
                if (b2 != 32 && b2 != 9) {
                    break;
                }
                buffer.readByte();
            } else {
                buffer.readByte();
                z = true;
            }
        }
        return z;
    }

    public static long g(java.lang.String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return java.lang.Long.parseLong(str);
        } catch (java.lang.NumberFormatException unused) {
            return -1L;
        }
    }

    public static java.util.Set<java.lang.String> h(okhttp3.Response response) {
        return varyFields(response.headers());
    }

    public static boolean hasBody(okhttp3.Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int code = response.code();
        return (((code >= 100 && code < 200) || code == 204 || code == 304) && contentLength(response) == -1 && !com.ss.android.socialbase.downloader.utils.DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(response.header("Transfer-Encoding"))) ? false : true;
    }

    public static boolean hasVaryAll(okhttp3.Headers headers) {
        return varyFields(headers).contains("*");
    }

    public static boolean hasVaryAll(okhttp3.Response response) {
        return hasVaryAll(response.headers());
    }

    public static java.util.List<okhttp3.Challenge> parseChallenges(okhttp3.Headers headers, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < headers.size(); i++) {
            if (str.equalsIgnoreCase(headers.name(i))) {
                a(arrayList, new okio.Buffer().writeUtf8(headers.value(i)));
            }
        }
        return arrayList;
    }

    public static int parseSeconds(java.lang.String str, int i) {
        try {
            long parseLong = java.lang.Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (java.lang.NumberFormatException unused) {
            return i;
        }
    }

    public static void receiveHeaders(okhttp3.CookieJar cookieJar, okhttp3.HttpUrl httpUrl, okhttp3.Headers headers) {
        if (cookieJar == okhttp3.CookieJar.NO_COOKIES) {
            return;
        }
        java.util.List<okhttp3.Cookie> parseAll = okhttp3.Cookie.parseAll(httpUrl, headers);
        if (parseAll.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, parseAll);
    }

    public static int skipUntil(java.lang.String str, int i, java.lang.String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int skipWhitespace(java.lang.String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }

    public static java.util.Set<java.lang.String> varyFields(okhttp3.Headers headers) {
        java.util.Set<java.lang.String> emptySet = java.util.Collections.emptySet();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            if (com.google.common.net.HttpHeaders.VARY.equalsIgnoreCase(headers.name(i))) {
                java.lang.String value = headers.value(i);
                if (emptySet.isEmpty()) {
                    emptySet = new java.util.TreeSet<>((java.util.Comparator<? super java.lang.String>) java.lang.String.CASE_INSENSITIVE_ORDER);
                }
                for (java.lang.String str : value.split(",")) {
                    emptySet.add(str.trim());
                }
            }
        }
        return emptySet;
    }

    public static okhttp3.Headers varyHeaders(okhttp3.Headers headers, okhttp3.Headers headers2) {
        java.util.Set<java.lang.String> varyFields = varyFields(headers2);
        if (varyFields.isEmpty()) {
            return okhttp3.internal.Util.EMPTY_HEADERS;
        }
        okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            java.lang.String name = headers.name(i);
            if (varyFields.contains(name)) {
                builder.add(name, headers.value(i));
            }
        }
        return builder.build();
    }

    public static okhttp3.Headers varyHeaders(okhttp3.Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static boolean varyMatches(okhttp3.Response response, okhttp3.Headers headers, okhttp3.Request request) {
        for (java.lang.String str : h(response)) {
            if (!java.util.Objects.equals(headers.values(str), request.headers(str))) {
                return false;
            }
        }
        return true;
    }
}
