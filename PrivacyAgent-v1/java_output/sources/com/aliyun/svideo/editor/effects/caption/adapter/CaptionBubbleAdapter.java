package com.aliyun.svideo.editor.effects.caption.adapter;

/* loaded from: classes12.dex */
public class CaptionBubbleAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private com.aliyun.svideo.downloader.FileDownloaderModel mFileDownloaderModel;
    private java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> mFontFromLocal;
    private int mGroupId;
    private com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener mOnCaptionChooserStateChangeListener;
    private java.util.List<com.aliyun.svideo.base.Form.PasterForm> mPasterFormList = new java.util.ArrayList();
    private int mCurrentSelectIndex = -1;
    private final com.aliyun.svideo.common.utils.image.ImageLoaderImpl imageLoader = new com.aliyun.svideo.common.utils.image.ImageLoaderImpl();

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ int val$finalPosition;

        /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00621 implements java.lang.Runnable {

            /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter$1$1$1, reason: invalid class name and collision with other inner class name */
            public class C00631 extends com.aliyun.svideo.downloader.FileDownloaderCallback {
                final /* synthetic */ java.lang.String val$finalFontPath;
                final /* synthetic */ int val$fontId;
                final /* synthetic */ com.aliyun.svideo.base.Form.PasterForm val$pasterInfo;

                public C00631(com.aliyun.svideo.base.Form.PasterForm pasterForm, java.lang.String str, int i) {
                    this.val$pasterInfo = pasterForm;
                    this.val$finalFontPath = str;
                    this.val$fontId = i;
                }

                @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
                public void onFinish(int i, java.lang.String str) {
                    super.onFinish(i, str);
                    com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source(str);
                    source.setId(java.lang.String.valueOf(this.val$pasterInfo.getId()));
                    source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getResUri(source.getPath().contains("aliyun_svideo_caption/") ? "app" : com.aliyun.svideo.editor.util.AlivcResUtil.HOST_CLOUD, com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_BUBBLE, java.lang.String.valueOf(com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.this.mGroupId), java.lang.String.valueOf(this.val$pasterInfo.getId())));
                    com.aliyun.svideosdk.common.struct.project.Source source2 = new com.aliyun.svideosdk.common.struct.project.Source(this.val$finalFontPath);
                    source2.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getCloudResUri("font", java.lang.String.valueOf(this.val$fontId)));
                    com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.this.callBack(source, source2);
                    com.aliyun.common.logger.Logger.getDefaultLogger().d("downloadId..." + i + "  bubblePath..." + str, new java.lang.Object[0]);
                }
            }

            public RunnableC00621() {
            }

            @Override // java.lang.Runnable
            public void run() {
                java.lang.String str;
                com.aliyun.svideo.base.Form.PasterForm pasterForm = (com.aliyun.svideo.base.Form.PasterForm) com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.this.mPasterFormList.get(com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.AnonymousClass1.this.val$finalPosition);
                int fontId = pasterForm.getFontId();
                if (com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.this.mFontFromLocal == null) {
                    com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.this.mFontFromLocal = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getFontFromLocal();
                }
                if (com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.this.mFontFromLocal.size() > 0) {
                    for (com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel : com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.this.mFontFromLocal) {
                        if (fileDownloaderModel.getId() == fontId) {
                            str = fileDownloaderModel.getPath();
                            break;
                        }
                    }
                }
                str = null;
                java.lang.String pathByUrl = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getPathByUrl(pasterForm.getDownloadUrl());
                if (pathByUrl == null || pathByUrl.isEmpty()) {
                    com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.downloadPaster(com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.this.mFileDownloaderModel, new com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.AnonymousClass1.RunnableC00621.C00631(pasterForm, str, fontId));
                    return;
                }
                com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source(pathByUrl);
                source.setId(java.lang.String.valueOf(pasterForm.getId()));
                source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getResUri(source.getPath().contains("aliyun_svideo_caption/") ? "app" : com.aliyun.svideo.editor.util.AlivcResUtil.HOST_CLOUD, com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_BUBBLE, java.lang.String.valueOf(com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.this.mGroupId), java.lang.String.valueOf(pasterForm.getId())));
                com.aliyun.svideosdk.common.struct.project.Source source2 = new com.aliyun.svideosdk.common.struct.project.Source(str);
                source2.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getCloudResUri("font", java.lang.String.valueOf(fontId)));
                com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.this.callBack(source, source2);
            }
        }

        public AnonymousClass1(int i) {
            this.val$finalPosition = i;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.this.notifySelectedView(this.val$finalPosition)) {
                com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.AnonymousClass1.RunnableC00621());
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.Source val$bubbleSource;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.project.Source val$fontSource;

        public AnonymousClass2(com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.common.struct.project.Source source2) {
            this.val$bubbleSource = source;
            this.val$fontSource = source2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.this.mOnCaptionChooserStateChangeListener != null) {
                com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.this.mOnCaptionChooserStateChangeListener.onBubbleEffectTemplateChanged(this.val$bubbleSource, this.val$fontSource);
            }
        }
    }

    public static class CaptionViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.widget.ImageView mImage;
        android.view.View selectedview;

        public CaptionViewHolder(android.view.View view) {
            super(view);
            this.mImage = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.resource_image_view);
            this.selectedview = view.findViewById(com.aliyun.svideo.editor.R.id.selected_view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBack(com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.common.struct.project.Source source2) {
        com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.AnonymousClass2(source, source2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifySelectedView(int i) {
        int i2 = this.mCurrentSelectIndex;
        if (i == i2) {
            return false;
        }
        this.mCurrentSelectIndex = i;
        notifyItemChanged(i2);
        notifyItemChanged(this.mCurrentSelectIndex);
        return true;
    }

    public void clearSelectedView() {
        int i = this.mCurrentSelectIndex;
        if (i > -1) {
            notifyItemChanged(i);
            this.mCurrentSelectIndex = -1;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        java.util.List<com.aliyun.svideo.base.Form.PasterForm> list = this.mPasterFormList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.CaptionViewHolder captionViewHolder = (com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.CaptionViewHolder) viewHolder;
        int adapterPosition = captionViewHolder.getAdapterPosition();
        this.imageLoader.loadImage(captionViewHolder.mImage.getContext().getApplicationContext(), this.mPasterFormList.get(adapterPosition).getIcon()).into(captionViewHolder.mImage);
        if (adapterPosition == this.mCurrentSelectIndex) {
            captionViewHolder.selectedview.setVisibility(0);
        } else {
            captionViewHolder.selectedview.setVisibility(8);
        }
        captionViewHolder.itemView.setOnClickListener(new com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.AnonymousClass1(adapterPosition));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter.CaptionViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_bubble_item_paster, viewGroup, false));
    }

    public void setData(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel, java.util.List<com.aliyun.svideo.base.Form.PasterForm> list, int i) {
        if (list == null) {
            return;
        }
        this.mFileDownloaderModel = fileDownloaderModel;
        this.mCurrentSelectIndex = -1;
        this.mGroupId = i;
        this.mPasterFormList.clear();
        this.mPasterFormList.addAll(list);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        this.mOnCaptionChooserStateChangeListener = onCaptionChooserStateChangeListener;
    }

    public void setSelectPosition(int i) {
        java.util.List<com.aliyun.svideo.base.Form.PasterForm> list = this.mPasterFormList;
        if (list == null || list.size() <= i) {
            return;
        }
        notifySelectedView(i);
    }
}
