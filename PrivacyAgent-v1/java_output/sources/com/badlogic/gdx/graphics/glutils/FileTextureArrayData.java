package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class FileTextureArrayData implements com.badlogic.gdx.graphics.TextureArrayData {
    public com.badlogic.gdx.graphics.TextureData[] a;
    public boolean b;
    public com.badlogic.gdx.graphics.Pixmap.Format c;
    public int d;
    public boolean e;

    public FileTextureArrayData(com.badlogic.gdx.graphics.Pixmap.Format format, boolean z, com.badlogic.gdx.files.FileHandle[] fileHandleArr) {
        this.c = format;
        this.e = z;
        this.d = fileHandleArr.length;
        this.a = new com.badlogic.gdx.graphics.TextureData[fileHandleArr.length];
        for (int i = 0; i < fileHandleArr.length; i++) {
            this.a[i] = com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandleArr[i], format, z);
        }
    }

    @Override // com.badlogic.gdx.graphics.TextureArrayData
    public void consumeTextureArrayData() {
        boolean z;
        com.badlogic.gdx.graphics.Pixmap pixmap;
        int i = 0;
        while (true) {
            com.badlogic.gdx.graphics.TextureData[] textureDataArr = this.a;
            if (i >= textureDataArr.length) {
                return;
            }
            if (textureDataArr[i].getType() == com.badlogic.gdx.graphics.TextureData.TextureDataType.Custom) {
                this.a[i].consumeCustomData(com.badlogic.gdx.graphics.GL30.GL_TEXTURE_2D_ARRAY);
            } else {
                com.badlogic.gdx.graphics.TextureData textureData = this.a[i];
                com.badlogic.gdx.graphics.Pixmap consumePixmap = textureData.consumePixmap();
                boolean disposePixmap = textureData.disposePixmap();
                if (textureData.getFormat() != consumePixmap.getFormat()) {
                    com.badlogic.gdx.graphics.Pixmap pixmap2 = new com.badlogic.gdx.graphics.Pixmap(consumePixmap.getWidth(), consumePixmap.getHeight(), textureData.getFormat());
                    pixmap2.setBlending(com.badlogic.gdx.graphics.Pixmap.Blending.None);
                    pixmap2.drawPixmap(consumePixmap, 0, 0, 0, 0, consumePixmap.getWidth(), consumePixmap.getHeight());
                    if (textureData.disposePixmap()) {
                        consumePixmap.dispose();
                    }
                    pixmap = pixmap2;
                    z = true;
                } else {
                    z = disposePixmap;
                    pixmap = consumePixmap;
                }
                com.badlogic.gdx.Gdx.gl30.glTexSubImage3D(com.badlogic.gdx.graphics.GL30.GL_TEXTURE_2D_ARRAY, 0, 0, 0, i, pixmap.getWidth(), pixmap.getHeight(), 1, pixmap.getGLInternalFormat(), pixmap.getGLType(), pixmap.getPixels());
                if (z) {
                    pixmap.dispose();
                }
            }
            i++;
        }
    }

    @Override // com.badlogic.gdx.graphics.TextureArrayData
    public int getDepth() {
        return this.d;
    }

    @Override // com.badlogic.gdx.graphics.TextureArrayData
    public int getGLType() {
        return com.badlogic.gdx.graphics.Pixmap.Format.toGlType(this.c);
    }

    @Override // com.badlogic.gdx.graphics.TextureArrayData
    public int getHeight() {
        return this.a[0].getHeight();
    }

    @Override // com.badlogic.gdx.graphics.TextureArrayData
    public int getInternalFormat() {
        return com.badlogic.gdx.graphics.Pixmap.Format.toGlFormat(this.c);
    }

    @Override // com.badlogic.gdx.graphics.TextureArrayData
    public int getWidth() {
        return this.a[0].getWidth();
    }

    @Override // com.badlogic.gdx.graphics.TextureArrayData
    public boolean isManaged() {
        for (com.badlogic.gdx.graphics.TextureData textureData : this.a) {
            if (!textureData.isManaged()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.badlogic.gdx.graphics.TextureArrayData
    public boolean isPrepared() {
        return this.b;
    }

    @Override // com.badlogic.gdx.graphics.TextureArrayData
    public void prepare() {
        int i = -1;
        int i2 = -1;
        for (com.badlogic.gdx.graphics.TextureData textureData : this.a) {
            textureData.prepare();
            if (i == -1) {
                i = textureData.getWidth();
                i2 = textureData.getHeight();
            } else if (i != textureData.getWidth() || i2 != textureData.getHeight()) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Error whilst preparing TextureArray: TextureArray Textures must have equal dimensions.");
            }
        }
        this.b = true;
    }
}
