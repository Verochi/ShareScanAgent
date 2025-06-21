package com.alimm.tanx.ui.image.glide.load.resource.transcode;

/* loaded from: classes.dex */
public class GlideBitmapDrawableTranscoder implements com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<android.graphics.Bitmap, com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable> {
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final android.content.res.Resources resources;

    public GlideBitmapDrawableTranscoder(android.content.Context context) {
        this(context.getResources(), com.alimm.tanx.ui.image.glide.Glide.get(context).getBitmapPool());
    }

    public GlideBitmapDrawableTranscoder(android.content.res.Resources resources, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this.resources = resources;
        this.bitmapPool = bitmapPool;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public java.lang.String getId() {
        return "GlideBitmapDrawableTranscoder.com.alimm.tanx.ui.image.glide.load.resource.transcode";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable> transcode(com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> resource) {
        return new com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawableResource(new com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable(this.resources, resource.get()), this.bitmapPool);
    }
}
