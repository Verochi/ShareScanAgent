package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class cu implements com.baidu.mobads.sdk.api.IOAdEventListener {
    final /* synthetic */ com.baidu.mobads.sdk.internal.cs a;

    public cu(com.baidu.mobads.sdk.internal.cs csVar) {
        this.a = csVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.a.g();
        }
    }
}
