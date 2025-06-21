package com.amap.api.maps.model.particle;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class ConstantRotationOverLife extends com.amap.api.maps.model.particle.RotationOverLife {
    private float rotate;

    public ConstantRotationOverLife(float f) {
        this.rotate = f;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.RotationOverLife
    public float getRotate() {
        return this.rotate;
    }
}
