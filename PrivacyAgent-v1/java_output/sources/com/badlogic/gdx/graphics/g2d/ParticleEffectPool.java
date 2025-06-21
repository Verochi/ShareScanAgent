package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class ParticleEffectPool extends com.badlogic.gdx.utils.Pool<com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect> {
    public final com.badlogic.gdx.graphics.g2d.ParticleEffect b;

    public class PooledEffect extends com.badlogic.gdx.graphics.g2d.ParticleEffect {
        public PooledEffect(com.badlogic.gdx.graphics.g2d.ParticleEffect particleEffect) {
            super(particleEffect);
        }

        public void free() {
            com.badlogic.gdx.graphics.g2d.ParticleEffectPool.this.free(this);
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEffect
        public void reset() {
            super.reset();
        }
    }

    public ParticleEffectPool(com.badlogic.gdx.graphics.g2d.ParticleEffect particleEffect, int i, int i2) {
        super(i, i2);
        this.b = particleEffect;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.utils.Pool
    public com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect newObject() {
        return new com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect(this.b);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.utils.Pool
    public com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect obtain() {
        com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect pooledEffect = (com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect) super.obtain();
        pooledEffect.reset();
        return pooledEffect;
    }
}
