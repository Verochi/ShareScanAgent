package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes29.dex */
public class MoreMVActivity extends com.aliyun.svideo.editor.effectmanager.AbstractActionBarActivity implements com.aliyun.svideo.editor.effectmanager.MoreMVAdapter.OnItemRightButtonClickListener, android.view.View.OnClickListener {
    public static final java.lang.String SELECTD_ID = "selected_id";
    private static final java.lang.String TAG = "com.aliyun.svideo.editor.effectmanager.MoreMVActivity";
    private android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.IMVForm>>> loadResourceTask;
    private com.aliyun.svideo.editor.effectmanager.MoreMVAdapter mAdapter;
    private androidx.recyclerview.widget.RecyclerView mRvMoreMV;
    private int selectId;
    private com.aliyun.svideo.editor.effectmanager.EffectLoader mMVLoader = new com.aliyun.svideo.editor.effectmanager.EffectLoader();
    private java.util.List<com.aliyun.svideo.base.Form.IMVForm> mLoadingMv = null;

    /* renamed from: com.aliyun.svideo.editor.effectmanager.MoreMVActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback<com.aliyun.svideo.base.Form.IMVForm> {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.effectmanager.EffectLoader.LoadCallback
        public void onLoadCompleted(java.util.List<com.aliyun.svideo.base.Form.IMVForm> list, java.util.List<com.aliyun.svideo.base.Form.IMVForm> list2, java.lang.Throwable th) {
            int size = list == null ? 0 : list.size();
            int size2 = list2 == null ? 0 : list2.size();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("localSize : ");
            sb.append(size);
            sb.append(" ,remoteSize : ");
            sb.append(size2);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            if (list != null) {
                java.util.Iterator<com.aliyun.svideo.base.Form.IMVForm> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new com.aliyun.svideo.editor.effectmanager.EffectBody(it.next(), true));
                }
            }
            if (list2 != null) {
                java.util.Iterator<com.aliyun.svideo.base.Form.IMVForm> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new com.aliyun.svideo.editor.effectmanager.EffectBody(it2.next(), false));
                }
            }
            arrayList.addAll(arrayList2);
            com.aliyun.svideo.editor.effectmanager.MoreMVActivity.this.mAdapter.syncData(arrayList);
            com.aliyun.svideo.editor.effectmanager.MoreMVActivity.this.mLoadingMv = new java.util.ArrayList(arrayList.size());
        }
    }

    public static class FileDownLoadCallBack extends com.aliyun.svideo.downloader.FileDownloaderCallback {
        private com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.IMVForm> data;
        private int position;
        private java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> tasks;
        private java.lang.ref.WeakReference<com.aliyun.svideo.editor.effectmanager.MoreMVActivity> weakReference;

        public FileDownLoadCallBack(com.aliyun.svideo.editor.effectmanager.MoreMVActivity moreMVActivity, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.IMVForm> effectBody, int i, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list) {
            this.weakReference = new java.lang.ref.WeakReference<>(moreMVActivity);
            this.data = effectBody;
            this.position = i;
            this.tasks = list;
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onError(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th) {
            super.onError(baseDownloadTask, th);
            com.aliyun.svideo.editor.effectmanager.MoreMVActivity moreMVActivity = this.weakReference.get();
            if (moreMVActivity != null) {
                moreMVActivity.mAdapter.notifyDownloadingFailure(this.data);
                moreMVActivity.mLoadingMv.remove(this.data.getData());
                com.aliyun.common.utils.ToastUtil.showToast(moreMVActivity, th.getMessage());
                synchronized (this.tasks) {
                    java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderModel> it = this.tasks.iterator();
                    while (it.hasNext()) {
                        com.aliyun.svideo.downloader.DownloaderManager.getInstance().deleteTaskByTaskId(it.next().getTaskId());
                    }
                    this.tasks.clear();
                }
                com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().deleteTaskById(this.data.getData().getId());
            }
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onFinish(int i, java.lang.String str) {
            super.onFinish(i, str);
            com.aliyun.svideo.editor.effectmanager.MoreMVActivity moreMVActivity = this.weakReference.get();
            if (moreMVActivity != null) {
                moreMVActivity.mLoadingMv.remove(this.data.getData());
                java.lang.String unused = com.aliyun.svideo.editor.effectmanager.MoreMVActivity.TAG;
                moreMVActivity.mAdapter.notifyDownloadingComplete(this.data, this.position);
            }
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onProgress(int i, long j, long j2, long j3, int i2) {
            super.onProgress(i, j, j2, j3, i2);
            java.lang.String unused = com.aliyun.svideo.editor.effectmanager.MoreMVActivity.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("当前下载了");
            sb.append((j * 1.0f) / j2);
            com.aliyun.svideo.editor.effectmanager.MoreMVActivity moreMVActivity = this.weakReference.get();
            if (moreMVActivity != null) {
                moreMVActivity.mAdapter.updateProcess((com.aliyun.svideo.editor.effectmanager.MoreMVAdapter.ImvViewHolder) moreMVActivity.mRvMoreMV.findViewHolderForAdapterPosition(this.position), i2, this.position);
            }
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onStart(int i, long j, long j2, int i2) {
            super.onStart(i, j, j2, i2);
            com.aliyun.svideo.editor.effectmanager.MoreMVActivity moreMVActivity = this.weakReference.get();
            if (moreMVActivity != null) {
                moreMVActivity.mAdapter.notifyDownloadingStart(this.data);
            }
        }
    }

    private void initData() {
        this.selectId = getIntent().getIntExtra("selected_id", 0);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("selected_id", this.selectId);
        setResult(0, intent);
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        if (view.getId() == getActionBarLeftViewID()) {
            onBackPressed();
        } else if (view.getId() == getActionBarRightViewID()) {
            android.content.Intent intent = new android.content.Intent(this, (java.lang.Class<?>) com.aliyun.svideo.editor.effectmanager.EffectManagerActivity.class);
            intent.putExtra(com.aliyun.svideo.editor.effectmanager.EffectManagerActivity.KEY_TAB, 3);
            startActivity(intent);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // com.aliyun.svideo.editor.effectmanager.AbstractActionBarActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        initData();
        setContentView(com.aliyun.svideo.editor.R.layout.alivc_editor_activity_more_effect);
        setActionBarLeftText(getString(com.aliyun.svideo.editor.R.string.alivc_common_cancel));
        setActionBarLeftViewVisibility(0);
        setActionBarTitle(getString(com.aliyun.svideo.editor.R.string.alivc_editor_more_title_mv));
        setActionBarTitleVisibility(0);
        setActionBarRightView(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_edit);
        setActionBarRightViewVisibility(0);
        setActionBarLeftClickListener(this);
        setActionBarRightClickListener(this);
        this.mRvMoreMV = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.rv_more_paster);
        com.aliyun.svideo.editor.effectmanager.MoreMVAdapter moreMVAdapter = new com.aliyun.svideo.editor.effectmanager.MoreMVAdapter(this);
        this.mAdapter = moreMVAdapter;
        this.mRvMoreMV.setAdapter(moreMVAdapter);
        this.mRvMoreMV.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this, 1, false));
        this.mAdapter.setRightBtnClickListener(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.IMVForm>>> asyncTask = this.loadResourceTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.loadResourceTask = null;
        }
    }

    @Override // com.aliyun.svideo.editor.effectmanager.MoreMVAdapter.OnItemRightButtonClickListener
    public void onLocalItemClick(int i, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.IMVForm> effectBody) {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("selected_id", effectBody.getData().getId());
        setResult(-1, intent);
        finish();
    }

    @Override // com.aliyun.svideo.editor.effectmanager.MoreMVAdapter.OnItemRightButtonClickListener
    public void onRemoteItemClick(int i, com.aliyun.svideo.editor.effectmanager.EffectBody<com.aliyun.svideo.base.Form.IMVForm> effectBody) {
        if (!com.aliyun.common.utils.CommonUtil.hasNetwork(this)) {
            com.aliyun.common.utils.ToastUtil.showToast(this, com.aliyun.svideo.editor.R.string.alivc_editor_more_no_network);
            return;
        }
        if (com.aliyun.common.utils.CommonUtil.SDFreeSize() < 10000000) {
            android.widget.Toast.makeText(this, com.aliyun.svideo.editor.R.string.alivc_common_no_free_memory, 0).show();
            return;
        }
        if (this.mLoadingMv.contains(effectBody.getData())) {
            return;
        }
        this.mLoadingMv.add(effectBody.getData());
        com.aliyun.svideo.base.Form.IMVForm data = effectBody.getData();
        java.util.List<com.aliyun.svideo.base.Form.AspectForm> aspectList = data.getAspectList();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.aliyun.svideo.editor.effectmanager.TasksManager tasksManager = new com.aliyun.svideo.editor.effectmanager.TasksManager();
        if (aspectList != null) {
            for (com.aliyun.svideo.base.Form.AspectForm aspectForm : aspectList) {
                com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
                fileDownloaderModel.setEffectType(3);
                fileDownloaderModel.setTag(data.getTag());
                fileDownloaderModel.setKey(data.getKey());
                fileDownloaderModel.setName(data.getName());
                fileDownloaderModel.setNameEn(data.getNameEn());
                fileDownloaderModel.setId(data.getId());
                fileDownloaderModel.setCat(data.getCat());
                fileDownloaderModel.setLevel(data.getLevel());
                fileDownloaderModel.setPreviewpic(data.getPreviewPic());
                fileDownloaderModel.setIcon(data.getIcon());
                fileDownloaderModel.setPreviewmp4(data.getPreviewMp4());
                fileDownloaderModel.setSort(data.getSort());
                fileDownloaderModel.setSubtype(data.getType());
                fileDownloaderModel.setMd5(aspectForm.getMd5());
                fileDownloaderModel.setDownload(aspectForm.getDownload());
                fileDownloaderModel.setUrl(aspectForm.getDownload());
                fileDownloaderModel.setAspect(aspectForm.getAspect());
                fileDownloaderModel.setDuration(data.getDuration());
                fileDownloaderModel.setIsunzip(1);
                tasksManager.addTask(com.aliyun.svideo.downloader.DownloaderManager.getInstance().addTask(fileDownloaderModel, fileDownloaderModel.getDownload()).getTaskId(), new com.aliyun.svideo.editor.effectmanager.MoreMVActivity.FileDownLoadCallBack(this, effectBody, i, arrayList));
            }
            tasksManager.startTask();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mMVLoader.loadAllMV(this, new com.aliyun.svideo.editor.effectmanager.MoreMVActivity.AnonymousClass1());
    }
}
