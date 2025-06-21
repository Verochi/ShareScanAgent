package com.amap.api.maps.model.particle;

/* loaded from: classes12.dex */
public class ParticleOverlay extends com.amap.api.maps.model.BaseOverlay {
    private java.lang.ref.WeakReference<com.amap.api.maps.interfaces.IGlOverlayLayer> glOverlayLayerRef;
    private com.amap.api.maps.model.particle.ParticleOverlayOptions options;

    public ParticleOverlay(com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer, com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions, java.lang.String str) {
        super(str);
        this.glOverlayLayerRef = new java.lang.ref.WeakReference<>(iGlOverlayLayer);
        this.options = particleOverlayOptions;
    }

    private void a() {
        com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (android.text.TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.updateOption(this.overlayName, this.options);
    }

    public void destroy() {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public int getCurrentParticleNum() {
        try {
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                return iGlOverlayLayer.getCurrentParticleNum(this.overlayName);
            }
            return 0;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public void setDuration(long j) {
        try {
            com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setDuration(j);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLoop(boolean z) {
        try {
            com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setLoop(z);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setMaxParticles(int i) {
        try {
            com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setMaxParticles(i);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleEmission(com.amap.api.maps.model.particle.ParticleEmissionModule particleEmissionModule) {
        try {
            com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleEmissionModule(particleEmissionModule);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleLifeTime(long j) {
        try {
            com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleLifeTime(j);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleOverLifeModule(com.amap.api.maps.model.particle.ParticleOverLifeModule particleOverLifeModule) {
        try {
            com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleOverLifeModule(particleOverLifeModule);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleShapeModule(com.amap.api.maps.model.particle.ParticleShapeModule particleShapeModule) {
        try {
            com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleShapeModule(particleShapeModule);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleStartSpeed(com.amap.api.maps.model.particle.VelocityGenerate velocityGenerate) {
        try {
            com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleStartSpeed(velocityGenerate);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStartColor(com.amap.api.maps.model.particle.ColorGenerate colorGenerate) {
        try {
            com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleStartColor(colorGenerate);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStartParticleSize(int i, int i2) {
        try {
            com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setStartParticleSize(i, i2);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setVisible(z);
                a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
