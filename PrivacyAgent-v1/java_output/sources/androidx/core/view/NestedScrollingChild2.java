package androidx.core.view;

/* loaded from: classes.dex */
public interface NestedScrollingChild2 extends androidx.core.view.NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i, int i2, @androidx.annotation.Nullable int[] iArr, @androidx.annotation.Nullable int[] iArr2, int i3);

    boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @androidx.annotation.Nullable int[] iArr, int i5);

    boolean hasNestedScrollingParent(int i);

    boolean startNestedScroll(int i, int i2);

    void stopNestedScroll(int i);
}
