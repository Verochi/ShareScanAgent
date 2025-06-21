package com.otaliastudios.cameraview.markers;

/* loaded from: classes19.dex */
public class DefaultAutoFocusMarker implements com.otaliastudios.cameraview.markers.AutoFocusMarker {

    @androidx.annotation.VisibleForTesting
    public android.view.View a;

    @androidx.annotation.VisibleForTesting
    public android.view.View b;

    /* renamed from: com.otaliastudios.cameraview.markers.DefaultAutoFocusMarker$1, reason: invalid class name */
    public class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            super.onAnimationEnd(animator);
            com.otaliastudios.cameraview.markers.DefaultAutoFocusMarker.b(com.otaliastudios.cameraview.markers.DefaultAutoFocusMarker.this.a, 1.36f, 0.0f, 200L, 1000L, null);
        }
    }

    public static void b(@androidx.annotation.NonNull android.view.View view, float f, float f2, long j, long j2, @androidx.annotation.Nullable android.animation.Animator.AnimatorListener animatorListener) {
        view.animate().scaleX(f).scaleY(f).alpha(f2).setDuration(j).setStartDelay(j2).setListener(animatorListener).start();
    }

    @Override // com.otaliastudios.cameraview.markers.Marker
    @androidx.annotation.Nullable
    public android.view.View onAttach(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.otaliastudios.cameraview.R.layout.cameraview_layout_focus_marker, viewGroup, false);
        this.a = inflate.findViewById(com.otaliastudios.cameraview.R.id.focusMarkerContainer);
        this.b = inflate.findViewById(com.otaliastudios.cameraview.R.id.focusMarkerFill);
        return inflate;
    }

    @Override // com.otaliastudios.cameraview.markers.AutoFocusMarker
    public void onAutoFocusEnd(@androidx.annotation.NonNull com.otaliastudios.cameraview.markers.AutoFocusTrigger autoFocusTrigger, boolean z, @androidx.annotation.NonNull android.graphics.PointF pointF) {
        if (autoFocusTrigger == com.otaliastudios.cameraview.markers.AutoFocusTrigger.METHOD) {
            return;
        }
        if (z) {
            b(this.a, 1.0f, 0.0f, 500L, 0L, null);
            b(this.b, 1.0f, 0.0f, 500L, 0L, null);
        } else {
            b(this.b, 0.0f, 0.0f, 500L, 0L, null);
            b(this.a, 1.36f, 1.0f, 500L, 0L, new com.otaliastudios.cameraview.markers.DefaultAutoFocusMarker.AnonymousClass1());
        }
    }

    @Override // com.otaliastudios.cameraview.markers.AutoFocusMarker
    public void onAutoFocusStart(@androidx.annotation.NonNull com.otaliastudios.cameraview.markers.AutoFocusTrigger autoFocusTrigger, @androidx.annotation.NonNull android.graphics.PointF pointF) {
        if (autoFocusTrigger == com.otaliastudios.cameraview.markers.AutoFocusTrigger.METHOD) {
            return;
        }
        this.a.clearAnimation();
        this.b.clearAnimation();
        this.a.setScaleX(1.36f);
        this.a.setScaleY(1.36f);
        this.a.setAlpha(1.0f);
        this.b.setScaleX(0.0f);
        this.b.setScaleY(0.0f);
        this.b.setAlpha(1.0f);
        b(this.a, 1.0f, 1.0f, 300L, 0L, null);
        b(this.b, 1.0f, 1.0f, 300L, 0L, null);
    }
}
