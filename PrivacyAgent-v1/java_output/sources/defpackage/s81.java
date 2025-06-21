package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class s81 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ android.view.View n;

    public /* synthetic */ s81(android.view.View view) {
        this.n = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.diamon.adapter.MainDiamondPositionAdapter.b(this.n, valueAnimator);
    }
}
