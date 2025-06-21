package com.aliyun.svideo.base.widget.beauty.seekbar;

/* loaded from: classes.dex */
public class BeautySeekBar extends android.widget.FrameLayout {
    private boolean hasHistory;
    private boolean isSeekBarNegativeMin;
    private android.widget.SeekBar mBackSeekBar;
    private android.content.Context mContext;
    private com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar mFrontSeekBar;
    private com.aliyun.svideo.base.widget.beauty.listener.OnProgresschangeListener mListener;

    /* renamed from: com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.OnSeekBarChangeListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.OnSeekBarChangeListener
        public void onProgressChanged(com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar indicatorSeekBar, int i, float f, boolean z) {
            if (com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar.this.mListener != null) {
                com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar.this.mListener.onProgressChange(i);
                if (com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar.this.mListener instanceof com.aliyun.svideo.base.widget.beauty.listener.AbstractOnProgressFloatChangeListener) {
                    ((com.aliyun.svideo.base.widget.beauty.listener.AbstractOnProgressFloatChangeListener) com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar.this.mListener).onProgressFloatChange(i, f);
                }
            }
        }

        @Override // com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.OnSeekBarChangeListener
        public void onSectionChanged(com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar indicatorSeekBar, int i, java.lang.String str, boolean z) {
        }

        @Override // com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar indicatorSeekBar, int i) {
        }

        @Override // com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar indicatorSeekBar) {
        }
    }

    public BeautySeekBar(android.content.Context context) {
        super(context);
        this.isSeekBarNegativeMin = false;
        this.mContext = context;
        initView();
    }

    public BeautySeekBar(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSeekBarNegativeMin = false;
        this.mContext = context;
        initView();
    }

    public BeautySeekBar(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSeekBarNegativeMin = false;
        this.mContext = context;
        initView();
    }

    private void initView() {
        android.view.LayoutInflater.from(this.mContext).inflate(com.aliyun.svideo.base.R.layout.alivc_beauty_seekbar, this);
        com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar indicatorSeekBar = (com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar) findViewById(com.aliyun.svideo.base.R.id.front_seekbar);
        this.mFrontSeekBar = indicatorSeekBar;
        indicatorSeekBar.setIndicatorGap(10);
        android.widget.SeekBar seekBar = (android.widget.SeekBar) findViewById(com.aliyun.svideo.base.R.id.back_seekbar);
        this.mBackSeekBar = seekBar;
        seekBar.setEnabled(false);
        this.mBackSeekBar.setActivated(false);
        this.mFrontSeekBar.setOnSeekChangeListener(new com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar.AnonymousClass1());
    }

    public int getSeekIndicator() {
        return this.mBackSeekBar.getProgress();
    }

    public void resetProgress() {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mFrontSeekBar.setProgress(this.mBackSeekBar.getProgress());
        } else if (this.isSeekBarNegativeMin) {
            this.mFrontSeekBar.setProgress(this.mBackSeekBar.getProgress() - 100);
        } else {
            this.mFrontSeekBar.setProgress(this.mBackSeekBar.getProgress());
        }
    }

    public void setBackSeekMin(int i) {
        if (i >= 0) {
            this.isSeekBarNegativeMin = false;
        } else {
            this.isSeekBarNegativeMin = true;
        }
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mBackSeekBar.setMin(i);
        } else if (this.isSeekBarNegativeMin) {
            this.mBackSeekBar.setMax(200);
        } else {
            this.mBackSeekBar.setMax(100);
        }
    }

    public void setFloatProgress(boolean z) {
        this.mFrontSeekBar.setFloatProgress(z);
    }

    public void setIndicatorAndProgress(int i, float f) {
        this.mBackSeekBar.setProgress(i);
        this.mBackSeekBar.setVisibility(0);
        this.mFrontSeekBar.setProgress(f);
    }

    public void setLastProgress(float f) {
        this.hasHistory = true;
        this.mFrontSeekBar.setProgress(f);
        this.mBackSeekBar.setVisibility(0);
    }

    public void setMax(float f) {
        this.mFrontSeekBar.setMax(f);
    }

    public void setMin(float f) {
        this.mFrontSeekBar.setMin(f);
    }

    public void setProgress(int i) {
        this.mFrontSeekBar.setProgress(i);
        this.mBackSeekBar.setVisibility(0);
    }

    public void setProgressChangeListener(com.aliyun.svideo.base.widget.beauty.listener.OnProgresschangeListener onProgresschangeListener) {
        this.mListener = onProgresschangeListener;
    }

    public void setSeekIndicator(float f) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mBackSeekBar.setProgress((int) f);
        } else if (this.isSeekBarNegativeMin) {
            this.mBackSeekBar.setProgress(((int) f) + 100);
        } else {
            this.mBackSeekBar.setProgress((int) f);
        }
    }
}
