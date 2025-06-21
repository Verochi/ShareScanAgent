package com.esotericsoftware.spine.vertexeffects;

/* loaded from: classes22.dex */
public class SwirlEffect implements com.esotericsoftware.spine.SkeletonRenderer.VertexEffect {
    public float a;
    public float b;
    public float c;
    public float d;
    public com.badlogic.gdx.math.Interpolation e = com.badlogic.gdx.math.Interpolation.pow2Out;
    public float f;
    public float g;

    public SwirlEffect(float f) {
        this.c = f;
    }

    @Override // com.esotericsoftware.spine.SkeletonRenderer.VertexEffect
    public void begin(com.esotericsoftware.spine.Skeleton skeleton) {
        this.a = skeleton.getX() + this.f;
        this.b = skeleton.getY() + this.g;
    }

    @Override // com.esotericsoftware.spine.SkeletonRenderer.VertexEffect
    public void end() {
    }

    public com.badlogic.gdx.math.Interpolation getInterpolation() {
        return this.e;
    }

    public void setAngle(float f) {
        this.d = f * 0.017453292f;
    }

    public void setCenter(float f, float f2) {
        this.f = f;
        this.g = f2;
    }

    public void setCenterX(float f) {
        this.f = f;
    }

    public void setCenterY(float f) {
        this.g = f;
    }

    public void setInterpolation(com.badlogic.gdx.math.Interpolation interpolation) {
        this.e = interpolation;
    }

    public void setRadius(float f) {
        this.c = f;
    }

    @Override // com.esotericsoftware.spine.SkeletonRenderer.VertexEffect
    public void transform(com.badlogic.gdx.math.Vector2 vector2, com.badlogic.gdx.math.Vector2 vector22, com.badlogic.gdx.graphics.Color color, com.badlogic.gdx.graphics.Color color2) {
        float f = vector2.x - this.a;
        float f2 = vector2.y - this.b;
        float sqrt = (float) java.lang.Math.sqrt((f * f) + (f2 * f2));
        float f3 = this.c;
        if (sqrt < f3) {
            float apply = this.e.apply(0.0f, this.d, (f3 - sqrt) / f3);
            float cos = com.esotericsoftware.spine.utils.SpineUtils.cos(apply);
            float sin = com.esotericsoftware.spine.utils.SpineUtils.sin(apply);
            vector2.x = ((cos * f) - (sin * f2)) + this.a;
            vector2.y = (sin * f) + (cos * f2) + this.b;
        }
    }
}
