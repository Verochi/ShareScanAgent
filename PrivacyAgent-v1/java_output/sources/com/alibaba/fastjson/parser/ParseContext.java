package com.alibaba.fastjson.parser;

/* loaded from: classes.dex */
public class ParseContext {
    public final java.lang.Object fieldName;
    public java.lang.Object object;
    public final com.alibaba.fastjson.parser.ParseContext parent;
    private transient java.lang.String path;
    public java.lang.reflect.Type type;

    public ParseContext(com.alibaba.fastjson.parser.ParseContext parseContext, java.lang.Object obj, java.lang.Object obj2) {
        this.parent = parseContext;
        this.object = obj;
        this.fieldName = obj2;
    }

    public java.lang.String toString() {
        if (this.path == null) {
            if (this.parent == null) {
                this.path = "$";
            } else if (this.fieldName instanceof java.lang.Integer) {
                this.path = this.parent.toString() + "[" + this.fieldName + "]";
            } else {
                this.path = this.parent.toString() + "." + this.fieldName;
            }
        }
        return this.path;
    }
}
