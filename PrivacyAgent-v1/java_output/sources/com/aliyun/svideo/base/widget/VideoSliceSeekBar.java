package com.aliyun.svideo.base.widget;

/* loaded from: classes.dex */
public class VideoSliceSeekBar extends android.view.View {
    private static final int DRAG_OFFSET = 50;
    private static int MERGIN_PADDING = 20;
    private static final int PADDING_BOTTOM_TOP = 10;
    private static final int PADDING_LEFT_RIGHT = 5;
    private static java.lang.String TAG = "VideoSliceSeekBar";
    private boolean blocked;
    private int downX;
    private float frameProgress;
    private boolean isDefaultSeekTotal;
    private boolean isInited;
    private boolean isTouch;
    private int lastDrawLeft;
    private int lastDrawRight;
    private com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb lastSelectedThumb;
    private float maxValue;
    private boolean needFrameProgress;
    private android.graphics.Paint paintThumb;
    private int prevX;
    private int progressHalfHeight;
    private int progressMinDiff;
    private int progressMinDiffPixels;
    private int resBackground;
    private int resFrame;
    private int resPaddingColor;
    private int resSweepLeft;
    private int resSweepRight;
    private com.aliyun.svideo.base.widget.VideoSliceSeekBar.SeekBarChangeListener scl;
    private int screenWidth;
    private com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb selectedThumb;
    private android.graphics.Bitmap thumbFrame;
    private int thumbMaxSliceRightx;
    private int thumbPadding;
    private android.graphics.Bitmap thumbSlice;
    private int thumbSliceHalfWidth;
    private float thumbSliceLeftValue;
    private int thumbSliceLeftX;
    private android.graphics.Bitmap thumbSliceRight;
    private float thumbSliceRightValue;
    private int thumbSliceRightX;

    public interface SeekBarChangeListener {
        void onSeekEnd();

        void onSeekStart();

        void seekBarValueChanged(float f, float f2, int i);
    }

    public enum SelectThumb {
        SELECT_THUMB_NONE,
        SELECT_THUMB_LEFT,
        SELECT_THUMB_MORE_LEFT,
        SELECT_THUMB_RIGHT,
        SELECT_THUMB_MORE_RIGHT
    }

    public VideoSliceSeekBar(android.content.Context context) {
        super(context);
        this.progressMinDiff = 25;
        this.progressHalfHeight = 0;
        this.thumbPadding = 0;
        this.maxValue = 100.0f;
        this.paintThumb = new android.graphics.Paint();
        this.lastSelectedThumb = com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_NONE;
        this.resSweepLeft = com.aliyun.svideo.base.R.mipmap.aliyun_svideo_icon_sweep_left;
        this.resSweepRight = com.aliyun.svideo.base.R.mipmap.aliyun_svideo_icon_sweep_right;
        this.resFrame = com.aliyun.svideo.base.R.mipmap.aliyun_svideo_icon_frame;
        this.resBackground = com.aliyun.svideo.base.R.color.alivc_common_theme_primary;
        this.resPaddingColor = android.R.color.holo_red_dark;
        this.isTouch = false;
        initValue(context);
    }

    public VideoSliceSeekBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.progressMinDiff = 25;
        this.progressHalfHeight = 0;
        this.thumbPadding = 0;
        this.maxValue = 100.0f;
        this.paintThumb = new android.graphics.Paint();
        this.lastSelectedThumb = com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_NONE;
        this.resSweepLeft = com.aliyun.svideo.base.R.mipmap.aliyun_svideo_icon_sweep_left;
        this.resSweepRight = com.aliyun.svideo.base.R.mipmap.aliyun_svideo_icon_sweep_right;
        this.resFrame = com.aliyun.svideo.base.R.mipmap.aliyun_svideo_icon_frame;
        this.resBackground = com.aliyun.svideo.base.R.color.alivc_common_theme_primary;
        this.resPaddingColor = android.R.color.holo_red_dark;
        this.isTouch = false;
        initValue(context);
    }

    public VideoSliceSeekBar(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.progressMinDiff = 25;
        this.progressHalfHeight = 0;
        this.thumbPadding = 0;
        this.maxValue = 100.0f;
        this.paintThumb = new android.graphics.Paint();
        this.lastSelectedThumb = com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_NONE;
        this.resSweepLeft = com.aliyun.svideo.base.R.mipmap.aliyun_svideo_icon_sweep_left;
        this.resSweepRight = com.aliyun.svideo.base.R.mipmap.aliyun_svideo_icon_sweep_right;
        this.resFrame = com.aliyun.svideo.base.R.mipmap.aliyun_svideo_icon_frame;
        this.resBackground = com.aliyun.svideo.base.R.color.alivc_common_theme_primary;
        this.resPaddingColor = android.R.color.holo_red_dark;
        this.isTouch = false;
        initValue(context);
    }

    private boolean adjustSliceXY(int i) {
        com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb selectThumb;
        int i2 = this.thumbSliceRightX;
        int i3 = this.thumbSliceLeftX;
        int i4 = i2 - i3;
        int i5 = this.progressMinDiffPixels;
        boolean z = (i4 <= i5 && this.selectedThumb == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_MORE_RIGHT && i <= this.downX) || (i4 <= i5 && this.selectedThumb == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_MORE_LEFT && i >= this.downX);
        if ((i4 <= i5 && this.selectedThumb == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_RIGHT && i <= this.downX) || (i4 <= i5 && this.selectedThumb == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_LEFT && i >= this.downX)) {
            z = true;
        }
        if (z) {
            com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb selectThumb2 = this.selectedThumb;
            if (selectThumb2 == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_RIGHT || selectThumb2 == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_MORE_RIGHT) {
                this.thumbSliceRightX = i3 + i5;
            } else if (selectThumb2 == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_LEFT || selectThumb2 == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_MORE_LEFT) {
                this.thumbSliceLeftX = i2 - i5;
            }
            return true;
        }
        int i6 = this.thumbMaxSliceRightx;
        if (i > i6 && ((selectThumb = this.selectedThumb) == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_RIGHT || selectThumb == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_MORE_RIGHT)) {
            this.thumbSliceRightX = i6;
            return true;
        }
        if (i2 >= (getWidth() - (this.thumbSliceHalfWidth * 2)) - MERGIN_PADDING) {
            this.thumbSliceRightX = getWidth() - (this.thumbSliceHalfWidth * 2);
        }
        if (this.thumbSliceLeftX < MERGIN_PADDING) {
            this.thumbSliceLeftX = 0;
        }
        return false;
    }

    private int calculateCorrds(int i) {
        return (int) (((getWidth() - (this.thumbSliceHalfWidth * 2)) / this.maxValue) * i);
    }

    private void calculateThumbValue() {
        if (getWidth() == 0) {
            return;
        }
        this.thumbSliceLeftValue = (this.maxValue * this.thumbSliceLeftX) / (getWidth() - (this.thumbSliceHalfWidth * 2));
        this.thumbSliceRightValue = (this.maxValue * this.thumbSliceRightX) / (getWidth() - (this.thumbSliceHalfWidth * 2));
    }

    private void getStyleParam() {
        android.content.res.TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{com.aliyun.svideo.base.R.attr.qusnap_crop_sweep_left, com.aliyun.svideo.base.R.attr.qusnap_crop_sweep_right, com.aliyun.svideo.base.R.attr.qusnap_crop_seek_frame, com.aliyun.svideo.base.R.attr.qusnap_background_color, com.aliyun.svideo.base.R.attr.qusnap_crop_seek_padding_color});
        this.resSweepLeft = obtainStyledAttributes.getResourceId(0, com.aliyun.svideo.base.R.mipmap.aliyun_svideo_icon_sweep_left);
        this.resSweepRight = obtainStyledAttributes.getResourceId(1, com.aliyun.svideo.base.R.mipmap.aliyun_svideo_icon_sweep_right);
        this.resFrame = obtainStyledAttributes.getResourceId(2, com.aliyun.svideo.base.R.mipmap.aliyun_svideo_icon_frame);
        this.resBackground = obtainStyledAttributes.getResourceId(3, 0);
        this.resPaddingColor = obtainStyledAttributes.getResourceId(4, android.R.color.holo_red_dark);
    }

    private void init() {
        if (this.thumbSlice.getHeight() > getHeight()) {
            getLayoutParams().height = this.thumbSlice.getHeight();
        }
        this.thumbSliceHalfWidth = this.thumbSlice.getWidth() / 2;
        this.progressMinDiffPixels = calculateCorrds(this.progressMinDiff) - (this.thumbPadding * 2);
        this.selectedThumb = com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_NONE;
        setLeftProgress(0);
        setRightProgress(100);
        setThumbMaxSliceRightx(this.screenWidth);
        invalidate();
    }

    private void initValue(android.content.Context context) {
        getStyleParam();
        this.thumbSlice = android.graphics.BitmapFactory.decodeResource(getResources(), this.resSweepLeft);
        this.thumbSliceRight = android.graphics.BitmapFactory.decodeResource(getResources(), this.resSweepRight);
        this.thumbFrame = android.graphics.BitmapFactory.decodeResource(getResources(), this.resFrame);
        int i = context.getResources().getDisplayMetrics().widthPixels;
        this.screenWidth = i;
        float dip2px = (i - com.aliyun.svideo.common.utils.DensityUtils.dip2px(getContext(), 40.0f)) / 10;
        float height = dip2px / this.thumbSlice.getHeight();
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(height, height);
        float height2 = dip2px / this.thumbFrame.getHeight();
        android.graphics.Matrix matrix2 = new android.graphics.Matrix();
        matrix2.postScale(height2, height2);
        android.graphics.Bitmap bitmap = this.thumbSlice;
        this.thumbSlice = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.thumbSlice.getHeight(), matrix, false);
        android.graphics.Bitmap bitmap2 = this.thumbSliceRight;
        this.thumbSliceRight = android.graphics.Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.thumbSliceRight.getHeight(), matrix, false);
        android.graphics.Bitmap bitmap3 = this.thumbFrame;
        this.thumbFrame = android.graphics.Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), this.thumbFrame.getHeight(), matrix2, false);
        invalidate();
    }

    private void notifySeekBarValueChanged() {
        int i = this.thumbSliceLeftX;
        int i2 = this.thumbPadding;
        if (i < i2) {
            this.thumbSliceLeftX = i2;
        }
        if (this.thumbSliceRightX < i2) {
            this.thumbSliceRightX = i2;
        }
        if (this.thumbSliceLeftX > getWidth() - this.thumbPadding) {
            this.thumbSliceLeftX = getWidth() - this.thumbPadding;
        }
        if (this.thumbSliceRightX > getWidth() - this.thumbPadding) {
            this.thumbSliceRightX = getWidth() - this.thumbPadding;
        }
        invalidate();
        if (this.scl != null) {
            calculateThumbValue();
            if (this.isTouch) {
                com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb selectThumb = this.selectedThumb;
                if (selectThumb == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_LEFT || selectThumb == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_MORE_LEFT) {
                    this.scl.seekBarValueChanged(this.thumbSliceLeftValue, this.thumbSliceRightValue, 0);
                } else if (selectThumb == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_RIGHT || selectThumb == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_MORE_RIGHT) {
                    this.scl.seekBarValueChanged(this.thumbSliceLeftValue, this.thumbSliceRightValue, 1);
                } else {
                    this.scl.seekBarValueChanged(this.thumbSliceLeftValue, this.thumbSliceRightValue, 2);
                }
            }
        }
        this.isTouch = false;
    }

    public float getLeftProgress() {
        return this.thumbSliceLeftValue;
    }

    public float getRightProgress() {
        return this.thumbSliceRightValue;
    }

    @Override // android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int i = this.thumbSliceLeftX;
        int i2 = this.thumbSliceRightX;
        this.paintThumb.setColor(getResources().getColor(this.resPaddingColor));
        float f = i2 + 5;
        canvas.drawRect((this.thumbSlice.getWidth() + i) - 5, 0.0f, f, 10.0f, this.paintThumb);
        canvas.drawRect((this.thumbSlice.getWidth() + i) - 5, this.thumbSlice.getHeight() - 10, f, this.thumbSlice.getHeight(), this.paintThumb);
        this.paintThumb.setColor(getResources().getColor(this.resBackground));
        this.paintThumb.setAlpha(229);
        canvas.drawRect(0.0f, 0.0f, i + 5, this.thumbSlice.getHeight(), this.paintThumb);
        canvas.drawRect((this.thumbSliceRight.getWidth() + i2) - 5, 0.0f, getWidth(), this.thumbSlice.getHeight(), this.paintThumb);
        canvas.drawBitmap(this.thumbSlice, i, 0.0f, this.paintThumb);
        canvas.drawBitmap(this.thumbSliceRight, i2, 0.0f, this.paintThumb);
        if (this.needFrameProgress) {
            float width = (this.frameProgress * (getWidth() - (this.thumbSliceHalfWidth * 2))) - (this.thumbFrame.getWidth() / 2);
            int i3 = this.thumbSliceHalfWidth;
            if (width > (i3 * 2) + i2) {
                width = i2 + (i3 * 2);
            }
            canvas.drawBitmap(this.thumbFrame, width, 0.0f, this.paintThumb);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        if (r6 != 3) goto L43;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!this.blocked) {
            int x = (int) motionEvent.getX();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb selectThumb = this.selectedThumb;
                        if (selectThumb == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_LEFT) {
                            this.thumbSliceLeftX = x;
                        } else if (selectThumb == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_RIGHT) {
                            this.thumbSliceRightX = x;
                        } else if (selectThumb == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_MORE_RIGHT) {
                            this.thumbSliceRightX += x - this.prevX;
                        } else if (selectThumb == com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_MORE_LEFT) {
                            this.thumbSliceLeftX += x - this.prevX;
                        }
                        if (!adjustSliceXY(x)) {
                            this.prevX = x;
                        }
                    }
                }
                this.downX = x;
                adjustSliceXY(x);
                this.selectedThumb = com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_NONE;
                com.aliyun.svideo.base.widget.VideoSliceSeekBar.SeekBarChangeListener seekBarChangeListener = this.scl;
                if (seekBarChangeListener != null) {
                    seekBarChangeListener.onSeekEnd();
                }
            } else {
                int i = this.thumbSliceLeftX;
                if (x > (this.thumbSliceHalfWidth * 2) + i + 50) {
                    int i2 = this.thumbSliceRightX;
                    if (x >= (i2 - (r3 * 2)) - 50) {
                        if (x <= i2) {
                            this.selectedThumb = com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_RIGHT;
                        } else {
                            this.selectedThumb = com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_MORE_RIGHT;
                        }
                    }
                } else if (x >= i) {
                    this.selectedThumb = com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_LEFT;
                } else {
                    this.selectedThumb = com.aliyun.svideo.base.widget.VideoSliceSeekBar.SelectThumb.SELECT_THUMB_MORE_LEFT;
                }
                this.downX = x;
                this.prevX = x;
                com.aliyun.svideo.base.widget.VideoSliceSeekBar.SeekBarChangeListener seekBarChangeListener2 = this.scl;
                if (seekBarChangeListener2 != null) {
                    seekBarChangeListener2.onSeekStart();
                }
            }
            if (x != this.downX) {
                this.isTouch = true;
                notifySeekBarValueChanged();
            }
        }
        return true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.isInited) {
            return;
        }
        this.isInited = true;
        init();
    }

    public void setFrameProgress(float f) {
        this.frameProgress = f;
        invalidate();
    }

    public void setLeftProgress(int i) {
        if (i <= this.thumbSliceRightValue - this.progressMinDiff) {
            this.thumbSliceLeftX = calculateCorrds(i);
        }
        notifySeekBarValueChanged();
    }

    public void setMaxValue(int i) {
        this.maxValue = i;
    }

    public void setProgress(int i, int i2) {
        if (i2 - i >= this.progressMinDiff) {
            this.thumbSliceLeftX = calculateCorrds(i);
            this.thumbSliceRightX = calculateCorrds(i2);
        }
        notifySeekBarValueChanged();
    }

    public void setProgressHeight(int i) {
        this.progressHalfHeight /= 2;
        invalidate();
    }

    public void setProgressMinDiff(int i) {
        this.progressMinDiff = i;
        this.progressMinDiffPixels = calculateCorrds(i);
    }

    public void setRightProgress(int i) {
        if (i >= this.thumbSliceLeftValue + this.progressMinDiff) {
            this.thumbSliceRightX = calculateCorrds(i);
            if (!this.isDefaultSeekTotal) {
                this.isDefaultSeekTotal = true;
            }
        }
        notifySeekBarValueChanged();
    }

    public void setSeekBarChangeListener(com.aliyun.svideo.base.widget.VideoSliceSeekBar.SeekBarChangeListener seekBarChangeListener) {
        this.scl = seekBarChangeListener;
    }

    public void setSliceBlocked(boolean z) {
        this.blocked = z;
        invalidate();
    }

    public void setThumbMaxSliceRightx(int i) {
        this.thumbMaxSliceRightx = i;
    }

    public void setThumbPadding(int i) {
        this.thumbPadding = i;
        invalidate();
    }

    public void setThumbSlice(android.graphics.Bitmap bitmap) {
        this.thumbSlice = bitmap;
        init();
    }

    public void showFrameProgress(boolean z) {
        this.needFrameProgress = z;
    }
}
