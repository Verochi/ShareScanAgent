package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes29.dex */
public class MorePasterActivity extends com.aliyun.svideo.editor.effectmanager.AbstractActionBarActivity {
    public static final java.lang.String SELECTED_ID = "selected_id";
    private static final java.lang.String TAG = "com.aliyun.svideo.editor.effectmanager.MorePasterActivity";
    private android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm>>> loadResource;
    private com.aliyun.svideo.editor.effectmanager.MorePasterAdapter mAdapter;
    private androidx.recyclerview.widget.RecyclerView mRvMorePaster;
    private com.aliyun.svideo.editor.effectmanager.EffectLoader mPasterLoader = new com.aliyun.svideo.editor.effectmanager.EffectLoader();
    private java.util.List<com.aliyun.svideo.base.Form.ResourceForm> mLoadingPaster = null;
    private java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> mLoadingTasks = new java.util.ArrayList();
    private int downloadSize = 0;
    private com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.OnItemRightButtonClickListener mOnItemRightButtonClickListener = new com.aliyun.svideo.editor.effectmanager.MorePasterActivity.AnonymousClass2();
    private android.view.View.OnClickListener mOnClickListener = new com.aliyun.svideo.editor.effectmanager.MorePasterActivity.AnonymousClass3();

    /* renamed from: com.aliyun.svideo.editor.effectmanager.MorePasterActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback<com.aliyun.svideo.base.Form.ResourceForm> {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback
        public void onLoadCompleted(java.util.List<com.aliyun.svideo.base.Form.ResourceForm> list, java.util.List<com.aliyun.svideo.base.Form.ResourceForm> list2, java.lang.Throwable th) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            if (list != null) {
                java.util.Iterator<com.aliyun.svideo.base.Form.ResourceForm> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new com.aliyun.svideo.editor.effectmanager.EffectBody(it.next(), true));
                }
            }
            if (list2 != null) {
                java.util.Iterator<com.aliyun.svideo.base.Form.ResourceForm> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new com.aliyun.svideo.editor.effectmanager.EffectBody(it2.next(), false));
                }
            }
            arrayList.addAll(arrayList2);
            com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mAdapter.syncData(arrayList);
            com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mLoadingPaster = new java.util.ArrayList(arrayList.size());
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effectmanager.MorePasterActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.OnItemRightButtonClickListener {

        /* renamed from: com.aliyun.svideo.editor.effectmanager.MorePasterActivity$2$1, reason: invalid class name */
        public class AnonymousClass1 implements com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.Form.PasterForm>> {
            final /* synthetic */ com.aliyun.svideo.editor.effectmanager.EffectBody val$data;
            final /* synthetic */ com.aliyun.svideo.base.Form.ResourceForm val$paster;
            final /* synthetic */ int val$position;

            /* renamed from: com.aliyun.svideo.editor.effectmanager.MorePasterActivity$2$1$1, reason: invalid class name and collision with other inner class name */
            public class C00611 extends com.aliyun.svideo.downloader.FileDownloaderCallback {
                final /* synthetic */ java.util.List val$currLoadingTask;
                final /* synthetic */ int val$size;
                final /* synthetic */ com.aliyun.svideo.downloader.FileDownloaderModel val$task;

                public C00611(java.util.List list, com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel, int i) {
                    this.val$currLoadingTask = list;
                    this.val$task = fileDownloaderModel;
                    this.val$size = i;
                }

                @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
                public void onError(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th) {
                    super.onError(baseDownloadTask, th);
                    com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this, th.getMessage());
                    synchronized (com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mLoadingTasks) {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        for (com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel : this.val$currLoadingTask) {
                            if (fileDownloaderModel.getId() == ((com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effectmanager.MorePasterActivity.AnonymousClass2.AnonymousClass1.this.val$data.getData()).getId()) {
                                com.aliyun.svideo.downloader.DownloaderManager.getInstance().deleteTaskByTaskId(fileDownloaderModel.getTaskId());
                                arrayList.add(fileDownloaderModel);
                            }
                        }
                        com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mLoadingPaster.remove(com.aliyun.svideo.editor.effectmanager.MorePasterActivity.AnonymousClass2.AnonymousClass1.this.val$data.getData());
                        com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mLoadingTasks.remove(arrayList);
                        arrayList.clear();
                        com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mAdapter.notifyDownloadingFailure(com.aliyun.svideo.editor.effectmanager.MorePasterActivity.AnonymousClass2.AnonymousClass1.this.val$data);
                    }
                    com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().deleteTaskById(((com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effectmanager.MorePasterActivity.AnonymousClass2.AnonymousClass1.this.val$data.getData()).getId());
                }

                @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
                public void onFinish(int i, java.lang.String str) {
                    boolean z;
                    super.onFinish(i, str);
                    synchronized (this.val$currLoadingTask) {
                        this.val$currLoadingTask.remove(this.val$task);
                        com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mLoadingPaster.remove(com.aliyun.svideo.editor.effectmanager.MorePasterActivity.AnonymousClass2.AnonymousClass1.this.val$data.getData());
                        z = this.val$currLoadingTask.size() == 0;
                        com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.downloadSize -= this.val$size;
                    }
                    if (z) {
                        java.lang.String unused = com.aliyun.svideo.editor.effectmanager.MorePasterActivity.TAG;
                        com.aliyun.svideo.editor.effectmanager.MorePasterAdapter morePasterAdapter = com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mAdapter;
                        com.aliyun.svideo.editor.effectmanager.MorePasterActivity.AnonymousClass2.AnonymousClass1 anonymousClass1 = com.aliyun.svideo.editor.effectmanager.MorePasterActivity.AnonymousClass2.AnonymousClass1.this;
                        morePasterAdapter.notifyDownloadingComplete(anonymousClass1.val$data, anonymousClass1.val$position);
                    }
                }

                @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
                public void onProgress(int i, long j, long j2, long j3, int i2) {
                    super.onProgress(i, j, j2, j3, i2);
                    synchronized (this) {
                        java.lang.String unused = com.aliyun.svideo.editor.effectmanager.MorePasterActivity.TAG;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("素材[");
                        sb.append(((com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effectmanager.MorePasterActivity.AnonymousClass2.AnonymousClass1.this.val$data.getData()).getName());
                        sb.append("]当前下载了 progress");
                        com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mAdapter.updateProcess((com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.PasterViewHolder) com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mRvMorePaster.findViewHolderForAdapterPosition(com.aliyun.svideo.editor.effectmanager.MorePasterActivity.AnonymousClass2.AnonymousClass1.this.val$position), i2, com.aliyun.svideo.editor.effectmanager.MorePasterActivity.AnonymousClass2.AnonymousClass1.this.val$position);
                    }
                }

                @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
                public void onStart(int i, long j, long j2, int i2) {
                    super.onStart(i, j, j2, i2);
                }
            }

            public AnonymousClass1(com.aliyun.svideo.editor.effectmanager.EffectBody effectBody, int i, com.aliyun.svideo.base.Form.ResourceForm resourceForm) {
                this.val$data = effectBody;
                this.val$position = i;
                this.val$paster = resourceForm;
            }

            @Override // com.aliyun.svideo.base.http.HttpCallback
            public void onFailure(java.lang.Throwable th) {
            }

            @Override // com.aliyun.svideo.base.http.HttpCallback
            public void onSuccess(java.util.List<com.aliyun.svideo.base.Form.PasterForm> list) {
                int size = list.size();
                com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.downloadSize += size;
                if (com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.downloadSize >= 50) {
                    com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.downloadSize -= size;
                    if (com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mLoadingPaster.contains(this.val$data.getData())) {
                        com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mLoadingPaster.remove(this.val$data.getData());
                    }
                    com.aliyun.svideo.editor.util.FixedToastUtils.show(com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.getApplicationContext(), com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_more_tip_task));
                    return;
                }
                com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mAdapter.notifyDownloadingStart(this.val$data);
                com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mAdapter.notifyItemChanged(this.val$position, com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.DOWNLOAD_START);
                com.aliyun.svideo.editor.effectmanager.TasksManager tasksManager = new com.aliyun.svideo.editor.effectmanager.TasksManager();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i = 0; i < size; i++) {
                    com.aliyun.svideo.base.Form.PasterForm pasterForm = list.get(i);
                    com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
                    fileDownloaderModel.setEffectType(2);
                    fileDownloaderModel.setName(this.val$paster.getName());
                    fileDownloaderModel.setNameEn(this.val$paster.getNameEn());
                    fileDownloaderModel.setDescription(this.val$paster.getDescription());
                    fileDownloaderModel.setDescriptionEn(this.val$paster.getDescriptionEn());
                    fileDownloaderModel.setIcon(this.val$paster.getIcon());
                    fileDownloaderModel.setIsnew(this.val$paster.getIsNew());
                    fileDownloaderModel.setId(this.val$paster.getId());
                    fileDownloaderModel.setLevel(this.val$paster.getLevel());
                    fileDownloaderModel.setPreview(this.val$paster.getPreviewUrl());
                    fileDownloaderModel.setSort(this.val$paster.getSort());
                    fileDownloaderModel.setSubname(pasterForm.getName());
                    fileDownloaderModel.setSubicon(pasterForm.getIcon());
                    fileDownloaderModel.setSubid(pasterForm.getId());
                    fileDownloaderModel.setPriority(pasterForm.getPriority());
                    fileDownloaderModel.setUrl(pasterForm.getDownloadUrl());
                    fileDownloaderModel.setMd5(pasterForm.getMD5());
                    fileDownloaderModel.setSubpreview(pasterForm.getPreviewUrl());
                    fileDownloaderModel.setSubsort(pasterForm.getSort());
                    fileDownloaderModel.setSubtype(pasterForm.getType());
                    fileDownloaderModel.setIsunzip(1);
                    com.aliyun.svideo.downloader.FileDownloaderModel addTask = com.aliyun.svideo.downloader.DownloaderManager.getInstance().addTask(fileDownloaderModel, fileDownloaderModel.getUrl());
                    tasksManager.addTask(addTask.getTaskId(), new com.aliyun.svideo.editor.effectmanager.MorePasterActivity.AnonymousClass2.AnonymousClass1.C00611(arrayList, addTask, size));
                    com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mLoadingTasks.add(addTask);
                    arrayList.add(addTask);
                    tasksManager.startTask();
                }
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.OnItemRightButtonClickListener
        public void onLocalItemClick(int i, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody) {
            android.content.Intent intent = new android.content.Intent();
            intent.putExtra("selected_id", effectBody.getData().getId());
            com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.setResult(-1, intent);
            com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.finish();
        }

        @Override // com.aliyun.svideo.editor.effectmanager.MorePasterAdapter.OnItemRightButtonClickListener
        public void onRemoteItemClick(int i, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm> effectBody) {
            if (!com.aliyun.common.utils.CommonUtil.hasNetwork(com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this)) {
                com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this, com.aliyun.svideo.editor.R.string.alivc_editor_more_no_network);
                return;
            }
            if (com.aliyun.common.utils.CommonUtil.SDFreeSize() < 10000000) {
                com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this, com.aliyun.svideo.editor.R.string.alivc_common_no_free_memory);
            } else {
                if (com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mLoadingPaster.contains(effectBody.getData())) {
                    return;
                }
                com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mLoadingPaster.add(effectBody.getData());
                com.aliyun.svideo.base.Form.ResourceForm data = effectBody.getData();
                com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.mPasterLoader.mService.getPasterListById(com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.getPackageName(), data.getId(), new com.aliyun.svideo.editor.effectmanager.MorePasterActivity.AnonymousClass2.AnonymousClass1(effectBody, i, data));
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effectmanager.MorePasterActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (view.getId() == com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.getActionBarLeftViewID()) {
                com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.onBackPressed();
            } else if (view.getId() == com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.getActionBarRightViewID()) {
                android.content.Intent intent = new android.content.Intent(com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this, (java.lang.Class<?>) com.aliyun.svideo.editor.effectmanager.EffectManagerActivity.class);
                intent.putExtra(com.aliyun.svideo.editor.effectmanager.EffectManagerActivity.KEY_TAB, 0);
                com.aliyun.svideo.editor.effectmanager.MorePasterActivity.this.startActivity(intent);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class LoadResourceTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm>>> {
        java.lang.ref.WeakReference<com.aliyun.svideo.editor.effectmanager.MorePasterActivity> weakReference;

        public LoadResourceTask(com.aliyun.svideo.editor.effectmanager.MorePasterActivity morePasterActivity) {
            this.weakReference = new java.lang.ref.WeakReference<>(morePasterActivity);
        }

        @Override // android.os.AsyncTask
        public java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm>> doInBackground(java.lang.Void... voidArr) {
            com.aliyun.svideo.editor.effectmanager.MorePasterActivity morePasterActivity = this.weakReference.get();
            java.util.ArrayList arrayList = null;
            java.util.List<com.aliyun.svideo.base.Form.ResourceForm> loadLocalPaster = morePasterActivity != null ? morePasterActivity.mPasterLoader.loadLocalPaster() : null;
            if (loadLocalPaster != null) {
                arrayList = new java.util.ArrayList();
                java.util.Iterator<com.aliyun.svideo.base.Form.ResourceForm> it = loadLocalPaster.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.aliyun.svideo.editor.effectmanager.EffectBody(it.next(), true));
                }
            }
            return arrayList;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm>> list) {
            com.aliyun.svideo.editor.effectmanager.MorePasterActivity morePasterActivity = this.weakReference.get();
            if (morePasterActivity == null || list == null) {
                return;
            }
            morePasterActivity.mAdapter.syncData(list);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(0, new android.content.Intent());
        super.onBackPressed();
    }

    @Override // com.aliyun.svideo.editor.effectmanager.AbstractActionBarActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.aliyun.svideo.editor.R.layout.alivc_editor_activity_more_effect);
        setActionBarLeftText(getString(com.aliyun.svideo.editor.R.string.alivc_common_cancel));
        setActionBarLeftViewVisibility(0);
        setActionBarTitle(getString(com.aliyun.svideo.editor.R.string.alivc_editor_more_title_sticker));
        setActionBarTitleVisibility(0);
        setActionBarRightView(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_edit);
        setActionBarRightViewVisibility(0);
        setActionBarLeftClickListener(this.mOnClickListener);
        setActionBarRightClickListener(this.mOnClickListener);
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.rv_more_paster);
        this.mRvMorePaster = recyclerView;
        recyclerView.setItemAnimator(null);
        com.aliyun.svideo.editor.effectmanager.MorePasterAdapter morePasterAdapter = new com.aliyun.svideo.editor.effectmanager.MorePasterAdapter(this);
        this.mAdapter = morePasterAdapter;
        this.mRvMorePaster.setAdapter(morePasterAdapter);
        this.mRvMorePaster.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this, 1, false));
        this.mAdapter.setRightBtnClickListener(this.mOnItemRightButtonClickListener);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.ResourceForm>>> asyncTask = this.loadResource;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.loadResource = null;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.loadResource = new com.aliyun.svideo.editor.effectmanager.MorePasterActivity.LoadResourceTask(this).executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
        this.mPasterLoader.loadAllPaster(this, new com.aliyun.svideo.editor.effectmanager.MorePasterActivity.AnonymousClass1());
    }
}
