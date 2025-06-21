package com.aliyun.player.source;

/* loaded from: classes.dex */
public enum Definition {
    DEFINITION_FD("FD"),
    DEFINITION_LD("LD"),
    DEFINITION_SD("SD"),
    DEFINITION_HD("HD"),
    DEFINITION_OD("OD"),
    DEFINITION_2K("2K"),
    DEFINITION_4K("4K"),
    DEFINITION_SQ("SQ"),
    DEFINITION_HQ("HQ"),
    DEFINITION_AUTO("AUTO");

    private java.lang.String mName;

    Definition(java.lang.String str) {
        this.mName = str;
    }

    public java.lang.String getName() {
        return this.mName;
    }
}
