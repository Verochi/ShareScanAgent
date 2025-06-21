package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public class Matrix4 implements java.io.Serializable {
    public static final int M00 = 0;
    public static final int M01 = 4;
    public static final int M02 = 8;
    public static final int M03 = 12;
    public static final int M10 = 1;
    public static final int M11 = 5;
    public static final int M12 = 9;
    public static final int M13 = 13;
    public static final int M20 = 2;
    public static final int M21 = 6;
    public static final int M22 = 10;
    public static final int M23 = 14;
    public static final int M30 = 3;
    public static final int M31 = 7;
    public static final int M32 = 11;
    public static final int M33 = 15;
    private static final long serialVersionUID = -2717655254359579617L;
    public final float[] val;
    private static final float[] tmp = new float[16];
    static com.badlogic.gdx.math.Quaternion quat = new com.badlogic.gdx.math.Quaternion();
    static com.badlogic.gdx.math.Quaternion quat2 = new com.badlogic.gdx.math.Quaternion();
    static final com.badlogic.gdx.math.Vector3 l_vez = new com.badlogic.gdx.math.Vector3();
    static final com.badlogic.gdx.math.Vector3 l_vex = new com.badlogic.gdx.math.Vector3();
    static final com.badlogic.gdx.math.Vector3 l_vey = new com.badlogic.gdx.math.Vector3();
    static final com.badlogic.gdx.math.Vector3 tmpVec = new com.badlogic.gdx.math.Vector3();
    static final com.badlogic.gdx.math.Matrix4 tmpMat = new com.badlogic.gdx.math.Matrix4();
    static final com.badlogic.gdx.math.Vector3 right = new com.badlogic.gdx.math.Vector3();
    static final com.badlogic.gdx.math.Vector3 tmpForward = new com.badlogic.gdx.math.Vector3();
    static final com.badlogic.gdx.math.Vector3 tmpUp = new com.badlogic.gdx.math.Vector3();

    public Matrix4() {
        float[] fArr = new float[16];
        this.val = fArr;
        fArr[0] = 1.0f;
        fArr[5] = 1.0f;
        fArr[10] = 1.0f;
        fArr[15] = 1.0f;
    }

    public Matrix4(com.badlogic.gdx.math.Matrix4 matrix4) {
        this.val = new float[16];
        set(matrix4);
    }

    public Matrix4(com.badlogic.gdx.math.Quaternion quaternion) {
        this.val = new float[16];
        set(quaternion);
    }

    public Matrix4(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Quaternion quaternion, com.badlogic.gdx.math.Vector3 vector32) {
        this.val = new float[16];
        set(vector3, quaternion, vector32);
    }

    public Matrix4(float[] fArr) {
        this.val = new float[16];
        set(fArr);
    }

    public static native float det(float[] fArr);

    public static native boolean inv(float[] fArr);

    public static native void mul(float[] fArr, float[] fArr2);

    public static native void mulVec(float[] fArr, float[] fArr2);

    public static native void mulVec(float[] fArr, float[] fArr2, int i, int i2, int i3);

    public static native void prj(float[] fArr, float[] fArr2);

    public static native void prj(float[] fArr, float[] fArr2, int i, int i2, int i3);

    public static native void rot(float[] fArr, float[] fArr2);

    public static native void rot(float[] fArr, float[] fArr2, int i, int i2, int i3);

    public com.badlogic.gdx.math.Matrix4 avg(com.badlogic.gdx.math.Matrix4 matrix4, float f) {
        com.badlogic.gdx.math.Vector3 vector3 = tmpVec;
        getScale(vector3);
        com.badlogic.gdx.math.Vector3 vector32 = tmpForward;
        matrix4.getScale(vector32);
        getRotation(quat);
        matrix4.getRotation(quat2);
        com.badlogic.gdx.math.Vector3 vector33 = tmpUp;
        getTranslation(vector33);
        com.badlogic.gdx.math.Vector3 vector34 = right;
        matrix4.getTranslation(vector34);
        com.badlogic.gdx.math.Vector3 scl = vector3.scl(f);
        float f2 = 1.0f - f;
        setToScaling(scl.add(vector32.scl(f2)));
        rotate(quat.slerp(quat2, f2));
        setTranslation(vector33.scl(f).add(vector34.scl(f2)));
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 avg(com.badlogic.gdx.math.Matrix4[] matrix4Arr) {
        float length = 1.0f / matrix4Arr.length;
        com.badlogic.gdx.math.Vector3 vector3 = tmpVec;
        com.badlogic.gdx.math.Matrix4 matrix4 = matrix4Arr[0];
        com.badlogic.gdx.math.Vector3 vector32 = tmpUp;
        vector3.set(matrix4.getScale(vector32).scl(length));
        quat.set(matrix4Arr[0].getRotation(quat2).exp(length));
        tmpForward.set(matrix4Arr[0].getTranslation(vector32).scl(length));
        for (int i = 1; i < matrix4Arr.length; i++) {
            com.badlogic.gdx.math.Vector3 vector33 = tmpVec;
            com.badlogic.gdx.math.Matrix4 matrix42 = matrix4Arr[i];
            com.badlogic.gdx.math.Vector3 vector34 = tmpUp;
            vector33.add(matrix42.getScale(vector34).scl(length));
            quat.mul(matrix4Arr[i].getRotation(quat2).exp(length));
            tmpForward.add(matrix4Arr[i].getTranslation(vector34).scl(length));
        }
        quat.nor();
        setToScaling(tmpVec);
        rotate(quat);
        setTranslation(tmpForward);
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 avg(com.badlogic.gdx.math.Matrix4[] matrix4Arr, float[] fArr) {
        com.badlogic.gdx.math.Vector3 vector3 = tmpVec;
        com.badlogic.gdx.math.Matrix4 matrix4 = matrix4Arr[0];
        com.badlogic.gdx.math.Vector3 vector32 = tmpUp;
        vector3.set(matrix4.getScale(vector32).scl(fArr[0]));
        quat.set(matrix4Arr[0].getRotation(quat2).exp(fArr[0]));
        tmpForward.set(matrix4Arr[0].getTranslation(vector32).scl(fArr[0]));
        for (int i = 1; i < matrix4Arr.length; i++) {
            com.badlogic.gdx.math.Vector3 vector33 = tmpVec;
            com.badlogic.gdx.math.Matrix4 matrix42 = matrix4Arr[i];
            com.badlogic.gdx.math.Vector3 vector34 = tmpUp;
            vector33.add(matrix42.getScale(vector34).scl(fArr[i]));
            quat.mul(matrix4Arr[i].getRotation(quat2).exp(fArr[i]));
            tmpForward.add(matrix4Arr[i].getTranslation(vector34).scl(fArr[i]));
        }
        quat.nor();
        setToScaling(tmpVec);
        rotate(quat);
        setTranslation(tmpForward);
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 cpy() {
        return new com.badlogic.gdx.math.Matrix4(this);
    }

    public float det() {
        float[] fArr = this.val;
        float f = fArr[3];
        float f2 = fArr[6];
        float f3 = fArr[9];
        float f4 = fArr[12];
        float f5 = fArr[2];
        float f6 = fArr[7];
        float f7 = fArr[5];
        float f8 = fArr[10];
        float f9 = fArr[1];
        float f10 = fArr[11];
        float f11 = fArr[8];
        float f12 = fArr[13];
        float f13 = (((((((((f * f2) * f3) * f4) - (((f5 * f6) * f3) * f4)) - (((f * f7) * f8) * f4)) + (((f9 * f6) * f8) * f4)) + (((f5 * f7) * f10) * f4)) - (((f9 * f2) * f10) * f4)) - (((f * f2) * f11) * f12)) + (f5 * f6 * f11 * f12);
        float f14 = fArr[4];
        float f15 = fArr[0];
        float f16 = (((f13 + (((f * f14) * f8) * f12)) - (((f15 * f6) * f8) * f12)) - (((f5 * f14) * f10) * f12)) + (f15 * f2 * f10 * f12);
        float f17 = fArr[14];
        float f18 = fArr[15];
        return (((((((((((f16 + (((f * f7) * f11) * f17)) - (((f9 * f6) * f11) * f17)) - (((f * f14) * f3) * f17)) + (((f6 * f15) * f3) * f17)) + (((f9 * f14) * f10) * f17)) - (((f15 * f7) * f10) * f17)) - (((f5 * f7) * f11) * f18)) + (((f9 * f2) * f11) * f18)) + (((f5 * f14) * f3) * f18)) - (((f2 * f15) * f3) * f18)) - (((f9 * f14) * f8) * f18)) + (f15 * f7 * f8 * f18);
    }

    public float det3x3() {
        float[] fArr = this.val;
        float f = fArr[0];
        float f2 = fArr[5];
        float f3 = fArr[10];
        float f4 = fArr[4];
        float f5 = fArr[9];
        float f6 = fArr[2];
        float f7 = (f * f2 * f3) + (f4 * f5 * f6);
        float f8 = fArr[8];
        float f9 = fArr[1];
        float f10 = fArr[6];
        return (((f7 + ((f8 * f9) * f10)) - ((f * f5) * f10)) - ((f4 * f9) * f3)) - ((f8 * f2) * f6);
    }

    public void extract4x3Matrix(float[] fArr) {
        float[] fArr2 = this.val;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = fArr2[2];
        fArr[3] = fArr2[4];
        fArr[4] = fArr2[5];
        fArr[5] = fArr2[6];
        fArr[6] = fArr2[8];
        fArr[7] = fArr2[9];
        fArr[8] = fArr2[10];
        fArr[9] = fArr2[12];
        fArr[10] = fArr2[13];
        fArr[11] = fArr2[14];
    }

    public com.badlogic.gdx.math.Quaternion getRotation(com.badlogic.gdx.math.Quaternion quaternion) {
        return quaternion.setFromMatrix(this);
    }

    public com.badlogic.gdx.math.Quaternion getRotation(com.badlogic.gdx.math.Quaternion quaternion, boolean z) {
        return quaternion.setFromMatrix(z, this);
    }

    public com.badlogic.gdx.math.Vector3 getScale(com.badlogic.gdx.math.Vector3 vector3) {
        return vector3.set(getScaleX(), getScaleY(), getScaleZ());
    }

    public float getScaleX() {
        return (com.badlogic.gdx.math.MathUtils.isZero(this.val[4]) && com.badlogic.gdx.math.MathUtils.isZero(this.val[8])) ? java.lang.Math.abs(this.val[0]) : (float) java.lang.Math.sqrt(getScaleXSquared());
    }

    public float getScaleXSquared() {
        float[] fArr = this.val;
        float f = fArr[0];
        float f2 = fArr[4];
        float f3 = fArr[8];
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    public float getScaleY() {
        return (com.badlogic.gdx.math.MathUtils.isZero(this.val[1]) && com.badlogic.gdx.math.MathUtils.isZero(this.val[9])) ? java.lang.Math.abs(this.val[5]) : (float) java.lang.Math.sqrt(getScaleYSquared());
    }

    public float getScaleYSquared() {
        float[] fArr = this.val;
        float f = fArr[1];
        float f2 = fArr[5];
        float f3 = fArr[9];
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    public float getScaleZ() {
        return (com.badlogic.gdx.math.MathUtils.isZero(this.val[2]) && com.badlogic.gdx.math.MathUtils.isZero(this.val[6])) ? java.lang.Math.abs(this.val[10]) : (float) java.lang.Math.sqrt(getScaleZSquared());
    }

    public float getScaleZSquared() {
        float[] fArr = this.val;
        float f = fArr[2];
        float f2 = fArr[6];
        float f3 = fArr[10];
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    public com.badlogic.gdx.math.Vector3 getTranslation(com.badlogic.gdx.math.Vector3 vector3) {
        float[] fArr = this.val;
        vector3.x = fArr[12];
        vector3.y = fArr[13];
        vector3.z = fArr[14];
        return vector3;
    }

    public float[] getValues() {
        return this.val;
    }

    public boolean hasRotationOrScaling() {
        return (com.badlogic.gdx.math.MathUtils.isEqual(this.val[0], 1.0f) && com.badlogic.gdx.math.MathUtils.isEqual(this.val[5], 1.0f) && com.badlogic.gdx.math.MathUtils.isEqual(this.val[10], 1.0f) && com.badlogic.gdx.math.MathUtils.isZero(this.val[4]) && com.badlogic.gdx.math.MathUtils.isZero(this.val[8]) && com.badlogic.gdx.math.MathUtils.isZero(this.val[1]) && com.badlogic.gdx.math.MathUtils.isZero(this.val[9]) && com.badlogic.gdx.math.MathUtils.isZero(this.val[2]) && com.badlogic.gdx.math.MathUtils.isZero(this.val[6])) ? false : true;
    }

    public com.badlogic.gdx.math.Matrix4 idt() {
        float[] fArr = this.val;
        fArr[0] = 1.0f;
        fArr[4] = 0.0f;
        fArr[8] = 0.0f;
        fArr[12] = 0.0f;
        fArr[1] = 0.0f;
        fArr[5] = 1.0f;
        fArr[9] = 0.0f;
        fArr[13] = 0.0f;
        fArr[2] = 0.0f;
        fArr[6] = 0.0f;
        fArr[10] = 1.0f;
        fArr[14] = 0.0f;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 inv() {
        float[] fArr = this.val;
        float f = fArr[3];
        float f2 = fArr[6];
        float f3 = fArr[9];
        float f4 = fArr[12];
        float f5 = fArr[2];
        float f6 = fArr[7];
        float f7 = fArr[5];
        float f8 = fArr[10];
        float f9 = fArr[1];
        float f10 = fArr[11];
        float f11 = fArr[8];
        float f12 = fArr[13];
        float f13 = fArr[4];
        float f14 = fArr[0];
        float f15 = fArr[14];
        float f16 = fArr[15];
        float f17 = (((((((((((((((((((((((((f * f2) * f3) * f4) - (((f5 * f6) * f3) * f4)) - (((f * f7) * f8) * f4)) + (((f9 * f6) * f8) * f4)) + (((f5 * f7) * f10) * f4)) - (((f9 * f2) * f10) * f4)) - (((f * f2) * f11) * f12)) + (((f5 * f6) * f11) * f12)) + (((f * f13) * f8) * f12)) - (((f14 * f6) * f8) * f12)) - (((f5 * f13) * f10) * f12)) + (((f14 * f2) * f10) * f12)) + (((f * f7) * f11) * f15)) - (((f9 * f6) * f11) * f15)) - (((f * f13) * f3) * f15)) + (((f14 * f6) * f3) * f15)) + (((f9 * f13) * f10) * f15)) - (((f14 * f7) * f10) * f15)) - (((f5 * f7) * f11) * f16)) + (((f9 * f2) * f11) * f16)) + (((f5 * f13) * f3) * f16)) - (((f14 * f2) * f3) * f16)) - (((f9 * f13) * f8) * f16)) + (f14 * f7 * f8 * f16);
        if (f17 == 0.0f) {
            throw new java.lang.RuntimeException("non-invertible matrix");
        }
        float f18 = 1.0f / f17;
        float[] fArr2 = tmp;
        float f19 = ((((((f3 * f15) * f6) - ((f12 * f8) * f6)) + ((f12 * f2) * f10)) - ((f7 * f15) * f10)) - ((f3 * f2) * f16)) + (f7 * f8 * f16);
        fArr2[0] = f19;
        float f20 = ((((((f4 * f8) * f6) - ((f11 * f15) * f6)) - ((f4 * f2) * f10)) + ((f13 * f15) * f10)) + ((f11 * f2) * f16)) - ((f13 * f8) * f16);
        fArr2[4] = f20;
        float f21 = fArr[4];
        float f22 = ((((((f11 * f12) * f6) - ((f4 * f3) * f6)) + ((f4 * f7) * f10)) - ((f21 * f12) * f10)) - ((f11 * f7) * f16)) + (f21 * f3 * f16);
        fArr2[8] = f22;
        float f23 = fArr[8];
        float f24 = ((((((f4 * f3) * f2) - ((f23 * f12) * f2)) - ((f4 * f7) * f8)) + ((f21 * f12) * f8)) + ((f7 * f23) * f15)) - ((f21 * f3) * f15);
        fArr2[12] = f24;
        float f25 = ((((((f12 * f8) * f) - ((f3 * f15) * f)) - ((f12 * f5) * f10)) + ((f9 * f15) * f10)) + ((f3 * f5) * f16)) - ((f9 * f8) * f16);
        fArr2[1] = f25;
        float f26 = fArr[12];
        float f27 = fArr[0];
        float f28 = ((((((f23 * f15) * f) - ((f26 * f8) * f)) + ((f26 * f5) * f10)) - ((f27 * f15) * f10)) - ((f23 * f5) * f16)) + (f27 * f8 * f16);
        fArr2[5] = f28;
        float f29 = fArr[1];
        float f30 = ((((((f26 * f3) * f) - ((f23 * f12) * f)) - ((f26 * f29) * f10)) + ((f27 * f12) * f10)) + ((f23 * f29) * f16)) - ((f3 * f27) * f16);
        fArr2[9] = f30;
        float f31 = fArr[9];
        float f32 = ((((((f23 * f12) * f5) - ((f26 * f31) * f5)) + ((f26 * f29) * f8)) - ((f12 * f27) * f8)) - ((f23 * f29) * f15)) + (f27 * f31 * f15);
        fArr2[13] = f32;
        float f33 = fArr[5];
        float f34 = fArr[13];
        float f35 = ((((((f33 * f15) * f) - ((f34 * f2) * f)) + ((f34 * f5) * f6)) - ((f29 * f15) * f6)) - ((f5 * f33) * f16)) + (f29 * f2 * f16);
        fArr2[2] = f35;
        float f36 = fArr[2];
        float f37 = ((((((f26 * f2) * f) - ((f21 * f15) * f)) - ((f26 * f36) * f6)) + ((f27 * f15) * f6)) + ((f21 * f36) * f16)) - ((f2 * f27) * f16);
        fArr2[6] = f37;
        float f38 = ((((((f21 * f34) * f) - ((f26 * f33) * f)) + ((f26 * f29) * f6)) - ((f27 * f34) * f6)) - ((f21 * f29) * f16)) + (f27 * f33 * f16);
        fArr2[10] = f38;
        float f39 = fArr[6];
        float f40 = ((((((f26 * f33) * f36) - ((f21 * f34) * f36)) - ((f26 * f29) * f39)) + ((f34 * f27) * f39)) + ((f21 * f29) * f15)) - ((f27 * f33) * f15);
        fArr2[14] = f40;
        float f41 = fArr[10];
        float f42 = ((((((f31 * f39) * f) - ((f33 * f41) * f)) - ((f31 * f36) * f6)) + ((f29 * f41) * f6)) + ((f33 * f36) * f10)) - ((f29 * f39) * f10);
        fArr2[3] = f42;
        float f43 = fArr[3];
        float f44 = ((((((f21 * f41) * f43) - ((f23 * f39) * f43)) + ((f23 * f36) * f6)) - ((f27 * f41) * f6)) - ((f21 * f36) * f10)) + (f27 * f39 * f10);
        fArr2[7] = f44;
        float f45 = fArr[7];
        float f46 = ((((((f23 * f33) * f43) - ((f21 * f31) * f43)) - ((f23 * f29) * f45)) + ((f27 * f31) * f45)) + ((f21 * f29) * f10)) - ((f27 * f33) * f10);
        fArr2[11] = f46;
        float f47 = ((((((f21 * f31) * f36) - ((f23 * f33) * f36)) + ((f23 * f29) * f39)) - ((f31 * f27) * f39)) - ((f21 * f29) * f41)) + (f27 * f33 * f41);
        fArr2[15] = f47;
        fArr[0] = f19 * f18;
        fArr[4] = f20 * f18;
        fArr[8] = f22 * f18;
        fArr[12] = f24 * f18;
        fArr[1] = f25 * f18;
        fArr[5] = f28 * f18;
        fArr[9] = f30 * f18;
        fArr[13] = f32 * f18;
        fArr[2] = f35 * f18;
        fArr[6] = f37 * f18;
        fArr[10] = f38 * f18;
        fArr[14] = f40 * f18;
        fArr[3] = f42 * f18;
        fArr[7] = f44 * f18;
        fArr[11] = f46 * f18;
        fArr[15] = f47 * f18;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 lerp(com.badlogic.gdx.math.Matrix4 matrix4, float f) {
        for (int i = 0; i < 16; i++) {
            float[] fArr = this.val;
            fArr[i] = (fArr[i] * (1.0f - f)) + (matrix4.val[i] * f);
        }
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 mul(com.badlogic.gdx.math.Matrix4 matrix4) {
        mul(this.val, matrix4.val);
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 mulLeft(com.badlogic.gdx.math.Matrix4 matrix4) {
        com.badlogic.gdx.math.Matrix4 matrix42 = tmpMat;
        matrix42.set(matrix4);
        mul(matrix42.val, this.val);
        return set(matrix42);
    }

    public com.badlogic.gdx.math.Matrix4 rotate(float f, float f2, float f3, float f4) {
        if (f4 == 0.0f) {
            return this;
        }
        quat.setFromAxis(f, f2, f3, f4);
        return rotate(quat);
    }

    public com.badlogic.gdx.math.Matrix4 rotate(com.badlogic.gdx.math.Quaternion quaternion) {
        float[] fArr = tmp;
        quaternion.toMatrix(fArr);
        mul(this.val, fArr);
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 rotate(com.badlogic.gdx.math.Vector3 vector3, float f) {
        if (f == 0.0f) {
            return this;
        }
        quat.set(vector3, f);
        return rotate(quat);
    }

    public com.badlogic.gdx.math.Matrix4 rotate(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32) {
        return rotate(quat.setFromCross(vector3, vector32));
    }

    public com.badlogic.gdx.math.Matrix4 rotateRad(float f, float f2, float f3, float f4) {
        if (f4 == 0.0f) {
            return this;
        }
        quat.setFromAxisRad(f, f2, f3, f4);
        return rotate(quat);
    }

    public com.badlogic.gdx.math.Matrix4 rotateRad(com.badlogic.gdx.math.Vector3 vector3, float f) {
        if (f == 0.0f) {
            return this;
        }
        quat.setFromAxisRad(vector3, f);
        return rotate(quat);
    }

    public com.badlogic.gdx.math.Matrix4 scale(float f, float f2, float f3) {
        float[] fArr = tmp;
        fArr[0] = f;
        fArr[4] = 0.0f;
        fArr[8] = 0.0f;
        fArr[12] = 0.0f;
        fArr[1] = 0.0f;
        fArr[5] = f2;
        fArr[9] = 0.0f;
        fArr[13] = 0.0f;
        fArr[2] = 0.0f;
        fArr[6] = 0.0f;
        fArr[10] = f3;
        fArr[14] = 0.0f;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        mul(this.val, fArr);
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 scl(float f) {
        float[] fArr = this.val;
        fArr[0] = fArr[0] * f;
        fArr[5] = fArr[5] * f;
        fArr[10] = fArr[10] * f;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 scl(float f, float f2, float f3) {
        float[] fArr = this.val;
        fArr[0] = fArr[0] * f;
        fArr[5] = fArr[5] * f2;
        fArr[10] = fArr[10] * f3;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 scl(com.badlogic.gdx.math.Vector3 vector3) {
        float[] fArr = this.val;
        fArr[0] = fArr[0] * vector3.x;
        fArr[5] = fArr[5] * vector3.y;
        fArr[10] = fArr[10] * vector3.z;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 set(float f, float f2, float f3, float f4) {
        return set(0.0f, 0.0f, 0.0f, f, f2, f3, f4);
    }

    public com.badlogic.gdx.math.Matrix4 set(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f4 * 2.0f;
        float f9 = f5 * 2.0f;
        float f10 = 2.0f * f6;
        float f11 = f7 * f8;
        float f12 = f7 * f9;
        float f13 = f7 * f10;
        float f14 = f8 * f4;
        float f15 = f4 * f9;
        float f16 = f4 * f10;
        float f17 = f9 * f5;
        float f18 = f5 * f10;
        float f19 = f10 * f6;
        float[] fArr = this.val;
        fArr[0] = 1.0f - (f17 + f19);
        fArr[4] = f15 - f13;
        fArr[8] = f16 + f12;
        fArr[12] = f;
        fArr[1] = f15 + f13;
        fArr[5] = 1.0f - (f19 + f14);
        fArr[9] = f18 - f11;
        fArr[13] = f2;
        fArr[2] = f16 - f12;
        fArr[6] = f18 + f11;
        fArr[10] = 1.0f - (f14 + f17);
        fArr[14] = f3;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 set(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11 = f4 * 2.0f;
        float f12 = f5 * 2.0f;
        float f13 = 2.0f * f6;
        float f14 = f7 * f11;
        float f15 = f7 * f12;
        float f16 = f7 * f13;
        float f17 = f11 * f4;
        float f18 = f4 * f12;
        float f19 = f4 * f13;
        float f20 = f12 * f5;
        float f21 = f5 * f13;
        float f22 = f13 * f6;
        float[] fArr = this.val;
        fArr[0] = (1.0f - (f20 + f22)) * f8;
        fArr[4] = (f18 - f16) * f9;
        fArr[8] = (f19 + f15) * f10;
        fArr[12] = f;
        fArr[1] = f8 * (f18 + f16);
        fArr[5] = (1.0f - (f22 + f17)) * f9;
        fArr[9] = (f21 - f14) * f10;
        fArr[13] = f2;
        fArr[2] = f8 * (f19 - f15);
        fArr[6] = f9 * (f21 + f14);
        fArr[10] = (1.0f - (f17 + f20)) * f10;
        fArr[14] = f3;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 set(com.badlogic.gdx.math.Affine2 affine2) {
        float[] fArr = this.val;
        fArr[0] = affine2.m00;
        fArr[1] = affine2.m10;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = affine2.m01;
        fArr[5] = affine2.m11;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = affine2.m02;
        fArr[13] = affine2.m12;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 set(com.badlogic.gdx.math.Matrix3 matrix3) {
        float[] fArr = this.val;
        float[] fArr2 = matrix3.val;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = fArr2[2];
        fArr[3] = 0.0f;
        fArr[4] = fArr2[3];
        fArr[5] = fArr2[4];
        fArr[6] = fArr2[5];
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = fArr2[6];
        fArr[13] = fArr2[7];
        fArr[14] = 0.0f;
        fArr[15] = fArr2[8];
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 set(com.badlogic.gdx.math.Matrix4 matrix4) {
        return set(matrix4.val);
    }

    public com.badlogic.gdx.math.Matrix4 set(com.badlogic.gdx.math.Quaternion quaternion) {
        return set(quaternion.x, quaternion.y, quaternion.z, quaternion.w);
    }

    public com.badlogic.gdx.math.Matrix4 set(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Quaternion quaternion) {
        return set(vector3.x, vector3.y, vector3.z, quaternion.x, quaternion.y, quaternion.z, quaternion.w);
    }

    public com.badlogic.gdx.math.Matrix4 set(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Quaternion quaternion, com.badlogic.gdx.math.Vector3 vector32) {
        return set(vector3.x, vector3.y, vector3.z, quaternion.x, quaternion.y, quaternion.z, quaternion.w, vector32.x, vector32.y, vector32.z);
    }

    public com.badlogic.gdx.math.Matrix4 set(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32, com.badlogic.gdx.math.Vector3 vector33, com.badlogic.gdx.math.Vector3 vector34) {
        float[] fArr = this.val;
        fArr[0] = vector3.x;
        fArr[4] = vector3.y;
        fArr[8] = vector3.z;
        fArr[1] = vector32.x;
        fArr[5] = vector32.y;
        fArr[9] = vector32.z;
        fArr[2] = vector33.x;
        fArr[6] = vector33.y;
        fArr[10] = vector33.z;
        fArr[12] = vector34.x;
        fArr[13] = vector34.y;
        fArr[14] = vector34.z;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 set(float[] fArr) {
        float[] fArr2 = this.val;
        java.lang.System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setAsAffine(com.badlogic.gdx.math.Affine2 affine2) {
        float[] fArr = this.val;
        fArr[0] = affine2.m00;
        fArr[1] = affine2.m10;
        fArr[4] = affine2.m01;
        fArr[5] = affine2.m11;
        fArr[12] = affine2.m02;
        fArr[13] = affine2.m12;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setAsAffine(com.badlogic.gdx.math.Matrix4 matrix4) {
        float[] fArr = this.val;
        float[] fArr2 = matrix4.val;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[4] = fArr2[4];
        fArr[5] = fArr2[5];
        fArr[12] = fArr2[12];
        fArr[13] = fArr2[13];
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setFromEulerAngles(float f, float f2, float f3) {
        quat.setEulerAngles(f, f2, f3);
        return set(quat);
    }

    public com.badlogic.gdx.math.Matrix4 setFromEulerAnglesRad(float f, float f2, float f3) {
        quat.setEulerAnglesRad(f, f2, f3);
        return set(quat);
    }

    public com.badlogic.gdx.math.Matrix4 setToLookAt(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32) {
        com.badlogic.gdx.math.Vector3 vector33 = l_vez;
        vector33.set(vector3).nor();
        com.badlogic.gdx.math.Vector3 vector34 = l_vex;
        vector34.set(vector3).nor();
        vector34.crs(vector32).nor();
        com.badlogic.gdx.math.Vector3 vector35 = l_vey;
        vector35.set(vector34).crs(vector33).nor();
        idt();
        float[] fArr = this.val;
        fArr[0] = vector34.x;
        fArr[4] = vector34.y;
        fArr[8] = vector34.z;
        fArr[1] = vector35.x;
        fArr[5] = vector35.y;
        fArr[9] = vector35.z;
        fArr[2] = -vector33.x;
        fArr[6] = -vector33.y;
        fArr[10] = -vector33.z;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToLookAt(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32, com.badlogic.gdx.math.Vector3 vector33) {
        com.badlogic.gdx.math.Vector3 vector34 = tmpVec;
        vector34.set(vector32).sub(vector3);
        setToLookAt(vector34, vector33);
        mul(tmpMat.setToTranslation(-vector3.x, -vector3.y, -vector3.z));
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToOrtho(float f, float f2, float f3, float f4, float f5, float f6) {
        idt();
        float f7 = f2 - f;
        float f8 = f4 - f3;
        float f9 = f6 - f5;
        float f10 = (-(f2 + f)) / f7;
        float f11 = (-(f4 + f3)) / f8;
        float[] fArr = this.val;
        fArr[0] = 2.0f / f7;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 2.0f / f8;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = (-2.0f) / f9;
        fArr[11] = 0.0f;
        fArr[12] = f10;
        fArr[13] = f11;
        fArr[14] = (-(f6 + f5)) / f9;
        fArr[15] = 1.0f;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToOrtho2D(float f, float f2, float f3, float f4) {
        setToOrtho(f, f + f3, f2, f2 + f4, 0.0f, 1.0f);
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToOrtho2D(float f, float f2, float f3, float f4, float f5, float f6) {
        setToOrtho(f, f + f3, f2, f2 + f4, f5, f6);
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToProjection(float f, float f2, float f3, float f4) {
        idt();
        float tan = (float) (1.0d / java.lang.Math.tan((f3 * 0.017453292519943295d) / 2.0d));
        float f5 = f - f2;
        float f6 = (f2 + f) / f5;
        float f7 = ((f2 * 2.0f) * f) / f5;
        float[] fArr = this.val;
        fArr[0] = tan / f4;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = tan;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = f6;
        fArr[11] = -1.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = f7;
        fArr[15] = 0.0f;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToProjection(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f5 * 2.0f;
        float f8 = f2 - f;
        float f9 = f4 - f3;
        float f10 = (f2 + f) / f8;
        float f11 = (f4 + f3) / f9;
        float f12 = f5 - f6;
        float f13 = (f6 + f5) / f12;
        float f14 = ((f6 * 2.0f) * f5) / f12;
        float[] fArr = this.val;
        fArr[0] = f7 / f8;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = f7 / f9;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = f10;
        fArr[9] = f11;
        fArr[10] = f13;
        fArr[11] = -1.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = f14;
        fArr[15] = 0.0f;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToRotation(float f, float f2, float f3, float f4) {
        if (f4 != 0.0f) {
            return set(quat.setFromAxis(f, f2, f3, f4));
        }
        idt();
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToRotation(float f, float f2, float f3, float f4, float f5, float f6) {
        return set(quat.setFromCross(f, f2, f3, f4, f5, f6));
    }

    public com.badlogic.gdx.math.Matrix4 setToRotation(com.badlogic.gdx.math.Vector3 vector3, float f) {
        if (f != 0.0f) {
            return set(quat.set(vector3, f));
        }
        idt();
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToRotation(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32) {
        return set(quat.setFromCross(vector3, vector32));
    }

    public com.badlogic.gdx.math.Matrix4 setToRotationRad(float f, float f2, float f3, float f4) {
        if (f4 != 0.0f) {
            return set(quat.setFromAxisRad(f, f2, f3, f4));
        }
        idt();
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToRotationRad(com.badlogic.gdx.math.Vector3 vector3, float f) {
        if (f != 0.0f) {
            return set(quat.setFromAxisRad(vector3, f));
        }
        idt();
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToScaling(float f, float f2, float f3) {
        idt();
        float[] fArr = this.val;
        fArr[0] = f;
        fArr[5] = f2;
        fArr[10] = f3;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToScaling(com.badlogic.gdx.math.Vector3 vector3) {
        idt();
        float[] fArr = this.val;
        fArr[0] = vector3.x;
        fArr[5] = vector3.y;
        fArr[10] = vector3.z;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToTranslation(float f, float f2, float f3) {
        idt();
        float[] fArr = this.val;
        fArr[12] = f;
        fArr[13] = f2;
        fArr[14] = f3;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToTranslation(com.badlogic.gdx.math.Vector3 vector3) {
        idt();
        float[] fArr = this.val;
        fArr[12] = vector3.x;
        fArr[13] = vector3.y;
        fArr[14] = vector3.z;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToTranslationAndScaling(float f, float f2, float f3, float f4, float f5, float f6) {
        idt();
        float[] fArr = this.val;
        fArr[12] = f;
        fArr[13] = f2;
        fArr[14] = f3;
        fArr[0] = f4;
        fArr[5] = f5;
        fArr[10] = f6;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToTranslationAndScaling(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32) {
        idt();
        float[] fArr = this.val;
        fArr[12] = vector3.x;
        fArr[13] = vector3.y;
        fArr[14] = vector3.z;
        fArr[0] = vector32.x;
        fArr[5] = vector32.y;
        fArr[10] = vector32.z;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setToWorld(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32, com.badlogic.gdx.math.Vector3 vector33) {
        com.badlogic.gdx.math.Vector3 vector34 = tmpForward;
        vector34.set(vector32).nor();
        com.badlogic.gdx.math.Vector3 vector35 = right;
        vector35.set(vector34).crs(vector33).nor();
        com.badlogic.gdx.math.Vector3 vector36 = tmpUp;
        vector36.set(vector35).crs(vector34).nor();
        set(vector35, vector36, vector34.scl(-1.0f), vector3);
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setTranslation(float f, float f2, float f3) {
        float[] fArr = this.val;
        fArr[12] = f;
        fArr[13] = f2;
        fArr[14] = f3;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 setTranslation(com.badlogic.gdx.math.Vector3 vector3) {
        float[] fArr = this.val;
        fArr[12] = vector3.x;
        fArr[13] = vector3.y;
        fArr[14] = vector3.z;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 toNormalMatrix() {
        float[] fArr = this.val;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        return inv().tra();
    }

    public java.lang.String toString() {
        return "[" + this.val[0] + "|" + this.val[4] + "|" + this.val[8] + "|" + this.val[12] + "]\n[" + this.val[1] + "|" + this.val[5] + "|" + this.val[9] + "|" + this.val[13] + "]\n[" + this.val[2] + "|" + this.val[6] + "|" + this.val[10] + "|" + this.val[14] + "]\n[" + this.val[3] + "|" + this.val[7] + "|" + this.val[11] + "|" + this.val[15] + "]\n";
    }

    public com.badlogic.gdx.math.Matrix4 tra() {
        float[] fArr = tmp;
        float[] fArr2 = this.val;
        fArr[0] = fArr2[0];
        fArr[4] = fArr2[1];
        fArr[8] = fArr2[2];
        fArr[12] = fArr2[3];
        fArr[1] = fArr2[4];
        fArr[5] = fArr2[5];
        fArr[9] = fArr2[6];
        fArr[13] = fArr2[7];
        fArr[2] = fArr2[8];
        fArr[6] = fArr2[9];
        fArr[10] = fArr2[10];
        fArr[14] = fArr2[11];
        fArr[3] = fArr2[12];
        fArr[7] = fArr2[13];
        fArr[11] = fArr2[14];
        fArr[15] = fArr2[15];
        return set(fArr);
    }

    public com.badlogic.gdx.math.Matrix4 translate(float f, float f2, float f3) {
        float[] fArr = tmp;
        fArr[0] = 1.0f;
        fArr[4] = 0.0f;
        fArr[8] = 0.0f;
        fArr[12] = f;
        fArr[1] = 0.0f;
        fArr[5] = 1.0f;
        fArr[9] = 0.0f;
        fArr[13] = f2;
        fArr[2] = 0.0f;
        fArr[6] = 0.0f;
        fArr[10] = 1.0f;
        fArr[14] = f3;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        mul(this.val, fArr);
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 translate(com.badlogic.gdx.math.Vector3 vector3) {
        return translate(vector3.x, vector3.y, vector3.z);
    }

    public com.badlogic.gdx.math.Matrix4 trn(float f, float f2, float f3) {
        float[] fArr = this.val;
        fArr[12] = fArr[12] + f;
        fArr[13] = fArr[13] + f2;
        fArr[14] = fArr[14] + f3;
        return this;
    }

    public com.badlogic.gdx.math.Matrix4 trn(com.badlogic.gdx.math.Vector3 vector3) {
        float[] fArr = this.val;
        fArr[12] = fArr[12] + vector3.x;
        fArr[13] = fArr[13] + vector3.y;
        fArr[14] = fArr[14] + vector3.z;
        return this;
    }
}
