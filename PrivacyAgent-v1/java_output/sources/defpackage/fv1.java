package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class fv1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef n;
    public final /* synthetic */ com.moji.card.view.OpCardLiveSlideshowView t;

    public /* synthetic */ fv1(kotlin.jvm.internal.Ref.ObjectRef objectRef, com.moji.card.view.OpCardLiveSlideshowView opCardLiveSlideshowView) {
        this.n = objectRef;
        this.t = opCardLiveSlideshowView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.card.view.OpCardLiveSlideshowView.h(this.n, this.t, valueAnimator);
    }
}
