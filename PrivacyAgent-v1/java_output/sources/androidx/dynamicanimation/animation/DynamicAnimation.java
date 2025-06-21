package androidx.dynamicanimation.animation;

/* loaded from: classes.dex */
public abstract class DynamicAnimation<T extends androidx.dynamicanimation.animation.DynamicAnimation<T>> implements androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback {
    public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.00390625f;
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1f;
    public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002f;
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    private static final float UNSET = Float.MAX_VALUE;
    private final java.util.ArrayList<androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener> mEndListeners;
    private long mLastFrameTime;
    float mMaxValue;
    float mMinValue;
    private float mMinVisibleChange;
    final androidx.dynamicanimation.animation.FloatPropertyCompat mProperty;
    boolean mRunning;
    boolean mStartValueIsSet;
    final java.lang.Object mTarget;
    private final java.util.ArrayList<androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener> mUpdateListeners;
    float mValue;
    float mVelocity;
    public static final androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty TRANSLATION_X = new androidx.dynamicanimation.animation.DynamicAnimation.AnonymousClass1("translationX");
    public static final androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty TRANSLATION_Y = new androidx.dynamicanimation.animation.DynamicAnimation.AnonymousClass2("translationY");
    public static final androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty TRANSLATION_Z = new androidx.dynamicanimation.animation.DynamicAnimation.AnonymousClass3("translationZ");
    public static final androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty SCALE_X = new androidx.dynamicanimation.animation.DynamicAnimation.AnonymousClass4("scaleX");
    public static final androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty SCALE_Y = new androidx.dynamicanimation.animation.DynamicAnimation.AnonymousClass5("scaleY");
    public static final androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty ROTATION = new androidx.dynamicanimation.animation.DynamicAnimation.AnonymousClass6("rotation");
    public static final androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty ROTATION_X = new androidx.dynamicanimation.animation.DynamicAnimation.AnonymousClass7("rotationX");
    public static final androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty ROTATION_Y = new androidx.dynamicanimation.animation.DynamicAnimation.AnonymousClass8("rotationY");
    public static final androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty X = new androidx.dynamicanimation.animation.DynamicAnimation.AnonymousClass9("x");
    public static final androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty Y = new androidx.dynamicanimation.animation.DynamicAnimation.AnonymousClass10("y");
    public static final androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty Z = new androidx.dynamicanimation.animation.DynamicAnimation.AnonymousClass11(com.umeng.analytics.pro.bo.aJ);
    public static final androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty ALPHA = new androidx.dynamicanimation.animation.DynamicAnimation.AnonymousClass12("alpha");
    public static final androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty SCROLL_X = new androidx.dynamicanimation.animation.DynamicAnimation.AnonymousClass13("scrollX");
    public static final androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty SCROLL_Y = new androidx.dynamicanimation.animation.DynamicAnimation.AnonymousClass14("scrollY");

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$1, reason: invalid class name */
    public static class AnonymousClass1 extends androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty {
        public AnonymousClass1(java.lang.String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(android.view.View view) {
            return view.getTranslationX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(android.view.View view, float f) {
            view.setTranslationX(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$10, reason: invalid class name */
    public static class AnonymousClass10 extends androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty {
        public AnonymousClass10(java.lang.String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(android.view.View view) {
            return view.getY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(android.view.View view, float f) {
            view.setY(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$11, reason: invalid class name */
    public static class AnonymousClass11 extends androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty {
        public AnonymousClass11(java.lang.String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(android.view.View view) {
            return androidx.core.view.ViewCompat.getZ(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(android.view.View view, float f) {
            androidx.core.view.ViewCompat.setZ(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$12, reason: invalid class name */
    public static class AnonymousClass12 extends androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty {
        public AnonymousClass12(java.lang.String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(android.view.View view) {
            return view.getAlpha();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(android.view.View view, float f) {
            view.setAlpha(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$13, reason: invalid class name */
    public static class AnonymousClass13 extends androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty {
        public AnonymousClass13(java.lang.String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(android.view.View view) {
            return view.getScrollX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(android.view.View view, float f) {
            view.setScrollX((int) f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$14, reason: invalid class name */
    public static class AnonymousClass14 extends androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty {
        public AnonymousClass14(java.lang.String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(android.view.View view) {
            return view.getScrollY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(android.view.View view, float f) {
            view.setScrollY((int) f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$15, reason: invalid class name */
    public class AnonymousClass15 extends androidx.dynamicanimation.animation.FloatPropertyCompat {
        final /* synthetic */ androidx.dynamicanimation.animation.FloatValueHolder val$floatValueHolder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass15(java.lang.String str, androidx.dynamicanimation.animation.FloatValueHolder floatValueHolder) {
            super(str);
            this.val$floatValueHolder = floatValueHolder;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(java.lang.Object obj) {
            return this.val$floatValueHolder.getValue();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(java.lang.Object obj, float f) {
            this.val$floatValueHolder.setValue(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$2, reason: invalid class name */
    public static class AnonymousClass2 extends androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty {
        public AnonymousClass2(java.lang.String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(android.view.View view) {
            return view.getTranslationY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(android.view.View view, float f) {
            view.setTranslationY(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$3, reason: invalid class name */
    public static class AnonymousClass3 extends androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty {
        public AnonymousClass3(java.lang.String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(android.view.View view) {
            return androidx.core.view.ViewCompat.getTranslationZ(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(android.view.View view, float f) {
            androidx.core.view.ViewCompat.setTranslationZ(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$4, reason: invalid class name */
    public static class AnonymousClass4 extends androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty {
        public AnonymousClass4(java.lang.String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(android.view.View view) {
            return view.getScaleX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(android.view.View view, float f) {
            view.setScaleX(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$5, reason: invalid class name */
    public static class AnonymousClass5 extends androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty {
        public AnonymousClass5(java.lang.String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(android.view.View view) {
            return view.getScaleY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(android.view.View view, float f) {
            view.setScaleY(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$6, reason: invalid class name */
    public static class AnonymousClass6 extends androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty {
        public AnonymousClass6(java.lang.String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(android.view.View view) {
            return view.getRotation();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(android.view.View view, float f) {
            view.setRotation(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$7, reason: invalid class name */
    public static class AnonymousClass7 extends androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty {
        public AnonymousClass7(java.lang.String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(android.view.View view) {
            return view.getRotationX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(android.view.View view, float f) {
            view.setRotationX(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$8, reason: invalid class name */
    public static class AnonymousClass8 extends androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty {
        public AnonymousClass8(java.lang.String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(android.view.View view) {
            return view.getRotationY();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(android.view.View view, float f) {
            view.setRotationY(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$9, reason: invalid class name */
    public static class AnonymousClass9 extends androidx.dynamicanimation.animation.DynamicAnimation.ViewProperty {
        public AnonymousClass9(java.lang.String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(android.view.View view) {
            return view.getX();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(android.view.View view, float f) {
            view.setX(f);
        }
    }

    public static class MassState {
        float mValue;
        float mVelocity;
    }

    public interface OnAnimationEndListener {
        void onAnimationEnd(androidx.dynamicanimation.animation.DynamicAnimation dynamicAnimation, boolean z, float f, float f2);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(androidx.dynamicanimation.animation.DynamicAnimation dynamicAnimation, float f, float f2);
    }

    public static abstract class ViewProperty extends androidx.dynamicanimation.animation.FloatPropertyCompat<android.view.View> {
        private ViewProperty(java.lang.String str) {
            super(str);
        }

        public /* synthetic */ ViewProperty(java.lang.String str, androidx.dynamicanimation.animation.DynamicAnimation.AnonymousClass1 anonymousClass1) {
            this(str);
        }
    }

    public DynamicAnimation(androidx.dynamicanimation.animation.FloatValueHolder floatValueHolder) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0L;
        this.mEndListeners = new java.util.ArrayList<>();
        this.mUpdateListeners = new java.util.ArrayList<>();
        this.mTarget = null;
        this.mProperty = new androidx.dynamicanimation.animation.DynamicAnimation.AnonymousClass15("FloatValueHolder", floatValueHolder);
        this.mMinVisibleChange = 1.0f;
    }

    public <K> DynamicAnimation(K k, androidx.dynamicanimation.animation.FloatPropertyCompat<K> floatPropertyCompat) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0L;
        this.mEndListeners = new java.util.ArrayList<>();
        this.mUpdateListeners = new java.util.ArrayList<>();
        this.mTarget = k;
        this.mProperty = floatPropertyCompat;
        if (floatPropertyCompat == ROTATION || floatPropertyCompat == ROTATION_X || floatPropertyCompat == ROTATION_Y) {
            this.mMinVisibleChange = 0.1f;
            return;
        }
        if (floatPropertyCompat == ALPHA) {
            this.mMinVisibleChange = 0.00390625f;
        } else if (floatPropertyCompat == SCALE_X || floatPropertyCompat == SCALE_Y) {
            this.mMinVisibleChange = 0.00390625f;
        } else {
            this.mMinVisibleChange = 1.0f;
        }
    }

    private void endAnimationInternal(boolean z) {
        this.mRunning = false;
        androidx.dynamicanimation.animation.AnimationHandler.getInstance().removeCallback(this);
        this.mLastFrameTime = 0L;
        this.mStartValueIsSet = false;
        for (int i = 0; i < this.mEndListeners.size(); i++) {
            if (this.mEndListeners.get(i) != null) {
                this.mEndListeners.get(i).onAnimationEnd(this, z, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mEndListeners);
    }

    private float getPropertyValue() {
        return this.mProperty.getValue(this.mTarget);
    }

    private static <T> void removeEntry(java.util.ArrayList<T> arrayList, T t) {
        int indexOf = arrayList.indexOf(t);
        if (indexOf >= 0) {
            arrayList.set(indexOf, null);
        }
    }

    private static <T> void removeNullEntries(java.util.ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void startAnimationInternal() {
        if (this.mRunning) {
            return;
        }
        this.mRunning = true;
        if (!this.mStartValueIsSet) {
            this.mValue = getPropertyValue();
        }
        float f = this.mValue;
        if (f > this.mMaxValue || f < this.mMinValue) {
            throw new java.lang.IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        androidx.dynamicanimation.animation.AnimationHandler.getInstance().addAnimationFrameCallback(this, 0L);
    }

    public T addEndListener(androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener onAnimationEndListener) {
        if (!this.mEndListeners.contains(onAnimationEndListener)) {
            this.mEndListeners.add(onAnimationEndListener);
        }
        return this;
    }

    public T addUpdateListener(androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener onAnimationUpdateListener) {
        if (isRunning()) {
            throw new java.lang.UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        if (!this.mUpdateListeners.contains(onAnimationUpdateListener)) {
            this.mUpdateListeners.add(onAnimationUpdateListener);
        }
        return this;
    }

    public void cancel() {
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            throw new android.util.AndroidRuntimeException("Animations may only be canceled on the main thread");
        }
        if (this.mRunning) {
            endAnimationInternal(true);
        }
    }

    @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public boolean doAnimationFrame(long j) {
        long j2 = this.mLastFrameTime;
        if (j2 == 0) {
            this.mLastFrameTime = j;
            setPropertyValue(this.mValue);
            return false;
        }
        this.mLastFrameTime = j;
        boolean updateValueAndVelocity = updateValueAndVelocity(j - j2);
        float min = java.lang.Math.min(this.mValue, this.mMaxValue);
        this.mValue = min;
        float max = java.lang.Math.max(min, this.mMinValue);
        this.mValue = max;
        setPropertyValue(max);
        if (updateValueAndVelocity) {
            endAnimationInternal(false);
        }
        return updateValueAndVelocity;
    }

    public abstract float getAcceleration(float f, float f2);

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    public float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    public abstract boolean isAtEquilibrium(float f, float f2);

    public boolean isRunning() {
        return this.mRunning;
    }

    public void removeEndListener(androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener onAnimationEndListener) {
        removeEntry(this.mEndListeners, onAnimationEndListener);
    }

    public void removeUpdateListener(androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener onAnimationUpdateListener) {
        removeEntry(this.mUpdateListeners, onAnimationUpdateListener);
    }

    public T setMaxValue(float f) {
        this.mMaxValue = f;
        return this;
    }

    public T setMinValue(float f) {
        this.mMinValue = f;
        return this;
    }

    public T setMinimumVisibleChange(@androidx.annotation.FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f) {
            throw new java.lang.IllegalArgumentException("Minimum visible change must be positive.");
        }
        this.mMinVisibleChange = f;
        setValueThreshold(f * 0.75f);
        return this;
    }

    public void setPropertyValue(float f) {
        this.mProperty.setValue(this.mTarget, f);
        for (int i = 0; i < this.mUpdateListeners.size(); i++) {
            if (this.mUpdateListeners.get(i) != null) {
                this.mUpdateListeners.get(i).onAnimationUpdate(this, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mUpdateListeners);
    }

    public T setStartValue(float f) {
        this.mValue = f;
        this.mStartValueIsSet = true;
        return this;
    }

    public T setStartVelocity(float f) {
        this.mVelocity = f;
        return this;
    }

    public abstract void setValueThreshold(float f);

    public void start() {
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            throw new android.util.AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.mRunning) {
            return;
        }
        startAnimationInternal();
    }

    public abstract boolean updateValueAndVelocity(long j);
}
