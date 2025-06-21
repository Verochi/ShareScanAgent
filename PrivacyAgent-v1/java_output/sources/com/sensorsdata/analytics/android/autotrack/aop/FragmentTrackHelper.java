package com.sensorsdata.analytics.android.autotrack.aop;

/* loaded from: classes19.dex */
public class FragmentTrackHelper {
    private static final java.util.concurrent.CopyOnWriteArraySet<com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks> FRAGMENT_CALLBACKS = new java.util.concurrent.CopyOnWriteArraySet<>();

    public static void addFragmentCallbacks(com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks sAFragmentLifecycleCallbacks) {
        if (sAFragmentLifecycleCallbacks != null) {
            FRAGMENT_CALLBACKS.add(sAFragmentLifecycleCallbacks);
        }
    }

    public static void onFragmentViewCreated(java.lang.Object obj, android.view.View view, android.os.Bundle bundle) {
        if (com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.isFragment(obj)) {
            java.util.Iterator<com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks> it = FRAGMENT_CALLBACKS.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onViewCreated(obj, view, bundle);
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
        }
    }

    public static void removeFragmentCallbacks(com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks sAFragmentLifecycleCallbacks) {
        if (sAFragmentLifecycleCallbacks != null) {
            FRAGMENT_CALLBACKS.remove(sAFragmentLifecycleCallbacks);
        }
    }

    public static void trackFragmentPause(java.lang.Object obj) {
        if (com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.isFragment(obj)) {
            java.util.Iterator<com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks> it = FRAGMENT_CALLBACKS.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onPause(obj);
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
        }
    }

    public static void trackFragmentResume(java.lang.Object obj) {
        if (com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.isFragment(obj)) {
            java.util.Iterator<com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks> it = FRAGMENT_CALLBACKS.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onResume(obj);
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
        }
    }

    public static void trackFragmentSetUserVisibleHint(java.lang.Object obj, boolean z) {
        if (com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.isFragment(obj)) {
            java.util.Iterator<com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks> it = FRAGMENT_CALLBACKS.iterator();
            while (it.hasNext()) {
                try {
                    it.next().setUserVisibleHint(obj, z);
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
        }
    }

    public static void trackOnHiddenChanged(java.lang.Object obj, boolean z) {
        if (com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.isFragment(obj)) {
            java.util.Iterator<com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks> it = FRAGMENT_CALLBACKS.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onHiddenChanged(obj, z);
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
        }
    }
}
