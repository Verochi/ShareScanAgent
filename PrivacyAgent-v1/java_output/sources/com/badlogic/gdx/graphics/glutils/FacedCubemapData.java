package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class FacedCubemapData implements com.badlogic.gdx.graphics.CubemapData {
    protected final com.badlogic.gdx.graphics.TextureData[] data;

    public FacedCubemapData() {
        this((com.badlogic.gdx.graphics.TextureData) null, (com.badlogic.gdx.graphics.TextureData) null, (com.badlogic.gdx.graphics.TextureData) null, (com.badlogic.gdx.graphics.TextureData) null, (com.badlogic.gdx.graphics.TextureData) null, (com.badlogic.gdx.graphics.TextureData) null);
    }

    public FacedCubemapData(int i, int i2, int i3, com.badlogic.gdx.graphics.Pixmap.Format format) {
        this(new com.badlogic.gdx.graphics.glutils.PixmapTextureData(new com.badlogic.gdx.graphics.Pixmap(i3, i2, format), null, false, true), new com.badlogic.gdx.graphics.glutils.PixmapTextureData(new com.badlogic.gdx.graphics.Pixmap(i3, i2, format), null, false, true), new com.badlogic.gdx.graphics.glutils.PixmapTextureData(new com.badlogic.gdx.graphics.Pixmap(i, i3, format), null, false, true), new com.badlogic.gdx.graphics.glutils.PixmapTextureData(new com.badlogic.gdx.graphics.Pixmap(i, i3, format), null, false, true), new com.badlogic.gdx.graphics.glutils.PixmapTextureData(new com.badlogic.gdx.graphics.Pixmap(i, i2, format), null, false, true), new com.badlogic.gdx.graphics.glutils.PixmapTextureData(new com.badlogic.gdx.graphics.Pixmap(i, i2, format), null, false, true));
    }

    public FacedCubemapData(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.files.FileHandle fileHandle2, com.badlogic.gdx.files.FileHandle fileHandle3, com.badlogic.gdx.files.FileHandle fileHandle4, com.badlogic.gdx.files.FileHandle fileHandle5, com.badlogic.gdx.files.FileHandle fileHandle6) {
        this(com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle, false), com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle2, false), com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle3, false), com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle4, false), com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle5, false), com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle6, false));
    }

    public FacedCubemapData(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.files.FileHandle fileHandle2, com.badlogic.gdx.files.FileHandle fileHandle3, com.badlogic.gdx.files.FileHandle fileHandle4, com.badlogic.gdx.files.FileHandle fileHandle5, com.badlogic.gdx.files.FileHandle fileHandle6, boolean z) {
        this(com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle, z), com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle2, z), com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle3, z), com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle4, z), com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle5, z), com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle6, z));
    }

    public FacedCubemapData(com.badlogic.gdx.graphics.Pixmap pixmap, com.badlogic.gdx.graphics.Pixmap pixmap2, com.badlogic.gdx.graphics.Pixmap pixmap3, com.badlogic.gdx.graphics.Pixmap pixmap4, com.badlogic.gdx.graphics.Pixmap pixmap5, com.badlogic.gdx.graphics.Pixmap pixmap6) {
        this(pixmap, pixmap2, pixmap3, pixmap4, pixmap5, pixmap6, false);
    }

    public FacedCubemapData(com.badlogic.gdx.graphics.Pixmap pixmap, com.badlogic.gdx.graphics.Pixmap pixmap2, com.badlogic.gdx.graphics.Pixmap pixmap3, com.badlogic.gdx.graphics.Pixmap pixmap4, com.badlogic.gdx.graphics.Pixmap pixmap5, com.badlogic.gdx.graphics.Pixmap pixmap6, boolean z) {
        this(pixmap == null ? null : new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap, null, z, false), pixmap2 == null ? null : new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap2, null, z, false), pixmap3 == null ? null : new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap3, null, z, false), pixmap4 == null ? null : new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap4, null, z, false), pixmap5 == null ? null : new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap5, null, z, false), pixmap6 == null ? null : new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap6, null, z, false));
    }

    public FacedCubemapData(com.badlogic.gdx.graphics.TextureData textureData, com.badlogic.gdx.graphics.TextureData textureData2, com.badlogic.gdx.graphics.TextureData textureData3, com.badlogic.gdx.graphics.TextureData textureData4, com.badlogic.gdx.graphics.TextureData textureData5, com.badlogic.gdx.graphics.TextureData textureData6) {
        this.data = new com.badlogic.gdx.graphics.TextureData[]{textureData, textureData2, textureData3, textureData4, textureData5, textureData6};
    }

    @Override // com.badlogic.gdx.graphics.CubemapData
    public void consumeCubemapData() {
        int i = 0;
        while (true) {
            com.badlogic.gdx.graphics.TextureData[] textureDataArr = this.data;
            if (i >= textureDataArr.length) {
                return;
            }
            if (textureDataArr[i].getType() == com.badlogic.gdx.graphics.TextureData.TextureDataType.Custom) {
                this.data[i].consumeCustomData(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_CUBE_MAP_POSITIVE_X + i);
            } else {
                com.badlogic.gdx.graphics.Pixmap consumePixmap = this.data[i].consumePixmap();
                boolean disposePixmap = this.data[i].disposePixmap();
                if (this.data[i].getFormat() != consumePixmap.getFormat()) {
                    com.badlogic.gdx.graphics.Pixmap pixmap = new com.badlogic.gdx.graphics.Pixmap(consumePixmap.getWidth(), consumePixmap.getHeight(), this.data[i].getFormat());
                    pixmap.setBlending(com.badlogic.gdx.graphics.Pixmap.Blending.None);
                    pixmap.drawPixmap(consumePixmap, 0, 0, 0, 0, consumePixmap.getWidth(), consumePixmap.getHeight());
                    if (this.data[i].disposePixmap()) {
                        consumePixmap.dispose();
                    }
                    consumePixmap = pixmap;
                    disposePixmap = true;
                }
                com.badlogic.gdx.Gdx.gl.glPixelStorei(com.badlogic.gdx.graphics.GL20.GL_UNPACK_ALIGNMENT, 1);
                com.badlogic.gdx.Gdx.gl.glTexImage2D(i + com.badlogic.gdx.graphics.GL20.GL_TEXTURE_CUBE_MAP_POSITIVE_X, 0, consumePixmap.getGLInternalFormat(), consumePixmap.getWidth(), consumePixmap.getHeight(), 0, consumePixmap.getGLFormat(), consumePixmap.getGLType(), consumePixmap.getPixels());
                if (disposePixmap) {
                    consumePixmap.dispose();
                }
            }
            i++;
        }
    }

    @Override // com.badlogic.gdx.graphics.CubemapData
    public int getHeight() {
        int i;
        int height;
        int height2;
        int height3;
        com.badlogic.gdx.graphics.TextureData textureData = this.data[com.badlogic.gdx.graphics.Cubemap.CubemapSide.PositiveZ.index];
        if (textureData == null || (i = textureData.getHeight()) <= 0) {
            i = 0;
        }
        com.badlogic.gdx.graphics.TextureData textureData2 = this.data[com.badlogic.gdx.graphics.Cubemap.CubemapSide.NegativeZ.index];
        if (textureData2 != null && (height3 = textureData2.getHeight()) > i) {
            i = height3;
        }
        com.badlogic.gdx.graphics.TextureData textureData3 = this.data[com.badlogic.gdx.graphics.Cubemap.CubemapSide.PositiveX.index];
        if (textureData3 != null && (height2 = textureData3.getHeight()) > i) {
            i = height2;
        }
        com.badlogic.gdx.graphics.TextureData textureData4 = this.data[com.badlogic.gdx.graphics.Cubemap.CubemapSide.NegativeX.index];
        return (textureData4 == null || (height = textureData4.getHeight()) <= i) ? i : height;
    }

    public com.badlogic.gdx.graphics.TextureData getTextureData(com.badlogic.gdx.graphics.Cubemap.CubemapSide cubemapSide) {
        return this.data[cubemapSide.index];
    }

    @Override // com.badlogic.gdx.graphics.CubemapData
    public int getWidth() {
        int i;
        int width;
        int width2;
        int width3;
        com.badlogic.gdx.graphics.TextureData textureData = this.data[com.badlogic.gdx.graphics.Cubemap.CubemapSide.PositiveZ.index];
        if (textureData == null || (i = textureData.getWidth()) <= 0) {
            i = 0;
        }
        com.badlogic.gdx.graphics.TextureData textureData2 = this.data[com.badlogic.gdx.graphics.Cubemap.CubemapSide.NegativeZ.index];
        if (textureData2 != null && (width3 = textureData2.getWidth()) > i) {
            i = width3;
        }
        com.badlogic.gdx.graphics.TextureData textureData3 = this.data[com.badlogic.gdx.graphics.Cubemap.CubemapSide.PositiveY.index];
        if (textureData3 != null && (width2 = textureData3.getWidth()) > i) {
            i = width2;
        }
        com.badlogic.gdx.graphics.TextureData textureData4 = this.data[com.badlogic.gdx.graphics.Cubemap.CubemapSide.NegativeY.index];
        return (textureData4 == null || (width = textureData4.getWidth()) <= i) ? i : width;
    }

    public boolean isComplete() {
        int i = 0;
        while (true) {
            com.badlogic.gdx.graphics.TextureData[] textureDataArr = this.data;
            if (i >= textureDataArr.length) {
                return true;
            }
            if (textureDataArr[i] == null) {
                return false;
            }
            i++;
        }
    }

    @Override // com.badlogic.gdx.graphics.CubemapData
    public boolean isManaged() {
        for (com.badlogic.gdx.graphics.TextureData textureData : this.data) {
            if (!textureData.isManaged()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.badlogic.gdx.graphics.CubemapData
    public boolean isPrepared() {
        return false;
    }

    public void load(com.badlogic.gdx.graphics.Cubemap.CubemapSide cubemapSide, com.badlogic.gdx.files.FileHandle fileHandle) {
        this.data[cubemapSide.index] = com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle, false);
    }

    public void load(com.badlogic.gdx.graphics.Cubemap.CubemapSide cubemapSide, com.badlogic.gdx.graphics.Pixmap pixmap) {
        this.data[cubemapSide.index] = pixmap != null ? new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap, null, false, false) : null;
    }

    @Override // com.badlogic.gdx.graphics.CubemapData
    public void prepare() {
        if (!isComplete()) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("You need to complete your cubemap data before using it");
        }
        int i = 0;
        while (true) {
            com.badlogic.gdx.graphics.TextureData[] textureDataArr = this.data;
            if (i >= textureDataArr.length) {
                return;
            }
            if (!textureDataArr[i].isPrepared()) {
                this.data[i].prepare();
            }
            i++;
        }
    }
}
