package com.aliyun.svideo.editor.effects.caption.adapter.holder;

/* loaded from: classes12.dex */
public class CaptionBubblePanelViewHolder extends com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder {
    private int currentCaptionControlId;
    private com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter mCaptionAdapter;
    private androidx.recyclerview.widget.RecyclerView mCaptionList;
    private com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter mCategoryAdapter;
    private java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> mCategoryData;
    private androidx.recyclerview.widget.RecyclerView mCategoryList;
    protected int mCurrID;
    private java.util.Map<java.lang.Integer, java.util.List<com.aliyun.svideo.base.Form.PasterForm>> mPastersMap;
    private final com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.OnItemClickListener onItemClickListener;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int val$captionControllerId;

        /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00641 implements java.lang.Runnable {
            final /* synthetic */ int val$currentIndex;

            public RunnableC00641(int i) {
                this.val$currentIndex = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.this.mCaptionAdapter.setSelectPosition(this.val$currentIndex);
            }
        }

        public AnonymousClass1(int i) {
            this.val$captionControllerId = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.this.currentCaptionControlId != this.val$captionControllerId) {
                int currentIndex = com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.this.getCurrentIndex();
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.this.currentCaptionControlId = this.val$captionControllerId;
                com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.AnonymousClass1.RunnableC00641(currentIndex));
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {

        /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.util.List val$bubbleFromLocal;

            public AnonymousClass1(java.util.List list) {
                this.val$bubbleFromLocal = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.this.initResourceLocalWithSelectId(this.val$bubbleFromLocal);
            }
        }

        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.AnonymousClass2.AnonymousClass1(com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getBubbleFromLocal()));
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.OnItemClickListener {
        public AnonymousClass3() {
        }

        @Override // com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.OnItemClickListener
        public void onItemClick(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel) {
            if (fileDownloaderModel == null) {
                if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.this.getCaptionChooserStateChangeListener() != null) {
                    com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.this.getCaptionChooserStateChangeListener().onBubbleEffectTemplateChanged(null, null);
                }
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.this.mCaptionAdapter.clearSelectedView();
            } else {
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.this.mCurrID = fileDownloaderModel.getId();
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.this.mCaptionAdapter.setData(fileDownloaderModel, (java.util.List) com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.this.mPastersMap.get(java.lang.Integer.valueOf(com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.this.mCurrID)), com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.this.mCurrID);
            }
        }

        @Override // com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter.OnItemClickListener
        public void onMoreClick() {
            ((android.app.Activity) com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.this.getContext()).startActivityForResult(new android.content.Intent(com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.this.getContext(), (java.lang.Class<?>) com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.class), 1001);
        }
    }

    public CaptionBubblePanelViewHolder(android.content.Context context, java.lang.String str, com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        super(context, str, onCaptionChooserStateChangeListener);
        this.mCategoryData = new java.util.ArrayList();
        this.mPastersMap = new java.util.HashMap();
        this.mCurrID = 0;
        this.onItemClickListener = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.AnonymousClass3();
    }

    private com.aliyun.svideo.base.Form.PasterForm addPasterForm(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel) {
        com.aliyun.svideo.base.Form.PasterForm pasterForm = new com.aliyun.svideo.base.Form.PasterForm();
        pasterForm.setPreviewUrl(fileDownloaderModel.getSubpreview());
        pasterForm.setSort(fileDownloaderModel.getSubsort());
        pasterForm.setId(fileDownloaderModel.getSubid());
        pasterForm.setFontId(fileDownloaderModel.getFontid());
        pasterForm.setMD5(fileDownloaderModel.getMd5());
        pasterForm.setType(fileDownloaderModel.getSubtype());
        pasterForm.setIcon(fileDownloaderModel.getSubicon());
        pasterForm.setDownloadUrl(fileDownloaderModel.getUrl());
        pasterForm.setName(fileDownloaderModel.getSubname());
        return pasterForm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentIndex() {
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterController;
        java.util.List<com.aliyun.svideo.base.Form.PasterForm> list;
        com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener captionChooserStateChangeListener = getCaptionChooserStateChangeListener();
        if (captionChooserStateChangeListener != null && this.mPastersMap != null && (aliyunPasterController = captionChooserStateChangeListener.getAliyunPasterController()) != null) {
            java.lang.String bubbleEffectTemplate = aliyunPasterController.getBubbleEffectTemplate();
            if (!android.text.TextUtils.isEmpty(bubbleEffectTemplate) && (list = this.mPastersMap.get(java.lang.Integer.valueOf(this.mCurrID))) != null) {
                for (int i = 0; i < list.size(); i++) {
                    com.aliyun.svideo.base.Form.PasterForm pasterForm = list.get(i);
                    if (pasterForm != null && bubbleEffectTemplate.equals(pasterForm.getDownloadUrl())) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    private void lazyInit() {
        android.view.View itemView = getItemView();
        if (itemView == null || this.mCategoryAdapter != null) {
            notifyDataSetChanged();
            return;
        }
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) itemView.findViewById(com.aliyun.svideo.editor.R.id.effect_list);
        this.mCaptionList = recyclerView;
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager(getContext(), 4, 1, false));
        com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter captionBubbleAdapter = new com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleAdapter();
        this.mCaptionAdapter = captionBubbleAdapter;
        captionBubbleAdapter.setOnItemClickListener(getCaptionChooserStateChangeListener());
        this.mCaptionList.setAdapter(this.mCaptionAdapter);
        androidx.recyclerview.widget.RecyclerView recyclerView2 = (androidx.recyclerview.widget.RecyclerView) itemView.findViewById(com.aliyun.svideo.editor.R.id.category_list);
        this.mCategoryList = recyclerView2;
        recyclerView2.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter captionBubbleCategoryAdapter = new com.aliyun.svideo.editor.effects.caption.adapter.CaptionBubbleCategoryAdapter();
        this.mCategoryAdapter = captionBubbleCategoryAdapter;
        this.mCategoryList.setAdapter(captionBubbleCategoryAdapter);
        this.mCategoryAdapter.setOnItemClickListener(this.onItemClickListener);
        this.currentCaptionControlId = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(getCaptionChooserStateChangeListener());
        loadLocalPaster();
    }

    private void loadLocalPaster() {
        com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.AnonymousClass2());
    }

    public void initResourceLocalWithSelectId(java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list) {
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel;
        this.mCategoryData.clear();
        this.mPastersMap.clear();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list != null && list.size() > 0) {
            for (com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel2 : list) {
                if (fileDownloaderModel2 != null && new java.io.File(fileDownloaderModel2.getPath()).exists()) {
                    int id = fileDownloaderModel2.getId();
                    if (!arrayList.contains(java.lang.Integer.valueOf(id))) {
                        arrayList.add(java.lang.Integer.valueOf(id));
                        this.mCategoryData.add(fileDownloaderModel2);
                    }
                    java.util.List<com.aliyun.svideo.base.Form.PasterForm> list2 = this.mPastersMap.get(java.lang.Integer.valueOf(id));
                    if (list2 == null) {
                        list2 = new java.util.ArrayList<>();
                        this.mPastersMap.put(java.lang.Integer.valueOf(id), list2);
                    }
                    list2.add(addPasterForm(fileDownloaderModel2));
                }
            }
        }
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel3 = new com.aliyun.svideo.downloader.FileDownloaderModel();
        fileDownloaderModel3.setCategory(-1);
        this.mCategoryData.add(null);
        this.mCategoryData.add(fileDownloaderModel3);
        this.mCategoryAdapter.setData(this.mCategoryData);
        if (this.mCategoryData.size() <= 0 || (fileDownloaderModel = this.mCategoryData.get(0)) == null) {
            return;
        }
        this.mCurrID = fileDownloaderModel.getId();
        this.mCategoryList.smoothScrollToPosition(0);
        this.mCategoryAdapter.setData(this.mCategoryData);
        if (this.mPastersMap.size() > 0) {
            this.mCaptionAdapter.setData(fileDownloaderModel, this.mPastersMap.get(java.lang.Integer.valueOf(this.mCurrID)), this.mCurrID);
        }
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void notifyDataSetChanged() {
        if (this.mCaptionAdapter != null) {
            com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBubblePanelViewHolder.AnonymousClass1(com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(getCaptionChooserStateChangeListener())));
        }
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onBindViewHolder() {
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public android.view.View onCreateView(android.content.Context context) {
        return android.view.LayoutInflater.from(context).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_bubble_container, (android.view.ViewGroup) null, false);
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
