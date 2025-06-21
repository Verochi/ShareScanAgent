package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class FlexInteger {
    public java.lang.Integer a;

    public FlexInteger(java.lang.String str) {
        this.a = java.lang.Integer.decode(str);
    }

    public int intValue() {
        return this.a.intValue();
    }

    public java.lang.String toString() {
        return this.a.toString();
    }
}
