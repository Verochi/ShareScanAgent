package com.anythink.expressad.video.signal.a;

/* loaded from: classes12.dex */
public final class n extends com.anythink.expressad.video.signal.a.g {
    private com.anythink.expressad.video.module.AnythinkVideoView t;

    public n(com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView) {
        this.t = anythinkVideoView;
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final void alertWebViewShowed() {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        if (anythinkVideoView != null) {
            anythinkVideoView.alertWebViewShowed();
        } else {
            super.alertWebViewShowed();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final void closeVideoOperate(int i, int i2) {
        super.closeVideoOperate(i, i2);
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        if (anythinkVideoView != null) {
            anythinkVideoView.closeVideoOperate(i, i2);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final void dismissAllAlert() {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        if (anythinkVideoView != null) {
            anythinkVideoView.dismissAllAlert();
        } else {
            super.dismissAllAlert();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final int getBorderViewHeight() {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        return anythinkVideoView != null ? anythinkVideoView.getBorderViewHeight() : super.getBorderViewHeight();
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final int getBorderViewLeft() {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        return anythinkVideoView != null ? anythinkVideoView.getBorderViewLeft() : super.getBorderViewLeft();
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final int getBorderViewRadius() {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        return anythinkVideoView != null ? anythinkVideoView.getBorderViewRadius() : super.getBorderViewRadius();
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final int getBorderViewTop() {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        return anythinkVideoView != null ? anythinkVideoView.getBorderViewTop() : super.getBorderViewTop();
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final int getBorderViewWidth() {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        return anythinkVideoView != null ? anythinkVideoView.getBorderViewWidth() : super.getBorderViewWidth();
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final java.lang.String getCurrentProgress() {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        return anythinkVideoView != null ? anythinkVideoView.getCurrentProgress() : super.getCurrentProgress();
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final void hideAlertView(int i) {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        if (anythinkVideoView != null) {
            anythinkVideoView.hideAlertView(i);
        } else {
            super.hideAlertView(i);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final boolean isH5Canvas() {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        return anythinkVideoView != null ? anythinkVideoView.isH5Canvas() : super.isH5Canvas();
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final void progressOperate(int i, int i2) {
        super.progressOperate(i, i2);
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        if (anythinkVideoView != null) {
            anythinkVideoView.progressOperate(i, i2);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final void setCover(boolean z) {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        if (anythinkVideoView != null) {
            anythinkVideoView.setCover(z);
        } else {
            super.setCover(z);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final void setScaleFitXY(int i) {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        if (anythinkVideoView != null) {
            anythinkVideoView.setScaleFitXY(i);
        } else {
            super.setScaleFitXY(i);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final void setVisible(int i) {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        if (anythinkVideoView != null) {
            anythinkVideoView.setVisible(i);
        } else {
            super.setVisible(i);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final void showAlertView() {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        if (anythinkVideoView != null) {
            anythinkVideoView.showAlertView();
        } else {
            super.showAlertView();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final void showIVRewardAlertView(java.lang.String str) {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        if (anythinkVideoView != null) {
            anythinkVideoView.showIVRewardAlertView(str);
        } else {
            super.showIVRewardAlertView(str);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final void showVideoLocation(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        super.showVideoLocation(i, i2, i3, i4, i5, i6, i7, i8, i9);
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        if (anythinkVideoView != null) {
            anythinkVideoView.showVideoLocation(i, i2, i3, i4, i5, i6, i7, i8, i9);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final void soundOperate(int i, int i2) {
        super.soundOperate(i, i2);
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        if (anythinkVideoView != null) {
            anythinkVideoView.soundOperate(i, i2);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final void soundOperate(int i, int i2, java.lang.String str) {
        super.soundOperate(i, i2, str);
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        if (anythinkVideoView != null) {
            anythinkVideoView.soundOperate(i, i2, str);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.g, com.anythink.expressad.video.signal.j
    public final void videoOperate(int i) {
        super.videoOperate(i);
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.t;
        if (anythinkVideoView != null) {
            anythinkVideoView.videoOperate(i);
        }
    }
}
