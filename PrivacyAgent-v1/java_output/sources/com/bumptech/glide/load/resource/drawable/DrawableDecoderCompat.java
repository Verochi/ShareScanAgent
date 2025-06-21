package com.bumptech.glide.load.resource.drawable;

/* loaded from: classes.dex */
public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    private DrawableDecoderCompat() {
    }

    public static android.graphics.drawable.Drawable getDrawable(android.content.Context context, @androidx.annotation.DrawableRes int i, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
        return getDrawable(context, context, i, theme);
    }

    public static android.graphics.drawable.Drawable getDrawable(android.content.Context context, android.content.Context context2, @androidx.annotation.DrawableRes int i) {
        return getDrawable(context, context2, i, null);
    }

    private static android.graphics.drawable.Drawable getDrawable(android.content.Context context, android.content.Context context2, @androidx.annotation.DrawableRes int i, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
        try {
            if (shouldCallAppCompatResources) {
                return loadDrawableV7(context2, i, theme);
            }
        } catch (android.content.res.Resources.NotFoundException unused) {
        } catch (java.lang.IllegalStateException e) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e;
            }
            return androidx.core.content.ContextCompat.getDrawable(context2, i);
        } catch (java.lang.NoClassDefFoundError unused2) {
            shouldCallAppCompatResources = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return loadDrawableV4(context2, i, theme);
    }

    private static android.graphics.drawable.Drawable loadDrawableV4(android.content.Context context, @androidx.annotation.DrawableRes int i, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
        return androidx.core.content.res.ResourcesCompat.getDrawable(context.getResources(), i, theme);
    }

    private static android.graphics.drawable.Drawable loadDrawableV7(android.content.Context context, @androidx.annotation.DrawableRes int i, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
        if (theme != null) {
            context = new androidx.appcompat.view.ContextThemeWrapper(context, theme);
        }
        return androidx.appcompat.content.res.AppCompatResources.getDrawable(context, i);
    }
}
