package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes12.dex */
public class MorePasterAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder> {
    public static final java.lang.String DOWNLOAD_FINISH = "download_finish";
    public static final java.lang.String DOWNLOAD_START = "download_start";
    private static final java.lang.String TAG = "com.aliyun.svideo.editor.effectmanager.MorePasterAdapter";
    private static final int VIEW_TYPE_DOWNLOADING = 3;
    private static final int VIEW_TYPE_LOCAL = 1;
    private static final int VIEW_TYPE_NO = 0;
    private static final int VIEW_TYPE_REMOTE = 2;
    private android.content.Context mContext;
    private java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm>> mDataList = new java.util.ArrayList();
    private java.util.ArrayList<com.aliyun.svideo.base.Form.ResourceForm> mLoadingPaster = new java.util.ArrayList<>();
    private java.util.Comparator<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm>> mPasterCompator = new com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.ResourceFormCompator();
    private com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.OnItemRightButtonClickListener mRightBtnClickListener;

    public interface OnItemRightButtonClickListener {
        void onLocalItemClick(int i, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody);

        void onRemoteItemClick(int i, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody);
    }

    public class PasterViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private android.widget.ImageView downloadFinish;
        private com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> mData;
        private android.widget.ImageView mIvIcon;
        private int mPosition;
        private android.widget.TextView mTvDesc;
        private android.widget.TextView mTvName;
        private android.widget.TextView mTvRightButton;
        private android.widget.ProgressBar progressView;

        /* renamed from: com.aliyun.svideo.editor.effectmanager.MorePasterAdapter$PasterViewHolder$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnClickListener {
            final /* synthetic */ com.aliyun.svideo.editor.effectmanager.MorePasterAdapter val$this$0;

            public AnonymousClass1(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter morePasterAdapter) {
                this.val$this$0 = morePasterAdapter;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                if (com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder.this.mData.isLocal()) {
                    if (com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.this.mRightBtnClickListener != null) {
                        com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.this.mRightBtnClickListener.onLocalItemClick(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder.this.mPosition, com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder.this.mData);
                    }
                } else if (com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.this.mRightBtnClickListener != null) {
                    com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.this.mRightBtnClickListener.onRemoteItemClick(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder.this.mPosition, com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder.this.mData);
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        /* renamed from: com.aliyun.svideo.editor.effectmanager.MorePasterAdapter$PasterViewHolder$2, reason: invalid class name */
        public class AnonymousClass2 implements android.view.View.OnClickListener {
            final /* synthetic */ com.aliyun.svideo.editor.effectmanager.MorePasterAdapter val$this$0;

            public AnonymousClass2(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter morePasterAdapter) {
                this.val$this$0 = morePasterAdapter;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                if (com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.this.mRightBtnClickListener != null) {
                    com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.this.mRightBtnClickListener.onLocalItemClick(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder.this.mPosition, com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder.this.mData);
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        /* renamed from: com.aliyun.svideo.editor.effectmanager.MorePasterAdapter$PasterViewHolder$3, reason: invalid class name */
        public class AnonymousClass3 implements android.view.View.OnClickListener {
            final /* synthetic */ com.aliyun.svideo.editor.effectmanager.MorePasterAdapter val$this$0;

            public AnonymousClass3(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter morePasterAdapter) {
                this.val$this$0 = morePasterAdapter;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                com.aliyun.svideo.editor.effects.overlay.PasterPreviewDialog newInstance;
                if (((com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder.this.mData.getData()).getPreviewUrl() != null && !"".equals(((com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder.this.mData.getData()).getPreviewUrl()) && (newInstance = com.aliyun.svideo.editor.effects.overlay.PasterPreviewDialog.newInstance(((com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder.this.mData.getData()).getPreviewUrl(), ((com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder.this.mData.getData()).getName(), ((com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder.this.mData.getData()).getId())) != null) {
                    newInstance.show(((com.aliyun.svideo.editor.effectmanager.MorePasterActivity) com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.this.mContext).getSupportFragmentManager(), com.aliyun.svideo.editor.util.EditorCommon.QU_OVERLAY);
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public PasterViewHolder(android.view.View view) {
            super(view);
            this.mPosition = -1;
            this.mTvName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_name);
            this.mTvDesc = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_desc);
            this.mIvIcon = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_icon);
            this.progressView = (android.widget.ProgressBar) view.findViewById(com.aliyun.svideo.editor.R.id.download_progress);
            this.downloadFinish = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_download_finish);
            android.widget.TextView textView = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_right_button);
            this.mTvRightButton = textView;
            textView.setText(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.this.mContext.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_common_download));
            this.mTvRightButton.setOnClickListener(new com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder.AnonymousClass1(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.this));
            this.downloadFinish.setOnClickListener(new com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder.AnonymousClass2(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.this));
            view.setOnClickListener(new com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder.AnonymousClass3(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.this));
        }

        public void updateData(int i, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody) {
            this.mData = effectBody;
            this.mPosition = i;
            com.aliyun.svideo.base.Form.ResourceForm data = effectBody.getData();
            java.lang.String name = data.getName();
            java.lang.String description = data.getDescription();
            if (!com.aliyun.svideo.common.utils.LanguageUtils.isCHEN(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.this.mContext)) {
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

    public class ResourceFormCompator implements java.util.Comparator<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm>> {
        public ResourceFormCompator() {
        }

        @Override // java.util.Comparator
        public int compare(com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody2) {
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
            com.aliyun.svideo.base.Form.ResourceForm data = effectBody.getData();
            com.aliyun.svideo.base.Form.ResourceForm data2 = effectBody2.getData();
            if (data.getId() < data2.getId()) {
                return -1;
            }
            return data.getId() == data2.getId() ? 0 : 1;
        }
    }

    public MorePasterAdapter(android.content.Context context) {
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
        com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody = this.mDataList.get(i);
        if (effectBody.isLocal()) {
            return 1;
        }
        return effectBody.isLoading() ? 3 : 2;
    }

    public synchronized void notifyDownloadingComplete(com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody, int i) {
        effectBody.setLocal(true);
        effectBody.setLoading(false);
        this.mLoadingPaster.remove(effectBody.getData());
        notifyItemChanged(i, DOWNLOAD_FINISH);
    }

    public void notifyDownloadingFailure(com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody) {
        effectBody.setLocal(false);
        effectBody.setLoading(false);
        this.mLoadingPaster.remove(effectBody.getData());
        notifyDataSetChanged();
    }

    public void notifyDownloadingStart(com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody) {
        if (this.mLoadingPaster.contains(effectBody.getData())) {
            return;
        }
        this.mLoadingPaster.add(effectBody.getData());
        effectBody.setLoading(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder pasterViewHolder, int i, java.util.List list) {
        onBindViewHolder2(pasterViewHolder, i, (java.util.List<java.lang.Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder pasterViewHolder, int i) {
        int itemViewType = getItemViewType(i);
        com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody = this.mDataList.get(i);
        if (itemViewType == 1) {
            pasterViewHolder.mTvRightButton.setVisibility(4);
            pasterViewHolder.downloadFinish.setVisibility(0);
            pasterViewHolder.progressView.setVisibility(4);
        } else if (itemViewType == 2) {
            pasterViewHolder.mTvRightButton.setText(com.aliyun.svideo.editor.R.string.alivc_common_download);
            pasterViewHolder.mTvRightButton.setVisibility(0);
            pasterViewHolder.progressView.setVisibility(4);
            pasterViewHolder.downloadFinish.setVisibility(4);
            pasterViewHolder.mTvRightButton.setBackgroundResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_shape_caption_manager_bg);
        } else if (itemViewType == 3) {
            pasterViewHolder.mTvRightButton.setText(com.aliyun.svideo.editor.R.string.alivc_editor_more_downloading);
            pasterViewHolder.mTvRightButton.setVisibility(0);
            pasterViewHolder.mTvRightButton.setBackgroundResource(com.aliyun.svideo.editor.R.color.alivc_common_bg_transparent);
            pasterViewHolder.progressView.setVisibility(0);
            pasterViewHolder.downloadFinish.setVisibility(4);
        }
        pasterViewHolder.progressView.setProgress(0);
        pasterViewHolder.updateData(i, effectBody);
    }

    /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
    public void onBindViewHolder2(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder pasterViewHolder, int i, java.util.List<java.lang.Object> list) {
        synchronized (com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.class) {
            if (list != null) {
                if (list.size() != 0) {
                    for (java.lang.Object obj : list) {
                        if (DOWNLOAD_START.equals(obj)) {
                            pasterViewHolder.mTvRightButton.setBackgroundResource(com.aliyun.svideo.editor.R.color.alivc_common_bg_transparent);
                            pasterViewHolder.progressView.setVisibility(0);
                            pasterViewHolder.progressView.setProgress(0);
                        } else if (DOWNLOAD_FINISH.equals(obj)) {
                            pasterViewHolder.mTvRightButton.setVisibility(4);
                            pasterViewHolder.downloadFinish.setVisibility(0);
                            pasterViewHolder.progressView.setVisibility(4);
                            pasterViewHolder.progressView.setProgress(0);
                        }
                    }
                    return;
                }
            }
            super.onBindViewHolder((com.aliyun.svideo.editor.effectmanager.MorePasterAdapter) pasterViewHolder, i, list);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_more_effect, viewGroup, false));
    }

    public void setRightBtnClickListener(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.OnItemRightButtonClickListener onItemRightButtonClickListener) {
        this.mRightBtnClickListener = onItemRightButtonClickListener;
    }

    public synchronized void syncData(java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm>> list) {
        if (this.mLoadingPaster.size() != 0) {
            return;
        }
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
        java.util.Collections.sort(this.mDataList, this.mPasterCompator);
        notifyDataSetChanged();
    }

    public void updateProcess(com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder pasterViewHolder, int i, int i2) {
        if (pasterViewHolder == null || pasterViewHolder.mPosition != i2 || pasterViewHolder.progressView.getProgress() > i || pasterViewHolder.mData.isLocal()) {
            return;
        }
        pasterViewHolder.mTvRightButton.setText(com.aliyun.svideo.editor.R.string.alivc_editor_more_downloading);
        pasterViewHolder.mTvRightButton.setBackgroundColor(0);
        pasterViewHolder.progressView.setVisibility(0);
        pasterViewHolder.progressView.setProgress(i);
    }
}
