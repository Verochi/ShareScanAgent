package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class wn implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.share.CityTipsShareDialog n;
    public final /* synthetic */ int t;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef u;

    public /* synthetic */ wn(com.moji.mjweather.share.CityTipsShareDialog cityTipsShareDialog, int i, kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        this.n = cityTipsShareDialog;
        this.t = i;
        this.u = objectRef;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.share.CityTipsShareDialog.c(this.n, this.t, this.u, view);
    }
}
