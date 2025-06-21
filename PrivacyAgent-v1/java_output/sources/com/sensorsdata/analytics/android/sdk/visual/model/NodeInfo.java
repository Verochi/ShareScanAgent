package com.sensorsdata.analytics.android.sdk.visual.model;

/* loaded from: classes19.dex */
public class NodeInfo {
    protected java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.AlertInfo> alertInfos;
    protected com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Status status;
    protected java.lang.String title;
    protected java.util.List<? extends com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> webNodes;

    public static class AlertInfo {
        public java.lang.String linkText;
        public java.lang.String linkUrl;
        public java.lang.String message;
        public java.lang.String title;

        public AlertInfo(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            this.title = str;
            this.message = str2;
            this.linkText = str3;
            this.linkUrl = str4;
        }
    }

    public static class Builder<T extends com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo> {
        protected java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.AlertInfo> alertInfos;
        protected com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Status status;
        protected java.lang.String title;
        protected java.util.List<? extends com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> webNodes;

        public T create() {
            return null;
        }

        public com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Builder<T> setAlertInfo(java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.AlertInfo> list) {
            this.alertInfos = list;
            return this;
        }

        public com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Builder<T> setStatus(com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Status status) {
            this.status = status;
            return this;
        }

        public com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Builder<T> setTitle(java.lang.String str) {
            this.title = str;
            return this;
        }

        public com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Builder<T> setWebNodes(java.util.List<? extends com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> list) {
            this.webNodes = list;
            return this;
        }
    }

    public enum Status {
        SUCCESS,
        FAILURE
    }

    public java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.AlertInfo> getAlertInfos() {
        return this.alertInfos;
    }

    public java.util.List<? extends com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> getNodes() {
        return this.webNodes;
    }

    public com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Status getStatus() {
        return this.status;
    }

    public java.lang.String getTitle() {
        return this.title;
    }
}
