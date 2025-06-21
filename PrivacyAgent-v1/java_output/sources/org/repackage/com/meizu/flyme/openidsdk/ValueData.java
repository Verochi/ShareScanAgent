package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: classes26.dex */
class ValueData {
    public java.lang.String a;
    public int b;
    public long c = java.lang.System.currentTimeMillis() + 86400000;

    public ValueData(java.lang.String str, int i) {
        this.a = str;
        this.b = i;
    }

    public java.lang.String toString() {
        return "ValueData{value='" + this.a + "', code=" + this.b + ", expired=" + this.c + '}';
    }
}
