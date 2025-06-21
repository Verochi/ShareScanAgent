package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public abstract class BasePointOverlay extends com.amap.api.maps.model.BaseOverlay {
    public BasePointOverlay(java.lang.String str) {
        super(str);
    }

    public abstract void destroy();

    public abstract java.lang.String getId();

    public abstract java.lang.Object getObject();

    public abstract com.amap.api.maps.model.LatLng getPosition();

    public abstract float getRotateAngle();

    public abstract java.lang.String getSnippet();

    public abstract java.lang.String getTitle();

    public abstract boolean isInfoWindowEnable();

    public abstract boolean isVisible();

    public abstract void remove();

    public abstract void setAnimation(com.amap.api.maps.model.animation.Animation animation);

    public abstract void setGeoPoint(com.autonavi.amap.mapcore.IPoint iPoint);

    public abstract void setObject(java.lang.Object obj);

    public abstract void setPosition(com.amap.api.maps.model.LatLng latLng);

    public abstract void setRotateAngle(float f);

    public abstract void setSnippet(java.lang.String str);

    public abstract void setTitle(java.lang.String str);

    public abstract void setVisible(boolean z);

    public abstract void showInfoWindow();

    public abstract boolean startAnimation();
}
