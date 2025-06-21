package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class vx implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mj40dayforecast.Days40MainActivity n;

    public /* synthetic */ vx(com.moji.mj40dayforecast.Days40MainActivity days40MainActivity) {
        this.n = days40MainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mj40dayforecast.Days40MainActivity.f(this.n, (java.lang.Boolean) obj);
    }
}
