package com.aliyun.svideo.editor.effects.videoeq;

/* loaded from: classes12.dex */
public class VideoEqChooserView extends com.aliyun.svideo.editor.effects.control.BaseChooser implements com.aliyun.svideo.editor.effects.videoeq.FilterAdapter.OnItemClickListener, android.widget.SeekBar.OnSeekBarChangeListener, android.view.View.OnClickListener {
    private static final int MAXPROGRESS = 100;
    private float mBrightness;
    private android.widget.ImageView mCancel;
    private android.widget.ImageView mComplete;
    private float mContrast;
    private com.aliyun.svideo.editor.effects.videoeq.FilterAdapter mFilterAdapter;
    float mLastBrightness;
    float mLastContrast;
    float mLastSaturation;
    int mLastSaveIndex;
    private com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType mLastSaveType;
    int mLastSelectIndex;
    float mLastSharpness;
    float mLastVignette;
    private androidx.recyclerview.widget.RecyclerView mListView;
    private android.view.View mProgressBar;
    private android.view.View mRest;
    private float mSaturation;
    private android.widget.SeekBar mSeekBar;
    private float mSharpness;
    private com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType mType;
    private float mVignette;

    /* renamed from: com.aliyun.svideo.editor.effects.videoeq.VideoEqChooserView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.videoeq.VideoEqChooserView videoEqChooserView = com.aliyun.svideo.editor.effects.videoeq.VideoEqChooserView.this;
            videoEqChooserView.resetEq(videoEqChooserView.mType);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.videoeq.VideoEqChooserView$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$svideosdk$common$internal$videoaugment$VideoAugmentationType;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.values().length];
            $SwitchMap$com$aliyun$svideosdk$common$internal$videoaugment$VideoAugmentationType = iArr;
            try {
                iArr[com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.BRIGHTNESS.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$internal$videoaugment$VideoAugmentationType[com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.CONTRAST.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$internal$videoaugment$VideoAugmentationType[com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.SATURATION.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$internal$videoaugment$VideoAugmentationType[com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.SHARPNESS.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$internal$videoaugment$VideoAugmentationType[com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.VIGNETTE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public VideoEqChooserView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public VideoEqChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoEqChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBrightness = 0.5f;
        this.mContrast = 0.25f;
        this.mSaturation = 0.5f;
        this.mSharpness = 0.0f;
        this.mVignette = 0.0f;
        this.mLastSelectIndex = 0;
        this.mLastSaveIndex = 0;
        saveLastAllEQ();
    }

    private void configProgress() {
        if (this.mType == null) {
            hideProgressBar();
            return;
        }
        showProgressBar();
        int i = com.aliyun.svideo.editor.effects.videoeq.VideoEqChooserView.AnonymousClass2.$SwitchMap$com$aliyun$svideosdk$common$internal$videoaugment$VideoAugmentationType[this.mType.ordinal()];
        if (i == 1) {
            this.mSeekBar.setProgress((int) (this.mBrightness * 100.0f));
            return;
        }
        if (i == 2) {
            this.mSeekBar.setProgress((int) (this.mContrast * 100.0f));
            return;
        }
        if (i == 3) {
            this.mSeekBar.setProgress((int) (this.mSaturation * 100.0f));
        } else if (i == 4) {
            this.mSeekBar.setProgress((int) (this.mSharpness * 100.0f));
        } else {
            if (i != 5) {
                return;
            }
            this.mSeekBar.setProgress((int) (this.mVignette * 100.0f));
        }
    }

    private void hideProgressBar() {
        this.mProgressBar.setVisibility(4);
    }

    private void resetAllEq() {
        this.mBrightness = 0.5f;
        this.mContrast = 0.25f;
        this.mSaturation = 0.5f;
        this.mSharpness = 0.0f;
        this.mVignette = 0.0f;
        com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.msg.body.VideoEqResetAllMsg());
        configProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetEq(com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType videoAugmentationType) {
        int i = com.aliyun.svideo.editor.effects.videoeq.VideoEqChooserView.AnonymousClass2.$SwitchMap$com$aliyun$svideosdk$common$internal$videoaugment$VideoAugmentationType[videoAugmentationType.ordinal()];
        if (i == 1) {
            this.mBrightness = 0.5f;
        } else if (i == 2) {
            this.mContrast = 0.25f;
        } else if (i == 3) {
            this.mSaturation = 0.5f;
        } else if (i == 4) {
            this.mSharpness = 0.0f;
        } else if (i != 5) {
            return;
        } else {
            this.mVignette = 0.0f;
        }
        com.aliyun.svideo.editor.msg.body.VideoEqResetMsg videoEqResetMsg = new com.aliyun.svideo.editor.msg.body.VideoEqResetMsg();
        videoEqResetMsg.setType(videoAugmentationType);
        com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(videoEqResetMsg);
        configProgress();
    }

    private void resetLastEqProgress() {
        this.mType = this.mLastSaveType;
        this.mBrightness = this.mLastBrightness;
        this.mContrast = this.mLastContrast;
        this.mSaturation = this.mLastSaturation;
        this.mSharpness = this.mLastSharpness;
        this.mVignette = this.mLastVignette;
        configProgress();
    }

    private void saveLastAllEQ() {
        this.mLastBrightness = this.mBrightness;
        this.mLastContrast = this.mContrast;
        this.mLastSaturation = this.mSaturation;
        this.mLastSharpness = this.mSharpness;
        this.mLastVignette = this.mVignette;
    }

    private void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void init() {
        android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_videoeq, this);
        this.mListView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.effect_list_filter);
        this.mListView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        if (this.mFilterAdapter == null) {
            com.aliyun.svideo.editor.effects.videoeq.FilterAdapter filterAdapter = new com.aliyun.svideo.editor.effects.videoeq.FilterAdapter(getContext());
            this.mFilterAdapter = filterAdapter;
            filterAdapter.setOnItemClickListener(this);
            this.mFilterAdapter.setDataList(com.aliyun.svideo.editor.util.EditorCommon.getVideoEqList(getContext()));
        }
        this.mListView.setAdapter(this.mFilterAdapter);
        this.mListView.addItemDecoration(new com.aliyun.svideo.editor.effects.control.SpacesEffectItemDecoration(getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.list_item_space)));
        android.graphics.drawable.Drawable drawable = getContext().getResources().getDrawable(com.aliyun.svideo.editor.R.mipmap.alivc_svideo_icon_tab_filter);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        android.widget.SeekBar seekBar = (android.widget.SeekBar) findViewById(com.aliyun.svideo.editor.R.id.seek_bar);
        this.mSeekBar = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.mSeekBar.setMax(100);
        this.mProgressBar = findViewById(com.aliyun.svideo.editor.R.id.seek_bar_area);
        android.view.View findViewById = findViewById(com.aliyun.svideo.editor.R.id.iv_reset);
        this.mRest = findViewById;
        findViewById.setOnClickListener(new com.aliyun.svideo.editor.effects.videoeq.VideoEqChooserView.AnonymousClass1());
        this.mCancel = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.alivc_btn_close);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.alivc_btn_done);
        this.mComplete = imageView;
        imageView.setOnClickListener(this);
        this.mCancel.setOnClickListener(this);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isPlayerNeedZoom() {
        return true;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isShowSelectedView() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        if (com.aliyun.svideo.base.utils.FastClickUtil.isFastClick()) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (view == this.mCancel) {
            if (this.mOnEffectActionLister != null) {
                if (this.mLastSaveType == null) {
                    this.mType = null;
                    resetAllEq();
                } else {
                    resetLastEqProgress();
                }
                this.mFilterAdapter.setSelectedPos(this.mLastSaveIndex);
                this.mFilterAdapter.notifyDataSetChanged();
                this.mOnEffectActionLister.onCancel();
            }
        } else if (view == this.mComplete && this.mOnEffectActionLister != null) {
            this.mLastSaveIndex = this.mLastSelectIndex;
            this.mLastSaveType = this.mType;
            saveLastAllEQ();
            this.mOnEffectActionLister.onComplete();
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // com.aliyun.svideo.editor.effects.videoeq.FilterAdapter.OnItemClickListener
    public boolean onItemClick(com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType videoAugmentationType, int i) {
        this.mType = videoAugmentationType;
        configProgress();
        if (i == 0) {
            resetAllEq();
        }
        this.mLastSelectIndex = i;
        return true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
        int i2 = com.aliyun.svideo.editor.effects.videoeq.VideoEqChooserView.AnonymousClass2.$SwitchMap$com$aliyun$svideosdk$common$internal$videoaugment$VideoAugmentationType[this.mType.ordinal()];
        if (i2 == 1) {
            this.mBrightness = i / 100.0f;
            com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.msg.body.BrightnessProgressMsg().progress(this.mBrightness));
            return;
        }
        if (i2 == 2) {
            this.mContrast = i / 100.0f;
            com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.msg.body.ContrastProgressMsg().progress(this.mContrast));
            return;
        }
        if (i2 == 3) {
            this.mSaturation = i / 100.0f;
            com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.msg.body.SaturationProgressMsg().progress(this.mSaturation));
        } else if (i2 == 4) {
            this.mSharpness = i / 100.0f;
            com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.msg.body.SharpProgressMsg().progress(this.mSharpness));
        } else {
            if (i2 != 5) {
                return;
            }
            this.mVignette = i / 100.0f;
            com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.msg.body.VignetteMsg().progress(this.mVignette));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
    }
}
