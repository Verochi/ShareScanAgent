package androidx.core.view;

/* loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {
    static final int LISTENER_TAG_ID = 2113929216;
    private java.lang.ref.WeakReference<android.view.View> mView;
    java.lang.Runnable mStartAction = null;
    java.lang.Runnable mEndAction = null;
    int mOldLayerType = -1;

    /* renamed from: androidx.core.view.ViewPropertyAnimatorCompat$1, reason: invalid class name */
    public class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ androidx.core.view.ViewPropertyAnimatorListener val$listener;
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass1(androidx.core.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener, android.view.View view) {
            this.val$listener = viewPropertyAnimatorListener;
            this.val$view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            this.val$listener.onAnimationCancel(this.val$view);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            this.val$listener.onAnimationEnd(this.val$view);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            this.val$listener.onAnimationStart(this.val$view);
        }
    }

    /* renamed from: androidx.core.view.ViewPropertyAnimatorCompat$2, reason: invalid class name */
    public class AnonymousClass2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ androidx.core.view.ViewPropertyAnimatorUpdateListener val$listener;
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass2(androidx.core.view.ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, android.view.View view) {
            this.val$listener = viewPropertyAnimatorUpdateListener;
            this.val$view = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            this.val$listener.onAnimationUpdate(this.val$view);
        }
    }

    public static class ViewPropertyAnimatorListenerApi14 implements androidx.core.view.ViewPropertyAnimatorListener {
        boolean mAnimEndCalled;
        androidx.core.view.ViewPropertyAnimatorCompat mVpa;

        public ViewPropertyAnimatorListenerApi14(androidx.core.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.mVpa = viewPropertyAnimatorCompat;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(android.view.View view) {
            java.lang.Object tag = view.getTag(androidx.core.view.ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            androidx.core.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof androidx.core.view.ViewPropertyAnimatorListener ? (androidx.core.view.ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationCancel(view);
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        @android.annotation.SuppressLint({"WrongConstant"})
        public void onAnimationEnd(android.view.View view) {
            int i = this.mVpa.mOldLayerType;
            if (i > -1) {
                view.setLayerType(i, null);
                this.mVpa.mOldLayerType = -1;
            }
            androidx.core.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
            java.lang.Runnable runnable = viewPropertyAnimatorCompat.mEndAction;
            if (runnable != null) {
                viewPropertyAnimatorCompat.mEndAction = null;
                runnable.run();
            }
            java.lang.Object tag = view.getTag(androidx.core.view.ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            androidx.core.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof androidx.core.view.ViewPropertyAnimatorListener ? (androidx.core.view.ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationEnd(view);
            }
            this.mAnimEndCalled = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(android.view.View view) {
            this.mAnimEndCalled = false;
            if (this.mVpa.mOldLayerType > -1) {
                view.setLayerType(2, null);
            }
            androidx.core.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
            java.lang.Runnable runnable = viewPropertyAnimatorCompat.mStartAction;
            if (runnable != null) {
                viewPropertyAnimatorCompat.mStartAction = null;
                runnable.run();
            }
            java.lang.Object tag = view.getTag(androidx.core.view.ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            androidx.core.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof androidx.core.view.ViewPropertyAnimatorListener ? (androidx.core.view.ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(view);
            }
        }
    }

    public ViewPropertyAnimatorCompat(android.view.View view) {
        this.mView = new java.lang.ref.WeakReference<>(view);
    }

    private void setListenerInternal(android.view.View view, androidx.core.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new androidx.core.view.ViewPropertyAnimatorCompat.AnonymousClass1(viewPropertyAnimatorListener, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public androidx.core.view.ViewPropertyAnimatorCompat alpha(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat alphaBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().alphaBy(f);
        }
        return this;
    }

    public void cancel() {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long getDuration() {
        android.view.View view = this.mView.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public android.view.animation.Interpolator getInterpolator() {
        android.view.View view = this.mView.get();
        if (view != null) {
            return (android.view.animation.Interpolator) view.animate().getInterpolator();
        }
        return null;
    }

    public long getStartDelay() {
        android.view.View view = this.mView.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0L;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat rotation(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().rotation(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat rotationBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().rotationBy(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat rotationX(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().rotationX(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat rotationXBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().rotationXBy(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat rotationY(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().rotationY(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat rotationYBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().rotationYBy(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat scaleX(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().scaleX(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat scaleXBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().scaleXBy(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat scaleY(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().scaleY(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat scaleYBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().scaleYBy(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat setDuration(long j) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat setInterpolator(android.view.animation.Interpolator interpolator) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat setListener(androidx.core.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        android.view.View view = this.mView.get();
        if (view != null) {
            setListenerInternal(view, viewPropertyAnimatorListener);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat setStartDelay(long j) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat setUpdateListener(androidx.core.view.ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().setUpdateListener(viewPropertyAnimatorUpdateListener != null ? new androidx.core.view.ViewPropertyAnimatorCompat.AnonymousClass2(viewPropertyAnimatorUpdateListener, view) : null);
        }
        return this;
    }

    public void start() {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public androidx.core.view.ViewPropertyAnimatorCompat translationX(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().translationX(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat translationXBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().translationXBy(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat translationY(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat translationYBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().translationYBy(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat translationZ(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().translationZ(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat translationZBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().translationZBy(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat withEndAction(java.lang.Runnable runnable) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().withEndAction(runnable);
        }
        return this;
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    public androidx.core.view.ViewPropertyAnimatorCompat withLayer() {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().withLayer();
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat withStartAction(java.lang.Runnable runnable) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().withStartAction(runnable);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat x(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().x(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat xBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().xBy(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat y(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().y(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat yBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().yBy(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat z(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().z(f);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat zBy(float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            view.animate().zBy(f);
        }
        return this;
    }
}
