package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class fc0 implements com.moji.mjweather.setting.view.FoldTextView.TagClickListener {
    public final /* synthetic */ com.moji.mjweather.setting.adapter.FeedMsgViewAdapter a;
    public final /* synthetic */ int b;

    public /* synthetic */ fc0(com.moji.mjweather.setting.adapter.FeedMsgViewAdapter feedMsgViewAdapter, int i) {
        this.a = feedMsgViewAdapter;
        this.b = i;
    }

    public final void onTextOPen(boolean z) {
        com.moji.mjweather.setting.adapter.FeedMsgViewAdapter.a(this.a, this.b, z);
    }
}
