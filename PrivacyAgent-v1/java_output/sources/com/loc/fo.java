package com.loc;

/* loaded from: classes23.dex */
public final class fo {
    public static int a = 1;
    public static int b = 2;
    private static com.loc.fo e;
    private android.content.Context j;
    private java.lang.String k;
    private long c = 0;
    private boolean d = false;
    private java.util.ArrayList<java.lang.String> f = new java.util.ArrayList<>();
    private com.loc.ev g = new com.loc.ev();
    private com.loc.ev h = new com.loc.ev();
    private long i = com.igexin.push.config.c.l;
    private boolean l = false;

    /* renamed from: com.loc.fo$1, reason: invalid class name */
    public class AnonymousClass1 extends com.loc.cu {
        final /* synthetic */ int a;

        public AnonymousClass1(int i) {
            this.a = i;
        }

        @Override // com.loc.cu
        public final void a() {
            int i;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("http://");
            sb.append(com.loc.fu.r());
            sb.append("?host=dualstack-a.apilocate.amap.com&query=");
            sb.append(this.a == com.loc.fo.b ? 6 : 4);
            java.lang.String sb2 = sb.toString();
            com.loc.fp fpVar = new com.loc.fp();
            fpVar.b(sb2);
            fpVar.c(sb2);
            fpVar.a(com.loc.bu.a.SINGLE);
            fpVar.a(com.loc.bu.c.HTTP);
            try {
                com.loc.bp.a();
                org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(com.loc.bp.a(fpVar).a));
                java.lang.String[] b = com.loc.fo.b(jSONObject.optJSONArray("ips"), com.loc.fo.a);
                if (b != null && b.length > 0 && !com.loc.fo.b(b, com.loc.fo.this.b(com.loc.fo.a).a())) {
                    com.loc.fo.this.b(com.loc.fo.a).a(b);
                    com.loc.fo.this.f(com.loc.fo.a);
                }
                java.lang.String[] b2 = com.loc.fo.b(jSONObject.optJSONArray("ipsv6"), com.loc.fo.b);
                if (b2 != null && b2.length > 0 && !com.loc.fo.b(b2, com.loc.fo.this.b(com.loc.fo.b).a())) {
                    com.loc.fo.this.b(com.loc.fo.b).a(b2);
                    com.loc.fo.this.f(com.loc.fo.b);
                }
                if ((jSONObject.has("ips") || jSONObject.has("ipsv6")) && jSONObject.has(com.huawei.hms.push.constant.RemoteMessageConst.TTL) && (i = jSONObject.getInt(com.huawei.hms.push.constant.RemoteMessageConst.TTL)) > 30) {
                    com.loc.fo.this.i = i * 1000;
                }
            } catch (java.lang.Throwable th) {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                try {
                    jSONObject2.put("key", "dnsError");
                    jSONObject2.put("reason", th.getMessage());
                } catch (java.lang.Throwable unused) {
                }
                com.loc.gb.a(com.loc.fo.this.j, "O018", jSONObject2);
            }
        }
    }

    private fo(android.content.Context context) {
        this.j = context;
    }

    public static synchronized com.loc.fo a(android.content.Context context) {
        com.loc.fo foVar;
        synchronized (com.loc.fo.class) {
            if (e == null) {
                e = new com.loc.fo(context);
            }
            foVar = e;
        }
        return foVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.loc.ev b(int i) {
        return i == b ? this.h : this.g;
    }

    private synchronized void b(boolean z, int i) {
        if (!z) {
            if (!com.loc.fu.p() && this.l) {
                return;
            }
        }
        if (this.c != 0) {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            long j = this.c;
            if (currentTimeMillis - j < this.i) {
                return;
            }
            if (currentTimeMillis - j < 60000) {
                return;
            }
        }
        this.c = java.lang.System.currentTimeMillis();
        this.l = true;
        java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
            stringBuffer.append(stackTraceElement.getClassName() + "(" + stackTraceElement.getMethodName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + stackTraceElement.getLineNumber() + "),");
        }
        com.loc.ct.a().b(new com.loc.fo.AnonymousClass1(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(java.lang.String[] strArr, java.lang.String[] strArr2) {
        if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0 || strArr.length != strArr2.length) {
            return false;
        }
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (!strArr[i].equals(strArr2[i])) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String[] b(org.json.JSONArray jSONArray, int i) throws org.json.JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new java.lang.String[0];
        }
        int length = jSONArray.length();
        java.lang.String[] strArr = new java.lang.String[length];
        for (int i2 = 0; i2 < length; i2++) {
            java.lang.String string = jSONArray.getString(i2);
            if (!android.text.TextUtils.isEmpty(string)) {
                if (i == b) {
                    string = "[" + string + "]";
                }
                strArr[i2] = string;
            }
        }
        return strArr;
    }

    private static java.lang.String c(int i) {
        return i == b ? "last_ip_6" : "last_ip_4";
    }

    private void d(int i) {
        if (b(i).d()) {
            android.content.SharedPreferences.Editor a2 = com.loc.gc.a(this.j, "cbG9jaXA");
            com.loc.gc.a(a2, c(i));
            com.loc.gc.a(a2);
            b(i).a(false);
        }
    }

    private java.lang.String e(int i) {
        java.lang.String str;
        int i2 = 0;
        b(false, i);
        java.lang.String[] a2 = b(i).a();
        if (a2 == null || a2.length <= 0) {
            g(i);
            return b(i).b();
        }
        int length = a2.length;
        while (true) {
            if (i2 >= length) {
                str = null;
                break;
            }
            str = a2[i2];
            if (!this.f.contains(str)) {
                break;
            }
            i2++;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        b(i).a(str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        if (b(i).a() == null || b(i).a().length <= 0) {
            return;
        }
        java.lang.String str = b(i).a()[0];
        if (str.equals(this.k) || this.f.contains(str)) {
            return;
        }
        this.k = str;
        android.content.SharedPreferences.Editor a2 = com.loc.gc.a(this.j, "cbG9jaXA");
        com.loc.gc.a(a2, c(i), str);
        com.loc.gc.a(a2);
    }

    private void g(int i) {
        java.lang.String a2 = com.loc.gc.a(this.j, "cbG9jaXA", c(i), (java.lang.String) null);
        if (android.text.TextUtils.isEmpty(a2) || this.f.contains(a2)) {
            return;
        }
        b(i).a(a2);
        b(i).b(a2);
        b(i).a(true);
    }

    public final java.lang.String a(com.loc.fr frVar, int i) {
        try {
            if (com.loc.fu.q() && frVar != null) {
                java.lang.String b2 = frVar.b();
                java.lang.String host = new java.net.URL(b2).getHost();
                if (!"http://abroad.apilocate.amap.com/mobile/binary".equals(b2) && !"abroad.apilocate.amap.com".equals(host)) {
                    java.lang.String str = "apilocate.amap.com".equalsIgnoreCase(host) ? "httpdns.apilocate.amap.com" : host;
                    if (!com.loc.n.g(str)) {
                        return null;
                    }
                    java.lang.String e2 = e(i);
                    if (!android.text.TextUtils.isEmpty(e2)) {
                        frVar.d(b2.replace(host, e2));
                        frVar.a().put(com.alipay.sdk.m.l.c.f, str);
                        frVar.e(str);
                        frVar.a(i == b);
                        return e2;
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return null;
    }

    public final void a(int i) {
        if (b(i).e()) {
            d(i);
            return;
        }
        this.f.add(b(i).b());
        d(i);
        b(true, i);
    }

    public final void a(boolean z, int i) {
        b(i).b(z);
        if (z) {
            java.lang.String c = b(i).c();
            java.lang.String b2 = b(i).b();
            if (android.text.TextUtils.isEmpty(b2) || b2.equals(c)) {
                return;
            }
            android.content.SharedPreferences.Editor a2 = com.loc.gc.a(this.j, "cbG9jaXA");
            com.loc.gc.a(a2, c(i), b2);
            com.loc.gc.a(a2);
        }
    }
}
