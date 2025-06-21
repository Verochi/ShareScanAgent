package com.sensorsdata.analytics.android.sdk.visual.property;

/* loaded from: classes19.dex */
public class VisualPropertiesManager {
    private static final java.lang.String PROPERTY_TYPE_NUMBER = "NUMBER";
    private static final java.lang.String TAG = "SA.VP.VisualPropertiesManager";
    private com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener mCollectLogListener;
    private final com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesCache mConfigCache;
    private final com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper mRequestHelper;
    private com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig mVisualConfig;
    private final com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesH5Helper mVisualPropertiesH5Helper;

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.IApiCallback {
        public AnonymousClass1() {
        }

        @Override // com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper.IApiCallback
        public void onSuccess(java.lang.String str) {
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.this.save2Cache(str);
        }
    }

    public interface CollectLogListener {
        void onCheckEventConfigFailure();

        void onCheckVisualConfigFailure(java.lang.String str);

        void onFindPropertyElementFailure(java.lang.String str, java.lang.String str2, java.lang.String str3);

        void onOtherError(java.lang.String str);

        void onParsePropertyContentFailure(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

        void onStart(java.lang.String str, java.lang.String str2, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode);

        void onSwitchClose();
    }

    public static class SingletonHolder {
        private static final com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager INSTANCE = new com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager(null);

        private SingletonHolder() {
        }
    }

    public enum VisualEventType {
        APP_CLICK("appclick", "$AppClick"),
        WEB_CLICK("appclick", com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants.WEB_CLICK_EVENT_NAME);

        private final java.lang.String trackEventType;
        private final java.lang.String visualEventType;

        VisualEventType(java.lang.String str, java.lang.String str2) {
            this.visualEventType = str;
            this.trackEventType = str2;
        }

        public static com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.VisualEventType getVisualEventType(java.lang.String str) {
            for (com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.VisualEventType visualEventType : values()) {
                if (android.text.TextUtils.equals(visualEventType.trackEventType, str)) {
                    return visualEventType;
                }
            }
            return null;
        }

        public java.lang.String getVisualEventType() {
            return this.visualEventType;
        }
    }

    private VisualPropertiesManager() {
        com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesCache visualPropertiesCache = new com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesCache();
        this.mConfigCache = visualPropertiesCache;
        this.mVisualConfig = visualPropertiesCache.getVisualConfig();
        this.mRequestHelper = new com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper();
        this.mVisualPropertiesH5Helper = new com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesH5Helper();
    }

    public /* synthetic */ VisualPropertiesManager(com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager getInstance() {
        return com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.SingletonHolder.INSTANCE;
    }

    private void mergeVisualProperty(java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualProperty> list, com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualEvent visualEvent, org.json.JSONObject jSONObject, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode, java.lang.String str) {
        try {
            java.util.HashSet<java.lang.String> hashSet = new java.util.HashSet<>();
            com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable.getInstance().clearViewNodeCache();
            for (com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualProperty visualProperty : list) {
                if (!visualProperty.isH5 || android.text.TextUtils.isEmpty(visualProperty.webViewElementPath)) {
                    mergeAppVisualProperty(visualProperty, visualEvent, jSONObject, viewNode);
                } else {
                    hashSet.add(visualProperty.webViewElementPath + visualProperty.screenName);
                }
            }
            if (hashSet.size() > 0) {
                this.mVisualPropertiesH5Helper.mergeJSVisualProperties(jSONObject, hashSet, str);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public boolean checkAppIdAndProject() {
        java.lang.String serverUrl = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getServerUrl();
        if (android.text.TextUtils.isEmpty(serverUrl)) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "serverUrl is empty and return");
            return false;
        }
        java.lang.String queryParameter = android.net.Uri.parse(serverUrl).getQueryParameter("project");
        java.lang.String processName = com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getProcessName(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSAContextManager().getContext());
        if (android.text.TextUtils.isEmpty(queryParameter) || android.text.TextUtils.isEmpty(processName)) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "project or app_id is empty and return");
            return false;
        }
        com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig visualConfig = this.mVisualConfig;
        if (visualConfig == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "VisualConfig is null and return");
            return false;
        }
        if (!android.text.TextUtils.equals(processName, visualConfig.appId)) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("app_id is not equals: current app_id is %s, config app_id is %s ", processName, this.mVisualConfig.appId));
            return false;
        }
        if (android.text.TextUtils.equals(queryParameter, this.mVisualConfig.project)) {
            return true;
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("project is not equals: current project is %s, config project is %s ", queryParameter, this.mVisualConfig.project));
        return false;
    }

    public java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualPropertiesConfig> getMatchEventConfigList(java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualPropertiesConfig> list, com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.VisualEventType visualEventType, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            for (com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualPropertiesConfig visualPropertiesConfig : list) {
                if (android.text.TextUtils.equals(visualPropertiesConfig.eventType, visualEventType.getVisualEventType())) {
                    com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualEvent visualEvent = visualPropertiesConfig.event;
                    if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.equals(visualEvent.screenName, str)) {
                        if (visualEventType == com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.VisualEventType.APP_CLICK || visualEventType == com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.VisualEventType.WEB_CLICK) {
                            if (!android.text.TextUtils.equals(visualEvent.elementPath, str2)) {
                                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("event element_path is not match: current element_path is %s, config element_path is %s ", str2, visualEvent.elementPath));
                            } else if (visualEvent.limitElementPosition && !android.text.TextUtils.equals(visualEvent.elementPosition, str3)) {
                                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("event element_position is not match: current element_position is %s, config element_position is %s ", str3, visualEvent.elementPosition));
                            } else if (visualEvent.limitElementContent && !android.text.TextUtils.equals(visualEvent.elementContent, str4)) {
                                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("event element_content is not match: current element_content is %s, config element_content is %s ", str4, visualEvent.elementContent));
                            }
                        }
                        arrayList.add(visualPropertiesConfig);
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return arrayList;
    }

    public com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig getVisualConfig() {
        return this.mVisualConfig;
    }

    public java.lang.String getVisualConfigVersion() {
        com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig visualConfig = this.mVisualConfig;
        if (visualConfig != null) {
            return visualConfig.version;
        }
        return null;
    }

    public com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesCache getVisualPropertiesCache() {
        return this.mConfigCache;
    }

    public com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesH5Helper getVisualPropertiesH5Helper() {
        return this.mVisualPropertiesH5Helper;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0154 A[Catch: Exception -> 0x019c, TRY_LEAVE, TryCatch #3 {Exception -> 0x019c, blocks: (B:3:0x0002, B:6:0x000c, B:9:0x0012, B:11:0x001a, B:15:0x0023, B:18:0x002f, B:20:0x0037, B:22:0x003b, B:24:0x0043, B:26:0x0059, B:50:0x00de, B:53:0x00e6, B:55:0x014e, B:57:0x0154, B:65:0x016f, B:67:0x0173, B:72:0x017b, B:76:0x0182, B:78:0x0186, B:92:0x013d, B:94:0x0141, B:95:0x014a, B:97:0x018e, B:99:0x0192, B:104:0x00d9, B:61:0x0160, B:83:0x0105, B:85:0x0117, B:86:0x0129, B:88:0x0132), top: B:2:0x0002, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0192 A[Catch: Exception -> 0x019c, TRY_LEAVE, TryCatch #3 {Exception -> 0x019c, blocks: (B:3:0x0002, B:6:0x000c, B:9:0x0012, B:11:0x001a, B:15:0x0023, B:18:0x002f, B:20:0x0037, B:22:0x003b, B:24:0x0043, B:26:0x0059, B:50:0x00de, B:53:0x00e6, B:55:0x014e, B:57:0x0154, B:65:0x016f, B:67:0x0173, B:72:0x017b, B:76:0x0182, B:78:0x0186, B:92:0x013d, B:94:0x0141, B:95:0x014a, B:97:0x018e, B:99:0x0192, B:104:0x00d9, B:61:0x0160, B:83:0x0105, B:85:0x0117, B:86:0x0129, B:88:0x0132), top: B:2:0x0002, inners: #0, #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mergeAppVisualProperty(com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualProperty visualProperty, com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualEvent visualEvent, org.json.JSONObject jSONObject, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode) {
        java.lang.String str;
        com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener collectLogListener;
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return;
        }
        if (android.text.TextUtils.isEmpty(visualProperty.name)) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "config visual property name is empty");
            return;
        }
        if (android.text.TextUtils.isEmpty(visualProperty.elementPath)) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "config visual property elementPath is empty");
            return;
        }
        if (viewNode != null && !android.text.TextUtils.isEmpty(viewNode.getViewPosition()) && visualEvent != null && !android.text.TextUtils.isEmpty(visualEvent.elementPosition) && !visualEvent.limitElementPosition && !android.text.TextUtils.isEmpty(visualProperty.elementPosition) && android.text.TextUtils.equals(visualProperty.elementPath.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0], visualEvent.elementPath.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0])) {
            visualProperty.elementPosition = viewNode.getViewPosition();
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "visualProperty elementPosition replace: " + viewNode.getViewPosition());
        }
        java.lang.String str2 = null;
        try {
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode2 = com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable.getInstance().getViewNode(viewNode != null ? viewNode.getView() : null, visualProperty.elementPath, visualProperty.elementPosition, visualProperty.screenName);
            if (viewNode2 == null || !android.text.TextUtils.equals(visualProperty.elementPath, viewNode2.getViewPath()) || (!android.text.TextUtils.isEmpty(visualProperty.elementPosition) && !android.text.TextUtils.equals(visualProperty.elementPosition, viewNode2.getViewPosition()))) {
                str = null;
            } else {
                str = viewNode2.getViewContent();
                try {
                    java.lang.ref.WeakReference<android.view.View> view = viewNode2.getView() != null ? viewNode2.getView() : null;
                    if (view != null && view.get() != null) {
                        str = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(view.get(), true);
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    if (str != null) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("find property target view success, property element_path: %s,element_position: %s,element_content: %s", visualProperty.elementPath, visualProperty.elementPosition, str));
                        if (!android.text.TextUtils.isEmpty(visualProperty.regular)) {
                        }
                        if (android.text.TextUtils.isEmpty(str2)) {
                        }
                    }
                    collectLogListener = this.mCollectLogListener;
                    if (collectLogListener == null) {
                    }
                }
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            str = null;
        }
        if (str != null && !android.text.TextUtils.isEmpty(str)) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("find property target view success, property element_path: %s,element_position: %s,element_content: %s", visualProperty.elementPath, visualProperty.elementPosition, str));
            if (!android.text.TextUtils.isEmpty(visualProperty.regular)) {
                try {
                    java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(visualProperty.regular, 40).matcher(str);
                    if (!matcher.find()) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "matcher not find continue");
                        com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener collectLogListener2 = this.mCollectLogListener;
                        if (collectLogListener2 != null) {
                            collectLogListener2.onParsePropertyContentFailure(visualProperty.name, visualProperty.type, str, visualProperty.regular);
                            return;
                        }
                        return;
                    }
                    str2 = matcher.group();
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("propertyValue is: %s", str2));
                } catch (java.lang.Exception e4) {
                    com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener collectLogListener3 = this.mCollectLogListener;
                    if (collectLogListener3 != null) {
                        collectLogListener3.onParsePropertyContentFailure(visualProperty.name, visualProperty.type, str, visualProperty.regular);
                    }
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e4);
                    return;
                }
            }
            if (android.text.TextUtils.isEmpty(str2)) {
                if (!android.text.TextUtils.equals(PROPERTY_TYPE_NUMBER, visualProperty.type)) {
                    try {
                        jSONObject.put(visualProperty.name, str2);
                        return;
                    } catch (org.json.JSONException e5) {
                        com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener collectLogListener4 = this.mCollectLogListener;
                        if (collectLogListener4 != null) {
                            collectLogListener4.onOtherError(e5.getMessage());
                            return;
                        }
                        return;
                    }
                }
                if (str2 != null) {
                    try {
                        jSONObject.put(visualProperty.name, java.text.NumberFormat.getInstance().parse(str2));
                        return;
                    } catch (java.lang.Exception e6) {
                        com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener collectLogListener5 = this.mCollectLogListener;
                        if (collectLogListener5 != null) {
                            collectLogListener5.onOtherError(e6.getMessage());
                            return;
                        }
                        return;
                    }
                }
                return;
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return;
            }
            return;
        }
        collectLogListener = this.mCollectLogListener;
        if (collectLogListener == null) {
            collectLogListener.onFindPropertyElementFailure(visualProperty.name, visualProperty.elementPath, visualProperty.elementPosition);
        }
    }

    public void mergeVisualProperties(com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.VisualEventType visualEventType, org.json.JSONObject jSONObject, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.ref.WeakReference<android.view.View> view;
        try {
            java.lang.String optString = jSONObject.optString("$screen_name");
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener collectLogListener = this.mCollectLogListener;
            if (collectLogListener != null) {
                collectLogListener.onStart(visualEventType.visualEventType, optString, viewNode);
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("mergeVisualProperties eventType: %s, screenName:%s ", visualEventType.getVisualEventType(), optString));
            if (android.text.TextUtils.isEmpty(optString)) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "screenName is empty and return");
                return;
            }
            if (!com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isVisualizedAutoTrackEnabled()) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "you should call 'enableVisualizedAutoTrack(true)' first");
                com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener collectLogListener2 = this.mCollectLogListener;
                if (collectLogListener2 != null) {
                    collectLogListener2.onSwitchClose();
                    return;
                }
                return;
            }
            android.app.Activity activityOfView = (viewNode == null || (view = viewNode.getView()) == null || view.get() == null) ? null : com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(view.get().getContext(), view.get());
            if (activityOfView == null) {
                activityOfView = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity();
            }
            if (activityOfView != null && com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isVisualizedAutoTrackActivity(activityOfView.getClass())) {
                if (this.mVisualConfig == null) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "visual properties is empty and return");
                    com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener collectLogListener3 = this.mCollectLogListener;
                    if (collectLogListener3 != null) {
                        collectLogListener3.onCheckVisualConfigFailure(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSAContextManager().getContext(), com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_cache_no_property_error));
                        return;
                    }
                    return;
                }
                if (!checkAppIdAndProject()) {
                    com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener collectLogListener4 = this.mCollectLogListener;
                    if (collectLogListener4 != null) {
                        collectLogListener4.onCheckVisualConfigFailure(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSAContextManager().getContext(), com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_appid_error));
                        return;
                    }
                    return;
                }
                java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualPropertiesConfig> list = this.mVisualConfig.events;
                if (list != null && list.size() != 0) {
                    if (viewNode != null) {
                        str = viewNode.getViewPath();
                        str2 = viewNode.getViewPosition();
                        str3 = viewNode.getViewContent();
                    } else {
                        str = null;
                        str2 = null;
                        str3 = null;
                    }
                    java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualPropertiesConfig> matchEventConfigList = getMatchEventConfigList(list, visualEventType, optString, str, str2, str3);
                    if (matchEventConfigList.size() == 0) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "event config is empty and return");
                        com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener collectLogListener5 = this.mCollectLogListener;
                        if (collectLogListener5 != null) {
                            collectLogListener5.onCheckEventConfigFailure();
                            return;
                        }
                        return;
                    }
                    for (com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualPropertiesConfig visualPropertiesConfig : matchEventConfigList) {
                        com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualEvent visualEvent = visualPropertiesConfig.event;
                        if (visualEvent == null || !visualEvent.isH5) {
                            java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualProperty> list2 = visualPropertiesConfig.properties;
                            if (list2 != null && list2.size() != 0) {
                                mergeVisualProperty(list2, visualEvent, jSONObject, viewNode, visualPropertiesConfig.eventName);
                            }
                            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "properties is empty ");
                        }
                    }
                    return;
                }
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "propertiesConfigs is empty");
                com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener collectLogListener6 = this.mCollectLogListener;
                if (collectLogListener6 != null) {
                    collectLogListener6.onOtherError("propertiesConfigs is empty");
                    return;
                }
                return;
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "activity is null or not in white list and return");
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener collectLogListener7 = this.mCollectLogListener;
            if (collectLogListener7 != null) {
                collectLogListener7.onOtherError("activity is null or not in white list and return");
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void registerCollectLogListener(com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.CollectLogListener collectLogListener) {
        this.mCollectLogListener = collectLogListener;
    }

    public void requestVisualConfig(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        if (sAContextManager != null) {
            try {
                if (sAContextManager.getSensorsDataAPI().isNetworkRequestEnable() && !com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.isSDKDisabled()) {
                    if (sAContextManager.getInternalConfigs().saConfigOptions.isVisualizedPropertiesEnabled()) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_REQUEST_VISUAL_CONFIG);
                        this.mRequestHelper.requestVisualConfig(sAContextManager.getContext(), getVisualConfigVersion(), new com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.AnonymousClass1());
                        return;
                    }
                    return;
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return;
            }
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Close network request");
    }

    public void save2Cache(java.lang.String str) {
        this.mConfigCache.save2Cache(str);
        this.mVisualConfig = this.mConfigCache.getVisualConfig();
    }

    public void unRegisterCollectLogListener() {
        this.mCollectLogListener = null;
    }
}
