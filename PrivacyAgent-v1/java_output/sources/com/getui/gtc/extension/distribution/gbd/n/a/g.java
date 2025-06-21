package com.getui.gtc.extension.distribution.gbd.n.a;

/* loaded from: classes22.dex */
public final class g {
    private static final java.lang.String c = "GBD_SCM";
    java.util.HashSet<com.getui.gtc.extension.distribution.gbd.n.a.g.c> a;
    boolean b;
    private java.util.Timer d;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.a.g$1, reason: invalid class name */
    public class AnonymousClass1 extends java.util.TimerTask {
        final /* synthetic */ com.getui.gtc.extension.distribution.gbd.n.a.g.b a;

        public AnonymousClass1(com.getui.gtc.extension.distribution.gbd.n.a.g.b bVar) {
            this.a = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            try {
                com.getui.gtc.extension.distribution.gbd.n.a.g.b bVar = this.a;
                if (bVar != null) {
                    bVar.a();
                }
                com.getui.gtc.extension.distribution.gbd.n.a.g.this.b = true;
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.a.g$2, reason: invalid class name */
    public class AnonymousClass2 implements android.hardware.SensorEventListener {
        float a = -1.0f;
        final /* synthetic */ com.getui.gtc.extension.distribution.gbd.n.a.g.c b;

        public AnonymousClass2(com.getui.gtc.extension.distribution.gbd.n.a.g.c cVar) {
            this.b = cVar;
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
            try {
                float f = this.a;
                if (f != -1.0f && f != sensorEvent.values[0]) {
                    this.b.c = true;
                }
                this.a = sensorEvent.values[0];
            } catch (java.lang.Exception e) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.a.g$3, reason: invalid class name */
    public class AnonymousClass3 extends java.util.TimerTask {
        final /* synthetic */ android.hardware.SensorManager a;
        final /* synthetic */ android.hardware.SensorEventListener b;
        final /* synthetic */ com.getui.gtc.extension.distribution.gbd.n.a.g.c c;

        public AnonymousClass3(android.hardware.SensorManager sensorManager, android.hardware.SensorEventListener sensorEventListener, com.getui.gtc.extension.distribution.gbd.n.a.g.c cVar) {
            this.a = sensorManager;
            this.b = sensorEventListener;
            this.c = cVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            try {
                this.a.unregisterListener(this.b);
                com.getui.gtc.extension.distribution.gbd.n.a.g.c cVar = this.c;
                cVar.d = true;
                com.getui.gtc.extension.distribution.gbd.n.a.g.this.a.add(cVar);
            } catch (java.lang.Exception e) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            }
        }
    }

    public static final class a {
        private static final com.getui.gtc.extension.distribution.gbd.n.a.g a = new com.getui.gtc.extension.distribution.gbd.n.a.g((byte) 0);

        private a() {
        }
    }

    public interface b {
        void a();
    }

    public class c {
        int a;
        boolean b;
        boolean c;
        boolean d;

        public c() {
        }

        private static /* synthetic */ boolean e(com.getui.gtc.extension.distribution.gbd.n.a.g.c cVar) {
            cVar.d = true;
            return true;
        }

        private static /* synthetic */ boolean f(com.getui.gtc.extension.distribution.gbd.n.a.g.c cVar) {
            cVar.c = true;
            return true;
        }

        public final boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && com.getui.gtc.extension.distribution.gbd.n.a.g.c.class == obj.getClass() && this.a == ((com.getui.gtc.extension.distribution.gbd.n.a.g.c) obj).a;
        }

        public final int hashCode() {
            return this.a;
        }
    }

    private g() {
        this.a = new java.util.HashSet<>();
        this.d = new java.util.Timer();
    }

    public /* synthetic */ g(byte b2) {
        this();
    }

    public static synchronized com.getui.gtc.extension.distribution.gbd.n.a.g a() {
        com.getui.gtc.extension.distribution.gbd.n.a.g gVar;
        synchronized (com.getui.gtc.extension.distribution.gbd.n.a.g.class) {
            gVar = com.getui.gtc.extension.distribution.gbd.n.a.g.a.a;
        }
        return gVar;
    }

    private synchronized void a(android.content.Context context) {
        android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) context.getSystemService(com.umeng.analytics.pro.bo.ac);
        if (sensorManager == null) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(c, "s manager is null");
            return;
        }
        a(sensorManager, 5);
        a(sensorManager, 2);
        a(sensorManager, 1);
    }

    private void a(android.hardware.SensorManager sensorManager, int i) {
        try {
            com.getui.gtc.extension.distribution.gbd.n.a.g.c cVar = new com.getui.gtc.extension.distribution.gbd.n.a.g.c();
            cVar.a = i;
            android.hardware.Sensor defaultSensor = sensorManager.getDefaultSensor(i);
            if (defaultSensor == null) {
                cVar.b = false;
                cVar.d = true;
            } else {
                cVar.b = true;
                com.getui.gtc.extension.distribution.gbd.n.a.g.AnonymousClass2 anonymousClass2 = new com.getui.gtc.extension.distribution.gbd.n.a.g.AnonymousClass2(cVar);
                sensorManager.registerListener(anonymousClass2, defaultSensor, 0);
                this.d.schedule(new com.getui.gtc.extension.distribution.gbd.n.a.g.AnonymousClass3(sensorManager, anonymousClass2, cVar), 500L);
            }
            this.a.add(cVar);
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
        }
    }

    private static /* synthetic */ boolean a(com.getui.gtc.extension.distribution.gbd.n.a.g gVar) {
        gVar.b = true;
        return true;
    }

    private org.json.JSONArray c() {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.a.g.c> it = this.a.iterator();
        while (it.hasNext()) {
            com.getui.gtc.extension.distribution.gbd.n.a.g.c next = it.next();
            if (next.d) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("type", next.a);
                    jSONObject.put("enable", next.b);
                    jSONObject.put("valueChanged", next.c);
                    jSONArray.put(jSONObject);
                } catch (org.json.JSONException e) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e);
                }
            }
        }
        return jSONArray;
    }

    private java.util.HashSet<com.getui.gtc.extension.distribution.gbd.n.a.g.c> d() {
        return this.a;
    }

    private boolean e() {
        return this.b;
    }

    public final synchronized void a(android.content.Context context, com.getui.gtc.extension.distribution.gbd.n.a.g.b bVar) {
        a(context);
        this.d.schedule(new com.getui.gtc.extension.distribution.gbd.n.a.g.AnonymousClass1(bVar), 700L);
    }

    public final boolean b() {
        boolean z;
        if (this.a.isEmpty()) {
            return true;
        }
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.a.g.c> it = this.a.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            com.getui.gtc.extension.distribution.gbd.n.a.g.c next = it.next();
            if (next.b) {
                z2 = false;
            }
            if (!next.d || next.c) {
                z = false;
                break;
            }
        }
        z = true;
        return z2 || z;
    }
}
