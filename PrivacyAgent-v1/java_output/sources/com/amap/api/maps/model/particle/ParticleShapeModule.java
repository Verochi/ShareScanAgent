package com.amap.api.maps.model.particle;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public abstract class ParticleShapeModule {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    protected final int TYPE_DEFAULT = -1;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    protected final int TYPE_SINGLEPOINT = 0;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    protected final int TYPE_RECT = 1;
    protected int type = -1;
    protected boolean isUseRatio = false;

    public abstract float[] getPoint();

    public boolean isUseRatio() {
        return this.isUseRatio;
    }
}
