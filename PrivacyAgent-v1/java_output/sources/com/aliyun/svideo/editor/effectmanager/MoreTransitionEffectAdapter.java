package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes12.dex */
public class MoreTransitionEffectAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder> {
    private static final java.lang.String TAG = "com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter";
    private static final int VIEW_TYPE_DOWNLOADING = 3;
    private static final int VIEW_TYPE_LOCAL = 1;
    private static final int VIEW_TYPE_NO = 0;
    private static final int VIEW_TYPE_REMOTE = 2;
    private android.content.Context mContext;
    private java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.AnimationEffectForm>> mDataList = new java.util.ArrayList();
    private java.util.ArrayList<com.aliyun.svideo.base.Form.AnimationEffectForm> mLoadingMV = new java.util.ArrayList<>();
    private java.util.Comparator<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.AnimationEffectForm>> mMVCompator = new com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.AnimationFilterFormCompator();
    private com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.OnItemRightButtonClickListener mRightBtnClickListener;

    public class AnimationFilterFormCompator implements java.util.Comparator<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.AnimationEffectForm>> {
        public AnimationFilterFormCompator() {
        }

        @Override // java.util.Comparator
        public int compare(com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.AnimationEffectForm> effectBody, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.AnimationEffectForm> effectBody2) {
            if (effectBody == null && effectBody2 == null) {
                return 0;
            }
            if (effectBody == null && effectBody2 != null) {
                return -1;
            }
            if (effectBody != null && effectBody2 == null) {
                return 1;
            }
            if (effectBody.isLocal() && !effectBody2.isLocal()) {
                return -1;
            }
            if (!effectBody.isLocal() && effectBody2.isLocal()) {
                return 1;
            }
            if (effectBody.getData() == null && effectBody2.getData() == null) {
                return 0;
            }
            if (effectBody.getData() != null && effectBody2.getData() == null) {
                return 1;
            }
            if (effectBody.getData() == null && effectBody2.getData() != null) {
                return -1;
            }
            com.aliyun.svideo.base.Form.AnimationEffectForm data = effectBody.getData();
            com.aliyun.svideo.base.Form.AnimationEffectForm data2 = effectBody2.getData();
            if (data.getId() < data2.getId()) {
                return -1;
            }
            return data.getId() == data2.getId() ? 0 : 1;
        }
    }

    public class ImvViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private android.widget.ImageView downloadFinish;
        private android.widget.ImageView mAfIcon;
        private com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.AnimationEffectForm> mData;
        private int mPosition;
        private android.widget.TextView mTvDesc;
        private android.widget.TextView mTvName;
        private android.widget.TextView mTvRightButton;
        private android.widget.ProgressBar progressView;

        /* renamed from: com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter$ImvViewHolder$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnClickListener {
            final /* synthetic */ com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter val$this$0;

            public AnonymousClass1(com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter moreTransitionEffectAdapter) {
                this.val$this$0 = moreTransitionEffectAdapter;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                if (com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.this.mRightBtnClickListener != null) {
                    if (com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder.this.mData.isLocal()) {
                        com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.this.mRightBtnClickListener.onLocalItemClick(com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder.this.mPosition, com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder.this.mData);
                    } else {
                        com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.this.mRightBtnClickListener.onRemoteItemClick(com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder.this.mPosition, com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder.this.mData);
                    }
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        /* renamed from: com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter$ImvViewHolder$2, reason: invalid class name */
        public class AnonymousClass2 implements android.view.View.OnClickListener {
            final /* synthetic */ com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter val$this$0;

            public AnonymousClass2(com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter moreTransitionEffectAdapter) {
                this.val$this$0 = moreTransitionEffectAdapter;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                if (com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.this.mRightBtnClickListener != null) {
                    com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.this.mRightBtnClickListener.onLocalItemClick(com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder.this.mPosition, com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder.this.mData);
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        /* renamed from: com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter$ImvViewHolder$3, reason: invalid class name */
        public class AnonymousClass3 implements android.view.View.OnClickListener {
            final /* synthetic */ com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter val$this$0;

            public AnonymousClass3(com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter moreTransitionEffectAdapter) {
                this.val$this$0 = moreTransitionEffectAdapter;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                if (((com.aliyun.svideo.base.Form.AnimationEffectForm) com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder.this.mData.getData()).getPreviewMediaUrl() != null && !"".equals(((com.aliyun.svideo.base.Form.AnimationEffectForm) com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder.this.mData.getData()).getPreviewMediaUrl())) {
                    com.aliyun.svideo.editor.effects.imv.IMVPreviewDialog.newInstance(((com.aliyun.svideo.base.Form.AnimationEffectForm) com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder.this.mData.getData()).getPreviewMediaUrl(), ((com.aliyun.svideo.base.Form.AnimationEffectForm) com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder.this.mData.getData()).getPreviewImageUrl()).show(((com.aliyun.svideo.editor.effectmanager.MoreMVActivity) com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.this.mContext).getSupportFragmentManager(), "iMV");
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public ImvViewHolder(android.view.View view) {
            super(view);
            this.mTvName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_name);
            this.mTvDesc = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_desc);
            this.mAfIcon = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_icon);
            this.downloadFinish = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_download_finish);
            this.progressView = (android.widget.ProgressBar) view.findViewById(com.aliyun.svideo.editor.R.id.download_progress);
            android.widget.TextView textView = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_right_button);
            this.mTvRightButton = textView;
            textView.setText(com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.this.mContext.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_common_download));
            this.mTvRightButton.setOnClickListener(new com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder.AnonymousClass1(com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.this));
            this.downloadFinish.setOnClickListener(new com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder.AnonymousClass2(com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.this));
            view.setOnClickListener(new com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder.AnonymousClass3(com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.this));
        }

        public void updateData(int i, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.AnimationEffectForm> effectBody) {
            this.mData = effectBody;
            this.mPosition = i;
            com.aliyun.svideo.base.Form.AnimationEffectForm data = effectBody.getData();
            java.lang.String name = data.getName();
            if (!com.aliyun.svideo.common.utils.LanguageUtils.isCHEN(com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.this.mContext) && data.getNameEn() != null) {
                name = data.getNameEn();
            }
            this.mTvName.setText(name);
            if (com.aliyun.svideo.common.utils.LanguageUtils.isCHEN(com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.this.mContext) || data.getNameEn() == null) {
                this.mTvDesc.setText(data.getDescription());
            } else {
                this.mTvDesc.setText(data.getDescriptionEn());
            }
            new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(this.mAfIcon.getContext(), data.getIconUrl()).into(this.mAfIcon);
        }
    }

    public interface OnItemRightButtonClickListener {
        void onLocalItemClick(int i, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.AnimationEffectForm> effectBody);

        void onRemoteItemClick(int i, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.AnimationEffectForm> effectBody);
    }

    public MoreTransitionEffectAdapter(android.content.Context context) {
        this.mContext = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i < 0 || i >= this.mDataList.size()) {
            return 0;
        }
        com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.AnimationEffectForm> effectBody = this.mDataList.get(i);
        if (effectBody.isLocal()) {
            return 1;
        }
        return effectBody.isLoading() ? 3 : 2;
    }

    public synchronized void notifyDownloadingComplete(com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.AnimationEffectForm> effectBody, int i) {
        effectBody.setLocal(true);
        effectBody.setLoading(false);
        this.mLoadingMV.remove(effectBody.getData());
        notifyDataSetChanged();
    }

    public void notifyDownloadingFailure(com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.AnimationEffectForm> effectBody) {
        effectBody.setLocal(false);
        effectBody.setLoading(false);
        this.mLoadingMV.remove(effectBody.getData());
        notifyDataSetChanged();
    }

    public void notifyDownloadingStart(com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.AnimationEffectForm> effectBody) {
        if (this.mLoadingMV.contains(effectBody.getData())) {
            return;
        }
        this.mLoadingMV.add(effectBody.getData());
        effectBody.setLoading(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder imvViewHolder, int i) {
        int itemViewType = getItemViewType(i);
        imvViewHolder.mTvRightButton.setVisibility(0);
        imvViewHolder.progressView.setVisibility(8);
        if (itemViewType == 1) {
            imvViewHolder.mTvRightButton.setVisibility(4);
            imvViewHolder.downloadFinish.setVisibility(0);
            imvViewHolder.updateData(i, this.mDataList.get(i));
        } else if (itemViewType == 2) {
            imvViewHolder.mTvRightButton.setBackgroundResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_shape_caption_manager_bg);
            imvViewHolder.updateData(i, this.mDataList.get(i));
        } else {
            if (itemViewType != 3) {
                return;
            }
            imvViewHolder.mTvRightButton.setText(this.mContext.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_more_downloading));
            imvViewHolder.updateData(i, this.mDataList.get(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_more_effect, viewGroup, false));
    }

    public void setRightBtnClickListener(com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.OnItemRightButtonClickListener onItemRightButtonClickListener) {
        this.mRightBtnClickListener = onItemRightButtonClickListener;
    }

    public synchronized void syncData(java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.AnimationEffectForm>> list) {
        if (this.mLoadingMV.size() != 0) {
            return;
        }
        if (list == null) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.AnimationEffectForm> effectBody : this.mDataList) {
            if (!list.contains(effectBody)) {
                arrayList.add(effectBody);
            }
        }
        this.mDataList.removeAll(arrayList);
        for (com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.AnimationEffectForm> effectBody2 : list) {
            if (!this.mDataList.contains(effectBody2)) {
                this.mDataList.add(effectBody2);
            }
        }
        java.util.Collections.sort(this.mDataList, this.mMVCompator);
        notifyDataSetChanged();
    }

    public void updateProcess(com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectAdapter.ImvViewHolder imvViewHolder, int i, int i2) {
        if (imvViewHolder == null || imvViewHolder.mPosition != i2) {
            return;
        }
        imvViewHolder.mTvRightButton.setBackgroundColor(0);
        imvViewHolder.progressView.setVisibility(0);
        imvViewHolder.progressView.setProgress(i);
    }
}
