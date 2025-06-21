package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public class Vector2 implements java.io.Serializable, com.badlogic.gdx.math.Vector<com.badlogic.gdx.math.Vector2> {
    public static final com.badlogic.gdx.math.Vector2 X = new com.badlogic.gdx.math.Vector2(1.0f, 0.0f);
    public static final com.badlogic.gdx.math.Vector2 Y = new com.badlogic.gdx.math.Vector2(0.0f, 1.0f);
    public static final com.badlogic.gdx.math.Vector2 Zero = new com.badlogic.gdx.math.Vector2(0.0f, 0.0f);
    private static final long serialVersionUID = 913902788239530931L;
    public float x;
    public float y;

    public Vector2() {
    }

    public Vector2(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public Vector2(com.badlogic.gdx.math.Vector2 vector2) {
        set(vector2);
    }

    public static float dot(float f, float f2, float f3, float f4) {
        return (f * f3) + (f2 * f4);
    }

    public static float dst(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) java.lang.Math.sqrt((f5 * f5) + (f6 * f6));
    }

    public static float dst2(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (f5 * f5) + (f6 * f6);
    }

    public static float len(float f, float f2) {
        return (float) java.lang.Math.sqrt((f * f) + (f2 * f2));
    }

    public static float len2(float f, float f2) {
        return (f * f) + (f2 * f2);
    }

    public com.badlogic.gdx.math.Vector2 add(float f, float f2) {
        this.x += f;
        this.y += f2;
        return this;
    }

    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 add(com.badlogic.gdx.math.Vector2 vector2) {
        this.x += vector2.x;
        this.y += vector2.y;
        return this;
    }

    public float angle() {
        float atan2 = ((float) java.lang.Math.atan2(this.y, this.x)) * 57.295776f;
        return atan2 < 0.0f ? atan2 + 360.0f : atan2;
    }

    public float angle(com.badlogic.gdx.math.Vector2 vector2) {
        return ((float) java.lang.Math.atan2(crs(vector2), dot(vector2))) * 57.295776f;
    }

    public float angleRad() {
        return (float) java.lang.Math.atan2(this.y, this.x);
    }

    public float angleRad(com.badlogic.gdx.math.Vector2 vector2) {
        return (float) java.lang.Math.atan2(crs(vector2), dot(vector2));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 clamp(float f, float f2) {
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
    public com.badlogic.gdx.math.Vector2 cpy() {
        return new com.badlogic.gdx.math.Vector2(this);
    }

    public float crs(float f, float f2) {
        return (this.x * f2) - (this.y * f);
    }

    public float crs(com.badlogic.gdx.math.Vector2 vector2) {
        return (this.x * vector2.y) - (this.y * vector2.x);
    }

    public float dot(float f, float f2) {
        return (this.x * f) + (this.y * f2);
    }

    @Override // com.badlogic.gdx.math.Vector
    public float dot(com.badlogic.gdx.math.Vector2 vector2) {
        return (this.x * vector2.x) + (this.y * vector2.y);
    }

    public float dst(float f, float f2) {
        float f3 = f - this.x;
        float f4 = f2 - this.y;
        return (float) java.lang.Math.sqrt((f3 * f3) + (f4 * f4));
    }

    @Override // com.badlogic.gdx.math.Vector
    public float dst(com.badlogic.gdx.math.Vector2 vector2) {
        float f = vector2.x - this.x;
        float f2 = vector2.y - this.y;
        return (float) java.lang.Math.sqrt((f * f) + (f2 * f2));
    }

    public float dst2(float f, float f2) {
        float f3 = f - this.x;
        float f4 = f2 - this.y;
        return (f3 * f3) + (f4 * f4);
    }

    @Override // com.badlogic.gdx.math.Vector
    public float dst2(com.badlogic.gdx.math.Vector2 vector2) {
        float f = vector2.x - this.x;
        float f2 = vector2.y - this.y;
        return (f * f) + (f2 * f2);
    }

    public boolean epsilonEquals(float f, float f2, float f3) {
        return java.lang.Math.abs(f - this.x) <= f3 && java.lang.Math.abs(f2 - this.y) <= f3;
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean epsilonEquals(com.badlogic.gdx.math.Vector2 vector2, float f) {
        return vector2 != null && java.lang.Math.abs(vector2.x - this.x) <= f && java.lang.Math.abs(vector2.y - this.y) <= f;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.badlogic.gdx.math.Vector2 vector2 = (com.badlogic.gdx.math.Vector2) obj;
        return com.badlogic.gdx.utils.NumberUtils.floatToIntBits(this.x) == com.badlogic.gdx.utils.NumberUtils.floatToIntBits(vector2.x) && com.badlogic.gdx.utils.NumberUtils.floatToIntBits(this.y) == com.badlogic.gdx.utils.NumberUtils.floatToIntBits(vector2.y);
    }

    public com.badlogic.gdx.math.Vector2 fromString(java.lang.String str) {
        int indexOf = str.indexOf(44, 1);
        if (indexOf != -1 && str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            try {
                return set(java.lang.Float.parseFloat(str.substring(1, indexOf)), java.lang.Float.parseFloat(str.substring(indexOf + 1, str.length() - 1)));
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Malformed Vector2: " + str);
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean hasOppositeDirection(com.badlogic.gdx.math.Vector2 vector2) {
        return dot(vector2) < 0.0f;
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean hasSameDirection(com.badlogic.gdx.math.Vector2 vector2) {
        return dot(vector2) > 0.0f;
    }

    public int hashCode() {
        return ((com.badlogic.gdx.utils.NumberUtils.floatToIntBits(this.x) + 31) * 31) + com.badlogic.gdx.utils.NumberUtils.floatToIntBits(this.y);
    }

    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 interpolate(com.badlogic.gdx.math.Vector2 vector2, float f, com.badlogic.gdx.math.Interpolation interpolation) {
        return lerp(vector2, interpolation.apply(f));
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isCollinear(com.badlogic.gdx.math.Vector2 vector2) {
        return isOnLine(vector2) && dot(vector2) > 0.0f;
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isCollinear(com.badlogic.gdx.math.Vector2 vector2, float f) {
        return isOnLine(vector2, f) && dot(vector2) > 0.0f;
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isCollinearOpposite(com.badlogic.gdx.math.Vector2 vector2) {
        return isOnLine(vector2) && dot(vector2) < 0.0f;
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isCollinearOpposite(com.badlogic.gdx.math.Vector2 vector2, float f) {
        return isOnLine(vector2, f) && dot(vector2) < 0.0f;
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isOnLine(com.badlogic.gdx.math.Vector2 vector2) {
        return com.badlogic.gdx.math.MathUtils.isZero((this.x * vector2.y) - (this.y * vector2.x));
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isOnLine(com.badlogic.gdx.math.Vector2 vector2, float f) {
        return com.badlogic.gdx.math.MathUtils.isZero((this.x * vector2.y) - (this.y * vector2.x), f);
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isPerpendicular(com.badlogic.gdx.math.Vector2 vector2) {
        return com.badlogic.gdx.math.MathUtils.isZero(dot(vector2));
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isPerpendicular(com.badlogic.gdx.math.Vector2 vector2, float f) {
        return com.badlogic.gdx.math.MathUtils.isZero(dot(vector2), f);
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
        return this.x == 0.0f && this.y == 0.0f;
    }

    @Override // com.badlogic.gdx.math.Vector
    public boolean isZero(float f) {
        return len2() < f;
    }

    @Override // com.badlogic.gdx.math.Vector
    public float len() {
        float f = this.x;
        float f2 = this.y;
        return (float) java.lang.Math.sqrt((f * f) + (f2 * f2));
    }

    @Override // com.badlogic.gdx.math.Vector
    public float len2() {
        float f = this.x;
        float f2 = this.y;
        return (f * f) + (f2 * f2);
    }

    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 lerp(com.badlogic.gdx.math.Vector2 vector2, float f) {
        float f2 = 1.0f - f;
        this.x = (this.x * f2) + (vector2.x * f);
        this.y = (this.y * f2) + (vector2.y * f);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 limit(float f) {
        return limit2(f * f);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 limit2(float f) {
        return len2() > f ? scl((float) java.lang.Math.sqrt(f / r0)) : this;
    }

    public com.badlogic.gdx.math.Vector2 mul(com.badlogic.gdx.math.Matrix3 matrix3) {
        float f = this.x;
        float[] fArr = matrix3.val;
        float f2 = fArr[0] * f;
        float f3 = this.y;
        float f4 = f2 + (fArr[3] * f3) + fArr[6];
        float f5 = (f * fArr[1]) + (f3 * fArr[4]) + fArr[7];
        this.x = f4;
        this.y = f5;
        return this;
    }

    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 mulAdd(com.badlogic.gdx.math.Vector2 vector2, float f) {
        this.x += vector2.x * f;
        this.y += vector2.y * f;
        return this;
    }

    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 mulAdd(com.badlogic.gdx.math.Vector2 vector2, com.badlogic.gdx.math.Vector2 vector22) {
        this.x += vector2.x * vector22.x;
        this.y += vector2.y * vector22.y;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 nor() {
        float len = len();
        if (len != 0.0f) {
            this.x /= len;
            this.y /= len;
        }
        return this;
    }

    public com.badlogic.gdx.math.Vector2 rotate(float f) {
        return rotateRad(f * 0.017453292f);
    }

    public com.badlogic.gdx.math.Vector2 rotate90(int i) {
        float f = this.x;
        if (i >= 0) {
            this.x = -this.y;
            this.y = f;
        } else {
            this.x = this.y;
            this.y = -f;
        }
        return this;
    }

    public com.badlogic.gdx.math.Vector2 rotateRad(float f) {
        double d = f;
        float cos = (float) java.lang.Math.cos(d);
        float sin = (float) java.lang.Math.sin(d);
        float f2 = this.x;
        float f3 = this.y;
        this.x = (f2 * cos) - (f3 * sin);
        this.y = (f2 * sin) + (f3 * cos);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 scl(float f) {
        this.x *= f;
        this.y *= f;
        return this;
    }

    public com.badlogic.gdx.math.Vector2 scl(float f, float f2) {
        this.x *= f;
        this.y *= f2;
        return this;
    }

    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 scl(com.badlogic.gdx.math.Vector2 vector2) {
        this.x *= vector2.x;
        this.y *= vector2.y;
        return this;
    }

    public com.badlogic.gdx.math.Vector2 set(float f, float f2) {
        this.x = f;
        this.y = f2;
        return this;
    }

    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 set(com.badlogic.gdx.math.Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
        return this;
    }

    public com.badlogic.gdx.math.Vector2 setAngle(float f) {
        return setAngleRad(f * 0.017453292f);
    }

    public com.badlogic.gdx.math.Vector2 setAngleRad(float f) {
        set(len(), 0.0f);
        rotateRad(f);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 setLength(float f) {
        return setLength2(f * f);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 setLength2(float f) {
        float len2 = len2();
        return (len2 == 0.0f || len2 == f) ? this : scl((float) java.lang.Math.sqrt(f / len2));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 setToRandomDirection() {
        float random = com.badlogic.gdx.math.MathUtils.random(0.0f, 6.2831855f);
        return set(com.badlogic.gdx.math.MathUtils.cos(random), com.badlogic.gdx.math.MathUtils.sin(random));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 setZero() {
        this.x = 0.0f;
        this.y = 0.0f;
        return this;
    }

    public com.badlogic.gdx.math.Vector2 sub(float f, float f2) {
        this.x -= f;
        this.y -= f2;
        return this;
    }

    @Override // com.badlogic.gdx.math.Vector
    public com.badlogic.gdx.math.Vector2 sub(com.badlogic.gdx.math.Vector2 vector2) {
        this.x -= vector2.x;
        this.y -= vector2.y;
        return this;
    }

    public java.lang.String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
