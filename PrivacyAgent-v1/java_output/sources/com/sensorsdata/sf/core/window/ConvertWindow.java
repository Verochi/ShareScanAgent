package com.sensorsdata.sf.core.window;

/* loaded from: classes19.dex */
public class ConvertWindow extends com.sensorsdata.sf.core.window.Window {
    private java.lang.String uuid;

    public java.lang.String getUUID() {
        return this.uuid;
    }

    public void setUUID(java.lang.String str) {
        this.uuid = str;
    }

    @Override // com.sensorsdata.sf.core.window.Window
    public java.lang.String toString() {
        return super.toString() + "ConvertWindow{uuid='" + this.uuid + "'}";
    }
}
