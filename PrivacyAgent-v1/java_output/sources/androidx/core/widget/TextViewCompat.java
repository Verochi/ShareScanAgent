package androidx.core.widget;

/* loaded from: classes.dex */
public final class TextViewCompat {
    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
    private static final int LINES = 1;
    private static final java.lang.String LOG_TAG = "TextViewCompat";
    private static java.lang.reflect.Field sMaxModeField;
    private static boolean sMaxModeFieldFetched;
    private static java.lang.reflect.Field sMaximumField;
    private static boolean sMaximumFieldFetched;
    private static java.lang.reflect.Field sMinModeField;
    private static boolean sMinModeFieldFetched;
    private static java.lang.reflect.Field sMinimumField;
    private static boolean sMinimumFieldFetched;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface AutoSizeTextType {
    }

    @androidx.annotation.RequiresApi(26)
    public static class OreoCallback implements android.view.ActionMode.Callback {
        private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        private final android.view.ActionMode.Callback mCallback;
        private boolean mCanUseMenuBuilderReferences;
        private boolean mInitializedMenuBuilderReferences = false;
        private java.lang.Class<?> mMenuBuilderClass;
        private java.lang.reflect.Method mMenuBuilderRemoveItemAtMethod;
        private final android.widget.TextView mTextView;

        public OreoCallback(android.view.ActionMode.Callback callback, android.widget.TextView textView) {
            this.mCallback = callback;
            this.mTextView = textView;
        }

        private android.content.Intent createProcessTextIntent() {
            return new android.content.Intent().setAction("android.intent.action.PROCESS_TEXT").setType(com.baidu.mobads.sdk.internal.am.e);
        }

        private android.content.Intent createProcessTextIntentForResolveInfo(android.content.pm.ResolveInfo resolveInfo, android.widget.TextView textView) {
            android.content.Intent putExtra = createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !isEditable(textView));
            android.content.pm.ActivityInfo activityInfo = resolveInfo.activityInfo;
            return putExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        private java.util.List<android.content.pm.ResolveInfo> getSupportedActivities(android.content.Context context, android.content.pm.PackageManager packageManager) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (!(context instanceof android.app.Activity)) {
                return arrayList;
            }
            for (android.content.pm.ResolveInfo resolveInfo : packageManager.queryIntentActivities(createProcessTextIntent(), 0)) {
                if (isSupportedActivity(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        private boolean isEditable(android.widget.TextView textView) {
            return (textView instanceof android.text.Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        private boolean isSupportedActivity(android.content.pm.ResolveInfo resolveInfo, android.content.Context context) {
            int checkSelfPermission;
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            android.content.pm.ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            java.lang.String str = activityInfo.permission;
            if (str == null) {
                return true;
            }
            checkSelfPermission = context.checkSelfPermission(str);
            return checkSelfPermission == 0;
        }

        private void recomputeProcessTextMenuItems(android.view.Menu menu) {
            android.content.Context context = this.mTextView.getContext();
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            if (!this.mInitializedMenuBuilderReferences) {
                this.mInitializedMenuBuilderReferences = true;
                try {
                    java.lang.Class<?> cls = java.lang.Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.mMenuBuilderClass = cls;
                    this.mMenuBuilderRemoveItemAtMethod = cls.getDeclaredMethod("removeItemAt", java.lang.Integer.TYPE);
                    this.mCanUseMenuBuilderReferences = true;
                } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException unused) {
                    this.mMenuBuilderClass = null;
                    this.mMenuBuilderRemoveItemAtMethod = null;
                    this.mCanUseMenuBuilderReferences = false;
                }
            }
            try {
                java.lang.reflect.Method declaredMethod = (this.mCanUseMenuBuilderReferences && this.mMenuBuilderClass.isInstance(menu)) ? this.mMenuBuilderRemoveItemAtMethod : menu.getClass().getDeclaredMethod("removeItemAt", java.lang.Integer.TYPE);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    android.view.MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, java.lang.Integer.valueOf(size));
                    }
                }
                java.util.List<android.content.pm.ResolveInfo> supportedActivities = getSupportedActivities(context, packageManager);
                for (int i = 0; i < supportedActivities.size(); i++) {
                    android.content.pm.ResolveInfo resolveInfo = supportedActivities.get(i);
                    menu.add(0, 0, i + 100, resolveInfo.loadLabel(packageManager)).setIntent(createProcessTextIntentForResolveInfo(resolveInfo, this.mTextView)).setShowAsAction(1);
                }
            } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused2) {
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(android.view.ActionMode actionMode, android.view.MenuItem menuItem) {
            return this.mCallback.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
            return this.mCallback.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(android.view.ActionMode actionMode) {
            this.mCallback.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
            recomputeProcessTextMenuItems(menu);
            return this.mCallback.onPrepareActionMode(actionMode, menu);
        }
    }

    private TextViewCompat() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeMaxTextSize(@androidx.annotation.NonNull android.widget.TextView textView) {
        int autoSizeMaxTextSize;
        if (android.os.Build.VERSION.SDK_INT >= 27) {
            autoSizeMaxTextSize = textView.getAutoSizeMaxTextSize();
            return autoSizeMaxTextSize;
        }
        if (textView instanceof androidx.core.widget.AutoSizeableTextView) {
            return ((androidx.core.widget.AutoSizeableTextView) textView).getAutoSizeMaxTextSize();
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeMinTextSize(@androidx.annotation.NonNull android.widget.TextView textView) {
        int autoSizeMinTextSize;
        if (android.os.Build.VERSION.SDK_INT >= 27) {
            autoSizeMinTextSize = textView.getAutoSizeMinTextSize();
            return autoSizeMinTextSize;
        }
        if (textView instanceof androidx.core.widget.AutoSizeableTextView) {
            return ((androidx.core.widget.AutoSizeableTextView) textView).getAutoSizeMinTextSize();
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeStepGranularity(@androidx.annotation.NonNull android.widget.TextView textView) {
        int autoSizeStepGranularity;
        if (android.os.Build.VERSION.SDK_INT >= 27) {
            autoSizeStepGranularity = textView.getAutoSizeStepGranularity();
            return autoSizeStepGranularity;
        }
        if (textView instanceof androidx.core.widget.AutoSizeableTextView) {
            return ((androidx.core.widget.AutoSizeableTextView) textView).getAutoSizeStepGranularity();
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    public static int[] getAutoSizeTextAvailableSizes(@androidx.annotation.NonNull android.widget.TextView textView) {
        int[] autoSizeTextAvailableSizes;
        if (android.os.Build.VERSION.SDK_INT < 27) {
            return textView instanceof androidx.core.widget.AutoSizeableTextView ? ((androidx.core.widget.AutoSizeableTextView) textView).getAutoSizeTextAvailableSizes() : new int[0];
        }
        autoSizeTextAvailableSizes = textView.getAutoSizeTextAvailableSizes();
        return autoSizeTextAvailableSizes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeTextType(@androidx.annotation.NonNull android.widget.TextView textView) {
        int autoSizeTextType;
        if (android.os.Build.VERSION.SDK_INT >= 27) {
            autoSizeTextType = textView.getAutoSizeTextType();
            return autoSizeTextType;
        }
        if (textView instanceof androidx.core.widget.AutoSizeableTextView) {
            return ((androidx.core.widget.AutoSizeableTextView) textView).getAutoSizeTextType();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @androidx.annotation.Nullable
    public static android.content.res.ColorStateList getCompoundDrawableTintList(@androidx.annotation.NonNull android.widget.TextView textView) {
        android.content.res.ColorStateList compoundDrawableTintList;
        androidx.core.util.Preconditions.checkNotNull(textView);
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            compoundDrawableTintList = textView.getCompoundDrawableTintList();
            return compoundDrawableTintList;
        }
        if (textView instanceof androidx.core.widget.TintableCompoundDrawablesView) {
            return ((androidx.core.widget.TintableCompoundDrawablesView) textView).getSupportCompoundDrawablesTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @androidx.annotation.Nullable
    public static android.graphics.PorterDuff.Mode getCompoundDrawableTintMode(@androidx.annotation.NonNull android.widget.TextView textView) {
        android.graphics.PorterDuff.Mode compoundDrawableTintMode;
        androidx.core.util.Preconditions.checkNotNull(textView);
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            compoundDrawableTintMode = textView.getCompoundDrawableTintMode();
            return compoundDrawableTintMode;
        }
        if (textView instanceof androidx.core.widget.TintableCompoundDrawablesView) {
            return ((androidx.core.widget.TintableCompoundDrawablesView) textView).getSupportCompoundDrawablesTintMode();
        }
        return null;
    }

    @androidx.annotation.NonNull
    public static android.graphics.drawable.Drawable[] getCompoundDrawablesRelative(@androidx.annotation.NonNull android.widget.TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }

    public static int getFirstBaselineToTopHeight(@androidx.annotation.NonNull android.widget.TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int getLastBaselineToBottomHeight(@androidx.annotation.NonNull android.widget.TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static int getMaxLines(@androidx.annotation.NonNull android.widget.TextView textView) {
        return textView.getMaxLines();
    }

    public static int getMinLines(@androidx.annotation.NonNull android.widget.TextView textView) {
        return textView.getMinLines();
    }

    @androidx.annotation.RequiresApi(18)
    private static int getTextDirection(@androidx.annotation.NonNull android.text.TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == android.text.TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == android.text.TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == android.text.TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == android.text.TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == android.text.TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic == android.text.TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    @androidx.annotation.RequiresApi(18)
    private static android.text.TextDirectionHeuristic getTextDirectionHeuristic(@androidx.annotation.NonNull android.widget.TextView textView) {
        android.icu.text.DecimalFormatSymbols decimalFormatSymbols;
        java.lang.String[] digitStrings;
        if (textView.getTransformationMethod() instanceof android.text.method.PasswordTransformationMethod) {
            return android.text.TextDirectionHeuristics.LTR;
        }
        if (android.os.Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            decimalFormatSymbols = android.icu.text.DecimalFormatSymbols.getInstance(textView.getTextLocale());
            digitStrings = decimalFormatSymbols.getDigitStrings();
            byte directionality = java.lang.Character.getDirectionality(digitStrings[0].codePointAt(0));
            return (directionality == 1 || directionality == 2) ? android.text.TextDirectionHeuristics.RTL : android.text.TextDirectionHeuristics.LTR;
        }
        boolean z = textView.getLayoutDirection() == 1;
        switch (textView.getTextDirection()) {
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                if (!z) {
                    break;
                } else {
                    break;
                }
        }
        return android.text.TextDirectionHeuristics.LTR;
    }

    @androidx.annotation.NonNull
    public static androidx.core.text.PrecomputedTextCompat.Params getTextMetricsParams(@androidx.annotation.NonNull android.widget.TextView textView) {
        int breakStrategy;
        int hyphenationFrequency;
        android.text.PrecomputedText.Params textMetricsParams;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 28) {
            textMetricsParams = textView.getTextMetricsParams();
            return new androidx.core.text.PrecomputedTextCompat.Params(textMetricsParams);
        }
        androidx.core.text.PrecomputedTextCompat.Params.Builder builder = new androidx.core.text.PrecomputedTextCompat.Params.Builder(new android.text.TextPaint(textView.getPaint()));
        if (i >= 23) {
            breakStrategy = textView.getBreakStrategy();
            builder.setBreakStrategy(breakStrategy);
            hyphenationFrequency = textView.getHyphenationFrequency();
            builder.setHyphenationFrequency(hyphenationFrequency);
        }
        builder.setTextDirection(getTextDirectionHeuristic(textView));
        return builder.build();
    }

    private static java.lang.reflect.Field retrieveField(java.lang.String str) {
        java.lang.reflect.Field field = null;
        try {
            field = android.widget.TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (java.lang.NoSuchFieldException unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Could not retrieve ");
            sb.append(str);
            sb.append(" field.");
            return field;
        }
    }

    private static int retrieveIntFromField(java.lang.reflect.Field field, android.widget.TextView textView) {
        try {
            return field.getInt(textView);
        } catch (java.lang.IllegalAccessException unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Could not retrieve value of ");
            sb.append(field.getName());
            sb.append(" field.");
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setAutoSizeTextTypeUniformWithConfiguration(@androidx.annotation.NonNull android.widget.TextView textView, int i, int i2, int i3, int i4) throws java.lang.IllegalArgumentException {
        if (android.os.Build.VERSION.SDK_INT >= 27) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (textView instanceof androidx.core.widget.AutoSizeableTextView) {
            ((androidx.core.widget.AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setAutoSizeTextTypeUniformWithPresetSizes(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull int[] iArr, int i) throws java.lang.IllegalArgumentException {
        if (android.os.Build.VERSION.SDK_INT >= 27) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (textView instanceof androidx.core.widget.AutoSizeableTextView) {
            ((androidx.core.widget.AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setAutoSizeTextTypeWithDefaults(@androidx.annotation.NonNull android.widget.TextView textView, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 27) {
            textView.setAutoSizeTextTypeWithDefaults(i);
        } else if (textView instanceof androidx.core.widget.AutoSizeableTextView) {
            ((androidx.core.widget.AutoSizeableTextView) textView).setAutoSizeTextTypeWithDefaults(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCompoundDrawableTintList(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        androidx.core.util.Preconditions.checkNotNull(textView);
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintList(colorStateList);
        } else if (textView instanceof androidx.core.widget.TintableCompoundDrawablesView) {
            ((androidx.core.widget.TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCompoundDrawableTintMode(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        androidx.core.util.Preconditions.checkNotNull(textView);
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintMode(mode);
        } else if (textView instanceof androidx.core.widget.TintableCompoundDrawablesView) {
            ((androidx.core.widget.TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void setCompoundDrawablesRelative(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.Nullable android.graphics.drawable.Drawable drawable, @androidx.annotation.Nullable android.graphics.drawable.Drawable drawable2, @androidx.annotation.Nullable android.graphics.drawable.Drawable drawable3, @androidx.annotation.Nullable android.graphics.drawable.Drawable drawable4) {
        textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.DrawableRes int i, @androidx.annotation.DrawableRes int i2, @androidx.annotation.DrawableRes int i3, @androidx.annotation.DrawableRes int i4) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.Nullable android.graphics.drawable.Drawable drawable, @androidx.annotation.Nullable android.graphics.drawable.Drawable drawable2, @androidx.annotation.Nullable android.graphics.drawable.Drawable drawable3, @androidx.annotation.Nullable android.graphics.drawable.Drawable drawable4) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public static void setCustomSelectionActionModeCallback(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.view.ActionMode.Callback callback) {
        textView.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(textView, callback));
    }

    public static void setFirstBaselineToTopHeight(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.IntRange(from = 0) @androidx.annotation.Px int i) {
        androidx.core.util.Preconditions.checkArgumentNonnegative(i);
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i);
            return;
        }
        android.graphics.Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i > java.lang.Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i + i2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void setLastBaselineToBottomHeight(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.IntRange(from = 0) @androidx.annotation.Px int i) {
        androidx.core.util.Preconditions.checkArgumentNonnegative(i);
        android.graphics.Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i > java.lang.Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    public static void setLineHeight(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.IntRange(from = 0) @androidx.annotation.Px int i) {
        androidx.core.util.Preconditions.checkArgumentNonnegative(i);
        if (i != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i - r0, 1.0f);
        }
    }

    public static void setPrecomputedText(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull androidx.core.text.PrecomputedTextCompat precomputedTextCompat) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            textView.setText(precomputedTextCompat.getPrecomputedText());
        } else {
            if (!getTextMetricsParams(textView).equalsWithoutTextDirection(precomputedTextCompat.getParams())) {
                throw new java.lang.IllegalArgumentException("Given text can not be applied to TextView.");
            }
            textView.setText(precomputedTextCompat);
        }
    }

    public static void setTextAppearance(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.StyleRes int i) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    public static void setTextMetricsParams(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull androidx.core.text.PrecomputedTextCompat.Params params) {
        int i = android.os.Build.VERSION.SDK_INT;
        textView.setTextDirection(getTextDirection(params.getTextDirection()));
        if (i >= 23) {
            textView.getPaint().set(params.getTextPaint());
            textView.setBreakStrategy(params.getBreakStrategy());
            textView.setHyphenationFrequency(params.getHyphenationFrequency());
        } else {
            float textScaleX = params.getTextPaint().getTextScaleX();
            textView.getPaint().set(params.getTextPaint());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
        }
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static android.view.ActionMode.Callback wrapCustomSelectionActionModeCallback(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.view.ActionMode.Callback callback) {
        int i = android.os.Build.VERSION.SDK_INT;
        return (i < 26 || i > 27 || (callback instanceof androidx.core.widget.TextViewCompat.OreoCallback)) ? callback : new androidx.core.widget.TextViewCompat.OreoCallback(callback, textView);
    }
}
