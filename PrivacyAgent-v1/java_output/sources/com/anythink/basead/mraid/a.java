package com.anythink.basead.mraid;

/* loaded from: classes12.dex */
public final class a implements com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge {
    com.anythink.basead.mraid.c a;
    java.lang.ref.WeakReference<android.app.Activity> b;
    private com.anythink.basead.mraid.b c;

    private void a(android.app.Activity activity) {
        this.b = new java.lang.ref.WeakReference<>(activity);
    }

    public final void a(com.anythink.basead.mraid.b bVar) {
        if (bVar != null) {
            this.c = bVar;
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void cai(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void click(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void close() {
        com.anythink.basead.mraid.b bVar = this.c;
        if (bVar != null) {
            bVar.close();
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void expand(java.lang.String str, boolean z) {
        android.app.Activity activity;
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z);
            java.lang.ref.WeakReference<android.app.Activity> weakReference = this.b;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return;
            }
            com.anythink.basead.mraid.c cVar = this.a;
            if (cVar == null || !cVar.isShowing()) {
                com.anythink.basead.mraid.c cVar2 = new com.anythink.basead.mraid.c(activity, bundle, this.c);
                this.a = cVar2;
                cVar2.show();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void getFileInfo(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final com.anythink.expressad.foundation.d.c getMraidCampaign() {
        return null;
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void getNetstat(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void gial(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void handlerH5Exception(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void increaseOfferFrequence(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void init(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void install(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void onJSBridgeConnect(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void open(java.lang.String str) {
        com.anythink.basead.mraid.b bVar = this.c;
        if (bVar != null) {
            bVar.open(str);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void openURL(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void readyStatus(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void reportUrls(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void resetCountdown(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void sendImpressions(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void toggleCloseBtn(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void triggerCloseBtn(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void unload() {
        close();
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void useCustomClose(boolean z) {
        try {
            com.anythink.basead.mraid.b bVar = this.c;
            if (bVar != null) {
                bVar.useCustomClose(z);
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
