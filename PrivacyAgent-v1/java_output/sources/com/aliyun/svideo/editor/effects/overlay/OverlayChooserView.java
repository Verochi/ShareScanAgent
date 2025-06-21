package com.aliyun.svideo.editor.effects.overlay;

import com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.PageAdapter;

/* loaded from: classes12.dex */
public class OverlayChooserView extends com.aliyun.svideo.editor.effects.control.BaseChooser {
    private com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.PageAdapter mAdapter;
    private com.aliyun.svideo.editor.effects.CategoryAdapter mCategoryAdapter;
    private androidx.recyclerview.widget.RecyclerView mCategoryList;
    private android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel>> mLoadTask;
    private java.util.List<com.aliyun.svideo.base.Form.PasterForm> mPageDataList;
    private com.aliyun.svideo.editor.effects.overlay.AbstractPageListCallback mPageListCallback;
    private java.util.ArrayList<com.aliyun.svideo.base.Form.ResourceForm> mPasterList;

    /* renamed from: com.aliyun.svideo.editor.effects.overlay.OverlayChooserView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.effects.control.OnItemClickListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.effects.control.OnItemClickListener
        public boolean onItemClick(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo, int i) {
            if (!effectInfo.isCategory) {
                return true;
            }
            com.aliyun.svideo.base.Form.ResourceForm resourceForm = (com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this.mPasterList.get(i);
            ((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this).mCurrID = resourceForm.getId();
            com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this.mPageListCallback.setData(resourceForm);
            com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this.mPageDataList.clear();
            com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this.mPageDataList.addAll(resourceForm.getPasterList());
            com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this.mAdapter.realNotifyDataSetChanged();
            com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this.mPageListCallback.resetSelected();
            return true;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.overlay.OverlayChooserView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.editor.effects.CategoryAdapter.OnMoreClickListener {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.editor.effects.CategoryAdapter.OnMoreClickListener
        public void onMoreClick() {
            ((android.app.Activity) com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this.getContext()).startActivityForResult(new android.content.Intent(com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this.getContext(), (java.lang.Class<?>) com.aliyun.svideo.editor.effectmanager.MorePasterActivity.class), 1003);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.overlay.OverlayChooserView$3, reason: invalid class name */
    public class AnonymousClass3 extends com.aliyun.svideo.editor.effects.overlay.AbstractPageListCallback {
        public AnonymousClass3(android.content.Context context) {
            super(context);
        }

        @Override // com.aliyun.svideo.editor.effects.overlay.AbstractPageListCallback
        public void notifySelected(int i, int i2) {
            com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this.mAdapter.realNotifyItemChanged(i);
            if (i2 >= 0) {
                com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this.mAdapter.realNotifyItemChanged(i2);
            }
            com.aliyun.svideo.base.Form.PasterForm selectedItem = com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this.mPageListCallback.getSelectedItem();
            com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
            effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.OVERLAY;
            effectInfo.setPath(selectedItem.getPath());
            com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source(selectedItem.getPath());
            source.setId(java.lang.String.valueOf(selectedItem.getId()));
            source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getResUri(source.getPath().contains("aliyun_svideo_overlay/") ? "app" : com.aliyun.svideo.editor.util.AlivcResUtil.HOST_CLOUD, com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_STICKER, java.lang.String.valueOf(com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this.mPageListCallback.getGroupId()), source.getId()));
            effectInfo.setSource(source);
            com.aliyun.svideo.editor.effects.control.OnEffectChangeListener onEffectChangeListener = com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this.mOnEffectChangeListener;
            if (onEffectChangeListener != null) {
                onEffectChangeListener.onEffectChange(effectInfo);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.overlay.OverlayChooserView$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this.dealCancel();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.overlay.OverlayChooserView$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this).mOnEffectActionLister != null) {
                ((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this).mOnEffectActionLister.onComplete();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class MyLoadAsyncTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel>> {
        private MyLoadAsyncTask() {
        }

        public /* synthetic */ MyLoadAsyncTask(com.aliyun.svideo.editor.effects.overlay.OverlayChooserView overlayChooserView, defpackage.kw1 kw1Var) {
            this();
        }

        @Override // android.os.AsyncTask
        public java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> doInBackground(java.lang.Void... voidArr) {
            return com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(2);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list) {
            super.onPostExecute((com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.MyLoadAsyncTask) list);
            com.aliyun.svideo.editor.effects.overlay.OverlayChooserView overlayChooserView = com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.this;
            overlayChooserView.initResourceLocalWithSelectId(((com.aliyun.svideo.editor.effects.control.BaseChooser) overlayChooserView).mCurrID, list);
        }
    }

    public OverlayChooserView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public OverlayChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrID = -1;
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
        pasterForm.setPath(fileDownloaderModel.getPath());
        return pasterForm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealCancel() {
        com.aliyun.svideo.editor.effects.control.OnEffectActionLister onEffectActionLister = this.mOnEffectActionLister;
        if (onEffectActionLister != null) {
            onEffectActionLister.onCancel();
        }
    }

    private void initTitleView(android.view.View view) {
        android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_effect_icon);
        android.widget.TextView textView = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_effect_title);
        imageView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_overlay);
        textView.setText(com.aliyun.svideo.editor.R.string.alivc_editor_effect_sticker);
        view.findViewById(com.aliyun.svideo.editor.R.id.iv_cancel).setOnClickListener(new com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.AnonymousClass4());
        view.findViewById(com.aliyun.svideo.editor.R.id.iv_confirm).setOnClickListener(new com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.AnonymousClass5());
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public android.widget.FrameLayout getThumbContainer() {
        return (android.widget.FrameLayout) findViewById(com.aliyun.svideo.editor.R.id.fl_thumblinebar);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public com.aliyun.svideo.editor.effects.control.UIEditorPage getUIEditorPage() {
        return com.aliyun.svideo.editor.effects.control.UIEditorPage.OVERLAY;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void init() {
        android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_overlay, this);
        initTitleView(inflate);
        this.mPasterList = new java.util.ArrayList<>();
        this.mPageDataList = new java.util.ArrayList();
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) inflate.findViewById(com.aliyun.svideo.editor.R.id.category_list);
        this.mCategoryList = recyclerView;
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        com.aliyun.svideo.editor.effects.CategoryAdapter categoryAdapter = new com.aliyun.svideo.editor.effects.CategoryAdapter(getContext());
        this.mCategoryAdapter = categoryAdapter;
        this.mCategoryList.setAdapter(categoryAdapter);
        this.mCategoryAdapter.setData(this.mPasterList);
        this.mCategoryAdapter.setOnItemClickListener(new com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.AnonymousClass1());
        this.mCategoryAdapter.setMoreClickListener(new com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.AnonymousClass2());
        com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView pageRecyclerView = (com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView) inflate.findViewById(com.aliyun.svideo.editor.R.id.effect_overlay_view);
        pageRecyclerView.setPageSize(1, 5);
        pageRecyclerView.setPageMargin(30);
        pageRecyclerView.setAutoScrollPage(false);
        com.aliyun.svideo.base.widget.pagerecyclerview.PageIndicatorView pageIndicatorView = (com.aliyun.svideo.base.widget.pagerecyclerview.PageIndicatorView) inflate.findViewById(com.aliyun.svideo.editor.R.id.view_indicator);
        com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.AnonymousClass3 anonymousClass3 = new com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.AnonymousClass3(getContext());
        this.mPageListCallback = anonymousClass3;
        this.mAdapter = pageRecyclerView.new PageAdapter(this.mPageDataList, anonymousClass3);
        pageRecyclerView.setIndicator(pageIndicatorView);
        this.mAdapter.setHasStableIds(true);
        pageRecyclerView.setAdapter(this.mAdapter);
        loadLocalPaster();
    }

    public void initResourceLocalWithSelectId(int i, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list) {
        this.mPasterList.clear();
        this.mPageListCallback.resetSelected();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList<com.aliyun.svideo.downloader.FileDownloaderModel> arrayList3 = new java.util.ArrayList();
        if (list != null && list.size() > 0) {
            for (com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel : list) {
                if (new java.io.File(fileDownloaderModel.getPath()).exists()) {
                    arrayList3.add(fileDownloaderModel);
                }
            }
            com.aliyun.svideo.base.Form.ResourceForm resourceForm = null;
            java.util.ArrayList arrayList4 = null;
            for (com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel2 : arrayList3) {
                if (!arrayList2.contains(java.lang.Integer.valueOf(fileDownloaderModel2.getId()))) {
                    if (resourceForm != null) {
                        resourceForm.setPasterList(arrayList4);
                        arrayList.add(resourceForm);
                    }
                    arrayList2.add(java.lang.Integer.valueOf(fileDownloaderModel2.getId()));
                    resourceForm = new com.aliyun.svideo.base.Form.ResourceForm();
                    arrayList4 = new java.util.ArrayList();
                    resourceForm.setPreviewUrl(fileDownloaderModel2.getPreview());
                    resourceForm.setIcon(fileDownloaderModel2.getIcon());
                    resourceForm.setLevel(fileDownloaderModel2.getLevel());
                    resourceForm.setName(fileDownloaderModel2.getName());
                    resourceForm.setNameEn(fileDownloaderModel2.getNameEn());
                    resourceForm.setId(fileDownloaderModel2.getId());
                    resourceForm.setDescription(fileDownloaderModel2.getDescription());
                    resourceForm.setSort(fileDownloaderModel2.getSort());
                    resourceForm.setIsNew(fileDownloaderModel2.getIsnew());
                }
                arrayList4.add(addPasterForm(fileDownloaderModel2));
            }
            if (resourceForm != null) {
                resourceForm.setPasterList(arrayList4);
                arrayList.add(resourceForm);
            }
        }
        this.mPasterList.addAll(arrayList);
        com.aliyun.svideo.base.Form.ResourceForm resourceForm2 = new com.aliyun.svideo.base.Form.ResourceForm();
        resourceForm2.setMore(true);
        this.mPasterList.add(resourceForm2);
        this.mCategoryAdapter.setData(this.mPasterList);
        if (arrayList2.size() > 0 && (i == -1 || i == 0 || !arrayList2.contains(java.lang.Integer.valueOf(i)))) {
            i = ((java.lang.Integer) arrayList2.get(0)).intValue();
        }
        java.util.Iterator<com.aliyun.svideo.base.Form.ResourceForm> it = this.mPasterList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.aliyun.svideo.base.Form.ResourceForm next = it.next();
            if (next.getId() == i) {
                this.mPageDataList.clear();
                if (next.getPasterList() != null) {
                    this.mPageDataList.addAll(next.getPasterList());
                }
                this.mPageListCallback.setData(next);
                this.mAdapter.realNotifyDataSetChanged();
            } else {
                i2++;
            }
        }
        this.mCategoryList.smoothScrollToPosition(i2);
        this.mCategoryAdapter.selectPosition(i2);
        if (this.mCurrID == -1) {
            loadLocalPaster();
            this.mCurrID = 0;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("categoryIndex :");
        sb.append(i2);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isHostPaster(com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController) {
        return aliyunBasePasterController != null && aliyunBasePasterController.getEditorPage() == com.aliyun.svideo.editor.effects.control.UIEditorPage.OVERLAY;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isPlayerNeedZoom() {
        return true;
    }

    public void loadLocalPaster() {
        com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.MyLoadAsyncTask myLoadAsyncTask = new com.aliyun.svideo.editor.effects.overlay.OverlayChooserView.MyLoadAsyncTask(this, null);
        this.mLoadTask = myLoadAsyncTask;
        myLoadAsyncTask.execute(new java.lang.Void[0]);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void onBackPressed() {
        super.onBackPressed();
        dealCancel();
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void onRemove() {
        super.onRemove();
        android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel>> asyncTask = this.mLoadTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
    }

    public void setCurrResourceID(int i) {
        if (i != -1) {
            this.mCurrID = i;
        }
        loadLocalPaster();
    }
}
