package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class en2 implements com.moji.scrollview.HorizontalScrollViewMonitor.OnScrollListener {
    public final /* synthetic */ com.moji.snow.adapter.SnowDetailHolder a;

    public /* synthetic */ en2(com.moji.snow.adapter.SnowDetailHolder snowDetailHolder) {
        this.a = snowDetailHolder;
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        com.moji.snow.adapter.SnowDetailHolder.c(this.a, i, i2, i3, i4);
    }
}
