package com.aliyun.svideo.common.base;

/* loaded from: classes.dex */
public class AlivcWheelDialogFragment extends com.aliyun.svideo.common.base.BaseDialogFragment implements com.aliyun.svideo.common.widget.WheelView.OnValueChangeListener {
    private java.lang.String mDialogLeft;
    private java.lang.String mDialogRight;
    private java.lang.String[] mDialogWheel;
    public androidx.fragment.app.FragmentManager mFragmentManager;
    private com.aliyun.svideo.common.base.AlivcWheelDialogFragment.OnWheelDialogListener mOnWheelDialogListener;
    private android.widget.TextView mTvLeft;
    private android.widget.TextView mTvRight;
    private com.aliyun.svideo.common.widget.WheelView mWheelView;
    public boolean mIsCancelableOutside = true;
    public int mDialogAnimationRes = 0;

    /* renamed from: com.aliyun.svideo.common.base.AlivcWheelDialogFragment$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.common.base.AlivcWheelDialogFragment.this.mOnWheelDialogListener != null) {
                com.aliyun.svideo.common.base.AlivcWheelDialogFragment.OnWheelDialogListener onWheelDialogListener = com.aliyun.svideo.common.base.AlivcWheelDialogFragment.this.mOnWheelDialogListener;
                com.aliyun.svideo.common.base.AlivcWheelDialogFragment alivcWheelDialogFragment = com.aliyun.svideo.common.base.AlivcWheelDialogFragment.this;
                onWheelDialogListener.onClickLeft(alivcWheelDialogFragment, alivcWheelDialogFragment.getWheelValue());
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.common.base.AlivcWheelDialogFragment$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.common.base.AlivcWheelDialogFragment.this.mOnWheelDialogListener != null) {
                com.aliyun.svideo.common.base.AlivcWheelDialogFragment.OnWheelDialogListener onWheelDialogListener = com.aliyun.svideo.common.base.AlivcWheelDialogFragment.this.mOnWheelDialogListener;
                com.aliyun.svideo.common.base.AlivcWheelDialogFragment alivcWheelDialogFragment = com.aliyun.svideo.common.base.AlivcWheelDialogFragment.this;
                onWheelDialogListener.onClickRight(alivcWheelDialogFragment, alivcWheelDialogFragment.getWheelValue());
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class Builder {
        private com.aliyun.svideo.common.base.AlivcWheelDialogFragment mDialogFragment;

        public Builder(androidx.fragment.app.FragmentManager fragmentManager) {
            com.aliyun.svideo.common.base.AlivcWheelDialogFragment alivcWheelDialogFragment = new com.aliyun.svideo.common.base.AlivcWheelDialogFragment();
            this.mDialogFragment = alivcWheelDialogFragment;
            alivcWheelDialogFragment.mFragmentManager = fragmentManager;
        }

        public com.aliyun.svideo.common.base.AlivcWheelDialogFragment.Builder cancelString(java.lang.String str) {
            this.mDialogFragment.mDialogLeft = str;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcWheelDialogFragment create() {
            return this.mDialogFragment;
        }

        public com.aliyun.svideo.common.base.AlivcWheelDialogFragment.Builder dialogAnimationRes(int i) {
            this.mDialogFragment.mDialogAnimationRes = i;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcWheelDialogFragment.Builder isCancelableOutside(boolean z) {
            this.mDialogFragment.mIsCancelableOutside = z;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcWheelDialogFragment.Builder onWheelDialogListener(com.aliyun.svideo.common.base.AlivcWheelDialogFragment.OnWheelDialogListener onWheelDialogListener) {
            this.mDialogFragment.mOnWheelDialogListener = onWheelDialogListener;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcWheelDialogFragment.Builder setWheelData(java.lang.String[] strArr) {
            this.mDialogFragment.mDialogWheel = strArr;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcWheelDialogFragment.Builder sureString(java.lang.String str) {
            this.mDialogFragment.mDialogRight = str;
            return this;
        }
    }

    public interface OnWheelDialogListener {
        void onClickLeft(androidx.fragment.app.DialogFragment dialogFragment, java.lang.String str);

        void onClickRight(androidx.fragment.app.DialogFragment dialogFragment, java.lang.String str);

        void onValueChanged(androidx.fragment.app.DialogFragment dialogFragment, java.lang.String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getWheelValue() {
        java.lang.String[] displayedValues = this.mWheelView.getDisplayedValues();
        if (displayedValues == null) {
            return null;
        }
        return displayedValues[this.mWheelView.getValue() - this.mWheelView.getMinValue()];
    }

    @Override // com.aliyun.svideo.common.base.BaseDialogFragment
    public void bindView(android.view.View view) {
        this.mTvLeft = (android.widget.TextView) view.findViewById(com.aliyun.svideo.common.R.id.alivc_tv_cancel);
        this.mTvRight = (android.widget.TextView) view.findViewById(com.aliyun.svideo.common.R.id.alivc_tv_sure);
        this.mWheelView = (com.aliyun.svideo.common.widget.WheelView) view.findViewById(com.aliyun.svideo.common.R.id.alivc_wheelView_dialog);
        this.mTvLeft.setText(this.mDialogLeft);
        this.mTvRight.setText(this.mDialogRight);
        this.mWheelView.refreshByNewDisplayedValues(this.mDialogWheel);
        this.mWheelView.setWrapSelectorWheel(false);
        this.mWheelView.setDividerColor(androidx.core.content.ContextCompat.getColor(getContext(), com.aliyun.svideo.common.R.color.alivc_common_bg_white_gray));
        this.mWheelView.setSelectedTextColor(androidx.core.content.ContextCompat.getColor(getContext(), com.aliyun.svideo.common.R.color.alivc_common_bg_black));
        this.mWheelView.setNormalTextColor(androidx.core.content.ContextCompat.getColor(getContext(), com.aliyun.svideo.common.R.color.alivc_common_font_gray_333333));
        initEvent();
    }

    @Override // com.aliyun.svideo.common.base.BaseDialogFragment
    public int getDialogAnimationRes() {
        return this.mDialogAnimationRes;
    }

    @Override // com.aliyun.svideo.common.base.BaseDialogFragment
    public int getLayoutRes() {
        return com.aliyun.svideo.common.R.layout.alivc_common_dialogfragment_wheelview;
    }

    public void initEvent() {
        this.mTvLeft.setOnClickListener(new com.aliyun.svideo.common.base.AlivcWheelDialogFragment.AnonymousClass1());
        this.mTvRight.setOnClickListener(new com.aliyun.svideo.common.base.AlivcWheelDialogFragment.AnonymousClass2());
    }

    @Override // com.aliyun.svideo.common.base.BaseDialogFragment
    public boolean isCancelableOutside() {
        return this.mIsCancelableOutside;
    }

    @Override // com.aliyun.svideo.common.widget.WheelView.OnValueChangeListener
    public void onValueChange(com.aliyun.svideo.common.widget.WheelView wheelView, int i, int i2) {
        com.aliyun.svideo.common.base.AlivcWheelDialogFragment.OnWheelDialogListener onWheelDialogListener;
        java.lang.String[] displayedValues = this.mWheelView.getDisplayedValues();
        if (displayedValues == null || (onWheelDialogListener = this.mOnWheelDialogListener) == null) {
            return;
        }
        onWheelDialogListener.onValueChanged(this, displayedValues[i2 - this.mWheelView.getMinValue()]);
    }

    public void setWheelDialogListener(com.aliyun.svideo.common.base.AlivcWheelDialogFragment.OnWheelDialogListener onWheelDialogListener) {
        this.mOnWheelDialogListener = onWheelDialogListener;
    }

    public com.aliyun.svideo.common.base.AlivcWheelDialogFragment show() {
        try {
            androidx.fragment.app.FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.add(this, this.tag);
            beginTransaction.commitAllowingStateLoss();
        } catch (java.lang.Exception e) {
            e.toString();
        }
        return this;
    }
}
