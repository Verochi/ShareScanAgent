package androidx.core.view;

/* loaded from: classes.dex */
public interface NestedScrollingChild {
    boolean dispatchNestedFling(float f, float f2, boolean z);

    boolean dispatchNestedPreFling(float f, float f2);

    boolean dispatchNestedPreScroll(int i, int i2, @androidx.annotation.Nullable int[] iArr, @androidx.annotation.Nullable int[] iArr2);

    boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @androidx.annotation.Nullable int[] iArr);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean z);

    boolean startNestedScroll(int i);

    void stopNestedScroll();
}
