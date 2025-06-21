package com.aliyun.svideo.base.widget;

/* loaded from: classes.dex */
public class MusicWaveView extends android.view.View {
    private static final float MIN_WAVE_RATE = 0.25f;
    private static final java.lang.String TAG = "MusicWaveView";
    private static final int WAVE_OFFSET = 2;
    private static final int WAVE_WIDTH = 6;
    private int mDisplayTime;
    private int mHeight;
    private android.graphics.Paint mPaint;
    private android.graphics.Rect mRect;
    private int mScreenWidth;
    private int mSelectBgWidth;
    private int mStartOffset;
    private int mTotalTime;
    private float[] mWaveArray;
    private int mWaveHeight;
    private int mWidth;

    public MusicWaveView(android.content.Context context) {
        super(context);
        this.mPaint = new android.graphics.Paint();
        this.mRect = new android.graphics.Rect();
        init(context);
    }

    public MusicWaveView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new android.graphics.Paint();
        this.mRect = new android.graphics.Rect();
        init(context);
    }

    public MusicWaveView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new android.graphics.Paint();
        this.mRect = new android.graphics.Rect();
        init(context);
    }

    private void generateWaveArray() {
        int i = (this.mWidth - (this.mStartOffset * 2)) / 8;
        this.mWaveArray = new float[i];
        java.util.Random random = new java.util.Random();
        random.setSeed(this.mTotalTime);
        for (int i2 = 0; i2 < i; i2++) {
            this.mWaveArray[i2] = random.nextFloat();
            float[] fArr = this.mWaveArray;
            float f = fArr[i2];
            if (f < 0.25f) {
                fArr[i2] = f + 0.25f;
            }
        }
    }

    private void init(android.content.Context context) {
        this.mWaveHeight = com.aliyun.common.utils.DensityUtil.dip2px(context, 40.0f);
        this.mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
        int dip2px = com.aliyun.common.utils.DensityUtil.dip2px(context, 200.0f);
        this.mSelectBgWidth = dip2px;
        this.mStartOffset = (this.mScreenWidth - dip2px) / 2;
        setWillNotDraw(false);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(-1);
    }

    public int getMusicLayoutWidth() {
        return this.mWidth - (this.mStartOffset * 2);
    }

    public void layout() {
        int i;
        int i2 = this.mDisplayTime;
        if (i2 == 0 || (i = this.mTotalTime) == 0) {
            return;
        }
        int i3 = ((int) ((i / i2) * this.mSelectBgWidth)) + (this.mStartOffset * 2);
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.width = i3;
        setLayoutParams(layoutParams);
        this.mWidth = i3;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("lWidth...");
        sb.append(i3);
        this.mHeight = layoutParams.height;
        generateWaveArray();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (getHeight() == 0 || this.mWaveArray == null) {
            return;
        }
        int i = 0;
        while (true) {
            float[] fArr = this.mWaveArray;
            if (i >= fArr.length) {
                return;
            }
            int i2 = (int) (this.mWaveHeight * fArr[i]);
            int i3 = (i * 8) + this.mStartOffset;
            int height = (getHeight() - i2) / 2;
            this.mRect.set(i3, height, i3 + 6, i2 + height);
            canvas.drawRect(this.mRect, this.mPaint);
            i++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i);
        int size = mode == Integer.MIN_VALUE ? android.view.View.MeasureSpec.getSize(i) : 0;
        if (mode != 1073741824) {
            i = size;
        }
        if (mode == 0) {
            i = this.mWidth;
        }
        int mode2 = android.view.View.MeasureSpec.getMode(0);
        int size2 = mode2 == Integer.MIN_VALUE ? android.view.View.MeasureSpec.getSize(i2) : 0;
        if (mode2 != 1073741824) {
            i2 = size2;
        }
        if (mode2 == 0) {
            i2 = this.mHeight;
        }
        setMeasuredDimension(i, i2);
    }

    public void setDisplayTime(int i) {
        this.mDisplayTime = i;
    }

    public void setTotalTime(int i) {
        this.mTotalTime = i;
    }
}
