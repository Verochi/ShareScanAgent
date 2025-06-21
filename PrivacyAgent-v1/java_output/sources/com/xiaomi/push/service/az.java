package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class az extends com.xiaomi.push.p.b {
    boolean a = false;
    final /* synthetic */ com.xiaomi.push.service.ay b;

    public az(com.xiaomi.push.service.ay ayVar) {
        this.b = ayVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044 A[Catch: Exception -> 0x0052, TRY_LEAVE, TryCatch #0 {Exception -> 0x0052, blocks: (B:2:0x0000, B:4:0x0012, B:8:0x0024, B:10:0x0044), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    @Override // com.xiaomi.push.p.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        java.lang.String str;
        com.xiaomi.push.cw.a aVar;
        try {
            java.lang.String a = com.xiaomi.push.service.d.a(com.xiaomi.push.jc.a()).a();
            if (!android.text.TextUtils.isEmpty(a) && !com.xiaomi.push.iy.China.name().equals(a)) {
                str = "https://resolver.msg.global.xiaomi.net/psc/?t=a";
                aVar = (com.xiaomi.push.cw.a) new com.xiaomi.push.cw.a().b(android.util.Base64.decode(com.xiaomi.push.bz.a(com.xiaomi.push.jc.a(), str, new com.xiaomi.push.bz.a()), 10));
                if (aVar == null) {
                    this.b.a = aVar;
                    this.a = true;
                    com.xiaomi.push.service.ay.a(this.b);
                    return;
                }
                return;
            }
            str = "https://resolver.msg.xiaomi.net/psc/?t=a";
            aVar = (com.xiaomi.push.cw.a) new com.xiaomi.push.cw.a().b(android.util.Base64.decode(com.xiaomi.push.bz.a(com.xiaomi.push.jc.a(), str, new com.xiaomi.push.bz.a()), 10));
            if (aVar == null) {
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.push.p.b
    public final void b() {
        java.util.List list;
        java.util.List list2;
        com.xiaomi.push.service.ay.a[] aVarArr;
        com.xiaomi.push.cw.a unused;
        com.xiaomi.push.service.ay.b(this.b);
        if (this.a) {
            synchronized (this.b) {
                list = this.b.c;
                list2 = this.b.c;
                aVarArr = (com.xiaomi.push.service.ay.a[]) list.toArray(new com.xiaomi.push.service.ay.a[list2.size()]);
            }
            int length = aVarArr.length;
            for (int i = 0; i < length; i++) {
                unused = this.b.a;
            }
        }
    }
}
