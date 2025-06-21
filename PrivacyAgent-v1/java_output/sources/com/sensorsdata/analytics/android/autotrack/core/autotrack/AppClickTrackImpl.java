package com.sensorsdata.analytics.android.autotrack.core.autotrack;

/* loaded from: classes19.dex */
public class AppClickTrackImpl {
    private static final java.lang.String TAG = "AppClickTrackImpl";
    private static final java.util.HashMap<java.lang.Integer, java.lang.Long> eventTimestamp = new java.util.HashMap<>();

    /* renamed from: com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$eventName;
        final /* synthetic */ org.json.JSONObject val$finalPro;
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.SensorsDataAPI val$sensorsDataAPI;

        public AnonymousClass1(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, java.lang.String str, org.json.JSONObject jSONObject) {
            this.val$sensorsDataAPI = sensorsDataAPI;
            this.val$eventName = str;
            this.val$finalPro = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$sensorsDataAPI.getSAContextManager().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName(this.val$eventName).setProperties(this.val$finalPro).setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK));
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$eventProperties;
        final /* synthetic */ org.json.JSONObject val$properties;
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.SensorsDataAPI val$sensorsDataAPI;
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass2(android.view.View view, org.json.JSONObject jSONObject, com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, org.json.JSONObject jSONObject2) {
            this.val$view = view;
            this.val$properties = jSONObject;
            this.val$sensorsDataAPI = sensorsDataAPI;
            this.val$eventProperties = jSONObject2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$view != null) {
                com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_MERGE_VISUAL_PROPERTIES, this.val$properties, this.val$view);
            }
            this.val$sensorsDataAPI.getSAContextManager().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName("$AppClick").setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK).setProperties(this.val$eventProperties));
        }
    }

    public static org.json.JSONObject buildPageProperty(android.app.Activity activity, java.lang.Object obj) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (obj != null) {
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getFragmentPageInfo(activity, obj), jSONObject);
        } else if (activity != null) {
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getActivityPageInfo(activity), jSONObject);
        }
        return jSONObject;
    }

    private static com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext getAppClickViewContext(android.view.View view, java.lang.Class<?> cls) {
        return getAppClickViewContext(null, view, cls);
    }

    private static com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext getAppClickViewContext(java.lang.Object obj, android.view.View view, java.lang.Class<?> cls) {
        if (com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewIgnored(cls)) {
            return null;
        }
        android.content.Context context = obj instanceof android.content.Context ? (android.content.Context) obj : null;
        if (view != null) {
            if (com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewIgnored(view)) {
                return null;
            }
            if (context == null && (context = view.getContext()) == null) {
                return null;
            }
        }
        android.app.Activity activityOfView = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(context, view);
        if (activityOfView != null && com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isActivityAutoTrackAppClickIgnored(activityOfView.getClass())) {
            return null;
        }
        java.lang.Object fragmentFromView = com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.getFragmentFromView(view, activityOfView);
        if (fragmentFromView == null || !com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isActivityAutoTrackAppClickIgnored(fragmentFromView.getClass())) {
            return new com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext(activityOfView, fragmentFromView, view);
        }
        return null;
    }

    private static org.json.JSONObject getExpandListViewExtendProperty(android.widget.ExpandableListView expandableListView, int i, int i2) {
        try {
            android.widget.ExpandableListAdapter expandableListAdapter = expandableListView.getExpandableListAdapter();
            if (!(expandableListAdapter instanceof com.sensorsdata.analytics.android.sdk.SensorsExpandableListViewItemTrackProperties)) {
                return null;
            }
            com.sensorsdata.analytics.android.sdk.SensorsExpandableListViewItemTrackProperties sensorsExpandableListViewItemTrackProperties = (com.sensorsdata.analytics.android.sdk.SensorsExpandableListViewItemTrackProperties) expandableListAdapter;
            return i2 == -1 ? sensorsExpandableListViewItemTrackProperties.getSensorsGroupItemTrackProperties(i) : sensorsExpandableListViewItemTrackProperties.getSensorsChildItemTrackProperties(i, i2);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    private static boolean isAppClickIgnore(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI) {
        return !sensorsDataAPI.isAutoTrackEnabled() || sensorsDataAPI.isAutoTrackEventTypeIgnored(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_CLICK);
    }

    private static boolean isDeBounceTrack(java.lang.Object obj) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        java.util.HashMap<java.lang.Integer, java.lang.Long> hashMap = eventTimestamp;
        java.lang.Long l = hashMap.get(java.lang.Integer.valueOf(obj.hashCode()));
        if (l != null && elapsedRealtime - l.longValue() < 500) {
            return true;
        }
        hashMap.put(java.lang.Integer.valueOf(obj.hashCode()), java.lang.Long.valueOf(elapsedRealtime));
        return false;
    }

    public static void track(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObject;
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            if (!android.text.TextUtils.isEmpty(str2)) {
                try {
                    jSONObject = new org.json.JSONObject(str2);
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
                com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl.AnonymousClass1(sensorsDataAPI, str, jSONObject));
            }
            jSONObject = null;
            com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl.AnonymousClass1(sensorsDataAPI, str, jSONObject));
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    private static void trackAutoEvent(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, org.json.JSONObject jSONObject, android.view.View view) {
        com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl.AnonymousClass2(view, jSONObject, sensorsDataAPI, com.sensorsdata.analytics.android.sdk.util.SADataHelper.appendLibMethodAutoTrack(jSONObject)));
    }

    public static void trackDialog(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, android.content.DialogInterface dialogInterface, int i) {
        android.widget.Button button;
        java.lang.Class<androidx.appcompat.app.AlertDialog> cls = androidx.appcompat.app.AlertDialog.class;
        try {
            if (!isAppClickIgnore(sensorsDataAPI) && !com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewIgnored((java.lang.Class<?>) android.app.Dialog.class)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                android.view.View view = null;
                android.app.Dialog dialog = dialogInterface instanceof android.app.Dialog ? (android.app.Dialog) dialogInterface : null;
                if (dialog != null && !isDeBounceTrack(dialog)) {
                    android.app.Activity activityOfView = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(dialog.getContext(), null);
                    if (activityOfView == null) {
                        activityOfView = dialog.getOwnerActivity();
                    }
                    if (activityOfView != null && !sensorsDataAPI.isActivityAutoTrackAppClickIgnored(activityOfView.getClass())) {
                        com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getActivityPageInfo(activityOfView), jSONObject);
                        try {
                            android.view.Window window = dialog.getWindow();
                            if (window != null && window.isActive()) {
                                java.lang.String str = (java.lang.String) dialog.getWindow().getDecorView().getTag(com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_id);
                                if (!android.text.TextUtils.isEmpty(str)) {
                                    jSONObject.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_ID, str);
                                }
                            }
                        } catch (java.lang.Exception e) {
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                        }
                        com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeDuplicateProperty(com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getRNPageInfo(), jSONObject);
                        jSONObject.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_TYPE, "Dialog");
                        try {
                            try {
                                int i2 = androidx.appcompat.app.AlertDialog.n;
                            } catch (java.lang.Exception unused) {
                                cls = null;
                            }
                        } catch (java.lang.Exception unused2) {
                            int i3 = androidx.appcompat.app.AlertDialog.n;
                        }
                        if (cls == null) {
                            return;
                        }
                        if (dialog instanceof android.app.AlertDialog) {
                            android.app.AlertDialog alertDialog = (android.app.AlertDialog) dialog;
                            android.widget.Button button2 = alertDialog.getButton(i);
                            if (button2 != null) {
                                if (!android.text.TextUtils.isEmpty(button2.getText())) {
                                    jSONObject.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT, button2.getText());
                                }
                                view = button2;
                            } else {
                                android.widget.ListView listView = alertDialog.getListView();
                                if (listView != null) {
                                    java.lang.Object item = listView.getAdapter().getItem(i);
                                    if (item != null && (item instanceof java.lang.String)) {
                                        jSONObject.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT, item);
                                    }
                                    view = listView.getChildAt(i);
                                }
                            }
                        } else if (cls.isInstance(dialog)) {
                            try {
                                button = (android.widget.Button) dialog.getClass().getMethod("getButton", java.lang.Integer.TYPE).invoke(dialog, java.lang.Integer.valueOf(i));
                            } catch (java.lang.Exception unused3) {
                                button = null;
                            }
                            if (button != null) {
                                if (!android.text.TextUtils.isEmpty(button.getText())) {
                                    jSONObject.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT, button.getText());
                                }
                                view = button;
                            } else {
                                try {
                                    android.widget.ListView listView2 = (android.widget.ListView) dialog.getClass().getMethod("getListView", new java.lang.Class[0]).invoke(dialog, new java.lang.Object[0]);
                                    if (listView2 != null) {
                                        java.lang.Object item2 = listView2.getAdapter().getItem(i);
                                        if (item2 != null && (item2 instanceof java.lang.String)) {
                                            jSONObject.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT, item2);
                                        }
                                        view = listView2.getChildAt(i);
                                    }
                                } catch (java.lang.Exception unused4) {
                                }
                            }
                        }
                        trackAutoEvent(sensorsDataAPI, jSONObject, view);
                    }
                }
            }
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    public static void trackDrawerClosed(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, android.view.View view) {
        if (view == null) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT, "Close");
            sensorsDataAPI.setViewProperties(view, jSONObject);
            trackViewOnClick(sensorsDataAPI, view, view.isPressed());
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void trackDrawerOpened(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, android.view.View view) {
        if (view == null) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT, "Open");
            sensorsDataAPI.setViewProperties(view, jSONObject);
            trackViewOnClick(sensorsDataAPI, view, view.isPressed());
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void trackExpandableListViewOnChildClick(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, android.widget.ExpandableListView expandableListView, android.view.View view, int i, int i2) {
        com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext appClickViewContext;
        java.lang.String viewContent;
        if (expandableListView == null || view == null) {
            return;
        }
        try {
            if (com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewIgnored(view) || isAppClickIgnore(sensorsDataAPI) || (appClickViewContext = getAppClickViewContext(expandableListView, android.widget.ExpandableListView.class)) == null) {
                return;
            }
            org.json.JSONObject buildPageProperty = buildPageProperty(appClickViewContext.activity, appClickViewContext.fragment);
            java.lang.String viewId = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewId(expandableListView);
            if (!android.text.TextUtils.isEmpty(viewId)) {
                buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_ID, viewId);
            }
            buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_TYPE, "ExpandableListView");
            if (view instanceof android.view.ViewGroup) {
                viewContent = null;
                try {
                    viewContent = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.traverseView(new java.lang.StringBuilder(), (android.view.ViewGroup) view);
                    if (!android.text.TextUtils.isEmpty(viewContent)) {
                        viewContent = viewContent.substring(0, viewContent.length() - 1);
                    }
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            } else {
                viewContent = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(view);
            }
            if (!android.text.TextUtils.isEmpty(viewContent)) {
                buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT, viewContent);
            }
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(getExpandListViewExtendProperty(expandableListView, i, i2), buildPageProperty);
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject((org.json.JSONObject) view.getTag(com.sensorsdata.analytics.android.autotrack.R.id.sensors_analytics_tag_view_properties), buildPageProperty);
            trackAutoEvent(sensorsDataAPI, buildPageProperty, view);
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    public static void trackExpandableListViewOnGroupClick(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, android.widget.ExpandableListView expandableListView, android.view.View view, int i) {
        com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext appClickViewContext;
        java.lang.String viewContent;
        if (expandableListView == null || view == null) {
            return;
        }
        try {
            if (isAppClickIgnore(sensorsDataAPI) || (appClickViewContext = getAppClickViewContext(expandableListView, android.widget.ExpandableListView.class)) == null) {
                return;
            }
            org.json.JSONObject buildPageProperty = buildPageProperty(appClickViewContext.activity, appClickViewContext.fragment);
            java.lang.String viewId = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewId(expandableListView);
            if (!android.text.TextUtils.isEmpty(viewId)) {
                buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_ID, viewId);
            }
            buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_TYPE, "ExpandableListView");
            if (view instanceof android.view.ViewGroup) {
                viewContent = null;
                try {
                    viewContent = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.traverseView(new java.lang.StringBuilder(), (android.view.ViewGroup) view);
                    if (!android.text.TextUtils.isEmpty(viewContent)) {
                        viewContent = viewContent.substring(0, viewContent.length() - 1);
                    }
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            } else {
                viewContent = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(view);
            }
            if (!android.text.TextUtils.isEmpty(viewContent)) {
                buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT, viewContent);
            }
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(getExpandListViewExtendProperty(expandableListView, i, -1), buildPageProperty);
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject((org.json.JSONObject) view.getTag(com.sensorsdata.analytics.android.autotrack.R.id.sensors_analytics_tag_view_properties), buildPageProperty);
            trackAutoEvent(sensorsDataAPI, buildPageProperty, view);
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    public static void trackListView(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, android.widget.AdapterView<?> adapterView, android.view.View view, int i) {
        java.lang.String str;
        java.lang.Class cls;
        if (view != null) {
            try {
                if (!isAppClickIgnore(sensorsDataAPI) && !com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewIgnored(adapterView) && !com.sensorsdata.analytics.android.autotrack.utils.KeyboardViewUtil.isKeyboardView(view)) {
                    if (adapterView instanceof android.widget.ListView) {
                        cls = android.widget.ListView.class;
                        str = "ListView";
                    } else if (adapterView instanceof android.widget.GridView) {
                        cls = android.widget.GridView.class;
                        str = "GridView";
                    } else if (adapterView instanceof android.widget.Spinner) {
                        cls = android.widget.Spinner.class;
                        str = "Spinner";
                    } else {
                        str = "";
                        cls = null;
                    }
                    com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext appClickViewContext = getAppClickViewContext(adapterView, view, cls);
                    if (appClickViewContext == null) {
                        return;
                    }
                    org.json.JSONObject buildPageProperty = buildPageProperty(appClickViewContext.activity, appClickViewContext.fragment);
                    if (!android.text.TextUtils.isEmpty(str)) {
                        buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_TYPE, str);
                    }
                    java.lang.String viewId = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewId(adapterView);
                    if (!android.text.TextUtils.isEmpty(viewId)) {
                        buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_ID, viewId);
                    }
                    java.lang.Object adapter = adapterView.getAdapter();
                    if (adapter instanceof android.widget.HeaderViewListAdapter) {
                        adapter = ((android.widget.HeaderViewListAdapter) adapter).getWrappedAdapter();
                    }
                    if (adapter instanceof com.sensorsdata.analytics.android.sdk.SensorsAdapterViewItemTrackProperties) {
                        try {
                            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(((com.sensorsdata.analytics.android.sdk.SensorsAdapterViewItemTrackProperties) adapter).getSensorsItemTrackProperties(i), buildPageProperty);
                        } catch (org.json.JSONException e) {
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                        }
                    }
                    java.lang.String viewContent = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(view);
                    if (!android.text.TextUtils.isEmpty(viewContent)) {
                        buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT, viewContent);
                    }
                    com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject((org.json.JSONObject) view.getTag(com.sensorsdata.analytics.android.autotrack.R.id.sensors_analytics_tag_view_properties), buildPageProperty);
                    trackAutoEvent(sensorsDataAPI, buildPageProperty, view);
                }
            } catch (java.lang.Exception e2) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
            }
        }
    }

    public static void trackMenuItem(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, java.lang.Object obj, android.view.MenuItem menuItem) {
        com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext appClickViewContext;
        if (menuItem != null) {
            try {
                if (isDeBounceTrack(menuItem) || isAppClickIgnore(sensorsDataAPI) || (appClickViewContext = getAppClickViewContext(obj, com.sensorsdata.analytics.android.sdk.util.WindowHelper.getClickView(menuItem), android.view.MenuItem.class)) == null) {
                    return;
                }
                org.json.JSONObject buildPageProperty = buildPageProperty(appClickViewContext.activity, appClickViewContext.fragment);
                try {
                    android.app.Activity activity = appClickViewContext.activity;
                    if (activity != null) {
                        java.lang.String resourceEntryName = activity.getResources().getResourceEntryName(menuItem.getItemId());
                        if (!android.text.TextUtils.isEmpty(resourceEntryName)) {
                            buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_ID, resourceEntryName);
                        }
                    }
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
                if (menuItem.getTitle() != null) {
                    java.lang.String charSequence = menuItem.getTitle().toString();
                    if (appClickViewContext.view != null && android.text.TextUtils.isEmpty(charSequence)) {
                        charSequence = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(appClickViewContext.view);
                    }
                    buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT, charSequence);
                }
                buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_TYPE, "MenuItem");
                trackAutoEvent(sensorsDataAPI, buildPageProperty, appClickViewContext.view);
            } catch (java.lang.Exception e2) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
            }
        }
    }

    public static void trackRadioGroup(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, android.widget.RadioGroup radioGroup, int i) {
        android.view.View findViewById;
        com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext appClickViewContext;
        android.widget.RadioButton radioButton;
        java.lang.Exception e;
        android.app.Activity activity;
        if (radioGroup != null) {
            try {
                if (isAppClickIgnore(sensorsDataAPI) || (findViewById = radioGroup.findViewById(i)) == null || !findViewById.isPressed() || (appClickViewContext = getAppClickViewContext(radioGroup, android.widget.RadioGroup.class)) == null) {
                    return;
                }
                org.json.JSONObject buildPageProperty = buildPageProperty(appClickViewContext.activity, appClickViewContext.fragment);
                java.lang.String viewId = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewId(radioGroup);
                if (!android.text.TextUtils.isEmpty(viewId)) {
                    buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_ID, viewId);
                }
                buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_TYPE, com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewType(findViewById));
                android.widget.RadioButton radioButton2 = null;
                try {
                    activity = appClickViewContext.activity;
                } catch (java.lang.Exception e2) {
                    radioButton = null;
                    e = e2;
                }
                if (activity != null) {
                    radioButton = (android.widget.RadioButton) activity.findViewById(radioGroup.getCheckedRadioButtonId());
                    if (radioButton != null) {
                        try {
                            if (!android.text.TextUtils.isEmpty(radioButton.getText())) {
                                buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT, radioButton.getText().toString());
                            }
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                            radioButton2 = radioButton;
                            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject((org.json.JSONObject) radioGroup.getTag(com.sensorsdata.analytics.android.autotrack.R.id.sensors_analytics_tag_view_properties), buildPageProperty);
                            trackAutoEvent(sensorsDataAPI, buildPageProperty, radioButton2);
                        }
                    }
                    radioButton2 = radioButton;
                }
                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject((org.json.JSONObject) radioGroup.getTag(com.sensorsdata.analytics.android.autotrack.R.id.sensors_analytics_tag_view_properties), buildPageProperty);
                trackAutoEvent(sensorsDataAPI, buildPageProperty, radioButton2);
            } catch (java.lang.Exception e4) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e4);
            }
        }
    }

    public static void trackTabHost(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, java.lang.String str) {
        com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext appClickViewContext;
        try {
            if (isAppClickIgnore(sensorsDataAPI) || (appClickViewContext = getAppClickViewContext(com.sensorsdata.analytics.android.autotrack.utils.AutoTrackViewUtils.getTabView(str), android.widget.TabHost.class)) == null) {
                return;
            }
            org.json.JSONObject jSONObject = null;
            try {
                jSONObject = buildPageProperty(appClickViewContext.activity, appClickViewContext.fragment);
                java.lang.String viewContent = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(appClickViewContext.view);
                if (!android.text.TextUtils.isEmpty(viewContent)) {
                    str = viewContent;
                }
                jSONObject.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT, str);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
            if (jSONObject == null) {
                jSONObject = new org.json.JSONObject();
            }
            jSONObject.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_TYPE, "TabHost");
            trackAutoEvent(sensorsDataAPI, jSONObject, appClickViewContext.view);
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    public static void trackTabLayoutSelected(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, java.lang.Object obj, java.lang.Object obj2) {
        android.view.View tabLayout;
        com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext tabLayoutContext;
        boolean isBindViewPager;
        android.app.Activity activity;
        if (obj2 != null) {
            try {
                if (isDeBounceTrack(obj2) || isAppClickIgnore(sensorsDataAPI) || (tabLayout = com.sensorsdata.analytics.android.autotrack.utils.AutoTrackViewUtils.getTabLayout(obj2)) == null || (tabLayoutContext = com.sensorsdata.analytics.android.autotrack.utils.AutoTrackViewUtils.getTabLayoutContext(obj, tabLayout)) == null) {
                    return;
                }
                android.app.Activity activity2 = tabLayoutContext.activity;
                if (activity2 == null || !sensorsDataAPI.isActivityAutoTrackAppClickIgnored(activity2.getClass())) {
                    java.lang.Object obj3 = tabLayoutContext.fragment;
                    if (obj3 == null || !sensorsDataAPI.isActivityAutoTrackAppClickIgnored(obj3.getClass())) {
                        org.json.JSONObject buildPageProperty = buildPageProperty(tabLayoutContext.activity, tabLayoutContext.fragment);
                        buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_TYPE, "TabLayout");
                        android.view.View view = (android.view.View) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField((java.lang.Class<?>) com.google.android.material.tabs.TabLayout.Tab.class, obj2, "mCustomView", "customView");
                        java.lang.String tabLayoutText = com.sensorsdata.analytics.android.autotrack.utils.AutoTrackViewUtils.getTabLayoutText(view, obj2);
                        if (tabLayoutText != null) {
                            buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT, tabLayoutText);
                        }
                        if (view == null || view.getId() == -1) {
                            view = tabLayout;
                        }
                        if (view.getId() != -1 && (activity = tabLayoutContext.activity) != null) {
                            java.lang.String resourceEntryName = activity.getResources().getResourceEntryName(view.getId());
                            if (!android.text.TextUtils.isEmpty(resourceEntryName)) {
                                buildPageProperty.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_ID, resourceEntryName);
                            }
                        }
                        com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject((org.json.JSONObject) view.getTag(com.sensorsdata.analytics.android.autotrack.R.id.sensors_analytics_tag_view_properties), buildPageProperty);
                        android.view.View view2 = (android.view.View) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField((java.lang.Class<?>) com.google.android.material.tabs.TabLayout.Tab.class, obj2, com.anythink.expressad.a.B);
                        if (view2 == null) {
                            view2 = (android.view.View) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField((java.lang.Class<?>) com.google.android.material.tabs.TabLayout.Tab.class, obj2, "mView");
                        }
                        if (view2 != null && (((isBindViewPager = com.sensorsdata.analytics.android.autotrack.utils.AutoTrackViewUtils.isBindViewPager(tabLayout)) && !view2.isPressed()) || (!isBindViewPager && view2.isPressed()))) {
                            buildPageProperty.put("$referrer_title", com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getCurrentTitle());
                        }
                        trackAutoEvent(sensorsDataAPI, buildPageProperty, view2);
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public static void trackViewOnClick(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, android.view.View view, boolean z) {
        com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext appClickViewContext;
        org.json.JSONObject injectClickInfo;
        if (view != null) {
            try {
                if (isAppClickIgnore(sensorsDataAPI) || isDeBounceTrack(view) || com.sensorsdata.analytics.android.autotrack.utils.KeyboardViewUtil.isKeyboardView(view) || (appClickViewContext = getAppClickViewContext(view, view.getClass())) == null || (injectClickInfo = com.sensorsdata.analytics.android.autotrack.utils.AopUtil.injectClickInfo(appClickViewContext, new org.json.JSONObject(), z)) == null) {
                    return;
                }
                trackAutoEvent(sensorsDataAPI, injectClickInfo, view);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }
}
