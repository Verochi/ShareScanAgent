package com.anythink.expressad.video.signal.a;

/* loaded from: classes12.dex */
public class d implements com.anythink.expressad.video.signal.e, com.anythink.expressad.video.signal.h {
    protected static final java.lang.String j = "DefaultJSContainerModule";

    @Override // com.anythink.expressad.video.signal.e
    public void configurationChanged(int i, int i2, int i3) {
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean endCardShowing() {
        return true;
    }

    @Override // com.anythink.expressad.video.signal.e, com.anythink.expressad.video.signal.h
    public void handlerPlayableException(java.lang.String str) {
    }

    @Override // com.anythink.expressad.video.signal.e
    public void hideAlertWebview() {
    }

    @Override // com.anythink.expressad.video.signal.h
    public void install(com.anythink.expressad.foundation.d.c cVar) {
        java.util.Objects.toString(cVar);
    }

    @Override // com.anythink.expressad.video.signal.e
    public void ivRewardAdsWithoutVideo(java.lang.String str) {
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean miniCardLoaded() {
        return false;
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean miniCardShowing() {
        return false;
    }

    @Override // com.anythink.expressad.video.signal.h
    public void notifyCloseBtn(int i) {
    }

    @Override // com.anythink.expressad.video.signal.h
    public void orientation(android.content.res.Configuration configuration) {
        java.util.Objects.toString(configuration);
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
    }

    @Override // com.anythink.expressad.video.signal.e, com.anythink.expressad.video.signal.h
    public void readyStatus(int i) {
    }

    @Override // com.anythink.expressad.video.signal.e
    public void resizeMiniCard(int i, int i2, int i3) {
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean showAlertWebView() {
        return false;
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showEndcard(int i) {
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showMiniCard(int i, int i2, int i3, int i4, int i5) {
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showPlayableView() {
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showVideoClickView(int i) {
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showVideoEndCover() {
    }

    @Override // com.anythink.expressad.video.signal.h
    public void toggleCloseBtn(int i) {
    }

    @Override // com.anythink.expressad.video.signal.h
    public void webviewshow() {
    }
}
