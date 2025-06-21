package com.google.android.material.textfield;

/* loaded from: classes22.dex */
public class MaterialAutoCompleteTextView extends androidx.appcompat.widget.AppCompatAutoCompleteTextView {
    private static final int MAX_ITEMS_MEASURED = 15;

    @androidx.annotation.Nullable
    private final android.view.accessibility.AccessibilityManager accessibilityManager;

    @androidx.annotation.NonNull
    private final androidx.appcompat.widget.ListPopupWindow modalListPopup;

    @androidx.annotation.NonNull
    private final android.graphics.Rect tempRect;

    /* renamed from: com.google.android.material.textfield.MaterialAutoCompleteTextView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.AdapterView.OnItemClickListener {
        public AnonymousClass1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
            com.google.android.material.textfield.MaterialAutoCompleteTextView.this.updateText(i < 0 ? com.google.android.material.textfield.MaterialAutoCompleteTextView.this.modalListPopup.getSelectedItem() : com.google.android.material.textfield.MaterialAutoCompleteTextView.this.getAdapter().getItem(i));
            android.widget.AdapterView.OnItemClickListener onItemClickListener = com.google.android.material.textfield.MaterialAutoCompleteTextView.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i < 0) {
                    view = com.google.android.material.textfield.MaterialAutoCompleteTextView.this.modalListPopup.getSelectedView();
                    i = com.google.android.material.textfield.MaterialAutoCompleteTextView.this.modalListPopup.getSelectedItemPosition();
                    j = com.google.android.material.textfield.MaterialAutoCompleteTextView.this.modalListPopup.getSelectedItemId();
                }
                onItemClickListener.onItemClick(com.google.android.material.textfield.MaterialAutoCompleteTextView.this.modalListPopup.getListView(), view, i, j);
            }
            com.google.android.material.textfield.MaterialAutoCompleteTextView.this.modalListPopup.dismiss();
        }
    }

    public MaterialAutoCompleteTextView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public MaterialAutoCompleteTextView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i, 0), attributeSet, i);
        this.tempRect = new android.graphics.Rect();
        android.content.Context context2 = getContext();
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.MaterialAutoCompleteTextView, i, com.google.android.material.R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int i2 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_inputType;
        if (obtainStyledAttributes.hasValue(i2) && obtainStyledAttributes.getInt(i2, 0) == 0) {
            setKeyListener(null);
        }
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) context2.getSystemService("accessibility");
        androidx.appcompat.widget.ListPopupWindow listPopupWindow = new androidx.appcompat.widget.ListPopupWindow(context2);
        this.modalListPopup = listPopupWindow;
        listPopupWindow.setModal(true);
        listPopupWindow.setAnchorView(this);
        listPopupWindow.setInputMethodMode(2);
        listPopupWindow.setAdapter(getAdapter());
        listPopupWindow.setOnItemClickListener(new com.google.android.material.textfield.MaterialAutoCompleteTextView.AnonymousClass1());
        obtainStyledAttributes.recycle();
    }

    @androidx.annotation.Nullable
    private com.google.android.material.textfield.TextInputLayout findTextInputLayoutAncestor() {
        for (android.view.ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof com.google.android.material.textfield.TextInputLayout) {
                return (com.google.android.material.textfield.TextInputLayout) parent;
            }
        }
        return null;
    }

    private int measureContentWidth() {
        android.widget.ListAdapter adapter = getAdapter();
        com.google.android.material.textfield.TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        int i = 0;
        if (adapter == null || findTextInputLayoutAncestor == null) {
            return 0;
        }
        int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = java.lang.Math.min(adapter.getCount(), java.lang.Math.max(0, this.modalListPopup.getSelectedItemPosition()) + 15);
        android.view.View view = null;
        int i2 = 0;
        for (int max = java.lang.Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = adapter.getView(max, view, findTextInputLayoutAncestor);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = java.lang.Math.max(i2, view.getMeasuredWidth());
        }
        android.graphics.drawable.Drawable background = this.modalListPopup.getBackground();
        if (background != null) {
            background.getPadding(this.tempRect);
            android.graphics.Rect rect = this.tempRect;
            i2 += rect.left + rect.right;
        }
        return i2 + findTextInputLayoutAncestor.getEndIconView().getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends android.widget.ListAdapter & android.widget.Filterable> void updateText(java.lang.Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.TextView
    @androidx.annotation.Nullable
    public java.lang.CharSequence getHint() {
        com.google.android.material.textfield.TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        return (findTextInputLayoutAncestor == null || !findTextInputLayoutAncestor.isProvidingHint()) ? super.getHint() : findTextInputLayoutAncestor.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.textfield.TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        if (findTextInputLayoutAncestor != null && findTextInputLayoutAncestor.isProvidingHint() && super.getHint() == null && com.google.android.material.internal.ManufacturerUtils.isMeizuDevice()) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (android.view.View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(java.lang.Math.min(java.lang.Math.max(getMeasuredWidth(), measureContentWidth()), android.view.View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends android.widget.ListAdapter & android.widget.Filterable> void setAdapter(@androidx.annotation.Nullable T t) {
        super.setAdapter(t);
        this.modalListPopup.setAdapter(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        android.view.accessibility.AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.modalListPopup.show();
        }
    }
}
