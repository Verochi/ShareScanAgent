package com.sensorsdata.sf.core.entity;

/* loaded from: classes19.dex */
public class Matcher {
    public java.lang.String eventName;
    public com.sensorsdata.sf.core.window.Window eventWindow;
    public com.sensorsdata.sf.core.entity.Filter filter;
    public java.lang.String function;
    public java.lang.String measure;
    public java.util.List<java.lang.String> params;
    public java.lang.String type;

    public java.lang.String toString() {
        return "Matcher{eventName='" + this.eventName + "', params=" + this.params + ", eventWindow=" + this.eventWindow + ", type='" + this.type + "', filter=" + this.filter + ", measure='" + this.measure + "', function='" + this.function + "'}";
    }
}
