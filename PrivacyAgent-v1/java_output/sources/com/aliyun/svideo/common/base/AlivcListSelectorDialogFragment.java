package com.aliyun.svideo.common.base;

/* loaded from: classes.dex */
public class AlivcListSelectorDialogFragment extends com.aliyun.svideo.common.base.BaseDialogFragment {
    public static final java.lang.String TAG = "AlivcListSelectorDialogFragment";
    public androidx.fragment.app.FragmentManager mFragmentManager;
    public int mHeight;
    private int mItemSelectedColor;
    private int mItemUnSelectedColor;
    public android.content.DialogInterface.OnKeyListener mKeyListener;
    public java.util.List<java.lang.String> mLists;
    private com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.OnListItemSelectedListener mOnListItemSelectedListener;
    public java.lang.String mPosition;
    private com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.SelectorQuickAdapter mSelectorQuickAdapter;
    public android.widget.TextView mTvCancel;
    public int mWidth;
    private android.content.DialogInterface.OnDismissListener onDismissListener;
    public float mDimAmount = 0.2f;
    public int mGravity = 80;
    public java.lang.String mTag = TAG;
    public boolean mIsCancelableOutside = true;
    public int mDialogAnimationRes = 0;

    /* renamed from: com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.OnItemClickListener {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.OnItemClickListener
        public void onItemClick(com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter baseQuickAdapter, android.view.View view, int i) {
            if (com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.this.mOnListItemSelectedListener != null) {
                com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.this.mOnListItemSelectedListener.onClick(baseQuickAdapter.getData().get(i).toString());
                com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.this.dismiss();
            }
        }
    }

    public static class Builder {
        private com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment params;

        public Builder(androidx.fragment.app.FragmentManager fragmentManager) {
            com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment alivcListSelectorDialogFragment = new com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment();
            this.params = alivcListSelectorDialogFragment;
            alivcListSelectorDialogFragment.mFragmentManager = fragmentManager;
        }

        public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment create() {
            return this.params;
        }

        public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.Builder setCancelableOutside(boolean z) {
            this.params.mIsCancelableOutside = z;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.Builder setDialogAnimationRes(int i) {
            this.params.mDialogAnimationRes = i;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.Builder setDimAmount(float f) {
            this.params.mDimAmount = f;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.Builder setGravity(int i) {
            this.params.mGravity = i;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.Builder setHeight(int i) {
            this.params.mHeight = i;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.Builder setItemColor(int i) {
            this.params.mItemSelectedColor = i;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.Builder setNewData(java.util.ArrayList<java.lang.String> arrayList) {
            this.params.mLists = arrayList;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.Builder setOnDismissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
            this.params.onDismissListener = onDismissListener;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.Builder setOnKeyListener(android.content.DialogInterface.OnKeyListener onKeyListener) {
            this.params.mKeyListener = onKeyListener;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.Builder setOnListItemSelectedListener(com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.OnListItemSelectedListener onListItemSelectedListener) {
            this.params.mOnListItemSelectedListener = onListItemSelectedListener;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.Builder setScreenHeightAspect(android.content.Context context, float f) {
            this.params.mHeight = (int) (com.aliyun.svideo.common.base.BaseDialogFragment.getScreenHeight(context) * f);
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.Builder setScreenWidthAspect(android.content.Context context, float f) {
            this.params.mWidth = (int) (com.aliyun.svideo.common.base.BaseDialogFragment.getScreenWidth(context) * f);
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.Builder setTag(java.lang.String str) {
            this.params.mTag = str;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.Builder setUnItemColor(int i) {
            this.params.mItemUnSelectedColor = i;
            return this;
        }

        public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.Builder setWidth(int i) {
            this.params.mWidth = i;
            return this;
        }
    }

    public interface OnListItemSelectedListener {
        void onClick(java.lang.String str);
    }

    public class SelectorQuickAdapter extends com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter<java.lang.String, com.aliyun.svideo.common.baseAdapter.BaseViewHolder> {
        private java.lang.String mPosition;

        public SelectorQuickAdapter(int i, @androidx.annotation.Nullable java.util.List<java.lang.String> list) {
            super(i, list);
        }

        @Override // com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter
        public void convert(com.aliyun.svideo.common.baseAdapter.BaseViewHolder baseViewHolder, java.lang.String str) {
            android.widget.TextView textView = (android.widget.TextView) baseViewHolder.getView(com.aliyun.svideo.common.R.id.alivc_tv_name);
            textView.setText(str);
            java.lang.String str2 = this.mPosition;
            if (str2 == null || !str2.equals(str)) {
                textView.setTextColor(com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.this.mItemUnSelectedColor);
            } else {
                textView.setTextColor(com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.this.mItemSelectedColor);
            }
        }

        public void setSelectedPosition(java.lang.String str) {
            this.mPosition = str;
        }
    }

    private void initData() {
        java.util.List<java.lang.String> list = this.mLists;
        if (list != null) {
            this.mSelectorQuickAdapter.setNewData(list);
            this.mSelectorQuickAdapter.setOnItemClickListener(new com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.AnonymousClass2());
        }
        java.lang.String str = this.mPosition;
        if (str != null) {
            this.mSelectorQuickAdapter.setSelectedPosition(str);
        }
    }

    @Override // com.aliyun.svideo.common.base.BaseDialogFragment
    public void bindView(android.view.View view) {
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) view.findViewById(com.aliyun.svideo.common.R.id.alivc_common_dialog_recyclerview);
        android.widget.TextView textView = (android.widget.TextView) view.findViewById(com.aliyun.svideo.common.R.id.alivc_tv_cancel);
        this.mTvCancel = textView;
        textView.setOnClickListener(new com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.AnonymousClass1());
        androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = new androidx.recyclerview.widget.LinearLayoutManager(getActivity(), 1, false);
        com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.SelectorQuickAdapter selectorQuickAdapter = new com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.SelectorQuickAdapter(com.aliyun.svideo.common.R.layout.alivc_common_dialog_rv_selector_item, null);
        this.mSelectorQuickAdapter = selectorQuickAdapter;
        recyclerView.setAdapter(selectorQuickAdapter);
        androidx.recyclerview.widget.DividerItemDecoration dividerItemDecoration = new androidx.recyclerview.widget.DividerItemDecoration(getActivity(), 1);
        dividerItemDecoration.setDrawable(androidx.core.content.ContextCompat.getDrawable(getActivity(), com.aliyun.svideo.common.R.drawable.alivc_common_rv_divider_gray_vertical));
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(linearLayoutManager);
        initData();
    }

    @Override // com.aliyun.svideo.common.base.BaseDialogFragment
    public int getDialogAnimationRes() {
        return this.mDialogAnimationRes;
    }

    @Override // com.aliyun.svideo.common.base.BaseDialogFragment
    public int getDialogHeight() {
        return this.mHeight;
    }

    @Override // com.aliyun.svideo.common.base.BaseDialogFragment
    public int getDialogWidth() {
        return this.mWidth;
    }

    @Override // com.aliyun.svideo.common.base.BaseDialogFragment
    public float getDimAmount() {
        return this.mDimAmount;
    }

    @Override // com.aliyun.svideo.common.base.BaseDialogFragment
    public java.lang.String getFragmentTag() {
        return this.mTag;
    }

    @Override // com.aliyun.svideo.common.base.BaseDialogFragment
    public int getGravity() {
        return this.mGravity;
    }

    @Override // com.aliyun.svideo.common.base.BaseDialogFragment
    public int getLayoutRes() {
        return com.aliyun.svideo.common.R.layout.alivc_common_dialogfragment_selector;
    }

    @Override // com.aliyun.svideo.common.base.BaseDialogFragment
    public android.content.DialogInterface.OnKeyListener getOnKeyListener() {
        return this.mKeyListener;
    }

    @Override // com.aliyun.svideo.common.base.BaseDialogFragment
    public boolean isCancelableOutside() {
        return this.mIsCancelableOutside;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        android.content.DialogInterface.OnDismissListener onDismissListener = this.onDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public void setOnListSelectedListener(com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment.OnListItemSelectedListener onListItemSelectedListener) {
        this.mOnListItemSelectedListener = onListItemSelectedListener;
    }

    public void setPosition(java.lang.String str) {
        this.mPosition = str;
    }

    public com.aliyun.svideo.common.base.AlivcListSelectorDialogFragment show() {
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
