package com.amap.api.maps.model.particle;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class ParticleOverLifeModule {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private static final int TYPE_COLOR = 3;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private static final int TYPE_ROTATE = 1;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private static final int TYPE_SCALE = 2;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private static final int TYPE_VEL = 0;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private com.amap.api.maps.model.particle.ColorGenerate colorGenerate;
    private java.lang.Object colorGenerateObject;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private com.amap.api.maps.model.particle.RotationOverLife rotateOverLife;
    private java.lang.Object rotateOverLifeObject;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private com.amap.api.maps.model.particle.SizeOverLife sizeOverLife;
    private java.lang.Object sizeOverLifeObject;
    private java.lang.Object velocityOverLifeObject;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private com.amap.api.maps.model.particle.VelocityGenerate overLife = null;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private com.amap.api.maps.model.particle.VelocityGenerate velocityOverLife = null;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private boolean isNeedReloadVelocityGenerate = false;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private boolean isNeedReloadRotationOverLife = false;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private boolean isNeedReloadSizeOverLife = false;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private boolean isNeedReloadColorGenerate = false;

    public void setColorGenerate(com.amap.api.maps.model.particle.ColorGenerate colorGenerate) {
        this.colorGenerate = colorGenerate;
        this.colorGenerateObject = colorGenerate;
        this.isNeedReloadColorGenerate = true;
    }

    public void setRotateOverLife(com.amap.api.maps.model.particle.RotationOverLife rotationOverLife) {
        this.rotateOverLife = rotationOverLife;
        this.rotateOverLifeObject = rotationOverLife;
        this.isNeedReloadRotationOverLife = true;
    }

    public void setSizeOverLife(com.amap.api.maps.model.particle.SizeOverLife sizeOverLife) {
        this.sizeOverLife = sizeOverLife;
        this.sizeOverLifeObject = sizeOverLife;
        this.isNeedReloadSizeOverLife = true;
    }

    public void setVelocityOverLife(com.amap.api.maps.model.particle.VelocityGenerate velocityGenerate) {
        this.overLife = velocityGenerate;
        this.velocityOverLife = velocityGenerate;
        this.velocityOverLifeObject = velocityGenerate;
        this.isNeedReloadVelocityGenerate = true;
    }
}
