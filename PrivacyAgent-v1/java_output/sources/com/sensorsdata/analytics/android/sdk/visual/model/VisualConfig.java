package com.sensorsdata.analytics.android.sdk.visual.model;

/* loaded from: classes19.dex */
public class VisualConfig {
    public java.lang.String appId;
    public java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualPropertiesConfig> events;
    public java.lang.String os;
    public java.lang.String project;
    public java.lang.String version;

    public static class VisualEvent {
        public java.lang.String elementContent;
        public java.lang.String elementPath;
        public java.lang.String elementPosition;
        public boolean isH5;
        public boolean limitElementContent;
        public boolean limitElementPosition;
        public java.lang.String screenName;

        public java.lang.String toString() {
            return "VisualEvent{elementPath='" + this.elementPath + "', elementPosition='" + this.elementPosition + "', elementContent='" + this.elementContent + "', screenName='" + this.screenName + "', limitElementPosition=" + this.limitElementPosition + ", limitElementContent=" + this.limitElementContent + ", isH5=" + this.isH5 + '}';
        }
    }

    public static class VisualPropertiesConfig {
        public com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualEvent event;
        public java.lang.String eventName;
        public java.lang.String eventType;
        public java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualProperty> properties;

        public java.lang.String toString() {
            return "VisualPropertiesConfig{eventName='" + this.eventName + "', eventType='" + this.eventType + "', event=" + this.event + ", properties=" + this.properties + '}';
        }
    }

    public static class VisualProperty {
        public java.lang.String elementPath;
        public java.lang.String elementPosition;
        public boolean isH5;
        public java.lang.String name;
        public java.lang.String regular;
        public java.lang.String screenName;
        public java.lang.String type;
        public java.lang.String webViewElementPath;

        public java.lang.String toString() {
            return "VisualProperty{elementPath='" + this.elementPath + "', elementPosition='" + this.elementPosition + "', screenName='" + this.screenName + "', name='" + this.name + "', regular='" + this.regular + "', type='" + this.type + "', isH5=" + this.isH5 + ", webViewElementPath='" + this.webViewElementPath + "'}";
        }
    }

    public java.lang.String toString() {
        return "VisualConfig{appId='" + this.appId + "', os='" + this.os + "', project='" + this.project + "', version='" + this.version + "', events=" + this.events + '}';
    }
}
