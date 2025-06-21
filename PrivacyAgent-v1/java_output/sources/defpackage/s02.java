package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class s02 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.detail.PicTextLiveActivity n;

    public /* synthetic */ s02(com.moji.newliveview.detail.PicTextLiveActivity picTextLiveActivity) {
        this.n = picTextLiveActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.detail.PicTextLiveActivity.b(this.n, (com.moji.http.snsforum.entity.PicTextLiveResult) obj);
    }
}
