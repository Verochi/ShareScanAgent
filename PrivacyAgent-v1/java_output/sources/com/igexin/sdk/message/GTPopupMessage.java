package com.igexin.sdk.message;

/* loaded from: classes23.dex */
public class GTPopupMessage extends com.igexin.sdk.message.BaseMessage {
    private com.igexin.sdk.message.GTPopupMessage.GtAction action;
    private java.lang.String elementType;
    private com.igexin.sdk.message.GTPopupMessage.EventProperties eventProperties;

    public static class EventProperties implements java.io.Serializable {
        private final java.lang.String $popup_click_modal;
        private final java.lang.String $popup_node_modal_name;
        private final java.lang.String $popup_node_name;
        private final java.lang.String $popup_plan_name;

        public EventProperties(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            this.$popup_plan_name = str;
            this.$popup_node_name = str2;
            this.$popup_click_modal = str3;
            this.$popup_node_modal_name = str4;
        }

        public java.lang.String get$popup_click_modal() {
            return this.$popup_click_modal;
        }

        public java.lang.String get$popup_node_modal_name() {
            return this.$popup_node_modal_name;
        }

        public java.lang.String get$popup_node_name() {
            return this.$popup_node_name;
        }

        public java.lang.String get$popup_plan_name() {
            return this.$popup_plan_name;
        }

        public java.lang.String toString() {
            return "{\"$popup_plan_name\":\"" + this.$popup_plan_name + kotlin.text.Typography.quote + ", \"$popup_node_name\":\"" + this.$popup_node_name + kotlin.text.Typography.quote + ", \"$popup_click_modal\":\"" + this.$popup_click_modal + kotlin.text.Typography.quote + ", \"$popup_node_modal_name\":\"" + this.$popup_node_modal_name + kotlin.text.Typography.quote + '}';
        }
    }

    public static class GtAction implements java.io.Serializable {
        private final java.lang.String actionType;
        private final boolean closePopup;
        private final java.lang.String intent;
        private final java.lang.String url;

        public GtAction(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
            this.actionType = str;
            this.intent = str2;
            this.url = str3;
            this.closePopup = z;
        }

        public java.lang.String getActionType() {
            return this.actionType;
        }

        public java.lang.String getIntent() {
            return this.intent;
        }

        public java.lang.String getUrl() {
            return this.url;
        }

        public boolean isClosePopup() {
            return this.closePopup;
        }
    }

    public com.igexin.sdk.message.GTPopupMessage.GtAction getAction() {
        return this.action;
    }

    public java.lang.String getElementType() {
        return this.elementType;
    }

    public com.igexin.sdk.message.GTPopupMessage.EventProperties getEventProperties() {
        return this.eventProperties;
    }

    public void setAction(com.igexin.sdk.message.GTPopupMessage.GtAction gtAction) {
        this.action = gtAction;
    }

    public void setElementType(java.lang.String str) {
        this.elementType = str;
    }

    public void setEventProperties(com.igexin.sdk.message.GTPopupMessage.EventProperties eventProperties) {
        this.eventProperties = eventProperties;
    }
}
