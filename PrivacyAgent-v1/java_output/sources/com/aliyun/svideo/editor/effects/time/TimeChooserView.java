package com.aliyun.svideo.editor.effects.time;

/* loaded from: classes12.dex */
public class TimeChooserView extends com.aliyun.svideo.editor.effects.control.BaseChooser implements android.view.View.OnClickListener {
    private android.widget.FrameLayout flThumblinebar;
    private boolean isFirstShow;
    private android.widget.ImageView mCancel;
    private android.widget.ImageView mComplete;
    private boolean mIsMoment;
    private android.widget.ImageView mIvEffectIcon;
    private com.aliyun.svideo.editor.effects.control.EffectInfo mLastSelectEffectInfo;
    private android.widget.ImageView mTimeFast;
    private android.widget.ImageView mTimeNone;
    private android.widget.ImageView mTimeRepeat;
    private android.widget.ImageView mTimeRepeat2Invert;
    private android.widget.ImageView mTimeSlow;
    private android.widget.TextView mTvEffectTitle;
    private android.view.View mView;

    /* renamed from: com.aliyun.svideo.editor.effects.time.TimeChooserView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.time.TimeChooserView timeChooserView = com.aliyun.svideo.editor.effects.time.TimeChooserView.this;
            if (timeChooserView.mEditorService != null && timeChooserView.mLastSelectEffectInfo != null) {
                com.aliyun.svideo.editor.effects.time.TimeChooserView timeChooserView2 = com.aliyun.svideo.editor.effects.time.TimeChooserView.this;
                timeChooserView2.mEditorService.setLastTimeEffectInfo(timeChooserView2.mLastSelectEffectInfo);
            }
            if (((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.time.TimeChooserView.this).mOnEffectActionLister != null) {
                ((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.time.TimeChooserView.this).mOnEffectActionLister.onComplete();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.time.TimeChooserView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.time.TimeChooserView.this.onBackPressed();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.time.TimeChooserView$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$svideosdk$editor$TimeEffectType;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.editor.TimeEffectType.values().length];
            $SwitchMap$com$aliyun$svideosdk$editor$TimeEffectType = iArr;
            try {
                iArr[com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_NONE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$editor$TimeEffectType[com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_INVERT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$editor$TimeEffectType[com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_RATE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$editor$TimeEffectType[com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_REPEAT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public TimeChooserView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public TimeChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimeChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsMoment = true;
        this.isFirstShow = true;
    }

    private void resetBtn() {
        this.mTimeNone.setSelected(false);
        this.mTimeSlow.setSelected(false);
        this.mTimeFast.setSelected(false);
        this.mTimeRepeat.setSelected(false);
        this.mTimeRepeat2Invert.setSelected(false);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public android.widget.FrameLayout getThumbContainer() {
        return this.flThumblinebar;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public com.aliyun.svideo.editor.effects.control.UIEditorPage getUIEditorPage() {
        return com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void init() {
        android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_time, (android.view.ViewGroup) null);
        this.mView = inflate;
        addView(inflate);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.time_effect_none);
        this.mTimeNone = imageView;
        imageView.setOnClickListener(this);
        android.widget.ImageView imageView2 = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.time_effect_slow);
        this.mTimeSlow = imageView2;
        imageView2.setOnClickListener(this);
        android.widget.ImageView imageView3 = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.time_effect_speed_up);
        this.mTimeFast = imageView3;
        imageView3.setOnClickListener(this);
        android.widget.ImageView imageView4 = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.time_effect_repeat_invert);
        this.mTimeRepeat2Invert = imageView4;
        imageView4.setOnClickListener(this);
        android.widget.ImageView imageView5 = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.time_effect_repeat);
        this.mTimeRepeat = imageView5;
        imageView5.setOnClickListener(this);
        this.flThumblinebar = (android.widget.FrameLayout) findViewById(com.aliyun.svideo.editor.R.id.fl_thumblinebar);
        this.mCancel = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.cancel);
        this.mTvEffectTitle = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_effect_title);
        this.mIvEffectIcon = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.iv_effect_icon);
        this.mComplete = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.complete);
        this.mIvEffectIcon.setImageResource(com.aliyun.svideo.editor.R.mipmap.alivc_svideo_icon_effect_time);
        this.mTvEffectTitle.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_time_tittle);
        this.mComplete.setOnClickListener(new com.aliyun.svideo.editor.effects.time.TimeChooserView.AnonymousClass1());
        this.mCancel.setOnClickListener(new com.aliyun.svideo.editor.effects.time.TimeChooserView.AnonymousClass2());
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isPlayerNeedZoom() {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mEditorService != null) {
            resetBtn();
            int i = com.aliyun.svideo.editor.effects.time.TimeChooserView.AnonymousClass3.$SwitchMap$com$aliyun$svideosdk$editor$TimeEffectType[this.mEditorService.getLastTimeEffectInfo().timeEffectType.ordinal()];
            if (i == 1) {
                this.mTimeNone.setSelected(true);
            } else if (i == 2) {
                this.mTimeRepeat2Invert.setSelected(true);
            } else if (i != 3) {
                if (i != 4) {
                    this.mTimeNone.setSelected(true);
                } else {
                    this.mTimeRepeat.setSelected(true);
                }
            } else if (this.mEditorService.getLastTimeEffectInfo().timeParam > 1.0f) {
                this.mTimeFast.setSelected(true);
            } else {
                this.mTimeSlow.setSelected(true);
            }
        }
        if (this.isFirstShow) {
            android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_tip_first_show, (android.view.ViewGroup) null, false);
            ((android.widget.TextView) inflate.findViewById(com.aliyun.svideo.editor.R.id.alivc_svideo_tip_first)).setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_time_tip_apply);
            android.widget.PopupWindow popupWindow = new android.widget.PopupWindow(inflate, -2, -2, true);
            popupWindow.setContentView(inflate);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
            popupWindow.showAsDropDown(this.mTimeNone, 0, -com.aliyun.svideo.common.utils.DensityUtils.dip2px(getContext(), 95.0f));
            this.isFirstShow = false;
        }
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void onBackPressed() {
        com.aliyun.svideo.editor.effects.control.EditorService editorService = this.mEditorService;
        if (editorService != null && this.mLastSelectEffectInfo != null) {
            this.mOnEffectChangeListener.onEffectChange(editorService.getLastTimeEffectInfo());
        }
        com.aliyun.svideo.editor.effects.control.OnEffectActionLister onEffectActionLister = this.mOnEffectActionLister;
        if (onEffectActionLister != null) {
            onEffectActionLister.onCancel();
        }
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (this.mThumbLineBar.isScrolling()) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (com.aliyun.svideo.base.utils.FastClickUtil.isFastClick()) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        resetBtn();
        view.setSelected(true);
        if (id == com.aliyun.svideo.editor.R.id.time_effect_none) {
            if (this.mOnEffectChangeListener != null) {
                com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                this.mLastSelectEffectInfo = effectInfo;
                effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME;
                effectInfo.timeEffectType = com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_NONE;
                effectInfo.isMoment = true;
                this.mOnEffectChangeListener.onEffectChange(effectInfo);
            }
        } else if (id == com.aliyun.svideo.editor.R.id.time_effect_slow) {
            if (this.mOnEffectChangeListener != null) {
                com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo2 = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                this.mLastSelectEffectInfo = effectInfo2;
                effectInfo2.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME;
                effectInfo2.timeEffectType = com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_RATE;
                effectInfo2.timeParam = 0.5f;
                effectInfo2.isMoment = true;
                this.mOnEffectChangeListener.onEffectChange(effectInfo2);
            }
        } else if (id == com.aliyun.svideo.editor.R.id.time_effect_speed_up) {
            if (this.mOnEffectChangeListener != null) {
                com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo3 = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                this.mLastSelectEffectInfo = effectInfo3;
                effectInfo3.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME;
                effectInfo3.timeEffectType = com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_RATE;
                effectInfo3.timeParam = 2.0f;
                effectInfo3.isMoment = true;
                this.mOnEffectChangeListener.onEffectChange(effectInfo3);
            }
        } else if (id == com.aliyun.svideo.editor.R.id.time_effect_repeat_invert) {
            if (this.mOnEffectChangeListener != null) {
                com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo4 = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                this.mLastSelectEffectInfo = effectInfo4;
                effectInfo4.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME;
                effectInfo4.isMoment = false;
                effectInfo4.timeEffectType = com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_INVERT;
                this.mOnEffectChangeListener.onEffectChange(effectInfo4);
            }
        } else if (id == com.aliyun.svideo.editor.R.id.time_effect_repeat) {
            com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo5 = new com.aliyun.svideo.editor.effects.control.EffectInfo();
            this.mLastSelectEffectInfo = effectInfo5;
            effectInfo5.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.TIME;
            effectInfo5.isMoment = true;
            effectInfo5.timeEffectType = com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_REPEAT;
            this.mOnEffectChangeListener.onEffectChange(effectInfo5);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setFirstShow(boolean z) {
        this.isFirstShow = z;
    }
}
