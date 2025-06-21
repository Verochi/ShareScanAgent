package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class k {
    public int B;
    public java.lang.String D;
    public int b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String l;
    public java.lang.String m;
    public java.lang.String n;
    public java.lang.String o;
    public java.lang.String p;
    public java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    public java.lang.String f379s;
    public java.lang.String z;
    public java.lang.String a = "";
    public java.lang.String e = "";
    public java.lang.String f = "";
    public java.lang.String g = "";
    public java.lang.String h = "";
    public java.lang.String i = "";
    public java.lang.String j = "";
    public java.lang.String k = "";
    public java.lang.String q = "";
    public int t = com.huawei.hms.push.n.STYLE_DEFAULT.ordinal();
    public java.lang.String u = "";
    public java.lang.String v = "";
    public java.lang.String w = "";
    public int x = 0;
    public int y = 0;
    public java.lang.String A = "";
    public java.lang.String C = "";
    public java.lang.String E = "";
    public java.lang.String F = "";

    public k(byte[] bArr, byte[] bArr2) {
        java.nio.charset.Charset charset = com.huawei.hms.push.x.a;
        this.r = new java.lang.String(bArr, charset);
        this.f379s = new java.lang.String(bArr2, charset);
    }

    public java.lang.String a() {
        return this.m;
    }

    public final org.json.JSONObject a(org.json.JSONObject jSONObject) throws org.json.JSONException {
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        jSONObject2.put(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
        jSONObject2.put("group", this.a);
        jSONObject2.put("tag", this.A);
        jSONObject2.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.AUTO_CANCEL, this.x);
        jSONObject2.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.VISIBILITY, this.y);
        jSONObject2.put("when", this.z);
        return jSONObject2;
    }

    public final org.json.JSONObject a(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) throws org.json.JSONException {
        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
        jSONObject3.put("dispPkgName", this.f);
        jSONObject3.put(com.huawei.hms.push.constant.RemoteMessageConst.MSGID, this.e);
        jSONObject3.put("ap", this.d);
        jSONObject3.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_ID, this.B);
        jSONObject3.put(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PS_CONTENT, jSONObject);
        jSONObject3.put(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.NOTIFY_DETAIL, jSONObject2);
        jSONObject3.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.TICKER, this.D);
        jSONObject3.put("data", this.C);
        return jSONObject3;
    }

    public void a(int i) {
        this.B = i;
    }

    public java.lang.String b() {
        return this.F;
    }

    public final org.json.JSONObject b(org.json.JSONObject jSONObject) throws org.json.JSONException {
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        jSONObject2.put("cmd", this.g);
        jSONObject2.put("content", this.h);
        jSONObject2.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_ICON, this.i);
        jSONObject2.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_TITLE, this.j);
        jSONObject2.put("notifySummary", this.k);
        jSONObject2.put(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PARAM, jSONObject);
        return jSONObject2;
    }

    public java.lang.String c() {
        return this.d;
    }

    public final void c(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject.has("ap")) {
            java.lang.String string = jSONObject.getString("ap");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (android.text.TextUtils.isEmpty(string) || string.length() >= 48) {
                this.d = string.substring(0, 48);
                return;
            }
            int length = 48 - string.length();
            for (int i = 0; i < length; i++) {
                sb.append("0");
            }
            sb.append(string);
            this.d = sb.toString();
        }
    }

    public java.lang.String d() {
        return this.l;
    }

    public final boolean d(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("acn")) {
            this.m = jSONObject.getString("acn");
        }
        if (jSONObject.has(com.huawei.hms.push.constant.RemoteMessageConst.Notification.INTENT_URI)) {
            this.c = jSONObject.getString(com.huawei.hms.push.constant.RemoteMessageConst.Notification.INTENT_URI);
        }
        if (jSONObject.has("appPackageName")) {
            this.l = jSONObject.getString("appPackageName");
            return true;
        }
        com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "appPackageName is null");
        return false;
    }

    public int e() {
        return this.x;
    }

    public final boolean e(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (!jSONObject.has(com.huawei.hms.push.constant.RemoteMessageConst.MSGID)) {
            com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", "msgId == null");
            return false;
        }
        java.lang.Object obj = jSONObject.get(com.huawei.hms.push.constant.RemoteMessageConst.MSGID);
        if (obj instanceof java.lang.String) {
            this.e = (java.lang.String) obj;
            return true;
        }
        if (!(obj instanceof java.lang.Integer)) {
            return true;
        }
        this.e = java.lang.String.valueOf(((java.lang.Integer) obj).intValue());
        return true;
    }

    public int f() {
        return this.b;
    }

    public final boolean f(org.json.JSONObject jSONObject) {
        com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "enter parseNotifyParam");
        try {
            org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
            if (jSONObject2.has(com.anythink.expressad.foundation.h.i.e)) {
                this.t = jSONObject2.getInt(com.anythink.expressad.foundation.h.i.e);
            }
            this.u = jSONObject2.optString("bigTitle");
            this.v = jSONObject2.optString("bigContent");
            this.E = jSONObject2.optString("icon");
            return true;
        } catch (org.json.JSONException e) {
            com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", e.toString());
            return false;
        }
    }

    public java.lang.String g() {
        return this.v;
    }

    public final void g(org.json.JSONObject jSONObject) {
        this.a = jSONObject.optString("group");
        com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "NOTIFY_GROUP:" + this.a);
        this.x = jSONObject.optInt(com.huawei.hms.push.constant.RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "autoCancel: " + this.x);
        this.y = jSONObject.optInt(com.huawei.hms.push.constant.RemoteMessageConst.Notification.VISIBILITY, 0);
        this.z = jSONObject.optString("when");
        this.A = jSONObject.optString("tag");
    }

    public java.lang.String h() {
        return this.u;
    }

    public final boolean h(org.json.JSONObject jSONObject) {
        try {
            org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PARAM);
            if (jSONObject2.has("autoClear")) {
                this.b = jSONObject2.getInt("autoClear");
            } else {
                this.b = 0;
            }
            if ("app".equals(this.g) || "cosa".equals(this.g)) {
                d(jSONObject2);
                return true;
            }
            if ("url".equals(this.g)) {
                k(jSONObject2);
                return true;
            }
            if (!"rp".equals(this.g)) {
                return true;
            }
            j(jSONObject2);
            return true;
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e("PushSelfShowLog", "ParseParam error ", e);
            return false;
        }
    }

    public java.lang.String i() {
        return this.g;
    }

    public final boolean i(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject.has(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PS_CONTENT)) {
            org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PS_CONTENT);
            this.g = jSONObject2.getString("cmd");
            this.h = jSONObject2.optString("content");
            this.i = jSONObject2.optString(com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_ICON);
            this.j = jSONObject2.optString(com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.k = jSONObject2.optString("notifySummary");
            this.D = jSONObject2.optString(com.huawei.hms.push.constant.RemoteMessageConst.Notification.TICKER);
            if ((!jSONObject2.has(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.NOTIFY_DETAIL) || f(jSONObject2)) && jSONObject2.has(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PARAM)) {
                return h(jSONObject2);
            }
        }
        return false;
    }

    public java.lang.String j() {
        return this.h;
    }

    public final boolean j(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("appPackageName")) {
            this.l = jSONObject.getString("appPackageName");
        }
        if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
            com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "rpl or rpt is null");
            return false;
        }
        this.o = jSONObject.getString("rpl");
        this.p = jSONObject.getString("rpt");
        if (!jSONObject.has("rpct")) {
            return true;
        }
        this.q = jSONObject.getString("rpct");
        return true;
    }

    public java.lang.String k() {
        return this.f;
    }

    public final boolean k(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (!jSONObject.has("url")) {
            com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "url is null");
            return false;
        }
        this.n = jSONObject.getString("url");
        if (jSONObject.has("appPackageName")) {
            this.l = jSONObject.getString("appPackageName");
        }
        if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
            return true;
        }
        this.o = jSONObject.getString("rpl");
        this.p = jSONObject.getString("rpt");
        if (!jSONObject.has("rpct")) {
            return true;
        }
        this.q = jSONObject.getString("rpct");
        return true;
    }

    public java.lang.String l() {
        return this.a;
    }

    public java.lang.String m() {
        return this.E;
    }

    public java.lang.String n() {
        return this.c;
    }

    public byte[] o() {
        try {
            return a(a(b(v()), r())).toString().getBytes(com.huawei.hms.push.x.a);
        } catch (org.json.JSONException e) {
            com.huawei.hms.support.log.HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException:", e);
            return new byte[0];
        }
    }

    public java.lang.String p() {
        com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "msgId =" + this.e);
        return this.e;
    }

    public java.lang.String q() {
        return this.A;
    }

    public final org.json.JSONObject r() throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put(com.anythink.expressad.foundation.h.i.e, this.t);
        jSONObject.put("bigTitle", this.u);
        jSONObject.put("bigContent", this.v);
        jSONObject.put("bigPic", this.w);
        return jSONObject;
    }

    public int s() {
        return this.B;
    }

    public java.lang.String t() {
        return this.k;
    }

    public java.lang.String u() {
        return this.j;
    }

    public final org.json.JSONObject v() throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("autoClear", this.b);
        jSONObject.put("url", this.n);
        jSONObject.put("rpl", this.o);
        jSONObject.put("rpt", this.p);
        jSONObject.put("rpct", this.q);
        jSONObject.put("appPackageName", this.l);
        jSONObject.put("acn", this.m);
        jSONObject.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.INTENT_URI, this.c);
        return jSONObject;
    }

    public int w() {
        return this.t;
    }

    public java.lang.String x() {
        return this.D;
    }

    public byte[] y() {
        return this.f379s.getBytes(com.huawei.hms.push.x.a);
    }

    public boolean z() {
        try {
            if (android.text.TextUtils.isEmpty(this.r)) {
                com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "msg is null");
                return false;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(this.r);
            g(jSONObject);
            org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.MSG_CONTENT);
            if (!e(jSONObject2)) {
                return false;
            }
            this.f = jSONObject2.optString("dispPkgName");
            c(jSONObject2);
            this.B = jSONObject2.optInt(com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_ID, -1);
            this.C = jSONObject2.optString("data");
            this.F = jSONObject2.optString(com.huawei.hms.push.constant.RemoteMessageConst.ANALYTIC_INFO);
            return i(jSONObject2);
        } catch (org.json.JSONException unused) {
            com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "parse message exception.");
            return false;
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", e.toString());
            return false;
        }
    }
}
