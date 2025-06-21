package androidx.appcompat.widget;

/* loaded from: classes.dex */
class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    private boolean mAsyncFontPending;

    @androidx.annotation.NonNull
    private final androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private androidx.appcompat.widget.TintInfo mDrawableBottomTint;
    private androidx.appcompat.widget.TintInfo mDrawableEndTint;
    private androidx.appcompat.widget.TintInfo mDrawableLeftTint;
    private androidx.appcompat.widget.TintInfo mDrawableRightTint;
    private androidx.appcompat.widget.TintInfo mDrawableStartTint;
    private androidx.appcompat.widget.TintInfo mDrawableTint;
    private androidx.appcompat.widget.TintInfo mDrawableTopTint;
    private android.graphics.Typeface mFontTypeface;

    @androidx.annotation.NonNull
    private final android.widget.TextView mView;
    private int mStyle = 0;
    private int mFontWeight = -1;

    /* renamed from: androidx.appcompat.widget.AppCompatTextHelper$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.core.content.res.ResourcesCompat.FontCallback {
        final /* synthetic */ int val$fontWeight;
        final /* synthetic */ int val$style;
        final /* synthetic */ java.lang.ref.WeakReference val$textViewWeak;

        public AnonymousClass1(int i, int i2, java.lang.ref.WeakReference weakReference) {
            this.val$fontWeight = i;
            this.val$style = i2;
            this.val$textViewWeak = weakReference;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrievalFailed(int i) {
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrieved(@androidx.annotation.NonNull android.graphics.Typeface typeface) {
            int i;
            if (android.os.Build.VERSION.SDK_INT >= 28 && (i = this.val$fontWeight) != -1) {
                typeface = android.graphics.Typeface.create(typeface, i, (this.val$style & 2) != 0);
            }
            androidx.appcompat.widget.AppCompatTextHelper.this.onAsyncTypefaceReceived(this.val$textViewWeak, typeface);
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatTextHelper$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ int val$style;
        final /* synthetic */ android.widget.TextView val$textView;
        final /* synthetic */ android.graphics.Typeface val$typeface;

        public AnonymousClass2(android.widget.TextView textView, android.graphics.Typeface typeface, int i) {
            this.val$textView = textView;
            this.val$typeface = typeface;
            this.val$style = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$textView.setTypeface(this.val$typeface, this.val$style);
        }
    }

    public AppCompatTextHelper(@androidx.annotation.NonNull android.widget.TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper(textView);
    }

    private void applyCompoundDrawableTint(android.graphics.drawable.Drawable drawable, androidx.appcompat.widget.TintInfo tintInfo) {
        if (drawable == null || tintInfo == null) {
            return;
        }
        androidx.appcompat.widget.AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
    }

    private static androidx.appcompat.widget.TintInfo createTintInfo(android.content.Context context, androidx.appcompat.widget.AppCompatDrawableManager appCompatDrawableManager, int i) {
        android.content.res.ColorStateList tintList = appCompatDrawableManager.getTintList(context, i);
        if (tintList == null) {
            return null;
        }
        androidx.appcompat.widget.TintInfo tintInfo = new androidx.appcompat.widget.TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = tintList;
        return tintInfo;
    }

    private void setCompoundDrawables(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2, android.graphics.drawable.Drawable drawable3, android.graphics.drawable.Drawable drawable4, android.graphics.drawable.Drawable drawable5, android.graphics.drawable.Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            android.graphics.drawable.Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
            android.widget.TextView textView = this.mView;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        android.graphics.drawable.Drawable[] compoundDrawablesRelative2 = this.mView.getCompoundDrawablesRelative();
        android.graphics.drawable.Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            android.widget.TextView textView2 = this.mView;
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            android.graphics.drawable.Drawable drawable8 = compoundDrawablesRelative2[2];
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
            return;
        }
        android.graphics.drawable.Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
        android.widget.TextView textView3 = this.mView;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void setCompoundTints() {
        androidx.appcompat.widget.TintInfo tintInfo = this.mDrawableTint;
        this.mDrawableLeftTint = tintInfo;
        this.mDrawableTopTint = tintInfo;
        this.mDrawableRightTint = tintInfo;
        this.mDrawableBottomTint = tintInfo;
        this.mDrawableStartTint = tintInfo;
        this.mDrawableEndTint = tintInfo;
    }

    private void setTextSizeInternal(int i, float f) {
        this.mAutoSizeTextHelper.setTextSizeInternal(i, f);
    }

    private void updateTypefaceAndStyle(android.content.Context context, androidx.appcompat.widget.TintTypedArray tintTypedArray) {
        java.lang.String string;
        android.graphics.Typeface create;
        android.graphics.Typeface create2;
        this.mStyle = tintTypedArray.getInt(androidx.appcompat.R.styleable.TextAppearance_android_textStyle, this.mStyle);
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 28) {
            int i2 = tintTypedArray.getInt(androidx.appcompat.R.styleable.TextAppearance_android_textFontWeight, -1);
            this.mFontWeight = i2;
            if (i2 != -1) {
                this.mStyle = (this.mStyle & 2) | 0;
            }
        }
        int i3 = androidx.appcompat.R.styleable.TextAppearance_android_fontFamily;
        if (!tintTypedArray.hasValue(i3) && !tintTypedArray.hasValue(androidx.appcompat.R.styleable.TextAppearance_fontFamily)) {
            int i4 = androidx.appcompat.R.styleable.TextAppearance_android_typeface;
            if (tintTypedArray.hasValue(i4)) {
                this.mAsyncFontPending = false;
                int i5 = tintTypedArray.getInt(i4, 1);
                if (i5 == 1) {
                    this.mFontTypeface = android.graphics.Typeface.SANS_SERIF;
                    return;
                } else if (i5 == 2) {
                    this.mFontTypeface = android.graphics.Typeface.SERIF;
                    return;
                } else {
                    if (i5 != 3) {
                        return;
                    }
                    this.mFontTypeface = android.graphics.Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.mFontTypeface = null;
        int i6 = androidx.appcompat.R.styleable.TextAppearance_fontFamily;
        if (tintTypedArray.hasValue(i6)) {
            i3 = i6;
        }
        int i7 = this.mFontWeight;
        int i8 = this.mStyle;
        if (!context.isRestricted()) {
            try {
                android.graphics.Typeface font = tintTypedArray.getFont(i3, this.mStyle, new androidx.appcompat.widget.AppCompatTextHelper.AnonymousClass1(i7, i8, new java.lang.ref.WeakReference(this.mView)));
                if (font != null) {
                    if (i < 28 || this.mFontWeight == -1) {
                        this.mFontTypeface = font;
                    } else {
                        create2 = android.graphics.Typeface.create(android.graphics.Typeface.create(font, 0), this.mFontWeight, (this.mStyle & 2) != 0);
                        this.mFontTypeface = create2;
                    }
                }
                this.mAsyncFontPending = this.mFontTypeface == null;
            } catch (android.content.res.Resources.NotFoundException | java.lang.UnsupportedOperationException unused) {
            }
        }
        if (this.mFontTypeface != null || (string = tintTypedArray.getString(i3)) == null) {
            return;
        }
        if (android.os.Build.VERSION.SDK_INT < 28 || this.mFontWeight == -1) {
            this.mFontTypeface = android.graphics.Typeface.create(string, this.mStyle);
        } else {
            create = android.graphics.Typeface.create(android.graphics.Typeface.create(string, 0), this.mFontWeight, (this.mStyle & 2) != 0);
            this.mFontTypeface = create;
        }
    }

    public void applyCompoundDrawablesTints() {
        if (this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
            android.graphics.drawable.Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
        if (this.mDrawableStartTint == null && this.mDrawableEndTint == null) {
            return;
        }
        android.graphics.drawable.Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
        applyCompoundDrawableTint(compoundDrawablesRelative[0], this.mDrawableStartTint);
        applyCompoundDrawableTint(compoundDrawablesRelative[2], this.mDrawableEndTint);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    public int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    public int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    public int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    public int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getCompoundDrawableTintList() {
        androidx.appcompat.widget.TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    @androidx.annotation.Nullable
    public android.graphics.PorterDuff.Mode getCompoundDrawableTintMode() {
        androidx.appcompat.widget.TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e5  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadFromAttributes(@androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        java.lang.String str;
        android.content.res.ColorStateList colorStateList;
        java.lang.String str2;
        boolean z;
        android.content.res.ColorStateList colorStateList2;
        android.content.res.ColorStateList colorStateList3;
        boolean z2;
        java.lang.String str3;
        int i2;
        int i3;
        java.lang.String str4;
        androidx.appcompat.widget.AppCompatDrawableManager appCompatDrawableManager;
        android.graphics.Typeface typeface;
        androidx.appcompat.widget.TintTypedArray obtainStyledAttributes;
        int i4;
        int i5;
        int i6;
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int dimensionPixelSize3;
        int[] autoSizeTextAvailableSizes;
        int autoSizeStepGranularity;
        android.os.LocaleList forLanguageTags;
        android.content.Context context = this.mView.getContext();
        androidx.appcompat.widget.AppCompatDrawableManager appCompatDrawableManager2 = androidx.appcompat.widget.AppCompatDrawableManager.get();
        int[] iArr = androidx.appcompat.R.styleable.AppCompatTextHelper;
        androidx.appcompat.widget.TintTypedArray obtainStyledAttributes2 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        android.widget.TextView textView = this.mView;
        androidx.core.view.ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes2.getWrappedTypeArray(), i, 0);
        int resourceId = obtainStyledAttributes2.getResourceId(androidx.appcompat.R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        int i7 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableLeft;
        if (obtainStyledAttributes2.hasValue(i7)) {
            this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager2, obtainStyledAttributes2.getResourceId(i7, 0));
        }
        int i8 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableTop;
        if (obtainStyledAttributes2.hasValue(i8)) {
            this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager2, obtainStyledAttributes2.getResourceId(i8, 0));
        }
        int i9 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableRight;
        if (obtainStyledAttributes2.hasValue(i9)) {
            this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager2, obtainStyledAttributes2.getResourceId(i9, 0));
        }
        int i10 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableBottom;
        if (obtainStyledAttributes2.hasValue(i10)) {
            this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager2, obtainStyledAttributes2.getResourceId(i10, 0));
        }
        int i11 = android.os.Build.VERSION.SDK_INT;
        int i12 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableStart;
        if (obtainStyledAttributes2.hasValue(i12)) {
            this.mDrawableStartTint = createTintInfo(context, appCompatDrawableManager2, obtainStyledAttributes2.getResourceId(i12, 0));
        }
        int i13 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableEnd;
        if (obtainStyledAttributes2.hasValue(i13)) {
            this.mDrawableEndTint = createTintInfo(context, appCompatDrawableManager2, obtainStyledAttributes2.getResourceId(i13, 0));
        }
        obtainStyledAttributes2.recycle();
        boolean z3 = this.mView.getTransformationMethod() instanceof android.text.method.PasswordTransformationMethod;
        if (resourceId != -1) {
            androidx.appcompat.widget.TintTypedArray obtainStyledAttributes3 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, resourceId, androidx.appcompat.R.styleable.TextAppearance);
            if (!z3) {
                int i14 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps;
                if (obtainStyledAttributes3.hasValue(i14)) {
                    z = obtainStyledAttributes3.getBoolean(i14, false);
                    z2 = true;
                    updateTypefaceAndStyle(context, obtainStyledAttributes3);
                    if (i11 >= 23) {
                        int i15 = androidx.appcompat.R.styleable.TextAppearance_android_textColor;
                        colorStateList = obtainStyledAttributes3.hasValue(i15) ? obtainStyledAttributes3.getColorStateList(i15) : null;
                        int i16 = androidx.appcompat.R.styleable.TextAppearance_android_textColorHint;
                        colorStateList2 = obtainStyledAttributes3.hasValue(i16) ? obtainStyledAttributes3.getColorStateList(i16) : null;
                        int i17 = androidx.appcompat.R.styleable.TextAppearance_android_textColorLink;
                        if (obtainStyledAttributes3.hasValue(i17)) {
                            colorStateList3 = obtainStyledAttributes3.getColorStateList(i17);
                            int i18 = androidx.appcompat.R.styleable.TextAppearance_textLocale;
                            str2 = obtainStyledAttributes3.hasValue(i18) ? obtainStyledAttributes3.getString(i18) : null;
                            if (i11 >= 26) {
                                int i19 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings;
                                if (obtainStyledAttributes3.hasValue(i19)) {
                                    str = obtainStyledAttributes3.getString(i19);
                                    obtainStyledAttributes3.recycle();
                                }
                            }
                            str = null;
                            obtainStyledAttributes3.recycle();
                        }
                    } else {
                        colorStateList = null;
                        colorStateList2 = null;
                    }
                    colorStateList3 = null;
                    int i182 = androidx.appcompat.R.styleable.TextAppearance_textLocale;
                    if (obtainStyledAttributes3.hasValue(i182)) {
                    }
                    if (i11 >= 26) {
                    }
                    str = null;
                    obtainStyledAttributes3.recycle();
                }
            }
            z = false;
            z2 = false;
            updateTypefaceAndStyle(context, obtainStyledAttributes3);
            if (i11 >= 23) {
            }
            colorStateList3 = null;
            int i1822 = androidx.appcompat.R.styleable.TextAppearance_textLocale;
            if (obtainStyledAttributes3.hasValue(i1822)) {
            }
            if (i11 >= 26) {
            }
            str = null;
            obtainStyledAttributes3.recycle();
        } else {
            str = null;
            colorStateList = null;
            str2 = null;
            z = false;
            colorStateList2 = null;
            colorStateList3 = null;
            z2 = false;
        }
        androidx.appcompat.widget.TintTypedArray obtainStyledAttributes4 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, androidx.appcompat.R.styleable.TextAppearance, i, 0);
        if (!z3) {
            int i20 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps;
            if (obtainStyledAttributes4.hasValue(i20)) {
                str3 = str;
                z = obtainStyledAttributes4.getBoolean(i20, false);
                i2 = 23;
                z2 = true;
                if (i11 < i2) {
                    int i21 = androidx.appcompat.R.styleable.TextAppearance_android_textColor;
                    if (obtainStyledAttributes4.hasValue(i21)) {
                        colorStateList = obtainStyledAttributes4.getColorStateList(i21);
                    }
                    int i22 = androidx.appcompat.R.styleable.TextAppearance_android_textColorHint;
                    if (obtainStyledAttributes4.hasValue(i22)) {
                        colorStateList2 = obtainStyledAttributes4.getColorStateList(i22);
                    }
                    int i23 = androidx.appcompat.R.styleable.TextAppearance_android_textColorLink;
                    if (obtainStyledAttributes4.hasValue(i23)) {
                        colorStateList3 = obtainStyledAttributes4.getColorStateList(i23);
                    }
                }
                i3 = androidx.appcompat.R.styleable.TextAppearance_textLocale;
                if (obtainStyledAttributes4.hasValue(i3)) {
                    str2 = obtainStyledAttributes4.getString(i3);
                }
                if (i11 >= 26) {
                    int i24 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings;
                    if (obtainStyledAttributes4.hasValue(i24)) {
                        str4 = obtainStyledAttributes4.getString(i24);
                        if (i11 >= 28) {
                            int i25 = androidx.appcompat.R.styleable.TextAppearance_android_textSize;
                            if (obtainStyledAttributes4.hasValue(i25)) {
                                appCompatDrawableManager = appCompatDrawableManager2;
                                if (obtainStyledAttributes4.getDimensionPixelSize(i25, -1) == 0) {
                                    this.mView.setTextSize(0, 0.0f);
                                }
                                updateTypefaceAndStyle(context, obtainStyledAttributes4);
                                obtainStyledAttributes4.recycle();
                                if (colorStateList != null) {
                                    this.mView.setTextColor(colorStateList);
                                }
                                if (colorStateList2 != null) {
                                    this.mView.setHintTextColor(colorStateList2);
                                }
                                if (colorStateList3 != null) {
                                    this.mView.setLinkTextColor(colorStateList3);
                                }
                                if (!z3 && z2) {
                                    setAllCaps(z);
                                }
                                typeface = this.mFontTypeface;
                                if (typeface != null) {
                                    if (this.mFontWeight == -1) {
                                        this.mView.setTypeface(typeface, this.mStyle);
                                    } else {
                                        this.mView.setTypeface(typeface);
                                    }
                                }
                                if (str4 != null) {
                                    this.mView.setFontVariationSettings(str4);
                                }
                                if (str2 != null) {
                                    if (i11 >= 24) {
                                        android.widget.TextView textView2 = this.mView;
                                        forLanguageTags = android.os.LocaleList.forLanguageTags(str2);
                                        textView2.setTextLocales(forLanguageTags);
                                    } else {
                                        this.mView.setTextLocale(java.util.Locale.forLanguageTag(str2.substring(0, str2.indexOf(44))));
                                    }
                                }
                                this.mAutoSizeTextHelper.loadFromAttributes(attributeSet, i);
                                if (androidx.core.widget.AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && this.mAutoSizeTextHelper.getAutoSizeTextType() != 0) {
                                    autoSizeTextAvailableSizes = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
                                    if (autoSizeTextAvailableSizes.length > 0) {
                                        autoSizeStepGranularity = this.mView.getAutoSizeStepGranularity();
                                        if (autoSizeStepGranularity != -1.0f) {
                                            this.mView.setAutoSizeTextTypeUniformWithConfiguration(this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
                                        } else {
                                            this.mView.setAutoSizeTextTypeUniformWithPresetSizes(autoSizeTextAvailableSizes, 0);
                                        }
                                    }
                                }
                                obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, androidx.appcompat.R.styleable.AppCompatTextView);
                                int resourceId2 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableLeftCompat, -1);
                                androidx.appcompat.widget.AppCompatDrawableManager appCompatDrawableManager3 = appCompatDrawableManager;
                                android.graphics.drawable.Drawable drawable = resourceId2 == -1 ? appCompatDrawableManager3.getDrawable(context, resourceId2) : null;
                                int resourceId3 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableTopCompat, -1);
                                android.graphics.drawable.Drawable drawable2 = resourceId3 == -1 ? appCompatDrawableManager3.getDrawable(context, resourceId3) : null;
                                int resourceId4 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableRightCompat, -1);
                                android.graphics.drawable.Drawable drawable3 = resourceId4 == -1 ? appCompatDrawableManager3.getDrawable(context, resourceId4) : null;
                                int resourceId5 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableBottomCompat, -1);
                                android.graphics.drawable.Drawable drawable4 = resourceId5 == -1 ? appCompatDrawableManager3.getDrawable(context, resourceId5) : null;
                                int resourceId6 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableStartCompat, -1);
                                android.graphics.drawable.Drawable drawable5 = resourceId6 == -1 ? appCompatDrawableManager3.getDrawable(context, resourceId6) : null;
                                int resourceId7 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableEndCompat, -1);
                                setCompoundDrawables(drawable, drawable2, drawable3, drawable4, drawable5, resourceId7 == -1 ? appCompatDrawableManager3.getDrawable(context, resourceId7) : null);
                                i4 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTint;
                                if (obtainStyledAttributes.hasValue(i4)) {
                                    androidx.core.widget.TextViewCompat.setCompoundDrawableTintList(this.mView, obtainStyledAttributes.getColorStateList(i4));
                                }
                                i5 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTintMode;
                                if (obtainStyledAttributes.hasValue(i5)) {
                                    i6 = -1;
                                } else {
                                    i6 = -1;
                                    androidx.core.widget.TextViewCompat.setCompoundDrawableTintMode(this.mView, androidx.appcompat.widget.DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i5, -1), null));
                                }
                                dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.AppCompatTextView_firstBaselineToTopHeight, i6);
                                dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.AppCompatTextView_lastBaselineToBottomHeight, i6);
                                dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.AppCompatTextView_lineHeight, i6);
                                obtainStyledAttributes.recycle();
                                if (dimensionPixelSize != i6) {
                                    androidx.core.widget.TextViewCompat.setFirstBaselineToTopHeight(this.mView, dimensionPixelSize);
                                }
                                if (dimensionPixelSize2 != i6) {
                                    androidx.core.widget.TextViewCompat.setLastBaselineToBottomHeight(this.mView, dimensionPixelSize2);
                                }
                                if (dimensionPixelSize3 == i6) {
                                    androidx.core.widget.TextViewCompat.setLineHeight(this.mView, dimensionPixelSize3);
                                    return;
                                }
                                return;
                            }
                        }
                        appCompatDrawableManager = appCompatDrawableManager2;
                        updateTypefaceAndStyle(context, obtainStyledAttributes4);
                        obtainStyledAttributes4.recycle();
                        if (colorStateList != null) {
                        }
                        if (colorStateList2 != null) {
                        }
                        if (colorStateList3 != null) {
                        }
                        if (!z3) {
                            setAllCaps(z);
                        }
                        typeface = this.mFontTypeface;
                        if (typeface != null) {
                        }
                        if (str4 != null) {
                        }
                        if (str2 != null) {
                        }
                        this.mAutoSizeTextHelper.loadFromAttributes(attributeSet, i);
                        if (androidx.core.widget.AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                            autoSizeTextAvailableSizes = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
                            if (autoSizeTextAvailableSizes.length > 0) {
                            }
                        }
                        obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, androidx.appcompat.R.styleable.AppCompatTextView);
                        int resourceId22 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableLeftCompat, -1);
                        androidx.appcompat.widget.AppCompatDrawableManager appCompatDrawableManager32 = appCompatDrawableManager;
                        if (resourceId22 == -1) {
                        }
                        int resourceId32 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableTopCompat, -1);
                        if (resourceId32 == -1) {
                        }
                        int resourceId42 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableRightCompat, -1);
                        if (resourceId42 == -1) {
                        }
                        int resourceId52 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableBottomCompat, -1);
                        if (resourceId52 == -1) {
                        }
                        int resourceId62 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableStartCompat, -1);
                        if (resourceId62 == -1) {
                        }
                        int resourceId72 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableEndCompat, -1);
                        setCompoundDrawables(drawable, drawable2, drawable3, drawable4, drawable5, resourceId72 == -1 ? appCompatDrawableManager32.getDrawable(context, resourceId72) : null);
                        i4 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTint;
                        if (obtainStyledAttributes.hasValue(i4)) {
                        }
                        i5 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTintMode;
                        if (obtainStyledAttributes.hasValue(i5)) {
                        }
                        dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.AppCompatTextView_firstBaselineToTopHeight, i6);
                        dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.AppCompatTextView_lastBaselineToBottomHeight, i6);
                        dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.AppCompatTextView_lineHeight, i6);
                        obtainStyledAttributes.recycle();
                        if (dimensionPixelSize != i6) {
                        }
                        if (dimensionPixelSize2 != i6) {
                        }
                        if (dimensionPixelSize3 == i6) {
                        }
                    }
                }
                str4 = str3;
                if (i11 >= 28) {
                }
                appCompatDrawableManager = appCompatDrawableManager2;
                updateTypefaceAndStyle(context, obtainStyledAttributes4);
                obtainStyledAttributes4.recycle();
                if (colorStateList != null) {
                }
                if (colorStateList2 != null) {
                }
                if (colorStateList3 != null) {
                }
                if (!z3) {
                }
                typeface = this.mFontTypeface;
                if (typeface != null) {
                }
                if (str4 != null) {
                }
                if (str2 != null) {
                }
                this.mAutoSizeTextHelper.loadFromAttributes(attributeSet, i);
                if (androidx.core.widget.AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                }
                obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, androidx.appcompat.R.styleable.AppCompatTextView);
                int resourceId222 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableLeftCompat, -1);
                androidx.appcompat.widget.AppCompatDrawableManager appCompatDrawableManager322 = appCompatDrawableManager;
                if (resourceId222 == -1) {
                }
                int resourceId322 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableTopCompat, -1);
                if (resourceId322 == -1) {
                }
                int resourceId422 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableRightCompat, -1);
                if (resourceId422 == -1) {
                }
                int resourceId522 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableBottomCompat, -1);
                if (resourceId522 == -1) {
                }
                int resourceId622 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableStartCompat, -1);
                if (resourceId622 == -1) {
                }
                int resourceId722 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableEndCompat, -1);
                setCompoundDrawables(drawable, drawable2, drawable3, drawable4, drawable5, resourceId722 == -1 ? appCompatDrawableManager322.getDrawable(context, resourceId722) : null);
                i4 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTint;
                if (obtainStyledAttributes.hasValue(i4)) {
                }
                i5 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTintMode;
                if (obtainStyledAttributes.hasValue(i5)) {
                }
                dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.AppCompatTextView_firstBaselineToTopHeight, i6);
                dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.AppCompatTextView_lastBaselineToBottomHeight, i6);
                dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.AppCompatTextView_lineHeight, i6);
                obtainStyledAttributes.recycle();
                if (dimensionPixelSize != i6) {
                }
                if (dimensionPixelSize2 != i6) {
                }
                if (dimensionPixelSize3 == i6) {
                }
            }
        }
        str3 = str;
        i2 = 23;
        if (i11 < i2) {
        }
        i3 = androidx.appcompat.R.styleable.TextAppearance_textLocale;
        if (obtainStyledAttributes4.hasValue(i3)) {
        }
        if (i11 >= 26) {
        }
        str4 = str3;
        if (i11 >= 28) {
        }
        appCompatDrawableManager = appCompatDrawableManager2;
        updateTypefaceAndStyle(context, obtainStyledAttributes4);
        obtainStyledAttributes4.recycle();
        if (colorStateList != null) {
        }
        if (colorStateList2 != null) {
        }
        if (colorStateList3 != null) {
        }
        if (!z3) {
        }
        typeface = this.mFontTypeface;
        if (typeface != null) {
        }
        if (str4 != null) {
        }
        if (str2 != null) {
        }
        this.mAutoSizeTextHelper.loadFromAttributes(attributeSet, i);
        if (androidx.core.widget.AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
        }
        obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, androidx.appcompat.R.styleable.AppCompatTextView);
        int resourceId2222 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableLeftCompat, -1);
        androidx.appcompat.widget.AppCompatDrawableManager appCompatDrawableManager3222 = appCompatDrawableManager;
        if (resourceId2222 == -1) {
        }
        int resourceId3222 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableTopCompat, -1);
        if (resourceId3222 == -1) {
        }
        int resourceId4222 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableRightCompat, -1);
        if (resourceId4222 == -1) {
        }
        int resourceId5222 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        if (resourceId5222 == -1) {
        }
        int resourceId6222 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableStartCompat, -1);
        if (resourceId6222 == -1) {
        }
        int resourceId7222 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTextView_drawableEndCompat, -1);
        setCompoundDrawables(drawable, drawable2, drawable3, drawable4, drawable5, resourceId7222 == -1 ? appCompatDrawableManager3222.getDrawable(context, resourceId7222) : null);
        i4 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTint;
        if (obtainStyledAttributes.hasValue(i4)) {
        }
        i5 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTintMode;
        if (obtainStyledAttributes.hasValue(i5)) {
        }
        dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.AppCompatTextView_firstBaselineToTopHeight, i6);
        dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.AppCompatTextView_lastBaselineToBottomHeight, i6);
        dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.AppCompatTextView_lineHeight, i6);
        obtainStyledAttributes.recycle();
        if (dimensionPixelSize != i6) {
        }
        if (dimensionPixelSize2 != i6) {
        }
        if (dimensionPixelSize3 == i6) {
        }
    }

    public void onAsyncTypefaceReceived(java.lang.ref.WeakReference<android.widget.TextView> weakReference, android.graphics.Typeface typeface) {
        if (this.mAsyncFontPending) {
            this.mFontTypeface = typeface;
            android.widget.TextView textView = weakReference.get();
            if (textView != null) {
                if (androidx.core.view.ViewCompat.isAttachedToWindow(textView)) {
                    textView.post(new androidx.appcompat.widget.AppCompatTextHelper.AnonymousClass2(textView, typeface, this.mStyle));
                } else {
                    textView.setTypeface(typeface, this.mStyle);
                }
            }
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (androidx.core.widget.AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            return;
        }
        autoSizeText();
    }

    public void onSetCompoundDrawables() {
        applyCompoundDrawablesTints();
    }

    public void onSetTextAppearance(android.content.Context context, int i) {
        java.lang.String string;
        android.content.res.ColorStateList colorStateList;
        android.content.res.ColorStateList colorStateList2;
        android.content.res.ColorStateList colorStateList3;
        androidx.appcompat.widget.TintTypedArray obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, i, androidx.appcompat.R.styleable.TextAppearance);
        int i2 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps;
        if (obtainStyledAttributes.hasValue(i2)) {
            setAllCaps(obtainStyledAttributes.getBoolean(i2, false));
        }
        int i3 = android.os.Build.VERSION.SDK_INT;
        if (i3 < 23) {
            int i4 = androidx.appcompat.R.styleable.TextAppearance_android_textColor;
            if (obtainStyledAttributes.hasValue(i4) && (colorStateList3 = obtainStyledAttributes.getColorStateList(i4)) != null) {
                this.mView.setTextColor(colorStateList3);
            }
            int i5 = androidx.appcompat.R.styleable.TextAppearance_android_textColorLink;
            if (obtainStyledAttributes.hasValue(i5) && (colorStateList2 = obtainStyledAttributes.getColorStateList(i5)) != null) {
                this.mView.setLinkTextColor(colorStateList2);
            }
            int i6 = androidx.appcompat.R.styleable.TextAppearance_android_textColorHint;
            if (obtainStyledAttributes.hasValue(i6) && (colorStateList = obtainStyledAttributes.getColorStateList(i6)) != null) {
                this.mView.setHintTextColor(colorStateList);
            }
        }
        int i7 = androidx.appcompat.R.styleable.TextAppearance_android_textSize;
        if (obtainStyledAttributes.hasValue(i7) && obtainStyledAttributes.getDimensionPixelSize(i7, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, obtainStyledAttributes);
        if (i3 >= 26) {
            int i8 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings;
            if (obtainStyledAttributes.hasValue(i8) && (string = obtainStyledAttributes.getString(i8)) != null) {
                this.mView.setFontVariationSettings(string);
            }
        }
        obtainStyledAttributes.recycle();
        android.graphics.Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            this.mView.setTypeface(typeface, this.mStyle);
        }
    }

    public void populateSurroundingTextIfNeeded(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.Nullable android.view.inputmethod.InputConnection inputConnection, @androidx.annotation.NonNull android.view.inputmethod.EditorInfo editorInfo) {
        if (android.os.Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        androidx.core.view.inputmethod.EditorInfoCompat.setInitialSurroundingText(editorInfo, textView.getText());
    }

    public void setAllCaps(boolean z) {
        this.mView.setAllCaps(z);
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws java.lang.IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(@androidx.annotation.NonNull int[] iArr, int i) throws java.lang.IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(i);
    }

    public void setCompoundDrawableTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new androidx.appcompat.widget.TintInfo();
        }
        androidx.appcompat.widget.TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = colorStateList != null;
        setCompoundTints();
    }

    public void setCompoundDrawableTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new androidx.appcompat.widget.TintInfo();
        }
        androidx.appcompat.widget.TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = mode != null;
        setCompoundTints();
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setTextSize(int i, float f) {
        if (androidx.core.widget.AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE || isAutoSizeEnabled()) {
            return;
        }
        setTextSizeInternal(i, f);
    }
}
