package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class pd implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.newliveview.atlas.AtlasGroupView n;

    public /* synthetic */ pd(com.moji.newliveview.atlas.AtlasGroupView atlasGroupView) {
        this.n = atlasGroupView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.newliveview.atlas.AtlasGroupView.a(this.n, valueAnimator);
    }
}
