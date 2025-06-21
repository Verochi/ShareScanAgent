package com.amap.api.maps;

/* loaded from: classes12.dex */
public class InfoWindowAnimationManager {
    com.autonavi.amap.mapcore.interfaces.IInfoWindowManager a;

    public InfoWindowAnimationManager(com.autonavi.amap.mapcore.interfaces.IInfoWindowManager iInfoWindowManager) {
        this.a = iInfoWindowManager;
    }

    public void setInfoWindowAnimation(com.amap.api.maps.model.animation.Animation animation, com.amap.api.maps.model.animation.Animation.AnimationListener animationListener) {
        this.a.setInfoWindowAnimation(animation, animationListener);
    }

    public void setInfoWindowAppearAnimation(com.amap.api.maps.model.animation.Animation animation) {
        this.a.setInfoWindowAppearAnimation(animation);
    }

    public void setInfoWindowBackColor(int i) {
        this.a.setInfoWindowBackColor(i);
    }

    public void setInfoWindowBackEnable(boolean z) {
        this.a.setInfoWindowBackEnable(z);
    }

    public void setInfoWindowBackScale(float f, float f2) {
        this.a.setInfoWindowBackScale(f, f2);
    }

    public void setInfoWindowDisappearAnimation(com.amap.api.maps.model.animation.Animation animation) {
        this.a.setInfoWindowDisappearAnimation(animation);
    }

    public void setInfoWindowMovingAnimation(com.amap.api.maps.model.animation.Animation animation) {
        this.a.setInfoWindowMovingAnimation(animation);
    }

    public void startAnimation() {
        this.a.startAnimation();
    }
}
