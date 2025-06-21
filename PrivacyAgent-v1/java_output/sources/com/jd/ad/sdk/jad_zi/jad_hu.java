package com.jd.ad.sdk.jad_zi;

/* loaded from: classes23.dex */
public class jad_hu implements com.jd.ad.sdk.mdt.service.JADFoundationService {

    public class jad_an extends com.jd.ad.sdk.jad_fo.jad_an<android.graphics.drawable.Drawable> {
        public final /* synthetic */ com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener jad_dq;

        public jad_an(com.jd.ad.sdk.jad_zi.jad_hu jad_huVar, com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener onImageLoadListener) {
            this.jad_dq = onImageLoadListener;
        }

        @Override // com.jd.ad.sdk.jad_fo.jad_er
        public void jad_an(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            com.jd.ad.sdk.logger.Logger.d("preload 加载图片 onLoadCleared");
        }

        @Override // com.jd.ad.sdk.jad_fo.jad_er
        public void jad_an(@androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.Nullable com.jd.ad.sdk.jad_gp.jad_bo jad_boVar) {
            android.graphics.drawable.Drawable drawable = (android.graphics.drawable.Drawable) obj;
            com.jd.ad.sdk.logger.Logger.d("preload 加载图片 onResourceReady");
            com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener onImageLoadListener = this.jad_dq;
            if (onImageLoadListener != null) {
                onImageLoadListener.onLoadSuccess(drawable);
            }
        }

        @Override // com.jd.ad.sdk.jad_fo.jad_an, com.jd.ad.sdk.jad_fo.jad_er
        public void jad_cp(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            com.jd.ad.sdk.logger.Logger.d("preload 加载图片 onLoadFailed");
            com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener onImageLoadListener = this.jad_dq;
            if (onImageLoadListener != null) {
                onImageLoadListener.onLoadFailed(-1, "load error", drawable);
            }
        }
    }

    public class jad_bo implements com.jd.ad.sdk.jad_en.jad_jt<android.graphics.drawable.Drawable> {
        public jad_bo(com.jd.ad.sdk.jad_zi.jad_hu jad_huVar) {
        }

        @Override // com.jd.ad.sdk.jad_en.jad_jt
        public boolean jad_an(@androidx.annotation.Nullable com.jd.ad.sdk.jad_mx.jad_sf jad_sfVar, java.lang.Object obj, com.jd.ad.sdk.jad_fo.jad_er<android.graphics.drawable.Drawable> jad_erVar, boolean z) {
            com.jd.ad.sdk.logger.Logger.d("preload 加载图片 失败");
            return false;
        }

        @Override // com.jd.ad.sdk.jad_en.jad_jt
        public boolean jad_an(android.graphics.drawable.Drawable drawable, java.lang.Object obj, com.jd.ad.sdk.jad_fo.jad_er<android.graphics.drawable.Drawable> jad_erVar, com.jd.ad.sdk.jad_ju.jad_an jad_anVar, boolean z) {
            com.jd.ad.sdk.logger.Logger.d("preload 加载图片 成功");
            return false;
        }
    }

    public class jad_cp implements com.jd.ad.sdk.jad_en.jad_jt<android.graphics.drawable.Drawable> {
        public final /* synthetic */ com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener jad_an;

        public jad_cp(com.jd.ad.sdk.jad_zi.jad_hu jad_huVar, com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener onImageLoadListener) {
            this.jad_an = onImageLoadListener;
        }

        @Override // com.jd.ad.sdk.jad_en.jad_jt
        public boolean jad_an(@androidx.annotation.Nullable com.jd.ad.sdk.jad_mx.jad_sf jad_sfVar, java.lang.Object obj, com.jd.ad.sdk.jad_fo.jad_er<android.graphics.drawable.Drawable> jad_erVar, boolean z) {
            this.jad_an.onLoadFailed(-1, "load error", null);
            return false;
        }

        @Override // com.jd.ad.sdk.jad_en.jad_jt
        public boolean jad_an(android.graphics.drawable.Drawable drawable, java.lang.Object obj, com.jd.ad.sdk.jad_fo.jad_er<android.graphics.drawable.Drawable> jad_erVar, com.jd.ad.sdk.jad_ju.jad_an jad_anVar, boolean z) {
            this.jad_an.onLoadSuccess(null);
            return false;
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADFoundationService
    @androidx.annotation.Nullable
    public android.app.Application getApplication() {
        return com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
    }

    @Override // com.jd.ad.sdk.mdt.service.JADFoundationService
    public boolean isNetAvailable() {
        android.app.Application jad_an2 = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        return (jad_an2 == null || com.jd.ad.sdk.jad_qd.jad_iv.jad_an(jad_an2) == 0) ? false : true;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADFoundationService
    public void loadImage(@androidx.annotation.Nullable android.content.Context context, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener onImageLoadListener) {
        if (!com.jd.ad.sdk.jad_fq.jad_dq.jad_an(context) || android.text.TextUtils.isEmpty(str) || onImageLoadListener == null) {
            return;
        }
        com.jd.ad.sdk.jad_gr.jad_cp.jad_bo(context).jad_an(str).jad_an(com.jd.ad.sdk.jad_mx.jad_ly.jad_cp).jad_bo(new com.jd.ad.sdk.jad_zi.jad_hu.jad_bo(this)).jad_an((com.jd.ad.sdk.jad_gr.jad_iv) new com.jd.ad.sdk.jad_zi.jad_hu.jad_an(this, onImageLoadListener));
    }

    @Override // com.jd.ad.sdk.mdt.service.JADFoundationService
    public void preloadImage(@androidx.annotation.Nullable android.content.Context context, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener onImageLoadListener) {
        if (com.jd.ad.sdk.jad_fq.jad_dq.jad_an(context) && !android.text.TextUtils.isEmpty(str)) {
            com.jd.ad.sdk.jad_gr.jad_cp.jad_bo(context).jad_an(str).jad_an(com.jd.ad.sdk.jad_mx.jad_ly.jad_bo).jad_bo(new com.jd.ad.sdk.jad_zi.jad_hu.jad_cp(this, onImageLoadListener)).jad_dq();
        }
    }
}
