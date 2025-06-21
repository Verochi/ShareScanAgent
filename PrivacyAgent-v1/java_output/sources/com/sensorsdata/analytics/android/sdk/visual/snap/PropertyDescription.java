package com.sensorsdata.analytics.android.sdk.visual.snap;

/* loaded from: classes19.dex */
public class PropertyDescription {
    public final com.sensorsdata.analytics.android.sdk.visual.snap.Caller accessor;
    private final java.lang.String mMutatorName;
    public final java.lang.String name;
    public final java.lang.Class<?> targetClass;

    public PropertyDescription(java.lang.String str, java.lang.Class<?> cls, com.sensorsdata.analytics.android.sdk.visual.snap.Caller caller, java.lang.String str2) {
        this.name = str;
        this.targetClass = cls;
        this.accessor = caller;
        this.mMutatorName = str2;
    }

    public java.lang.String toString() {
        return "[PropertyDescription " + this.name + "," + this.targetClass + ", " + this.accessor + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + this.mMutatorName + "]";
    }
}
