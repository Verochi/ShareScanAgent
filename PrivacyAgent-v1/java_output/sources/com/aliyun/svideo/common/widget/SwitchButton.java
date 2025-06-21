package com.aliyun.svideo.common.widget;

/* loaded from: classes.dex */
public class SwitchButton extends android.view.View {
    private static final int STATE_SWITCH_OFF = 1;
    private static final int STATE_SWITCH_OFF2 = 2;
    private static final int STATE_SWITCH_ON = 4;
    private static final int STATE_SWITCH_ON2 = 3;
    protected float animationSpeed;
    private float bAnim;
    private float bLeft;
    private float bOff2LeftX;
    private float bOffLeftX;
    private float bOffset;
    private float bOn2LeftX;
    private float bOnLeftX;
    private final android.graphics.Path bPath;
    private float bRadius;
    private final android.graphics.RectF bRectF;
    private float bRight;
    private float bStrokeWidth;
    private float bWidth;
    protected int colorOff;
    protected int colorOffDark;
    protected int colorPrimary;
    protected int colorPrimaryDark;
    protected int colorShadow;
    protected boolean hasShadow;
    private final android.view.animation.AccelerateInterpolator interpolator;
    private boolean isCanVisibleDrawing;
    protected boolean isOpened;
    private int lastState;
    private com.aliyun.svideo.common.widget.SwitchButton.OnStateChangedListener listener;
    private android.view.View.OnClickListener mOnClickListener;
    private final android.graphics.Paint paint;
    protected float ratioAspect;
    private float sAnim;
    private float sCenterX;
    private float sCenterY;
    private final android.graphics.Path sPath;
    private float sRight;
    private float sScale;
    private android.graphics.RadialGradient shadowGradient;
    private float shadowReservedHeight;
    private int state;

    /* renamed from: com.aliyun.svideo.common.widget.SwitchButton$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.common.widget.SwitchButton.OnStateChangedListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.common.widget.SwitchButton.OnStateChangedListener
        public void toggleToOff(com.aliyun.svideo.common.widget.SwitchButton switchButton) {
            com.aliyun.svideo.common.widget.SwitchButton.this.toggleSwitch(false);
        }

        @Override // com.aliyun.svideo.common.widget.SwitchButton.OnStateChangedListener
        public void toggleToOn(com.aliyun.svideo.common.widget.SwitchButton switchButton) {
            com.aliyun.svideo.common.widget.SwitchButton.this.toggleSwitch(true);
        }
    }

    public interface OnStateChangedListener {
        void toggleToOff(com.aliyun.svideo.common.widget.SwitchButton switchButton);

        void toggleToOn(com.aliyun.svideo.common.widget.SwitchButton switchButton);
    }

    public static final class SavedState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<com.aliyun.svideo.common.widget.SwitchButton.SavedState> CREATOR = new com.aliyun.svideo.common.widget.SwitchButton.SavedState.AnonymousClass1();
        private boolean isOpened;

        /* renamed from: com.aliyun.svideo.common.widget.SwitchButton$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<com.aliyun.svideo.common.widget.SwitchButton.SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.aliyun.svideo.common.widget.SwitchButton.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.aliyun.svideo.common.widget.SwitchButton.SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.aliyun.svideo.common.widget.SwitchButton.SavedState[] newArray(int i) {
                return new com.aliyun.svideo.common.widget.SwitchButton.SavedState[i];
            }
        }

        private SavedState(android.os.Parcel parcel) {
            super(parcel);
            this.isOpened = 1 == parcel.readInt();
        }

        public /* synthetic */ SavedState(android.os.Parcel parcel, defpackage.nu2 nu2Var) {
            this(parcel);
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isOpened ? 1 : 0);
        }
    }

    public SwitchButton(android.content.Context context) {
        this(context, null);
    }

    @android.annotation.TargetApi(11)
    public SwitchButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.interpolator = new android.view.animation.AccelerateInterpolator(2.0f);
        this.paint = new android.graphics.Paint();
        this.sPath = new android.graphics.Path();
        this.bPath = new android.graphics.Path();
        this.bRectF = new android.graphics.RectF();
        this.ratioAspect = 0.68f;
        this.animationSpeed = 0.1f;
        this.isCanVisibleDrawing = false;
        this.listener = new com.aliyun.svideo.common.widget.SwitchButton.AnonymousClass1();
        setLayerType(1, null);
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.aliyun.svideo.common.R.styleable.SwitchButton);
        this.colorPrimary = obtainStyledAttributes.getColor(com.aliyun.svideo.common.R.styleable.SwitchButton_primaryColor, -11806877);
        this.colorPrimaryDark = obtainStyledAttributes.getColor(com.aliyun.svideo.common.R.styleable.SwitchButton_primaryColorDark, -12925358);
        this.colorOff = obtainStyledAttributes.getColor(com.aliyun.svideo.common.R.styleable.SwitchButton_offColor, -1842205);
        this.colorOffDark = obtainStyledAttributes.getColor(com.aliyun.svideo.common.R.styleable.SwitchButton_offColorDark, -4210753);
        this.colorShadow = obtainStyledAttributes.getColor(com.aliyun.svideo.common.R.styleable.SwitchButton_shadowColor, -13421773);
        this.ratioAspect = obtainStyledAttributes.getFloat(com.aliyun.svideo.common.R.styleable.SwitchButton_ratioAspect, 0.68f);
        this.hasShadow = obtainStyledAttributes.getBoolean(com.aliyun.svideo.common.R.styleable.SwitchButton_hasShadow, true);
        boolean z = obtainStyledAttributes.getBoolean(com.aliyun.svideo.common.R.styleable.SwitchButton_isOpened, false);
        this.isOpened = z;
        int i = z ? 4 : 1;
        this.state = i;
        this.lastState = i;
        obtainStyledAttributes.recycle();
        if (this.colorPrimary == -11806877 && this.colorPrimaryDark == -12925358) {
            try {
                android.util.TypedValue typedValue = new android.util.TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorPrimary, typedValue, true);
                int i2 = typedValue.data;
                if (i2 > 0) {
                    this.colorPrimary = i2;
                }
                android.util.TypedValue typedValue2 = new android.util.TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorPrimaryDark, typedValue2, true);
                int i3 = typedValue2.data;
                if (i3 > 0) {
                    this.colorPrimaryDark = i3;
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private void calcBPath(float f) {
        this.bPath.reset();
        android.graphics.RectF rectF = this.bRectF;
        float f2 = this.bLeft;
        float f3 = this.bStrokeWidth;
        rectF.left = f2 + (f3 / 2.0f);
        rectF.right = this.bRight - (f3 / 2.0f);
        this.bPath.arcTo(rectF, 90.0f, 180.0f);
        android.graphics.RectF rectF2 = this.bRectF;
        float f4 = this.bLeft;
        float f5 = this.bOffset;
        float f6 = this.bStrokeWidth;
        rectF2.left = f4 + (f * f5) + (f6 / 2.0f);
        rectF2.right = (this.bRight + (f * f5)) - (f6 / 2.0f);
        this.bPath.arcTo(rectF2, 270.0f, 180.0f);
        this.bPath.close();
    }

    private float calcBTranslate(float f) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i = this.state;
        int i2 = i - this.lastState;
        if (i2 != -3) {
            if (i2 != -2) {
                if (i2 != -1) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            if (i == 4) {
                                f5 = this.bOnLeftX;
                                f6 = this.bOffLeftX;
                            } else {
                                if (i == 3) {
                                    f5 = this.bOn2LeftX;
                                    f6 = this.bOffLeftX;
                                }
                                f4 = 0.0f;
                            }
                            f4 = f5 - ((f5 - f6) * f);
                        } else if (i2 == 3) {
                            f5 = this.bOnLeftX;
                            f6 = this.bOffLeftX;
                            f4 = f5 - ((f5 - f6) * f);
                        } else if (i == 1) {
                            f4 = this.bOffLeftX;
                        } else {
                            if (i == 4) {
                                f4 = this.bOnLeftX;
                            }
                            f4 = 0.0f;
                        }
                    } else if (i == 2) {
                        f4 = this.bOffLeftX;
                    } else {
                        if (i == 4) {
                            f5 = this.bOnLeftX;
                            f6 = this.bOn2LeftX;
                            f4 = f5 - ((f5 - f6) * f);
                        }
                        f4 = 0.0f;
                    }
                } else if (i == 3) {
                    f2 = this.bOn2LeftX;
                    f3 = this.bOnLeftX;
                } else {
                    if (i == 1) {
                        f4 = this.bOffLeftX;
                    }
                    f4 = 0.0f;
                }
            } else if (i == 1) {
                f2 = this.bOffLeftX;
                f3 = this.bOn2LeftX;
            } else {
                if (i == 2) {
                    f2 = this.bOff2LeftX;
                    f3 = this.bOnLeftX;
                }
                f4 = 0.0f;
            }
            return f4 - this.bOffLeftX;
        }
        f2 = this.bOffLeftX;
        f3 = this.bOnLeftX;
        f4 = f2 + ((f3 - f2) * f);
        return f4 - this.bOffLeftX;
    }

    private void refreshState(int i) {
        boolean z = this.isOpened;
        if (!z && i == 4) {
            this.isOpened = true;
        } else if (z && i == 1) {
            this.isOpened = false;
        }
        this.lastState = this.state;
        this.state = i;
        postInvalidate();
    }

    public boolean isOpened() {
        return this.isOpened;
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (this.isCanVisibleDrawing) {
            boolean z = true;
            this.paint.setAntiAlias(true);
            int i = this.state;
            boolean z2 = i == 4 || i == 3;
            this.paint.setStyle(android.graphics.Paint.Style.FILL);
            this.paint.setColor(z2 ? this.colorPrimary : this.colorOff);
            canvas.drawPath(this.sPath, this.paint);
            float f = this.sAnim;
            float f2 = this.animationSpeed;
            float f3 = f - f2 > 0.0f ? f - f2 : 0.0f;
            this.sAnim = f3;
            float f4 = this.bAnim;
            this.bAnim = f4 - f2 > 0.0f ? f4 - f2 : 0.0f;
            float interpolation = this.interpolator.getInterpolation(f3);
            float interpolation2 = this.interpolator.getInterpolation(this.bAnim);
            float f5 = this.sScale * (z2 ? interpolation : 1.0f - interpolation);
            float f6 = (this.sRight - this.sCenterX) - this.bRadius;
            if (z2) {
                interpolation = 1.0f - interpolation;
            }
            canvas.save();
            canvas.scale(f5, f5, this.sCenterX + (f6 * interpolation), this.sCenterY);
            this.paint.setColor(-1);
            canvas.drawPath(this.sPath, this.paint);
            canvas.restore();
            canvas.save();
            canvas.translate(calcBTranslate(interpolation2), this.shadowReservedHeight);
            int i2 = this.state;
            if (i2 != 3 && i2 != 2) {
                z = false;
            }
            if (z) {
                interpolation2 = 1.0f - interpolation2;
            }
            calcBPath(interpolation2);
            if (this.hasShadow) {
                this.paint.setStyle(android.graphics.Paint.Style.FILL);
                this.paint.setShader(this.shadowGradient);
                canvas.drawPath(this.bPath, this.paint);
                this.paint.setShader(null);
            }
            canvas.translate(0.0f, -this.shadowReservedHeight);
            float f7 = this.bWidth;
            canvas.scale(0.98f, 0.98f, f7 / 2.0f, f7 / 2.0f);
            this.paint.setStyle(android.graphics.Paint.Style.FILL);
            this.paint.setColor(-1);
            canvas.drawPath(this.bPath, this.paint);
            this.paint.setStyle(android.graphics.Paint.Style.STROKE);
            this.paint.setStrokeWidth(this.bStrokeWidth * 0.5f);
            this.paint.setColor(z2 ? this.colorPrimaryDark : this.colorOffDark);
            canvas.drawPath(this.bPath, this.paint);
            canvas.restore();
            this.paint.reset();
            if (this.sAnim > 0.0f || this.bAnim > 0.0f) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = android.view.View.MeasureSpec.getSize(i);
        int mode = android.view.View.MeasureSpec.getMode(i);
        if (mode != 1073741824) {
            int paddingLeft = ((int) ((getResources().getDisplayMetrics().density * 56.0f) + 0.5f)) + getPaddingLeft() + getPaddingRight();
            size = mode == Integer.MIN_VALUE ? java.lang.Math.min(paddingLeft, size) : paddingLeft;
        }
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        if (mode2 != 1073741824) {
            int paddingTop = ((int) (size * this.ratioAspect)) + getPaddingTop() + getPaddingBottom();
            size2 = mode2 == Integer.MIN_VALUE ? java.lang.Math.min(paddingTop, size2) : paddingTop;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        com.aliyun.svideo.common.widget.SwitchButton.SavedState savedState = (com.aliyun.svideo.common.widget.SwitchButton.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        boolean z = savedState.isOpened;
        this.isOpened = z;
        this.state = z ? 4 : 1;
        invalidate();
    }

    @Override // android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        com.aliyun.svideo.common.widget.SwitchButton.SavedState savedState = new com.aliyun.svideo.common.widget.SwitchButton.SavedState(super.onSaveInstanceState());
        savedState.isOpened = this.isOpened;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int width;
        int paddingTop;
        int height;
        super.onSizeChanged(i, i2, i3, i4);
        boolean z = i > getPaddingLeft() + getPaddingRight() && i2 > getPaddingTop() + getPaddingBottom();
        this.isCanVisibleDrawing = z;
        if (z) {
            int paddingLeft2 = (i - getPaddingLeft()) - getPaddingRight();
            int paddingTop2 = (i2 - getPaddingTop()) - getPaddingBottom();
            float f = paddingLeft2;
            float f2 = this.ratioAspect;
            float f3 = paddingTop2;
            if (f * f2 < f3) {
                paddingLeft = getPaddingLeft();
                width = i - getPaddingRight();
                int i5 = ((int) (f3 - (f * this.ratioAspect))) / 2;
                paddingTop = getPaddingTop() + i5;
                height = (getHeight() - getPaddingBottom()) - i5;
            } else {
                int i6 = ((int) (f - (f3 / f2))) / 2;
                paddingLeft = getPaddingLeft() + i6;
                width = (getWidth() - getPaddingRight()) - i6;
                paddingTop = getPaddingTop();
                height = getHeight() - getPaddingBottom();
            }
            float f4 = (int) ((height - paddingTop) * 0.07f);
            this.shadowReservedHeight = f4;
            float f5 = paddingLeft;
            float f6 = paddingTop + f4;
            float f7 = width;
            this.sRight = f7;
            float f8 = height - f4;
            float f9 = f8 - f6;
            this.sCenterX = (f7 + f5) / 2.0f;
            float f10 = (f8 + f6) / 2.0f;
            this.sCenterY = f10;
            this.bLeft = f5;
            this.bWidth = f9;
            this.bRight = f5 + f9;
            float f11 = f9 / 2.0f;
            float f12 = 0.95f * f11;
            this.bRadius = f12;
            float f13 = 0.2f * f12;
            this.bOffset = f13;
            float f14 = (f11 - f12) * 2.0f;
            this.bStrokeWidth = f14;
            float f15 = f7 - f9;
            this.bOnLeftX = f15;
            this.bOn2LeftX = f15 - f13;
            this.bOffLeftX = f5;
            this.bOff2LeftX = f13 + f5;
            this.sScale = 1.0f - (f14 / f9);
            this.sPath.reset();
            android.graphics.RectF rectF = new android.graphics.RectF();
            rectF.top = f6;
            rectF.bottom = f8;
            rectF.left = f5;
            rectF.right = f5 + f9;
            this.sPath.arcTo(rectF, 90.0f, 180.0f);
            float f16 = this.sRight;
            rectF.left = f16 - f9;
            rectF.right = f16;
            this.sPath.arcTo(rectF, 270.0f, 180.0f);
            this.sPath.close();
            android.graphics.RectF rectF2 = this.bRectF;
            float f17 = this.bLeft;
            rectF2.left = f17;
            float f18 = this.bRight;
            rectF2.right = f18;
            float f19 = this.bStrokeWidth;
            rectF2.top = f6 + (f19 / 2.0f);
            rectF2.bottom = f8 - (f19 / 2.0f);
            float f20 = (f18 + f17) / 2.0f;
            int i7 = this.colorShadow;
            int i8 = (i7 >> 16) & 255;
            int i9 = (i7 >> 8) & 255;
            int i10 = i7 & 255;
            this.shadowGradient = new android.graphics.RadialGradient(f20, f10, this.bRadius, android.graphics.Color.argb(200, i8, i9, i10), android.graphics.Color.argb(25, i8, i9, i10), android.graphics.Shader.TileMode.CLAMP);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int i = this.state;
        if ((i == 4 || i == 1) && this.sAnim * this.bAnim == 0.0f) {
            int action = motionEvent.getAction();
            if (action == 0) {
                return true;
            }
            if (action == 1) {
                int i2 = this.state;
                this.lastState = i2;
                this.bAnim = 1.0f;
                if (i2 == 1) {
                    refreshState(2);
                    this.listener.toggleToOn(this);
                } else if (i2 == 4) {
                    refreshState(3);
                    this.listener.toggleToOff(this);
                }
                android.view.View.OnClickListener onClickListener = this.mOnClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setColor(int i, int i2) {
        setColor(i, i2, this.colorOff, this.colorOffDark);
    }

    public void setColor(int i, int i2, int i3, int i4) {
        setColor(i, i2, i3, i4, this.colorShadow);
    }

    public void setColor(int i, int i2, int i3, int i4, int i5) {
        this.colorPrimary = i;
        this.colorPrimaryDark = i2;
        this.colorOff = i3;
        this.colorOffDark = i4;
        this.colorShadow = i5;
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(android.view.View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setOnStateChangedListener(com.aliyun.svideo.common.widget.SwitchButton.OnStateChangedListener onStateChangedListener) {
        if (onStateChangedListener == null) {
            throw new java.lang.IllegalArgumentException("empty listener");
        }
        this.listener = onStateChangedListener;
    }

    public void setOpened(boolean z) {
        int i = z ? 4 : 1;
        if (i == this.state) {
            return;
        }
        refreshState(i);
    }

    public void setShadow(boolean z) {
        this.hasShadow = z;
        invalidate();
    }

    public void toggleSwitch(boolean z) {
        int i = z ? 4 : 1;
        int i2 = this.state;
        if (i == i2) {
            return;
        }
        if ((i == 4 && (i2 == 1 || i2 == 2)) || (i == 1 && (i2 == 4 || i2 == 3))) {
            this.sAnim = 1.0f;
        }
        this.bAnim = 1.0f;
        refreshState(i);
    }
}
