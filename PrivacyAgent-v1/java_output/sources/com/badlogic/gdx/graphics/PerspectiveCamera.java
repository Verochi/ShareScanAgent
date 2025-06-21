package com.badlogic.gdx.graphics;

/* loaded from: classes12.dex */
public class PerspectiveCamera extends com.badlogic.gdx.graphics.Camera {
    public final com.badlogic.gdx.math.Vector3 c;
    public float fieldOfView;

    public PerspectiveCamera() {
        this.fieldOfView = 67.0f;
        this.c = new com.badlogic.gdx.math.Vector3();
    }

    public PerspectiveCamera(float f, float f2, float f3) {
        this.fieldOfView = 67.0f;
        this.c = new com.badlogic.gdx.math.Vector3();
        this.fieldOfView = f;
        this.viewportWidth = f2;
        this.viewportHeight = f3;
        update();
    }

    @Override // com.badlogic.gdx.graphics.Camera
    public void update() {
        update(true);
    }

    @Override // com.badlogic.gdx.graphics.Camera
    public void update(boolean z) {
        this.projection.setToProjection(java.lang.Math.abs(this.near), java.lang.Math.abs(this.far), this.fieldOfView, this.viewportWidth / this.viewportHeight);
        com.badlogic.gdx.math.Matrix4 matrix4 = this.view;
        com.badlogic.gdx.math.Vector3 vector3 = this.position;
        matrix4.setToLookAt(vector3, this.c.set(vector3).add(this.direction), this.up);
        this.combined.set(this.projection);
        com.badlogic.gdx.math.Matrix4.mul(this.combined.val, this.view.val);
        if (z) {
            this.invProjectionView.set(this.combined);
            com.badlogic.gdx.math.Matrix4.inv(this.invProjectionView.val);
            this.frustum.update(this.invProjectionView);
        }
    }
}
