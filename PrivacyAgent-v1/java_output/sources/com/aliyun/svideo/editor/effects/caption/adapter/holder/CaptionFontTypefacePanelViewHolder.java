package com.aliyun.svideo.editor.effects.caption.adapter.holder;

/* loaded from: classes12.dex */
public class CaptionFontTypefacePanelViewHolder extends com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder {
    private int currentCaptionControlId;
    private com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter mCaptionAdapter;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {

        /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00671 implements java.lang.Runnable {
            final /* synthetic */ int val$currentIndex;

            public RunnableC00671(int i) {
                this.val$currentIndex = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder.this.mCaptionAdapter.setmCurrectSelectIndex(this.val$currentIndex);
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int captionControllerId = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder.this.getCaptionChooserStateChangeListener());
            if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder.this.currentCaptionControlId != captionControllerId) {
                int currentIndex = com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder.this.getCurrentIndex();
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder.this.currentCaptionControlId = captionControllerId;
                com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder.AnonymousClass1.RunnableC00671(currentIndex));
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {

        /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.util.List val$fontFromLocal;

            public AnonymousClass1(java.util.List list) {
                this.val$fontFromLocal = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder.this.mCaptionAdapter != null) {
                    com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder.this.mCaptionAdapter.setData(this.val$fontFromLocal);
                }
            }
        }

        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder.AnonymousClass2.AnonymousClass1(com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getFontFromLocal()));
        }
    }

    public CaptionFontTypefacePanelViewHolder(android.content.Context context, java.lang.String str, com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        super(context, str, onCaptionChooserStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentIndex() {
        com.aliyun.svideosdk.common.ISource fontPath;
        java.lang.String path;
        java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> fontData;
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption captionController = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionController(getCaptionChooserStateChangeListener());
        if (captionController == null || this.mCaptionAdapter == null || (fontPath = captionController.getFontPath()) == null || (path = fontPath.getPath()) == null || (fontData = this.mCaptionAdapter.getFontData()) == null) {
            return 0;
        }
        for (int i = 0; i < fontData.size(); i++) {
            com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = fontData.get(i);
            if (fileDownloaderModel != null) {
                if (path.equals(fileDownloaderModel.getPath() + com.aliyun.svideo.editor.contant.CaptionConfig.FONT_NAME)) {
                    return i;
                }
            }
        }
        return 0;
    }

    private void lazyInit() {
        android.view.View itemView = getItemView();
        if (itemView == null || this.mCaptionAdapter != null) {
            notifyDataSetChanged();
            return;
        }
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) itemView.findViewById(com.aliyun.svideo.editor.R.id.effect_list);
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager(getContext(), 4, 1, false));
        com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter captionFontAdapter = new com.aliyun.svideo.editor.effects.caption.adapter.CaptionFontAdapter();
        this.mCaptionAdapter = captionFontAdapter;
        captionFontAdapter.setOnItemClickListener(getCaptionChooserStateChangeListener());
        recyclerView.setAdapter(this.mCaptionAdapter);
        this.currentCaptionControlId = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(getCaptionChooserStateChangeListener());
        loadLocalPaster();
    }

    private void loadLocalPaster() {
        com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder.AnonymousClass2());
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void notifyDataSetChanged() {
        if (this.mCaptionAdapter != null) {
            com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontTypefacePanelViewHolder.AnonymousClass1());
        }
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onBindViewHolder() {
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public android.view.View onCreateView(android.content.Context context) {
        return android.view.LayoutInflater.from(context).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_style_font_container, (android.view.ViewGroup) null, false);
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onTabClick() {
        lazyInit();
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void resourceChanged() {
        if (this.mCaptionAdapter != null) {
            loadLocalPaster();
        }
    }
}
