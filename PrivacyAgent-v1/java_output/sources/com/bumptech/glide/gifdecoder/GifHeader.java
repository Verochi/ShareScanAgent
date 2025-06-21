package com.bumptech.glide.gifdecoder;

/* loaded from: classes.dex */
public class GifHeader {
    public static final int NETSCAPE_LOOP_COUNT_DOES_NOT_EXIST = -1;
    public static final int NETSCAPE_LOOP_COUNT_FOREVER = 0;

    @androidx.annotation.ColorInt
    int bgColor;
    int bgIndex;
    com.bumptech.glide.gifdecoder.GifFrame currentFrame;
    boolean gctFlag;
    int gctSize;
    int height;
    int pixelAspect;
    int width;

    @androidx.annotation.ColorInt
    int[] gct = null;
    int status = 0;
    int frameCount = 0;
    final java.util.List<com.bumptech.glide.gifdecoder.GifFrame> frames = new java.util.ArrayList();
    int loopCount = -1;

    public int getHeight() {
        return this.height;
    }

    public int getNumFrames() {
        return this.frameCount;
    }

    public int getStatus() {
        return this.status;
    }

    public int getWidth() {
        return this.width;
    }
}
