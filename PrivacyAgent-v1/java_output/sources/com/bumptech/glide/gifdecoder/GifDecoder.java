package com.bumptech.glide.gifdecoder;

/* loaded from: classes.dex */
public interface GifDecoder {
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    public static final int TOTAL_ITERATION_COUNT_FOREVER = 0;

    public interface BitmapProvider {
        @androidx.annotation.NonNull
        android.graphics.Bitmap obtain(int i, int i2, @androidx.annotation.NonNull android.graphics.Bitmap.Config config);

        @androidx.annotation.NonNull
        byte[] obtainByteArray(int i);

        @androidx.annotation.NonNull
        int[] obtainIntArray(int i);

        void release(@androidx.annotation.NonNull android.graphics.Bitmap bitmap);

        void release(@androidx.annotation.NonNull byte[] bArr);

        void release(@androidx.annotation.NonNull int[] iArr);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface GifDecodeStatus {
    }

    void advance();

    void clear();

    int getByteSize();

    int getCurrentFrameIndex();

    @androidx.annotation.NonNull
    java.nio.ByteBuffer getData();

    int getDelay(int i);

    int getFrameCount();

    int getHeight();

    @java.lang.Deprecated
    int getLoopCount();

    int getNetscapeLoopCount();

    int getNextDelay();

    @androidx.annotation.Nullable
    android.graphics.Bitmap getNextFrame();

    int getStatus();

    int getTotalIterationCount();

    int getWidth();

    int read(@androidx.annotation.Nullable java.io.InputStream inputStream, int i);

    int read(@androidx.annotation.Nullable byte[] bArr);

    void resetFrameIndex();

    void setData(@androidx.annotation.NonNull com.bumptech.glide.gifdecoder.GifHeader gifHeader, @androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer);

    void setData(@androidx.annotation.NonNull com.bumptech.glide.gifdecoder.GifHeader gifHeader, @androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, int i);

    void setData(@androidx.annotation.NonNull com.bumptech.glide.gifdecoder.GifHeader gifHeader, @androidx.annotation.NonNull byte[] bArr);

    void setDefaultBitmapConfig(@androidx.annotation.NonNull android.graphics.Bitmap.Config config);
}
