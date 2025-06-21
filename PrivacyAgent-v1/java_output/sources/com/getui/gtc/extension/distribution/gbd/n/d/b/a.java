package com.getui.gtc.extension.distribution.gbd.n.d.b;

/* loaded from: classes22.dex */
public final class a implements java.lang.Cloneable, java.util.Map.Entry<java.lang.String, java.lang.String> {
    public java.lang.String a;
    public java.lang.String b;

    public a(java.lang.String str, java.lang.String str2) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str2);
        this.a = str.trim().toLowerCase();
        this.b = str2;
    }

    private static com.getui.gtc.extension.distribution.gbd.n.d.b.a a(java.lang.String str, java.lang.String str2) {
        return new com.getui.gtc.extension.distribution.gbd.n.d.b.a(str, com.getui.gtc.extension.distribution.gbd.n.d.b.h.a(str2, true));
    }

    private void a(java.lang.StringBuilder sb, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar) {
        sb.append(this.a);
        sb.append("=\"");
        sb.append(com.getui.gtc.extension.distribution.gbd.n.d.b.h.a(this.b, aVar));
        sb.append("\"");
    }

    private java.lang.String b() {
        return this.a;
    }

    private void b(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        this.a = str.trim().toLowerCase();
    }

    private java.lang.String c() {
        return this.b;
    }

    private java.lang.String d() {
        return this.a + "=\"" + com.getui.gtc.extension.distribution.gbd.n.d.b.h.a(this.b, new com.getui.gtc.extension.distribution.gbd.n.d.b.e("").a) + "\"";
    }

    private boolean e() {
        return this.a.startsWith("data-") && this.a.length() > 5;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final com.getui.gtc.extension.distribution.gbd.n.d.b.a clone() {
        try {
            return (com.getui.gtc.extension.distribution.gbd.n.d.b.a) super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    @Override // java.util.Map.Entry
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final java.lang.String setValue(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        java.lang.String str2 = this.b;
        this.b = str;
        return str2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.a)) {
            return false;
        }
        com.getui.gtc.extension.distribution.gbd.n.d.b.a aVar = (com.getui.gtc.extension.distribution.gbd.n.d.b.a) obj;
        java.lang.String str = this.a;
        if (str == null ? aVar.a != null : !str.equals(aVar.a)) {
            return false;
        }
        java.lang.String str2 = this.b;
        java.lang.String str3 = aVar.b;
        return str2 == null ? str3 == null : str2.equals(str3);
    }

    @Override // java.util.Map.Entry
    public final /* bridge */ /* synthetic */ java.lang.String getKey() {
        return this.a;
    }

    @Override // java.util.Map.Entry
    public final /* bridge */ /* synthetic */ java.lang.String getValue() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        java.lang.String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        java.lang.String str2 = this.b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final java.lang.String toString() {
        return this.a + "=\"" + com.getui.gtc.extension.distribution.gbd.n.d.b.h.a(this.b, new com.getui.gtc.extension.distribution.gbd.n.d.b.e("").a) + "\"";
    }
}
