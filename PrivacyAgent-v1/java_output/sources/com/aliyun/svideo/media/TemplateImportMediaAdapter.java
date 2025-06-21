package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class TemplateImportMediaAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.aliyun.svideo.media.TemplateImportMediaAdapter.TemplateImportViewHolder> {
    private com.aliyun.svideo.media.MediaImageLoader mImageLoader;
    private com.aliyun.svideo.media.TemplateImportMediaAdapter.OnItemViewCallback mItemViewCallback;
    private java.util.HashMap<java.lang.Integer, com.aliyun.svideo.media.MediaInfo> mDataMap = new java.util.HashMap<>();
    private java.util.List<java.lang.Long> mTemplateParams = new java.util.ArrayList();
    private int mSelectIndex = 0;

    /* renamed from: com.aliyun.svideo.media.TemplateImportMediaAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ com.aliyun.svideo.media.MediaInfo val$info;
        final /* synthetic */ int val$position;

        public AnonymousClass1(com.aliyun.svideo.media.MediaInfo mediaInfo, int i) {
            this.val$info = mediaInfo;
            this.val$position = i;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.media.TemplateImportMediaAdapter.this.mItemViewCallback != null) {
                if (this.val$info != null) {
                    com.aliyun.svideo.media.TemplateImportMediaAdapter.this.mItemViewCallback.onItemPhotoClick(this.val$info, this.val$position);
                } else {
                    com.aliyun.svideo.media.TemplateImportMediaAdapter.this.mSelectIndex = this.val$position;
                    com.aliyun.svideo.media.TemplateImportMediaAdapter.this.mItemViewCallback.onDurationChange(((java.lang.Long) com.aliyun.svideo.media.TemplateImportMediaAdapter.this.mTemplateParams.get(this.val$position)).longValue());
                }
            }
            com.aliyun.svideo.media.TemplateImportMediaAdapter.this.notifyDataSetChanged();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.media.TemplateImportMediaAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        final /* synthetic */ com.aliyun.svideo.media.MediaInfo val$info;
        final /* synthetic */ int val$position;

        public AnonymousClass2(int i, com.aliyun.svideo.media.MediaInfo mediaInfo) {
            this.val$position = i;
            this.val$info = mediaInfo;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.media.TemplateImportMediaAdapter.this.mSelectIndex = this.val$position;
            if (com.aliyun.svideo.media.TemplateImportMediaAdapter.this.mItemViewCallback != null) {
                com.aliyun.svideo.media.TemplateImportMediaAdapter.this.mItemViewCallback.onItemDeleteClick(this.val$info);
                com.aliyun.svideo.media.TemplateImportMediaAdapter.this.mItemViewCallback.onDurationChange(((java.lang.Long) com.aliyun.svideo.media.TemplateImportMediaAdapter.this.mTemplateParams.get(this.val$position)).longValue());
            }
            com.aliyun.svideo.media.TemplateImportMediaAdapter.this.remove(this.val$position);
            com.aliyun.svideo.media.TemplateImportMediaAdapter.this.notifyDataSetChanged();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface OnItemViewCallback {
        void onDurationChange(long j);

        void onFinish(java.util.List<com.aliyun.svideo.media.MediaInfo> list);

        void onItemDeleteClick(com.aliyun.svideo.media.MediaInfo mediaInfo);

        void onItemPhotoClick(com.aliyun.svideo.media.MediaInfo mediaInfo, int i);
    }

    public static class TemplateImportViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public android.widget.ImageView ivCover;
        public android.widget.ImageView ivDelete;
        public android.view.View ivSelect;
        public android.widget.TextView tvDuration;
        public android.widget.TextView tvIndex;

        public TemplateImportViewHolder(android.view.View view) {
            super(view);
            this.ivCover = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.media.R.id.iv_cover);
            this.ivSelect = view.findViewById(com.aliyun.svideo.media.R.id.iv_select);
            this.tvDuration = (android.widget.TextView) view.findViewById(com.aliyun.svideo.media.R.id.tv_duration);
            this.ivDelete = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.media.R.id.iv_delete);
            this.tvIndex = (android.widget.TextView) view.findViewById(com.aliyun.svideo.media.R.id.iv_index);
        }
    }

    public TemplateImportMediaAdapter(com.aliyun.svideo.media.MediaImageLoader mediaImageLoader) {
        this.mImageLoader = mediaImageLoader;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mTemplateParams.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(com.aliyun.svideo.media.TemplateImportMediaAdapter.TemplateImportViewHolder templateImportViewHolder, @android.annotation.SuppressLint({"RecyclerView"}) int i) {
        float longValue = this.mTemplateParams.get(i).longValue() / 1000.0f;
        com.aliyun.svideo.media.MediaInfo mediaInfo = this.mDataMap.get(java.lang.Integer.valueOf(i));
        if (mediaInfo != null) {
            templateImportViewHolder.ivDelete.setVisibility(0);
            templateImportViewHolder.tvDuration.setVisibility(8);
            this.mImageLoader.displayImage(mediaInfo, templateImportViewHolder.ivCover);
        } else {
            java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#.##");
            templateImportViewHolder.tvDuration.setText(decimalFormat.format(longValue) + androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH);
            templateImportViewHolder.tvDuration.setVisibility(0);
            templateImportViewHolder.ivDelete.setVisibility(8);
            templateImportViewHolder.ivCover.setImageResource(com.aliyun.svideo.media.R.drawable.shape_rect_template_import_bg);
        }
        templateImportViewHolder.tvIndex.setText(java.lang.String.valueOf(i + 1));
        templateImportViewHolder.ivSelect.setVisibility(i == this.mSelectIndex ? 0 : 8);
        templateImportViewHolder.ivCover.setOnClickListener(new com.aliyun.svideo.media.TemplateImportMediaAdapter.AnonymousClass1(mediaInfo, i));
        templateImportViewHolder.ivDelete.setOnClickListener(new com.aliyun.svideo.media.TemplateImportMediaAdapter.AnonymousClass2(i, mediaInfo));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.aliyun.svideo.media.TemplateImportMediaAdapter.TemplateImportViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.media.TemplateImportMediaAdapter.TemplateImportViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.media.R.layout.alivc_media_item_video_template_import, viewGroup, false));
    }

    public void putData(com.aliyun.svideo.media.MediaInfo mediaInfo) {
        int i = this.mSelectIndex;
        if (i == -1) {
            return;
        }
        this.mDataMap.put(java.lang.Integer.valueOf(i), mediaInfo);
        int i2 = 0;
        while (true) {
            if (i2 >= this.mTemplateParams.size()) {
                i2 = -1;
                break;
            } else if (this.mDataMap.get(java.lang.Integer.valueOf(i2)) == null) {
                break;
            } else {
                i2++;
            }
        }
        this.mSelectIndex = i2;
        if (i2 != -1) {
            com.aliyun.svideo.media.TemplateImportMediaAdapter.OnItemViewCallback onItemViewCallback = this.mItemViewCallback;
            if (onItemViewCallback != null) {
                onItemViewCallback.onDurationChange(this.mTemplateParams.get(i2).longValue());
            }
        } else if (this.mItemViewCallback != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i3 = 0; i3 < this.mTemplateParams.size(); i3++) {
                arrayList.add(this.mDataMap.get(java.lang.Integer.valueOf(i3)));
            }
            this.mItemViewCallback.onDurationChange(-1L);
            this.mItemViewCallback.onFinish(arrayList);
        }
        notifyDataSetChanged();
    }

    public void remove(int i) {
        this.mDataMap.remove(java.lang.Integer.valueOf(i));
    }

    public void setItemViewCallback(com.aliyun.svideo.media.TemplateImportMediaAdapter.OnItemViewCallback onItemViewCallback) {
        this.mItemViewCallback = onItemViewCallback;
    }

    public void setTemplateParams(java.util.List<java.lang.Long> list) {
        this.mTemplateParams.clear();
        this.mTemplateParams.addAll(list);
    }
}
