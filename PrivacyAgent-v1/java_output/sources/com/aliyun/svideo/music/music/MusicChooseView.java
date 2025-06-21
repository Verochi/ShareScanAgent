package com.aliyun.svideo.music.music;

/* loaded from: classes12.dex */
public class MusicChooseView extends android.widget.LinearLayout implements android.view.View.OnClickListener {
    private static final java.lang.String TAG = "MusicChooseView";
    private boolean isLocalMusic;
    boolean isShowed;
    private boolean isViewAttached;
    private boolean isVisible;
    private android.widget.TextView mAlivcMusicCopyrightTV;
    private android.widget.ImageView mAliyunBackBtn;
    private android.widget.TextView mAliyunCompeletBtn;
    private android.widget.TextView mAliyunLocalMusic;
    private androidx.recyclerview.widget.RecyclerView mAliyunMusicRecyclerView;
    private android.widget.TextView mAliyunOnlineMusic;
    private boolean mCacheIsLocalMusic;
    private com.aliyun.svideo.base.http.MusicFileBean mCacheMusic;
    private int mCachePosition;
    private int mCacheStartTime;
    private java.util.ArrayList<com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean>> mLocalMusicList;
    private int mLoopTime;
    private android.media.MediaPlayer mMediaPlayer;
    private java.lang.Runnable mMusciRunnable;
    private com.aliyun.svideo.music.music.MusicAdapter mMusicAdapter;
    private java.util.ArrayList<com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean>> mOnlineMusicList;
    private android.os.Handler mPlayHandler;
    private int mRecordTime;
    private com.aliyun.svideo.base.http.MusicFileBean mSelectMusic;
    private int mSelectPosition;
    java.lang.Runnable mStartRunnable;
    private int mStartTime;
    private android.media.MediaMetadataRetriever mmr;
    private com.aliyun.svideo.music.music.MusicLoader musicLoader;
    private com.aliyun.svideo.music.music.MusicSelectListener musicSelectListener;
    private int playedTime;

    /* renamed from: com.aliyun.svideo.music.music.MusicChooseView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.music.music.MusicLoader.LoadCallback {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.music.music.MusicLoader.LoadCallback
        public void onLoadLocalMusicCompleted(java.util.List<com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean>> list) {
            com.aliyun.svideo.music.music.MusicChooseView.this.mLocalMusicList.clear();
            com.aliyun.svideo.music.music.MusicChooseView.this.mLocalMusicList.addAll(list);
            if (com.aliyun.svideo.music.music.MusicChooseView.this.isLocalMusic) {
                com.aliyun.svideo.music.music.MusicChooseView.this.mMusicAdapter.setData(com.aliyun.svideo.music.music.MusicChooseView.this.mLocalMusicList, 0);
            }
        }

        @Override // com.aliyun.svideo.music.music.MusicLoader.LoadCallback
        public void onLoadNetMusicCompleted(java.util.List<com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean>> list) {
            com.aliyun.svideo.music.music.MusicChooseView.this.mOnlineMusicList.addAll(list);
            if (com.aliyun.svideo.music.music.MusicChooseView.this.isLocalMusic) {
                return;
            }
            com.aliyun.svideo.music.music.MusicChooseView.this.mMusicAdapter.setData(com.aliyun.svideo.music.music.MusicChooseView.this.mOnlineMusicList, 0);
        }

        @Override // com.aliyun.svideo.music.music.MusicLoader.LoadCallback
        public void onSearchNetMusicCompleted(java.util.List<com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean>> list) {
        }
    }

    /* renamed from: com.aliyun.svideo.music.music.MusicChooseView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.music.music.MusicAdapter.OnMusicSeek {

        /* renamed from: com.aliyun.svideo.music.music.MusicChooseView$2$1, reason: invalid class name */
        public class AnonymousClass1 extends com.aliyun.svideo.downloader.FileDownloaderCallback {
            final /* synthetic */ com.aliyun.svideo.music.music.EffectBody val$effectBody;
            final /* synthetic */ int val$position;

            public AnonymousClass1(com.aliyun.svideo.music.music.EffectBody effectBody, int i) {
                this.val$effectBody = effectBody;
                this.val$position = i;
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onError(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th) {
                super.onError(baseDownloadTask, th);
                com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.music.music.MusicChooseView.this.getContext(), th.getMessage());
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onFinish(int i, java.lang.String str) {
                super.onFinish(i, str);
                ((com.aliyun.svideo.base.http.MusicFileBean) this.val$effectBody.getData()).setPath(str);
                if (com.aliyun.svideo.music.music.MusicChooseView.this.mMusicAdapter == null) {
                    return;
                }
                if (this.val$position == com.aliyun.svideo.music.music.MusicChooseView.this.mMusicAdapter.getSelectIndex() && !com.aliyun.svideo.music.music.MusicChooseView.this.isLocalMusic) {
                    com.aliyun.svideo.music.music.MusicChooseView.this.onMusicSelected((com.aliyun.svideo.base.http.MusicFileBean) this.val$effectBody.getData(), this.val$position);
                }
                com.aliyun.svideo.music.music.MusicChooseView.this.mMusicAdapter.notifyDownloadingComplete((com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder) com.aliyun.svideo.music.music.MusicChooseView.this.mAliyunMusicRecyclerView.findViewHolderForAdapterPosition(this.val$position), this.val$effectBody, this.val$position);
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onProgress(int i, long j, long j2, long j3, int i2) {
                super.onProgress(i, j, j2, j3, i2);
                if (com.aliyun.svideo.music.music.MusicChooseView.this.isLocalMusic) {
                    return;
                }
                com.aliyun.svideo.music.music.MusicChooseView.this.mMusicAdapter.updateProcess((com.aliyun.svideo.music.music.MusicAdapter.MusicViewHolder) com.aliyun.svideo.music.music.MusicChooseView.this.mAliyunMusicRecyclerView.findViewHolderForAdapterPosition(this.val$position), i2, this.val$position);
            }

            @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
            public void onStart(int i, long j, long j2, int i2) {
                super.onStart(i, j, j2, i2);
                if (com.aliyun.svideo.music.music.MusicChooseView.this.isLocalMusic) {
                    return;
                }
                com.aliyun.svideo.music.music.MusicChooseView.this.mMusicAdapter.notifyDownloadingStart(this.val$effectBody);
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.music.music.MusicAdapter.OnMusicSeek
        public void onSeekStop(long j) {
            com.aliyun.svideo.music.music.MusicChooseView.this.mPlayHandler.removeCallbacks(com.aliyun.svideo.music.music.MusicChooseView.this.mMusciRunnable);
            com.aliyun.svideo.music.music.MusicChooseView.this.mStartTime = (int) j;
            com.aliyun.svideo.music.music.MusicChooseView.this.mPlayHandler.postDelayed(com.aliyun.svideo.music.music.MusicChooseView.this.mMusciRunnable, 0L);
        }

        @Override // com.aliyun.svideo.music.music.MusicAdapter.OnMusicSeek
        public void onSelectMusic(int i, com.aliyun.svideo.music.music.EffectBody<com.aliyun.svideo.base.http.MusicFileBean> effectBody) {
            com.aliyun.svideo.base.http.MusicFileBean data = effectBody.getData();
            com.aliyun.svideo.music.music.MusicChooseView.this.mSelectMusic = data;
            com.aliyun.svideo.music.music.MusicChooseView.this.mSelectPosition = i;
            if (effectBody.isLocal()) {
                com.aliyun.svideo.music.music.MusicChooseView.this.onMusicSelected(data, i);
                return;
            }
            if (com.aliyun.svideo.music.music.MusicChooseView.this.mMediaPlayer != null && com.aliyun.svideo.music.music.MusicChooseView.this.mMediaPlayer.isPlaying()) {
                com.aliyun.svideo.music.music.MusicChooseView.this.mMediaPlayer.stop();
            }
            com.aliyun.svideo.music.music.MusicChooseView.this.musicLoader.downloadMusic(data, new com.aliyun.svideo.music.music.MusicChooseView.AnonymousClass2.AnonymousClass1(effectBody, i));
        }
    }

    /* renamed from: com.aliyun.svideo.music.music.MusicChooseView$3, reason: invalid class name */
    public class AnonymousClass3 extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
        public AnonymousClass3() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
            if (i != 0 || com.aliyun.svideo.music.music.MusicChooseView.this.isLocalMusic) {
                return;
            }
            androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = (androidx.recyclerview.widget.LinearLayoutManager) recyclerView.getLayoutManager();
            int itemCount = recyclerView.getAdapter().getItemCount();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            int childCount = recyclerView.getChildCount();
            if (findLastVisibleItemPosition <= itemCount - 5 || childCount <= 5) {
                return;
            }
            com.aliyun.svideo.music.music.MusicChooseView.this.musicLoader.loadMoreOnlineMusic();
        }
    }

    /* renamed from: com.aliyun.svideo.music.music.MusicChooseView$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (com.aliyun.svideo.music.music.MusicChooseView.class) {
                if (com.aliyun.svideo.music.music.MusicChooseView.this.isVisible) {
                    com.aliyun.svideo.music.music.MusicChooseView.this.mMediaPlayer.seekTo(com.aliyun.svideo.music.music.MusicChooseView.this.mStartTime);
                    com.aliyun.svideo.music.music.MusicChooseView.this.mMediaPlayer.start();
                    com.aliyun.svideo.music.music.MusicChooseView.this.mPlayHandler.postDelayed(this, com.aliyun.svideo.music.music.MusicChooseView.this.mLoopTime);
                }
            }
        }
    }

    /* renamed from: com.aliyun.svideo.music.music.MusicChooseView$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (com.aliyun.svideo.music.music.MusicChooseView.class) {
                if (com.aliyun.svideo.music.music.MusicChooseView.this.isVisible) {
                    com.aliyun.svideo.music.music.MusicChooseView.this.mMediaPlayer.start();
                }
            }
        }
    }

    /* renamed from: com.aliyun.svideo.music.music.MusicChooseView$6, reason: invalid class name */
    public class AnonymousClass6 extends android.text.style.ClickableSpan {
        public AnonymousClass6() {
        }

        @Override // android.text.style.ClickableSpan
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(@androidx.annotation.NonNull android.view.View view) {
            com.aliyun.svideo.music.music.MusicChooseView.this.getContext().startActivity(new android.content.Intent(com.aliyun.svideo.music.music.MusicChooseView.this.getContext(), (java.lang.Class<?>) com.aliyun.svideo.base.CopyrightWebActivity.class));
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public MusicChooseView(android.content.Context context) {
        super(context);
        this.mPlayHandler = new android.os.Handler(android.os.Looper.getMainLooper());
        this.mRecordTime = 10000;
        this.mLoopTime = 10000;
        this.isLocalMusic = false;
        this.mLocalMusicList = new java.util.ArrayList<>();
        this.mOnlineMusicList = new java.util.ArrayList<>();
        this.mMusciRunnable = new com.aliyun.svideo.music.music.MusicChooseView.AnonymousClass4();
        this.mStartRunnable = new com.aliyun.svideo.music.music.MusicChooseView.AnonymousClass5();
        init();
    }

    public MusicChooseView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPlayHandler = new android.os.Handler(android.os.Looper.getMainLooper());
        this.mRecordTime = 10000;
        this.mLoopTime = 10000;
        this.isLocalMusic = false;
        this.mLocalMusicList = new java.util.ArrayList<>();
        this.mOnlineMusicList = new java.util.ArrayList<>();
        this.mMusciRunnable = new com.aliyun.svideo.music.music.MusicChooseView.AnonymousClass4();
        this.mStartRunnable = new com.aliyun.svideo.music.music.MusicChooseView.AnonymousClass5();
        init();
    }

    public MusicChooseView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPlayHandler = new android.os.Handler(android.os.Looper.getMainLooper());
        this.mRecordTime = 10000;
        this.mLoopTime = 10000;
        this.isLocalMusic = false;
        this.mLocalMusicList = new java.util.ArrayList<>();
        this.mOnlineMusicList = new java.util.ArrayList<>();
        this.mMusciRunnable = new com.aliyun.svideo.music.music.MusicChooseView.AnonymousClass4();
        this.mStartRunnable = new com.aliyun.svideo.music.music.MusicChooseView.AnonymousClass5();
        init();
    }

    private android.text.SpannableString getClickalbeSpan() {
        java.lang.String string = getContext().getResources().getString(com.aliyun.svideo.music.R.string.alivc_music_copyright);
        java.lang.String string2 = getContext().getResources().getString(com.aliyun.svideo.music.R.string.alivc_music_copyright_link);
        int length = string.length();
        int length2 = string.length() + string2.length();
        android.text.SpannableString spannableString = new android.text.SpannableString(string + string2);
        spannableString.setSpan(new android.text.style.UnderlineSpan(), length, length2, 33);
        spannableString.setSpan(new com.aliyun.svideo.music.music.MusicChooseView.AnonymousClass6(), length, length2, 33);
        spannableString.setSpan(new android.text.style.ForegroundColorSpan(getContext().getResources().getColor(com.aliyun.svideo.music.R.color.alivc_common_cyan_light)), length, length2, 33);
        return spannableString;
    }

    private void init() {
        initView();
        initData();
    }

    private void initData() {
        if (this.musicLoader == null) {
            com.aliyun.svideo.music.music.MusicLoader musicLoader = new com.aliyun.svideo.music.music.MusicLoader(getContext());
            this.musicLoader = musicLoader;
            musicLoader.setCallback(new com.aliyun.svideo.music.music.MusicChooseView.AnonymousClass1());
            this.musicLoader.loadAllMusic();
        }
    }

    private void initView() {
        android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.music.R.layout.alivc_music_view_chooser_music, (android.view.ViewGroup) this, true);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.music.R.id.aliyun_back_btn);
        this.mAliyunBackBtn = imageView;
        imageView.setOnClickListener(this);
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.aliyun.svideo.music.R.id.aliyun_compelet_btn);
        this.mAliyunCompeletBtn = textView;
        textView.setOnClickListener(this);
        android.widget.TextView textView2 = (android.widget.TextView) findViewById(com.aliyun.svideo.music.R.id.aliyun_online_music);
        this.mAliyunOnlineMusic = textView2;
        textView2.setOnClickListener(this);
        android.widget.TextView textView3 = (android.widget.TextView) findViewById(com.aliyun.svideo.music.R.id.aliyun_local_music);
        this.mAliyunLocalMusic = textView3;
        textView3.setOnClickListener(this);
        this.mAliyunMusicRecyclerView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.music.R.id.aliyun_music_list);
        android.widget.TextView textView4 = (android.widget.TextView) findViewById(com.aliyun.svideo.music.R.id.alivc_music_copyright);
        this.mAlivcMusicCopyrightTV = textView4;
        textView4.setText(getClickalbeSpan());
        this.mAlivcMusicCopyrightTV.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        setFocusable(true);
        this.mAliyunMusicRecyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 1, false));
        if (this.mMusicAdapter == null) {
            com.aliyun.svideo.music.music.MusicAdapter musicAdapter = new com.aliyun.svideo.music.music.MusicAdapter();
            this.mMusicAdapter = musicAdapter;
            musicAdapter.setStreamDuration(this.mRecordTime);
            this.mMusicAdapter.setOnMusicSeekListener(new com.aliyun.svideo.music.music.MusicChooseView.AnonymousClass2());
        }
        this.mAliyunMusicRecyclerView.setAdapter(this.mMusicAdapter);
        this.mAliyunMusicRecyclerView.addOnScrollListener(new com.aliyun.svideo.music.music.MusicChooseView.AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMusicSelected(com.aliyun.svideo.base.http.MusicFileBean musicFileBean, int i) {
        if (this.mCachePosition != i) {
            this.mStartTime = 0;
        } else {
            this.mStartTime = this.mCacheStartTime;
        }
        if (this.mCacheIsLocalMusic != this.isLocalMusic) {
            this.mStartTime = 0;
        }
        try {
            if (this.isVisible) {
                prepareMusicInfo(musicFileBean);
                this.mMusicAdapter.notifyItemChanged(i);
                this.mMediaPlayer.setLooping(true);
                this.mPlayHandler.postDelayed(this.mMusciRunnable, 0L);
                return;
            }
            if (this.isShowed) {
                prepareMusicInfo(musicFileBean);
                this.mMusicAdapter.notifyItemChanged(i);
                this.mMediaPlayer.setLooping(true);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (java.lang.IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    private void prepareMusicInfo(com.aliyun.svideo.base.http.MusicFileBean musicFileBean) throws java.io.IOException, java.lang.IllegalStateException {
        this.mPlayHandler.removeCallbacks(this.mMusciRunnable);
        this.mMediaPlayer.reset();
        android.net.Uri parse = !android.text.TextUtils.isEmpty(musicFileBean.path) ? android.net.Uri.parse(musicFileBean.path) : null;
        if (!android.text.TextUtils.isEmpty(musicFileBean.uri)) {
            parse = android.net.Uri.parse(musicFileBean.uri);
        }
        if (parse == null) {
            return;
        }
        this.mMediaPlayer.setDataSource(getContext(), parse);
        this.mMediaPlayer.prepare();
        int duration = this.mMediaPlayer.getDuration();
        com.aliyun.svideo.base.http.MusicFileBean musicFileBean2 = this.mSelectMusic;
        if (musicFileBean2 != null) {
            musicFileBean2.duration = duration;
        }
        int i = this.mRecordTime;
        if (duration < i) {
            this.mLoopTime = duration;
        } else {
            this.mLoopTime = i;
        }
        musicFileBean.setDuration(duration);
    }

    private void selectLocalTab(int i) {
        this.mMusicAdapter.setData(this.mLocalMusicList, i);
        this.mAlivcMusicCopyrightTV.setVisibility(4);
        this.mAliyunOnlineMusic.setSelected(false);
        this.mAliyunLocalMusic.setSelected(true);
    }

    private void selectOnlineTab(int i) {
        this.mMusicAdapter.setData(this.mOnlineMusicList, i);
        this.mAlivcMusicCopyrightTV.setVisibility(0);
        this.mAliyunOnlineMusic.setSelected(true);
        this.mAliyunLocalMusic.setSelected(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        com.aliyun.svideo.music.music.MusicAdapter musicAdapter;
        com.aliyun.svideo.music.music.MusicAdapter musicAdapter2;
        super.onAttachedToWindow();
        this.mMediaPlayer = new android.media.MediaPlayer();
        this.mmr = new android.media.MediaMetadataRetriever();
        this.isViewAttached = true;
        setVisibleStatus(true);
        if (this.mCacheIsLocalMusic) {
            selectLocalTab(this.mCachePosition);
        } else {
            selectOnlineTab(this.mCachePosition);
        }
        boolean z = this.isShowed;
        if (!z || this.mCacheMusic == null || (musicAdapter2 = this.mMusicAdapter) == null) {
            if (!z || (musicAdapter = this.mMusicAdapter) == null) {
                return;
            }
            musicAdapter.notifySelectPosition(0, 0);
            this.mAliyunMusicRecyclerView.scrollToPosition(0);
            return;
        }
        musicAdapter2.notifySelectPosition(this.mCacheStartTime, this.mCachePosition);
        this.mAliyunMusicRecyclerView.scrollToPosition(this.mCachePosition);
        try {
            prepareMusicInfo(this.mCacheMusic);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        this.mMediaPlayer.setLooping(true);
        this.mPlayHandler.postDelayed(this.mMusciRunnable, 0L);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        if (view == this.mAliyunBackBtn) {
            com.aliyun.svideo.music.music.MusicSelectListener musicSelectListener = this.musicSelectListener;
            if (musicSelectListener != null) {
                musicSelectListener.onCancel();
                this.mSelectMusic = this.mCacheMusic;
                this.mStartTime = this.mCacheStartTime;
                this.mSelectPosition = this.mCachePosition;
                this.isLocalMusic = this.mCacheIsLocalMusic;
            }
        } else if (view == this.mAliyunCompeletBtn) {
            if (this.musicSelectListener != null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("log_music_start_time : ");
                sb.append(this.mStartTime);
                this.musicSelectListener.onMusicSelect(this.mSelectMusic, this.mStartTime);
                this.mCacheMusic = this.mSelectMusic;
                this.mCacheStartTime = this.mStartTime;
                this.mCachePosition = this.mSelectPosition;
                this.mCacheIsLocalMusic = this.isLocalMusic;
            }
        } else if (view == this.mAliyunOnlineMusic) {
            if (this.isLocalMusic) {
                this.isLocalMusic = false;
                selectOnlineTab(0);
            }
        } else if (view == this.mAliyunLocalMusic && !this.isLocalMusic) {
            this.isLocalMusic = true;
            selectLocalTab(0);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setVisibleStatus(false);
        this.isViewAttached = false;
        this.mPlayHandler.removeCallbacks(this.mMusciRunnable);
        this.mMediaPlayer.stop();
        this.mMediaPlayer.release();
        try {
            this.mmr.release();
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (i == 4) {
            this.mSelectMusic = this.mCacheMusic;
            this.mStartTime = this.mCacheStartTime;
            this.mSelectPosition = this.mCachePosition;
            this.isLocalMusic = this.mCacheIsLocalMusic;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void setMusicSelectListener(com.aliyun.svideo.music.music.MusicSelectListener musicSelectListener) {
        this.musicSelectListener = musicSelectListener;
    }

    public void setStreamDuration(int i) {
        this.mRecordTime = i;
        com.aliyun.svideo.music.music.MusicAdapter musicAdapter = this.mMusicAdapter;
        if (musicAdapter != null) {
            musicAdapter.setStreamDuration(i);
        }
    }

    public void setVisibleStatus(boolean z) {
        if (this.isViewAttached) {
            if (z) {
                if (this.mOnlineMusicList.isEmpty()) {
                    this.musicLoader.loadMoreOnlineMusic();
                }
                this.mPlayHandler.removeCallbacks(this.mStartRunnable);
                this.mPlayHandler.removeCallbacks(this.mMusciRunnable);
                this.mPlayHandler.postDelayed(this.mStartRunnable, 500L);
                this.mPlayHandler.postDelayed(this.mMusciRunnable, this.mLoopTime - this.playedTime);
                this.isShowed = true;
            } else {
                this.mPlayHandler.removeCallbacks(this.mStartRunnable);
                this.mPlayHandler.removeCallbacks(this.mMusciRunnable);
                if (this.mMediaPlayer.isPlaying()) {
                    this.playedTime = this.mMediaPlayer.getCurrentPosition() - this.mStartTime;
                    synchronized (com.aliyun.svideo.music.music.MusicChooseView.class) {
                        this.mMediaPlayer.pause();
                        this.isVisible = false;
                    }
                }
            }
        }
        this.isVisible = z;
    }
}
