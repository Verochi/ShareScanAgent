package com.qq.e.comm.managers;

/* loaded from: classes19.dex */
public class GDTAdSdk {

    public interface OnStartListener {
        void onStartFailed(java.lang.Exception exc);

        void onStartSuccess();
    }

    public static com.qq.e.comm.managers.IGDTAdManager getGDTAdManger() {
        return com.qq.e.comm.managers.a.b();
    }

    @java.lang.Deprecated
    public static void init(android.content.Context context, java.lang.String str) {
        com.qq.e.comm.util.GDTLogger.w("该方法已被废弃，请尽快切换初始化接口为GDTAdSdk#initWithoutStart、GDTAdSdk#start，详见接入文档或咨询技术支持。");
        com.qq.e.comm.managers.a.b().a(context, str, true);
    }

    public static void initWithoutStart(android.content.Context context, java.lang.String str) {
        com.qq.e.comm.managers.a.b().a(context, str, false);
    }

    public static void start(com.qq.e.comm.managers.GDTAdSdk.OnStartListener onStartListener) {
        com.qq.e.comm.managers.a.b().a(onStartListener);
    }
}
