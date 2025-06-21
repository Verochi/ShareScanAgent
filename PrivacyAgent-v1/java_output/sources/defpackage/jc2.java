package defpackage;

/* loaded from: classes16.dex */
public final /* synthetic */ class jc2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.textview.RollingTextView n;
    public final /* synthetic */ int t;

    public /* synthetic */ jc2(com.moji.textview.RollingTextView rollingTextView, int i) {
        this.n = rollingTextView;
        this.t = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.textview.RollingTextView.d(this.n, this.t);
    }
}
