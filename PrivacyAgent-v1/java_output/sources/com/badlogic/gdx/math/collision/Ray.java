package com.badlogic.gdx.math.collision;

/* loaded from: classes12.dex */
public class Ray implements java.io.Serializable {
    private static final long serialVersionUID = -620692054835390878L;
    static com.badlogic.gdx.math.Vector3 tmp = new com.badlogic.gdx.math.Vector3();
    public final com.badlogic.gdx.math.Vector3 direction;
    public final com.badlogic.gdx.math.Vector3 origin;

    public Ray() {
        this.origin = new com.badlogic.gdx.math.Vector3();
        this.direction = new com.badlogic.gdx.math.Vector3();
    }

    public Ray(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32) {
        com.badlogic.gdx.math.Vector3 vector33 = new com.badlogic.gdx.math.Vector3();
        this.origin = vector33;
        com.badlogic.gdx.math.Vector3 vector34 = new com.badlogic.gdx.math.Vector3();
        this.direction = vector34;
        vector33.set(vector3);
        vector34.set(vector32).nor();
    }

    public com.badlogic.gdx.math.collision.Ray cpy() {
        return new com.badlogic.gdx.math.collision.Ray(this.origin, this.direction);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        com.badlogic.gdx.math.collision.Ray ray = (com.badlogic.gdx.math.collision.Ray) obj;
        return this.direction.equals(ray.direction) && this.origin.equals(ray.origin);
    }

    public com.badlogic.gdx.math.Vector3 getEndPoint(com.badlogic.gdx.math.Vector3 vector3, float f) {
        return vector3.set(this.direction).scl(f).add(this.origin);
    }

    public int hashCode() {
        return ((this.direction.hashCode() + 73) * 73) + this.origin.hashCode();
    }

    public com.badlogic.gdx.math.collision.Ray mul(com.badlogic.gdx.math.Matrix4 matrix4) {
        tmp.set(this.origin).add(this.direction);
        tmp.mul(matrix4);
        this.origin.mul(matrix4);
        this.direction.set(tmp.sub(this.origin));
        return this;
    }

    public com.badlogic.gdx.math.collision.Ray set(float f, float f2, float f3, float f4, float f5, float f6) {
        this.origin.set(f, f2, f3);
        this.direction.set(f4, f5, f6);
        return this;
    }

    public com.badlogic.gdx.math.collision.Ray set(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32) {
        this.origin.set(vector3);
        this.direction.set(vector32);
        return this;
    }

    public com.badlogic.gdx.math.collision.Ray set(com.badlogic.gdx.math.collision.Ray ray) {
        this.origin.set(ray.origin);
        this.direction.set(ray.direction);
        return this;
    }

    public java.lang.String toString() {
        return "ray [" + this.origin + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.direction + "]";
    }
}
