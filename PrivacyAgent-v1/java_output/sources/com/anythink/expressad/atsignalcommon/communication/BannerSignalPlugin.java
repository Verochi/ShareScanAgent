package com.anythink.expressad.atsignalcommon.communication;

/* loaded from: classes12.dex */
public class BannerSignalPlugin extends com.anythink.expressad.atsignalcommon.windvane.l {
    private final java.lang.String a = "BannerSignalPlugin";
    private com.anythink.expressad.atsignalcommon.communication.b b;

    public void click(java.lang.Object obj, java.lang.String str) {
    }

    public void getFileInfo(java.lang.Object obj, java.lang.String str) {
    }

    public void getNetstat(java.lang.Object obj, java.lang.String str) {
    }

    public void handlerH5Exception(java.lang.Object obj, java.lang.String str) {
    }

    public void increaseOfferFrequence(java.lang.Object obj, java.lang.String str) {
    }

    public void init(java.lang.Object obj, java.lang.String str) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(android.content.Context context, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof com.anythink.expressad.atsignalcommon.communication.b) {
                this.b = (com.anythink.expressad.atsignalcommon.communication.b) context;
            } else {
                if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof com.anythink.expressad.atsignalcommon.communication.b)) {
                    return;
                }
                this.b = (com.anythink.expressad.atsignalcommon.communication.b) windVaneWebView.getObject();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void install(java.lang.Object obj, java.lang.String str) {
    }

    public void onSignalCommunication(java.lang.Object obj, java.lang.String str) {
    }

    public void openURL(java.lang.Object obj, java.lang.String str) {
    }

    public void readyStatus(java.lang.Object obj, java.lang.String str) {
    }

    public void reportUrls(java.lang.Object obj, java.lang.String str) {
    }

    public void resetCountdown(java.lang.Object obj, java.lang.String str) {
    }

    public void sendImpressions(java.lang.Object obj, java.lang.String str) {
    }

    public void toggleCloseBtn(java.lang.Object obj, java.lang.String str) {
    }

    public void triggerCloseBtn(java.lang.Object obj, java.lang.String str) {
    }
}
