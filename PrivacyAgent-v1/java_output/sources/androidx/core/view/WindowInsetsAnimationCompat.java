package androidx.core.view;

/* loaded from: classes.dex */
public final class WindowInsetsAnimationCompat {
    private static final boolean DEBUG = false;
    private static final java.lang.String TAG = "WindowInsetsAnimCompat";
    private androidx.core.view.WindowInsetsAnimationCompat.Impl mImpl;

    public static final class BoundsCompat {
        private final androidx.core.graphics.Insets mLowerBound;
        private final androidx.core.graphics.Insets mUpperBound;

        @androidx.annotation.RequiresApi(30)
        private BoundsCompat(@androidx.annotation.NonNull android.view.WindowInsetsAnimation.Bounds bounds) {
            this.mLowerBound = androidx.core.view.WindowInsetsAnimationCompat.Impl30.getLowerBounds(bounds);
            this.mUpperBound = androidx.core.view.WindowInsetsAnimationCompat.Impl30.getHigherBounds(bounds);
        }

        public BoundsCompat(@androidx.annotation.NonNull androidx.core.graphics.Insets insets, @androidx.annotation.NonNull androidx.core.graphics.Insets insets2) {
            this.mLowerBound = insets;
            this.mUpperBound = insets2;
        }

        @androidx.annotation.NonNull
        @androidx.annotation.RequiresApi(30)
        public static androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat toBoundsCompat(@androidx.annotation.NonNull android.view.WindowInsetsAnimation.Bounds bounds) {
            return new androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat(bounds);
        }

        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getLowerBound() {
            return this.mLowerBound;
        }

        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getUpperBound() {
            return this.mUpperBound;
        }

        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat inset(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            return new androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat(androidx.core.view.WindowInsetsCompat.insetInsets(this.mLowerBound, insets.left, insets.top, insets.right, insets.bottom), androidx.core.view.WindowInsetsCompat.insetInsets(this.mUpperBound, insets.left, insets.top, insets.right, insets.bottom));
        }

        @androidx.annotation.NonNull
        @androidx.annotation.RequiresApi(30)
        public android.view.WindowInsetsAnimation.Bounds toBounds() {
            return androidx.core.view.WindowInsetsAnimationCompat.Impl30.createPlatformBounds(this);
        }

        public java.lang.String toString() {
            return "Bounds{lower=" + this.mLowerBound + " upper=" + this.mUpperBound + com.alipay.sdk.m.u.i.d;
        }
    }

    public static abstract class Callback {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;
        android.view.WindowInsets mDispachedInsets;
        private final int mDispatchMode;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public @interface DispatchMode {
        }

        public Callback(int i) {
            this.mDispatchMode = i;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public void onEnd(@androidx.annotation.NonNull androidx.core.view.WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public void onPrepare(@androidx.annotation.NonNull androidx.core.view.WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        @androidx.annotation.NonNull
        public abstract androidx.core.view.WindowInsetsCompat onProgress(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull java.util.List<androidx.core.view.WindowInsetsAnimationCompat> list);

        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat onStart(@androidx.annotation.NonNull androidx.core.view.WindowInsetsAnimationCompat windowInsetsAnimationCompat, @androidx.annotation.NonNull androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
            return boundsCompat;
        }
    }

    public static class Impl {
        private float mAlpha;
        private final long mDurationMillis;
        private float mFraction;

        @androidx.annotation.Nullable
        private final android.view.animation.Interpolator mInterpolator;
        private final int mTypeMask;

        public Impl(int i, @androidx.annotation.Nullable android.view.animation.Interpolator interpolator, long j) {
            this.mTypeMask = i;
            this.mInterpolator = interpolator;
            this.mDurationMillis = j;
        }

        public float getAlpha() {
            return this.mAlpha;
        }

        public long getDurationMillis() {
            return this.mDurationMillis;
        }

        public float getFraction() {
            return this.mFraction;
        }

        public float getInterpolatedFraction() {
            android.view.animation.Interpolator interpolator = this.mInterpolator;
            return interpolator != null ? interpolator.getInterpolation(this.mFraction) : this.mFraction;
        }

        @androidx.annotation.Nullable
        public android.view.animation.Interpolator getInterpolator() {
            return this.mInterpolator;
        }

        public int getTypeMask() {
            return this.mTypeMask;
        }

        public void setAlpha(float f) {
            this.mAlpha = f;
        }

        public void setFraction(float f) {
            this.mFraction = f;
        }
    }

    @androidx.annotation.RequiresApi(21)
    public static class Impl21 extends androidx.core.view.WindowInsetsAnimationCompat.Impl {

        @androidx.annotation.RequiresApi(21)
        public static class Impl21OnApplyWindowInsetsListener implements android.view.View.OnApplyWindowInsetsListener {
            private static final int COMPAT_ANIMATION_DURATION = 160;
            final androidx.core.view.WindowInsetsAnimationCompat.Callback mCallback;
            private androidx.core.view.WindowInsetsCompat mLastInsets;

            /* renamed from: androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$1, reason: invalid class name */
            public class AnonymousClass1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
                final /* synthetic */ androidx.core.view.WindowInsetsAnimationCompat val$anim;
                final /* synthetic */ int val$animationMask;
                final /* synthetic */ androidx.core.view.WindowInsetsCompat val$startingInsets;
                final /* synthetic */ androidx.core.view.WindowInsetsCompat val$targetInsets;
                final /* synthetic */ android.view.View val$v;

                public AnonymousClass1(androidx.core.view.WindowInsetsAnimationCompat windowInsetsAnimationCompat, androidx.core.view.WindowInsetsCompat windowInsetsCompat, androidx.core.view.WindowInsetsCompat windowInsetsCompat2, int i, android.view.View view) {
                    this.val$anim = windowInsetsAnimationCompat;
                    this.val$targetInsets = windowInsetsCompat;
                    this.val$startingInsets = windowInsetsCompat2;
                    this.val$animationMask = i;
                    this.val$v = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    this.val$anim.setFraction(valueAnimator.getAnimatedFraction());
                    androidx.core.view.WindowInsetsAnimationCompat.Impl21.dispatchOnProgress(this.val$v, androidx.core.view.WindowInsetsAnimationCompat.Impl21.interpolateInsets(this.val$targetInsets, this.val$startingInsets, this.val$anim.getInterpolatedFraction(), this.val$animationMask), java.util.Collections.singletonList(this.val$anim));
                }
            }

            /* renamed from: androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$2, reason: invalid class name */
            public class AnonymousClass2 extends android.animation.AnimatorListenerAdapter {
                final /* synthetic */ androidx.core.view.WindowInsetsAnimationCompat val$anim;
                final /* synthetic */ android.view.View val$v;

                public AnonymousClass2(androidx.core.view.WindowInsetsAnimationCompat windowInsetsAnimationCompat, android.view.View view) {
                    this.val$anim = windowInsetsAnimationCompat;
                    this.val$v = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    this.val$anim.setFraction(1.0f);
                    androidx.core.view.WindowInsetsAnimationCompat.Impl21.dispatchOnEnd(this.val$v, this.val$anim);
                }
            }

            /* renamed from: androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$3, reason: invalid class name */
            public class AnonymousClass3 implements java.lang.Runnable {
                final /* synthetic */ androidx.core.view.WindowInsetsAnimationCompat val$anim;
                final /* synthetic */ androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat val$animationBounds;
                final /* synthetic */ android.animation.ValueAnimator val$animator;
                final /* synthetic */ android.view.View val$v;

                public AnonymousClass3(android.view.View view, androidx.core.view.WindowInsetsAnimationCompat windowInsetsAnimationCompat, androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat boundsCompat, android.animation.ValueAnimator valueAnimator) {
                    this.val$v = view;
                    this.val$anim = windowInsetsAnimationCompat;
                    this.val$animationBounds = boundsCompat;
                    this.val$animator = valueAnimator;
                }

                @Override // java.lang.Runnable
                public void run() {
                    androidx.core.view.WindowInsetsAnimationCompat.Impl21.dispatchOnStart(this.val$v, this.val$anim, this.val$animationBounds);
                    this.val$animator.start();
                }
            }

            public Impl21OnApplyWindowInsetsListener(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.WindowInsetsAnimationCompat.Callback callback) {
                this.mCallback = callback;
                androidx.core.view.WindowInsetsCompat rootWindowInsets = androidx.core.view.ViewCompat.getRootWindowInsets(view);
                this.mLastInsets = rootWindowInsets != null ? new androidx.core.view.WindowInsetsCompat.Builder(rootWindowInsets).build() : null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public android.view.WindowInsets onApplyWindowInsets(android.view.View view, android.view.WindowInsets windowInsets) {
                int buildAnimationMask;
                if (!view.isLaidOut()) {
                    this.mLastInsets = androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
                    return androidx.core.view.WindowInsetsAnimationCompat.Impl21.forwardToViewIfNeeded(view, windowInsets);
                }
                androidx.core.view.WindowInsetsCompat windowInsetsCompat = androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
                if (this.mLastInsets == null) {
                    this.mLastInsets = androidx.core.view.ViewCompat.getRootWindowInsets(view);
                }
                if (this.mLastInsets == null) {
                    this.mLastInsets = windowInsetsCompat;
                    return androidx.core.view.WindowInsetsAnimationCompat.Impl21.forwardToViewIfNeeded(view, windowInsets);
                }
                androidx.core.view.WindowInsetsAnimationCompat.Callback callback = androidx.core.view.WindowInsetsAnimationCompat.Impl21.getCallback(view);
                if ((callback == null || !java.util.Objects.equals(callback.mDispachedInsets, windowInsets)) && (buildAnimationMask = androidx.core.view.WindowInsetsAnimationCompat.Impl21.buildAnimationMask(windowInsetsCompat, this.mLastInsets)) != 0) {
                    androidx.core.view.WindowInsetsCompat windowInsetsCompat2 = this.mLastInsets;
                    androidx.core.view.WindowInsetsAnimationCompat windowInsetsAnimationCompat = new androidx.core.view.WindowInsetsAnimationCompat(buildAnimationMask, new android.view.animation.DecelerateInterpolator(), 160L);
                    windowInsetsAnimationCompat.setFraction(0.0f);
                    android.animation.ValueAnimator duration = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(windowInsetsAnimationCompat.getDurationMillis());
                    androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat computeAnimationBounds = androidx.core.view.WindowInsetsAnimationCompat.Impl21.computeAnimationBounds(windowInsetsCompat, windowInsetsCompat2, buildAnimationMask);
                    androidx.core.view.WindowInsetsAnimationCompat.Impl21.dispatchOnPrepare(view, windowInsetsAnimationCompat, windowInsets, false);
                    duration.addUpdateListener(new androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.AnonymousClass1(windowInsetsAnimationCompat, windowInsetsCompat, windowInsetsCompat2, buildAnimationMask, view));
                    duration.addListener(new androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.AnonymousClass2(windowInsetsAnimationCompat, view));
                    androidx.core.view.OneShotPreDrawListener.add(view, new androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.AnonymousClass3(view, windowInsetsAnimationCompat, computeAnimationBounds, duration));
                    this.mLastInsets = windowInsetsCompat;
                    return androidx.core.view.WindowInsetsAnimationCompat.Impl21.forwardToViewIfNeeded(view, windowInsets);
                }
                return androidx.core.view.WindowInsetsAnimationCompat.Impl21.forwardToViewIfNeeded(view, windowInsets);
            }
        }

        public Impl21(int i, @androidx.annotation.Nullable android.view.animation.Interpolator interpolator, long j) {
            super(i, interpolator, j);
        }

        @android.annotation.SuppressLint({"WrongConstant"})
        public static int buildAnimationMask(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat2) {
            int i = 0;
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if (!windowInsetsCompat.getInsets(i2).equals(windowInsetsCompat2.getInsets(i2))) {
                    i |= i2;
                }
            }
            return i;
        }

        @androidx.annotation.NonNull
        public static androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat computeAnimationBounds(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat2, int i) {
            androidx.core.graphics.Insets insets = windowInsetsCompat.getInsets(i);
            androidx.core.graphics.Insets insets2 = windowInsetsCompat2.getInsets(i);
            return new androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat(androidx.core.graphics.Insets.of(java.lang.Math.min(insets.left, insets2.left), java.lang.Math.min(insets.top, insets2.top), java.lang.Math.min(insets.right, insets2.right), java.lang.Math.min(insets.bottom, insets2.bottom)), androidx.core.graphics.Insets.of(java.lang.Math.max(insets.left, insets2.left), java.lang.Math.max(insets.top, insets2.top), java.lang.Math.max(insets.right, insets2.right), java.lang.Math.max(insets.bottom, insets2.bottom)));
        }

        @androidx.annotation.NonNull
        private static android.view.View.OnApplyWindowInsetsListener createProxyListener(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.WindowInsetsAnimationCompat.Callback callback) {
            return new androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener(view, callback);
        }

        public static void dispatchOnEnd(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            androidx.core.view.WindowInsetsAnimationCompat.Callback callback = getCallback(view);
            if (callback != null) {
                callback.onEnd(windowInsetsAnimationCompat);
                if (callback.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    dispatchOnEnd(viewGroup.getChildAt(i), windowInsetsAnimationCompat);
                }
            }
        }

        public static void dispatchOnPrepare(android.view.View view, androidx.core.view.WindowInsetsAnimationCompat windowInsetsAnimationCompat, android.view.WindowInsets windowInsets, boolean z) {
            androidx.core.view.WindowInsetsAnimationCompat.Callback callback = getCallback(view);
            if (callback != null) {
                callback.mDispachedInsets = windowInsets;
                if (!z) {
                    callback.onPrepare(windowInsetsAnimationCompat);
                    z = callback.getDispatchMode() == 0;
                }
            }
            if (view instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    dispatchOnPrepare(viewGroup.getChildAt(i), windowInsetsAnimationCompat, windowInsets, z);
                }
            }
        }

        public static void dispatchOnProgress(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull java.util.List<androidx.core.view.WindowInsetsAnimationCompat> list) {
            androidx.core.view.WindowInsetsAnimationCompat.Callback callback = getCallback(view);
            if (callback != null) {
                windowInsetsCompat = callback.onProgress(windowInsetsCompat, list);
                if (callback.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    dispatchOnProgress(viewGroup.getChildAt(i), windowInsetsCompat, list);
                }
            }
        }

        public static void dispatchOnStart(android.view.View view, androidx.core.view.WindowInsetsAnimationCompat windowInsetsAnimationCompat, androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
            androidx.core.view.WindowInsetsAnimationCompat.Callback callback = getCallback(view);
            if (callback != null) {
                callback.onStart(windowInsetsAnimationCompat, boundsCompat);
                if (callback.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    dispatchOnStart(viewGroup.getChildAt(i), windowInsetsAnimationCompat, boundsCompat);
                }
            }
        }

        @androidx.annotation.NonNull
        public static android.view.WindowInsets forwardToViewIfNeeded(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.WindowInsets windowInsets) {
            return view.getTag(androidx.core.R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        @androidx.annotation.Nullable
        public static androidx.core.view.WindowInsetsAnimationCompat.Callback getCallback(android.view.View view) {
            java.lang.Object tag = view.getTag(androidx.core.R.id.tag_window_insets_animation_callback);
            if (tag instanceof androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener) {
                return ((androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener) tag).mCallback;
            }
            return null;
        }

        @android.annotation.SuppressLint({"WrongConstant"})
        public static androidx.core.view.WindowInsetsCompat interpolateInsets(androidx.core.view.WindowInsetsCompat windowInsetsCompat, androidx.core.view.WindowInsetsCompat windowInsetsCompat2, float f, int i) {
            androidx.core.view.WindowInsetsCompat.Builder builder = new androidx.core.view.WindowInsetsCompat.Builder(windowInsetsCompat);
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) == 0) {
                    builder.setInsets(i2, windowInsetsCompat.getInsets(i2));
                } else {
                    androidx.core.graphics.Insets insets = windowInsetsCompat.getInsets(i2);
                    androidx.core.graphics.Insets insets2 = windowInsetsCompat2.getInsets(i2);
                    float f2 = 1.0f - f;
                    builder.setInsets(i2, androidx.core.view.WindowInsetsCompat.insetInsets(insets, (int) (((insets.left - insets2.left) * f2) + 0.5d), (int) (((insets.top - insets2.top) * f2) + 0.5d), (int) (((insets.right - insets2.right) * f2) + 0.5d), (int) (((insets.bottom - insets2.bottom) * f2) + 0.5d)));
                }
            }
            return builder.build();
        }

        public static void setCallback(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable androidx.core.view.WindowInsetsAnimationCompat.Callback callback) {
            java.lang.Object tag = view.getTag(androidx.core.R.id.tag_on_apply_window_listener);
            if (callback == null) {
                view.setTag(androidx.core.R.id.tag_window_insets_animation_callback, null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener(null);
                    return;
                }
                return;
            }
            android.view.View.OnApplyWindowInsetsListener createProxyListener = createProxyListener(view, callback);
            view.setTag(androidx.core.R.id.tag_window_insets_animation_callback, createProxyListener);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(createProxyListener);
            }
        }
    }

    @androidx.annotation.RequiresApi(30)
    public static class Impl30 extends androidx.core.view.WindowInsetsAnimationCompat.Impl {

        @androidx.annotation.NonNull
        private final android.view.WindowInsetsAnimation mWrapped;

        @androidx.annotation.RequiresApi(30)
        public static class ProxyCallback extends android.view.WindowInsetsAnimation.Callback {
            private final java.util.HashMap<android.view.WindowInsetsAnimation, androidx.core.view.WindowInsetsAnimationCompat> mAnimations;
            private final androidx.core.view.WindowInsetsAnimationCompat.Callback mCompat;
            private java.util.List<androidx.core.view.WindowInsetsAnimationCompat> mRORunningAnimations;
            private java.util.ArrayList<androidx.core.view.WindowInsetsAnimationCompat> mTmpRunningAnimations;

            public ProxyCallback(@androidx.annotation.NonNull androidx.core.view.WindowInsetsAnimationCompat.Callback callback) {
                super(callback.getDispatchMode());
                this.mAnimations = new java.util.HashMap<>();
                this.mCompat = callback;
            }

            @androidx.annotation.NonNull
            private androidx.core.view.WindowInsetsAnimationCompat getWindowInsetsAnimationCompat(@androidx.annotation.NonNull android.view.WindowInsetsAnimation windowInsetsAnimation) {
                androidx.core.view.WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.mAnimations.get(windowInsetsAnimation);
                if (windowInsetsAnimationCompat != null) {
                    return windowInsetsAnimationCompat;
                }
                androidx.core.view.WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = androidx.core.view.WindowInsetsAnimationCompat.toWindowInsetsAnimationCompat(windowInsetsAnimation);
                this.mAnimations.put(windowInsetsAnimation, windowInsetsAnimationCompat2);
                return windowInsetsAnimationCompat2;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(@androidx.annotation.NonNull android.view.WindowInsetsAnimation windowInsetsAnimation) {
                this.mCompat.onEnd(getWindowInsetsAnimationCompat(windowInsetsAnimation));
                this.mAnimations.remove(windowInsetsAnimation);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(@androidx.annotation.NonNull android.view.WindowInsetsAnimation windowInsetsAnimation) {
                this.mCompat.onPrepare(getWindowInsetsAnimationCompat(windowInsetsAnimation));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            @androidx.annotation.NonNull
            public android.view.WindowInsets onProgress(@androidx.annotation.NonNull android.view.WindowInsets windowInsets, @androidx.annotation.NonNull java.util.List<android.view.WindowInsetsAnimation> list) {
                float fraction;
                java.util.ArrayList<androidx.core.view.WindowInsetsAnimationCompat> arrayList = this.mTmpRunningAnimations;
                if (arrayList == null) {
                    java.util.ArrayList<androidx.core.view.WindowInsetsAnimationCompat> arrayList2 = new java.util.ArrayList<>(list.size());
                    this.mTmpRunningAnimations = arrayList2;
                    this.mRORunningAnimations = java.util.Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    android.view.WindowInsetsAnimation windowInsetsAnimation = list.get(size);
                    androidx.core.view.WindowInsetsAnimationCompat windowInsetsAnimationCompat = getWindowInsetsAnimationCompat(windowInsetsAnimation);
                    fraction = windowInsetsAnimation.getFraction();
                    windowInsetsAnimationCompat.setFraction(fraction);
                    this.mTmpRunningAnimations.add(windowInsetsAnimationCompat);
                }
                return this.mCompat.onProgress(androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(windowInsets), this.mRORunningAnimations).toWindowInsets();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            @androidx.annotation.NonNull
            public android.view.WindowInsetsAnimation.Bounds onStart(@androidx.annotation.NonNull android.view.WindowInsetsAnimation windowInsetsAnimation, @androidx.annotation.NonNull android.view.WindowInsetsAnimation.Bounds bounds) {
                return this.mCompat.onStart(getWindowInsetsAnimationCompat(windowInsetsAnimation), androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat.toBoundsCompat(bounds)).toBounds();
            }
        }

        public Impl30(int i, android.view.animation.Interpolator interpolator, long j) {
            this(new android.view.WindowInsetsAnimation(i, interpolator, j));
        }

        public Impl30(@androidx.annotation.NonNull android.view.WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.mWrapped = windowInsetsAnimation;
        }

        @androidx.annotation.NonNull
        public static android.view.WindowInsetsAnimation.Bounds createPlatformBounds(@androidx.annotation.NonNull androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
            return new android.view.WindowInsetsAnimation.Bounds(boundsCompat.getLowerBound().toPlatformInsets(), boundsCompat.getUpperBound().toPlatformInsets());
        }

        @androidx.annotation.NonNull
        public static androidx.core.graphics.Insets getHigherBounds(@androidx.annotation.NonNull android.view.WindowInsetsAnimation.Bounds bounds) {
            android.graphics.Insets upperBound;
            upperBound = bounds.getUpperBound();
            return androidx.core.graphics.Insets.toCompatInsets(upperBound);
        }

        @androidx.annotation.NonNull
        public static androidx.core.graphics.Insets getLowerBounds(@androidx.annotation.NonNull android.view.WindowInsetsAnimation.Bounds bounds) {
            android.graphics.Insets lowerBound;
            lowerBound = bounds.getLowerBound();
            return androidx.core.graphics.Insets.toCompatInsets(lowerBound);
        }

        public static void setCallback(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable androidx.core.view.WindowInsetsAnimationCompat.Callback callback) {
            view.setWindowInsetsAnimationCallback(callback != null ? new androidx.core.view.WindowInsetsAnimationCompat.Impl30.ProxyCallback(callback) : null);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public long getDurationMillis() {
            long durationMillis;
            durationMillis = this.mWrapped.getDurationMillis();
            return durationMillis;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public float getFraction() {
            float fraction;
            fraction = this.mWrapped.getFraction();
            return fraction;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public float getInterpolatedFraction() {
            float interpolatedFraction;
            interpolatedFraction = this.mWrapped.getInterpolatedFraction();
            return interpolatedFraction;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        @androidx.annotation.Nullable
        public android.view.animation.Interpolator getInterpolator() {
            android.view.animation.Interpolator interpolator;
            interpolator = this.mWrapped.getInterpolator();
            return interpolator;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public int getTypeMask() {
            int typeMask;
            typeMask = this.mWrapped.getTypeMask();
            return typeMask;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public void setFraction(float f) {
            this.mWrapped.setFraction(f);
        }
    }

    public WindowInsetsAnimationCompat(int i, @androidx.annotation.Nullable android.view.animation.Interpolator interpolator, long j) {
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new androidx.core.view.WindowInsetsAnimationCompat.Impl30(i, interpolator, j);
        } else {
            this.mImpl = new androidx.core.view.WindowInsetsAnimationCompat.Impl21(i, interpolator, j);
        }
    }

    @androidx.annotation.RequiresApi(30)
    private WindowInsetsAnimationCompat(@androidx.annotation.NonNull android.view.WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new androidx.core.view.WindowInsetsAnimationCompat.Impl30(windowInsetsAnimation);
        }
    }

    public static void setCallback(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable androidx.core.view.WindowInsetsAnimationCompat.Callback callback) {
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            androidx.core.view.WindowInsetsAnimationCompat.Impl30.setCallback(view, callback);
        } else {
            androidx.core.view.WindowInsetsAnimationCompat.Impl21.setCallback(view, callback);
        }
    }

    @androidx.annotation.RequiresApi(30)
    public static androidx.core.view.WindowInsetsAnimationCompat toWindowInsetsAnimationCompat(android.view.WindowInsetsAnimation windowInsetsAnimation) {
        return new androidx.core.view.WindowInsetsAnimationCompat(windowInsetsAnimation);
    }

    @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
    public float getAlpha() {
        return this.mImpl.getAlpha();
    }

    public long getDurationMillis() {
        return this.mImpl.getDurationMillis();
    }

    @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
    public float getFraction() {
        return this.mImpl.getFraction();
    }

    public float getInterpolatedFraction() {
        return this.mImpl.getInterpolatedFraction();
    }

    @androidx.annotation.Nullable
    public android.view.animation.Interpolator getInterpolator() {
        return this.mImpl.getInterpolator();
    }

    public int getTypeMask() {
        return this.mImpl.getTypeMask();
    }

    public void setAlpha(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.mImpl.setAlpha(f);
    }

    public void setFraction(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.mImpl.setFraction(f);
    }
}
