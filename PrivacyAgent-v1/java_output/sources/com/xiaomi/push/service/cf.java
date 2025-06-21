package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class cf {
    private com.xiaomi.push.service.ct a = new com.xiaomi.push.service.ct();

    public static com.xiaomi.push.service.aj.b a(com.xiaomi.push.ek ekVar) {
        java.util.Collection<com.xiaomi.push.service.aj.b> c = com.xiaomi.push.service.aj.a().c(java.lang.Integer.toString(ekVar.a.a));
        if (c.isEmpty()) {
            return null;
        }
        java.util.Iterator<com.xiaomi.push.service.aj.b> it = c.iterator();
        if (c.size() == 1) {
            return it.next();
        }
        java.lang.String b = ekVar.b();
        while (it.hasNext()) {
            com.xiaomi.push.service.aj.b next = it.next();
            if (android.text.TextUtils.equals(b, next.b)) {
                return next;
            }
        }
        return null;
    }

    public static com.xiaomi.push.service.aj.b a(com.xiaomi.push.fn fnVar) {
        java.util.Collection<com.xiaomi.push.service.aj.b> c = com.xiaomi.push.service.aj.a().c(fnVar.t);
        if (c.isEmpty()) {
            return null;
        }
        java.util.Iterator<com.xiaomi.push.service.aj.b> it = c.iterator();
        if (c.size() == 1) {
            return it.next();
        }
        java.lang.String str = fnVar.f466s;
        java.lang.String str2 = fnVar.r;
        while (it.hasNext()) {
            com.xiaomi.push.service.aj.b next = it.next();
            if (android.text.TextUtils.equals(str, next.b) || android.text.TextUtils.equals(str2, next.b)) {
                return next;
            }
        }
        return null;
    }

    private static java.lang.String a(com.xiaomi.push.service.aj.b bVar) {
        java.lang.StringBuilder sb;
        java.lang.String str;
        if ("9".equals(bVar.h)) {
            sb = new java.lang.StringBuilder();
            sb.append(bVar.a);
            str = ".permission.MIMC_RECEIVE";
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(bVar.a);
            str = ".permission.MIPUSH_RECEIVE";
        }
        sb.append(str);
        return sb.toString();
    }

    public static void a(android.content.Context context, android.content.Intent intent, com.xiaomi.push.service.aj.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    @android.annotation.SuppressLint({"DefaultLocale"})
    public static void a(android.content.Context context, com.xiaomi.push.service.aj.b bVar, int i) {
        if ("5".equalsIgnoreCase(bVar.h)) {
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.a);
        intent.putExtra(com.xiaomi.push.service.an.t, bVar.h);
        intent.putExtra("ext_reason", i);
        intent.putExtra(com.xiaomi.push.service.an.q, bVar.b);
        intent.putExtra(com.xiaomi.push.service.an.F, bVar.j);
        if (bVar.r == null || !"9".equals(bVar.h)) {
            com.xiaomi.channel.commonutils.logger.b.a(java.lang.String.format("[Bcst] notify channel closed. %s,%s,%d", bVar.h, bVar.a, java.lang.Integer.valueOf(i)));
            a(context, intent, bVar);
            return;
        }
        try {
            bVar.r.send(android.os.Message.obtain(null, 17, intent));
        } catch (android.os.RemoteException unused) {
            bVar.r = null;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("peer may died: ");
            java.lang.String str = bVar.b;
            sb.append(str.substring(str.lastIndexOf(64)));
            com.xiaomi.channel.commonutils.logger.b.a(sb.toString());
        }
    }

    public static void a(android.content.Context context, com.xiaomi.push.service.aj.b bVar, java.lang.String str, java.lang.String str2) {
        if ("5".equalsIgnoreCase(bVar.h)) {
            com.xiaomi.channel.commonutils.logger.b.d("mipush kicked by server");
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.h);
        intent.putExtra(com.xiaomi.push.service.an.q, bVar.b);
        intent.putExtra(com.xiaomi.push.service.an.F, bVar.j);
        com.xiaomi.channel.commonutils.logger.b.a(java.lang.String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVar.h, bVar.a, str2));
        a(context, intent, bVar);
    }

    @android.annotation.SuppressLint({"DefaultLocale"})
    public static void a(android.content.Context context, com.xiaomi.push.service.aj.b bVar, boolean z, int i, java.lang.String str) {
        if ("5".equalsIgnoreCase(bVar.h)) {
            com.xiaomi.push.service.ct.a(context, z, str);
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.h);
        intent.putExtra(com.xiaomi.push.service.an.q, bVar.b);
        intent.putExtra(com.xiaomi.push.service.an.F, bVar.j);
        com.xiaomi.channel.commonutils.logger.b.a(java.lang.String.format("[Bcst] notify channel open result. %s,%s,%b,%d", bVar.h, bVar.a, java.lang.Boolean.valueOf(z), java.lang.Integer.valueOf(i)));
        a(context, intent, bVar);
    }
}
