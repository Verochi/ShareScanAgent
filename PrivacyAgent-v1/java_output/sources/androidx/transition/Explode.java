package androidx.transition;

/* loaded from: classes.dex */
public class Explode extends androidx.transition.Visibility {
    private static final java.lang.String PROPNAME_SCREEN_BOUNDS = "android:explode:screenBounds";
    private int[] mTempLoc;
    private static final android.animation.TimeInterpolator sDecelerate = new android.view.animation.DecelerateInterpolator();
    private static final android.animation.TimeInterpolator sAccelerate = new android.view.animation.AccelerateInterpolator();

    public Explode() {
        this.mTempLoc = new int[2];
        setPropagation(new androidx.transition.CircularPropagation());
    }

    public Explode(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempLoc = new int[2];
        setPropagation(new androidx.transition.CircularPropagation());
    }

    private static float calculateDistance(float f, float f2) {
        return (float) java.lang.Math.sqrt((f * f) + (f2 * f2));
    }

    private static float calculateMaxDistance(android.view.View view, int i, int i2) {
        return calculateDistance(java.lang.Math.max(i, view.getWidth() - i), java.lang.Math.max(i2, view.getHeight() - i2));
    }

    private void calculateOut(android.view.View view, android.graphics.Rect rect, int[] iArr) {
        int centerY;
        int i;
        view.getLocationOnScreen(this.mTempLoc);
        int[] iArr2 = this.mTempLoc;
        int i2 = iArr2[0];
        int i3 = iArr2[1];
        android.graphics.Rect epicenter = getEpicenter();
        if (epicenter == null) {
            i = (view.getWidth() / 2) + i2 + java.lang.Math.round(view.getTranslationX());
            centerY = (view.getHeight() / 2) + i3 + java.lang.Math.round(view.getTranslationY());
        } else {
            int centerX = epicenter.centerX();
            centerY = epicenter.centerY();
            i = centerX;
        }
        float centerX2 = rect.centerX() - i;
        float centerY2 = rect.centerY() - centerY;
        if (centerX2 == 0.0f && centerY2 == 0.0f) {
            centerX2 = ((float) (java.lang.Math.random() * 2.0d)) - 1.0f;
            centerY2 = ((float) (java.lang.Math.random() * 2.0d)) - 1.0f;
        }
        float calculateDistance = calculateDistance(centerX2, centerY2);
        float calculateMaxDistance = calculateMaxDistance(view, i - i2, centerY - i3);
        iArr[0] = java.lang.Math.round((centerX2 / calculateDistance) * calculateMaxDistance);
        iArr[1] = java.lang.Math.round(calculateMaxDistance * (centerY2 / calculateDistance));
    }

    private void captureValues(androidx.transition.TransitionValues transitionValues) {
        android.view.View view = transitionValues.view;
        view.getLocationOnScreen(this.mTempLoc);
        int[] iArr = this.mTempLoc;
        int i = iArr[0];
        int i2 = iArr[1];
        transitionValues.values.put(PROPNAME_SCREEN_BOUNDS, new android.graphics.Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Visibility
    public android.animation.Animator onAppear(android.view.ViewGroup viewGroup, android.view.View view, androidx.transition.TransitionValues transitionValues, androidx.transition.TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        android.graphics.Rect rect = (android.graphics.Rect) transitionValues2.values.get(PROPNAME_SCREEN_BOUNDS);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        calculateOut(viewGroup, rect, this.mTempLoc);
        int[] iArr = this.mTempLoc;
        return androidx.transition.TranslationAnimationCreator.createAnimation(view, transitionValues2, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, sDecelerate, this);
    }

    @Override // androidx.transition.Visibility
    public android.animation.Animator onDisappear(android.view.ViewGroup viewGroup, android.view.View view, androidx.transition.TransitionValues transitionValues, androidx.transition.TransitionValues transitionValues2) {
        float f;
        float f2;
        if (transitionValues == null) {
            return null;
        }
        android.graphics.Rect rect = (android.graphics.Rect) transitionValues.values.get(PROPNAME_SCREEN_BOUNDS);
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(androidx.transition.R.id.transition_position);
        if (iArr != null) {
            f = (r7 - rect.left) + translationX;
            f2 = (r0 - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f = translationX;
            f2 = translationY;
        }
        calculateOut(viewGroup, rect, this.mTempLoc);
        int[] iArr2 = this.mTempLoc;
        return androidx.transition.TranslationAnimationCreator.createAnimation(view, transitionValues, i, i2, translationX, translationY, f + iArr2[0], f2 + iArr2[1], sAccelerate, this);
    }
}
