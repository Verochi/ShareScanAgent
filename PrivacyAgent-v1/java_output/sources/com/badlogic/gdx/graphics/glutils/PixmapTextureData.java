package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class PixmapTextureData implements com.badlogic.gdx.graphics.TextureData {
    public final com.badlogic.gdx.graphics.Pixmap a;
    public final com.badlogic.gdx.graphics.Pixmap.Format b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public PixmapTextureData(com.badlogic.gdx.graphics.Pixmap pixmap, com.badlogic.gdx.graphics.Pixmap.Format format, boolean z, boolean z2) {
        this(pixmap, format, z, z2, false);
    }

    public PixmapTextureData(com.badlogic.gdx.graphics.Pixmap pixmap, com.badlogic.gdx.graphics.Pixmap.Format format, boolean z, boolean z2, boolean z3) {
        this.a = pixmap;
        this.b = format == null ? pixmap.getFormat() : format;
        this.c = z;
        this.d = z2;
        this.e = z3;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void consumeCustomData(int i) {
        throw new com.badlogic.gdx.utils.GdxRuntimeException("This TextureData implementation does not upload data itself");
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public com.badlogic.gdx.graphics.Pixmap consumePixmap() {
        return this.a;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean disposePixmap() {
        return this.d;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public com.badlogic.gdx.graphics.Pixmap.Format getFormat() {
        return this.b;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getHeight() {
        return this.a.getHeight();
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public com.badlogic.gdx.graphics.TextureData.TextureDataType getType() {
        return com.badlogic.gdx.graphics.TextureData.TextureDataType.Pixmap;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getWidth() {
        return this.a.getWidth();
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean isManaged() {
        return this.e;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean isPrepared() {
        return true;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void prepare() {
        throw new com.badlogic.gdx.utils.GdxRuntimeException("prepare() must not be called on a PixmapTextureData instance as it is already prepared.");
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean useMipMaps() {
        return this.c;
    }
}
