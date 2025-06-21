package com.badlogic.gdx.graphics;

/* loaded from: classes12.dex */
public abstract class GLTexture implements com.badlogic.gdx.utils.Disposable {
    protected int glHandle;
    public final int glTarget;
    protected com.badlogic.gdx.graphics.Texture.TextureFilter magFilter;
    protected com.badlogic.gdx.graphics.Texture.TextureFilter minFilter;
    protected com.badlogic.gdx.graphics.Texture.TextureWrap uWrap;
    protected com.badlogic.gdx.graphics.Texture.TextureWrap vWrap;

    public GLTexture(int i) {
        this(i, com.badlogic.gdx.Gdx.gl.glGenTexture());
    }

    public GLTexture(int i, int i2) {
        com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter = com.badlogic.gdx.graphics.Texture.TextureFilter.Nearest;
        this.minFilter = textureFilter;
        this.magFilter = textureFilter;
        com.badlogic.gdx.graphics.Texture.TextureWrap textureWrap = com.badlogic.gdx.graphics.Texture.TextureWrap.ClampToEdge;
        this.uWrap = textureWrap;
        this.vWrap = textureWrap;
        this.glTarget = i;
        this.glHandle = i2;
    }

    public static void uploadImageData(int i, com.badlogic.gdx.graphics.TextureData textureData) {
        uploadImageData(i, textureData, 0);
    }

    public static void uploadImageData(int i, com.badlogic.gdx.graphics.TextureData textureData, int i2) {
        if (textureData == null) {
            return;
        }
        if (!textureData.isPrepared()) {
            textureData.prepare();
        }
        if (textureData.getType() == com.badlogic.gdx.graphics.TextureData.TextureDataType.Custom) {
            textureData.consumeCustomData(i);
            return;
        }
        com.badlogic.gdx.graphics.Pixmap consumePixmap = textureData.consumePixmap();
        boolean disposePixmap = textureData.disposePixmap();
        if (textureData.getFormat() != consumePixmap.getFormat()) {
            com.badlogic.gdx.graphics.Pixmap pixmap = new com.badlogic.gdx.graphics.Pixmap(consumePixmap.getWidth(), consumePixmap.getHeight(), textureData.getFormat());
            pixmap.setBlending(com.badlogic.gdx.graphics.Pixmap.Blending.None);
            pixmap.drawPixmap(consumePixmap, 0, 0, 0, 0, consumePixmap.getWidth(), consumePixmap.getHeight());
            if (textureData.disposePixmap()) {
                consumePixmap.dispose();
            }
            consumePixmap = pixmap;
            disposePixmap = true;
        }
        com.badlogic.gdx.Gdx.gl.glPixelStorei(com.badlogic.gdx.graphics.GL20.GL_UNPACK_ALIGNMENT, 1);
        if (textureData.useMipMaps()) {
            com.badlogic.gdx.graphics.glutils.MipMapGenerator.generateMipMap(i, consumePixmap, consumePixmap.getWidth(), consumePixmap.getHeight());
        } else {
            com.badlogic.gdx.Gdx.gl.glTexImage2D(i, i2, consumePixmap.getGLInternalFormat(), consumePixmap.getWidth(), consumePixmap.getHeight(), 0, consumePixmap.getGLFormat(), consumePixmap.getGLType(), consumePixmap.getPixels());
        }
        if (disposePixmap) {
            consumePixmap.dispose();
        }
    }

    public void bind() {
        com.badlogic.gdx.Gdx.gl.glBindTexture(this.glTarget, this.glHandle);
    }

    public void bind(int i) {
        com.badlogic.gdx.Gdx.gl.glActiveTexture(i + com.badlogic.gdx.graphics.GL20.GL_TEXTURE0);
        com.badlogic.gdx.Gdx.gl.glBindTexture(this.glTarget, this.glHandle);
    }

    public void delete() {
        int i = this.glHandle;
        if (i != 0) {
            com.badlogic.gdx.Gdx.gl.glDeleteTexture(i);
            this.glHandle = 0;
        }
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public void dispose() {
        delete();
    }

    public abstract int getDepth();

    public abstract int getHeight();

    public com.badlogic.gdx.graphics.Texture.TextureFilter getMagFilter() {
        return this.magFilter;
    }

    public com.badlogic.gdx.graphics.Texture.TextureFilter getMinFilter() {
        return this.minFilter;
    }

    public int getTextureObjectHandle() {
        return this.glHandle;
    }

    public com.badlogic.gdx.graphics.Texture.TextureWrap getUWrap() {
        return this.uWrap;
    }

    public com.badlogic.gdx.graphics.Texture.TextureWrap getVWrap() {
        return this.vWrap;
    }

    public abstract int getWidth();

    public abstract boolean isManaged();

    public abstract void reload();

    public void setFilter(com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter, com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter2) {
        this.minFilter = textureFilter;
        this.magFilter = textureFilter2;
        bind();
        com.badlogic.gdx.Gdx.gl.glTexParameterf(this.glTarget, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_MIN_FILTER, textureFilter.getGLEnum());
        com.badlogic.gdx.Gdx.gl.glTexParameterf(this.glTarget, 10240, textureFilter2.getGLEnum());
    }

    public void setWrap(com.badlogic.gdx.graphics.Texture.TextureWrap textureWrap, com.badlogic.gdx.graphics.Texture.TextureWrap textureWrap2) {
        this.uWrap = textureWrap;
        this.vWrap = textureWrap2;
        bind();
        com.badlogic.gdx.Gdx.gl.glTexParameterf(this.glTarget, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_S, textureWrap.getGLEnum());
        com.badlogic.gdx.Gdx.gl.glTexParameterf(this.glTarget, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_T, textureWrap2.getGLEnum());
    }

    public void unsafeSetFilter(com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter, com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter2) {
        unsafeSetFilter(textureFilter, textureFilter2, false);
    }

    public void unsafeSetFilter(com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter, com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter2, boolean z) {
        if (textureFilter != null && (z || this.minFilter != textureFilter)) {
            com.badlogic.gdx.Gdx.gl.glTexParameterf(this.glTarget, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_MIN_FILTER, textureFilter.getGLEnum());
            this.minFilter = textureFilter;
        }
        if (textureFilter2 != null) {
            if (z || this.magFilter != textureFilter2) {
                com.badlogic.gdx.Gdx.gl.glTexParameterf(this.glTarget, 10240, textureFilter2.getGLEnum());
                this.magFilter = textureFilter2;
            }
        }
    }

    public void unsafeSetWrap(com.badlogic.gdx.graphics.Texture.TextureWrap textureWrap, com.badlogic.gdx.graphics.Texture.TextureWrap textureWrap2) {
        unsafeSetWrap(textureWrap, textureWrap2, false);
    }

    public void unsafeSetWrap(com.badlogic.gdx.graphics.Texture.TextureWrap textureWrap, com.badlogic.gdx.graphics.Texture.TextureWrap textureWrap2, boolean z) {
        if (textureWrap != null && (z || this.uWrap != textureWrap)) {
            com.badlogic.gdx.Gdx.gl.glTexParameterf(this.glTarget, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_S, textureWrap.getGLEnum());
            this.uWrap = textureWrap;
        }
        if (textureWrap2 != null) {
            if (z || this.vWrap != textureWrap2) {
                com.badlogic.gdx.Gdx.gl.glTexParameterf(this.glTarget, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_T, textureWrap2.getGLEnum());
                this.vWrap = textureWrap2;
            }
        }
    }
}
