package com.google.android.material.button;

/* loaded from: classes22.dex */
public class MaterialButtonToggleGroup extends android.widget.LinearLayout {
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;
    private static final java.lang.String LOG_TAG = "MaterialButtonToggleGroup";

    @androidx.annotation.IdRes
    private int checkedId;
    private final com.google.android.material.button.MaterialButtonToggleGroup.CheckedStateTracker checkedStateTracker;
    private java.lang.Integer[] childOrder;
    private final java.util.Comparator<com.google.android.material.button.MaterialButton> childOrderComparator;
    private final java.util.LinkedHashSet<com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener> onButtonCheckedListeners;
    private final java.util.List<com.google.android.material.button.MaterialButtonToggleGroup.CornerData> originalCornerData;
    private final com.google.android.material.button.MaterialButtonToggleGroup.PressedStateTracker pressedStateTracker;
    private boolean selectionRequired;
    private boolean singleSelection;
    private boolean skipCheckedStateTracker;

    /* renamed from: com.google.android.material.button.MaterialButtonToggleGroup$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<com.google.android.material.button.MaterialButton> {
        public AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(com.google.android.material.button.MaterialButton materialButton, com.google.android.material.button.MaterialButton materialButton2) {
            int compareTo = java.lang.Boolean.valueOf(materialButton.isChecked()).compareTo(java.lang.Boolean.valueOf(materialButton2.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = java.lang.Boolean.valueOf(materialButton.isPressed()).compareTo(java.lang.Boolean.valueOf(materialButton2.isPressed()));
            return compareTo2 != 0 ? compareTo2 : java.lang.Integer.valueOf(com.google.android.material.button.MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(java.lang.Integer.valueOf(com.google.android.material.button.MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    /* renamed from: com.google.android.material.button.MaterialButtonToggleGroup$2, reason: invalid class name */
    public class AnonymousClass2 extends androidx.core.view.AccessibilityDelegateCompat {
        public AnonymousClass2() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(android.view.View view, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionItemInfo(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, com.google.android.material.button.MaterialButtonToggleGroup.this.getIndexWithinVisibleButtons(view), 1, false, ((com.google.android.material.button.MaterialButton) view).isChecked()));
        }
    }

    public class CheckedStateTracker implements com.google.android.material.button.MaterialButton.OnCheckedChangeListener {
        private CheckedStateTracker() {
        }

        public /* synthetic */ CheckedStateTracker(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup, com.google.android.material.button.MaterialButtonToggleGroup.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.material.button.MaterialButton.OnCheckedChangeListener
        public void onCheckedChanged(@androidx.annotation.NonNull com.google.android.material.button.MaterialButton materialButton, boolean z) {
            if (com.google.android.material.button.MaterialButtonToggleGroup.this.skipCheckedStateTracker) {
                return;
            }
            if (com.google.android.material.button.MaterialButtonToggleGroup.this.singleSelection) {
                com.google.android.material.button.MaterialButtonToggleGroup.this.checkedId = z ? materialButton.getId() : -1;
            }
            if (com.google.android.material.button.MaterialButtonToggleGroup.this.updateCheckedStates(materialButton.getId(), z)) {
                com.google.android.material.button.MaterialButtonToggleGroup.this.dispatchOnButtonChecked(materialButton.getId(), materialButton.isChecked());
            }
            com.google.android.material.button.MaterialButtonToggleGroup.this.invalidate();
        }
    }

    public static class CornerData {
        private static final com.google.android.material.shape.CornerSize noCorner = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
        com.google.android.material.shape.CornerSize bottomLeft;
        com.google.android.material.shape.CornerSize bottomRight;
        com.google.android.material.shape.CornerSize topLeft;
        com.google.android.material.shape.CornerSize topRight;

        public CornerData(com.google.android.material.shape.CornerSize cornerSize, com.google.android.material.shape.CornerSize cornerSize2, com.google.android.material.shape.CornerSize cornerSize3, com.google.android.material.shape.CornerSize cornerSize4) {
            this.topLeft = cornerSize;
            this.topRight = cornerSize3;
            this.bottomRight = cornerSize4;
            this.bottomLeft = cornerSize2;
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.CornerData bottom(com.google.android.material.button.MaterialButtonToggleGroup.CornerData cornerData) {
            com.google.android.material.shape.CornerSize cornerSize = noCorner;
            return new com.google.android.material.button.MaterialButtonToggleGroup.CornerData(cornerSize, cornerData.bottomLeft, cornerSize, cornerData.bottomRight);
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.CornerData end(com.google.android.material.button.MaterialButtonToggleGroup.CornerData cornerData, android.view.View view) {
            return com.google.android.material.internal.ViewUtils.isLayoutRtl(view) ? left(cornerData) : right(cornerData);
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.CornerData left(com.google.android.material.button.MaterialButtonToggleGroup.CornerData cornerData) {
            com.google.android.material.shape.CornerSize cornerSize = cornerData.topLeft;
            com.google.android.material.shape.CornerSize cornerSize2 = cornerData.bottomLeft;
            com.google.android.material.shape.CornerSize cornerSize3 = noCorner;
            return new com.google.android.material.button.MaterialButtonToggleGroup.CornerData(cornerSize, cornerSize2, cornerSize3, cornerSize3);
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.CornerData right(com.google.android.material.button.MaterialButtonToggleGroup.CornerData cornerData) {
            com.google.android.material.shape.CornerSize cornerSize = noCorner;
            return new com.google.android.material.button.MaterialButtonToggleGroup.CornerData(cornerSize, cornerSize, cornerData.topRight, cornerData.bottomRight);
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.CornerData start(com.google.android.material.button.MaterialButtonToggleGroup.CornerData cornerData, android.view.View view) {
            return com.google.android.material.internal.ViewUtils.isLayoutRtl(view) ? right(cornerData) : left(cornerData);
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.CornerData top(com.google.android.material.button.MaterialButtonToggleGroup.CornerData cornerData) {
            com.google.android.material.shape.CornerSize cornerSize = cornerData.topLeft;
            com.google.android.material.shape.CornerSize cornerSize2 = noCorner;
            return new com.google.android.material.button.MaterialButtonToggleGroup.CornerData(cornerSize, cornerSize2, cornerData.topRight, cornerSize2);
        }
    }

    public interface OnButtonCheckedListener {
        void onButtonChecked(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup, @androidx.annotation.IdRes int i, boolean z);
    }

    public class PressedStateTracker implements com.google.android.material.button.MaterialButton.OnPressedChangeListener {
        private PressedStateTracker() {
        }

        public /* synthetic */ PressedStateTracker(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup, com.google.android.material.button.MaterialButtonToggleGroup.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.material.button.MaterialButton.OnPressedChangeListener
        public void onPressedChanged(@androidx.annotation.NonNull com.google.android.material.button.MaterialButton materialButton, boolean z) {
            com.google.android.material.button.MaterialButtonToggleGroup.this.invalidate();
        }
    }

    public MaterialButtonToggleGroup(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public MaterialButtonToggleGroup(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialButtonToggleGroup(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i, r4), attributeSet, i);
        int i2 = DEF_STYLE_RES;
        this.originalCornerData = new java.util.ArrayList();
        this.checkedStateTracker = new com.google.android.material.button.MaterialButtonToggleGroup.CheckedStateTracker(this, null);
        this.pressedStateTracker = new com.google.android.material.button.MaterialButtonToggleGroup.PressedStateTracker(this, null);
        this.onButtonCheckedListeners = new java.util.LinkedHashSet<>();
        this.childOrderComparator = new com.google.android.material.button.MaterialButtonToggleGroup.AnonymousClass1();
        this.skipCheckedStateTracker = false;
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, com.google.android.material.R.styleable.MaterialButtonToggleGroup, i, i2, new int[0]);
        setSingleSelection(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.checkedId = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.selectionRequired = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        obtainStyledAttributes.recycle();
        androidx.core.view.ViewCompat.setImportantForAccessibility(this, 1);
    }

    private void adjustChildMarginsAndUpdateLayout() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            com.google.android.material.button.MaterialButton childButton = getChildButton(i);
            int min = java.lang.Math.min(childButton.getStrokeWidth(), getChildButton(i - 1).getStrokeWidth());
            android.widget.LinearLayout.LayoutParams buildLayoutParams = buildLayoutParams(childButton);
            if (getOrientation() == 0) {
                androidx.core.view.MarginLayoutParamsCompat.setMarginEnd(buildLayoutParams, 0);
                androidx.core.view.MarginLayoutParamsCompat.setMarginStart(buildLayoutParams, -min);
                buildLayoutParams.topMargin = 0;
            } else {
                buildLayoutParams.bottomMargin = 0;
                buildLayoutParams.topMargin = -min;
                androidx.core.view.MarginLayoutParamsCompat.setMarginStart(buildLayoutParams, 0);
            }
            childButton.setLayoutParams(buildLayoutParams);
        }
        resetChildMargins(firstVisibleChildIndex);
    }

    @androidx.annotation.NonNull
    private android.widget.LinearLayout.LayoutParams buildLayoutParams(@androidx.annotation.NonNull android.view.View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof android.widget.LinearLayout.LayoutParams ? (android.widget.LinearLayout.LayoutParams) layoutParams : new android.widget.LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void checkForced(int i, boolean z) {
        com.google.android.material.button.MaterialButton materialButton = (com.google.android.material.button.MaterialButton) findViewById(i);
        if (materialButton != null) {
            materialButton.setChecked(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnButtonChecked(@androidx.annotation.IdRes int i, boolean z) {
        java.util.Iterator<com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener> it = this.onButtonCheckedListeners.iterator();
        while (it.hasNext()) {
            it.next().onButtonChecked(this, i, z);
        }
    }

    private com.google.android.material.button.MaterialButton getChildButton(int i) {
        return (com.google.android.material.button.MaterialButton) getChildAt(i);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (isChildVisible(i)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getIndexWithinVisibleButtons(@androidx.annotation.Nullable android.view.View view) {
        if (!(view instanceof com.google.android.material.button.MaterialButton)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) == view) {
                return i;
            }
            if ((getChildAt(i2) instanceof com.google.android.material.button.MaterialButton) && isChildVisible(i2)) {
                i++;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (isChildVisible(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    @androidx.annotation.Nullable
    private com.google.android.material.button.MaterialButtonToggleGroup.CornerData getNewCornerData(int i, int i2, int i3) {
        com.google.android.material.button.MaterialButtonToggleGroup.CornerData cornerData = this.originalCornerData.get(i);
        if (i2 == i3) {
            return cornerData;
        }
        boolean z = getOrientation() == 0;
        if (i == i2) {
            return z ? com.google.android.material.button.MaterialButtonToggleGroup.CornerData.start(cornerData, this) : com.google.android.material.button.MaterialButtonToggleGroup.CornerData.top(cornerData);
        }
        if (i == i3) {
            return z ? com.google.android.material.button.MaterialButtonToggleGroup.CornerData.end(cornerData, this) : com.google.android.material.button.MaterialButtonToggleGroup.CornerData.bottom(cornerData);
        }
        return null;
    }

    private int getVisibleButtonCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof com.google.android.material.button.MaterialButton) && isChildVisible(i2)) {
                i++;
            }
        }
        return i;
    }

    private boolean isChildVisible(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    private void resetChildMargins(int i) {
        if (getChildCount() == 0 || i == -1) {
            return;
        }
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) getChildButton(i).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            androidx.core.view.MarginLayoutParamsCompat.setMarginEnd(layoutParams, 0);
            androidx.core.view.MarginLayoutParamsCompat.setMarginStart(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void setCheckedId(int i) {
        this.checkedId = i;
        dispatchOnButtonChecked(i, true);
    }

    private void setCheckedStateForView(@androidx.annotation.IdRes int i, boolean z) {
        android.view.View findViewById = findViewById(i);
        if (findViewById instanceof com.google.android.material.button.MaterialButton) {
            this.skipCheckedStateTracker = true;
            ((com.google.android.material.button.MaterialButton) findViewById).setChecked(z);
            this.skipCheckedStateTracker = false;
        }
    }

    private void setGeneratedIdIfNeeded(@androidx.annotation.NonNull com.google.android.material.button.MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(androidx.core.view.ViewCompat.generateViewId());
        }
    }

    private void setupButtonChild(@androidx.annotation.NonNull com.google.android.material.button.MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(android.text.TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.addOnCheckedChangeListener(this.checkedStateTracker);
        materialButton.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private static void updateBuilderWithCornerData(com.google.android.material.shape.ShapeAppearanceModel.Builder builder, @androidx.annotation.Nullable com.google.android.material.button.MaterialButtonToggleGroup.CornerData cornerData) {
        if (cornerData == null) {
            builder.setAllCornerSizes(0.0f);
        } else {
            builder.setTopLeftCornerSize(cornerData.topLeft).setBottomLeftCornerSize(cornerData.bottomLeft).setTopRightCornerSize(cornerData.topRight).setBottomRightCornerSize(cornerData.bottomRight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateCheckedStates(int i, boolean z) {
        java.util.List<java.lang.Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.selectionRequired && checkedButtonIds.isEmpty()) {
            setCheckedStateForView(i, true);
            this.checkedId = i;
            return false;
        }
        if (z && this.singleSelection) {
            checkedButtonIds.remove(java.lang.Integer.valueOf(i));
            java.util.Iterator<java.lang.Integer> it = checkedButtonIds.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                setCheckedStateForView(intValue, false);
                dispatchOnButtonChecked(intValue, false);
            }
        }
        return true;
    }

    private void updateChildOrder() {
        java.util.TreeMap treeMap = new java.util.TreeMap(this.childOrderComparator);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put(getChildButton(i), java.lang.Integer.valueOf(i));
        }
        this.childOrder = (java.lang.Integer[]) treeMap.values().toArray(new java.lang.Integer[0]);
    }

    public void addOnButtonCheckedListener(@androidx.annotation.NonNull com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener onButtonCheckedListener) {
        this.onButtonCheckedListeners.add(onButtonCheckedListener);
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        if (view instanceof com.google.android.material.button.MaterialButton) {
            super.addView(view, i, layoutParams);
            com.google.android.material.button.MaterialButton materialButton = (com.google.android.material.button.MaterialButton) view;
            setGeneratedIdIfNeeded(materialButton);
            setupButtonChild(materialButton);
            if (materialButton.isChecked()) {
                updateCheckedStates(materialButton.getId(), true);
                setCheckedId(materialButton.getId());
            }
            com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
            this.originalCornerData.add(new com.google.android.material.button.MaterialButtonToggleGroup.CornerData(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel.getBottomRightCornerSize()));
            androidx.core.view.ViewCompat.setAccessibilityDelegate(materialButton, new com.google.android.material.button.MaterialButtonToggleGroup.AnonymousClass2());
        }
    }

    public void check(@androidx.annotation.IdRes int i) {
        if (i == this.checkedId) {
            return;
        }
        checkForced(i, true);
    }

    public void clearChecked() {
        this.skipCheckedStateTracker = true;
        for (int i = 0; i < getChildCount(); i++) {
            com.google.android.material.button.MaterialButton childButton = getChildButton(i);
            childButton.setChecked(false);
            dispatchOnButtonChecked(childButton.getId(), false);
        }
        this.skipCheckedStateTracker = false;
        setCheckedId(-1);
    }

    public void clearOnButtonCheckedListeners() {
        this.onButtonCheckedListeners.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        updateChildOrder();
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @androidx.annotation.NonNull
    public java.lang.CharSequence getAccessibilityClassName() {
        return com.google.android.material.button.MaterialButtonToggleGroup.class.getName();
    }

    @androidx.annotation.IdRes
    public int getCheckedButtonId() {
        if (this.singleSelection) {
            return this.checkedId;
        }
        return -1;
    }

    @androidx.annotation.NonNull
    public java.util.List<java.lang.Integer> getCheckedButtonIds() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            com.google.android.material.button.MaterialButton childButton = getChildButton(i);
            if (childButton.isChecked()) {
                arrayList.add(java.lang.Integer.valueOf(childButton.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        java.lang.Integer[] numArr = this.childOrder;
        return (numArr == null || i2 >= numArr.length) ? i2 : numArr[i2].intValue();
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.checkedId;
        if (i != -1) {
            checkForced(i, true);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@androidx.annotation.NonNull android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.view.accessibility.AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getVisibleButtonCount(), false, isSingleSelection() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(android.view.View view) {
        super.onViewRemoved(view);
        if (view instanceof com.google.android.material.button.MaterialButton) {
            com.google.android.material.button.MaterialButton materialButton = (com.google.android.material.button.MaterialButton) view;
            materialButton.removeOnCheckedChangeListener(this.checkedStateTracker);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.originalCornerData.remove(indexOfChild);
        }
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
    }

    public void removeOnButtonCheckedListener(@androidx.annotation.NonNull com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener onButtonCheckedListener) {
        this.onButtonCheckedListeners.remove(onButtonCheckedListener);
    }

    public void setSelectionRequired(boolean z) {
        this.selectionRequired = z;
    }

    public void setSingleSelection(@androidx.annotation.BoolRes int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    public void setSingleSelection(boolean z) {
        if (this.singleSelection != z) {
            this.singleSelection = z;
            clearChecked();
        }
    }

    public void uncheck(@androidx.annotation.IdRes int i) {
        checkForced(i, false);
    }

    @androidx.annotation.VisibleForTesting
    public void updateChildShapes() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i = 0; i < childCount; i++) {
            com.google.android.material.button.MaterialButton childButton = getChildButton(i);
            if (childButton.getVisibility() != 8) {
                com.google.android.material.shape.ShapeAppearanceModel.Builder builder = childButton.getShapeAppearanceModel().toBuilder();
                updateBuilderWithCornerData(builder, getNewCornerData(i, firstVisibleChildIndex, lastVisibleChildIndex));
                childButton.setShapeAppearanceModel(builder.build());
            }
        }
    }
}
