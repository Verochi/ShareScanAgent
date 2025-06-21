package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class fm extends com.xiaomi.push.fn {
    public java.lang.String a;
    java.lang.String b;
    java.lang.String c;
    java.lang.String d;
    java.lang.String e;
    java.lang.String f;
    boolean g;
    java.lang.String h;
    java.lang.String i;
    java.lang.String j;
    java.lang.String k;
    java.lang.String l;
    boolean m;

    public fm() {
        this.a = null;
        this.b = null;
        this.g = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = false;
    }

    public fm(android.os.Bundle bundle) {
        super(bundle);
        this.a = null;
        this.b = null;
        this.g = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = false;
        this.a = bundle.getString("ext_msg_type");
        this.c = bundle.getString("ext_msg_lang");
        this.b = bundle.getString("ext_msg_thread");
        this.d = bundle.getString("ext_msg_sub");
        this.e = bundle.getString("ext_msg_body");
        this.f = bundle.getString("ext_body_encode");
        this.h = bundle.getString("ext_msg_appid");
        this.g = bundle.getBoolean("ext_msg_trans", false);
        this.m = bundle.getBoolean("ext_msg_encrypt", false);
        this.i = bundle.getString("ext_msg_seq");
        this.j = bundle.getString("ext_msg_mseq");
        this.k = bundle.getString("ext_msg_fseq");
        this.l = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.fn
    public final android.os.Bundle a() {
        android.os.Bundle a = super.a();
        if (!android.text.TextUtils.isEmpty(this.a)) {
            a.putString("ext_msg_type", this.a);
        }
        java.lang.String str = this.c;
        if (str != null) {
            a.putString("ext_msg_lang", str);
        }
        java.lang.String str2 = this.d;
        if (str2 != null) {
            a.putString("ext_msg_sub", str2);
        }
        java.lang.String str3 = this.e;
        if (str3 != null) {
            a.putString("ext_msg_body", str3);
        }
        if (!android.text.TextUtils.isEmpty(this.f)) {
            a.putString("ext_body_encode", this.f);
        }
        java.lang.String str4 = this.b;
        if (str4 != null) {
            a.putString("ext_msg_thread", str4);
        }
        java.lang.String str5 = this.h;
        if (str5 != null) {
            a.putString("ext_msg_appid", str5);
        }
        if (this.g) {
            a.putBoolean("ext_msg_trans", true);
        }
        if (!android.text.TextUtils.isEmpty(this.i)) {
            a.putString("ext_msg_seq", this.i);
        }
        if (!android.text.TextUtils.isEmpty(this.j)) {
            a.putString("ext_msg_mseq", this.j);
        }
        if (!android.text.TextUtils.isEmpty(this.k)) {
            a.putString("ext_msg_fseq", this.k);
        }
        if (this.m) {
            a.putBoolean("ext_msg_encrypt", true);
        }
        if (!android.text.TextUtils.isEmpty(this.l)) {
            a.putString("ext_msg_status", this.l);
        }
        return a;
    }

    @Override // com.xiaomi.push.fn
    public final java.lang.String b() {
        com.xiaomi.push.fr frVar;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("<message");
        if (this.p != null) {
            sb.append(" xmlns=\"");
            sb.append(this.p);
            sb.append("\"");
        }
        if (this.c != null) {
            sb.append(" xml:lang=\"");
            sb.append(this.c);
            sb.append("\"");
        }
        if (d() != null) {
            sb.append(" id=\"");
            sb.append(d());
            sb.append("\"");
        }
        if (this.r != null) {
            sb.append(" to=\"");
            sb.append(com.xiaomi.push.fy.a(this.r));
            sb.append("\"");
        }
        if (!android.text.TextUtils.isEmpty(this.i)) {
            sb.append(" seq=\"");
            sb.append(this.i);
            sb.append("\"");
        }
        if (!android.text.TextUtils.isEmpty(this.j)) {
            sb.append(" mseq=\"");
            sb.append(this.j);
            sb.append("\"");
        }
        if (!android.text.TextUtils.isEmpty(this.k)) {
            sb.append(" fseq=\"");
            sb.append(this.k);
            sb.append("\"");
        }
        if (!android.text.TextUtils.isEmpty(this.l)) {
            sb.append(" status=\"");
            sb.append(this.l);
            sb.append("\"");
        }
        if (this.f466s != null) {
            sb.append(" from=\"");
            sb.append(com.xiaomi.push.fy.a(this.f466s));
            sb.append("\"");
        }
        if (this.t != null) {
            sb.append(" chid=\"");
            sb.append(com.xiaomi.push.fy.a(this.t));
            sb.append("\"");
        }
        if (this.g) {
            sb.append(" transient=\"true\"");
        }
        if (!android.text.TextUtils.isEmpty(this.h)) {
            sb.append(" appid=\"");
            sb.append(this.h);
            sb.append("\"");
        }
        if (!android.text.TextUtils.isEmpty(this.a)) {
            sb.append(" type=\"");
            sb.append(this.a);
            sb.append("\"");
        }
        if (this.m) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.d != null) {
            sb.append("<subject>");
            sb.append(com.xiaomi.push.fy.a(this.d));
            sb.append("</subject>");
        }
        if (this.e != null) {
            sb.append("<body");
            if (!android.text.TextUtils.isEmpty(this.f)) {
                sb.append(" encode=\"");
                sb.append(this.f);
                sb.append("\"");
            }
            sb.append(">");
            sb.append(com.xiaomi.push.fy.a(this.e));
            sb.append("</body>");
        }
        if (this.b != null) {
            sb.append("<thread>");
            sb.append(this.b);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.a) && (frVar = this.v) != null) {
            sb.append(frVar.b());
        }
        sb.append(e());
        sb.append("</message>");
        return sb.toString();
    }

    @Override // com.xiaomi.push.fn
    public final boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.xiaomi.push.fm.class == obj.getClass()) {
            com.xiaomi.push.fm fmVar = (com.xiaomi.push.fm) obj;
            if (!super.equals(fmVar)) {
                return false;
            }
            java.lang.String str = this.e;
            if (str == null ? fmVar.e != null : !str.equals(fmVar.e)) {
                return false;
            }
            java.lang.String str2 = this.c;
            if (str2 == null ? fmVar.c != null : !str2.equals(fmVar.c)) {
                return false;
            }
            java.lang.String str3 = this.d;
            if (str3 == null ? fmVar.d != null : !str3.equals(fmVar.d)) {
                return false;
            }
            java.lang.String str4 = this.b;
            if (str4 == null ? fmVar.b != null : !str4.equals(fmVar.b)) {
                return false;
            }
            if (this.a == fmVar.a) {
                return true;
            }
        }
        return false;
    }

    @Override // com.xiaomi.push.fn
    public final int hashCode() {
        java.lang.String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        java.lang.String str2 = this.e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.b;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        java.lang.String str4 = this.c;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        java.lang.String str5 = this.d;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
