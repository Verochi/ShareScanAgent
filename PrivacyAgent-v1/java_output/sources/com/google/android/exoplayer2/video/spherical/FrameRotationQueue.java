package com.google.android.exoplayer2.video.spherical;

/* loaded from: classes22.dex */
public final class FrameRotationQueue {
    public final float[] a = new float[16];
    public final float[] b = new float[16];
    public final com.google.android.exoplayer2.util.TimedValueQueue<float[]> c = new com.google.android.exoplayer2.util.TimedValueQueue<>();
    public boolean d;

    public static void a(float[] fArr, float[] fArr2) {
        float f = fArr2[0];
        float f2 = -fArr2[1];
        float f3 = -fArr2[2];
        float length = android.opengl.Matrix.length(f, f2, f3);
        if (length != 0.0f) {
            android.opengl.Matrix.setRotateM(fArr, 0, (float) java.lang.Math.toDegrees(length), f / length, f2 / length, f3 / length);
        } else {
            android.opengl.Matrix.setIdentityM(fArr, 0);
        }
    }

    public static void computeRecenterMatrix(float[] fArr, float[] fArr2) {
        android.opengl.Matrix.setIdentityM(fArr, 0);
        float f = fArr2[10];
        float f2 = fArr2[8];
        float sqrt = (float) java.lang.Math.sqrt((f * f) + (f2 * f2));
        float f3 = fArr2[10];
        fArr[0] = f3 / sqrt;
        float f4 = fArr2[8];
        fArr[2] = f4 / sqrt;
        fArr[8] = (-f4) / sqrt;
        fArr[10] = f3 / sqrt;
    }

    public boolean pollRotationMatrix(float[] fArr, long j) {
        float[] pollFloor = this.c.pollFloor(j);
        if (pollFloor == null) {
            return false;
        }
        a(this.b, pollFloor);
        if (!this.d) {
            computeRecenterMatrix(this.a, this.b);
            this.d = true;
        }
        android.opengl.Matrix.multiplyMM(fArr, 0, this.a, 0, this.b, 0);
        return true;
    }

    public void reset() {
        this.c.clear();
        this.d = false;
    }

    public void setRotation(long j, float[] fArr) {
        this.c.add(j, fArr);
    }
}
