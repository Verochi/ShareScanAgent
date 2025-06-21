package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class p implements com.baidu.mobads.sdk.api.IOAdEventListener {
    final /* synthetic */ com.baidu.mobads.sdk.internal.o a;

    public p(com.baidu.mobads.sdk.internal.o oVar) {
        this.a = oVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        com.baidu.mobads.sdk.internal.bi.a(new com.baidu.mobads.sdk.internal.q(this, iOAdEvent));
    }
}
