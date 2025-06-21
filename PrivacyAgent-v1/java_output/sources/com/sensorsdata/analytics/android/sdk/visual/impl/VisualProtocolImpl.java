package com.sensorsdata.analytics.android.sdk.visual.impl;

/* loaded from: classes19.dex */
public class VisualProtocolImpl {
    private static final java.lang.String TAG = "SA.SAVisualProtocolImpl";
    private final com.sensorsdata.analytics.android.sdk.core.SAContextManager mSAContextManager;

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.impl.VisualProtocolImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass1(android.content.Context context) {
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            new com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog(this.val$context).show();
        }
    }

    public VisualProtocolImpl(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mSAContextManager = sAContextManager;
        com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(new com.sensorsdata.analytics.android.sdk.visual.utils.AppStateManager());
    }

    private void addVisualJavascriptInterface(android.view.View view) {
        if (view != null) {
            int i = com.sensorsdata.analytics.android.sdk.visual.R.id.sensors_analytics_tag_view_webview_visual;
            if (view.getTag(i) == null) {
                view.setTag(i, new java.lang.Object());
                com.sensorsdata.analytics.android.sdk.jsbridge.H5Helper.addJavascriptInterface(view, new com.sensorsdata.analytics.android.sdk.visual.WebViewVisualInterface(view), "SensorsData_App_Visual_Bridge");
            }
        }
    }

    private java.lang.String appVisualConfig() {
        try {
            if (this.mSAContextManager.getInternalConfigs().saConfigOptions != null && this.mSAContextManager.getInternalConfigs().saConfigOptions.isVisualizedPropertiesEnabled()) {
                com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().getVisualPropertiesH5Helper().registerListeners();
                return com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().getVisualPropertiesCache().getVisualCache();
            }
            return null;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    private void mergeVisualProperties(org.json.JSONObject jSONObject, android.view.View view) {
        if (view == null) {
            return;
        }
        try {
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode addViewPathProperties = com.sensorsdata.analytics.android.sdk.visual.utils.VisualUtil.addViewPathProperties(com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(view.getContext(), view), view, jSONObject);
            if (this.mSAContextManager.getInternalConfigs().saConfigOptions.isVisualizedPropertiesEnabled()) {
                com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().mergeVisualProperties(com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.VisualEventType.APP_CLICK, jSONObject, addViewPathProperties);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void showPairingCodeInputDialog(android.content.Context context) {
        if (this.mSAContextManager.getContext() == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "The argument context can't be null");
        } else if (context instanceof android.app.Activity) {
            ((android.app.Activity) context).runOnUiThread(new com.sensorsdata.analytics.android.sdk.visual.impl.VisualProtocolImpl.AnonymousClass1(context));
        } else {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "The static method showPairingCodeEditDialog(Context context) only accepts Activity as a parameter");
        }
    }

    public java.lang.String flutterGetAppVisualConfig() {
        java.lang.String appVisualConfig = appVisualConfig();
        if (android.text.TextUtils.isEmpty(appVisualConfig)) {
            return null;
        }
        return android.util.Base64.encodeToString(appVisualConfig.getBytes(), 2);
    }

    public java.lang.Boolean getVisualState() {
        return java.lang.Boolean.valueOf(com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance().isServiceRunning() || com.sensorsdata.analytics.android.sdk.visual.HeatMapService.getInstance().isServiceRunning());
    }

    public java.lang.String h5GetAppVisualConfig() {
        java.lang.String appVisualConfig = appVisualConfig();
        if (android.text.TextUtils.isEmpty(appVisualConfig)) {
            return null;
        }
        return android.util.Base64.encodeToString(appVisualConfig.getBytes(), 0);
    }

    public <T> T invokeModuleFunction(java.lang.String str, java.lang.Object... objArr) {
        char c;
        try {
            switch (str.hashCode()) {
                case -2132080600:
                    if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_RESUME_VISUAL_SERVICE)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -2103270069:
                    if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_ADD_VISUAL_JAVASCRIPTINTERFACE)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -2071982886:
                    if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_H5_GET_APPVISUAL_CONFIG)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case -1974002693:
                    if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_GET_VISUAL_STATE)) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case -1706331910:
                    if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_SHOW_PAIRING_CODE_INPUTDIALOG)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -746052307:
                    if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_SHOW_OPEN_VISUALIZED_AUTOTRACK_DIALOG)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -467015053:
                    if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_STOP_VISUAL_SERVICE)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -366380714:
                    if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_RESUME_HEATMAP_SERVICE)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -288956309:
                    if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_STOP_HEATMAP_SERVICE)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 561737425:
                    if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_REQUEST_VISUAL_CONFIG)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 834619917:
                    if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_SHOW_OPEN_HEATMAP_DIALOG)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 873596527:
                    if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_SEND_VISUALIZED_MESSAGE)) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 1417500907:
                    if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_MERGE_VISUAL_PROPERTIES)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1571660393:
                    if (str.equals(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_FLUTTER_GET_APPVISUAL_CONFIG)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    addVisualJavascriptInterface((android.view.View) objArr[0]);
                    return null;
                case 1:
                    com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().requestVisualConfig(this.mSAContextManager);
                    return null;
                case 2:
                    mergeVisualProperties((org.json.JSONObject) objArr[0], (android.view.View) objArr[1]);
                    return null;
                case 3:
                    com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance().resume();
                    return null;
                case 4:
                    com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance().stop();
                    return null;
                case 5:
                    com.sensorsdata.analytics.android.sdk.visual.HeatMapService.getInstance().resume();
                    return null;
                case 6:
                    com.sensorsdata.analytics.android.sdk.visual.HeatMapService.getInstance().stop();
                    return null;
                case 7:
                    showPairingCodeInputDialog((android.content.Context) objArr[0]);
                    return null;
                case '\b':
                    com.sensorsdata.analytics.android.sdk.visual.view.VisualDialog.showOpenHeatMapDialog((android.app.Activity) objArr[0], (java.lang.String) objArr[1], (java.lang.String) objArr[2]);
                    return null;
                case '\t':
                    com.sensorsdata.analytics.android.sdk.visual.view.VisualDialog.showOpenVisualizedAutoTrackDialog((android.app.Activity) objArr[0], (java.lang.String) objArr[1], (java.lang.String) objArr[2]);
                    return null;
                case '\n':
                    return (T) h5GetAppVisualConfig();
                case 11:
                    return (T) flutterGetAppVisualConfig();
                case '\f':
                    return (T) getVisualState();
                case '\r':
                    sendVisualizedMessage((java.lang.String) objArr[0]);
                    return null;
                default:
                    return null;
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public void sendVisualizedMessage(java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getFlutterNodesManager().handlerMessage(str);
    }
}
