package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public interface Batch extends com.badlogic.gdx.utils.Disposable {
    public static final int C1 = 2;
    public static final int C2 = 7;
    public static final int C3 = 12;
    public static final int C4 = 17;
    public static final int U1 = 3;
    public static final int U2 = 8;
    public static final int U3 = 13;
    public static final int U4 = 18;
    public static final int V1 = 4;
    public static final int V2 = 9;
    public static final int V3 = 14;
    public static final int V4 = 19;
    public static final int X1 = 0;
    public static final int X2 = 5;
    public static final int X3 = 10;
    public static final int X4 = 15;
    public static final int Y1 = 1;
    public static final int Y2 = 6;
    public static final int Y3 = 11;
    public static final int Y4 = 16;

    void begin();

    void disableBlending();

    void draw(com.badlogic.gdx.graphics.Texture texture, float f, float f2);

    void draw(com.badlogic.gdx.graphics.Texture texture, float f, float f2, float f3, float f4);

    void draw(com.badlogic.gdx.graphics.Texture texture, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8);

    void draw(com.badlogic.gdx.graphics.Texture texture, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i, int i2, int i3, int i4, boolean z, boolean z2);

    void draw(com.badlogic.gdx.graphics.Texture texture, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4, boolean z, boolean z2);

    void draw(com.badlogic.gdx.graphics.Texture texture, float f, float f2, int i, int i2, int i3, int i4);

    void draw(com.badlogic.gdx.graphics.Texture texture, float[] fArr, int i, int i2);

    void draw(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, float f2);

    void draw(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, float f2, float f3, float f4);

    void draw(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9);

    void draw(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, boolean z);

    void draw(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, float f2, com.badlogic.gdx.math.Affine2 affine2);

    void enableBlending();

    void end();

    void flush();

    int getBlendDstFunc();

    int getBlendSrcFunc();

    com.badlogic.gdx.graphics.Color getColor();

    float getPackedColor();

    com.badlogic.gdx.math.Matrix4 getProjectionMatrix();

    com.badlogic.gdx.graphics.glutils.ShaderProgram getShader();

    com.badlogic.gdx.math.Matrix4 getTransformMatrix();

    boolean isBlendingEnabled();

    boolean isDrawing();

    void setBlendFunction(int i, int i2);

    void setColor(float f);

    void setColor(float f, float f2, float f3, float f4);

    void setColor(com.badlogic.gdx.graphics.Color color);

    void setProjectionMatrix(com.badlogic.gdx.math.Matrix4 matrix4);

    void setShader(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram);

    void setTransformMatrix(com.badlogic.gdx.math.Matrix4 matrix4);
}
