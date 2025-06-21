package com.bytedance.pangle.apm;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class ApmUtils {
    public static final int FLAG_ANR_MONITOR = 2;
    public static final int FLAG_JAVA_CRASH = 1;
    public static final int FLAG_NATIVE_CRASH = 4;
    public static final int FLAG_REGISTER_JAVA_CRASH = 8;
    private static volatile com.bytedance.pangle.apm.AbsApm sApm;

    /* renamed from: com.bytedance.pangle.apm.ApmUtils$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.bytedance.pangle.apm.AbsApm {
        @Override // com.bytedance.pangle.apm.AbsApm
        public final java.lang.String getDid() {
            return "0";
        }

        @Override // com.bytedance.pangle.apm.AbsApm
        public final void init() {
        }

        @Override // com.bytedance.pangle.apm.AbsApm
        public final void monitorEvent(java.lang.String str, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, org.json.JSONObject jSONObject3) {
        }

        @Override // com.bytedance.pangle.apm.AbsApm
        public final void reportError(java.lang.String str, @androidx.annotation.NonNull java.lang.Throwable th) {
        }
    }

    public static com.bytedance.pangle.apm.AbsApm getApmInstance() {
        if (sApm == null) {
            synchronized (com.bytedance.pangle.apm.AbsApm.class) {
                if (sApm == null) {
                    sApm = new com.bytedance.pangle.apm.ApmUtils.AnonymousClass1();
                }
            }
        }
        return sApm;
    }

    public static synchronized void register(com.bytedance.pangle.apm.AbsApm absApm) {
        synchronized (com.bytedance.pangle.apm.ApmUtils.class) {
            sApm = absApm;
        }
    }
}
