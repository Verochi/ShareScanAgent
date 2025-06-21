package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class kd2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.weathersence.activity.ScenePreviewActivity n;

    public /* synthetic */ kd2(com.moji.weathersence.activity.ScenePreviewActivity scenePreviewActivity) {
        this.n = scenePreviewActivity;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.weathersence.activity.ScenePreviewActivity.c(this.n, valueAnimator);
    }
}
