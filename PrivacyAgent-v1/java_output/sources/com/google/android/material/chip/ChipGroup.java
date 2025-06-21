package com.google.android.material.chip;

/* loaded from: classes22.dex */
public class ChipGroup extends com.google.android.material.internal.FlowLayout {
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_ChipGroup;

    @androidx.annotation.IdRes
    private int checkedId;
    private final com.google.android.material.chip.ChipGroup.CheckedStateTracker checkedStateTracker;

    @androidx.annotation.Dimension
    private int chipSpacingHorizontal;

    @androidx.annotation.Dimension
    private int chipSpacingVertical;

    @androidx.annotation.Nullable
    private com.google.android.material.chip.ChipGroup.OnCheckedChangeListener onCheckedChangeListener;

    @androidx.annotation.NonNull
    private com.google.android.material.chip.ChipGroup.PassThroughHierarchyChangeListener passThroughListener;
    private boolean protectFromCheckedChange;
    private boolean selectionRequired;
    private boolean singleSelection;

    public class CheckedStateTracker implements android.widget.CompoundButton.OnCheckedChangeListener {
        private CheckedStateTracker() {
        }

        public /* synthetic */ CheckedStateTracker(com.google.android.material.chip.ChipGroup chipGroup, com.google.android.material.chip.ChipGroup.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(@androidx.annotation.NonNull android.widget.CompoundButton compoundButton, boolean z) {
            if (com.google.android.material.chip.ChipGroup.this.protectFromCheckedChange) {
                return;
            }
            if (com.google.android.material.chip.ChipGroup.this.getCheckedChipIds().isEmpty() && com.google.android.material.chip.ChipGroup.this.selectionRequired) {
                com.google.android.material.chip.ChipGroup.this.setCheckedStateForView(compoundButton.getId(), true);
                com.google.android.material.chip.ChipGroup.this.setCheckedId(compoundButton.getId(), false);
                return;
            }
            int id = compoundButton.getId();
            if (!z) {
                if (com.google.android.material.chip.ChipGroup.this.checkedId == id) {
                    com.google.android.material.chip.ChipGroup.this.setCheckedId(-1);
                }
            } else {
                if (com.google.android.material.chip.ChipGroup.this.checkedId != -1 && com.google.android.material.chip.ChipGroup.this.checkedId != id && com.google.android.material.chip.ChipGroup.this.singleSelection) {
                    com.google.android.material.chip.ChipGroup chipGroup = com.google.android.material.chip.ChipGroup.this;
                    chipGroup.setCheckedStateForView(chipGroup.checkedId, false);
                }
                com.google.android.material.chip.ChipGroup.this.setCheckedId(id);
            }
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {
        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(com.google.android.material.chip.ChipGroup chipGroup, @androidx.annotation.IdRes int i);
    }

    public class PassThroughHierarchyChangeListener implements android.view.ViewGroup.OnHierarchyChangeListener {
        private android.view.ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;

        private PassThroughHierarchyChangeListener() {
        }

        public /* synthetic */ PassThroughHierarchyChangeListener(com.google.android.material.chip.ChipGroup chipGroup, com.google.android.material.chip.ChipGroup.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(android.view.View view, android.view.View view2) {
            if (view == com.google.android.material.chip.ChipGroup.this && (view2 instanceof com.google.android.material.chip.Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(androidx.core.view.ViewCompat.generateViewId());
                }
                com.google.android.material.chip.Chip chip = (com.google.android.material.chip.Chip) view2;
                if (chip.isChecked()) {
                    ((com.google.android.material.chip.ChipGroup) view).check(chip.getId());
                }
                chip.setOnCheckedChangeListenerInternal(com.google.android.material.chip.ChipGroup.this.checkedStateTracker);
            }
            android.view.ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.onHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(android.view.View view, android.view.View view2) {
            if (view == com.google.android.material.chip.ChipGroup.this && (view2 instanceof com.google.android.material.chip.Chip)) {
                ((com.google.android.material.chip.Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            android.view.ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.onHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(android.content.Context context) {
        this(context, null);
    }

    public ChipGroup(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.chipGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChipGroup(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i, r4), attributeSet, i);
        int i2 = DEF_STYLE_RES;
        this.checkedStateTracker = new com.google.android.material.chip.ChipGroup.CheckedStateTracker(this, null);
        this.passThroughListener = new com.google.android.material.chip.ChipGroup.PassThroughHierarchyChangeListener(this, null);
        this.checkedId = -1;
        this.protectFromCheckedChange = false;
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, com.google.android.material.R.styleable.ChipGroup, i, i2, new int[0]);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.ChipGroup_singleLine, false));
        setSingleSelection(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.ChipGroup_singleSelection, false));
        setSelectionRequired(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.ChipGroup_selectionRequired, false));
        int resourceId = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.ChipGroup_checkedChip, -1);
        if (resourceId != -1) {
            this.checkedId = resourceId;
        }
        obtainStyledAttributes.recycle();
        super.setOnHierarchyChangeListener(this.passThroughListener);
        androidx.core.view.ViewCompat.setImportantForAccessibility(this, 1);
    }

    private int getChipCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof com.google.android.material.chip.Chip) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i) {
        setCheckedId(i, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i, boolean z) {
        this.checkedId = i;
        com.google.android.material.chip.ChipGroup.OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListener;
        if (onCheckedChangeListener != null && this.singleSelection && z) {
            onCheckedChangeListener.onCheckedChanged(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedStateForView(@androidx.annotation.IdRes int i, boolean z) {
        android.view.View findViewById = findViewById(i);
        if (findViewById instanceof com.google.android.material.chip.Chip) {
            this.protectFromCheckedChange = true;
            ((com.google.android.material.chip.Chip) findViewById).setChecked(z);
            this.protectFromCheckedChange = false;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        if (view instanceof com.google.android.material.chip.Chip) {
            com.google.android.material.chip.Chip chip = (com.google.android.material.chip.Chip) view;
            if (chip.isChecked()) {
                int i2 = this.checkedId;
                if (i2 != -1 && this.singleSelection) {
                    setCheckedStateForView(i2, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i, layoutParams);
    }

    public void check(@androidx.annotation.IdRes int i) {
        int i2 = this.checkedId;
        if (i == i2) {
            return;
        }
        if (i2 != -1 && this.singleSelection) {
            setCheckedStateForView(i2, false);
        }
        if (i != -1) {
            setCheckedStateForView(i, true);
        }
        setCheckedId(i);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof com.google.android.material.chip.ChipGroup.LayoutParams);
    }

    public void clearCheck() {
        this.protectFromCheckedChange = true;
        for (int i = 0; i < getChildCount(); i++) {
            android.view.View childAt = getChildAt(i);
            if (childAt instanceof com.google.android.material.chip.Chip) {
                ((com.google.android.material.chip.Chip) childAt).setChecked(false);
            }
        }
        this.protectFromCheckedChange = false;
        setCheckedId(-1);
    }

    @Override // android.view.ViewGroup
    @androidx.annotation.NonNull
    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new com.google.android.material.chip.ChipGroup.LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    @androidx.annotation.NonNull
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new com.google.android.material.chip.ChipGroup.LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    @androidx.annotation.NonNull
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new com.google.android.material.chip.ChipGroup.LayoutParams(layoutParams);
    }

    @androidx.annotation.IdRes
    public int getCheckedChipId() {
        if (this.singleSelection) {
            return this.checkedId;
        }
        return -1;
    }

    @androidx.annotation.NonNull
    public java.util.List<java.lang.Integer> getCheckedChipIds() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            android.view.View childAt = getChildAt(i);
            if ((childAt instanceof com.google.android.material.chip.Chip) && ((com.google.android.material.chip.Chip) childAt).isChecked()) {
                arrayList.add(java.lang.Integer.valueOf(childAt.getId()));
                if (this.singleSelection) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    @androidx.annotation.Dimension
    public int getChipSpacingHorizontal() {
        return this.chipSpacingHorizontal;
    }

    @androidx.annotation.Dimension
    public int getChipSpacingVertical() {
        return this.chipSpacingVertical;
    }

    public int getIndexOfChip(@androidx.annotation.Nullable android.view.View view) {
        if (!(view instanceof com.google.android.material.chip.Chip)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof com.google.android.material.chip.Chip) {
                if (((com.google.android.material.chip.Chip) getChildAt(i2)) == view) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean isSingleLine() {
        return super.isSingleLine();
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.checkedId;
        if (i != -1) {
            setCheckedStateForView(i, true);
            setCheckedId(this.checkedId);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@androidx.annotation.NonNull android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.view.accessibility.AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCount(), isSingleLine() ? getChipCount() : -1, false, isSingleSelection() ? 1 : 2));
    }

    public void setChipSpacing(@androidx.annotation.Dimension int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingHorizontal(@androidx.annotation.Dimension int i) {
        if (this.chipSpacingHorizontal != i) {
            this.chipSpacingHorizontal = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(@androidx.annotation.DimenRes int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingResource(@androidx.annotation.DimenRes int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingVertical(@androidx.annotation.Dimension int i) {
        if (this.chipSpacingVertical != i) {
            this.chipSpacingVertical = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(@androidx.annotation.DimenRes int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    @java.lang.Deprecated
    public void setDividerDrawableHorizontal(android.graphics.drawable.Drawable drawable) {
        throw new java.lang.UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @java.lang.Deprecated
    public void setDividerDrawableVertical(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        throw new java.lang.UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @java.lang.Deprecated
    public void setFlexWrap(int i) {
        throw new java.lang.UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(com.google.android.material.chip.ChipGroup.OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(android.view.ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.passThroughListener.onHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.selectionRequired = z;
    }

    @java.lang.Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new java.lang.UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @java.lang.Deprecated
    public void setShowDividerVertical(int i) {
        throw new java.lang.UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(@androidx.annotation.BoolRes int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(@androidx.annotation.BoolRes int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    public void setSingleSelection(boolean z) {
        if (this.singleSelection != z) {
            this.singleSelection = z;
            clearCheck();
        }
    }
}
