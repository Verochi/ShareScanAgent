package com.google.android.exoplayer2.ui.spherical;

/* loaded from: classes22.dex */
final class OrientationListener implements android.hardware.SensorEventListener {
    public final float[] n = new float[16];
    public final float[] t = new float[16];
    public final float[] u = new float[16];
    public final float[] v = new float[3];
    public final android.view.Display w;
    public final com.google.android.exoplayer2.ui.spherical.OrientationListener.Listener[] x;
    public boolean y;

    public interface Listener {
        void onOrientationChange(float[] fArr, float f);
    }

    public OrientationListener(android.view.Display display, com.google.android.exoplayer2.ui.spherical.OrientationListener.Listener... listenerArr) {
        this.w = display;
        this.x = listenerArr;
    }

    public static void e(float[] fArr) {
        android.opengl.Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    public final float a(float[] fArr) {
        android.hardware.SensorManager.remapCoordinateSystem(fArr, 1, 131, this.t);
        android.hardware.SensorManager.getOrientation(this.t, this.v);
        return this.v[2];
    }

    public final void b(float[] fArr, float f) {
        for (com.google.android.exoplayer2.ui.spherical.OrientationListener.Listener listener : this.x) {
            listener.onOrientationChange(fArr, f);
        }
    }

    public final void c(float[] fArr) {
        if (!this.y) {
            com.google.android.exoplayer2.video.spherical.FrameRotationQueue.computeRecenterMatrix(this.u, fArr);
            this.y = true;
        }
        float[] fArr2 = this.t;
        java.lang.System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        android.opengl.Matrix.multiplyMM(fArr, 0, this.t, 0, this.u, 0);
    }

    public final void d(float[] fArr, int i) {
        if (i != 0) {
            int i2 = 129;
            int i3 = 1;
            if (i == 1) {
                i2 = 2;
                i3 = 129;
            } else if (i == 2) {
                i3 = 130;
            } else {
                if (i != 3) {
                    throw new java.lang.IllegalStateException();
                }
                i2 = 130;
            }
            float[] fArr2 = this.t;
            java.lang.System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            android.hardware.SensorManager.remapCoordinateSystem(this.t, i2, i3, fArr);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    @androidx.annotation.BinderThread
    public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
        android.hardware.SensorManager.getRotationMatrixFromVector(this.n, sensorEvent.values);
        d(this.n, this.w.getRotation());
        float a = a(this.n);
        e(this.n);
        c(this.n);
        b(this.n, a);
    }
}
