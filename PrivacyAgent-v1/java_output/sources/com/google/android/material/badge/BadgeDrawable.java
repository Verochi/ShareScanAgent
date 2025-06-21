package com.google.android.material.badge;

/* loaded from: classes22.dex */
public class BadgeDrawable extends android.graphics.drawable.Drawable implements com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate {
    private static final int BADGE_NUMBER_NONE = -1;
    public static final int BOTTOM_END = 8388693;
    public static final int BOTTOM_START = 8388691;
    static final java.lang.String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
    private static final int DEFAULT_MAX_BADGE_CHARACTER_COUNT = 4;

    @androidx.annotation.StyleRes
    private static final int DEFAULT_STYLE = com.google.android.material.R.style.Widget_MaterialComponents_Badge;

    @androidx.annotation.AttrRes
    private static final int DEFAULT_THEME_ATTR = com.google.android.material.R.attr.badgeStyle;
    private static final int MAX_CIRCULAR_BADGE_NUMBER_COUNT = 9;
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;

    @androidx.annotation.Nullable
    private java.lang.ref.WeakReference<android.view.View> anchorViewRef;

    @androidx.annotation.NonNull
    private final android.graphics.Rect badgeBounds;
    private float badgeCenterX;
    private float badgeCenterY;
    private final float badgeRadius;
    private final float badgeWidePadding;
    private final float badgeWithTextRadius;

    @androidx.annotation.NonNull
    private final java.lang.ref.WeakReference<android.content.Context> contextRef;
    private float cornerRadius;

    @androidx.annotation.Nullable
    private java.lang.ref.WeakReference<android.widget.FrameLayout> customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;

    @androidx.annotation.NonNull
    private final com.google.android.material.badge.BadgeDrawable.SavedState savedState;

    @androidx.annotation.NonNull
    private final com.google.android.material.shape.MaterialShapeDrawable shapeDrawable;

    @androidx.annotation.NonNull
    private final com.google.android.material.internal.TextDrawableHelper textDrawableHelper;

    /* renamed from: com.google.android.material.badge.BadgeDrawable$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.view.View val$anchorView;
        final /* synthetic */ android.widget.FrameLayout val$frameLayout;

        public AnonymousClass1(android.view.View view, android.widget.FrameLayout frameLayout) {
            this.val$anchorView = view;
            this.val$frameLayout = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.material.badge.BadgeDrawable.this.updateBadgeCoordinates(this.val$anchorView, this.val$frameLayout);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SavedState implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.google.android.material.badge.BadgeDrawable.SavedState> CREATOR = new com.google.android.material.badge.BadgeDrawable.SavedState.AnonymousClass1();

        @androidx.annotation.Dimension(unit = 1)
        private int additionalHorizontalOffset;

        @androidx.annotation.Dimension(unit = 1)
        private int additionalVerticalOffset;
        private int alpha;

        @androidx.annotation.ColorInt
        private int backgroundColor;
        private int badgeGravity;

        @androidx.annotation.ColorInt
        private int badgeTextColor;

        @androidx.annotation.StringRes
        private int contentDescriptionExceedsMaxBadgeNumberRes;

        @androidx.annotation.Nullable
        private java.lang.CharSequence contentDescriptionNumberless;

        @androidx.annotation.PluralsRes
        private int contentDescriptionQuantityStrings;

        @androidx.annotation.Dimension(unit = 1)
        private int horizontalOffset;
        private boolean isVisible;
        private int maxCharacterCount;
        private int number;

        @androidx.annotation.Dimension(unit = 1)
        private int verticalOffset;

        /* renamed from: com.google.android.material.badge.BadgeDrawable$SavedState$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.material.badge.BadgeDrawable.SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @androidx.annotation.NonNull
            public com.google.android.material.badge.BadgeDrawable.SavedState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
                return new com.google.android.material.badge.BadgeDrawable.SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @androidx.annotation.NonNull
            public com.google.android.material.badge.BadgeDrawable.SavedState[] newArray(int i) {
                return new com.google.android.material.badge.BadgeDrawable.SavedState[i];
            }
        }

        public SavedState(@androidx.annotation.NonNull android.content.Context context) {
            this.alpha = 255;
            this.number = -1;
            this.badgeTextColor = new com.google.android.material.resources.TextAppearance(context, com.google.android.material.R.style.TextAppearance_MaterialComponents_Badge).textColor.getDefaultColor();
            this.contentDescriptionNumberless = context.getString(com.google.android.material.R.string.mtrl_badge_numberless_content_description);
            this.contentDescriptionQuantityStrings = com.google.android.material.R.plurals.mtrl_badge_content_description;
            this.contentDescriptionExceedsMaxBadgeNumberRes = com.google.android.material.R.string.mtrl_exceed_max_badge_number_content_description;
            this.isVisible = true;
        }

        public SavedState(@androidx.annotation.NonNull android.os.Parcel parcel) {
            this.alpha = 255;
            this.number = -1;
            this.backgroundColor = parcel.readInt();
            this.badgeTextColor = parcel.readInt();
            this.alpha = parcel.readInt();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = parcel.readInt();
            this.horizontalOffset = parcel.readInt();
            this.verticalOffset = parcel.readInt();
            this.additionalHorizontalOffset = parcel.readInt();
            this.additionalVerticalOffset = parcel.readInt();
            this.isVisible = parcel.readInt() != 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
            parcel.writeInt(this.backgroundColor);
            parcel.writeInt(this.badgeTextColor);
            parcel.writeInt(this.alpha);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            parcel.writeString(this.contentDescriptionNumberless.toString());
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeInt(this.badgeGravity);
            parcel.writeInt(this.horizontalOffset);
            parcel.writeInt(this.verticalOffset);
            parcel.writeInt(this.additionalHorizontalOffset);
            parcel.writeInt(this.additionalVerticalOffset);
            parcel.writeInt(this.isVisible ? 1 : 0);
        }
    }

    private BadgeDrawable(@androidx.annotation.NonNull android.content.Context context) {
        this.contextRef = new java.lang.ref.WeakReference<>(context);
        com.google.android.material.internal.ThemeEnforcement.checkMaterialTheme(context);
        android.content.res.Resources resources = context.getResources();
        this.badgeBounds = new android.graphics.Rect();
        this.shapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
        this.badgeRadius = resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_badge_radius);
        this.badgeWidePadding = resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.badgeWithTextRadius = resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_badge_with_text_radius);
        com.google.android.material.internal.TextDrawableHelper textDrawableHelper = new com.google.android.material.internal.TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        textDrawableHelper.getTextPaint().setTextAlign(android.graphics.Paint.Align.CENTER);
        this.savedState = new com.google.android.material.badge.BadgeDrawable.SavedState(context);
        setTextAppearanceResource(com.google.android.material.R.style.TextAppearance_MaterialComponents_Badge);
    }

    private void calculateCenterAndBounds(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.graphics.Rect rect, @androidx.annotation.NonNull android.view.View view) {
        int i = this.savedState.verticalOffset + this.savedState.additionalVerticalOffset;
        int i2 = this.savedState.badgeGravity;
        if (i2 == 8388691 || i2 == 8388693) {
            this.badgeCenterY = rect.bottom - i;
        } else {
            this.badgeCenterY = rect.top + i;
        }
        if (getNumber() <= 9) {
            float f = !hasNumber() ? this.badgeRadius : this.badgeWithTextRadius;
            this.cornerRadius = f;
            this.halfBadgeHeight = f;
            this.halfBadgeWidth = f;
        } else {
            float f2 = this.badgeWithTextRadius;
            this.cornerRadius = f2;
            this.halfBadgeHeight = f2;
            this.halfBadgeWidth = (this.textDrawableHelper.getTextWidth(getBadgeText()) / 2.0f) + this.badgeWidePadding;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(hasNumber() ? com.google.android.material.R.dimen.mtrl_badge_text_horizontal_edge_offset : com.google.android.material.R.dimen.mtrl_badge_horizontal_edge_offset);
        int i3 = this.savedState.horizontalOffset + this.savedState.additionalHorizontalOffset;
        int i4 = this.savedState.badgeGravity;
        if (i4 == 8388659 || i4 == 8388691) {
            this.badgeCenterX = androidx.core.view.ViewCompat.getLayoutDirection(view) == 0 ? (rect.left - this.halfBadgeWidth) + dimensionPixelSize + i3 : ((rect.right + this.halfBadgeWidth) - dimensionPixelSize) - i3;
        } else {
            this.badgeCenterX = androidx.core.view.ViewCompat.getLayoutDirection(view) == 0 ? ((rect.right + this.halfBadgeWidth) - dimensionPixelSize) - i3 : (rect.left - this.halfBadgeWidth) + dimensionPixelSize + i3;
        }
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.badge.BadgeDrawable create(@androidx.annotation.NonNull android.content.Context context) {
        return createFromAttributes(context, null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    @androidx.annotation.NonNull
    private static com.google.android.material.badge.BadgeDrawable createFromAttributes(@androidx.annotation.NonNull android.content.Context context, android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2) {
        com.google.android.material.badge.BadgeDrawable badgeDrawable = new com.google.android.material.badge.BadgeDrawable(context);
        badgeDrawable.loadDefaultStateFromAttributes(context, attributeSet, i, i2);
        return badgeDrawable;
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.badge.BadgeDrawable createFromResource(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.XmlRes int i) {
        android.util.AttributeSet parseDrawableXml = com.google.android.material.drawable.DrawableUtils.parseDrawableXml(context, i, "badge");
        int styleAttribute = parseDrawableXml.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = DEFAULT_STYLE;
        }
        return createFromAttributes(context, parseDrawableXml, DEFAULT_THEME_ATTR, styleAttribute);
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.badge.BadgeDrawable createFromSavedState(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.google.android.material.badge.BadgeDrawable.SavedState savedState) {
        com.google.android.material.badge.BadgeDrawable badgeDrawable = new com.google.android.material.badge.BadgeDrawable(context);
        badgeDrawable.restoreFromSavedState(savedState);
        return badgeDrawable;
    }

    private void drawText(android.graphics.Canvas canvas) {
        android.graphics.Rect rect = new android.graphics.Rect();
        java.lang.String badgeText = getBadgeText();
        this.textDrawableHelper.getTextPaint().getTextBounds(badgeText, 0, badgeText.length(), rect);
        canvas.drawText(badgeText, this.badgeCenterX, this.badgeCenterY + (rect.height() / 2), this.textDrawableHelper.getTextPaint());
    }

    @androidx.annotation.NonNull
    private java.lang.String getBadgeText() {
        if (getNumber() <= this.maxBadgeNumber) {
            return java.text.NumberFormat.getInstance().format(getNumber());
        }
        android.content.Context context = this.contextRef.get();
        return context == null ? "" : context.getString(com.google.android.material.R.string.mtrl_exceed_max_badge_number_suffix, java.lang.Integer.valueOf(this.maxBadgeNumber), DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
    }

    private void loadDefaultStateFromAttributes(android.content.Context context, android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2) {
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context, attributeSet, com.google.android.material.R.styleable.Badge, i, i2, new int[0]);
        setMaxCharacterCount(obtainStyledAttributes.getInt(com.google.android.material.R.styleable.Badge_maxCharacterCount, 4));
        int i3 = com.google.android.material.R.styleable.Badge_number;
        if (obtainStyledAttributes.hasValue(i3)) {
            setNumber(obtainStyledAttributes.getInt(i3, 0));
        }
        setBackgroundColor(readColorFromAttributes(context, obtainStyledAttributes, com.google.android.material.R.styleable.Badge_backgroundColor));
        int i4 = com.google.android.material.R.styleable.Badge_badgeTextColor;
        if (obtainStyledAttributes.hasValue(i4)) {
            setBadgeTextColor(readColorFromAttributes(context, obtainStyledAttributes, i4));
        }
        setBadgeGravity(obtainStyledAttributes.getInt(com.google.android.material.R.styleable.Badge_badgeGravity, TOP_END));
        setHorizontalOffset(obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.Badge_horizontalOffset, 0));
        setVerticalOffset(obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.Badge_verticalOffset, 0));
        obtainStyledAttributes.recycle();
    }

    private static int readColorFromAttributes(android.content.Context context, @androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.StyleableRes int i) {
        return com.google.android.material.resources.MaterialResources.getColorStateList(context, typedArray, i).getDefaultColor();
    }

    private void restoreFromSavedState(@androidx.annotation.NonNull com.google.android.material.badge.BadgeDrawable.SavedState savedState) {
        setMaxCharacterCount(savedState.maxCharacterCount);
        if (savedState.number != -1) {
            setNumber(savedState.number);
        }
        setBackgroundColor(savedState.backgroundColor);
        setBadgeTextColor(savedState.badgeTextColor);
        setBadgeGravity(savedState.badgeGravity);
        setHorizontalOffset(savedState.horizontalOffset);
        setVerticalOffset(savedState.verticalOffset);
        setAdditionalHorizontalOffset(savedState.additionalHorizontalOffset);
        setAdditionalVerticalOffset(savedState.additionalVerticalOffset);
        setVisible(savedState.isVisible);
    }

    private void setTextAppearance(@androidx.annotation.Nullable com.google.android.material.resources.TextAppearance textAppearance) {
        android.content.Context context;
        if (this.textDrawableHelper.getTextAppearance() == textAppearance || (context = this.contextRef.get()) == null) {
            return;
        }
        this.textDrawableHelper.setTextAppearance(textAppearance, context);
        updateCenterAndBounds();
    }

    private void setTextAppearanceResource(@androidx.annotation.StyleRes int i) {
        android.content.Context context = this.contextRef.get();
        if (context == null) {
            return;
        }
        setTextAppearance(new com.google.android.material.resources.TextAppearance(context, i));
    }

    private void tryWrapAnchorInCompatParent(android.view.View view) {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != com.google.android.material.R.id.mtrl_anchor_parent) {
            java.lang.ref.WeakReference<android.widget.FrameLayout> weakReference = this.customBadgeParentRef;
            if (weakReference == null || weakReference.get() != viewGroup) {
                updateAnchorParentToNotClip(view);
                android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(view.getContext());
                frameLayout.setId(com.google.android.material.R.id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(indexOfChild);
                view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, indexOfChild);
                this.customBadgeParentRef = new java.lang.ref.WeakReference<>(frameLayout);
                frameLayout.post(new com.google.android.material.badge.BadgeDrawable.AnonymousClass1(view, frameLayout));
            }
        }
    }

    private static void updateAnchorParentToNotClip(android.view.View view) {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void updateCenterAndBounds() {
        android.content.Context context = this.contextRef.get();
        java.lang.ref.WeakReference<android.view.View> weakReference = this.anchorViewRef;
        android.view.View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        rect.set(this.badgeBounds);
        android.graphics.Rect rect2 = new android.graphics.Rect();
        view.getDrawingRect(rect2);
        java.lang.ref.WeakReference<android.widget.FrameLayout> weakReference2 = this.customBadgeParentRef;
        android.widget.FrameLayout frameLayout = weakReference2 != null ? weakReference2.get() : null;
        if (frameLayout != null || com.google.android.material.badge.BadgeUtils.USE_COMPAT_PARENT) {
            if (frameLayout == null) {
                frameLayout = (android.view.ViewGroup) view.getParent();
            }
            frameLayout.offsetDescendantRectToMyCoords(view, rect2);
        }
        calculateCenterAndBounds(context, rect2, view);
        com.google.android.material.badge.BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
        this.shapeDrawable.setCornerSize(this.cornerRadius);
        if (rect.equals(this.badgeBounds)) {
            return;
        }
        this.shapeDrawable.setBounds(this.badgeBounds);
    }

    private void updateMaxBadgeNumber() {
        this.maxBadgeNumber = ((int) java.lang.Math.pow(10.0d, getMaxCharacterCount() - 1.0d)) - 1;
    }

    public void clearNumber() {
        this.savedState.number = -1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.shapeDrawable.draw(canvas);
        if (hasNumber()) {
            drawText(canvas);
        }
    }

    public int getAdditionalHorizontalOffset() {
        return this.savedState.additionalHorizontalOffset;
    }

    public int getAdditionalVerticalOffset() {
        return this.savedState.additionalVerticalOffset;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.savedState.alpha;
    }

    @androidx.annotation.ColorInt
    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    public int getBadgeGravity() {
        return this.savedState.badgeGravity;
    }

    @androidx.annotation.ColorInt
    public int getBadgeTextColor() {
        return this.textDrawableHelper.getTextPaint().getColor();
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getContentDescription() {
        android.content.Context context;
        if (!isVisible()) {
            return null;
        }
        if (!hasNumber()) {
            return this.savedState.contentDescriptionNumberless;
        }
        if (this.savedState.contentDescriptionQuantityStrings <= 0 || (context = this.contextRef.get()) == null) {
            return null;
        }
        return getNumber() <= this.maxBadgeNumber ? context.getResources().getQuantityString(this.savedState.contentDescriptionQuantityStrings, getNumber(), java.lang.Integer.valueOf(getNumber())) : context.getString(this.savedState.contentDescriptionExceedsMaxBadgeNumberRes, java.lang.Integer.valueOf(this.maxBadgeNumber));
    }

    @androidx.annotation.Nullable
    public android.widget.FrameLayout getCustomBadgeParent() {
        java.lang.ref.WeakReference<android.widget.FrameLayout> weakReference = this.customBadgeParentRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getHorizontalOffset() {
        return this.savedState.horizontalOffset;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    public int getMaxCharacterCount() {
        return this.savedState.maxCharacterCount;
    }

    public int getNumber() {
        if (hasNumber()) {
            return this.savedState.number;
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.badge.BadgeDrawable.SavedState getSavedState() {
        return this.savedState;
    }

    public int getVerticalOffset() {
        return this.savedState.verticalOffset;
    }

    public boolean hasNumber() {
        return this.savedState.number != -1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void onTextSizeChange() {
        invalidateSelf();
    }

    public void setAdditionalHorizontalOffset(int i) {
        this.savedState.additionalHorizontalOffset = i;
        updateCenterAndBounds();
    }

    public void setAdditionalVerticalOffset(int i) {
        this.savedState.additionalVerticalOffset = i;
        updateCenterAndBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.savedState.alpha = i;
        this.textDrawableHelper.getTextPaint().setAlpha(i);
        invalidateSelf();
    }

    public void setBackgroundColor(@androidx.annotation.ColorInt int i) {
        this.savedState.backgroundColor = i;
        android.content.res.ColorStateList valueOf = android.content.res.ColorStateList.valueOf(i);
        if (this.shapeDrawable.getFillColor() != valueOf) {
            this.shapeDrawable.setFillColor(valueOf);
            invalidateSelf();
        }
    }

    public void setBadgeGravity(int i) {
        if (this.savedState.badgeGravity != i) {
            this.savedState.badgeGravity = i;
            java.lang.ref.WeakReference<android.view.View> weakReference = this.anchorViewRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            android.view.View view = this.anchorViewRef.get();
            java.lang.ref.WeakReference<android.widget.FrameLayout> weakReference2 = this.customBadgeParentRef;
            updateBadgeCoordinates(view, weakReference2 != null ? weakReference2.get() : null);
        }
    }

    public void setBadgeTextColor(@androidx.annotation.ColorInt int i) {
        this.savedState.badgeTextColor = i;
        if (this.textDrawableHelper.getTextPaint().getColor() != i) {
            this.textDrawableHelper.getTextPaint().setColor(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(@androidx.annotation.StringRes int i) {
        this.savedState.contentDescriptionExceedsMaxBadgeNumberRes = i;
    }

    public void setContentDescriptionNumberless(java.lang.CharSequence charSequence) {
        this.savedState.contentDescriptionNumberless = charSequence;
    }

    public void setContentDescriptionQuantityStringsResource(@androidx.annotation.PluralsRes int i) {
        this.savedState.contentDescriptionQuantityStrings = i;
    }

    public void setHorizontalOffset(int i) {
        this.savedState.horizontalOffset = i;
        updateCenterAndBounds();
    }

    public void setMaxCharacterCount(int i) {
        if (this.savedState.maxCharacterCount != i) {
            this.savedState.maxCharacterCount = i;
            updateMaxBadgeNumber();
            this.textDrawableHelper.setTextWidthDirty(true);
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    public void setNumber(int i) {
        int max = java.lang.Math.max(0, i);
        if (this.savedState.number != max) {
            this.savedState.number = max;
            this.textDrawableHelper.setTextWidthDirty(true);
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    public void setVerticalOffset(int i) {
        this.savedState.verticalOffset = i;
        updateCenterAndBounds();
    }

    public void setVisible(boolean z) {
        setVisible(z, false);
        this.savedState.isVisible = z;
        if (!com.google.android.material.badge.BadgeUtils.USE_COMPAT_PARENT || getCustomBadgeParent() == null || z) {
            return;
        }
        ((android.view.ViewGroup) getCustomBadgeParent().getParent()).invalidate();
    }

    public void updateBadgeCoordinates(@androidx.annotation.NonNull android.view.View view) {
        updateBadgeCoordinates(view, (android.widget.FrameLayout) null);
    }

    @java.lang.Deprecated
    public void updateBadgeCoordinates(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.view.ViewGroup viewGroup) {
        if (!(viewGroup instanceof android.widget.FrameLayout)) {
            throw new java.lang.IllegalArgumentException("customBadgeParent must be a FrameLayout");
        }
        updateBadgeCoordinates(view, (android.widget.FrameLayout) viewGroup);
    }

    public void updateBadgeCoordinates(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.widget.FrameLayout frameLayout) {
        this.anchorViewRef = new java.lang.ref.WeakReference<>(view);
        boolean z = com.google.android.material.badge.BadgeUtils.USE_COMPAT_PARENT;
        if (z && frameLayout == null) {
            tryWrapAnchorInCompatParent(view);
        } else {
            this.customBadgeParentRef = new java.lang.ref.WeakReference<>(frameLayout);
        }
        if (!z) {
            updateAnchorParentToNotClip(view);
        }
        updateCenterAndBounds();
        invalidateSelf();
    }
}
