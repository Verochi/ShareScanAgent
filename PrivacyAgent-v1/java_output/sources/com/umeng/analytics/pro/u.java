package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class u {
    private static final java.lang.String a = "fs_lc_tl_uapp";
    private static final java.lang.String f = "-1";
    private static android.content.Context g;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private org.json.JSONObject h;

    public static class a {
        private static final com.umeng.analytics.pro.u a = new com.umeng.analytics.pro.u(null);

        private a() {
        }
    }

    private u() {
        this.b = 128;
        this.c = 256;
        this.d = 1024;
        this.e = 10;
        this.h = null;
        try {
            b(g);
        } catch (java.lang.Throwable unused) {
        }
    }

    public /* synthetic */ u(com.umeng.analytics.pro.u.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.umeng.analytics.pro.u a(android.content.Context context) {
        if (g == null && context != null) {
            g = context.getApplicationContext();
        }
        return com.umeng.analytics.pro.u.a.a;
    }

    private org.json.JSONObject a(java.util.Map<java.lang.String, java.lang.Object> map) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : map.entrySet()) {
                try {
                    java.lang.String key = entry.getKey();
                    if (key != null) {
                        java.lang.String subStr = com.umeng.commonsdk.statistics.common.HelperUtils.subStr(key, 128);
                        java.lang.Object value = entry.getValue();
                        if (value != null) {
                            int i = 0;
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    int[] iArr = (int[]) value;
                                    org.json.JSONArray jSONArray = new org.json.JSONArray();
                                    while (i < iArr.length) {
                                        jSONArray.put(iArr[i]);
                                        i++;
                                    }
                                    jSONObject.put(subStr, jSONArray);
                                } else if (value instanceof double[]) {
                                    double[] dArr = (double[]) value;
                                    org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                                    while (i < dArr.length) {
                                        jSONArray2.put(dArr[i]);
                                        i++;
                                    }
                                    jSONObject.put(subStr, jSONArray2);
                                } else if (value instanceof long[]) {
                                    long[] jArr = (long[]) value;
                                    org.json.JSONArray jSONArray3 = new org.json.JSONArray();
                                    while (i < jArr.length) {
                                        jSONArray3.put(jArr[i]);
                                        i++;
                                    }
                                    jSONObject.put(subStr, jSONArray3);
                                } else if (value instanceof float[]) {
                                    float[] fArr = (float[]) value;
                                    org.json.JSONArray jSONArray4 = new org.json.JSONArray();
                                    while (i < fArr.length) {
                                        jSONArray4.put(fArr[i]);
                                        i++;
                                    }
                                    jSONObject.put(subStr, jSONArray4);
                                } else if (value instanceof short[]) {
                                    short[] sArr = (short[]) value;
                                    org.json.JSONArray jSONArray5 = new org.json.JSONArray();
                                    while (i < sArr.length) {
                                        jSONArray5.put((int) sArr[i]);
                                        i++;
                                    }
                                    jSONObject.put(subStr, jSONArray5);
                                }
                            } else if (value instanceof java.util.List) {
                                java.util.List list = (java.util.List) value;
                                org.json.JSONArray jSONArray6 = new org.json.JSONArray();
                                while (i < list.size()) {
                                    java.lang.Object obj = list.get(i);
                                    if ((obj instanceof java.lang.String) || (obj instanceof java.lang.Long) || (obj instanceof java.lang.Integer) || (obj instanceof java.lang.Float) || (obj instanceof java.lang.Double) || (obj instanceof java.lang.Short)) {
                                        jSONArray6.put(list.get(i));
                                    }
                                    i++;
                                }
                                if (jSONArray6.length() > 0) {
                                    jSONObject.put(subStr, jSONArray6);
                                }
                            } else if (value instanceof java.lang.String) {
                                jSONObject.put(subStr, com.umeng.commonsdk.statistics.common.HelperUtils.subStr(value.toString(), 256));
                            } else {
                                if (!(value instanceof java.lang.Long) && !(value instanceof java.lang.Integer) && !(value instanceof java.lang.Float) && !(value instanceof java.lang.Double) && !(value instanceof java.lang.Short)) {
                                    com.umeng.commonsdk.statistics.common.MLog.e("The param has not support type. please check !");
                                }
                                jSONObject.put(subStr, value);
                            }
                        }
                    }
                } catch (java.lang.Exception e) {
                    com.umeng.commonsdk.statistics.common.MLog.e(e);
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return jSONObject;
    }

    private void a() {
        try {
            java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(g, "track_list", "");
            if (android.text.TextUtils.isEmpty(imprintProperty)) {
                return;
            }
            java.lang.String[] split = imprintProperty.split("!");
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            int i = 0;
            if (this.h != null) {
                for (java.lang.String str : split) {
                    java.lang.String subStr = com.umeng.commonsdk.statistics.common.HelperUtils.subStr(str, 128);
                    if (this.h.has(subStr)) {
                        jSONObject.put(subStr, this.h.get(subStr));
                    }
                }
            }
            this.h = new org.json.JSONObject();
            if (split.length >= 10) {
                while (i < 10) {
                    a(split[i], jSONObject);
                    i++;
                }
            } else {
                while (i < split.length) {
                    a(split[i], jSONObject);
                    i++;
                }
            }
            c(g);
        } catch (java.lang.Exception unused) {
        }
    }

    private void a(java.lang.String str, org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.lang.String subStr = com.umeng.commonsdk.statistics.common.HelperUtils.subStr(str, 128);
        if (jSONObject.has(subStr)) {
            a(subStr, ((java.lang.Boolean) jSONObject.get(subStr)).booleanValue());
        } else {
            a(subStr, false);
        }
    }

    private void a(java.lang.String str, boolean z) {
        try {
            if (com.umeng.analytics.pro.f.ae.equals(str) || com.umeng.analytics.pro.f.ac.equals(str) || "id".equals(str) || "ts".equals(str) || this.h.has(str)) {
                return;
            }
            this.h.put(str, z);
        } catch (java.lang.Exception unused) {
        }
    }

    private boolean a(java.lang.String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length <= 128) {
                    return true;
                }
            } catch (java.lang.Exception unused) {
            }
        }
        com.umeng.commonsdk.statistics.common.MLog.e("key is " + str + ", please check key, illegal");
        return false;
    }

    private void b(android.content.Context context) {
        try {
            java.lang.String string = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context).getString(a, null);
            if (!android.text.TextUtils.isEmpty(string)) {
                this.h = new org.json.JSONObject(string);
            }
            a();
        } catch (java.lang.Exception unused) {
        }
    }

    private boolean b(java.lang.String str) {
        if (str == null) {
            return true;
        }
        try {
            if (str.trim().getBytes().length <= 256) {
                return true;
            }
        } catch (java.lang.Exception unused) {
        }
        com.umeng.commonsdk.statistics.common.MLog.e("value is " + str + ", please check value, illegal");
        return false;
    }

    private boolean b(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : map.entrySet()) {
                        if (!a(entry.getKey())) {
                            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.h, 0, "\\|");
                            return false;
                        }
                        if (entry.getValue() == null) {
                            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.i, 0, "\\|");
                            return false;
                        }
                        if (entry.getValue() instanceof java.lang.String) {
                            if (com.umeng.analytics.pro.f.aK.equals(entry.getKey())) {
                                if (!c(entry.getValue().toString())) {
                                    com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.P, 0, "\\|");
                                    return false;
                                }
                            } else if ("_$!url".equals(entry.getKey())) {
                                if (!c(entry.getValue().toString())) {
                                    com.umeng.commonsdk.debug.UMLog.aq("url参数长度超过限制。|参数url长度不能超过1024字符。", 0, "\\|");
                                    return false;
                                }
                            } else if (!b(entry.getValue().toString())) {
                                com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.j, 0, "\\|");
                                return false;
                            }
                        }
                    }
                    return true;
                }
            } catch (java.lang.Exception unused) {
                return true;
            }
        }
        com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.g, 0, "\\|");
        return false;
    }

    private void c(android.content.Context context) {
        try {
            if (this.h != null) {
                com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(g).edit().putString(a, this.h.toString()).commit();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private boolean c(java.lang.String str) {
        if (str == null) {
            return true;
        }
        try {
            return str.trim().getBytes().length <= 1024;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public void a(java.lang.String str, java.lang.String str2, long j, int i, java.lang.String str3) {
        try {
            if (a(str) && b(str2)) {
                if (java.util.Arrays.asList(com.umeng.analytics.pro.f.aM).contains(str)) {
                    com.umeng.commonsdk.statistics.common.MLog.e("key is " + str + ", please check key, illegal");
                    com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.m, 0, "\\|");
                    return;
                }
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", currentTimeMillis);
                if (j > 0) {
                    jSONObject.put(com.umeng.analytics.pro.f.ac, j);
                }
                jSONObject.put("__t", 2049);
                if (!android.text.TextUtils.isEmpty(str2)) {
                    jSONObject.put(str, str2);
                }
                java.lang.String d = com.umeng.commonsdk.utils.UMUtils.isMainProgress(g) ? com.umeng.analytics.pro.aa.a().d(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(g)) : com.umeng.analytics.pro.aa.a().a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(g), currentTimeMillis);
                if (android.text.TextUtils.isEmpty(d)) {
                    d = f;
                }
                jSONObject.put("__i", d);
                if (!android.text.TextUtils.isEmpty(str3)) {
                    try {
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject(str3);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(com.umeng.analytics.pro.f.aA, jSONObject2);
                        }
                    } catch (org.json.JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", com.umeng.commonsdk.service.UMGlobalContext.getInstance(g).getProcessName(g));
                a();
                org.json.JSONObject jSONObject3 = this.h;
                if (jSONObject3 != null && jSONObject3.has(str) && !((java.lang.Boolean) this.h.get(str)).booleanValue()) {
                    jSONObject.put(com.umeng.analytics.pro.f.ae, 1);
                    this.h.put(str, true);
                    c(g);
                }
                android.content.Context context = g;
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, 4097, com.umeng.analytics.CoreProtocol.getInstance(context), jSONObject);
                return;
            }
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.l, 0, "\\|");
        } catch (java.lang.Throwable unused2) {
        }
    }

    public void a(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, long j, java.lang.String str2, boolean z) {
        try {
            if (!a(str)) {
                com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.f, 0, "\\|");
                return;
            }
            if (b(map)) {
                if (map.size() > 100) {
                    com.umeng.commonsdk.statistics.common.MLog.e("map size is " + map.size() + ", please check");
                    return;
                }
                if (java.util.Arrays.asList(com.umeng.analytics.pro.f.aM).contains(str)) {
                    com.umeng.commonsdk.statistics.common.MLog.e("key is " + str + ", please check key, illegal");
                    com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.b, 0, "\\|");
                    return;
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", java.lang.System.currentTimeMillis());
                if (j > 0) {
                    jSONObject.put(com.umeng.analytics.pro.f.ac, j);
                }
                jSONObject.put("__t", 2049);
                com.umeng.commonsdk.statistics.common.ULog.i("befort ekv map, event is " + jSONObject.toString());
                for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : map.entrySet()) {
                    if (java.util.Arrays.asList(com.umeng.analytics.pro.f.aM).contains(entry.getKey())) {
                        com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.e, 0, "\\|");
                        return;
                    }
                    java.lang.Object value = entry.getValue();
                    if (!(value instanceof java.lang.String) && !(value instanceof java.lang.Integer) && !(value instanceof java.lang.Long) && !(value instanceof java.lang.Short) && !(value instanceof java.lang.Float) && !(value instanceof java.lang.Double)) {
                        if (!value.getClass().isArray()) {
                            com.umeng.commonsdk.statistics.common.MLog.e("please check key or value, illegal type!");
                            return;
                        }
                        if (value instanceof int[]) {
                            int[] iArr = (int[]) value;
                            if (iArr.length > 10) {
                                com.umeng.commonsdk.statistics.common.MLog.e("please check key or value, size overlength!");
                                return;
                            }
                            org.json.JSONArray jSONArray = new org.json.JSONArray();
                            for (int i : iArr) {
                                jSONArray.put(i);
                            }
                            jSONObject.put(entry.getKey(), jSONArray);
                        } else if (value instanceof double[]) {
                            double[] dArr = (double[]) value;
                            if (dArr.length > 10) {
                                com.umeng.commonsdk.statistics.common.MLog.e("please check key or value, size overlength!");
                                return;
                            }
                            org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                            for (double d : dArr) {
                                jSONArray2.put(d);
                            }
                            jSONObject.put(entry.getKey(), jSONArray2);
                        } else if (value instanceof long[]) {
                            long[] jArr = (long[]) value;
                            if (jArr.length > 10) {
                                com.umeng.commonsdk.statistics.common.MLog.e("please check key or value, size overlength!");
                                return;
                            }
                            org.json.JSONArray jSONArray3 = new org.json.JSONArray();
                            for (long j2 : jArr) {
                                jSONArray3.put(j2);
                            }
                            jSONObject.put(entry.getKey(), jSONArray3);
                        } else if (value instanceof float[]) {
                            float[] fArr = (float[]) value;
                            if (fArr.length > 10) {
                                com.umeng.commonsdk.statistics.common.MLog.e("please check key or value, size overlength!");
                                return;
                            }
                            org.json.JSONArray jSONArray4 = new org.json.JSONArray();
                            for (float f2 : fArr) {
                                jSONArray4.put(f2);
                            }
                            jSONObject.put(entry.getKey(), jSONArray4);
                        } else if (value instanceof short[]) {
                            short[] sArr = (short[]) value;
                            if (sArr.length > 10) {
                                com.umeng.commonsdk.statistics.common.MLog.e("please check key or value, size overlength!");
                                return;
                            }
                            org.json.JSONArray jSONArray5 = new org.json.JSONArray();
                            for (short s2 : sArr) {
                                jSONArray5.put((int) s2);
                            }
                            jSONObject.put(entry.getKey(), jSONArray5);
                        } else {
                            if (!(value instanceof java.lang.String[])) {
                                com.umeng.commonsdk.statistics.common.MLog.e("please check key or value, illegal type!");
                                return;
                            }
                            java.lang.String[] strArr = (java.lang.String[]) value;
                            if (strArr.length > 10) {
                                com.umeng.commonsdk.statistics.common.MLog.e("please check key or value, size overlength!");
                                return;
                            }
                            org.json.JSONArray jSONArray6 = new org.json.JSONArray();
                            for (int i2 = 0; i2 < strArr.length; i2++) {
                                java.lang.String str3 = strArr[i2];
                                if (str3 == null) {
                                    com.umeng.commonsdk.statistics.common.MLog.e("please check array, null item!");
                                    return;
                                } else {
                                    if (!b(str3)) {
                                        return;
                                    }
                                    jSONArray6.put(strArr[i2]);
                                }
                            }
                            jSONObject.put(entry.getKey(), jSONArray6);
                        }
                    }
                    jSONObject.put(entry.getKey(), value);
                }
                java.lang.String d2 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(g) ? com.umeng.analytics.pro.aa.a().d(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(g)) : com.umeng.analytics.pro.aa.a().a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(g), jSONObject.getLong("ts"));
                if (android.text.TextUtils.isEmpty(d2)) {
                    d2 = f;
                }
                jSONObject.put("__i", d2);
                if (!android.text.TextUtils.isEmpty(str2)) {
                    try {
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject(str2);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(com.umeng.analytics.pro.f.aA, jSONObject2);
                        }
                    } catch (org.json.JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", com.umeng.commonsdk.service.UMGlobalContext.getInstance(g).getProcessName(g));
                a();
                org.json.JSONObject jSONObject3 = this.h;
                if (jSONObject3 != null && jSONObject3.has(str) && !((java.lang.Boolean) this.h.get(str)).booleanValue()) {
                    jSONObject.put(com.umeng.analytics.pro.f.ae, 1);
                    this.h.put(str, true);
                    c(g);
                }
                com.umeng.commonsdk.statistics.common.ULog.i("----->>>>>ekv event json is " + jSONObject.toString());
                if (z) {
                    android.content.Context context = g;
                    com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.analytics.pro.q.a.n, com.umeng.analytics.CoreProtocol.getInstance(context), jSONObject);
                } else {
                    android.content.Context context2 = g;
                    com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context2, 4097, com.umeng.analytics.CoreProtocol.getInstance(context2), jSONObject);
                }
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    public void a(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str2) {
        try {
            if (a(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", java.lang.System.currentTimeMillis());
                jSONObject.put(com.umeng.analytics.pro.f.ac, 0);
                jSONObject.put("__t", com.umeng.analytics.pro.k.b);
                com.umeng.commonsdk.statistics.common.ULog.i("befort gkv map, event is " + jSONObject.toString());
                java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.Object>> it = map.entrySet().iterator();
                for (int i = 0; i < 10 && it.hasNext(); i++) {
                    java.util.Map.Entry<java.lang.String, java.lang.Object> next = it.next();
                    if (!com.umeng.analytics.pro.f.ae.equals(next.getKey()) && !com.umeng.analytics.pro.f.ac.equals(next.getKey()) && !"id".equals(next.getKey()) && !"ts".equals(next.getKey())) {
                        java.lang.Object value = next.getValue();
                        if ((value instanceof java.lang.String) || (value instanceof java.lang.Integer) || (value instanceof java.lang.Long)) {
                            jSONObject.put(next.getKey(), value);
                        }
                    }
                }
                java.lang.String d = com.umeng.analytics.pro.aa.a().d(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(g));
                if (android.text.TextUtils.isEmpty(d)) {
                    d = f;
                }
                jSONObject.put("__i", d);
                if (!android.text.TextUtils.isEmpty(str2)) {
                    try {
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject(str2);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(com.umeng.analytics.pro.f.aA, jSONObject2);
                        }
                    } catch (org.json.JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", com.umeng.commonsdk.service.UMGlobalContext.getInstance(g).getProcessName(g));
                com.umeng.commonsdk.statistics.common.ULog.i("----->>>>>gkv event json is " + jSONObject.toString());
                android.content.Context context = g;
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, 4098, com.umeng.analytics.CoreProtocol.getInstance(context), jSONObject);
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    public void a(java.util.List<java.lang.String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    a();
                    org.json.JSONObject jSONObject = this.h;
                    if (jSONObject != null) {
                        if (jSONObject.length() >= 5) {
                            com.umeng.commonsdk.statistics.common.MLog.d("already setFistLaunchEvent, igone.");
                            return;
                        }
                        for (int i = 0; i < list.size(); i++) {
                            if (this.h.length() >= 5) {
                                com.umeng.commonsdk.statistics.common.MLog.d(" add setFistLaunchEvent over.");
                                return;
                            }
                            a(com.umeng.commonsdk.statistics.common.HelperUtils.subStr(list.get(i), 128), false);
                        }
                        c(g);
                        return;
                    }
                    this.h = new org.json.JSONObject();
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        org.json.JSONObject jSONObject2 = this.h;
                        if (jSONObject2 == null) {
                            this.h = new org.json.JSONObject();
                        } else if (jSONObject2.length() >= 5) {
                            break;
                        }
                        java.lang.String str = list.get(i2);
                        if (!android.text.TextUtils.isEmpty(str)) {
                            a(com.umeng.commonsdk.statistics.common.HelperUtils.subStr(str, 128), false);
                        }
                    }
                    c(g);
                    return;
                }
            } catch (java.lang.Exception unused) {
                return;
            }
        }
        com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.ak, 0, "\\|");
    }
}
