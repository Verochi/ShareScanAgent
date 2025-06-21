package com.anythink.expressad.shake;

/* loaded from: classes12.dex */
public class a {
    private static volatile com.anythink.expressad.shake.a c;
    android.hardware.Sensor a;
    private android.hardware.SensorManager b;

    private a() {
        android.content.Context f = com.anythink.core.common.b.o.a().f();
        if (f != null) {
            try {
                if (this.b == null) {
                    this.b = (android.hardware.SensorManager) f.getSystemService(com.umeng.analytics.pro.bo.ac);
                }
                if (this.a == null) {
                    this.a = this.b.getDefaultSensor(1);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static com.anythink.expressad.shake.a a() {
        if (c == null) {
            synchronized (com.anythink.expressad.shake.a.class) {
                if (c == null) {
                    c = new com.anythink.expressad.shake.a();
                }
            }
        }
        return c;
    }

    public final void a(android.hardware.SensorEventListener sensorEventListener) {
        try {
            this.b.registerListener(sensorEventListener, this.a, 2);
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void b(android.hardware.SensorEventListener sensorEventListener) {
        android.hardware.SensorManager sensorManager = this.b;
        if (sensorManager != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public final boolean b() {
        return this.a != null;
    }
}
