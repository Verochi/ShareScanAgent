package androidx.constraintlayout.utils.widget;

/* loaded from: classes.dex */
public class MotionTelltales extends androidx.constraintlayout.utils.widget.MockView {
    private static final java.lang.String TAG = "MotionTelltales";
    android.graphics.Matrix mInvertMatrix;
    androidx.constraintlayout.motion.widget.MotionLayout mMotionLayout;
    private android.graphics.Paint mPaintTelltales;
    int mTailColor;
    float mTailScale;
    int mVelocityMode;
    float[] velocity;

    public MotionTelltales(android.content.Context context) {
        super(context);
        this.mPaintTelltales = new android.graphics.Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new android.graphics.Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(context, null);
    }

    public MotionTelltales(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaintTelltales = new android.graphics.Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new android.graphics.Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(context, attributeSet);
    }

    public MotionTelltales(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaintTelltales = new android.graphics.Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new android.graphics.Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(context, attributeSet);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet) {
        if (attributeSet != null) {
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.MotionTelltales);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == androidx.constraintlayout.widget.R.styleable.MotionTelltales_telltales_tailColor) {
                    this.mTailColor = obtainStyledAttributes.getColor(index, this.mTailColor);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionTelltales_telltales_velocityMode) {
                    this.mVelocityMode = obtainStyledAttributes.getInt(index, this.mVelocityMode);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionTelltales_telltales_tailScale) {
                    this.mTailScale = obtainStyledAttributes.getFloat(index, this.mTailScale);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mPaintTelltales.setColor(this.mTailColor);
        this.mPaintTelltales.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.mInvertMatrix);
        if (this.mMotionLayout == null) {
            android.view.ViewParent parent = getParent();
            if (parent instanceof androidx.constraintlayout.motion.widget.MotionLayout) {
                this.mMotionLayout = (androidx.constraintlayout.motion.widget.MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i = 0; i < 5; i++) {
            float f = fArr[i];
            for (int i2 = 0; i2 < 5; i2++) {
                float f2 = fArr[i2];
                this.mMotionLayout.getViewVelocity(this, f2, f, this.velocity, this.mVelocityMode);
                this.mInvertMatrix.mapVectors(this.velocity);
                float f3 = width * f2;
                float f4 = height * f;
                float[] fArr2 = this.velocity;
                float f5 = fArr2[0];
                float f6 = this.mTailScale;
                float f7 = f4 - (fArr2[1] * f6);
                this.mInvertMatrix.mapVectors(fArr2);
                canvas.drawLine(f3, f4, f3 - (f5 * f6), f7, this.mPaintTelltales);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        postInvalidate();
    }

    public void setText(java.lang.CharSequence charSequence) {
        this.mText = charSequence.toString();
        requestLayout();
    }
}
