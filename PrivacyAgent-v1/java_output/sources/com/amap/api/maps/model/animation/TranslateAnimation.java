package com.amap.api.maps.model.animation;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class TranslateAnimation extends com.amap.api.maps.model.animation.Animation {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private double x;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private double y;

    public TranslateAnimation(com.amap.api.maps.model.LatLng latLng) {
        this.glAnimation = new com.autonavi.amap.mapcore.animation.GLTranslateAnimation(latLng);
        this.x = latLng.latitude;
        this.y = latLng.longitude;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public java.lang.String getAnimationType() {
        return "TranslateAnimation";
    }
}
