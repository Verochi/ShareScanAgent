package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class pw implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mj180dayforecast.Days180MainActivity n;

    public /* synthetic */ pw(com.moji.mj180dayforecast.Days180MainActivity days180MainActivity) {
        this.n = days180MainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mj180dayforecast.Days180MainActivity.h(this.n, (com.moji.mjcitypicker.data.SelectedArea) obj);
    }
}
