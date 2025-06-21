package okhttp3;

@okhttp3.internal.annotations.EverythingIsNonNull
/* loaded from: classes23.dex */
public final class JavaNetCookieJar implements okhttp3.CookieJar {
    public final java.net.CookieHandler a;

    public JavaNetCookieJar(java.net.CookieHandler cookieHandler) {
        this.a = cookieHandler;
    }

    public final java.util.List<okhttp3.Cookie> a(okhttp3.HttpUrl httpUrl, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int delimiterOffset = okhttp3.internal.Util.delimiterOffset(str, i, length, ";,");
            int delimiterOffset2 = okhttp3.internal.Util.delimiterOffset(str, i, delimiterOffset, com.alipay.sdk.m.n.a.h);
            java.lang.String trimSubstring = okhttp3.internal.Util.trimSubstring(str, i, delimiterOffset2);
            if (!trimSubstring.startsWith("$")) {
                java.lang.String trimSubstring2 = delimiterOffset2 < delimiterOffset ? okhttp3.internal.Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset) : "";
                if (trimSubstring2.startsWith("\"") && trimSubstring2.endsWith("\"")) {
                    trimSubstring2 = trimSubstring2.substring(1, trimSubstring2.length() - 1);
                }
                arrayList.add(new okhttp3.Cookie.Builder().name(trimSubstring).value(trimSubstring2).domain(httpUrl.host()).build());
            }
            i = delimiterOffset + 1;
        }
        return arrayList;
    }

    @Override // okhttp3.CookieJar
    public java.util.List<okhttp3.Cookie> loadForRequest(okhttp3.HttpUrl httpUrl) {
        try {
            java.util.ArrayList arrayList = null;
            for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : this.a.get(httpUrl.uri(), java.util.Collections.emptyMap()).entrySet()) {
                java.lang.String key = entry.getKey();
                if (com.google.common.net.HttpHeaders.COOKIE.equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key)) {
                    if (!entry.getValue().isEmpty()) {
                        for (java.lang.String str : entry.getValue()) {
                            if (arrayList == null) {
                                arrayList = new java.util.ArrayList();
                            }
                            arrayList.addAll(a(httpUrl, str));
                        }
                    }
                }
            }
            return arrayList != null ? java.util.Collections.unmodifiableList(arrayList) : java.util.Collections.emptyList();
        } catch (java.io.IOException e) {
            okhttp3.internal.platform.Platform.get().log(5, "Loading cookies failed for " + httpUrl.resolve("/..."), e);
            return java.util.Collections.emptyList();
        }
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(okhttp3.HttpUrl httpUrl, java.util.List<okhttp3.Cookie> list) {
        if (this.a != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<okhttp3.Cookie> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().h(true));
            }
            try {
                this.a.put(httpUrl.uri(), java.util.Collections.singletonMap(com.google.common.net.HttpHeaders.SET_COOKIE, arrayList));
            } catch (java.io.IOException e) {
                okhttp3.internal.platform.Platform.get().log(5, "Saving cookies failed for " + httpUrl.resolve("/..."), e);
            }
        }
    }
}
