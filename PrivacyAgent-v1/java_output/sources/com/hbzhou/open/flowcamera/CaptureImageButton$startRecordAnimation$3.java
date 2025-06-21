package com.hbzhou.open.flowcamera;

@kotlin.Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/hbzhou/open/flowcamera/CaptureImageButton$startRecordAnimation$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "MJCameraModule_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes22.dex */
public final class CaptureImageButton$startRecordAnimation$3 extends android.animation.AnimatorListenerAdapter {
    public final /* synthetic */ com.hbzhou.open.flowcamera.CaptureImageButton n;

    public CaptureImageButton$startRecordAnimation$3(com.hbzhou.open.flowcamera.CaptureImageButton captureImageButton) {
        this.n = captureImageButton;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@org.jetbrains.annotations.NotNull android.animation.Animator animation) {
        int i;
        com.hbzhou.open.flowcamera.CaptureImageButton.RecordCountDownTimer recordCountDownTimer;
        com.hbzhou.open.flowcamera.CaptureListener captureListener;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationEnd(animation);
        i = this.n.state;
        if (i == this.n.STATE_LONG_PRESS) {
            if (this.n.captureListener != null && (captureListener = this.n.captureListener) != null) {
                captureListener.recordStart();
            }
            com.hbzhou.open.flowcamera.CaptureImageButton captureImageButton = this.n;
            captureImageButton.state = captureImageButton.getSTATE_RECORDERING();
            recordCountDownTimer = this.n.timer;
            kotlin.jvm.internal.Intrinsics.checkNotNull(recordCountDownTimer);
            recordCountDownTimer.start();
        }
    }
}
