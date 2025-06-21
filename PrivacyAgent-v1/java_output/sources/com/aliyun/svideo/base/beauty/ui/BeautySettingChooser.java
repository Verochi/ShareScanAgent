package com.aliyun.svideo.base.beauty.ui;

/* loaded from: classes.dex */
public class BeautySettingChooser extends com.aliyun.svideo.base.BaseChooser {
    private com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView mBeautyDetailSettingView;
    private int mCurrentLevel;
    private com.aliyun.svideo.base.beauty.api.OnDefaultBeautyLevelChangeListener mOnDefaultBeautyLevelChangeListener;

    /* renamed from: com.aliyun.svideo.base.beauty.ui.BeautySettingChooser$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView.OnLevelChangeListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView.OnLevelChangeListener
        public void onChangeListener(int i) {
            if (com.aliyun.svideo.base.beauty.ui.BeautySettingChooser.this.mOnDefaultBeautyLevelChangeListener != null) {
                com.aliyun.svideo.base.beauty.ui.BeautySettingChooser.this.mOnDefaultBeautyLevelChangeListener.onDefaultBeautyLevelChange(i);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.base.beauty.ui.BeautySettingChooser$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.base.beauty.ui.BeautySettingChooser.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    @Override // com.aliyun.svideo.base.BaseChooser, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, com.aliyun.svideo.base.R.style.QUDemoFullStyle);
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.Nullable
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Bundle bundle) {
        return new com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView(getContext());
    }

    @Override // com.aliyun.svideo.base.BaseChooser, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mBeautyDetailSettingView.setDefaultSelect(this.mCurrentLevel);
    }

    @Override // com.aliyun.svideo.base.BaseChooser, androidx.fragment.app.Fragment
    public void onViewCreated(android.view.View view, @androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView alivcBeautyFaceSettingView = (com.aliyun.svideo.base.beauty.ui.view.AlivcBeautyFaceSettingView) view;
        this.mBeautyDetailSettingView = alivcBeautyFaceSettingView;
        alivcBeautyFaceSettingView.setOnBeautyFaceLevelChangeListener(new com.aliyun.svideo.base.beauty.ui.BeautySettingChooser.AnonymousClass1());
        this.mBeautyDetailSettingView.setOnBlankClickListener(new com.aliyun.svideo.base.beauty.ui.BeautySettingChooser.AnonymousClass2());
    }

    public void setOnDefaultBeautyLevelChangeListener(com.aliyun.svideo.base.beauty.api.OnDefaultBeautyLevelChangeListener onDefaultBeautyLevelChangeListener) {
        this.mOnDefaultBeautyLevelChangeListener = onDefaultBeautyLevelChangeListener;
    }

    public void show(androidx.fragment.app.FragmentManager fragmentManager, java.lang.String str, int i) {
        this.mCurrentLevel = i;
        super.show(fragmentManager, str);
    }
}
