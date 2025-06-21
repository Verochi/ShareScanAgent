package com.alipay.sdk.app;

/* loaded from: classes.dex */
public class PayTask {
    public static final java.lang.Object h = com.alipay.sdk.m.u.h.class;
    public static long i;
    public android.app.Activity a;
    public com.alipay.sdk.m.x.a b;
    public final java.lang.String c = "wappaygw.alipay.com/service/rest.htm";
    public final java.lang.String d = "mclient.alipay.com/service/rest.htm";
    public final java.lang.String e = "mclient.alipay.com/home/exterfaceAssign.htm";
    public final java.lang.String f = "mclient.alipay.com/cashier/mobilepay.htm";
    public java.util.Map<java.lang.String, com.alipay.sdk.app.PayTask.c> g = new java.util.HashMap();

    public class a implements java.lang.Runnable {
        public final /* synthetic */ java.lang.String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ com.alipay.sdk.app.H5PayCallback c;

        public a(java.lang.String str, boolean z, com.alipay.sdk.app.H5PayCallback h5PayCallback) {
            this.a = str;
            this.b = z;
            this.c = h5PayCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alipay.sdk.util.H5PayResultModel h5Pay = com.alipay.sdk.app.PayTask.this.h5Pay(new com.alipay.sdk.m.s.a(com.alipay.sdk.app.PayTask.this.a, this.a, "payInterceptorWithUrl"), this.a, this.b);
            com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "inc finished: " + h5Pay.getResultCode());
            this.c.onPayResult(h5Pay);
        }
    }

    public class b implements com.alipay.sdk.m.u.h.g {
        public b() {
        }

        @Override // com.alipay.sdk.m.u.h.g
        public void a() {
            com.alipay.sdk.app.PayTask.this.dismissLoading();
        }

        @Override // com.alipay.sdk.m.u.h.g
        public void b() {
        }
    }

    public class c {
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String c;
        public java.lang.String d;

        public c() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
        }

        public /* synthetic */ c(com.alipay.sdk.app.PayTask payTask, com.alipay.sdk.app.PayTask.a aVar) {
            this();
        }

        public java.lang.String a() {
            return this.c;
        }

        public void a(java.lang.String str) {
            this.c = str;
        }

        public java.lang.String b() {
            return this.a;
        }

        public void b(java.lang.String str) {
            this.a = str;
        }

        public java.lang.String c() {
            return this.b;
        }

        public void c(java.lang.String str) {
            this.b = str;
        }

        public java.lang.String d() {
            return this.d;
        }

        public void d(java.lang.String str) {
            this.d = str;
        }
    }

    public PayTask(android.app.Activity activity) {
        this.a = activity;
        com.alipay.sdk.m.s.b.d().a(this.a);
        this.b = new com.alipay.sdk.m.x.a(activity, com.alipay.sdk.m.x.a.j);
    }

    private com.alipay.sdk.m.u.h.g a() {
        return new com.alipay.sdk.app.PayTask.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0052 A[Catch: all -> 0x005c, TryCatch #2 {all -> 0x005c, blocks: (B:9:0x001e, B:11:0x0045, B:13:0x0052, B:14:0x0057), top: B:8:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(android.content.Context context) {
        java.lang.String str;
        java.lang.String str2;
        android.content.pm.PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = packageInfo.versionName;
        } catch (java.lang.Exception e) {
            e = e;
            str = "";
        }
        try {
            str2 = packageInfo.packageName;
        } catch (java.lang.Exception e2) {
            e = e2;
            com.alipay.sdk.m.u.e.a(e);
            str2 = "";
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("appkey", com.alipay.sdk.m.l.a.f);
            jSONObject.put(com.alipay.sdk.m.s.a.f86s, "and_lite");
            jSONObject.put("sv", "h.a.3.8.11");
            jSONObject.put(com.alipay.sdk.m.s.a.u, str2);
            jSONObject.put("av", str);
            jSONObject.put(com.alipay.sdk.m.s.a.x, java.lang.System.currentTimeMillis());
            if (!android.text.TextUtils.isEmpty("sc")) {
            }
            return jSONObject.toString();
        }
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("appkey", com.alipay.sdk.m.l.a.f);
            jSONObject2.put(com.alipay.sdk.m.s.a.f86s, "and_lite");
            jSONObject2.put("sv", "h.a.3.8.11");
            jSONObject2.put(com.alipay.sdk.m.s.a.u, str2);
            jSONObject2.put("av", str);
            jSONObject2.put(com.alipay.sdk.m.s.a.x, java.lang.System.currentTimeMillis());
            if (!android.text.TextUtils.isEmpty("sc")) {
                jSONObject2.put("sc", "h5tonative");
            }
            return jSONObject2.toString();
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.u.e.a(th);
            return "";
        }
    }

    private java.lang.String a(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.r.b bVar) {
        java.lang.String[] c2 = bVar.c();
        android.content.Intent intent = new android.content.Intent(this.a, (java.lang.Class<?>) com.alipay.sdk.app.H5PayActivity.class);
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("url", c2[0]);
        if (c2.length == 2) {
            bundle.putString("cookie", c2[1]);
        }
        intent.putExtras(bundle);
        com.alipay.sdk.m.s.a.C0043a.a(aVar, intent);
        this.a.startActivity(intent);
        java.lang.Object obj = h;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (java.lang.InterruptedException e) {
                com.alipay.sdk.m.u.e.a(e);
                return com.alipay.sdk.m.j.b.a();
            }
        }
        java.lang.String d = com.alipay.sdk.m.j.b.d();
        return android.text.TextUtils.isEmpty(d) ? com.alipay.sdk.m.j.b.a() : d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0093, code lost:
    
        r0 = r6.c();
        r11 = com.alipay.sdk.m.j.b.a(java.lang.Integer.valueOf(r0[1]).intValue(), r0[0], com.alipay.sdk.m.u.n.e(r10, r0[2]));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String a(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.r.b bVar, java.lang.String str) {
        boolean c2;
        java.lang.String d;
        java.lang.String[] c3 = bVar.c();
        android.content.Intent intent = new android.content.Intent(this.a, (java.lang.Class<?>) com.alipay.sdk.app.H5PayActivity.class);
        try {
            org.json.JSONObject h2 = com.alipay.sdk.m.u.n.h(new java.lang.String(com.alipay.sdk.m.n.a.a(c3[2])));
            intent.putExtra("url", c3[0]);
            intent.putExtra("title", c3[1]);
            intent.putExtra("version", com.alipay.sdk.m.x.c.d);
            intent.putExtra("method", h2.optString("method", "POST"));
            com.alipay.sdk.m.j.b.a(false);
            com.alipay.sdk.m.j.b.a((java.lang.String) null);
            com.alipay.sdk.m.s.a.C0043a.a(aVar, intent);
            this.a.startActivity(intent);
            java.lang.Object obj = h;
            synchronized (obj) {
                try {
                    obj.wait();
                    c2 = com.alipay.sdk.m.j.b.c();
                    d = com.alipay.sdk.m.j.b.d();
                    com.alipay.sdk.m.j.b.a(false);
                    com.alipay.sdk.m.j.b.a((java.lang.String) null);
                } catch (java.lang.InterruptedException e) {
                    com.alipay.sdk.m.u.e.a(e);
                    return com.alipay.sdk.m.j.b.a();
                }
            }
            java.lang.String str2 = "";
            if (c2) {
                try {
                    java.util.List<com.alipay.sdk.m.r.b> a2 = com.alipay.sdk.m.r.b.a(com.alipay.sdk.m.u.n.h(new java.lang.String(com.alipay.sdk.m.n.a.a(d))));
                    int i2 = 0;
                    while (true) {
                        if (i2 >= a2.size()) {
                            break;
                        }
                        com.alipay.sdk.m.r.b bVar2 = a2.get(i2);
                        if (bVar2.a() == com.alipay.sdk.m.r.a.SetResult) {
                            break;
                        }
                        i2++;
                    }
                } catch (java.lang.Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, th, d);
                }
            }
            if (!android.text.TextUtils.isEmpty(str2)) {
                return str2;
            }
            try {
                return com.alipay.sdk.m.j.b.a(java.lang.Integer.valueOf(str).intValue(), "", "");
            } catch (java.lang.Throwable th2) {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, th2, "endCode: " + str);
                return com.alipay.sdk.m.j.b.a(8000, "", "");
            }
        } catch (java.lang.Throwable th3) {
            com.alipay.sdk.m.u.e.a(th3);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, th3, java.util.Arrays.toString(c3));
            return com.alipay.sdk.m.j.b.a();
        }
    }

    private java.lang.String a(com.alipay.sdk.m.s.a aVar, java.lang.String str) {
        showLoading();
        com.alipay.sdk.m.j.c cVar = null;
        try {
            try {
                try {
                    org.json.JSONObject c2 = new com.alipay.sdk.m.q.f().a(aVar, this.a.getApplicationContext(), str).c();
                    java.lang.String optString = c2.optString("end_code", null);
                    java.util.List<com.alipay.sdk.m.r.b> a2 = com.alipay.sdk.m.r.b.a(c2.optJSONObject(com.alipay.sdk.m.l.c.c).optJSONObject(com.alipay.sdk.m.l.c.d));
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        if (a2.get(i2).a() == com.alipay.sdk.m.r.a.Update) {
                            com.alipay.sdk.m.r.b.a(a2.get(i2));
                        }
                    }
                    a(aVar, c2);
                    dismissLoading();
                    com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                    for (int i3 = 0; i3 < a2.size(); i3++) {
                        com.alipay.sdk.m.r.b bVar = a2.get(i3);
                        if (bVar.a() == com.alipay.sdk.m.r.a.WapPay) {
                            java.lang.String a3 = a(aVar, bVar);
                            dismissLoading();
                            com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                            return a3;
                        }
                        if (bVar.a() == com.alipay.sdk.m.r.a.OpenWeb) {
                            java.lang.String a4 = a(aVar, bVar, optString);
                            dismissLoading();
                            com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                            return a4;
                        }
                    }
                    dismissLoading();
                    com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                } catch (java.io.IOException e) {
                    com.alipay.sdk.m.j.c b2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.NETWORK_ERROR.b());
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.k, e);
                    dismissLoading();
                    com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                    cVar = b2;
                }
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, th);
                dismissLoading();
                com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
            }
            if (cVar == null) {
                cVar = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.FAILED.b());
            }
            return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
        } catch (java.lang.Throwable th2) {
            dismissLoading();
            com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
            throw th2;
        }
    }

    public static java.lang.String a(com.alipay.sdk.m.s.a aVar, java.lang.String str, java.util.List<com.alipay.sdk.m.m.a.b> list, java.lang.String str2, android.app.Activity activity) {
        com.alipay.sdk.m.u.n.c a2 = com.alipay.sdk.m.u.n.a(aVar, activity, list);
        if (a2 == null || a2.a(aVar) || a2.a() || !android.text.TextUtils.equals(a2.a.packageName, com.alipay.sdk.app.PayResultActivity.d)) {
            return str2;
        }
        com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "PayTask not_login");
        java.lang.String valueOf = java.lang.String.valueOf(str.hashCode());
        java.lang.Object obj = new java.lang.Object();
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = com.alipay.sdk.app.PayResultActivity.c;
        hashMap.put(valueOf, obj);
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.alipay.sdk.app.PayResultActivity.class);
        intent.putExtra(com.alipay.sdk.app.PayResultActivity.f, str);
        intent.putExtra(com.alipay.sdk.app.PayResultActivity.g, activity.getPackageName());
        intent.putExtra(com.alipay.sdk.app.PayResultActivity.e, valueOf);
        com.alipay.sdk.m.s.a.C0043a.a(aVar, intent);
        activity.startActivity(intent);
        synchronized (hashMap.get(valueOf)) {
            try {
                com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "PayTask wait");
                hashMap.get(valueOf).wait();
            } catch (java.lang.InterruptedException unused) {
                com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "PayTask interrupted");
                return com.alipay.sdk.m.j.b.a();
            }
        }
        java.lang.String str3 = com.alipay.sdk.app.PayResultActivity.b.b;
        com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "PayTask ret: " + str3);
        return str3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0108, code lost:
    
        if (com.alipay.sdk.m.m.a.D().s() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x016e, code lost:
    
        dismissLoading();
        com.alipay.sdk.m.k.a.b(r6.a.getApplicationContext(), r7, r8, r7.d);
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "pay returning: " + r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0161, code lost:
    
        com.alipay.sdk.m.m.a.D().a(r7, r6.a.getApplicationContext(), false, 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x015f, code lost:
    
        if (com.alipay.sdk.m.m.a.D().s() != false) goto L36;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized java.lang.String a(com.alipay.sdk.m.s.a aVar, java.lang.String str, boolean z) {
        java.lang.String str2;
        if (z) {
            showLoading();
        }
        if (str.contains("payment_inst=")) {
            java.lang.String substring = str.substring(str.indexOf("payment_inst=") + 13);
            int indexOf = substring.indexOf(38);
            if (indexOf > 0) {
                substring = substring.substring(0, indexOf);
            }
            com.alipay.sdk.m.j.a.a(substring.replaceAll("\"", "").toLowerCase(java.util.Locale.getDefault()).replaceAll("alipay", ""));
        } else {
            com.alipay.sdk.m.j.a.a("");
        }
        if (str.contains(com.alipay.sdk.m.l.a.v)) {
            com.alipay.sdk.m.l.a.w = true;
        }
        if (com.alipay.sdk.m.l.a.w) {
            if (str.startsWith(com.alipay.sdk.m.l.a.x)) {
                str = str.substring(str.indexOf(com.alipay.sdk.m.l.a.x) + 53);
            } else if (str.startsWith(com.alipay.sdk.m.l.a.y)) {
                str = str.substring(str.indexOf(com.alipay.sdk.m.l.a.y) + 52);
            }
        }
        str2 = "";
        try {
            com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "pay prepared: " + str);
            str2 = a(str, aVar);
            com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "pay raw result: " + str2);
            com.alipay.sdk.m.u.i.a(aVar, this.a.getApplicationContext(), str2);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.V, "" + android.os.SystemClock.elapsedRealtime());
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.W, com.alipay.sdk.m.u.l.a(str2, com.alipay.sdk.m.u.l.a) + "|" + com.alipay.sdk.m.u.l.a(str2, com.alipay.sdk.m.u.l.b));
        } catch (java.lang.Throwable th) {
            try {
                str2 = com.alipay.sdk.m.j.b.a();
                com.alipay.sdk.m.u.e.a(th);
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.V, "" + android.os.SystemClock.elapsedRealtime());
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.W, com.alipay.sdk.m.u.l.a(str2, com.alipay.sdk.m.u.l.a) + "|" + com.alipay.sdk.m.u.l.a(str2, com.alipay.sdk.m.u.l.b));
            } catch (java.lang.Throwable th2) {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.V, "" + android.os.SystemClock.elapsedRealtime());
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.W, com.alipay.sdk.m.u.l.a(str2, com.alipay.sdk.m.u.l.a) + "|" + com.alipay.sdk.m.u.l.a(str2, com.alipay.sdk.m.u.l.b));
                if (!com.alipay.sdk.m.m.a.D().s()) {
                    com.alipay.sdk.m.m.a.D().a(aVar, this.a.getApplicationContext(), false, 3);
                }
                dismissLoading();
                com.alipay.sdk.m.k.a.b(this.a.getApplicationContext(), aVar, str, aVar.d);
                throw th2;
            }
        }
        return str2;
    }

    private java.lang.String a(java.lang.String str, com.alipay.sdk.m.s.a aVar) {
        java.lang.String a2 = aVar.a(str);
        if (a2.contains("paymethod=\"expressGateway\"")) {
            return a(aVar, a2);
        }
        java.util.List<com.alipay.sdk.m.m.a.b> l = com.alipay.sdk.m.m.a.D().l();
        if (!com.alipay.sdk.m.m.a.D().h || l == null) {
            l = com.alipay.sdk.m.j.a.d;
        }
        if (!com.alipay.sdk.m.u.n.a(aVar, (android.content.Context) this.a, l, true)) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.j0);
            return a(aVar, a2);
        }
        com.alipay.sdk.m.u.h hVar = new com.alipay.sdk.m.u.h(this.a, aVar, a());
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "pay inner started: " + a2);
        java.lang.String a3 = hVar.a(a2, false);
        if (!android.text.TextUtils.isEmpty(a3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("resultStatus={");
            com.alipay.sdk.m.j.c cVar = com.alipay.sdk.m.j.c.ACTIVITY_NOT_START_EXIT;
            sb.append(cVar.b());
            sb.append(com.alipay.sdk.m.u.i.d);
            if (a3.contains(sb.toString())) {
                com.alipay.sdk.m.u.n.a("alipaySdk", com.alipay.sdk.m.l.b.q, this.a, aVar);
                if (com.alipay.sdk.m.m.a.D().A()) {
                    a3 = hVar.a(a2, true);
                } else {
                    a3 = a3.replace("resultStatus={" + cVar.b() + com.alipay.sdk.m.u.i.d, "resultStatus={" + com.alipay.sdk.m.j.c.CANCELED.b() + com.alipay.sdk.m.u.i.d);
                }
            }
        }
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "pay inner raw result: " + a3);
        hVar.a();
        boolean w = com.alipay.sdk.m.m.a.D().w();
        if (android.text.TextUtils.equals(a3, com.alipay.sdk.m.u.h.j) || android.text.TextUtils.equals(a3, com.alipay.sdk.m.u.h.k) || (w && aVar.e())) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.i0);
            return a(aVar, a2);
        }
        if (android.text.TextUtils.isEmpty(a3)) {
            return com.alipay.sdk.m.j.b.a();
        }
        if (!a3.contains(com.alipay.sdk.app.PayResultActivity.b)) {
            return a3;
        }
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.k0);
        return a(aVar, a2, l, a3, this.a);
    }

    private java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf(com.alipay.sdk.m.u.i.d));
    }

    private java.lang.String a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) throws java.io.UnsupportedEncodingException {
        boolean equals = "9000".equals(map.get(com.alipay.sdk.m.u.l.a));
        java.lang.String str2 = map.get("result");
        com.alipay.sdk.app.PayTask.c remove = this.g.remove(str);
        java.lang.String[] strArr = new java.lang.String[2];
        strArr[0] = remove != null ? remove.a() : "";
        strArr[1] = remove != null ? remove.d() : "";
        a(strArr);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str2.length() > 15) {
            java.lang.String a2 = a(com.alipay.sdk.m.u.n.a("&callBackUrl=\"", "\"", str2), com.alipay.sdk.m.u.n.a("&call_back_url=\"", "\"", str2), com.alipay.sdk.m.u.n.a(com.alipay.sdk.m.l.a.t, "\"", str2), java.net.URLDecoder.decode(com.alipay.sdk.m.u.n.a(com.alipay.sdk.m.l.a.u, "&", str2), "utf-8"), java.net.URLDecoder.decode(com.alipay.sdk.m.u.n.a("&callBackUrl=", "&", str2), "utf-8"), com.alipay.sdk.m.u.n.a("call_back_url=\"", "\"", str2));
            if (!android.text.TextUtils.isEmpty(a2)) {
                return a2;
            }
        }
        if (remove != null) {
            java.lang.String b2 = equals ? remove.b() : remove.c();
            if (!android.text.TextUtils.isEmpty(b2)) {
                return b2;
            }
        }
        return remove != null ? com.alipay.sdk.m.m.a.D().r() : "";
    }

    public static final java.lang.String a(java.lang.String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (java.lang.String str : strArr) {
            if (!android.text.TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    private void a(com.alipay.sdk.m.s.a aVar, org.json.JSONObject jSONObject) {
        try {
            java.lang.String optString = jSONObject.optString("tid");
            java.lang.String optString2 = jSONObject.optString(com.alipay.sdk.m.t.a.j);
            if (android.text.TextUtils.isEmpty(optString) || android.text.TextUtils.isEmpty(optString2)) {
                return;
            }
            com.alipay.sdk.m.t.a.a(com.alipay.sdk.m.s.b.d().b()).a(optString, optString2);
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.P, th);
        }
    }

    private boolean a(boolean z, boolean z2, java.lang.String str, java.lang.StringBuilder sb, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String... strArr) {
        java.lang.String str2;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str2 = "";
                break;
            }
            java.lang.String str3 = strArr[i2];
            if (!android.text.TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i2++;
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            return !z2;
        }
        if (!z) {
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append("\"");
            return true;
        }
        sb.append("&");
        sb.append(str);
        sb.append("=\"");
        sb.append(str2);
        sb.append("\"");
        return true;
    }

    public static synchronized boolean fetchSdkConfig(android.content.Context context) {
        synchronized (com.alipay.sdk.app.PayTask.class) {
            try {
                com.alipay.sdk.m.s.b.d().a(context);
                long elapsedRealtime = android.os.SystemClock.elapsedRealtime() / 1000;
                if (elapsedRealtime - i < com.alipay.sdk.m.m.a.D().d()) {
                    return false;
                }
                i = elapsedRealtime;
                com.alipay.sdk.m.m.a.D().a(com.alipay.sdk.m.s.a.h(), context.getApplicationContext(), false, 4);
                return true;
            } catch (java.lang.Exception e) {
                com.alipay.sdk.m.u.e.a(e);
                return false;
            }
        }
    }

    public void dismissLoading() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
            this.b = null;
        }
    }

    public synchronized java.lang.String fetchOrderInfoFromH5PayUrl(java.lang.String str) {
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                java.lang.String trim = str.trim();
                if (trim.startsWith("https://wappaygw.alipay.com/service/rest.htm") || trim.startsWith("http://wappaygw.alipay.com/service/rest.htm")) {
                    java.lang.String trim2 = trim.replaceFirst("(http|https)://wappaygw.alipay.com/service/rest.htm\\?", "").trim();
                    if (!android.text.TextUtils.isEmpty(trim2)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + com.alipay.sdk.m.u.n.a("<request_token>", "</request_token>", com.alipay.sdk.m.u.n.b(trim2).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.a) + "\"";
                    }
                }
                if (trim.startsWith("https://mclient.alipay.com/service/rest.htm") || trim.startsWith("http://mclient.alipay.com/service/rest.htm")) {
                    java.lang.String trim3 = trim.replaceFirst("(http|https)://mclient.alipay.com/service/rest.htm\\?", "").trim();
                    if (!android.text.TextUtils.isEmpty(trim3)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + com.alipay.sdk.m.u.n.a("<request_token>", "</request_token>", com.alipay.sdk.m.u.n.b(trim3).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.a) + "\"";
                    }
                }
                if ((trim.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm") || trim.startsWith("http://mclient.alipay.com/home/exterfaceAssign.htm")) && ((trim.contains("alipay.wap.create.direct.pay.by.user") || trim.contains("create_forex_trade_wap")) && !android.text.TextUtils.isEmpty(trim.replaceFirst("(http|https)://mclient.alipay.com/home/exterfaceAssign.htm\\?", "").trim()))) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("url", str);
                    jSONObject.put("bizcontext", a(this.a));
                    return com.alipay.sdk.m.s.a.C + jSONObject.toString();
                }
                if (java.util.regex.Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                    java.lang.String a2 = com.alipay.sdk.m.u.n.a("?", "", str);
                    if (!android.text.TextUtils.isEmpty(a2)) {
                        java.util.Map<java.lang.String, java.lang.String> b2 = com.alipay.sdk.m.u.n.b(a2);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        if (a(false, true, com.alipay.sdk.m.k.b.B0, sb, b2, com.alipay.sdk.m.k.b.B0, "alipay_trade_no")) {
                            a(true, false, "pay_phase_id", sb, b2, "payPhaseId", "pay_phase_id", "out_relation_id");
                            sb.append("&biz_sub_type=\"TRADE\"");
                            sb.append("&biz_type=\"trade\"");
                            java.lang.String str2 = b2.get("app_name");
                            if (android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.isEmpty(b2.get("cid"))) {
                                str2 = "ali1688";
                            } else if (android.text.TextUtils.isEmpty(str2) && (!android.text.TextUtils.isEmpty(b2.get("sid")) || !android.text.TextUtils.isEmpty(b2.get("s_id")))) {
                                str2 = "tb";
                            }
                            sb.append("&app_name=\"" + str2 + "\"");
                            if (!a(true, true, "extern_token", sb, b2, "extern_token", "cid", "sid", "s_id")) {
                                return "";
                            }
                            a(true, false, "appenv", sb, b2, "appenv");
                            sb.append("&pay_channel_id=\"alipay_sdk\"");
                            com.alipay.sdk.app.PayTask.c cVar = new com.alipay.sdk.app.PayTask.c(this, null);
                            cVar.b(b2.get("return_url"));
                            cVar.c(b2.get("show_url"));
                            cVar.a(b2.get("pay_order_id"));
                            java.lang.String str3 = sb.toString() + "&bizcontext=\"" + a(this.a) + "\"";
                            this.g.put(str3, cVar);
                            return str3;
                        }
                    }
                }
                if (!trim.startsWith("https://mclient.alipay.com/cashier/mobilepay.htm") && !trim.startsWith("http://mclient.alipay.com/cashier/mobilepay.htm") && (!com.alipay.sdk.app.EnvUtils.isSandBox() || !trim.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm"))) {
                    if (com.alipay.sdk.m.m.a.D().h() && java.util.regex.Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(trim).find()) {
                        android.net.Uri parse = android.net.Uri.parse(trim);
                        java.lang.String queryParameter = parse.getQueryParameter("return_url");
                        java.lang.String queryParameter2 = parse.getQueryParameter("show_url");
                        java.lang.String queryParameter3 = parse.getQueryParameter("pay_order_id");
                        java.lang.String a3 = a(parse.getQueryParameter("trade_nos"), parse.getQueryParameter("alipay_trade_no"));
                        java.lang.String a4 = a(parse.getQueryParameter("payPhaseId"), parse.getQueryParameter("pay_phase_id"), parse.getQueryParameter("out_relation_id"));
                        java.lang.String[] strArr = new java.lang.String[4];
                        strArr[0] = parse.getQueryParameter("app_name");
                        strArr[1] = !android.text.TextUtils.isEmpty(parse.getQueryParameter("cid")) ? "ali1688" : "";
                        strArr[2] = !android.text.TextUtils.isEmpty(parse.getQueryParameter("sid")) ? "tb" : "";
                        strArr[3] = !android.text.TextUtils.isEmpty(parse.getQueryParameter("s_id")) ? "tb" : "";
                        java.lang.String a5 = a(strArr);
                        java.lang.String a6 = a(parse.getQueryParameter("extern_token"), parse.getQueryParameter("cid"), parse.getQueryParameter("sid"), parse.getQueryParameter("s_id"));
                        java.lang.String a7 = a(parse.getQueryParameter("appenv"));
                        if (!android.text.TextUtils.isEmpty(a3) && !android.text.TextUtils.isEmpty(a5) && !android.text.TextUtils.isEmpty(a6)) {
                            java.lang.String format = java.lang.String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", a3, a4, a5, a6, a7, a(this.a));
                            com.alipay.sdk.app.PayTask.c cVar2 = new com.alipay.sdk.app.PayTask.c(this, null);
                            cVar2.b(queryParameter);
                            cVar2.c(queryParameter2);
                            cVar2.a(queryParameter3);
                            cVar2.d(a3);
                            this.g.put(format, cVar2);
                            return format;
                        }
                    }
                }
                java.lang.String a8 = a(this.a);
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put("url", trim);
                jSONObject2.put("bizcontext", a8);
                return java.lang.String.format("new_external_info==%s", jSONObject2.toString());
            }
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.u.e.a(th);
        }
        return "";
    }

    public synchronized java.lang.String fetchTradeToken() {
        return com.alipay.sdk.m.u.i.a(new com.alipay.sdk.m.s.a(this.a, "", "fetchTradeToken"), this.a.getApplicationContext());
    }

    public java.lang.String getVersion() {
        return "15.8.11";
    }

    public synchronized com.alipay.sdk.util.H5PayResultModel h5Pay(com.alipay.sdk.m.s.a aVar, java.lang.String str, boolean z) {
        com.alipay.sdk.util.H5PayResultModel h5PayResultModel;
        h5PayResultModel = new com.alipay.sdk.util.H5PayResultModel();
        try {
            java.lang.String[] split = a(aVar, str, z).split(com.alipay.sdk.m.u.i.b);
            java.util.HashMap hashMap = new java.util.HashMap();
            for (java.lang.String str2 : split) {
                int indexOf = str2.indexOf("={");
                if (indexOf >= 0) {
                    java.lang.String substring = str2.substring(0, indexOf);
                    hashMap.put(substring, a(str2, substring));
                }
            }
            if (hashMap.containsKey(com.alipay.sdk.m.u.l.a)) {
                h5PayResultModel.setResultCode(hashMap.get(com.alipay.sdk.m.u.l.a));
            }
            h5PayResultModel.setReturnUrl(a(str, hashMap));
            if (android.text.TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
                com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.n0, "");
            }
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.o0, th);
            com.alipay.sdk.m.u.e.a(th);
        }
        return h5PayResultModel;
    }

    public synchronized java.lang.String pay(java.lang.String str, boolean z) {
        if (com.alipay.sdk.m.u.b.a()) {
            return com.alipay.sdk.m.j.b.b();
        }
        return a(new com.alipay.sdk.m.s.a(this.a, str, "pay"), str, z);
    }

    public synchronized boolean payInterceptorWithUrl(java.lang.String str, boolean z, com.alipay.sdk.app.H5PayCallback h5PayCallback) {
        java.lang.String fetchOrderInfoFromH5PayUrl;
        fetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!android.text.TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl)) {
            com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "intercepted: " + fetchOrderInfoFromH5PayUrl);
            new java.lang.Thread(new com.alipay.sdk.app.PayTask.a(fetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
        }
        return !android.text.TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl);
    }

    public synchronized java.util.Map<java.lang.String, java.lang.String> payV2(java.lang.String str, boolean z) {
        java.lang.String a2;
        com.alipay.sdk.m.s.a aVar;
        if (com.alipay.sdk.m.u.b.a()) {
            a2 = com.alipay.sdk.m.j.b.b();
            aVar = null;
        } else {
            com.alipay.sdk.m.s.a aVar2 = new com.alipay.sdk.m.s.a(this.a, str, "payV2");
            a2 = a(aVar2, str, z);
            aVar = aVar2;
        }
        return com.alipay.sdk.m.u.l.a(aVar, a2);
    }

    public void showLoading() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }
}
