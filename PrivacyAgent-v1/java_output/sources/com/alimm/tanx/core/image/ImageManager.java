package com.alimm.tanx.core.image;

/* loaded from: classes.dex */
public class ImageManager implements com.alimm.tanx.core.utils.NotConfused {
    private static volatile com.alimm.tanx.core.image.ILoader loader;

    public static com.alimm.tanx.core.image.ILoader getLoader() {
        if (loader == null) {
            loader = com.alimm.tanx.core.TanxCoreInstanceConfig.getInstance().getImageLoader();
        }
        return loader;
    }

    public static boolean isValidContextForGlide(android.content.Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof android.app.Activity)) {
            return true;
        }
        android.app.Activity activity = (android.app.Activity) context;
        return (activity.isDestroyed() || activity.isFinishing()) ? false : true;
    }

    public static void setLoader(com.alimm.tanx.core.image.ILoader iLoader) {
        loader = iLoader;
    }

    public static com.alimm.tanx.core.image.util.ImageConfig.Builder with(android.content.Context context) {
        return isValidContextForGlide(context) ? new com.alimm.tanx.core.image.util.ImageConfig.Builder(context) : new com.alimm.tanx.core.image.util.ImageConfig.Builder(context.getApplicationContext());
    }
}
