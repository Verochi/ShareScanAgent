package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public interface VertexData extends com.badlogic.gdx.utils.Disposable {
    void bind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram);

    void bind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram, int[] iArr);

    @Override // com.badlogic.gdx.utils.Disposable
    void dispose();

    com.badlogic.gdx.graphics.VertexAttributes getAttributes();

    java.nio.FloatBuffer getBuffer();

    int getNumMaxVertices();

    int getNumVertices();

    void invalidate();

    void setVertices(float[] fArr, int i, int i2);

    void unbind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram);

    void unbind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram, int[] iArr);

    void updateVertices(int i, float[] fArr, int i2, int i3);
}
