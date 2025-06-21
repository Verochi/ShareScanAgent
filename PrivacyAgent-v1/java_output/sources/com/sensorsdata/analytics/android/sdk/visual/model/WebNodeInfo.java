package com.sensorsdata.analytics.android.sdk.visual.model;

/* loaded from: classes19.dex */
public class WebNodeInfo extends com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo {
    private java.lang.String url;

    public static class WebNodeBuilder extends com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Builder<com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo> {
        private java.lang.String url;

        @Override // com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Builder
        public com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo create() {
            return new com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo(this.webNodes, this.alertInfos, this.title, this.url, this.status, null);
        }

        public com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo.WebNodeBuilder setUrl(java.lang.String str) {
            this.url = str;
            return this;
        }
    }

    private WebNodeInfo(java.util.List<? extends com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> list, java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.AlertInfo> list2, java.lang.String str, java.lang.String str2, com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Status status) {
        this.webNodes = list;
        this.alertInfos = list2;
        this.title = str;
        this.url = str2;
        this.status = status;
    }

    public /* synthetic */ WebNodeInfo(java.util.List list, java.util.List list2, java.lang.String str, java.lang.String str2, com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Status status, com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo.AnonymousClass1 anonymousClass1) {
        this(list, list2, str, str2, status);
    }

    public static com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo createAlertInfo(java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.AlertInfo> list) {
        return new com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo.WebNodeBuilder().setAlertInfo(list).setStatus(com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Status.FAILURE).create();
    }

    public static com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo createNodesInfo(java.util.List<? extends com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> list) {
        return new com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo.WebNodeBuilder().setWebNodes(list).setStatus(com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Status.SUCCESS).create();
    }

    public static com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo createPageInfo(java.lang.String str, java.lang.String str2) {
        return new com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo.WebNodeBuilder().setUrl(str2).setTitle(str).create();
    }

    public java.lang.String getUrl() {
        return this.url;
    }
}
