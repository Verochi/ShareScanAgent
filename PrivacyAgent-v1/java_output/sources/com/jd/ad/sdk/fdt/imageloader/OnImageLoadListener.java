package com.jd.ad.sdk.fdt.imageloader;

/* loaded from: classes23.dex */
public interface OnImageLoadListener {
    void onLoadFailed(int i, java.lang.String str, @androidx.annotation.Nullable android.graphics.drawable.Drawable drawable);

    void onLoadSuccess(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable);
}
