package cn.shuzilm.core;

/* loaded from: classes.dex */
class f implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;
    final /* synthetic */ java.lang.String b;

    public f(android.content.Context context, java.lang.String str) {
        this.a = context;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        org.json.JSONObject jSONObject;
        try {
            android.content.Context context = this.a;
            jSONObject = cn.shuzilm.core.DUHelper.l;
            cn.shuzilm.core.DUHelper.dGZvcmRQ(context, jSONObject.toString(), this.b);
        } catch (java.lang.Exception | java.lang.UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }
}
