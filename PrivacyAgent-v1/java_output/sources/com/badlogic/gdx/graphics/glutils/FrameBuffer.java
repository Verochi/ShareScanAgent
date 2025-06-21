package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class FrameBuffer extends com.badlogic.gdx.graphics.glutils.GLFrameBuffer<com.badlogic.gdx.graphics.Texture> {
    public FrameBuffer(com.badlogic.gdx.graphics.Pixmap.Format format, int i, int i2, boolean z) {
        this(format, i, i2, z, false);
    }

    public FrameBuffer(com.badlogic.gdx.graphics.Pixmap.Format format, int i, int i2, boolean z, boolean z2) {
        super(format, i, i2, z, z2);
    }

    public static void unbind() {
        com.badlogic.gdx.graphics.glutils.GLFrameBuffer.unbind();
    }

    @Override // com.badlogic.gdx.graphics.glutils.GLFrameBuffer
    public void attachFrameBufferColorTexture() {
        com.badlogic.gdx.Gdx.gl20.glFramebufferTexture2D(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, com.badlogic.gdx.graphics.GL20.GL_COLOR_ATTACHMENT0, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, ((com.badlogic.gdx.graphics.Texture) this.colorTexture).getTextureObjectHandle(), 0);
    }

    @Override // com.badlogic.gdx.graphics.glutils.GLFrameBuffer
    public com.badlogic.gdx.graphics.Texture createColorTexture() {
        int glFormat = com.badlogic.gdx.graphics.Pixmap.Format.toGlFormat(this.format);
        com.badlogic.gdx.graphics.Texture texture = new com.badlogic.gdx.graphics.Texture(new com.badlogic.gdx.graphics.glutils.GLOnlyTextureData(this.width, this.height, 0, glFormat, glFormat, com.badlogic.gdx.graphics.Pixmap.Format.toGlType(this.format)));
        com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;
        texture.setFilter(textureFilter, textureFilter);
        com.badlogic.gdx.graphics.Texture.TextureWrap textureWrap = com.badlogic.gdx.graphics.Texture.TextureWrap.ClampToEdge;
        texture.setWrap(textureWrap, textureWrap);
        return texture;
    }

    @Override // com.badlogic.gdx.graphics.glutils.GLFrameBuffer
    public void disposeColorTexture(com.badlogic.gdx.graphics.Texture texture) {
        texture.dispose();
    }
}
