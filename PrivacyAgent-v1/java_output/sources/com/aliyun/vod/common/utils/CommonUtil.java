package com.aliyun.vod.common.utils;

/* loaded from: classes12.dex */
public class CommonUtil {

    /* renamed from: com.aliyun.vod.common.utils.CommonUtil$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.app.Application.ActivityLifecycleCallbacks {
        final /* synthetic */ java.lang.reflect.Method val$finishInputLockedMethod;
        final /* synthetic */ android.view.inputmethod.InputMethodManager val$inputMethodManager;
        final /* synthetic */ java.lang.reflect.Field val$mHField;
        final /* synthetic */ java.lang.reflect.Field val$mServedViewField;

        public AnonymousClass1(android.view.inputmethod.InputMethodManager inputMethodManager, java.lang.reflect.Field field, java.lang.reflect.Field field2, java.lang.reflect.Method method) {
            this.val$inputMethodManager = inputMethodManager;
            this.val$mHField = field;
            this.val$mServedViewField = field2;
            this.val$finishInputLockedMethod = method;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
            activity.getWindow().getDecorView().getRootView().getViewTreeObserver().addOnGlobalFocusChangeListener(new com.aliyun.vod.common.utils.CommonUtil.ReferenceCleaner(this.val$inputMethodManager, this.val$mHField, this.val$mServedViewField, this.val$finishInputLockedMethod));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
        }
    }

    public static class ReferenceCleaner implements android.os.MessageQueue.IdleHandler, android.view.View.OnAttachStateChangeListener, android.view.ViewTreeObserver.OnGlobalFocusChangeListener {
        private final java.lang.reflect.Method finishInputLockedMethod;
        private final android.view.inputmethod.InputMethodManager inputMethodManager;
        private final java.lang.reflect.Field mHField;
        private final java.lang.reflect.Field mServedViewField;

        public ReferenceCleaner(android.view.inputmethod.InputMethodManager inputMethodManager, java.lang.reflect.Field field, java.lang.reflect.Field field2, java.lang.reflect.Method method) {
            this.inputMethodManager = inputMethodManager;
            this.mHField = field;
            this.mServedViewField = field2;
            this.finishInputLockedMethod = method;
        }

        private void clearInputMethodManagerLeak() {
            try {
                synchronized (this.mHField.get(this.inputMethodManager)) {
                    android.view.View view = (android.view.View) this.mServedViewField.get(this.inputMethodManager);
                    if (view != null) {
                        boolean z = true;
                        if (view.getWindowVisibility() != 8) {
                            view.removeOnAttachStateChangeListener(this);
                            view.addOnAttachStateChangeListener(this);
                        } else {
                            android.app.Activity extractActivity = extractActivity(view.getContext());
                            if (extractActivity != null && extractActivity.getWindow() != null) {
                                android.view.View peekDecorView = extractActivity.getWindow().peekDecorView();
                                if (peekDecorView.getWindowVisibility() == 8) {
                                    z = false;
                                }
                                if (z) {
                                    peekDecorView.requestFocusFromTouch();
                                } else {
                                    this.finishInputLockedMethod.invoke(this.inputMethodManager, new java.lang.Object[0]);
                                }
                            }
                            this.finishInputLockedMethod.invoke(this.inputMethodManager, new java.lang.Object[0]);
                        }
                    }
                }
            } catch (java.lang.Exception unused) {
            }
        }

        private android.app.Activity extractActivity(android.content.Context context) {
            android.content.Context baseContext;
            while (!(context instanceof android.app.Application)) {
                if (context instanceof android.app.Activity) {
                    return (android.app.Activity) context;
                }
                if (!(context instanceof android.content.ContextWrapper) || (baseContext = ((android.content.ContextWrapper) context).getBaseContext()) == context) {
                    return null;
                }
                context = baseContext;
            }
            return null;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(android.view.View view, android.view.View view2) {
            if (view2 == null) {
                return;
            }
            if (view != null) {
                view.removeOnAttachStateChangeListener(this);
            }
            android.os.Looper.myQueue().removeIdleHandler(this);
            view2.addOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(android.view.View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
            view.removeOnAttachStateChangeListener(this);
            android.os.Looper.myQueue().removeIdleHandler(this);
            android.os.Looper.myQueue().addIdleHandler(this);
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            clearInputMethodManagerLeak();
            return false;
        }
    }

    public static long SDFreeSize() {
        if (!isReadWrite() && !isReadOnly()) {
            return -1L;
        }
        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static void clearDirectory(java.io.File file) {
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (java.io.File file2 : listFiles) {
            if (file2.isDirectory()) {
                deleteDirectory(file2);
            } else {
                file2.delete();
            }
        }
    }

    public static boolean deleteDirectory(java.io.File file) {
        clearDirectory(file);
        return file.delete();
    }

    public static void deleteFileByIds(android.content.Context context, long[] jArr) throws java.io.IOException {
        for (long j : jArr) {
            deleteDirectory(getAssetPackageDir(context, j));
        }
    }

    public static void fixFocusedViewLeak(android.app.Application application) {
        if (android.os.Build.VERSION.SDK_INT > 23) {
            return;
        }
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) application.getSystemService("input_method");
        try {
            java.lang.reflect.Field declaredField = android.view.inputmethod.InputMethodManager.class.getDeclaredField("mServedView");
            declaredField.setAccessible(true);
            java.lang.reflect.Field declaredField2 = android.view.inputmethod.InputMethodManager.class.getDeclaredField("mServedView");
            declaredField2.setAccessible(true);
            java.lang.reflect.Method declaredMethod = android.view.inputmethod.InputMethodManager.class.getDeclaredMethod("finishInputLocked", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            android.view.inputmethod.InputMethodManager.class.getDeclaredMethod("focusIn", android.view.View.class).setAccessible(true);
            application.registerActivityLifecycleCallbacks(new com.aliyun.vod.common.utils.CommonUtil.AnonymousClass1(inputMethodManager, declaredField2, declaredField, declaredMethod));
        } catch (java.lang.Exception unused) {
        }
    }

    public static void fixInputMethodManagerLeak(android.content.Context context) {
        android.view.inputmethod.InputMethodManager inputMethodManager;
        if (context == null || (inputMethodManager = (android.view.inputmethod.InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        java.lang.String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
        for (int i = 0; i < 3; i++) {
            try {
                java.lang.reflect.Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                java.lang.Object obj = declaredField.get(inputMethodManager);
                if (obj != null && (obj instanceof android.view.View)) {
                    if (((android.view.View) obj).getContext() != context) {
                        return;
                    } else {
                        declaredField.set(inputMethodManager, null);
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static java.io.File getAssetPackageDir(android.content.Context context, long j) throws java.io.FileNotFoundException, java.lang.IllegalArgumentException {
        java.io.File resourcesUnzipPath = getResourcesUnzipPath(context);
        if (resourcesUnzipPath == null) {
            throw new java.io.FileNotFoundException();
        }
        return new java.io.File(resourcesUnzipPath, "Shop_Effect_" + java.lang.String.valueOf(j));
    }

    public static java.lang.String getDatabasePath(android.content.Context context) {
        return android.os.Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName() + "/qupai.db";
    }

    public static java.io.File getResourcesUnzipPath(android.content.Context context) {
        java.io.File externalFilesDir = context.getExternalFilesDir(android.os.Environment.DIRECTORY_MUSIC);
        if (externalFilesDir == null || !externalFilesDir.exists()) {
            return null;
        }
        return externalFilesDir;
    }

    public static boolean hasNetwork(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isReadOnly() {
        return android.os.Environment.getExternalStorageState().equals("mounted_ro");
    }

    public static boolean isReadWrite() {
        return android.os.Environment.getExternalStorageState().equals("mounted");
    }
}
