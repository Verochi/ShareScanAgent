package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class SAFragmentUtils {

    @android.annotation.SuppressLint({"NewApi"})
    private static android.util.LruCache<java.lang.String, java.lang.ref.WeakReference<java.lang.Object>> sFragmentLruCache = new android.util.LruCache<>(Integer.MAX_VALUE);

    public static boolean fragmentGetUserVisibleHint(java.lang.Object obj) {
        try {
            return ((java.lang.Boolean) obj.getClass().getMethod("getUserVisibleHint", new java.lang.Class[0]).invoke(obj, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean fragmentIsHidden(java.lang.Object obj) {
        try {
            return ((java.lang.Boolean) obj.getClass().getMethod(com.sensorsdata.sf.ui.view.UIProperty.isHidden, new java.lang.Class[0]).invoke(obj, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean fragmentIsResumed(java.lang.Object obj) {
        try {
            return ((java.lang.Boolean) obj.getClass().getMethod("isResumed", new java.lang.Class[0]).invoke(obj, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static android.app.Activity getActivityFromFragment(java.lang.Object obj) {
        try {
            return (android.app.Activity) obj.getClass().getMethod("getActivity", new java.lang.Class[0]).invoke(obj, new java.lang.Object[0]);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.Object getFragmentFromCache(java.lang.String str) {
        java.lang.Object obj;
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            java.lang.ref.WeakReference<java.lang.Object> weakReference = sFragmentLruCache.get(str);
            if (weakReference != null && (obj = weakReference.get()) != null) {
                return obj;
            }
            java.lang.Object newInstance = java.lang.Class.forName(str).newInstance();
            sFragmentLruCache.put(str, new java.lang.ref.WeakReference<>(newInstance));
            return newInstance;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public static java.lang.Object getFragmentFromView(android.view.View view) {
        return getFragmentFromView(view, null);
    }

    public static java.lang.Object getFragmentFromView(android.view.View view, android.app.Activity activity) {
        android.view.Window window;
        if (view == null) {
            return null;
        }
        try {
            int i = com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_fragment_name;
            java.lang.String str = (java.lang.String) view.getTag(i);
            java.lang.String str2 = (java.lang.String) view.getTag(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_fragment_name2);
            if (!android.text.TextUtils.isEmpty(str2)) {
                str = str2;
            }
            if (android.text.TextUtils.isEmpty(str)) {
                if (activity == null) {
                    activity = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(view.getContext(), view);
                }
                if (activity != null && (window = activity.getWindow()) != null && window.isActive() && window.getDecorView().getRootView().getTag(i) != null) {
                    str = traverseParentViewTag(view);
                }
            }
            return getFragmentFromCache(str);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public static boolean isFragment(java.lang.Object obj) {
        java.lang.Class<?> cls;
        java.lang.Class<androidx.fragment.app.Fragment> cls2;
        java.lang.Class<androidx.fragment.app.Fragment> cls3 = androidx.fragment.app.Fragment.class;
        if (obj == null) {
            return false;
        }
        try {
            cls = java.lang.Class.forName("android.app.Fragment");
        } catch (java.lang.Exception unused) {
            cls = null;
        }
        try {
            int i = androidx.fragment.app.Fragment.n;
            cls2 = cls3;
        } catch (java.lang.Exception unused2) {
            cls2 = null;
        }
        try {
            int i2 = androidx.fragment.app.Fragment.n;
        } catch (java.lang.Exception unused3) {
            cls3 = null;
        }
        if (cls2 == null && cls3 == null && cls == null) {
            return false;
        }
        if (cls2 != null) {
            try {
                if (cls2.isInstance(obj)) {
                    return true;
                }
            } catch (java.lang.Exception unused4) {
            }
        }
        if (cls3 != null && cls3.isInstance(obj)) {
            return true;
        }
        if (cls != null) {
            if (cls.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFragmentVisible(java.lang.Object obj) {
        java.lang.Object obj2;
        try {
            obj2 = obj.getClass().getMethod("getParentFragment", new java.lang.Class[0]).invoke(obj, new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            obj2 = null;
        }
        try {
            if (obj2 == null) {
                if (!fragmentIsHidden(obj) && fragmentGetUserVisibleHint(obj) && fragmentIsResumed(obj)) {
                    return true;
                }
            } else if (!fragmentIsHidden(obj) && fragmentGetUserVisibleHint(obj) && fragmentIsResumed(obj) && !fragmentIsHidden(obj2) && fragmentGetUserVisibleHint(obj2) && fragmentIsResumed(obj2)) {
                return true;
            }
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
        return false;
    }

    public static void setFragmentToCache(java.lang.String str, java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        sFragmentLruCache.put(str, new java.lang.ref.WeakReference<>(obj));
    }

    private static java.lang.String traverseParentViewTag(android.view.View view) {
        try {
            java.lang.String str = null;
            for (android.view.ViewParent parent = view.getParent(); android.text.TextUtils.isEmpty(str) && (parent instanceof android.view.View); parent = parent.getParent()) {
                str = (java.lang.String) ((android.view.View) parent).getTag(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_fragment_name);
            }
            return str;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }
}
