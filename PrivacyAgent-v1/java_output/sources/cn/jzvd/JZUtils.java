package cn.jzvd;

/* loaded from: classes.dex */
public class JZUtils {
    public static int SYSTEM_UI = 0;
    public static final java.lang.String TAG = "JZVD";
    public static final java.util.LinkedList<java.util.Map<java.lang.String, java.lang.Long>> a = new java.util.LinkedList<>();

    public static void clearSavedProgress() {
        a.clear();
    }

    public static int dip2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getNavigationBarHeight(android.content.Context context) {
        boolean hasPermanentMenuKey = android.view.ViewConfiguration.get(context).hasPermanentMenuKey();
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
        if (identifier <= 0 || hasPermanentMenuKey) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static long getSavedProgress(java.lang.String str) {
        if (str == null) {
            return 0L;
        }
        java.util.Iterator<java.util.Map<java.lang.String, java.lang.Long>> it = a.iterator();
        while (it.hasNext()) {
            java.lang.Long l = it.next().get(str);
            if (l != null) {
                return l.longValue();
            }
        }
        return 0L;
    }

    public static int getScreenHeight(android.content.Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(android.content.Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getStatusBarHeight(android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM));
    }

    public static android.view.Window getWindow(android.content.Context context) {
        return scanForActivity(context) != null ? scanForActivity(context).getWindow() : scanForActivity(context).getWindow();
    }

    @android.annotation.SuppressLint({"RestrictedApi"})
    public static void hideStatusBar(android.content.Context context) {
        getWindow(context).setFlags(1024, 1024);
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static void hideSystemUI(android.content.Context context) {
        SYSTEM_UI = getWindow(context).getDecorView().getSystemUiVisibility();
        getWindow(context).getDecorView().setSystemUiVisibility(5638);
    }

    public static boolean isWifiConnected(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static void saveProgress(java.lang.String str, long j) {
        if (str == null) {
            return;
        }
        java.util.Iterator<java.util.Map<java.lang.String, java.lang.Long>> it = a.iterator();
        while (it.hasNext()) {
            java.util.Map<java.lang.String, java.lang.Long> next = it.next();
            if (next.containsKey(str)) {
                next.put(str, java.lang.Long.valueOf(j));
                return;
            }
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(str, java.lang.Long.valueOf(j));
        java.util.LinkedList<java.util.Map<java.lang.String, java.lang.Long>> linkedList = a;
        linkedList.add(hashMap);
        if (linkedList.size() > 7) {
            linkedList.removeFirst();
        }
    }

    public static android.app.Activity scanForActivity(android.content.Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof android.app.Activity) {
            return (android.app.Activity) context;
        }
        if (context instanceof android.content.ContextWrapper) {
            return scanForActivity(((android.content.ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static void setRequestedOrientation(android.content.Context context, int i) {
        if (scanForActivity(context) != null) {
            scanForActivity(context).setRequestedOrientation(i);
        } else {
            scanForActivity(context).setRequestedOrientation(i);
        }
    }

    @android.annotation.SuppressLint({"RestrictedApi"})
    public static void showStatusBar(android.content.Context context) {
        getWindow(context).clearFlags(1024);
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static void showSystemUI(android.content.Context context) {
        getWindow(context).getDecorView().setSystemUiVisibility(SYSTEM_UI);
    }

    public static java.lang.String stringForTime(long j) {
        if (j <= 0 || j >= 86400000) {
            return "00:00";
        }
        long j2 = j / 1000;
        int i = (int) (j2 % 60);
        int i2 = (int) ((j2 / 60) % 60);
        int i3 = (int) (j2 / com.anythink.expressad.d.a.b.P);
        java.util.Formatter formatter = new java.util.Formatter(new java.lang.StringBuilder(), java.util.Locale.getDefault());
        return i3 > 0 ? formatter.format("%d:%02d:%02d", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i)).toString() : formatter.format("%02d:%02d", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i)).toString();
    }
}
