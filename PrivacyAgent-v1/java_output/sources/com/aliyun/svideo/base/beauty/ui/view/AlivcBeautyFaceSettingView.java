package com.aliyun.svideo.base.beauty.ui.view;

/* loaded from: classes.dex */
public class AlivcBeautyFaceSettingView extends android.widget.FrameLayout {
    private int mCurrentLevel;
    private com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView.OnLevelChangeListener mOnBeautyFaceLevelChangeListener;
    private android.view.View.OnClickListener mOnBlankClickListener;
    private android.widget.RadioGroup mRgAdvancedGroup;

    /* renamed from: com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.RadioGroup.OnCheckedChangeListener {
        public AnonymousClass1() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onCheckedChanged(android.widget.RadioGroup radioGroup, int i) {
            if (com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView.this.mOnBeautyFaceLevelChangeListener != null) {
                com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView alivcBeautyFaceSettingView = com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView.this;
                alivcBeautyFaceSettingView.mCurrentLevel = alivcBeautyFaceSettingView.switchIdToLevel(i);
                com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView.this.mOnBeautyFaceLevelChangeListener.onChangeListener(com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView.this.mCurrentLevel);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i);
        }
    }

    /* renamed from: com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView.this.mOnBlankClickListener != null) {
                com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView.this.mOnBlankClickListener.onClick(view);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface OnLevelChangeListener {
        void onChangeListener(int i);
    }

    public AlivcBeautyFaceSettingView(android.content.Context context) {
        this(context, null);
    }

    public AlivcBeautyFaceSettingView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlivcBeautyFaceSettingView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void advancedCheck(int i) {
        int i2 = i != 0 ? i != 20 ? i != 40 ? i != 60 ? i != 80 ? i != 100 ? com.aliyun.svideo.base.R.id.beauty_advanced_3 : com.aliyun.svideo.base.R.id.beauty_advanced_5 : com.aliyun.svideo.base.R.id.beauty_advanced_4 : com.aliyun.svideo.base.R.id.beauty_advanced_3 : com.aliyun.svideo.base.R.id.beauty_advanced_2 : com.aliyun.svideo.base.R.id.beauty_advanced_1 : com.aliyun.svideo.base.R.id.beauty_advanced_0;
        android.widget.RadioGroup radioGroup = this.mRgAdvancedGroup;
        if (radioGroup != null) {
            radioGroup.check(i2);
        }
    }

    private void initView(android.content.Context context) {
        android.view.LayoutInflater.from(context).inflate(com.aliyun.svideo.base.R.layout.alivc_beauty_face_view, this);
        android.widget.RadioGroup radioGroup = (android.widget.RadioGroup) findViewById(com.aliyun.svideo.base.R.id.beauty_advanced_group);
        this.mRgAdvancedGroup = radioGroup;
        radioGroup.setOnCheckedChangeListener(new com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView.AnonymousClass1());
        findViewById(com.aliyun.svideo.base.R.id.blank_view).setOnClickListener(new com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView.AnonymousClass2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int switchIdToLevel(int i) {
        if (i == com.aliyun.svideo.base.R.id.beauty_advanced_0) {
            return 0;
        }
        if (i == com.aliyun.svideo.base.R.id.beauty_advanced_1) {
            return 20;
        }
        if (i == com.aliyun.svideo.base.R.id.beauty_advanced_2) {
            return 40;
        }
        if (i == com.aliyun.svideo.base.R.id.beauty_advanced_3) {
            return 60;
        }
        if (i == com.aliyun.svideo.base.R.id.beauty_advanced_4) {
            return 80;
        }
        return i == com.aliyun.svideo.base.R.id.beauty_advanced_5 ? 100 : 0;
    }

    public void setDefaultSelect(int i) {
        this.mCurrentLevel = i;
        advancedCheck(i);
    }

    public void setOnBeautyFaceLevelChangeListener(com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView.OnLevelChangeListener onLevelChangeListener) {
        this.mOnBeautyFaceLevelChangeListener = onLevelChangeListener;
    }

    public void setOnBlankClickListener(android.view.View.OnClickListener onClickListener) {
        this.mOnBlankClickListener = onClickListener;
    }
}
