package com.google.android.material.shape;

/* loaded from: classes22.dex */
public class InterpolateOnScrollPositionChangeHelper {
    private android.widget.ScrollView containingScrollView;
    private com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable;
    private android.view.View shapedView;
    private final int[] scrollLocation = new int[2];
    private final int[] containerLocation = new int[2];
    private final android.view.ViewTreeObserver.OnScrollChangedListener scrollChangedListener = new com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper.AnonymousClass1();

    /* renamed from: com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnScrollChangedListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper.this.updateInterpolationForScreenPosition();
        }
    }

    public InterpolateOnScrollPositionChangeHelper(android.view.View view, com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable, android.widget.ScrollView scrollView) {
        this.shapedView = view;
        this.materialShapeDrawable = materialShapeDrawable;
        this.containingScrollView = scrollView;
    }

    public void setContainingScrollView(android.widget.ScrollView scrollView) {
        this.containingScrollView = scrollView;
    }

    public void setMaterialShapeDrawable(com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable) {
        this.materialShapeDrawable = materialShapeDrawable;
    }

    public void startListeningForScrollChanges(@androidx.annotation.NonNull android.view.ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this.scrollChangedListener);
    }

    public void stopListeningForScrollChanges(@androidx.annotation.NonNull android.view.ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this.scrollChangedListener);
    }

    public void updateInterpolationForScreenPosition() {
        android.widget.ScrollView scrollView = this.containingScrollView;
        if (scrollView == null) {
            return;
        }
        if (scrollView.getChildCount() == 0) {
            throw new java.lang.IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
        }
        this.containingScrollView.getLocationInWindow(this.scrollLocation);
        this.containingScrollView.getChildAt(0).getLocationInWindow(this.containerLocation);
        int top = (this.shapedView.getTop() - this.scrollLocation[1]) + this.containerLocation[1];
        int height = this.shapedView.getHeight();
        int height2 = this.containingScrollView.getHeight();
        if (top < 0) {
            this.materialShapeDrawable.setInterpolation(java.lang.Math.max(0.0f, java.lang.Math.min(1.0f, (top / height) + 1.0f)));
            this.shapedView.invalidate();
            return;
        }
        if (top + height > height2) {
            this.materialShapeDrawable.setInterpolation(java.lang.Math.max(0.0f, java.lang.Math.min(1.0f, 1.0f - ((r0 - height2) / height))));
            this.shapedView.invalidate();
        } else if (this.materialShapeDrawable.getInterpolation() != 1.0f) {
            this.materialShapeDrawable.setInterpolation(1.0f);
            this.shapedView.invalidate();
        }
    }
}
