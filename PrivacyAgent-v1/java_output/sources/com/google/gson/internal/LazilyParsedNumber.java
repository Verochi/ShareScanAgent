package com.google.gson.internal;

/* loaded from: classes22.dex */
public final class LazilyParsedNumber extends java.lang.Number {
    private final java.lang.String value;

    public LazilyParsedNumber(java.lang.String str) {
        this.value = str;
    }

    private java.lang.Object writeReplace() throws java.io.ObjectStreamException {
        return new java.math.BigDecimal(this.value);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return java.lang.Double.parseDouble(this.value);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.gson.internal.LazilyParsedNumber)) {
            return false;
        }
        java.lang.String str = this.value;
        java.lang.String str2 = ((com.google.gson.internal.LazilyParsedNumber) obj).value;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return java.lang.Float.parseFloat(this.value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return java.lang.Integer.parseInt(this.value);
            } catch (java.lang.NumberFormatException unused) {
                return (int) java.lang.Long.parseLong(this.value);
            }
        } catch (java.lang.NumberFormatException unused2) {
            return new java.math.BigDecimal(this.value).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return java.lang.Long.parseLong(this.value);
        } catch (java.lang.NumberFormatException unused) {
            return new java.math.BigDecimal(this.value).longValue();
        }
    }

    public java.lang.String toString() {
        return this.value;
    }
}
