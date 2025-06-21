package com.jd.ad.sdk.fdt.utils;

/* loaded from: classes23.dex */
public class ActLifecycle implements android.app.Application.ActivityLifecycleCallbacks {
    public static final java.util.concurrent.CopyOnWriteArrayList<com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an> jad_bo = new java.util.concurrent.CopyOnWriteArrayList<>();
    public static final java.util.concurrent.CopyOnWriteArrayList<com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener> jad_cp = new java.util.concurrent.CopyOnWriteArrayList<>();
    public final java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<android.app.Activity>> jad_an = new java.util.concurrent.CopyOnWriteArrayList<>();

    public interface OnLifecycleChangeListener {
        void onActivityDestroyed(@androidx.annotation.NonNull android.app.Activity activity);

        void onActivityPaused(@androidx.annotation.NonNull android.app.Activity activity);

        void onActivityResumed(@androidx.annotation.NonNull android.app.Activity activity);

        void onActivityStopped(@androidx.annotation.NonNull android.app.Activity activity);
    }

    public interface jad_an {
        void jad_an();

        void jad_bo();
    }

    public static void addLifecycleListener(com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener onLifecycleChangeListener) {
        if (onLifecycleChangeListener == null) {
            return;
        }
        jad_cp.add(onLifecycleChangeListener);
    }

    public static void jad_an(com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an jad_anVar) {
        jad_bo.add(jad_anVar);
    }

    public static void removeLifecycleListener(com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener onLifecycleChangeListener) {
        if (onLifecycleChangeListener == null) {
            return;
        }
        jad_cp.remove(onLifecycleChangeListener);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@androidx.annotation.NonNull android.app.Activity activity) {
        java.util.concurrent.CopyOnWriteArrayList<com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener> copyOnWriteArrayList = jad_cp;
        if (copyOnWriteArrayList.size() > 0) {
            java.util.Iterator<com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener next = it.next();
                if (next != null) {
                    next.onActivityDestroyed(activity);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@androidx.annotation.NonNull android.app.Activity activity) {
        java.util.concurrent.CopyOnWriteArrayList<com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener> copyOnWriteArrayList = jad_cp;
        if (copyOnWriteArrayList.size() > 0) {
            java.util.Iterator<com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener next = it.next();
                if (next != null) {
                    next.onActivityPaused(activity);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@androidx.annotation.NonNull android.app.Activity activity) {
        java.util.concurrent.CopyOnWriteArrayList<com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener> copyOnWriteArrayList = jad_cp;
        if (copyOnWriteArrayList.size() > 0) {
            java.util.Iterator<com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener next = it.next();
                if (next != null) {
                    next.onActivityResumed(activity);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@androidx.annotation.NonNull android.app.Activity activity) {
        if (this.jad_an.size() == 0) {
            java.util.concurrent.CopyOnWriteArrayList<com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an> copyOnWriteArrayList = jad_bo;
            if (copyOnWriteArrayList.size() > 0) {
                java.util.Iterator<com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an next = it.next();
                    if (next != null) {
                        next.jad_an();
                    }
                }
            }
        }
        if (activity == null) {
            return;
        }
        this.jad_an.add(new java.lang.ref.WeakReference<>(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@androidx.annotation.NonNull android.app.Activity activity) {
        if (this.jad_an.size() > 0) {
            java.util.Iterator<java.lang.ref.WeakReference<android.app.Activity>> it = this.jad_an.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                java.lang.ref.WeakReference<android.app.Activity> next = it.next();
                if (next.get() == activity) {
                    this.jad_an.remove(next);
                    break;
                }
            }
        }
        if (this.jad_an.size() == 0) {
            java.util.concurrent.CopyOnWriteArrayList<com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an> copyOnWriteArrayList = jad_bo;
            if (copyOnWriteArrayList.size() > 0) {
                java.util.Iterator<com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an> it2 = copyOnWriteArrayList.iterator();
                while (it2.hasNext()) {
                    com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an next2 = it2.next();
                    if (next2 != null) {
                        next2.jad_bo();
                    }
                }
            }
        }
        java.util.concurrent.CopyOnWriteArrayList<com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener> copyOnWriteArrayList2 = jad_cp;
        if (copyOnWriteArrayList2.size() > 0) {
            java.util.Iterator<com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener> it3 = copyOnWriteArrayList2.iterator();
            while (it3.hasNext()) {
                com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener next3 = it3.next();
                if (next3 != null) {
                    next3.onActivityStopped(activity);
                }
            }
        }
    }
}
