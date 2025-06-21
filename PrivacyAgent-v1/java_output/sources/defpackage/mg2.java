package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class mg2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ java.util.ArrayList n;

    public /* synthetic */ mg2(java.util.ArrayList arrayList) {
        this.n = arrayList;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.ShortEnterAnimator.d(this.n, valueAnimator);
    }
}
