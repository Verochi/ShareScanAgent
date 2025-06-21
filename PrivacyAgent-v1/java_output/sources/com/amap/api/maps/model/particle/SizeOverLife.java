package com.amap.api.maps.model.particle;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public abstract class SizeOverLife {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    protected final int TYPE_DEFAULT = -1;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    protected final int TYPE_CURVESIZEOVERLIFE = 0;
    protected int type = -1;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public final int DEFAULT_SIZE = 0;

    public abstract float getSizeX(float f);

    public abstract float getSizeY(float f);

    public abstract float getSizeZ(float f);
}
