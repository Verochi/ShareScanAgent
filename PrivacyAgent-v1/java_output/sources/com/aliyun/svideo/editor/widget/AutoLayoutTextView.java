package com.aliyun.svideo.editor.widget;

/* loaded from: classes12.dex */
public class AutoLayoutTextView extends androidx.appcompat.widget.AppCompatTextView {
    private static final int NO_LINE_LIMIT = -1;
    private boolean isEditCompleted;
    private boolean isMirror;
    private boolean isTextOnly;
    private android.graphics.RectF mAvailableSpaceRect;
    private int mBottom;
    private int mCurrentColor;
    private java.lang.Integer mCurrentStrokeColor;
    private java.lang.String mFontPath;
    private boolean mFrozen;
    private int mHeight;
    private android.widget.ImageView mImageView;
    private boolean mInitialized;
    private int mLastHeight;
    private int mLastWidth;
    private android.text.StaticLayout mLayout;
    private int mLeft;
    private int mMaxHeightWhenOutof;
    private int mMaxLines;
    private float mMaxTextSize;
    private int mMaxWidthWhenOutof;
    private float mMinTextSize;
    private android.text.TextPaint mPaint;
    private int mRight;
    boolean mScaleByDrawable;
    private final com.aliyun.svideo.editor.widget.AutoLayoutTextView.SizeTester mSizeTester;
    private float mSpacingAdd;
    private float mSpacingMult;
    protected android.graphics.Paint.Join mStrokeJoin;
    protected float mStrokeMiter;
    protected float mStrokeWidth;
    private float mTextAngle;
    private android.graphics.RectF mTextRect;
    private int mTop;
    private int mWidth;
    private int mWidthLimit;

    /* renamed from: com.aliyun.svideo.editor.widget.AutoLayoutTextView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.widget.AutoLayoutTextView.SizeTester {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.widget.AutoLayoutTextView.SizeTester
        @android.annotation.TargetApi(16)
        public int onTestSize(int i, android.graphics.RectF rectF, java.lang.String str) {
            com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mPaint.setTextSize(i);
            com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mLayout = new android.text.StaticLayout(str, com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mPaint, com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mWidthLimit, android.text.Layout.Alignment.ALIGN_NORMAL, com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mSpacingMult, com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mSpacingAdd, true);
            if (com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mMaxLines != -1 && com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mLayout.getLineCount() > com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mMaxLines) {
                return 1;
            }
            if (com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mLayout.getLineCount() > com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.calculateMaxLinesByText(str)) {
                return 1;
            }
            com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mTextRect.bottom = com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mLayout.getHeight();
            com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mTextRect.right = com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.getLayoutMaxWidth();
            com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mTextRect.offsetTo(0.0f, 0.0f);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("suggest size : ");
            sb.append(i);
            sb.append(" width : ");
            sb.append(com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mTextRect.right);
            sb.append(" height : ");
            sb.append(com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mTextRect.bottom);
            sb.append(" match : ");
            sb.append(rectF.contains(com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mTextRect));
            return rectF.contains(com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mTextRect) ? -1 : 1;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.widget.AutoLayoutTextView$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int width = ((android.view.ViewGroup) com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.getParent()).getWidth();
            int height = ((android.view.ViewGroup) com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.getParent()).getHeight();
            int applyDimension = (int) android.util.TypedValue.applyDimension(1, 30.0f, com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.getResources().getDisplayMetrics());
            com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mMaxWidthWhenOutof = width - applyDimension;
            com.aliyun.svideo.editor.widget.AutoLayoutTextView.this.mMaxHeightWhenOutof = height - (applyDimension * 3);
            com.aliyun.svideo.editor.widget.AutoLayoutTextView autoLayoutTextView = com.aliyun.svideo.editor.widget.AutoLayoutTextView.this;
            autoLayoutTextView.setMaxWidth(autoLayoutTextView.mMaxWidthWhenOutof);
            com.aliyun.svideo.editor.widget.AutoLayoutTextView autoLayoutTextView2 = com.aliyun.svideo.editor.widget.AutoLayoutTextView.this;
            autoLayoutTextView2.setMaxHeight(autoLayoutTextView2.mMaxHeightWhenOutof);
        }
    }

    public interface SizeTester {
        int onTestSize(int i, android.graphics.RectF rectF, java.lang.String str);
    }

    public AutoLayoutTextView(android.content.Context context) {
        super(context);
        this.mCurrentColor = -1;
        this.mFrozen = false;
        this.mTextRect = new android.graphics.RectF();
        this.mSpacingMult = 1.0f;
        this.mSpacingAdd = 0.0f;
        this.mMinTextSize = 0.0f;
        this.isEditCompleted = false;
        this.mSizeTester = new com.aliyun.svideo.editor.widget.AutoLayoutTextView.AnonymousClass1();
        initialize();
    }

    public AutoLayoutTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentColor = -1;
        this.mFrozen = false;
        this.mTextRect = new android.graphics.RectF();
        this.mSpacingMult = 1.0f;
        this.mSpacingAdd = 0.0f;
        this.mMinTextSize = 0.0f;
        this.isEditCompleted = false;
        this.mSizeTester = new com.aliyun.svideo.editor.widget.AutoLayoutTextView.AnonymousClass1();
        initialize();
    }

    public AutoLayoutTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentColor = -1;
        this.mFrozen = false;
        this.mTextRect = new android.graphics.RectF();
        this.mSpacingMult = 1.0f;
        this.mSpacingAdd = 0.0f;
        this.mMinTextSize = 0.0f;
        this.isEditCompleted = false;
        this.mSizeTester = new com.aliyun.svideo.editor.widget.AutoLayoutTextView.AnonymousClass1();
        initialize();
    }

    private void adjustTextSize() {
        if (this.mInitialized && !android.text.TextUtils.isEmpty(getText())) {
            int i = (int) this.mMinTextSize;
            float max = this.isEditCompleted ? this.mMaxTextSize : java.lang.Math.max(getTextSize(), android.util.TypedValue.applyDimension(2, 10.0f, getResources().getDisplayMetrics()));
            this.mWidthLimit = (int) this.mAvailableSpaceRect.right;
            this.mPaint = new android.text.TextPaint(getPaint());
            super.setTextSize(0, efficientTextSizeSearch(i, (int) max, this.mSizeTester, this.mAvailableSpaceRect));
        }
    }

    private static int binarySearch(int i, int i2, java.lang.String str, com.aliyun.svideo.editor.widget.AutoLayoutTextView.SizeTester sizeTester, android.graphics.RectF rectF) {
        int i3 = i2 - 1;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("start : ");
        sb.append(i);
        sb.append(" end : ");
        sb.append(i2);
        sb.append(" width : ");
        sb.append(rectF.right);
        sb.append(" height : ");
        sb.append(rectF.bottom);
        int i4 = i;
        while (i <= i3) {
            int i5 = (i + i3) >>> 1;
            int onTestSize = sizeTester.onTestSize(i5, rectF, str);
            if (onTestSize < 0) {
                int i6 = i5 + 1;
                i4 = i;
                i = i6;
            } else {
                if (onTestSize <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
                i3 = i4;
            }
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("last best : ");
        sb2.append(i4);
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calculateMaxLinesByText(java.lang.CharSequence charSequence) {
        if (android.text.TextUtils.isEmpty(charSequence)) {
            return 1;
        }
        return charSequence.toString().split("\n").length;
    }

    private int[] count(java.lang.String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            int charCount = java.lang.Character.charCount(codePointAt);
            if (codePointAt != 10) {
                if (com.aliyun.svideo.editor.util.ChineseUtil.isChinese(str.substring(i, i + charCount))) {
                    i5++;
                } else {
                    i4++;
                }
                i2 = (i4 % 2 == 0 ? i4 / 2 : (i4 / 2) + 1) + i5;
                if (i2 == 10) {
                    i3 = i + 1;
                }
            }
            i += charCount;
        }
        return new int[]{i2, i3};
    }

    private int efficientTextSizeSearch(int i, int i2, com.aliyun.svideo.editor.widget.AutoLayoutTextView.SizeTester sizeTester, android.graphics.RectF rectF) {
        return binarySearch(i, i2, getText().toString(), sizeTester, rectF);
    }

    private java.lang.CharSequence filtrateText(java.lang.CharSequence charSequence) {
        if (android.text.TextUtils.isEmpty(charSequence) || this.isTextOnly) {
            return charSequence;
        }
        int[] count = count(charSequence.toString());
        return count[0] > 10 ? charSequence.subSequence(0, count[1]) : charSequence;
    }

    private boolean generateFileFromBitmap(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2) throws java.io.IOException {
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            java.io.File parentFile = file.getParentFile();
            if (!parentFile.exists() && parentFile.isDirectory()) {
                parentFile.mkdirs();
            }
            file.createNewFile();
        }
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG;
        }
        if (str.endsWith(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPG) || str.endsWith(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG) || str2.endsWith(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPG) || str2.endsWith(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG)) {
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } else if (str.endsWith(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_PNG) || str2.endsWith(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_PNG)) {
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } else {
            if (!str.endsWith("webp") && !str2.endsWith("webp")) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("not supported image format for '");
                sb.append(str);
                sb.append("'");
                fileOutputStream.flush();
                fileOutputStream.close();
                if (!file.exists()) {
                    return false;
                }
                file.delete();
                return false;
            }
            bitmap.compress(android.graphics.Bitmap.CompressFormat.WEBP, 100, fileOutputStream);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        return true;
    }

    private float generateStrokeWidth() {
        int px2sp = px2sp(getContext(), getTextSize());
        float applyDimension = android.util.TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics());
        return px2sp <= 27 ? applyDimension : applyDimension * (((px2sp - 27) / 15.0f) + 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLayoutMaxWidth() {
        int i = -1;
        for (int i2 = 0; i2 < this.mLayout.getLineCount(); i2++) {
            if (i < this.mLayout.getLineWidth(i2)) {
                i = (int) this.mLayout.getLineWidth(i2);
            }
        }
        return i;
    }

    private void initialize() {
        this.mStrokeJoin = android.graphics.Paint.Join.ROUND;
        this.mStrokeMiter = 10.0f;
        this.mMaxTextSize = android.util.TypedValue.applyDimension(2, 180.0f, getResources().getDisplayMetrics());
        this.mMaxTextSize = getResources().getDisplayMetrics().widthPixels;
        this.mAvailableSpaceRect = new android.graphics.RectF();
        if (this.mMaxLines == 0) {
            this.mMaxLines = -1;
        }
        float[] fArr = new float[2];
        com.aliyun.svideo.editor.util.CompatUtil.generateSpacingmultAndSpacingadd(fArr, this);
        this.mSpacingMult = fArr[0];
        this.mSpacingAdd = fArr[1];
        this.mInitialized = true;
        post(new com.aliyun.svideo.editor.widget.AutoLayoutTextView.AnonymousClass2());
    }

    public static int px2sp(android.content.Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public void freeze() {
        this.mFrozen = true;
    }

    @Override // android.widget.TextView
    public boolean getDefaultEditable() {
        return true;
    }

    public java.lang.String getFontPath() {
        return this.mFontPath;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.mMaxLines;
    }

    public float getMaxTextSize() {
        return this.mMaxTextSize;
    }

    public int getTextColor() {
        return this.mCurrentColor;
    }

    public int getTextHeight() {
        android.text.Layout layout = getLayout();
        if (layout == null) {
            measureSelf(this.mWidth, this.mHeight);
            super.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.mWidth + getPaddingLeft() + getPaddingRight(), 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(this.mHeight + getPaddingTop() + getPaddingBottom(), 1073741824));
            layout = getLayout();
        }
        if (layout == null && (layout = this.mLayout) == null) {
            return 0;
        }
        return layout.getHeight();
    }

    public float getTextRotation() {
        return this.mTextAngle;
    }

    public int getTextStrokeColor() {
        return this.mCurrentStrokeColor.intValue();
    }

    public int getTextWidth() {
        android.text.Layout layout = getLayout();
        if (layout == null) {
            measureSelf(this.mWidth, this.mHeight);
            super.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.mWidth + getPaddingLeft() + getPaddingRight(), 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(this.mHeight + getPaddingTop() + getPaddingBottom(), 1073741824));
            layout = getLayout();
        }
        if (layout == null && (layout = this.mLayout) == null) {
            return 0;
        }
        return layout.getWidth();
    }

    public float getmStrokeWidth() {
        return this.mStrokeWidth;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.mFrozen) {
            return;
        }
        super.invalidate();
    }

    @Override // android.view.View
    public void invalidate(int i, int i2, int i3, int i4) {
        if (this.mFrozen) {
            return;
        }
        super.invalidate(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void invalidate(android.graphics.Rect rect) {
        if (this.mFrozen) {
            return;
        }
        super.invalidate(rect);
    }

    public boolean isNeedSelfMeasure() {
        return !this.isEditCompleted;
    }

    public android.graphics.Bitmap layoutToBitmap() {
        boolean z;
        int i = this.mWidth;
        int i2 = this.mHeight;
        android.text.Layout layout = getLayout();
        if (layout == null) {
            measureSelf(this.mWidth, this.mHeight);
            super.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.mWidth + getPaddingLeft() + getPaddingRight(), 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(this.mHeight + getPaddingTop() + getPaddingBottom(), 1073741824));
            layout = getLayout();
        }
        android.graphics.Bitmap bitmap = null;
        if (layout == null && (layout = this.mLayout) == null) {
            return null;
        }
        int width = getWidth();
        int height = getHeight();
        int width2 = layout.getWidth();
        int height2 = layout.getHeight();
        if (width == 0 || height == 0) {
            width = this.mWidth;
            height = this.mHeight;
            z = true;
        } else {
            z = false;
        }
        if (!this.isTextOnly && !z) {
            width = (width - getPaddingLeft()) - getPaddingRight();
            height = (height - getPaddingTop()) - getPaddingBottom();
        }
        if (width != 0 && height != 0) {
            bitmap = android.graphics.Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap);
            canvas.translate((width - width2) / 2, (height - height2) / 2);
            android.text.TextPaint paint = layout.getPaint();
            java.lang.Integer num = this.mCurrentStrokeColor;
            if (num != null && num.intValue() != 0) {
                paint.setStyle(android.graphics.Paint.Style.STROKE);
                paint.setStrokeJoin(this.mStrokeJoin);
                paint.setStrokeMiter(this.mStrokeMiter);
                paint.setStrokeWidth(generateStrokeWidth());
                paint.setColor(this.mCurrentStrokeColor.intValue());
                layout.draw(canvas);
            }
            paint.setColor(this.mCurrentColor);
            paint.setStyle(android.graphics.Paint.Style.FILL);
            layout.draw(canvas);
            android.widget.ImageView imageView = this.mImageView;
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
            setTextWidth(i);
            setTextHeight(i2);
        }
        return bitmap;
    }

    public void measureSelf(int i, int i2) {
        this.mPaint = new android.text.TextPaint(getPaint());
        int lineWidth = ((int) new android.text.StaticLayout(getText(), this.mPaint, this.mWidthLimit, android.text.Layout.Alignment.ALIGN_NORMAL, this.mSpacingMult, this.mSpacingAdd, true).getLineWidth(0)) + getPaddingLeft() + getPaddingRight();
        if (i < lineWidth) {
            getLayoutParams().width = lineWidth;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        if (this.mScaleByDrawable) {
            int alpha = getPaint().getAlpha();
            getPaint().setAlpha(0);
            super.onDraw(canvas);
            getPaint().setAlpha(alpha);
            return;
        }
        freeze();
        int currentTextColor = getCurrentTextColor();
        setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        java.lang.Integer num = this.mCurrentStrokeColor;
        if (num != null && num.intValue() != 0) {
            android.text.TextPaint paint = getPaint();
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            paint.setStrokeJoin(this.mStrokeJoin);
            paint.setStrokeMiter(this.mStrokeMiter);
            setTextColor(this.mCurrentStrokeColor.intValue());
            float generateStrokeWidth = generateStrokeWidth();
            this.mStrokeWidth = generateStrokeWidth;
            paint.setStrokeWidth(generateStrokeWidth);
            super.onDraw(canvas);
            paint.setStyle(android.graphics.Paint.Style.FILL);
        }
        setTextColor(currentTextColor);
        unfreeze();
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int size;
        int size2;
        if (isNeedSelfMeasure()) {
            super.onMeasure(-2, -2);
            size = getMeasuredWidth();
            size2 = getMeasuredHeight();
            setMeasuredDimension(size + 30, size2 + 30);
            if (size != this.mMaxWidthWhenOutof || size2 != this.mMaxHeightWhenOutof) {
                return;
            }
        } else {
            size = android.view.View.MeasureSpec.getSize(i);
            size2 = android.view.View.MeasureSpec.getSize(i2);
        }
        if (this.mLastHeight == 0 || this.mLastWidth == 0) {
            this.mLastHeight = size2;
            this.mLastWidth = size;
        }
        setMeasuredDimension(size, size2);
        measureSelf(size, size2);
    }

    @Override // android.view.View
    public void postInvalidate() {
        if (this.mFrozen) {
            return;
        }
        super.postInvalidate();
    }

    @Override // android.view.View
    public void postInvalidate(int i, int i2, int i3, int i4) {
        if (this.mFrozen) {
            return;
        }
        super.postInvalidate(i, i2, i3, i4);
    }

    public void reAdjust() {
        adjustTextSize();
    }

    @Override // android.view.View
    public void requestLayout() {
        if (this.mFrozen) {
            return;
        }
        super.requestLayout();
    }

    public void restore(int i, int i2) {
        this.mLastHeight = i2;
        this.mLastWidth = i;
    }

    public void setCurrentColor(int i) {
        this.mCurrentColor = i;
        setTextColor(i);
    }

    public void setEditCompleted(boolean z) {
        this.isEditCompleted = z;
    }

    public void setFontPath(java.lang.String str) {
        this.mFontPath = str;
        if (android.text.TextUtils.isEmpty(str)) {
            setTypeface(android.graphics.Typeface.DEFAULT);
        } else if (new java.io.File(this.mFontPath).exists()) {
            setTypeface(android.graphics.Typeface.createFromFile(str));
        }
    }

    public void setImageView(android.widget.ImageView imageView) {
        this.mImageView = imageView;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.mSpacingMult = f2;
        this.mSpacingAdd = f;
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        super.setLines(i);
        this.mMaxLines = i;
        reAdjust();
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.mMaxLines = i;
        reAdjust();
    }

    public void setMinTextSize(float f) {
        this.mMinTextSize = f;
        reAdjust();
    }

    public void setMirror(boolean z) {
        this.isMirror = z;
        float degrees = (float) java.lang.Math.toDegrees(this.mTextAngle);
        if (z) {
            degrees = -degrees;
        }
        setRotation(degrees);
        requestLayout();
    }

    public void setSelection(int i) {
        android.text.Selection.setSelection((android.text.Spannable) getText(), i);
    }

    @Override // android.widget.TextView
    public void setSingleLine() {
        super.setSingleLine();
        this.mMaxLines = 1;
        reAdjust();
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
        if (z) {
            this.mMaxLines = 1;
        } else {
            this.mMaxLines = -1;
        }
        reAdjust();
    }

    @Override // android.widget.TextView
    public void setText(java.lang.CharSequence charSequence, android.widget.TextView.BufferType bufferType) {
        super.setText(filtrateText(charSequence), android.widget.TextView.BufferType.EDITABLE);
    }

    public void setTextBottom(int i) {
        this.mBottom = i;
    }

    public void setTextHeight(int i) {
        this.mHeight = i;
    }

    public void setTextLeft(int i) {
        this.mLeft = i;
    }

    public void setTextOnly(boolean z) {
        this.isTextOnly = z;
    }

    public void setTextRight(int i) {
        this.mRight = i;
    }

    public void setTextStrokeColor(int i) {
        this.mCurrentStrokeColor = java.lang.Integer.valueOf(i);
        invalidate();
    }

    public void setTextTop(int i) {
        this.mTop = i;
    }

    public void setTextWidth(int i) {
        this.mWidth = i;
    }

    public void setVideoSize(int i, int i2) {
    }

    public void setmTextAngle(float f) {
        this.mTextAngle = f;
        setRotation((float) java.lang.Math.toDegrees(f));
    }

    public void unfreeze() {
        this.mFrozen = false;
    }
}
