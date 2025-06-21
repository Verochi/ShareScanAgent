package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class ETC1TextureData implements com.badlogic.gdx.graphics.TextureData {
    public com.badlogic.gdx.files.FileHandle a;
    public com.badlogic.gdx.graphics.glutils.ETC1.ETC1Data b;
    public boolean c;
    public int d;
    public int e;
    public boolean f;

    public ETC1TextureData(com.badlogic.gdx.files.FileHandle fileHandle) {
        this(fileHandle, false);
    }

    public ETC1TextureData(com.badlogic.gdx.files.FileHandle fileHandle, boolean z) {
        this.d = 0;
        this.e = 0;
        this.f = false;
        this.a = fileHandle;
        this.c = z;
    }

    public ETC1TextureData(com.badlogic.gdx.graphics.glutils.ETC1.ETC1Data eTC1Data, boolean z) {
        this.d = 0;
        this.e = 0;
        this.f = false;
        this.b = eTC1Data;
        this.c = z;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void consumeCustomData(int i) {
        if (!this.f) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Call prepare() before calling consumeCompressedData()");
        }
        if (com.badlogic.gdx.Gdx.graphics.supportsExtension("GL_OES_compressed_ETC1_RGB8_texture")) {
            com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl;
            int i2 = com.badlogic.gdx.graphics.glutils.ETC1.ETC1_RGB8_OES;
            int i3 = this.d;
            int i4 = this.e;
            int capacity = this.b.compressedData.capacity();
            com.badlogic.gdx.graphics.glutils.ETC1.ETC1Data eTC1Data = this.b;
            gl20.glCompressedTexImage2D(i, 0, i2, i3, i4, 0, capacity - eTC1Data.dataOffset, eTC1Data.compressedData);
            if (useMipMaps()) {
                com.badlogic.gdx.Gdx.gl20.glGenerateMipmap(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D);
            }
        } else {
            com.badlogic.gdx.graphics.Pixmap decodeImage = com.badlogic.gdx.graphics.glutils.ETC1.decodeImage(this.b, com.badlogic.gdx.graphics.Pixmap.Format.RGB565);
            com.badlogic.gdx.Gdx.gl.glTexImage2D(i, 0, decodeImage.getGLInternalFormat(), decodeImage.getWidth(), decodeImage.getHeight(), 0, decodeImage.getGLFormat(), decodeImage.getGLType(), decodeImage.getPixels());
            if (this.c) {
                com.badlogic.gdx.graphics.glutils.MipMapGenerator.generateMipMap(i, decodeImage, decodeImage.getWidth(), decodeImage.getHeight());
            }
            decodeImage.dispose();
            this.c = false;
        }
        this.b.dispose();
        this.b = null;
        this.f = false;
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
        return com.badlogic.gdx.graphics.Pixmap.Format.RGB565;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getHeight() {
        return this.e;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public com.badlogic.gdx.graphics.TextureData.TextureDataType getType() {
        return com.badlogic.gdx.graphics.TextureData.TextureDataType.Custom;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getWidth() {
        return this.d;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean isManaged() {
        return true;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean isPrepared() {
        return this.f;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void prepare() {
        if (this.f) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Already prepared");
        }
        com.badlogic.gdx.files.FileHandle fileHandle = this.a;
        if (fileHandle == null && this.b == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Can only load once from ETC1Data");
        }
        if (fileHandle != null) {
            this.b = new com.badlogic.gdx.graphics.glutils.ETC1.ETC1Data(fileHandle);
        }
        com.badlogic.gdx.graphics.glutils.ETC1.ETC1Data eTC1Data = this.b;
        this.d = eTC1Data.width;
        this.e = eTC1Data.height;
        this.f = true;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean useMipMaps() {
        return this.c;
    }
}
