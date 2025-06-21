package androidx.constraintlayout.utils.widget;

/* loaded from: classes.dex */
public class ImageFilterView extends androidx.appcompat.widget.AppCompatImageView {
    private float mCrossfade;
    private androidx.constraintlayout.utils.widget.ImageFilterView.ImageMatrix mImageMatrix;
    android.graphics.drawable.LayerDrawable mLayer;
    android.graphics.drawable.Drawable[] mLayers;
    private boolean mOverlay;
    private android.graphics.Path mPath;
    android.graphics.RectF mRect;
    private float mRound;
    private float mRoundPercent;
    android.view.ViewOutlineProvider mViewOutlineProvider;

    /* renamed from: androidx.constraintlayout.utils.widget.ImageFilterView$1, reason: invalid class name */
    public class AnonymousClass1 extends android.view.ViewOutlineProvider {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(android.view.View view, android.graphics.Outline outline) {
            outline.setRoundRect(0, 0, androidx.constraintlayout.utils.widget.ImageFilterView.this.getWidth(), androidx.constraintlayout.utils.widget.ImageFilterView.this.getHeight(), (java.lang.Math.min(r3, r4) * androidx.constraintlayout.utils.widget.ImageFilterView.this.mRoundPercent) / 2.0f);
        }
    }

    /* renamed from: androidx.constraintlayout.utils.widget.ImageFilterView$2, reason: invalid class name */
    public class AnonymousClass2 extends android.view.ViewOutlineProvider {
        public AnonymousClass2() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(android.view.View view, android.graphics.Outline outline) {
            outline.setRoundRect(0, 0, androidx.constraintlayout.utils.widget.ImageFilterView.this.getWidth(), androidx.constraintlayout.utils.widget.ImageFilterView.this.getHeight(), androidx.constraintlayout.utils.widget.ImageFilterView.this.mRound);
        }
    }

    public static class ImageMatrix {
        float[] m = new float[20];
        android.graphics.ColorMatrix mColorMatrix = new android.graphics.ColorMatrix();
        android.graphics.ColorMatrix mTmpColorMatrix = new android.graphics.ColorMatrix();
        float mBrightness = 1.0f;
        float mSaturation = 1.0f;
        float mContrast = 1.0f;
        float mWarmth = 1.0f;

        private void brightness(float f) {
            float[] fArr = this.m;
            fArr[0] = f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void saturation(float f) {
            float f2 = 1.0f - f;
            float f3 = 0.2999f * f2;
            float f4 = 0.587f * f2;
            float f5 = f2 * 0.114f;
            float[] fArr = this.m;
            fArr[0] = f3 + f;
            fArr[1] = f4;
            fArr[2] = f5;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f3;
            fArr[6] = f4 + f;
            fArr[7] = f5;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f3;
            fArr[11] = f4;
            fArr[12] = f5 + f;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void warmth(float f) {
            float log;
            float f2;
            if (f <= 0.0f) {
                f = 0.01f;
            }
            float f3 = (5000.0f / f) / 100.0f;
            if (f3 > 66.0f) {
                double d = f3 - 60.0f;
                f2 = ((float) java.lang.Math.pow(d, -0.13320475816726685d)) * 329.69873f;
                log = ((float) java.lang.Math.pow(d, 0.07551484555006027d)) * 288.12216f;
            } else {
                log = (((float) java.lang.Math.log(f3)) * 99.4708f) - 161.11957f;
                f2 = 255.0f;
            }
            float log2 = f3 < 66.0f ? f3 > 19.0f ? (((float) java.lang.Math.log(f3 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float min = java.lang.Math.min(255.0f, java.lang.Math.max(f2, 0.0f));
            float min2 = java.lang.Math.min(255.0f, java.lang.Math.max(log, 0.0f));
            float min3 = java.lang.Math.min(255.0f, java.lang.Math.max(log2, 0.0f));
            float log3 = (((float) java.lang.Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float log4 = (((float) java.lang.Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float min4 = java.lang.Math.min(255.0f, java.lang.Math.max(255.0f, 0.0f));
            float min5 = java.lang.Math.min(255.0f, java.lang.Math.max(log3, 0.0f));
            float min6 = min3 / java.lang.Math.min(255.0f, java.lang.Math.max(log4, 0.0f));
            float[] fArr = this.m;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public void updateMatrix(android.widget.ImageView imageView) {
            boolean z;
            this.mColorMatrix.reset();
            float f = this.mSaturation;
            boolean z2 = true;
            if (f != 1.0f) {
                saturation(f);
                this.mColorMatrix.set(this.m);
                z = true;
            } else {
                z = false;
            }
            float f2 = this.mContrast;
            if (f2 != 1.0f) {
                this.mTmpColorMatrix.setScale(f2, f2, f2, 1.0f);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                z = true;
            }
            float f3 = this.mWarmth;
            if (f3 != 1.0f) {
                warmth(f3);
                this.mTmpColorMatrix.set(this.m);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                z = true;
            }
            float f4 = this.mBrightness;
            if (f4 != 1.0f) {
                brightness(f4);
                this.mTmpColorMatrix.set(this.m);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            } else {
                z2 = z;
            }
            if (z2) {
                imageView.setColorFilter(new android.graphics.ColorMatrixColorFilter(this.mColorMatrix));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(android.content.Context context) {
        super(context);
        this.mImageMatrix = new androidx.constraintlayout.utils.widget.ImageFilterView.ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(context, null);
    }

    public ImageFilterView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mImageMatrix = new androidx.constraintlayout.utils.widget.ImageFilterView.ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(context, attributeSet);
    }

    public ImageFilterView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mImageMatrix = new androidx.constraintlayout.utils.widget.ImageFilterView.ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(context, attributeSet);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet) {
        if (attributeSet != null) {
            android.content.res.TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            android.graphics.drawable.Drawable drawable = obtainStyledAttributes.getDrawable(androidx.constraintlayout.widget.R.styleable.ImageFilterView_altSrc);
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == androidx.constraintlayout.widget.R.styleable.ImageFilterView_crossfade) {
                    this.mCrossfade = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == androidx.constraintlayout.widget.R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == androidx.constraintlayout.widget.R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == androidx.constraintlayout.widget.R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == androidx.constraintlayout.widget.R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == androidx.constraintlayout.widget.R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == androidx.constraintlayout.widget.R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.mOverlay));
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                android.graphics.drawable.Drawable[] drawableArr = new android.graphics.drawable.Drawable[2];
                this.mLayers = drawableArr;
                drawableArr[0] = getDrawable();
                this.mLayers[1] = drawable;
                android.graphics.drawable.LayerDrawable layerDrawable = new android.graphics.drawable.LayerDrawable(this.mLayers);
                this.mLayer = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
                super.setImageDrawable(this.mLayer);
            }
        }
    }

    private void setOverlay(boolean z) {
        this.mOverlay = z;
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.mImageMatrix.mBrightness;
    }

    public float getContrast() {
        return this.mImageMatrix.mContrast;
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getSaturation() {
        return this.mImageMatrix.mSaturation;
    }

    public float getWarmth() {
        return this.mImageMatrix.mWarmth;
    }

    public void setBrightness(float f) {
        androidx.constraintlayout.utils.widget.ImageFilterView.ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mBrightness = f;
        imageMatrix.updateMatrix(this);
    }

    public void setContrast(float f) {
        androidx.constraintlayout.utils.widget.ImageFilterView.ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mContrast = f;
        imageMatrix.updateMatrix(this);
    }

    public void setCrossfade(float f) {
        this.mCrossfade = f;
        if (this.mLayers != null) {
            if (!this.mOverlay) {
                this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
            }
            this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
            super.setImageDrawable(this.mLayer);
        }
    }

    @androidx.annotation.RequiresApi(21)
    public void setRound(float f) {
        if (java.lang.Float.isNaN(f)) {
            this.mRound = f;
            float f2 = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.mRound != f;
        this.mRound = f;
        if (f != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new android.graphics.Path();
            }
            if (this.mRect == null) {
                this.mRect = new android.graphics.RectF();
            }
            if (this.mViewOutlineProvider == null) {
                androidx.constraintlayout.utils.widget.ImageFilterView.AnonymousClass2 anonymousClass2 = new androidx.constraintlayout.utils.widget.ImageFilterView.AnonymousClass2();
                this.mViewOutlineProvider = anonymousClass2;
                setOutlineProvider(anonymousClass2);
            }
            setClipToOutline(true);
            this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
            this.mPath.reset();
            android.graphics.Path path = this.mPath;
            android.graphics.RectF rectF = this.mRect;
            float f3 = this.mRound;
            path.addRoundRect(rectF, f3, f3, android.graphics.Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    @androidx.annotation.RequiresApi(21)
    public void setRoundPercent(float f) {
        boolean z = this.mRoundPercent != f;
        this.mRoundPercent = f;
        if (f != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new android.graphics.Path();
            }
            if (this.mRect == null) {
                this.mRect = new android.graphics.RectF();
            }
            if (this.mViewOutlineProvider == null) {
                androidx.constraintlayout.utils.widget.ImageFilterView.AnonymousClass1 anonymousClass1 = new androidx.constraintlayout.utils.widget.ImageFilterView.AnonymousClass1();
                this.mViewOutlineProvider = anonymousClass1;
                setOutlineProvider(anonymousClass1);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (java.lang.Math.min(width, height) * this.mRoundPercent) / 2.0f;
            this.mRect.set(0.0f, 0.0f, width, height);
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, min, min, android.graphics.Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f) {
        androidx.constraintlayout.utils.widget.ImageFilterView.ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mSaturation = f;
        imageMatrix.updateMatrix(this);
    }

    public void setWarmth(float f) {
        androidx.constraintlayout.utils.widget.ImageFilterView.ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mWarmth = f;
        imageMatrix.updateMatrix(this);
    }
}
