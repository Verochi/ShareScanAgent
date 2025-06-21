package com.efs.sdk.h5pagesdk;

/* loaded from: classes22.dex */
public class H5ConfigMananger {
    private com.efs.sdk.base.EfsReporter b;
    private android.content.Context mContext;
    private final java.lang.String TAG = "H5ConfigMananger";
    private final int a = 0;
    private int c = 0;
    private boolean d = false;

    /* renamed from: com.efs.sdk.h5pagesdk.H5ConfigMananger$1, reason: invalid class name */
    public class AnonymousClass1 implements com.efs.sdk.base.observer.IConfigCallback {
        public AnonymousClass1() {
        }

        @Override // com.efs.sdk.base.observer.IConfigCallback
        public final void onChange(java.util.Map<java.lang.String, java.lang.Object> map) {
            try {
                java.lang.Object obj = map.get("apm_native_h5perf_sampling_rate");
                if (obj != null) {
                    com.efs.sdk.h5pagesdk.H5ConfigMananger.this.c = java.lang.Integer.parseInt(obj.toString());
                    com.efs.sdk.h5pagesdk.H5ConfigMananger h5ConfigMananger = com.efs.sdk.h5pagesdk.H5ConfigMananger.this;
                    h5ConfigMananger.d = com.efs.sdk.h5pagesdk.H5ConfigMananger.a(h5ConfigMananger.c);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.efs.sdk.h5pagesdk.H5ConfigMananger$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String f;

        public AnonymousClass2(java.lang.String str) {
            this.f = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.efs.sdk.h5pagesdk.H5ConfigMananger.this.b == null) {
                return;
            }
            com.efs.sdk.base.protocol.record.EfsJSONLog efsJSONLog = new com.efs.sdk.base.protocol.record.EfsJSONLog("nativeh5perf");
            efsJSONLog.put("wk_native_h5log", this.f);
            com.efs.sdk.h5pagesdk.H5ConfigMananger.this.b.send(efsJSONLog);
        }
    }

    public H5ConfigMananger(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter) {
        this.mContext = context;
        this.b = efsReporter;
        efsReporter.getAllSdkConfig(new java.lang.String[]{"apm_native_h5perf_sampling_rate"}, new com.efs.sdk.h5pagesdk.H5ConfigMananger.AnonymousClass1());
    }

    public static /* synthetic */ boolean a(int i) {
        if (com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()) {
            return true;
        }
        if (i != 0) {
            return i == 100 || new java.util.Random().nextInt(100) <= i;
        }
        return false;
    }

    public java.lang.String generateLaunchOptions() {
        if (!this.d && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            if (!com.efs.sdk.h5pagesdk.H5Manager.isDebug) {
                return "";
            }
            com.efs.sdk.base.core.util.Log.e("H5ConfigMananger", "采样未命中，并且不处于集成测试模式");
            return "";
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("sample", this.c);
            if (this.d) {
                jSONObject.put("sampleResult", "Y");
            } else {
                jSONObject.put("sampleResult", "N");
            }
            android.content.Context context = this.mContext;
            if (context != null) {
                jSONObject.put("appName", context.getApplicationInfo().packageName);
            }
            jSONObject.put("bridgeVersion", 1);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public boolean isH5TracerEnable() {
        return this.d;
    }

    public void sendData(java.lang.String str) {
        if (this.d || com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            com.efs.sdk.h5pagesdk.a.execute(new com.efs.sdk.h5pagesdk.H5ConfigMananger.AnonymousClass2(str));
        }
    }
}
