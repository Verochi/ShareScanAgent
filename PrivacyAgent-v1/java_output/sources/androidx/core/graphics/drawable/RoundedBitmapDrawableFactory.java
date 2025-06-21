package androidx.core.graphics.drawable;

/* loaded from: classes.dex */
public final class RoundedBitmapDrawableFactory {
    private static final java.lang.String TAG = "RoundedBitmapDrawableFa";

    public static class DefaultRoundedBitmapDrawable extends androidx.core.graphics.drawable.RoundedBitmapDrawable {
        public DefaultRoundedBitmapDrawable(android.content.res.Resources resources, android.graphics.Bitmap bitmap) {
            super(resources, bitmap);
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public void gravityCompatApply(int i, int i2, int i3, android.graphics.Rect rect, android.graphics.Rect rect2) {
            androidx.core.view.GravityCompat.apply(i, i2, i3, rect, rect2, 0);
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public boolean hasMipMap() {
            android.graphics.Bitmap bitmap = this.mBitmap;
            return bitmap != null && androidx.core.graphics.BitmapCompat.hasMipMap(bitmap);
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public void setMipMap(boolean z) {
            android.graphics.Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                androidx.core.graphics.BitmapCompat.setHasMipMap(bitmap, z);
                invalidateSelf();
            }
        }
    }

    private RoundedBitmapDrawableFactory() {
    }

    @androidx.annotation.NonNull
    public static androidx.core.graphics.drawable.RoundedBitmapDrawable create(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
        return new androidx.core.graphics.drawable.RoundedBitmapDrawable21(resources, bitmap);
    }

    @androidx.annotation.NonNull
    public static androidx.core.graphics.drawable.RoundedBitmapDrawable create(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.NonNull java.io.InputStream inputStream) {
        androidx.core.graphics.drawable.RoundedBitmapDrawable create = create(resources, android.graphics.BitmapFactory.decodeStream(inputStream));
        if (create.getBitmap() == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("RoundedBitmapDrawable cannot decode ");
            sb.append(inputStream);
        }
        return create;
    }

    @androidx.annotation.NonNull
    public static androidx.core.graphics.drawable.RoundedBitmapDrawable create(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.NonNull java.lang.String str) {
        androidx.core.graphics.drawable.RoundedBitmapDrawable create = create(resources, android.graphics.BitmapFactory.decodeFile(str));
        if (create.getBitmap() == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("RoundedBitmapDrawable cannot decode ");
            sb.append(str);
        }
        return create;
    }
}
