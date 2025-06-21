package com.getui.gtc.base;

/* loaded from: classes22.dex */
public class GtcProvider extends com.getui.gtc.base.util.EmptyProvider implements com.getui.gtc.base.publish.Publisher {
    private static final java.lang.String METHOD_ON_FOREGROUND_CHANGED = "onForegroundChanged";

    @android.annotation.SuppressLint({"StaticFieldLeak"})
    private static android.content.Context context;
    private static int gtcPid;
    private static boolean isCheckedLifecycle;
    private static volatile boolean isForeground;
    private static boolean lazyInitCrypt;
    private static java.lang.String sdcardPath;

    /* renamed from: com.getui.gtc.base.GtcProvider$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.getui.gtc.base.util.OnForegroundChangedListener {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // com.getui.gtc.base.util.OnForegroundChangedListener
        public final void onForegroundChanged(boolean z) {
            boolean unused = com.getui.gtc.base.GtcProvider.isForeground = z;
            if (android.os.Process.myPid() != com.getui.gtc.base.GtcProvider.gtcPid) {
                com.getui.gtc.base.GtcProvider.subscribe(this.a, z);
            }
        }
    }

    /* renamed from: com.getui.gtc.base.GtcProvider$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ boolean b;

        public AnonymousClass2(android.content.Context context, boolean z) {
            this.a = context;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getContentResolver().call(android.net.Uri.parse("content://" + this.a.getPackageName() + ".getui.gtc.provider"), com.getui.gtc.base.GtcProvider.METHOD_ON_FOREGROUND_CHANGED, java.lang.Boolean.toString(this.b), (android.os.Bundle) null);
        }
    }

    /* renamed from: com.getui.gtc.base.GtcProvider$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.base.crypt.SecureCryptTools.getInstance();
        }
    }

    public static android.content.Context context() {
        return context;
    }

    @java.lang.Deprecated
    public static java.util.Set<java.lang.String> getForeActivities() {
        return java.util.Collections.emptySet();
    }

    @java.lang.Deprecated
    public static java.lang.String getSdcardPath() {
        if (sdcardPath == null) {
            synchronized (com.getui.gtc.base.GtcProvider.class) {
                if (sdcardPath == null) {
                    sdcardPath = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
                }
            }
        }
        return sdcardPath;
    }

    public static int gtcPid() {
        return gtcPid;
    }

    public static boolean isForeground() {
        return isForeground;
    }

    public static void lazyInitCrypt() {
        lazyInitCrypt = true;
    }

    @java.lang.Deprecated
    public static int mainPid() {
        return gtcPid;
    }

    public static void setContext(android.content.Context context2) {
        if (context == null && context2 != null) {
            context = context2.getApplicationContext();
        }
        tryListenerForeground(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void subscribe(android.content.Context context2, boolean z) {
        com.getui.gtc.base.util.ScheduleQueue.getInstance().addSchedule(new com.getui.gtc.base.GtcProvider.AnonymousClass2(context2, z));
    }

    private static void tryListenerForeground(android.content.Context context2) {
        try {
            if (isCheckedLifecycle) {
                return;
            }
            synchronized (com.getui.gtc.base.GtcProvider.class) {
                if (isCheckedLifecycle) {
                    return;
                }
                android.content.Context applicationContext = context2 != null ? context2.getApplicationContext() : com.getui.gtc.base.util.CommonUtil.findAppContext();
                if (applicationContext == null) {
                    return;
                }
                if (com.getui.gtc.base.util.CommonUtil.isMainProcess(applicationContext)) {
                    ((android.app.Application) applicationContext).registerActivityLifecycleCallbacks(new com.getui.gtc.base.GtcProvider.AnonymousClass1(applicationContext));
                    if (android.os.Process.myPid() != gtcPid && com.getui.gtc.base.util.CommonUtil.getTopActivity() != null) {
                        isForeground = true;
                        subscribe(applicationContext, true);
                    }
                }
                isCheckedLifecycle = true;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.content.ContentProvider
    public android.os.Bundle call(java.lang.String str, java.lang.String str2, android.os.Bundle bundle) {
        if (METHOD_ON_FOREGROUND_CHANGED.equals(str)) {
            isForeground = java.lang.Boolean.parseBoolean(str2);
            return null;
        }
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        return publish(bundle);
    }

    @Override // com.getui.gtc.base.util.EmptyProvider, android.content.ContentProvider
    public boolean onCreate() {
        try {
            gtcPid = android.os.Process.myPid();
            setContext(getContext());
            if (lazyInitCrypt) {
                return true;
            }
            com.getui.gtc.base.util.ScheduleQueue.getInstance().addSchedule(new com.getui.gtc.base.GtcProvider.AnonymousClass3());
            return true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.getui.gtc.base.publish.Publisher
    public android.os.Bundle publish(android.os.Bundle bundle) {
        return com.getui.gtc.base.publish.Broker.getInstance().publish(bundle);
    }
}
