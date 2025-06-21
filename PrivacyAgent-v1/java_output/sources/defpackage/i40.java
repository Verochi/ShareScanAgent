package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class i40 implements android.view.View.OnTouchListener {
    public final /* synthetic */ android.widget.LinearLayout n;

    public /* synthetic */ i40(android.widget.LinearLayout linearLayout) {
        this.n = linearLayout;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        return com.moji.newliveview.detail.view.DislikePupupWindow.a(this.n, view, motionEvent);
    }
}
