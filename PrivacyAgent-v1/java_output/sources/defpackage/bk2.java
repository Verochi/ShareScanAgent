package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class bk2 implements android.view.View.OnTouchListener {
    public final /* synthetic */ android.view.GestureDetector n;

    public /* synthetic */ bk2(android.view.GestureDetector gestureDetector) {
        this.n = gestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        return com.moji.liveview_finalversion.ui.detail.viewholder.SinglePictureViewHolder.d(this.n, view, motionEvent);
    }
}
