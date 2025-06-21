package com.google.android.material.textfield;

/* loaded from: classes22.dex */
public class TextInputLayout extends android.widget.LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_Design_TextInputLayout;
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final java.lang.String LOG_TAG = "TextInputLayout";
    private static final int NO_WIDTH = -1;
    private android.animation.ValueAnimator animator;

    @androidx.annotation.Nullable
    private com.google.android.material.shape.MaterialShapeDrawable boxBackground;

    @androidx.annotation.ColorInt
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private int boxCollapsedPaddingTopPx;
    private int boxLabelCutoutHeight;
    private final int boxLabelCutoutPaddingPx;

    @androidx.annotation.ColorInt
    private int boxStrokeColor;
    private int boxStrokeWidthDefaultPx;
    private int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;

    @androidx.annotation.Nullable
    private com.google.android.material.shape.MaterialShapeDrawable boxUnderline;
    final com.google.android.material.internal.CollapsingTextHelper collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList counterTextColor;

    @androidx.annotation.Nullable
    private android.widget.TextView counterView;

    @androidx.annotation.ColorInt
    private int defaultFilledBackgroundColor;
    private android.content.res.ColorStateList defaultHintTextColor;

    @androidx.annotation.ColorInt
    private int defaultStrokeColor;

    @androidx.annotation.ColorInt
    private int disabledColor;

    @androidx.annotation.ColorInt
    private int disabledFilledBackgroundColor;
    android.widget.EditText editText;
    private final java.util.LinkedHashSet<com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener> editTextAttachedListeners;

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable endDummyDrawable;
    private int endDummyDrawableWidth;
    private final java.util.LinkedHashSet<com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener> endIconChangedListeners;
    private final android.util.SparseArray<com.google.android.material.textfield.EndIconDelegate> endIconDelegates;

    @androidx.annotation.NonNull
    private final android.widget.FrameLayout endIconFrame;
    private int endIconMode;
    private android.view.View.OnLongClickListener endIconOnLongClickListener;
    private android.content.res.ColorStateList endIconTintList;
    private android.graphics.PorterDuff.Mode endIconTintMode;

    @androidx.annotation.NonNull
    private final com.google.android.material.internal.CheckableImageButton endIconView;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout endLayout;
    private android.view.View.OnLongClickListener errorIconOnLongClickListener;
    private android.content.res.ColorStateList errorIconTintList;

    @androidx.annotation.NonNull
    private final com.google.android.material.internal.CheckableImageButton errorIconView;
    private boolean expandedHintEnabled;

    @androidx.annotation.ColorInt
    private int focusedFilledBackgroundColor;

    @androidx.annotation.ColorInt
    private int focusedStrokeColor;
    private android.content.res.ColorStateList focusedTextColor;
    private boolean hasEndIconTintList;
    private boolean hasEndIconTintMode;
    private boolean hasStartIconTintList;
    private boolean hasStartIconTintMode;
    private java.lang.CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;

    @androidx.annotation.ColorInt
    private int hoveredFilledBackgroundColor;

    @androidx.annotation.ColorInt
    private int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final com.google.android.material.textfield.IndicatorViewController indicatorViewController;

    @androidx.annotation.NonNull
    private final android.widget.FrameLayout inputFrame;
    private boolean isProvidingHint;
    private int maxWidth;
    private int minWidth;
    private android.graphics.drawable.Drawable originalEditTextEndDrawable;
    private java.lang.CharSequence originalHint;
    private boolean placeholderEnabled;
    private java.lang.CharSequence placeholderText;
    private int placeholderTextAppearance;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList placeholderTextColor;
    private android.widget.TextView placeholderTextView;

    @androidx.annotation.Nullable
    private java.lang.CharSequence prefixText;

    @androidx.annotation.NonNull
    private final android.widget.TextView prefixTextView;
    private boolean restoringSavedState;

    @androidx.annotation.NonNull
    private com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel;

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable startDummyDrawable;
    private int startDummyDrawableWidth;
    private android.view.View.OnLongClickListener startIconOnLongClickListener;
    private android.content.res.ColorStateList startIconTintList;
    private android.graphics.PorterDuff.Mode startIconTintMode;

    @androidx.annotation.NonNull
    private final com.google.android.material.internal.CheckableImageButton startIconView;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout startLayout;
    private android.content.res.ColorStateList strokeErrorColor;

    @androidx.annotation.Nullable
    private java.lang.CharSequence suffixText;

    @androidx.annotation.NonNull
    private final android.widget.TextView suffixTextView;
    private final android.graphics.Rect tmpBoundsRect;
    private final android.graphics.Rect tmpRect;
    private final android.graphics.RectF tmpRectF;
    private android.graphics.Typeface typeface;

    /* renamed from: com.google.android.material.textfield.TextInputLayout$1, reason: invalid class name */
    public class AnonymousClass1 implements android.text.TextWatcher {
        public AnonymousClass1() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@androidx.annotation.NonNull android.text.Editable editable) {
            com.google.android.material.textfield.TextInputLayout.this.updateLabelState(!r0.restoringSavedState);
            com.google.android.material.textfield.TextInputLayout textInputLayout = com.google.android.material.textfield.TextInputLayout.this;
            if (textInputLayout.counterEnabled) {
                textInputLayout.updateCounter(editable.length());
            }
            if (com.google.android.material.textfield.TextInputLayout.this.placeholderEnabled) {
                com.google.android.material.textfield.TextInputLayout.this.updatePlaceholderText(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.material.textfield.TextInputLayout.this.endIconView.performClick();
            com.google.android.material.textfield.TextInputLayout.this.endIconView.jumpDrawablesToCurrentState();
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.material.textfield.TextInputLayout.this.editText.requestLayout();
        }
    }

    /* renamed from: com.google.android.material.textfield.TextInputLayout$4, reason: invalid class name */
    public class AnonymousClass4 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass4() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
            com.google.android.material.textfield.TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class AccessibilityDelegate extends androidx.core.view.AccessibilityDelegateCompat {
        private final com.google.android.material.textfield.TextInputLayout layout;

        public AccessibilityDelegate(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout) {
            this.layout = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            android.widget.EditText editText = this.layout.getEditText();
            java.lang.CharSequence text = editText != null ? editText.getText() : null;
            java.lang.CharSequence hint = this.layout.getHint();
            java.lang.CharSequence error = this.layout.getError();
            java.lang.CharSequence placeholderText = this.layout.getPlaceholderText();
            int counterMaxLength = this.layout.getCounterMaxLength();
            java.lang.CharSequence counterOverflowDescription = this.layout.getCounterOverflowDescription();
            boolean z = !android.text.TextUtils.isEmpty(text);
            boolean z2 = !android.text.TextUtils.isEmpty(hint);
            boolean z3 = !this.layout.isHintExpanded();
            boolean z4 = !android.text.TextUtils.isEmpty(error);
            boolean z5 = z4 || !android.text.TextUtils.isEmpty(counterOverflowDescription);
            java.lang.String charSequence = z2 ? hint.toString() : "";
            if (z) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (!android.text.TextUtils.isEmpty(charSequence)) {
                accessibilityNodeInfoCompat.setText(charSequence);
                if (z3 && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(charSequence + ", " + ((java.lang.Object) placeholderText));
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!android.text.TextUtils.isEmpty(charSequence)) {
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(charSequence);
                } else {
                    if (z) {
                        charSequence = ((java.lang.Object) text) + ", " + charSequence;
                    }
                    accessibilityNodeInfoCompat.setText(charSequence);
                }
                accessibilityNodeInfoCompat.setShowingHintText(!z);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
            if (z5) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
            if (editText != null) {
                editText.setLabelFor(com.google.android.material.R.id.textinput_helper_text);
            }
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface EndIconMode {
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout, int i);
    }

    public static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<com.google.android.material.textfield.TextInputLayout.SavedState> CREATOR = new com.google.android.material.textfield.TextInputLayout.SavedState.AnonymousClass1();

        @androidx.annotation.Nullable
        java.lang.CharSequence error;

        @androidx.annotation.Nullable
        java.lang.CharSequence helperText;

        @androidx.annotation.Nullable
        java.lang.CharSequence hintText;
        boolean isEndIconChecked;

        @androidx.annotation.Nullable
        java.lang.CharSequence placeholderText;

        /* renamed from: com.google.android.material.textfield.TextInputLayout$SavedState$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.ClassLoaderCreator<com.google.android.material.textfield.TextInputLayout.SavedState> {
            @Override // android.os.Parcelable.Creator
            @androidx.annotation.Nullable
            public com.google.android.material.textfield.TextInputLayout.SavedState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
                return new com.google.android.material.textfield.TextInputLayout.SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @androidx.annotation.NonNull
            public com.google.android.material.textfield.TextInputLayout.SavedState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new com.google.android.material.textfield.TextInputLayout.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @androidx.annotation.NonNull
            public com.google.android.material.textfield.TextInputLayout.SavedState[] newArray(int i) {
                return new com.google.android.material.textfield.TextInputLayout.SavedState[i];
            }
        }

        public SavedState(@androidx.annotation.NonNull android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (java.lang.CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isEndIconChecked = parcel.readInt() == 1;
            this.hintText = (java.lang.CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.helperText = (java.lang.CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.placeholderText = (java.lang.CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @androidx.annotation.NonNull
        public java.lang.String toString() {
            return "TextInputLayout.SavedState{" + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + " error=" + ((java.lang.Object) this.error) + " hint=" + ((java.lang.Object) this.hintText) + " helperText=" + ((java.lang.Object) this.helperText) + " placeholderText=" + ((java.lang.Object) this.placeholderText) + com.alipay.sdk.m.u.i.d;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            android.text.TextUtils.writeToParcel(this.error, parcel, i);
            parcel.writeInt(this.isEndIconChecked ? 1 : 0);
            android.text.TextUtils.writeToParcel(this.hintText, parcel, i);
            android.text.TextUtils.writeToParcel(this.helperText, parcel, i);
            android.text.TextUtils.writeToParcel(this.placeholderText, parcel, i);
        }
    }

    public TextInputLayout(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public TextInputLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.textInputStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v150 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextInputLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i, r9), attributeSet, i);
        int i2;
        ?? r2;
        int i3 = DEF_STYLE_RES;
        this.minWidth = -1;
        this.maxWidth = -1;
        this.indicatorViewController = new com.google.android.material.textfield.IndicatorViewController(this);
        this.tmpRect = new android.graphics.Rect();
        this.tmpBoundsRect = new android.graphics.Rect();
        this.tmpRectF = new android.graphics.RectF();
        this.editTextAttachedListeners = new java.util.LinkedHashSet<>();
        this.endIconMode = 0;
        android.util.SparseArray<com.google.android.material.textfield.EndIconDelegate> sparseArray = new android.util.SparseArray<>();
        this.endIconDelegates = sparseArray;
        this.endIconChangedListeners = new java.util.LinkedHashSet<>();
        com.google.android.material.internal.CollapsingTextHelper collapsingTextHelper = new com.google.android.material.internal.CollapsingTextHelper(this);
        this.collapsingTextHelper = collapsingTextHelper;
        android.content.Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(context2);
        this.inputFrame = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(frameLayout);
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context2);
        this.startLayout = linearLayout;
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -1, androidx.core.view.GravityCompat.START));
        frameLayout.addView(linearLayout);
        android.widget.LinearLayout linearLayout2 = new android.widget.LinearLayout(context2);
        this.endLayout = linearLayout2;
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -1, androidx.core.view.GravityCompat.END));
        frameLayout.addView(linearLayout2);
        android.widget.FrameLayout frameLayout2 = new android.widget.FrameLayout(context2);
        this.endIconFrame = frameLayout2;
        frameLayout2.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -1));
        android.animation.TimeInterpolator timeInterpolator = com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR;
        collapsingTextHelper.setTextSizeInterpolator(timeInterpolator);
        collapsingTextHelper.setPositionInterpolator(timeInterpolator);
        collapsingTextHelper.setCollapsedTextGravity(com.google.android.material.badge.BadgeDrawable.TOP_START);
        int[] iArr = com.google.android.material.R.styleable.TextInputLayout;
        int i4 = com.google.android.material.R.styleable.TextInputLayout_counterTextAppearance;
        int i5 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextAppearance;
        int i6 = com.google.android.material.R.styleable.TextInputLayout_errorTextAppearance;
        int i7 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextAppearance;
        int i8 = com.google.android.material.R.styleable.TextInputLayout_hintTextAppearance;
        androidx.appcompat.widget.TintTypedArray obtainTintedStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, iArr, i, i3, i4, i5, i6, i7, i8);
        this.hintEnabled = obtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.TextInputLayout_hintEnabled, true);
        setHint(obtainTintedStyledAttributes.getText(com.google.android.material.R.styleable.TextInputLayout_android_hint));
        this.hintAnimationEnabled = obtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.expandedHintEnabled = obtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.TextInputLayout_expandedHintEnabled, true);
        int i9 = com.google.android.material.R.styleable.TextInputLayout_android_minWidth;
        if (obtainTintedStyledAttributes.hasValue(i9)) {
            i2 = -1;
            setMinWidth(obtainTintedStyledAttributes.getDimensionPixelSize(i9, -1));
        } else {
            i2 = -1;
        }
        int i10 = com.google.android.material.R.styleable.TextInputLayout_android_maxWidth;
        if (obtainTintedStyledAttributes.hasValue(i10)) {
            setMaxWidth(obtainTintedStyledAttributes.getDimensionPixelSize(i10, i2));
        }
        this.shapeAppearanceModel = com.google.android.material.shape.ShapeAppearanceModel.builder(context2, attributeSet, i, i3).build();
        this.boxLabelCutoutPaddingPx = context2.getResources().getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = obtainTintedStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.boxStrokeWidthDefaultPx = obtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_textinput_box_stroke_width_default));
        this.boxStrokeWidthFocusedPx = obtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float dimension = obtainTintedStyledAttributes.getDimension(com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float dimension2 = obtainTintedStyledAttributes.getDimension(com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float dimension3 = obtainTintedStyledAttributes.getDimension(com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float dimension4 = obtainTintedStyledAttributes.getDimension(com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        com.google.android.material.shape.ShapeAppearanceModel.Builder builder = this.shapeAppearanceModel.toBuilder();
        if (dimension >= 0.0f) {
            builder.setTopLeftCornerSize(dimension);
        }
        if (dimension2 >= 0.0f) {
            builder.setTopRightCornerSize(dimension2);
        }
        if (dimension3 >= 0.0f) {
            builder.setBottomRightCornerSize(dimension3);
        }
        if (dimension4 >= 0.0f) {
            builder.setBottomLeftCornerSize(dimension4);
        }
        this.shapeAppearanceModel = builder.build();
        android.content.res.ColorStateList colorStateList = com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, com.google.android.material.R.styleable.TextInputLayout_boxBackgroundColor);
        if (colorStateList != null) {
            int defaultColor = colorStateList.getDefaultColor();
            this.defaultFilledBackgroundColor = defaultColor;
            this.boxBackgroundColor = defaultColor;
            if (colorStateList.isStateful()) {
                this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
                this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            } else {
                this.focusedFilledBackgroundColor = this.defaultFilledBackgroundColor;
                android.content.res.ColorStateList colorStateList2 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(context2, com.google.android.material.R.color.mtrl_filled_background_color);
                this.disabledFilledBackgroundColor = colorStateList2.getColorForState(new int[]{-16842910}, -1);
                this.hoveredFilledBackgroundColor = colorStateList2.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
            }
        } else {
            this.boxBackgroundColor = 0;
            this.defaultFilledBackgroundColor = 0;
            this.disabledFilledBackgroundColor = 0;
            this.focusedFilledBackgroundColor = 0;
            this.hoveredFilledBackgroundColor = 0;
        }
        int i11 = com.google.android.material.R.styleable.TextInputLayout_android_textColorHint;
        if (obtainTintedStyledAttributes.hasValue(i11)) {
            android.content.res.ColorStateList colorStateList3 = obtainTintedStyledAttributes.getColorStateList(i11);
            this.focusedTextColor = colorStateList3;
            this.defaultHintTextColor = colorStateList3;
        }
        int i12 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeColor;
        android.content.res.ColorStateList colorStateList4 = com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, i12);
        this.focusedStrokeColor = obtainTintedStyledAttributes.getColor(i12, 0);
        this.defaultStrokeColor = androidx.core.content.ContextCompat.getColor(context2, com.google.android.material.R.color.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = androidx.core.content.ContextCompat.getColor(context2, com.google.android.material.R.color.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = androidx.core.content.ContextCompat.getColor(context2, com.google.android.material.R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateList4 != null) {
            setBoxStrokeColorStateList(colorStateList4);
        }
        int i13 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeErrorColor;
        if (obtainTintedStyledAttributes.hasValue(i13)) {
            setBoxStrokeErrorColor(com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, i13));
        }
        if (obtainTintedStyledAttributes.getResourceId(i8, -1) != -1) {
            r2 = 0;
            setHintTextAppearance(obtainTintedStyledAttributes.getResourceId(i8, 0));
        } else {
            r2 = 0;
        }
        int resourceId = obtainTintedStyledAttributes.getResourceId(i6, r2);
        java.lang.CharSequence text = obtainTintedStyledAttributes.getText(com.google.android.material.R.styleable.TextInputLayout_errorContentDescription);
        boolean z = obtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.TextInputLayout_errorEnabled, r2);
        android.view.LayoutInflater from = android.view.LayoutInflater.from(getContext());
        int i14 = com.google.android.material.R.layout.design_text_input_end_icon;
        com.google.android.material.internal.CheckableImageButton checkableImageButton = (com.google.android.material.internal.CheckableImageButton) from.inflate(i14, linearLayout2, (boolean) r2);
        this.errorIconView = checkableImageButton;
        checkableImageButton.setId(com.google.android.material.R.id.text_input_error_icon);
        checkableImageButton.setVisibility(8);
        if (com.google.android.material.resources.MaterialResources.isFontScaleAtLeast1_3(context2)) {
            androidx.core.view.MarginLayoutParamsCompat.setMarginStart((android.view.ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), r2);
        }
        int i15 = com.google.android.material.R.styleable.TextInputLayout_errorIconDrawable;
        if (obtainTintedStyledAttributes.hasValue(i15)) {
            setErrorIconDrawable(obtainTintedStyledAttributes.getDrawable(i15));
        }
        int i16 = com.google.android.material.R.styleable.TextInputLayout_errorIconTint;
        if (obtainTintedStyledAttributes.hasValue(i16)) {
            setErrorIconTintList(com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, i16));
        }
        int i17 = com.google.android.material.R.styleable.TextInputLayout_errorIconTintMode;
        if (obtainTintedStyledAttributes.hasValue(i17)) {
            setErrorIconTintMode(com.google.android.material.internal.ViewUtils.parseTintMode(obtainTintedStyledAttributes.getInt(i17, -1), null));
        }
        checkableImageButton.setContentDescription(getResources().getText(com.google.android.material.R.string.error_icon_content_description));
        androidx.core.view.ViewCompat.setImportantForAccessibility(checkableImageButton, 2);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int resourceId2 = obtainTintedStyledAttributes.getResourceId(i7, 0);
        boolean z2 = obtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.TextInputLayout_helperTextEnabled, false);
        java.lang.CharSequence text2 = obtainTintedStyledAttributes.getText(com.google.android.material.R.styleable.TextInputLayout_helperText);
        int resourceId3 = obtainTintedStyledAttributes.getResourceId(com.google.android.material.R.styleable.TextInputLayout_placeholderTextAppearance, 0);
        java.lang.CharSequence text3 = obtainTintedStyledAttributes.getText(com.google.android.material.R.styleable.TextInputLayout_placeholderText);
        int resourceId4 = obtainTintedStyledAttributes.getResourceId(com.google.android.material.R.styleable.TextInputLayout_prefixTextAppearance, 0);
        java.lang.CharSequence text4 = obtainTintedStyledAttributes.getText(com.google.android.material.R.styleable.TextInputLayout_prefixText);
        int resourceId5 = obtainTintedStyledAttributes.getResourceId(com.google.android.material.R.styleable.TextInputLayout_suffixTextAppearance, 0);
        java.lang.CharSequence text5 = obtainTintedStyledAttributes.getText(com.google.android.material.R.styleable.TextInputLayout_suffixText);
        boolean z3 = obtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(obtainTintedStyledAttributes.getInt(com.google.android.material.R.styleable.TextInputLayout_counterMaxLength, -1));
        this.counterTextAppearance = obtainTintedStyledAttributes.getResourceId(i4, 0);
        this.counterOverflowTextAppearance = obtainTintedStyledAttributes.getResourceId(i5, 0);
        com.google.android.material.internal.CheckableImageButton checkableImageButton2 = (com.google.android.material.internal.CheckableImageButton) android.view.LayoutInflater.from(getContext()).inflate(com.google.android.material.R.layout.design_text_input_start_icon, (android.view.ViewGroup) linearLayout, false);
        this.startIconView = checkableImageButton2;
        checkableImageButton2.setVisibility(8);
        if (com.google.android.material.resources.MaterialResources.isFontScaleAtLeast1_3(context2)) {
            androidx.core.view.MarginLayoutParamsCompat.setMarginEnd((android.view.ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams(), 0);
        }
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        int i18 = com.google.android.material.R.styleable.TextInputLayout_startIconDrawable;
        if (obtainTintedStyledAttributes.hasValue(i18)) {
            setStartIconDrawable(obtainTintedStyledAttributes.getDrawable(i18));
            int i19 = com.google.android.material.R.styleable.TextInputLayout_startIconContentDescription;
            if (obtainTintedStyledAttributes.hasValue(i19)) {
                setStartIconContentDescription(obtainTintedStyledAttributes.getText(i19));
            }
            setStartIconCheckable(obtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.TextInputLayout_startIconCheckable, true));
        }
        int i20 = com.google.android.material.R.styleable.TextInputLayout_startIconTint;
        if (obtainTintedStyledAttributes.hasValue(i20)) {
            setStartIconTintList(com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, i20));
        }
        int i21 = com.google.android.material.R.styleable.TextInputLayout_startIconTintMode;
        if (obtainTintedStyledAttributes.hasValue(i21)) {
            setStartIconTintMode(com.google.android.material.internal.ViewUtils.parseTintMode(obtainTintedStyledAttributes.getInt(i21, -1), null));
        }
        setBoxBackgroundMode(obtainTintedStyledAttributes.getInt(com.google.android.material.R.styleable.TextInputLayout_boxBackgroundMode, 0));
        com.google.android.material.internal.CheckableImageButton checkableImageButton3 = (com.google.android.material.internal.CheckableImageButton) android.view.LayoutInflater.from(getContext()).inflate(i14, (android.view.ViewGroup) frameLayout2, false);
        this.endIconView = checkableImageButton3;
        frameLayout2.addView(checkableImageButton3);
        checkableImageButton3.setVisibility(8);
        if (com.google.android.material.resources.MaterialResources.isFontScaleAtLeast1_3(context2)) {
            androidx.core.view.MarginLayoutParamsCompat.setMarginStart((android.view.ViewGroup.MarginLayoutParams) checkableImageButton3.getLayoutParams(), 0);
        }
        sparseArray.append(-1, new com.google.android.material.textfield.CustomEndIconDelegate(this));
        sparseArray.append(0, new com.google.android.material.textfield.NoEndIconDelegate(this));
        sparseArray.append(1, new com.google.android.material.textfield.PasswordToggleEndIconDelegate(this));
        sparseArray.append(2, new com.google.android.material.textfield.ClearTextEndIconDelegate(this));
        sparseArray.append(3, new com.google.android.material.textfield.DropdownMenuEndIconDelegate(this));
        int i22 = com.google.android.material.R.styleable.TextInputLayout_endIconMode;
        if (obtainTintedStyledAttributes.hasValue(i22)) {
            setEndIconMode(obtainTintedStyledAttributes.getInt(i22, 0));
            int i23 = com.google.android.material.R.styleable.TextInputLayout_endIconDrawable;
            if (obtainTintedStyledAttributes.hasValue(i23)) {
                setEndIconDrawable(obtainTintedStyledAttributes.getDrawable(i23));
            }
            int i24 = com.google.android.material.R.styleable.TextInputLayout_endIconContentDescription;
            if (obtainTintedStyledAttributes.hasValue(i24)) {
                setEndIconContentDescription(obtainTintedStyledAttributes.getText(i24));
            }
            setEndIconCheckable(obtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.TextInputLayout_endIconCheckable, true));
        } else {
            int i25 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleEnabled;
            if (obtainTintedStyledAttributes.hasValue(i25)) {
                setEndIconMode(obtainTintedStyledAttributes.getBoolean(i25, false) ? 1 : 0);
                setEndIconDrawable(obtainTintedStyledAttributes.getDrawable(com.google.android.material.R.styleable.TextInputLayout_passwordToggleDrawable));
                setEndIconContentDescription(obtainTintedStyledAttributes.getText(com.google.android.material.R.styleable.TextInputLayout_passwordToggleContentDescription));
                int i26 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleTint;
                if (obtainTintedStyledAttributes.hasValue(i26)) {
                    setEndIconTintList(com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, i26));
                }
                int i27 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleTintMode;
                if (obtainTintedStyledAttributes.hasValue(i27)) {
                    setEndIconTintMode(com.google.android.material.internal.ViewUtils.parseTintMode(obtainTintedStyledAttributes.getInt(i27, -1), null));
                }
            }
        }
        if (!obtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.TextInputLayout_passwordToggleEnabled)) {
            int i28 = com.google.android.material.R.styleable.TextInputLayout_endIconTint;
            if (obtainTintedStyledAttributes.hasValue(i28)) {
                setEndIconTintList(com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, i28));
            }
            int i29 = com.google.android.material.R.styleable.TextInputLayout_endIconTintMode;
            if (obtainTintedStyledAttributes.hasValue(i29)) {
                setEndIconTintMode(com.google.android.material.internal.ViewUtils.parseTintMode(obtainTintedStyledAttributes.getInt(i29, -1), null));
            }
        }
        androidx.appcompat.widget.AppCompatTextView appCompatTextView = new androidx.appcompat.widget.AppCompatTextView(context2);
        this.prefixTextView = appCompatTextView;
        appCompatTextView.setId(com.google.android.material.R.id.textinput_prefix_text);
        appCompatTextView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
        androidx.core.view.ViewCompat.setAccessibilityLiveRegion(appCompatTextView, 1);
        linearLayout.addView(checkableImageButton2);
        linearLayout.addView(appCompatTextView);
        androidx.appcompat.widget.AppCompatTextView appCompatTextView2 = new androidx.appcompat.widget.AppCompatTextView(context2);
        this.suffixTextView = appCompatTextView2;
        appCompatTextView2.setId(com.google.android.material.R.id.textinput_suffix_text);
        appCompatTextView2.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2, 80));
        androidx.core.view.ViewCompat.setAccessibilityLiveRegion(appCompatTextView2, 1);
        linearLayout2.addView(appCompatTextView2);
        linearLayout2.addView(checkableImageButton);
        linearLayout2.addView(frameLayout2);
        setHelperTextEnabled(z2);
        setHelperText(text2);
        setHelperTextTextAppearance(resourceId2);
        setErrorEnabled(z);
        setErrorTextAppearance(resourceId);
        setErrorContentDescription(text);
        setCounterTextAppearance(this.counterTextAppearance);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        setPrefixText(text4);
        setPrefixTextAppearance(resourceId4);
        setSuffixText(text5);
        setSuffixTextAppearance(resourceId5);
        int i30 = com.google.android.material.R.styleable.TextInputLayout_errorTextColor;
        if (obtainTintedStyledAttributes.hasValue(i30)) {
            setErrorTextColor(obtainTintedStyledAttributes.getColorStateList(i30));
        }
        int i31 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextColor;
        if (obtainTintedStyledAttributes.hasValue(i31)) {
            setHelperTextColor(obtainTintedStyledAttributes.getColorStateList(i31));
        }
        int i32 = com.google.android.material.R.styleable.TextInputLayout_hintTextColor;
        if (obtainTintedStyledAttributes.hasValue(i32)) {
            setHintTextColor(obtainTintedStyledAttributes.getColorStateList(i32));
        }
        int i33 = com.google.android.material.R.styleable.TextInputLayout_counterTextColor;
        if (obtainTintedStyledAttributes.hasValue(i33)) {
            setCounterTextColor(obtainTintedStyledAttributes.getColorStateList(i33));
        }
        int i34 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextColor;
        if (obtainTintedStyledAttributes.hasValue(i34)) {
            setCounterOverflowTextColor(obtainTintedStyledAttributes.getColorStateList(i34));
        }
        int i35 = com.google.android.material.R.styleable.TextInputLayout_placeholderTextColor;
        if (obtainTintedStyledAttributes.hasValue(i35)) {
            setPlaceholderTextColor(obtainTintedStyledAttributes.getColorStateList(i35));
        }
        int i36 = com.google.android.material.R.styleable.TextInputLayout_prefixTextColor;
        if (obtainTintedStyledAttributes.hasValue(i36)) {
            setPrefixTextColor(obtainTintedStyledAttributes.getColorStateList(i36));
        }
        int i37 = com.google.android.material.R.styleable.TextInputLayout_suffixTextColor;
        if (obtainTintedStyledAttributes.hasValue(i37)) {
            setSuffixTextColor(obtainTintedStyledAttributes.getColorStateList(i37));
        }
        setCounterEnabled(z3);
        setEnabled(obtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.TextInputLayout_android_enabled, true));
        obtainTintedStyledAttributes.recycle();
        androidx.core.view.ViewCompat.setImportantForAccessibility(this, 2);
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            androidx.core.view.ViewCompat.setImportantForAutofill(this, 1);
        }
    }

    private void addPlaceholderTextView() {
        android.widget.TextView textView = this.placeholderTextView;
        if (textView != null) {
            this.inputFrame.addView(textView);
            this.placeholderTextView.setVisibility(0);
        }
    }

    private void adjustFilledEditTextPaddingForLargeFont() {
        if (this.editText == null || this.boxBackgroundMode != 1) {
            return;
        }
        if (com.google.android.material.resources.MaterialResources.isFontScaleAtLeast2_0(getContext())) {
            android.widget.EditText editText = this.editText;
            androidx.core.view.ViewCompat.setPaddingRelative(editText, androidx.core.view.ViewCompat.getPaddingStart(editText), getResources().getDimensionPixelSize(com.google.android.material.R.dimen.material_filled_edittext_font_2_0_padding_top), androidx.core.view.ViewCompat.getPaddingEnd(this.editText), getResources().getDimensionPixelSize(com.google.android.material.R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (com.google.android.material.resources.MaterialResources.isFontScaleAtLeast1_3(getContext())) {
            android.widget.EditText editText2 = this.editText;
            androidx.core.view.ViewCompat.setPaddingRelative(editText2, androidx.core.view.ViewCompat.getPaddingStart(editText2), getResources().getDimensionPixelSize(com.google.android.material.R.dimen.material_filled_edittext_font_1_3_padding_top), androidx.core.view.ViewCompat.getPaddingEnd(this.editText), getResources().getDimensionPixelSize(com.google.android.material.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    private void applyBoxAttributes() {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable == null) {
            return;
        }
        materialShapeDrawable.setShapeAppearanceModel(this.shapeAppearanceModel);
        if (canDrawOutlineStroke()) {
            this.boxBackground.setStroke(this.boxStrokeWidthPx, this.boxStrokeColor);
        }
        int calculateBoxBackgroundColor = calculateBoxBackgroundColor();
        this.boxBackgroundColor = calculateBoxBackgroundColor;
        this.boxBackground.setFillColor(android.content.res.ColorStateList.valueOf(calculateBoxBackgroundColor));
        if (this.endIconMode == 3) {
            this.editText.getBackground().invalidateSelf();
        }
        applyBoxUnderlineAttributes();
        invalidate();
    }

    private void applyBoxUnderlineAttributes() {
        if (this.boxUnderline == null) {
            return;
        }
        if (canDrawStroke()) {
            this.boxUnderline.setFillColor(android.content.res.ColorStateList.valueOf(this.boxStrokeColor));
        }
        invalidate();
    }

    private void applyCutoutPadding(@androidx.annotation.NonNull android.graphics.RectF rectF) {
        float f = rectF.left;
        int i = this.boxLabelCutoutPaddingPx;
        rectF.left = f - i;
        rectF.right += i;
    }

    private void applyEndIconTint() {
        applyIconTint(this.endIconView, this.hasEndIconTintList, this.endIconTintList, this.hasEndIconTintMode, this.endIconTintMode);
    }

    private void applyIconTint(@androidx.annotation.NonNull com.google.android.material.internal.CheckableImageButton checkableImageButton, boolean z, android.content.res.ColorStateList colorStateList, boolean z2, android.graphics.PorterDuff.Mode mode) {
        android.graphics.drawable.Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = androidx.core.graphics.drawable.DrawableCompat.wrap(drawable).mutate();
            if (z) {
                androidx.core.graphics.drawable.DrawableCompat.setTintList(drawable, colorStateList);
            }
            if (z2) {
                androidx.core.graphics.drawable.DrawableCompat.setTintMode(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void applyStartIconTint() {
        applyIconTint(this.startIconView, this.hasStartIconTintList, this.startIconTintList, this.hasStartIconTintMode, this.startIconTintMode);
    }

    private void assignBoxBackgroundByMode() {
        int i = this.boxBackgroundMode;
        if (i == 0) {
            this.boxBackground = null;
            this.boxUnderline = null;
            return;
        }
        if (i == 1) {
            this.boxBackground = new com.google.android.material.shape.MaterialShapeDrawable(this.shapeAppearanceModel);
            this.boxUnderline = new com.google.android.material.shape.MaterialShapeDrawable();
        } else {
            if (i != 2) {
                throw new java.lang.IllegalArgumentException(this.boxBackgroundMode + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.hintEnabled || (this.boxBackground instanceof com.google.android.material.textfield.CutoutDrawable)) {
                this.boxBackground = new com.google.android.material.shape.MaterialShapeDrawable(this.shapeAppearanceModel);
            } else {
                this.boxBackground = new com.google.android.material.textfield.CutoutDrawable(this.shapeAppearanceModel);
            }
            this.boxUnderline = null;
        }
    }

    private int calculateBoxBackgroundColor() {
        return this.boxBackgroundMode == 1 ? com.google.android.material.color.MaterialColors.layer(com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R.attr.colorSurface, 0), this.boxBackgroundColor) : this.boxBackgroundColor;
    }

    @androidx.annotation.NonNull
    private android.graphics.Rect calculateCollapsedTextBounds(@androidx.annotation.NonNull android.graphics.Rect rect) {
        if (this.editText == null) {
            throw new java.lang.IllegalStateException();
        }
        android.graphics.Rect rect2 = this.tmpBoundsRect;
        boolean z = androidx.core.view.ViewCompat.getLayoutDirection(this) == 1;
        rect2.bottom = rect.bottom;
        int i = this.boxBackgroundMode;
        if (i == 1) {
            rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, z);
            rect2.top = rect.top + this.boxCollapsedPaddingTopPx;
            rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, z);
            return rect2;
        }
        if (i != 2) {
            rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, z);
            rect2.top = getPaddingTop();
            rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, z);
            return rect2;
        }
        rect2.left = rect.left + this.editText.getPaddingLeft();
        rect2.top = rect.top - calculateLabelMarginTop();
        rect2.right = rect.right - this.editText.getPaddingRight();
        return rect2;
    }

    private int calculateExpandedLabelBottom(@androidx.annotation.NonNull android.graphics.Rect rect, @androidx.annotation.NonNull android.graphics.Rect rect2, float f) {
        return isSingleLineFilledTextField() ? (int) (rect2.top + f) : rect.bottom - this.editText.getCompoundPaddingBottom();
    }

    private int calculateExpandedLabelTop(@androidx.annotation.NonNull android.graphics.Rect rect, float f) {
        return isSingleLineFilledTextField() ? (int) (rect.centerY() - (f / 2.0f)) : rect.top + this.editText.getCompoundPaddingTop();
    }

    @androidx.annotation.NonNull
    private android.graphics.Rect calculateExpandedTextBounds(@androidx.annotation.NonNull android.graphics.Rect rect) {
        if (this.editText == null) {
            throw new java.lang.IllegalStateException();
        }
        android.graphics.Rect rect2 = this.tmpBoundsRect;
        float expandedTextHeight = this.collapsingTextHelper.getExpandedTextHeight();
        rect2.left = rect.left + this.editText.getCompoundPaddingLeft();
        rect2.top = calculateExpandedLabelTop(rect, expandedTextHeight);
        rect2.right = rect.right - this.editText.getCompoundPaddingRight();
        rect2.bottom = calculateExpandedLabelBottom(rect, rect2, expandedTextHeight);
        return rect2;
    }

    private int calculateLabelMarginTop() {
        float collapsedTextHeight;
        if (!this.hintEnabled) {
            return 0;
        }
        int i = this.boxBackgroundMode;
        if (i == 0 || i == 1) {
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight();
        } else {
            if (i != 2) {
                return 0;
            }
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        }
        return (int) collapsedTextHeight;
    }

    private boolean canDrawOutlineStroke() {
        return this.boxBackgroundMode == 2 && canDrawStroke();
    }

    private boolean canDrawStroke() {
        return this.boxStrokeWidthPx > -1 && this.boxStrokeColor != 0;
    }

    private void closeCutout() {
        if (cutoutEnabled()) {
            ((com.google.android.material.textfield.CutoutDrawable) this.boxBackground).removeCutout();
        }
    }

    private void collapseHint(boolean z) {
        android.animation.ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (z && this.hintAnimationEnabled) {
            animateToExpansionFraction(1.0f);
        } else {
            this.collapsingTextHelper.setExpansionFraction(1.0f);
        }
        this.hintExpanded = false;
        if (cutoutEnabled()) {
            openCutout();
        }
        updatePlaceholderText();
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
    }

    private boolean cutoutEnabled() {
        return this.hintEnabled && !android.text.TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof com.google.android.material.textfield.CutoutDrawable);
    }

    private void dispatchOnEditTextAttached() {
        java.util.Iterator<com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener> it = this.editTextAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEditTextAttached(this);
        }
    }

    private void dispatchOnEndIconChanged(int i) {
        java.util.Iterator<com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener> it = this.endIconChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEndIconChanged(this, i);
        }
    }

    private void drawBoxUnderline(android.graphics.Canvas canvas) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.boxUnderline;
        if (materialShapeDrawable != null) {
            android.graphics.Rect bounds = materialShapeDrawable.getBounds();
            bounds.top = bounds.bottom - this.boxStrokeWidthPx;
            this.boxUnderline.draw(canvas);
        }
    }

    private void drawHint(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        if (this.hintEnabled) {
            this.collapsingTextHelper.draw(canvas);
        }
    }

    private void expandHint(boolean z) {
        android.animation.ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (z && this.hintAnimationEnabled) {
            animateToExpansionFraction(0.0f);
        } else {
            this.collapsingTextHelper.setExpansionFraction(0.0f);
        }
        if (cutoutEnabled() && ((com.google.android.material.textfield.CutoutDrawable) this.boxBackground).hasCutout()) {
            closeCutout();
        }
        this.hintExpanded = true;
        hidePlaceholderText();
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
    }

    private com.google.android.material.textfield.EndIconDelegate getEndIconDelegate() {
        com.google.android.material.textfield.EndIconDelegate endIconDelegate = this.endIconDelegates.get(this.endIconMode);
        return endIconDelegate != null ? endIconDelegate : this.endIconDelegates.get(0);
    }

    @androidx.annotation.Nullable
    private com.google.android.material.internal.CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.errorIconView.getVisibility() == 0) {
            return this.errorIconView;
        }
        if (hasEndIcon() && isEndIconVisible()) {
            return this.endIconView;
        }
        return null;
    }

    private int getLabelLeftBoundAlightWithPrefix(int i, boolean z) {
        int compoundPaddingLeft = i + this.editText.getCompoundPaddingLeft();
        return (this.prefixText == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - this.prefixTextView.getMeasuredWidth()) + this.prefixTextView.getPaddingLeft();
    }

    private int getLabelRightBoundAlignedWithSuffix(int i, boolean z) {
        int compoundPaddingRight = i - this.editText.getCompoundPaddingRight();
        return (this.prefixText == null || !z) ? compoundPaddingRight : compoundPaddingRight + (this.prefixTextView.getMeasuredWidth() - this.prefixTextView.getPaddingRight());
    }

    private boolean hasEndIcon() {
        return this.endIconMode != 0;
    }

    private void hidePlaceholderText() {
        android.widget.TextView textView = this.placeholderTextView;
        if (textView == null || !this.placeholderEnabled) {
            return;
        }
        textView.setText((java.lang.CharSequence) null);
        this.placeholderTextView.setVisibility(4);
    }

    private boolean isErrorIconVisible() {
        return this.errorIconView.getVisibility() == 0;
    }

    private boolean isSingleLineFilledTextField() {
        return this.boxBackgroundMode == 1 && this.editText.getMinLines() <= 1;
    }

    private int[] mergeIconState(com.google.android.material.internal.CheckableImageButton checkableImageButton) {
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = java.util.Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        java.lang.System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        return copyOf;
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        setEditTextBoxBackground();
        updateTextInputBoxState();
        updateBoxCollapsedPaddingTop();
        adjustFilledEditTextPaddingForLargeFont();
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
    }

    private void openCutout() {
        if (cutoutEnabled()) {
            android.graphics.RectF rectF = this.tmpRectF;
            this.collapsingTextHelper.getCollapsedTextActualBounds(rectF, this.editText.getWidth(), this.editText.getGravity());
            applyCutoutPadding(rectF);
            int i = this.boxStrokeWidthPx;
            this.boxLabelCutoutHeight = i;
            rectF.top = 0.0f;
            rectF.bottom = i;
            rectF.offset(-getPaddingLeft(), 0.0f);
            ((com.google.android.material.textfield.CutoutDrawable) this.boxBackground).setCutout(rectF);
        }
    }

    private static void recursiveSetEnabled(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof android.view.ViewGroup) {
                recursiveSetEnabled((android.view.ViewGroup) childAt, z);
            }
        }
    }

    private void refreshIconDrawableState(com.google.android.material.internal.CheckableImageButton checkableImageButton, android.content.res.ColorStateList colorStateList) {
        android.graphics.drawable.Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(mergeIconState(checkableImageButton), colorStateList.getDefaultColor());
        android.graphics.drawable.Drawable mutate = androidx.core.graphics.drawable.DrawableCompat.wrap(drawable).mutate();
        androidx.core.graphics.drawable.DrawableCompat.setTintList(mutate, android.content.res.ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    private void removePlaceholderTextView() {
        android.widget.TextView textView = this.placeholderTextView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void setEditText(android.widget.EditText editText) {
        if (this.editText != null) {
            throw new java.lang.IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.endIconMode != 3) {
            boolean z = editText instanceof com.google.android.material.textfield.TextInputEditText;
        }
        this.editText = editText;
        setMinWidth(this.minWidth);
        setMaxWidth(this.maxWidth);
        onApplyBoxBackgroundMode();
        setTextInputAccessibilityDelegate(new com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate(this));
        this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
        this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
        int gravity = this.editText.getGravity();
        this.collapsingTextHelper.setCollapsedTextGravity((gravity & (-113)) | 48);
        this.collapsingTextHelper.setExpandedTextGravity(gravity);
        this.editText.addTextChangedListener(new com.google.android.material.textfield.TextInputLayout.AnonymousClass1());
        if (this.defaultHintTextColor == null) {
            this.defaultHintTextColor = this.editText.getHintTextColors();
        }
        if (this.hintEnabled) {
            if (android.text.TextUtils.isEmpty(this.hint)) {
                java.lang.CharSequence hint = this.editText.getHint();
                this.originalHint = hint;
                setHint(hint);
                this.editText.setHint((java.lang.CharSequence) null);
            }
            this.isProvidingHint = true;
        }
        if (this.counterView != null) {
            updateCounter(this.editText.getText().length());
        }
        updateEditTextBackground();
        this.indicatorViewController.adjustIndicatorPadding();
        this.startLayout.bringToFront();
        this.endLayout.bringToFront();
        this.endIconFrame.bringToFront();
        this.errorIconView.bringToFront();
        dispatchOnEditTextAttached();
        updatePrefixTextViewPadding();
        updateSuffixTextViewPadding();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        updateLabelState(false, true);
    }

    private void setEditTextBoxBackground() {
        if (shouldUseEditTextBackgroundForBoxBackground()) {
            androidx.core.view.ViewCompat.setBackground(this.editText, this.boxBackground);
        }
    }

    private void setErrorIconVisible(boolean z) {
        this.errorIconView.setVisibility(z ? 0 : 8);
        this.endIconFrame.setVisibility(z ? 8 : 0);
        updateSuffixTextViewPadding();
        if (hasEndIcon()) {
            return;
        }
        updateDummyDrawables();
    }

    private void setHintInternal(java.lang.CharSequence charSequence) {
        if (android.text.TextUtils.equals(charSequence, this.hint)) {
            return;
        }
        this.hint = charSequence;
        this.collapsingTextHelper.setText(charSequence);
        if (this.hintExpanded) {
            return;
        }
        openCutout();
    }

    private static void setIconClickable(@androidx.annotation.NonNull com.google.android.material.internal.CheckableImageButton checkableImageButton, @androidx.annotation.Nullable android.view.View.OnLongClickListener onLongClickListener) {
        boolean hasOnClickListeners = androidx.core.view.ViewCompat.hasOnClickListeners(checkableImageButton);
        boolean z = onLongClickListener != null;
        boolean z2 = hasOnClickListeners || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z);
        androidx.core.view.ViewCompat.setImportantForAccessibility(checkableImageButton, z2 ? 1 : 2);
    }

    private static void setIconOnClickListener(@androidx.annotation.NonNull com.google.android.material.internal.CheckableImageButton checkableImageButton, @androidx.annotation.Nullable android.view.View.OnClickListener onClickListener, @androidx.annotation.Nullable android.view.View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private static void setIconOnLongClickListener(@androidx.annotation.NonNull com.google.android.material.internal.CheckableImageButton checkableImageButton, @androidx.annotation.Nullable android.view.View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.placeholderEnabled == z) {
            return;
        }
        if (z) {
            androidx.appcompat.widget.AppCompatTextView appCompatTextView = new androidx.appcompat.widget.AppCompatTextView(getContext());
            this.placeholderTextView = appCompatTextView;
            appCompatTextView.setId(com.google.android.material.R.id.textinput_placeholder);
            androidx.core.view.ViewCompat.setAccessibilityLiveRegion(this.placeholderTextView, 1);
            setPlaceholderTextAppearance(this.placeholderTextAppearance);
            setPlaceholderTextColor(this.placeholderTextColor);
            addPlaceholderTextView();
        } else {
            removePlaceholderTextView();
            this.placeholderTextView = null;
        }
        this.placeholderEnabled = z;
    }

    private boolean shouldUpdateEndDummyDrawable() {
        return (this.errorIconView.getVisibility() == 0 || ((hasEndIcon() && isEndIconVisible()) || this.suffixText != null)) && this.endLayout.getMeasuredWidth() > 0;
    }

    private boolean shouldUpdateStartDummyDrawable() {
        return !(getStartIconDrawable() == null && this.prefixText == null) && this.startLayout.getMeasuredWidth() > 0;
    }

    private boolean shouldUseEditTextBackgroundForBoxBackground() {
        android.widget.EditText editText = this.editText;
        return (editText == null || this.boxBackground == null || editText.getBackground() != null || this.boxBackgroundMode == 0) ? false : true;
    }

    private void showPlaceholderText() {
        android.widget.TextView textView = this.placeholderTextView;
        if (textView == null || !this.placeholderEnabled) {
            return;
        }
        textView.setText(this.placeholderText);
        this.placeholderTextView.setVisibility(0);
        this.placeholderTextView.bringToFront();
    }

    private void tintEndIconOnError(boolean z) {
        if (!z || getEndIconDrawable() == null) {
            applyEndIconTint();
            return;
        }
        android.graphics.drawable.Drawable mutate = androidx.core.graphics.drawable.DrawableCompat.wrap(getEndIconDrawable()).mutate();
        androidx.core.graphics.drawable.DrawableCompat.setTint(mutate, this.indicatorViewController.getErrorViewCurrentTextColor());
        this.endIconView.setImageDrawable(mutate);
    }

    private void updateBoxCollapsedPaddingTop() {
        if (this.boxBackgroundMode == 1) {
            if (com.google.android.material.resources.MaterialResources.isFontScaleAtLeast2_0(getContext())) {
                this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(com.google.android.material.R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (com.google.android.material.resources.MaterialResources.isFontScaleAtLeast1_3(getContext())) {
                this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(com.google.android.material.R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    private void updateBoxUnderlineBounds(@androidx.annotation.NonNull android.graphics.Rect rect) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.boxUnderline;
        if (materialShapeDrawable != null) {
            int i = rect.bottom;
            materialShapeDrawable.setBounds(rect.left, i - this.boxStrokeWidthFocusedPx, rect.right, i);
        }
    }

    private void updateCounter() {
        if (this.counterView != null) {
            android.widget.EditText editText = this.editText;
            updateCounter(editText == null ? 0 : editText.getText().length());
        }
    }

    private static void updateCounterContentDescription(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.widget.TextView textView, int i, int i2, boolean z) {
        textView.setContentDescription(context.getString(z ? com.google.android.material.R.string.character_counter_overflowed_content_description : com.google.android.material.R.string.character_counter_content_description, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2)));
    }

    private void updateCounterTextAppearanceAndColor() {
        android.content.res.ColorStateList colorStateList;
        android.content.res.ColorStateList colorStateList2;
        android.widget.TextView textView = this.counterView;
        if (textView != null) {
            setTextAppearanceCompatWithErrorFallback(textView, this.counterOverflowed ? this.counterOverflowTextAppearance : this.counterTextAppearance);
            if (!this.counterOverflowed && (colorStateList2 = this.counterTextColor) != null) {
                this.counterView.setTextColor(colorStateList2);
            }
            if (!this.counterOverflowed || (colorStateList = this.counterOverflowTextColor) == null) {
                return;
            }
            this.counterView.setTextColor(colorStateList);
        }
    }

    private void updateCutout() {
        if (!cutoutEnabled() || this.hintExpanded || this.boxLabelCutoutHeight == this.boxStrokeWidthPx) {
            return;
        }
        closeCutout();
        openCutout();
    }

    private boolean updateDummyDrawables() {
        boolean z;
        if (this.editText == null) {
            return false;
        }
        boolean z2 = true;
        if (shouldUpdateStartDummyDrawable()) {
            int measuredWidth = this.startLayout.getMeasuredWidth() - this.editText.getPaddingLeft();
            if (this.startDummyDrawable == null || this.startDummyDrawableWidth != measuredWidth) {
                android.graphics.drawable.ColorDrawable colorDrawable = new android.graphics.drawable.ColorDrawable();
                this.startDummyDrawable = colorDrawable;
                this.startDummyDrawableWidth = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            android.graphics.drawable.Drawable[] compoundDrawablesRelative = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(this.editText);
            android.graphics.drawable.Drawable drawable = compoundDrawablesRelative[0];
            android.graphics.drawable.Drawable drawable2 = this.startDummyDrawable;
            if (drawable != drawable2) {
                androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(this.editText, drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.startDummyDrawable != null) {
                android.graphics.drawable.Drawable[] compoundDrawablesRelative2 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(this.editText);
                androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(this.editText, null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.startDummyDrawable = null;
                z = true;
            }
            z = false;
        }
        if (shouldUpdateEndDummyDrawable()) {
            int measuredWidth2 = this.suffixTextView.getMeasuredWidth() - this.editText.getPaddingRight();
            com.google.android.material.internal.CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + androidx.core.view.MarginLayoutParamsCompat.getMarginStart((android.view.ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            android.graphics.drawable.Drawable[] compoundDrawablesRelative3 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(this.editText);
            android.graphics.drawable.Drawable drawable3 = this.endDummyDrawable;
            if (drawable3 == null || this.endDummyDrawableWidth == measuredWidth2) {
                if (drawable3 == null) {
                    android.graphics.drawable.ColorDrawable colorDrawable2 = new android.graphics.drawable.ColorDrawable();
                    this.endDummyDrawable = colorDrawable2;
                    this.endDummyDrawableWidth = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                android.graphics.drawable.Drawable drawable4 = compoundDrawablesRelative3[2];
                android.graphics.drawable.Drawable drawable5 = this.endDummyDrawable;
                if (drawable4 != drawable5) {
                    this.originalEditTextEndDrawable = drawable4;
                    androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(this.editText, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], drawable5, compoundDrawablesRelative3[3]);
                } else {
                    z2 = z;
                }
            } else {
                this.endDummyDrawableWidth = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(this.editText, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.endDummyDrawable, compoundDrawablesRelative3[3]);
            }
        } else {
            if (this.endDummyDrawable == null) {
                return z;
            }
            android.graphics.drawable.Drawable[] compoundDrawablesRelative4 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(this.editText);
            if (compoundDrawablesRelative4[2] == this.endDummyDrawable) {
                androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(this.editText, compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.originalEditTextEndDrawable, compoundDrawablesRelative4[3]);
            } else {
                z2 = z;
            }
            this.endDummyDrawable = null;
        }
        return z2;
    }

    private boolean updateEditTextHeightBasedOnIcon() {
        int max;
        if (this.editText == null || this.editText.getMeasuredHeight() >= (max = java.lang.Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight()))) {
            return false;
        }
        this.editText.setMinimumHeight(max);
        return true;
    }

    private void updateInputLayoutMargins() {
        if (this.boxBackgroundMode != 1) {
            android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
            int calculateLabelMarginTop = calculateLabelMarginTop();
            if (calculateLabelMarginTop != layoutParams.topMargin) {
                layoutParams.topMargin = calculateLabelMarginTop;
                this.inputFrame.requestLayout();
            }
        }
    }

    private void updateLabelState(boolean z, boolean z2) {
        android.content.res.ColorStateList colorStateList;
        android.widget.TextView textView;
        boolean isEnabled = isEnabled();
        android.widget.EditText editText = this.editText;
        boolean z3 = (editText == null || android.text.TextUtils.isEmpty(editText.getText())) ? false : true;
        android.widget.EditText editText2 = this.editText;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean errorShouldBeShown = this.indicatorViewController.errorShouldBeShown();
        android.content.res.ColorStateList colorStateList2 = this.defaultHintTextColor;
        if (colorStateList2 != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList2);
            this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
        }
        if (!isEnabled) {
            android.content.res.ColorStateList colorStateList3 = this.defaultHintTextColor;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.disabledColor) : this.disabledColor;
            this.collapsingTextHelper.setCollapsedTextColor(android.content.res.ColorStateList.valueOf(colorForState));
            this.collapsingTextHelper.setExpandedTextColor(android.content.res.ColorStateList.valueOf(colorForState));
        } else if (errorShouldBeShown) {
            this.collapsingTextHelper.setCollapsedTextColor(this.indicatorViewController.getErrorViewTextColors());
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(textView.getTextColors());
        } else if (z4 && (colorStateList = this.focusedTextColor) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
        }
        if (z3 || !this.expandedHintEnabled || (isEnabled() && z4)) {
            if (z2 || this.hintExpanded) {
                collapseHint(z);
                return;
            }
            return;
        }
        if (z2 || !this.hintExpanded) {
            expandHint(z);
        }
    }

    private void updatePlaceholderMeasurementsBasedOnEditText() {
        android.widget.EditText editText;
        if (this.placeholderTextView == null || (editText = this.editText) == null) {
            return;
        }
        this.placeholderTextView.setGravity(editText.getGravity());
        this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
    }

    private void updatePlaceholderText() {
        android.widget.EditText editText = this.editText;
        updatePlaceholderText(editText == null ? 0 : editText.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlaceholderText(int i) {
        if (i != 0 || this.hintExpanded) {
            hidePlaceholderText();
        } else {
            showPlaceholderText();
        }
    }

    private void updatePrefixTextViewPadding() {
        if (this.editText == null) {
            return;
        }
        androidx.core.view.ViewCompat.setPaddingRelative(this.prefixTextView, isStartIconVisible() ? 0 : androidx.core.view.ViewCompat.getPaddingStart(this.editText), this.editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(com.google.android.material.R.dimen.material_input_text_to_prefix_suffix_padding), this.editText.getCompoundPaddingBottom());
    }

    private void updatePrefixTextVisibility() {
        this.prefixTextView.setVisibility((this.prefixText == null || isHintExpanded()) ? 8 : 0);
        updateDummyDrawables();
    }

    private void updateStrokeErrorColor(boolean z, boolean z2) {
        int defaultColor = this.strokeErrorColor.getDefaultColor();
        int colorForState = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, defaultColor);
        if (z) {
            this.boxStrokeColor = colorForState2;
        } else if (z2) {
            this.boxStrokeColor = colorForState;
        } else {
            this.boxStrokeColor = defaultColor;
        }
    }

    private void updateSuffixTextViewPadding() {
        if (this.editText == null) {
            return;
        }
        androidx.core.view.ViewCompat.setPaddingRelative(this.suffixTextView, getContext().getResources().getDimensionPixelSize(com.google.android.material.R.dimen.material_input_text_to_prefix_suffix_padding), this.editText.getPaddingTop(), (isEndIconVisible() || isErrorIconVisible()) ? 0 : androidx.core.view.ViewCompat.getPaddingEnd(this.editText), this.editText.getPaddingBottom());
    }

    private void updateSuffixTextVisibility() {
        int visibility = this.suffixTextView.getVisibility();
        boolean z = (this.suffixText == null || isHintExpanded()) ? false : true;
        this.suffixTextView.setVisibility(z ? 0 : 8);
        if (visibility != this.suffixTextView.getVisibility()) {
            getEndIconDelegate().onSuffixVisibilityChanged(z);
        }
        updateDummyDrawables();
    }

    public void addOnEditTextAttachedListener(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.add(onEditTextAttachedListener);
        if (this.editText != null) {
            onEditTextAttachedListener.onEditTextAttached(this);
        }
    }

    public void addOnEndIconChangedListener(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.add(onEndIconChangedListener);
    }

    @Override // android.view.ViewGroup
    public void addView(@androidx.annotation.NonNull android.view.View view, int i, @androidx.annotation.NonNull android.view.ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof android.widget.EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.inputFrame.addView(view, layoutParams2);
        this.inputFrame.setLayoutParams(layoutParams);
        updateInputLayoutMargins();
        setEditText((android.widget.EditText) view);
    }

    @androidx.annotation.VisibleForTesting
    public void animateToExpansionFraction(float f) {
        if (this.collapsingTextHelper.getExpansionFraction() == f) {
            return;
        }
        if (this.animator == null) {
            android.animation.ValueAnimator valueAnimator = new android.animation.ValueAnimator();
            this.animator = valueAnimator;
            valueAnimator.setInterpolator(com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.animator.setDuration(167L);
            this.animator.addUpdateListener(new com.google.android.material.textfield.TextInputLayout.AnonymousClass4());
        }
        this.animator.setFloatValues(this.collapsingTextHelper.getExpansionFraction(), f);
        this.animator.start();
    }

    public void clearOnEditTextAttachedListeners() {
        this.editTextAttachedListeners.clear();
    }

    public void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    @androidx.annotation.VisibleForTesting
    public boolean cutoutIsOpen() {
        return cutoutEnabled() && ((com.google.android.material.textfield.CutoutDrawable) this.boxBackground).hasCutout();
    }

    @Override // android.view.ViewGroup, android.view.View
    @android.annotation.TargetApi(26)
    public void dispatchProvideAutofillStructure(@androidx.annotation.NonNull android.view.ViewStructure viewStructure, int i) {
        android.view.ViewStructure newChild;
        android.widget.EditText editText = this.editText;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.originalHint != null) {
            boolean z = this.isProvidingHint;
            this.isProvidingHint = false;
            java.lang.CharSequence hint = editText.getHint();
            this.editText.setHint(this.originalHint);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.editText.setHint(hint);
                this.isProvidingHint = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        viewStructure.setChildCount(this.inputFrame.getChildCount());
        for (int i2 = 0; i2 < this.inputFrame.getChildCount(); i2++) {
            android.view.View childAt = this.inputFrame.getChildAt(i2);
            newChild = viewStructure.newChild(i2);
            childAt.dispatchProvideAutofillStructure(newChild, i);
            if (childAt == this.editText) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(@androidx.annotation.NonNull android.util.SparseArray<android.os.Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    @Override // android.view.View
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        super.draw(canvas);
        drawHint(canvas);
        drawBoxUnderline(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.inDrawableStateChanged) {
            return;
        }
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        boolean state = collapsingTextHelper != null ? collapsingTextHelper.setState(drawableState) | false : false;
        if (this.editText != null) {
            updateLabelState(androidx.core.view.ViewCompat.isLaidOut(this) && isEnabled());
        }
        updateEditTextBackground();
        updateTextInputBoxState();
        if (state) {
            invalidate();
        }
        this.inDrawableStateChanged = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        android.widget.EditText editText = this.editText;
        return editText != null ? editText.getBaseline() + getPaddingTop() + calculateLabelMarginTop() : super.getBaseline();
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.MaterialShapeDrawable getBoxBackground() {
        int i = this.boxBackgroundMode;
        if (i == 1 || i == 2) {
            return this.boxBackground;
        }
        throw new java.lang.IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxBackground.getBottomLeftCornerResolvedSize();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxBackground.getBottomRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxBackground.getTopRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxBackground.getTopLeftCornerResolvedSize();
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getCounterOverflowDescription() {
        android.widget.TextView textView;
        if (this.counterEnabled && this.counterOverflowed && (textView = this.counterView) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    @androidx.annotation.Nullable
    public android.widget.EditText getEditText() {
        return this.editText;
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.internal.CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getError() {
        if (this.indicatorViewController.isErrorEnabled()) {
            return this.indicatorViewController.getErrorText();
        }
        return null;
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getErrorContentDescription() {
        return this.indicatorViewController.getErrorContentDescription();
    }

    @androidx.annotation.ColorInt
    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    @androidx.annotation.VisibleForTesting
    public final int getErrorTextCurrentColor() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getHelperText() {
        if (this.indicatorViewController.isHelperTextEnabled()) {
            return this.indicatorViewController.getHelperText();
        }
        return null;
    }

    @androidx.annotation.ColorInt
    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    @androidx.annotation.VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    @androidx.annotation.VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    @androidx.annotation.Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    @androidx.annotation.Px
    public int getMinWidth() {
        return this.minWidth;
    }

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public java.lang.CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public android.graphics.drawable.Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getPlaceholderText() {
        if (this.placeholderEnabled) {
            return this.placeholderText;
        }
        return null;
    }

    @androidx.annotation.StyleRes
    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getPrefixText() {
        return this.prefixText;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getPrefixTextColor() {
        return this.prefixTextView.getTextColors();
    }

    @androidx.annotation.NonNull
    public android.widget.TextView getPrefixTextView() {
        return this.prefixTextView;
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getSuffixText() {
        return this.suffixText;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    @androidx.annotation.NonNull
    public android.widget.TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    @androidx.annotation.Nullable
    public android.graphics.Typeface getTypeface() {
        return this.typeface;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public boolean isEndIconCheckable() {
        return this.endIconView.isCheckable();
    }

    public boolean isEndIconVisible() {
        return this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0;
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    public boolean isExpandedHintEnabled() {
        return this.expandedHintEnabled;
    }

    @androidx.annotation.VisibleForTesting
    public final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    @androidx.annotation.VisibleForTesting
    public final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    @java.lang.Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        return this.endIconMode == 1;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public boolean isStartIconCheckable() {
        return this.startIconView.isCheckable();
    }

    public boolean isStartIconVisible() {
        return this.startIconView.getVisibility() == 0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        android.widget.EditText editText = this.editText;
        if (editText != null) {
            android.graphics.Rect rect = this.tmpRect;
            com.google.android.material.internal.DescendantOffsetUtils.getDescendantRect(this, editText, rect);
            updateBoxUnderlineBounds(rect);
            if (this.hintEnabled) {
                this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
                int gravity = this.editText.getGravity();
                this.collapsingTextHelper.setCollapsedTextGravity((gravity & (-113)) | 48);
                this.collapsingTextHelper.setExpandedTextGravity(gravity);
                this.collapsingTextHelper.setCollapsedBounds(calculateCollapsedTextBounds(rect));
                this.collapsingTextHelper.setExpandedBounds(calculateExpandedTextBounds(rect));
                this.collapsingTextHelper.recalculate();
                if (!cutoutEnabled() || this.hintExpanded) {
                    return;
                }
                openCutout();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        boolean updateEditTextHeightBasedOnIcon = updateEditTextHeightBasedOnIcon();
        boolean updateDummyDrawables = updateDummyDrawables();
        if (updateEditTextHeightBasedOnIcon || updateDummyDrawables) {
            this.editText.post(new com.google.android.material.textfield.TextInputLayout.AnonymousClass3());
        }
        updatePlaceholderMeasurementsBasedOnEditText();
        updatePrefixTextViewPadding();
        updateSuffixTextViewPadding();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@androidx.annotation.Nullable android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.google.android.material.textfield.TextInputLayout.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.google.android.material.textfield.TextInputLayout.SavedState savedState = (com.google.android.material.textfield.TextInputLayout.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.error);
        if (savedState.isEndIconChecked) {
            this.endIconView.post(new com.google.android.material.textfield.TextInputLayout.AnonymousClass2());
        }
        setHint(savedState.hintText);
        setHelperText(savedState.helperText);
        setPlaceholderText(savedState.placeholderText);
        requestLayout();
    }

    @Override // android.view.View
    @androidx.annotation.Nullable
    public android.os.Parcelable onSaveInstanceState() {
        com.google.android.material.textfield.TextInputLayout.SavedState savedState = new com.google.android.material.textfield.TextInputLayout.SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.errorShouldBeShown()) {
            savedState.error = getError();
        }
        savedState.isEndIconChecked = hasEndIcon() && this.endIconView.isChecked();
        savedState.hintText = getHint();
        savedState.helperText = getHelperText();
        savedState.placeholderText = getPlaceholderText();
        return savedState;
    }

    @java.lang.Deprecated
    public void passwordVisibilityToggleRequested(boolean z) {
        if (this.endIconMode == 1) {
            this.endIconView.performClick();
            if (z) {
                this.endIconView.jumpDrawablesToCurrentState();
            }
        }
    }

    public void refreshEndIconDrawableState() {
        refreshIconDrawableState(this.endIconView, this.endIconTintList);
    }

    public void refreshErrorIconDrawableState() {
        refreshIconDrawableState(this.errorIconView, this.errorIconTintList);
    }

    public void refreshStartIconDrawableState() {
        refreshIconDrawableState(this.startIconView, this.startIconTintList);
    }

    public void removeOnEditTextAttachedListener(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.remove(onEditTextAttachedListener);
    }

    public void removeOnEndIconChangedListener(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.remove(onEndIconChangedListener);
    }

    public void setBoxBackgroundColor(@androidx.annotation.ColorInt int i) {
        if (this.boxBackgroundColor != i) {
            this.boxBackgroundColor = i;
            this.defaultFilledBackgroundColor = i;
            this.focusedFilledBackgroundColor = i;
            this.hoveredFilledBackgroundColor = i;
            applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorResource(@androidx.annotation.ColorRes int i) {
        setBoxBackgroundColor(androidx.core.content.ContextCompat.getColor(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.defaultFilledBackgroundColor = defaultColor;
        this.boxBackgroundColor = defaultColor;
        this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        applyBoxAttributes();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.boxBackgroundMode) {
            return;
        }
        this.boxBackgroundMode = i;
        if (this.editText != null) {
            onApplyBoxBackgroundMode();
        }
    }

    public void setBoxCornerRadii(float f, float f2, float f3, float f4) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable != null && materialShapeDrawable.getTopLeftCornerResolvedSize() == f && this.boxBackground.getTopRightCornerResolvedSize() == f2 && this.boxBackground.getBottomRightCornerResolvedSize() == f4 && this.boxBackground.getBottomLeftCornerResolvedSize() == f3) {
            return;
        }
        this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCornerSize(f).setTopRightCornerSize(f2).setBottomRightCornerSize(f4).setBottomLeftCornerSize(f3).build();
        applyBoxAttributes();
    }

    public void setBoxCornerRadiiResources(@androidx.annotation.DimenRes int i, @androidx.annotation.DimenRes int i2, @androidx.annotation.DimenRes int i3, @androidx.annotation.DimenRes int i4) {
        setBoxCornerRadii(getContext().getResources().getDimension(i), getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i4), getContext().getResources().getDimension(i3));
    }

    public void setBoxStrokeColor(@androidx.annotation.ColorInt int i) {
        if (this.focusedStrokeColor != i) {
            this.focusedStrokeColor = i;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeColorStateList(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.defaultStrokeColor = colorStateList.getDefaultColor();
            this.disabledColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.hoveredStrokeColor = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            this.focusedStrokeColor = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        } else if (this.focusedStrokeColor != colorStateList.getDefaultColor()) {
            this.focusedStrokeColor = colorStateList.getDefaultColor();
        }
        updateTextInputBoxState();
    }

    public void setBoxStrokeErrorColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.strokeErrorColor != colorStateList) {
            this.strokeErrorColor = colorStateList;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.boxStrokeWidthDefaultPx = i;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.boxStrokeWidthFocusedPx = i;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocusedResource(@androidx.annotation.DimenRes int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(@androidx.annotation.DimenRes int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.counterEnabled != z) {
            if (z) {
                androidx.appcompat.widget.AppCompatTextView appCompatTextView = new androidx.appcompat.widget.AppCompatTextView(getContext());
                this.counterView = appCompatTextView;
                appCompatTextView.setId(com.google.android.material.R.id.textinput_counter);
                android.graphics.Typeface typeface = this.typeface;
                if (typeface != null) {
                    this.counterView.setTypeface(typeface);
                }
                this.counterView.setMaxLines(1);
                this.indicatorViewController.addIndicator(this.counterView, 2);
                androidx.core.view.MarginLayoutParamsCompat.setMarginStart((android.view.ViewGroup.MarginLayoutParams) this.counterView.getLayoutParams(), getResources().getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_textinput_counter_margin_start));
                updateCounterTextAppearanceAndColor();
                updateCounter();
            } else {
                this.indicatorViewController.removeIndicator(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.counterMaxLength != i) {
            if (i > 0) {
                this.counterMaxLength = i;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled) {
                updateCounter();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.counterOverflowTextAppearance != i) {
            this.counterOverflowTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.counterOverflowTextColor != colorStateList) {
            this.counterOverflowTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.counterTextAppearance != i) {
            this.counterTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.counterTextColor != colorStateList) {
            this.counterTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setDefaultHintTextColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.endIconView.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.endIconView.setCheckable(z);
    }

    public void setEndIconContentDescription(@androidx.annotation.StringRes int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconContentDescription(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.endIconView.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@androidx.annotation.DrawableRes int i) {
        setEndIconDrawable(i != 0 ? androidx.appcompat.content.res.AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setEndIconDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
        refreshEndIconDrawableState();
    }

    public void setEndIconMode(int i) {
        int i2 = this.endIconMode;
        this.endIconMode = i;
        dispatchOnEndIconChanged(i2);
        setEndIconVisible(i != 0);
        if (getEndIconDelegate().isBoxBackgroundModeSupported(this.boxBackgroundMode)) {
            getEndIconDelegate().initialize();
            applyEndIconTint();
            return;
        }
        throw new java.lang.IllegalStateException("The current box background mode " + this.boxBackgroundMode + " is not supported by the end icon mode " + i);
    }

    public void setEndIconOnClickListener(@androidx.annotation.Nullable android.view.View.OnClickListener onClickListener) {
        setIconOnClickListener(this.endIconView, onClickListener, this.endIconOnLongClickListener);
    }

    public void setEndIconOnLongClickListener(@androidx.annotation.Nullable android.view.View.OnLongClickListener onLongClickListener) {
        this.endIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.endIconView, onLongClickListener);
    }

    public void setEndIconTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.endIconTintList != colorStateList) {
            this.endIconTintList = colorStateList;
            this.hasEndIconTintList = true;
            applyEndIconTint();
        }
    }

    public void setEndIconTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        if (this.endIconTintMode != mode) {
            this.endIconTintMode = mode;
            this.hasEndIconTintMode = true;
            applyEndIconTint();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (isEndIconVisible() != z) {
            this.endIconView.setVisibility(z ? 0 : 8);
            updateSuffixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public void setError(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        if (!this.indicatorViewController.isErrorEnabled()) {
            if (android.text.TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (android.text.TextUtils.isEmpty(charSequence)) {
            this.indicatorViewController.hideError();
        } else {
            this.indicatorViewController.showError(charSequence);
        }
    }

    public void setErrorContentDescription(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        this.indicatorViewController.setErrorContentDescription(charSequence);
    }

    public void setErrorEnabled(boolean z) {
        this.indicatorViewController.setErrorEnabled(z);
    }

    public void setErrorIconDrawable(@androidx.annotation.DrawableRes int i) {
        setErrorIconDrawable(i != 0 ? androidx.appcompat.content.res.AppCompatResources.getDrawable(getContext(), i) : null);
        refreshErrorIconDrawableState();
    }

    public void setErrorIconDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.errorIconView.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.indicatorViewController.isErrorEnabled());
    }

    public void setErrorIconOnClickListener(@androidx.annotation.Nullable android.view.View.OnClickListener onClickListener) {
        setIconOnClickListener(this.errorIconView, onClickListener, this.errorIconOnLongClickListener);
    }

    public void setErrorIconOnLongClickListener(@androidx.annotation.Nullable android.view.View.OnLongClickListener onLongClickListener) {
        this.errorIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.errorIconView, onLongClickListener);
    }

    public void setErrorIconTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.errorIconTintList = colorStateList;
        android.graphics.drawable.Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.DrawableCompat.wrap(drawable).mutate();
            androidx.core.graphics.drawable.DrawableCompat.setTintList(drawable, colorStateList);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        android.graphics.drawable.Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.DrawableCompat.wrap(drawable).mutate();
            androidx.core.graphics.drawable.DrawableCompat.setTintMode(drawable, mode);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(@androidx.annotation.StyleRes int i) {
        this.indicatorViewController.setErrorTextAppearance(i);
    }

    public void setErrorTextColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.indicatorViewController.setErrorViewTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.expandedHintEnabled != z) {
            this.expandedHintEnabled = z;
            updateLabelState(false);
        }
    }

    public void setHelperText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        if (android.text.TextUtils.isEmpty(charSequence)) {
            if (isHelperTextEnabled()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.indicatorViewController.showHelper(charSequence);
        }
    }

    public void setHelperTextColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.indicatorViewController.setHelperTextViewTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.indicatorViewController.setHelperTextEnabled(z);
    }

    public void setHelperTextTextAppearance(@androidx.annotation.StyleRes int i) {
        this.indicatorViewController.setHelperTextAppearance(i);
    }

    public void setHint(@androidx.annotation.StringRes int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    public void setHint(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.hintAnimationEnabled = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.hintEnabled) {
            this.hintEnabled = z;
            if (z) {
                java.lang.CharSequence hint = this.editText.getHint();
                if (!android.text.TextUtils.isEmpty(hint)) {
                    if (android.text.TextUtils.isEmpty(this.hint)) {
                        setHint(hint);
                    }
                    this.editText.setHint((java.lang.CharSequence) null);
                }
                this.isProvidingHint = true;
            } else {
                this.isProvidingHint = false;
                if (!android.text.TextUtils.isEmpty(this.hint) && android.text.TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal(null);
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public void setHintTextAppearance(@androidx.annotation.StyleRes int i) {
        this.collapsingTextHelper.setCollapsedTextAppearance(i);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText != null) {
            updateLabelState(false);
            updateInputLayoutMargins();
        }
    }

    public void setHintTextColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.focusedTextColor != colorStateList) {
            if (this.defaultHintTextColor == null) {
                this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
            }
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false);
            }
        }
    }

    public void setMaxWidth(@androidx.annotation.Px int i) {
        this.maxWidth = i;
        android.widget.EditText editText = this.editText;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(@androidx.annotation.DimenRes int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinWidth(@androidx.annotation.Px int i) {
        this.minWidth = i;
        android.widget.EditText editText = this.editText;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinWidth(i);
    }

    public void setMinWidthResource(@androidx.annotation.DimenRes int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @java.lang.Deprecated
    public void setPasswordVisibilityToggleContentDescription(@androidx.annotation.StringRes int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @java.lang.Deprecated
    public void setPasswordVisibilityToggleContentDescription(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        this.endIconView.setContentDescription(charSequence);
    }

    @java.lang.Deprecated
    public void setPasswordVisibilityToggleDrawable(@androidx.annotation.DrawableRes int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? androidx.appcompat.content.res.AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @java.lang.Deprecated
    public void setPasswordVisibilityToggleDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    @java.lang.Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.endIconMode != 1) {
            setEndIconMode(1);
        } else {
            if (z) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @java.lang.Deprecated
    public void setPasswordVisibilityToggleTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.endIconTintList = colorStateList;
        this.hasEndIconTintList = true;
        applyEndIconTint();
    }

    @java.lang.Deprecated
    public void setPasswordVisibilityToggleTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        this.endIconTintMode = mode;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
    }

    public void setPlaceholderText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        if (this.placeholderEnabled && android.text.TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.placeholderEnabled) {
                setPlaceholderTextEnabled(true);
            }
            this.placeholderText = charSequence;
        }
        updatePlaceholderText();
    }

    public void setPlaceholderTextAppearance(@androidx.annotation.StyleRes int i) {
        this.placeholderTextAppearance = i;
        android.widget.TextView textView = this.placeholderTextView;
        if (textView != null) {
            androidx.core.widget.TextViewCompat.setTextAppearance(textView, i);
        }
    }

    public void setPlaceholderTextColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.placeholderTextColor != colorStateList) {
            this.placeholderTextColor = colorStateList;
            android.widget.TextView textView = this.placeholderTextView;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        this.prefixText = android.text.TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.prefixTextView.setText(charSequence);
        updatePrefixTextVisibility();
    }

    public void setPrefixTextAppearance(@androidx.annotation.StyleRes int i) {
        androidx.core.widget.TextViewCompat.setTextAppearance(this.prefixTextView, i);
    }

    public void setPrefixTextColor(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        this.prefixTextView.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.startIconView.setCheckable(z);
    }

    public void setStartIconContentDescription(@androidx.annotation.StringRes int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconContentDescription(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.startIconView.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@androidx.annotation.DrawableRes int i) {
        setStartIconDrawable(i != 0 ? androidx.appcompat.content.res.AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setStartIconDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.startIconView.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            refreshStartIconDrawableState();
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((java.lang.CharSequence) null);
        }
    }

    public void setStartIconOnClickListener(@androidx.annotation.Nullable android.view.View.OnClickListener onClickListener) {
        setIconOnClickListener(this.startIconView, onClickListener, this.startIconOnLongClickListener);
    }

    public void setStartIconOnLongClickListener(@androidx.annotation.Nullable android.view.View.OnLongClickListener onLongClickListener) {
        this.startIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.startIconView, onLongClickListener);
    }

    public void setStartIconTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.startIconTintList != colorStateList) {
            this.startIconTintList = colorStateList;
            this.hasStartIconTintList = true;
            applyStartIconTint();
        }
    }

    public void setStartIconTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        if (this.startIconTintMode != mode) {
            this.startIconTintMode = mode;
            this.hasStartIconTintMode = true;
            applyStartIconTint();
        }
    }

    public void setStartIconVisible(boolean z) {
        if (isStartIconVisible() != z) {
            this.startIconView.setVisibility(z ? 0 : 8);
            updatePrefixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public void setSuffixText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        this.suffixText = android.text.TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.suffixTextView.setText(charSequence);
        updateSuffixTextVisibility();
    }

    public void setSuffixTextAppearance(@androidx.annotation.StyleRes int i) {
        androidx.core.widget.TextViewCompat.setTextAppearance(this.suffixTextView, i);
    }

    public void setSuffixTextColor(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        this.suffixTextView.setTextColor(colorStateList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setTextAppearanceCompatWithErrorFallback(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.StyleRes int i) {
        boolean z = true;
        try {
            androidx.core.widget.TextViewCompat.setTextAppearance(textView, i);
            if (android.os.Build.VERSION.SDK_INT >= 23) {
            }
            z = false;
        } catch (java.lang.Exception unused) {
        }
        if (z) {
            androidx.core.widget.TextViewCompat.setTextAppearance(textView, com.google.android.material.R.style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(androidx.core.content.ContextCompat.getColor(getContext(), com.google.android.material.R.color.design_error));
        }
    }

    public void setTextInputAccessibilityDelegate(@androidx.annotation.Nullable com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate accessibilityDelegate) {
        android.widget.EditText editText = this.editText;
        if (editText != null) {
            androidx.core.view.ViewCompat.setAccessibilityDelegate(editText, accessibilityDelegate);
        }
    }

    public void setTypeface(@androidx.annotation.Nullable android.graphics.Typeface typeface) {
        if (typeface != this.typeface) {
            this.typeface = typeface;
            this.collapsingTextHelper.setTypefaces(typeface);
            this.indicatorViewController.setTypefaces(typeface);
            android.widget.TextView textView = this.counterView;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public void updateCounter(int i) {
        boolean z = this.counterOverflowed;
        int i2 = this.counterMaxLength;
        if (i2 == -1) {
            this.counterView.setText(java.lang.String.valueOf(i));
            this.counterView.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            this.counterOverflowed = i > i2;
            updateCounterContentDescription(getContext(), this.counterView, i, this.counterMaxLength, this.counterOverflowed);
            if (z != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
            }
            this.counterView.setText(androidx.core.text.BidiFormatter.getInstance().unicodeWrap(getContext().getString(com.google.android.material.R.string.character_counter_pattern, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.counterMaxLength))));
        }
        if (this.editText == null || z == this.counterOverflowed) {
            return;
        }
        updateLabelState(false);
        updateTextInputBoxState();
        updateEditTextBackground();
    }

    public void updateEditTextBackground() {
        android.graphics.drawable.Drawable background;
        android.widget.TextView textView;
        android.widget.EditText editText = this.editText;
        if (editText == null || this.boxBackgroundMode != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (this.indicatorViewController.errorShouldBeShown()) {
            background.setColorFilter(androidx.appcompat.widget.AppCompatDrawableManager.getPorterDuffColorFilter(this.indicatorViewController.getErrorViewCurrentTextColor(), android.graphics.PorterDuff.Mode.SRC_IN));
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            background.setColorFilter(androidx.appcompat.widget.AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), android.graphics.PorterDuff.Mode.SRC_IN));
        } else {
            androidx.core.graphics.drawable.DrawableCompat.clearColorFilter(background);
            this.editText.refreshDrawableState();
        }
    }

    public void updateLabelState(boolean z) {
        updateLabelState(z, false);
    }

    public void updateTextInputBoxState() {
        android.widget.TextView textView;
        android.widget.EditText editText;
        android.widget.EditText editText2;
        if (this.boxBackground == null || this.boxBackgroundMode == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.editText) != null && editText2.hasFocus());
        boolean z3 = isHovered() || ((editText = this.editText) != null && editText.isHovered());
        if (!isEnabled()) {
            this.boxStrokeColor = this.disabledColor;
        } else if (this.indicatorViewController.errorShouldBeShown()) {
            if (this.strokeErrorColor != null) {
                updateStrokeErrorColor(z2, z3);
            } else {
                this.boxStrokeColor = this.indicatorViewController.getErrorViewCurrentTextColor();
            }
        } else if (!this.counterOverflowed || (textView = this.counterView) == null) {
            if (z2) {
                this.boxStrokeColor = this.focusedStrokeColor;
            } else if (z3) {
                this.boxStrokeColor = this.hoveredStrokeColor;
            } else {
                this.boxStrokeColor = this.defaultStrokeColor;
            }
        } else if (this.strokeErrorColor != null) {
            updateStrokeErrorColor(z2, z3);
        } else {
            this.boxStrokeColor = textView.getCurrentTextColor();
        }
        if (getErrorIconDrawable() != null && this.indicatorViewController.isErrorEnabled() && this.indicatorViewController.errorShouldBeShown()) {
            z = true;
        }
        setErrorIconVisible(z);
        refreshErrorIconDrawableState();
        refreshStartIconDrawableState();
        refreshEndIconDrawableState();
        if (getEndIconDelegate().shouldTintIconOnError()) {
            tintEndIconOnError(this.indicatorViewController.errorShouldBeShown());
        }
        if (z2 && isEnabled()) {
            this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
        } else {
            this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        }
        if (this.boxBackgroundMode == 2) {
            updateCutout();
        }
        if (this.boxBackgroundMode == 1) {
            if (!isEnabled()) {
                this.boxBackgroundColor = this.disabledFilledBackgroundColor;
            } else if (z3 && !z2) {
                this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
            } else if (z2) {
                this.boxBackgroundColor = this.focusedFilledBackgroundColor;
            } else {
                this.boxBackgroundColor = this.defaultFilledBackgroundColor;
            }
        }
        applyBoxAttributes();
    }
}
