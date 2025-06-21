package cn.jzvd;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements java.lang.Runnable {
    public final /* synthetic */ cn.jzvd.JZMediaExo.onBufferingUpdate n;
    public final /* synthetic */ int t;

    public /* synthetic */ a(cn.jzvd.JZMediaExo.onBufferingUpdate onbufferingupdate, int i) {
        this.n = onbufferingupdate;
        this.t = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.b(this.t);
    }
}
