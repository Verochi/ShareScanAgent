package com.sensorsdata.analytics.android.autotrack.utils;

/* loaded from: classes19.dex */
public class AutoTrackViewUtils {
    /* JADX WARN: Multi-variable type inference failed */
    private static android.view.View findTabLayout(android.view.View view) {
        android.view.ViewParent parent = view.getParent();
        if (parent instanceof android.view.ViewGroup) {
            int i = 0;
            while (true) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) parent;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                android.view.View childAt = viewGroup.getChildAt(i);
                if ("ViewPager".equals(childAt.getClass().getSimpleName())) {
                    android.view.View findTabLayoutView = findTabLayoutView(childAt);
                    if (findTabLayoutView != null) {
                        return findTabLayoutView;
                    }
                } else {
                    i++;
                }
            }
        }
        if (parent.getParent() == null) {
            return null;
        }
        return findTabLayout((android.view.View) parent);
    }

    private static android.view.View findTabLayoutView(android.view.View view) {
        java.util.List list = (java.util.List) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField(view.getClass(), view, "mOnPageChangeListeners");
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (java.lang.Object obj : list) {
            java.lang.ref.WeakReference weakReference = (java.lang.ref.WeakReference) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField(obj.getClass(), obj, "tabLayoutRef");
            if (weakReference != null && weakReference.get() != null) {
                return (android.view.View) weakReference.get();
            }
        }
        return null;
    }

    private static android.view.View getAndroidXTabLayout(java.lang.Object obj) {
        try {
            int i = com.google.android.material.tabs.TabLayout.MODE_SCROLLABLE;
            if (com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewIgnored((java.lang.Class<?>) com.google.android.material.tabs.TabLayout.class) || !com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(obj, "com.google.android.material.tabs.TabLayout$Tab")) {
                return null;
            }
            android.view.View view = (android.view.View) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField(new java.lang.String[]{"com.google.android.material.tabs.TabLayout$Tab"}, obj, "parent");
            if (view != null) {
                try {
                    if (com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(view, "com.google.android.material.tabs.TabLayout")) {
                        if (com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewIgnored(view)) {
                            return null;
                        }
                    }
                } catch (java.lang.Exception unused) {
                }
            }
            return view;
        } catch (java.lang.Exception unused2) {
            return null;
        }
    }

    private static android.view.View getSupportTabLayout(java.lang.Object obj) {
        try {
            int i = com.google.android.material.tabs.TabLayout.MODE_SCROLLABLE;
            if (com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewIgnored((java.lang.Class<?>) com.google.android.material.tabs.TabLayout.class) || !com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(obj, "com.google.android.material.tabs.TabLayout$Tab")) {
                return null;
            }
            android.view.View view = (android.view.View) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField(new java.lang.String[]{"com.google.android.material.tabs.TabLayout$Tab"}, obj, "mParent", "parent");
            if (view != null) {
                try {
                    if (com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(view, "com.google.android.material.tabs.TabLayout")) {
                        if (com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewIgnored(view)) {
                            return null;
                        }
                    }
                } catch (java.lang.Exception unused) {
                }
            }
            return view;
        } catch (java.lang.Exception unused2) {
            return null;
        }
    }

    public static android.view.View getTabLayout(java.lang.Object obj) {
        android.view.View androidXTabLayout = getAndroidXTabLayout(obj);
        return androidXTabLayout == null ? getSupportTabLayout(obj) : androidXTabLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext getTabLayoutContext(java.lang.Object obj, android.view.View view) {
        android.app.Activity activity;
        java.lang.Object obj2;
        try {
            if (!(obj instanceof android.content.Context)) {
                java.lang.reflect.Field[] declaredFields = obj.getClass().getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        activity = null;
                        obj2 = null;
                        break;
                    }
                    java.lang.reflect.Field field = declaredFields[i];
                    field.setAccessible(true);
                    obj2 = field.get(obj);
                    if (obj2 instanceof android.app.Activity) {
                        activity = (android.app.Activity) obj2;
                        break;
                    }
                    if (com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.isFragment(obj2)) {
                        activity = null;
                        break;
                    }
                    if (obj2 instanceof android.view.View) {
                        activity = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(((android.view.View) obj2).getContext(), null);
                        break;
                    }
                    i++;
                }
                if (view != null) {
                    if (activity == null) {
                        activity = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(view.getContext(), null);
                    }
                    if (obj2 == null) {
                        obj2 = com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.getFragmentFromView(view, activity);
                    }
                }
                if (activity == null && obj2 != null) {
                    activity = com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.getActivityFromFragment(obj2);
                }
                return new com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext(activity, obj2, view);
            }
            activity = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView((android.content.Context) obj, null);
            obj2 = null;
            if (view != null) {
            }
            if (activity == null) {
                activity = com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.getActivityFromFragment(obj2);
            }
            return new com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext(activity, obj2, view);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public static java.lang.String getTabLayoutText(android.view.View view, java.lang.Object obj) {
        java.lang.Object callMethod;
        java.lang.String str = null;
        if (view != null) {
            try {
                if (view instanceof android.view.ViewGroup) {
                    str = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.traverseView(new java.lang.StringBuilder(), (android.view.ViewGroup) view);
                    if (!android.text.TextUtils.isEmpty(str)) {
                        str = str.substring(0, str.length() - 1);
                    }
                } else {
                    str = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(view);
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
        return (!android.text.TextUtils.isEmpty(str) || (callMethod = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callMethod(obj, "getText", new java.lang.Object[0])) == null) ? str : callMethod.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0025, code lost:
    
        if (com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewIgnored(r1) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0027, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static android.view.View getTabView(java.lang.String str) {
        android.view.View clickView = com.sensorsdata.analytics.android.sdk.util.WindowHelper.getClickView(str);
        if (clickView != null) {
            android.view.View view = clickView;
            android.view.View view2 = null;
            while (view2 == null && view != null && view.getParent() != null) {
                view = (android.view.View) view.getParent();
                if (view instanceof android.widget.TabHost) {
                    view2 = view;
                }
            }
        }
        return clickView;
    }

    public static boolean isBindViewPager(android.view.View view) {
        if (view == null) {
            return false;
        }
        return ((android.view.View) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField(view.getClass(), view, "viewPager")) != null || view == findTabLayout(view);
    }
}
