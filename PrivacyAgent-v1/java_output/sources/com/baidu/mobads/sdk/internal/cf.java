package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class cf implements com.baidu.mobads.sdk.internal.am.b {
    final /* synthetic */ double a;
    final /* synthetic */ com.baidu.mobads.sdk.internal.bz b;

    public cf(com.baidu.mobads.sdk.internal.bz bzVar, double d) {
        this.b = bzVar;
        this.a = d;
    }

    @Override // com.baidu.mobads.sdk.internal.am.b
    public void a(java.lang.String str, int i) {
        boolean z;
        z = this.b.A;
        if (z) {
            this.b.A = false;
            this.b.a(false, "remote update Network access failed");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0055, code lost:
    
        if (r9 == java.lang.Math.floor(r4.b())) goto L12;
     */
    @Override // com.baidu.mobads.sdk.internal.am.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences m;
        com.baidu.mobads.sdk.internal.bx bxVar;
        com.baidu.mobads.sdk.internal.bx bxVar2;
        com.baidu.mobads.sdk.internal.bt btVar;
        com.baidu.mobads.sdk.internal.bx bxVar3;
        boolean z;
        com.baidu.mobads.sdk.internal.bx bxVar4;
        com.baidu.mobads.sdk.internal.bx bxVar5;
        com.baidu.mobads.sdk.internal.bx bxVar6;
        com.baidu.mobads.sdk.internal.bx bxVar7;
        this.b.w = new com.baidu.mobads.sdk.internal.bx(str);
        double b = com.baidu.mobads.sdk.internal.cm.b();
        m = this.b.m();
        float f = m.getFloat(com.baidu.mobads.sdk.internal.bz.c, 0.0f);
        bxVar = this.b.w;
        boolean z2 = true;
        java.lang.Boolean valueOf = java.lang.Boolean.valueOf(((float) bxVar.b()) == f);
        bxVar2 = this.b.w;
        if (b <= bxVar2.b()) {
            double floor = java.lang.Math.floor(b);
            bxVar7 = this.b.w;
        }
        z2 = false;
        java.lang.Boolean valueOf2 = java.lang.Boolean.valueOf(z2);
        btVar = this.b.z;
        btVar.a(com.baidu.mobads.sdk.internal.bz.a, "try to download apk badVer=" + f + ", isBad=" + valueOf + ", compatible=" + valueOf2);
        double d = this.a;
        bxVar3 = this.b.w;
        if (d < bxVar3.b()) {
            bxVar4 = this.b.w;
            if (bxVar4 != null) {
                bxVar5 = this.b.w;
                if (bxVar5.a().booleanValue() && valueOf2.booleanValue() && !valueOf.booleanValue()) {
                    com.baidu.mobads.sdk.internal.bz bzVar = this.b;
                    bxVar6 = bzVar.w;
                    bzVar.a(bxVar6);
                    return;
                }
            }
        }
        z = this.b.A;
        if (z) {
            this.b.A = false;
            this.b.a(false, "Refused to download remote for version...");
        }
    }
}
