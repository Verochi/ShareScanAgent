package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes12.dex */
public class MoreCaptionAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder> {
    private static final java.lang.String TAG = "com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter";
    private static final int VIEW_TYPE_DOWNLOADING = 3;
    private static final int VIEW_TYPE_LOCAL = 1;
    private static final int VIEW_TYPE_REMOTE = 2;
    private android.content.Context mContext;
    private java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm>> mDataList;
    private com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.OnItemRightButtonClickListener mRightBtnClickListener;

    public class CaptionViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private android.widget.ImageView downloadFinish;
        private android.widget.ProgressBar downloadProgress;
        private com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> mData;
        private android.widget.ImageView mIvIcon;
        private int mPosition;
        private android.widget.TextView mTvDesc;
        private android.widget.TextView mTvName;
        private android.widget.TextView mTvRightButton;

        /* renamed from: com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter$CaptionViewHolder$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnClickListener {
            final /* synthetic */ com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter val$this$0;

            public AnonymousClass1(com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter moreCaptionAdapter) {
                this.val$this$0 = moreCaptionAdapter;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                if (com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.this.mRightBtnClickListener != null) {
                    if (com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder.this.mData.isLocal()) {
                        com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.this.mRightBtnClickListener.onLocalItemClick(com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder.this.mPosition, com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder.this.mData);
                    } else {
                        com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.this.mRightBtnClickListener.onRemoteItemClick(com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder.this.mPosition, com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder.this.mData);
                    }
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        /* renamed from: com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter$CaptionViewHolder$2, reason: invalid class name */
        public class AnonymousClass2 implements android.view.View.OnClickListener {
            final /* synthetic */ com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter val$this$0;

            public AnonymousClass2(com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter moreCaptionAdapter) {
                this.val$this$0 = moreCaptionAdapter;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                com.aliyun.svideo.editor.effects.overlay.PasterPreviewDialog newInstance;
                if (((com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder.this.mData.getData()).getPreviewUrl() != null && !"".equals(((com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder.this.mData.getData()).getPreviewUrl()) && (newInstance = com.aliyun.svideo.editor.effects.overlay.PasterPreviewDialog.newInstance(((com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder.this.mData.getData()).getPreviewUrl(), ((com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder.this.mData.getData()).getName(), ((com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder.this.mData.getData()).getId())) != null) {
                    newInstance.show(((com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity) com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.this.mContext).getSupportFragmentManager(), com.aliyun.svideo.editor.util.EditorCommon.QU_CAPTION);
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public CaptionViewHolder(android.view.View view) {
            super(view);
            this.mTvName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_name);
            this.mTvDesc = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_desc);
            this.mTvRightButton = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_right_button);
            this.mIvIcon = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_icon);
            this.downloadProgress = (android.widget.ProgressBar) view.findViewById(com.aliyun.svideo.editor.R.id.download_progress);
            this.downloadFinish = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_download_finish);
            this.mTvRightButton.setOnClickListener(new com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder.AnonymousClass1(com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.this));
            view.setOnClickListener(new com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder.AnonymousClass2(com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.this));
        }

        public void updateData(int i, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody) {
            this.mData = effectBody;
            this.mPosition = i;
            com.aliyun.svideo.base.Form.ResourceForm data = effectBody.getData();
            java.lang.String name = data.getName();
            java.lang.String description = data.getDescription();
            if (!com.aliyun.svideo.common.utils.LanguageUtils.isCHEN(com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.this.mContext)) {
                if (data.getNameEn() != null) {
                    name = data.getNameEn();
                }
                if (data.getDescriptionEn() != null) {
                    description = data.getDescriptionEn();
                }
            }
            this.mTvName.setText(name);
            this.mTvDesc.setText(description);
            new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(this.mIvIcon.getContext(), data.getIcon()).into(this.mIvIcon);
        }
    }

    public interface OnItemRightButtonClickListener {
        void onLocalItemClick(int i, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody);

        void onRemoteItemClick(int i, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody);
    }

    public MoreCaptionAdapter(java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm>> list, android.content.Context context) {
        this.mDataList = list;
        this.mContext = context;
    }

    public synchronized void changeToLocal(com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody) {
        for (com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody2 : this.mDataList) {
            if (effectBody2.equals(effectBody)) {
                effectBody2.setLocal(true);
                effectBody2.setLoading(false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i < 0 || i >= this.mDataList.size()) {
            return 1;
        }
        com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody = this.mDataList.get(i);
        if (effectBody.isLocal()) {
            return 1;
        }
        return effectBody.isLoading() ? 3 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder captionViewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            captionViewHolder.mTvRightButton.setVisibility(0);
            captionViewHolder.downloadFinish.setVisibility(0);
            captionViewHolder.mTvRightButton.setBackgroundColor(0);
            captionViewHolder.downloadProgress.setVisibility(8);
        } else if (itemViewType == 2) {
            captionViewHolder.mTvRightButton.setVisibility(0);
            captionViewHolder.mTvRightButton.setText(com.aliyun.svideo.editor.R.string.alivc_common_download);
            captionViewHolder.mTvRightButton.setBackgroundResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_shape_caption_manager_bg);
            captionViewHolder.downloadFinish.setVisibility(8);
            captionViewHolder.downloadProgress.setVisibility(8);
        } else if (itemViewType == 3) {
            captionViewHolder.downloadFinish.setVisibility(8);
            captionViewHolder.downloadProgress.setVisibility(0);
            captionViewHolder.mTvRightButton.setVisibility(0);
            captionViewHolder.mTvRightButton.setText(com.aliyun.svideo.editor.R.string.alivc_editor_more_downloading);
            captionViewHolder.mTvRightButton.setBackgroundColor(0);
        }
        captionViewHolder.updateData(i, this.mDataList.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_more_caption, viewGroup, false));
    }

    public void onDownloadFailure(com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody) {
        if (this.mDataList.contains(effectBody)) {
            effectBody.setLocal(false);
            effectBody.setLoading(false);
        }
        notifyDataSetChanged();
    }

    public void setRightBtnClickListener(com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.OnItemRightButtonClickListener onItemRightButtonClickListener) {
        this.mRightBtnClickListener = onItemRightButtonClickListener;
    }

    public synchronized void syncData(java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm>> list) {
        if (list == null) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody : this.mDataList) {
            if (!list.contains(effectBody)) {
                arrayList.add(effectBody);
            }
        }
        this.mDataList.removeAll(arrayList);
        for (com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody2 : list) {
            if (!this.mDataList.contains(effectBody2)) {
                this.mDataList.add(effectBody2);
            }
        }
        notifyDataSetChanged();
    }

    public void updateProcess(com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder captionViewHolder, int i, int i2) {
        if (captionViewHolder == null || captionViewHolder.mPosition != i2) {
            return;
        }
        captionViewHolder.mTvRightButton.setBackgroundColor(0);
        captionViewHolder.downloadProgress.setVisibility(0);
        captionViewHolder.downloadProgress.setProgress(i);
        if (captionViewHolder.mData != null) {
            captionViewHolder.mData.setLoading(true);
        }
    }
}
