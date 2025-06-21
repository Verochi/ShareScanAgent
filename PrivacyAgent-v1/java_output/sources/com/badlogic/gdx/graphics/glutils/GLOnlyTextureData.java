package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class GLOnlyTextureData implements com.badlogic.gdx.graphics.TextureData {
    public int a;
    public int b;
    public boolean c = false;
    public int d;
    public int e;
    public int f;
    public int g;

    public GLOnlyTextureData(int i, int i2, int i3, int i4, int i5, int i6) {
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void consumeCustomData(int i) {
        com.badlogic.gdx.Gdx.gl.glTexImage2D(i, this.d, this.e, this.a, this.b, 0, this.f, this.g, null);
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public com.badlogic.gdx.graphics.Pixmap consumePixmap() {
        throw new com.badlogic.gdx.utils.GdxRuntimeException("This TextureData implementation does not return a Pixmap");
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean disposePixmap() {
        throw new com.badlogic.gdx.utils.GdxRuntimeException("This TextureData implementation does not return a Pixmap");
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public com.badlogic.gdx.graphics.Pixmap.Format getFormat() {
        return com.badlogic.gdx.graphics.Pixmap.Format.RGBA8888;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getHeight() {
        return this.b;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public com.badlogic.gdx.graphics.TextureData.TextureDataType getType() {
        return com.badlogic.gdx.graphics.TextureData.TextureDataType.Custom;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getWidth() {
        return this.a;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean isManaged() {
        return false;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean isPrepared() {
        return this.c;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void prepare() {
        if (this.c) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Already prepared");
        }
        this.c = true;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean useMipMaps() {
        return false;
    }
}
