package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class nk implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.hbzhou.open.flowcamera.CaptureImageButton n;

    public /* synthetic */ nk(com.hbzhou.open.flowcamera.CaptureImageButton captureImageButton) {
        this.n = captureImageButton;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.hbzhou.open.flowcamera.CaptureImageButton.k(this.n, valueAnimator);
    }
}
