package com.igexin.push.core.b;

/* loaded from: classes31.dex */
public final class l extends com.igexin.push.extension.mod.BaseActionBean implements java.io.Serializable {
    private static boolean k = true;
    private static int l;
    private static int m;
    public com.igexin.push.core.b.l.b a;
    public com.igexin.push.core.b.l.b b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    public com.igexin.sdk.message.GTPopupMessage j;

    /* loaded from: classes23.dex */
    public enum a {
        closePopup,
        intent,
        url
    }

    /* loaded from: classes23.dex */
    public static class b implements java.io.Serializable {
        private java.lang.String A;
        private java.lang.String B;
        private java.lang.String C;
        private java.lang.String D;
        private java.lang.String E;
        private float F;
        private float G;
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String c;
        public java.lang.String d;
        public java.lang.String e;
        public java.lang.String f;
        public java.util.ArrayList<com.igexin.push.core.b.l.b> g;
        public java.lang.String h;
        public boolean i;
        public java.lang.String j;
        public java.lang.String k;
        public int l;
        public int m;
        public int n;
        public com.igexin.sdk.message.GTPopupMessage o;
        public java.lang.String p;
        float q = 0.0f;
        private java.lang.String r;

        /* renamed from: s, reason: collision with root package name */
        private java.lang.String f387s;
        private java.lang.String t;
        private java.lang.String u;
        private java.lang.String v;
        private java.lang.String w;
        private java.lang.String x;
        private java.lang.String y;
        private java.lang.String z;

        public b(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2, float f, float f2) {
            java.lang.String str3;
            org.json.JSONObject optJSONObject;
            if (jSONObject == null) {
                return;
            }
            this.F = f;
            this.G = f2;
            this.a = jSONObject.optString("type");
            org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject("layout");
            if (optJSONObject2 != null) {
                this.b = optJSONObject2.optString(com.sensorsdata.sf.ui.view.UIProperty.align);
                this.r = optJSONObject2.optString("width", null);
                this.f387s = optJSONObject2.optString("height", null);
                org.json.JSONObject optJSONObject3 = optJSONObject2.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.margin);
                if (optJSONObject3 != null) {
                    this.u = optJSONObject3.optString(com.sensorsdata.sf.ui.view.UIProperty.top, null);
                    this.v = optJSONObject3.optString(com.sensorsdata.sf.ui.view.UIProperty.bottom, null);
                    this.w = optJSONObject3.optString(com.sensorsdata.sf.ui.view.UIProperty.right, null);
                    this.x = optJSONObject3.optString(com.sensorsdata.sf.ui.view.UIProperty.left, null);
                }
                org.json.JSONObject optJSONObject4 = optJSONObject2.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.padding);
                if (optJSONObject4 != null) {
                    this.y = optJSONObject4.optString(com.sensorsdata.sf.ui.view.UIProperty.top, null);
                    this.z = optJSONObject4.optString(com.sensorsdata.sf.ui.view.UIProperty.bottom, null);
                    this.A = optJSONObject4.optString(com.sensorsdata.sf.ui.view.UIProperty.right, null);
                    this.B = optJSONObject4.optString(com.sensorsdata.sf.ui.view.UIProperty.left, null);
                }
                this.t = optJSONObject2.optString(com.sensorsdata.sf.ui.view.UIProperty.maxHeight);
            }
            org.json.JSONObject optJSONObject5 = jSONObject.optJSONObject("properties");
            if (optJSONObject5 != null) {
                this.d = optJSONObject5.optString("name", "");
                this.e = optJSONObject5.optString("elementType");
                this.f = optJSONObject5.optString("elementId", "");
                this.h = optJSONObject5.optString("image");
                this.C = optJSONObject5.optString(com.sensorsdata.sf.ui.view.UIProperty.cornerRadius, null);
                this.k = optJSONObject5.optString("text");
                this.D = optJSONObject5.optString("font", null);
                this.c = optJSONObject5.optString(com.sensorsdata.sf.ui.view.UIProperty.textAlign, null);
                this.i = "bold".equals(optJSONObject5.optString("fontWeight"));
                org.json.JSONObject optJSONObject6 = optJSONObject5.optJSONObject("color");
                if (optJSONObject6 != null) {
                    str3 = "";
                    this.l = android.graphics.Color.argb((int) (optJSONObject6.optDouble("a") * 255.0d), (int) optJSONObject6.optDouble("r"), (int) optJSONObject6.optDouble("g"), (int) optJSONObject6.optDouble("b"));
                } else {
                    str3 = "";
                }
                org.json.JSONObject optJSONObject7 = optJSONObject5.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.backgroundColor);
                if (optJSONObject7 != null) {
                    this.m = android.graphics.Color.argb((int) (optJSONObject7.optDouble("a") * 255.0d), (int) optJSONObject7.optDouble("r"), (int) optJSONObject7.optDouble("g"), (int) optJSONObject7.optDouble("b"));
                }
                this.E = optJSONObject5.optString(com.sensorsdata.sf.ui.view.UIProperty.borderWidth, null);
                org.json.JSONObject optJSONObject8 = optJSONObject5.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.borderColor);
                if (optJSONObject8 != null) {
                    this.n = android.graphics.Color.argb((int) (optJSONObject8.optDouble("a") * 255.0d), (int) optJSONObject8.optDouble("r"), (int) optJSONObject8.optDouble("g"), (int) optJSONObject8.optDouble("b"));
                }
                this.j = optJSONObject5.optString(com.sensorsdata.sf.ui.view.UIProperty.backgroundImage);
            } else {
                str3 = "";
            }
            org.json.JSONObject optJSONObject9 = jSONObject.optJSONObject("action");
            if (optJSONObject9 != null && (optJSONObject = optJSONObject9.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.action_android)) != null) {
                com.igexin.sdk.message.GTPopupMessage gTPopupMessage = new com.igexin.sdk.message.GTPopupMessage();
                gTPopupMessage.setElementType(this.e);
                com.igexin.sdk.message.GTPopupMessage.GtAction gtAction = new com.igexin.sdk.message.GTPopupMessage.GtAction(optJSONObject.optString("actionType"), optJSONObject.optString(com.huawei.hms.support.api.entity.core.CommonCode.Resolution.HAS_RESOLUTION_FROM_APK), optJSONObject.optString("url"), optJSONObject.optBoolean("closePopup", false));
                java.lang.String str4 = this.f;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(this.d);
                sb.append(android.text.TextUtils.isEmpty(this.k) ? str3 : com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.k);
                com.igexin.sdk.message.GTPopupMessage.EventProperties eventProperties = new com.igexin.sdk.message.GTPopupMessage.EventProperties(str, str2, str4, sb.toString());
                gTPopupMessage.setAction(gtAction);
                gTPopupMessage.setEventProperties(eventProperties);
                this.o = gTPopupMessage;
                this.p = optJSONObject.optString("clickActionId", str3);
            }
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray(com.sensorsdata.sf.ui.view.UIProperty.subviews);
            if (optJSONArray != null) {
                this.g = new java.util.ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.g.add(new com.igexin.push.core.b.l.b(optJSONArray.optJSONObject(i), str, str2, f, f2));
                }
            }
        }

        private static float a(java.lang.String str) {
            if (str == null || !str.contains("px")) {
                return 0.0f;
            }
            return (float) (com.igexin.push.core.e.l.getResources().getDisplayMetrics().scaledDensity * java.lang.Double.parseDouble(str.substring(0, str.length() - 2)));
        }

        private static int a(java.lang.String str, float f, float f2) {
            if (str == null || !str.contains("px")) {
                return -2;
            }
            return (int) (((com.igexin.push.core.b.l.k ? java.lang.Math.min(com.igexin.push.core.b.l.m / f2, com.igexin.push.core.b.l.l / f) : java.lang.Math.min(com.igexin.push.core.b.l.m / f, com.igexin.push.core.b.l.l / f2)) * java.lang.Double.parseDouble(str.substring(0, str.length() - 2))) + 0.5d);
        }

        private java.lang.Object a(java.lang.String str, java.lang.Object obj) {
            if (this.q == 0.0f) {
                this.q = com.igexin.push.core.e.l.getResources().getDisplayMetrics().density;
            }
            if (str == null || !str.contains("px")) {
                return obj;
            }
            double parseDouble = java.lang.Double.parseDouble(str.substring(0, str.length() - 2));
            return obj instanceof java.lang.Float ? java.lang.Double.valueOf(parseDouble * this.q) : obj instanceof java.lang.Integer ? java.lang.Integer.valueOf((int) ((parseDouble * this.q) + 0.5d)) : java.lang.Integer.valueOf((int) ((parseDouble * this.q) + 0.5d));
        }

        private static java.lang.Object a(java.lang.String str, java.lang.Object obj, float f, float f2) {
            float f3;
            int i;
            if (str == null || !str.contains("px")) {
                return obj;
            }
            if (com.igexin.push.core.b.l.k) {
                f3 = com.igexin.push.core.b.l.m / f2;
                i = com.igexin.push.core.b.l.l;
            } else {
                f3 = com.igexin.push.core.b.l.l / f2;
                i = com.igexin.push.core.b.l.m;
            }
            float min = java.lang.Math.min(f3, i / f);
            float parseFloat = java.lang.Float.parseFloat(str.substring(0, str.length() - 2));
            if (obj instanceof java.lang.Float) {
                return java.lang.Float.valueOf(parseFloat * min);
            }
            boolean z = obj instanceof java.lang.Integer;
            return java.lang.Integer.valueOf((int) ((parseFloat * min) + 0.5f));
        }

        public final int a() {
            return a(this.r, this.F, this.G);
        }

        public final int b() {
            return a(this.f387s, this.F, this.G);
        }

        public final int c() {
            return ((java.lang.Integer) a(this.u, 0, this.F, this.G)).intValue();
        }

        public final int d() {
            return ((java.lang.Integer) a(this.v, 0, this.F, this.G)).intValue();
        }

        public final int e() {
            return ((java.lang.Integer) a(this.w, 0, this.F, this.G)).intValue();
        }

        public final int f() {
            return ((java.lang.Integer) a(this.x, 0, this.F, this.G)).intValue();
        }

        public final int g() {
            return ((java.lang.Integer) a(this.y, 0, this.F, this.G)).intValue();
        }

        public final int h() {
            return ((java.lang.Integer) a(this.z, 0, this.F, this.G)).intValue();
        }

        public final int i() {
            return ((java.lang.Integer) a(this.A, 0, this.F, this.G)).intValue();
        }

        public final int j() {
            return ((java.lang.Integer) a(this.B, 0, this.F, this.G)).intValue();
        }

        public final int k() {
            return ((java.lang.Integer) a(this.C, 0, this.F, this.G)).intValue();
        }

        public final float l() {
            return ((java.lang.Float) a(this.D, java.lang.Float.valueOf(0.0f), this.F, this.G)).floatValue();
        }

        public final int m() {
            return ((java.lang.Integer) a(this.E, 0, this.F, this.G)).intValue();
        }

        public final int n() {
            return ((java.lang.Integer) a(this.t, 0, this.F, this.G)).intValue();
        }
    }

    public static void a(android.content.Context context) {
        int i;
        int i2 = context.getResources().getConfiguration().orientation;
        android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int min = java.lang.Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        if (i2 == 1) {
            k = true;
            l = min;
            i = displayMetrics.heightPixels;
        } else {
            k = false;
            l = min;
            i = displayMetrics.widthPixels;
        }
        m = i;
    }

    private void a(java.lang.String str) {
        this.e = str;
    }

    private void a(org.json.JSONObject jSONObject) {
        float f;
        float f2;
        org.json.JSONObject optJSONObject = jSONObject.optJSONObject("statisticsInfo");
        if (optJSONObject != null) {
            this.c = optJSONObject.optString("planName", "");
            this.d = optJSONObject.optString("nodeName", "");
        }
        org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject("properties");
        if (optJSONObject2 != null) {
            java.lang.String optString = optJSONObject2.optString("baseWidth");
            java.lang.String optString2 = optJSONObject2.optString("baseHeight");
            f = java.lang.Float.parseFloat(optString.substring(0, optString.length() - 2));
            f2 = java.lang.Float.parseFloat(optString2.substring(0, optString2.length() - 2));
        } else {
            f = 1.0f;
            f2 = 1.0f;
        }
        this.i = jSONObject.optString("showActionId", "");
        float f3 = f;
        float f4 = f2;
        this.a = new com.igexin.push.core.b.l.b(jSONObject.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.type_mask), this.c, this.d, f3, f4);
        this.b = new com.igexin.push.core.b.l.b(jSONObject.optJSONObject("template"), this.c, this.d, f3, f4);
        com.igexin.sdk.message.GTPopupMessage.EventProperties eventProperties = new com.igexin.sdk.message.GTPopupMessage.EventProperties(this.c, this.d, "", "");
        com.igexin.sdk.message.GTPopupMessage gTPopupMessage = new com.igexin.sdk.message.GTPopupMessage();
        gTPopupMessage.setEventProperties(eventProperties);
        this.j = gTPopupMessage;
    }

    private void b(java.lang.String str) {
        this.f = str;
    }

    private void c(java.lang.String str) {
        this.g = str;
    }

    private java.lang.String d() {
        return this.g;
    }

    private void d(java.lang.String str) {
        this.h = str;
    }

    private java.lang.String e() {
        return this.i;
    }

    private com.igexin.sdk.message.GTPopupMessage f() {
        return this.j;
    }

    private com.igexin.push.core.b.l.b g() {
        return this.b;
    }

    private com.igexin.push.core.b.l.b h() {
        return this.a;
    }

    private java.lang.String i() {
        return this.e;
    }

    private java.lang.String j() {
        return this.h;
    }

    private java.lang.String k() {
        return this.f;
    }
}
