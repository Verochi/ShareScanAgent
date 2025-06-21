package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes29.dex */
public class MoreCaptionActivity extends com.aliyun.svideo.editor.effectmanager.AbstractActionBarActivity implements com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.OnItemRightButtonClickListener, android.view.View.OnClickListener {
    public static final java.lang.String SELECTED_ID = "selected_id";
    private static final java.lang.String TAG = "com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity";
    private android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm>>> loadCaptionResource;
    private com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter mAdapter;
    private androidx.recyclerview.widget.RecyclerView mRvMorePaster;
    private java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm>> mData = new java.util.ArrayList();
    private com.aliyun.svideo.editor.effectmanager.CaptionLoader mCaptionLoader = new com.aliyun.svideo.editor.effectmanager.CaptionLoader();
    private java.util.Hashtable<java.lang.Integer, java.lang.Boolean> mIsBreak = null;
    private int mFontResIndex = 0;
    private java.util.Map<java.lang.Integer, java.lang.Integer> mFontInfoRequestCountMap = new java.util.HashMap();

    /* renamed from: com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.effectmanager.CaptionLoader.LoadCallback {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.effectmanager.CaptionLoader.LoadCallback
        public void onLoadCompleted(java.util.List<com.aliyun.svideo.base.Form.ResourceForm> list, java.util.List<com.aliyun.svideo.base.Form.ResourceForm> list2, java.lang.Throwable th) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            if (list != null) {
                java.util.Iterator<com.aliyun.svideo.base.Form.ResourceForm> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.aliyun.svideo.editor.effectmanager.EffectBody(it.next(), true));
                }
                com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mAdapter.syncData(arrayList);
            }
            if (list2 != null) {
                java.util.Iterator<com.aliyun.svideo.base.Form.ResourceForm> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new com.aliyun.svideo.editor.effectmanager.EffectBody(it2.next(), false));
                }
            }
            arrayList2.addAll(arrayList);
            com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mAdapter.syncData(arrayList2);
            com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mIsBreak = new java.util.Hashtable(arrayList2.size());
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity$2, reason: invalid class name */
    public class AnonymousClass2 extends com.aliyun.svideo.downloader.FileDownloaderCallback {
        final /* synthetic */ com.aliyun.svideo.editor.effectmanager.EffectBody val$data;
        final /* synthetic */ com.aliyun.svideo.base.Form.PasterForm val$material;
        final /* synthetic */ java.util.List val$materials;
        final /* synthetic */ int val$position;
        final /* synthetic */ int[] val$process;
        final /* synthetic */ com.aliyun.svideo.downloader.FileDownloaderModel val$task;
        final /* synthetic */ java.util.List val$tasks;

        public AnonymousClass2(java.util.List list, com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel, com.aliyun.svideo.editor.effectmanager.EffectBody effectBody, int[] iArr, java.util.List list2, com.aliyun.svideo.base.Form.PasterForm pasterForm, int i) {
            this.val$tasks = list;
            this.val$task = fileDownloaderModel;
            this.val$data = effectBody;
            this.val$process = iArr;
            this.val$materials = list2;
            this.val$material = pasterForm;
            this.val$position = i;
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onError(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th) {
            super.onError(baseDownloadTask, th);
            com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this, th.getMessage());
            com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mIsBreak.put(java.lang.Integer.valueOf(((com.aliyun.svideo.base.Form.ResourceForm) this.val$data.getData()).getId()), java.lang.Boolean.TRUE);
            synchronized (this.val$tasks) {
                java.util.Iterator it = this.val$tasks.iterator();
                while (it.hasNext()) {
                    com.aliyun.svideo.downloader.DownloaderManager.getInstance().deleteTaskByTaskId(((com.aliyun.svideo.downloader.FileDownloaderModel) it.next()).getTaskId());
                }
                this.val$tasks.clear();
            }
            com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().deleteTaskById(((com.aliyun.svideo.base.Form.ResourceForm) this.val$data.getData()).getId());
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onFinish(int i, java.lang.String str) {
            boolean z;
            super.onFinish(i, str);
            synchronized (this.val$tasks) {
                this.val$tasks.remove(this.val$task);
                z = this.val$tasks.size() == 0;
            }
            java.lang.String unused = com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("downloadId ...");
            sb.append(i);
            sb.append("threadId...");
            sb.append(java.lang.Thread.currentThread().getId());
            sb.append("task size...");
            sb.append(this.val$tasks.size());
            if (z) {
                if (com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mIsBreak == null || com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mIsBreak.size() == 0 || !((java.lang.Boolean) com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mIsBreak.get(java.lang.Integer.valueOf(((com.aliyun.svideo.base.Form.ResourceForm) this.val$data.getData()).getId()))).booleanValue()) {
                    com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mAdapter.changeToLocal(this.val$data);
                    java.lang.String unused2 = com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.TAG;
                }
            }
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onProgress(int i, long j, long j2, long j3, int i2) {
            super.onProgress(i, j, j2, j3, i2);
            java.lang.String unused = com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("当前下载了");
            sb.append((j * 1.0f) / j2);
            this.val$process[this.val$materials.indexOf(this.val$material)] = i2;
            com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mAdapter.updateProcess((com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder) com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mRvMorePaster.findViewHolderForAdapterPosition(this.val$position), java.lang.Math.round(com.aliyun.svideo.editor.util.EditorCommon.getTotal(this.val$process) / this.val$process.length), this.val$position);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity$3, reason: invalid class name */
    public class AnonymousClass3 extends com.aliyun.svideo.downloader.FileDownloaderCallback {
        final /* synthetic */ com.aliyun.svideo.editor.effectmanager.EffectBody val$data;
        final /* synthetic */ com.aliyun.svideo.base.Form.FontForm val$fontForm;
        final /* synthetic */ java.util.List val$fontForms;
        final /* synthetic */ java.util.List val$materials;
        final /* synthetic */ int val$position;
        final /* synthetic */ int[] val$process;
        final /* synthetic */ com.aliyun.svideo.downloader.FileDownloaderModel val$task;
        final /* synthetic */ java.util.List val$tasks;

        public AnonymousClass3(java.util.List list, com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel, com.aliyun.svideo.editor.effectmanager.EffectBody effectBody, int[] iArr, java.util.List list2, com.aliyun.svideo.base.Form.FontForm fontForm, java.util.List list3, int i) {
            this.val$tasks = list;
            this.val$task = fileDownloaderModel;
            this.val$data = effectBody;
            this.val$process = iArr;
            this.val$fontForms = list2;
            this.val$fontForm = fontForm;
            this.val$materials = list3;
            this.val$position = i;
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onError(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th) {
            super.onError(baseDownloadTask, th);
            com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this, th.getMessage());
            com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mIsBreak.put(java.lang.Integer.valueOf(((com.aliyun.svideo.base.Form.ResourceForm) this.val$data.getData()).getId()), java.lang.Boolean.TRUE);
            synchronized (this.val$tasks) {
                java.util.Iterator it = this.val$tasks.iterator();
                while (it.hasNext()) {
                    com.aliyun.svideo.downloader.DownloaderManager.getInstance().deleteTaskByTaskId(((com.aliyun.svideo.downloader.FileDownloaderModel) it.next()).getTaskId());
                }
                this.val$tasks.clear();
                com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mAdapter.onDownloadFailure(this.val$data);
            }
            com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().deleteTaskById(((com.aliyun.svideo.base.Form.ResourceForm) this.val$data.getData()).getId());
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onFinish(int i, java.lang.String str) {
            boolean z;
            super.onFinish(i, str);
            synchronized (this.val$tasks) {
                this.val$tasks.remove(this.val$task);
                z = this.val$tasks.size() == 0;
            }
            java.lang.String unused = com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("downloadId font...");
            sb.append(i);
            sb.append("threadId...");
            sb.append(java.lang.Thread.currentThread().getId());
            sb.append("task size...");
            sb.append(this.val$tasks.size());
            if (z) {
                if (com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mIsBreak == null || com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mIsBreak.size() == 0 || !((java.lang.Boolean) com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mIsBreak.get(java.lang.Integer.valueOf(((com.aliyun.svideo.base.Form.ResourceForm) this.val$data.getData()).getId()))).booleanValue()) {
                    com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mAdapter.changeToLocal(this.val$data);
                    java.lang.String unused2 = com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.TAG;
                }
            }
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onProgress(int i, long j, long j2, long j3, int i2) {
            super.onProgress(i, j, j2, j3, i2);
            java.lang.String unused = com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("当前下载了");
            sb.append((j * 1.0f) / j2);
            this.val$process[this.val$fontForms.indexOf(this.val$fontForm) + this.val$materials.size()] = i2;
            com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mAdapter.updateProcess((com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.CaptionViewHolder) com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mRvMorePaster.findViewHolderForAdapterPosition(this.val$position), java.lang.Math.round(com.aliyun.svideo.editor.util.EditorCommon.getTotal(this.val$process) / this.val$process.length), this.val$position);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.Form.PasterForm>> {
        final /* synthetic */ com.aliyun.svideo.editor.effectmanager.EffectBody val$data;
        final /* synthetic */ java.util.List val$fontForms;
        final /* synthetic */ java.util.List val$ids;
        final /* synthetic */ int val$position;

        /* renamed from: com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity$4$1, reason: invalid class name */
        public class AnonymousClass1 implements com.aliyun.svideo.base.http.HttpCallback<com.aliyun.svideo.base.Form.FontForm> {
            public AnonymousClass1() {
            }

            @Override // com.aliyun.svideo.base.http.HttpCallback
            public void onFailure(java.lang.Throwable th) {
                int intValue = ((java.lang.Integer) com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mFontInfoRequestCountMap.get(java.lang.Integer.valueOf(com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.AnonymousClass4.this.val$position))).intValue() - 1;
                com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mFontInfoRequestCountMap.put(java.lang.Integer.valueOf(com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.AnonymousClass4.this.val$position), java.lang.Integer.valueOf(intValue));
                if (intValue == 0) {
                    com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.AnonymousClass4 anonymousClass4 = com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.AnonymousClass4.this;
                    com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.downloadAll(anonymousClass4.val$data, anonymousClass4.val$fontForms, anonymousClass4.val$position);
                }
            }

            @Override // com.aliyun.svideo.base.http.HttpCallback
            public void onSuccess(com.aliyun.svideo.base.Form.FontForm fontForm) {
                com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.AnonymousClass4.this.val$fontForms.add(fontForm);
                int intValue = ((java.lang.Integer) com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mFontInfoRequestCountMap.get(java.lang.Integer.valueOf(com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.AnonymousClass4.this.val$position))).intValue() - 1;
                com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mFontInfoRequestCountMap.put(java.lang.Integer.valueOf(com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.AnonymousClass4.this.val$position), java.lang.Integer.valueOf(intValue));
                if (intValue == 0) {
                    com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.AnonymousClass4 anonymousClass4 = com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.AnonymousClass4.this;
                    com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.downloadAll(anonymousClass4.val$data, anonymousClass4.val$fontForms, anonymousClass4.val$position);
                }
            }
        }

        public AnonymousClass4(com.aliyun.svideo.editor.effectmanager.EffectBody effectBody, int i, java.util.List list, java.util.List list2) {
            this.val$data = effectBody;
            this.val$position = i;
            this.val$ids = list;
            this.val$fontForms = list2;
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onFailure(java.lang.Throwable th) {
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onSuccess(java.util.List<com.aliyun.svideo.base.Form.PasterForm> list) {
            ((com.aliyun.svideo.base.Form.ResourceForm) this.val$data.getData()).setPasterList(list);
            com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mFontInfoRequestCountMap.put(java.lang.Integer.valueOf(this.val$position), 0);
            for (com.aliyun.svideo.base.Form.PasterForm pasterForm : list) {
                if (!this.val$ids.contains(java.lang.Integer.valueOf(pasterForm.getFontId()))) {
                    this.val$ids.add(java.lang.Integer.valueOf(pasterForm.getFontId()));
                    com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mFontInfoRequestCountMap.put(java.lang.Integer.valueOf(this.val$position), java.lang.Integer.valueOf(((java.lang.Integer) com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mFontInfoRequestCountMap.get(java.lang.Integer.valueOf(this.val$position))).intValue() + 1));
                    com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.mCaptionLoader.mService.getFontById(com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.this.getPackageName(), pasterForm.getFontId(), new com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.AnonymousClass4.AnonymousClass1());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadAll(com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody, java.util.List<com.aliyun.svideo.base.Form.FontForm> list, int i) {
        int i2;
        if (com.aliyun.common.utils.CommonUtil.SDFreeSize() < 10000000) {
            com.aliyun.svideo.common.utils.ToastUtils.show(this, com.aliyun.svideo.editor.R.string.alivc_common_no_free_memory);
            return;
        }
        com.aliyun.svideo.base.Form.ResourceForm data = effectBody.getData();
        java.util.List<com.aliyun.svideo.base.Form.PasterForm> pasterList = data.getPasterList();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (pasterList != null) {
            int size = pasterList.size() + list.size();
            int[] iArr = new int[size];
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("process size... ");
            sb.append(size);
            java.util.Iterator<com.aliyun.svideo.base.Form.PasterForm> it = pasterList.iterator();
            while (true) {
                i2 = 1;
                if (!it.hasNext()) {
                    break;
                }
                com.aliyun.svideo.base.Form.PasterForm next = it.next();
                com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
                fileDownloaderModel.setEffectType(6);
                fileDownloaderModel.setName(data.getName());
                fileDownloaderModel.setNameEn(data.getNameEn());
                fileDownloaderModel.setDescription(data.getDescription());
                fileDownloaderModel.setDescriptionEn(data.getDescriptionEn());
                fileDownloaderModel.setIcon(data.getIcon());
                fileDownloaderModel.setIsnew(data.getIsNew());
                fileDownloaderModel.setId(data.getId());
                fileDownloaderModel.setLevel(data.getLevel());
                fileDownloaderModel.setPreview(data.getPreviewUrl());
                fileDownloaderModel.setSort(data.getSort());
                fileDownloaderModel.setSubname(next.getName());
                fileDownloaderModel.setSubicon(next.getIcon());
                fileDownloaderModel.setSubid(next.getId());
                fileDownloaderModel.setUrl(next.getDownloadUrl());
                fileDownloaderModel.setMd5(next.getMD5());
                fileDownloaderModel.setSubpreview(next.getPreviewUrl());
                fileDownloaderModel.setSubsort(next.getSort());
                fileDownloaderModel.setSubtype(next.getType());
                fileDownloaderModel.setFontid(next.getFontId());
                fileDownloaderModel.setIsunzip(1);
                com.aliyun.svideo.downloader.FileDownloaderModel addTask = com.aliyun.svideo.downloader.DownloaderManager.getInstance().addTask(fileDownloaderModel, fileDownloaderModel.getUrl());
                com.aliyun.svideo.downloader.DownloaderManager.getInstance().startTask(addTask.getTaskId(), new com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.AnonymousClass2(arrayList, addTask, effectBody, iArr, pasterList, next, i));
                arrayList.add(addTask);
                data = data;
                it = it;
            }
            java.util.Iterator<com.aliyun.svideo.base.Form.FontForm> it2 = list.iterator();
            while (it2.hasNext()) {
                com.aliyun.svideo.base.Form.FontForm next2 = it2.next();
                com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel2 = new com.aliyun.svideo.downloader.FileDownloaderModel();
                fileDownloaderModel2.setEffectType(i2);
                fileDownloaderModel2.setName(next2.getName());
                fileDownloaderModel2.setIcon(next2.getIcon());
                fileDownloaderModel2.setId(next2.getId());
                fileDownloaderModel2.setLevel(next2.getLevel());
                fileDownloaderModel2.setSort(next2.getSort());
                fileDownloaderModel2.setUrl(next2.getUrl());
                fileDownloaderModel2.setMd5(next2.getMd5());
                fileDownloaderModel2.setBanner(next2.getBanner());
                fileDownloaderModel2.setIsunzip(i2);
                com.aliyun.svideo.downloader.FileDownloaderModel addTask2 = com.aliyun.svideo.downloader.DownloaderManager.getInstance().addTask(fileDownloaderModel2, fileDownloaderModel2.getUrl());
                com.aliyun.svideo.downloader.DownloaderManager.getInstance().startTask(addTask2.getTaskId(), new com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.AnonymousClass3(arrayList, addTask2, effectBody, iArr, list, next2, pasterList, i));
                arrayList.add(addTask2);
                it2 = it2;
                pasterList = pasterList;
                i2 = 1;
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0, new android.content.Intent());
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        if (view.getId() == getActionBarLeftViewID()) {
            onBackPressed();
        } else if (view.getId() == getActionBarRightViewID()) {
            android.content.Intent intent = new android.content.Intent(this, (java.lang.Class<?>) com.aliyun.svideo.editor.effectmanager.EffectManagerActivity.class);
            intent.putExtra(com.aliyun.svideo.editor.effectmanager.EffectManagerActivity.KEY_TAB, 1);
            startActivity(intent);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // com.aliyun.svideo.editor.effectmanager.AbstractActionBarActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.aliyun.svideo.editor.R.layout.alivc_editor_activity_more_effect);
        setActionBarLeftText(getString(com.aliyun.svideo.editor.R.string.alivc_common_cancel));
        setActionBarLeftViewVisibility(0);
        setActionBarTitle(getString(com.aliyun.svideo.editor.R.string.alivc_editor_more_title_caption));
        setActionBarTitleVisibility(0);
        setActionBarRightView(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_edit);
        setActionBarRightViewVisibility(0);
        setActionBarLeftClickListener(this);
        setActionBarRightClickListener(this);
        this.mRvMorePaster = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.rv_more_paster);
        com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter moreCaptionAdapter = new com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter(this.mData, this);
        this.mAdapter = moreCaptionAdapter;
        this.mRvMorePaster.setAdapter(moreCaptionAdapter);
        this.mRvMorePaster.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this, 1, false));
        this.mAdapter.setRightBtnClickListener(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm>>> asyncTask = this.loadCaptionResource;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.loadCaptionResource = null;
        }
    }

    @Override // com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.OnItemRightButtonClickListener
    public void onLocalItemClick(int i, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody) {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("selected_id", effectBody.getData().getId());
        setResult(-1, intent);
        finish();
    }

    @Override // com.aliyun.svideo.editor.effectmanager.MoreCaptionAdapter.OnItemRightButtonClickListener
    public void onRemoteItemClick(int i, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody) {
        if (!com.aliyun.common.utils.CommonUtil.hasNetwork(this)) {
            com.aliyun.svideo.common.utils.ToastUtils.show(this, com.aliyun.svideo.editor.R.string.alivc_editor_more_no_network);
            return;
        }
        this.mFontResIndex = 0;
        com.aliyun.svideo.base.Form.ResourceForm data = effectBody.getData();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.mCaptionLoader.mService.getCaptionListById(getPackageName(), data.getId(), new com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.AnonymousClass4(effectBody, i, new java.util.ArrayList(), arrayList));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mCaptionLoader.loadAllCaption(this, new com.aliyun.svideo.editor.effectmanager.MoreCaptionActivity.AnonymousClass1());
    }
}
