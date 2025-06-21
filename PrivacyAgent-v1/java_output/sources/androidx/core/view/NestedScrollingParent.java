package androidx.core.view;

/* loaded from: classes.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(@androidx.annotation.NonNull android.view.View view, float f, float f2, boolean z);

    boolean onNestedPreFling(@androidx.annotation.NonNull android.view.View view, float f, float f2);

    void onNestedPreScroll(@androidx.annotation.NonNull android.view.View view, int i, int i2, @androidx.annotation.NonNull int[] iArr);

    void onNestedScroll(@androidx.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4);

    void onNestedScrollAccepted(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, int i);

    boolean onStartNestedScroll(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, int i);

    void onStopNestedScroll(@androidx.annotation.NonNull android.view.View view);
}
