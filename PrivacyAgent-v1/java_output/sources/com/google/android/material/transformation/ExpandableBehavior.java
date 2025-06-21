package com.google.android.material.transformation;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public abstract class ExpandableBehavior extends androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior<android.view.View> {
    private static final int STATE_COLLAPSED = 2;
    private static final int STATE_EXPANDED = 1;
    private static final int STATE_UNINITIALIZED = 0;
    private int currentState;

    /* renamed from: com.google.android.material.transformation.ExpandableBehavior$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ android.view.View val$child;
        final /* synthetic */ com.google.android.material.expandable.ExpandableWidget val$dep;
        final /* synthetic */ int val$expectedState;

        public AnonymousClass1(android.view.View view, int i, com.google.android.material.expandable.ExpandableWidget expandableWidget) {
            this.val$child = view;
            this.val$expectedState = i;
            this.val$dep = expandableWidget;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.val$child.getViewTreeObserver().removeOnPreDrawListener(this);
            if (com.google.android.material.transformation.ExpandableBehavior.this.currentState == this.val$expectedState) {
                com.google.android.material.transformation.ExpandableBehavior expandableBehavior = com.google.android.material.transformation.ExpandableBehavior.this;
                com.google.android.material.expandable.ExpandableWidget expandableWidget = this.val$dep;
                expandableBehavior.onExpandedStateChange((android.view.View) expandableWidget, this.val$child, expandableWidget.isExpanded(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.currentState = 0;
    }

    public ExpandableBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentState = 0;
    }

    private boolean didStateChange(boolean z) {
        if (!z) {
            return this.currentState == 1;
        }
        int i = this.currentState;
        return i == 0 || i == 2;
    }

    @androidx.annotation.Nullable
    public static <T extends com.google.android.material.transformation.ExpandableBehavior> T from(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.lang.Class<T> cls) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams)) {
            throw new java.lang.IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior behavior = ((androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (behavior instanceof com.google.android.material.transformation.ExpandableBehavior) {
            return cls.cast(behavior);
        }
        throw new java.lang.IllegalArgumentException("The view is not associated with ExpandableBehavior");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @androidx.annotation.Nullable
    public com.google.android.material.expandable.ExpandableWidget findExpandableWidget(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull android.view.View view) {
        java.util.List<android.view.View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i = 0; i < size; i++) {
            android.view.View view2 = dependencies.get(i);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (com.google.android.material.expandable.ExpandableWidget) view2;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @androidx.annotation.CallSuper
    public boolean onDependentViewChanged(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.View view2) {
        com.google.android.material.expandable.ExpandableWidget expandableWidget = (com.google.android.material.expandable.ExpandableWidget) view2;
        if (!didStateChange(expandableWidget.isExpanded())) {
            return false;
        }
        this.currentState = expandableWidget.isExpanded() ? 1 : 2;
        return onExpandedStateChange((android.view.View) expandableWidget, view, expandableWidget.isExpanded(), true);
    }

    public abstract boolean onExpandedStateChange(android.view.View view, android.view.View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @androidx.annotation.CallSuper
    public boolean onLayoutChild(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull android.view.View view, int i) {
        com.google.android.material.expandable.ExpandableWidget findExpandableWidget;
        if (androidx.core.view.ViewCompat.isLaidOut(view) || (findExpandableWidget = findExpandableWidget(coordinatorLayout, view)) == null || !didStateChange(findExpandableWidget.isExpanded())) {
            return false;
        }
        int i2 = findExpandableWidget.isExpanded() ? 1 : 2;
        this.currentState = i2;
        view.getViewTreeObserver().addOnPreDrawListener(new com.google.android.material.transformation.ExpandableBehavior.AnonymousClass1(view, i2, findExpandableWidget));
        return false;
    }
}
