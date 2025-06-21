package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes12.dex */
public class RecycleViewAdapter extends com.aliyun.svideo.editor.effectmanager.StateController.StateAdapter<com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter.PasterViewHolder> {
    private java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list;
    private android.content.Context mContext;

    public class PasterViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private com.aliyun.svideo.downloader.FileDownloaderModel mData;
        private android.widget.ImageView mIvIcon;
        private int mPosition;
        private android.widget.TextView mTvDesc;
        private android.widget.TextView mTvName;
        private android.widget.ProgressBar progressView;
        private android.widget.TextView tvDelete;

        /* renamed from: com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter$PasterViewHolder$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnClickListener {
            final /* synthetic */ com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter val$this$0;

            public AnonymousClass1(com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter recycleViewAdapter) {
                this.val$this$0 = recycleViewAdapter;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = (com.aliyun.svideo.downloader.FileDownloaderModel) com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter.this.list.remove(com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter.PasterViewHolder.this.mPosition);
                com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter.this.notifyDataSetChanged();
                com.aliyun.svideo.downloader.DownloaderManager.getInstance().deleteTask(fileDownloaderModel.getId());
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public PasterViewHolder(android.view.View view) {
            super(view);
            this.mTvName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_name);
            this.mTvDesc = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_desc);
            this.progressView = (android.widget.ProgressBar) view.findViewById(com.aliyun.svideo.editor.R.id.download_progress);
            this.tvDelete = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_right_button);
            this.mIvIcon = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_icon);
            this.tvDelete.setText(com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter.this.mContext.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_manager_delete));
            this.tvDelete.setBackgroundResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_shape_effect_manager_delete_bg);
            this.tvDelete.setOnClickListener(new com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter.PasterViewHolder.AnonymousClass1(com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter.this));
            this.progressView.setVisibility(8);
            this.tvDelete.setVisibility(0);
        }

        public void updateData(int i, com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel) {
            this.mData = fileDownloaderModel;
            this.mPosition = i;
            java.lang.String name = fileDownloaderModel.getName();
            java.lang.String description = this.mData.getDescription();
            if (!com.aliyun.svideo.common.utils.LanguageUtils.isCHEN(com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter.this.mContext)) {
                if (this.mData.getNameEn() != null) {
                    name = this.mData.getNameEn();
                }
                if (this.mData.getDescriptionEn() != null) {
                    description = this.mData.getDescriptionEn();
                }
            }
            this.mTvName.setText(name);
            this.mTvDesc.setText(description);
            new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(this.mIvIcon.getContext(), this.mData.getIcon()).into(this.mIvIcon);
        }
    }

    public RecycleViewAdapter(android.content.Context context, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list) {
        this.list = list;
        this.mContext = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter.PasterViewHolder pasterViewHolder, int i) {
        pasterViewHolder.updateData(i, this.list.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter.PasterViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effectmanager.RecycleViewAdapter.PasterViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_more_effect, viewGroup, false));
    }
}
