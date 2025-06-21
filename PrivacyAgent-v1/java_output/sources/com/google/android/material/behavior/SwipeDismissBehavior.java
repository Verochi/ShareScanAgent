package com.google.android.material.behavior;

/* loaded from: classes22.dex */
public class SwipeDismissBehavior<V extends android.view.View> extends androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior<V> {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    private boolean interceptingEvents;
    com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener listener;
    private boolean sensitivitySet;
    androidx.customview.widget.ViewDragHelper viewDragHelper;
    private float sensitivity = 0.0f;
    int swipeDirection = 2;
    float dragDismissThreshold = 0.5f;
    float alphaStartSwipeDistance = 0.0f;
    float alphaEndSwipeDistance = 0.5f;
    private final androidx.customview.widget.ViewDragHelper.Callback dragCallback = new com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1();

    /* renamed from: com.google.android.material.behavior.SwipeDismissBehavior$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.customview.widget.ViewDragHelper.Callback {
        private static final int INVALID_POINTER_ID = -1;
        private int activePointerId = -1;
        private int originalCapturedViewLeft;

        public AnonymousClass1() {
        }

        private boolean shouldDismiss(@androidx.annotation.NonNull android.view.View view, float f) {
            if (f == 0.0f) {
                return java.lang.Math.abs(view.getLeft() - this.originalCapturedViewLeft) >= java.lang.Math.round(((float) view.getWidth()) * com.google.android.material.behavior.SwipeDismissBehavior.this.dragDismissThreshold);
            }
            boolean z = androidx.core.view.ViewCompat.getLayoutDirection(view) == 1;
            int i = com.google.android.material.behavior.SwipeDismissBehavior.this.swipeDirection;
            if (i == 2) {
                return true;
            }
            if (i == 0) {
                if (z) {
                    if (f >= 0.0f) {
                        return false;
                    }
                } else if (f <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i != 1) {
                return false;
            }
            if (z) {
                if (f <= 0.0f) {
                    return false;
                }
            } else if (f >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@androidx.annotation.NonNull android.view.View view, int i, int i2) {
            int width;
            int width2;
            int width3;
            boolean z = androidx.core.view.ViewCompat.getLayoutDirection(view) == 1;
            int i3 = com.google.android.material.behavior.SwipeDismissBehavior.this.swipeDirection;
            if (i3 == 0) {
                if (z) {
                    width = this.originalCapturedViewLeft - view.getWidth();
                    width2 = this.originalCapturedViewLeft;
                } else {
                    width = this.originalCapturedViewLeft;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i3 != 1) {
                width = this.originalCapturedViewLeft - view.getWidth();
                width2 = view.getWidth() + this.originalCapturedViewLeft;
            } else if (z) {
                width = this.originalCapturedViewLeft;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.originalCapturedViewLeft - view.getWidth();
                width2 = this.originalCapturedViewLeft;
            }
            return com.google.android.material.behavior.SwipeDismissBehavior.clamp(width, i, width2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@androidx.annotation.NonNull android.view.View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(@androidx.annotation.NonNull android.view.View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(@androidx.annotation.NonNull android.view.View view, int i) {
            this.activePointerId = i;
            this.originalCapturedViewLeft = view.getLeft();
            android.view.ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener onDismissListener = com.google.android.material.behavior.SwipeDismissBehavior.this.listener;
            if (onDismissListener != null) {
                onDismissListener.onDragStateChanged(i);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@androidx.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4) {
            float width = this.originalCapturedViewLeft + (view.getWidth() * com.google.android.material.behavior.SwipeDismissBehavior.this.alphaStartSwipeDistance);
            float width2 = this.originalCapturedViewLeft + (view.getWidth() * com.google.android.material.behavior.SwipeDismissBehavior.this.alphaEndSwipeDistance);
            float f = i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(com.google.android.material.behavior.SwipeDismissBehavior.clamp(0.0f, 1.0f - com.google.android.material.behavior.SwipeDismissBehavior.fraction(width, width2, f), 1.0f));
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@androidx.annotation.NonNull android.view.View view, float f, float f2) {
            int i;
            boolean z;
            com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener onDismissListener;
            this.activePointerId = -1;
            int width = view.getWidth();
            if (shouldDismiss(view, f)) {
                int left = view.getLeft();
                int i2 = this.originalCapturedViewLeft;
                i = left < i2 ? i2 - width : i2 + width;
                z = true;
            } else {
                i = this.originalCapturedViewLeft;
                z = false;
            }
            if (com.google.android.material.behavior.SwipeDismissBehavior.this.viewDragHelper.settleCapturedViewAt(i, view.getTop())) {
                androidx.core.view.ViewCompat.postOnAnimation(view, new com.google.android.material.behavior.SwipeDismissBehavior.SettleRunnable(view, z));
            } else {
                if (!z || (onDismissListener = com.google.android.material.behavior.SwipeDismissBehavior.this.listener) == null) {
                    return;
                }
                onDismissListener.onDismiss(view);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(android.view.View view, int i) {
            int i2 = this.activePointerId;
            return (i2 == -1 || i2 == i) && com.google.android.material.behavior.SwipeDismissBehavior.this.canSwipeDismissView(view);
        }
    }

    /* renamed from: com.google.android.material.behavior.SwipeDismissBehavior$2, reason: invalid class name */
    public class AnonymousClass2 implements androidx.core.view.accessibility.AccessibilityViewCommand {
        public AnonymousClass2() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments commandArguments) {
            boolean z = false;
            if (!com.google.android.material.behavior.SwipeDismissBehavior.this.canSwipeDismissView(view)) {
                return false;
            }
            boolean z2 = androidx.core.view.ViewCompat.getLayoutDirection(view) == 1;
            int i = com.google.android.material.behavior.SwipeDismissBehavior.this.swipeDirection;
            if ((i == 0 && z2) || (i == 1 && !z2)) {
                z = true;
            }
            int width = view.getWidth();
            if (z) {
                width = -width;
            }
            androidx.core.view.ViewCompat.offsetLeftAndRight(view, width);
            view.setAlpha(0.0f);
            com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener onDismissListener = com.google.android.material.behavior.SwipeDismissBehavior.this.listener;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(view);
            }
            return true;
        }
    }

    public interface OnDismissListener {
        void onDismiss(android.view.View view);

        void onDragStateChanged(int i);
    }

    public class SettleRunnable implements java.lang.Runnable {
        private final boolean dismiss;
        private final android.view.View view;

        public SettleRunnable(android.view.View view, boolean z) {
            this.view = view;
            this.dismiss = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener onDismissListener;
            androidx.customview.widget.ViewDragHelper viewDragHelper = com.google.android.material.behavior.SwipeDismissBehavior.this.viewDragHelper;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                androidx.core.view.ViewCompat.postOnAnimation(this.view, this);
            } else {
                if (!this.dismiss || (onDismissListener = com.google.android.material.behavior.SwipeDismissBehavior.this.listener) == null) {
                    return;
                }
                onDismissListener.onDismiss(this.view);
            }
        }
    }

    public static float clamp(float f, float f2, float f3) {
        return java.lang.Math.min(java.lang.Math.max(f, f2), f3);
    }

    public static int clamp(int i, int i2, int i3) {
        return java.lang.Math.min(java.lang.Math.max(i, i2), i3);
    }

    private void ensureViewDragHelper(android.view.ViewGroup viewGroup) {
        if (this.viewDragHelper == null) {
            this.viewDragHelper = this.sensitivitySet ? androidx.customview.widget.ViewDragHelper.create(viewGroup, this.sensitivity, this.dragCallback) : androidx.customview.widget.ViewDragHelper.create(viewGroup, this.dragCallback);
        }
    }

    public static float fraction(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    private void updateAccessibilityActions(android.view.View view) {
        androidx.core.view.ViewCompat.removeAccessibilityAction(view, 1048576);
        if (canSwipeDismissView(view)) {
            androidx.core.view.ViewCompat.replaceAccessibilityAction(view, androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass2());
        }
    }

    public boolean canSwipeDismissView(@androidx.annotation.NonNull android.view.View view) {
        return true;
    }

    public int getDragState() {
        androidx.customview.widget.ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper != null) {
            return viewDragHelper.getViewDragState();
        }
        return 0;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.VisibleForTesting
    public com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener getListener() {
        return this.listener;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull V v, @androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
        boolean z = this.interceptingEvents;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.interceptingEvents = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.interceptingEvents = false;
        }
        if (!z) {
            return false;
        }
        ensureViewDragHelper(coordinatorLayout);
        return this.viewDragHelper.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull V v, int i) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, v, i);
        if (androidx.core.view.ViewCompat.getImportantForAccessibility(v) == 0) {
            androidx.core.view.ViewCompat.setImportantForAccessibility(v, 1);
            updateAccessibilityActions(v);
        }
        return onLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v, android.view.MotionEvent motionEvent) {
        androidx.customview.widget.ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper == null) {
            return false;
        }
        viewDragHelper.processTouchEvent(motionEvent);
        return true;
    }

    public void setDragDismissDistance(float f) {
        this.dragDismissThreshold = clamp(0.0f, f, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f) {
        this.alphaEndSwipeDistance = clamp(0.0f, f, 1.0f);
    }

    public void setListener(@androidx.annotation.Nullable com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener onDismissListener) {
        this.listener = onDismissListener;
    }

    public void setSensitivity(float f) {
        this.sensitivity = f;
        this.sensitivitySet = true;
    }

    public void setStartAlphaSwipeDistance(float f) {
        this.alphaStartSwipeDistance = clamp(0.0f, f, 1.0f);
    }

    public void setSwipeDirection(int i) {
        this.swipeDirection = i;
    }
}
