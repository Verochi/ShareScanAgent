package com.getui.gs.d;

/* loaded from: classes22.dex */
public final class a {
    public long a = -1;
    public java.lang.String b;
    public long c;
    public com.getui.gs.d.a.EnumC0289a d;
    public org.json.JSONObject e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public org.json.JSONObject i;

    /* renamed from: com.getui.gs.d.a$a, reason: collision with other inner class name */
    public enum EnumC0289a {
        TYPE_NORMAL,
        TYPE_DURATION,
        TYPE_PROFILE
    }

    public final void a(java.lang.String str) {
        if (str == null) {
            str = "";
        }
        this.h = str;
    }

    public final void a(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new org.json.JSONObject();
        }
        this.e = jSONObject;
    }

    public final java.lang.String toString() {
        return "Event{id=" + this.a + ", eventId='" + this.b + "', time=" + this.c + ", type=" + this.d + ", jsonObject=" + this.e + ", sessionId='" + this.f + "', foreground='" + this.g + "', ext='" + this.h + "', inner='" + this.i.toString() + "'}";
    }
}
