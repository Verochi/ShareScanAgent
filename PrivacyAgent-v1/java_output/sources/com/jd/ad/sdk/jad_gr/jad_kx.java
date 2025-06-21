package com.jd.ad.sdk.jad_gr;

/* loaded from: classes23.dex */
public abstract class jad_kx<CHILD extends com.jd.ad.sdk.jad_gr.jad_kx<CHILD, TranscodeType>, TranscodeType> implements java.lang.Cloneable {
    public java.lang.Object clone() {
        try {
            return (com.jd.ad.sdk.jad_gr.jad_kx) super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public final CHILD jad_an() {
        try {
            return (CHILD) super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.RuntimeException(e);
        }
    }
}
