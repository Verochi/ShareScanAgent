package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class ji0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.dailydetails.viewmodel.FrameLiveData n;

    public /* synthetic */ ji0(com.moji.mjweather.dailydetails.viewmodel.FrameLiveData frameLiveData) {
        this.n = frameLiveData;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.dailydetails.viewmodel.FrameLiveData.a(this.n, (java.lang.Boolean) obj);
    }
}
