package androidx.transition;

/* loaded from: classes.dex */
public class SidePropagation extends androidx.transition.VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;
    private int mSide = 80;

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0017, code lost:
    
        r0 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0026, code lost:
    
        if ((androidx.core.view.ViewCompat.getLayoutDirection(r7) == 1) != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if ((androidx.core.view.ViewCompat.getLayoutDirection(r7) == 1) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        r0 = 5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int distance(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = this.mSide;
        if (i9 != 8388611) {
            if (i9 == 8388613) {
            }
        }
        if (i9 == 3) {
            return (i7 - i) + java.lang.Math.abs(i4 - i2);
        }
        if (i9 == 5) {
            return (i - i5) + java.lang.Math.abs(i4 - i2);
        }
        if (i9 == 48) {
            return (i8 - i2) + java.lang.Math.abs(i3 - i);
        }
        if (i9 != 80) {
            return 0;
        }
        return (i2 - i6) + java.lang.Math.abs(i3 - i);
    }

    private int getMaxDistance(android.view.ViewGroup viewGroup) {
        int i = this.mSide;
        return (i == 3 || i == 5 || i == 8388611 || i == 8388613) ? viewGroup.getWidth() : viewGroup.getHeight();
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(android.view.ViewGroup viewGroup, androidx.transition.Transition transition, androidx.transition.TransitionValues transitionValues, androidx.transition.TransitionValues transitionValues2) {
        int i;
        int i2;
        int i3;
        androidx.transition.TransitionValues transitionValues3 = transitionValues;
        if (transitionValues3 == null && transitionValues2 == null) {
            return 0L;
        }
        android.graphics.Rect epicenter = transition.getEpicenter();
        if (transitionValues2 == null || getViewVisibility(transitionValues3) == 0) {
            i = -1;
        } else {
            transitionValues3 = transitionValues2;
            i = 1;
        }
        int viewX = getViewX(transitionValues3);
        int viewY = getViewY(transitionValues3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + java.lang.Math.round(viewGroup.getTranslationX());
        int round2 = iArr[1] + java.lang.Math.round(viewGroup.getTranslationY());
        int width = round + viewGroup.getWidth();
        int height = round2 + viewGroup.getHeight();
        if (epicenter != null) {
            i2 = epicenter.centerX();
            i3 = epicenter.centerY();
        } else {
            i2 = (round + width) / 2;
            i3 = (round2 + height) / 2;
        }
        float distance = distance(viewGroup, viewX, viewY, i2, i3, round, round2, width, height) / getMaxDistance(viewGroup);
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return java.lang.Math.round(((duration * i) / this.mPropagationSpeed) * distance);
    }

    public void setPropagationSpeed(float f) {
        if (f == 0.0f) {
            throw new java.lang.IllegalArgumentException("propagationSpeed may not be 0");
        }
        this.mPropagationSpeed = f;
    }

    public void setSide(int i) {
        this.mSide = i;
    }
}
