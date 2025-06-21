package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public final class jad_kx {
    public static final com.jd.ad.sdk.jad_ny.jad_er jad_an = new com.jd.ad.sdk.jad_te.jad_kx.jad_an();

    public class jad_an extends com.jd.ad.sdk.jad_ny.jad_fs {
        @Override // com.jd.ad.sdk.jad_ny.jad_fs, com.jd.ad.sdk.jad_ny.jad_er
        public void jad_an(android.graphics.Bitmap bitmap) {
        }
    }

    @androidx.annotation.Nullable
    public static com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_an(com.jd.ad.sdk.jad_ny.jad_er jad_erVar, android.graphics.drawable.Drawable drawable, int i, int i2) {
        android.graphics.Bitmap bitmap;
        android.graphics.drawable.Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof android.graphics.drawable.BitmapDrawable) {
            bitmap = ((android.graphics.drawable.BitmapDrawable) current).getBitmap();
        } else if (current instanceof android.graphics.drawable.Animatable) {
            bitmap = null;
        } else {
            if (i != Integer.MIN_VALUE || current.getIntrinsicWidth() > 0) {
                if (i2 != Integer.MIN_VALUE || current.getIntrinsicHeight() > 0) {
                    if (current.getIntrinsicWidth() > 0) {
                        i = current.getIntrinsicWidth();
                    }
                    if (current.getIntrinsicHeight() > 0) {
                        i2 = current.getIntrinsicHeight();
                    }
                    java.util.concurrent.locks.Lock lock = com.jd.ad.sdk.jad_te.jad_vi.jad_bo;
                    lock.lock();
                    android.graphics.Bitmap jad_an2 = jad_erVar.jad_an(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
                    try {
                        android.graphics.Canvas canvas = new android.graphics.Canvas(jad_an2);
                        current.setBounds(0, 0, i, i2);
                        current.draw(canvas);
                        canvas.setBitmap(null);
                        lock.unlock();
                        bitmap = jad_an2;
                        z = true;
                    } catch (java.lang.Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                } else if (android.util.Log.isLoggable("DrawableToBitmap", 5)) {
                    com.jd.ad.sdk.logger.Logger.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                }
            } else if (android.util.Log.isLoggable("DrawableToBitmap", 5)) {
                com.jd.ad.sdk.logger.Logger.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            bitmap = null;
            z = true;
        }
        if (!z) {
            jad_erVar = jad_an;
        }
        return com.jd.ad.sdk.jad_te.jad_er.jad_an(bitmap, jad_erVar);
    }
}
