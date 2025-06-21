package com.aliyun.svideo.common.utils;

/* loaded from: classes.dex */
public class LanguageUtils {
    private static final java.lang.String TAG = "LanguageUtils";

    public static boolean isCHEN(android.content.Context context) {
        java.util.Locale locale = context.getResources().getConfiguration().locale;
        boolean equals = com.anythink.expressad.video.dynview.a.a.Q.equals(locale.getLanguage().toLowerCase());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("当前系统语言 : ");
        sb.append(locale.getLanguage());
        sb.append(" ,当前地区 ：");
        sb.append(locale.getCountry());
        return equals;
    }
}
