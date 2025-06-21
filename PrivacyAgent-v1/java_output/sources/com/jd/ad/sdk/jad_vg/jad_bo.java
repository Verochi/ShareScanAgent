package com.jd.ad.sdk.jad_vg;

/* loaded from: classes23.dex */
public final class jad_bo {
    public static android.graphics.drawable.Drawable jad_an(android.content.Context context, android.content.Context context2, @androidx.annotation.DrawableRes int i, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
        if (theme == null) {
            theme = context2.getTheme();
        }
        return androidx.core.content.res.ResourcesCompat.getDrawable(context2.getResources(), i, theme);
    }
}
