package com.huawei.hms.framework.network.grs.g;

/* loaded from: classes22.dex */
public class d {
    private static final java.lang.String o = "d";
    private java.util.Map<java.lang.String, java.util.List<java.lang.String>> a;
    private byte[] b;
    private int c;
    private long d;
    private long e;
    private long f;
    private java.lang.String g;
    private int h;
    private int i;
    private java.lang.String j;
    private long k;
    private java.lang.String l;
    private java.lang.Exception m;
    private java.lang.String n;

    public d(int i, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, byte[] bArr, long j) {
        this.h = 2;
        this.i = 9001;
        this.j = "";
        this.k = 0L;
        this.l = "";
        this.c = i;
        this.a = map;
        this.b = java.nio.ByteBuffer.wrap(bArr).array();
        this.d = j;
        s();
    }

    public d(java.lang.Exception exc, long j) {
        this.c = 0;
        this.h = 2;
        this.i = 9001;
        this.j = "";
        this.k = 0L;
        this.l = "";
        this.m = exc;
        this.d = j;
    }

    private void a(java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String str;
        java.lang.String str2;
        if (map.containsKey("ETag")) {
            java.lang.String str3 = map.get("ETag");
            if (!android.text.TextUtils.isEmpty(str3)) {
                com.huawei.hms.framework.common.Logger.i(o, "success get Etag from server");
                a(str3);
                return;
            } else {
                str = o;
                str2 = "The Response Heads Etag is Empty";
            }
        } else {
            str = o;
            str2 = "Response Heads has not Etag";
        }
        com.huawei.hms.framework.common.Logger.i(str, str2);
    }

    private void b(int i) {
        this.i = i;
    }

    private void b(java.util.Map<java.lang.String, java.lang.String> map) {
        long time;
        if (map.containsKey("Cache-Control")) {
            java.lang.String str = map.get("Cache-Control");
            if (!android.text.TextUtils.isEmpty(str) && str.contains("max-age=")) {
                try {
                    time = java.lang.Long.parseLong(str.substring(str.indexOf("max-age=") + 8));
                    try {
                        com.huawei.hms.framework.common.Logger.v(o, "Cache-Control value{%s}", java.lang.Long.valueOf(time));
                    } catch (java.lang.NumberFormatException e) {
                        e = e;
                        com.huawei.hms.framework.common.Logger.w(o, "getExpireTime addHeadersToResult NumberFormatException", e);
                        if (time > 0) {
                        }
                        time = com.anythink.expressad.d.a.b.aT;
                        long j = time * 1000;
                        com.huawei.hms.framework.common.Logger.i(o, "convert expireTime{%s}", java.lang.Long.valueOf(j));
                        c(java.lang.String.valueOf(j + java.lang.System.currentTimeMillis()));
                    }
                } catch (java.lang.NumberFormatException e2) {
                    e = e2;
                    time = 0;
                }
            }
            time = 0;
        } else {
            if (map.containsKey("Expires")) {
                java.lang.String str2 = map.get("Expires");
                com.huawei.hms.framework.common.Logger.v(o, "expires is{%s}", str2);
                java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", java.util.Locale.ROOT);
                java.lang.String str3 = map.containsKey("Date") ? map.get("Date") : null;
                try {
                    time = (simpleDateFormat.parse(str2).getTime() - (android.text.TextUtils.isEmpty(str3) ? new java.util.Date() : simpleDateFormat.parse(str3)).getTime()) / 1000;
                } catch (java.text.ParseException e3) {
                    com.huawei.hms.framework.common.Logger.w(o, "getExpireTime ParseException.", e3);
                }
            } else {
                com.huawei.hms.framework.common.Logger.i(o, "response headers neither contains Cache-Control nor Expires.");
            }
            time = 0;
        }
        if (time > 0 || time > 2592000) {
            time = com.anythink.expressad.d.a.b.aT;
        }
        long j2 = time * 1000;
        com.huawei.hms.framework.common.Logger.i(o, "convert expireTime{%s}", java.lang.Long.valueOf(j2));
        c(java.lang.String.valueOf(j2 + java.lang.System.currentTimeMillis()));
    }

    private void c(int i) {
        this.h = i;
    }

    private void c(long j) {
        this.k = j;
    }

    private void c(java.lang.String str) {
        this.j = str;
    }

    private void c(java.util.Map<java.lang.String, java.lang.String> map) {
        long j;
        if (map.containsKey(com.google.common.net.HttpHeaders.RETRY_AFTER)) {
            java.lang.String str = map.get(com.google.common.net.HttpHeaders.RETRY_AFTER);
            if (!android.text.TextUtils.isEmpty(str)) {
                try {
                    j = java.lang.Long.parseLong(str);
                } catch (java.lang.NumberFormatException e) {
                    com.huawei.hms.framework.common.Logger.w(o, "getRetryAfter addHeadersToResult NumberFormatException", e);
                }
                long j2 = j * 1000;
                com.huawei.hms.framework.common.Logger.v(o, "convert retry-afterTime{%s}", java.lang.Long.valueOf(j2));
                c(j2);
            }
        }
        j = 0;
        long j22 = j * 1000;
        com.huawei.hms.framework.common.Logger.v(o, "convert retry-afterTime{%s}", java.lang.Long.valueOf(j22));
        c(j22);
    }

    private void d(java.lang.String str) {
    }

    private void e(java.lang.String str) {
    }

    private void f(java.lang.String str) {
        this.g = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0051, code lost:
    
        if (r9.getInt("resultCode") == 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void p() {
        int i;
        if (m()) {
            com.huawei.hms.framework.common.Logger.i(o, "GRSSDK get httpcode{304} not any changed.");
            c(1);
            return;
        }
        if (!o()) {
            com.huawei.hms.framework.common.Logger.i(o, "GRSSDK parse server body all failed.");
            c(2);
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(com.huawei.hms.framework.common.StringUtils.byte2Str(this.b));
            if (jSONObject.has("isSuccess")) {
                if (jSONObject.getInt("isSuccess") == 1) {
                    i = 1;
                }
                i = 2;
            } else if (!jSONObject.has("resultCode")) {
                com.huawei.hms.framework.common.Logger.e(o, "sth. wrong because server errorcode's key.");
                i = -1;
            }
            if (i != 1 && jSONObject.has("services")) {
                i = 0;
            }
            c(i);
            if (i == 1 || i == 0) {
                f(jSONObject.has("services") ? jSONObject.getJSONObject("services").toString() : "");
                e(jSONObject.has("errorList") ? jSONObject.getJSONObject("errorList").toString() : "");
            } else {
                b(jSONObject.has("errorCode") ? jSONObject.getInt("errorCode") : 9001);
                d(jSONObject.has("errorDesc") ? jSONObject.getString("errorDesc") : "");
            }
        } catch (org.json.JSONException e) {
            com.huawei.hms.framework.common.Logger.w(o, "GrsResponse GrsResponse(String result) JSONException: %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e.getMessage()));
            c(2);
        }
    }

    private void q() {
        if (o() || n() || m()) {
            java.util.Map<java.lang.String, java.lang.String> r = r();
            if (r.size() <= 0) {
                com.huawei.hms.framework.common.Logger.w(o, "parseHeader {headers.size() <= 0}");
                return;
            }
            try {
                if (o() || m()) {
                    b(r);
                    a(r);
                }
                if (n()) {
                    c(r);
                }
            } catch (org.json.JSONException e) {
                com.huawei.hms.framework.common.Logger.w(o, "parseHeader catch JSONException: %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e.getMessage()));
            }
        }
    }

    private java.util.Map<java.lang.String, java.lang.String> r() {
        java.util.HashMap hashMap = new java.util.HashMap(16);
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> map = this.a;
        if (map == null || map.size() <= 0) {
            com.huawei.hms.framework.common.Logger.v(o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return hashMap;
        }
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : this.a.entrySet()) {
            java.lang.String key = entry.getKey();
            java.util.Iterator<java.lang.String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                hashMap.put(key, it.next());
            }
        }
        return hashMap;
    }

    private void s() {
        q();
        p();
    }

    public java.lang.String a() {
        return this.j;
    }

    public void a(int i) {
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(java.lang.String str) {
        this.l = str;
    }

    public int b() {
        return this.c;
    }

    public void b(long j) {
        this.e = j;
    }

    public void b(java.lang.String str) {
        this.n = str;
    }

    public int c() {
        return this.i;
    }

    public java.lang.Exception d() {
        return this.m;
    }

    public java.lang.String e() {
        return this.l;
    }

    public int f() {
        return this.h;
    }

    public long g() {
        return this.f;
    }

    public long h() {
        return this.e;
    }

    public long i() {
        return this.d;
    }

    public java.lang.String j() {
        return this.g;
    }

    public long k() {
        return this.k;
    }

    public java.lang.String l() {
        return this.n;
    }

    public boolean m() {
        return this.c == 304;
    }

    public boolean n() {
        return this.c == 503;
    }

    public boolean o() {
        return this.c == 200;
    }
}
