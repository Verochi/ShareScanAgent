package com.umeng.analytics;

/* loaded from: classes19.dex */
public class CoreProtocol implements com.umeng.commonsdk.framework.UMLogDataProtocol, com.umeng.commonsdk.framework.UMSenderStateNotify {
    private static android.content.Context a;

    public static class a {
        private static final com.umeng.analytics.CoreProtocol a = new com.umeng.analytics.CoreProtocol(null);

        private a() {
        }
    }

    private CoreProtocol() {
    }

    public /* synthetic */ CoreProtocol(com.umeng.analytics.CoreProtocol.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.umeng.analytics.CoreProtocol getInstance(android.content.Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return com.umeng.analytics.CoreProtocol.a.a;
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onConnectionAvailable() {
        com.umeng.analytics.pro.q.a(a).a();
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onSenderIdle() {
        com.umeng.analytics.pro.q.a(a).b();
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(java.lang.Object obj) {
        com.umeng.analytics.pro.q.a(a).a(obj);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public org.json.JSONObject setupReportData(long j) {
        return com.umeng.analytics.pro.q.a(a).a(j);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(java.lang.Object obj, int i) {
        com.umeng.analytics.pro.q.a(a).a(obj, i);
    }
}
