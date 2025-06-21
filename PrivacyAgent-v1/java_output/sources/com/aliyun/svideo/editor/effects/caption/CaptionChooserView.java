package com.aliyun.svideo.editor.effects.caption;

/* loaded from: classes12.dex */
public class CaptionChooserView extends com.aliyun.svideo.editor.effects.control.BaseChooser {
    private static final int CAPTION_TYPE = 6;
    private com.aliyun.svideo.editor.effects.caption.CaptionAdapter mCaptionAdapter;
    private java.util.ArrayList<com.aliyun.svideo.base.Form.ResourceForm> mCaptionData;
    private com.aliyun.svideo.editor.effects.CategoryAdapter mCategoryAdapter;
    private androidx.recyclerview.widget.RecyclerView mCategoryList;
    private android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel>> mLoadTask;
    private com.aliyun.svideo.editor.effects.control.OnItemClickListener mOnItemClickListener;
    private com.aliyun.svideo.editor.effects.CategoryAdapter.OnMoreClickListener mOnMoreClickListener;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.CaptionChooserView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.caption.CaptionChooserView.this.dealCancel();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.CaptionChooserView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.caption.CaptionChooserView.this).mOnEffectActionLister != null) {
                ((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.caption.CaptionChooserView.this).mOnEffectActionLister.onComplete();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.CaptionChooserView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideo.editor.effects.CategoryAdapter.OnMoreClickListener {
        public AnonymousClass3() {
        }

        @Override // com.aliyun.svideo.editor.effects.CategoryAdapter.OnMoreClickListener
        public void onMoreClick() {
            ((android.app.Activity) com.aliyun.svideo.editor.effects.caption.CaptionChooserView.this.getContext()).startActivityForResult(new android.content.Intent(com.aliyun.svideo.editor.effects.caption.CaptionChooserView.this.getContext(), (java.lang.Class<?>) com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.class), 1001);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.CaptionChooserView$4, reason: invalid class name */
    public class AnonymousClass4 implements com.aliyun.svideo.editor.effects.control.OnItemClickListener {
        public AnonymousClass4() {
        }

        @Override // com.aliyun.svideo.editor.effects.control.OnItemClickListener
        public boolean onItemClick(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo, int i) {
            if (!effectInfo.isCategory) {
                com.aliyun.svideo.editor.effects.control.OnEffectChangeListener onEffectChangeListener = com.aliyun.svideo.editor.effects.caption.CaptionChooserView.this.mOnEffectChangeListener;
                if (onEffectChangeListener == null) {
                    return true;
                }
                onEffectChangeListener.onEffectChange(effectInfo);
                return true;
            }
            if (i == 0) {
                com.aliyun.svideo.editor.effects.caption.CaptionChooserView.this.mCaptionAdapter.showFontData();
                ((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.caption.CaptionChooserView.this).mCurrID = 0;
                return true;
            }
            com.aliyun.svideo.base.Form.ResourceForm resourceForm = (com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effects.caption.CaptionChooserView.this.mCaptionData.get(i);
            ((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.caption.CaptionChooserView.this).mCurrID = resourceForm.getId();
            com.aliyun.svideo.editor.effects.caption.CaptionChooserView.this.mCaptionAdapter.setData(resourceForm);
            return true;
        }
    }

    public class MyLoadAsyncTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel>> {
        private MyLoadAsyncTask() {
        }

        public /* synthetic */ MyLoadAsyncTask(com.aliyun.svideo.editor.effects.caption.CaptionChooserView captionChooserView, defpackage.jk jkVar) {
            this();
        }

        @Override // android.os.AsyncTask
        public java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> doInBackground(java.lang.Void... voidArr) {
            return com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(6);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list) {
            super.onPostExecute((com.aliyun.svideo.editor.effects.caption.CaptionChooserView.MyLoadAsyncTask) list);
            com.aliyun.svideo.editor.effects.caption.CaptionChooserView captionChooserView = com.aliyun.svideo.editor.effects.caption.CaptionChooserView.this;
            captionChooserView.initResourceLocalWithSelectId(((com.aliyun.svideo.editor.effects.control.BaseChooser) captionChooserView).mCurrID, list);
        }
    }

    public CaptionChooserView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public CaptionChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaptionChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
    public void dealCancel() {
        com.aliyun.svideo.editor.effects.control.OnEffectActionLister onEffectActionLister = this.mOnEffectActionLister;
        if (onEffectActionLister != null) {
            onEffectActionLister.onCancel();
        }
    }

    private void initListener() {
        this.mOnMoreClickListener = new com.aliyun.svideo.editor.effects.caption.CaptionChooserView.AnonymousClass3();
        this.mOnItemClickListener = new com.aliyun.svideo.editor.effects.caption.CaptionChooserView.AnonymousClass4();
    }

    private void initTitleView(android.view.View view) {
        android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_effect_icon);
        android.widget.TextView textView = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_effect_title);
        imageView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_caption);
        textView.setText(com.aliyun.svideo.editor.R.string.alivc_editor_effect_caption);
        view.findViewById(com.aliyun.svideo.editor.R.id.iv_cancel).setOnClickListener(new com.aliyun.svideo.editor.effects.caption.CaptionChooserView.AnonymousClass1());
        view.findViewById(com.aliyun.svideo.editor.R.id.iv_confirm).setOnClickListener(new com.aliyun.svideo.editor.effects.caption.CaptionChooserView.AnonymousClass2());
    }

    private void loadLocalPaster() {
        com.aliyun.svideo.editor.effects.caption.CaptionChooserView.MyLoadAsyncTask myLoadAsyncTask = new com.aliyun.svideo.editor.effects.caption.CaptionChooserView.MyLoadAsyncTask(this, null);
        this.mLoadTask = myLoadAsyncTask;
        myLoadAsyncTask.execute(new java.lang.Void[0]);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public android.widget.FrameLayout getThumbContainer() {
        return (android.widget.FrameLayout) findViewById(com.aliyun.svideo.editor.R.id.fl_thumblinebar);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public com.aliyun.svideo.editor.effects.control.UIEditorPage getUIEditorPage() {
        return com.aliyun.svideo.editor.effects.control.UIEditorPage.CAPTION;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void init() {
        android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_caption, this);
        initTitleView(inflate);
        this.mCaptionData = new java.util.ArrayList<>();
        initListener();
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) inflate.findViewById(com.aliyun.svideo.editor.R.id.effect_list);
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        recyclerView.addItemDecoration(new com.aliyun.svideo.editor.effects.control.SpaceItemDecoration(getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.list_item_space)));
        com.aliyun.svideo.editor.effects.caption.CaptionAdapter captionAdapter = new com.aliyun.svideo.editor.effects.caption.CaptionAdapter(getContext());
        this.mCaptionAdapter = captionAdapter;
        captionAdapter.setOnItemClickListener(this.mOnItemClickListener);
        recyclerView.setAdapter(this.mCaptionAdapter);
        androidx.recyclerview.widget.RecyclerView recyclerView2 = (androidx.recyclerview.widget.RecyclerView) inflate.findViewById(com.aliyun.svideo.editor.R.id.category_list);
        this.mCategoryList = recyclerView2;
        recyclerView2.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        com.aliyun.svideo.editor.effects.CategoryAdapter categoryAdapter = new com.aliyun.svideo.editor.effects.CategoryAdapter(getContext());
        this.mCategoryAdapter = categoryAdapter;
        categoryAdapter.addShowFontCategory();
        this.mCategoryAdapter.setOnItemClickListener(this.mOnItemClickListener);
        this.mCategoryAdapter.setMoreClickListener(this.mOnMoreClickListener);
        this.mCategoryList.setAdapter(this.mCategoryAdapter);
        loadLocalPaster();
    }

    public void initResourceLocalWithSelectId(int i, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list) {
        this.mCaptionData.clear();
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
        this.mCaptionData.addAll(arrayList);
        com.aliyun.svideo.base.Form.ResourceForm resourceForm2 = new com.aliyun.svideo.base.Form.ResourceForm();
        resourceForm2.setMore(true);
        this.mCaptionData.add(resourceForm2);
        this.mCategoryAdapter.setData(this.mCaptionData);
        if (this.mCaptionData.size() == 1) {
            this.mCaptionAdapter.clearData();
            return;
        }
        int i2 = 0;
        if (i == 0 || !arrayList2.contains(java.lang.Integer.valueOf(i))) {
            this.mCaptionAdapter.showFontData();
        } else if (arrayList2.size() > 0) {
            java.util.Iterator<com.aliyun.svideo.base.Form.ResourceForm> it = this.mCaptionData.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.aliyun.svideo.base.Form.ResourceForm next = it.next();
                if (next.getId() == i) {
                    this.mCaptionAdapter.setData(next);
                    break;
                }
                i2++;
            }
        }
        this.mCategoryList.smoothScrollToPosition(i2);
        this.mCategoryAdapter.selectPosition(i2);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isHostPaster(com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController) {
        return aliyunBasePasterController != null && ((aliyunBasePasterController instanceof com.aliyun.svideo.editor.editor.PasterUITextImpl) || (aliyunBasePasterController instanceof com.aliyun.svideo.editor.editor.PasterUICaptionImpl));
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isPlayerNeedZoom() {
        return true;
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
