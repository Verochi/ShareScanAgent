package com.sensorsdata.analytics.android.sdk.util.visual;

/* loaded from: classes19.dex */
public class ViewUtil {
    private static boolean sHaveCustomRecyclerView;
    private static java.lang.Class<?> sRecyclerViewClass;
    private static java.lang.reflect.Method sRecyclerViewGetChildAdapterPositionMethod;
    private static final boolean sHaveRecyclerView = haveRecyclerView();
    private static final android.util.SparseArray<java.lang.String> sViewCache = new android.util.SparseArray<>();

    private static void checkAndInvalidate(android.view.View view) {
        if (view.getLayerType() != 0) {
            view.invalidate();
        }
    }

    private static void checkCustomRecyclerView(java.lang.Class<?> cls, java.lang.String str) {
        if (sHaveRecyclerView || sHaveCustomRecyclerView || str == null || !str.contains("RecyclerView")) {
            return;
        }
        try {
            if (findRecyclerInSuper(cls) == null || sRecyclerViewGetChildAdapterPositionMethod == null) {
                return;
            }
            sRecyclerViewClass = cls;
            sHaveCustomRecyclerView = true;
        } catch (java.lang.Exception unused) {
        }
    }

    public static void clear() {
        android.util.SparseArray<java.lang.String> sparseArray = sViewCache;
        synchronized (sparseArray) {
            sparseArray.clear();
        }
    }

    private static java.lang.Class<?> findRecyclerInSuper(java.lang.Class<?> cls) {
        while (cls != null && !cls.equals(android.view.ViewGroup.class)) {
            try {
                sRecyclerViewGetChildAdapterPositionMethod = cls.getMethod("getChildAdapterPosition", android.view.View.class);
            } catch (java.lang.NoSuchMethodException unused) {
            }
            if (sRecyclerViewGetChildAdapterPositionMethod == null) {
                try {
                    sRecyclerViewGetChildAdapterPositionMethod = cls.getMethod("getChildPosition", android.view.View.class);
                } catch (java.lang.NoSuchMethodException unused2) {
                }
            }
            if (sRecyclerViewGetChildAdapterPositionMethod != null) {
                return cls;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private static java.lang.String getCanonicalAndCheckCustomView(java.lang.Class<?> cls) {
        java.lang.String canonicalName = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getCanonicalName(cls);
        if (canonicalName != null) {
            checkCustomRecyclerView(cls, canonicalName);
        }
        return canonicalName;
    }

    private static int getChildAdapterPositionInRecyclerView(android.view.View view, android.view.ViewGroup viewGroup) {
        java.lang.Object invoke;
        if (!instanceOfRecyclerView(viewGroup)) {
            if (sHaveCustomRecyclerView) {
                return invokeCRVGetChildAdapterPositionMethod(viewGroup, view);
            }
            return -1;
        }
        try {
            sRecyclerViewGetChildAdapterPositionMethod = viewGroup.getClass().getMethod("getChildAdapterPosition", android.view.View.class);
        } catch (java.lang.NoSuchMethodException unused) {
        }
        if (sRecyclerViewGetChildAdapterPositionMethod == null) {
            try {
                sRecyclerViewGetChildAdapterPositionMethod = viewGroup.getClass().getMethod("getChildPosition", android.view.View.class);
            } catch (java.lang.NoSuchMethodException unused2) {
            }
        }
        try {
            java.lang.reflect.Method method = sRecyclerViewGetChildAdapterPositionMethod;
            if (method == null || (invoke = method.invoke(viewGroup, view)) == null) {
                return -1;
            }
            return ((java.lang.Integer) invoke).intValue();
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused3) {
            return -1;
        }
    }

    private static int getCurrentItem(android.view.View view) {
        try {
            java.lang.Object invoke = view.getClass().getMethod("getCurrentItem", new java.lang.Class[0]).invoke(view, new java.lang.Object[0]);
            if (invoke != null) {
                return ((java.lang.Integer) invoke).intValue();
            }
            return -1;
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            return -1;
        }
    }

    public static int getMainWindowCount(android.view.View[] viewArr) {
        com.sensorsdata.analytics.android.sdk.util.WindowHelper.init();
        int i = 0;
        for (android.view.View view : viewArr) {
            if (view != null) {
                i += com.sensorsdata.analytics.android.sdk.util.WindowHelper.getWindowPrefix(view).equals(com.sensorsdata.analytics.android.sdk.util.WindowHelper.getMainWindowPrefix()) ? 1 : 0;
            }
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static com.sensorsdata.analytics.android.sdk.util.visual.ViewNode getViewNode(android.view.View view, int i, boolean z) {
        boolean z2;
        int viewPosition = getViewPosition(view, i);
        android.view.ViewParent parent = view.getParent();
        if (parent == 0) {
            return null;
        }
        if ((com.sensorsdata.analytics.android.sdk.util.WindowHelper.isDecorView(view.getClass()) && !(parent instanceof android.view.View)) || !(parent instanceof android.view.View)) {
            return null;
        }
        android.view.View view2 = (android.view.View) parent;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        java.lang.String canonicalAndCheckCustomView = getCanonicalAndCheckCustomView(view.getClass());
        java.lang.Object parent2 = view2.getParent();
        if (parent2 instanceof android.view.View) {
            android.view.View view3 = (android.view.View) parent2;
            android.util.SparseArray<java.lang.String> sparseArray = sViewCache;
            synchronized (sparseArray) {
                java.lang.String str = sparseArray.get(view3.hashCode());
                r3 = android.text.TextUtils.isEmpty(str) ? null : str;
            }
        }
        boolean z3 = true;
        if (view2 instanceof android.widget.ExpandableListView) {
            android.widget.ExpandableListView expandableListView = (android.widget.ExpandableListView) view2;
            long expandableListPosition = expandableListView.getExpandableListPosition(viewPosition);
            if (android.widget.ExpandableListView.getPackedPositionType(expandableListPosition) != 2) {
                int packedPositionGroup = android.widget.ExpandableListView.getPackedPositionGroup(expandableListPosition);
                int packedPositionChild = android.widget.ExpandableListView.getPackedPositionChild(expandableListPosition);
                if (packedPositionChild != -1) {
                    r3 = java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "%d:%d", java.lang.Integer.valueOf(packedPositionGroup), java.lang.Integer.valueOf(packedPositionChild));
                    sb2.append((java.lang.CharSequence) sb);
                    sb2.append("/ELVG[");
                    sb2.append(packedPositionGroup);
                    sb2.append("]/ELVC[-]/");
                    sb2.append(canonicalAndCheckCustomView);
                    sb2.append("[0]");
                    sb.append("/ELVG[");
                    sb.append(packedPositionGroup);
                    sb.append("]/ELVC[");
                    sb.append(packedPositionChild);
                    sb.append("]/");
                    sb.append(canonicalAndCheckCustomView);
                    sb.append("[0]");
                } else {
                    java.lang.String format = java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, com.google.android.material.timepicker.TimeModel.NUMBER_FORMAT, java.lang.Integer.valueOf(packedPositionGroup));
                    sb2.append((java.lang.CharSequence) sb);
                    sb2.append("/ELVG[-]/");
                    sb2.append(canonicalAndCheckCustomView);
                    sb2.append("[0]");
                    sb.append("/ELVG[");
                    sb.append(packedPositionGroup);
                    sb.append("]/");
                    sb.append(canonicalAndCheckCustomView);
                    sb.append("[0]");
                    r3 = format;
                }
            } else {
                if (viewPosition < expandableListView.getHeaderViewsCount()) {
                    sb.append("/ELH[");
                    sb.append(viewPosition);
                    sb.append("]/");
                    sb.append(canonicalAndCheckCustomView);
                    sb.append("[0]");
                    sb2.append("/ELH[");
                    sb2.append(viewPosition);
                    sb2.append("]/");
                    sb2.append(canonicalAndCheckCustomView);
                    sb2.append("[0]");
                } else {
                    int count = viewPosition - (expandableListView.getCount() - expandableListView.getFooterViewsCount());
                    sb.append("/ELF[");
                    sb.append(count);
                    sb.append("]/");
                    sb.append(canonicalAndCheckCustomView);
                    sb.append("[0]");
                    sb2.append("/ELF[");
                    sb2.append(count);
                    sb2.append("]/");
                    sb2.append(canonicalAndCheckCustomView);
                    sb2.append("[0]");
                }
                z3 = false;
            }
            z2 = z3;
        } else if (isListView(view2)) {
            java.lang.String format2 = java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, com.google.android.material.timepicker.TimeModel.NUMBER_FORMAT, java.lang.Integer.valueOf(viewPosition));
            sb2.append((java.lang.CharSequence) sb);
            sb2.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            sb2.append(canonicalAndCheckCustomView);
            sb2.append("[-]");
            sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            sb.append(canonicalAndCheckCustomView);
            sb.append("[");
            sb.append(format2);
            sb.append("]");
            r3 = format2;
            z2 = true;
        } else {
            if (instanceOfSupportSwipeRefreshLayout(view2)) {
                sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                sb.append(canonicalAndCheckCustomView);
                sb.append("[0]");
                sb2.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                sb2.append(canonicalAndCheckCustomView);
                sb2.append("[0]");
            } else {
                java.lang.Object instanceOfFragmentRootView = instanceOfFragmentRootView(view2, view);
                if (instanceOfFragmentRootView != null) {
                    java.lang.String canonicalAndCheckCustomView2 = getCanonicalAndCheckCustomView(instanceOfFragmentRootView.getClass());
                    sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                    sb.append(canonicalAndCheckCustomView2);
                    sb.append("[0]");
                    sb2.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                    sb2.append(canonicalAndCheckCustomView2);
                    sb2.append("[0]");
                } else {
                    int childIndex = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getChildIndex(parent, view);
                    sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                    sb.append(canonicalAndCheckCustomView);
                    sb.append("[");
                    sb.append(childIndex);
                    sb.append("]");
                    sb2.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                    sb2.append(canonicalAndCheckCustomView);
                    sb2.append("[");
                    sb2.append(childIndex);
                    sb2.append("]");
                }
            }
            z2 = false;
        }
        if (com.sensorsdata.analytics.android.sdk.util.WindowHelper.isDecorView(view2.getClass())) {
            if (sb.length() > 0) {
                sb.deleteCharAt(0);
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(0);
            }
        }
        if (!android.text.TextUtils.isEmpty(r3)) {
            android.util.SparseArray<java.lang.String> sparseArray2 = sViewCache;
            synchronized (sparseArray2) {
                sparseArray2.put(view2.hashCode(), r3);
            }
        }
        return new com.sensorsdata.analytics.android.sdk.util.visual.ViewNode(view, r3, sb.toString(), sb2.toString(), com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(view, z), com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewType(view), z2);
    }

    public static com.sensorsdata.analytics.android.sdk.util.visual.ViewNode getViewPathAndPosition(android.view.View view, boolean z) {
        int indexOf;
        java.util.ArrayList arrayList = new java.util.ArrayList(8);
        arrayList.add(view);
        for (android.view.ViewParent parent = view.getParent(); parent instanceof android.view.ViewGroup; parent = parent.getParent()) {
            arrayList.add((android.view.ViewGroup) parent);
        }
        int size = arrayList.size() - 1;
        android.view.View view2 = (android.view.View) arrayList.get(size);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        java.lang.String str = null;
        if (!(view2 instanceof android.view.ViewGroup)) {
            return null;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view2;
        java.lang.String str2 = null;
        for (int i = size - 1; i >= 0; i--) {
            android.view.View view3 = (android.view.View) arrayList.get(i);
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode = getViewNode(view3, viewGroup.indexOfChild(view3), z);
            if (viewNode != null) {
                if (!android.text.TextUtils.isEmpty(viewNode.getViewPath()) && viewNode.getViewPath().contains(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER) && !android.text.TextUtils.isEmpty(str) && (indexOf = sb2.indexOf(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != -1) {
                    sb2.replace(indexOf, indexOf + 1, java.lang.String.valueOf(str));
                }
                sb.append(viewNode.getViewOriginalPath());
                sb2.append(viewNode.getViewPath());
                str = viewNode.getViewPosition();
                str2 = viewNode.getViewContent();
            }
            if (!(view3 instanceof android.view.ViewGroup)) {
                break;
            }
            viewGroup = (android.view.ViewGroup) view3;
        }
        return new com.sensorsdata.analytics.android.sdk.util.visual.ViewNode(view, str, sb.toString(), sb2.toString(), str2);
    }

    private static int getViewPosition(android.view.View view, int i) {
        int childAdapterPositionInRecyclerView;
        if (view.getParent() == null || !(view.getParent() instanceof android.view.ViewGroup)) {
            return i;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
        return (instanceOfAndroidXViewPager(viewGroup) || instanceOfSupportViewPager(viewGroup)) ? getCurrentItem(viewGroup) : viewGroup instanceof android.widget.AdapterView ? i + ((android.widget.AdapterView) viewGroup).getFirstVisiblePosition() : (!instanceOfRecyclerView(viewGroup) || (childAdapterPositionInRecyclerView = getChildAdapterPositionInRecyclerView(view, viewGroup)) < 0) ? i : childAdapterPositionInRecyclerView;
    }

    private static boolean haveRecyclerView() {
        try {
            try {
                int i = androidx.recyclerview.widget.RecyclerView.HORIZONTAL;
                return true;
            } catch (java.lang.ClassNotFoundException unused) {
                return false;
            }
        } catch (java.lang.ClassNotFoundException unused2) {
            int i2 = androidx.recyclerview.widget.RecyclerView.HORIZONTAL;
            return true;
        }
    }

    private static boolean instanceOfAndroidXViewPager(java.lang.Object obj) {
        return com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(obj, "androidx.viewpager.widget.ViewPager");
    }

    public static boolean instanceOfFlutterActivity(java.lang.Object obj) {
        return com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(obj, "io.flutter.embedding.android.FlutterActivity");
    }

    public static boolean instanceOfFlutterSurfaceView(java.lang.Object obj) {
        return com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(obj, "io.flutter.embedding.android.FlutterSurfaceView");
    }

    private static java.lang.Object instanceOfFragmentRootView(android.view.View view, android.view.View view2) {
        java.lang.Object fragmentFromView = com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.getFragmentFromView(view);
        java.lang.Object fragmentFromView2 = com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.getFragmentFromView(view2);
        if (fragmentFromView != null || fragmentFromView2 == null) {
            return null;
        }
        return fragmentFromView2;
    }

    public static boolean instanceOfRecyclerView(java.lang.Object obj) {
        java.lang.Class<?> cls;
        boolean isInstance = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(obj, "androidx.recyclerview.widget.RecyclerView", "androidx.recyclerview.widget.RecyclerView");
        return !isInstance ? sHaveCustomRecyclerView && obj != null && (cls = sRecyclerViewClass) != null && cls.isAssignableFrom(obj.getClass()) : isInstance;
    }

    private static boolean instanceOfSupportSwipeRefreshLayout(java.lang.Object obj) {
        return com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(obj, "androidx.swiperefreshlayout.widget.SwipeRefreshLayout", "androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
    }

    private static boolean instanceOfSupportViewPager(java.lang.Object obj) {
        return com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(obj, "androidx.viewpager.widget.ViewPager");
    }

    private static boolean instanceOfUCWebView(java.lang.Object obj) {
        return com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(obj, "com.alipay.mobile.nebulauc.impl.UCWebView$WebViewEx");
    }

    public static boolean instanceOfWebView(java.lang.Object obj) {
        return (obj instanceof android.webkit.WebView) || instanceOfX5WebView(obj) || instanceOfUCWebView(obj);
    }

    public static boolean instanceOfX5WebView(java.lang.Object obj) {
        return com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(obj, "com.tencent.smtt.sdk.WebView");
    }

    public static void invalidateLayerTypeView(android.view.View[] viewArr) {
        for (android.view.View view : viewArr) {
            if (viewVisibilityInParents(view) && view.isHardwareAccelerated()) {
                checkAndInvalidate(view);
                if (view instanceof android.view.ViewGroup) {
                    invalidateViewGroup((android.view.ViewGroup) view);
                }
            }
        }
    }

    private static void invalidateViewGroup(android.view.ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            android.view.View childAt = viewGroup.getChildAt(i);
            if (com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewSelfVisible(childAt)) {
                checkAndInvalidate(childAt);
                if (childAt instanceof android.view.ViewGroup) {
                    invalidateViewGroup((android.view.ViewGroup) childAt);
                }
            }
        }
    }

    private static int invokeCRVGetChildAdapterPositionMethod(android.view.View view, android.view.View view2) {
        try {
            if (view.getClass() == sRecyclerViewClass) {
                return ((java.lang.Integer) sRecyclerViewGetChildAdapterPositionMethod.invoke(view, view2)).intValue();
            }
            return -1;
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return -1;
        }
    }

    private static boolean isListView(android.view.View view) {
        return (view instanceof android.widget.AdapterView) || instanceOfRecyclerView(view) || instanceOfAndroidXViewPager(view) || instanceOfSupportViewPager(view);
    }

    public static boolean isWindowNeedTraverse(android.view.View view, java.lang.String str, boolean z) {
        if (view.hashCode() == com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getCurrentRootWindowsHashCode()) {
            return true;
        }
        if (view instanceof android.view.ViewGroup) {
            if (!z) {
                return true;
            }
            if (view.getWindowVisibility() != 8 && view.getVisibility() == 0 && !android.text.TextUtils.equals(str, com.sensorsdata.analytics.android.sdk.util.WindowHelper.getMainWindowPrefix()) && view.getWidth() != 0 && view.getHeight() != 0) {
                return true;
            }
        }
        return (view.getWindowVisibility() == 0 || view.getVisibility() == 0) && com.sensorsdata.analytics.android.sdk.util.WindowHelper.isCustomWindow(view);
    }

    public static boolean viewVisibilityInParents(android.view.View view) {
        if (view == null || !com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewSelfVisible(view)) {
            return false;
        }
        android.view.ViewParent parent = view.getParent();
        while (parent instanceof android.view.View) {
            if (!com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewSelfVisible((android.view.View) parent) || (parent = parent.getParent()) == null) {
                return false;
            }
        }
        return true;
    }
}
