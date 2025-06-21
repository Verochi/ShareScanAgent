package com.autonavi.amap.mapcore.interfaces;

/* loaded from: classes12.dex */
public interface IInfoWindowManager {
    void setInfoWindowAnimation(com.amap.api.maps.model.animation.Animation animation, com.amap.api.maps.model.animation.Animation.AnimationListener animationListener);

    void setInfoWindowAppearAnimation(com.amap.api.maps.model.animation.Animation animation);

    void setInfoWindowBackColor(int i);

    void setInfoWindowBackEnable(boolean z);

    void setInfoWindowBackScale(float f, float f2);

    void setInfoWindowDisappearAnimation(com.amap.api.maps.model.animation.Animation animation);

    void setInfoWindowMovingAnimation(com.amap.api.maps.model.animation.Animation animation);

    void startAnimation();
}
