package com.xiaomi.push;

/* loaded from: classes19.dex */
final class ja implements java.lang.Runnable {
    final /* synthetic */ java.lang.String a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ java.lang.String c;
    final /* synthetic */ com.xiaomi.push.iz d;

    public ja(com.xiaomi.push.iz izVar, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.d = izVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.content.Context context;
        context = this.d.b;
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences(this.a, 4).edit();
        edit.putString(this.b, this.c);
        edit.commit();
    }
}
