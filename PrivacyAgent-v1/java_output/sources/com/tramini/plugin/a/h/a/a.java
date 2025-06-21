package com.tramini.plugin.a.h.a;

/* loaded from: classes19.dex */
public final class a implements java.lang.CharSequence {
    java.lang.CharSequence a;

    public a(java.lang.CharSequence charSequence) {
        this.a = charSequence;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        if (java.lang.Thread.currentThread().isInterrupted()) {
            throw new java.lang.RuntimeException("Interrupted!");
        }
        return this.a.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.a.length();
    }

    @Override // java.lang.CharSequence
    public final java.lang.CharSequence subSequence(int i, int i2) {
        return new com.tramini.plugin.a.h.a.a(this.a.subSequence(i, i2));
    }

    @Override // java.lang.CharSequence
    public final java.lang.String toString() {
        return this.a.toString();
    }
}
