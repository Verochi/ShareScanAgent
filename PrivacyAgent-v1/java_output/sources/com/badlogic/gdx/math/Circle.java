package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public class Circle implements java.io.Serializable, com.badlogic.gdx.math.Shape2D {
    public float radius;
    public float x;
    public float y;

    public Circle() {
    }

    public Circle(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.radius = f3;
    }

    public Circle(com.badlogic.gdx.math.Circle circle) {
        this.x = circle.x;
        this.y = circle.y;
        this.radius = circle.radius;
    }

    public Circle(com.badlogic.gdx.math.Vector2 vector2, float f) {
        this.x = vector2.x;
        this.y = vector2.y;
        this.radius = f;
    }

    public Circle(com.badlogic.gdx.math.Vector2 vector2, com.badlogic.gdx.math.Vector2 vector22) {
        float f = vector2.x;
        this.x = f;
        float f2 = vector2.y;
        this.y = f2;
        this.radius = com.badlogic.gdx.math.Vector2.len(f - vector22.x, f2 - vector22.y);
    }

    public float area() {
        float f = this.radius;
        return f * f * 3.1415927f;
    }

    public float circumference() {
        return this.radius * 6.2831855f;
    }

    @Override // com.badlogic.gdx.math.Shape2D
    public boolean contains(float f, float f2) {
        float f3 = this.x - f;
        float f4 = this.y - f2;
        float f5 = (f3 * f3) + (f4 * f4);
        float f6 = this.radius;
        return f5 <= f6 * f6;
    }

    public boolean contains(com.badlogic.gdx.math.Circle circle) {
        float f = this.radius;
        float f2 = circle.radius;
        float f3 = f - f2;
        if (f3 < 0.0f) {
            return false;
        }
        float f4 = this.x - circle.x;
        float f5 = this.y - circle.y;
        float f6 = (f4 * f4) + (f5 * f5);
        float f7 = f + f2;
        return f3 * f3 >= f6 && f6 < f7 * f7;
    }

    @Override // com.badlogic.gdx.math.Shape2D
    public boolean contains(com.badlogic.gdx.math.Vector2 vector2) {
        float f = this.x - vector2.x;
        float f2 = this.y - vector2.y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.radius;
        return f3 <= f4 * f4;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        com.badlogic.gdx.math.Circle circle = (com.badlogic.gdx.math.Circle) obj;
        return this.x == circle.x && this.y == circle.y && this.radius == circle.radius;
    }

    public int hashCode() {
        return ((((com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.radius) + 41) * 41) + com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.x)) * 41) + com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.y);
    }

    public boolean overlaps(com.badlogic.gdx.math.Circle circle) {
        float f = this.x - circle.x;
        float f2 = this.y - circle.y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.radius + circle.radius;
        return f3 < f4 * f4;
    }

    public void set(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.radius = f3;
    }

    public void set(com.badlogic.gdx.math.Circle circle) {
        this.x = circle.x;
        this.y = circle.y;
        this.radius = circle.radius;
    }

    public void set(com.badlogic.gdx.math.Vector2 vector2, float f) {
        this.x = vector2.x;
        this.y = vector2.y;
        this.radius = f;
    }

    public void set(com.badlogic.gdx.math.Vector2 vector2, com.badlogic.gdx.math.Vector2 vector22) {
        float f = vector2.x;
        this.x = f;
        float f2 = vector2.y;
        this.y = f2;
        this.radius = com.badlogic.gdx.math.Vector2.len(f - vector22.x, f2 - vector22.y);
    }

    public void setPosition(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public void setPosition(com.badlogic.gdx.math.Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
    }

    public void setRadius(float f) {
        this.radius = f;
    }

    public void setX(float f) {
        this.x = f;
    }

    public void setY(float f) {
        this.y = f;
    }

    public java.lang.String toString() {
        return this.x + "," + this.y + "," + this.radius;
    }
}
