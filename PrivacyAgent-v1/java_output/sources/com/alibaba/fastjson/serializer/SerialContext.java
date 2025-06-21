package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public class SerialContext {
    public final int features;
    public final java.lang.Object fieldName;
    public final java.lang.Object object;
    public final com.alibaba.fastjson.serializer.SerialContext parent;

    public SerialContext(com.alibaba.fastjson.serializer.SerialContext serialContext, java.lang.Object obj, java.lang.Object obj2, int i) {
        this.parent = serialContext;
        this.object = obj;
        this.fieldName = obj2;
        this.features = i;
    }

    public java.lang.String toString() {
        if (this.parent == null) {
            return "$";
        }
        if (!(this.fieldName instanceof java.lang.Integer)) {
            return this.parent.toString() + "." + this.fieldName;
        }
        return this.parent.toString() + "[" + this.fieldName + "]";
    }
}
