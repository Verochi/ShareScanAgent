package com.sensorsdata.analytics.android.sdk.visual.model;

/* loaded from: classes19.dex */
public class FlutterNodeInfo extends com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo {
    private final java.lang.String flutter_lib_version;
    private final java.lang.String screen_name;

    public static class FlutterNodeBuilder extends com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Builder<com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo> {
        private java.lang.String flutter_lib_version;
        private java.lang.String screen_name;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Builder
        public com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo create() {
            return new com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo(this.webNodes, this.alertInfos, this.title, this.screen_name, this.flutter_lib_version, this.status, null);
        }

        public com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo.FlutterNodeBuilder setFlutter_lib_version(java.lang.String str) {
            this.flutter_lib_version = str;
            return this;
        }

        public com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo.FlutterNodeBuilder setScreen_name(java.lang.String str) {
            this.screen_name = str;
            return this;
        }
    }

    private FlutterNodeInfo(java.util.List<? extends com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> list, java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.AlertInfo> list2, java.lang.String str, java.lang.String str2, java.lang.String str3, com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Status status) {
        this.webNodes = list;
        this.alertInfos = list2;
        this.title = str;
        this.screen_name = str2;
        this.flutter_lib_version = str3;
        this.status = status;
    }

    public /* synthetic */ FlutterNodeInfo(java.util.List list, java.util.List list2, java.lang.String str, java.lang.String str2, java.lang.String str3, com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Status status, com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo.AnonymousClass1 anonymousClass1) {
        this(list, list2, str, str2, str3, status);
    }

    public static com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo createAlertInfo(java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.AlertInfo> list) {
        return new com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo.FlutterNodeBuilder().setAlertInfo(list).setStatus(com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Status.FAILURE).create();
    }

    public static com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo createNodesInfo(java.util.List<? extends com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> list) {
        return new com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo.FlutterNodeBuilder().setWebNodes(list).setStatus(com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Status.SUCCESS).create();
    }

    public static com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo createPageInfo(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return new com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo.FlutterNodeBuilder().setScreen_name(str2).setFlutter_lib_version(str3).setTitle(str).create();
    }

    public java.lang.String getFlutter_lib_version() {
        return this.flutter_lib_version;
    }

    public java.lang.String getScreen_name() {
        return this.screen_name;
    }
}
