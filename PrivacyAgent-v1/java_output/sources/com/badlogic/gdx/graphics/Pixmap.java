package com.badlogic.gdx.graphics;

/* loaded from: classes12.dex */
public class Pixmap implements com.badlogic.gdx.utils.Disposable {
    public final com.badlogic.gdx.graphics.g2d.Gdx2DPixmap b;
    public boolean d;
    public com.badlogic.gdx.graphics.Pixmap.Blending a = com.badlogic.gdx.graphics.Pixmap.Blending.SourceOver;
    public int c = 0;

    public enum Blending {
        None,
        SourceOver
    }

    public enum Filter {
        NearestNeighbour,
        BiLinear
    }

    public enum Format {
        Alpha,
        Intensity,
        LuminanceAlpha,
        RGB565,
        RGBA4444,
        RGB888,
        RGBA8888;

        public static com.badlogic.gdx.graphics.Pixmap.Format fromGdx2DPixmapFormat(int i) {
            if (i == 1) {
                return Alpha;
            }
            if (i == 2) {
                return LuminanceAlpha;
            }
            if (i == 5) {
                return RGB565;
            }
            if (i == 6) {
                return RGBA4444;
            }
            if (i == 3) {
                return RGB888;
            }
            if (i == 4) {
                return RGBA8888;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Unknown Gdx2DPixmap Format: " + i);
        }

        public static int toGdx2DPixmapFormat(com.badlogic.gdx.graphics.Pixmap.Format format) {
            if (format == Alpha || format == Intensity) {
                return 1;
            }
            if (format == LuminanceAlpha) {
                return 2;
            }
            if (format == RGB565) {
                return 5;
            }
            if (format == RGBA4444) {
                return 6;
            }
            if (format == RGB888) {
                return 3;
            }
            if (format == RGBA8888) {
                return 4;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Unknown Format: " + format);
        }

        public static int toGlFormat(com.badlogic.gdx.graphics.Pixmap.Format format) {
            return com.badlogic.gdx.graphics.g2d.Gdx2DPixmap.toGlFormat(toGdx2DPixmapFormat(format));
        }

        public static int toGlType(com.badlogic.gdx.graphics.Pixmap.Format format) {
            return com.badlogic.gdx.graphics.g2d.Gdx2DPixmap.toGlType(toGdx2DPixmapFormat(format));
        }
    }

    public Pixmap(int i, int i2, com.badlogic.gdx.graphics.Pixmap.Format format) {
        this.b = new com.badlogic.gdx.graphics.g2d.Gdx2DPixmap(i, i2, com.badlogic.gdx.graphics.Pixmap.Format.toGdx2DPixmapFormat(format));
        setColor(0.0f, 0.0f, 0.0f, 0.0f);
        fill();
    }

    public Pixmap(com.badlogic.gdx.files.FileHandle fileHandle) {
        try {
            byte[] readBytes = fileHandle.readBytes();
            this.b = new com.badlogic.gdx.graphics.g2d.Gdx2DPixmap(readBytes, 0, readBytes.length, 0);
        } catch (java.lang.Exception e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Couldn't load file: " + fileHandle, e);
        }
    }

    public Pixmap(com.badlogic.gdx.graphics.g2d.Gdx2DPixmap gdx2DPixmap) {
        this.b = gdx2DPixmap;
    }

    public Pixmap(byte[] bArr, int i, int i2) {
        try {
            this.b = new com.badlogic.gdx.graphics.g2d.Gdx2DPixmap(bArr, i, i2, 0);
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Couldn't load pixmap from image data", e);
        }
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public void dispose() {
        if (this.d) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Pixmap already disposed!");
        }
        this.b.dispose();
        this.d = true;
    }

    public void drawCircle(int i, int i2, int i3) {
        this.b.drawCircle(i, i2, i3, this.c);
    }

    public void drawLine(int i, int i2, int i3, int i4) {
        this.b.drawLine(i, i2, i3, i4, this.c);
    }

    public void drawPixel(int i, int i2) {
        this.b.setPixel(i, i2, this.c);
    }

    public void drawPixel(int i, int i2, int i3) {
        this.b.setPixel(i, i2, i3);
    }

    public void drawPixmap(com.badlogic.gdx.graphics.Pixmap pixmap, int i, int i2) {
        drawPixmap(pixmap, i, i2, 0, 0, pixmap.getWidth(), pixmap.getHeight());
    }

    public void drawPixmap(com.badlogic.gdx.graphics.Pixmap pixmap, int i, int i2, int i3, int i4, int i5, int i6) {
        this.b.drawPixmap(pixmap.b, i3, i4, i, i2, i5, i6);
    }

    public void drawPixmap(com.badlogic.gdx.graphics.Pixmap pixmap, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.b.drawPixmap(pixmap.b, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void drawRectangle(int i, int i2, int i3, int i4) {
        this.b.drawRect(i, i2, i3, i4, this.c);
    }

    public void fill() {
        this.b.clear(this.c);
    }

    public void fillCircle(int i, int i2, int i3) {
        this.b.fillCircle(i, i2, i3, this.c);
    }

    public void fillRectangle(int i, int i2, int i3, int i4) {
        this.b.fillRect(i, i2, i3, i4, this.c);
    }

    public void fillTriangle(int i, int i2, int i3, int i4, int i5, int i6) {
        this.b.fillTriangle(i, i2, i3, i4, i5, i6, this.c);
    }

    public com.badlogic.gdx.graphics.Pixmap.Blending getBlending() {
        return this.a;
    }

    public com.badlogic.gdx.graphics.Pixmap.Format getFormat() {
        return com.badlogic.gdx.graphics.Pixmap.Format.fromGdx2DPixmapFormat(this.b.getFormat());
    }

    public int getGLFormat() {
        return this.b.getGLFormat();
    }

    public int getGLInternalFormat() {
        return this.b.getGLInternalFormat();
    }

    public int getGLType() {
        return this.b.getGLType();
    }

    public int getHeight() {
        return this.b.getHeight();
    }

    public int getPixel(int i, int i2) {
        return this.b.getPixel(i, i2);
    }

    public java.nio.ByteBuffer getPixels() {
        if (this.d) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Pixmap already disposed");
        }
        return this.b.getPixels();
    }

    public int getWidth() {
        return this.b.getWidth();
    }

    public void setBlending(com.badlogic.gdx.graphics.Pixmap.Blending blending) {
        this.a = blending;
        this.b.setBlend(blending == com.badlogic.gdx.graphics.Pixmap.Blending.None ? 0 : 1);
    }

    public void setColor(float f, float f2, float f3, float f4) {
        this.c = com.badlogic.gdx.graphics.Color.rgba8888(f, f2, f3, f4);
    }

    public void setColor(int i) {
        this.c = i;
    }

    public void setColor(com.badlogic.gdx.graphics.Color color) {
        this.c = com.badlogic.gdx.graphics.Color.rgba8888(color.r, color.g, color.b, color.a);
    }

    public void setFilter(com.badlogic.gdx.graphics.Pixmap.Filter filter) {
        this.b.setScale(filter == com.badlogic.gdx.graphics.Pixmap.Filter.NearestNeighbour ? 0 : 1);
    }
}
