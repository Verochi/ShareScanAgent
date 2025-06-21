package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class cg implements com.baidu.mobads.sdk.internal.an.a {
    final /* synthetic */ com.baidu.mobads.sdk.internal.bz a;

    public cg(com.baidu.mobads.sdk.internal.bz bzVar) {
        this.a = bzVar;
    }

    @Override // com.baidu.mobads.sdk.internal.an.a
    public void a() {
        boolean z;
        z = this.a.A;
        if (z) {
            this.a.A = false;
            this.a.a(false, "remote update Network access failed");
        }
    }
}
