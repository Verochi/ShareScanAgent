package com.alimm.tanx.ui.image;

/* loaded from: classes.dex */
public class GlideSourceCodeImageLoader implements com.alimm.tanx.core.image.IImageLoader {
    private static final java.lang.String TAG = "GlideSourceCodeImageLoader";

    /* renamed from: com.alimm.tanx.ui.image.GlideSourceCodeImageLoader$1, reason: invalid class name */
    public class AnonymousClass1 extends com.alimm.tanx.ui.image.glide.request.target.SimpleTarget<android.graphics.Bitmap> {
        final /* synthetic */ com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback val$callback;

        public AnonymousClass1(com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback imageBitmapCallback) {
            this.val$callback = imageBitmapCallback;
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
        public void onLoadFailed(java.lang.Exception exc, android.graphics.drawable.Drawable drawable) {
            if (this.val$callback != null) {
                com.alimm.tanx.core.ut.impl.TanxMonitorUt.sendImageMonitor(2, -1, "image", false);
                this.val$callback.onFailure(com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(exc));
            }
        }

        public void onResourceReady(android.graphics.Bitmap bitmap, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super android.graphics.Bitmap> glideAnimation) {
            if (this.val$callback != null) {
                com.alimm.tanx.core.ut.impl.TanxMonitorUt.sendImageMonitor(2, 1, "image", false);
                this.val$callback.onSuccess(bitmap);
            }
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(java.lang.Object obj, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation glideAnimation) {
            onResourceReady((android.graphics.Bitmap) obj, (com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super android.graphics.Bitmap>) glideAnimation);
        }
    }

    /* renamed from: com.alimm.tanx.ui.image.GlideSourceCodeImageLoader$2, reason: invalid class name */
    public class AnonymousClass2 extends com.alimm.tanx.ui.image.glide.request.target.SimpleTarget<com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> {
        final /* synthetic */ com.alimm.tanx.core.image.util.ImageConfig.GifCallback val$gifCallback;
        final /* synthetic */ android.widget.ImageView val$view;

        public AnonymousClass2(com.alimm.tanx.core.image.util.ImageConfig.GifCallback gifCallback, android.widget.ImageView imageView) {
            this.val$gifCallback = gifCallback;
            this.val$view = imageView;
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
        public void onLoadFailed(java.lang.Exception exc, android.graphics.drawable.Drawable drawable) {
            com.alimm.tanx.core.image.util.ImageConfig.GifCallback gifCallback = this.val$gifCallback;
            if (gifCallback != null) {
                gifCallback.onFailure(com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(exc));
                com.alimm.tanx.core.ut.impl.TanxMonitorUt.sendImageMonitor(2, -1, "gif", false);
            }
        }

        public void onResourceReady(com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable glideDrawable, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> glideAnimation) {
            if (this.val$gifCallback != null) {
                if (glideDrawable.isAnimated()) {
                    glideDrawable.setLoopCount(-1);
                    glideDrawable.start();
                }
                this.val$view.setBackground(glideDrawable);
                this.val$gifCallback.onSuccess();
                com.alimm.tanx.core.ut.impl.TanxMonitorUt.sendImageMonitor(2, 1, "gif", false);
            }
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(java.lang.Object obj, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation glideAnimation) {
            onResourceReady((com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable) obj, (com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable>) glideAnimation);
        }
    }

    private com.alimm.tanx.ui.image.glide.DrawableTypeRequest getDrawableTypeRequest(com.alimm.tanx.core.image.util.ImageConfig imageConfig, com.alimm.tanx.ui.image.glide.RequestManager requestManager) {
        if (!android.text.TextUtils.isEmpty(imageConfig.getUrl())) {
            return requestManager.load(imageConfig.getUrl());
        }
        if (imageConfig.getResId() > 0) {
            return requestManager.load(java.lang.Integer.valueOf(imageConfig.getResId()));
        }
        return null;
    }

    private com.alimm.tanx.ui.image.glide.request.target.SimpleTarget<com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> getGifSimpleTarget(android.widget.ImageView imageView, com.alimm.tanx.core.image.util.ImageConfig.GifCallback gifCallback) {
        return new com.alimm.tanx.ui.image.GlideSourceCodeImageLoader.AnonymousClass2(gifCallback, imageView);
    }

    private static boolean isParentContextDestroyed(android.content.Context context) {
        if (context == null) {
            return true;
        }
        if (context instanceof android.app.Activity) {
            android.app.Activity activity = (android.app.Activity) context;
            if (activity.isDestroyed() || activity.isFinishing()) {
                return true;
            }
        }
        if (!(context instanceof androidx.fragment.app.FragmentActivity)) {
            return false;
        }
        androidx.fragment.app.FragmentActivity fragmentActivity = (androidx.fragment.app.FragmentActivity) context;
        return fragmentActivity.isDestroyed() || fragmentActivity.isFinishing();
    }

    private static boolean isParentContextDestroyed(android.view.View view) {
        if (view != null) {
            return isParentContextDestroyed(view.getContext());
        }
        return true;
    }

    @Override // com.alimm.tanx.core.image.ILoader
    public void load(com.alimm.tanx.core.image.util.ImageConfig imageConfig, com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback imageBitmapCallback) {
        try {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "load()");
            com.alimm.tanx.core.ut.impl.TanxMonitorUt.sendImageMonitor(2, 1, "image", true);
            if (isParentContextDestroyed(imageConfig.getContext())) {
                com.alimm.tanx.core.utils.LogUtils.e(TAG, "load error isParentContextNotDestroyed 对应view或activity已经销毁");
                return;
            }
            com.alimm.tanx.ui.image.glide.DrawableTypeRequest drawableTypeRequest = getDrawableTypeRequest(imageConfig, com.alimm.tanx.ui.image.glide.Glide.with(imageConfig.getContext()));
            if (drawableTypeRequest == null) {
                return;
            }
            drawableTypeRequest.asBitmap().into((com.alimm.tanx.ui.image.glide.BitmapTypeRequest) new com.alimm.tanx.ui.image.GlideSourceCodeImageLoader.AnonymousClass1(imageBitmapCallback));
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
    }

    @Override // com.alimm.tanx.core.image.ILoader
    public void loadGif(com.alimm.tanx.core.image.util.GifConfig gifConfig, com.alimm.tanx.core.image.util.ImageConfig.GifCallback gifCallback) {
        java.lang.String str;
        try {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "loadGif()");
            com.alimm.tanx.core.ut.impl.TanxMonitorUt.sendImageMonitor(2, 1, "gif", true);
            if (isParentContextDestroyed(gifConfig.getGifView())) {
                com.alimm.tanx.core.utils.LogUtils.e(TAG, "load error isParentContextNotDestroyed 对应view或activity已经销毁");
                return;
            }
            if (gifConfig.getGifView() == null) {
                str = "imageView对象为空";
            } else if (!android.text.TextUtils.isEmpty(gifConfig.getGifUrl())) {
                com.alimm.tanx.ui.image.glide.Glide.with(gifConfig.getGifView().getContext()).load(gifConfig.getGifUrl()).diskCacheStrategy(com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy.RESULT).into((com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<java.lang.String>) getGifSimpleTarget(gifConfig.getGifView(), gifCallback));
                return;
            } else {
                if (gifConfig.getGifRes() != -1) {
                    com.alimm.tanx.ui.image.glide.Glide.with(gifConfig.getGifView().getContext()).load(java.lang.Integer.valueOf(gifConfig.getGifRes())).diskCacheStrategy(com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy.RESULT).into((com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<java.lang.Integer>) getGifSimpleTarget(gifConfig.getGifView(), gifCallback));
                    return;
                }
                str = "";
            }
            if (gifCallback != null) {
                gifCallback.onFailure(str);
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
    }
}
