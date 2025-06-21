package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public class Plane implements java.io.Serializable {
    private static final long serialVersionUID = -1240652082930747866L;
    public float d;
    public final com.badlogic.gdx.math.Vector3 normal;

    public enum PlaneSide {
        OnPlane,
        Back,
        Front
    }

    public Plane() {
        this.normal = new com.badlogic.gdx.math.Vector3();
        this.d = 0.0f;
    }

    public Plane(com.badlogic.gdx.math.Vector3 vector3, float f) {
        com.badlogic.gdx.math.Vector3 vector32 = new com.badlogic.gdx.math.Vector3();
        this.normal = vector32;
        this.d = 0.0f;
        vector32.set(vector3).nor();
        this.d = f;
    }

    public Plane(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32) {
        com.badlogic.gdx.math.Vector3 vector33 = new com.badlogic.gdx.math.Vector3();
        this.normal = vector33;
        this.d = 0.0f;
        vector33.set(vector3).nor();
        this.d = -vector33.dot(vector32);
    }

    public Plane(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32, com.badlogic.gdx.math.Vector3 vector33) {
        this.normal = new com.badlogic.gdx.math.Vector3();
        this.d = 0.0f;
        set(vector3, vector32, vector33);
    }

    public float distance(com.badlogic.gdx.math.Vector3 vector3) {
        return this.normal.dot(vector3) + this.d;
    }

    public float getD() {
        return this.d;
    }

    public com.badlogic.gdx.math.Vector3 getNormal() {
        return this.normal;
    }

    public boolean isFrontFacing(com.badlogic.gdx.math.Vector3 vector3) {
        return this.normal.dot(vector3) <= 0.0f;
    }

    public void set(float f, float f2, float f3, float f4) {
        this.normal.set(f, f2, f3);
        this.d = f4;
    }

    public void set(float f, float f2, float f3, float f4, float f5, float f6) {
        this.normal.set(f4, f5, f6);
        this.d = -((f * f4) + (f2 * f5) + (f3 * f6));
    }

    public void set(com.badlogic.gdx.math.Plane plane) {
        this.normal.set(plane.normal);
        this.d = plane.d;
    }

    public void set(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32) {
        this.normal.set(vector32);
        this.d = -vector3.dot(vector32);
    }

    public void set(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32, com.badlogic.gdx.math.Vector3 vector33) {
        this.normal.set(vector3).sub(vector32).crs(vector32.x - vector33.x, vector32.y - vector33.y, vector32.z - vector33.z).nor();
        this.d = -vector3.dot(this.normal);
    }

    public com.badlogic.gdx.math.Plane.PlaneSide testPoint(float f, float f2, float f3) {
        float dot = this.normal.dot(f, f2, f3) + this.d;
        return dot == 0.0f ? com.badlogic.gdx.math.Plane.PlaneSide.OnPlane : dot < 0.0f ? com.badlogic.gdx.math.Plane.PlaneSide.Back : com.badlogic.gdx.math.Plane.PlaneSide.Front;
    }

    public com.badlogic.gdx.math.Plane.PlaneSide testPoint(com.badlogic.gdx.math.Vector3 vector3) {
        float dot = this.normal.dot(vector3) + this.d;
        return dot == 0.0f ? com.badlogic.gdx.math.Plane.PlaneSide.OnPlane : dot < 0.0f ? com.badlogic.gdx.math.Plane.PlaneSide.Back : com.badlogic.gdx.math.Plane.PlaneSide.Front;
    }

    public java.lang.String toString() {
        return this.normal.toString() + ", " + this.d;
    }
}
