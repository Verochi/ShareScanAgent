package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class jg2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ android.view.View n;

    public /* synthetic */ jg2(android.view.View view) {
        this.n = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.ShortEnterAnimator.c(this.n, valueAnimator);
    }
}
