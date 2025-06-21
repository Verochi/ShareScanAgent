package com.alimm.tanx.ui.image.glide.load.resource.transcode;

/* loaded from: classes.dex */
public class BitmapToGlideDrawableTranscoder implements com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<android.graphics.Bitmap, com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> {
    private final com.alimm.tanx.ui.image.glide.load.resource.transcode.GlideBitmapDrawableTranscoder glideBitmapDrawableTranscoder;

    public BitmapToGlideDrawableTranscoder(android.content.Context context) {
        this.glideBitmapDrawableTranscoder = new com.alimm.tanx.ui.image.glide.load.resource.transcode.GlideBitmapDrawableTranscoder(context);
    }

    public BitmapToGlideDrawableTranscoder(com.alimm.tanx.ui.image.glide.load.resource.transcode.GlideBitmapDrawableTranscoder glideBitmapDrawableTranscoder) {
        this.glideBitmapDrawableTranscoder = glideBitmapDrawableTranscoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public java.lang.String getId() {
        return this.glideBitmapDrawableTranscoder.getId();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> transcode(com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> resource) {
        return this.glideBitmapDrawableTranscoder.transcode(resource);
    }
}
