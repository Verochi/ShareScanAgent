package com.igexin.push.core.e;

/* loaded from: classes31.dex */
public class d {
    private static final java.lang.String a = "MsgSPManager";
    private static final java.lang.String b = "gx_msg_sp";
    private static final java.lang.String c = "taskIdList";
    private static final java.lang.String d = "gx_vendor_token";
    private static final java.lang.String e = "tokeninfo";
    private static final java.lang.String f = "usfdl";
    private static final java.lang.Object h = new java.lang.Object();
    private static final java.lang.Object i = new java.lang.Object();
    private static volatile com.igexin.push.core.e.d j;
    private android.content.SharedPreferences g;

    private d(android.content.Context context) {
        if (context != null) {
            this.g = context.getSharedPreferences(b, 0);
        }
    }

    public static com.igexin.push.core.e.d a(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        if (j == null) {
            synchronized (com.igexin.push.core.e.d.class) {
                if (j == null) {
                    j = new com.igexin.push.core.e.d(applicationContext);
                }
            }
        }
        return j;
    }

    private void a(java.lang.String str, java.lang.Object obj) {
        android.content.SharedPreferences.Editor edit = this.g.edit();
        if (obj instanceof java.lang.String) {
            edit.putString(str, (java.lang.String) obj);
        }
        edit.apply();
    }

    private java.lang.Object b(java.lang.String str, java.lang.Object obj) {
        return obj instanceof java.lang.String ? this.g.getString(str, (java.lang.String) obj) : obj;
    }

    private static void b(org.json.JSONObject jSONObject) {
        try {
            if (jSONObject.length() < 150) {
                return;
            }
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            boolean z = false;
            long j2 = Long.MAX_VALUE;
            java.lang.String str = null;
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                long j3 = jSONObject.getLong(next);
                if (j2 > j3) {
                    str = next;
                    j2 = j3;
                }
                if (j3 < java.lang.System.currentTimeMillis() - 432000000) {
                    keys.remove();
                    z = true;
                }
            }
            if (z || str == null) {
                return;
            }
            jSONObject.remove(str);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void c(java.lang.String str) {
        try {
            a(d, str);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void c(org.json.JSONObject jSONObject) {
        try {
            if (jSONObject.length() < 20) {
                return;
            }
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            boolean z = false;
            long j2 = Long.MAX_VALUE;
            java.lang.String str = null;
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                long parseLong = java.lang.Long.parseLong(jSONObject.getJSONObject(next).getString("timestamp"));
                if (j2 > parseLong) {
                    str = next;
                    j2 = parseLong;
                }
                if (parseLong < java.lang.System.currentTimeMillis() - 432000000) {
                    keys.remove();
                    z = true;
                }
            }
            if (z || str == null) {
                return;
            }
            jSONObject.remove(str);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private org.json.JSONObject d() {
        try {
            java.lang.String str = (java.lang.String) b(c, "");
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            return new org.json.JSONObject(str);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private org.json.JSONObject e() {
        try {
            java.lang.String str = (java.lang.String) b(f, "");
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            return new org.json.JSONObject(str);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private java.lang.String f() {
        try {
            return (java.lang.String) b(d, null);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    public final org.json.JSONObject a() {
        synchronized (h) {
            try {
                java.lang.String str = (java.lang.String) b(f, "");
                if (android.text.TextUtils.isEmpty(str)) {
                    return null;
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(keys.next());
                    if (!jSONObject2.has("timestamp") || java.lang.Long.parseLong(jSONObject2.getString("timestamp")) < java.lang.System.currentTimeMillis() - 432000000) {
                        keys.remove();
                    }
                }
                return jSONObject;
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
                return null;
            }
        }
    }

    public final void a(java.lang.String str, org.json.JSONObject jSONObject) {
        if (this.g == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (h) {
            try {
                org.json.JSONObject e2 = e();
                if (e2 == null) {
                    e2 = new org.json.JSONObject();
                }
                if (e2.length() > 0) {
                    c(e2);
                }
                e2.put(str, jSONObject);
                a(f, e2.toString());
            } finally {
            }
        }
    }

    public final void a(org.json.JSONObject jSONObject) {
        try {
            a(e, jSONObject.toString());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    public final boolean a(java.lang.String str) {
        if (this.g != null && !android.text.TextUtils.isEmpty(str)) {
            try {
                org.json.JSONObject d2 = d();
                if (d2 != null && d2.has(str)) {
                    com.igexin.c.a.c.a.a("sp task " + str + " already exists", new java.lang.Object[0]);
                    return true;
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
        return false;
    }

    public final void b() {
        synchronized (h) {
            try {
                if (this.g != null) {
                    a(f, "");
                }
            } finally {
            }
        }
    }

    public final void b(java.lang.String str) {
        if (this.g == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (i) {
            try {
                org.json.JSONObject d2 = d();
                if (d2 == null) {
                    d2 = new org.json.JSONObject();
                }
                if (d2.length() > 0) {
                    b(d2);
                }
                d2.put(str, java.lang.System.currentTimeMillis());
                a(c, d2.toString());
            } finally {
            }
        }
    }

    public final org.json.JSONObject c() {
        try {
            java.lang.String valueOf = java.lang.String.valueOf(b(e, ""));
            return valueOf.isEmpty() ? new org.json.JSONObject() : new org.json.JSONObject(valueOf);
        } catch (org.json.JSONException e2) {
            com.igexin.c.a.c.a.a(e2);
            return new org.json.JSONObject();
        }
    }
}
