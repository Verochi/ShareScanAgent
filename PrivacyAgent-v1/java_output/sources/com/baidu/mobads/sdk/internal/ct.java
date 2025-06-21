package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class ct implements com.baidu.mobads.sdk.api.IOAdEventListener {
    final /* synthetic */ com.baidu.mobads.sdk.internal.cs a;

    public ct(com.baidu.mobads.sdk.internal.cs csVar) {
        this.a = csVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.a.c((java.util.Map<java.lang.String, java.lang.Object>) iOAdEvent.getData());
        }
    }
}
