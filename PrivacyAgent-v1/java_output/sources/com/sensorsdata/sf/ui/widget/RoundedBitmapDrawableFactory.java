package com.sensorsdata.sf.ui.widget;

/* loaded from: classes19.dex */
public class RoundedBitmapDrawableFactory {
    private static final java.lang.String TAG = "RoundedBitmapDrawableFa";

    public static class DefaultRoundedBitmapDrawable extends com.sensorsdata.sf.ui.widget.RoundedBitmapDrawable {
        public DefaultRoundedBitmapDrawable(android.content.res.Resources resources, android.graphics.Bitmap bitmap, boolean z) {
            super(resources, bitmap, z);
        }

        public static boolean hasMipMap(android.graphics.Bitmap bitmap) {
            return bitmap.hasMipMap();
        }

        @Override // com.sensorsdata.sf.ui.widget.RoundedBitmapDrawable
        public void gravityCompatApply(int i, int i2, int i3, android.graphics.Rect rect, android.graphics.Rect rect2) {
            android.view.Gravity.apply(i, i2, i3, rect, rect2, 0);
        }

        @Override // com.sensorsdata.sf.ui.widget.RoundedBitmapDrawable
        public boolean hasMipMap() {
            android.graphics.Bitmap bitmap = this.mBitmap;
            return bitmap != null && hasMipMap(bitmap);
        }

        @Override // com.sensorsdata.sf.ui.widget.RoundedBitmapDrawable
        public void setMipMap(boolean z) {
            android.graphics.Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                bitmap.setHasMipMap(z);
                invalidateSelf();
            }
        }
    }

    private RoundedBitmapDrawableFactory() {
    }

    public static com.sensorsdata.sf.ui.widget.RoundedBitmapDrawable create(android.content.res.Resources resources, android.graphics.Bitmap bitmap, boolean z) {
        return new com.sensorsdata.sf.ui.widget.RoundedBitmapDrawable21(resources, bitmap, z);
    }

    public static com.sensorsdata.sf.ui.widget.RoundedBitmapDrawable create(android.content.res.Resources resources, java.io.InputStream inputStream, boolean z) {
        com.sensorsdata.sf.ui.widget.RoundedBitmapDrawable create = create(resources, android.graphics.BitmapFactory.decodeStream(inputStream), z);
        if (create.getBitmap() == null) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "RoundedBitmapDrawable cannot decode " + inputStream);
        }
        return create;
    }

    public static com.sensorsdata.sf.ui.widget.RoundedBitmapDrawable create(android.content.res.Resources resources, java.lang.String str, boolean z) {
        com.sensorsdata.sf.ui.widget.RoundedBitmapDrawable create = create(resources, android.graphics.BitmapFactory.decodeFile(str), z);
        if (create.getBitmap() == null) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "RoundedBitmapDrawable cannot decode " + str);
        }
        return create;
    }
}
