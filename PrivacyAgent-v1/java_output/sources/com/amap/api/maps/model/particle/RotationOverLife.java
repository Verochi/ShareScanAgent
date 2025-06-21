package com.amap.api.maps.model.particle;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public abstract class RotationOverLife {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    protected final int TYPE_DEFAULT = -1;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    protected final int TYPE_CONSTANTROTATIONOVERLIFE = 0;
    protected int type = -1;

    public abstract float getRotate();
}
