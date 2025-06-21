package com.airbnb.lottie.manager;

/* loaded from: classes.dex */
public class ImageAssetManager {
    public static final java.lang.Object e = new java.lang.Object();
    public final android.content.Context a;
    public java.lang.String b;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.ImageAssetDelegate c;
    public final java.util.Map<java.lang.String, com.airbnb.lottie.LottieImageAsset> d;

    public ImageAssetManager(android.graphics.drawable.Drawable.Callback callback, java.lang.String str, com.airbnb.lottie.ImageAssetDelegate imageAssetDelegate, java.util.Map<java.lang.String, com.airbnb.lottie.LottieImageAsset> map) {
        this.b = str;
        if (!android.text.TextUtils.isEmpty(str)) {
            if (this.b.charAt(r4.length() - 1) != '/') {
                this.b += '/';
            }
        }
        if (callback instanceof android.view.View) {
            this.a = ((android.view.View) callback).getContext();
            this.d = map;
            setDelegate(imageAssetDelegate);
        } else {
            com.airbnb.lottie.utils.Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.d = new java.util.HashMap();
            this.a = null;
        }
    }

    public final android.graphics.Bitmap a(java.lang.String str, @androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
        synchronized (e) {
            this.d.get(str).setBitmap(bitmap);
        }
        return bitmap;
    }

    @androidx.annotation.Nullable
    public android.graphics.Bitmap bitmapForId(java.lang.String str) {
        com.airbnb.lottie.LottieImageAsset lottieImageAsset = this.d.get(str);
        if (lottieImageAsset == null) {
            return null;
        }
        android.graphics.Bitmap bitmap = lottieImageAsset.getBitmap();
        if (bitmap != null) {
            return bitmap;
        }
        com.airbnb.lottie.ImageAssetDelegate imageAssetDelegate = this.c;
        if (imageAssetDelegate != null) {
            android.graphics.Bitmap fetchBitmap = imageAssetDelegate.fetchBitmap(lottieImageAsset);
            if (fetchBitmap != null) {
                a(str, fetchBitmap);
            }
            return fetchBitmap;
        }
        java.lang.String fileName = lottieImageAsset.getFileName();
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL;
        if (fileName.startsWith("data:") && fileName.indexOf("base64,") > 0) {
            try {
                byte[] decode = android.util.Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                return a(str, android.graphics.BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (java.lang.IllegalArgumentException e2) {
                com.airbnb.lottie.utils.Logger.warning("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (android.text.TextUtils.isEmpty(this.b)) {
                throw new java.lang.IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                return a(str, com.airbnb.lottie.utils.Utils.resizeBitmapIfNeeded(android.graphics.BitmapFactory.decodeStream(this.a.getAssets().open(this.b + fileName), null, options), lottieImageAsset.getWidth(), lottieImageAsset.getHeight()));
            } catch (java.lang.IllegalArgumentException e3) {
                com.airbnb.lottie.utils.Logger.warning("Unable to decode image.", e3);
                return null;
            }
        } catch (java.io.IOException e4) {
            com.airbnb.lottie.utils.Logger.warning("Unable to open asset.", e4);
            return null;
        }
    }

    public boolean hasSameContext(android.content.Context context) {
        return (context == null && this.a == null) || this.a.equals(context);
    }

    public void setDelegate(@androidx.annotation.Nullable com.airbnb.lottie.ImageAssetDelegate imageAssetDelegate) {
        this.c = imageAssetDelegate;
    }

    @androidx.annotation.Nullable
    public android.graphics.Bitmap updateBitmap(java.lang.String str, @androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
        if (bitmap != null) {
            android.graphics.Bitmap bitmap2 = this.d.get(str).getBitmap();
            a(str, bitmap);
            return bitmap2;
        }
        com.airbnb.lottie.LottieImageAsset lottieImageAsset = this.d.get(str);
        android.graphics.Bitmap bitmap3 = lottieImageAsset.getBitmap();
        lottieImageAsset.setBitmap(null);
        return bitmap3;
    }
}
