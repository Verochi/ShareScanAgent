package com.sijla.f;

/* loaded from: classes19.dex */
final class g implements java.lang.Runnable {
    private /* synthetic */ android.content.Context a;
    private /* synthetic */ com.sijla.f.f b;

    public g(com.sijla.f.f fVar, android.content.Context context) {
        this.b = fVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        org.json.JSONObject jSONObject;
        byte[] bArr;
        java.util.List<java.lang.String> list;
        java.lang.String str;
        try {
            android.content.Context applicationContext = this.a.getApplicationContext();
            android.content.SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("QT", 0);
            android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
            com.sijla.bean.b a = com.sijla.f.c.a(applicationContext);
            java.util.List<java.lang.String> a2 = com.sijla.h.c.a(applicationContext);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i = 0; i < a2.size(); i++) {
                java.lang.String str2 = a2.get(i);
                if (str2 != null) {
                    java.io.File file = new java.io.File(str2);
                    if (file.exists()) {
                        arrayList.add(file);
                    }
                }
            }
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            java.lang.String str3 = "2";
            if (arrayList.isEmpty()) {
                java.lang.String string = sharedPreferences.getString("appver", "");
                if (android.text.TextUtils.isEmpty(string)) {
                    str3 = "4";
                } else if (android.text.TextUtils.isEmpty(string) || !sharedPreferences.getString("QTIME", "").equals("")) {
                    str3 = "1";
                }
            } else {
                java.util.Iterator it = arrayList.iterator();
                org.json.JSONObject jSONObject3 = jSONObject2;
                boolean z = true;
                while (true) {
                    if (!it.hasNext()) {
                        jSONObject = jSONObject3;
                        break;
                    }
                    try {
                        bArr = com.sijla.h.c.a((java.io.File) it.next());
                    } catch (java.lang.Exception unused) {
                        bArr = null;
                    }
                    if (bArr != null) {
                        try {
                            java.lang.String a3 = com.sijla.h.c.a(bArr);
                            if (android.text.TextUtils.isEmpty(a3)) {
                                continue;
                            } else {
                                jSONObject = new org.json.JSONObject(a3);
                                try {
                                    java.util.List<java.lang.String> b = com.sijla.f.f.b();
                                    java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                                    while (keys.hasNext()) {
                                        java.lang.String next = keys.next();
                                        if (b.contains(next)) {
                                            list = b;
                                        } else {
                                            java.lang.String optString = jSONObject.optString(next);
                                            java.lang.String optString2 = a.optString(next);
                                            java.lang.String c = com.sijla.h.c.c(optString2);
                                            if (!com.sijla.h.c.a(c)) {
                                                optString2 = c;
                                            }
                                            java.lang.String c2 = com.sijla.h.c.c(optString);
                                            if (com.sijla.h.c.a(c2)) {
                                                list = b;
                                                str = optString;
                                            } else {
                                                list = b;
                                                str = c2;
                                            }
                                            z &= str.equals(optString2) || com.sijla.h.c.a(optString2);
                                        }
                                        b = list;
                                    }
                                    if (z) {
                                        break;
                                    } else {
                                        jSONObject3 = jSONObject;
                                    }
                                } catch (java.lang.Exception e) {
                                    e = e;
                                    jSONObject3 = jSONObject;
                                    e.printStackTrace();
                                }
                            }
                        } catch (java.lang.Exception e2) {
                            e = e2;
                        }
                    }
                }
                java.lang.String str4 = z ? "1" : "3";
                java.lang.String string2 = sharedPreferences.getString("appver", "");
                if (string2.equals(com.sijla.h.a.a.j(applicationContext)) || "".equals(string2)) {
                    if (jSONObject.optString("03").equals(a.optString("03")) && "".equals(string2)) {
                        str4 = "5";
                    }
                    str3 = str4;
                }
            }
            com.sijla.h.h.c();
            com.sijla.h.c.f();
            java.lang.String j = com.sijla.h.a.a.j(applicationContext);
            edit.putString("QTIME", java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000));
            edit.putString("appver", j);
            edit.apply();
            "QT_STATUS:".concat(str3);
            java.lang.String string3 = sharedPreferences.getString("__truthinfo2dd__", "");
            java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
            if (str3.equals("1") && format.equals(string3)) {
                return;
            }
            edit.putString("__truthinfo2dd__", format);
            edit.apply();
            com.sijla.f.c.a(applicationContext, str3);
        } catch (java.lang.Throwable th) {
            java.lang.System.err.println("QtruthExcetion");
            th.printStackTrace();
        }
    }
}
