package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public class Ellipse implements java.io.Serializable, com.badlogic.gdx.math.Shape2D {
    private static final long serialVersionUID = 7381533206532032099L;
    public float height;
    public float width;
    public float x;
    public float y;

    public Ellipse() {
    }

    public Ellipse(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    public Ellipse(com.badlogic.gdx.math.Circle circle) {
        this.x = circle.x;
        this.y = circle.y;
        float f = circle.radius;
        this.width = f;
        this.height = f;
    }

    public Ellipse(com.badlogic.gdx.math.Ellipse ellipse) {
        this.x = ellipse.x;
        this.y = ellipse.y;
        this.width = ellipse.width;
        this.height = ellipse.height;
    }

    public Ellipse(com.badlogic.gdx.math.Vector2 vector2, float f, float f2) {
        this.x = vector2.x;
        this.y = vector2.y;
        this.width = f;
        this.height = f2;
    }

    public Ellipse(com.badlogic.gdx.math.Vector2 vector2, com.badlogic.gdx.math.Vector2 vector22) {
        this.x = vector2.x;
        this.y = vector2.y;
        this.width = vector22.x;
        this.height = vector22.y;
    }

    public float area() {
        return ((this.width * this.height) * 3.1415927f) / 4.0f;
    }

    public float circumference() {
        float f = this.width / 2.0f;
        float f2 = this.height / 2.0f;
        return (f * 3.0f > f2 || f2 * 3.0f > f) ? (float) ((((f + f2) * 3.0f) - java.lang.Math.sqrt((r4 + f2) * (f + (f2 * 3.0f)))) * 3.1415927410125732d) : (float) (java.lang.Math.sqrt(((f * f) + (f2 * f2)) / 2.0f) * 6.2831854820251465d);
    }

    @Override // com.badlogic.gdx.math.Shape2D
    public boolean contains(float f, float f2) {
        float f3 = f - this.x;
        float f4 = f2 - this.y;
        float f5 = this.width;
        float f6 = (f3 * f3) / (((f5 * 0.5f) * f5) * 0.5f);
        float f7 = this.height;
        return f6 + ((f4 * f4) / (((f7 * 0.5f) * f7) * 0.5f)) <= 1.0f;
    }

    @Override // com.badlogic.gdx.math.Shape2D
    public boolean contains(com.badlogic.gdx.math.Vector2 vector2) {
        return contains(vector2.x, vector2.y);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        com.badlogic.gdx.math.Ellipse ellipse = (com.badlogic.gdx.math.Ellipse) obj;
        return this.x == ellipse.x && this.y == ellipse.y && this.width == ellipse.width && this.height == ellipse.height;
    }

    public int hashCode() {
        return ((((((com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.height) + 53) * 53) + com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.width)) * 53) + com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.x)) * 53) + com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.y);
    }

    public void set(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    public void set(com.badlogic.gdx.math.Circle circle) {
        this.x = circle.x;
        this.y = circle.y;
        float f = circle.radius;
        this.width = f;
        this.height = f;
    }

    public void set(com.badlogic.gdx.math.Ellipse ellipse) {
        this.x = ellipse.x;
        this.y = ellipse.y;
        this.width = ellipse.width;
        this.height = ellipse.height;
    }

    public void set(com.badlogic.gdx.math.Vector2 vector2, com.badlogic.gdx.math.Vector2 vector22) {
        this.x = vector2.x;
        this.y = vector2.y;
        this.width = vector22.x;
        this.height = vector22.y;
    }

    public com.badlogic.gdx.math.Ellipse setPosition(float f, float f2) {
        this.x = f;
        this.y = f2;
        return this;
    }

    public com.badlogic.gdx.math.Ellipse setPosition(com.badlogic.gdx.math.Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
        return this;
    }

    public com.badlogic.gdx.math.Ellipse setSize(float f, float f2) {
        this.width = f;
        this.height = f2;
        return this;
    }
}
