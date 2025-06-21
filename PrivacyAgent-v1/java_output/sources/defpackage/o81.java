package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class o81 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ androidx.recyclerview.widget.RecyclerView.ViewHolder n;
    public final /* synthetic */ com.moji.diamon.adapter.MainDiamondPositionAdapter t;

    public /* synthetic */ o81(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, com.moji.diamon.adapter.MainDiamondPositionAdapter mainDiamondPositionAdapter) {
        this.n = viewHolder;
        this.t = mainDiamondPositionAdapter;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.diamon.adapter.MainDiamondPositionAdapter.d(this.n, this.t, valueAnimator);
    }
}
