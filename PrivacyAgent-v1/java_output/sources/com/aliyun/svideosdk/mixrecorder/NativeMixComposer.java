package com.aliyun.svideosdk.mixrecorder;

@com.aliyun.svideosdk.conan.DoNotProguard
/* loaded from: classes12.dex */
public class NativeMixComposer {
    private long a;

    public NativeMixComposer(boolean z, long j) {
        this.a = 0L;
        this.a = nativeCreate(z, j);
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int nativeAddStream(long j, java.lang.String str, int i, long j2, long j3, int i2);

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int nativeCancelMix(long j);

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int nativeConfigOutputParam(long j, java.lang.String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int[] iArr, int i10, int[] iArr2, int i11);

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int nativeConfigTrackBorder(long j, int i, float f, int i2, float f2);

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native long nativeCreate(boolean z, long j);

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int nativeCreateTrack(long j, float f, float f2, float f3, float f4, boolean z);

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int nativePauseMix(long j);

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int nativeRelease(long j);

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int nativeResumeMix(long j);

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int nativeSetFillBackgroundBitmap(long j, android.graphics.Bitmap bitmap);

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int nativeSetFillBackgroundColor(long j, long j2);

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int nativeSetFillBackgroundDisplayMode(long j, int i);

    @com.aliyun.svideosdk.conan.DoNotProguard
    private native int nativeStartMix(long j, java.lang.Object obj);

    public int a() {
        long j = this.a;
        if (j != 0) {
            return nativeCancelMix(j);
        }
        return -4;
    }

    public int a(float f, float f2, float f3, float f4, boolean z) {
        long j = this.a;
        if (j != 0) {
            return nativeCreateTrack(j, f, f2, f3, f4, z);
        }
        return -4;
    }

    public int a(int i) {
        long j = this.a;
        if (j != 0) {
            return nativeSetFillBackgroundColor(j, i);
        }
        return -4;
    }

    public int a(int i, float f, int i2, float f2) {
        long j = this.a;
        if (j != 0) {
            return nativeConfigTrackBorder(j, i, f, i2, f2);
        }
        return -4;
    }

    public int a(android.graphics.Bitmap bitmap) {
        long j = this.a;
        if (j != 0) {
            return nativeSetFillBackgroundBitmap(j, bitmap);
        }
        return -4;
    }

    public int a(com.aliyun.svideosdk.mixrecorder.AliyunMixCallback aliyunMixCallback) {
        long j = this.a;
        if (j != 0) {
            return nativeStartMix(j, aliyunMixCallback);
        }
        return -4;
    }

    public int a(java.lang.String str) {
        if (this.a == 0) {
            return -4;
        }
        if (new java.io.File(str).exists()) {
            return nativeSetFillBackgroundBitmap(this.a, android.graphics.BitmapFactory.decodeFile(str));
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Video file[");
        sb.append(str);
        sb.append("] not exist!");
        return -20003002;
    }

    public int a(java.lang.String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int[] iArr, int i10, int[] iArr2, int i11) {
        long j = this.a;
        if (j != 0) {
            return nativeConfigOutputParam(j, str, i, i2, i3, i4, i5, i6, i7, i8, i9, iArr, i10, iArr2, i11);
        }
        return -4;
    }

    public int a(java.lang.String str, int i, long j, long j2, int i2) {
        if (this.a == 0) {
            return -4;
        }
        if (new java.io.File(str).exists()) {
            return nativeAddStream(this.a, str, i, j, j2, i2);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Video file[");
        sb.append(str);
        sb.append("] not exist!");
        return -20003002;
    }

    public int b() {
        long j = this.a;
        if (j != 0) {
            return nativePauseMix(j);
        }
        return -4;
    }

    public int b(int i) {
        long j = this.a;
        if (j != 0) {
            return nativeSetFillBackgroundDisplayMode(j, i);
        }
        return -4;
    }

    public int c() {
        long j = this.a;
        if (j == 0) {
            return -4;
        }
        int nativeRelease = nativeRelease(j);
        this.a = 0L;
        return nativeRelease;
    }

    public int d() {
        long j = this.a;
        if (j != 0) {
            return nativeResumeMix(j);
        }
        return -4;
    }
}
