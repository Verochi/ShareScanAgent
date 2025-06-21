package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class Encrypto implements com.alimm.tanx.core.utils.NotConfused {
    static {
        java.lang.System.loadLibrary("encrypto");
    }

    public static native java.lang.String encrypt();
}
