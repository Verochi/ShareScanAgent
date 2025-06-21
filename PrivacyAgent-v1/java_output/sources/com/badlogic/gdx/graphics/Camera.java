package com.badlogic.gdx.graphics;

/* loaded from: classes12.dex */
public abstract class Camera {
    public final com.badlogic.gdx.math.Vector3 position = new com.badlogic.gdx.math.Vector3();
    public final com.badlogic.gdx.math.Vector3 direction = new com.badlogic.gdx.math.Vector3(0.0f, 0.0f, -1.0f);
    public final com.badlogic.gdx.math.Vector3 up = new com.badlogic.gdx.math.Vector3(0.0f, 1.0f, 0.0f);
    public final com.badlogic.gdx.math.Matrix4 projection = new com.badlogic.gdx.math.Matrix4();
    public final com.badlogic.gdx.math.Matrix4 view = new com.badlogic.gdx.math.Matrix4();
    public final com.badlogic.gdx.math.Matrix4 combined = new com.badlogic.gdx.math.Matrix4();
    public final com.badlogic.gdx.math.Matrix4 invProjectionView = new com.badlogic.gdx.math.Matrix4();
    public float near = 1.0f;
    public float far = 100.0f;
    public float viewportWidth = 0.0f;
    public float viewportHeight = 0.0f;
    public final com.badlogic.gdx.math.Frustum frustum = new com.badlogic.gdx.math.Frustum();
    public final com.badlogic.gdx.math.Vector3 a = new com.badlogic.gdx.math.Vector3();
    public final com.badlogic.gdx.math.collision.Ray b = new com.badlogic.gdx.math.collision.Ray(new com.badlogic.gdx.math.Vector3(), new com.badlogic.gdx.math.Vector3());

    public com.badlogic.gdx.math.collision.Ray getPickRay(float f, float f2) {
        return getPickRay(f, f2, 0.0f, 0.0f, com.badlogic.gdx.Gdx.graphics.getWidth(), com.badlogic.gdx.Gdx.graphics.getHeight());
    }

    public com.badlogic.gdx.math.collision.Ray getPickRay(float f, float f2, float f3, float f4, float f5, float f6) {
        unproject(this.b.origin.set(f, f2, 0.0f), f3, f4, f5, f6);
        unproject(this.b.direction.set(f, f2, 1.0f), f3, f4, f5, f6);
        com.badlogic.gdx.math.collision.Ray ray = this.b;
        ray.direction.sub(ray.origin).nor();
        return this.b;
    }

    public void lookAt(float f, float f2, float f3) {
        this.a.set(f, f2, f3).sub(this.position).nor();
        if (this.a.isZero()) {
            return;
        }
        float dot = this.a.dot(this.up);
        if (java.lang.Math.abs(dot - 1.0f) < 1.0E-9f) {
            this.up.set(this.direction).scl(-1.0f);
        } else if (java.lang.Math.abs(dot + 1.0f) < 1.0E-9f) {
            this.up.set(this.direction);
        }
        this.direction.set(this.a);
        normalizeUp();
    }

    public void lookAt(com.badlogic.gdx.math.Vector3 vector3) {
        lookAt(vector3.x, vector3.y, vector3.z);
    }

    public void normalizeUp() {
        this.a.set(this.direction).crs(this.up).nor();
        this.up.set(this.a).crs(this.direction).nor();
    }

    public com.badlogic.gdx.math.Vector3 project(com.badlogic.gdx.math.Vector3 vector3) {
        project(vector3, 0.0f, 0.0f, com.badlogic.gdx.Gdx.graphics.getWidth(), com.badlogic.gdx.Gdx.graphics.getHeight());
        return vector3;
    }

    public com.badlogic.gdx.math.Vector3 project(com.badlogic.gdx.math.Vector3 vector3, float f, float f2, float f3, float f4) {
        vector3.prj(this.combined);
        vector3.x = ((f3 * (vector3.x + 1.0f)) / 2.0f) + f;
        vector3.y = ((f4 * (vector3.y + 1.0f)) / 2.0f) + f2;
        vector3.z = (vector3.z + 1.0f) / 2.0f;
        return vector3;
    }

    public void rotate(float f, float f2, float f3, float f4) {
        this.direction.rotate(f, f2, f3, f4);
        this.up.rotate(f, f2, f3, f4);
    }

    public void rotate(com.badlogic.gdx.math.Matrix4 matrix4) {
        this.direction.rot(matrix4);
        this.up.rot(matrix4);
    }

    public void rotate(com.badlogic.gdx.math.Quaternion quaternion) {
        quaternion.transform(this.direction);
        quaternion.transform(this.up);
    }

    public void rotate(com.badlogic.gdx.math.Vector3 vector3, float f) {
        this.direction.rotate(vector3, f);
        this.up.rotate(vector3, f);
    }

    public void rotateAround(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32, float f) {
        this.a.set(vector3);
        this.a.sub(this.position);
        translate(this.a);
        rotate(vector32, f);
        this.a.rotate(vector32, f);
        com.badlogic.gdx.math.Vector3 vector33 = this.a;
        translate(-vector33.x, -vector33.y, -vector33.z);
    }

    public void transform(com.badlogic.gdx.math.Matrix4 matrix4) {
        this.position.mul(matrix4);
        rotate(matrix4);
    }

    public void translate(float f, float f2, float f3) {
        this.position.add(f, f2, f3);
    }

    public void translate(com.badlogic.gdx.math.Vector3 vector3) {
        this.position.add(vector3);
    }

    public com.badlogic.gdx.math.Vector3 unproject(com.badlogic.gdx.math.Vector3 vector3) {
        unproject(vector3, 0.0f, 0.0f, com.badlogic.gdx.Gdx.graphics.getWidth(), com.badlogic.gdx.Gdx.graphics.getHeight());
        return vector3;
    }

    public com.badlogic.gdx.math.Vector3 unproject(com.badlogic.gdx.math.Vector3 vector3, float f, float f2, float f3, float f4) {
        float f5 = vector3.x - f;
        float height = ((com.badlogic.gdx.Gdx.graphics.getHeight() - vector3.y) - 1.0f) - f2;
        vector3.x = ((f5 * 2.0f) / f3) - 1.0f;
        vector3.y = ((height * 2.0f) / f4) - 1.0f;
        vector3.z = (vector3.z * 2.0f) - 1.0f;
        vector3.prj(this.invProjectionView);
        return vector3;
    }

    public abstract void update();

    public abstract void update(boolean z);
}
