package com.aliyun.svideo.editor.effects.pip;

/* loaded from: classes12.dex */
public class PipSettingView extends com.aliyun.svideo.editor.effects.control.BaseChooser implements com.aliyun.svideo.editor.effects.pip.OperationAdapter.OnItemClickListener, android.widget.SeekBar.OnSeekBarChangeListener {
    private static final int MAXPROGRESS = 100;
    int mAlpha;
    int mAngle;
    int mBoarder;
    int mBrightness;
    int mContrast;
    int mCorner;
    int mDenoise;
    private androidx.recyclerview.widget.RecyclerView mListView;
    int mMove;
    private com.aliyun.svideo.editor.effects.pip.OperationAdapter mOperationAdapter;
    private android.view.View mProgressBar;
    private android.view.View mRest;
    int mSaturation;
    int mScale;
    private android.widget.SeekBar mSeekBar;
    int mSharpness;
    private com.aliyun.svideo.editor.effects.pip.Operation mType;
    int mVignette;
    int mVolume;

    /* renamed from: com.aliyun.svideo.editor.effects.pip.PipSettingView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.pip.PipSettingView$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation;

        static {
            int[] iArr = new int[com.aliyun.svideo.editor.effects.pip.Operation.values().length];
            $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation = iArr;
            try {
                iArr[com.aliyun.svideo.editor.effects.pip.Operation.SCALE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[com.aliyun.svideo.editor.effects.pip.Operation.ANGLE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[com.aliyun.svideo.editor.effects.pip.Operation.VOLUME.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[com.aliyun.svideo.editor.effects.pip.Operation.DENOISE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[com.aliyun.svideo.editor.effects.pip.Operation.RADIUS.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[com.aliyun.svideo.editor.effects.pip.Operation.BORDER.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[com.aliyun.svideo.editor.effects.pip.Operation.MOVE.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[com.aliyun.svideo.editor.effects.pip.Operation.ALPHA.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[com.aliyun.svideo.editor.effects.pip.Operation.VIGNETTE.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[com.aliyun.svideo.editor.effects.pip.Operation.SATURATION.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[com.aliyun.svideo.editor.effects.pip.Operation.BRIGHTNESS.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[com.aliyun.svideo.editor.effects.pip.Operation.SHARPNESS.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[com.aliyun.svideo.editor.effects.pip.Operation.CONTRAST.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[com.aliyun.svideo.editor.effects.pip.Operation.ADD.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[com.aliyun.svideo.editor.effects.pip.Operation.EFFECT.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[com.aliyun.svideo.editor.effects.pip.Operation.FRAME_ANIMATION.ordinal()] = 16;
            } catch (java.lang.NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[com.aliyun.svideo.editor.effects.pip.Operation.DELETE.ordinal()] = 17;
            } catch (java.lang.NoSuchFieldError unused17) {
            }
        }
    }

    public PipSettingView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public PipSettingView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PipSettingView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = com.aliyun.svideo.editor.effects.pip.Operation.SCALE;
        this.mScale = 30;
        this.mAngle = 50;
        this.mMove = 50;
        this.mCorner = 0;
        this.mBoarder = 0;
        this.mVolume = 100;
        this.mDenoise = 0;
        this.mAlpha = 100;
        this.mBrightness = 50;
        this.mContrast = 25;
        this.mVignette = 0;
        this.mSaturation = 50;
        this.mSharpness = 0;
    }

    private void configProgress() {
        if (this.mType == null) {
            hideProgressBar();
        }
        showProgressBar();
        switch (com.aliyun.svideo.editor.effects.pip.PipSettingView.AnonymousClass2.$SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[this.mType.ordinal()]) {
            case 1:
                this.mSeekBar.setProgress(this.mScale);
                break;
            case 2:
                this.mSeekBar.setProgress(this.mAngle);
                break;
            case 3:
                this.mSeekBar.setProgress(this.mVolume);
                break;
            case 4:
                this.mSeekBar.setProgress(this.mDenoise);
                break;
            case 5:
                this.mSeekBar.setProgress(this.mCorner);
                break;
            case 6:
                this.mSeekBar.setProgress(this.mBoarder);
                break;
            case 7:
                this.mSeekBar.setProgress(this.mMove);
                break;
            case 8:
                this.mSeekBar.setProgress(this.mAlpha);
                break;
            case 9:
                this.mSeekBar.setProgress(this.mVignette);
                break;
            case 10:
                this.mSeekBar.setProgress(this.mSaturation);
                break;
            case 11:
                this.mSeekBar.setProgress(this.mBrightness);
                break;
            case 12:
                this.mSeekBar.setProgress(this.mSharpness);
                break;
            case 13:
                this.mSeekBar.setProgress(this.mContrast);
                break;
            case 14:
                hideProgressBar();
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipAddMsg());
                break;
            case 15:
                hideProgressBar();
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipEffectMsg());
                break;
            case 16:
                hideProgressBar();
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipFrameAnimationMsg());
                break;
            case 17:
                hideProgressBar();
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipDeleteMsg());
                break;
        }
    }

    private void dealCancel() {
        com.aliyun.svideo.editor.effects.control.OnEffectActionLister onEffectActionLister = this.mOnEffectActionLister;
        if (onEffectActionLister != null) {
            onEffectActionLister.onCancel();
        }
    }

    private void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    private void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public com.aliyun.svideo.editor.effects.control.UIEditorPage getUIEditorPage() {
        return com.aliyun.svideo.editor.effects.control.UIEditorPage.PIP;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void init() {
        android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_setting_pip, this);
        this.mListView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.effect_list_filter);
        this.mListView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        if (this.mOperationAdapter == null) {
            com.aliyun.svideo.editor.effects.pip.OperationAdapter operationAdapter = new com.aliyun.svideo.editor.effects.pip.OperationAdapter(getContext());
            this.mOperationAdapter = operationAdapter;
            operationAdapter.setOnItemClickListener(this);
        }
        this.mListView.setAdapter(this.mOperationAdapter);
        this.mListView.addItemDecoration(new com.aliyun.svideo.editor.effects.control.SpaceItemDecoration(getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.list_item_space)));
        android.widget.SeekBar seekBar = (android.widget.SeekBar) findViewById(com.aliyun.svideo.editor.R.id.seek_bar);
        this.mSeekBar = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.mSeekBar.setMax(100);
        this.mProgressBar = findViewById(com.aliyun.svideo.editor.R.id.seek_bar_area);
        android.view.View findViewById = findViewById(com.aliyun.svideo.editor.R.id.iv_reset);
        this.mRest = findViewById;
        findViewById.setOnClickListener(new com.aliyun.svideo.editor.effects.pip.PipSettingView.AnonymousClass1());
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isPlayerNeedZoom() {
        return true;
    }

    @Override // com.aliyun.svideo.editor.effects.pip.OperationAdapter.OnItemClickListener
    public boolean onItemClick(com.aliyun.svideo.editor.effects.pip.Operation operation, int i) {
        this.mType = operation;
        configProgress();
        return true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
        switch (com.aliyun.svideo.editor.effects.pip.PipSettingView.AnonymousClass2.$SwitchMap$com$aliyun$svideo$editor$effects$pip$Operation[this.mType.ordinal()]) {
            case 1:
                this.mScale = i;
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipScaleMsg().progress(this.mScale / 100.0f));
                break;
            case 2:
                this.mAngle = i;
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipAngleMsg().progress(((i * (i < 50 ? -1.0f : 1.0f)) / 50.0f) * 3.14f));
                break;
            case 3:
                this.mVolume = i;
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipVolumeMsg().progress(this.mVolume));
                break;
            case 4:
                this.mDenoise = i;
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipDenoiseMsg().progress(this.mDenoise));
                break;
            case 5:
                this.mCorner = i;
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipRadiusMsg().progress(this.mCorner));
                break;
            case 6:
                this.mBoarder = i;
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipBorderMsg().progress(this.mBoarder));
                break;
            case 7:
                this.mMove = i;
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipMoveMsg().progress(this.mMove / 100.0f));
                break;
            case 8:
                this.mAlpha = i;
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipAlphaMsg().progress(this.mAlpha / 100.0f));
                break;
            case 9:
                this.mVignette = i;
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipVignetteMsg().progress(this.mVignette / 100.0f));
                break;
            case 10:
                this.mSaturation = i;
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipSaturationMsg().progress(this.mSaturation / 100.0f));
                break;
            case 11:
                this.mBrightness = i;
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipBrighnessMsg().progress(this.mBrightness / 100.0f));
                break;
            case 12:
                this.mSharpness = i;
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipSharpnessMsg().progress(this.mSharpness / 100.0f));
                break;
            case 13:
                this.mContrast = i;
                com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.effects.pip.msg.PipContrastMsg().progress(this.mContrast / 100.0f));
                break;
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
