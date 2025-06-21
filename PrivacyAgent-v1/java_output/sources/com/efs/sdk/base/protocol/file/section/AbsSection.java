package com.efs.sdk.base.protocol.file.section;

/* loaded from: classes22.dex */
public abstract class AbsSection {
    public static final java.lang.String SEP_LINE_BREAK = "linebreak";
    public static final java.lang.String SEP_ORIGIN_LINE_BREAK = "\n";
    java.lang.String type;
    java.lang.String name = "";
    java.lang.String version = "1.0";
    java.lang.String sep = "";

    public AbsSection(java.lang.String str) {
        this.type = str;
    }

    public abstract java.lang.String changeToStr();

    public java.lang.String getDeclarationLine() {
        return "section:" + this.name + "," + this.type + "," + this.version + "," + this.sep;
    }

    public void setSep(java.lang.String str) {
        if (str.equals("\n")) {
            this.sep = SEP_LINE_BREAK;
        } else {
            this.sep = str;
        }
    }
}
