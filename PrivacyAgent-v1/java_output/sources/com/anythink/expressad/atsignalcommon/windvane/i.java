package com.anythink.expressad.atsignalcommon.windvane;

/* loaded from: classes12.dex */
public final class i {
    private static java.util.HashMap<java.lang.String, java.lang.Class> a = new java.util.HashMap<>();
    private android.content.Context b;
    private java.lang.Object c;
    private com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView d;

    public i(android.content.Context context, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
        this.b = context;
        this.d = windVaneWebView;
        try {
            int i = com.anythink.expressad.atsignalcommon.bridge.BannerJSPlugin.t;
            a(com.anythink.expressad.atsignalcommon.bridge.BannerJSPlugin.class);
        } catch (java.lang.ClassNotFoundException unused) {
        }
        try {
            int i2 = com.anythink.expressad.video.signal.communication.RewardJs.t;
            a(com.anythink.expressad.video.signal.communication.RewardJs.class);
        } catch (java.lang.ClassNotFoundException unused2) {
        }
        try {
            int i3 = com.anythink.expressad.video.signal.communication.VideoBridge.t;
            a(com.anythink.expressad.video.signal.communication.VideoBridge.class);
        } catch (java.lang.ClassNotFoundException unused3) {
        }
        try {
            a(com.anythink.expressad.atsignalcommon.mraid.MraidJSBridge.class);
        } catch (java.lang.ClassNotFoundException unused4) {
        }
        try {
            int i4 = com.anythink.expressad.splash.js.SplashJs.t;
            a(com.anythink.expressad.splash.js.SplashJs.class);
        } catch (java.lang.ClassNotFoundException unused5) {
        }
        try {
            a(com.anythink.expressad.atsignalcommon.webEnvCheck.WebGLCheckjs.class);
        } catch (java.lang.ClassNotFoundException unused6) {
        }
    }

    private java.lang.Object a(java.lang.String str, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, android.content.Context context) {
        java.lang.Class cls = a.get(str);
        if (cls == null) {
            return null;
        }
        try {
            if (!com.anythink.expressad.atsignalcommon.windvane.l.class.isAssignableFrom(cls)) {
                return null;
            }
            com.anythink.expressad.atsignalcommon.windvane.l lVar = (com.anythink.expressad.atsignalcommon.windvane.l) cls.newInstance();
            lVar.initialize(context, windVaneWebView);
            lVar.initialize(this.c, windVaneWebView);
            return lVar;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void a() {
        try {
            int i = com.anythink.expressad.atsignalcommon.bridge.BannerJSPlugin.t;
            a(com.anythink.expressad.atsignalcommon.bridge.BannerJSPlugin.class);
        } catch (java.lang.ClassNotFoundException unused) {
        }
        try {
            int i2 = com.anythink.expressad.video.signal.communication.RewardJs.t;
            a(com.anythink.expressad.video.signal.communication.RewardJs.class);
        } catch (java.lang.ClassNotFoundException unused2) {
        }
        try {
            int i3 = com.anythink.expressad.video.signal.communication.VideoBridge.t;
            a(com.anythink.expressad.video.signal.communication.VideoBridge.class);
        } catch (java.lang.ClassNotFoundException unused3) {
        }
        try {
            a(com.anythink.expressad.atsignalcommon.mraid.MraidJSBridge.class);
        } catch (java.lang.ClassNotFoundException unused4) {
        }
        try {
            int i4 = com.anythink.expressad.splash.js.SplashJs.t;
            a(com.anythink.expressad.splash.js.SplashJs.class);
        } catch (java.lang.ClassNotFoundException unused5) {
        }
        try {
            a(com.anythink.expressad.atsignalcommon.webEnvCheck.WebGLCheckjs.class);
        } catch (java.lang.ClassNotFoundException unused6) {
        }
    }

    public static void a(java.lang.Class cls) {
        if (a == null) {
            a = new java.util.HashMap<>();
        }
        a.put(cls.getSimpleName(), cls);
    }

    private static void b(java.lang.String str) {
        if (a == null) {
            a = new java.util.HashMap<>();
        }
        a.remove(str);
    }

    public final java.lang.Object a(java.lang.String str) {
        if (a == null) {
            a = new java.util.HashMap<>();
        }
        return a(str, this.d, this.b);
    }

    public final void a(android.content.Context context) {
        this.b = context;
    }

    public final void a(java.lang.Object obj) {
        this.c = obj;
    }
}
