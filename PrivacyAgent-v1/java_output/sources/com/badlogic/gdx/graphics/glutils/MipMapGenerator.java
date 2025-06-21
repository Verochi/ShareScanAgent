package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class MipMapGenerator {
    public static boolean a = true;

    public static void a(int i, com.badlogic.gdx.graphics.Pixmap pixmap, int i2, int i3) {
        com.badlogic.gdx.Gdx.gl.glTexImage2D(i, 0, pixmap.getGLInternalFormat(), pixmap.getWidth(), pixmap.getHeight(), 0, pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
        if (com.badlogic.gdx.Gdx.gl20 == null && i2 != i3) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("texture width and height must be square when using mipmapping.");
        }
        int width = pixmap.getWidth() / 2;
        int height = pixmap.getHeight() / 2;
        int i4 = 1;
        com.badlogic.gdx.graphics.Pixmap pixmap2 = pixmap;
        while (width > 0 && height > 0) {
            com.badlogic.gdx.graphics.Pixmap pixmap3 = new com.badlogic.gdx.graphics.Pixmap(width, height, pixmap2.getFormat());
            pixmap3.setBlending(com.badlogic.gdx.graphics.Pixmap.Blending.None);
            pixmap3.drawPixmap(pixmap2, 0, 0, pixmap2.getWidth(), pixmap2.getHeight(), 0, 0, width, height);
            if (i4 > 1) {
                pixmap2.dispose();
            }
            pixmap2 = pixmap3;
            com.badlogic.gdx.Gdx.gl.glTexImage2D(i, i4, pixmap3.getGLInternalFormat(), pixmap3.getWidth(), pixmap3.getHeight(), 0, pixmap3.getGLFormat(), pixmap3.getGLType(), pixmap3.getPixels());
            width = pixmap2.getWidth() / 2;
            height = pixmap2.getHeight() / 2;
            i4++;
        }
    }

    public static void b(int i, com.badlogic.gdx.graphics.Pixmap pixmap, int i2, int i3) {
        if (!com.badlogic.gdx.Gdx.graphics.supportsExtension("GL_ARB_framebuffer_object") && !com.badlogic.gdx.Gdx.graphics.supportsExtension("GL_EXT_framebuffer_object") && com.badlogic.gdx.Gdx.gl30 == null) {
            a(i, pixmap, i2, i3);
        } else {
            com.badlogic.gdx.Gdx.gl.glTexImage2D(i, 0, pixmap.getGLInternalFormat(), pixmap.getWidth(), pixmap.getHeight(), 0, pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
            com.badlogic.gdx.Gdx.gl20.glGenerateMipmap(i);
        }
    }

    public static void c(int i, com.badlogic.gdx.graphics.Pixmap pixmap) {
        com.badlogic.gdx.Gdx.gl.glTexImage2D(i, 0, pixmap.getGLInternalFormat(), pixmap.getWidth(), pixmap.getHeight(), 0, pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
        com.badlogic.gdx.Gdx.gl20.glGenerateMipmap(i);
    }

    public static void generateMipMap(int i, com.badlogic.gdx.graphics.Pixmap pixmap, int i2, int i3) {
        if (!a) {
            a(i, pixmap, i2, i3);
        } else if (com.badlogic.gdx.Gdx.app.getType() == com.badlogic.gdx.Application.ApplicationType.Android || com.badlogic.gdx.Gdx.app.getType() == com.badlogic.gdx.Application.ApplicationType.WebGL || com.badlogic.gdx.Gdx.app.getType() == com.badlogic.gdx.Application.ApplicationType.iOS) {
            c(i, pixmap);
        } else {
            b(i, pixmap, i2, i3);
        }
    }

    public static void generateMipMap(com.badlogic.gdx.graphics.Pixmap pixmap, int i, int i2) {
        generateMipMap(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, pixmap, i, i2);
    }

    public static void setUseHardwareMipMap(boolean z) {
        a = z;
    }
}
