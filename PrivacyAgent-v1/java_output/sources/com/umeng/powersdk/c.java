package com.umeng.powersdk;

/* loaded from: classes19.dex */
public final class c {
    int a;
    int b;
    int c;
    java.lang.ref.WeakReference<android.app.Activity> d;
    boolean e;
    int f;
    boolean g;

    /* renamed from: com.umeng.powersdk.c$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        final /* synthetic */ android.os.HandlerThread a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(android.os.Looper looper, android.os.HandlerThread handlerThread) {
            super(looper);
            this.a = handlerThread;
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            if (message.what == com.umeng.powersdk.c.this.a) {
                try {
                    this.a.quit();
                } catch (java.lang.Throwable unused) {
                }
            }
        }
    }

    /* renamed from: com.umeng.powersdk.c$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.os.Handler a;

        public AnonymousClass2(android.os.Handler handler) {
            this.a = handler;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.umeng.powersdk.c cVar = com.umeng.powersdk.c.this;
                android.os.Handler handler = this.a;
                int i = cVar.b;
                handler.post(cVar.new AnonymousClass3(android.os.SystemClock.elapsedRealtime(), cVar.c, handler, i));
            } catch (java.lang.Throwable unused) {
                this.a.sendEmptyMessage(com.umeng.powersdk.c.this.a);
            }
        }
    }

    /* renamed from: com.umeng.powersdk.c$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ int b;
        final /* synthetic */ android.os.Handler c;
        final /* synthetic */ int d;

        public AnonymousClass3(long j, int i, android.os.Handler handler, int i2) {
            this.a = j;
            this.b = i;
            this.c = handler;
            this.d = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.umeng.powersdk.c.this.e) {
                if (android.os.SystemClock.elapsedRealtime() - this.a > this.b * 1000) {
                    this.c.sendEmptyMessage(com.umeng.powersdk.c.this.a);
                    return;
                }
                try {
                    com.efs.sdk.base.protocol.record.EfsJSONLog efsJSONLog = new com.efs.sdk.base.protocol.record.EfsJSONLog("powerperf");
                    efsJSONLog.put("power", com.umeng.powersdk.c.this.a());
                    com.efs.sdk.base.EfsReporter reporter = com.umeng.powersdk.PowerManager.getReporter();
                    if (reporter != null) {
                        reporter.send(efsJSONLog);
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
            this.c.postDelayed(this, this.d * 1000);
        }
    }

    public static class a {
        private static final com.umeng.powersdk.c a = new com.umeng.powersdk.c((byte) 0);
    }

    private c() {
        this.a = 1;
        this.b = 0;
        this.c = 0;
        this.e = true;
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    public final org.json.JSONObject a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            android.os.BatteryManager batteryManager = (android.os.BatteryManager) com.umeng.powersdk.PowerManager.getApplicationContext().getSystemService("batterymanager");
            if (batteryManager != null) {
                float longProperty = batteryManager.getLongProperty(2);
                if (longProperty >= 10000.0f || longProperty <= -10000.0f) {
                    longProperty /= 1000.0f;
                }
                jSONObject.put("ci", java.lang.Math.abs(longProperty));
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            com.umeng.powersdk.a a2 = com.umeng.powersdk.b.a(com.umeng.powersdk.PowerManager.getApplicationContext()).a();
            jSONObject.put("le", a2.a);
            jSONObject.put("vo", a2.b);
            jSONObject.put("te", a2.c);
            jSONObject.put("st", a2.d);
            jSONObject.put(com.aliyun.common.log.struct.AliyunLogKey.KEY_CROP_HEIGHT, a2.e);
            jSONObject.put("ts", a2.f);
            try {
                long longValue = ((java.lang.Long) com.efs.sdk.base.core.config.GlobalInfoManager.getInstance().getGlobalInfo().getGlobalInfoMap().get("stime")).longValue();
                if (longValue > 0) {
                    jSONObject.put("ptime", java.lang.System.currentTimeMillis() - longValue);
                }
            } catch (java.lang.Throwable unused2) {
            }
            java.lang.ref.WeakReference<android.app.Activity> weakReference = this.d;
            if (weakReference != null) {
                jSONObject.put("c_act", weakReference.get().getClass().getName());
            }
        } catch (java.lang.Throwable unused3) {
        }
        return jSONObject;
    }
}
