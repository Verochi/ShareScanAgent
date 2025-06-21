package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class t02 implements com.chad.library.adapter.base.listener.OnItemChildClickListener {
    public final /* synthetic */ com.moji.newliveview.detail.PicTextLiveActivity a;

    public /* synthetic */ t02(com.moji.newliveview.detail.PicTextLiveActivity picTextLiveActivity) {
        this.a = picTextLiveActivity;
    }

    @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
    public final void onItemChildClick(com.chad.library.adapter.base.BaseQuickAdapter baseQuickAdapter, android.view.View view, int i) {
        com.moji.newliveview.detail.PicTextLiveActivity.c(this.a, baseQuickAdapter, view, i);
    }
}
