package com.jd.ad.sdk.bl.dynamicrender;

/* loaded from: classes23.dex */
public abstract class ShakeListener implements android.hardware.SensorEventListener, android.os.Handler.Callback {
    public android.hardware.SensorManager jad_an;
    public float jad_bo;
    public float[] jad_cp;
    public final float[] jad_dq;
    public boolean jad_er;
    public float jad_fs;
    public java.util.List<java.lang.Long> jad_hu;
    public java.util.List<java.lang.Long> jad_iv;
    public float jad_jt;
    public long jad_jw;
    public long jad_kx;
    public android.os.Handler jad_ly;
    public long jad_mz;

    public ShakeListener(android.content.Context context) {
        this.jad_bo = 0.0f;
        this.jad_cp = new float[4];
        this.jad_dq = new float[4];
        this.jad_er = false;
        this.jad_fs = 0.0f;
        this.jad_jt = 0.0f;
        this.jad_hu = new java.util.ArrayList();
        this.jad_iv = new java.util.ArrayList();
        this.jad_jw = 0L;
        this.jad_mz = 0L;
        try {
            this.jad_an = (android.hardware.SensorManager) context.getSystemService(com.umeng.analytics.pro.bo.ac);
        } catch (java.lang.SecurityException e) {
            e.printStackTrace();
        }
    }

    public ShakeListener(android.content.Context context, float f, float f2, float f3) {
        this.jad_bo = 0.0f;
        this.jad_cp = new float[4];
        this.jad_dq = new float[4];
        this.jad_er = false;
        this.jad_fs = 0.0f;
        this.jad_jt = 0.0f;
        this.jad_hu = new java.util.ArrayList();
        this.jad_iv = new java.util.ArrayList();
        this.jad_jw = 0L;
        this.jad_mz = 0L;
        try {
            this.jad_an = (android.hardware.SensorManager) context.getSystemService(com.umeng.analytics.pro.bo.ac);
            this.jad_bo = f;
            this.jad_fs = f2;
            this.jad_jt = f3;
        } catch (java.lang.SecurityException e) {
            e.printStackTrace();
        }
    }

    public ShakeListener(android.content.Context context, float f, float f2, float f3, boolean z) {
        this.jad_bo = 0.0f;
        this.jad_cp = new float[4];
        this.jad_dq = new float[4];
        this.jad_er = false;
        this.jad_fs = 0.0f;
        this.jad_jt = 0.0f;
        this.jad_hu = new java.util.ArrayList();
        this.jad_iv = new java.util.ArrayList();
        this.jad_jw = 0L;
        this.jad_mz = 0L;
        try {
            this.jad_an = (android.hardware.SensorManager) context.getSystemService(com.umeng.analytics.pro.bo.ac);
            this.jad_bo = f;
            this.jad_fs = f2;
            this.jad_jt = f3;
        } catch (java.lang.SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@androidx.annotation.NonNull android.os.Message message) {
        jad_an();
        return true;
    }

    public final void jad_an() {
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (currentTimeMillis - this.jad_mz <= 2000.0d) {
                return;
            }
            this.jad_mz = currentTimeMillis;
            boolean jad_an = jad_an(this.jad_hu);
            boolean jad_an2 = jad_an(this.jad_iv);
            float f = this.jad_fs;
            if (f > 0.0f && this.jad_bo > 0.0f) {
                if (jad_an && jad_an2) {
                    jad_an = true;
                }
                jad_an = false;
            } else if (f > 0.0f) {
                jad_an = jad_an2;
            } else {
                if (this.jad_bo > 0.0f) {
                }
                jad_an = false;
            }
            if (!jad_an) {
                jad_dq();
            } else {
                onShake();
                jad_dq();
            }
        } catch (java.lang.Exception e) {
            jad_dq();
            e.printStackTrace();
        }
    }

    public final boolean jad_an(java.util.List<java.lang.Long> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        if (this.jad_jt == 0.0f) {
            return true;
        }
        if (list.size() < 2) {
            return false;
        }
        int size = list.size();
        double longValue = list.get(0).longValue();
        int i = size - 1;
        double longValue2 = list.get(i).longValue();
        if (longValue2 - longValue <= 0.0d) {
            return false;
        }
        double d = 0.0d;
        for (int i2 = 1; i2 < size; i2++) {
            double longValue3 = list.get(i2).longValue() - list.get(i2 - 1).longValue();
            if (longValue3 < 0.0d) {
                return false;
            }
            d += longValue3;
        }
        double d2 = i;
        return d / d2 <= ((double) (this.jad_jt * 1000.0f)) / d2 && ((double) java.lang.System.currentTimeMillis()) - longValue2 < 1500.0d;
    }

    public final synchronized void jad_bo() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (this.jad_jt > 0.0f) {
            if (currentTimeMillis - this.jad_jw > 1500.0d) {
                this.jad_hu = new java.util.ArrayList();
                this.jad_iv = new java.util.ArrayList();
                jad_dq();
            }
            android.os.Handler handler = this.jad_ly;
            if (handler == null) {
                if (handler == null) {
                    this.jad_ly = new android.os.Handler(android.os.Looper.getMainLooper(), this);
                }
                android.os.Handler handler2 = this.jad_ly;
                if (handler2 != null) {
                    handler2.sendEmptyMessageDelayed(1, (long) (this.jad_jt * 1000.0f));
                }
            }
        }
        this.jad_jw = currentTimeMillis;
        if (this.jad_hu == null) {
            this.jad_hu = new java.util.ArrayList();
        }
        this.jad_hu.add(java.lang.Long.valueOf(currentTimeMillis));
        if (this.jad_jt == 0.0f) {
            jad_an();
        }
    }

    public final synchronized void jad_cp() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (this.jad_jt > 0.0f) {
            if (currentTimeMillis - this.jad_kx > 1500.0d) {
                this.jad_iv = new java.util.ArrayList();
                this.jad_hu = new java.util.ArrayList();
                jad_dq();
            }
            android.os.Handler handler = this.jad_ly;
            if (handler == null) {
                if (handler == null) {
                    this.jad_ly = new android.os.Handler(android.os.Looper.getMainLooper(), this);
                }
                android.os.Handler handler2 = this.jad_ly;
                if (handler2 != null) {
                    handler2.sendEmptyMessageDelayed(1, (long) (this.jad_jt * 1000.0f));
                }
            }
        }
        this.jad_kx = currentTimeMillis;
        if (this.jad_iv == null) {
            this.jad_iv = new java.util.ArrayList();
        }
        this.jad_iv.add(java.lang.Long.valueOf(currentTimeMillis));
        if (this.jad_jt == 0.0f) {
            jad_an();
        }
    }

    public final void jad_dq() {
        android.os.Handler handler = this.jad_ly;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.jad_ly = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() == 1) {
                if (this.jad_bo > 0.0f) {
                    float[] fArr = sensorEvent.values;
                    if (java.lang.Math.sqrt(java.lang.Math.pow(fArr[0], 2.0d) + java.lang.Math.pow(fArr[1], 2.0d) + java.lang.Math.pow(fArr[2], 2.0d)) > this.jad_bo) {
                        jad_bo();
                    }
                }
            } else if (sensorEvent.sensor.getType() == 11 && this.jad_fs > 0.0f) {
                float[] fArr2 = sensorEvent.values;
                float[] fArr3 = this.jad_dq;
                java.lang.System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
                if (this.jad_er) {
                    float[] fArr4 = new float[4];
                    android.hardware.SensorManager.getQuaternionFromVector(fArr4, this.jad_cp);
                    float[] fArr5 = new float[4];
                    android.hardware.SensorManager.getQuaternionFromVector(fArr5, this.jad_dq);
                    float f = fArr4[0];
                    float f2 = fArr5[0];
                    float f3 = fArr4[1];
                    float f4 = fArr5[1];
                    float f5 = fArr4[2];
                    float f6 = fArr5[2];
                    float f7 = f5 * f6;
                    float f8 = fArr4[3] * fArr5[3];
                    if (this.jad_fs <= java.lang.Math.toDegrees(java.lang.Math.acos(java.lang.Math.min(java.lang.Math.max(((f8 + (f7 + ((f3 * f4) + (f * f2)))) * (((r9 * r11) + ((f5 * f6) + ((f3 * f4) + (f * f2)))) * 2.0f)) - 1.0f, -1.0d), 1.0d)))) {
                        this.jad_cp = fArr4;
                        jad_cp();
                    }
                } else {
                    float[] fArr6 = this.jad_dq;
                    java.lang.System.arraycopy(fArr6, 0, this.jad_cp, 0, fArr6.length);
                    this.jad_er = true;
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void onShake();

    public void register() {
        try {
            android.hardware.SensorManager sensorManager = this.jad_an;
            if (sensorManager != null) {
                sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 2);
                android.hardware.SensorManager sensorManager2 = this.jad_an;
                sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(11), 3);
            }
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.w("Exception while register shake listener: " + e, new java.lang.Object[0]);
        }
    }

    public void unregister() {
        jad_dq();
        android.hardware.SensorManager sensorManager = this.jad_an;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }
}
