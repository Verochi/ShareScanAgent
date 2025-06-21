package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class o83 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.feed.dress.view.VideoDescView n;
    public final /* synthetic */ java.lang.CharSequence t;

    public /* synthetic */ o83(com.moji.mjweather.feed.dress.view.VideoDescView videoDescView, java.lang.CharSequence charSequence) {
        this.n = videoDescView;
        this.t = charSequence;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.feed.dress.view.VideoDescView.c(this.n, this.t);
    }
}
