package com.xiaomi.push;

/* loaded from: classes19.dex */
public class aa implements com.xiaomi.push.u {
    private static volatile com.xiaomi.push.aa a;
    private com.xiaomi.push.u b;
    private int c;

    private aa(android.content.Context context) {
        com.xiaomi.push.u adVar;
        if (com.xiaomi.push.iu.a()) {
            com.xiaomi.push.y.a = 1;
            adVar = new com.xiaomi.push.x(context);
        } else if (com.xiaomi.push.t.a(context)) {
            com.xiaomi.push.y.a = 2;
            adVar = new com.xiaomi.push.t(context);
        } else if (com.xiaomi.push.ab.a(context)) {
            com.xiaomi.push.y.a = 4;
            adVar = new com.xiaomi.push.ab(context);
        } else if (com.xiaomi.push.ae.a(context)) {
            com.xiaomi.push.y.a = 5;
            adVar = new com.xiaomi.push.ae(context);
        } else if (com.xiaomi.push.w.a(context)) {
            com.xiaomi.push.y.a = 3;
            adVar = new com.xiaomi.push.v(context);
        } else {
            com.xiaomi.push.y.a = 0;
            adVar = new com.xiaomi.push.ad();
        }
        this.b = adVar;
        this.c = com.xiaomi.push.y.a;
        com.xiaomi.channel.commonutils.logger.b.a("create id manager is: " + this.c);
    }

    public static com.xiaomi.push.aa a(android.content.Context context) {
        if (a == null) {
            synchronized (com.xiaomi.push.aa.class) {
                if (a == null) {
                    a = new com.xiaomi.push.aa(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    public final void a(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            return;
        }
        if (!android.text.TextUtils.isEmpty(null)) {
            map.put("udid", null);
        }
        java.lang.String b = b();
        if (!android.text.TextUtils.isEmpty(b)) {
            map.put("oaid", b);
        }
        if (!android.text.TextUtils.isEmpty(null)) {
            map.put("vaid", null);
        }
        if (!android.text.TextUtils.isEmpty(null)) {
            map.put("aaid", null);
        }
        map.put("oaid_type", java.lang.String.valueOf(this.c));
    }

    @Override // com.xiaomi.push.u
    public final boolean a() {
        return this.b.a();
    }

    @Override // com.xiaomi.push.u
    public final java.lang.String b() {
        java.lang.String b = this.b.b();
        return b == null ? "" : b;
    }
}
