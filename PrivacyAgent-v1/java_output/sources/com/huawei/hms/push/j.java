package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class j {
    public static final java.lang.String[] a = {"url", "app", "cosa", "rp"};
    public android.content.Context b;
    public com.huawei.hms.push.k c;

    public j(android.content.Context context, com.huawei.hms.push.k kVar) {
        this.b = context;
        this.c = kVar;
    }

    public static boolean a(java.lang.String str) {
        for (java.lang.String str2 : a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final void a() {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("enter launchApp, appPackageName =");
            sb.append(this.c.d());
            com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", sb.toString());
            if (com.huawei.hms.push.q.c(this.b, this.c.d())) {
                b();
            }
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e("PushSelfShowLog", "launchApp error:" + e.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00ba, code lost:
    
        if (com.huawei.hms.push.q.a(r6.b, r6.c.d(), r2).booleanValue() != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
    
        if (r3 != false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c5 A[Catch: Exception -> 0x00e1, TryCatch #1 {Exception -> 0x00e1, blocks: (B:3:0x0007, B:5:0x000e, B:7:0x001c, B:17:0x00c1, B:20:0x00c5, B:22:0x00d0, B:23:0x00db, B:25:0x00d6, B:10:0x0097, B:12:0x009f, B:33:0x007e, B:35:0x0085, B:27:0x0044, B:29:0x0059), top: B:2:0x0007, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        android.content.Intent parseUri;
        com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", "run into launchCosaApp");
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("enter launchExistApp cosa, appPackageName =");
            sb.append(this.c.d());
            sb.append(",and msg.intentUri is ");
            sb.append(this.c.n());
            com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", sb.toString());
            android.content.Intent b = com.huawei.hms.push.q.b(this.b, this.c.d());
            boolean z = false;
            if (this.c.n() == null) {
                if (this.c.a() != null) {
                    parseUri = new android.content.Intent(this.c.a());
                }
                if (b != null) {
                    com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", "launchCosaApp,intent == null");
                    return;
                }
                b.setPackage(this.c.d());
                if (z) {
                    b.addFlags(268435456);
                } else {
                    b.setFlags(805437440);
                }
                this.b.startActivity(b);
                return;
            }
            try {
                parseUri = android.content.Intent.parseUri(this.c.n(), 0);
                parseUri.setSelector(null);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Intent.parseUri(msg.intentUri, 0), action:");
                sb2.append(parseUri.getAction());
                com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", sb2.toString());
                z = com.huawei.hms.push.q.a(this.b, this.c.d(), parseUri).booleanValue();
            } catch (java.lang.Exception e) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("intentUri error.");
                sb3.append(e.toString());
                com.huawei.hms.support.log.HMSLog.w("PushSelfShowLog", sb3.toString());
            }
            b = parseUri;
            if (b != null) {
            }
        } catch (java.lang.Exception e2) {
            com.huawei.hms.support.log.HMSLog.e("PushSelfShowLog", "launch Cosa App exception." + e2.toString());
        }
    }

    public void c() {
        com.huawei.hms.push.k kVar;
        com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "enter launchNotify()");
        if (this.b == null || (kVar = this.c) == null) {
            com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
            return;
        }
        if ("app".equals(kVar.i())) {
            a();
            return;
        }
        if ("cosa".equals(this.c.i())) {
            b();
            return;
        }
        if ("rp".equals(this.c.i())) {
            com.huawei.hms.support.log.HMSLog.w("PushSelfShowLog", this.c.i() + " not support rich message.");
            return;
        }
        if ("url".equals(this.c.i())) {
            com.huawei.hms.support.log.HMSLog.w("PushSelfShowLog", this.c.i() + " not support URL.");
            return;
        }
        com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", this.c.i() + " is not exist in hShowType");
    }
}
