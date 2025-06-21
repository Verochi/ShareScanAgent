package com.anythink.expressad.shake;

/* loaded from: classes12.dex */
public abstract class b implements android.hardware.SensorEventListener {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public float d = 0.0f;
    public float e = 0.0f;
    public float f = 0.0f;
    public long g = 0;
    private int h;
    private int i;

    public b(int i, int i2) {
        this.h = i;
        this.i = i2;
    }

    public abstract void a();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
    
        if (java.lang.Math.abs(r10 - r2) > r9.h) goto L14;
     */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        float f = -fArr[0];
        float f2 = -fArr[1];
        float f3 = -fArr[2];
        float f4 = this.d;
        if (f4 == 0.0f || java.lang.Math.abs(f - f4) <= this.h) {
            float f5 = this.e;
            if (f5 == 0.0f || java.lang.Math.abs(f2 - f5) <= this.h) {
                float f6 = this.f;
                if (f6 != 0.0f) {
                }
                this.d = f;
                this.e = f2;
                this.f = f3;
            }
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - this.g > this.i) {
            this.g = currentTimeMillis;
            a();
        }
        this.d = f;
        this.e = f2;
        this.f = f3;
    }
}
