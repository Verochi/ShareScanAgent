package com.amap.api.maps;

/* loaded from: classes12.dex */
public class SwipeDismissTouchListener implements android.view.View.OnTouchListener {
    public static final int A_HALF = 2;
    public static final int MIN_VIEW_WIDTH = 2;
    public static final int ONE_THIRD = 3;
    private long mAnimationTime;
    private com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks mCallbacks;
    private boolean mCanFinish;
    private float mDownX;
    private float mDownY;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private boolean mO;
    private int mSlop;
    private boolean mSwiping;
    private int mSwipingSlop;
    private java.lang.Object mToken;
    private float mTranslationX;
    private android.view.VelocityTracker mVelocityTracker;
    private android.view.View mView;
    private int mViewWidth = 1;

    /* renamed from: com.amap.api.maps.SwipeDismissTouchListener$1, reason: invalid class name */
    public class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(android.animation.Animator animator) {
            com.amap.api.maps.SwipeDismissTouchListener.this.a();
        }
    }

    /* renamed from: com.amap.api.maps.SwipeDismissTouchListener$2, reason: invalid class name */
    public class AnonymousClass2 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ android.view.ViewGroup.LayoutParams a;
        final /* synthetic */ int b;

        public AnonymousClass2(android.view.ViewGroup.LayoutParams layoutParams, int i) {
            this.a = layoutParams;
            this.b = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(android.animation.Animator animator) {
            com.amap.api.maps.SwipeDismissTouchListener.this.mView.setAlpha(0.0f);
            com.amap.api.maps.SwipeDismissTouchListener.this.mView.setTranslationX(0.0f);
            this.a.height = this.b;
            com.amap.api.maps.SwipeDismissTouchListener.this.mView.setLayoutParams(this.a);
        }
    }

    /* renamed from: com.amap.api.maps.SwipeDismissTouchListener$3, reason: invalid class name */
    public class AnonymousClass3 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ android.view.ViewGroup.LayoutParams a;

        public AnonymousClass3(android.view.ViewGroup.LayoutParams layoutParams) {
            this.a = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            this.a.height = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
            com.amap.api.maps.SwipeDismissTouchListener.this.mView.setLayoutParams(this.a);
        }
    }

    public interface DismissCallbacks {
        boolean canDismiss(java.lang.Object obj);

        void onDismiss(android.view.View view, java.lang.Object obj);

        void onNotifySwipe();
    }

    public SwipeDismissTouchListener(android.view.View view, java.lang.Object obj, com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks dismissCallbacks) {
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(view.getContext());
        this.mSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mAnimationTime = view.getContext().getResources().getInteger(android.R.integer.config_shortAnimTime);
        this.mView = view;
        this.mToken = obj;
        this.mCallbacks = dismissCallbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.mCallbacks.onDismiss(this.mView, this.mToken);
        android.view.ViewGroup.LayoutParams layoutParams = this.mView.getLayoutParams();
        int height = this.mView.getHeight();
        android.animation.ValueAnimator duration = android.animation.ValueAnimator.ofInt(height, 1).setDuration(this.mAnimationTime);
        duration.addListener(new com.amap.api.maps.SwipeDismissTouchListener.AnonymousClass2(layoutParams, height));
        duration.addUpdateListener(new com.amap.api.maps.SwipeDismissTouchListener.AnonymousClass3(layoutParams));
        duration.start();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        boolean z;
        motionEvent.offsetLocation(this.mTranslationX, 0.0f);
        if (this.mViewWidth < 2) {
            this.mViewWidth = this.mView.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mDownX = motionEvent.getRawX();
            this.mDownY = motionEvent.getRawY();
            if (this.mCallbacks.canDismiss(this.mToken)) {
                this.mO = false;
                android.view.VelocityTracker obtain = android.view.VelocityTracker.obtain();
                this.mVelocityTracker = obtain;
                obtain.addMovement(motionEvent);
            }
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                android.view.VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    float rawX = motionEvent.getRawX() - this.mDownX;
                    float rawY = motionEvent.getRawY() - this.mDownY;
                    if (java.lang.Math.abs(rawX) > this.mSlop && java.lang.Math.abs(rawY) < java.lang.Math.abs(rawX) / 2.0f) {
                        this.mSwiping = true;
                        this.mSwipingSlop = rawX > 0.0f ? this.mSlop : -this.mSlop;
                        this.mView.getParent().requestDisallowInterceptTouchEvent(true);
                        if (!this.mO) {
                            this.mO = true;
                            this.mCallbacks.onNotifySwipe();
                        }
                        if (java.lang.Math.abs(rawX) <= this.mViewWidth / 3) {
                            this.mCanFinish = false;
                        } else if (!this.mCanFinish) {
                            this.mCanFinish = true;
                            this.mCallbacks.onNotifySwipe();
                        }
                        android.view.MotionEvent obtain2 = android.view.MotionEvent.obtain(motionEvent);
                        obtain2.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.mView.onTouchEvent(obtain2);
                        obtain2.recycle();
                    }
                    if (this.mSwiping) {
                        this.mTranslationX = rawX;
                        this.mView.setTranslationX(rawX - this.mSwipingSlop);
                        this.mView.setAlpha(java.lang.Math.max(0.0f, java.lang.Math.min(1.0f, 1.0f - ((java.lang.Math.abs(rawX) * 2.0f) / this.mViewWidth))));
                        return true;
                    }
                }
            } else if (actionMasked == 3 && this.mVelocityTracker != null) {
                this.mView.animate().translationX(0.0f).alpha(1.0f).setDuration(this.mAnimationTime).setListener(null);
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                this.mTranslationX = 0.0f;
                this.mDownX = 0.0f;
                this.mDownY = 0.0f;
                this.mSwiping = false;
            }
        } else if (this.mVelocityTracker != null) {
            float rawX2 = motionEvent.getRawX() - this.mDownX;
            this.mVelocityTracker.addMovement(motionEvent);
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xVelocity = this.mVelocityTracker.getXVelocity();
            float abs = java.lang.Math.abs(xVelocity);
            float abs2 = java.lang.Math.abs(this.mVelocityTracker.getYVelocity());
            if (java.lang.Math.abs(rawX2) > this.mViewWidth / 2 && this.mSwiping) {
                z = rawX2 > 0.0f;
            } else if (this.mMinFlingVelocity > abs || abs > this.mMaxFlingVelocity || abs2 >= abs || !this.mSwiping) {
                z = false;
                r3 = false;
            } else {
                r3 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX2 > 0.0f ? 1 : (rawX2 == 0.0f ? 0 : -1)) < 0);
                z = this.mVelocityTracker.getXVelocity() > 0.0f;
            }
            if (r3) {
                this.mView.animate().translationX(z ? this.mViewWidth : -this.mViewWidth).alpha(0.0f).setDuration(50L).setListener(new com.amap.api.maps.SwipeDismissTouchListener.AnonymousClass1());
            } else if (this.mSwiping) {
                this.mView.animate().translationX(0.0f).alpha(1.0f).setDuration(this.mAnimationTime).setListener(null);
            }
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mTranslationX = 0.0f;
            this.mDownX = 0.0f;
            this.mDownY = 0.0f;
            this.mSwiping = false;
        }
        return false;
    }
}
