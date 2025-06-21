package com.aliyun.svideo.music.music;

/* loaded from: classes12.dex */
public class MusicLoader {
    public static final int EFFECT_MUSIC = 5;
    private com.aliyun.svideo.music.music.MusicLoader.LoadCallback callback;
    private boolean isLoadingMusic;
    private boolean isMusicEnd;
    private final android.content.Context mContext;
    private final com.aliyun.svideo.music.music.MusicQuery mMusicQuery;
    public com.aliyun.svideo.base.http.EffectService mService = new com.aliyun.svideo.base.http.EffectService();
    private int pageSize = 25;
    private int pageNo = 1;

    /* renamed from: com.aliyun.svideo.music.music.MusicLoader$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.music.music.MusicQuery.OnResProgressListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.music.music.MusicQuery.OnResProgressListener
        public void onResProgress(java.util.ArrayList<com.aliyun.svideo.base.http.MusicFileBean> arrayList) {
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            java.util.Iterator<com.aliyun.svideo.base.http.MusicFileBean> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new com.aliyun.svideo.music.music.EffectBody(it.next(), true));
            }
            if (com.aliyun.svideo.music.music.MusicLoader.this.callback != null) {
                com.aliyun.svideo.music.music.MusicLoader.this.callback.onLoadLocalMusicCompleted(arrayList2);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.music.music.MusicLoader$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.http.MusicFileBean>> {
        final /* synthetic */ java.lang.String val$keyWord;
        final /* synthetic */ int val$pageSize;

        public AnonymousClass2(java.lang.String str, int i) {
            this.val$keyWord = str;
            this.val$pageSize = i;
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onFailure(java.lang.Throwable th) {
            com.aliyun.svideo.music.music.MusicLoader.this.isLoadingMusic = false;
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onSuccess(java.util.List<com.aliyun.svideo.base.http.MusicFileBean> list) {
            com.aliyun.svideo.music.music.MusicLoader.this.isLoadingMusic = false;
            if (android.text.TextUtils.isEmpty(this.val$keyWord) && list.size() < this.val$pageSize) {
                com.aliyun.svideo.music.music.MusicLoader.this.isMusicEnd = true;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> resourceByType = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(5);
            for (com.aliyun.svideo.base.http.MusicFileBean musicFileBean : list) {
                com.aliyun.svideo.music.music.EffectBody effectBody = new com.aliyun.svideo.music.music.EffectBody(musicFileBean, false);
                for (com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel : resourceByType) {
                    if (musicFileBean.getMusicId().equals(fileDownloaderModel.getDownload()) && new java.io.File(fileDownloaderModel.getPath()).exists()) {
                        musicFileBean.setPath(fileDownloaderModel.getPath());
                        effectBody.setLocal(true);
                    }
                }
                arrayList.add(effectBody);
            }
            if (com.aliyun.svideo.music.music.MusicLoader.this.callback != null) {
                if (android.text.TextUtils.isEmpty(this.val$keyWord)) {
                    com.aliyun.svideo.music.music.MusicLoader.this.callback.onLoadNetMusicCompleted(arrayList);
                } else {
                    com.aliyun.svideo.music.music.MusicLoader.this.callback.onSearchNetMusicCompleted(arrayList);
                }
            }
            com.aliyun.svideo.music.music.MusicLoader.this.pageNo++;
            com.aliyun.svideo.music.music.MusicLoader.this.pageSize++;
        }
    }

    /* renamed from: com.aliyun.svideo.music.music.MusicLoader$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideo.base.http.HttpCallback<java.lang.String> {
        final /* synthetic */ com.aliyun.svideo.downloader.FileDownloaderCallback val$callback;
        final /* synthetic */ com.aliyun.svideo.base.http.MusicFileBean val$musicFileBean;

        /* renamed from: com.aliyun.svideo.music.music.MusicLoader$3$1, reason: invalid class name */
        public class AnonymousClass1 extends com.aliyun.svideo.downloader.FileDownloaderCallback {
            final /* synthetic */ com.aliyun.svideo.downloader.FileDownloaderModel val$model;

            public AnonymousClass1(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel) {
                this.val$model = fileDownloaderModel;
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onError(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th) {
                com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.music.music.MusicLoader.this.mContext, th.getMessage());
                com.aliyun.svideo.downloader.DownloaderManager.getInstance().deleteTaskByTaskId(this.val$model.getTaskId());
                com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().deleteTask(this.val$model.getTaskId());
                com.aliyun.svideo.music.music.MusicLoader.AnonymousClass3.this.val$callback.onError(baseDownloadTask, th);
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onFinish(int i, java.lang.String str) {
                com.aliyun.svideo.music.music.MusicLoader.AnonymousClass3.this.val$callback.onFinish(i, str);
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onProgress(int i, long j, long j2, long j3, int i2) {
                com.aliyun.svideo.music.music.MusicLoader.AnonymousClass3.this.val$callback.onProgress(i, j, j2, j3, i2);
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onStart(int i, long j, long j2, int i2) {
                com.aliyun.svideo.music.music.MusicLoader.AnonymousClass3.this.val$callback.onStart(i, j, j2, i2);
            }
        }

        public AnonymousClass3(com.aliyun.svideo.base.http.MusicFileBean musicFileBean, com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback) {
            this.val$musicFileBean = musicFileBean;
            this.val$callback = fileDownloaderCallback;
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onFailure(java.lang.Throwable th) {
        }

        @Override // com.aliyun.svideo.base.http.HttpCallback
        public void onSuccess(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.music.music.MusicLoader.this.mContext, com.aliyun.svideo.music.music.MusicLoader.this.mContext.getResources().getString(com.aliyun.svideo.music.R.string.alivc_music_play_url_null));
                return;
            }
            com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
            fileDownloaderModel.setUrl(str);
            fileDownloaderModel.setDownload(this.val$musicFileBean.getMusicId());
            fileDownloaderModel.setName(this.val$musicFileBean.title);
            fileDownloaderModel.setIsunzip(0);
            fileDownloaderModel.setDuration(this.val$musicFileBean.duration);
            fileDownloaderModel.setPath(com.aliyun.common.utils.StorageUtils.getFilesDirectory(com.aliyun.svideo.music.music.MusicLoader.this.mContext) + "/svideo_res/cloud/music/" + this.val$musicFileBean.title);
            fileDownloaderModel.setDescription(this.val$musicFileBean.artist);
            fileDownloaderModel.setEffectType(5);
            com.aliyun.svideo.downloader.FileDownloaderModel addTask = com.aliyun.svideo.downloader.DownloaderManager.getInstance().addTask(fileDownloaderModel, str);
            if (com.aliyun.svideo.downloader.DownloaderManager.getInstance().isDownloading(addTask.getTaskId(), addTask.getPath())) {
                return;
            }
            com.aliyun.svideo.downloader.DownloaderManager.getInstance().startTask(addTask.getTaskId(), new com.aliyun.svideo.music.music.MusicLoader.AnonymousClass3.AnonymousClass1(addTask));
        }
    }

    public interface LoadCallback {
        void onLoadLocalMusicCompleted(java.util.List<com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean>> list);

        void onLoadNetMusicCompleted(java.util.List<com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean>> list);

        void onSearchNetMusicCompleted(java.util.List<com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean>> list);
    }

    public MusicLoader(android.content.Context context) {
        this.mContext = context;
        this.mMusicQuery = new com.aliyun.svideo.music.music.MusicQuery(context);
    }

    private void loadOnlineMusic(int i, int i2, java.lang.String str) {
        if (!com.aliyun.common.utils.CommonUtil.hasNetwork(this.mContext)) {
            com.aliyun.common.utils.ToastUtil.showToast(this.mContext, com.aliyun.svideo.music.R.string.alivc_music_network_not_connect);
        } else {
            this.isLoadingMusic = true;
            this.mService.loadingMusicData(this.mContext.getPackageName(), i, i2, str, new com.aliyun.svideo.music.music.MusicLoader.AnonymousClass2(str, i2));
        }
    }

    public void downloadMusic(com.aliyun.svideo.base.http.MusicFileBean musicFileBean, com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback) {
        if (!com.aliyun.common.utils.CommonUtil.hasNetwork(this.mContext)) {
            com.aliyun.common.utils.ToastUtil.showToast(this.mContext, com.aliyun.svideo.music.R.string.alivc_music_network_not_connect);
        } else if (com.aliyun.common.utils.CommonUtil.SDFreeSize() < 10000000) {
            android.widget.Toast.makeText(this.mContext, com.aliyun.svideo.music.R.string.alivc_music_no_free_memory, 0).show();
        } else {
            this.mService.getMusicDownloadUrlById(this.mContext.getPackageName(), musicFileBean.musicId, new com.aliyun.svideo.music.music.MusicLoader.AnonymousClass3(musicFileBean, fileDownloaderCallback));
        }
    }

    public void loadAllMusic() {
        loadLocalMusic();
        loadMoreOnlineMusic();
    }

    public void loadLocalMusic() {
        this.mMusicQuery.setOnResProgressListener(new com.aliyun.svideo.music.music.MusicLoader.AnonymousClass1());
        this.mMusicQuery.executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
    }

    public void loadMoreOnlineMusic() {
        if (this.isLoadingMusic || this.isMusicEnd) {
            return;
        }
        loadOnlineMusic(this.pageNo, this.pageSize, "");
    }

    public void searchOnlineMusic(java.lang.String str) {
        loadOnlineMusic(1, 25, str);
    }

    public void setCallback(com.aliyun.svideo.music.music.MusicLoader.LoadCallback loadCallback) {
        this.callback = loadCallback;
    }
}
