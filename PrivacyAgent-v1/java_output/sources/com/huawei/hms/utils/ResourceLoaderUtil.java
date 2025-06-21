package com.huawei.hms.utils;

/* loaded from: classes22.dex */
public abstract class ResourceLoaderUtil {
    public static android.content.Context a;
    public static java.lang.String b;

    public static int getAnimId(java.lang.String str) {
        return a.getResources().getIdentifier(str, com.anythink.expressad.foundation.h.i.f, b);
    }

    public static int getColorId(java.lang.String str) {
        return a.getResources().getIdentifier(str, "color", b);
    }

    public static android.graphics.drawable.Drawable getDrawable(java.lang.String str) {
        return a.getResources().getDrawable(getDrawableId(str));
    }

    public static int getDrawableId(java.lang.String str) {
        return a.getResources().getIdentifier(str, com.anythink.expressad.foundation.h.i.c, b);
    }

    public static int getIdId(java.lang.String str) {
        return a.getResources().getIdentifier(str, "id", b);
    }

    public static int getLayoutId(java.lang.String str) {
        return a.getResources().getIdentifier(str, "layout", b);
    }

    public static java.lang.String getString(java.lang.String str) {
        return a.getResources().getString(getStringId(str));
    }

    public static java.lang.String getString(java.lang.String str, java.lang.Object... objArr) {
        return a.getResources().getString(getStringId(str), objArr);
    }

    public static int getStringId(java.lang.String str) {
        return a.getResources().getIdentifier(str, com.anythink.expressad.foundation.h.i.g, b);
    }

    public static int getStyleId(java.lang.String str) {
        return a.getResources().getIdentifier(str, com.anythink.expressad.foundation.h.i.e, b);
    }

    public static android.content.Context getmContext() {
        return a;
    }

    public static void setmContext(android.content.Context context) {
        a = context;
        b = context.getPackageName();
    }
}
