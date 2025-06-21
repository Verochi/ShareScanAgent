package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class u53 implements android.view.View.OnTouchListener {
    public final /* synthetic */ com.moji.shorttime.ui.map.TyphoonMarkerAdapter n;

    public /* synthetic */ u53(com.moji.shorttime.ui.map.TyphoonMarkerAdapter typhoonMarkerAdapter) {
        this.n = typhoonMarkerAdapter;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        return com.moji.shorttime.ui.map.TyphoonMarkerAdapter.a(this.n, view, motionEvent);
    }
}
