package com.amap.api.maps.model.particle;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class CurveSizeOverLife extends com.amap.api.maps.model.particle.SizeOverLife {
    private float x;
    private float y;
    private float z;

    public CurveSizeOverLife(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeX(float f) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeY(float f) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeZ(float f) {
        return 0.0f;
    }
}
