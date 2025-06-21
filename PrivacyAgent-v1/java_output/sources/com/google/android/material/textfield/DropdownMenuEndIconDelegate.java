package com.google.android.material.textfield;

/* loaded from: classes22.dex */
class DropdownMenuEndIconDelegate extends com.google.android.material.textfield.EndIconDelegate {
    private static final int ANIMATION_FADE_IN_DURATION = 67;
    private static final int ANIMATION_FADE_OUT_DURATION = 50;
    private static final boolean IS_LOLLIPOP = true;
    private final com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate accessibilityDelegate;

    @androidx.annotation.Nullable
    private android.view.accessibility.AccessibilityManager accessibilityManager;
    private final com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener dropdownMenuOnEditTextAttachedListener;
    private long dropdownPopupActivatedAt;
    private boolean dropdownPopupDirty;

    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    private final com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener endIconChangedListener;
    private final android.text.TextWatcher exposedDropdownEndIconTextWatcher;
    private android.animation.ValueAnimator fadeInAnim;
    private android.animation.ValueAnimator fadeOutAnim;
    private android.graphics.drawable.StateListDrawable filledPopupBackground;
    private boolean isEndIconChecked;
    private final android.view.View.OnFocusChangeListener onFocusChangeListener;
    private com.google.android.material.shape.MaterialShapeDrawable outlinedPopupBackground;

    /* renamed from: com.google.android.material.textfield.DropdownMenuEndIconDelegate$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.android.material.internal.TextWatcherAdapter {

        /* renamed from: com.google.android.material.textfield.DropdownMenuEndIconDelegate$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC03331 implements java.lang.Runnable {
            final /* synthetic */ android.widget.AutoCompleteTextView val$editText;

            public RunnableC03331(android.widget.AutoCompleteTextView autoCompleteTextView) {
                this.val$editText = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.val$editText.isPopupShowing();
                com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.setEndIconChecked(isPopupShowing);
                com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.dropdownPopupDirty = isPopupShowing;
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(android.text.Editable editable) {
            android.widget.AutoCompleteTextView castAutoCompleteTextViewOrThrow = com.google.android.material.textfield.DropdownMenuEndIconDelegate.castAutoCompleteTextViewOrThrow(com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.textInputLayout.getEditText());
            if (com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.accessibilityManager.isTouchExplorationEnabled() && com.google.android.material.textfield.DropdownMenuEndIconDelegate.isEditable(castAutoCompleteTextViewOrThrow) && !com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.endIconView.hasFocus()) {
                castAutoCompleteTextViewOrThrow.dismissDropDown();
            }
            castAutoCompleteTextViewOrThrow.post(new com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass1.RunnableC03331(castAutoCompleteTextViewOrThrow));
        }
    }

    /* renamed from: com.google.android.material.textfield.DropdownMenuEndIconDelegate$10, reason: invalid class name */
    public class AnonymousClass10 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass10() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
            com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.endIconView.setAlpha(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.google.android.material.textfield.DropdownMenuEndIconDelegate$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnFocusChangeListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(android.view.View view, boolean z) {
            com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.textInputLayout.setEndIconActivated(z);
            if (z) {
                return;
            }
            com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.setEndIconChecked(false);
            com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.dropdownPopupDirty = false;
        }
    }

    /* renamed from: com.google.android.material.textfield.DropdownMenuEndIconDelegate$3, reason: invalid class name */
    public class AnonymousClass3 extends com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate {
        public AnonymousClass3(com.google.android.material.textfield.TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(android.view.View view, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!com.google.android.material.textfield.DropdownMenuEndIconDelegate.isEditable(com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.textInputLayout.getEditText())) {
                accessibilityNodeInfoCompat.setClassName(android.widget.Spinner.class.getName());
            }
            if (accessibilityNodeInfoCompat.isShowingHintText()) {
                accessibilityNodeInfoCompat.setHintText(null);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(android.view.View view, @androidx.annotation.NonNull android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            android.widget.AutoCompleteTextView castAutoCompleteTextViewOrThrow = com.google.android.material.textfield.DropdownMenuEndIconDelegate.castAutoCompleteTextViewOrThrow(com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.textInputLayout.getEditText());
            if (accessibilityEvent.getEventType() == 1 && com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.accessibilityManager.isTouchExplorationEnabled() && !com.google.android.material.textfield.DropdownMenuEndIconDelegate.isEditable(com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.textInputLayout.getEditText())) {
                com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.showHideDropdown(castAutoCompleteTextViewOrThrow);
            }
        }
    }

    /* renamed from: com.google.android.material.textfield.DropdownMenuEndIconDelegate$4, reason: invalid class name */
    public class AnonymousClass4 implements com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener {
        public AnonymousClass4() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public void onEditTextAttached(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout) {
            android.widget.AutoCompleteTextView castAutoCompleteTextViewOrThrow = com.google.android.material.textfield.DropdownMenuEndIconDelegate.castAutoCompleteTextViewOrThrow(textInputLayout.getEditText());
            com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.setPopupBackground(castAutoCompleteTextViewOrThrow);
            com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.addRippleEffect(castAutoCompleteTextViewOrThrow);
            com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.setUpDropdownShowHideBehavior(castAutoCompleteTextViewOrThrow);
            castAutoCompleteTextViewOrThrow.setThreshold(0);
            castAutoCompleteTextViewOrThrow.removeTextChangedListener(com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
            castAutoCompleteTextViewOrThrow.addTextChangedListener(com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((android.graphics.drawable.Drawable) null);
            if (!com.google.android.material.textfield.DropdownMenuEndIconDelegate.isEditable(castAutoCompleteTextViewOrThrow)) {
                androidx.core.view.ViewCompat.setImportantForAccessibility(com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.endIconView, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.accessibilityDelegate);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* renamed from: com.google.android.material.textfield.DropdownMenuEndIconDelegate$5, reason: invalid class name */
    public class AnonymousClass5 implements com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener {

        /* renamed from: com.google.android.material.textfield.DropdownMenuEndIconDelegate$5$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ android.widget.AutoCompleteTextView val$editText;

            public AnonymousClass1(android.widget.AutoCompleteTextView autoCompleteTextView) {
                this.val$editText = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$editText.removeTextChangedListener(com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
            }
        }

        public AnonymousClass5() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
        public void onEndIconChanged(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout, int i) {
            android.widget.AutoCompleteTextView autoCompleteTextView = (android.widget.AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView == null || i != 3) {
                return;
            }
            autoCompleteTextView.post(new com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass5.AnonymousClass1(autoCompleteTextView));
            if (autoCompleteTextView.getOnFocusChangeListener() == com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.onFocusChangeListener) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            if (com.google.android.material.textfield.DropdownMenuEndIconDelegate.IS_LOLLIPOP) {
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    /* renamed from: com.google.android.material.textfield.DropdownMenuEndIconDelegate$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.showHideDropdown((android.widget.AutoCompleteTextView) com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.textInputLayout.getEditText());
        }
    }

    /* renamed from: com.google.android.material.textfield.DropdownMenuEndIconDelegate$7, reason: invalid class name */
    public class AnonymousClass7 implements android.view.View.OnTouchListener {
        final /* synthetic */ android.widget.AutoCompleteTextView val$editText;

        public AnonymousClass7(android.widget.AutoCompleteTextView autoCompleteTextView) {
            this.val$editText = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.isDropdownPopupActive()) {
                    com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.dropdownPopupDirty = false;
                }
                com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.showHideDropdown(this.val$editText);
            }
            return false;
        }
    }

    /* renamed from: com.google.android.material.textfield.DropdownMenuEndIconDelegate$8, reason: invalid class name */
    public class AnonymousClass8 implements android.widget.AutoCompleteTextView.OnDismissListener {
        public AnonymousClass8() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.dropdownPopupDirty = true;
            com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.dropdownPopupActivatedAt = java.lang.System.currentTimeMillis();
            com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.setEndIconChecked(false);
        }
    }

    /* renamed from: com.google.android.material.textfield.DropdownMenuEndIconDelegate$9, reason: invalid class name */
    public class AnonymousClass9 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass9() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.material.textfield.DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = com.google.android.material.textfield.DropdownMenuEndIconDelegate.this;
            dropdownMenuEndIconDelegate.endIconView.setChecked(dropdownMenuEndIconDelegate.isEndIconChecked);
            com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.fadeInAnim.start();
        }
    }

    public DropdownMenuEndIconDelegate(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.exposedDropdownEndIconTextWatcher = new com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass1();
        this.onFocusChangeListener = new com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass2();
        this.accessibilityDelegate = new com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass3(this.textInputLayout);
        this.dropdownMenuOnEditTextAttachedListener = new com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass4();
        this.endIconChangedListener = new com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass5();
        this.dropdownPopupDirty = false;
        this.isEndIconChecked = false;
        this.dropdownPopupActivatedAt = Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRippleEffect(@androidx.annotation.NonNull android.widget.AutoCompleteTextView autoCompleteTextView) {
        if (isEditable(autoCompleteTextView)) {
            return;
        }
        int boxBackgroundMode = this.textInputLayout.getBoxBackgroundMode();
        com.google.android.material.shape.MaterialShapeDrawable boxBackground = this.textInputLayout.getBoxBackground();
        int color = com.google.android.material.color.MaterialColors.getColor(autoCompleteTextView, com.google.android.material.R.attr.colorControlHighlight);
        int[][] iArr = {new int[]{android.R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            addRippleEffectOnOutlinedLayout(autoCompleteTextView, color, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            addRippleEffectOnFilledLayout(autoCompleteTextView, color, iArr, boxBackground);
        }
    }

    private void addRippleEffectOnFilledLayout(@androidx.annotation.NonNull android.widget.AutoCompleteTextView autoCompleteTextView, int i, int[][] iArr, @androidx.annotation.NonNull com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable) {
        int boxBackgroundColor = this.textInputLayout.getBoxBackgroundColor();
        int[] iArr2 = {com.google.android.material.color.MaterialColors.layer(i, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (IS_LOLLIPOP) {
            androidx.core.view.ViewCompat.setBackground(autoCompleteTextView, new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(iArr, iArr2), materialShapeDrawable, materialShapeDrawable));
            return;
        }
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable2 = new com.google.android.material.shape.MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        materialShapeDrawable2.setFillColor(new android.content.res.ColorStateList(iArr, iArr2));
        android.graphics.drawable.LayerDrawable layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{materialShapeDrawable, materialShapeDrawable2});
        int paddingStart = androidx.core.view.ViewCompat.getPaddingStart(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int paddingEnd = androidx.core.view.ViewCompat.getPaddingEnd(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        androidx.core.view.ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
        androidx.core.view.ViewCompat.setPaddingRelative(autoCompleteTextView, paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    private void addRippleEffectOnOutlinedLayout(@androidx.annotation.NonNull android.widget.AutoCompleteTextView autoCompleteTextView, int i, int[][] iArr, @androidx.annotation.NonNull com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable) {
        android.graphics.drawable.LayerDrawable layerDrawable;
        int color = com.google.android.material.color.MaterialColors.getColor(autoCompleteTextView, com.google.android.material.R.attr.colorSurface);
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable2 = new com.google.android.material.shape.MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        int layer = com.google.android.material.color.MaterialColors.layer(i, color, 0.1f);
        materialShapeDrawable2.setFillColor(new android.content.res.ColorStateList(iArr, new int[]{layer, 0}));
        if (IS_LOLLIPOP) {
            materialShapeDrawable2.setTint(color);
            android.content.res.ColorStateList colorStateList = new android.content.res.ColorStateList(iArr, new int[]{layer, color});
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable3 = new com.google.android.material.shape.MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
            materialShapeDrawable3.setTint(-1);
            layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{new android.graphics.drawable.RippleDrawable(colorStateList, materialShapeDrawable2, materialShapeDrawable3), materialShapeDrawable});
        } else {
            layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{materialShapeDrawable2, materialShapeDrawable});
        }
        androidx.core.view.ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.NonNull
    public static android.widget.AutoCompleteTextView castAutoCompleteTextViewOrThrow(android.widget.EditText editText) {
        if (editText instanceof android.widget.AutoCompleteTextView) {
            return (android.widget.AutoCompleteTextView) editText;
        }
        throw new java.lang.RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private android.animation.ValueAnimator getAlphaAnimator(int i, float... fArr) {
        android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(i);
        ofFloat.addUpdateListener(new com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass10());
        return ofFloat;
    }

    private com.google.android.material.shape.MaterialShapeDrawable getPopUpMaterialShapeDrawable(float f, float f2, float f3, int i) {
        com.google.android.material.shape.ShapeAppearanceModel build = com.google.android.material.shape.ShapeAppearanceModel.builder().setTopLeftCornerSize(f).setTopRightCornerSize(f).setBottomLeftCornerSize(f2).setBottomRightCornerSize(f2).build();
        com.google.android.material.shape.MaterialShapeDrawable createWithElevationOverlay = com.google.android.material.shape.MaterialShapeDrawable.createWithElevationOverlay(this.context, f3);
        createWithElevationOverlay.setShapeAppearanceModel(build);
        createWithElevationOverlay.setPadding(0, i, 0, i);
        return createWithElevationOverlay;
    }

    private void initAnimators() {
        this.fadeInAnim = getAlphaAnimator(67, 0.0f, 1.0f);
        android.animation.ValueAnimator alphaAnimator = getAlphaAnimator(50, 1.0f, 0.0f);
        this.fadeOutAnim = alphaAnimator;
        alphaAnimator.addListener(new com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDropdownPopupActive() {
        long currentTimeMillis = java.lang.System.currentTimeMillis() - this.dropdownPopupActivatedAt;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEditable(@androidx.annotation.NonNull android.widget.EditText editText) {
        return editText.getKeyListener() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndIconChecked(boolean z) {
        if (this.isEndIconChecked != z) {
            this.isEndIconChecked = z;
            this.fadeInAnim.cancel();
            this.fadeOutAnim.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPopupBackground(@androidx.annotation.NonNull android.widget.AutoCompleteTextView autoCompleteTextView) {
        if (IS_LOLLIPOP) {
            int boxBackgroundMode = this.textInputLayout.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.outlinedPopupBackground);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.filledPopupBackground);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    public void setUpDropdownShowHideBehavior(@androidx.annotation.NonNull android.widget.AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass7(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.onFocusChangeListener);
        if (IS_LOLLIPOP) {
            autoCompleteTextView.setOnDismissListener(new com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass8());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHideDropdown(@androidx.annotation.Nullable android.widget.AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (isDropdownPopupActive()) {
            this.dropdownPopupDirty = false;
        }
        if (this.dropdownPopupDirty) {
            this.dropdownPopupDirty = false;
            return;
        }
        if (IS_LOLLIPOP) {
            setEndIconChecked(!this.isEndIconChecked);
        } else {
            this.isEndIconChecked = !this.isEndIconChecked;
            this.endIconView.toggle();
        }
        if (!this.isEndIconChecked) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        float dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.context.getResources().getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        com.google.android.material.shape.MaterialShapeDrawable popUpMaterialShapeDrawable = getPopUpMaterialShapeDrawable(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        com.google.android.material.shape.MaterialShapeDrawable popUpMaterialShapeDrawable2 = getPopUpMaterialShapeDrawable(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.outlinedPopupBackground = popUpMaterialShapeDrawable;
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        this.filledPopupBackground = stateListDrawable;
        stateListDrawable.addState(new int[]{android.R.attr.state_above_anchor}, popUpMaterialShapeDrawable);
        this.filledPopupBackground.addState(new int[0], popUpMaterialShapeDrawable2);
        this.textInputLayout.setEndIconDrawable(androidx.appcompat.content.res.AppCompatResources.getDrawable(this.context, IS_LOLLIPOP ? com.google.android.material.R.drawable.mtrl_dropdown_arrow : com.google.android.material.R.drawable.mtrl_ic_arrow_drop_down));
        com.google.android.material.textfield.TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(com.google.android.material.R.string.exposed_dropdown_menu_content_description));
        this.textInputLayout.setEndIconOnClickListener(new com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass6());
        this.textInputLayout.addOnEditTextAttachedListener(this.dropdownMenuOnEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
        initAnimators();
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) this.context.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean isBoxBackgroundModeSupported(int i) {
        return i != 0;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean shouldTintIconOnError() {
        return true;
    }
}
