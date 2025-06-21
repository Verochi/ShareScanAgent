package com.sensorsdata.sf.core.entity;

/* loaded from: classes19.dex */
public class PopupPlan {
    public int absolutePriority;
    public java.lang.Long audienceId;
    public java.lang.String cname;
    public com.sensorsdata.sf.core.window.ConvertWindow convertWindow;
    public boolean enableGlobalMsgLimit;
    public long expireAt;
    public boolean isAudience;
    public boolean isControlGroup;
    public boolean isTrigger;
    public long lastUpdateConfigTime;
    public org.json.JSONObject pageFilter;
    public com.sensorsdata.sf.core.entity.PatternPopup patternPopup;
    public long planId;
    public com.sensorsdata.sf.core.window.Window planIntervalWindow;
    public com.sensorsdata.sf.core.window.Window planReEntryWindow;
    public org.json.JSONObject popupWindowContent;
    public java.lang.String section_id;
    public java.lang.String status;
    public java.lang.String strategyId;
    public org.json.JSONObject windowUpdate;

    public boolean equals(java.lang.Object obj) {
        return ((com.sensorsdata.sf.core.entity.PopupPlan) obj).planId == this.planId;
    }

    public int hashCode() {
        return java.lang.Integer.parseInt(this.planId + "");
    }

    public boolean isActive() {
        return android.text.TextUtils.equals(this.status, "ACTIVE");
    }

    public boolean isExpired() {
        return java.lang.System.currentTimeMillis() >= this.expireAt;
    }

    public java.lang.String toString() {
        return "PopupPlan{planId=" + this.planId + ", cname='" + this.cname + "', patternPopup=" + this.patternPopup + ", reEntry=" + this.planReEntryWindow + ", convertWindow=" + this.convertWindow + ", planIntervalWindow=" + this.planIntervalWindow + ", isAudience=" + this.isAudience + ", isControlGroup=" + this.isControlGroup + ", audienceId=" + this.audienceId + ", status='" + this.status + "', absolutePriority=" + this.absolutePriority + ", lastUpdateConfigTime=" + this.lastUpdateConfigTime + ", expireAt=" + this.expireAt + ", pageFilter=" + this.pageFilter + ", enableGlobalMsgLimit=" + this.enableGlobalMsgLimit + ",section_id=" + this.section_id + '}';
    }
}
