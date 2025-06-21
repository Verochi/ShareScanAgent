package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class GalleryDirChooser {
    private com.aliyun.svideo.media.GalleryDirAdapter adapter;
    private android.view.View anchor;
    private boolean isShowGalleryDir;
    private android.app.Activity mActivity;
    private android.widget.PopupWindow popupWindow;

    /* renamed from: com.aliyun.svideo.media.GalleryDirChooser$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ com.aliyun.svideo.media.MediaStorage val$storage;

        public AnonymousClass1(com.aliyun.svideo.media.MediaStorage mediaStorage) {
            this.val$storage = mediaStorage;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (this.val$storage.isActive()) {
                com.aliyun.svideo.media.GalleryDirChooser.this.showOrHideGalleryDir();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.media.GalleryDirChooser$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.media.MediaStorage.OnMediaDirUpdate {

        /* renamed from: com.aliyun.svideo.media.GalleryDirChooser$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.media.GalleryDirChooser.this.adapter.notifyDataSetChanged();
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.media.MediaStorage.OnMediaDirUpdate
        public void onDirUpdate(com.aliyun.svideo.media.MediaDir mediaDir) {
            com.aliyun.svideo.media.GalleryDirChooser.this.anchor.post(new com.aliyun.svideo.media.GalleryDirChooser.AnonymousClass2.AnonymousClass1());
        }
    }

    /* renamed from: com.aliyun.svideo.media.GalleryDirChooser$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideo.media.GalleryDirAdapter.OnItemClickListener {
        final /* synthetic */ com.aliyun.svideo.media.MediaStorage val$storage;

        public AnonymousClass3(com.aliyun.svideo.media.MediaStorage mediaStorage) {
            this.val$storage = mediaStorage;
        }

        @Override // com.aliyun.svideo.media.GalleryDirAdapter.OnItemClickListener
        public boolean onItemClick(com.aliyun.svideo.media.GalleryDirAdapter galleryDirAdapter, int i) {
            com.aliyun.svideo.media.MediaDir item = galleryDirAdapter.getItem(i);
            com.aliyun.svideo.media.GalleryDirChooser.this.showOrHideGalleryDir();
            this.val$storage.setCurrentDir(item);
            return false;
        }
    }

    public GalleryDirChooser(android.content.Context context, android.view.View view, com.aliyun.svideo.media.ThumbnailGenerator thumbnailGenerator, com.aliyun.svideo.media.MediaStorage mediaStorage) {
        this.anchor = view;
        this.mActivity = (android.app.Activity) context;
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) android.view.View.inflate(context, com.aliyun.svideo.media.R.layout.alivc_meida_ppw_container_gallery_dir, null);
        this.adapter = new com.aliyun.svideo.media.GalleryDirAdapter(thumbnailGenerator);
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(context, 1, false));
        recyclerView.setAdapter(this.adapter);
        ((androidx.recyclerview.widget.SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.adapter.setData(mediaStorage.getDirs());
        android.widget.PopupWindow popupWindow = new android.widget.PopupWindow(recyclerView, -1, -2);
        this.popupWindow = popupWindow;
        popupWindow.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(context.getResources().getColor(com.aliyun.svideo.media.R.color.alivc_common_bg_white)));
        this.popupWindow.setOutsideTouchable(true);
        view.setOnClickListener(new com.aliyun.svideo.media.GalleryDirChooser.AnonymousClass1(mediaStorage));
        mediaStorage.setOnMediaDirUpdateListener(new com.aliyun.svideo.media.GalleryDirChooser.AnonymousClass2());
        this.adapter.setOnItemClickListener(new com.aliyun.svideo.media.GalleryDirChooser.AnonymousClass3(mediaStorage));
    }

    public boolean isShowGalleryDir() {
        return this.isShowGalleryDir;
    }

    public void setAllGalleryCount(int i) {
        this.adapter.setAllFileCount(i);
    }

    @android.annotation.TargetApi(17)
    public void showOrHideGalleryDir() {
        if (this.mActivity.isDestroyed()) {
            return;
        }
        if (this.isShowGalleryDir) {
            this.popupWindow.dismiss();
        } else if (android.os.Build.VERSION.SDK_INT < 24) {
            this.popupWindow.showAsDropDown(this.anchor);
        } else {
            android.graphics.Rect rect = new android.graphics.Rect();
            this.anchor.getGlobalVisibleRect(rect);
            this.popupWindow.setHeight(this.anchor.getResources().getDisplayMetrics().heightPixels - rect.bottom);
            this.popupWindow.showAsDropDown(this.anchor, 0, 0);
        }
        boolean z = !this.isShowGalleryDir;
        this.isShowGalleryDir = z;
        this.anchor.setActivated(z);
    }
}
