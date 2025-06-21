package androidx.transition;

/* loaded from: classes.dex */
public abstract class VisibilityPropagation extends androidx.transition.TransitionPropagation {
    private static final java.lang.String PROPNAME_VISIBILITY = "android:visibilityPropagation:visibility";
    private static final java.lang.String PROPNAME_VIEW_CENTER = "android:visibilityPropagation:center";
    private static final java.lang.String[] VISIBILITY_PROPAGATION_VALUES = {PROPNAME_VISIBILITY, PROPNAME_VIEW_CENTER};

    private static int getViewCoordinate(androidx.transition.TransitionValues transitionValues, int i) {
        int[] iArr;
        if (transitionValues == null || (iArr = (int[]) transitionValues.values.get(PROPNAME_VIEW_CENTER)) == null) {
            return -1;
        }
        return iArr[i];
    }

    @Override // androidx.transition.TransitionPropagation
    public void captureValues(androidx.transition.TransitionValues transitionValues) {
        android.view.View view = transitionValues.view;
        java.lang.Integer num = (java.lang.Integer) transitionValues.values.get("android:visibility:visibility");
        if (num == null) {
            num = java.lang.Integer.valueOf(view.getVisibility());
        }
        transitionValues.values.put(PROPNAME_VISIBILITY, num);
        int[] iArr = {r4, 0};
        view.getLocationOnScreen(iArr);
        int round = iArr[0] + java.lang.Math.round(view.getTranslationX());
        iArr[0] = round + (view.getWidth() / 2);
        int round2 = iArr[1] + java.lang.Math.round(view.getTranslationY());
        iArr[1] = round2;
        iArr[1] = round2 + (view.getHeight() / 2);
        transitionValues.values.put(PROPNAME_VIEW_CENTER, iArr);
    }

    @Override // androidx.transition.TransitionPropagation
    public java.lang.String[] getPropagationProperties() {
        return VISIBILITY_PROPAGATION_VALUES;
    }

    public int getViewVisibility(androidx.transition.TransitionValues transitionValues) {
        java.lang.Integer num;
        if (transitionValues == null || (num = (java.lang.Integer) transitionValues.values.get(PROPNAME_VISIBILITY)) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int getViewX(androidx.transition.TransitionValues transitionValues) {
        return getViewCoordinate(transitionValues, 0);
    }

    public int getViewY(androidx.transition.TransitionValues transitionValues) {
        return getViewCoordinate(transitionValues, 1);
    }
}
