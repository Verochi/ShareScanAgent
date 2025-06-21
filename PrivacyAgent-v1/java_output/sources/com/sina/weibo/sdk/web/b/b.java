package com.sina.weibo.sdk.web.b;

/* loaded from: classes19.dex */
public abstract class b {
    protected com.sina.weibo.sdk.web.WebData aH;
    protected java.lang.String aI;
    protected android.content.Context ae;

    public interface a {
        void onComplete();

        void onError(java.lang.String str);
    }

    public b() {
    }

    public b(com.sina.weibo.sdk.auth.AuthInfo authInfo, int i, java.lang.String str, java.lang.String str2) {
        this.aH = new com.sina.weibo.sdk.web.WebData(authInfo, i, str, str2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(java.lang.System.currentTimeMillis());
        this.aI = sb.toString();
    }

    public abstract void a(android.os.Bundle bundle);

    public void a(com.sina.weibo.sdk.web.b.b.a aVar) {
    }

    public abstract void b(android.os.Bundle bundle);

    public abstract java.lang.String getUrl();

    public final void readFromBundle(android.os.Bundle bundle) {
        this.aH = (com.sina.weibo.sdk.web.WebData) bundle.getParcelable("web_data");
        this.aI = bundle.getString("_weibo_transaction");
        b(bundle);
    }

    public final void setContext(android.content.Context context) {
        this.ae = context;
    }

    public boolean w() {
        return false;
    }

    public final android.os.Bundle writeToBundle(android.os.Bundle bundle) {
        bundle.putParcelable("web_data", this.aH);
        int type = this.aH.getType();
        if (type == 1) {
            bundle.putInt("web_type", 1);
        } else if (type == 2) {
            bundle.putInt("web_type", 2);
        } else if (type == 3) {
            bundle.putInt("web_type", 3);
        }
        bundle.putString("_weibo_transaction", this.aI);
        a(bundle);
        return bundle;
    }

    public final com.sina.weibo.sdk.web.WebData x() {
        return this.aH;
    }
}
