package com.amap.api.maps.model.particle;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class SinglePointParticleShape extends com.amap.api.maps.model.particle.ParticleShapeModule {
    private float[] point_3;

    public SinglePointParticleShape(float f, float f2, float f3) {
        this(f, f2, f3, false);
    }

    public SinglePointParticleShape(float f, float f2, float f3, boolean z) {
        this.point_3 = new float[]{f, f2, f3};
        this.isUseRatio = z;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.ParticleShapeModule
    public float[] getPoint() {
        return this.point_3;
    }
}
