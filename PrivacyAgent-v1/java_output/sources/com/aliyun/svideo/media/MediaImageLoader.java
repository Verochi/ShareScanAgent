package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class MediaImageLoader {
    private com.aliyun.svideo.media.ThumbnailGenerator mThumbnailGenerator;

    /* renamed from: com.aliyun.svideo.media.MediaImageLoader$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.media.ThumbnailGenerator.OnThumbnailGenerateListener {
        final /* synthetic */ com.aliyun.svideo.media.MediaInfo val$info;
        final /* synthetic */ android.widget.ImageView val$view;

        public AnonymousClass1(com.aliyun.svideo.media.MediaInfo mediaInfo, android.widget.ImageView imageView) {
            this.val$info = mediaInfo;
            this.val$view = imageView;
        }

        @Override // com.aliyun.svideo.media.ThumbnailGenerator.OnThumbnailGenerateListener
        public void onThumbnailGenerate(int i, android.graphics.Bitmap bitmap) {
            com.aliyun.svideo.media.MediaInfo mediaInfo = this.val$info;
            if (i == com.aliyun.svideo.media.ThumbnailGenerator.generateKey(mediaInfo.type, mediaInfo.id)) {
                this.val$view.setImageBitmap(bitmap);
            }
        }
    }

    public MediaImageLoader(android.content.Context context) {
        this.mThumbnailGenerator = new com.aliyun.svideo.media.ThumbnailGenerator(context);
    }

    private boolean onCheckFileExistence(java.lang.String str) {
        if (str == null) {
            return false;
        }
        return new java.io.File(str).exists();
    }

    public void displayImage(com.aliyun.svideo.media.MediaInfo mediaInfo, android.widget.ImageView imageView) {
        java.lang.String str;
        java.lang.String str2 = mediaInfo.thumbnailPath;
        if (str2 == null || !onCheckFileExistence(str2)) {
            imageView.setImageDrawable(new android.graphics.drawable.ColorDrawable(-7829368));
            this.mThumbnailGenerator.generateThumbnail(mediaInfo.type, mediaInfo.id, 0, new com.aliyun.svideo.media.MediaImageLoader.AnonymousClass1(mediaInfo, imageView));
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            str = mediaInfo.fileUri;
        } else {
            str = org.apache.tools.ant.taskdefs.XSLTLiaison.FILE_PROTOCOL_PREFIX + mediaInfo.thumbnailPath;
        }
        new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(imageView.getContext(), str).into(imageView);
    }
}
