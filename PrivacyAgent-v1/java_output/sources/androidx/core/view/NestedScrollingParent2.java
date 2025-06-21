package androidx.core.view;

/* loaded from: classes.dex */
public interface NestedScrollingParent2 extends androidx.core.view.NestedScrollingParent {
    void onNestedPreScroll(@androidx.annotation.NonNull android.view.View view, int i, int i2, @androidx.annotation.NonNull int[] iArr, int i3);

    void onNestedScroll(@androidx.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4, int i5);

    void onNestedScrollAccepted(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, int i, int i2);

    boolean onStartNestedScroll(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, int i, int i2);

    void onStopNestedScroll(@androidx.annotation.NonNull android.view.View view, int i);
}
