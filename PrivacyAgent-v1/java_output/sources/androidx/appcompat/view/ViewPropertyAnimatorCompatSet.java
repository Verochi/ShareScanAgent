package androidx.appcompat.view;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ViewPropertyAnimatorCompatSet {
    private android.view.animation.Interpolator mInterpolator;
    private boolean mIsStarted;
    androidx.core.view.ViewPropertyAnimatorListener mListener;
    private long mDuration = -1;
    private final androidx.core.view.ViewPropertyAnimatorListenerAdapter mProxyListener = new androidx.appcompat.view.ViewPropertyAnimatorCompatSet.AnonymousClass1();
    final java.util.ArrayList<androidx.core.view.ViewPropertyAnimatorCompat> mAnimators = new java.util.ArrayList<>();

    /* renamed from: androidx.appcompat.view.ViewPropertyAnimatorCompatSet$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.core.view.ViewPropertyAnimatorListenerAdapter {
        private boolean mProxyStarted = false;
        private int mProxyEndCount = 0;

        public AnonymousClass1() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(android.view.View view) {
            int i = this.mProxyEndCount + 1;
            this.mProxyEndCount = i;
            if (i == androidx.appcompat.view.ViewPropertyAnimatorCompatSet.this.mAnimators.size()) {
                androidx.core.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener = androidx.appcompat.view.ViewPropertyAnimatorCompatSet.this.mListener;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd(null);
                }
                onEnd();
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(android.view.View view) {
            if (this.mProxyStarted) {
                return;
            }
            this.mProxyStarted = true;
            androidx.core.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener = androidx.appcompat.view.ViewPropertyAnimatorCompatSet.this.mListener;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(null);
            }
        }

        public void onEnd() {
            this.mProxyEndCount = 0;
            this.mProxyStarted = false;
            androidx.appcompat.view.ViewPropertyAnimatorCompatSet.this.onAnimationsEnded();
        }
    }

    public void cancel() {
        if (this.mIsStarted) {
            java.util.Iterator<androidx.core.view.ViewPropertyAnimatorCompat> it = this.mAnimators.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.mIsStarted = false;
        }
    }

    public void onAnimationsEnded() {
        this.mIsStarted = false;
    }

    public androidx.appcompat.view.ViewPropertyAnimatorCompatSet play(androidx.core.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.mIsStarted) {
            this.mAnimators.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public androidx.appcompat.view.ViewPropertyAnimatorCompatSet playSequentially(androidx.core.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, androidx.core.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.mAnimators.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.mAnimators.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public androidx.appcompat.view.ViewPropertyAnimatorCompatSet setDuration(long j) {
        if (!this.mIsStarted) {
            this.mDuration = j;
        }
        return this;
    }

    public androidx.appcompat.view.ViewPropertyAnimatorCompatSet setInterpolator(android.view.animation.Interpolator interpolator) {
        if (!this.mIsStarted) {
            this.mInterpolator = interpolator;
        }
        return this;
    }

    public androidx.appcompat.view.ViewPropertyAnimatorCompatSet setListener(androidx.core.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.mIsStarted) {
            this.mListener = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void start() {
        if (this.mIsStarted) {
            return;
        }
        java.util.Iterator<androidx.core.view.ViewPropertyAnimatorCompat> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            androidx.core.view.ViewPropertyAnimatorCompat next = it.next();
            long j = this.mDuration;
            if (j >= 0) {
                next.setDuration(j);
            }
            android.view.animation.Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                next.setInterpolator(interpolator);
            }
            if (this.mListener != null) {
                next.setListener(this.mProxyListener);
            }
            next.start();
        }
        this.mIsStarted = true;
    }
}
