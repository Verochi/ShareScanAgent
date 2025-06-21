package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class WindowHelper {
    private static boolean sArrayListWindowViews = false;
    private static final java.lang.String sCustomWindowPrefix = "/CustomWindow";
    private static final java.lang.String sDialogWindowPrefix = "/DialogWindow";
    private static boolean sIsInitialized = false;
    private static java.lang.reflect.Method sItemViewGetDataMethod = null;
    private static java.lang.Class<?> sListMenuItemViewClazz = null;
    private static final java.lang.String sMainWindowPrefix = "/MainWindow";
    private static java.lang.Class sPhoneWindowClazz = null;
    private static java.lang.Class sPopupWindowClazz = null;
    private static final java.lang.String sPopupWindowPrefix = "/PopupWindow";
    private static boolean sViewArrayWindowViews;
    private static java.util.Comparator<android.view.View> sViewSizeComparator = new com.sensorsdata.analytics.android.sdk.util.WindowHelper.AnonymousClass1();
    private static java.lang.Object sWindowManger;
    private static java.lang.reflect.Field viewsField;

    /* renamed from: com.sensorsdata.analytics.android.sdk.util.WindowHelper$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.Comparator<android.view.View> {
        @Override // java.util.Comparator
        public int compare(android.view.View view, android.view.View view2) {
            int hashCode = view.hashCode();
            int hashCode2 = view2.hashCode();
            int currentRootWindowsHashCode = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getCurrentRootWindowsHashCode();
            if (hashCode == currentRootWindowsHashCode) {
                return -1;
            }
            if (hashCode2 == currentRootWindowsHashCode) {
                return 1;
            }
            return (view2.getWidth() * view2.getHeight()) - (view.getWidth() * view.getHeight());
        }
    }

    private static android.view.View[] filterNullAndDismissToastView(android.view.View[] viewArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList(viewArr.length);
        java.lang.System.currentTimeMillis();
        for (android.view.View view : viewArr) {
            if (view != null) {
                arrayList.add(view);
            }
        }
        android.view.View[] viewArr2 = new android.view.View[arrayList.size()];
        arrayList.toArray(viewArr2);
        return viewArr2;
    }

    private static android.view.View findMenuItemView(android.view.View view, android.view.MenuItem menuItem) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
        android.view.View view2;
        if ((com.sensorsdata.analytics.android.sdk.util.SAViewUtils.instanceOfActionMenuItem(menuItem) && menuItem.getItemId() == 16908332 && com.sensorsdata.analytics.android.sdk.util.SAViewUtils.instanceOfToolbar(view.getParent()) && (view instanceof android.widget.ImageButton) && (view2 = (android.view.View) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField(new java.lang.String[]{"androidx.appcompat.widget.Toolbar", "androidx.appcompat.widget.Toolbar", "android.widget.Toolbar"}, view.getParent(), "mNavButtonView")) != null && view2 == view) || getMenuItemData(view) == menuItem) {
            return view;
        }
        if (!(view instanceof android.view.ViewGroup)) {
            return null;
        }
        int i = 0;
        while (true) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return null;
            }
            android.view.View findMenuItemView = findMenuItemView(viewGroup.getChildAt(i), menuItem);
            if (findMenuItemView != null) {
                return findMenuItemView;
            }
            i++;
        }
    }

    private static android.view.View findTabView(android.view.View view, java.lang.String str) {
        int i = 0;
        if (android.text.TextUtils.equals(str, getTabHostTag(view))) {
            return (android.view.View) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callMethod(view, "getCurrentTabView", new java.lang.Object[0]);
        }
        if (!(view instanceof android.view.ViewGroup)) {
            return null;
        }
        while (true) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return null;
            }
            android.view.View findTabView = findTabView(viewGroup.getChildAt(i), str);
            if (findTabView != null) {
                return findTabView;
            }
            i++;
        }
    }

    public static android.view.View getClickView(android.view.MenuItem menuItem) {
        android.view.View findMenuItemView;
        android.view.View findMenuItemView2;
        if (menuItem == null) {
            return null;
        }
        init();
        android.view.View[] windowViews = getWindowViews();
        try {
            for (android.view.View view : windowViews) {
                if (view.getClass() == sPopupWindowClazz && (findMenuItemView2 = findMenuItemView(view, menuItem)) != null) {
                    return findMenuItemView2;
                }
            }
            for (android.view.View view2 : windowViews) {
                if (view2.getClass() != sPopupWindowClazz && (findMenuItemView = findMenuItemView(view2, menuItem)) != null) {
                    return findMenuItemView;
                }
            }
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException | java.lang.Exception unused) {
        }
        return null;
    }

    public static android.view.View getClickView(java.lang.String str) {
        android.view.View findTabView;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        init();
        for (android.view.View view : getWindowViews()) {
            try {
                if (view.getClass() != sPopupWindowClazz && (findTabView = findTabView(view, str)) != null) {
                    return findTabView;
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    public static java.lang.String getMainWindowPrefix() {
        return sMainWindowPrefix;
    }

    @android.annotation.SuppressLint({"RestrictedApi"})
    private static java.lang.Object getMenuItemData(android.view.View view) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
        if (view.getClass() == sListMenuItemViewClazz) {
            return sItemViewGetDataMethod.invoke(view, new java.lang.Object[0]);
        }
        if (com.sensorsdata.analytics.android.sdk.util.SAViewUtils.instanceOfAndroidXListMenuItemView(view) || com.sensorsdata.analytics.android.sdk.util.SAViewUtils.instanceOfSupportListMenuItemView(view) || com.sensorsdata.analytics.android.sdk.util.SAViewUtils.instanceOfBottomNavigationItemView(view)) {
            return com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getMenuItemData(view);
        }
        return null;
    }

    public static android.view.View[] getSortedWindowViews() {
        android.view.View[] windowViews = getWindowViews();
        if (windowViews.length <= 1) {
            return windowViews;
        }
        android.view.View[] viewArr = (android.view.View[]) java.util.Arrays.copyOf(windowViews, windowViews.length);
        java.util.Arrays.sort(viewArr, sViewSizeComparator);
        return viewArr;
    }

    private static java.lang.String getSubWindowPrefix(android.view.View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof android.view.WindowManager.LayoutParams)) {
            int i = ((android.view.WindowManager.LayoutParams) layoutParams).type;
            if (i == 1) {
                return sMainWindowPrefix;
            }
            if (i < 99 && view.getClass() == sPhoneWindowClazz) {
                return sDialogWindowPrefix;
            }
            if (i < 1999 && view.getClass() == sPopupWindowClazz) {
                return sPopupWindowPrefix;
            }
            if (i < 2999) {
                return sCustomWindowPrefix;
            }
        }
        java.lang.Class<?> cls = view.getClass();
        return cls == sPhoneWindowClazz ? sDialogWindowPrefix : cls == sPopupWindowClazz ? sPopupWindowPrefix : sCustomWindowPrefix;
    }

    private static java.lang.String getTabHostTag(android.view.View view) {
        if (view instanceof android.widget.TabHost) {
            return (java.lang.String) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callMethod(view, "getCurrentTabTag", new java.lang.Object[0]);
        }
        return null;
    }

    public static java.lang.String getWindowPrefix(android.view.View view) {
        return view.hashCode() == com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getCurrentRootWindowsHashCode() ? getMainWindowPrefix() : getSubWindowPrefix(view);
    }

    private static android.view.View[] getWindowViews() {
        android.view.View[] viewArr = new android.view.View[0];
        java.lang.Object obj = sWindowManger;
        android.view.View[] viewArr2 = null;
        r3 = null;
        android.view.View view = null;
        if (obj == null) {
            android.app.Activity foregroundActivity = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity();
            if (foregroundActivity != null) {
                android.view.Window window = foregroundActivity.getWindow();
                if (window.isActive()) {
                    view = window.getDecorView();
                }
            }
            return foregroundActivity != null ? new android.view.View[]{view} : viewArr;
        }
        try {
            if (sArrayListWindowViews) {
                viewArr2 = (android.view.View[]) ((java.util.ArrayList) viewsField.get(obj)).toArray(viewArr);
            } else if (sViewArrayWindowViews) {
                viewArr2 = (android.view.View[]) viewsField.get(obj);
            }
            if (viewArr2 != null) {
                viewArr = viewArr2;
            }
        } catch (java.lang.Exception unused) {
        }
        return filterNullAndDismissToastView(viewArr);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007a -> B:17:0x007a). Please report as a decompilation issue!!! */
    public static void init() {
        if (sIsInitialized) {
            return;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.view.WindowManagerGlobal");
            viewsField = cls.getDeclaredField("mViews");
            java.lang.reflect.Field declaredField = cls.getDeclaredField("sDefaultWindowManager");
            viewsField.setAccessible(true);
            if (viewsField.getType() == java.util.ArrayList.class) {
                sArrayListWindowViews = true;
            } else if (viewsField.getType() == android.view.View[].class) {
                sViewArrayWindowViews = true;
            }
            declaredField.setAccessible(true);
            sWindowManger = declaredField.get(null);
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchFieldException unused) {
        }
        try {
            sListMenuItemViewClazz = java.lang.Class.forName("com.android.internal.view.menu.ListMenuItemView");
            sItemViewGetDataMethod = java.lang.Class.forName("com.android.internal.view.menu.MenuView$ItemView").getDeclaredMethod("getItemData", new java.lang.Class[0]);
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException unused2) {
        }
        try {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                try {
                    sPhoneWindowClazz = java.lang.Class.forName("com.android.internal.policy.PhoneWindow$DecorView");
                } catch (java.lang.ClassNotFoundException unused3) {
                    sPhoneWindowClazz = java.lang.Class.forName("com.android.internal.policy.DecorView");
                }
            } else {
                sPhoneWindowClazz = java.lang.Class.forName("com.android.internal.policy.impl.PhoneWindow$DecorView");
            }
        } catch (java.lang.ClassNotFoundException unused4) {
        }
        try {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                sPopupWindowClazz = java.lang.Class.forName("android.widget.PopupWindow$PopupDecorView");
            } else {
                sPopupWindowClazz = java.lang.Class.forName("android.widget.PopupWindow$PopupViewContainer");
            }
        } catch (java.lang.ClassNotFoundException unused5) {
        }
        sIsInitialized = true;
    }

    public static boolean isCustomWindow(android.view.View view) {
        return android.text.TextUtils.equals(sCustomWindowPrefix, getSubWindowPrefix(view));
    }

    public static boolean isDecorView(java.lang.Class cls) {
        if (!sIsInitialized) {
            init();
        }
        return cls == sPhoneWindowClazz || cls == sPopupWindowClazz;
    }

    public static boolean isDialogOrPopupWindow(android.view.View view) {
        java.lang.String subWindowPrefix = getSubWindowPrefix(view);
        return android.text.TextUtils.equals(sDialogWindowPrefix, subWindowPrefix) || android.text.TextUtils.equals(sPopupWindowPrefix, subWindowPrefix);
    }

    public static boolean isMainWindow(android.view.View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return (layoutParams instanceof android.view.WindowManager.LayoutParams) && ((android.view.WindowManager.LayoutParams) layoutParams).type == 1;
    }
}
