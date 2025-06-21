package androidx.appcompat.widget;

/* loaded from: classes.dex */
class AppCompatTextViewAutoSizeHelper {
    private static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
    private static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 112;
    private static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
    private static final java.lang.String TAG = "ACTVAutoSizeHelper";
    static final float UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE = -1.0f;
    private static final int VERY_WIDE = 1048576;
    private final android.content.Context mContext;
    private final androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl mImpl;
    private android.text.TextPaint mTempTextPaint;

    @androidx.annotation.NonNull
    private final android.widget.TextView mTextView;
    private static final android.graphics.RectF TEMP_RECTF = new android.graphics.RectF();

    @android.annotation.SuppressLint({"BanConcurrentHashMap"})
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.reflect.Method> sTextViewMethodByNameCache = new java.util.concurrent.ConcurrentHashMap<>();

    @android.annotation.SuppressLint({"BanConcurrentHashMap"})
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.reflect.Field> sTextViewFieldByNameCache = new java.util.concurrent.ConcurrentHashMap<>();
    private int mAutoSizeTextType = 0;
    private boolean mNeedsAutoSizeText = false;
    private float mAutoSizeStepGranularityInPx = -1.0f;
    private float mAutoSizeMinTextSizeInPx = -1.0f;
    private float mAutoSizeMaxTextSizeInPx = -1.0f;
    private int[] mAutoSizeTextSizesInPx = new int[0];
    private boolean mHasPresetAutoSizeValues = false;

    public static class Impl {
        public void computeAndSetTextDirection(android.text.StaticLayout.Builder builder, android.widget.TextView textView) {
        }

        public boolean isHorizontallyScrollable(android.widget.TextView textView) {
            return ((java.lang.Boolean) androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getHorizontallyScrolling", java.lang.Boolean.FALSE)).booleanValue();
        }
    }

    @androidx.annotation.RequiresApi(23)
    public static class Impl23 extends androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl {
        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public void computeAndSetTextDirection(android.text.StaticLayout.Builder builder, android.widget.TextView textView) {
            builder.setTextDirection((android.text.TextDirectionHeuristic) androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getTextDirectionHeuristic", android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    @androidx.annotation.RequiresApi(29)
    public static class Impl29 extends androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23 {
        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23, androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public void computeAndSetTextDirection(android.text.StaticLayout.Builder builder, android.widget.TextView textView) {
            android.text.TextDirectionHeuristic textDirectionHeuristic;
            textDirectionHeuristic = textView.getTextDirectionHeuristic();
            builder.setTextDirection(textDirectionHeuristic);
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public boolean isHorizontallyScrollable(android.widget.TextView textView) {
            boolean isHorizontallyScrollable;
            isHorizontallyScrollable = textView.isHorizontallyScrollable();
            return isHorizontallyScrollable;
        }
    }

    public AppCompatTextViewAutoSizeHelper(@androidx.annotation.NonNull android.widget.TextView textView) {
        this.mTextView = textView;
        this.mContext = textView.getContext();
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 29) {
            this.mImpl = new androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl29();
        } else if (i >= 23) {
            this.mImpl = new androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23();
        } else {
            this.mImpl = new androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl();
        }
    }

    private static <T> T accessAndReturnWithDefault(@androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull T t) {
        try {
            java.lang.reflect.Field textViewField = getTextViewField(str);
            return textViewField == null ? t : (T) textViewField.get(obj);
        } catch (java.lang.IllegalAccessException unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Failed to access TextView#");
            sb.append(str);
            sb.append(" member");
            return t;
        }
    }

    private int[] cleanupAutoSizePresetSizes(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        java.util.Arrays.sort(iArr);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i : iArr) {
            if (i > 0 && java.util.Collections.binarySearch(arrayList, java.lang.Integer.valueOf(i)) < 0) {
                arrayList.add(java.lang.Integer.valueOf(i));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((java.lang.Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    private void clearAutoSizeConfiguration() {
        this.mAutoSizeTextType = 0;
        this.mAutoSizeMinTextSizeInPx = -1.0f;
        this.mAutoSizeMaxTextSizeInPx = -1.0f;
        this.mAutoSizeStepGranularityInPx = -1.0f;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mNeedsAutoSizeText = false;
    }

    @androidx.annotation.RequiresApi(23)
    private android.text.StaticLayout createStaticLayoutForMeasuring(java.lang.CharSequence charSequence, android.text.Layout.Alignment alignment, int i, int i2) {
        android.text.StaticLayout.Builder obtain;
        android.text.StaticLayout.Builder alignment2;
        android.text.StaticLayout.Builder lineSpacing;
        android.text.StaticLayout.Builder includePad;
        int breakStrategy;
        android.text.StaticLayout.Builder breakStrategy2;
        int hyphenationFrequency;
        android.text.StaticLayout.Builder hyphenationFrequency2;
        android.text.StaticLayout build;
        obtain = android.text.StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.mTempTextPaint, i);
        alignment2 = obtain.setAlignment(alignment);
        lineSpacing = alignment2.setLineSpacing(this.mTextView.getLineSpacingExtra(), this.mTextView.getLineSpacingMultiplier());
        includePad = lineSpacing.setIncludePad(this.mTextView.getIncludeFontPadding());
        breakStrategy = this.mTextView.getBreakStrategy();
        breakStrategy2 = includePad.setBreakStrategy(breakStrategy);
        hyphenationFrequency = this.mTextView.getHyphenationFrequency();
        hyphenationFrequency2 = breakStrategy2.setHyphenationFrequency(hyphenationFrequency);
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        hyphenationFrequency2.setMaxLines(i2);
        try {
            this.mImpl.computeAndSetTextDirection(obtain, this.mTextView);
        } catch (java.lang.ClassCastException unused) {
        }
        build = obtain.build();
        return build;
    }

    private android.text.StaticLayout createStaticLayoutForMeasuringPre16(java.lang.CharSequence charSequence, android.text.Layout.Alignment alignment, int i) {
        return new android.text.StaticLayout(charSequence, this.mTempTextPaint, i, alignment, ((java.lang.Float) accessAndReturnWithDefault(this.mTextView, "mSpacingMult", java.lang.Float.valueOf(1.0f))).floatValue(), ((java.lang.Float) accessAndReturnWithDefault(this.mTextView, "mSpacingAdd", java.lang.Float.valueOf(0.0f))).floatValue(), ((java.lang.Boolean) accessAndReturnWithDefault(this.mTextView, "mIncludePad", java.lang.Boolean.TRUE)).booleanValue());
    }

    @androidx.annotation.RequiresApi(16)
    private android.text.StaticLayout createStaticLayoutForMeasuringPre23(java.lang.CharSequence charSequence, android.text.Layout.Alignment alignment, int i) {
        return new android.text.StaticLayout(charSequence, this.mTempTextPaint, i, alignment, this.mTextView.getLineSpacingMultiplier(), this.mTextView.getLineSpacingExtra(), this.mTextView.getIncludeFontPadding());
    }

    private int findLargestTextSizeWhichFits(android.graphics.RectF rectF) {
        int length = this.mAutoSizeTextSizesInPx.length;
        if (length == 0) {
            throw new java.lang.IllegalStateException("No available text sizes to choose from.");
        }
        int i = 1;
        int i2 = length - 1;
        int i3 = 0;
        while (i <= i2) {
            int i4 = (i + i2) / 2;
            if (suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[i4], rectF)) {
                int i5 = i4 + 1;
                i3 = i;
                i = i5;
            } else {
                i3 = i4 - 1;
                i2 = i3;
            }
        }
        return this.mAutoSizeTextSizesInPx[i3];
    }

    @androidx.annotation.Nullable
    private static java.lang.reflect.Field getTextViewField(@androidx.annotation.NonNull java.lang.String str) {
        try {
            java.lang.reflect.Field field = sTextViewFieldByNameCache.get(str);
            if (field == null && (field = android.widget.TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                sTextViewFieldByNameCache.put(str, field);
            }
            return field;
        } catch (java.lang.NoSuchFieldException unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Failed to access TextView#");
            sb.append(str);
            sb.append(" member");
            return null;
        }
    }

    @androidx.annotation.Nullable
    private static java.lang.reflect.Method getTextViewMethod(@androidx.annotation.NonNull java.lang.String str) {
        try {
            java.lang.reflect.Method method = sTextViewMethodByNameCache.get(str);
            if (method == null && (method = android.widget.TextView.class.getDeclaredMethod(str, new java.lang.Class[0])) != null) {
                method.setAccessible(true);
                sTextViewMethodByNameCache.put(str, method);
            }
            return method;
        } catch (java.lang.Exception unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Failed to retrieve TextView#");
            sb.append(str);
            sb.append("() method");
            return null;
        }
    }

    public static <T> T invokeAndReturnWithDefault(@androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull T t) {
        try {
            return (T) getTextViewMethod(str).invoke(obj, new java.lang.Object[0]);
        } catch (java.lang.Exception unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Failed to invoke TextView#");
            sb.append(str);
            sb.append("() method");
            return t;
        }
    }

    private void setRawTextSize(float f) {
        if (f != this.mTextView.getPaint().getTextSize()) {
            this.mTextView.getPaint().setTextSize(f);
            boolean isInLayout = this.mTextView.isInLayout();
            if (this.mTextView.getLayout() != null) {
                this.mNeedsAutoSizeText = false;
                try {
                    java.lang.reflect.Method textViewMethod = getTextViewMethod("nullLayouts");
                    if (textViewMethod != null) {
                        textViewMethod.invoke(this.mTextView, new java.lang.Object[0]);
                    }
                } catch (java.lang.Exception unused) {
                }
                if (isInLayout) {
                    this.mTextView.forceLayout();
                } else {
                    this.mTextView.requestLayout();
                }
                this.mTextView.invalidate();
            }
        }
    }

    private boolean setupAutoSizeText() {
        if (supportsAutoSizeText() && this.mAutoSizeTextType == 1) {
            if (!this.mHasPresetAutoSizeValues || this.mAutoSizeTextSizesInPx.length == 0) {
                int floor = ((int) java.lang.Math.floor((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx)) + 1;
                int[] iArr = new int[floor];
                for (int i = 0; i < floor; i++) {
                    iArr[i] = java.lang.Math.round(this.mAutoSizeMinTextSizeInPx + (i * this.mAutoSizeStepGranularityInPx));
                }
                this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr);
            }
            this.mNeedsAutoSizeText = true;
        } else {
            this.mNeedsAutoSizeText = false;
        }
        return this.mNeedsAutoSizeText;
    }

    private void setupAutoSizeUniformPresetSizes(android.content.res.TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr);
            setupAutoSizeUniformPresetSizesConfiguration();
        }
    }

    private boolean setupAutoSizeUniformPresetSizesConfiguration() {
        boolean z = this.mAutoSizeTextSizesInPx.length > 0;
        this.mHasPresetAutoSizeValues = z;
        if (z) {
            this.mAutoSizeTextType = 1;
            this.mAutoSizeMinTextSizeInPx = r0[0];
            this.mAutoSizeMaxTextSizeInPx = r0[r1 - 1];
            this.mAutoSizeStepGranularityInPx = -1.0f;
        }
        return z;
    }

    private boolean suggestedSizeFitsInSpace(int i, android.graphics.RectF rectF) {
        java.lang.CharSequence transformation;
        java.lang.CharSequence text = this.mTextView.getText();
        android.text.method.TransformationMethod transformationMethod = this.mTextView.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.mTextView)) != null) {
            text = transformation;
        }
        int maxLines = this.mTextView.getMaxLines();
        initTempTextPaint(i);
        android.text.StaticLayout createLayout = createLayout(text, (android.text.Layout.Alignment) invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", android.text.Layout.Alignment.ALIGN_NORMAL), java.lang.Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (createLayout.getLineCount() <= maxLines && createLayout.getLineEnd(createLayout.getLineCount() - 1) == text.length())) && ((float) createLayout.getHeight()) <= rectF.bottom;
    }

    private boolean supportsAutoSizeText() {
        return !(this.mTextView instanceof androidx.appcompat.widget.AppCompatEditText);
    }

    private void validateAndSetAutoSizeTextTypeUniformConfiguration(float f, float f2, float f3) throws java.lang.IllegalArgumentException {
        if (f <= 0.0f) {
            throw new java.lang.IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        }
        if (f2 <= f) {
            throw new java.lang.IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        }
        if (f3 <= 0.0f) {
            throw new java.lang.IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
        this.mAutoSizeTextType = 1;
        this.mAutoSizeMinTextSizeInPx = f;
        this.mAutoSizeMaxTextSizeInPx = f2;
        this.mAutoSizeStepGranularityInPx = f3;
        this.mHasPresetAutoSizeValues = false;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void autoSizeText() {
        if (isAutoSizeEnabled()) {
            if (this.mNeedsAutoSizeText) {
                if (this.mTextView.getMeasuredHeight() <= 0 || this.mTextView.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.mImpl.isHorizontallyScrollable(this.mTextView) ? 1048576 : (this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft()) - this.mTextView.getTotalPaddingRight();
                int height = (this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom()) - this.mTextView.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                android.graphics.RectF rectF = TEMP_RECTF;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float findLargestTextSizeWhichFits = findLargestTextSizeWhichFits(rectF);
                    if (findLargestTextSizeWhichFits != this.mTextView.getTextSize()) {
                        setTextSizeInternal(0, findLargestTextSizeWhichFits);
                    }
                }
            }
            this.mNeedsAutoSizeText = true;
        }
    }

    @androidx.annotation.VisibleForTesting
    public android.text.StaticLayout createLayout(java.lang.CharSequence charSequence, android.text.Layout.Alignment alignment, int i, int i2) {
        return android.os.Build.VERSION.SDK_INT >= 23 ? createStaticLayoutForMeasuring(charSequence, alignment, i, i2) : createStaticLayoutForMeasuringPre23(charSequence, alignment, i);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMaxTextSize() {
        return java.lang.Math.round(this.mAutoSizeMaxTextSizeInPx);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        return java.lang.Math.round(this.mAutoSizeMinTextSizeInPx);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        return java.lang.Math.round(this.mAutoSizeStepGranularityInPx);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextSizesInPx;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeTextType() {
        return this.mAutoSizeTextType;
    }

    @androidx.annotation.VisibleForTesting
    public void initTempTextPaint(int i) {
        android.text.TextPaint textPaint = this.mTempTextPaint;
        if (textPaint == null) {
            this.mTempTextPaint = new android.text.TextPaint();
        } else {
            textPaint.reset();
        }
        this.mTempTextPaint.set(this.mTextView.getPaint());
        this.mTempTextPaint.setTextSize(i);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isAutoSizeEnabled() {
        return supportsAutoSizeText() && this.mAutoSizeTextType != 0;
    }

    public void loadFromAttributes(@androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        int resourceId;
        android.content.Context context = this.mContext;
        int[] iArr = androidx.appcompat.R.styleable.AppCompatTextView;
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        android.widget.TextView textView = this.mTextView;
        androidx.core.view.ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i, 0);
        int i2 = androidx.appcompat.R.styleable.AppCompatTextView_autoSizeTextType;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.mAutoSizeTextType = obtainStyledAttributes.getInt(i2, 0);
        }
        int i3 = androidx.appcompat.R.styleable.AppCompatTextView_autoSizeStepGranularity;
        float dimension = obtainStyledAttributes.hasValue(i3) ? obtainStyledAttributes.getDimension(i3, -1.0f) : -1.0f;
        int i4 = androidx.appcompat.R.styleable.AppCompatTextView_autoSizeMinTextSize;
        float dimension2 = obtainStyledAttributes.hasValue(i4) ? obtainStyledAttributes.getDimension(i4, -1.0f) : -1.0f;
        int i5 = androidx.appcompat.R.styleable.AppCompatTextView_autoSizeMaxTextSize;
        float dimension3 = obtainStyledAttributes.hasValue(i5) ? obtainStyledAttributes.getDimension(i5, -1.0f) : -1.0f;
        int i6 = androidx.appcompat.R.styleable.AppCompatTextView_autoSizePresetSizes;
        if (obtainStyledAttributes.hasValue(i6) && (resourceId = obtainStyledAttributes.getResourceId(i6, 0)) > 0) {
            android.content.res.TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            setupAutoSizeUniformPresetSizes(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!supportsAutoSizeText()) {
            this.mAutoSizeTextType = 0;
            return;
        }
        if (this.mAutoSizeTextType == 1) {
            if (!this.mHasPresetAutoSizeValues) {
                android.util.DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = android.util.TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = android.util.TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                validateAndSetAutoSizeTextTypeUniformConfiguration(dimension2, dimension3, dimension);
            }
            setupAutoSizeText();
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws java.lang.IllegalArgumentException {
        if (supportsAutoSizeText()) {
            android.util.DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            validateAndSetAutoSizeTextTypeUniformConfiguration(android.util.TypedValue.applyDimension(i4, i, displayMetrics), android.util.TypedValue.applyDimension(i4, i2, displayMetrics), android.util.TypedValue.applyDimension(i4, i3, displayMetrics));
            if (setupAutoSizeText()) {
                autoSizeText();
            }
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@androidx.annotation.NonNull int[] iArr, int i) throws java.lang.IllegalArgumentException {
        if (supportsAutoSizeText()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = java.util.Arrays.copyOf(iArr, length);
                } else {
                    android.util.DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = java.lang.Math.round(android.util.TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr2);
                if (!setupAutoSizeUniformPresetSizesConfiguration()) {
                    throw new java.lang.IllegalArgumentException("None of the preset sizes is valid: " + java.util.Arrays.toString(iArr));
                }
            } else {
                this.mHasPresetAutoSizeValues = false;
            }
            if (setupAutoSizeText()) {
                autoSizeText();
            }
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (supportsAutoSizeText()) {
            if (i == 0) {
                clearAutoSizeConfiguration();
                return;
            }
            if (i != 1) {
                throw new java.lang.IllegalArgumentException("Unknown auto-size text type: " + i);
            }
            android.util.DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            validateAndSetAutoSizeTextTypeUniformConfiguration(android.util.TypedValue.applyDimension(2, 12.0f, displayMetrics), android.util.TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (setupAutoSizeText()) {
                autoSizeText();
            }
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setTextSizeInternal(int i, float f) {
        android.content.Context context = this.mContext;
        setRawTextSize(android.util.TypedValue.applyDimension(i, f, (context == null ? android.content.res.Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
