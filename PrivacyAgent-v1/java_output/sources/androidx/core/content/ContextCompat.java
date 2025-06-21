package androidx.core.content;

/* loaded from: classes.dex */
public class ContextCompat {
    private static final java.lang.String TAG = "ContextCompat";
    private static final java.lang.Object sLock = new java.lang.Object();
    private static android.util.TypedValue sTempValue;

    public static final class LegacyServiceMapHolder {
        static final java.util.HashMap<java.lang.Class<?>, java.lang.String> SERVICES;

        static {
            java.util.HashMap<java.lang.Class<?>, java.lang.String> hashMap = new java.util.HashMap<>();
            SERVICES = hashMap;
            if (android.os.Build.VERSION.SDK_INT >= 22) {
                hashMap.put(android.telephony.SubscriptionManager.class, "telephony_subscription_service");
                hashMap.put(android.app.usage.UsageStatsManager.class, "usagestats");
            }
            hashMap.put(android.appwidget.AppWidgetManager.class, "appwidget");
            hashMap.put(android.os.BatteryManager.class, "batterymanager");
            hashMap.put(android.hardware.camera2.CameraManager.class, com.sensorsdata.sf.ui.view.UIProperty.action_type_camera);
            hashMap.put(android.app.job.JobScheduler.class, "jobscheduler");
            hashMap.put(android.content.pm.LauncherApps.class, "launcherapps");
            hashMap.put(android.media.projection.MediaProjectionManager.class, "media_projection");
            hashMap.put(android.media.session.MediaSessionManager.class, "media_session");
            hashMap.put(android.content.RestrictionsManager.class, "restrictions");
            hashMap.put(android.telecom.TelecomManager.class, "telecom");
            hashMap.put(android.media.tv.TvInputManager.class, "tv_input");
            hashMap.put(android.app.AppOpsManager.class, "appops");
            hashMap.put(android.view.accessibility.CaptioningManager.class, "captioning");
            hashMap.put(android.hardware.ConsumerIrManager.class, "consumer_ir");
            hashMap.put(android.print.PrintManager.class, "print");
            hashMap.put(android.bluetooth.BluetoothManager.class, "bluetooth");
            hashMap.put(android.hardware.display.DisplayManager.class, "display");
            hashMap.put(android.os.UserManager.class, com.umeng.analytics.pro.ay.m);
            hashMap.put(android.hardware.input.InputManager.class, "input");
            hashMap.put(android.media.MediaRouter.class, "media_router");
            hashMap.put(android.net.nsd.NsdManager.class, "servicediscovery");
            hashMap.put(android.view.accessibility.AccessibilityManager.class, "accessibility");
            hashMap.put(android.accounts.AccountManager.class, "account");
            hashMap.put(android.app.ActivityManager.class, "activity");
            hashMap.put(android.app.AlarmManager.class, androidx.core.app.NotificationCompat.CATEGORY_ALARM);
            hashMap.put(android.media.AudioManager.class, "audio");
            hashMap.put(android.content.ClipboardManager.class, "clipboard");
            hashMap.put(android.net.ConnectivityManager.class, "connectivity");
            hashMap.put(android.app.admin.DevicePolicyManager.class, "device_policy");
            hashMap.put(android.app.DownloadManager.class, "download");
            hashMap.put(android.os.DropBoxManager.class, "dropbox");
            hashMap.put(android.view.inputmethod.InputMethodManager.class, "input_method");
            hashMap.put(android.app.KeyguardManager.class, "keyguard");
            hashMap.put(android.view.LayoutInflater.class, "layout_inflater");
            hashMap.put(android.location.LocationManager.class, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
            hashMap.put(android.nfc.NfcManager.class, "nfc");
            hashMap.put(android.app.NotificationManager.class, com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
            hashMap.put(android.os.PowerManager.class, "power");
            hashMap.put(android.app.SearchManager.class, com.ss.android.download.api.constant.BaseConstants.MARKET_URI_AUTHORITY_SEARCH);
            hashMap.put(android.hardware.SensorManager.class, com.umeng.analytics.pro.bo.ac);
            hashMap.put(android.os.storage.StorageManager.class, "storage");
            hashMap.put(android.telephony.TelephonyManager.class, com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            hashMap.put(android.view.textservice.TextServicesManager.class, "textservices");
            hashMap.put(android.app.UiModeManager.class, "uimode");
            hashMap.put(android.hardware.usb.UsbManager.class, "usb");
            hashMap.put(android.os.Vibrator.class, "vibrator");
            hashMap.put(android.app.WallpaperManager.class, "wallpaper");
            hashMap.put(android.net.wifi.p2p.WifiP2pManager.class, "wifip2p");
            hashMap.put(android.net.wifi.WifiManager.class, com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
            hashMap.put(android.view.WindowManager.class, "window");
        }

        private LegacyServiceMapHolder() {
        }
    }

    public static class MainHandlerExecutor implements java.util.concurrent.Executor {
        private final android.os.Handler mHandler;

        public MainHandlerExecutor(@androidx.annotation.NonNull android.os.Handler handler) {
            this.mHandler = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            if (this.mHandler.post(runnable)) {
                return;
            }
            throw new java.util.concurrent.RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    public static int checkSelfPermission(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
        if (str != null) {
            return context.checkPermission(str, android.os.Process.myPid(), android.os.Process.myUid());
        }
        throw new java.lang.IllegalArgumentException("permission is null");
    }

    @androidx.annotation.Nullable
    public static android.content.Context createDeviceProtectedStorageContext(@androidx.annotation.NonNull android.content.Context context) {
        android.content.Context createDeviceProtectedStorageContext;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return null;
        }
        createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        return createDeviceProtectedStorageContext;
    }

    private static synchronized java.io.File createFilesDir(java.io.File file) {
        synchronized (androidx.core.content.ContextCompat.class) {
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            if (file.exists()) {
                return file;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Unable to create files subdir ");
            sb.append(file.getPath());
            return null;
        }
    }

    public static java.io.File getCodeCacheDir(@androidx.annotation.NonNull android.content.Context context) {
        return context.getCodeCacheDir();
    }

    @androidx.annotation.ColorInt
    public static int getColor(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.ColorRes int i) {
        int color;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return context.getResources().getColor(i);
        }
        color = context.getColor(i);
        return color;
    }

    @androidx.annotation.Nullable
    public static android.content.res.ColorStateList getColorStateList(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.ColorRes int i) {
        android.content.res.ColorStateList colorStateList;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return context.getResources().getColorStateList(i);
        }
        colorStateList = context.getColorStateList(i);
        return colorStateList;
    }

    @androidx.annotation.Nullable
    public static java.io.File getDataDir(@androidx.annotation.NonNull android.content.Context context) {
        java.io.File dataDir;
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            dataDir = context.getDataDir();
            return dataDir;
        }
        java.lang.String str = context.getApplicationInfo().dataDir;
        if (str != null) {
            return new java.io.File(str);
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static android.graphics.drawable.Drawable getDrawable(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i) {
        return context.getDrawable(i);
    }

    @androidx.annotation.NonNull
    public static java.io.File[] getExternalCacheDirs(@androidx.annotation.NonNull android.content.Context context) {
        return context.getExternalCacheDirs();
    }

    @androidx.annotation.NonNull
    public static java.io.File[] getExternalFilesDirs(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable java.lang.String str) {
        return context.getExternalFilesDirs(str);
    }

    public static java.util.concurrent.Executor getMainExecutor(android.content.Context context) {
        java.util.concurrent.Executor mainExecutor;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return new androidx.core.content.ContextCompat.MainHandlerExecutor(new android.os.Handler(context.getMainLooper()));
        }
        mainExecutor = context.getMainExecutor();
        return mainExecutor;
    }

    @androidx.annotation.Nullable
    public static java.io.File getNoBackupFilesDir(@androidx.annotation.NonNull android.content.Context context) {
        return context.getNoBackupFilesDir();
    }

    @androidx.annotation.NonNull
    public static java.io.File[] getObbDirs(@androidx.annotation.NonNull android.content.Context context) {
        return context.getObbDirs();
    }

    @androidx.annotation.Nullable
    public static <T> T getSystemService(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.Class<T> cls) {
        java.lang.Object systemService;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            systemService = context.getSystemService(cls);
            return (T) systemService;
        }
        java.lang.String systemServiceName = getSystemServiceName(context, cls);
        if (systemServiceName != null) {
            return (T) context.getSystemService(systemServiceName);
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static java.lang.String getSystemServiceName(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.Class<?> cls) {
        java.lang.String systemServiceName;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return androidx.core.content.ContextCompat.LegacyServiceMapHolder.SERVICES.get(cls);
        }
        systemServiceName = context.getSystemServiceName(cls);
        return systemServiceName;
    }

    public static boolean isDeviceProtectedStorage(@androidx.annotation.NonNull android.content.Context context) {
        boolean isDeviceProtectedStorage;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return false;
        }
        isDeviceProtectedStorage = context.isDeviceProtectedStorage();
        return isDeviceProtectedStorage;
    }

    public static boolean startActivities(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent[] intentArr) {
        return startActivities(context, intentArr, null);
    }

    public static boolean startActivities(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent[] intentArr, @androidx.annotation.Nullable android.os.Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }

    public static void startActivity(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.Nullable android.os.Bundle bundle) {
        context.startActivity(intent, bundle);
    }

    public static void startForegroundService(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
