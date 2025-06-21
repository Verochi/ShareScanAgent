package com.google.android.material.snackbar;

/* loaded from: classes22.dex */
public abstract class BaseTransientBottomBar<B extends com.google.android.material.snackbar.BaseTransientBottomBar<B>> {
    static final int ANIMATION_DURATION = 250;
    static final int ANIMATION_FADE_DURATION = 180;
    private static final int ANIMATION_FADE_IN_DURATION = 150;
    private static final int ANIMATION_FADE_OUT_DURATION = 75;
    public static final int ANIMATION_MODE_FADE = 1;
    public static final int ANIMATION_MODE_SLIDE = 0;
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    static final int MSG_DISMISS = 1;
    static final int MSG_SHOW = 0;

    @androidx.annotation.Nullable
    private final android.view.accessibility.AccessibilityManager accessibilityManager;

    @androidx.annotation.Nullable
    private android.view.View anchorView;
    private final android.view.ViewTreeObserver.OnGlobalLayoutListener anchorViewLayoutListener;
    private boolean anchorViewLayoutListenerEnabled;
    private com.google.android.material.snackbar.BaseTransientBottomBar.Behavior behavior;

    @androidx.annotation.RequiresApi(29)
    private final java.lang.Runnable bottomMarginGestureInsetRunnable;
    private java.util.List<com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback<B>> callbacks;

    @androidx.annotation.NonNull
    private final com.google.android.material.snackbar.ContentViewCallback contentViewCallback;
    private final android.content.Context context;
    private int duration;
    private int extraBottomMarginAnchorView;
    private int extraBottomMarginGestureInset;
    private int extraBottomMarginWindowInset;
    private int extraLeftMarginWindowInset;
    private int extraRightMarginWindowInset;
    private boolean gestureInsetBottomIgnored;

    @androidx.annotation.NonNull
    com.google.android.material.snackbar.SnackbarManager.Callback managerCallback;

    @androidx.annotation.Nullable
    private android.graphics.Rect originalMargins;

    @androidx.annotation.NonNull
    private final android.view.ViewGroup targetParent;

    @androidx.annotation.NonNull
    protected final com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout view;
    private static final boolean USE_OFFSET_API = false;
    private static final int[] SNACKBAR_STYLE_ATTR = {com.google.android.material.R.attr.snackbarStyle};
    private static final java.lang.String TAG = com.google.android.material.snackbar.BaseTransientBottomBar.class.getSimpleName();

    @androidx.annotation.NonNull
    static final android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper(), new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass1());

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@androidx.annotation.NonNull android.os.Message message) {
            int i = message.what;
            if (i == 0) {
                ((com.google.android.material.snackbar.BaseTransientBottomBar) message.obj).showView();
                return true;
            }
            if (i != 1) {
                return false;
            }
            ((com.google.android.material.snackbar.BaseTransientBottomBar) message.obj).hideView(message.arg1);
            return true;
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        public AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout snackbarBaseLayout = com.google.android.material.snackbar.BaseTransientBottomBar.this.view;
            if (snackbarBaseLayout == null) {
                return;
            }
            if (snackbarBaseLayout.getParent() != null) {
                com.google.android.material.snackbar.BaseTransientBottomBar.this.view.setVisibility(0);
            }
            if (com.google.android.material.snackbar.BaseTransientBottomBar.this.view.getAnimationMode() == 1) {
                com.google.android.material.snackbar.BaseTransientBottomBar.this.startFadeInAnimation();
            } else {
                com.google.android.material.snackbar.BaseTransientBottomBar.this.startSlideInAnimation();
            }
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$11, reason: invalid class name */
    public class AnonymousClass11 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass11() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.material.snackbar.BaseTransientBottomBar.this.onViewShown();
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$12, reason: invalid class name */
    public class AnonymousClass12 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ int val$event;

        public AnonymousClass12(int i) {
            this.val$event = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.material.snackbar.BaseTransientBottomBar.this.onViewHidden(this.val$event);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$13, reason: invalid class name */
    public class AnonymousClass13 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass13() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
            com.google.android.material.snackbar.BaseTransientBottomBar.this.view.setAlpha(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$14, reason: invalid class name */
    public class AnonymousClass14 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass14() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
            float floatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            com.google.android.material.snackbar.BaseTransientBottomBar.this.view.setScaleX(floatValue);
            com.google.android.material.snackbar.BaseTransientBottomBar.this.view.setScaleY(floatValue);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$15, reason: invalid class name */
    public class AnonymousClass15 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass15() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.material.snackbar.BaseTransientBottomBar.this.onViewShown();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            com.google.android.material.snackbar.BaseTransientBottomBar.this.contentViewCallback.animateContentIn(70, 180);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$16, reason: invalid class name */
    public class AnonymousClass16 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        private int previousAnimatedIntValue;
        final /* synthetic */ int val$translationYBottom;

        public AnonymousClass16(int i) {
            this.val$translationYBottom = i;
            this.previousAnimatedIntValue = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
            int intValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
            if (com.google.android.material.snackbar.BaseTransientBottomBar.USE_OFFSET_API) {
                androidx.core.view.ViewCompat.offsetTopAndBottom(com.google.android.material.snackbar.BaseTransientBottomBar.this.view, intValue - this.previousAnimatedIntValue);
            } else {
                com.google.android.material.snackbar.BaseTransientBottomBar.this.view.setTranslationY(intValue);
            }
            this.previousAnimatedIntValue = intValue;
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$17, reason: invalid class name */
    public class AnonymousClass17 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ int val$event;

        public AnonymousClass17(int i) {
            this.val$event = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.material.snackbar.BaseTransientBottomBar.this.onViewHidden(this.val$event);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            com.google.android.material.snackbar.BaseTransientBottomBar.this.contentViewCallback.animateContentOut(0, 180);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$18, reason: invalid class name */
    public class AnonymousClass18 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        private int previousAnimatedIntValue = 0;

        public AnonymousClass18() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
            int intValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
            if (com.google.android.material.snackbar.BaseTransientBottomBar.USE_OFFSET_API) {
                androidx.core.view.ViewCompat.offsetTopAndBottom(com.google.android.material.snackbar.BaseTransientBottomBar.this.view, intValue - this.previousAnimatedIntValue);
            } else {
                com.google.android.material.snackbar.BaseTransientBottomBar.this.view.setTranslationY(intValue);
            }
            this.previousAnimatedIntValue = intValue;
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        public AnonymousClass2() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (com.google.android.material.snackbar.BaseTransientBottomBar.this.anchorViewLayoutListenerEnabled) {
                com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar = com.google.android.material.snackbar.BaseTransientBottomBar.this;
                baseTransientBottomBar.extraBottomMarginAnchorView = baseTransientBottomBar.calculateBottomMarginForAnchorView();
                com.google.android.material.snackbar.BaseTransientBottomBar.this.updateMargins();
            }
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int screenHeight;
            com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar = com.google.android.material.snackbar.BaseTransientBottomBar.this;
            if (baseTransientBottomBar.view == null || baseTransientBottomBar.context == null || (screenHeight = (com.google.android.material.snackbar.BaseTransientBottomBar.this.getScreenHeight() - com.google.android.material.snackbar.BaseTransientBottomBar.this.getViewAbsoluteBottom()) + ((int) com.google.android.material.snackbar.BaseTransientBottomBar.this.view.getTranslationY())) >= com.google.android.material.snackbar.BaseTransientBottomBar.this.extraBottomMarginGestureInset) {
                return;
            }
            android.view.ViewGroup.LayoutParams layoutParams = com.google.android.material.snackbar.BaseTransientBottomBar.this.view.getLayoutParams();
            if (!(layoutParams instanceof android.view.ViewGroup.MarginLayoutParams)) {
                java.lang.String unused = com.google.android.material.snackbar.BaseTransientBottomBar.TAG;
                return;
            }
            ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += com.google.android.material.snackbar.BaseTransientBottomBar.this.extraBottomMarginGestureInset - screenHeight;
            com.google.android.material.snackbar.BaseTransientBottomBar.this.view.requestLayout();
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$4, reason: invalid class name */
    public class AnonymousClass4 implements androidx.core.view.OnApplyWindowInsetsListener {
        public AnonymousClass4() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
            com.google.android.material.snackbar.BaseTransientBottomBar.this.extraBottomMarginWindowInset = windowInsetsCompat.getSystemWindowInsetBottom();
            com.google.android.material.snackbar.BaseTransientBottomBar.this.extraLeftMarginWindowInset = windowInsetsCompat.getSystemWindowInsetLeft();
            com.google.android.material.snackbar.BaseTransientBottomBar.this.extraRightMarginWindowInset = windowInsetsCompat.getSystemWindowInsetRight();
            com.google.android.material.snackbar.BaseTransientBottomBar.this.updateMargins();
            return windowInsetsCompat;
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$5, reason: invalid class name */
    public class AnonymousClass5 extends androidx.core.view.AccessibilityDelegateCompat {
        public AnonymousClass5() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(android.view.View view, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.addAction(1048576);
            accessibilityNodeInfoCompat.setDismissable(true);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(android.view.View view, int i, android.os.Bundle bundle) {
            if (i != 1048576) {
                return super.performAccessibilityAction(view, i, bundle);
            }
            com.google.android.material.snackbar.BaseTransientBottomBar.this.dismiss();
            return true;
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$6, reason: invalid class name */
    public class AnonymousClass6 implements com.google.android.material.snackbar.SnackbarManager.Callback {
        public AnonymousClass6() {
        }

        @Override // com.google.android.material.snackbar.SnackbarManager.Callback
        public void dismiss(int i) {
            android.os.Handler handler = com.google.android.material.snackbar.BaseTransientBottomBar.handler;
            handler.sendMessage(handler.obtainMessage(1, i, 0, com.google.android.material.snackbar.BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.SnackbarManager.Callback
        public void show() {
            android.os.Handler handler = com.google.android.material.snackbar.BaseTransientBottomBar.handler;
            handler.sendMessage(handler.obtainMessage(0, com.google.android.material.snackbar.BaseTransientBottomBar.this));
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$7, reason: invalid class name */
    public class AnonymousClass7 implements com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener {

        /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$7$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.google.android.material.snackbar.BaseTransientBottomBar.this.onViewHidden(3);
            }
        }

        public AnonymousClass7() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener
        public void onViewAttachedToWindow(android.view.View view) {
            android.view.WindowInsets rootWindowInsets;
            android.graphics.Insets mandatorySystemGestureInsets;
            int i;
            if (android.os.Build.VERSION.SDK_INT < 29 || (rootWindowInsets = com.google.android.material.snackbar.BaseTransientBottomBar.this.view.getRootWindowInsets()) == null) {
                return;
            }
            com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar = com.google.android.material.snackbar.BaseTransientBottomBar.this;
            mandatorySystemGestureInsets = rootWindowInsets.getMandatorySystemGestureInsets();
            i = mandatorySystemGestureInsets.bottom;
            baseTransientBottomBar.extraBottomMarginGestureInset = i;
            com.google.android.material.snackbar.BaseTransientBottomBar.this.updateMargins();
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
            if (com.google.android.material.snackbar.BaseTransientBottomBar.this.isShownOrQueued()) {
                com.google.android.material.snackbar.BaseTransientBottomBar.handler.post(new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass7.AnonymousClass1());
            }
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$8, reason: invalid class name */
    public class AnonymousClass8 implements com.google.android.material.snackbar.BaseTransientBottomBar.OnLayoutChangeListener {
        public AnonymousClass8() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnLayoutChangeListener
        public void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4) {
            com.google.android.material.snackbar.BaseTransientBottomBar.this.view.setOnLayoutChangeListener(null);
            com.google.android.material.snackbar.BaseTransientBottomBar.this.showViewImpl();
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$9, reason: invalid class name */
    public class AnonymousClass9 implements com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener {
        public AnonymousClass9() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
        public void onDismiss(@androidx.annotation.NonNull android.view.View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            com.google.android.material.snackbar.BaseTransientBottomBar.this.dispatchDismiss(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
        public void onDragStateChanged(int i) {
            if (i == 0) {
                com.google.android.material.snackbar.SnackbarManager.getInstance().restoreTimeoutIfPaused(com.google.android.material.snackbar.BaseTransientBottomBar.this.managerCallback);
            } else if (i == 1 || i == 2) {
                com.google.android.material.snackbar.SnackbarManager.getInstance().pauseTimeout(com.google.android.material.snackbar.BaseTransientBottomBar.this.managerCallback);
            }
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AnimationMode {
    }

    public static abstract class BaseCallback<B> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public @interface DismissEvent {
        }

        public void onDismissed(B b, int i) {
        }

        public void onShown(B b) {
        }
    }

    public static class Behavior extends com.google.android.material.behavior.SwipeDismissBehavior<android.view.View> {

        @androidx.annotation.NonNull
        private final com.google.android.material.snackbar.BaseTransientBottomBar.BehaviorDelegate delegate = new com.google.android.material.snackbar.BaseTransientBottomBar.BehaviorDelegate(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void setBaseTransientBottomBar(@androidx.annotation.NonNull com.google.android.material.snackbar.BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.delegate.setBaseTransientBottomBar(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean canSwipeDismissView(android.view.View view) {
            return this.delegate.canSwipeDismissView(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
            this.delegate.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static class BehaviorDelegate {
        private com.google.android.material.snackbar.SnackbarManager.Callback managerCallback;

        public BehaviorDelegate(@androidx.annotation.NonNull com.google.android.material.behavior.SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.setStartAlphaSwipeDistance(0.1f);
            swipeDismissBehavior.setEndAlphaSwipeDistance(0.6f);
            swipeDismissBehavior.setSwipeDirection(0);
        }

        public boolean canSwipeDismissView(android.view.View view) {
            return view instanceof com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout;
        }

        public void onInterceptTouchEvent(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.SnackbarManager.getInstance().pauseTimeout(this.managerCallback);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.SnackbarManager.getInstance().restoreTimeoutIfPaused(this.managerCallback);
            }
        }

        public void setBaseTransientBottomBar(@androidx.annotation.NonNull com.google.android.material.snackbar.BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.managerCallback = baseTransientBottomBar.managerCallback;
        }
    }

    @java.lang.Deprecated
    public interface ContentViewCallback extends com.google.android.material.snackbar.ContentViewCallback {
    }

    @androidx.annotation.IntRange(from = 1)
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Duration {
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnAttachStateChangeListener {
        void onViewAttachedToWindow(android.view.View view);

        void onViewDetachedFromWindow(android.view.View view);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnLayoutChangeListener {
        void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static class SnackbarBaseLayout extends android.widget.FrameLayout {
        private static final android.view.View.OnTouchListener consumeAllTouchListener = new com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout.AnonymousClass1();
        private final float actionTextColorAlpha;
        private int animationMode;
        private final float backgroundOverlayColorAlpha;
        private android.content.res.ColorStateList backgroundTint;
        private android.graphics.PorterDuff.Mode backgroundTintMode;
        private com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener onAttachStateChangeListener;
        private com.google.android.material.snackbar.BaseTransientBottomBar.OnLayoutChangeListener onLayoutChangeListener;

        /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.view.View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @android.annotation.SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                return true;
            }
        }

        public SnackbarBaseLayout(@androidx.annotation.NonNull android.content.Context context) {
            this(context, null);
        }

        public SnackbarBaseLayout(@androidx.annotation.NonNull android.content.Context context, android.util.AttributeSet attributeSet) {
            super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, 0, 0), attributeSet);
            android.content.Context context2 = getContext();
            android.content.res.TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(com.google.android.material.R.styleable.SnackbarLayout_elevation)) {
                androidx.core.view.ViewCompat.setElevation(this, obtainStyledAttributes.getDimensionPixelSize(r1, 0));
            }
            this.animationMode = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.SnackbarLayout_animationMode, 0);
            this.backgroundOverlayColorAlpha = obtainStyledAttributes.getFloat(com.google.android.material.R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainStyledAttributes, com.google.android.material.R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(com.google.android.material.internal.ViewUtils.parseTintMode(obtainStyledAttributes.getInt(com.google.android.material.R.styleable.SnackbarLayout_backgroundTintMode, -1), android.graphics.PorterDuff.Mode.SRC_IN));
            this.actionTextColorAlpha = obtainStyledAttributes.getFloat(com.google.android.material.R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(consumeAllTouchListener);
            setFocusable(true);
            if (getBackground() == null) {
                androidx.core.view.ViewCompat.setBackground(this, createThemedBackground());
            }
        }

        @androidx.annotation.NonNull
        private android.graphics.drawable.Drawable createThemedBackground() {
            float dimension = getResources().getDimension(com.google.android.material.R.dimen.mtrl_snackbar_background_corner_radius);
            android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(com.google.android.material.color.MaterialColors.layer(this, com.google.android.material.R.attr.colorSurface, com.google.android.material.R.attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.backgroundTint == null) {
                return androidx.core.graphics.drawable.DrawableCompat.wrap(gradientDrawable);
            }
            android.graphics.drawable.Drawable wrap = androidx.core.graphics.drawable.DrawableCompat.wrap(gradientDrawable);
            androidx.core.graphics.drawable.DrawableCompat.setTintList(wrap, this.backgroundTint);
            return wrap;
        }

        public float getActionTextColorAlpha() {
            return this.actionTextColorAlpha;
        }

        public int getAnimationMode() {
            return this.animationMode;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.backgroundOverlayColorAlpha;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener onAttachStateChangeListener = this.onAttachStateChangeListener;
            if (onAttachStateChangeListener != null) {
                onAttachStateChangeListener.onViewAttachedToWindow(this);
            }
            androidx.core.view.ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener onAttachStateChangeListener = this.onAttachStateChangeListener;
            if (onAttachStateChangeListener != null) {
                onAttachStateChangeListener.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            com.google.android.material.snackbar.BaseTransientBottomBar.OnLayoutChangeListener onLayoutChangeListener = this.onLayoutChangeListener;
            if (onLayoutChangeListener != null) {
                onLayoutChangeListener.onLayoutChange(this, i, i2, i3, i4);
            }
        }

        public void setAnimationMode(int i) {
            this.animationMode = i;
        }

        @Override // android.view.View
        public void setBackground(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            if (drawable != null && this.backgroundTint != null) {
                drawable = androidx.core.graphics.drawable.DrawableCompat.wrap(drawable.mutate());
                androidx.core.graphics.drawable.DrawableCompat.setTintList(drawable, this.backgroundTint);
                androidx.core.graphics.drawable.DrawableCompat.setTintMode(drawable, this.backgroundTintMode);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
            this.backgroundTint = colorStateList;
            if (getBackground() != null) {
                android.graphics.drawable.Drawable wrap = androidx.core.graphics.drawable.DrawableCompat.wrap(getBackground().mutate());
                androidx.core.graphics.drawable.DrawableCompat.setTintList(wrap, colorStateList);
                androidx.core.graphics.drawable.DrawableCompat.setTintMode(wrap, this.backgroundTintMode);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
            this.backgroundTintMode = mode;
            if (getBackground() != null) {
                android.graphics.drawable.Drawable wrap = androidx.core.graphics.drawable.DrawableCompat.wrap(getBackground().mutate());
                androidx.core.graphics.drawable.DrawableCompat.setTintMode(wrap, mode);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        public void setOnAttachStateChangeListener(com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener onAttachStateChangeListener) {
            this.onAttachStateChangeListener = onAttachStateChangeListener;
        }

        @Override // android.view.View
        public void setOnClickListener(@androidx.annotation.Nullable android.view.View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : consumeAllTouchListener);
            super.setOnClickListener(onClickListener);
        }

        public void setOnLayoutChangeListener(com.google.android.material.snackbar.BaseTransientBottomBar.OnLayoutChangeListener onLayoutChangeListener) {
            this.onLayoutChangeListener = onLayoutChangeListener;
        }
    }

    public BaseTransientBottomBar(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.google.android.material.snackbar.ContentViewCallback contentViewCallback) {
        this.anchorViewLayoutListenerEnabled = false;
        this.anchorViewLayoutListener = new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass2();
        this.bottomMarginGestureInsetRunnable = new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass3();
        this.managerCallback = new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass6();
        if (viewGroup == null) {
            throw new java.lang.IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new java.lang.IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (contentViewCallback == null) {
            throw new java.lang.IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.targetParent = viewGroup;
        this.contentViewCallback = contentViewCallback;
        this.context = context;
        com.google.android.material.internal.ThemeEnforcement.checkAppCompatTheme(context);
        com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout snackbarBaseLayout = (com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout) android.view.LayoutInflater.from(context).inflate(getSnackbarBaseLayoutResId(), viewGroup, false);
        this.view = snackbarBaseLayout;
        if (view instanceof com.google.android.material.snackbar.SnackbarContentLayout) {
            ((com.google.android.material.snackbar.SnackbarContentLayout) view).updateActionTextColorAlphaIfNeeded(snackbarBaseLayout.getActionTextColorAlpha());
        }
        snackbarBaseLayout.addView(view);
        android.view.ViewGroup.LayoutParams layoutParams = snackbarBaseLayout.getLayoutParams();
        if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) layoutParams;
            this.originalMargins = new android.graphics.Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        androidx.core.view.ViewCompat.setAccessibilityLiveRegion(snackbarBaseLayout, 1);
        androidx.core.view.ViewCompat.setImportantForAccessibility(snackbarBaseLayout, 1);
        androidx.core.view.ViewCompat.setFitsSystemWindows(snackbarBaseLayout, true);
        androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(snackbarBaseLayout, new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass4());
        androidx.core.view.ViewCompat.setAccessibilityDelegate(snackbarBaseLayout, new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass5());
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) context.getSystemService("accessibility");
    }

    public BaseTransientBottomBar(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.google.android.material.snackbar.ContentViewCallback contentViewCallback) {
        this(viewGroup.getContext(), viewGroup, view, contentViewCallback);
    }

    private void animateViewOut(int i) {
        if (this.view.getAnimationMode() == 1) {
            startFadeOutAnimation(i);
        } else {
            startSlideOutAnimation(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calculateBottomMarginForAnchorView() {
        android.view.View view = this.anchorView;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[1];
        int[] iArr2 = new int[2];
        this.targetParent.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.targetParent.getHeight()) - i;
    }

    private android.animation.ValueAnimator getAlphaAnimator(float... fArr) {
        android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.addUpdateListener(new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass13());
        return ofFloat;
    }

    private android.animation.ValueAnimator getScaleAnimator(float... fArr) {
        android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(com.google.android.material.animation.AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat.addUpdateListener(new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass14());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.RequiresApi(17)
    public int getScreenHeight() {
        android.view.WindowManager windowManager = (android.view.WindowManager) this.context.getSystemService("window");
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private int getTranslationYBottom() {
        int height = this.view.getHeight();
        android.view.ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        return layoutParams instanceof android.view.ViewGroup.MarginLayoutParams ? height + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getViewAbsoluteBottom() {
        int[] iArr = new int[2];
        this.view.getLocationOnScreen(iArr);
        return iArr[1] + this.view.getHeight();
    }

    private boolean isSwipeDismissable() {
        android.view.ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        return (layoutParams instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) && (((androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof com.google.android.material.behavior.SwipeDismissBehavior);
    }

    private void setUpBehavior(androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams layoutParams) {
        com.google.android.material.behavior.SwipeDismissBehavior<? extends android.view.View> swipeDismissBehavior = this.behavior;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = getNewBehavior();
        }
        if (swipeDismissBehavior instanceof com.google.android.material.snackbar.BaseTransientBottomBar.Behavior) {
            ((com.google.android.material.snackbar.BaseTransientBottomBar.Behavior) swipeDismissBehavior).setBaseTransientBottomBar(this);
        }
        swipeDismissBehavior.setListener(new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass9());
        layoutParams.setBehavior(swipeDismissBehavior);
        if (this.anchorView == null) {
            layoutParams.insetEdge = 80;
        }
    }

    private boolean shouldUpdateGestureInset() {
        return this.extraBottomMarginGestureInset > 0 && !this.gestureInsetBottomIgnored && isSwipeDismissable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showViewImpl() {
        if (shouldAnimate()) {
            animateViewIn();
            return;
        }
        if (this.view.getParent() != null) {
            this.view.setVisibility(0);
        }
        onViewShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFadeInAnimation() {
        android.animation.ValueAnimator alphaAnimator = getAlphaAnimator(0.0f, 1.0f);
        android.animation.ValueAnimator scaleAnimator = getScaleAnimator(ANIMATION_SCALE_FROM_VALUE, 1.0f);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(alphaAnimator, scaleAnimator);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass11());
        animatorSet.start();
    }

    private void startFadeOutAnimation(int i) {
        android.animation.ValueAnimator alphaAnimator = getAlphaAnimator(1.0f, 0.0f);
        alphaAnimator.setDuration(75L);
        alphaAnimator.addListener(new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass12(i));
        alphaAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSlideInAnimation() {
        int translationYBottom = getTranslationYBottom();
        if (USE_OFFSET_API) {
            androidx.core.view.ViewCompat.offsetTopAndBottom(this.view, translationYBottom);
        } else {
            this.view.setTranslationY(translationYBottom);
        }
        android.animation.ValueAnimator valueAnimator = new android.animation.ValueAnimator();
        valueAnimator.setIntValues(translationYBottom, 0);
        valueAnimator.setInterpolator(com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass15());
        valueAnimator.addUpdateListener(new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass16(translationYBottom));
        valueAnimator.start();
    }

    private void startSlideOutAnimation(int i) {
        android.animation.ValueAnimator valueAnimator = new android.animation.ValueAnimator();
        valueAnimator.setIntValues(0, getTranslationYBottom());
        valueAnimator.setInterpolator(com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass17(i));
        valueAnimator.addUpdateListener(new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass18());
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMargins() {
        android.graphics.Rect rect;
        android.view.ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (!(layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) || (rect = this.originalMargins) == null) {
            return;
        }
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = rect.bottom + (this.anchorView != null ? this.extraBottomMarginAnchorView : this.extraBottomMarginWindowInset);
        marginLayoutParams.leftMargin = rect.left + this.extraLeftMarginWindowInset;
        marginLayoutParams.rightMargin = rect.right + this.extraRightMarginWindowInset;
        this.view.requestLayout();
        if (android.os.Build.VERSION.SDK_INT < 29 || !shouldUpdateGestureInset()) {
            return;
        }
        this.view.removeCallbacks(this.bottomMarginGestureInsetRunnable);
        this.view.post(this.bottomMarginGestureInsetRunnable);
    }

    @androidx.annotation.NonNull
    public B addCallback(@androidx.annotation.Nullable com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback<B> baseCallback) {
        if (baseCallback == null) {
            return this;
        }
        if (this.callbacks == null) {
            this.callbacks = new java.util.ArrayList();
        }
        this.callbacks.add(baseCallback);
        return this;
    }

    public void animateViewIn() {
        this.view.post(new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass10());
    }

    public void dismiss() {
        dispatchDismiss(3);
    }

    public void dispatchDismiss(int i) {
        com.google.android.material.snackbar.SnackbarManager.getInstance().dismiss(this.managerCallback, i);
    }

    @androidx.annotation.Nullable
    public android.view.View getAnchorView() {
        return this.anchorView;
    }

    public int getAnimationMode() {
        return this.view.getAnimationMode();
    }

    public com.google.android.material.snackbar.BaseTransientBottomBar.Behavior getBehavior() {
        return this.behavior;
    }

    @androidx.annotation.NonNull
    public android.content.Context getContext() {
        return this.context;
    }

    public int getDuration() {
        return this.duration;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.behavior.SwipeDismissBehavior<? extends android.view.View> getNewBehavior() {
        return new com.google.android.material.snackbar.BaseTransientBottomBar.Behavior();
    }

    @androidx.annotation.LayoutRes
    public int getSnackbarBaseLayoutResId() {
        return hasSnackbarStyleAttr() ? com.google.android.material.R.layout.mtrl_layout_snackbar : com.google.android.material.R.layout.design_layout_snackbar;
    }

    @androidx.annotation.NonNull
    public android.view.View getView() {
        return this.view;
    }

    public boolean hasSnackbarStyleAttr() {
        android.content.res.TypedArray obtainStyledAttributes = this.context.obtainStyledAttributes(SNACKBAR_STYLE_ATTR);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public final void hideView(int i) {
        if (shouldAnimate() && this.view.getVisibility() == 0) {
            animateViewOut(i);
        } else {
            onViewHidden(i);
        }
    }

    public boolean isAnchorViewLayoutListenerEnabled() {
        return this.anchorViewLayoutListenerEnabled;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isShown() {
        return com.google.android.material.snackbar.SnackbarManager.getInstance().isCurrent(this.managerCallback);
    }

    public boolean isShownOrQueued() {
        return com.google.android.material.snackbar.SnackbarManager.getInstance().isCurrentOrNext(this.managerCallback);
    }

    public void onViewHidden(int i) {
        com.google.android.material.snackbar.SnackbarManager.getInstance().onDismissed(this.managerCallback);
        java.util.List<com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback<B>> list = this.callbacks;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.callbacks.get(size).onDismissed(this, i);
            }
        }
        android.view.ViewParent parent = this.view.getParent();
        if (parent instanceof android.view.ViewGroup) {
            ((android.view.ViewGroup) parent).removeView(this.view);
        }
    }

    public void onViewShown() {
        com.google.android.material.snackbar.SnackbarManager.getInstance().onShown(this.managerCallback);
        java.util.List<com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback<B>> list = this.callbacks;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.callbacks.get(size).onShown(this);
            }
        }
    }

    @androidx.annotation.NonNull
    public B removeCallback(@androidx.annotation.Nullable com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback<B> baseCallback) {
        java.util.List<com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback<B>> list;
        if (baseCallback == null || (list = this.callbacks) == null) {
            return this;
        }
        list.remove(baseCallback);
        return this;
    }

    @androidx.annotation.NonNull
    public B setAnchorView(@androidx.annotation.IdRes int i) {
        android.view.View findViewById = this.targetParent.findViewById(i);
        if (findViewById != null) {
            return setAnchorView(findViewById);
        }
        throw new java.lang.IllegalArgumentException("Unable to find anchor view with id: " + i);
    }

    @androidx.annotation.NonNull
    public B setAnchorView(@androidx.annotation.Nullable android.view.View view) {
        com.google.android.material.internal.ViewUtils.removeOnGlobalLayoutListener(this.anchorView, this.anchorViewLayoutListener);
        this.anchorView = view;
        com.google.android.material.internal.ViewUtils.addOnGlobalLayoutListener(view, this.anchorViewLayoutListener);
        return this;
    }

    public void setAnchorViewLayoutListenerEnabled(boolean z) {
        this.anchorViewLayoutListenerEnabled = z;
    }

    @androidx.annotation.NonNull
    public B setAnimationMode(int i) {
        this.view.setAnimationMode(i);
        return this;
    }

    @androidx.annotation.NonNull
    public B setBehavior(com.google.android.material.snackbar.BaseTransientBottomBar.Behavior behavior) {
        this.behavior = behavior;
        return this;
    }

    @androidx.annotation.NonNull
    public B setDuration(int i) {
        this.duration = i;
        return this;
    }

    @androidx.annotation.NonNull
    public B setGestureInsetBottomIgnored(boolean z) {
        this.gestureInsetBottomIgnored = z;
        return this;
    }

    public boolean shouldAnimate() {
        android.view.accessibility.AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null) {
            return true;
        }
        java.util.List<android.accessibilityservice.AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void show() {
        com.google.android.material.snackbar.SnackbarManager.getInstance().show(getDuration(), this.managerCallback);
    }

    public final void showView() {
        this.view.setOnAttachStateChangeListener(new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass7());
        if (this.view.getParent() == null) {
            android.view.ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (layoutParams instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) {
                setUpBehavior((androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) layoutParams);
            }
            this.extraBottomMarginAnchorView = calculateBottomMarginForAnchorView();
            updateMargins();
            this.view.setVisibility(4);
            this.targetParent.addView(this.view);
        }
        if (androidx.core.view.ViewCompat.isLaidOut(this.view)) {
            showViewImpl();
        } else {
            this.view.setOnLayoutChangeListener(new com.google.android.material.snackbar.BaseTransientBottomBar.AnonymousClass8());
        }
    }
}
