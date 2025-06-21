package cn.shuzilm.core;

/* loaded from: classes.dex */
class b implements android.hardware.SensorEventListener {
    final /* synthetic */ android.content.Context a;
    final /* synthetic */ android.hardware.SensorManager b;
    final /* synthetic */ cn.shuzilm.core.DUHelper c;

    public b(cn.shuzilm.core.DUHelper dUHelper, android.content.Context context, android.hardware.SensorManager sensorManager) {
        this.c = dUHelper;
        this.a = context;
        this.b = sensorManager;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
        try {
            float[] fArr = sensorEvent.values;
            sensorEvent.sensor.getType();
            for (float f : fArr) {
            }
            cn.shuzilm.core.DUHelper.onSensorChanged(this.a, sensorEvent);
        } catch (java.lang.UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
        this.b.unregisterListener(this);
    }
}
