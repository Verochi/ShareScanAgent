package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public final class ScreenUtils {
    public static byte[] getFrameBufferPixels(int i, int i2, int i3, int i4, boolean z) {
        com.badlogic.gdx.Gdx.gl.glPixelStorei(com.badlogic.gdx.graphics.GL20.GL_PACK_ALIGNMENT, 1);
        int i5 = i3 * i4 * 4;
        java.nio.ByteBuffer newByteBuffer = com.badlogic.gdx.utils.BufferUtils.newByteBuffer(i5);
        com.badlogic.gdx.Gdx.gl.glReadPixels(i, i2, i3, i4, com.badlogic.gdx.graphics.GL20.GL_RGBA, com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE, newByteBuffer);
        byte[] bArr = new byte[i5];
        if (z) {
            int i6 = i3 * 4;
            for (int i7 = 0; i7 < i4; i7++) {
                newByteBuffer.position(((i4 - i7) - 1) * i6);
                newByteBuffer.get(bArr, i7 * i6, i6);
            }
        } else {
            newByteBuffer.clear();
            newByteBuffer.get(bArr);
        }
        return bArr;
    }

    public static byte[] getFrameBufferPixels(boolean z) {
        return getFrameBufferPixels(0, 0, com.badlogic.gdx.Gdx.graphics.getBackBufferWidth(), com.badlogic.gdx.Gdx.graphics.getBackBufferHeight(), z);
    }

    public static com.badlogic.gdx.graphics.Pixmap getFrameBufferPixmap(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.Gdx.gl.glPixelStorei(com.badlogic.gdx.graphics.GL20.GL_PACK_ALIGNMENT, 1);
        com.badlogic.gdx.graphics.Pixmap pixmap = new com.badlogic.gdx.graphics.Pixmap(i3, i4, com.badlogic.gdx.graphics.Pixmap.Format.RGBA8888);
        com.badlogic.gdx.Gdx.gl.glReadPixels(i, i2, i3, i4, com.badlogic.gdx.graphics.GL20.GL_RGBA, com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE, pixmap.getPixels());
        return pixmap;
    }

    public static com.badlogic.gdx.graphics.g2d.TextureRegion getFrameBufferTexture() {
        return getFrameBufferTexture(0, 0, com.badlogic.gdx.Gdx.graphics.getBackBufferWidth(), com.badlogic.gdx.Gdx.graphics.getBackBufferHeight());
    }

    public static com.badlogic.gdx.graphics.g2d.TextureRegion getFrameBufferTexture(int i, int i2, int i3, int i4) {
        int nextPowerOfTwo = com.badlogic.gdx.math.MathUtils.nextPowerOfTwo(i3);
        int nextPowerOfTwo2 = com.badlogic.gdx.math.MathUtils.nextPowerOfTwo(i4);
        com.badlogic.gdx.graphics.Pixmap frameBufferPixmap = getFrameBufferPixmap(i, i2, i3, i4);
        com.badlogic.gdx.graphics.Pixmap pixmap = new com.badlogic.gdx.graphics.Pixmap(nextPowerOfTwo, nextPowerOfTwo2, com.badlogic.gdx.graphics.Pixmap.Format.RGBA8888);
        pixmap.drawPixmap(frameBufferPixmap, 0, 0);
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion = new com.badlogic.gdx.graphics.g2d.TextureRegion(new com.badlogic.gdx.graphics.Texture(pixmap), 0, i4, i3, -i4);
        pixmap.dispose();
        frameBufferPixmap.dispose();
        return textureRegion;
    }
}
