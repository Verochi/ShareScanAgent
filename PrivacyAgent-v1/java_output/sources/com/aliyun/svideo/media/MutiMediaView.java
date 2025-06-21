package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class MutiMediaView extends android.widget.FrameLayout {
    public static final int MODE_NORMAL = 0;
    public static final int MODE_TEMPLATE_IMPORT = 0;
    private static final java.lang.String TAG = "MutiMediaView";
    private com.aliyun.svideo.media.GalleryMediaChooser galleryMediaChooser;
    private android.widget.ImageButton mBackBtn;
    private android.widget.Button mBtnNextStep;
    private boolean mIsReachedMaxDuration;
    private com.aliyun.svideo.media.MediaStorage mMediaStorage;
    private int mMode;
    private com.aliyun.svideo.media.MutiMediaView.OnActionListener mOnActionListener;
    private android.view.View.OnClickListener mOnClickLister;
    private com.aliyun.svideo.media.MutiMediaView.OnMediaClickListener mOnMediaClickListener;
    private com.aliyun.svideo.media.MutiMediaView.OnSelectMediaChangeListener mOnSelectMediaChangeListener;
    private com.aliyun.svideo.media.MutiMediaView.OnTemplateActionListener mOnTemplateActionListener;
    private androidx.recyclerview.widget.RecyclerView mRvSelectedView;
    private com.aliyun.svideo.media.SelectedMediaAdapter mSelectedVideoAdapter;
    private com.aliyun.svideo.media.TemplateImportMediaAdapter mTemplateImportAdapter;
    private java.util.List<com.aliyun.svideo.media.MediaInfo> mTemplateImportData;
    private java.util.List<java.lang.Long> mTemplateParams;
    private com.aliyun.svideo.media.ThumbnailGenerator mThumbnailGenerator;
    private android.widget.TextView mTitleTv;
    private android.widget.TextView mTvTotalDuration;

    /* renamed from: com.aliyun.svideo.media.MutiMediaView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.media.MediaStorage.OnMediaDirChange {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.media.MediaStorage.OnMediaDirChange
        public void onMediaDirChanged() {
            com.aliyun.svideo.media.MediaDir currentDir = com.aliyun.svideo.media.MutiMediaView.this.mMediaStorage.getCurrentDir();
            if (currentDir.id == -1) {
                com.aliyun.svideo.media.MutiMediaView.this.mTitleTv.setText(com.aliyun.svideo.media.MutiMediaView.this.getContext().getString(com.aliyun.svideo.media.R.string.alivc_media_gallery_all_media));
            } else {
                com.aliyun.svideo.media.MutiMediaView.this.mTitleTv.setText(currentDir.dirName);
            }
            com.aliyun.svideo.media.MutiMediaView.this.galleryMediaChooser.changeMediaDir(currentDir);
        }
    }

    /* renamed from: com.aliyun.svideo.media.MutiMediaView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.media.MediaStorage.OnCompletion {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.media.MediaStorage.OnCompletion
        public void onCompletion() {
            com.aliyun.svideo.media.MediaDir currentDir = com.aliyun.svideo.media.MutiMediaView.this.mMediaStorage.getCurrentDir();
            if (currentDir == null || currentDir.id == -1) {
                return;
            }
            com.aliyun.svideo.media.MutiMediaView.this.mTitleTv.setText(currentDir.dirName);
            com.aliyun.svideo.media.MutiMediaView.this.galleryMediaChooser.changeMediaDir(currentDir);
        }
    }

    /* renamed from: com.aliyun.svideo.media.MutiMediaView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideo.media.MediaStorage.OnCurrentMediaInfoChange {
        public AnonymousClass3() {
        }

        @Override // com.aliyun.svideo.media.MediaStorage.OnCurrentMediaInfoChange
        public void onCurrentMediaInfoChanged(com.aliyun.svideo.media.MediaInfo mediaInfo) {
            if (com.aliyun.svideo.media.MutiMediaView.this.mOnMediaClickListener != null) {
                com.aliyun.svideo.media.MutiMediaView.this.mOnMediaClickListener.onClick(mediaInfo);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.media.MutiMediaView$4, reason: invalid class name */
    public class AnonymousClass4 implements com.aliyun.svideo.media.SelectedMediaAdapter.OnItemViewCallback {
        public AnonymousClass4() {
        }

        @Override // com.aliyun.svideo.media.SelectedMediaAdapter.OnItemViewCallback
        public void onDurationChange(long j, boolean z) {
            com.aliyun.svideo.media.MutiMediaView.this.mTvTotalDuration.setText(com.aliyun.svideo.media.MutiMediaView.this.convertDuration2Text(j));
            com.aliyun.svideo.media.MutiMediaView.this.mTvTotalDuration.setActivated(z);
            com.aliyun.svideo.media.MutiMediaView.this.mIsReachedMaxDuration = z;
        }

        @Override // com.aliyun.svideo.media.SelectedMediaAdapter.OnItemViewCallback
        public void onItemDeleteClick(com.aliyun.svideo.media.MediaInfo mediaInfo) {
            if (com.aliyun.svideo.media.MutiMediaView.this.mOnSelectMediaChangeListener != null) {
                com.aliyun.svideo.media.MutiMediaView.this.mOnSelectMediaChangeListener.onRemove(mediaInfo);
            }
        }

        @Override // com.aliyun.svideo.media.SelectedMediaAdapter.OnItemViewCallback
        public void onItemPhotoClick(com.aliyun.svideo.media.MediaInfo mediaInfo, int i) {
            if (com.aliyun.svideo.media.MutiMediaView.this.mOnSelectMediaChangeListener != null) {
                com.aliyun.svideo.media.MutiMediaView.this.mOnSelectMediaChangeListener.onClick(mediaInfo, i);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.media.MutiMediaView$5, reason: invalid class name */
    public class AnonymousClass5 implements com.aliyun.svideo.media.TemplateImportMediaAdapter.OnItemViewCallback {
        public AnonymousClass5() {
        }

        @Override // com.aliyun.svideo.media.TemplateImportMediaAdapter.OnItemViewCallback
        public void onDurationChange(long j) {
            com.aliyun.svideo.media.MutiMediaView.this.galleryMediaChooser.setMinDuration(j);
        }

        @Override // com.aliyun.svideo.media.TemplateImportMediaAdapter.OnItemViewCallback
        public void onFinish(java.util.List<com.aliyun.svideo.media.MediaInfo> list) {
            com.aliyun.svideo.media.MutiMediaView.this.mTemplateImportData.clear();
            com.aliyun.svideo.media.MutiMediaView.this.mTemplateImportData.addAll(list);
            com.aliyun.svideo.media.MutiMediaView.this.mBtnNextStep.setEnabled(true);
        }

        @Override // com.aliyun.svideo.media.TemplateImportMediaAdapter.OnItemViewCallback
        public void onItemDeleteClick(com.aliyun.svideo.media.MediaInfo mediaInfo) {
            com.aliyun.svideo.media.MutiMediaView.this.mBtnNextStep.setEnabled(false);
        }

        @Override // com.aliyun.svideo.media.TemplateImportMediaAdapter.OnItemViewCallback
        public void onItemPhotoClick(com.aliyun.svideo.media.MediaInfo mediaInfo, int i) {
        }
    }

    /* renamed from: com.aliyun.svideo.media.MutiMediaView$6, reason: invalid class name */
    public class AnonymousClass6 extends androidx.recyclerview.widget.ItemTouchHelper.Callback {
        public AnonymousClass6() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
            return androidx.recyclerview.widget.ItemTouchHelper.Callback.makeMovementFlags(12, 3);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isItemViewSwipeEnabled() {
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder2) {
            com.aliyun.svideo.media.MutiMediaView.this.mSelectedVideoAdapter.swap((com.aliyun.svideo.media.SelectedMediaViewHolder) viewHolder, (com.aliyun.svideo.media.SelectedMediaViewHolder) viewHolder2);
            if (com.aliyun.svideo.media.MutiMediaView.this.mOnSelectMediaChangeListener == null) {
                return false;
            }
            com.aliyun.svideo.media.MutiMediaView.this.mOnSelectMediaChangeListener.onSwap(recyclerView, viewHolder, viewHolder2);
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        }
    }

    /* renamed from: com.aliyun.svideo.media.MutiMediaView$7, reason: invalid class name */
    public class AnonymousClass7 implements android.view.View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (view == com.aliyun.svideo.media.MutiMediaView.this.mBackBtn) {
                if (com.aliyun.svideo.media.MutiMediaView.this.mOnActionListener != null) {
                    com.aliyun.svideo.media.MutiMediaView.this.mOnActionListener.onBack();
                }
                if (com.aliyun.svideo.media.MutiMediaView.this.mOnTemplateActionListener != null) {
                    com.aliyun.svideo.media.MutiMediaView.this.mOnTemplateActionListener.onBack();
                }
            } else if (view == com.aliyun.svideo.media.MutiMediaView.this.mBtnNextStep) {
                if (com.aliyun.svideo.media.MutiMediaView.this.mOnActionListener != null) {
                    com.aliyun.svideo.media.MutiMediaView.this.mOnActionListener.onNext(com.aliyun.svideo.media.MutiMediaView.this.mIsReachedMaxDuration);
                }
                if (com.aliyun.svideo.media.MutiMediaView.this.mOnTemplateActionListener != null) {
                    com.aliyun.svideo.media.MutiMediaView.this.mOnTemplateActionListener.onTemplateImport(com.aliyun.svideo.media.MutiMediaView.this.mTemplateImportData);
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface OnActionListener {
        void onBack();

        void onNext(boolean z);
    }

    public interface OnMediaClickListener {
        void onClick(com.aliyun.svideo.media.MediaInfo mediaInfo);
    }

    public interface OnSelectMediaChangeListener {
        void onClick(com.aliyun.svideo.media.MediaInfo mediaInfo, int i);

        void onRemove(com.aliyun.svideo.media.MediaInfo mediaInfo);

        void onSwap(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder2);
    }

    public interface OnTemplateActionListener {
        void onBack();

        void onTemplateImport(java.util.List<com.aliyun.svideo.media.MediaInfo> list);
    }

    public MutiMediaView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public MutiMediaView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MutiMediaView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTemplateImportData = new java.util.ArrayList();
        this.mMode = 0;
        this.mTemplateParams = new java.util.ArrayList();
        this.mOnClickLister = new com.aliyun.svideo.media.MutiMediaView.AnonymousClass7();
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String convertDuration2Text(long j) {
        int round = java.lang.Math.round(j / 1000.0f);
        return java.lang.String.format(getContext().getString(com.aliyun.svideo.media.R.string.alivc_media_video_duration), java.lang.Integer.valueOf(round / com.anythink.expressad.d.a.b.ck), java.lang.Integer.valueOf((round % com.anythink.expressad.d.a.b.ck) / 60), java.lang.Integer.valueOf(round % 60));
    }

    private void init() {
        android.view.View.inflate(getContext(), com.aliyun.svideo.media.R.layout.alivc_media_activity_media_import, this);
        this.mBtnNextStep = (android.widget.Button) findViewById(com.aliyun.svideo.media.R.id.btn_next_step);
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.aliyun.svideo.media.R.id.gallery_title);
        this.mTitleTv = textView;
        textView.setText(com.aliyun.svideo.media.R.string.alivc_media_gallery_all_media);
        this.mBackBtn = (android.widget.ImageButton) findViewById(com.aliyun.svideo.media.R.id.gallery_closeBtn);
        android.widget.Button button = this.mBtnNextStep;
        if (button != null) {
            button.setOnClickListener(this.mOnClickLister);
        }
        this.mBackBtn.setOnClickListener(this.mOnClickLister);
        this.mMediaStorage = new com.aliyun.svideo.media.MediaStorage(getContext(), new com.aliyun.svideo.media.JsonExtend.JSONSupportImpl());
        this.mThumbnailGenerator = new com.aliyun.svideo.media.ThumbnailGenerator(getContext());
        this.galleryMediaChooser = new com.aliyun.svideo.media.GalleryMediaChooser((androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.media.R.id.gallery_media), new com.aliyun.svideo.media.GalleryDirChooser(getContext(), findViewById(com.aliyun.svideo.media.R.id.topPanel), this.mThumbnailGenerator, this.mMediaStorage), this.mMediaStorage, this.mThumbnailGenerator);
        this.mMediaStorage.setOnMediaDirChangeListener(new com.aliyun.svideo.media.MutiMediaView.AnonymousClass1());
        this.mMediaStorage.setOnCompletionListener(new com.aliyun.svideo.media.MutiMediaView.AnonymousClass2());
        this.mMediaStorage.setOnCurrentMediaInfoChangeListener(new com.aliyun.svideo.media.MutiMediaView.AnonymousClass3());
        android.widget.TextView textView2 = (android.widget.TextView) findViewById(com.aliyun.svideo.media.R.id.tv_duration_value);
        this.mTvTotalDuration = textView2;
        textView2.setText(convertDuration2Text(0L));
        this.mTvTotalDuration.setActivated(false);
    }

    public void addOnlyFirstMedia(com.aliyun.svideo.media.MediaInfo mediaInfo) {
        this.mSelectedVideoAdapter.addOnlyFirstMedia(mediaInfo);
    }

    public void addSelectMedia(com.aliyun.svideo.media.MediaInfo mediaInfo) {
        com.aliyun.svideo.media.SelectedMediaAdapter selectedMediaAdapter = this.mSelectedVideoAdapter;
        if (selectedMediaAdapter != null) {
            selectedMediaAdapter.addMedia(mediaInfo);
            return;
        }
        com.aliyun.svideo.media.TemplateImportMediaAdapter templateImportMediaAdapter = this.mTemplateImportAdapter;
        if (templateImportMediaAdapter != null) {
            templateImportMediaAdapter.putData(mediaInfo);
        }
    }

    public void changeDurationPosition(int i, long j) {
        this.mSelectedVideoAdapter.changeDurationPosition(i, j);
    }

    public void enableSelectView(long j) {
        if (this.mRvSelectedView == null) {
            findViewById(com.aliyun.svideo.media.R.id.rl_select).setVisibility(0);
            this.mRvSelectedView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.media.R.id.rv_selected_video);
            if (j == 0) {
                j = 2147483647L;
            }
            com.aliyun.svideo.media.SelectedMediaAdapter selectedMediaAdapter = new com.aliyun.svideo.media.SelectedMediaAdapter(new com.aliyun.svideo.media.MediaImageLoader(getContext()), j);
            this.mSelectedVideoAdapter = selectedMediaAdapter;
            this.mRvSelectedView.setAdapter(selectedMediaAdapter);
            this.mRvSelectedView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
            this.mSelectedVideoAdapter.setItemViewCallback(new com.aliyun.svideo.media.MutiMediaView.AnonymousClass4());
        }
    }

    public void enableSwap() {
        if (this.mRvSelectedView == null) {
            return;
        }
        new androidx.recyclerview.widget.ItemTouchHelper(new com.aliyun.svideo.media.MutiMediaView.AnonymousClass6()).attachToRecyclerView(this.mRvSelectedView);
    }

    public void enableTemplateImportView(java.util.List<java.lang.Long> list) {
        if (list == null || list.isEmpty() || this.mRvSelectedView != null) {
            return;
        }
        this.mBtnNextStep.setEnabled(false);
        ((android.widget.TextView) findViewById(com.aliyun.svideo.media.R.id.tv_duration_title)).setText(getResources().getString(com.aliyun.svideo.media.R.string.alivc_media_video_template_import, java.lang.Integer.valueOf(list.size())));
        this.mTvTotalDuration.setVisibility(8);
        findViewById(com.aliyun.svideo.media.R.id.rl_select).setVisibility(0);
        this.mRvSelectedView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.media.R.id.rv_selected_video);
        com.aliyun.svideo.media.TemplateImportMediaAdapter templateImportMediaAdapter = new com.aliyun.svideo.media.TemplateImportMediaAdapter(new com.aliyun.svideo.media.MediaImageLoader(getContext()));
        this.mTemplateImportAdapter = templateImportMediaAdapter;
        templateImportMediaAdapter.setTemplateParams(list);
        this.mRvSelectedView.setAdapter(this.mTemplateImportAdapter);
        this.mRvSelectedView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        this.mTemplateImportAdapter.setItemViewCallback(new com.aliyun.svideo.media.MutiMediaView.AnonymousClass5());
        this.galleryMediaChooser.setMinDuration(list.get(0).longValue());
    }

    public void enableTemplateReplace(long j) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(java.lang.Long.valueOf(j));
        enableTemplateImportView(arrayList);
        findViewById(com.aliyun.svideo.media.R.id.rl_select).setVisibility(8);
    }

    public com.aliyun.svideo.media.MediaInfo getOnlyOneMedia() {
        return this.mSelectedVideoAdapter.getOnlyOneMedia();
    }

    public void loadMedia() {
        try {
            this.mMediaStorage.startFetchMedias();
        } catch (java.lang.SecurityException unused) {
            com.aliyun.svideo.common.utils.ToastUtils.show(getContext(), getResources().getString(com.aliyun.svideo.media.R.string.alivc_common_no_permission));
        }
    }

    public void onDestroy() {
        this.mMediaStorage.saveCurrentDirToCache();
        this.mMediaStorage.cancelTask();
        this.mThumbnailGenerator.cancelAllTask();
    }

    public void setMediaSortMode(int i) {
        this.mMediaStorage.setSortMode(i);
    }

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setNextEnable(boolean z) {
        this.mBtnNextStep.setEnabled(z);
    }

    public void setOnActionListener(com.aliyun.svideo.media.MutiMediaView.OnActionListener onActionListener) {
        this.mOnActionListener = onActionListener;
    }

    public void setOnMediaClickListener(com.aliyun.svideo.media.MutiMediaView.OnMediaClickListener onMediaClickListener) {
        this.mOnMediaClickListener = onMediaClickListener;
    }

    public void setOnSelectMediaChangeListener(com.aliyun.svideo.media.MutiMediaView.OnSelectMediaChangeListener onSelectMediaChangeListener) {
        this.mOnSelectMediaChangeListener = onSelectMediaChangeListener;
    }

    public void setOnTemplateActionListener(com.aliyun.svideo.media.MutiMediaView.OnTemplateActionListener onTemplateActionListener) {
        this.mOnTemplateActionListener = onTemplateActionListener;
    }

    public void setVideoDurationRange(int i, int i2) {
        this.mMediaStorage.setVideoDurationRange(i, i2);
    }
}
