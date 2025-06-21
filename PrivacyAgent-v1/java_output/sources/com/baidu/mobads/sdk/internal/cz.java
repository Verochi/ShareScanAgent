package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class cz implements com.baidu.mobads.sdk.api.IOAdEventListener {
    final /* synthetic */ com.baidu.mobads.sdk.internal.cx a;

    public cz(com.baidu.mobads.sdk.internal.cx cxVar) {
        this.a = cxVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.a.z();
        }
    }
}
