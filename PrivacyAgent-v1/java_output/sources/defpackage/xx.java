package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class xx implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mj40dayforecast.Days40MainActivity n;

    public /* synthetic */ xx(com.moji.mj40dayforecast.Days40MainActivity days40MainActivity) {
        this.n = days40MainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mj40dayforecast.Days40MainActivity.c(this.n, (com.moji.mjcitypicker.data.SelectedArea) obj);
    }
}
