package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class FileTextureData implements com.badlogic.gdx.graphics.TextureData {
    public static boolean copyToPOT;
    public final com.badlogic.gdx.files.FileHandle a;
    public int b;
    public int c;
    public com.badlogic.gdx.graphics.Pixmap.Format d;
    public com.badlogic.gdx.graphics.Pixmap e;
    public boolean f;
    public boolean g = false;

    public FileTextureData(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.graphics.Pixmap pixmap, com.badlogic.gdx.graphics.Pixmap.Format format, boolean z) {
        this.b = 0;
        this.c = 0;
        this.a = fileHandle;
        this.e = pixmap;
        this.d = format;
        this.f = z;
        if (pixmap != null) {
            com.badlogic.gdx.graphics.Pixmap a = a(pixmap);
            this.e = a;
            this.b = a.getWidth();
            this.c = this.e.getHeight();
            if (format == null) {
                this.d = this.e.getFormat();
            }
        }
    }

    public final com.badlogic.gdx.graphics.Pixmap a(com.badlogic.gdx.graphics.Pixmap pixmap) {
        if (com.badlogic.gdx.Gdx.gl20 == null && copyToPOT) {
            int width = pixmap.getWidth();
            int height = pixmap.getHeight();
            int nextPowerOfTwo = com.badlogic.gdx.math.MathUtils.nextPowerOfTwo(width);
            int nextPowerOfTwo2 = com.badlogic.gdx.math.MathUtils.nextPowerOfTwo(height);
            if (width != nextPowerOfTwo || height != nextPowerOfTwo2) {
                com.badlogic.gdx.graphics.Pixmap pixmap2 = new com.badlogic.gdx.graphics.Pixmap(nextPowerOfTwo, nextPowerOfTwo2, pixmap.getFormat());
                pixmap2.drawPixmap(pixmap, 0, 0, 0, 0, width, height);
                pixmap.dispose();
                return pixmap2;
            }
        }
        return pixmap;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void consumeCustomData(int i) {
        throw new com.badlogic.gdx.utils.GdxRuntimeException("This TextureData implementation does not upload data itself");
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public com.badlogic.gdx.graphics.Pixmap consumePixmap() {
        if (!this.g) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Call prepare() before calling getPixmap()");
        }
        this.g = false;
        com.badlogic.gdx.graphics.Pixmap pixmap = this.e;
        this.e = null;
        return pixmap;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean disposePixmap() {
        return true;
    }

    public com.badlogic.gdx.files.FileHandle getFileHandle() {
        return this.a;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public com.badlogic.gdx.graphics.Pixmap.Format getFormat() {
        return this.d;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getHeight() {
        return this.c;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public com.badlogic.gdx.graphics.TextureData.TextureDataType getType() {
        return com.badlogic.gdx.graphics.TextureData.TextureDataType.Pixmap;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getWidth() {
        return this.b;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean isManaged() {
        return true;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean isPrepared() {
        return this.g;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void prepare() {
        if (this.g) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Already prepared");
        }
        if (this.e == null) {
            if (this.a.extension().equals("cim")) {
                this.e = com.badlogic.gdx.graphics.PixmapIO.readCIM(this.a);
            } else {
                this.e = a(new com.badlogic.gdx.graphics.Pixmap(this.a));
            }
            this.b = this.e.getWidth();
            this.c = this.e.getHeight();
            if (this.d == null) {
                this.d = this.e.getFormat();
            }
        }
        this.g = true;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean useMipMaps() {
        return this.f;
    }
}
