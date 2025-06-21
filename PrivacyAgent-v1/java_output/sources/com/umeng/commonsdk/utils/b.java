package com.umeng.commonsdk.utils;

/* loaded from: classes19.dex */
public class b {
    private static java.util.HashMap<java.lang.String, android.content.pm.PackageInfo> a = new java.util.HashMap<>();
    private static java.lang.Object b = new java.lang.Object();

    public static class a {
        private static final com.umeng.commonsdk.utils.b a = new com.umeng.commonsdk.utils.b(null);

        private a() {
        }
    }

    private b() {
    }

    public /* synthetic */ b(com.umeng.commonsdk.utils.b.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.umeng.commonsdk.utils.b a() {
        return com.umeng.commonsdk.utils.b.a.a;
    }

    public android.content.pm.PackageInfo a(android.content.Context context, java.lang.String str, int i) {
        android.content.pm.PackageInfo packageInfo;
        synchronized (b) {
            if (a.containsKey(str)) {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", pkgInfo缓存命中，直接返回");
                packageInfo = a.get(str);
            } else {
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, i);
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", 获取pkgInfo并缓存");
                    a.put(str, packageInfo);
                } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                    a.put(str, null);
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> pkg: " + str + "，目标包未安装。");
                    packageInfo = null;
                }
            }
        }
        return packageInfo;
    }
}
