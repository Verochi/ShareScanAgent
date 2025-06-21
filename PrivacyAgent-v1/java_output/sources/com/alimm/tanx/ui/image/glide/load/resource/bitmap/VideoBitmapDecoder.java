package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class VideoBitmapDecoder implements com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder<android.os.ParcelFileDescriptor> {
    private static final com.alimm.tanx.ui.image.glide.load.resource.bitmap.VideoBitmapDecoder.MediaMetadataRetrieverFactory DEFAULT_FACTORY = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.VideoBitmapDecoder.MediaMetadataRetrieverFactory();
    private static final int NO_FRAME = -1;
    private com.alimm.tanx.ui.image.glide.load.resource.bitmap.VideoBitmapDecoder.MediaMetadataRetrieverFactory factory;
    private int frame;

    public static class MediaMetadataRetrieverFactory {
        public android.media.MediaMetadataRetriever build() {
            return new android.media.MediaMetadataRetriever();
        }
    }

    public VideoBitmapDecoder() {
        this(DEFAULT_FACTORY, -1);
    }

    public VideoBitmapDecoder(int i) {
        this(DEFAULT_FACTORY, checkValidFrame(i));
    }

    public VideoBitmapDecoder(com.alimm.tanx.ui.image.glide.load.resource.bitmap.VideoBitmapDecoder.MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this.factory = mediaMetadataRetrieverFactory;
        this.frame = -1;
    }

    public VideoBitmapDecoder(com.alimm.tanx.ui.image.glide.load.resource.bitmap.VideoBitmapDecoder.MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory, int i) {
        this.factory = mediaMetadataRetrieverFactory;
        this.frame = i;
    }

    private static int checkValidFrame(int i) {
        if (i >= 0) {
            return i;
        }
        throw new java.lang.IllegalArgumentException("Requested frame must be non-negative");
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
    public android.graphics.Bitmap decode(android.os.ParcelFileDescriptor parcelFileDescriptor, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, int i, int i2, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) throws java.io.IOException {
        android.media.MediaMetadataRetriever build = this.factory.build();
        build.setDataSource(parcelFileDescriptor.getFileDescriptor());
        int i3 = this.frame;
        android.graphics.Bitmap frameAtTime = i3 >= 0 ? build.getFrameAtTime(i3) : build.getFrameAtTime();
        build.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
    public java.lang.String getId() {
        return "VideoBitmapDecoder.com.alimm.tanx.ui.image.glide.load.resource.bitmap";
    }
}
