package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class hc0 implements android.view.View.OnLongClickListener {
    public final /* synthetic */ com.moji.mjweather.setting.adapter.FeedMsgViewAdapter n;
    public final /* synthetic */ int t;

    public /* synthetic */ hc0(com.moji.mjweather.setting.adapter.FeedMsgViewAdapter feedMsgViewAdapter, int i) {
        this.n = feedMsgViewAdapter;
        this.t = i;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(android.view.View view) {
        return com.moji.mjweather.setting.adapter.FeedMsgViewAdapter.b(this.n, this.t, view);
    }
}
