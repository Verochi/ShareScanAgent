package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class bw implements com.baidu.mobads.sdk.internal.ci.a {
    final /* synthetic */ com.baidu.mobads.sdk.internal.bv a;

    public bw(com.baidu.mobads.sdk.internal.bv bvVar) {
        this.a = bvVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ci.a
    public void a(com.baidu.mobads.sdk.internal.bx bxVar) {
        this.a.a(com.baidu.mobads.sdk.internal.bz.k, bxVar, "download apk successfully, downloader exit");
        com.baidu.mobads.sdk.internal.bv unused = com.baidu.mobads.sdk.internal.bv.h = null;
    }

    @Override // com.baidu.mobads.sdk.internal.ci.a
    public void b(com.baidu.mobads.sdk.internal.bx bxVar) {
        this.a.a(com.baidu.mobads.sdk.internal.bz.l, bxVar, "downloadApk failed");
    }
}
