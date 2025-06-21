package defpackage;

/* loaded from: classes10.dex */
public final /* synthetic */ class ow1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.poimodule.POISettingAdapter n;
    public final /* synthetic */ int t;

    public /* synthetic */ ow1(com.moji.poimodule.POISettingAdapter pOISettingAdapter, int i) {
        this.n = pOISettingAdapter;
        this.t = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.poimodule.POISettingAdapter.e(this.n, this.t, view);
    }
}
