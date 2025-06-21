package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class s8 implements android.view.View.OnTouchListener {
    public final /* synthetic */ com.moji.shorttime.ui.map.AllergyRasterMarkerAdapter n;

    public /* synthetic */ s8(com.moji.shorttime.ui.map.AllergyRasterMarkerAdapter allergyRasterMarkerAdapter) {
        this.n = allergyRasterMarkerAdapter;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        return com.moji.shorttime.ui.map.AllergyRasterMarkerAdapter.a(this.n, view, motionEvent);
    }
}
