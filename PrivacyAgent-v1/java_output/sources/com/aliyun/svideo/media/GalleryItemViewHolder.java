package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class GalleryItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    private android.widget.TextView duration;
    private android.view.View durationLayoput;
    private android.widget.ImageView mIvMask;
    private int mScreenWidth;
    private android.widget.ImageView thumbImage;
    private com.aliyun.svideo.media.ThumbnailGenerator thumbnailGenerator;

    /* renamed from: com.aliyun.svideo.media.GalleryItemViewHolder$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.media.ThumbnailGenerator.OnThumbnailGenerateListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.media.ThumbnailGenerator.OnThumbnailGenerateListener
        public void onThumbnailGenerate(int i, android.graphics.Bitmap bitmap) {
            if (i == ((java.lang.Integer) com.aliyun.svideo.media.GalleryItemViewHolder.this.thumbImage.getTag(com.aliyun.svideo.media.R.id.tag_first)).intValue()) {
                com.aliyun.svideo.media.GalleryItemViewHolder.this.thumbImage.setImageBitmap(bitmap);
            }
        }
    }

    public GalleryItemViewHolder(android.view.View view, com.aliyun.svideo.media.ThumbnailGenerator thumbnailGenerator) {
        super(view);
        this.mScreenWidth = view.getContext().getResources().getDisplayMetrics().widthPixels;
        this.thumbnailGenerator = thumbnailGenerator;
        this.thumbImage = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.media.R.id.draft_thumbnail);
        this.duration = (android.widget.TextView) view.findViewById(com.aliyun.svideo.media.R.id.draft_duration);
        this.durationLayoput = view.findViewById(com.aliyun.svideo.media.R.id.duration_layoput);
        this.mIvMask = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.media.R.id.iv_mask);
        view.setTag(this);
    }

    private boolean onCheckFileExists(java.lang.String str) {
        if (str == null) {
            return false;
        }
        return new java.io.File(str).exists();
    }

    private void onMetaDataUpdate(android.widget.TextView textView, int i) {
        if (i == 0) {
            return;
        }
        int round = java.lang.Math.round(i / 1000.0f);
        textView.setText(java.lang.String.format(java.lang.String.format("%d:%02d", java.lang.Integer.valueOf(round / 60), java.lang.Integer.valueOf(round % 60)), new java.lang.Object[0]));
    }

    public void onBind(com.aliyun.svideo.media.MediaInfo mediaInfo, boolean z, long j) {
        setData(mediaInfo, j);
        this.itemView.setActivated(z);
    }

    public void setData(com.aliyun.svideo.media.MediaInfo mediaInfo, long j) {
        java.lang.String str;
        java.lang.String str2;
        if (mediaInfo == null) {
            return;
        }
        this.thumbImage.setTag(com.aliyun.svideo.media.R.id.tag_first, java.lang.Integer.valueOf(com.aliyun.svideo.media.ThumbnailGenerator.generateKey(mediaInfo.type, mediaInfo.id)));
        this.mIvMask.setVisibility(8);
        java.lang.String str3 = mediaInfo.thumbnailPath;
        if (str3 != null && onCheckFileExists(str3)) {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                str2 = mediaInfo.fileUri;
            } else {
                str2 = org.apache.tools.ant.taskdefs.XSLTLiaison.FILE_PROTOCOL_PREFIX + mediaInfo.thumbnailPath;
            }
            com.aliyun.svideo.common.utils.image.ImageLoaderImpl imageLoaderImpl = new com.aliyun.svideo.common.utils.image.ImageLoaderImpl();
            android.content.Context context = this.thumbImage.getContext();
            com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder builder = new com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder();
            int i = this.mScreenWidth;
            imageLoaderImpl.loadImage(context, str2, builder.override(i / 5, i / 5).skipMemoryCache().placeholder(new android.graphics.drawable.ColorDrawable(-7829368)).build()).into(this.thumbImage);
        } else if (mediaInfo.type == 1) {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                str = mediaInfo.fileUri;
            } else {
                str = org.apache.tools.ant.taskdefs.XSLTLiaison.FILE_PROTOCOL_PREFIX + mediaInfo.filePath;
            }
            com.aliyun.svideo.common.utils.image.ImageLoaderImpl imageLoaderImpl2 = new com.aliyun.svideo.common.utils.image.ImageLoaderImpl();
            android.content.Context context2 = this.thumbImage.getContext();
            com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder builder2 = new com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder();
            int i2 = this.mScreenWidth;
            imageLoaderImpl2.loadImage(context2, str, builder2.override(i2 / 5, i2 / 5).skipMemoryCache().placeholder(new android.graphics.drawable.ColorDrawable(-7829368)).build()).into(this.thumbImage);
        } else {
            this.thumbImage.setImageDrawable(new android.graphics.drawable.ColorDrawable(-7829368));
            this.thumbnailGenerator.generateThumbnail(mediaInfo.type, mediaInfo.id, 0, new com.aliyun.svideo.media.GalleryItemViewHolder.AnonymousClass1());
        }
        int i3 = mediaInfo.duration;
        if (i3 == 0) {
            this.durationLayoput.setVisibility(8);
            return;
        }
        if (j != -1 && mediaInfo.type != 1 && i3 < j) {
            this.mIvMask.setVisibility(0);
        }
        this.durationLayoput.setVisibility(0);
        onMetaDataUpdate(this.duration, i3);
    }
}
