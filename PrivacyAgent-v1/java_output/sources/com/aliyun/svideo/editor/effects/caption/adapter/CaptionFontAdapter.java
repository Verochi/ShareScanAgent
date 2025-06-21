package com.aliyun.svideo.editor.effects.caption.adapter;

/* loaded from: classes12.dex */
public class CaptionFontAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener mOnCaptionColorItemClickListener;
    private java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> mFontData = new java.util.ArrayList();
    private int mSelectPosition = -1;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter$1, reason: invalid class name */
    public class AnonymousClass1 extends com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget<android.graphics.drawable.Drawable> {
        final /* synthetic */ com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter.CaptionViewHolder val$captionViewHolder;

        public AnonymousClass1(com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter.CaptionViewHolder captionViewHolder) {
            this.val$captionViewHolder = captionViewHolder;
        }

        @Override // com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget
        public void onResourceReady(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
            this.val$captionViewHolder.mImage.setImageDrawable(drawable);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        final /* synthetic */ int val$finalPosition;

        /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter$2$1, reason: invalid class name */
        public class AnonymousClass1 extends com.aliyun.svideo.downloader.FileDownloaderCallback {
            final /* synthetic */ com.aliyun.svideo.downloader.FileDownloaderModel val$form;

            public AnonymousClass1(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel) {
                this.val$form = fileDownloaderModel;
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onFinish(int i, java.lang.String str) {
                super.onFinish(i, str);
                com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source(str);
                source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getCloudResUri("font", java.lang.String.valueOf(this.val$form.getId())));
                com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter.this.callBack(source);
            }
        }

        public AnonymousClass2(int i) {
            this.val$finalPosition = i;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter.this.notifySelectedView(this.val$finalPosition)) {
                com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = (com.aliyun.svideo.downloader.FileDownloaderModel) com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter.this.mFontData.get(this.val$finalPosition);
                if ("system_font".equals(fileDownloaderModel.getIcon())) {
                    com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter.this.callBack(new com.aliyun.svideosdk.common.struct.project.Source("system_font"));
                } else {
                    java.lang.String pathByUrl = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getPathByUrl(fileDownloaderModel.getUrl());
                    if (pathByUrl == null || pathByUrl.isEmpty()) {
                        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.downloadFont(fileDownloaderModel, new com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter.AnonymousClass2.AnonymousClass1(fileDownloaderModel));
                    } else {
                        com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source(pathByUrl);
                        source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getCloudResUri("font", java.lang.String.valueOf(fileDownloaderModel.getId())));
                        com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter.this.callBack(source);
                    }
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class CaptionViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        com.aliyun.svideo.base.widget.CircularImageView mImage;
        android.view.View selectedview;

        public CaptionViewHolder(android.view.View view) {
            super(view);
            this.mImage = (com.aliyun.svideo.base.widget.CircularImageView) view.findViewById(com.aliyun.svideo.editor.R.id.resource_image_view);
            this.selectedview = view.findViewById(com.aliyun.svideo.editor.R.id.selected_view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBack(com.aliyun.svideosdk.common.struct.project.Source source) {
        com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener = this.mOnCaptionColorItemClickListener;
        if (onCaptionChooserStateChangeListener != null) {
            onCaptionChooserStateChangeListener.onCaptionTextFontTtfChanged(source);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifySelectedView(int i) {
        int i2 = this.mSelectPosition;
        if (i == i2) {
            return false;
        }
        this.mSelectPosition = i;
        notifyItemChanged(i2);
        notifyItemChanged(this.mSelectPosition);
        return true;
    }

    public java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> getFontData() {
        return this.mFontData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list = this.mFontData;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == this.mSelectPosition ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter.CaptionViewHolder captionViewHolder = (com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter.CaptionViewHolder) viewHolder;
        int adapterPosition = captionViewHolder.getAdapterPosition();
        int itemViewType = captionViewHolder.getItemViewType();
        if (itemViewType == 1) {
            captionViewHolder.selectedview.setVisibility(0);
        } else if (itemViewType == 2) {
            captionViewHolder.selectedview.setVisibility(8);
        }
        java.lang.String icon = this.mFontData.get(adapterPosition).getIcon();
        if ("system_font".equals(icon)) {
            captionViewHolder.mImage.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_system_font_icon);
        } else {
            new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(captionViewHolder.mImage.getContext(), icon).into(captionViewHolder.mImage, new com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter.AnonymousClass1(captionViewHolder));
        }
        captionViewHolder.itemView.setOnClickListener(new com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter.AnonymousClass2(adapterPosition));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter.CaptionViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_font_item_paster, viewGroup, false));
    }

    public void setData(java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list) {
        if (list == null) {
            return;
        }
        this.mFontData.clear();
        this.mFontData.addAll(list);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        this.mOnCaptionColorItemClickListener = onCaptionChooserStateChangeListener;
    }

    public void setmCurrectSelectIndex(int i) {
        notifySelectedView(i);
    }

    public void showFontData() {
        this.mFontData.clear();
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getFontFromLocal();
        notifyDataSetChanged();
    }
}
