package com.badlogic.gdx.scenes.scene2d;

/* loaded from: classes12.dex */
public class AlphaAction extends com.badlogic.gdx.scenes.scene2d.TemporalAction {
    public float h;
    public float i;
    public com.badlogic.gdx.graphics.Color j;

    @Override // com.badlogic.gdx.scenes.scene2d.TemporalAction
    public void begin() {
        if (this.j == null) {
            this.j = this.target.getColor();
        }
        this.h = this.j.a;
    }

    public float getAlpha() {
        return this.i;
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.j;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.TemporalAction, com.badlogic.gdx.scenes.scene2d.Action, com.badlogic.gdx.utils.Pool.Poolable
    public void reset() {
        super.reset();
        this.j = null;
    }

    public void setAlpha(float f) {
        this.i = f;
    }

    public void setColor(com.badlogic.gdx.graphics.Color color) {
        this.j = color;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.TemporalAction
    public void update(float f) {
        com.badlogic.gdx.graphics.Color color = this.j;
        float f2 = this.h;
        color.a = f2 + ((this.i - f2) * f);
    }
}
