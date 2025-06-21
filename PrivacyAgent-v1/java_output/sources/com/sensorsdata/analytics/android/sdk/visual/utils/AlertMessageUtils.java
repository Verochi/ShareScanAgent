package com.sensorsdata.analytics.android.sdk.visual.utils;

/* loaded from: classes19.dex */
public class AlertMessageUtils {
    private static final java.lang.String TAG = "SA.AlertMessageUtils";

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sensorsdata$analytics$android$sdk$visual$utils$AlertMessageUtils$AlertRunnable$AlertType;

        static {
            int[] iArr = new int[com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.AlertRunnable.AlertType.values().length];
            $SwitchMap$com$sensorsdata$analytics$android$sdk$visual$utils$AlertMessageUtils$AlertRunnable$AlertType = iArr;
            try {
                iArr[com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.AlertRunnable.AlertType.H5.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sensorsdata$analytics$android$sdk$visual$utils$AlertMessageUtils$AlertRunnable$AlertType[com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.AlertRunnable.AlertType.FLUTTER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public static class AlertRunnable implements java.lang.Runnable {
        private final com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.AlertRunnable.AlertType alertType;
        private final java.lang.String unique;

        public enum AlertType {
            H5,
            FLUTTER
        }

        public AlertRunnable(com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.AlertRunnable.AlertType alertType, java.lang.String str) {
            this.unique = str;
            this.alertType = alertType;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.AnonymousClass1.$SwitchMap$com$sensorsdata$analytics$android$sdk$visual$utils$AlertMessageUtils$AlertRunnable$AlertType[this.alertType.ordinal()];
            if (i == 1) {
                com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.h5AlertHandlerFailure(this.unique);
            } else {
                if (i != 2) {
                    return;
                }
                com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.flutterAlertHandlerFailure(this.unique);
            }
        }
    }

    private static void buildAlertInfo(java.io.OutputStream outputStream, java.lang.String str, java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.AlertInfo> list, android.content.Context context) throws java.io.IOException {
        if (list == null || list.size() <= 0) {
            return;
        }
        outputStream.write(",\"app_alert_infos\":".getBytes());
        outputStream.flush();
        outputStream.write("[".getBytes());
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                outputStream.write(",".getBytes());
            }
            com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.AlertInfo alertInfo = list.get(i);
            if (alertInfo != null) {
                if (android.text.TextUtils.equals(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TYPE_HEAT_MAP, str)) {
                    alertInfo.title = alertInfo.title.replace(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual), com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_heatmap));
                }
                outputStream.write("{".getBytes());
                outputStream.write("\"title\":".getBytes());
                outputStream.write(("\"" + alertInfo.title + "\"").getBytes());
                outputStream.write(",".getBytes());
                outputStream.write("\"message\":".getBytes());
                outputStream.write(("\"" + alertInfo.message + "\"").getBytes());
                outputStream.write(",".getBytes());
                outputStream.write("\"link_text\":".getBytes());
                outputStream.write(("\"" + alertInfo.linkText + "\"").getBytes());
                outputStream.write(",".getBytes());
                outputStream.write("\"link_url\":".getBytes());
                outputStream.write(("\"" + alertInfo.linkUrl + "\"").getBytes());
                outputStream.write(com.alipay.sdk.m.u.i.d.getBytes());
            }
        }
        outputStream.write("]".getBytes());
        outputStream.flush();
    }

    public static void buildFlutterAlertInfo(java.io.OutputStream outputStream, java.lang.String str, com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapInfo, android.content.Context context) throws java.io.IOException {
        buildAlertInfo(outputStream, str, snapInfo.flutter_alertInfos, context);
    }

    public static void buildH5AlertInfo(java.io.OutputStream outputStream, java.lang.String str, com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapInfo, android.content.Context context) throws java.io.IOException {
        com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo webNodeInfo = (com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo) com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getWebNodesManager().getPageInfo(snapInfo.webViewUrl);
        if (webNodeInfo != null) {
            if (!android.text.TextUtils.isEmpty(webNodeInfo.getUrl())) {
                outputStream.write((",\"h5_url\": \"" + webNodeInfo.getUrl() + "\"").getBytes());
            }
            if (!android.text.TextUtils.isEmpty(webNodeInfo.getTitle())) {
                outputStream.write((",\"h5_title\": \"" + webNodeInfo.getTitle() + "\"").getBytes());
            }
        }
        buildAlertInfo(outputStream, str, snapInfo.alertInfos, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void flutterAlertHandlerFailure(java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Flutter page is not integrated SDK");
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        android.content.Context context = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSAContextManager().getContext();
        com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getFlutterNodesManager().handlerFailure(str, "{\"callType\":\"app_alert\",\"data\":[{\"title\":\"" + com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_sa_h5) + "\",\"message\":\"" + com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_sa_flutter_error) + "\",\"link_text\":\"" + com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_sa_h5_error_link) + "\",\"link_url\":\"https://manual.sensorsdata.cn/sa/latest/flutter-22257963.html\"}]}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h5AlertHandlerFailure(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || ((com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo) com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getWebNodesManager().getNodes(str)) != null) {
            return;
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "H5 page is not integrated Web JS SDK");
        android.content.Context context = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSAContextManager().getContext();
        com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getWebNodesManager().handlerFailure(str, "{\"callType\":\"app_alert\",\"data\":[{\"title\":\"" + com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_sa_h5) + "\",\"message\":\"" + com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_sa_h5_error) + "\",\"link_text\":\"" + com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_sa_h5_error_link) + "\",\"link_url\":\"https://manual.sensorsdata.cn/sa/latest/tech_sdk_client_web_use-7545346.html\"}]}");
    }
}
