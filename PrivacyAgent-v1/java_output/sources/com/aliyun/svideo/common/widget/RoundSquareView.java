package com.aliyun.svideo.common.widget;

/* loaded from: classes.dex */
public class RoundSquareView extends android.widget.ImageView {
    private android.graphics.Bitmap mBitmap;
    private android.graphics.Paint paint;
    private android.graphics.Paint paint2;
    private int roundHeight;
    private int roundWidth;

    public RoundSquareView(android.content.Context context) {
        super(context);
        this.roundWidth = 5;
        this.roundHeight = 5;
        init(context, null);
    }

    public RoundSquareView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.roundWidth = 5;
        this.roundHeight = 5;
        init(context, attributeSet);
    }

    public RoundSquareView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.roundWidth = 5;
        this.roundHeight = 5;
        init(context, attributeSet);
    }

    private void drawLiftDown(android.graphics.Canvas canvas) {
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(0.0f, getHeight() - this.roundHeight);
        path.lineTo(0.0f, getHeight());
        path.lineTo(this.roundWidth, getHeight());
        path.arcTo(new android.graphics.RectF(0.0f, getHeight() - (this.roundHeight * 2), (this.roundWidth * 2) + 0, getHeight()), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.paint);
    }

    private void drawLiftUp(android.graphics.Canvas canvas) {
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(0.0f, this.roundHeight);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.roundWidth, 0.0f);
        path.arcTo(new android.graphics.RectF(0.0f, 0.0f, this.roundWidth * 2, this.roundHeight * 2), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.paint);
    }

    private void drawRightDown(android.graphics.Canvas canvas) {
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(getWidth() - this.roundWidth, getHeight());
        path.lineTo(getWidth(), getHeight());
        path.lineTo(getWidth(), getHeight() - this.roundHeight);
        path.arcTo(new android.graphics.RectF(getWidth() - (this.roundWidth * 2), getHeight() - (this.roundHeight * 2), getWidth(), getHeight()), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.paint);
    }

    private void drawRightUp(android.graphics.Canvas canvas) {
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(getWidth(), this.roundHeight);
        path.lineTo(getWidth(), 0.0f);
        path.lineTo(getWidth() - this.roundWidth, 0.0f);
        path.arcTo(new android.graphics.RectF(getWidth() - (this.roundWidth * 2), 0.0f, getWidth(), (this.roundHeight * 2) + 0), -90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.paint);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet) {
        if (attributeSet != null) {
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.aliyun.svideo.common.R.styleable.QuViewRoundAngleImageView);
            this.roundWidth = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.common.R.styleable.QuViewRoundAngleImageView_roundWidth, this.roundWidth);
            this.roundHeight = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.common.R.styleable.QuViewRoundAngleImageView_roundHeight, this.roundHeight);
        } else {
            float f = context.getResources().getDisplayMetrics().density;
            this.roundWidth = (int) (this.roundWidth * f);
            this.roundHeight = (int) (this.roundHeight * f);
        }
        android.graphics.Paint paint = new android.graphics.Paint();
        this.paint = paint;
        paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.paint2 = paint2;
        paint2.setXfermode(null);
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        if (this.mBitmap == null) {
            this.mBitmap = android.graphics.Bitmap.createBitmap(getWidth(), getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        }
        android.graphics.Canvas canvas2 = new android.graphics.Canvas(this.mBitmap);
        super.draw(canvas2);
        drawLiftUp(canvas2);
        drawRightUp(canvas2);
        drawLiftDown(canvas2);
        drawRightDown(canvas2);
        canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, this.paint2);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        android.graphics.Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mBitmap = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, measuredWidth);
    }
}
