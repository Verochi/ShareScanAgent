package com.alimm.tanx.ui.image.util;

/* loaded from: classes.dex */
public class CircleCrop implements com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> {
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool mBitmapPool;

    public CircleCrop(android.content.Context context) {
        this(com.alimm.tanx.ui.image.glide.Glide.get(context).getBitmapPool());
    }

    public CircleCrop(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this.mBitmapPool = bitmapPool;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public java.lang.String getId() {
        return "CropCircleTransformation()";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> transform(com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> resource, int i, int i2) {
        android.graphics.Bitmap bitmap = resource.get();
        int min = java.lang.Math.min(bitmap.getWidth(), bitmap.getHeight());
        int width = (bitmap.getWidth() - min) / 2;
        int height = (bitmap.getHeight() - min) / 2;
        android.graphics.Bitmap bitmap2 = this.mBitmapPool.get(min, min, android.graphics.Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = android.graphics.Bitmap.createBitmap(min, min, android.graphics.Bitmap.Config.ARGB_8888);
        }
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap2);
        android.graphics.Paint paint = new android.graphics.Paint();
        android.graphics.Shader.TileMode tileMode = android.graphics.Shader.TileMode.CLAMP;
        android.graphics.BitmapShader bitmapShader = new android.graphics.BitmapShader(bitmap, tileMode, tileMode);
        if (width != 0 || height != 0) {
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.setTranslate(-width, -height);
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        float f = min / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        return com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource.obtain(bitmap2, this.mBitmapPool);
    }
}
