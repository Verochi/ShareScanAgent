package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class ak implements com.baidu.mobads.sdk.internal.g.b {
    @Override // com.baidu.mobads.sdk.internal.g.b
    public void a(com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
        if (nativeResponse instanceof com.baidu.mobads.sdk.api.XAdNativeResponse) {
            ((com.baidu.mobads.sdk.api.XAdNativeResponse) nativeResponse).onADStatusChanged();
        }
    }
}
