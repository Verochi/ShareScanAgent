package androidx.viewpager2.widget;

/* loaded from: classes.dex */
final class AnimateLayoutChangeDetector {
    private static final android.view.ViewGroup.MarginLayoutParams ZERO_MARGIN_LAYOUT_PARAMS;
    private androidx.recyclerview.widget.LinearLayoutManager mLayoutManager;

    /* renamed from: androidx.viewpager2.widget.AnimateLayoutChangeDetector$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<int[]> {
        public AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = new android.view.ViewGroup.MarginLayoutParams(-1, -1);
        ZERO_MARGIN_LAYOUT_PARAMS = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public AnimateLayoutChangeDetector(@androidx.annotation.NonNull androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    private boolean arePagesLaidOutContiguously() {
        int top;
        int i;
        int bottom;
        int i2;
        int childCount = this.mLayoutManager.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z = this.mLayoutManager.getOrientation() == 0;
        int[][] iArr = (int[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Integer.TYPE, childCount, 2);
        for (int i3 = 0; i3 < childCount; i3++) {
            android.view.View childAt = this.mLayoutManager.getChildAt(i3);
            if (childAt == null) {
                throw new java.lang.IllegalStateException("null view contained in the view hierarchy");
            }
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof android.view.ViewGroup.MarginLayoutParams ? (android.view.ViewGroup.MarginLayoutParams) layoutParams : ZERO_MARGIN_LAYOUT_PARAMS;
            int[] iArr2 = iArr[i3];
            if (z) {
                top = childAt.getLeft();
                i = marginLayoutParams.leftMargin;
            } else {
                top = childAt.getTop();
                i = marginLayoutParams.topMargin;
            }
            iArr2[0] = top - i;
            int[] iArr3 = iArr[i3];
            if (z) {
                bottom = childAt.getRight();
                i2 = marginLayoutParams.rightMargin;
            } else {
                bottom = childAt.getBottom();
                i2 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i2;
        }
        java.util.Arrays.sort(iArr, new androidx.viewpager2.widget.AnimateLayoutChangeDetector.AnonymousClass1());
        for (int i4 = 1; i4 < childCount; i4++) {
            if (iArr[i4 - 1][1] != iArr[i4][0]) {
                return false;
            }
        }
        int[] iArr4 = iArr[0];
        int i5 = iArr4[1];
        int i6 = iArr4[0];
        return i6 <= 0 && iArr[childCount - 1][1] >= i5 - i6;
    }

    private boolean hasRunningChangingLayoutTransition() {
        int childCount = this.mLayoutManager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (hasRunningChangingLayoutTransition(this.mLayoutManager.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasRunningChangingLayoutTransition(android.view.View view) {
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            android.animation.LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (hasRunningChangingLayoutTransition(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean mayHaveInterferingAnimations() {
        return (!arePagesLaidOutContiguously() || this.mLayoutManager.getChildCount() <= 1) && hasRunningChangingLayoutTransition();
    }
}
