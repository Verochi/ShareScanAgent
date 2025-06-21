package com.jd.ad.sdk.fdt.utils;

/* loaded from: classes23.dex */
public class ResourceUtils {
    public static int getAnimId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, com.anythink.expressad.foundation.h.i.f);
    }

    public static int getAnimatorId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, "animator");
    }

    public static int getAttrId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, "attr");
    }

    public static int getBoolId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, "bool");
    }

    public static int getColorId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, "color");
    }

    public static int getComponentId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, "id");
    }

    public static int getDimenId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, "dimen");
    }

    public static int getDrawableId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, com.anythink.expressad.foundation.h.i.c);
    }

    public static int getIntegerId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, "integer");
    }

    public static int getInterpolatorId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, "interpolator");
    }

    public static int getLayoutId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, "layout");
    }

    public static int getMipmapId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, "mipmap");
    }

    public static int getPluralsId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, "plurals");
    }

    public static int getResourceId(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public static int getStringId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, com.anythink.expressad.foundation.h.i.g);
    }

    public static int getStyleId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, com.anythink.expressad.foundation.h.i.e);
    }

    public static int getStyleableId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, "styleable");
    }

    public static int getXmlId(android.content.Context context, java.lang.String str) {
        return getResourceId(context, str, com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML);
    }
}
