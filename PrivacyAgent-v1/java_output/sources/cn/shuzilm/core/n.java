package cn.shuzilm.core;

/* loaded from: classes.dex */
class n implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ java.lang.String c;

    public n(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.String str;
        cn.shuzilm.core.DUHelper dUHelper;
        org.json.JSONObject jSONObject;
        cn.shuzilm.core.DUHelper dUHelper2;
        org.json.JSONObject jSONObject2;
        org.json.JSONObject jSONObject3;
        org.json.JSONObject jSONObject4;
        try {
            str = cn.shuzilm.core.DUHelper.i;
            cn.shuzilm.core.DUHelper.setConfig("apiKey", str);
            dUHelper = cn.shuzilm.core.DUHelper.d;
            android.content.Context context = this.a;
            jSONObject = cn.shuzilm.core.DUHelper.l;
            dUHelper.a(context, jSONObject, this.b);
            dUHelper2 = cn.shuzilm.core.DUHelper.d;
            jSONObject2 = cn.shuzilm.core.DUHelper.k;
            dUHelper2.a(jSONObject2, this.c);
            android.content.Context context2 = this.a;
            jSONObject3 = cn.shuzilm.core.DUHelper.l;
            java.lang.String jSONObject5 = jSONObject3.toString();
            jSONObject4 = cn.shuzilm.core.DUHelper.k;
            cn.shuzilm.core.DUHelper.reportRun(context2, jSONObject5, jSONObject4.toString());
        } catch (java.lang.Exception | java.lang.UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }
}
