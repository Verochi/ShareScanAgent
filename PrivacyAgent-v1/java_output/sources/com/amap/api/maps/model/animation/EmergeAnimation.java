package com.amap.api.maps.model.animation;

/* loaded from: classes12.dex */
public class EmergeAnimation extends com.amap.api.maps.model.animation.Animation {
    public EmergeAnimation(com.amap.api.maps.model.LatLng latLng) {
        this.glAnimation = new com.autonavi.amap.mapcore.animation.GLEmergeAnimation(latLng);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public java.lang.String getAnimationType() {
        return "EmergeAnimation";
    }
}
