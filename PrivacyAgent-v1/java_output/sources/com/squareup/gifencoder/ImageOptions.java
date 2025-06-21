package com.squareup.gifencoder;

/* loaded from: classes19.dex */
public final class ImageOptions {
    public int a = 0;
    public int b = 0;
    public com.squareup.gifencoder.ColorQuantizer c = com.squareup.gifencoder.MedianCutQuantizer.INSTANCE;
    public com.squareup.gifencoder.Ditherer d = com.squareup.gifencoder.FloydSteinbergDitherer.INSTANCE;
    public com.squareup.gifencoder.DisposalMethod e = com.squareup.gifencoder.DisposalMethod.UNSPECIFIED;
    public int f = 0;

    public com.squareup.gifencoder.ImageOptions setColorQuantizer(com.squareup.gifencoder.ColorQuantizer colorQuantizer) {
        this.c = colorQuantizer;
        return this;
    }

    public com.squareup.gifencoder.ImageOptions setDelay(long j, java.util.concurrent.TimeUnit timeUnit) {
        this.f = (int) (timeUnit.toMillis(j) / 10);
        return this;
    }

    public com.squareup.gifencoder.ImageOptions setDisposalMethod(com.squareup.gifencoder.DisposalMethod disposalMethod) {
        this.e = disposalMethod;
        return this;
    }

    public com.squareup.gifencoder.ImageOptions setDitherer(com.squareup.gifencoder.Ditherer ditherer) {
        this.d = ditherer;
        return this;
    }

    public com.squareup.gifencoder.ImageOptions setLeft(int i) {
        this.a = i;
        return this;
    }

    public com.squareup.gifencoder.ImageOptions setTop(int i) {
        this.b = i;
        return this;
    }
}
