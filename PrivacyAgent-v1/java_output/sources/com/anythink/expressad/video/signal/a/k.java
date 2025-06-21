package com.anythink.expressad.video.signal.a;

/* loaded from: classes12.dex */
public final class k extends com.anythink.expressad.video.signal.a.d {
    private com.anythink.expressad.video.module.AnythinkContainerView k;

    public k(com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView) {
        this.k = anythinkContainerView;
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final void configurationChanged(int i, int i2, int i3) {
        super.configurationChanged(i, i2, i3);
        try {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
            if (anythinkContainerView != null) {
                anythinkContainerView.configurationChanged(i, i2, i3);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final boolean endCardShowing() {
        try {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
            if (anythinkContainerView != null) {
                return anythinkContainerView.endCardShowing();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return super.endCardShowing();
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final void hideAlertWebview() {
        super.hideAlertWebview();
        com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
        if (anythinkContainerView != null) {
            anythinkContainerView.hideAlertWebview();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.h
    public final void install(com.anythink.expressad.foundation.d.c cVar) {
        super.install(cVar);
        try {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
            if (anythinkContainerView != null) {
                anythinkContainerView.install(cVar);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final void ivRewardAdsWithoutVideo(java.lang.String str) {
        super.ivRewardAdsWithoutVideo(str);
        com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
        if (anythinkContainerView != null) {
            anythinkContainerView.ivRewardAdsWithoutVideo(str);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final boolean miniCardLoaded() {
        try {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
            if (anythinkContainerView != null) {
                return anythinkContainerView.miniCardLoaded();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return super.miniCardLoaded();
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final boolean miniCardShowing() {
        try {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
            if (anythinkContainerView != null) {
                return anythinkContainerView.miniCardShowing();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return super.miniCardShowing();
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.h
    public final void orientation(android.content.res.Configuration configuration) {
        super.orientation(configuration);
        try {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
            if (anythinkContainerView != null) {
                anythinkContainerView.orientation(configuration);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.f
    public final void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        super.preLoadData(bVar);
        try {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
            if (anythinkContainerView != null) {
                anythinkContainerView.preLoadData(bVar);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e, com.anythink.expressad.video.signal.h
    public final void readyStatus(int i) {
        try {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
            if (anythinkContainerView != null) {
                anythinkContainerView.readyStatus(i);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        super.readyStatus(i);
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final void resizeMiniCard(int i, int i2, int i3) {
        super.resizeMiniCard(i, i2, i3);
        try {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
            if (anythinkContainerView != null) {
                anythinkContainerView.resizeMiniCard(i, i2, i3);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final boolean showAlertWebView() {
        super.showAlertWebView();
        com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
        if (anythinkContainerView != null) {
            return anythinkContainerView.showAlertWebView();
        }
        return false;
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final void showEndcard(int i) {
        super.showEndcard(i);
        try {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
            if (anythinkContainerView != null) {
                anythinkContainerView.showEndcard(i);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final void showMiniCard(int i, int i2, int i3, int i4, int i5) {
        super.showMiniCard(i, i2, i3, i4, i5);
        try {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
            if (anythinkContainerView != null) {
                anythinkContainerView.showMiniCard(i, i2, i3, i4, i5);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final void showPlayableView() {
        super.showPlayableView();
        try {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
            if (anythinkContainerView != null) {
                anythinkContainerView.showPlayableView();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.e
    public final void showVideoClickView(int i) {
        super.showVideoClickView(i);
        com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
        if (anythinkContainerView != null) {
            anythinkContainerView.showVideoClickView(i);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.h
    public final void toggleCloseBtn(int i) {
        super.toggleCloseBtn(i);
        try {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
            if (anythinkContainerView != null) {
                anythinkContainerView.toggleCloseBtn(i);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.d, com.anythink.expressad.video.signal.h
    public final void webviewshow() {
        super.webviewshow();
        try {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.k;
            if (anythinkContainerView != null) {
                anythinkContainerView.webviewshow();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
