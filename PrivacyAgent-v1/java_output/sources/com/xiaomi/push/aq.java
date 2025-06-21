package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class aq extends com.xiaomi.push.m.a {
    private android.content.Context a;

    public aq(android.content.Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.m.a
    public final java.lang.String a() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (com.xiaomi.a.b.b.a(this.a).a().c) {
                com.xiaomi.a.b.b a = com.xiaomi.a.b.b.a(this.a);
                if (a.a().c) {
                    com.xiaomi.push.ar arVar = new com.xiaomi.push.ar();
                    arVar.a = a.h;
                    arVar.b = a.d;
                    a.a.execute(arVar);
                }
                com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + " perf begin upload");
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to send perf data. ".concat(java.lang.String.valueOf(e)));
        }
    }
}
