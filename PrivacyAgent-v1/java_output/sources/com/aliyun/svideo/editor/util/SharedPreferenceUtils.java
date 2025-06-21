package com.aliyun.svideo.editor.util;

/* loaded from: classes12.dex */
public class SharedPreferenceUtils {
    private static final java.lang.String EDIT_PAGE = "edit_page";
    private static final java.lang.String EDIT_PAGE_EFFECT = "edit_page_effect";
    private static final java.lang.String EFFECT_ANIMATION = "effect_animation";
    private static final java.lang.String EFFECT_COVER = "effect_cover";
    private static final java.lang.String EFFECT_TIME = "effect_time";
    private static final java.lang.String SHAREDPRE_FILE = "svideo";

    public static boolean isAnimationEffectFirstShow(android.content.Context context) {
        return context.getSharedPreferences("svideo", 0).getBoolean(EFFECT_ANIMATION, false);
    }

    public static boolean isCoverViewFirstShow(android.content.Context context) {
        return context.getSharedPreferences("svideo", 0).getBoolean(EFFECT_COVER, true);
    }

    public static boolean isEditPageEffectFirstShow(android.content.Context context) {
        return context.getSharedPreferences("svideo", 0).getBoolean(EDIT_PAGE_EFFECT, true);
    }

    public static boolean isEditPageFirstShow(android.content.Context context) {
        return context.getSharedPreferences("svideo", 0).getBoolean(EDIT_PAGE, true);
    }

    public static boolean isTimeEffectFirstShow(android.content.Context context) {
        return context.getSharedPreferences("svideo", 0).getBoolean(EFFECT_TIME, true);
    }

    public static void setAnimationEffectFirstShow(android.content.Context context, boolean z) {
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("svideo", 0).edit();
        edit.putBoolean(EFFECT_ANIMATION, z);
        edit.commit();
    }

    public static void setCoverViewFirstShow(android.content.Context context, boolean z) {
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("svideo", 0).edit();
        edit.putBoolean(EFFECT_COVER, z);
        edit.commit();
    }

    public static void setEditPageEffectFirstShow(android.content.Context context, boolean z) {
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("svideo", 0).edit();
        edit.putBoolean(EDIT_PAGE_EFFECT, z);
        edit.commit();
    }

    public static void setEditPageFirstShow(android.content.Context context, boolean z) {
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("svideo", 0).edit();
        edit.putBoolean(EDIT_PAGE, z);
        edit.commit();
    }

    public static void setTimeEffectFirstShow(android.content.Context context, boolean z) {
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("svideo", 0).edit();
        edit.putBoolean(EFFECT_TIME, z);
        edit.commit();
    }
}
