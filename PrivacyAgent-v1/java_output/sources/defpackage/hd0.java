package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class hd0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ android.content.Context n;
    public final /* synthetic */ com.moji.mjweather.weather.view.FirstPageSpace t;

    public /* synthetic */ hd0(android.content.Context context, com.moji.mjweather.weather.view.FirstPageSpace firstPageSpace) {
        this.n = context;
        this.t = firstPageSpace;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.weather.view.FirstPageSpace.a(this.n, this.t, (kotlin.Unit) obj);
    }
}
