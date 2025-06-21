package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class p extends java.lang.Thread {
    public android.content.Context a;
    public com.huawei.hms.push.k b;

    public p(android.content.Context context, com.huawei.hms.push.k kVar) {
        this.a = context;
        this.b = kVar;
    }

    public static android.content.Intent a(android.content.Context context, com.huawei.hms.push.k kVar) {
        if (kVar == null) {
            return null;
        }
        android.content.Intent b = com.huawei.hms.push.q.b(context, kVar.d());
        if (kVar.n() == null) {
            if (kVar.a() != null) {
                android.content.Intent intent = new android.content.Intent(kVar.a());
                if (com.huawei.hms.push.q.a(context, kVar.d(), intent).booleanValue()) {
                    b = intent;
                }
            }
            b.setPackage(kVar.d());
            return b;
        }
        try {
            android.content.Intent parseUri = android.content.Intent.parseUri(kVar.n(), 0);
            parseUri.setSelector(null);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Intent.parseUri(msg.intentUri, 0), action:");
            sb.append(parseUri.getAction());
            com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", sb.toString());
            return com.huawei.hms.push.q.a(context, kVar.d(), parseUri).booleanValue() ? parseUri : b;
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.w("PushSelfShowLog", "intentUri error," + e.toString());
            return b;
        }
    }

    public final boolean a(android.content.Context context) {
        return com.huawei.hms.push.q.c(context, this.b.d());
    }

    public final boolean b(android.content.Context context) {
        if ("cosa".equals(this.b.i())) {
            return a(context);
        }
        return true;
    }

    public final boolean b(android.content.Context context, com.huawei.hms.push.k kVar) {
        if (!"cosa".equals(kVar.i()) || a(context, kVar) != null) {
            return false;
        }
        com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", "enter run()");
        try {
            if (!b(this.a) || b(this.a, this.b)) {
                return;
            }
            com.huawei.hms.push.o.a(this.a, this.b);
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e("PushSelfShowLog", e.toString());
        }
    }
}
