package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public class Vector3 implements java.io.Serializable, com.badlogic.gdx.math.Vector<com.badlogic.gdx.math.Vector3> {
    private static final long serialVersionUID = 3840054589595372522L;
    public float x;
    public float y;
    public float z;
    public static final com.badlogic.gdx.math.Vector3 X = new com.badlogic.gdx.math.Vector3(1.0f, 0.0f, 0.0f);
    public static final com.badlogic.gdx.math.Vector3 Y = new com.badlogic.gdx.math.Vector3(0.0f, 1.0f, 0.0f);
    public static final com.badlogic.gdx.math.Vector3 Z = new com.badlogic.gdx.math.Vector3(0.0f, 0.0f, 1.0f);
    public static final com.badlogic.gdx.math.Vector3 Zero = new com.badlogic.gdx.math.Vector3(0.0f, 0.0f, 0.0f);
    private static final com.badlogic.gdx.math.Matrix4 tmpMat = new com.badlogic.gdx.math.Matrix4();

    public Vector3() {
    }

    public Vector3(float f, float f2, float f3) {
        set(f, f2, f3);
    }

    public Vector3(com.badlogic.gdx.math.Vector2 vector2, float f) {
        set(vector2.x, vector2.y, f);
    }

    public Vector3(com.badlogic.gdx.math.Vector3 vector3) {
        set(vector3);
    }

    public Vector3(float[] fArr) {
        set(fArr[0], fArr[1], fArr[2]);
    }

    public static float dot(float f, float f2, float f3, float f4, float f5, float f6) {
        return (f * f4) + (f2 * f5) + (f3 * f6);
    }

    public static float dst(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f4 - f;
        float f8 = f5 - f2;
        float f9 = f6 - f3;
        return (float) java.lang.Math.sqrt((f7 * f7) + (f8 * f8) + (f9 * f9));
    }

    public static float dst2(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f4 - f;
        float f8 = f5 - f2;
        float f9 = f6 - f3;
        return (f7 * f7) + (f8 * f8) + (f9 * f9);
    }

    public static float len(float f, float f2, float f3) {
        return (float) java.lang.Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
    }

    public static float len2(float f, float f2, float f3) {
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    public com.badlogic.gdx.math.Vector3 add(float f) {
        return set(this.x + f, this.y + f, this.z + f);
    }

    public com.badlogic.gdx.math.Vector3 add(float f, float f2, float f3) {
        return set(this.x + f, this.y + f2, this.z + f3);
    }

    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 add(com.badlogic.gdx.math.Vector3 vector3) {
        return add(vector3.x, vector3.y, vector3.z);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 clamp(float f, float f2) {
        float len2 = len2();
        if (len2 == 0.0f) {
            return this;
        }
        if (len2 > f2 * f2) {
            return scl((float) java.lang.Math.sqrt(r4 / len2));
        }
        return len2 < f * f ? scl((float) java.lang.Math.sqrt(r3 / len2)) : this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 cpy() {
        return new com.badlogic.gdx.math.Vector3(this);
    }

    public com.badlogic.gdx.math.Vector3 crs(float f, float f2, float f3) {
        float f4 = this.y;
        float f5 = this.z;
        float f6 = (f4 * f3) - (f5 * f2);
        float f7 = this.x;
        return set(f6, (f5 * f) - (f3 * f7), (f7 * f2) - (f4 * f));
    }

    public com.badlogic.gdx.math.Vector3 crs(com.badlogic.gdx.math.Vector3 vector3) {
        float f = this.y;
        float f2 = vector3.z;
        float f3 = this.z;
        float f4 = vector3.y;
        float f5 = (f * f2) - (f3 * f4);
        float f6 = vector3.x;
        float f7 = this.x;
        return set(f5, (f3 * f6) - (f2 * f7), (f7 * f4) - (f * f6));
    }

    public float dot(float f, float f2, float f3) {
        return (this.x * f) + (this.y * f2) + (this.z * f3);
    }

    @Override // com.badlogic.gdx.math.Vector
    public float dot(com.badlogic.gdx.math.Vector3 vector3) {
        return (this.x * vector3.x) + (this.y * vector3.y) + (this.z * vector3.z);
    }

    public float dst(float f, float f2, float f3) {
        float f4 = f - this.x;
        float f5 = f2 - this.y;
        float f6 = f3 - this.z;
        return (float) java.lang.Math.sqrt((f4 * f4) + (f5 * f5) + (f6 * f6));
    }

    @Override // com.badlogic.gdx.math.Vector
    public float dst(com.badlogic.gdx.math.Vector3 vector3) {
        float f = vector3.x - this.x;
        float f2 = vector3.y - this.y;
        float f3 = vector3.z - this.z;
        return (float) java.lang.Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
    }

    public float dst2(float f, float f2, float f3) {
        float f4 = f - this.x;
        float f5 = f2 - this.y;
        float f6 = f3 - this.z;
        return (f4 * f4) + (f5 * f5) + (f6 * f6);
    }

    @Override // com.badlogic.gdx.math.Vector
    public float dst2(com.badlogic.gdx.math.Vector3 vector3) {
        float f = vector3.x - this.x;
        float f2 = vector3.y - this.y;
        float f3 = vector3.z - this.z;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    public boolean epsilonEquals(float f, float f2, float f3, float f4) {
        return java.lang.Math.abs(f - this.x) <= f4 && java.lang.Math.abs(f2 - this.y) <= f4 && java.lang.Math.abs(f3 - this.z) <= f4;
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean epsilonEquals(com.badlogic.gdx.math.Vector3 vector3, float f) {
        return vector3 != null && java.lang.Math.abs(vector3.x - this.x) <= f && java.lang.Math.abs(vector3.y - this.y) <= f && java.lang.Math.abs(vector3.z - this.z) <= f;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.badlogic.gdx.math.Vector3 vector3 = (com.badlogic.gdx.math.Vector3) obj;
        return com.badlogic.gdx.utils.NumberUtils.floatToIntBits(this.x) == com.badlogic.gdx.utils.NumberUtils.floatToIntBits(vector3.x) && com.badlogic.gdx.utils.NumberUtils.floatToIntBits(this.y) == com.badlogic.gdx.utils.NumberUtils.floatToIntBits(vector3.y) && com.badlogic.gdx.utils.NumberUtils.floatToIntBits(this.z) == com.badlogic.gdx.utils.NumberUtils.floatToIntBits(vector3.z);
    }

    public com.badlogic.gdx.math.Vector3 fromString(java.lang.String str) {
        int indexOf = str.indexOf(44, 1);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(44, i);
        if (indexOf != -1 && indexOf2 != -1 && str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            try {
                return set(java.lang.Float.parseFloat(str.substring(1, indexOf)), java.lang.Float.parseFloat(str.substring(i, indexOf2)), java.lang.Float.parseFloat(str.substring(indexOf2 + 1, str.length() - 1)));
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Malformed Vector3: " + str);
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean hasOppositeDirection(com.badlogic.gdx.math.Vector3 vector3) {
        return dot(vector3) < 0.0f;
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean hasSameDirection(com.badlogic.gdx.math.Vector3 vector3) {
        return dot(vector3) > 0.0f;
    }

    public int hashCode() {
        return ((((com.badlogic.gdx.utils.NumberUtils.floatToIntBits(this.x) + 31) * 31) + com.badlogic.gdx.utils.NumberUtils.floatToIntBits(this.y)) * 31) + com.badlogic.gdx.utils.NumberUtils.floatToIntBits(this.z);
    }

    public boolean idt(com.badlogic.gdx.math.Vector3 vector3) {
        return this.x == vector3.x && this.y == vector3.y && this.z == vector3.z;
    }

    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 interpolate(com.badlogic.gdx.math.Vector3 vector3, float f, com.badlogic.gdx.math.Interpolation interpolation) {
        return lerp(vector3, interpolation.apply(0.0f, 1.0f, f));
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isCollinear(com.badlogic.gdx.math.Vector3 vector3) {
        return isOnLine(vector3) && hasSameDirection(vector3);
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isCollinear(com.badlogic.gdx.math.Vector3 vector3, float f) {
        return isOnLine(vector3, f) && hasSameDirection(vector3);
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isCollinearOpposite(com.badlogic.gdx.math.Vector3 vector3) {
        return isOnLine(vector3) && hasOppositeDirection(vector3);
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isCollinearOpposite(com.badlogic.gdx.math.Vector3 vector3, float f) {
        return isOnLine(vector3, f) && hasOppositeDirection(vector3);
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isOnLine(com.badlogic.gdx.math.Vector3 vector3) {
        float f = this.y;
        float f2 = vector3.z;
        float f3 = this.z;
        float f4 = vector3.y;
        float f5 = (f * f2) - (f3 * f4);
        float f6 = vector3.x;
        float f7 = this.x;
        return len2(f5, (f3 * f6) - (f2 * f7), (f7 * f4) - (f * f6)) <= 1.0E-6f;
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isOnLine(com.badlogic.gdx.math.Vector3 vector3, float f) {
        float f2 = this.y;
        float f3 = vector3.z;
        float f4 = this.z;
        float f5 = vector3.y;
        float f6 = (f2 * f3) - (f4 * f5);
        float f7 = vector3.x;
        float f8 = this.x;
        return len2(f6, (f4 * f7) - (f3 * f8), (f8 * f5) - (f2 * f7)) <= f;
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isPerpendicular(com.badlogic.gdx.math.Vector3 vector3) {
        return com.badlogic.gdx.math.MathUtils.isZero(dot(vector3));
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isPerpendicular(com.badlogic.gdx.math.Vector3 vector3, float f) {
        return com.badlogic.gdx.math.MathUtils.isZero(dot(vector3), f);
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isUnit() {
        return isUnit(1.0E-9f);
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isUnit(float f) {
        return java.lang.Math.abs(len2() - 1.0f) < f;
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isZero() {
        return this.x == 0.0f && this.y == 0.0f && this.z == 0.0f;
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isZero(float f) {
        return len2() < f;
    }

    @Override // com.badlogic.gdx.math.Vector
    public float len() {
        float f = this.x;
        float f2 = this.y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.z;
        return (float) java.lang.Math.sqrt(f3 + (f4 * f4));
    }

    @Override // com.badlogic.gdx.math.Vector
    public float len2() {
        float f = this.x;
        float f2 = this.y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.z;
        return f3 + (f4 * f4);
    }

    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 lerp(com.badlogic.gdx.math.Vector3 vector3, float f) {
        float f2 = this.x;
        this.x = f2 + ((vector3.x - f2) * f);
        float f3 = this.y;
        this.y = f3 + ((vector3.y - f3) * f);
        float f4 = this.z;
        this.z = f4 + (f * (vector3.z - f4));
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 limit(float f) {
        return limit2(f * f);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 limit2(float f) {
        if (len2() > f) {
            scl((float) java.lang.Math.sqrt(f / r0));
        }
        return this;
    }

    public com.badlogic.gdx.math.Vector3 mul(com.badlogic.gdx.math.Matrix3 matrix3) {
        float[] fArr = matrix3.val;
        float f = this.x;
        float f2 = fArr[0] * f;
        float f3 = this.y;
        float f4 = f2 + (fArr[3] * f3);
        float f5 = this.z;
        return set(f4 + (fArr[6] * f5), (fArr[1] * f) + (fArr[4] * f3) + (fArr[7] * f5), (f * fArr[2]) + (f3 * fArr[5]) + (f5 * fArr[8]));
    }

    public com.badlogic.gdx.math.Vector3 mul(com.badlogic.gdx.math.Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        float f = this.x;
        float f2 = fArr[0] * f;
        float f3 = this.y;
        float f4 = f2 + (fArr[4] * f3);
        float f5 = this.z;
        return set(f4 + (fArr[8] * f5) + fArr[12], (fArr[1] * f) + (fArr[5] * f3) + (fArr[9] * f5) + fArr[13], (f * fArr[2]) + (f3 * fArr[6]) + (f5 * fArr[10]) + fArr[14]);
    }

    public com.badlogic.gdx.math.Vector3 mul(com.badlogic.gdx.math.Quaternion quaternion) {
        return quaternion.transform(this);
    }

    public com.badlogic.gdx.math.Vector3 mul4x3(float[] fArr) {
        float f = this.x;
        float f2 = fArr[0] * f;
        float f3 = this.y;
        float f4 = f2 + (fArr[3] * f3);
        float f5 = this.z;
        return set(f4 + (fArr[6] * f5) + fArr[9], (fArr[1] * f) + (fArr[4] * f3) + (fArr[7] * f5) + fArr[10], (f * fArr[2]) + (f3 * fArr[5]) + (f5 * fArr[8]) + fArr[11]);
    }

    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 mulAdd(com.badlogic.gdx.math.Vector3 vector3, float f) {
        this.x += vector3.x * f;
        this.y += vector3.y * f;
        this.z += vector3.z * f;
        return this;
    }

    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 mulAdd(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32) {
        this.x += vector3.x * vector32.x;
        this.y += vector3.y * vector32.y;
        this.z += vector3.z * vector32.z;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 nor() {
        float len2 = len2();
        return (len2 == 0.0f || len2 == 1.0f) ? this : scl(1.0f / ((float) java.lang.Math.sqrt(len2)));
    }

    public com.badlogic.gdx.math.Vector3 prj(com.badlogic.gdx.math.Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        float f = this.x;
        float f2 = fArr[3] * f;
        float f3 = this.y;
        float f4 = f2 + (fArr[7] * f3);
        float f5 = this.z;
        float f6 = 1.0f / ((f4 + (fArr[11] * f5)) + fArr[15]);
        return set(((fArr[0] * f) + (fArr[4] * f3) + (fArr[8] * f5) + fArr[12]) * f6, ((fArr[1] * f) + (fArr[5] * f3) + (fArr[9] * f5) + fArr[13]) * f6, ((f * fArr[2]) + (f3 * fArr[6]) + (f5 * fArr[10]) + fArr[14]) * f6);
    }

    public com.badlogic.gdx.math.Vector3 rot(com.badlogic.gdx.math.Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        float f = this.x;
        float f2 = fArr[0] * f;
        float f3 = this.y;
        float f4 = f2 + (fArr[4] * f3);
        float f5 = this.z;
        return set(f4 + (fArr[8] * f5), (fArr[1] * f) + (fArr[5] * f3) + (fArr[9] * f5), (f * fArr[2]) + (f3 * fArr[6]) + (f5 * fArr[10]));
    }

    public com.badlogic.gdx.math.Vector3 rotate(float f, float f2, float f3, float f4) {
        return mul(tmpMat.setToRotation(f2, f3, f4, f));
    }

    public com.badlogic.gdx.math.Vector3 rotate(com.badlogic.gdx.math.Vector3 vector3, float f) {
        com.badlogic.gdx.math.Matrix4 matrix4 = tmpMat;
        matrix4.setToRotation(vector3, f);
        return mul(matrix4);
    }

    public com.badlogic.gdx.math.Vector3 rotateRad(float f, float f2, float f3, float f4) {
        return mul(tmpMat.setToRotationRad(f2, f3, f4, f));
    }

    public com.badlogic.gdx.math.Vector3 rotateRad(com.badlogic.gdx.math.Vector3 vector3, float f) {
        com.badlogic.gdx.math.Matrix4 matrix4 = tmpMat;
        matrix4.setToRotationRad(vector3, f);
        return mul(matrix4);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 scl(float f) {
        return set(this.x * f, this.y * f, this.z * f);
    }

    public com.badlogic.gdx.math.Vector3 scl(float f, float f2, float f3) {
        return set(this.x * f, this.y * f2, this.z * f3);
    }

    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 scl(com.badlogic.gdx.math.Vector3 vector3) {
        return set(this.x * vector3.x, this.y * vector3.y, this.z * vector3.z);
    }

    public com.badlogic.gdx.math.Vector3 set(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        return this;
    }

    public com.badlogic.gdx.math.Vector3 set(com.badlogic.gdx.math.Vector2 vector2, float f) {
        return set(vector2.x, vector2.y, f);
    }

    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 set(com.badlogic.gdx.math.Vector3 vector3) {
        return set(vector3.x, vector3.y, vector3.z);
    }

    public com.badlogic.gdx.math.Vector3 set(float[] fArr) {
        return set(fArr[0], fArr[1], fArr[2]);
    }

    public com.badlogic.gdx.math.Vector3 setFromSpherical(float f, float f2) {
        float cos = com.badlogic.gdx.math.MathUtils.cos(f2);
        float sin = com.badlogic.gdx.math.MathUtils.sin(f2);
        return set(com.badlogic.gdx.math.MathUtils.cos(f) * sin, com.badlogic.gdx.math.MathUtils.sin(f) * sin, cos);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 setLength(float f) {
        return setLength2(f * f);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 setLength2(float f) {
        float len2 = len2();
        return (len2 == 0.0f || len2 == f) ? this : scl((float) java.lang.Math.sqrt(f / len2));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 setToRandomDirection() {
        return setFromSpherical(com.badlogic.gdx.math.MathUtils.random() * 6.2831855f, (float) java.lang.Math.acos((com.badlogic.gdx.math.MathUtils.random() * 2.0f) - 1.0f));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 setZero() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        return this;
    }

    public com.badlogic.gdx.math.Vector3 slerp(com.badlogic.gdx.math.Vector3 vector3, float f) {
        float dot = dot(vector3);
        double d = dot;
        if (d > 0.9995d || d < -0.9995d) {
            return lerp(vector3, f);
        }
        double acos = ((float) java.lang.Math.acos(d)) * f;
        float sin = (float) java.lang.Math.sin(acos);
        float f2 = vector3.x - (this.x * dot);
        float f3 = vector3.y - (this.y * dot);
        float f4 = vector3.z - (this.z * dot);
        float f5 = (f2 * f2) + (f3 * f3) + (f4 * f4);
        float sqrt = sin * (f5 >= 1.0E-4f ? 1.0f / ((float) java.lang.Math.sqrt(f5)) : 1.0f);
        return scl((float) java.lang.Math.cos(acos)).add(f2 * sqrt, f3 * sqrt, f4 * sqrt).nor();
    }

    public com.badlogic.gdx.math.Vector3 sub(float f) {
        return set(this.x - f, this.y - f, this.z - f);
    }

    public com.badlogic.gdx.math.Vector3 sub(float f, float f2, float f3) {
        return set(this.x - f, this.y - f2, this.z - f3);
    }

    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector3 sub(com.badlogic.gdx.math.Vector3 vector3) {
        return sub(vector3.x, vector3.y, vector3.z);
    }

    public java.lang.String toString() {
        return "(" + this.x + "," + this.y + "," + this.z + ")";
    }

    public com.badlogic.gdx.math.Vector3 traMul(com.badlogic.gdx.math.Matrix3 matrix3) {
        float[] fArr = matrix3.val;
        float f = this.x;
        float f2 = fArr[0] * f;
        float f3 = this.y;
        float f4 = f2 + (fArr[1] * f3);
        float f5 = this.z;
        return set(f4 + (fArr[2] * f5), (fArr[3] * f) + (fArr[4] * f3) + (fArr[5] * f5), (f * fArr[6]) + (f3 * fArr[7]) + (f5 * fArr[8]));
    }

    public com.badlogic.gdx.math.Vector3 traMul(com.badlogic.gdx.math.Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        float f = this.x;
        float f2 = fArr[0] * f;
        float f3 = this.y;
        float f4 = f2 + (fArr[1] * f3);
        float f5 = this.z;
        return set(f4 + (fArr[2] * f5) + fArr[3], (fArr[4] * f) + (fArr[5] * f3) + (fArr[6] * f5) + fArr[7], (f * fArr[8]) + (f3 * fArr[9]) + (f5 * fArr[10]) + fArr[11]);
    }

    public com.badlogic.gdx.math.Vector3 unrotate(com.badlogic.gdx.math.Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        float f = this.x;
        float f2 = fArr[0] * f;
        float f3 = this.y;
        float f4 = f2 + (fArr[1] * f3);
        float f5 = this.z;
        return set(f4 + (fArr[2] * f5), (fArr[4] * f) + (fArr[5] * f3) + (fArr[6] * f5), (f * fArr[8]) + (f3 * fArr[9]) + (f5 * fArr[10]));
    }

    public com.badlogic.gdx.math.Vector3 untransform(com.badlogic.gdx.math.Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        float f = this.x;
        float f2 = fArr[12];
        float f3 = f - f2;
        this.x = f3;
        float f4 = this.y - f2;
        this.y = f4;
        float f5 = this.z - f2;
        this.z = f5;
        return set((fArr[0] * f3) + (fArr[1] * f4) + (fArr[2] * f5), (fArr[4] * f3) + (fArr[5] * f4) + (fArr[6] * f5), (f3 * fArr[8]) + (f4 * fArr[9]) + (f5 * fArr[10]));
    }
}
