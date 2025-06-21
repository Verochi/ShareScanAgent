package com.anythink.expressad.video.dynview.c;

/* loaded from: classes12.dex */
public enum b implements com.anythink.expressad.video.dynview.c.a {
    NOT_FOUND_VIEWOPTION(-1, "ViewOption is null"),
    NOT_FOUND_CONTEXT(-2, "Context is null"),
    NOT_FOUND_LAYOUTNAME(-3, "layout xml name is null"),
    CAMPAIGNEX_IS_NULL(-4, "Campaign size only one"),
    VIEW_CREATE_ERROR(-5, "view create error"),
    NOT_FOUND_ROOTVIEW(-6, "rootview is null");

    private int g;
    private java.lang.String h;

    b(int i2, java.lang.String str) {
        this.g = i2;
        this.h = str;
    }

    public final int a() {
        return this.g;
    }

    public final java.lang.String b() {
        return this.h;
    }
}
