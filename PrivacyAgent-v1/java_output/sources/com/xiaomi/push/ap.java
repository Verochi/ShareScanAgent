package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ap extends com.xiaomi.push.m.a {
    private android.content.Context a;

    public ap(android.content.Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.m.a
    public final java.lang.String a() {
        return "100886";
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (com.xiaomi.a.b.b.a(this.a).a().b) {
                com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + " begin upload event");
                com.xiaomi.a.b.b a = com.xiaomi.a.b.b.a(this.a);
                if (a.a().b) {
                    com.xiaomi.push.ar arVar = new com.xiaomi.push.ar();
                    arVar.b = a.d;
                    arVar.a = a.g;
                    a.a.execute(arVar);
                }
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
