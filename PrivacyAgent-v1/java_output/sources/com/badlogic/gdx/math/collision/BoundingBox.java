package com.badlogic.gdx.math.collision;

/* loaded from: classes12.dex */
public class BoundingBox implements java.io.Serializable {
    private static final long serialVersionUID = -1286036817192127343L;
    private static final com.badlogic.gdx.math.Vector3 tmpVector = new com.badlogic.gdx.math.Vector3();
    public final com.badlogic.gdx.math.Vector3 min = new com.badlogic.gdx.math.Vector3();
    public final com.badlogic.gdx.math.Vector3 max = new com.badlogic.gdx.math.Vector3();
    private final com.badlogic.gdx.math.Vector3 cnt = new com.badlogic.gdx.math.Vector3();
    private final com.badlogic.gdx.math.Vector3 dim = new com.badlogic.gdx.math.Vector3();

    public BoundingBox() {
        clr();
    }

    public BoundingBox(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32) {
        set(vector3, vector32);
    }

    public BoundingBox(com.badlogic.gdx.math.collision.BoundingBox boundingBox) {
        set(boundingBox);
    }

    public static final float max(float f, float f2) {
        return f > f2 ? f : f2;
    }

    public static final float min(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public com.badlogic.gdx.math.collision.BoundingBox clr() {
        return set(this.min.set(0.0f, 0.0f, 0.0f), this.max.set(0.0f, 0.0f, 0.0f));
    }

    public boolean contains(com.badlogic.gdx.math.Vector3 vector3) {
        com.badlogic.gdx.math.Vector3 vector32 = this.min;
        float f = vector32.x;
        float f2 = vector3.x;
        if (f <= f2) {
            com.badlogic.gdx.math.Vector3 vector33 = this.max;
            if (vector33.x >= f2) {
                float f3 = vector32.y;
                float f4 = vector3.y;
                if (f3 <= f4 && vector33.y >= f4) {
                    float f5 = vector32.z;
                    float f6 = vector3.z;
                    if (f5 <= f6 && vector33.z >= f6) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean contains(com.badlogic.gdx.math.collision.BoundingBox boundingBox) {
        if (isValid()) {
            com.badlogic.gdx.math.Vector3 vector3 = this.min;
            float f = vector3.x;
            com.badlogic.gdx.math.Vector3 vector32 = boundingBox.min;
            if (f <= vector32.x && vector3.y <= vector32.y && vector3.z <= vector32.z) {
                com.badlogic.gdx.math.Vector3 vector33 = this.max;
                float f2 = vector33.x;
                com.badlogic.gdx.math.Vector3 vector34 = boundingBox.max;
                if (f2 < vector34.x || vector33.y < vector34.y || vector33.z < vector34.z) {
                }
            }
            return false;
        }
        return true;
    }

    public com.badlogic.gdx.math.collision.BoundingBox ext(float f, float f2, float f3) {
        com.badlogic.gdx.math.Vector3 vector3 = this.min;
        com.badlogic.gdx.math.Vector3 vector32 = vector3.set(min(vector3.x, f), min(this.min.y, f2), min(this.min.z, f3));
        com.badlogic.gdx.math.Vector3 vector33 = this.max;
        return set(vector32, vector33.set(max(vector33.x, f), max(this.max.y, f2), max(this.max.z, f3)));
    }

    public com.badlogic.gdx.math.collision.BoundingBox ext(com.badlogic.gdx.math.Vector3 vector3) {
        com.badlogic.gdx.math.Vector3 vector32 = this.min;
        com.badlogic.gdx.math.Vector3 vector33 = vector32.set(min(vector32.x, vector3.x), min(this.min.y, vector3.y), min(this.min.z, vector3.z));
        com.badlogic.gdx.math.Vector3 vector34 = this.max;
        return set(vector33, vector34.set(java.lang.Math.max(vector34.x, vector3.x), java.lang.Math.max(this.max.y, vector3.y), java.lang.Math.max(this.max.z, vector3.z)));
    }

    public com.badlogic.gdx.math.collision.BoundingBox ext(com.badlogic.gdx.math.Vector3 vector3, float f) {
        com.badlogic.gdx.math.Vector3 vector32 = this.min;
        com.badlogic.gdx.math.Vector3 vector33 = vector32.set(min(vector32.x, vector3.x - f), min(this.min.y, vector3.y - f), min(this.min.z, vector3.z - f));
        com.badlogic.gdx.math.Vector3 vector34 = this.max;
        return set(vector33, vector34.set(max(vector34.x, vector3.x + f), max(this.max.y, vector3.y + f), max(this.max.z, vector3.z + f)));
    }

    public com.badlogic.gdx.math.collision.BoundingBox ext(com.badlogic.gdx.math.collision.BoundingBox boundingBox) {
        com.badlogic.gdx.math.Vector3 vector3 = this.min;
        com.badlogic.gdx.math.Vector3 vector32 = vector3.set(min(vector3.x, boundingBox.min.x), min(this.min.y, boundingBox.min.y), min(this.min.z, boundingBox.min.z));
        com.badlogic.gdx.math.Vector3 vector33 = this.max;
        return set(vector32, vector33.set(max(vector33.x, boundingBox.max.x), max(this.max.y, boundingBox.max.y), max(this.max.z, boundingBox.max.z)));
    }

    public com.badlogic.gdx.math.collision.BoundingBox ext(com.badlogic.gdx.math.collision.BoundingBox boundingBox, com.badlogic.gdx.math.Matrix4 matrix4) {
        com.badlogic.gdx.math.Vector3 vector3 = tmpVector;
        com.badlogic.gdx.math.Vector3 vector32 = boundingBox.min;
        ext(vector3.set(vector32.x, vector32.y, vector32.z).mul(matrix4));
        com.badlogic.gdx.math.Vector3 vector33 = boundingBox.min;
        ext(vector3.set(vector33.x, vector33.y, boundingBox.max.z).mul(matrix4));
        com.badlogic.gdx.math.Vector3 vector34 = boundingBox.min;
        ext(vector3.set(vector34.x, boundingBox.max.y, vector34.z).mul(matrix4));
        float f = boundingBox.min.x;
        com.badlogic.gdx.math.Vector3 vector35 = boundingBox.max;
        ext(vector3.set(f, vector35.y, vector35.z).mul(matrix4));
        float f2 = boundingBox.max.x;
        com.badlogic.gdx.math.Vector3 vector36 = boundingBox.min;
        ext(vector3.set(f2, vector36.y, vector36.z).mul(matrix4));
        com.badlogic.gdx.math.Vector3 vector37 = boundingBox.max;
        ext(vector3.set(vector37.x, boundingBox.min.y, vector37.z).mul(matrix4));
        com.badlogic.gdx.math.Vector3 vector38 = boundingBox.max;
        ext(vector3.set(vector38.x, vector38.y, boundingBox.min.z).mul(matrix4));
        com.badlogic.gdx.math.Vector3 vector39 = boundingBox.max;
        ext(vector3.set(vector39.x, vector39.y, vector39.z).mul(matrix4));
        return this;
    }

    public com.badlogic.gdx.math.Vector3 getCenter(com.badlogic.gdx.math.Vector3 vector3) {
        return vector3.set(this.cnt);
    }

    public float getCenterX() {
        return this.cnt.x;
    }

    public float getCenterY() {
        return this.cnt.y;
    }

    public float getCenterZ() {
        return this.cnt.z;
    }

    public com.badlogic.gdx.math.Vector3 getCorner000(com.badlogic.gdx.math.Vector3 vector3) {
        com.badlogic.gdx.math.Vector3 vector32 = this.min;
        return vector3.set(vector32.x, vector32.y, vector32.z);
    }

    public com.badlogic.gdx.math.Vector3 getCorner001(com.badlogic.gdx.math.Vector3 vector3) {
        com.badlogic.gdx.math.Vector3 vector32 = this.min;
        return vector3.set(vector32.x, vector32.y, this.max.z);
    }

    public com.badlogic.gdx.math.Vector3 getCorner010(com.badlogic.gdx.math.Vector3 vector3) {
        com.badlogic.gdx.math.Vector3 vector32 = this.min;
        return vector3.set(vector32.x, this.max.y, vector32.z);
    }

    public com.badlogic.gdx.math.Vector3 getCorner011(com.badlogic.gdx.math.Vector3 vector3) {
        float f = this.min.x;
        com.badlogic.gdx.math.Vector3 vector32 = this.max;
        return vector3.set(f, vector32.y, vector32.z);
    }

    public com.badlogic.gdx.math.Vector3 getCorner100(com.badlogic.gdx.math.Vector3 vector3) {
        float f = this.max.x;
        com.badlogic.gdx.math.Vector3 vector32 = this.min;
        return vector3.set(f, vector32.y, vector32.z);
    }

    public com.badlogic.gdx.math.Vector3 getCorner101(com.badlogic.gdx.math.Vector3 vector3) {
        com.badlogic.gdx.math.Vector3 vector32 = this.max;
        return vector3.set(vector32.x, this.min.y, vector32.z);
    }

    public com.badlogic.gdx.math.Vector3 getCorner110(com.badlogic.gdx.math.Vector3 vector3) {
        com.badlogic.gdx.math.Vector3 vector32 = this.max;
        return vector3.set(vector32.x, vector32.y, this.min.z);
    }

    public com.badlogic.gdx.math.Vector3 getCorner111(com.badlogic.gdx.math.Vector3 vector3) {
        com.badlogic.gdx.math.Vector3 vector32 = this.max;
        return vector3.set(vector32.x, vector32.y, vector32.z);
    }

    public float getDepth() {
        return this.dim.z;
    }

    public com.badlogic.gdx.math.Vector3 getDimensions(com.badlogic.gdx.math.Vector3 vector3) {
        return vector3.set(this.dim);
    }

    public float getHeight() {
        return this.dim.y;
    }

    public com.badlogic.gdx.math.Vector3 getMax(com.badlogic.gdx.math.Vector3 vector3) {
        return vector3.set(this.max);
    }

    public com.badlogic.gdx.math.Vector3 getMin(com.badlogic.gdx.math.Vector3 vector3) {
        return vector3.set(this.min);
    }

    public float getWidth() {
        return this.dim.x;
    }

    public com.badlogic.gdx.math.collision.BoundingBox inf() {
        this.min.set(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
        this.max.set(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        this.cnt.set(0.0f, 0.0f, 0.0f);
        this.dim.set(0.0f, 0.0f, 0.0f);
        return this;
    }

    public boolean intersects(com.badlogic.gdx.math.collision.BoundingBox boundingBox) {
        if (isValid()) {
            return java.lang.Math.abs(this.cnt.x - boundingBox.cnt.x) <= (this.dim.x / 2.0f) + (boundingBox.dim.x / 2.0f) && java.lang.Math.abs(this.cnt.y - boundingBox.cnt.y) <= (this.dim.y / 2.0f) + (boundingBox.dim.y / 2.0f) && java.lang.Math.abs(this.cnt.z - boundingBox.cnt.z) <= (this.dim.z / 2.0f) + (boundingBox.dim.z / 2.0f);
        }
        return false;
    }

    public boolean isValid() {
        com.badlogic.gdx.math.Vector3 vector3 = this.min;
        float f = vector3.x;
        com.badlogic.gdx.math.Vector3 vector32 = this.max;
        return f <= vector32.x && vector3.y <= vector32.y && vector3.z <= vector32.z;
    }

    public com.badlogic.gdx.math.collision.BoundingBox mul(com.badlogic.gdx.math.Matrix4 matrix4) {
        com.badlogic.gdx.math.Vector3 vector3 = this.min;
        float f = vector3.x;
        float f2 = vector3.y;
        float f3 = vector3.z;
        com.badlogic.gdx.math.Vector3 vector32 = this.max;
        float f4 = vector32.x;
        float f5 = vector32.y;
        float f6 = vector32.z;
        inf();
        com.badlogic.gdx.math.Vector3 vector33 = tmpVector;
        ext(vector33.set(f, f2, f3).mul(matrix4));
        ext(vector33.set(f, f2, f6).mul(matrix4));
        ext(vector33.set(f, f5, f3).mul(matrix4));
        ext(vector33.set(f, f5, f6).mul(matrix4));
        ext(vector33.set(f4, f2, f3).mul(matrix4));
        ext(vector33.set(f4, f2, f6).mul(matrix4));
        ext(vector33.set(f4, f5, f3).mul(matrix4));
        ext(vector33.set(f4, f5, f6).mul(matrix4));
        return this;
    }

    public com.badlogic.gdx.math.collision.BoundingBox set(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32) {
        com.badlogic.gdx.math.Vector3 vector33 = this.min;
        float f = vector3.x;
        float f2 = vector32.x;
        if (f >= f2) {
            f = f2;
        }
        float f3 = vector3.y;
        float f4 = vector32.y;
        if (f3 >= f4) {
            f3 = f4;
        }
        float f5 = vector3.z;
        float f6 = vector32.z;
        if (f5 >= f6) {
            f5 = f6;
        }
        vector33.set(f, f3, f5);
        com.badlogic.gdx.math.Vector3 vector34 = this.max;
        float f7 = vector3.x;
        float f8 = vector32.x;
        if (f7 <= f8) {
            f7 = f8;
        }
        float f9 = vector3.y;
        float f10 = vector32.y;
        if (f9 <= f10) {
            f9 = f10;
        }
        float f11 = vector3.z;
        float f12 = vector32.z;
        if (f11 <= f12) {
            f11 = f12;
        }
        vector34.set(f7, f9, f11);
        this.cnt.set(this.min).add(this.max).scl(0.5f);
        this.dim.set(this.max).sub(this.min);
        return this;
    }

    public com.badlogic.gdx.math.collision.BoundingBox set(com.badlogic.gdx.math.collision.BoundingBox boundingBox) {
        return set(boundingBox.min, boundingBox.max);
    }

    public com.badlogic.gdx.math.collision.BoundingBox set(java.util.List<com.badlogic.gdx.math.Vector3> list) {
        inf();
        java.util.Iterator<com.badlogic.gdx.math.Vector3> it = list.iterator();
        while (it.hasNext()) {
            ext(it.next());
        }
        return this;
    }

    public com.badlogic.gdx.math.collision.BoundingBox set(com.badlogic.gdx.math.Vector3[] vector3Arr) {
        inf();
        for (com.badlogic.gdx.math.Vector3 vector3 : vector3Arr) {
            ext(vector3);
        }
        return this;
    }

    public java.lang.String toString() {
        return "[" + this.min + "|" + this.max + "]";
    }
}
