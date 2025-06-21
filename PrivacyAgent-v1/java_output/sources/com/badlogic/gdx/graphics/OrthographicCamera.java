package com.badlogic.gdx.graphics;

/* loaded from: classes12.dex */
public class OrthographicCamera extends com.badlogic.gdx.graphics.Camera {
    public float zoom = 1.0f;
    public final com.badlogic.gdx.math.Vector3 c = new com.badlogic.gdx.math.Vector3();

    public OrthographicCamera() {
        this.near = 0.0f;
    }

    public OrthographicCamera(float f, float f2) {
        this.viewportWidth = f;
        this.viewportHeight = f2;
        this.near = 0.0f;
        update();
    }

    public void rotate(float f) {
        rotate(this.direction, f);
    }

    public void setToOrtho(boolean z) {
        setToOrtho(z, com.badlogic.gdx.Gdx.graphics.getWidth(), com.badlogic.gdx.Gdx.graphics.getHeight());
    }

    public void setToOrtho(boolean z, float f, float f2) {
        if (z) {
            this.up.set(0.0f, -1.0f, 0.0f);
            this.direction.set(0.0f, 0.0f, 1.0f);
        } else {
            this.up.set(0.0f, 1.0f, 0.0f);
            this.direction.set(0.0f, 0.0f, -1.0f);
        }
        com.badlogic.gdx.math.Vector3 vector3 = this.position;
        float f3 = this.zoom;
        vector3.set((f3 * f) / 2.0f, (f3 * f2) / 2.0f, 0.0f);
        this.viewportWidth = f;
        this.viewportHeight = f2;
        update();
    }

    public void translate(float f, float f2) {
        translate(f, f2, 0.0f);
    }

    public void translate(com.badlogic.gdx.math.Vector2 vector2) {
        translate(vector2.x, vector2.y, 0.0f);
    }

    @Override // com.badlogic.gdx.graphics.Camera
    public void update() {
        update(true);
    }

    @Override // com.badlogic.gdx.graphics.Camera
    public void update(boolean z) {
        com.badlogic.gdx.math.Matrix4 matrix4 = this.projection;
        float f = this.zoom;
        float f2 = this.viewportWidth;
        float f3 = this.viewportHeight;
        matrix4.setToOrtho(((-f2) * f) / 2.0f, (f2 / 2.0f) * f, (-(f3 / 2.0f)) * f, (f * f3) / 2.0f, this.near, this.far);
        com.badlogic.gdx.math.Matrix4 matrix42 = this.view;
        com.badlogic.gdx.math.Vector3 vector3 = this.position;
        matrix42.setToLookAt(vector3, this.c.set(vector3).add(this.direction), this.up);
        this.combined.set(this.projection);
        com.badlogic.gdx.math.Matrix4.mul(this.combined.val, this.view.val);
        if (z) {
            this.invProjectionView.set(this.combined);
            com.badlogic.gdx.math.Matrix4.inv(this.invProjectionView.val);
            this.frustum.update(this.invProjectionView);
        }
    }
}
