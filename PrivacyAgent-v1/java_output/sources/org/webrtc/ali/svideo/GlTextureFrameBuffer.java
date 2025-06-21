package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
public class GlTextureFrameBuffer {
    private final int frameBufferId;
    private int height;
    private final int pixelFormat;
    private final int textureId;
    private int width;

    public GlTextureFrameBuffer(int i) {
        switch (i) {
            case com.badlogic.gdx.graphics.GL20.GL_RGB /* 6407 */:
            case com.badlogic.gdx.graphics.GL20.GL_RGBA /* 6408 */:
            case com.badlogic.gdx.graphics.GL20.GL_LUMINANCE /* 6409 */:
                this.pixelFormat = i;
                this.textureId = org.webrtc.ali.svideo.GlUtil.generateTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D);
                this.width = 0;
                this.height = 0;
                int[] iArr = new int[1];
                android.opengl.GLES20.glGenFramebuffers(1, iArr, 0);
                this.frameBufferId = iArr[0];
                return;
            default:
                throw new java.lang.IllegalArgumentException("Invalid pixel format: " + i);
        }
    }

    public int getFrameBufferId() {
        return this.frameBufferId;
    }

    public int getHeight() {
        return this.height;
    }

    public int getTextureId() {
        return this.textureId;
    }

    public int getWidth() {
        return this.width;
    }

    public void release() {
        android.opengl.GLES20.glDeleteTextures(1, new int[]{this.textureId}, 0);
        android.opengl.GLES20.glDeleteFramebuffers(1, new int[]{this.frameBufferId}, 0);
        this.width = 0;
        this.height = 0;
    }

    public void setSize(int i, int i2) {
        if (i == 0 || i2 == 0) {
            throw new java.lang.IllegalArgumentException("Invalid size: " + i + "x" + i2);
        }
        if (i == this.width && i2 == this.height) {
            return;
        }
        this.width = i;
        this.height = i2;
        android.opengl.GLES20.glActiveTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE0);
        android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, this.textureId);
        int i3 = this.pixelFormat;
        android.opengl.GLES20.glTexImage2D(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0, i3, i, i2, 0, i3, com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE, null);
        android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0);
        org.webrtc.ali.svideo.GlUtil.checkNoGLES2Error("GlTextureFrameBuffer setSize");
        android.opengl.GLES20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, this.frameBufferId);
        android.opengl.GLES20.glFramebufferTexture2D(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, com.badlogic.gdx.graphics.GL20.GL_COLOR_ATTACHMENT0, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, this.textureId, 0);
        int glCheckFramebufferStatus = android.opengl.GLES20.glCheckFramebufferStatus(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER);
        if (glCheckFramebufferStatus == 36053) {
            android.opengl.GLES20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, 0);
            return;
        }
        throw new java.lang.IllegalStateException("Framebuffer not complete, status: " + glCheckFramebufferStatus);
    }
}
