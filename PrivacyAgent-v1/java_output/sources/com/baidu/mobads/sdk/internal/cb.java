package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class cb extends android.os.Handler {
    final /* synthetic */ com.baidu.mobads.sdk.internal.bz a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb(com.baidu.mobads.sdk.internal.bz bzVar, android.os.Looper looper) {
        super(looper);
        this.a = bzVar;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        com.baidu.mobads.sdk.internal.bt btVar;
        boolean z;
        android.content.Context context;
        com.baidu.mobads.sdk.internal.bt btVar2;
        boolean z2;
        boolean p;
        java.lang.String string = message.getData().getString(com.baidu.mobads.sdk.internal.bz.n);
        com.baidu.mobads.sdk.internal.bx bxVar = (com.baidu.mobads.sdk.internal.bx) message.getData().getParcelable(com.baidu.mobads.sdk.internal.bz.m);
        if (!com.baidu.mobads.sdk.internal.bz.k.equals(string)) {
            btVar = this.a.z;
            btVar.a(com.baidu.mobads.sdk.internal.bz.a, "mOnApkDownloadCompleted: download failed, code: " + string);
            this.a.a(false);
            z = this.a.A;
            if (z) {
                this.a.A = false;
                this.a.a(false, "Refused to download remote for version...");
                return;
            }
            return;
        }
        java.lang.String e = bxVar.e();
        context = this.a.y;
        com.baidu.mobads.sdk.internal.bs bsVar = new com.baidu.mobads.sdk.internal.bs(e, context, bxVar);
        try {
            try {
                com.baidu.mobads.sdk.internal.bz bzVar = this.a;
                if (bzVar.u == com.baidu.mobads.sdk.internal.bz.t) {
                    bsVar.a();
                    bsVar.a(com.baidu.mobads.sdk.internal.bz.f());
                    if (com.baidu.mobads.sdk.internal.bz.p != null) {
                        com.baidu.mobads.sdk.internal.bz.p.b = bxVar.b();
                    }
                    this.a.l();
                    z2 = this.a.A;
                    if (z2) {
                        this.a.A = false;
                        com.baidu.mobads.sdk.internal.bz bzVar2 = this.a;
                        p = bzVar2.p();
                        bzVar2.a(p, "load remote file just downloaded");
                    }
                } else {
                    bzVar.a(bsVar);
                    bsVar.a(com.baidu.mobads.sdk.internal.bz.f());
                    this.a.a(true);
                }
            } catch (com.baidu.mobads.sdk.internal.bz.a e2) {
                java.lang.String str = "download apk file failed: " + e2.toString();
                this.a.a(false);
                btVar2 = this.a.z;
                btVar2.a(com.baidu.mobads.sdk.internal.bz.a, str);
            }
        } finally {
            bsVar.delete();
        }
    }
}
