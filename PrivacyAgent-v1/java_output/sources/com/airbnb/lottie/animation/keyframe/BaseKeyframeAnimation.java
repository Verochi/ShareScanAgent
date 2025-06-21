package com.airbnb.lottie.animation.keyframe;

/* loaded from: classes.dex */
public abstract class BaseKeyframeAnimation<K, A> {
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper<K> c;

    @androidx.annotation.Nullable
    protected com.airbnb.lottie.value.LottieValueCallback<A> valueCallback;
    public final java.util.List<com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener> a = new java.util.ArrayList(1);
    public boolean b = false;
    protected float progress = 0.0f;

    @androidx.annotation.Nullable
    public A d = null;
    public float e = -1.0f;
    public float f = -1.0f;

    public interface AnimationListener {
        void onValueChanged();
    }

    public static final class EmptyKeyframeWrapper<T> implements com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper<T> {
        public EmptyKeyframeWrapper() {
        }

        public /* synthetic */ EmptyKeyframeWrapper(com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public com.airbnb.lottie.value.Keyframe<T> a() {
            throw new java.lang.IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float b() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean c(float f) {
            throw new java.lang.IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean d(float f) {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float e() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return true;
        }
    }

    public interface KeyframesWrapper<T> {
        com.airbnb.lottie.value.Keyframe<T> a();

        @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
        float b();

        boolean c(float f);

        boolean d(float f);

        @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
        float e();

        boolean isEmpty();
    }

    public static final class KeyframesWrapperImpl<T> implements com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper<T> {
        public final java.util.List<? extends com.airbnb.lottie.value.Keyframe<T>> a;
        public com.airbnb.lottie.value.Keyframe<T> c = null;
        public float d = -1.0f;

        @androidx.annotation.NonNull
        public com.airbnb.lottie.value.Keyframe<T> b = f(0.0f);

        public KeyframesWrapperImpl(java.util.List<? extends com.airbnb.lottie.value.Keyframe<T>> list) {
            this.a = list;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        @androidx.annotation.NonNull
        public com.airbnb.lottie.value.Keyframe<T> a() {
            return this.b;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float b() {
            return this.a.get(0).getStartProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean c(float f) {
            com.airbnb.lottie.value.Keyframe<T> keyframe = this.c;
            com.airbnb.lottie.value.Keyframe<T> keyframe2 = this.b;
            if (keyframe == keyframe2 && this.d == f) {
                return true;
            }
            this.c = keyframe2;
            this.d = f;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean d(float f) {
            if (this.b.containsProgress(f)) {
                return !this.b.isStatic();
            }
            this.b = f(f);
            return true;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float e() {
            return this.a.get(r0.size() - 1).getEndProgress();
        }

        public final com.airbnb.lottie.value.Keyframe<T> f(float f) {
            java.util.List<? extends com.airbnb.lottie.value.Keyframe<T>> list = this.a;
            com.airbnb.lottie.value.Keyframe<T> keyframe = list.get(list.size() - 1);
            if (f >= keyframe.getStartProgress()) {
                return keyframe;
            }
            for (int size = this.a.size() - 2; size >= 1; size--) {
                com.airbnb.lottie.value.Keyframe<T> keyframe2 = this.a.get(size);
                if (this.b != keyframe2 && keyframe2.containsProgress(f)) {
                    return keyframe2;
                }
            }
            return this.a.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }
    }

    public static final class SingleKeyframeWrapper<T> implements com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper<T> {

        @androidx.annotation.NonNull
        public final com.airbnb.lottie.value.Keyframe<T> a;
        public float b = -1.0f;

        public SingleKeyframeWrapper(java.util.List<? extends com.airbnb.lottie.value.Keyframe<T>> list) {
            this.a = list.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public com.airbnb.lottie.value.Keyframe<T> a() {
            return this.a;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float b() {
            return this.a.getStartProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean c(float f) {
            if (this.b == f) {
                return true;
            }
            this.b = f;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean d(float f) {
            return !this.a.isStatic();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float e() {
            return this.a.getEndProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }
    }

    public BaseKeyframeAnimation(java.util.List<? extends com.airbnb.lottie.value.Keyframe<K>> list) {
        this.c = d(list);
    }

    public static <T> com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper<T> d(java.util.List<? extends com.airbnb.lottie.value.Keyframe<T>> list) {
        return list.isEmpty() ? new com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.EmptyKeyframeWrapper(null) : list.size() == 1 ? new com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.SingleKeyframeWrapper(list) : new com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapperImpl(list);
    }

    @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
    public float a() {
        if (this.f == -1.0f) {
            this.f = this.c.e();
        }
        return this.f;
    }

    public void addUpdateListener(com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener animationListener) {
        this.a.add(animationListener);
    }

    public float b() {
        if (this.b) {
            return 0.0f;
        }
        com.airbnb.lottie.value.Keyframe<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.isStatic()) {
            return 0.0f;
        }
        return (this.progress - currentKeyframe.getStartProgress()) / (currentKeyframe.getEndProgress() - currentKeyframe.getStartProgress());
    }

    @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
    public final float c() {
        if (this.e == -1.0f) {
            this.e = this.c.b();
        }
        return this.e;
    }

    public com.airbnb.lottie.value.Keyframe<K> getCurrentKeyframe() {
        com.airbnb.lottie.L.beginSection("BaseKeyframeAnimation#getCurrentKeyframe");
        com.airbnb.lottie.value.Keyframe<K> a = this.c.a();
        com.airbnb.lottie.L.endSection("BaseKeyframeAnimation#getCurrentKeyframe");
        return a;
    }

    public float getInterpolatedCurrentKeyframeProgress() {
        com.airbnb.lottie.value.Keyframe<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.isStatic()) {
            return 0.0f;
        }
        return currentKeyframe.interpolator.getInterpolation(b());
    }

    public float getProgress() {
        return this.progress;
    }

    public A getValue() {
        float b = b();
        if (this.valueCallback == null && this.c.c(b)) {
            return this.d;
        }
        com.airbnb.lottie.value.Keyframe<K> currentKeyframe = getCurrentKeyframe();
        android.view.animation.Interpolator interpolator = currentKeyframe.xInterpolator;
        A value = (interpolator == null || currentKeyframe.yInterpolator == null) ? getValue(currentKeyframe, getInterpolatedCurrentKeyframeProgress()) : getValue(currentKeyframe, b, interpolator.getInterpolation(b), currentKeyframe.yInterpolator.getInterpolation(b));
        this.d = value;
        return value;
    }

    public abstract A getValue(com.airbnb.lottie.value.Keyframe<K> keyframe, float f);

    public A getValue(com.airbnb.lottie.value.Keyframe<K> keyframe, float f, float f2, float f3) {
        throw new java.lang.UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void notifyListeners() {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).onValueChanged();
        }
    }

    public void setIsDiscrete() {
        this.b = true;
    }

    public void setProgress(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.c.isEmpty()) {
            return;
        }
        if (f < c()) {
            f = c();
        } else if (f > a()) {
            f = a();
        }
        if (f == this.progress) {
            return;
        }
        this.progress = f;
        if (this.c.d(f)) {
            notifyListeners();
        }
    }

    public void setValueCallback(@androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<A> lottieValueCallback) {
        com.airbnb.lottie.value.LottieValueCallback<A> lottieValueCallback2 = this.valueCallback;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation(null);
        }
        this.valueCallback = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }
}
