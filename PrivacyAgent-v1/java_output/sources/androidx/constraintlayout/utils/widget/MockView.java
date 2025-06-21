package androidx.constraintlayout.utils.widget;

/* loaded from: classes.dex */
public class MockView extends android.view.View {
    private int mDiagonalsColor;
    private boolean mDrawDiagonals;
    private boolean mDrawLabel;
    private int mMargin;
    private android.graphics.Paint mPaintDiagonals;
    private android.graphics.Paint mPaintText;
    private android.graphics.Paint mPaintTextBackground;
    protected java.lang.String mText;
    private int mTextBackgroundColor;
    private android.graphics.Rect mTextBounds;
    private int mTextColor;

    public MockView(android.content.Context context) {
        super(context);
        this.mPaintDiagonals = new android.graphics.Paint();
        this.mPaintText = new android.graphics.Paint();
        this.mPaintTextBackground = new android.graphics.Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new android.graphics.Rect();
        this.mDiagonalsColor = android.graphics.Color.argb(255, 0, 0, 0);
        this.mTextColor = android.graphics.Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = android.graphics.Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(context, null);
    }

    public MockView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaintDiagonals = new android.graphics.Paint();
        this.mPaintText = new android.graphics.Paint();
        this.mPaintTextBackground = new android.graphics.Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new android.graphics.Rect();
        this.mDiagonalsColor = android.graphics.Color.argb(255, 0, 0, 0);
        this.mTextColor = android.graphics.Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = android.graphics.Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(context, attributeSet);
    }

    public MockView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaintDiagonals = new android.graphics.Paint();
        this.mPaintText = new android.graphics.Paint();
        this.mPaintTextBackground = new android.graphics.Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new android.graphics.Rect();
        this.mDiagonalsColor = android.graphics.Color.argb(255, 0, 0, 0);
        this.mTextColor = android.graphics.Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = android.graphics.Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(context, attributeSet);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet) {
        if (attributeSet != null) {
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == androidx.constraintlayout.widget.R.styleable.MockView_mock_label) {
                    this.mText = obtainStyledAttributes.getString(index);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MockView_mock_showDiagonals) {
                    this.mDrawDiagonals = obtainStyledAttributes.getBoolean(index, this.mDrawDiagonals);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MockView_mock_diagonalsColor) {
                    this.mDiagonalsColor = obtainStyledAttributes.getColor(index, this.mDiagonalsColor);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MockView_mock_labelBackgroundColor) {
                    this.mTextBackgroundColor = obtainStyledAttributes.getColor(index, this.mTextBackgroundColor);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MockView_mock_labelColor) {
                    this.mTextColor = obtainStyledAttributes.getColor(index, this.mTextColor);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MockView_mock_showLabel) {
                    this.mDrawLabel = obtainStyledAttributes.getBoolean(index, this.mDrawLabel);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.mText == null) {
            try {
                this.mText = context.getResources().getResourceEntryName(getId());
            } catch (java.lang.Exception unused) {
            }
        }
        this.mPaintDiagonals.setColor(this.mDiagonalsColor);
        this.mPaintDiagonals.setAntiAlias(true);
        this.mPaintText.setColor(this.mTextColor);
        this.mPaintText.setAntiAlias(true);
        this.mPaintTextBackground.setColor(this.mTextBackgroundColor);
        this.mMargin = java.lang.Math.round(this.mMargin * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.mDrawDiagonals) {
            width--;
            height--;
            float f = width;
            float f2 = height;
            canvas.drawLine(0.0f, 0.0f, f, f2, this.mPaintDiagonals);
            canvas.drawLine(0.0f, f2, f, 0.0f, this.mPaintDiagonals);
            canvas.drawLine(0.0f, 0.0f, f, 0.0f, this.mPaintDiagonals);
            canvas.drawLine(f, 0.0f, f, f2, this.mPaintDiagonals);
            canvas.drawLine(f, f2, 0.0f, f2, this.mPaintDiagonals);
            canvas.drawLine(0.0f, f2, 0.0f, 0.0f, this.mPaintDiagonals);
        }
        java.lang.String str = this.mText;
        if (str == null || !this.mDrawLabel) {
            return;
        }
        this.mPaintText.getTextBounds(str, 0, str.length(), this.mTextBounds);
        float width2 = (width - this.mTextBounds.width()) / 2.0f;
        float height2 = ((height - this.mTextBounds.height()) / 2.0f) + this.mTextBounds.height();
        this.mTextBounds.offset((int) width2, (int) height2);
        android.graphics.Rect rect = this.mTextBounds;
        int i = rect.left;
        int i2 = this.mMargin;
        rect.set(i - i2, rect.top - i2, rect.right + i2, rect.bottom + i2);
        canvas.drawRect(this.mTextBounds, this.mPaintTextBackground);
        canvas.drawText(this.mText, width2, height2, this.mPaintText);
    }
}
