package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public interface ImmediateModeRenderer {
    void begin(com.badlogic.gdx.math.Matrix4 matrix4, int i);

    void color(float f);

    void color(float f, float f2, float f3, float f4);

    void color(com.badlogic.gdx.graphics.Color color);

    void dispose();

    void end();

    void flush();

    int getMaxVertices();

    int getNumVertices();

    void normal(float f, float f2, float f3);

    void texCoord(float f, float f2);

    void vertex(float f, float f2, float f3);
}
