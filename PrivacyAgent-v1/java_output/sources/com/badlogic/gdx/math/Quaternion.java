package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public class Quaternion implements java.io.Serializable {
    private static final long serialVersionUID = -7661875440774897168L;
    private static com.badlogic.gdx.math.Quaternion tmp1 = new com.badlogic.gdx.math.Quaternion(0.0f, 0.0f, 0.0f, 0.0f);
    private static com.badlogic.gdx.math.Quaternion tmp2 = new com.badlogic.gdx.math.Quaternion(0.0f, 0.0f, 0.0f, 0.0f);
    public float w;
    public float x;
    public float y;
    public float z;

    public Quaternion() {
        idt();
    }

    public Quaternion(float f, float f2, float f3, float f4) {
        set(f, f2, f3, f4);
    }

    public Quaternion(com.badlogic.gdx.math.Quaternion quaternion) {
        set(quaternion);
    }

    public Quaternion(com.badlogic.gdx.math.Vector3 vector3, float f) {
        set(vector3, f);
    }

    public static final float dot(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return (f * f5) + (f2 * f6) + (f3 * f7) + (f4 * f8);
    }

    public static final float len(float f, float f2, float f3, float f4) {
        return (float) java.lang.Math.sqrt((f * f) + (f2 * f2) + (f3 * f3) + (f4 * f4));
    }

    public static final float len2(float f, float f2, float f3, float f4) {
        return (f * f) + (f2 * f2) + (f3 * f3) + (f4 * f4);
    }

    public com.badlogic.gdx.math.Quaternion add(float f, float f2, float f3, float f4) {
        this.x += f;
        this.y += f2;
        this.z += f3;
        this.w += f4;
        return this;
    }

    public com.badlogic.gdx.math.Quaternion add(com.badlogic.gdx.math.Quaternion quaternion) {
        this.x += quaternion.x;
        this.y += quaternion.y;
        this.z += quaternion.z;
        this.w += quaternion.w;
        return this;
    }

    public com.badlogic.gdx.math.Quaternion conjugate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public com.badlogic.gdx.math.Quaternion cpy() {
        return new com.badlogic.gdx.math.Quaternion(this);
    }

    public float dot(float f, float f2, float f3, float f4) {
        return (this.x * f) + (this.y * f2) + (this.z * f3) + (this.w * f4);
    }

    public float dot(com.badlogic.gdx.math.Quaternion quaternion) {
        return (this.x * quaternion.x) + (this.y * quaternion.y) + (this.z * quaternion.z) + (this.w * quaternion.w);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof com.badlogic.gdx.math.Quaternion)) {
            return false;
        }
        com.badlogic.gdx.math.Quaternion quaternion = (com.badlogic.gdx.math.Quaternion) obj;
        return com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.w) == com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(quaternion.w) && com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.x) == com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(quaternion.x) && com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.y) == com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(quaternion.y) && com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.z) == com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(quaternion.z);
    }

    public com.badlogic.gdx.math.Quaternion exp(float f) {
        float len = len();
        double d = len;
        float pow = (float) java.lang.Math.pow(d, f);
        float acos = (float) java.lang.Math.acos(this.w / len);
        float sin = ((double) java.lang.Math.abs(acos)) < 0.001d ? (pow * f) / len : (float) ((pow * java.lang.Math.sin(f * acos)) / (d * java.lang.Math.sin(acos)));
        this.w = (float) (pow * java.lang.Math.cos(f * acos));
        this.x *= sin;
        this.y *= sin;
        this.z *= sin;
        nor();
        return this;
    }

    public float getAngle() {
        return getAngleRad() * 57.295776f;
    }

    public float getAngleAround(float f, float f2, float f3) {
        return getAngleAroundRad(f, f2, f3) * 57.295776f;
    }

    public float getAngleAround(com.badlogic.gdx.math.Vector3 vector3) {
        return getAngleAround(vector3.x, vector3.y, vector3.z);
    }

    public float getAngleAroundRad(float f, float f2, float f3) {
        float dot = com.badlogic.gdx.math.Vector3.dot(this.x, this.y, this.z, f, f2, f3);
        if (com.badlogic.gdx.math.MathUtils.isZero(len2(f * dot, f2 * dot, f3 * dot, this.w))) {
            return 0.0f;
        }
        return (float) (java.lang.Math.acos(com.badlogic.gdx.math.MathUtils.clamp((float) ((dot < 0.0f ? -this.w : this.w) / java.lang.Math.sqrt(r7)), -1.0f, 1.0f)) * 2.0d);
    }

    public float getAngleAroundRad(com.badlogic.gdx.math.Vector3 vector3) {
        return getAngleAroundRad(vector3.x, vector3.y, vector3.z);
    }

    public float getAngleRad() {
        float f = this.w;
        if (f > 1.0f) {
            f /= len();
        }
        return (float) (java.lang.Math.acos(f) * 2.0d);
    }

    public float getAxisAngle(com.badlogic.gdx.math.Vector3 vector3) {
        return getAxisAngleRad(vector3) * 57.295776f;
    }

    public float getAxisAngleRad(com.badlogic.gdx.math.Vector3 vector3) {
        if (this.w > 1.0f) {
            nor();
        }
        float acos = (float) (java.lang.Math.acos(this.w) * 2.0d);
        float f = this.w;
        double sqrt = java.lang.Math.sqrt(1.0f - (f * f));
        if (sqrt < 9.999999974752427E-7d) {
            vector3.x = this.x;
            vector3.y = this.y;
            vector3.z = this.z;
        } else {
            vector3.x = (float) (this.x / sqrt);
            vector3.y = (float) (this.y / sqrt);
            vector3.z = (float) (this.z / sqrt);
        }
        return acos;
    }

    public int getGimbalPole() {
        float f = (this.y * this.x) + (this.z * this.w);
        if (f > 0.499f) {
            return 1;
        }
        return f < -0.499f ? -1 : 0;
    }

    public float getPitch() {
        return getPitchRad() * 57.295776f;
    }

    public float getPitchRad() {
        int gimbalPole = getGimbalPole();
        return gimbalPole == 0 ? (float) java.lang.Math.asin(com.badlogic.gdx.math.MathUtils.clamp(((this.w * this.x) - (this.z * this.y)) * 2.0f, -1.0f, 1.0f)) : gimbalPole * 3.1415927f * 0.5f;
    }

    public float getRoll() {
        return getRollRad() * 57.295776f;
    }

    public float getRollRad() {
        int gimbalPole = getGimbalPole();
        if (gimbalPole != 0) {
            return gimbalPole * 2.0f * com.badlogic.gdx.math.MathUtils.atan2(this.y, this.w);
        }
        float f = this.w;
        float f2 = this.z;
        float f3 = this.y;
        float f4 = this.x;
        return com.badlogic.gdx.math.MathUtils.atan2(((f * f2) + (f3 * f4)) * 2.0f, 1.0f - (((f4 * f4) + (f2 * f2)) * 2.0f));
    }

    public void getSwingTwist(float f, float f2, float f3, com.badlogic.gdx.math.Quaternion quaternion, com.badlogic.gdx.math.Quaternion quaternion2) {
        float dot = com.badlogic.gdx.math.Vector3.dot(this.x, this.y, this.z, f, f2, f3);
        quaternion2.set(f * dot, f2 * dot, f3 * dot, this.w).nor();
        if (dot < 0.0f) {
            quaternion2.mul(-1.0f);
        }
        quaternion.set(quaternion2).conjugate().mulLeft(this);
    }

    public void getSwingTwist(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Quaternion quaternion, com.badlogic.gdx.math.Quaternion quaternion2) {
        getSwingTwist(vector3.x, vector3.y, vector3.z, quaternion, quaternion2);
    }

    public float getYaw() {
        return getYawRad() * 57.295776f;
    }

    public float getYawRad() {
        if (getGimbalPole() != 0) {
            return 0.0f;
        }
        float f = this.y;
        float f2 = this.w * f;
        float f3 = this.x;
        return com.badlogic.gdx.math.MathUtils.atan2((f2 + (this.z * f3)) * 2.0f, 1.0f - (((f * f) + (f3 * f3)) * 2.0f));
    }

    public int hashCode() {
        return ((((((com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.w) + 31) * 31) + com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.x)) * 31) + com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.y)) * 31) + com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.z);
    }

    public com.badlogic.gdx.math.Quaternion idt() {
        return set(0.0f, 0.0f, 0.0f, 1.0f);
    }

    public boolean isIdentity() {
        return com.badlogic.gdx.math.MathUtils.isZero(this.x) && com.badlogic.gdx.math.MathUtils.isZero(this.y) && com.badlogic.gdx.math.MathUtils.isZero(this.z) && com.badlogic.gdx.math.MathUtils.isEqual(this.w, 1.0f);
    }

    public boolean isIdentity(float f) {
        return com.badlogic.gdx.math.MathUtils.isZero(this.x, f) && com.badlogic.gdx.math.MathUtils.isZero(this.y, f) && com.badlogic.gdx.math.MathUtils.isZero(this.z, f) && com.badlogic.gdx.math.MathUtils.isEqual(this.w, 1.0f, f);
    }

    public float len() {
        float f = this.x;
        float f2 = this.y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.z;
        float f5 = f3 + (f4 * f4);
        float f6 = this.w;
        return (float) java.lang.Math.sqrt(f5 + (f6 * f6));
    }

    public float len2() {
        float f = this.x;
        float f2 = this.y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.z;
        float f5 = f3 + (f4 * f4);
        float f6 = this.w;
        return f5 + (f6 * f6);
    }

    public com.badlogic.gdx.math.Quaternion mul(float f) {
        this.x *= f;
        this.y *= f;
        this.z *= f;
        this.w *= f;
        return this;
    }

    public com.badlogic.gdx.math.Quaternion mul(float f, float f2, float f3, float f4) {
        float f5 = this.w;
        float f6 = this.x;
        float f7 = this.y;
        float f8 = this.z;
        this.x = (((f5 * f) + (f6 * f4)) + (f7 * f3)) - (f8 * f2);
        this.y = (((f5 * f2) + (f7 * f4)) + (f8 * f)) - (f6 * f3);
        this.z = (((f5 * f3) + (f8 * f4)) + (f6 * f2)) - (f7 * f);
        this.w = (((f5 * f4) - (f6 * f)) - (f7 * f2)) - (f8 * f3);
        return this;
    }

    public com.badlogic.gdx.math.Quaternion mul(com.badlogic.gdx.math.Quaternion quaternion) {
        float f = this.w;
        float f2 = quaternion.x;
        float f3 = this.x;
        float f4 = quaternion.w;
        float f5 = this.y;
        float f6 = quaternion.z;
        float f7 = this.z;
        float f8 = quaternion.y;
        this.x = (((f * f2) + (f3 * f4)) + (f5 * f6)) - (f7 * f8);
        this.y = (((f * f8) + (f5 * f4)) + (f7 * f2)) - (f3 * f6);
        this.z = (((f * f6) + (f7 * f4)) + (f3 * f8)) - (f5 * f2);
        this.w = (((f * f4) - (f3 * f2)) - (f5 * f8)) - (f7 * f6);
        return this;
    }

    public com.badlogic.gdx.math.Quaternion mulLeft(float f, float f2, float f3, float f4) {
        float f5 = this.x;
        float f6 = this.w;
        float f7 = this.z;
        float f8 = this.y;
        this.x = (((f4 * f5) + (f * f6)) + (f2 * f7)) - (f3 * f8);
        this.y = (((f4 * f8) + (f2 * f6)) + (f3 * f5)) - (f * f7);
        this.z = (((f4 * f7) + (f3 * f6)) + (f * f8)) - (f2 * f5);
        this.w = (((f4 * f6) - (f * f5)) - (f2 * f8)) - (f3 * f7);
        return this;
    }

    public com.badlogic.gdx.math.Quaternion mulLeft(com.badlogic.gdx.math.Quaternion quaternion) {
        float f = quaternion.w;
        float f2 = this.x;
        float f3 = quaternion.x;
        float f4 = this.w;
        float f5 = quaternion.y;
        float f6 = this.z;
        float f7 = quaternion.z;
        float f8 = this.y;
        this.x = (((f * f2) + (f3 * f4)) + (f5 * f6)) - (f7 * f8);
        this.y = (((f * f8) + (f5 * f4)) + (f7 * f2)) - (f3 * f6);
        this.z = (((f * f6) + (f7 * f4)) + (f3 * f8)) - (f5 * f2);
        this.w = (((f * f4) - (f3 * f2)) - (f5 * f8)) - (f7 * f6);
        return this;
    }

    public com.badlogic.gdx.math.Quaternion nor() {
        float len2 = len2();
        if (len2 != 0.0f && !com.badlogic.gdx.math.MathUtils.isEqual(len2, 1.0f)) {
            float sqrt = (float) java.lang.Math.sqrt(len2);
            this.w /= sqrt;
            this.x /= sqrt;
            this.y /= sqrt;
            this.z /= sqrt;
        }
        return this;
    }

    public com.badlogic.gdx.math.Quaternion set(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.w = f4;
        return this;
    }

    public com.badlogic.gdx.math.Quaternion set(com.badlogic.gdx.math.Quaternion quaternion) {
        return set(quaternion.x, quaternion.y, quaternion.z, quaternion.w);
    }

    public com.badlogic.gdx.math.Quaternion set(com.badlogic.gdx.math.Vector3 vector3, float f) {
        return setFromAxis(vector3.x, vector3.y, vector3.z, f);
    }

    public com.badlogic.gdx.math.Quaternion setEulerAngles(float f, float f2, float f3) {
        return setEulerAnglesRad(f * 0.017453292f, f2 * 0.017453292f, f3 * 0.017453292f);
    }

    public com.badlogic.gdx.math.Quaternion setEulerAnglesRad(float f, float f2, float f3) {
        double d = f3 * 0.5f;
        float sin = (float) java.lang.Math.sin(d);
        float cos = (float) java.lang.Math.cos(d);
        double d2 = f2 * 0.5f;
        float sin2 = (float) java.lang.Math.sin(d2);
        float cos2 = (float) java.lang.Math.cos(d2);
        double d3 = f * 0.5f;
        float sin3 = (float) java.lang.Math.sin(d3);
        float cos3 = (float) java.lang.Math.cos(d3);
        float f4 = cos3 * sin2;
        float f5 = sin3 * cos2;
        float f6 = cos3 * cos2;
        float f7 = sin3 * sin2;
        this.x = (f4 * cos) + (f5 * sin);
        this.y = (f5 * cos) - (f4 * sin);
        this.z = (f6 * sin) - (f7 * cos);
        this.w = (f6 * cos) + (f7 * sin);
        return this;
    }

    public com.badlogic.gdx.math.Quaternion setFromAxes(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return setFromAxes(false, f, f2, f3, f4, f5, f6, f7, f8, f9);
    }

    public com.badlogic.gdx.math.Quaternion setFromAxes(boolean z, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (z) {
            float len = 1.0f / com.badlogic.gdx.math.Vector3.len(f, f2, f3);
            float len2 = 1.0f / com.badlogic.gdx.math.Vector3.len(f4, f5, f6);
            float len3 = 1.0f / com.badlogic.gdx.math.Vector3.len(f7, f8, f9);
            f *= len;
            f2 *= len;
            f3 *= len;
            f4 *= len2;
            f5 *= len2;
            f6 *= len2;
            f7 *= len3;
            f8 *= len3;
            f9 *= len3;
        }
        if (f + f5 + f9 >= 0.0f) {
            float sqrt = (float) java.lang.Math.sqrt(r6 + 1.0f);
            this.w = sqrt * 0.5f;
            float f10 = 0.5f / sqrt;
            this.x = (f8 - f6) * f10;
            this.y = (f3 - f7) * f10;
            this.z = (f4 - f2) * f10;
        } else if (f > f5 && f > f9) {
            float sqrt2 = (float) java.lang.Math.sqrt(((f + 1.0d) - f5) - f9);
            this.x = sqrt2 * 0.5f;
            float f11 = 0.5f / sqrt2;
            this.y = (f4 + f2) * f11;
            this.z = (f3 + f7) * f11;
            this.w = (f8 - f6) * f11;
        } else if (f5 > f9) {
            float sqrt3 = (float) java.lang.Math.sqrt(((f5 + 1.0d) - f) - f9);
            this.y = sqrt3 * 0.5f;
            float f12 = 0.5f / sqrt3;
            this.x = (f4 + f2) * f12;
            this.z = (f8 + f6) * f12;
            this.w = (f3 - f7) * f12;
        } else {
            float sqrt4 = (float) java.lang.Math.sqrt(((f9 + 1.0d) - f) - f5);
            this.z = sqrt4 * 0.5f;
            float f13 = 0.5f / sqrt4;
            this.x = (f3 + f7) * f13;
            this.y = (f8 + f6) * f13;
            this.w = (f4 - f2) * f13;
        }
        return this;
    }

    public com.badlogic.gdx.math.Quaternion setFromAxis(float f, float f2, float f3, float f4) {
        return setFromAxisRad(f, f2, f3, f4 * 0.017453292f);
    }

    public com.badlogic.gdx.math.Quaternion setFromAxis(com.badlogic.gdx.math.Vector3 vector3, float f) {
        return setFromAxis(vector3.x, vector3.y, vector3.z, f);
    }

    public com.badlogic.gdx.math.Quaternion setFromAxisRad(float f, float f2, float f3, float f4) {
        float len = com.badlogic.gdx.math.Vector3.len(f, f2, f3);
        if (len == 0.0f) {
            return idt();
        }
        float f5 = 1.0f / len;
        double d = (f4 < 0.0f ? 6.2831855f - ((-f4) % 6.2831855f) : f4 % 6.2831855f) / 2.0f;
        float sin = (float) java.lang.Math.sin(d);
        return set(f * f5 * sin, f2 * f5 * sin, f5 * f3 * sin, (float) java.lang.Math.cos(d)).nor();
    }

    public com.badlogic.gdx.math.Quaternion setFromAxisRad(com.badlogic.gdx.math.Vector3 vector3, float f) {
        return setFromAxisRad(vector3.x, vector3.y, vector3.z, f);
    }

    public com.badlogic.gdx.math.Quaternion setFromCross(float f, float f2, float f3, float f4, float f5, float f6) {
        return setFromAxisRad((f2 * f6) - (f3 * f5), (f3 * f4) - (f6 * f), (f * f5) - (f2 * f4), (float) java.lang.Math.acos(com.badlogic.gdx.math.MathUtils.clamp(com.badlogic.gdx.math.Vector3.dot(f, f2, f3, f4, f5, f6), -1.0f, 1.0f)));
    }

    public com.badlogic.gdx.math.Quaternion setFromCross(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32) {
        float acos = (float) java.lang.Math.acos(com.badlogic.gdx.math.MathUtils.clamp(vector3.dot(vector32), -1.0f, 1.0f));
        float f = vector3.y;
        float f2 = vector32.z;
        float f3 = vector3.z;
        float f4 = vector32.y;
        float f5 = vector32.x;
        float f6 = vector3.x;
        return setFromAxisRad((f * f2) - (f3 * f4), (f3 * f5) - (f2 * f6), (f6 * f4) - (f * f5), acos);
    }

    public com.badlogic.gdx.math.Quaternion setFromMatrix(com.badlogic.gdx.math.Matrix3 matrix3) {
        return setFromMatrix(false, matrix3);
    }

    public com.badlogic.gdx.math.Quaternion setFromMatrix(com.badlogic.gdx.math.Matrix4 matrix4) {
        return setFromMatrix(false, matrix4);
    }

    public com.badlogic.gdx.math.Quaternion setFromMatrix(boolean z, com.badlogic.gdx.math.Matrix3 matrix3) {
        float[] fArr = matrix3.val;
        return setFromAxes(z, fArr[0], fArr[3], fArr[6], fArr[1], fArr[4], fArr[7], fArr[2], fArr[5], fArr[8]);
    }

    public com.badlogic.gdx.math.Quaternion setFromMatrix(boolean z, com.badlogic.gdx.math.Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        return setFromAxes(z, fArr[0], fArr[4], fArr[8], fArr[1], fArr[5], fArr[9], fArr[2], fArr[6], fArr[10]);
    }

    public com.badlogic.gdx.math.Quaternion slerp(com.badlogic.gdx.math.Quaternion quaternion, float f) {
        float f2 = (this.x * quaternion.x) + (this.y * quaternion.y) + (this.z * quaternion.z) + (this.w * quaternion.w);
        if (f2 < 0.0f) {
            f2 = -f2;
        }
        float f3 = 1.0f - f;
        if (1.0f - f2 > 0.1d) {
            float sin = 1.0f / ((float) java.lang.Math.sin((float) java.lang.Math.acos(f2)));
            f3 = ((float) java.lang.Math.sin(f3 * r0)) * sin;
            f = ((float) java.lang.Math.sin(f * r0)) * sin;
        }
        if (f2 < 0.0f) {
            f = -f;
        }
        this.x = (this.x * f3) + (quaternion.x * f);
        this.y = (this.y * f3) + (quaternion.y * f);
        this.z = (this.z * f3) + (quaternion.z * f);
        this.w = (f3 * this.w) + (f * quaternion.w);
        return this;
    }

    public com.badlogic.gdx.math.Quaternion slerp(com.badlogic.gdx.math.Quaternion[] quaternionArr) {
        float length = 1.0f / quaternionArr.length;
        set(quaternionArr[0]).exp(length);
        for (int i = 1; i < quaternionArr.length; i++) {
            mul(tmp1.set(quaternionArr[i]).exp(length));
        }
        nor();
        return this;
    }

    public com.badlogic.gdx.math.Quaternion slerp(com.badlogic.gdx.math.Quaternion[] quaternionArr, float[] fArr) {
        set(quaternionArr[0]).exp(fArr[0]);
        for (int i = 1; i < quaternionArr.length; i++) {
            mul(tmp1.set(quaternionArr[i]).exp(fArr[i]));
        }
        nor();
        return this;
    }

    public void toMatrix(float[] fArr) {
        float f = this.x;
        float f2 = f * f;
        float f3 = this.y;
        float f4 = f * f3;
        float f5 = this.z;
        float f6 = f * f5;
        float f7 = this.w;
        float f8 = f * f7;
        float f9 = f3 * f3;
        float f10 = f3 * f5;
        float f11 = f3 * f7;
        float f12 = f5 * f5;
        float f13 = f5 * f7;
        fArr[0] = 1.0f - ((f9 + f12) * 2.0f);
        fArr[4] = (f4 - f13) * 2.0f;
        fArr[8] = (f6 + f11) * 2.0f;
        fArr[12] = 0.0f;
        fArr[1] = (f4 + f13) * 2.0f;
        fArr[5] = 1.0f - ((f12 + f2) * 2.0f);
        fArr[9] = (f10 - f8) * 2.0f;
        fArr[13] = 0.0f;
        fArr[2] = (f6 - f11) * 2.0f;
        fArr[6] = (f10 + f8) * 2.0f;
        fArr[10] = 1.0f - ((f2 + f9) * 2.0f);
        fArr[14] = 0.0f;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
    }

    public java.lang.String toString() {
        return "[" + this.x + "|" + this.y + "|" + this.z + "|" + this.w + "]";
    }

    public com.badlogic.gdx.math.Vector3 transform(com.badlogic.gdx.math.Vector3 vector3) {
        tmp2.set(this);
        tmp2.conjugate();
        tmp2.mulLeft(tmp1.set(vector3.x, vector3.y, vector3.z, 0.0f)).mulLeft(this);
        com.badlogic.gdx.math.Quaternion quaternion = tmp2;
        vector3.x = quaternion.x;
        vector3.y = quaternion.y;
        vector3.z = quaternion.z;
        return vector3;
    }
}
