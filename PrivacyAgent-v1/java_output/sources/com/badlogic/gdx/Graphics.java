package com.badlogic.gdx;

/* loaded from: classes12.dex */
public interface Graphics {

    public static class BufferFormat {
        public final int a;
        public final int b;
        public final boolean coverageSampling;
        public final int depth;
        public final int g;
        public final int r;
        public final int samples;
        public final int stencil;

        public BufferFormat(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
            this.r = i;
            this.g = i2;
            this.b = i3;
            this.a = i4;
            this.depth = i5;
            this.stencil = i6;
            this.samples = i7;
            this.coverageSampling = z;
        }

        public java.lang.String toString() {
            return "r: " + this.r + ", g: " + this.g + ", b: " + this.b + ", a: " + this.a + ", depth: " + this.depth + ", stencil: " + this.stencil + ", num samples: " + this.samples + ", coverage sampling: " + this.coverageSampling;
        }
    }

    public static class DisplayMode {
        public final int bitsPerPixel;
        public final int height;
        public final int refreshRate;
        public final int width;

        public DisplayMode(int i, int i2, int i3, int i4) {
            this.width = i;
            this.height = i2;
            this.refreshRate = i3;
            this.bitsPerPixel = i4;
        }

        public java.lang.String toString() {
            return this.width + "x" + this.height + ", bpp: " + this.bitsPerPixel + ", hz: " + this.refreshRate;
        }
    }

    public enum GraphicsType {
        AndroidGL,
        LWJGL,
        WebGL,
        iOSGL,
        JGLFW,
        Mock,
        LWJGL3
    }

    public static class Monitor {
        public final java.lang.String name;
        public final int virtualX;
        public final int virtualY;

        public Monitor(int i, int i2, java.lang.String str) {
            this.virtualX = i;
            this.virtualY = i2;
            this.name = str;
        }
    }

    int getBackBufferHeight();

    int getBackBufferWidth();

    com.badlogic.gdx.Graphics.BufferFormat getBufferFormat();

    float getDeltaTime();

    float getDensity();

    com.badlogic.gdx.Graphics.DisplayMode getDisplayMode();

    com.badlogic.gdx.Graphics.DisplayMode getDisplayMode(com.badlogic.gdx.Graphics.Monitor monitor);

    com.badlogic.gdx.Graphics.DisplayMode[] getDisplayModes();

    com.badlogic.gdx.Graphics.DisplayMode[] getDisplayModes(com.badlogic.gdx.Graphics.Monitor monitor);

    long getFrameId();

    int getFramesPerSecond();

    com.badlogic.gdx.graphics.GL20 getGL20();

    com.badlogic.gdx.graphics.GL30 getGL30();

    com.badlogic.gdx.graphics.glutils.GLVersion getGLVersion();

    int getHeight();

    com.badlogic.gdx.Graphics.Monitor getMonitor();

    com.badlogic.gdx.Graphics.Monitor[] getMonitors();

    float getPpcX();

    float getPpcY();

    float getPpiX();

    float getPpiY();

    com.badlogic.gdx.Graphics.Monitor getPrimaryMonitor();

    float getRawDeltaTime();

    com.badlogic.gdx.Graphics.GraphicsType getType();

    int getWidth();

    boolean isContinuousRendering();

    boolean isFullscreen();

    boolean isGL30Available();

    com.badlogic.gdx.graphics.Cursor newCursor(com.badlogic.gdx.graphics.Pixmap pixmap, int i, int i2);

    void requestRendering();

    void setContinuousRendering(boolean z);

    void setCursor(com.badlogic.gdx.graphics.Cursor cursor);

    boolean setFullscreenMode(com.badlogic.gdx.Graphics.DisplayMode displayMode);

    void setResizable(boolean z);

    void setSystemCursor(com.badlogic.gdx.graphics.Cursor.SystemCursor systemCursor);

    void setTitle(java.lang.String str);

    void setUndecorated(boolean z);

    void setVSync(boolean z);

    boolean setWindowedMode(int i, int i2);

    boolean supportsDisplayModeChange();

    boolean supportsExtension(java.lang.String str);
}
