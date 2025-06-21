package com.aliyun.svideo.editor.editor.thumblinebar;

/* loaded from: classes12.dex */
public class ThumbRecyclerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter.ThumbnailViewHolder> {
    private static final java.lang.String TAG = "ThumbRecyclerAdapter";
    private static final int VIEW_TYPE_FOOTER = 2;
    private static final int VIEW_TYPE_HEADER = 1;
    private static final int VIEW_TYPE_THUMBNAIL = 3;
    private android.util.SparseArray<android.graphics.Bitmap> mCacheBitmaps = new android.util.SparseArray<>();
    private int mCount;
    private com.aliyun.svideosdk.common.AliyunIThumbnailFetcher mFetcher;
    private long mInterval;
    private final int mScreenWidth;

    /* renamed from: com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion {
        final /* synthetic */ com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter.ThumbnailViewHolder val$holder;
        final /* synthetic */ int val$position;
        private int vecIndex = 1;

        public AnonymousClass1(int i, com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter.ThumbnailViewHolder thumbnailViewHolder) {
            this.val$position = i;
            this.val$holder = thumbnailViewHolder;
        }

        @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion
        public void onError(int i) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("requestThumbnailImage error msg: ");
            sb.append(i);
        }

        @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion
        public void onThumbnailReady(android.graphics.Bitmap bitmap, long j, int i) {
            if (bitmap != null && !bitmap.isRecycled()) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("onThumbnailReady  put: ");
                sb.append(this.val$position);
                sb.append(" ,l = ");
                sb.append(j / 1000);
                this.val$holder.mIvThumbnail.setImageBitmap(bitmap);
                com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter.this.mCacheBitmaps.put(this.val$position, bitmap);
                return;
            }
            int i2 = this.val$position;
            if (i2 == 0) {
                this.vecIndex = 1;
            } else if (i2 == com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter.this.mCount + 1) {
                this.vecIndex = -1;
            }
            int i3 = this.val$position + this.vecIndex;
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("requestThumbnailImage  failure: thisPosition = ");
            sb2.append(this.val$position);
            sb2.append("newPosition = ");
            sb2.append(i3);
            com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter.this.requestFetchThumbnail(this.val$holder, i3);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion
        public void onError(int i) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("requestThumbnailImage error msg: ");
            sb.append(i);
        }

        @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion
        public void onThumbnailReady(android.graphics.Bitmap bitmap, long j, int i) {
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter.this.mCacheBitmaps.put(i, bitmap);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("缓存ThumbnailReady put，time = ");
            sb.append(j / 1000);
            sb.append(", position = ");
            sb.append(i);
        }
    }

    public class ThumbnailViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.widget.ImageView mIvThumbnail;

        public ThumbnailViewHolder(android.view.View view) {
            super(view);
        }
    }

    public ThumbRecyclerAdapter(int i, int i2, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher aliyunIThumbnailFetcher, int i3, int i4, int i5) {
        this.mInterval = 0L;
        this.mInterval = i2 / i;
        this.mFetcher = aliyunIThumbnailFetcher;
        this.mCount = i;
        this.mScreenWidth = i3;
        aliyunIThumbnailFetcher.setParameters(i4, i5, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.CropMode.Mediate, com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE, 1);
        this.mFetcher.setFastMode(true);
    }

    private void requestFetchThumbnail(int i) {
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < this.mCount; i2++) {
            long j = this.mInterval;
            jArr[i2] = (i2 * j) + (j / 2);
        }
        this.mFetcher.requestThumbnailImage(jArr, new com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter.AnonymousClass2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestFetchThumbnail(com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter.ThumbnailViewHolder thumbnailViewHolder, int i) {
        long j = this.mInterval;
        long[] jArr = {((i - 1) * j) + (j / 2)};
        android.graphics.Bitmap bitmap = this.mCacheBitmaps.get(i);
        if (bitmap != null && !bitmap.isRecycled()) {
            thumbnailViewHolder.mIvThumbnail.setImageBitmap(bitmap);
            return;
        }
        if (this.mCacheBitmaps.size() > 0) {
            int indexOfKey = this.mCacheBitmaps.indexOfKey(0);
            for (int i2 = 1; i2 < this.mCacheBitmaps.size(); i2++) {
                if (java.lang.Math.abs(this.mCacheBitmaps.keyAt(i2) - i) < java.lang.Math.abs(indexOfKey - i)) {
                    indexOfKey = this.mCacheBitmaps.keyAt(i2);
                }
            }
            if (indexOfKey > -1) {
                thumbnailViewHolder.mIvThumbnail.setImageBitmap(this.mCacheBitmaps.get(indexOfKey));
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("requestThumbnailImage() times :");
        sb.append(jArr[0]);
        sb.append(" ,position = ");
        sb.append(i);
        this.mFetcher.requestThumbnailImage(jArr, new com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter.AnonymousClass1(i, thumbnailViewHolder));
    }

    public void cacheBitmaps() {
        requestFetchThumbnail(this.mCount);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i = this.mCount;
        if (i == 0) {
            return 0;
        }
        return i + 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 1;
        }
        return i == this.mCount + 1 ? 2 : 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter.ThumbnailViewHolder thumbnailViewHolder, int i) {
        if (getItemViewType(i) != 3) {
            return;
        }
        if (this.mCacheBitmaps.get(i) == null) {
            if (this.mInterval == 0) {
                this.mInterval = this.mFetcher.getTotalDuration() / this.mCount;
            }
            requestFetchThumbnail(thumbnailViewHolder, i);
        } else {
            android.graphics.Bitmap bitmap = this.mCacheBitmaps.get(i);
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            thumbnailViewHolder.mIvThumbnail.setImageBitmap(bitmap);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter.ThumbnailViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == 1 || i == 2) {
            android.view.View view = new android.view.View(viewGroup.getContext());
            view.setLayoutParams(new android.view.ViewGroup.LayoutParams(this.mScreenWidth / 2, -1));
            view.setBackgroundColor(0);
            return new com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter.ThumbnailViewHolder(view);
        }
        android.view.View inflate = android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_timeline_thumbnail, viewGroup, false);
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter.ThumbnailViewHolder thumbnailViewHolder = new com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter.ThumbnailViewHolder(inflate);
        thumbnailViewHolder.mIvThumbnail = (android.widget.ImageView) inflate.findViewById(com.aliyun.svideo.editor.R.id.iv_thumbnail);
        return thumbnailViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter.ThumbnailViewHolder thumbnailViewHolder) {
        super.onViewRecycled((com.aliyun.svideo.editor.editor.thumblinebar.ThumbRecyclerAdapter) thumbnailViewHolder);
        android.widget.ImageView imageView = thumbnailViewHolder.mIvThumbnail;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
    }

    public void setData(int i, int i2, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher aliyunIThumbnailFetcher, int i3, int i4, int i5) {
        if (this.mInterval * i == i2 || this.mCacheBitmaps.size() == 0) {
            this.mInterval = i2 / i;
        } else {
            this.mCacheBitmaps.clear();
            cacheBitmaps();
        }
        this.mFetcher = aliyunIThumbnailFetcher;
        this.mCount = i;
        aliyunIThumbnailFetcher.setParameters(i4, i5, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.CropMode.Mediate, com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE, 1);
        this.mFetcher.setFastMode(true);
    }
}
