package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class ag2 implements android.view.View.OnTouchListener {
    public final /* synthetic */ androidx.core.view.GestureDetectorCompat n;

    public /* synthetic */ ag2(androidx.core.view.GestureDetectorCompat gestureDetectorCompat) {
        this.n = gestureDetectorCompat;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        return com.moji.share.view.SharePlatform.a(this.n, view, motionEvent);
    }
}
