package com.alimm.tanx.core.ad.event.track.expose;

/* loaded from: classes.dex */
public class tanxc_if {
    private java.lang.String tanxc_do;
    private boolean tanxc_for;
    private java.lang.String tanxc_if;
    private boolean tanxc_int;
    private int tanxc_new = 0;
    private int tanxc_try = 3;

    public tanxc_if(java.lang.String str, java.lang.String str2, boolean z) {
        this.tanxc_do = str;
        this.tanxc_if = str2;
        this.tanxc_int = z;
    }

    public java.lang.String tanxc_do() {
        return this.tanxc_do;
    }

    public void tanxc_do(boolean z) {
        this.tanxc_for = z;
    }

    public boolean tanxc_for() {
        return this.tanxc_for;
    }

    public java.lang.String tanxc_if() {
        return this.tanxc_if;
    }

    public boolean tanxc_int() {
        return this.tanxc_int;
    }

    public void tanxc_new() {
        this.tanxc_new++;
    }

    public boolean tanxc_try() {
        return this.tanxc_new >= this.tanxc_try;
    }
}
