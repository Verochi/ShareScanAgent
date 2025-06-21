package androidx.fragment.app;

/* loaded from: classes.dex */
class FragmentAnim {

    /* renamed from: androidx.fragment.app.FragmentAnim$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.core.os.CancellationSignal.OnCancelListener {
        final /* synthetic */ androidx.fragment.app.Fragment val$fragment;

        public AnonymousClass1(androidx.fragment.app.Fragment fragment) {
            this.val$fragment = fragment;
        }

        @Override // androidx.core.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            if (this.val$fragment.getAnimatingAway() != null) {
                android.view.View animatingAway = this.val$fragment.getAnimatingAway();
                this.val$fragment.setAnimatingAway(null);
                animatingAway.clearAnimation();
            }
            this.val$fragment.setAnimator(null);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentAnim$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.animation.Animation.AnimationListener {
        final /* synthetic */ androidx.fragment.app.FragmentTransition.Callback val$callback;
        final /* synthetic */ android.view.ViewGroup val$container;
        final /* synthetic */ androidx.fragment.app.Fragment val$fragment;
        final /* synthetic */ androidx.core.os.CancellationSignal val$signal;

        /* renamed from: androidx.fragment.app.FragmentAnim$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (androidx.fragment.app.FragmentAnim.AnonymousClass2.this.val$fragment.getAnimatingAway() != null) {
                    androidx.fragment.app.FragmentAnim.AnonymousClass2.this.val$fragment.setAnimatingAway(null);
                    androidx.fragment.app.FragmentAnim.AnonymousClass2 anonymousClass2 = androidx.fragment.app.FragmentAnim.AnonymousClass2.this;
                    anonymousClass2.val$callback.onComplete(anonymousClass2.val$fragment, anonymousClass2.val$signal);
                }
            }
        }

        public AnonymousClass2(android.view.ViewGroup viewGroup, androidx.fragment.app.Fragment fragment, androidx.fragment.app.FragmentTransition.Callback callback, androidx.core.os.CancellationSignal cancellationSignal) {
            this.val$container = viewGroup;
            this.val$fragment = fragment;
            this.val$callback = callback;
            this.val$signal = cancellationSignal;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            this.val$container.post(new androidx.fragment.app.FragmentAnim.AnonymousClass2.AnonymousClass1());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
        }
    }

    /* renamed from: androidx.fragment.app.FragmentAnim$3, reason: invalid class name */
    public class AnonymousClass3 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ androidx.fragment.app.FragmentTransition.Callback val$callback;
        final /* synthetic */ android.view.ViewGroup val$container;
        final /* synthetic */ androidx.fragment.app.Fragment val$fragment;
        final /* synthetic */ androidx.core.os.CancellationSignal val$signal;
        final /* synthetic */ android.view.View val$viewToAnimate;

        public AnonymousClass3(android.view.ViewGroup viewGroup, android.view.View view, androidx.fragment.app.Fragment fragment, androidx.fragment.app.FragmentTransition.Callback callback, androidx.core.os.CancellationSignal cancellationSignal) {
            this.val$container = viewGroup;
            this.val$viewToAnimate = view;
            this.val$fragment = fragment;
            this.val$callback = callback;
            this.val$signal = cancellationSignal;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            this.val$container.endViewTransition(this.val$viewToAnimate);
            android.animation.Animator animator2 = this.val$fragment.getAnimator();
            this.val$fragment.setAnimator(null);
            if (animator2 == null || this.val$container.indexOfChild(this.val$viewToAnimate) >= 0) {
                return;
            }
            this.val$callback.onComplete(this.val$fragment, this.val$signal);
        }
    }

    public static class AnimationOrAnimator {
        public final android.view.animation.Animation animation;
        public final android.animation.Animator animator;

        public AnimationOrAnimator(android.animation.Animator animator) {
            this.animation = null;
            this.animator = animator;
            if (animator == null) {
                throw new java.lang.IllegalStateException("Animator cannot be null");
            }
        }

        public AnimationOrAnimator(android.view.animation.Animation animation) {
            this.animation = animation;
            this.animator = null;
            if (animation == null) {
                throw new java.lang.IllegalStateException("Animation cannot be null");
            }
        }
    }

    public static class EndViewTransitionAnimation extends android.view.animation.AnimationSet implements java.lang.Runnable {
        private boolean mAnimating;
        private final android.view.View mChild;
        private boolean mEnded;
        private final android.view.ViewGroup mParent;
        private boolean mTransitionEnded;

        public EndViewTransitionAnimation(@androidx.annotation.NonNull android.view.animation.Animation animation, @androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull android.view.View view) {
            super(false);
            this.mAnimating = true;
            this.mParent = viewGroup;
            this.mChild = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, @androidx.annotation.NonNull android.view.animation.Transformation transformation) {
            this.mAnimating = true;
            if (this.mEnded) {
                return !this.mTransitionEnded;
            }
            if (!super.getTransformation(j, transformation)) {
                this.mEnded = true;
                androidx.core.view.OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, @androidx.annotation.NonNull android.view.animation.Transformation transformation, float f) {
            this.mAnimating = true;
            if (this.mEnded) {
                return !this.mTransitionEnded;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.mEnded = true;
                androidx.core.view.OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mEnded || !this.mAnimating) {
                this.mParent.endViewTransition(this.mChild);
                this.mTransitionEnded = true;
            } else {
                this.mAnimating = false;
                this.mParent.post(this);
            }
        }
    }

    private FragmentAnim() {
    }

    public static void animateRemoveFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull androidx.fragment.app.FragmentAnim.AnimationOrAnimator animationOrAnimator, @androidx.annotation.NonNull androidx.fragment.app.FragmentTransition.Callback callback) {
        android.view.View view = fragment.mView;
        android.view.ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        androidx.core.os.CancellationSignal cancellationSignal = new androidx.core.os.CancellationSignal();
        cancellationSignal.setOnCancelListener(new androidx.fragment.app.FragmentAnim.AnonymousClass1(fragment));
        callback.onStart(fragment, cancellationSignal);
        if (animationOrAnimator.animation != null) {
            androidx.fragment.app.FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new androidx.fragment.app.FragmentAnim.EndViewTransitionAnimation(animationOrAnimator.animation, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            endViewTransitionAnimation.setAnimationListener(new androidx.fragment.app.FragmentAnim.AnonymousClass2(viewGroup, fragment, callback, cancellationSignal));
            fragment.mView.startAnimation(endViewTransitionAnimation);
            return;
        }
        android.animation.Animator animator = animationOrAnimator.animator;
        fragment.setAnimator(animator);
        animator.addListener(new androidx.fragment.app.FragmentAnim.AnonymousClass3(viewGroup, view, fragment, callback, cancellationSignal));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    private static int getNextAnim(androidx.fragment.app.Fragment fragment, boolean z, boolean z2) {
        return z2 ? z ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z ? fragment.getEnterAnim() : fragment.getExitAnim();
    }

    public static androidx.fragment.app.FragmentAnim.AnimationOrAnimator loadAnimation(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, boolean z, boolean z2) {
        int nextTransition = fragment.getNextTransition();
        int nextAnim = getNextAnim(fragment, z, z2);
        boolean z3 = false;
        fragment.setAnimations(0, 0, 0, 0);
        android.view.ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i = androidx.fragment.R.id.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i) != null) {
                fragment.mContainer.setTag(i, null);
            }
        }
        android.view.ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        android.view.animation.Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, nextAnim);
        if (onCreateAnimation != null) {
            return new androidx.fragment.app.FragmentAnim.AnimationOrAnimator(onCreateAnimation);
        }
        android.animation.Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, nextAnim);
        if (onCreateAnimator != null) {
            return new androidx.fragment.app.FragmentAnim.AnimationOrAnimator(onCreateAnimator);
        }
        if (nextAnim == 0 && nextTransition != 0) {
            nextAnim = transitToAnimResourceId(nextTransition, z);
        }
        if (nextAnim != 0) {
            boolean equals = com.anythink.expressad.foundation.h.i.f.equals(context.getResources().getResourceTypeName(nextAnim));
            if (equals) {
                try {
                    android.view.animation.Animation loadAnimation = android.view.animation.AnimationUtils.loadAnimation(context, nextAnim);
                    if (loadAnimation != null) {
                        return new androidx.fragment.app.FragmentAnim.AnimationOrAnimator(loadAnimation);
                    }
                    z3 = true;
                } catch (android.content.res.Resources.NotFoundException e) {
                    throw e;
                } catch (java.lang.RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    android.animation.Animator loadAnimator = android.animation.AnimatorInflater.loadAnimator(context, nextAnim);
                    if (loadAnimator != null) {
                        return new androidx.fragment.app.FragmentAnim.AnimationOrAnimator(loadAnimator);
                    }
                } catch (java.lang.RuntimeException e2) {
                    if (equals) {
                        throw e2;
                    }
                    android.view.animation.Animation loadAnimation2 = android.view.animation.AnimationUtils.loadAnimation(context, nextAnim);
                    if (loadAnimation2 != null) {
                        return new androidx.fragment.app.FragmentAnim.AnimationOrAnimator(loadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    @androidx.annotation.AnimRes
    private static int transitToAnimResourceId(int i, boolean z) {
        if (i == 4097) {
            return z ? androidx.fragment.R.animator.fragment_open_enter : androidx.fragment.R.animator.fragment_open_exit;
        }
        if (i == 4099) {
            return z ? androidx.fragment.R.animator.fragment_fade_enter : androidx.fragment.R.animator.fragment_fade_exit;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? androidx.fragment.R.animator.fragment_close_enter : androidx.fragment.R.animator.fragment_close_exit;
    }
}
