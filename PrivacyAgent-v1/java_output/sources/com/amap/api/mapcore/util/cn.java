package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class cn {
    private static final int[] d = {1};
    private int b = 0;
    private int c = -1;
    java.util.List<com.amap.api.mapcore.util.cj> a = null;

    public static int a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (!str.startsWith("#")) {
                str = "#".concat(str);
            }
            return android.graphics.Color.parseColor(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public static com.amap.api.mapcore.util.ck a(byte[] bArr) {
        com.amap.api.mapcore.util.ck ckVar = null;
        try {
            com.amap.api.mapcore.util.ck ckVar2 = new com.amap.api.mapcore.util.ck();
            try {
                byte[] bytes = "l".getBytes("utf-8");
                int length = bArr.length;
                int length2 = bytes.length;
                for (int i = 0; i < length; i++) {
                    bArr[i] = (byte) (bytes[i % length2] ^ bArr[i]);
                }
                ckVar2.a(com.autonavi.base.amap.mapcore.Convert.getString(bArr, 0, 4));
                ckVar2.b(com.autonavi.base.amap.mapcore.Convert.getString(bArr, 4, 32));
                ckVar2.c(com.autonavi.base.amap.mapcore.Convert.getString(bArr, 36, 10));
                ckVar2.d(a(com.autonavi.base.amap.mapcore.Convert.getSubBytes(bArr, 78, length - 78), com.autonavi.base.amap.mapcore.Convert.getSubBytes(bArr, 46, 16), com.autonavi.base.amap.mapcore.Convert.getSubBytes(bArr, 62, 16)));
                return ckVar2;
            } catch (java.lang.Throwable th) {
                th = th;
                ckVar = ckVar2;
                th.printStackTrace();
                return ckVar;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static com.autonavi.base.ae.gmap.style.StyleElement a(java.util.Map<java.lang.Integer, com.autonavi.base.ae.gmap.style.StyleItem> map, int i, int i2, com.amap.api.mapcore.util.cj cjVar) {
        com.autonavi.base.ae.gmap.style.StyleItem styleItem = map.get(java.lang.Integer.valueOf(i));
        if (styleItem == null) {
            styleItem = new com.autonavi.base.ae.gmap.style.StyleItem(cjVar.c);
            styleItem.mainKey = cjVar.a;
            styleItem.subKey = cjVar.b;
            map.put(java.lang.Integer.valueOf(i), styleItem);
        }
        com.autonavi.base.ae.gmap.style.StyleElement styleElement = styleItem.get(i2);
        if (styleElement != null) {
            return styleElement;
        }
        com.autonavi.base.ae.gmap.style.StyleElement styleElement2 = new com.autonavi.base.ae.gmap.style.StyleElement();
        styleElement2.styleElementType = i2;
        styleItem.put(i2, styleElement2);
        return styleElement2;
    }

    private static java.lang.String a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(bArr3);
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr2, "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new java.lang.String(cipher.doFinal(bArr), "utf-8");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private java.util.List<com.amap.api.mapcore.util.cj> a(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.amap.api.mapcore.util.cj cjVar : this.a) {
            if (cjVar != null) {
                java.lang.String str4 = cjVar.e;
                if (str4 == null || !str4.equals(str2)) {
                    java.lang.String str5 = cjVar.e;
                    if (str5 != null && str5.equals(str) && (str3 = cjVar.f) != null && str3.contains(str2)) {
                        arrayList.add(cjVar);
                    }
                } else {
                    arrayList.add(cjVar);
                }
            }
        }
        return arrayList;
    }

    private void a(com.amap.api.mapcore.util.co coVar) {
        if (this.c != -1) {
            java.util.Map<java.lang.Integer, com.autonavi.base.ae.gmap.style.StyleItem> a = coVar.a();
            for (com.amap.api.mapcore.util.cj cjVar : a("roads", "trafficRoadBackgroundColor")) {
                a(a, cjVar.d, com.amap.api.mapcore.util.cl.a("fillColor"), cjVar).value = this.c;
                a(a, cjVar.d, com.amap.api.mapcore.util.cl.a("strokeColor"), cjVar).value = this.c;
            }
        }
    }

    private void a(com.amap.api.mapcore.util.co coVar, byte[] bArr, boolean z) {
        com.amap.api.mapcore.util.ck a = a(bArr);
        if (a == null || a.a() == null) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(a.a());
            org.json.JSONArray names = jSONObject.names();
            for (int i = 0; i < names.length(); i++) {
                java.lang.String string = names.getString(i);
                if (string == null || !string.trim().equals("sdkTextures")) {
                    if (string == null || !string.trim().equals("background")) {
                        org.json.JSONObject optJSONObject = jSONObject.optJSONObject(string);
                        if (optJSONObject != null) {
                            a(string, coVar.a(), optJSONObject, z);
                        }
                    } else {
                        this.b = a("#".concat(java.lang.String.valueOf(jSONObject.optString("background"))));
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.Integer, com.autonavi.base.ae.gmap.style.StyleItem> map, org.json.JSONObject jSONObject, boolean z) throws org.json.JSONException {
        if (jSONObject == null) {
            return;
        }
        if (this.a == null) {
            this.a = b();
        }
        java.util.List<com.amap.api.mapcore.util.cj> a = a(str, str2);
        for (com.amap.api.mapcore.util.cj cjVar : a) {
            if (cjVar == null || cjVar.c == -1000) {
                return;
            }
            int i = cjVar.d;
            if (jSONObject.optBoolean("visible", true)) {
                if (!jSONObject.optBoolean("showIcon", true)) {
                    a(map, i, com.amap.api.mapcore.util.cl.a("textFillColor"), cjVar).textureId = -1;
                }
                if (!jSONObject.optBoolean("showLabel", true)) {
                    a(map, i, com.amap.api.mapcore.util.cl.a("textFillColor"), cjVar).opacity = 0.0f;
                    com.autonavi.base.ae.gmap.style.StyleElement a2 = a(map, i, com.amap.api.mapcore.util.cl.a("textStrokeColor"), cjVar);
                    a2.opacity = 0.0f;
                    a2.visible = 0;
                    a2.textureId = -1;
                }
                a(map, jSONObject, "color", "opacity", i, cjVar);
                a(map, jSONObject, "fillColor", "fillOpacity", i, cjVar);
                a(map, jSONObject, "strokeColor", "strokeOpacity", i, cjVar);
                a(map, jSONObject, "textFillColor", "textFillOpacity", i, cjVar);
                a(map, jSONObject, "textStrokeColor", "textStrokeOpacity", i, cjVar);
                a(map, jSONObject, com.sensorsdata.sf.ui.view.UIProperty.backgroundColor, "backgroundOpacity", i, cjVar);
                if (z) {
                    a(map, jSONObject, "textureName", i, cjVar);
                }
            } else {
                com.autonavi.base.ae.gmap.style.StyleElement a3 = a(map, i, com.amap.api.mapcore.util.cl.a("visible"), cjVar);
                a3.textureId = -1;
                a3.visible = 0;
            }
        }
        a.clear();
    }

    private void a(java.lang.String str, java.util.Map<java.lang.Integer, com.autonavi.base.ae.gmap.style.StyleItem> map, org.json.JSONObject jSONObject, boolean z) throws org.json.JSONException {
        if (jSONObject == null) {
            return;
        }
        org.json.JSONObject optJSONObject = jSONObject.optJSONObject("subType");
        if (optJSONObject == null) {
            a(str, str, map, jSONObject, z);
            return;
        }
        org.json.JSONArray names = optJSONObject.names();
        for (int i = 0; i < names.length(); i++) {
            java.lang.String optString = names.optString(i);
            org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject(optString);
            if (optJSONObject2.has("detailedType")) {
                org.json.JSONObject optJSONObject3 = optJSONObject2.optJSONObject("detailedType");
                if (optJSONObject3 != null) {
                    org.json.JSONArray names2 = optJSONObject3.names();
                    for (int i2 = 0; i2 < names2.length(); i2++) {
                        java.lang.String optString2 = names2.optString(i2);
                        org.json.JSONObject optJSONObject4 = optJSONObject3.optJSONObject(optString2);
                        if (optJSONObject4 != null) {
                            a(str, optString2, map, optJSONObject4, z);
                        }
                    }
                }
            } else {
                a(str, optString, map, optJSONObject2, z);
            }
        }
    }

    private static void a(java.util.Map<java.lang.Integer, com.autonavi.base.ae.gmap.style.StyleItem> map, org.json.JSONObject jSONObject, int i, int i2, com.amap.api.mapcore.util.cj cjVar) throws org.json.JSONException {
        int a;
        com.autonavi.base.ae.gmap.style.StyleElement a2 = a(map, i, i2, cjVar);
        org.json.JSONObject optJSONObject = jSONObject.optJSONObject("stylers");
        if (optJSONObject == null || (a = a(optJSONObject.optString("color"))) == 0) {
            return;
        }
        a2.value = a;
        a2.textureId = optJSONObject.optInt("textureName", 0);
        a2.lineWidth = optJSONObject.optInt("lineWidth", 0);
        if (i >= 30 && i <= 38) {
            a(map, i, 4, cjVar).opacity = 0.1f;
            return;
        }
        java.lang.String str = cjVar.e;
        if (str != null && str.equals("water") && i2 == 3) {
            a(map, i, 2, cjVar).value = a;
        }
    }

    private static void a(java.util.Map<java.lang.Integer, com.autonavi.base.ae.gmap.style.StyleItem> map, org.json.JSONObject jSONObject, java.lang.String str, int i, com.amap.api.mapcore.util.cj cjVar) {
        try {
            int optInt = jSONObject.optInt(str, 0);
            if (optInt == 0) {
                return;
            }
            a(map, i, com.amap.api.mapcore.util.cl.a(str), cjVar).textureId = optInt;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(java.util.Map<java.lang.Integer, com.autonavi.base.ae.gmap.style.StyleItem> map, org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2, int i, com.amap.api.mapcore.util.cj cjVar) {
        int a;
        float f;
        try {
            java.lang.String optString = jSONObject.optString(str, null);
            if (android.text.TextUtils.isEmpty(optString)) {
                f = (float) jSONObject.optDouble(str2, 1.0d);
                a = 0;
            } else {
                a = a("#".concat(java.lang.String.valueOf(optString)));
                f = 1.0f;
            }
            if (a == 0 && f == 1.0d) {
                return;
            }
            int a2 = com.amap.api.mapcore.util.cl.a(str);
            com.autonavi.base.ae.gmap.style.StyleElement a3 = a(map, i, a2, cjVar);
            a3.value = a;
            a3.opacity = f;
            java.lang.String str3 = cjVar.f;
            if (str3 != null && str3.equals("China")) {
                a(map, i, a2, cjVar).opacity = 0.0f;
                return;
            }
            java.lang.String str4 = cjVar.e;
            if (str4 != null && str4.equals("water") && a2 == 3) {
                com.autonavi.base.ae.gmap.style.StyleElement a4 = a(map, i, 2, cjVar);
                a4.value = a;
                a4.opacity = f;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(java.util.Map<java.lang.Integer, com.autonavi.base.ae.gmap.style.StyleItem> map, org.json.JSONObject jSONObject, java.lang.String str, java.lang.String[] strArr, int i) throws org.json.JSONException {
        for (java.lang.String str2 : strArr) {
            if (this.a == null) {
                this.a = b();
            }
            for (com.amap.api.mapcore.util.cj cjVar : a(str, str2)) {
                a(map, jSONObject, cjVar.d, i, cjVar);
            }
        }
    }

    private static void a(org.json.JSONArray jSONArray, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.List<com.amap.api.mapcore.util.cj> list) {
        int[] iArr;
        if (jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("mainkey");
                int[] iArr2 = new int[0];
                org.json.JSONArray optJSONArray = optJSONObject.optJSONArray("subkey");
                if (optJSONArray != null) {
                    int length2 = optJSONArray.length();
                    int[] iArr3 = new int[length2];
                    for (int i2 = 0; i2 < length2; i2++) {
                        iArr3[i2] = optJSONArray.optInt(i2);
                    }
                    iArr = iArr3;
                } else {
                    iArr = iArr2;
                }
                list.add(new com.amap.api.mapcore.util.cj(optInt, iArr, str, str2, str3));
            }
        }
    }

    private boolean a(java.util.Map<java.lang.Integer, com.autonavi.base.ae.gmap.style.StyleItem> map, byte[] bArr) {
        java.lang.String[] a;
        int a2;
        int a3;
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(new java.lang.String(bArr, "UTF-8"));
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
                java.lang.String optString = optJSONObject.optString("featureType");
                if (!android.text.TextUtils.isEmpty(optString)) {
                    if ("background".equals(optString)) {
                        org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("stylers");
                        if (optJSONObject2 != null && (a3 = a(optJSONObject2.optString("color"))) != 0) {
                            this.b = a3;
                        }
                    } else {
                        java.lang.String b = com.amap.api.mapcore.util.cm.b(optString);
                        if (b != null && (a = com.amap.api.mapcore.util.cm.a(optString)) != null && a.length != 0) {
                            java.lang.String optString2 = optJSONObject.optString("elementType");
                            if (!android.text.TextUtils.isEmpty(optString2) && (a2 = com.amap.api.mapcore.util.cl.a(optString2)) != -1) {
                                a(map, optJSONObject, b, a, a2);
                            }
                        }
                    }
                }
            }
            return true;
        } catch (org.json.JSONException unused) {
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private com.amap.api.mapcore.util.co b(java.lang.String str, boolean z) {
        try {
            return b(com.autonavi.base.amap.mapcore.FileUtil.readFileContents(str), z);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private com.amap.api.mapcore.util.co b(byte[] bArr, boolean z) {
        com.amap.api.mapcore.util.co coVar = new com.amap.api.mapcore.util.co();
        try {
            if (!a(coVar.a(), bArr)) {
                a(coVar, bArr, z);
            }
            a(coVar);
            coVar.b();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return coVar;
    }

    private java.util.List<com.amap.api.mapcore.util.cj> b() {
        org.json.JSONArray jSONArray;
        org.json.JSONObject optJSONObject;
        java.lang.String str;
        java.lang.String str2;
        org.json.JSONObject jSONObject;
        org.json.JSONArray jSONArray2;
        int i;
        java.lang.String str3;
        java.lang.String str4;
        org.json.JSONObject jSONObject2;
        org.json.JSONArray jSONArray3;
        int i2;
        org.json.JSONObject jSONObject3;
        org.json.JSONObject optJSONObject2;
        java.lang.String str5;
        org.json.JSONObject jSONObject4;
        java.lang.String str6 = "name";
        java.lang.String str7 = "subType";
        this.a = new java.util.ArrayList();
        try {
            jSONArray = new org.json.JSONArray("[{\n\t\"regions\": {\n\t\t\"name\": \"区域面\",\n\t\t\"subType\": {\n\t\t\t\"land\": {\n\t\t\t\t\"name\": \"陆地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [1, 4, 5]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"green\": {\n\t\t\t\t\"name\": \"绿地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [3, 7, 8, 9, 10, 12]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"edu\": {\n\t\t\t\t\"name\": \"教育体育\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [3, 31]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"public\": {\n\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [4, 12, 22, 32]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"traffic\": {\n\t\t\t\t\"name\": \"交通枢纽\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [6, 14, 40]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 30004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"scenicSpot\": {\n\t\t\t\t\"name\": \"景区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [5, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"culture\": {\n\t\t\t\t\"name\": \"文化\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [7, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"health\": {\n\t\t\t\t\"name\": \"医疗卫生\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [8, 36]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"sports\": {\n\t\t\t\t\"name\": \"运动场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [9, 10, 13, 19, 20, 21, 34, 37, 39]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"business\": {\n\t\t\t\t\"name\": \"商业场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [11, 23, 24, 25, 26, 27, 28, 29, 30, 38]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"parkingLot\": {\n\t\t\t\t\"name\": \"停车场\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30003\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"water\": {\n\t\t\"name\": \"水系\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 30001,\n\t\t\t\"subkey\": [2, 6, 11, 13]\n\t\t}, {\n\t\t\t\"mainkey\": 20014\n\t\t}, {\n\t\t\t\"mainkey\": 10002,\n\t\t\t\"subkey\": [13]\n\t\t}]\n\t},\n\t\"buildings\": {\n\t\t\"name\": \"建筑物\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 50001\n\t\t}, {\n\t\t\t\"mainkey\": 50002\n\t\t}, {\n\t\t\t\"mainkey\": 50003\n\t\t}, {\n\t\t\t\"mainkey\": 50004\n\t\t}, {\n\t\t\t\"mainkey\": 30002,\n\t\t\t\"subkey\": [2, 15, 16, 17, 18]\n\t\t}]\n\t},\n\t\"roads\": {\n\t\t\"name\": \"道路\",\n\t\t\"subType\": {\n\t\t\t\"highWay\": {\n\t\t\t\t\"name\": \"高速公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20001\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"ringRoad\": {\n\t\t\t\t\"name\": \"城市环线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20002\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"nationalRoad\": {\n\t\t\t\t\"name\": \"国道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20003\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincialRoad\": {\n\t\t\t\t\"name\": \"省道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"secondaryRoad\": {\n\t\t\t\t\"name\": \"二级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20007\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelThreeRoad\": {\n\t\t\t\t\"name\": \"三级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20008\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelFourRoad\": {\n\t\t\t\t\"name\": \"四级道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20009\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"roadsBeingBuilt\": {\n\t\t\t\t\"name\": \"在建道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20018\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"railway\": {\n\t\t\t\t\"name\": \"铁路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"highSpeedRailway\": {\n\t\t\t\t\"name\": \"高铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [2]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subwayBeingBuilt\": {\n\t\t\t\t\"name\": \"在建地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015,\n\t\t\t\t\t\"subkey\": [1, 2]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20019\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"overPass\": {\n\t\t\t\t\"name\": \"天桥\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20012\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"underPass\": {\n\t\t\t\t\"name\": \"地道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20013\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"other\": {\n\t\t\t\t\"name\": \"其他线条\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20011\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20017\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20020\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20024\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20028\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"guideBoards\": {\n\t\t\t\t\"name\": \"道路路牌\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 40001\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"labels\": {\n\t\t\"name\": \"标注\",\n\t\t\"subType\": {\n\t\t\t\"pois\": {\n\t\t\t\t\"name\": \"兴趣点\",\n\t\t\t\t\"subType\": {\n\t\t\t\t\t\"hotel\": {\n\t\t\t\t\t\t\"name\": \"住宿\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 0,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [9, 133, 134, 135, 136, 155, 156, 157, 158, 159, 160, 161, 162, 186]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [31, 32, 33, 34, 35, 36, 37, 38, 39, 164, 165]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"restaurant\": {\n\t\t\t\t\t\t\"name\": \"餐饮\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 1,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [19, 20, 21, 22, 114, 115, 116, 117, 118, 119, 183, 187]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 166, 167, 168, 179, 180, 181, 203, 205, 206, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"shop\": {\n\t\t\t\t\t\t\"name\": \"购物\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 2,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [7, 8, 68, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 7, 8, 9, 10, 11, 12, 13, 175, 200, 201, 202, 204]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"scenicSpot\": {\n\t\t\t\t\t\t\"name\": \"风景名胜\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 3,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [4, 12, 14, 38, 69, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 120, 167, 171, 188, 189, 190, 191, 192]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10008\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 187, 188, 190, 192, 193, 194, 195, 196, 198, 216, 217, 218, 219, 220, 221, 223, 224, 225]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"traffic\": {\n\t\t\t\t\t\t\"name\": \"交通设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 4,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [23, 24, 25, 26, 31, 36, 148, 154, 168, 172, 175, 176, 177, 178]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [11, 16]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10009\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"bank\": {\n\t\t\t\t\t\t\"name\": \"金融保险\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 5,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 144, 145, 146, 147]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"edu\": {\n\t\t\t\t\t\t\"name\": \"科教文化\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 6,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [10, 11, 13, 35, 138, 139, 140, 141, 142, 143, 163, 164, 165, 166, 170]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [43, 44, 45, 46, 47, 176, 177]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"live\": {\n\t\t\t\t\t\t\"name\": \"生活服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 7,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [58, 63, 64, 65, 66, 67, 121, 122, 123]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [28, 29, 30]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"hospital\": {\n\t\t\t\t\t\t\"name\": \"医疗保健\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 8,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [32, 33, 57, 70, 131, 132, 169, 193, 206, 207, 208, 209, 210]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [170, 209]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pe\": {\n\t\t\t\t\t\t\"name\": \"休闲体育\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 9,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [15, 16, 17, 37, 60, 61, 62, 73, 124, 125, 126, 127, 128, 129, 130, 180, 181, 182, 184, 185, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [169, 171, 172, 173, 174, 178, 197, 207]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"public\": {\n\t\t\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 10,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [59, 173, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"buidling\": {\n\t\t\t\t\t\t\"name\": \"商务住宅\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 11,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 74, 75, 76, 77, 78, 79, 80, 81, 179]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [189, 191]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"gov\": {\n\t\t\t\t\t\t\"name\": \"政府机构及社会团体\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 12,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [3, 34, 43, 137]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"moto\": {\n\t\t\t\t\t\t\"name\": \"摩托车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 13,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [113]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"vehicle\": {\n\t\t\t\t\t\t\"name\": \"汽车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 14,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [39, 40, 41, 71, 72, 151, 152, 153]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [40, 41, 42, 182, 183, 184, 185, 186]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pass\": {\n\t\t\t\t\t\t\"name\": \"通行设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 15,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [27, 28, 149, 150, 174]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [21]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"subway\": {\n\t\t\t\t\t\t\"name\": \"地铁站\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 16,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10005\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10006\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"roadFacilities\": {\n\t\t\t\t\t\t\"name\": \"道路附属设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 17,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [2, 29, 30]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10017\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"address\": {\n\t\t\t\t\t\t\"name\": \"地名\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 18,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [18]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [10, 12, 14, 15, 23, 36]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"other\": {\n\t\t\t\t\t\t\"name\": \"其他\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 19,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [1, 211, 212]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [28]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [208, 210, 211, 212, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10010\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10011\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10012\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10013\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10014\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10015\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10016\n\t\t\t\t\t\t}]\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t},\n\t\t\t\"aois\": {\n\t\t\t\t\"name\": \"区域标注\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"continent\": {\n\t\t\t\t\"name\": \"大洲\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [20]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"country\": {\n\t\t\t\t\"name\": \"国家\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [18, 19, 29]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"province\": {\n\t\t\t\t\"name\": \"省/直辖市/自治区/特别行政区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [22, 26, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"city\": {\n\t\t\t\t\"name\": \"城市\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 5, 7, 24, 25, 27, 30, 31, 32, 34, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"district\": {\n\t\t\t\t\"name\": \"区县\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [6, 8, 37]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"town\": {\n\t\t\t\t\"name\": \"乡镇\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"village\": {\n\t\t\t\t\"name\": \"村庄\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [17]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"borders\": {\n\t\t\"name\": \"行政区边界\",\n\t\t\"subType\": {\n\t\t\t\"China\": {\n\t\t\t\t\"name\": \"中国国界\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [1, 2, 9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"foreign\": {\n\t\t\t\t\"name\": \"外国国界/停火线/主张线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [3, 4, 8, 10, 11]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincial\": {\n\t\t\t\t\"name\": \"省界线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [5, 6, 7, 12]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t}\n}]");
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        if (jSONArray.length() != 0 && (optJSONObject = jSONArray.optJSONObject(0)) != null) {
            org.json.JSONArray names = optJSONObject.names();
            int length = names.length();
            int i3 = 0;
            while (i3 < length) {
                java.lang.String optString = names.optString(i3);
                org.json.JSONObject optJSONObject3 = optJSONObject.optJSONObject(optString);
                if (optJSONObject3 != null) {
                    java.lang.String optString2 = optJSONObject3.optString(str6);
                    if (optJSONObject3.has("styleMap")) {
                        a(optJSONObject3.optJSONArray("styleMap"), optString, (java.lang.String) null, optString2, this.a);
                    } else if (optJSONObject3.has(str7)) {
                        org.json.JSONObject optJSONObject4 = optJSONObject3.optJSONObject(str7);
                        if (optJSONObject4 != null) {
                            org.json.JSONArray names2 = optJSONObject4.names();
                            int length2 = names2.length();
                            int i4 = 0;
                            while (i4 < length2) {
                                java.lang.String optString3 = names2.optString(i4);
                                org.json.JSONObject optJSONObject5 = optJSONObject4.optJSONObject(optString3);
                                if (optJSONObject5 != null) {
                                    jSONObject2 = optJSONObject;
                                    java.lang.String optString4 = optJSONObject5.optString(str6);
                                    jSONArray3 = names;
                                    if (optJSONObject5.has("styleMap")) {
                                        i2 = length;
                                        a(optJSONObject5.optJSONArray("styleMap"), optString, optString3, optString2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString4, this.a);
                                    } else {
                                        i2 = length;
                                        if (optJSONObject5.has(str7) && (optJSONObject2 = optJSONObject5.optJSONObject(str7)) != null) {
                                            org.json.JSONArray names3 = optJSONObject2.names();
                                            str4 = str7;
                                            int length3 = names3.length();
                                            jSONObject3 = optJSONObject4;
                                            int i5 = 0;
                                            while (i5 < length3) {
                                                int i6 = length3;
                                                java.lang.String optString5 = names3.optString(i5);
                                                org.json.JSONArray jSONArray4 = names3;
                                                org.json.JSONObject optJSONObject6 = optJSONObject2.optJSONObject(optString5);
                                                if (optJSONObject6 != null) {
                                                    jSONObject4 = optJSONObject2;
                                                    java.lang.String optString6 = optJSONObject6.optString(str6);
                                                    if (optJSONObject6.has("styleMap")) {
                                                        str5 = str6;
                                                        a(optJSONObject6.optJSONArray("styleMap"), optString, optString3 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString5, optString2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString4 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString6, this.a);
                                                    } else {
                                                        str5 = str6;
                                                    }
                                                } else {
                                                    str5 = str6;
                                                    jSONObject4 = optJSONObject2;
                                                }
                                                i5++;
                                                length3 = i6;
                                                names3 = jSONArray4;
                                                optJSONObject2 = jSONObject4;
                                                str6 = str5;
                                            }
                                            str3 = str6;
                                            i4++;
                                            optJSONObject = jSONObject2;
                                            length = i2;
                                            names = jSONArray3;
                                            str7 = str4;
                                            optJSONObject4 = jSONObject3;
                                            str6 = str3;
                                        }
                                    }
                                    str3 = str6;
                                    str4 = str7;
                                } else {
                                    str3 = str6;
                                    str4 = str7;
                                    jSONObject2 = optJSONObject;
                                    jSONArray3 = names;
                                    i2 = length;
                                }
                                jSONObject3 = optJSONObject4;
                                i4++;
                                optJSONObject = jSONObject2;
                                length = i2;
                                names = jSONArray3;
                                str7 = str4;
                                optJSONObject4 = jSONObject3;
                                str6 = str3;
                            }
                        }
                    }
                    str = str6;
                    str2 = str7;
                    jSONObject = optJSONObject;
                    jSONArray2 = names;
                    i = length;
                    this.a.add(new com.amap.api.mapcore.util.cj(20021, d, "roads", "trafficRoadBackgroundColor", null));
                    i3++;
                    optJSONObject = jSONObject;
                    length = i;
                    names = jSONArray2;
                    str7 = str2;
                    str6 = str;
                }
                str = str6;
                str2 = str7;
                jSONObject = optJSONObject;
                jSONArray2 = names;
                i = length;
                i3++;
                optJSONObject = jSONObject;
                length = i;
                names = jSONArray2;
                str7 = str2;
                str6 = str;
            }
            return this.a;
        }
        return this.a;
    }

    public final int a() {
        return this.b;
    }

    public final com.amap.api.mapcore.util.co a(java.lang.String str, boolean z) {
        if (str == null || "".equals(str)) {
            return null;
        }
        return b(str, z);
    }

    public final com.amap.api.mapcore.util.co a(byte[] bArr, boolean z) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return b(bArr, z);
    }

    public final void a(int i) {
        this.c = i;
    }
}
