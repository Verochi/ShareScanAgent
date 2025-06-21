package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class mk implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.hbzhou.open.flowcamera.CaptureImageButton n;

    public /* synthetic */ mk(com.hbzhou.open.flowcamera.CaptureImageButton captureImageButton) {
        this.n = captureImageButton;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.hbzhou.open.flowcamera.CaptureImageButton.j(this.n, valueAnimator);
    }
}
