package com.badlogic.gdx.utils.viewport;

/* loaded from: classes12.dex */
public abstract class Viewport {
    public com.badlogic.gdx.graphics.Camera a;
    public float b;
    public float c;
    public int d;
    public int e;
    public int f;
    public int g;
    public final com.badlogic.gdx.math.Vector3 h = new com.badlogic.gdx.math.Vector3();

    public void apply() {
        apply(false);
    }

    public void apply(boolean z) {
        com.badlogic.gdx.graphics.glutils.HdpiUtils.glViewport(this.d, this.e, this.f, this.g);
        com.badlogic.gdx.graphics.Camera camera = this.a;
        float f = this.b;
        camera.viewportWidth = f;
        float f2 = this.c;
        camera.viewportHeight = f2;
        if (z) {
            camera.position.set(f / 2.0f, f2 / 2.0f, 0.0f);
        }
        this.a.update();
    }

    public void calculateScissors(com.badlogic.gdx.math.Matrix4 matrix4, com.badlogic.gdx.math.Rectangle rectangle, com.badlogic.gdx.math.Rectangle rectangle2) {
        com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.calculateScissors(this.a, this.d, this.e, this.f, this.g, matrix4, rectangle, rectangle2);
    }

    public int getBottomGutterHeight() {
        return this.e;
    }

    public com.badlogic.gdx.graphics.Camera getCamera() {
        return this.a;
    }

    public int getLeftGutterWidth() {
        return this.d;
    }

    public com.badlogic.gdx.math.collision.Ray getPickRay(float f, float f2) {
        return this.a.getPickRay(f, f2, this.d, this.e, this.f, this.g);
    }

    public int getRightGutterWidth() {
        return com.badlogic.gdx.Gdx.graphics.getWidth() - (this.d + this.f);
    }

    public int getRightGutterX() {
        return this.d + this.f;
    }

    public int getScreenHeight() {
        return this.g;
    }

    public int getScreenWidth() {
        return this.f;
    }

    public int getScreenX() {
        return this.d;
    }

    public int getScreenY() {
        return this.e;
    }

    public int getTopGutterHeight() {
        return com.badlogic.gdx.Gdx.graphics.getHeight() - (this.e + this.g);
    }

    public int getTopGutterY() {
        return this.e + this.g;
    }

    public float getWorldHeight() {
        return this.c;
    }

    public float getWorldWidth() {
        return this.b;
    }

    public com.badlogic.gdx.math.Vector2 project(com.badlogic.gdx.math.Vector2 vector2) {
        this.h.set(vector2.x, vector2.y, 1.0f);
        this.a.project(this.h, this.d, this.e, this.f, this.g);
        com.badlogic.gdx.math.Vector3 vector3 = this.h;
        vector2.set(vector3.x, vector3.y);
        return vector2;
    }

    public com.badlogic.gdx.math.Vector3 project(com.badlogic.gdx.math.Vector3 vector3) {
        this.a.project(vector3, this.d, this.e, this.f, this.g);
        return vector3;
    }

    public void setCamera(com.badlogic.gdx.graphics.Camera camera) {
        this.a = camera;
    }

    public void setScreenBounds(int i, int i2, int i3, int i4) {
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
    }

    public void setScreenHeight(int i) {
        this.g = i;
    }

    public void setScreenPosition(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public void setScreenSize(int i, int i2) {
        this.f = i;
        this.g = i2;
    }

    public void setScreenWidth(int i) {
        this.f = i;
    }

    public void setScreenX(int i) {
        this.d = i;
    }

    public void setScreenY(int i) {
        this.e = i;
    }

    public void setWorldHeight(float f) {
        this.c = f;
    }

    public void setWorldSize(float f, float f2) {
        this.b = f;
        this.c = f2;
    }

    public void setWorldWidth(float f) {
        this.b = f;
    }

    public com.badlogic.gdx.math.Vector2 toScreenCoordinates(com.badlogic.gdx.math.Vector2 vector2, com.badlogic.gdx.math.Matrix4 matrix4) {
        this.h.set(vector2.x, vector2.y, 0.0f);
        this.h.mul(matrix4);
        this.a.project(this.h);
        com.badlogic.gdx.math.Vector3 vector3 = this.h;
        float height = com.badlogic.gdx.Gdx.graphics.getHeight();
        com.badlogic.gdx.math.Vector3 vector32 = this.h;
        vector3.y = height - vector32.y;
        vector2.x = vector32.x;
        vector2.y = vector32.y;
        return vector2;
    }

    public com.badlogic.gdx.math.Vector2 unproject(com.badlogic.gdx.math.Vector2 vector2) {
        this.h.set(vector2.x, vector2.y, 1.0f);
        this.a.unproject(this.h, this.d, this.e, this.f, this.g);
        com.badlogic.gdx.math.Vector3 vector3 = this.h;
        vector2.set(vector3.x, vector3.y);
        return vector2;
    }

    public com.badlogic.gdx.math.Vector3 unproject(com.badlogic.gdx.math.Vector3 vector3) {
        this.a.unproject(vector3, this.d, this.e, this.f, this.g);
        return vector3;
    }

    public final void update(int i, int i2) {
        update(i, i2, false);
    }

    public void update(int i, int i2, boolean z) {
        apply(z);
    }
}
