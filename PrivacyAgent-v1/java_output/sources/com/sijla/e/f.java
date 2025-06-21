package com.sijla.e;

/* loaded from: classes19.dex */
public final class f extends com.sijla.e.c {
    private static boolean d;
    private android.content.Context b;
    private boolean c;

    public f(android.content.Context context) {
        this(context, (byte) 0);
    }

    private f(android.content.Context context, byte b) {
        this.b = context;
        this.c = false;
        this.a = "UDFER";
    }

    private static java.util.List<java.io.File> a(android.content.Context context, java.lang.String str) {
        java.io.File[] listFiles;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!com.sijla.h.c.a(str)) {
            java.io.File file = new java.io.File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                java.util.HashMap hashMap = new java.util.HashMap();
                for (java.io.File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        java.lang.String name = file2.getName();
                        if (file2.isDirectory() || !name.contains(".csv")) {
                            com.sijla.h.a.e.a(file2);
                        } else if (!name.endsWith(".lock")) {
                            try {
                                java.lang.String substring = name.substring(0, name.indexOf(".csv"));
                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                if (hashMap.containsKey(substring)) {
                                    sb.append((java.lang.CharSequence) hashMap.get(substring));
                                }
                                java.lang.String b = b(context, com.sijla.h.c.a(com.sijla.h.c.a(file2)));
                                if (!android.text.TextUtils.isEmpty(b)) {
                                    sb.append(b);
                                    hashMap.put(substring, sb);
                                }
                            } catch (java.lang.Exception e) {
                                e.printStackTrace();
                            }
                            file2.delete();
                        }
                    }
                }
                for (java.lang.String str2 : hashMap.keySet()) {
                    java.lang.String sb2 = ((java.lang.StringBuilder) hashMap.get(str2)).toString();
                    if (!android.text.TextUtils.isEmpty(sb2)) {
                        java.io.File a = com.sijla.h.a.e.a(str + (str2 + ".csv-" + java.lang.System.currentTimeMillis()), com.sijla.h.c.e(sb2));
                        if (a != null && a.exists()) {
                            arrayList.add(a);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static void a(android.content.Context context) {
        java.io.File[] listFiles;
        java.lang.String str;
        int i = 2;
        int i2 = 0;
        java.lang.String[] strArr = {com.sijla.h.a.d.d(context), com.sijla.h.a.d.e(context)};
        int i3 = 0;
        while (i3 < i) {
            java.lang.String str2 = strArr[i3];
            try {
                a(context, str2);
                listFiles = new java.io.File(str2).listFiles();
            } catch (java.lang.Throwable th) {
                th = th;
            }
            if (listFiles != null && listFiles.length != 0) {
                java.util.HashMap hashMap = new java.util.HashMap();
                for (java.io.File file : listFiles) {
                    if (file != null && file.exists() && file.isFile()) {
                        hashMap.put(file.getName(), file);
                    }
                }
                try {
                    org.json.JSONArray optJSONArray = com.sijla.c.d.a.optJSONArray("truthurls");
                    if (optJSONArray == null || optJSONArray.length() == 0) {
                        optJSONArray = new org.json.JSONArray();
                        optJSONArray.put("https://b.qchannel03.cn/n/ard");
                    }
                    java.lang.String b = b(context);
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    boolean z = com.sijla.c.d.a.optInt("repeatReportTruth", i2) == 0;
                    boolean z2 = false;
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        java.lang.String optString = optJSONArray.optString(i4, "https://b.qchannel03.cn/n/ard");
                        new com.sijla.f.c();
                        if (i4 > 0) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append(b);
                            sb.append("&r=");
                            sb.append(z ? 1 : 0);
                            str = sb.toString();
                        } else {
                            str = b;
                        }
                        com.sijla.f.c a = com.sijla.c.a.a(optString + str, new org.json.JSONObject(), hashMap);
                        new java.lang.StringBuilder("STATUS:").append(a.b());
                        if (a.b()) {
                            if (!z2) {
                                z2 = true;
                            }
                            if (z) {
                                break;
                            }
                        } else {
                            java.lang.String[] strArr2 = new java.lang.String[3];
                            try {
                                strArr2[0] = optString;
                                java.lang.Object a2 = a.a();
                                if (a2 != null) {
                                    try {
                                        strArr2[1] = a2.toString();
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                        try {
                                            th.printStackTrace();
                                        } catch (java.lang.Throwable th3) {
                                            th = th3;
                                            th.printStackTrace();
                                            i3++;
                                            i = 2;
                                            i2 = 0;
                                        }
                                        i3++;
                                        i = 2;
                                        i2 = 0;
                                    }
                                    try {
                                        strArr2[2] = com.sijla.c.a.d();
                                        arrayList.add(strArr2);
                                    } catch (java.lang.Throwable th4) {
                                        th = th4;
                                        th.printStackTrace();
                                        i3++;
                                        i = 2;
                                        i2 = 0;
                                    }
                                }
                            } catch (java.lang.Throwable th5) {
                                th = th5;
                                th.printStackTrace();
                                i3++;
                                i = 2;
                                i2 = 0;
                            }
                        }
                    }
                    a(str2, z2);
                } catch (java.lang.Throwable th6) {
                    th = th6;
                }
                i3++;
                i = 2;
                i2 = 0;
            }
            i3++;
            i = 2;
            i2 = 0;
        }
    }

    private static void a(java.lang.String str, boolean z) {
        try {
            java.io.File[] listFiles = new java.io.File(str).listFiles();
            if (listFiles != null) {
                int i = 0;
                if (!z && listFiles.length <= 9) {
                    int length = listFiles.length;
                    while (i < length) {
                        java.io.File file = listFiles[i];
                        if (file != null && file.exists() && !file.getName().endsWith(".lock")) {
                            file.renameTo(new java.io.File(file.getAbsolutePath() + ".lock"));
                        }
                        i++;
                    }
                    return;
                }
                int length2 = listFiles.length;
                while (i < length2) {
                    java.io.File file2 = listFiles[i];
                    if (file2 != null && file2.exists()) {
                        com.sijla.h.a.e.a(file2);
                    }
                    i++;
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private static java.lang.String b(android.content.Context context) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("appkey", com.sijla.h.c.d(context));
            jSONObject.put("uid", com.sijla.h.i.b(context));
            jSONObject.put("sdk", "20230823");
            if ("".equals(com.sijla.c.d.a.optString("rootdir", ""))) {
                jSONObject.put("sm", "1");
            }
            jSONObject.put("type", "3");
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.sijla.h.c.a.a();
        return "?".concat(java.lang.String.valueOf(com.sijla.h.c.a.a(jSONObject).toString()));
    }

    private static java.lang.String b(android.content.Context context, java.lang.String str) {
        try {
            return str.contains(context.getPackageName()) ? str : com.sijla.h.c.c(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    @Override // com.sijla.e.c
    public final void a() {
        super.a();
        com.sijla.a.a.a(new com.sijla.e.g(this));
    }

    public final void b() {
        if (d) {
            return;
        }
        if (com.sijla.h.c.a(this.b, "lastPostTime", com.sijla.c.d.a.optLong("timepost", com.anythink.expressad.d.a.b.P)) && com.sijla.h.a.a.e(this.b)) {
            d = true;
            com.sijla.h.c.b(this.b);
            a(this.b);
            d = false;
        }
    }

    @Override // com.sijla.e.c, com.sijla.b.u.b
    public final void d() {
    }

    @Override // com.sijla.e.c, com.sijla.b.u.b
    public final void e() {
    }
}
