package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class GalleryDirViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    private android.widget.TextView sortDirTxt;
    private android.widget.TextView sortFileNum;
    private android.widget.LinearLayout sortVideoLayout;
    private android.widget.ImageView thumbImage;
    private com.aliyun.svideo.media.ThumbnailGenerator thumbnailGenerator;

    /* renamed from: com.aliyun.svideo.media.GalleryDirViewHolder$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.media.ThumbnailGenerator.OnThumbnailGenerateListener {
        final /* synthetic */ com.aliyun.svideo.media.MediaDir val$dir;

        public AnonymousClass1(com.aliyun.svideo.media.MediaDir mediaDir) {
            this.val$dir = mediaDir;
        }

        @Override // com.aliyun.svideo.media.ThumbnailGenerator.OnThumbnailGenerateListener
        public void onThumbnailGenerate(int i, android.graphics.Bitmap bitmap) {
            com.aliyun.svideo.media.MediaDir mediaDir = this.val$dir;
            if (i == com.aliyun.svideo.media.ThumbnailGenerator.generateKey(mediaDir.type, mediaDir.id)) {
                com.aliyun.svideo.media.GalleryDirViewHolder.this.thumbImage.setImageBitmap(bitmap);
            }
        }
    }

    public GalleryDirViewHolder(android.view.View view, com.aliyun.svideo.media.ThumbnailGenerator thumbnailGenerator) {
        super(view);
        this.sortVideoLayout = (android.widget.LinearLayout) view.findViewById(com.aliyun.svideo.media.R.id.sort_video_layout);
        this.thumbImage = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.media.R.id.thumb_image);
        this.sortDirTxt = (android.widget.TextView) view.findViewById(com.aliyun.svideo.media.R.id.video_dir_name);
        this.sortFileNum = (android.widget.TextView) view.findViewById(com.aliyun.svideo.media.R.id.video_file_count);
        this.thumbnailGenerator = thumbnailGenerator;
        view.setTag(this);
    }

    public void setData(com.aliyun.svideo.media.MediaDir mediaDir) {
        this.sortDirTxt.setText(mediaDir.id == -1 ? this.sortDirTxt.getResources().getString(com.aliyun.svideo.media.R.string.alivc_media_gallery_all_media) : mediaDir.dirName);
        this.sortFileNum.setText(java.lang.String.valueOf(mediaDir.fileCount));
        if (mediaDir.thumbnailUrl == null) {
            this.thumbImage.setImageDrawable(new android.graphics.drawable.ColorDrawable(-7829368));
            this.thumbnailGenerator.generateThumbnail(mediaDir.type, mediaDir.id, mediaDir.resId, new com.aliyun.svideo.media.GalleryDirViewHolder.AnonymousClass1(mediaDir));
            return;
        }
        java.lang.String str = org.apache.tools.ant.taskdefs.XSLTLiaison.FILE_PROTOCOL_PREFIX + mediaDir.thumbnailUrl;
        if (this.thumbImage != null) {
            new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(this.thumbImage.getContext(), str).into(this.thumbImage);
        }
    }

    public void setFileCountWhenCompletion(int i) {
        this.sortFileNum.setText(java.lang.String.valueOf(i));
    }
}
