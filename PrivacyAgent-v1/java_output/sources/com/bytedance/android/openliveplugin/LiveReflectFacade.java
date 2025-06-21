package com.bytedance.android.openliveplugin;

/* loaded from: classes.dex */
public class LiveReflectFacade {
    public static void addLiveInitListener(java.lang.Object obj) {
        if (obj instanceof com.bytedance.android.live.base.api.ILiveInitCallback) {
            com.bytedance.android.openliveplugin.LivePluginHelper.addInitListener((com.bytedance.android.live.base.api.ILiveInitCallback) obj);
        }
    }

    public static com.bytedance.android.live.base.api.IOuterLiveService getOuterLiveService() {
        try {
            return (com.bytedance.android.live.base.api.IOuterLiveService) java.lang.Class.forName("com.bytedance.android.openlive.plugin.LivePluginFacade", true, com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite")).getMethod("getOuterLiveRoomService", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void initLiveInPlugin(android.app.Application application, java.lang.String str, com.bytedance.android.live.base.api.ILiveHostContextParam.Builder builder, boolean z, com.bytedance.android.live.base.api.ILiveInitCallback iLiveInitCallback) {
        com.bytedance.android.live.base.api.JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.plugin.LivePluginFacade", "initLiveInPlugin", com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), application, str, builder, java.lang.Boolean.valueOf(z), iLiveInitCallback);
    }

    public static void invokeLiveInitFailed(java.lang.String str) {
        com.bytedance.android.openliveplugin.LivePluginHelper.LiveInitCallback.INSTANCE.onLiveInitFailed(str);
    }

    public static void invokeLiveInitSuccess() {
        com.bytedance.android.openliveplugin.LivePluginHelper.LiveInitCallback.INSTANCE.onLiveInitFinish();
    }
}
