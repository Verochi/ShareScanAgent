package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class HdpiUtils {
    public static void glScissor(int i, int i2, int i3, int i4) {
        if (com.badlogic.gdx.Gdx.graphics.getWidth() == com.badlogic.gdx.Gdx.graphics.getBackBufferWidth() && com.badlogic.gdx.Gdx.graphics.getHeight() == com.badlogic.gdx.Gdx.graphics.getBackBufferHeight()) {
            com.badlogic.gdx.Gdx.gl.glScissor(i, i2, i3, i4);
        } else {
            com.badlogic.gdx.Gdx.gl.glScissor(toBackBufferX(i), toBackBufferY(i2), toBackBufferX(i3), toBackBufferY(i4));
        }
    }

    public static void glViewport(int i, int i2, int i3, int i4) {
        if (com.badlogic.gdx.Gdx.graphics.getWidth() == com.badlogic.gdx.Gdx.graphics.getBackBufferWidth() && com.badlogic.gdx.Gdx.graphics.getHeight() == com.badlogic.gdx.Gdx.graphics.getBackBufferHeight()) {
            com.badlogic.gdx.Gdx.gl.glViewport(i, i2, i3, i4);
        } else {
            com.badlogic.gdx.Gdx.gl.glViewport(toBackBufferX(i), toBackBufferY(i2), toBackBufferX(i3), toBackBufferY(i4));
        }
    }

    public static int toBackBufferX(int i) {
        return (int) ((i * com.badlogic.gdx.Gdx.graphics.getBackBufferWidth()) / com.badlogic.gdx.Gdx.graphics.getWidth());
    }

    public static int toBackBufferY(int i) {
        return (int) ((i * com.badlogic.gdx.Gdx.graphics.getBackBufferHeight()) / com.badlogic.gdx.Gdx.graphics.getHeight());
    }

    public static int toLogicalX(int i) {
        return (int) ((i * com.badlogic.gdx.Gdx.graphics.getWidth()) / com.badlogic.gdx.Gdx.graphics.getBackBufferWidth());
    }

    public static int toLogicalY(int i) {
        return (int) ((i * com.badlogic.gdx.Gdx.graphics.getHeight()) / com.badlogic.gdx.Gdx.graphics.getBackBufferHeight());
    }
}
