package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class rb1 implements android.view.View.OnTouchListener {
    public final /* synthetic */ com.moji.shorttime.ui.map.MapleLeavesMarkerAdapter n;

    public /* synthetic */ rb1(com.moji.shorttime.ui.map.MapleLeavesMarkerAdapter mapleLeavesMarkerAdapter) {
        this.n = mapleLeavesMarkerAdapter;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        return com.moji.shorttime.ui.map.MapleLeavesMarkerAdapter.b(this.n, view, motionEvent);
    }
}
