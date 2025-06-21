package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
final class DrawableToBitmapConverter {
    private static final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool NO_RECYCLE_BITMAP_POOL = new com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter.AnonymousClass1();
    private static final java.lang.String TAG = "DrawableToBitmap";

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter$1, reason: invalid class name */
    public class AnonymousClass1 extends com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
        public void put(android.graphics.Bitmap bitmap) {
        }
    }

    private DrawableToBitmapConverter() {
    }

    @androidx.annotation.Nullable
    public static com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> convert(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.drawable.Drawable drawable, int i, int i2) {
        android.graphics.Bitmap bitmap;
        android.graphics.drawable.Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof android.graphics.drawable.BitmapDrawable) {
            bitmap = ((android.graphics.drawable.BitmapDrawable) current).getBitmap();
        } else if (current instanceof android.graphics.drawable.Animatable) {
            bitmap = null;
        } else {
            bitmap = drawToBitmap(bitmapPool, current, i, i2);
            z = true;
        }
        if (!z) {
            bitmapPool = NO_RECYCLE_BITMAP_POOL;
        }
        return com.bumptech.glide.load.resource.bitmap.BitmapResource.obtain(bitmap, bitmapPool);
    }

    @androidx.annotation.Nullable
    private static android.graphics.Bitmap drawToBitmap(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.drawable.Drawable drawable, int i, int i2) {
        if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (android.util.Log.isLoggable(TAG, 5)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Unable to draw ");
                sb.append(drawable);
                sb.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        }
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (android.util.Log.isLoggable(TAG, 5)) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Unable to draw ");
                sb2.append(drawable);
                sb2.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        java.util.concurrent.locks.Lock bitmapDrawableLock = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock();
        bitmapDrawableLock.lock();
        android.graphics.Bitmap bitmap = bitmapPool.get(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
        try {
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap);
            drawable.setBounds(0, 0, i, i2);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return bitmap;
        } finally {
            bitmapDrawableLock.unlock();
        }
    }
}
