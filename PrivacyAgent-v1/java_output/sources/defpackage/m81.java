package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class m81 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ android.view.View n;
    public final /* synthetic */ com.moji.diamon.adapter.MainDiamondPositionAdapter t;

    public /* synthetic */ m81(android.view.View view, com.moji.diamon.adapter.MainDiamondPositionAdapter mainDiamondPositionAdapter) {
        this.n = view;
        this.t = mainDiamondPositionAdapter;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.diamon.adapter.MainDiamondPositionAdapter.j(this.n, this.t, valueAnimator);
    }
}
