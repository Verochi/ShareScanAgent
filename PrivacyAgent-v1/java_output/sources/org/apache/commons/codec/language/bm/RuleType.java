package org.apache.commons.codec.language.bm;

/* loaded from: classes24.dex */
public enum RuleType {
    APPROX("approx"),
    EXACT("exact"),
    RULES("rules");

    private final java.lang.String name;

    RuleType(java.lang.String str) {
        this.name = str;
    }

    public java.lang.String getName() {
        return this.name;
    }
}
