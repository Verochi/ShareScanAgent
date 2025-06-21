package com.esotericsoftware.spine.vertexeffects;

/* loaded from: classes22.dex */
public class JitterEffect implements com.esotericsoftware.spine.SkeletonRenderer.VertexEffect {
    public float a;
    public float b;

    public JitterEffect(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    @Override // com.esotericsoftware.spine.SkeletonRenderer.VertexEffect
    public void begin(com.esotericsoftware.spine.Skeleton skeleton) {
    }

    @Override // com.esotericsoftware.spine.SkeletonRenderer.VertexEffect
    public void end() {
    }

    public void setJitter(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public void setJitterX(float f) {
        this.a = f;
    }

    public void setJitterY(float f) {
        this.b = f;
    }

    @Override // com.esotericsoftware.spine.SkeletonRenderer.VertexEffect
    public void transform(com.badlogic.gdx.math.Vector2 vector2, com.badlogic.gdx.math.Vector2 vector22, com.badlogic.gdx.graphics.Color color, com.badlogic.gdx.graphics.Color color2) {
        vector2.x += com.badlogic.gdx.math.MathUtils.randomTriangular(-this.a, this.b);
        vector2.y += com.badlogic.gdx.math.MathUtils.randomTriangular(-this.a, this.b);
    }
}
