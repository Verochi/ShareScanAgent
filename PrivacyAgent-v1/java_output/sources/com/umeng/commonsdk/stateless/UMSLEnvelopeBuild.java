package com.umeng.commonsdk.stateless;

/* loaded from: classes19.dex */
public class UMSLEnvelopeBuild {
    private static final java.lang.String TAG = "UMSLEnvelopeBuild";
    private static boolean isEncryptEnabled;
    public static android.content.Context mContext;
    public static java.lang.String module;

    /* renamed from: com.umeng.commonsdk.stateless.UMSLEnvelopeBuild$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                android.os.Looper.prepare();
                android.widget.Toast.makeText(this.a.getApplicationContext(), com.umeng.commonsdk.debug.UMLogCommon.SC_10015, 1).show();
                android.os.Looper.loop();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static boolean isReadyBuildNew(android.content.Context context, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType uMBusinessType) {
        return false;
    }

    public static void setEncryptEnabled(boolean z) {
        isEncryptEnabled = z;
    }

    public org.json.JSONObject buildSLBaseHeader(android.content.Context context) {
        new com.umeng.commonsdk.stateless.UMSLEnvelopeBuild.AnonymousClass1(context).start();
        return null;
    }

    public org.json.JSONObject buildSLEnvelope(android.content.Context context, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, java.lang.String str) {
        return null;
    }
}
