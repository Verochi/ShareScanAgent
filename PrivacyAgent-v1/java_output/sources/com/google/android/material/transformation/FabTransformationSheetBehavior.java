package com.google.android.material.transformation;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public class FabTransformationSheetBehavior extends com.google.android.material.transformation.FabTransformationBehavior {

    @androidx.annotation.Nullable
    private java.util.Map<android.view.View, java.lang.Integer> importantForAccessibilityMap;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void updateImportantForAccessibility(@androidx.annotation.NonNull android.view.View view, boolean z) {
        android.view.ViewParent parent = view.getParent();
        if (parent instanceof androidx.coordinatorlayout.widget.CoordinatorLayout) {
            androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout = (androidx.coordinatorlayout.widget.CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                this.importantForAccessibilityMap = new java.util.HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                android.view.View childAt = coordinatorLayout.getChildAt(i);
                boolean z2 = (childAt.getLayoutParams() instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) && (((androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).getBehavior() instanceof com.google.android.material.transformation.FabTransformationScrimBehavior);
                if (childAt != view && !z2) {
                    if (z) {
                        this.importantForAccessibilityMap.put(childAt, java.lang.Integer.valueOf(childAt.getImportantForAccessibility()));
                        androidx.core.view.ViewCompat.setImportantForAccessibility(childAt, 4);
                    } else {
                        java.util.Map<android.view.View, java.lang.Integer> map = this.importantForAccessibilityMap;
                        if (map != null && map.containsKey(childAt)) {
                            androidx.core.view.ViewCompat.setImportantForAccessibility(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                        }
                    }
                }
            }
            if (z) {
                return;
            }
            this.importantForAccessibilityMap = null;
        }
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    @androidx.annotation.NonNull
    public com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec onCreateMotionSpec(android.content.Context context, boolean z) {
        int i = z ? com.google.android.material.R.animator.mtrl_fab_transformation_sheet_expand_spec : com.google.android.material.R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec fabTransformationSpec = new com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec();
        fabTransformationSpec.timings = com.google.android.material.animation.MotionSpec.createFromResource(context, i);
        fabTransformationSpec.positioning = new com.google.android.material.animation.Positioning(17, 0.0f, 0.0f);
        return fabTransformationSpec;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    @androidx.annotation.CallSuper
    public boolean onExpandedStateChange(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, boolean z, boolean z2) {
        updateImportantForAccessibility(view2, z);
        return super.onExpandedStateChange(view, view2, z, z2);
    }
}
