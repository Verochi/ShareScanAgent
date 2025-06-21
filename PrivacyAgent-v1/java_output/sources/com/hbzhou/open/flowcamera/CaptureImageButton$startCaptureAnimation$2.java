package com.hbzhou.open.flowcamera;

@kotlin.Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/hbzhou/open/flowcamera/CaptureImageButton$startCaptureAnimation$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "MJCameraModule_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes22.dex */
public final class CaptureImageButton$startCaptureAnimation$2 extends android.animation.AnimatorListenerAdapter {
    public final /* synthetic */ com.hbzhou.open.flowcamera.CaptureImageButton n;

    public CaptureImageButton$startCaptureAnimation$2(com.hbzhou.open.flowcamera.CaptureImageButton captureImageButton) {
        this.n = captureImageButton;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@org.jetbrains.annotations.NotNull android.animation.Animator animation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationEnd(animation);
        com.hbzhou.open.flowcamera.CaptureListener captureListener = this.n.captureListener;
        if (captureListener != null) {
            captureListener.takePictures();
        }
        com.hbzhou.open.flowcamera.CaptureImageButton captureImageButton = this.n;
        captureImageButton.state = captureImageButton.getSTATE_BAN();
    }
}
