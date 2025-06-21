package com.badlogic.gdx.scenes.scene2d;

/* loaded from: classes12.dex */
public abstract class TemporalAction extends com.badlogic.gdx.scenes.scene2d.Action {
    public float b;
    public float c;
    public com.badlogic.gdx.math.Interpolation d;
    public boolean e;
    public boolean f;
    public boolean g;

    public TemporalAction() {
    }

    public TemporalAction(float f) {
        this.b = f;
    }

    public TemporalAction(float f, com.badlogic.gdx.math.Interpolation interpolation) {
        this.b = f;
        this.d = interpolation;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Action
    public boolean act(float f) {
        float f2;
        boolean z = true;
        if (this.g) {
            return true;
        }
        com.badlogic.gdx.utils.Pool pool = getPool();
        setPool(null);
        try {
            if (!this.f) {
                begin();
                this.f = true;
            }
            float f3 = this.c + f;
            this.c = f3;
            float f4 = this.b;
            if (f3 < f4) {
                z = false;
            }
            this.g = z;
            if (z) {
                f2 = 1.0f;
            } else {
                f2 = f3 / f4;
                com.badlogic.gdx.math.Interpolation interpolation = this.d;
                if (interpolation != null) {
                    f2 = interpolation.apply(f2);
                }
            }
            if (this.e) {
                f2 = 1.0f - f2;
            }
            update(f2);
            if (this.g) {
                end();
            }
            return this.g;
        } finally {
            setPool(pool);
        }
    }

    public void begin() {
    }

    public void end() {
    }

    public void finish() {
        this.c = this.b;
    }

    public float getDuration() {
        return this.b;
    }

    public com.badlogic.gdx.math.Interpolation getInterpolation() {
        return this.d;
    }

    public float getTime() {
        return this.c;
    }

    public boolean isReverse() {
        return this.e;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Action, com.badlogic.gdx.utils.Pool.Poolable
    public void reset() {
        super.reset();
        this.e = false;
        this.d = null;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Action
    public void restart() {
        this.c = 0.0f;
        this.f = false;
        this.g = false;
    }

    public void setDuration(float f) {
        this.b = f;
    }

    public void setInterpolation(com.badlogic.gdx.math.Interpolation interpolation) {
        this.d = interpolation;
    }

    public void setReverse(boolean z) {
        this.e = z;
    }

    public void setTime(float f) {
        this.c = f;
    }

    public abstract void update(float f);
}
