package com.xiaomi.push;

/* loaded from: classes19.dex */
final class n extends com.xiaomi.push.m.b {
    final /* synthetic */ boolean b = false;
    final /* synthetic */ java.lang.String c;
    final /* synthetic */ com.xiaomi.push.m d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(com.xiaomi.push.m mVar, com.xiaomi.push.m.a aVar, java.lang.String str) {
        super(aVar);
        this.d = mVar;
        this.c = str;
    }

    @Override // com.xiaomi.push.m.b
    public final void a() {
        android.content.SharedPreferences sharedPreferences;
        if (this.b) {
            return;
        }
        sharedPreferences = this.d.e;
        sharedPreferences.edit().putLong(this.c, java.lang.System.currentTimeMillis()).commit();
    }
}
