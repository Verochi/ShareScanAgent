package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class af implements com.baidu.mobads.sdk.api.IOAdEventListener {
    final /* synthetic */ com.baidu.mobads.sdk.internal.ae a;

    public af(com.baidu.mobads.sdk.internal.ae aeVar) {
        this.a = aeVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.a.c((java.util.Map<java.lang.String, java.lang.Object>) iOAdEvent.getData());
        }
    }
}
