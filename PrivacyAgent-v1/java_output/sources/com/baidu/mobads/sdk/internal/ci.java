package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class ci implements java.util.Observer {
    private static final java.lang.String a = "APKParser";
    private static final java.lang.String g = "__xadsdk_downloaded__version__";
    private static final java.lang.String h = "version";
    private android.content.Context b;
    private java.net.URL c;
    private java.lang.String d;
    private final com.baidu.mobads.sdk.internal.bx e;
    private com.baidu.mobads.sdk.internal.ci.a f;
    private android.content.SharedPreferences i;
    private android.content.SharedPreferences.OnSharedPreferenceChangeListener j;

    public interface a {
        void a(com.baidu.mobads.sdk.internal.bx bxVar);

        void b(com.baidu.mobads.sdk.internal.bx bxVar);
    }

    public ci(android.content.Context context, java.lang.String str, com.baidu.mobads.sdk.internal.bx bxVar, com.baidu.mobads.sdk.internal.ci.a aVar) {
        this.c = null;
        this.d = null;
        this.j = new com.baidu.mobads.sdk.internal.cj(this);
        this.d = str;
        this.e = bxVar;
        a(context, aVar);
    }

    public ci(android.content.Context context, java.net.URL url, com.baidu.mobads.sdk.internal.bx bxVar, com.baidu.mobads.sdk.internal.ci.a aVar) {
        this.c = null;
        this.d = null;
        this.j = new com.baidu.mobads.sdk.internal.cj(this);
        this.c = url;
        this.e = bxVar;
        a(context, aVar);
    }

    private void a(android.content.Context context, com.baidu.mobads.sdk.internal.ci.a aVar) {
        this.b = context;
        this.f = aVar;
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(g, 0);
        this.i = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.j);
    }

    public void a(java.lang.String str, java.lang.String str2) {
        com.baidu.mobads.sdk.internal.al alVar = new com.baidu.mobads.sdk.internal.al(this.b, this.d != null ? new java.net.URL(this.d) : this.c, str, str2, false);
        alVar.addObserver(this);
        alVar.a();
        android.content.SharedPreferences.Editor edit = this.i.edit();
        edit.putString("version", this.e.toString());
        edit.apply();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Observer
    public void update(java.util.Observable observable, java.lang.Object obj) {
        com.baidu.mobads.sdk.internal.x xVar = (com.baidu.mobads.sdk.internal.x) observable;
        if (xVar.l() == com.baidu.mobads.sdk.internal.x.a.COMPLETED) {
            this.f.a(new com.baidu.mobads.sdk.internal.bx(this.e, xVar.g(), java.lang.Boolean.TRUE));
        }
        if (xVar.l() == com.baidu.mobads.sdk.internal.x.a.ERROR) {
            this.f.b(new com.baidu.mobads.sdk.internal.bx(this.e, xVar.g(), java.lang.Boolean.FALSE));
        }
    }
}
