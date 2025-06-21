package com.getui.gs.d;

/* loaded from: classes22.dex */
public final class b {
    public final java.util.Map<java.lang.String, com.getui.gs.d.a> a;
    private final java.util.List<com.getui.gs.f.c> b;

    public static class a {
        private static final com.getui.gs.d.b a = new com.getui.gs.d.b((byte) 0);
    }

    private b() {
        this.a = new java.util.HashMap();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.b = arrayList;
        arrayList.add(new com.getui.gs.f.b(com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE));
        arrayList.add(new com.getui.gs.f.b(com.getui.gs.d.a.EnumC0289a.TYPE_NORMAL));
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static com.getui.gs.d.a a(java.lang.String str, com.getui.gs.d.a.EnumC0289a enumC0289a, org.json.JSONObject jSONObject, java.lang.String str2) throws java.security.NoSuchAlgorithmException {
        com.getui.gs.d.a aVar = new com.getui.gs.d.a();
        aVar.b = str;
        aVar.c = java.lang.System.currentTimeMillis();
        aVar.d = enumC0289a;
        aVar.f = com.getui.gs.h.e.a();
        aVar.a(str2);
        aVar.a(jSONObject);
        aVar.g = com.getui.gs.h.d.a();
        return aVar;
    }

    public static void a(com.getui.gs.d.a aVar) throws org.json.JSONException {
        org.json.JSONObject jSONObject = aVar.e;
        java.util.Iterator<java.lang.String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            java.lang.String next = keys.next();
            if (android.text.TextUtils.isEmpty(next)) {
                throw new java.lang.IllegalArgumentException("the property key can't be empty");
            }
            if (aVar.d != com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE && next.startsWith("$")) {
                throw new java.lang.IllegalArgumentException("the property key can't start with $");
            }
            int length = next.length();
            if (length <= 0 || length > 128) {
                throw new java.lang.IllegalArgumentException("The length of key must be > 0 && <= 128: ".concat(next));
            }
            java.lang.Object obj = jSONObject.get(next);
            if (!(obj instanceof java.lang.String) && !(obj instanceof java.lang.Number) && !(obj instanceof java.lang.Boolean) && !(obj instanceof java.util.Date)) {
                throw new java.lang.IllegalArgumentException("the property value must be instance of String/Number/Boolean/Date");
            }
            if (obj instanceof java.util.Date) {
                jSONObject.put(next, new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format((java.util.Date) obj));
            }
        }
        aVar.i = new org.json.JSONObject();
        b(aVar);
    }

    public static void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("eventId is invalid: ".concat(java.lang.String.valueOf(str)));
        }
        int length = str.length();
        if (length <= 0 || length > 128) {
            throw new java.lang.IllegalArgumentException("The length of eventId must be > 0 && <= 128: ".concat(str));
        }
    }

    public static boolean a(java.lang.String str, java.lang.String... strArr) {
        if (strArr != null) {
            for (java.lang.String str2 : strArr) {
                if (str2.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void b(com.getui.gs.d.a aVar) throws org.json.JSONException {
        com.getui.gs.b.e eVar;
        org.json.JSONObject jSONObject = aVar.e;
        com.getui.gs.d.a.EnumC0289a enumC0289a = aVar.d;
        jSONObject.put("$app_version", com.getui.gs.a.d.f());
        jSONObject.put("$channelId", com.getui.gs.a.d.h());
        jSONObject.put("$lib_version", com.getui.gs.a.d.i());
        jSONObject.put("$manufacturer", com.getui.gs.h.a.a.d());
        jSONObject.put("$model", android.text.TextUtils.isEmpty(com.getui.gs.h.a.a.a()) ? "" : com.getui.gs.h.a.a.a().trim());
        jSONObject.put("$os", "Android");
        jSONObject.put("$os_version", com.getui.gs.h.a.a.b());
        jSONObject.put("$package_name", com.getui.gs.a.d.g());
        if (enumC0289a == com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE) {
            android.util.DisplayMetrics displayMetrics = com.getui.gs.a.d.a().getResources().getDisplayMetrics();
            jSONObject.put("$screen_height", displayMetrics.heightPixels);
            jSONObject.put("$screen_width", displayMetrics.widthPixels);
            eVar = com.getui.gs.b.e.a.a;
            jSONObject.put("$firstvisittime", com.getui.gs.h.d.a("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(eVar.a.a())));
            return;
        }
        if (enumC0289a == com.getui.gs.d.a.EnumC0289a.TYPE_NORMAL || enumC0289a == com.getui.gs.d.a.EnumC0289a.TYPE_DURATION) {
            java.lang.String f = com.getui.gs.h.a.a.f();
            jSONObject.put("$wifi", !android.text.TextUtils.isEmpty(f) && "WIFI".equals(f));
            jSONObject.put("$network_type", f);
            jSONObject.put("$carrier", com.getui.gs.h.a.a.e());
        }
    }

    public final void a() {
        java.util.Iterator<com.getui.gs.f.c> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public final void a(com.getui.gs.d.a aVar, boolean z) {
        java.lang.String str;
        com.getui.gs.b.e eVar;
        if (aVar.d != com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE || com.getui.gs.c.a.a("sdk.ido.type14.enable", true)) {
            com.getui.gs.d.a.EnumC0289a enumC0289a = aVar.d;
            if ((enumC0289a != com.getui.gs.d.a.EnumC0289a.TYPE_NORMAL && enumC0289a != com.getui.gs.d.a.EnumC0289a.TYPE_DURATION) || com.getui.gs.c.a.a("sdk.ido.type13.enable", true)) {
                eVar = com.getui.gs.b.e.a.a;
                eVar.b.a(aVar);
                if (z) {
                    a();
                    return;
                }
                return;
            }
            str = "t13 closed";
        } else {
            str = "t14 closed";
        }
        com.getui.gs.h.a.b(str);
    }

    public final void a(java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2) throws org.json.JSONException, java.security.NoSuchAlgorithmException {
        a(str);
        com.getui.gs.d.a a2 = a(str, com.getui.gs.d.a.EnumC0289a.TYPE_NORMAL, jSONObject, str2);
        a(a2);
        com.getui.gs.h.a.a("onEvent: ".concat(java.lang.String.valueOf(a2)));
        a(a2, true);
    }

    public final void a(org.json.JSONObject jSONObject, java.lang.String str, boolean z) throws org.json.JSONException, java.security.NoSuchAlgorithmException {
        com.getui.gs.d.a a2 = a("", com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE, jSONObject, str);
        a(a2);
        com.getui.gs.h.a.a("onProfile: ".concat(java.lang.String.valueOf(jSONObject)));
        a(a2, z);
    }
}
