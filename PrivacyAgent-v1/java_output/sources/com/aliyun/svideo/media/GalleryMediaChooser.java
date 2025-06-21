package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class GalleryMediaChooser {
    private com.aliyun.svideo.media.GalleryAdapter adapter;
    private androidx.recyclerview.widget.RecyclerView mGallery;
    private com.aliyun.svideo.media.MediaStorage mStorage;

    /* renamed from: com.aliyun.svideo.media.GalleryMediaChooser$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.media.MediaStorage.OnMediaDataUpdate {
        final /* synthetic */ com.aliyun.svideo.media.GalleryDirChooser val$dirChooser;

        public AnonymousClass1(com.aliyun.svideo.media.GalleryDirChooser galleryDirChooser) {
            this.val$dirChooser = galleryDirChooser;
        }

        @Override // com.aliyun.svideo.media.MediaStorage.OnMediaDataUpdate
        public void onDataUpdate(java.util.List<com.aliyun.svideo.media.MediaInfo> list) {
            int itemCount = com.aliyun.svideo.media.GalleryMediaChooser.this.adapter.getItemCount();
            int size = list.size();
            com.aliyun.svideo.media.GalleryMediaChooser.this.adapter.notifyItemRangeInserted(itemCount - size, size);
            if (size == 5 || com.aliyun.svideo.media.GalleryMediaChooser.this.mStorage.getMedias().size() < 5) {
                com.aliyun.svideo.media.GalleryMediaChooser.this.selectedFirstMediaOnAll(list);
            }
            this.val$dirChooser.setAllGalleryCount(com.aliyun.svideo.media.GalleryMediaChooser.this.mStorage.getMedias().size());
        }
    }

    /* renamed from: com.aliyun.svideo.media.GalleryMediaChooser$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.media.GalleryAdapter.OnItemClickListener {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.media.GalleryAdapter.OnItemClickListener
        public boolean onItemClick(com.aliyun.svideo.media.GalleryAdapter galleryAdapter, int i) {
            com.aliyun.svideo.media.MediaInfo item;
            if (galleryAdapter.getItemCount() <= i || (item = galleryAdapter.getItem(i)) == null) {
                return true;
            }
            com.aliyun.svideo.media.GalleryMediaChooser.this.mStorage.setCurrentDisplayMediaData(item);
            return true;
        }
    }

    /* renamed from: com.aliyun.svideo.media.GalleryMediaChooser$3, reason: invalid class name */
    public class AnonymousClass3 extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
        public AnonymousClass3() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
            ((androidx.recyclerview.widget.GridLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        }
    }

    /* renamed from: com.aliyun.svideo.media.GalleryMediaChooser$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnTouchListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            return false;
        }
    }

    public GalleryMediaChooser(androidx.recyclerview.widget.RecyclerView recyclerView, com.aliyun.svideo.media.GalleryDirChooser galleryDirChooser, com.aliyun.svideo.media.MediaStorage mediaStorage, com.aliyun.svideo.media.ThumbnailGenerator thumbnailGenerator) {
        this.mGallery = recyclerView;
        recyclerView.addItemDecoration(new com.aliyun.svideo.media.GalleryItemDecoration());
        this.mStorage = mediaStorage;
        this.adapter = new com.aliyun.svideo.media.GalleryAdapter(thumbnailGenerator);
        recyclerView.setLayoutManager(new com.aliyun.svideo.media.WrapContentGridLayoutManager(recyclerView.getContext(), 4, 1, false));
        recyclerView.setAdapter(this.adapter);
        this.adapter.setData(mediaStorage.getMedias());
        mediaStorage.setOnMediaDataUpdateListener(new com.aliyun.svideo.media.GalleryMediaChooser.AnonymousClass1(galleryDirChooser));
        this.adapter.setOnItemClickListener(new com.aliyun.svideo.media.GalleryMediaChooser.AnonymousClass2());
        this.mGallery.addOnScrollListener(new com.aliyun.svideo.media.GalleryMediaChooser.AnonymousClass3());
        this.mGallery.setOnTouchListener(new com.aliyun.svideo.media.GalleryMediaChooser.AnonymousClass4());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectedFirstMediaOnAll(java.util.List<com.aliyun.svideo.media.MediaInfo> list) {
        if (list.size() == 0) {
            return;
        }
        this.adapter.setActiveDataItem(list.get(0));
    }

    public void changeMediaDir(com.aliyun.svideo.media.MediaDir mediaDir) {
        if (mediaDir.id == -1) {
            this.adapter.setData(this.mStorage.getMedias());
            selectedFirstMediaOnAll(this.mStorage.getMedias());
        } else {
            this.adapter.setData(this.mStorage.findMediaByDir(mediaDir));
            selectedFirstMediaOnAll(this.mStorage.findMediaByDir(mediaDir));
        }
    }

    public void setCurrentMediaInfoActived() {
        this.mGallery.smoothScrollToPosition(this.adapter.setActiveDataItem(this.mStorage.getCurrentMedia()));
    }

    public void setMinDuration(long j) {
        this.adapter.setMinDuration(j);
    }
}
