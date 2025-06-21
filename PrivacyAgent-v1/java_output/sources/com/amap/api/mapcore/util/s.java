package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class s implements android.hardware.SensorEventListener {
    private android.hardware.SensorManager a;
    private android.hardware.Sensor b;
    private float d;
    private android.content.Context e;
    private com.autonavi.base.amap.api.mapcore.IAMapDelegate f;
    private com.amap.api.maps.model.Marker g;
    private long c = 0;
    private boolean h = true;

    /* renamed from: com.amap.api.mapcore.util.s$1, reason: invalid class name */
    public class AnonymousClass1 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ android.hardware.SensorEvent a;

        public AnonymousClass1(android.hardware.SensorEvent sensorEvent) {
            this.a = sensorEvent;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            if (this.a.sensor.getType() != 3) {
                return;
            }
            float a = (this.a.values[0] + com.amap.api.mapcore.util.s.a(com.amap.api.mapcore.util.s.this.e)) % 360.0f;
            if (a > 180.0f) {
                a -= 360.0f;
            } else if (a < -180.0f) {
                a += 360.0f;
            }
            if (java.lang.Math.abs(com.amap.api.mapcore.util.s.this.d - a) >= 3.0f) {
                com.amap.api.mapcore.util.s sVar = com.amap.api.mapcore.util.s.this;
                if (java.lang.Float.isNaN(a)) {
                    a = 0.0f;
                }
                sVar.d = a;
                if (com.amap.api.mapcore.util.s.this.g != null) {
                    try {
                        if (com.amap.api.mapcore.util.s.this.h) {
                            com.amap.api.mapcore.util.s.this.f.moveCamera(com.amap.api.mapcore.util.z.d(com.amap.api.mapcore.util.s.this.d));
                            com.amap.api.mapcore.util.s.this.g.setRotateAngle(-com.amap.api.mapcore.util.s.this.d);
                        } else {
                            com.amap.api.mapcore.util.s.this.g.setRotateAngle(360.0f - com.amap.api.mapcore.util.s.this.d);
                        }
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                }
                com.amap.api.mapcore.util.s.this.c = java.lang.System.currentTimeMillis();
            }
        }
    }

    public s(android.content.Context context, com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate) {
        this.e = context.getApplicationContext();
        this.f = iAMapDelegate;
        try {
            android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) context.getSystemService(com.umeng.analytics.pro.bo.ac);
            this.a = sensorManager;
            if (sensorManager != null) {
                this.b = sensorManager.getDefaultSensor(3);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static int a(android.content.Context context) {
        android.view.WindowManager windowManager;
        if (context == null || (windowManager = (android.view.WindowManager) context.getSystemService("window")) == null) {
            return 0;
        }
        try {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            if (rotation == 1) {
                return 90;
            }
            if (rotation != 2) {
                return rotation != 3 ? 0 : -90;
            }
            return 180;
        } catch (java.lang.Throwable unused) {
            return 0;
        }
    }

    public final void a() {
        android.hardware.Sensor sensor;
        android.hardware.SensorManager sensorManager = this.a;
        if (sensorManager == null || (sensor = this.b) == null) {
            return;
        }
        sensorManager.registerListener(this, sensor, 3);
    }

    public final void a(com.amap.api.maps.model.Marker marker) {
        this.g = marker;
    }

    public final void a(boolean z) {
        this.h = z;
    }

    public final void b() {
        android.hardware.Sensor sensor;
        android.hardware.SensorManager sensorManager = this.a;
        if (sensorManager == null || (sensor = this.b) == null) {
            return;
        }
        sensorManager.unregisterListener(this, sensor);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
        try {
            if (java.lang.System.currentTimeMillis() - this.c < 100) {
                return;
            }
            if (this.f.getGLMapEngine() == null || this.f.getGLMapEngine().getAnimateionsCount() <= 0) {
                com.amap.api.mapcore.util.dj.a().a(new com.amap.api.mapcore.util.s.AnonymousClass1(sensorEvent));
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
