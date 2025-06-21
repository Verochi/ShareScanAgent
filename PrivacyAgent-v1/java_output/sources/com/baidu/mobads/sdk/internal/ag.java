package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class ag implements com.baidu.mobads.sdk.api.IOAdEventListener {
    final /* synthetic */ com.baidu.mobads.sdk.internal.ae a;

    public ag(com.baidu.mobads.sdk.internal.ae aeVar) {
        this.a = aeVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.a.x();
        }
    }
}
