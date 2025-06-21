package org.apache.commons.codec.language.bm;

/* loaded from: classes24.dex */
public enum NameType {
    ASHKENAZI("ash"),
    GENERIC("gen"),
    SEPHARDIC("sep");

    private final java.lang.String name;

    NameType(java.lang.String str) {
        this.name = str;
    }

    public java.lang.String getName() {
        return this.name;
    }
}
