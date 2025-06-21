package com.sensorsdata.sf.ui.view;

/* loaded from: classes19.dex */
public enum SensorsFocusActionModel {
    CLOSE,
    OPEN_LINK,
    COPY,
    CUSTOMIZE;

    private org.json.JSONObject extra;
    private java.lang.String value;

    public org.json.JSONObject getExtra() {
        return this.extra;
    }

    public java.lang.String getValue() {
        return this.value;
    }

    public void setExtra(org.json.JSONObject jSONObject) {
        this.extra = jSONObject;
    }

    public void setValue(java.lang.String str) {
        this.value = str;
    }
}
