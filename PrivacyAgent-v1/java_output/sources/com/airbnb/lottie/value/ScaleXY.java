package com.airbnb.lottie.value;

/* loaded from: classes.dex */
public class ScaleXY {
    public float a;
    public float b;

    public ScaleXY() {
        this(1.0f, 1.0f);
    }

    public ScaleXY(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public boolean equals(float f, float f2) {
        return this.a == f && this.b == f2;
    }

    public float getScaleX() {
        return this.a;
    }

    public float getScaleY() {
        return this.b;
    }

    public void set(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public java.lang.String toString() {
        return getScaleX() + "x" + getScaleY();
    }
}
