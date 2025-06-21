package com.amap.api.maps.model.particle;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public abstract class VelocityGenerate {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    protected final int TYPE_DEFAULT = -1;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    protected final int TYPE_RANDOMVELOCITYBETWEENTWOCONSTANTS = 0;
    protected int type = -1;

    public abstract float getX();

    public abstract float getY();

    public abstract float getZ();
}
