package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class Gdx2DPixmap implements com.badlogic.gdx.utils.Disposable {
    public static final int GDX2D_BLEND_NONE = 0;
    public static final int GDX2D_BLEND_SRC_OVER = 1;
    public static final int GDX2D_FORMAT_ALPHA = 1;
    public static final int GDX2D_FORMAT_LUMINANCE_ALPHA = 2;
    public static final int GDX2D_FORMAT_RGB565 = 5;
    public static final int GDX2D_FORMAT_RGB888 = 3;
    public static final int GDX2D_FORMAT_RGBA4444 = 6;
    public static final int GDX2D_FORMAT_RGBA8888 = 4;
    public static final int GDX2D_SCALE_LINEAR = 1;
    public static final int GDX2D_SCALE_NEAREST = 0;
    public long a;
    public int b;
    public int c;
    public int d;
    public java.nio.ByteBuffer e;
    public long[] f;

    public Gdx2DPixmap(int i, int i2, int i3) throws com.badlogic.gdx.utils.GdxRuntimeException {
        long[] jArr = new long[4];
        this.f = jArr;
        java.nio.ByteBuffer newPixmap = newPixmap(jArr, i, i2, i3);
        this.e = newPixmap;
        if (newPixmap == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error loading pixmap.");
        }
        long[] jArr2 = this.f;
        this.a = jArr2[0];
        this.b = (int) jArr2[1];
        this.c = (int) jArr2[2];
        this.d = (int) jArr2[3];
    }

    public Gdx2DPixmap(java.io.InputStream inputStream, int i) throws java.io.IOException {
        this.f = new long[4];
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(1024);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            } else {
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        java.nio.ByteBuffer load = load(this.f, byteArray, 0, byteArray.length);
        this.e = load;
        if (load == null) {
            throw new java.io.IOException("Error loading pixmap: " + getFailureReason());
        }
        long[] jArr = this.f;
        this.a = jArr[0];
        this.b = (int) jArr[1];
        this.c = (int) jArr[2];
        int i2 = (int) jArr[3];
        this.d = i2;
        if (i == 0 || i == i2) {
            return;
        }
        a(i);
    }

    public Gdx2DPixmap(java.nio.ByteBuffer byteBuffer, long[] jArr) {
        this.f = new long[4];
        this.e = byteBuffer;
        this.a = jArr[0];
        this.b = (int) jArr[1];
        this.c = (int) jArr[2];
        this.d = (int) jArr[3];
    }

    public Gdx2DPixmap(byte[] bArr, int i, int i2, int i3) throws java.io.IOException {
        long[] jArr = new long[4];
        this.f = jArr;
        java.nio.ByteBuffer load = load(jArr, bArr, i, i2);
        this.e = load;
        if (load == null) {
            throw new java.io.IOException("Error loading pixmap: " + getFailureReason());
        }
        long[] jArr2 = this.f;
        this.a = jArr2[0];
        this.b = (int) jArr2[1];
        this.c = (int) jArr2[2];
        int i4 = (int) jArr2[3];
        this.d = i4;
        if (i3 == 0 || i3 == i4) {
            return;
        }
        a(i3);
    }

    private static native void clear(long j, int i);

    private static native void drawCircle(long j, int i, int i2, int i3, int i4);

    private static native void drawLine(long j, int i, int i2, int i3, int i4, int i5);

    private static native void drawPixmap(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    private static native void drawRect(long j, int i, int i2, int i3, int i4, int i5);

    private static native void fillCircle(long j, int i, int i2, int i3, int i4);

    private static native void fillRect(long j, int i, int i2, int i3, int i4, int i5);

    private static native void fillTriangle(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    private static native void free(long j);

    public static native java.lang.String getFailureReason();

    private static native int getPixel(long j, int i, int i2);

    private static native java.nio.ByteBuffer load(long[] jArr, byte[] bArr, int i, int i2);

    public static com.badlogic.gdx.graphics.g2d.Gdx2DPixmap newPixmap(int i, int i2, int i3) {
        try {
            return new com.badlogic.gdx.graphics.g2d.Gdx2DPixmap(i, i2, i3);
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    public static com.badlogic.gdx.graphics.g2d.Gdx2DPixmap newPixmap(java.io.InputStream inputStream, int i) {
        try {
            return new com.badlogic.gdx.graphics.g2d.Gdx2DPixmap(inputStream, i);
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    private static native java.nio.ByteBuffer newPixmap(long[] jArr, int i, int i2, int i3);

    private static native void setBlend(long j, int i);

    private static native void setPixel(long j, int i, int i2, int i3);

    private static native void setScale(long j, int i);

    public static int toGlFormat(int i) {
        switch (i) {
            case 1:
                return com.badlogic.gdx.graphics.GL20.GL_ALPHA;
            case 2:
                return com.badlogic.gdx.graphics.GL20.GL_LUMINANCE_ALPHA;
            case 3:
            case 5:
                return com.badlogic.gdx.graphics.GL20.GL_RGB;
            case 4:
            case 6:
                return com.badlogic.gdx.graphics.GL20.GL_RGBA;
            default:
                throw new com.badlogic.gdx.utils.GdxRuntimeException("unknown format: " + i);
        }
    }

    public static int toGlType(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                return com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE;
            case 5:
                return com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_SHORT_5_6_5;
            case 6:
                return com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_SHORT_4_4_4_4;
            default:
                throw new com.badlogic.gdx.utils.GdxRuntimeException("unknown format: " + i);
        }
    }

    public final void a(int i) {
        com.badlogic.gdx.graphics.g2d.Gdx2DPixmap gdx2DPixmap = new com.badlogic.gdx.graphics.g2d.Gdx2DPixmap(this.b, this.c, i);
        gdx2DPixmap.drawPixmap(this, 0, 0, 0, 0, this.b, this.c);
        dispose();
        this.a = gdx2DPixmap.a;
        this.d = gdx2DPixmap.d;
        this.c = gdx2DPixmap.c;
        this.f = gdx2DPixmap.f;
        this.e = gdx2DPixmap.e;
        this.b = gdx2DPixmap.b;
    }

    public void clear(int i) {
        clear(this.a, i);
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public void dispose() {
        free(this.a);
    }

    public void drawCircle(int i, int i2, int i3, int i4) {
        drawCircle(this.a, i, i2, i3, i4);
    }

    public void drawLine(int i, int i2, int i3, int i4, int i5) {
        drawLine(this.a, i, i2, i3, i4, i5);
    }

    public void drawPixmap(com.badlogic.gdx.graphics.g2d.Gdx2DPixmap gdx2DPixmap, int i, int i2, int i3, int i4, int i5, int i6) {
        drawPixmap(gdx2DPixmap.a, this.a, i, i2, i5, i6, i3, i4, i5, i6);
    }

    public void drawPixmap(com.badlogic.gdx.graphics.g2d.Gdx2DPixmap gdx2DPixmap, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        drawPixmap(gdx2DPixmap.a, this.a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void drawRect(int i, int i2, int i3, int i4, int i5) {
        drawRect(this.a, i, i2, i3, i4, i5);
    }

    public void fillCircle(int i, int i2, int i3, int i4) {
        fillCircle(this.a, i, i2, i3, i4);
    }

    public void fillRect(int i, int i2, int i3, int i4, int i5) {
        fillRect(this.a, i, i2, i3, i4, i5);
    }

    public void fillTriangle(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        fillTriangle(this.a, i, i2, i3, i4, i5, i6, i7);
    }

    public int getFormat() {
        return this.d;
    }

    public java.lang.String getFormatString() {
        switch (this.d) {
            case 1:
                return "alpha";
            case 2:
                return "luminance alpha";
            case 3:
                return "rgb888";
            case 4:
                return "rgba8888";
            case 5:
                return "rgb565";
            case 6:
                return "rgba4444";
            default:
                return "unknown";
        }
    }

    public int getGLFormat() {
        return getGLInternalFormat();
    }

    public int getGLInternalFormat() {
        return toGlFormat(this.d);
    }

    public int getGLType() {
        return toGlType(this.d);
    }

    public int getHeight() {
        return this.c;
    }

    public int getPixel(int i, int i2) {
        return getPixel(this.a, i, i2);
    }

    public java.nio.ByteBuffer getPixels() {
        return this.e;
    }

    public int getWidth() {
        return this.b;
    }

    public void setBlend(int i) {
        setBlend(this.a, i);
    }

    public void setPixel(int i, int i2, int i3) {
        setPixel(this.a, i, i2, i3);
    }

    public void setScale(int i) {
        setScale(this.a, i);
    }
}
