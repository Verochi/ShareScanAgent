package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class ToastUtil {
    private static final java.lang.String TAG = "ToastUtil";
    private static final android.os.Handler mToastMainHandler = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.sensorsdata.analytics.android.sdk.util.ToastUtil$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ int val$lengthLong;
        final /* synthetic */ java.lang.String val$message;

        public AnonymousClass1(android.content.Context context, java.lang.String str, int i) {
            this.val$context = context;
            this.val$message = str;
            this.val$lengthLong = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.util.ToastUtil.showToast(this.val$context, this.val$message, this.val$lengthLong);
        }
    }

    public static class HandlerProxy extends android.os.Handler {
        private android.os.Handler mHandler;

        public HandlerProxy(android.os.Handler handler) {
            this.mHandler = handler;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            try {
                this.mHandler.handleMessage(message);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private static void hookToast(android.widget.Toast toast) {
        java.lang.reflect.Field findFieldObj;
        int i = android.os.Build.VERSION.SDK_INT;
        if (26 > i || (isHuaWei() && 26 == i)) {
            try {
                java.lang.Object findFieldRecur = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findFieldRecur(toast, "mTN");
                if (findFieldRecur == null || (findFieldObj = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findFieldObj(findFieldRecur.getClass(), "mHandler")) == null) {
                    return;
                }
                findFieldObj.setAccessible(true);
                findFieldObj.set(findFieldRecur, new com.sensorsdata.analytics.android.sdk.util.ToastUtil.HandlerProxy((android.os.Handler) findFieldObj.get(findFieldRecur)));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    private static boolean isHuaWei() {
        java.lang.String manufacturer = com.sensorsdata.analytics.android.sdk.util.DeviceUtils.getManufacturer();
        if (manufacturer == null) {
            return false;
        }
        return manufacturer.equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_HON) || manufacturer.equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_HW);
    }

    public static void showLong(android.content.Context context, java.lang.String str) {
        if (context == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, com.anythink.expressad.foundation.g.b.b.a);
        } else {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            showToastToMain(context.getApplicationContext(), str, 1);
        }
    }

    public static void showShort(android.content.Context context, java.lang.String str) {
        if (context == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, com.anythink.expressad.foundation.g.b.b.a);
        } else {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            showToastToMain(context.getApplicationContext(), str, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showToast(android.content.Context context, java.lang.String str, int i) {
        android.widget.Toast makeText = android.widget.Toast.makeText(context, str, i);
        hookToast(makeText);
        makeText.show();
    }

    private static void showToastToMain(android.content.Context context, java.lang.String str, int i) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            showToast(context, str, i);
        } else {
            mToastMainHandler.post(new com.sensorsdata.analytics.android.sdk.util.ToastUtil.AnonymousClass1(context, str, i));
        }
    }
}
