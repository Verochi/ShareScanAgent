package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public final class Affine2 implements java.io.Serializable {
    private static final long serialVersionUID = 1524569123485049187L;
    public float m00 = 1.0f;
    public float m01 = 0.0f;
    public float m02 = 0.0f;
    public float m10 = 0.0f;
    public float m11 = 1.0f;
    public float m12 = 0.0f;

    public Affine2() {
    }

    public Affine2(com.badlogic.gdx.math.Affine2 affine2) {
        set(affine2);
    }

    public void applyTo(com.badlogic.gdx.math.Vector2 vector2) {
        float f = vector2.x;
        float f2 = vector2.y;
        vector2.x = (this.m00 * f) + (this.m01 * f2) + this.m02;
        vector2.y = (this.m10 * f) + (this.m11 * f2) + this.m12;
    }

    public float det() {
        return (this.m00 * this.m11) - (this.m01 * this.m10);
    }

    public com.badlogic.gdx.math.Vector2 getTranslation(com.badlogic.gdx.math.Vector2 vector2) {
        vector2.x = this.m02;
        vector2.y = this.m12;
        return vector2;
    }

    public com.badlogic.gdx.math.Affine2 idt() {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        return this;
    }

    public com.badlogic.gdx.math.Affine2 inv() {
        float det = det();
        if (det == 0.0f) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Can't invert a singular affine matrix");
        }
        float f = 1.0f / det;
        float f2 = this.m11;
        float f3 = this.m01;
        float f4 = -f3;
        float f5 = this.m12;
        float f6 = this.m02;
        float f7 = this.m10;
        float f8 = -f7;
        float f9 = this.m00;
        this.m00 = f2 * f;
        this.m01 = f4 * f;
        this.m02 = ((f3 * f5) - (f2 * f6)) * f;
        this.m10 = f8 * f;
        this.m11 = f9 * f;
        this.m12 = f * ((f7 * f6) - (f5 * f9));
        return this;
    }

    public boolean isIdt() {
        return this.m00 == 1.0f && this.m02 == 0.0f && this.m12 == 0.0f && this.m11 == 1.0f && this.m01 == 0.0f && this.m10 == 0.0f;
    }

    public boolean isTranslation() {
        return this.m00 == 1.0f && this.m11 == 1.0f && this.m01 == 0.0f && this.m10 == 0.0f;
    }

    public com.badlogic.gdx.math.Affine2 mul(com.badlogic.gdx.math.Affine2 affine2) {
        float f = this.m00;
        float f2 = affine2.m00;
        float f3 = this.m01;
        float f4 = affine2.m10;
        float f5 = (f * f2) + (f3 * f4);
        float f6 = affine2.m01;
        float f7 = affine2.m11;
        float f8 = (f * f6) + (f3 * f7);
        float f9 = affine2.m02;
        float f10 = affine2.m12;
        float f11 = (f * f9) + (f3 * f10) + this.m02;
        float f12 = this.m10;
        float f13 = this.m11;
        float f14 = (f2 * f12) + (f4 * f13);
        float f15 = (f6 * f12) + (f7 * f13);
        float f16 = (f12 * f9) + (f13 * f10) + this.m12;
        this.m00 = f5;
        this.m01 = f8;
        this.m02 = f11;
        this.m10 = f14;
        this.m11 = f15;
        this.m12 = f16;
        return this;
    }

    public com.badlogic.gdx.math.Affine2 preMul(com.badlogic.gdx.math.Affine2 affine2) {
        float f = affine2.m00;
        float f2 = this.m00;
        float f3 = affine2.m01;
        float f4 = this.m10;
        float f5 = (f * f2) + (f3 * f4);
        float f6 = this.m01;
        float f7 = this.m11;
        float f8 = (f * f6) + (f3 * f7);
        float f9 = this.m02;
        float f10 = this.m12;
        float f11 = (f * f9) + (f3 * f10) + affine2.m02;
        float f12 = affine2.m10;
        float f13 = affine2.m11;
        float f14 = (f2 * f12) + (f4 * f13);
        float f15 = (f6 * f12) + (f7 * f13);
        float f16 = (f12 * f9) + (f13 * f10) + affine2.m12;
        this.m00 = f5;
        this.m01 = f8;
        this.m02 = f11;
        this.m10 = f14;
        this.m11 = f15;
        this.m12 = f16;
        return this;
    }

    public com.badlogic.gdx.math.Affine2 preRotate(float f) {
        if (f == 0.0f) {
            return this;
        }
        float cosDeg = com.badlogic.gdx.math.MathUtils.cosDeg(f);
        float sinDeg = com.badlogic.gdx.math.MathUtils.sinDeg(f);
        float f2 = this.m00;
        float f3 = this.m10;
        float f4 = (cosDeg * f2) - (sinDeg * f3);
        float f5 = this.m01;
        float f6 = this.m11;
        float f7 = (cosDeg * f5) - (sinDeg * f6);
        float f8 = this.m02;
        float f9 = this.m12;
        this.m00 = f4;
        this.m01 = f7;
        this.m02 = (cosDeg * f8) - (sinDeg * f9);
        this.m10 = (f2 * sinDeg) + (f3 * cosDeg);
        this.m11 = (f5 * sinDeg) + (f6 * cosDeg);
        this.m12 = (sinDeg * f8) + (cosDeg * f9);
        return this;
    }

    public com.badlogic.gdx.math.Affine2 preRotateRad(float f) {
        if (f == 0.0f) {
            return this;
        }
        float cos = com.badlogic.gdx.math.MathUtils.cos(f);
        float sin = com.badlogic.gdx.math.MathUtils.sin(f);
        float f2 = this.m00;
        float f3 = this.m10;
        float f4 = (cos * f2) - (sin * f3);
        float f5 = this.m01;
        float f6 = this.m11;
        float f7 = (cos * f5) - (sin * f6);
        float f8 = this.m02;
        float f9 = this.m12;
        this.m00 = f4;
        this.m01 = f7;
        this.m02 = (cos * f8) - (sin * f9);
        this.m10 = (f2 * sin) + (f3 * cos);
        this.m11 = (f5 * sin) + (f6 * cos);
        this.m12 = (sin * f8) + (cos * f9);
        return this;
    }

    public com.badlogic.gdx.math.Affine2 preScale(float f, float f2) {
        this.m00 *= f;
        this.m01 *= f;
        this.m02 *= f;
        this.m10 *= f2;
        this.m11 *= f2;
        this.m12 *= f2;
        return this;
    }

    public com.badlogic.gdx.math.Affine2 preScale(com.badlogic.gdx.math.Vector2 vector2) {
        return preScale(vector2.x, vector2.y);
    }

    public com.badlogic.gdx.math.Affine2 preShear(float f, float f2) {
        float f3 = this.m00;
        float f4 = this.m10;
        float f5 = (f * f4) + f3;
        float f6 = this.m01;
        float f7 = this.m11;
        float f8 = (f * f7) + f6;
        float f9 = this.m02;
        float f10 = this.m12;
        this.m00 = f5;
        this.m01 = f8;
        this.m02 = (f * f10) + f9;
        this.m10 = f4 + (f3 * f2);
        this.m11 = f7 + (f6 * f2);
        this.m12 = f10 + (f2 * f9);
        return this;
    }

    public com.badlogic.gdx.math.Affine2 preShear(com.badlogic.gdx.math.Vector2 vector2) {
        return preShear(vector2.x, vector2.y);
    }

    public com.badlogic.gdx.math.Affine2 preTranslate(float f, float f2) {
        this.m02 += f;
        this.m12 += f2;
        return this;
    }

    public com.badlogic.gdx.math.Affine2 preTranslate(com.badlogic.gdx.math.Vector2 vector2) {
        return preTranslate(vector2.x, vector2.y);
    }

    public com.badlogic.gdx.math.Affine2 rotate(float f) {
        if (f == 0.0f) {
            return this;
        }
        float cosDeg = com.badlogic.gdx.math.MathUtils.cosDeg(f);
        float sinDeg = com.badlogic.gdx.math.MathUtils.sinDeg(f);
        float f2 = this.m00;
        float f3 = this.m01;
        float f4 = (f2 * cosDeg) + (f3 * sinDeg);
        float f5 = -sinDeg;
        float f6 = (f2 * f5) + (f3 * cosDeg);
        float f7 = this.m10;
        float f8 = this.m11;
        this.m00 = f4;
        this.m01 = f6;
        this.m10 = (f7 * cosDeg) + (sinDeg * f8);
        this.m11 = (f7 * f5) + (f8 * cosDeg);
        return this;
    }

    public com.badlogic.gdx.math.Affine2 rotateRad(float f) {
        if (f == 0.0f) {
            return this;
        }
        float cos = com.badlogic.gdx.math.MathUtils.cos(f);
        float sin = com.badlogic.gdx.math.MathUtils.sin(f);
        float f2 = this.m00;
        float f3 = this.m01;
        float f4 = (f2 * cos) + (f3 * sin);
        float f5 = -sin;
        float f6 = (f2 * f5) + (f3 * cos);
        float f7 = this.m10;
        float f8 = this.m11;
        this.m00 = f4;
        this.m01 = f6;
        this.m10 = (f7 * cos) + (sin * f8);
        this.m11 = (f7 * f5) + (f8 * cos);
        return this;
    }

    public com.badlogic.gdx.math.Affine2 scale(float f, float f2) {
        this.m00 *= f;
        this.m01 *= f2;
        this.m10 *= f;
        this.m11 *= f2;
        return this;
    }

    public com.badlogic.gdx.math.Affine2 scale(com.badlogic.gdx.math.Vector2 vector2) {
        return scale(vector2.x, vector2.y);
    }

    public com.badlogic.gdx.math.Affine2 set(com.badlogic.gdx.math.Affine2 affine2) {
        this.m00 = affine2.m00;
        this.m01 = affine2.m01;
        this.m02 = affine2.m02;
        this.m10 = affine2.m10;
        this.m11 = affine2.m11;
        this.m12 = affine2.m12;
        return this;
    }

    public com.badlogic.gdx.math.Affine2 set(com.badlogic.gdx.math.Matrix3 matrix3) {
        float[] fArr = matrix3.val;
        this.m00 = fArr[0];
        this.m01 = fArr[3];
        this.m02 = fArr[6];
        this.m10 = fArr[1];
        this.m11 = fArr[4];
        this.m12 = fArr[7];
        return this;
    }

    public com.badlogic.gdx.math.Affine2 set(com.badlogic.gdx.math.Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        this.m00 = fArr[0];
        this.m01 = fArr[4];
        this.m02 = fArr[12];
        this.m10 = fArr[1];
        this.m11 = fArr[5];
        this.m12 = fArr[13];
        return this;
    }

    public com.badlogic.gdx.math.Affine2 setToProduct(com.badlogic.gdx.math.Affine2 affine2, com.badlogic.gdx.math.Affine2 affine22) {
        float f = affine2.m00 * affine22.m00;
        float f2 = affine2.m01;
        float f3 = affine22.m10;
        this.m00 = f + (f2 * f3);
        float f4 = affine2.m00;
        float f5 = affine22.m01 * f4;
        float f6 = affine22.m11;
        this.m01 = f5 + (f2 * f6);
        float f7 = f4 * affine22.m02;
        float f8 = affine2.m01;
        float f9 = affine22.m12;
        this.m02 = f7 + (f8 * f9) + affine2.m02;
        float f10 = affine2.m10 * affine22.m00;
        float f11 = affine2.m11;
        this.m10 = f10 + (f3 * f11);
        float f12 = affine2.m10;
        this.m11 = (affine22.m01 * f12) + (f11 * f6);
        this.m12 = (f12 * affine22.m02) + (affine2.m11 * f9) + affine2.m12;
        return this;
    }

    public com.badlogic.gdx.math.Affine2 setToRotation(float f) {
        float cosDeg = com.badlogic.gdx.math.MathUtils.cosDeg(f);
        float sinDeg = com.badlogic.gdx.math.MathUtils.sinDeg(f);
        this.m00 = cosDeg;
        this.m01 = -sinDeg;
        this.m02 = 0.0f;
        this.m10 = sinDeg;
        this.m11 = cosDeg;
        this.m12 = 0.0f;
        return this;
    }

    public com.badlogic.gdx.math.Affine2 setToRotation(float f, float f2) {
        this.m00 = f;
        this.m01 = -f2;
        this.m02 = 0.0f;
        this.m10 = f2;
        this.m11 = f;
        this.m12 = 0.0f;
        return this;
    }

    public com.badlogic.gdx.math.Affine2 setToRotationRad(float f) {
        float cos = com.badlogic.gdx.math.MathUtils.cos(f);
        float sin = com.badlogic.gdx.math.MathUtils.sin(f);
        this.m00 = cos;
        this.m01 = -sin;
        this.m02 = 0.0f;
        this.m10 = sin;
        this.m11 = cos;
        this.m12 = 0.0f;
        return this;
    }

    public com.badlogic.gdx.math.Affine2 setToScaling(float f, float f2) {
        this.m00 = f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = f2;
        this.m12 = 0.0f;
        return this;
    }

    public com.badlogic.gdx.math.Affine2 setToScaling(com.badlogic.gdx.math.Vector2 vector2) {
        return setToScaling(vector2.x, vector2.y);
    }

    public com.badlogic.gdx.math.Affine2 setToShearing(float f, float f2) {
        this.m00 = 1.0f;
        this.m01 = f;
        this.m02 = 0.0f;
        this.m10 = f2;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        return this;
    }

    public com.badlogic.gdx.math.Affine2 setToShearing(com.badlogic.gdx.math.Vector2 vector2) {
        return setToShearing(vector2.x, vector2.y);
    }

    public com.badlogic.gdx.math.Affine2 setToTranslation(float f, float f2) {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = f2;
        return this;
    }

    public com.badlogic.gdx.math.Affine2 setToTranslation(com.badlogic.gdx.math.Vector2 vector2) {
        return setToTranslation(vector2.x, vector2.y);
    }

    public com.badlogic.gdx.math.Affine2 setToTrnRotRadScl(float f, float f2, float f3, float f4, float f5) {
        this.m02 = f;
        this.m12 = f2;
        if (f3 == 0.0f) {
            this.m00 = f4;
            this.m01 = 0.0f;
            this.m10 = 0.0f;
            this.m11 = f5;
        } else {
            float sin = com.badlogic.gdx.math.MathUtils.sin(f3);
            float cos = com.badlogic.gdx.math.MathUtils.cos(f3);
            this.m00 = cos * f4;
            this.m01 = (-sin) * f5;
            this.m10 = sin * f4;
            this.m11 = cos * f5;
        }
        return this;
    }

    public com.badlogic.gdx.math.Affine2 setToTrnRotRadScl(com.badlogic.gdx.math.Vector2 vector2, float f, com.badlogic.gdx.math.Vector2 vector22) {
        return setToTrnRotRadScl(vector2.x, vector2.y, f, vector22.x, vector22.y);
    }

    public com.badlogic.gdx.math.Affine2 setToTrnRotScl(float f, float f2, float f3, float f4, float f5) {
        this.m02 = f;
        this.m12 = f2;
        if (f3 == 0.0f) {
            this.m00 = f4;
            this.m01 = 0.0f;
            this.m10 = 0.0f;
            this.m11 = f5;
        } else {
            float sinDeg = com.badlogic.gdx.math.MathUtils.sinDeg(f3);
            float cosDeg = com.badlogic.gdx.math.MathUtils.cosDeg(f3);
            this.m00 = cosDeg * f4;
            this.m01 = (-sinDeg) * f5;
            this.m10 = sinDeg * f4;
            this.m11 = cosDeg * f5;
        }
        return this;
    }

    public com.badlogic.gdx.math.Affine2 setToTrnRotScl(com.badlogic.gdx.math.Vector2 vector2, float f, com.badlogic.gdx.math.Vector2 vector22) {
        return setToTrnRotScl(vector2.x, vector2.y, f, vector22.x, vector22.y);
    }

    public com.badlogic.gdx.math.Affine2 setToTrnScl(float f, float f2, float f3, float f4) {
        this.m00 = f3;
        this.m01 = 0.0f;
        this.m02 = f;
        this.m10 = 0.0f;
        this.m11 = f4;
        this.m12 = f2;
        return this;
    }

    public com.badlogic.gdx.math.Affine2 setToTrnScl(com.badlogic.gdx.math.Vector2 vector2, com.badlogic.gdx.math.Vector2 vector22) {
        return setToTrnScl(vector2.x, vector2.y, vector22.x, vector22.y);
    }

    public com.badlogic.gdx.math.Affine2 shear(float f, float f2) {
        float f3 = this.m00;
        float f4 = this.m01;
        this.m00 = (f2 * f4) + f3;
        this.m01 = f4 + (f3 * f);
        float f5 = this.m10;
        float f6 = this.m11;
        this.m10 = (f2 * f6) + f5;
        this.m11 = f6 + (f * f5);
        return this;
    }

    public com.badlogic.gdx.math.Affine2 shear(com.badlogic.gdx.math.Vector2 vector2) {
        return shear(vector2.x, vector2.y);
    }

    public java.lang.String toString() {
        return "[" + this.m00 + "|" + this.m01 + "|" + this.m02 + "]\n[" + this.m10 + "|" + this.m11 + "|" + this.m12 + "]\n[0.0|0.0|0.1]";
    }

    public com.badlogic.gdx.math.Affine2 translate(float f, float f2) {
        this.m02 += (this.m00 * f) + (this.m01 * f2);
        this.m12 += (this.m10 * f) + (this.m11 * f2);
        return this;
    }

    public com.badlogic.gdx.math.Affine2 translate(com.badlogic.gdx.math.Vector2 vector2) {
        return translate(vector2.x, vector2.y);
    }
}
