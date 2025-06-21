package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class l1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.condition.view.AbsWeatherAndTopLiveCallback n;

    public /* synthetic */ l1(com.moji.condition.view.AbsWeatherAndTopLiveCallback absWeatherAndTopLiveCallback) {
        this.n = absWeatherAndTopLiveCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.condition.view.AbsWeatherAndTopLiveCallback.b(this.n);
    }
}
