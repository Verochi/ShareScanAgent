package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class AntiCheatUtil implements com.alimm.tanx.core.utils.NotConfused {
    private static volatile com.alimm.tanx.core.utils.AntiCheatUtil instance;

    private boolean canDrawOverlays(android.content.Context context) {
        boolean canDrawOverlays;
        boolean canDrawOverlays2;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i < 23) {
            return true;
        }
        if (i >= 27) {
            canDrawOverlays2 = android.provider.Settings.canDrawOverlays(context);
            return canDrawOverlays2;
        }
        canDrawOverlays = android.provider.Settings.canDrawOverlays(context);
        if (canDrawOverlays) {
            return true;
        }
        try {
            android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return false;
            }
            android.view.View view = new android.view.View(context);
            android.view.WindowManager.LayoutParams layoutParams = new android.view.WindowManager.LayoutParams(0, 0, i >= 26 ? 2038 : 2003, 24, -2);
            view.setLayoutParams(layoutParams);
            windowManager.addView(view, layoutParams);
            windowManager.removeView(view);
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean checkFloatPermission(android.content.Context context) {
        boolean canDrawOverlays;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            canDrawOverlays = android.provider.Settings.canDrawOverlays(context);
            return canDrawOverlays;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.content.Context");
            java.lang.reflect.Field declaredField = cls.getDeclaredField("APP_OPS_SERVICE");
            declaredField.setAccessible(true);
            java.lang.Object obj = declaredField.get(cls);
            if (!(obj instanceof java.lang.String)) {
                return false;
            }
            java.lang.Object invoke = cls.getMethod("getSystemService", java.lang.String.class).invoke(context, (java.lang.String) obj);
            java.lang.Class<?> cls2 = java.lang.Class.forName("android.app.AppOpsManager");
            java.lang.reflect.Field declaredField2 = cls2.getDeclaredField("MODE_ALLOWED");
            declaredField2.setAccessible(true);
            java.lang.Class<?> cls3 = java.lang.Integer.TYPE;
            return ((java.lang.Integer) cls2.getMethod("checkOp", cls3, cls3, java.lang.String.class).invoke(invoke, 24, java.lang.Integer.valueOf(android.os.Binder.getCallingUid()), context.getPackageName())).intValue() == declaredField2.getInt(cls2);
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static com.alimm.tanx.core.utils.AntiCheatUtil getInstance() {
        if (instance == null) {
            synchronized (com.alimm.tanx.core.utils.AntiCheatUtil.class) {
                if (instance == null) {
                    instance = new com.alimm.tanx.core.utils.AntiCheatUtil();
                }
            }
        }
        return instance;
    }

    public boolean accessibilityEnabled(android.content.Context context) {
        android.view.accessibility.AccessibilityManager accessibilityManager;
        if (context == null || (accessibilityManager = (android.view.accessibility.AccessibilityManager) context.getSystemService("accessibility")) == null) {
            return false;
        }
        return accessibilityManager.isEnabled();
    }

    public float getBatteryPercentage(android.content.Context context) {
        android.content.Intent registerReceiver;
        if (context == null || (registerReceiver = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return -1.0f;
        }
        return (registerReceiver.getIntExtra(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, -1) / registerReceiver.getIntExtra("scale", -1)) * 100.0f;
    }

    public int getCurrentVolume(android.content.Context context) {
        android.media.AudioManager audioManager;
        if (context == null || (audioManager = (android.media.AudioManager) context.getSystemService("audio")) == null) {
            return -1;
        }
        return audioManager.getStreamVolume(3);
    }

    public boolean isCharging(android.content.Context context) {
        android.content.Intent registerReceiver;
        if (context == null || (registerReceiver = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    public boolean isSystemAlertPermissions(android.content.Context context) {
        if (context == null) {
            return false;
        }
        return checkFloatPermission(context);
    }
}
