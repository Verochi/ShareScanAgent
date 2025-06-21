package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class a33 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.condition.view.TopWeatherCallBack n;

    public /* synthetic */ a33(com.moji.condition.view.TopWeatherCallBack topWeatherCallBack) {
        this.n = topWeatherCallBack;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.condition.view.TopWeatherCallBack.j(this.n);
    }
}
