package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class zb1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.tabme.repository.MeLocalServiceRepository.LocalServiceLiveData n;

    public /* synthetic */ zb1(com.moji.mjweather.tabme.repository.MeLocalServiceRepository.LocalServiceLiveData localServiceLiveData) {
        this.n = localServiceLiveData;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.tabme.repository.MeLocalServiceRepository.LocalServiceLiveData.a(this.n, (com.moji.opevent.model.OperationEventWithStatus) obj);
    }
}
