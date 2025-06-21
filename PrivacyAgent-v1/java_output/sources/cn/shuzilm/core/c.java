package cn.shuzilm.core;

/* loaded from: classes.dex */
class c implements java.lang.Runnable {
    final /* synthetic */ java.lang.String a;
    final /* synthetic */ android.content.Context b;

    public c(java.lang.String str, android.content.Context context) {
        this.a = str;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        org.json.JSONObject jSONObject;
        try {
            cn.shuzilm.core.DUHelper.setConfig("f_pkg", this.a);
            android.content.Context context = this.b;
            jSONObject = cn.shuzilm.core.DUHelper.l;
            cn.shuzilm.core.DUHelper.onIEvent(context, jSONObject.toString(), null, null);
        } catch (java.lang.Exception | java.lang.UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }
}
