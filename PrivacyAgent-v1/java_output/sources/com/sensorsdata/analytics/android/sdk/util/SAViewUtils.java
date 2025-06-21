package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class SAViewUtils {
    private static final java.lang.String TAG = "SA.SAViewUtils";
    private static java.util.List<java.lang.String> sOSViewPackage = new com.sensorsdata.analytics.android.sdk.util.SAViewUtils.AnonymousClass1();

    /* renamed from: com.sensorsdata.analytics.android.sdk.util.SAViewUtils$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.LinkedList<java.lang.String> {
        public AnonymousClass1() {
            add("android##widget");
            add("android##support##v7##widget");
            add("android##support##design##widget");
            add("android##support##text##emoji##widget");
            add("androidx##appcompat##widget");
            add("androidx##emoji##widget");
            add("androidx##cardview##widget");
            add("com##google##android##material");
        }
    }

    public static org.json.JSONObject buildTitleAndScreenName(android.app.Activity activity) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("$screen_name", activity.getClass().getCanonicalName());
            java.lang.String activityTitle = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getActivityTitle(activity);
            if (!android.text.TextUtils.isEmpty(activityTitle)) {
                jSONObject.put("$title", activityTitle);
            }
            return jSONObject;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return new org.json.JSONObject();
        }
    }

    private static void exceptionCollect(android.view.View view) {
        if (view != null) {
            try {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "viewClass:" + view.getClass());
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "viewId:" + view.getId());
                java.lang.Object parent = view.getParent();
                if (parent != null) {
                    if (parent instanceof android.view.View) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "viewParentClass->ID:" + ((android.view.View) parent).getId());
                    }
                } else if ((view instanceof android.view.ViewGroup) && ((android.view.ViewGroup) view).getChildCount() > 0) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "childView->ID:" + ((android.view.ViewGroup) view).getChildAt(0).getId());
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public static android.app.Activity getActivityOfView(android.content.Context context, android.view.View view) {
        android.app.Activity activity;
        android.app.Activity activity2 = null;
        if (context == null) {
            return null;
        }
        try {
            if (!(context instanceof android.app.Activity)) {
                if (context instanceof android.content.ContextWrapper) {
                    while (!(context instanceof android.app.Activity) && (context instanceof android.content.ContextWrapper)) {
                        context = ((android.content.ContextWrapper) context).getBaseContext();
                    }
                    if (context instanceof android.app.Activity) {
                        activity = (android.app.Activity) context;
                    }
                }
                return activity2 == null ? activity2 : activity2;
            }
            activity = (android.app.Activity) context;
            activity2 = activity;
            return activity2 == null ? activity2 : activity2;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return activity2;
        }
    }

    public static int getChildIndex(android.view.ViewParent viewParent, android.view.View view) {
        try {
            if (!(viewParent instanceof android.view.ViewGroup)) {
                return -1;
            }
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) viewParent;
            java.lang.String viewId = getViewId(view);
            java.lang.String canonicalName = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getCanonicalName(view.getClass());
            int i = 0;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                android.view.View childAt = viewGroup.getChildAt(i2);
                if (com.sensorsdata.analytics.android.sdk.util.Pathfinder.hasClassName(childAt, canonicalName)) {
                    java.lang.String viewId2 = getViewId(childAt);
                    if ((viewId == null || viewId.equals(viewId2)) && childAt == view) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static java.lang.String getElementSelector(android.view.View view) {
        java.lang.String elementSelectorOrigin;
        java.lang.String selectPath = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getSelectPath(view);
        if (selectPath != null) {
            return selectPath;
        }
        android.view.ViewParent parent = view.getParent();
        android.view.View view2 = parent instanceof android.view.ViewGroup ? (android.view.View) parent : null;
        java.lang.String selectPath2 = view2 != null ? com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getSelectPath(view2) : null;
        java.lang.String canonicalName = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getCanonicalName(view.getClass());
        if (view2 != null) {
            if (selectPath2 == null) {
                selectPath2 = getElementSelectorOrigin(view2);
                com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().setSelectPath(view2, selectPath2);
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (selectPath2 != null && !selectPath2.equals("")) {
                sb.append(selectPath2);
                sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            }
            int childIndex = getChildIndex(parent, view);
            sb.append(canonicalName);
            sb.append("[");
            sb.append(childIndex);
            sb.append("]");
            elementSelectorOrigin = sb.toString();
        } else {
            elementSelectorOrigin = getElementSelectorOrigin(view);
        }
        com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().setSelectPath(view, elementSelectorOrigin);
        return elementSelectorOrigin;
    }

    private static java.lang.String getElementSelectorOrigin(android.view.View view) {
        boolean z;
        java.util.LinkedList linkedList = new java.util.LinkedList();
        do {
            android.view.ViewParent parent = view.getParent();
            linkedList.add(view.getClass().getCanonicalName() + "[" + getChildIndex(parent, view) + "]");
            z = parent instanceof android.view.ViewGroup;
            if (z) {
                view = (android.view.ViewGroup) parent;
            }
        } while (z);
        java.util.Collections.reverse(linkedList);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 1; i < linkedList.size(); i++) {
            sb.append((java.lang.String) linkedList.get(i));
            if (i != linkedList.size() - 1) {
                sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            }
        }
        return sb.toString();
    }

    public static java.lang.Object getMenuItemData(android.view.View view) {
        try {
            return view.getClass().getMethod("getItemData", new java.lang.Class[0]).invoke(view, new java.lang.Object[0]);
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
    }

    public static org.json.JSONObject getScreenNameAndTitle(android.view.View view) {
        if (view == null) {
            return null;
        }
        android.app.Activity activityOfView = getActivityOfView(view.getContext(), view);
        if (activityOfView == null) {
            activityOfView = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity();
        }
        if (activityOfView == null || activityOfView.getWindow() == null || !activityOfView.getWindow().isActive()) {
            return null;
        }
        java.lang.Object fragmentFromView = com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.getFragmentFromView(view, activityOfView);
        if (fragmentFromView != null) {
            return com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getFragmentPageInfo(activityOfView, fragmentFromView);
        }
        org.json.JSONObject activityPageInfo = com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getActivityPageInfo(activityOfView);
        com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeDuplicateProperty(com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getRNPageInfo(), activityPageInfo);
        return activityPageInfo;
    }

    private static java.lang.String getTabLayoutContent(java.lang.Object obj) {
        try {
            java.lang.Class<?> currentClass = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getCurrentClass(new java.lang.String[]{"com.google.android.material.tabs.TabLayout$Tab", "com.google.android.material.tabs.TabLayout$Tab"});
            if (currentClass == null) {
                return null;
            }
            java.lang.Object callMethod = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callMethod(obj, "getText", new java.lang.Object[0]);
            java.lang.String obj2 = callMethod != null ? callMethod.toString() : null;
            android.view.View view = (android.view.View) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField(currentClass, obj, "mCustomView", "customView");
            if (view == null) {
                return obj2;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (!(view instanceof android.view.ViewGroup)) {
                return getViewContent(view);
            }
            java.lang.String traverseView = traverseView(sb, (android.view.ViewGroup) view);
            return !android.text.TextUtils.isEmpty(traverseView) ? traverseView.substring(0, traverseView.length() - 1) : traverseView;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String getViewContent(android.view.View view) {
        return getViewContent(view, false);
    }

    public static java.lang.String getViewContent(android.view.View view, boolean z) {
        java.lang.String text;
        try {
            if (view == null) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "getViewContent view is null");
                return "";
            }
            java.lang.String viewType = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getViewType(view);
            java.lang.String viewText = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getViewText(view);
            if (viewType == null || viewText == null) {
                if (view instanceof android.widget.CheckBox) {
                    text = ((android.widget.CheckBox) view).getText();
                } else if (view instanceof android.widget.RadioButton) {
                    text = ((android.widget.RadioButton) view).getText();
                } else if (view instanceof android.widget.ToggleButton) {
                    android.widget.ToggleButton toggleButton = (android.widget.ToggleButton) view;
                    text = toggleButton.isChecked() ? toggleButton.getTextOn() : toggleButton.getTextOff();
                } else {
                    java.lang.String str = null;
                    java.lang.Class<?> cls = null;
                    str = null;
                    str = null;
                    str = null;
                    str = null;
                    str = null;
                    str = null;
                    str = null;
                    if (view instanceof android.widget.CompoundButton) {
                        try {
                            cls = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getClassByName("androidx.appcompat.widget.SwitchCompat");
                        } catch (java.lang.Exception unused) {
                        }
                        if (cls == null) {
                            try {
                                cls = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getClassByName("androidx.appcompat.widget.SwitchCompat");
                            } catch (java.lang.Exception unused2) {
                            }
                        }
                        android.widget.CompoundButton compoundButton = (android.widget.CompoundButton) view;
                        if ((cls == null || !cls.isInstance(view)) && !(view instanceof android.widget.Switch)) {
                            text = compoundButton.getText();
                        } else {
                            text = (java.lang.String) (compoundButton.isChecked() ? view.getClass().getMethod("getTextOn", new java.lang.Class[0]) : view.getClass().getMethod("getTextOff", new java.lang.Class[0])).invoke(view, new java.lang.Object[0]);
                        }
                    } else if (view instanceof android.widget.Button) {
                        text = ((android.widget.Button) view).getText();
                    } else if (view instanceof android.widget.CheckedTextView) {
                        text = ((android.widget.CheckedTextView) view).getText();
                    } else if (view instanceof android.widget.TextView) {
                        android.widget.TextView textView = (android.widget.TextView) view;
                        if (com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField(new java.lang.String[]{"androidx.appcompat.widget.AppCompatTextView"}, textView, "mPrecomputedTextFuture") == null) {
                            text = textView.getText();
                        }
                        text = str;
                    } else if (view instanceof android.widget.ImageView) {
                        android.widget.ImageView imageView = (android.widget.ImageView) view;
                        if (!android.text.TextUtils.isEmpty(imageView.getContentDescription()) && !isWeexView(view)) {
                            text = imageView.getContentDescription().toString();
                        }
                        text = str;
                    } else if (view instanceof android.widget.RatingBar) {
                        text = java.lang.String.valueOf(((android.widget.RatingBar) view).getRating());
                    } else if (view instanceof android.widget.SeekBar) {
                        text = java.lang.String.valueOf(((android.widget.SeekBar) view).getProgress());
                    } else if (view instanceof android.widget.Spinner) {
                        text = traverseView(new java.lang.StringBuilder(), (android.view.ViewGroup) view);
                        if (!android.text.TextUtils.isEmpty(text)) {
                            text = text.toString().substring(0, text.length() - 1);
                        }
                    } else {
                        java.lang.Object instanceOfTabView = instanceOfTabView(view);
                        if (instanceOfTabView != null) {
                            text = getTabLayoutContent(instanceOfTabView);
                        } else {
                            if (instanceOfBottomNavigationItemView(view)) {
                                java.lang.Object menuItemData = getMenuItemData(view);
                                if (menuItemData != null) {
                                    try {
                                        java.lang.Class<?> currentClass = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getCurrentClass(new java.lang.String[]{"androidx.appcompat.view.menu.MenuItemImpl"});
                                        if (currentClass != null) {
                                            java.lang.String str2 = (java.lang.String) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField(currentClass, menuItemData, "mTitle");
                                            if (!android.text.TextUtils.isEmpty(str2)) {
                                                str = str2;
                                            }
                                        }
                                    } catch (java.lang.Exception unused3) {
                                    }
                                }
                            } else if (instanceOfNavigationView(view)) {
                                text = isViewSelfVisible(view) ? "Open" : "Close";
                            } else if (view instanceof android.view.ViewGroup) {
                                text = !isWeexView(view) ? view.getContentDescription() : null;
                                if (android.text.TextUtils.isEmpty(text)) {
                                    try {
                                        text = traverseView(new java.lang.StringBuilder(), (android.view.ViewGroup) view);
                                        if (!android.text.TextUtils.isEmpty(text)) {
                                            text = text.toString().substring(0, text.length() - 1);
                                        }
                                    } catch (java.lang.Exception unused4) {
                                    }
                                }
                            }
                            text = str;
                        }
                    }
                }
                if (android.text.TextUtils.isEmpty(text) && (view instanceof android.widget.TextView)) {
                    text = ((android.widget.TextView) view).getHint();
                }
                if (android.text.TextUtils.isEmpty(text) && (!isWeexView(view) || isWeexTextView(view))) {
                    text = view.getContentDescription();
                }
                viewText = text == null ? "" : text;
                com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().setViewText(view, viewText.toString());
            }
            if (view instanceof android.widget.EditText) {
                viewText = z ? ((android.widget.EditText) view).getText() : "";
            }
            if (viewText == null) {
                viewText = "";
            }
            return viewText.toString();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    public static java.lang.String getViewGroupTypeByReflect(android.view.View view) {
        java.lang.String canonicalName = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getCanonicalName(view.getClass());
        java.lang.Class<?> classByName = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getClassByName("androidx.cardview.widget.CardView");
        if (classByName != null && classByName.isInstance(view)) {
            return getViewType(canonicalName, "CardView");
        }
        java.lang.Class<?> classByName2 = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getClassByName("androidx.cardview.widget.CardView");
        if (classByName2 != null && classByName2.isInstance(view)) {
            return getViewType(canonicalName, "CardView");
        }
        java.lang.Class<?> classByName3 = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getClassByName("com.google.android.material.navigation.NavigationView");
        if (classByName3 != null && classByName3.isInstance(view)) {
            return getViewType(canonicalName, "NavigationView");
        }
        java.lang.Class<?> classByName4 = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getClassByName("com.google.android.material.navigation.NavigationView");
        return (classByName4 == null || !classByName4.isInstance(view)) ? canonicalName : getViewType(canonicalName, "NavigationView");
    }

    public static java.lang.String getViewId(android.view.View view) {
        java.lang.String str;
        java.lang.String str2 = null;
        try {
            str = (java.lang.String) view.getTag(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_id);
        } catch (java.lang.Exception unused) {
        }
        try {
        } catch (java.lang.Exception unused2) {
            str2 = str;
            if (com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()) {
                exceptionCollect(view);
            }
            return str2;
        }
        if (!android.text.TextUtils.isEmpty(str) || !isValid(view.getId())) {
            return str;
        }
        str2 = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getViewId(view);
        if (str2 == null) {
            str2 = view.getContext().getResources().getResourceEntryName(view.getId());
            com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().setViewId(view, str2);
        }
        return str2;
    }

    public static java.lang.String getViewType(android.view.View view) {
        java.lang.String viewType = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getViewType(view);
        if (viewType == null) {
            viewType = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getCanonicalName(view.getClass());
            if (view instanceof android.widget.CheckBox) {
                viewType = getViewType(viewType, "CheckBox");
            } else if (view instanceof android.widget.RadioButton) {
                viewType = getViewType(viewType, "RadioButton");
            } else if (view instanceof android.widget.ToggleButton) {
                viewType = getViewType(viewType, "ToggleButton");
            } else if (view instanceof android.widget.CompoundButton) {
                viewType = getViewTypeByReflect(view);
            } else if (view instanceof android.widget.Button) {
                viewType = getViewType(viewType, "Button");
            } else if (view instanceof android.widget.CheckedTextView) {
                viewType = getViewType(viewType, "CheckedTextView");
            } else if (view instanceof android.widget.TextView) {
                viewType = getViewType(viewType, "TextView");
            } else if (view instanceof android.widget.ImageView) {
                viewType = getViewType(viewType, "ImageView");
            } else if (view instanceof android.widget.RatingBar) {
                viewType = getViewType(viewType, "RatingBar");
            } else if (view instanceof android.widget.SeekBar) {
                viewType = getViewType(viewType, "SeekBar");
            } else if (view instanceof android.widget.Spinner) {
                viewType = getViewType(viewType, "Spinner");
            } else if (instanceOfTabView(view) != null) {
                viewType = getViewType(viewType, "TabLayout");
            } else if (instanceOfNavigationView(view)) {
                viewType = getViewType(viewType, "NavigationView");
            } else if (view instanceof android.view.ViewGroup) {
                viewType = getViewGroupTypeByReflect(view);
            }
            com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().setViewType(view, viewType);
        }
        return viewType;
    }

    private static java.lang.String getViewType(java.lang.String str, java.lang.String str2) {
        return (android.text.TextUtils.isEmpty(str) || isOSViewByPackage(str)) ? str2 : str;
    }

    public static java.lang.String getViewTypeByReflect(android.view.View view) {
        java.lang.String canonicalName = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getCanonicalName(view.getClass());
        java.lang.Class<?> classByName = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getClassByName("android.widget.Switch");
        if (classByName != null && classByName.isInstance(view)) {
            return getViewType(canonicalName, "Switch");
        }
        java.lang.Class<?> classByName2 = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getClassByName("androidx.appcompat.widget.SwitchCompat");
        if (classByName2 != null && classByName2.isInstance(view)) {
            return getViewType(canonicalName, "SwitchCompat");
        }
        java.lang.Class<?> classByName3 = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getClassByName("androidx.appcompat.widget.SwitchCompat");
        return (classByName3 == null || !classByName3.isInstance(view)) ? canonicalName : getViewType(canonicalName, "SwitchCompat");
    }

    public static boolean instanceOfActionMenuItem(java.lang.Object obj) {
        return com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(obj, "androidx.appcompat.view.menu.ActionMenuItem");
    }

    public static boolean instanceOfAndroidXListMenuItemView(java.lang.Object obj) {
        return com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(obj, "androidx.appcompat.view.menu.ListMenuItemView");
    }

    public static boolean instanceOfBottomNavigationItemView(java.lang.Object obj) {
        return com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(obj, "com.google.android.material.bottomnavigation.BottomNavigationItemView", "com.google.android.material.internal.NavigationMenuItemView");
    }

    public static boolean instanceOfNavigationView(java.lang.Object obj) {
        return com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(obj, "com.google.android.material.navigation.NavigationView", "com.google.android.material.navigation.NavigationView");
    }

    public static boolean instanceOfSupportListMenuItemView(java.lang.Object obj) {
        return com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(obj, "androidx.appcompat.view.menu.ListMenuItemView");
    }

    private static java.lang.Object instanceOfTabView(android.view.View view) {
        if (view == null) {
            return null;
        }
        try {
            java.lang.Class<?> currentClass = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getCurrentClass(new java.lang.String[]{"com.google.android.material.tabs.TabLayout$TabView", "com.google.android.material.tabs.TabLayout$TabView"});
            if (currentClass != null && currentClass.isAssignableFrom(view.getClass())) {
                return com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField(currentClass, view, "mTab", "tab");
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return null;
    }

    public static boolean instanceOfToolbar(java.lang.Object obj) {
        return com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(obj, "androidx.appcompat.widget.Toolbar", "androidx.appcompat.widget.Toolbar", "android.widget.Toolbar");
    }

    private static boolean isOSViewByPackage(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.lang.String replace = str.replace(".", "##");
        java.util.Iterator<java.lang.String> it = sOSViewPackage.iterator();
        while (it.hasNext()) {
            if (replace.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValid(int i) {
        return (i == -1 || ((-16777216) & i) == 0 || (i & 16711680) == 0) ? false : true;
    }

    public static boolean isViewIgnored(android.view.View view) {
        if (view == null) {
            return true;
        }
        try {
            java.util.List<java.lang.Class<?>> ignoredViewTypeList = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getIgnoredViewTypeList();
            if (ignoredViewTypeList != null) {
                java.util.Iterator<java.lang.Class<?>> it = ignoredViewTypeList.iterator();
                while (it.hasNext()) {
                    if (it.next().isAssignableFrom(view.getClass())) {
                        return true;
                    }
                }
            }
            return "1".equals(view.getTag(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_ignored));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return true;
        }
    }

    public static boolean isViewIgnored(java.lang.Class<?> cls) {
        if (cls == null) {
            return true;
        }
        try {
            java.util.List<java.lang.Class<?>> ignoredViewTypeList = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getIgnoredViewTypeList();
            if (ignoredViewTypeList.isEmpty()) {
                return false;
            }
            java.util.Iterator<java.lang.Class<?>> it = ignoredViewTypeList.iterator();
            while (it.hasNext()) {
                if (it.next().isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Exception unused) {
            return true;
        }
    }

    public static boolean isViewSelfVisible(android.view.View view) {
        if (view != null && view.getWindowVisibility() != 8) {
            if (com.sensorsdata.analytics.android.sdk.util.WindowHelper.isDecorView(view.getClass())) {
                return true;
            }
            boolean localVisibleRect = view.getLocalVisibleRect(new android.graphics.Rect());
            if (view.getWidth() > 0 && view.getHeight() > 0 && view.getAlpha() > 0.0f && localVisibleRect) {
                return !(view.getVisibility() == 0 || view.getAnimation() == null || !view.getAnimation().getFillAfter()) || view.getVisibility() == 0;
            }
        }
        return false;
    }

    public static boolean isWeexTextView(android.view.View view) {
        if (view == null) {
            return false;
        }
        java.lang.String name = view.getClass().getName();
        return name.equals("com.taobao.weex.ui.view.WXTextView") || name.equals("org.apache.weex.ui.view.WXTextView");
    }

    public static boolean isWeexView(android.view.View view) {
        if (view == null) {
            return false;
        }
        java.lang.String name = view.getClass().getName();
        return name.startsWith("com.taobao.weex.ui.view") || name.startsWith("org.apache.weex.ui.view");
    }

    public static java.lang.String traverseView(java.lang.StringBuilder sb, android.view.ViewGroup viewGroup) {
        if (sb == null) {
            try {
                sb = new java.lang.StringBuilder();
            } catch (java.lang.Throwable th) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th.getMessage());
                return sb != null ? sb.toString() : "";
            }
        }
        if (viewGroup == null) {
            return sb.toString();
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = viewGroup.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                if (childAt instanceof android.view.ViewGroup) {
                    traverseView(sb, (android.view.ViewGroup) childAt);
                } else if (!isViewIgnored(childAt)) {
                    java.lang.String viewContent = getViewContent(childAt);
                    if (!android.text.TextUtils.isEmpty(viewContent)) {
                        sb.append(viewContent);
                        sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    }
                }
            }
        }
        return sb.toString();
    }
}
