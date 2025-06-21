package com.anythink.core.c.b;

/* loaded from: classes12.dex */
public final class e {
    public static final double a = -1.0d;
    private static final java.lang.String b = "UserValueCalculator";
    private static final java.lang.String[] c = {"MAX", "MIN", "AVG", "SUM", me.leolin.shortcutbadger.impl.AdwHomeBadger.COUNT};
    private static final java.lang.String[] d = {com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER, ">", "<", "!=", ">=", "<="};
    private static final java.lang.String[] e = {com.sensorsdata.sf.core.utils.PropertyExpression.OR, com.sensorsdata.sf.core.utils.PropertyExpression.AND};
    private static final java.lang.String[] f = {"DESC", "ASC"};
    private final com.anythink.core.c.b.d g;

    public e(com.anythink.core.c.b.d dVar) {
        this.g = dVar;
    }

    private static org.json.JSONObject a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("f", 2);
            jSONObject.put("q_f", com.anythink.core.c.b.d.a.h);
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            jSONArray.put("type");
            jSONObject.put("w_c_f", jSONArray);
            org.json.JSONArray jSONArray2 = new org.json.JSONArray();
            jSONArray2.put(0);
            jSONObject.put("w_c_o", jSONArray2);
            org.json.JSONArray jSONArray3 = new org.json.JSONArray();
            jSONArray3.put("4");
            jSONObject.put("w_c_v", jSONArray3);
            jSONObject.put("o_f", com.anythink.core.c.b.d.a.i);
            jSONObject.put("o", 0);
            jSONObject.put("l", 3);
        } catch (org.json.JSONException e2) {
            e2.getMessage();
        }
        return jSONObject;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(34:0|1|(6:(3:118|119|(35:121|(1:5)|6|7|(2:9|(29:11|12|13|(1:116)(29:19|20|(9:23|24|25|26|(1:28)(2:40|(1:42)(1:43))|29|(2:34|35)|36|21)|109|110|111|47|48|(2:50|51)(1:106)|52|53|(1:55)|57|(1:102)(1:61)|62|(1:64)|65|(3:67|(1:69)|70)|71|(3:73|(1:75)|76)|77|(1:79)|80|81|82|83|(4:85|(2:87|(1:89))(1:93)|90|91)|94|95)|46|47|48|(0)(0)|52|53|(0)|57|(1:59)|102|62|(0)|65|(0)|71|(0)|77|(0)|80|81|82|83|(0)|94|95))|117|12|13|(0)|116|46|47|48|(0)(0)|52|53|(0)|57|(0)|102|62|(0)|65|(0)|71|(0)|77|(0)|80|81|82|83|(0)|94|95))|82|83|(0)|94|95)|3|(0)|6|7|(0)|117|12|13|(0)|116|46|47|48|(0)(0)|52|53|(0)|57|(0)|102|62|(0)|65|(0)|71|(0)|77|(0)|80|81|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x013c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0141, code lost:
    
        r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x013e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x013f, code lost:
    
        r7 = r19;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0074 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010e A[Catch: Exception -> 0x013e, TRY_LEAVE, TryCatch #1 {Exception -> 0x013e, blocks: (B:48:0x0102, B:50:0x010e), top: B:47:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0125 A[Catch: Exception -> 0x013c, TRY_LEAVE, TryCatch #2 {Exception -> 0x013c, blocks: (B:53:0x011c, B:55:0x0125), top: B:52:0x011c }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014a A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:119:0x0020, B:121:0x0026, B:5:0x0037, B:6:0x003b, B:9:0x0046, B:11:0x004b, B:12:0x0050, B:17:0x0078, B:45:0x00fa, B:57:0x0144, B:59:0x014a, B:61:0x0150, B:62:0x015d, B:64:0x0168, B:65:0x0188, B:67:0x018e, B:69:0x0194, B:70:0x0197, B:71:0x019a, B:73:0x01a0, B:75:0x01a6, B:76:0x01a9, B:77:0x01ac, B:79:0x01c9, B:80:0x01db, B:104:0x0141), top: B:118:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0037 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:119:0x0020, B:121:0x0026, B:5:0x0037, B:6:0x003b, B:9:0x0046, B:11:0x004b, B:12:0x0050, B:17:0x0078, B:45:0x00fa, B:57:0x0144, B:59:0x014a, B:61:0x0150, B:62:0x015d, B:64:0x0168, B:65:0x0188, B:67:0x018e, B:69:0x0194, B:70:0x0197, B:71:0x019a, B:73:0x01a0, B:75:0x01a6, B:76:0x01a9, B:77:0x01ac, B:79:0x01c9, B:80:0x01db, B:104:0x0141), top: B:118:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0168 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:119:0x0020, B:121:0x0026, B:5:0x0037, B:6:0x003b, B:9:0x0046, B:11:0x004b, B:12:0x0050, B:17:0x0078, B:45:0x00fa, B:57:0x0144, B:59:0x014a, B:61:0x0150, B:62:0x015d, B:64:0x0168, B:65:0x0188, B:67:0x018e, B:69:0x0194, B:70:0x0197, B:71:0x019a, B:73:0x01a0, B:75:0x01a6, B:76:0x01a9, B:77:0x01ac, B:79:0x01c9, B:80:0x01db, B:104:0x0141), top: B:118:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x018e A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:119:0x0020, B:121:0x0026, B:5:0x0037, B:6:0x003b, B:9:0x0046, B:11:0x004b, B:12:0x0050, B:17:0x0078, B:45:0x00fa, B:57:0x0144, B:59:0x014a, B:61:0x0150, B:62:0x015d, B:64:0x0168, B:65:0x0188, B:67:0x018e, B:69:0x0194, B:70:0x0197, B:71:0x019a, B:73:0x01a0, B:75:0x01a6, B:76:0x01a9, B:77:0x01ac, B:79:0x01c9, B:80:0x01db, B:104:0x0141), top: B:118:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a0 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:119:0x0020, B:121:0x0026, B:5:0x0037, B:6:0x003b, B:9:0x0046, B:11:0x004b, B:12:0x0050, B:17:0x0078, B:45:0x00fa, B:57:0x0144, B:59:0x014a, B:61:0x0150, B:62:0x015d, B:64:0x0168, B:65:0x0188, B:67:0x018e, B:69:0x0194, B:70:0x0197, B:71:0x019a, B:73:0x01a0, B:75:0x01a6, B:76:0x01a9, B:77:0x01ac, B:79:0x01c9, B:80:0x01db, B:104:0x0141), top: B:118:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c9 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:119:0x0020, B:121:0x0026, B:5:0x0037, B:6:0x003b, B:9:0x0046, B:11:0x004b, B:12:0x0050, B:17:0x0078, B:45:0x00fa, B:57:0x0144, B:59:0x014a, B:61:0x0150, B:62:0x015d, B:64:0x0168, B:65:0x0188, B:67:0x018e, B:69:0x0194, B:70:0x0197, B:71:0x019a, B:73:0x01a0, B:75:0x01a6, B:76:0x01a9, B:77:0x01ac, B:79:0x01c9, B:80:0x01db, B:104:0x0141), top: B:118:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x021a A[Catch: Exception -> 0x0237, TryCatch #3 {Exception -> 0x0237, blocks: (B:83:0x0203, B:85:0x021a, B:87:0x0220, B:89:0x0229, B:93:0x0232), top: B:82:0x0203 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0046 A[Catch: Exception -> 0x002f, TRY_ENTER, TryCatch #0 {Exception -> 0x002f, blocks: (B:119:0x0020, B:121:0x0026, B:5:0x0037, B:6:0x003b, B:9:0x0046, B:11:0x004b, B:12:0x0050, B:17:0x0078, B:45:0x00fa, B:57:0x0144, B:59:0x014a, B:61:0x0150, B:62:0x015d, B:64:0x0168, B:65:0x0188, B:67:0x018e, B:69:0x0194, B:70:0x0197, B:71:0x019a, B:73:0x01a0, B:75:0x01a6, B:76:0x01a9, B:77:0x01ac, B:79:0x01c9, B:80:0x01db, B:104:0x0141), top: B:118:0x0020 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final double a(int i, java.lang.String str) {
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObject2;
        int i2;
        java.lang.String str2;
        org.json.JSONArray optJSONArray;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String concat;
        java.lang.String sb;
        double d2;
        double d3;
        int optInt;
        int optInt2;
        com.anythink.core.d.a b2 = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
        try {
            if (b2 != null) {
                try {
                    org.json.JSONObject V = b2.V();
                    if (V != null) {
                        jSONObject = V.getJSONObject(java.lang.String.valueOf(i));
                        if (jSONObject == null) {
                            jSONObject = a();
                        }
                        jSONObject2 = jSONObject;
                        i2 = jSONObject2.getInt("f");
                        java.lang.String str6 = "";
                        if (i2 >= 0) {
                            java.lang.String[] strArr = c;
                            if (i2 < strArr.length) {
                                str2 = strArr[i2];
                                java.lang.String string = jSONObject2.getString("q_f");
                                optJSONArray = jSONObject2.optJSONArray("w_c_f");
                                org.json.JSONArray optJSONArray2 = jSONObject2.optJSONArray("w_c_o");
                                org.json.JSONArray optJSONArray3 = jSONObject2.optJSONArray("w_c_v");
                                org.json.JSONArray optJSONArray4 = jSONObject2.optJSONArray("w_o");
                                if (optJSONArray == null && optJSONArray2 != null && optJSONArray3 != null && optJSONArray.length() > 0) {
                                    try {
                                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                                        int i3 = 0;
                                        while (i3 < optJSONArray.length()) {
                                            java.lang.String string2 = optJSONArray.getString(i3);
                                            int i4 = optJSONArray2.getInt(i3);
                                            str3 = str6;
                                            try {
                                                java.lang.String string3 = optJSONArray3.getString(i3);
                                                sb2.append(string2);
                                                sb2.append(d[i4]);
                                                if (com.anythink.core.common.o.t.a((java.lang.CharSequence) string3)) {
                                                    sb2.append(string3);
                                                } else if (string3.startsWith("strftime")) {
                                                    sb2.append(string3);
                                                } else {
                                                    sb2.append("'");
                                                    sb2.append(string3);
                                                    sb2.append("'");
                                                }
                                                if (i3 != optJSONArray.length() - 1 && optJSONArray4 != null && i3 < optJSONArray4.length()) {
                                                    int i5 = optJSONArray4.getInt(i3);
                                                    sb2.append(" ");
                                                    sb2.append(e[i5]);
                                                    sb2.append(" ");
                                                }
                                                i3++;
                                                str6 = str3;
                                            } catch (java.lang.Exception e2) {
                                                e = e2;
                                                e.getMessage();
                                                str4 = str3;
                                                java.lang.String optString = jSONObject2.optString("o_f");
                                                if (!android.text.TextUtils.isEmpty(optString)) {
                                                }
                                                optInt2 = jSONObject2.optInt("o", -1);
                                                if (optInt2 != -1) {
                                                }
                                                if (jSONObject2.isNull("l")) {
                                                }
                                                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                                                if (!android.text.TextUtils.isEmpty(str4)) {
                                                }
                                                if (!android.text.TextUtils.isEmpty(str5)) {
                                                }
                                                if (!android.text.TextUtils.isEmpty(concat)) {
                                                }
                                                sb = sb3.toString();
                                                java.lang.String str7 = "SELECT " + string + " FROM user_value_placement";
                                                if (!android.text.TextUtils.isEmpty(sb)) {
                                                }
                                                double[] a2 = this.g.a(new java.lang.String[]{str2 + "(" + string + ")", "count(*)"}, "(" + str7 + ")");
                                                d2 = a2[1];
                                                if (d2 > 0.0d) {
                                                }
                                                return -1.0d;
                                            }
                                        }
                                        str3 = str6;
                                        str4 = "WHERE ".concat(java.lang.String.valueOf(sb2));
                                    } catch (java.lang.Exception e3) {
                                        e = e3;
                                        str3 = str6;
                                    }
                                    java.lang.String optString2 = jSONObject2.optString("o_f");
                                    str5 = !android.text.TextUtils.isEmpty(optString2) ? "ORDER BY ".concat(java.lang.String.valueOf(optString2)) : str3;
                                    optInt2 = jSONObject2.optInt("o", -1);
                                    if (optInt2 != -1) {
                                        str5 = str5 + " " + f[optInt2];
                                    }
                                    concat = (!jSONObject2.isNull("l") || (optInt = jSONObject2.optInt("l")) <= 0) ? str3 : "LIMIT ".concat(java.lang.String.valueOf(optInt));
                                    java.lang.StringBuilder sb32 = new java.lang.StringBuilder();
                                    if (!android.text.TextUtils.isEmpty(str4)) {
                                        sb32.append(str4);
                                        sb32.append(" ");
                                        sb32.append("AND ");
                                        sb32.append("placement_id");
                                        sb32.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                                        sb32.append("'");
                                        sb32.append(str);
                                        sb32.append("'");
                                    }
                                    if (!android.text.TextUtils.isEmpty(str5)) {
                                        if (sb32.length() > 0) {
                                            sb32.append(" ");
                                        }
                                        sb32.append(str5);
                                    }
                                    if (!android.text.TextUtils.isEmpty(concat)) {
                                        if (sb32.length() > 0) {
                                            sb32.append(" ");
                                        }
                                        sb32.append(concat);
                                    }
                                    sb = sb32.toString();
                                    java.lang.String str72 = "SELECT " + string + " FROM user_value_placement";
                                    if (!android.text.TextUtils.isEmpty(sb)) {
                                        str72 = str72 + " " + sb;
                                    }
                                    double[] a22 = this.g.a(new java.lang.String[]{str2 + "(" + string + ")", "count(*)"}, "(" + str72 + ")");
                                    d2 = a22[1];
                                    if (d2 > 0.0d) {
                                        if (jSONObject2.isNull("l")) {
                                            d3 = a22[0];
                                        } else if (d2 >= jSONObject2.optInt("l")) {
                                            d3 = a22[0];
                                        }
                                        return d3;
                                    }
                                    return -1.0d;
                                }
                                str3 = "";
                                str4 = str3;
                                java.lang.String optString22 = jSONObject2.optString("o_f");
                                if (!android.text.TextUtils.isEmpty(optString22)) {
                                }
                                optInt2 = jSONObject2.optInt("o", -1);
                                if (optInt2 != -1) {
                                }
                                if (jSONObject2.isNull("l")) {
                                }
                                java.lang.StringBuilder sb322 = new java.lang.StringBuilder();
                                if (!android.text.TextUtils.isEmpty(str4)) {
                                }
                                if (!android.text.TextUtils.isEmpty(str5)) {
                                }
                                if (!android.text.TextUtils.isEmpty(concat)) {
                                }
                                sb = sb322.toString();
                                java.lang.String str722 = "SELECT " + string + " FROM user_value_placement";
                                if (!android.text.TextUtils.isEmpty(sb)) {
                                }
                                double[] a222 = this.g.a(new java.lang.String[]{str2 + "(" + string + ")", "count(*)"}, "(" + str722 + ")");
                                d2 = a222[1];
                                if (d2 > 0.0d) {
                                }
                                return -1.0d;
                            }
                        }
                        str2 = "";
                        java.lang.String string4 = jSONObject2.getString("q_f");
                        optJSONArray = jSONObject2.optJSONArray("w_c_f");
                        org.json.JSONArray optJSONArray22 = jSONObject2.optJSONArray("w_c_o");
                        org.json.JSONArray optJSONArray32 = jSONObject2.optJSONArray("w_c_v");
                        org.json.JSONArray optJSONArray42 = jSONObject2.optJSONArray("w_o");
                        if (optJSONArray == null) {
                        }
                        str3 = "";
                        str4 = str3;
                        java.lang.String optString222 = jSONObject2.optString("o_f");
                        if (!android.text.TextUtils.isEmpty(optString222)) {
                        }
                        optInt2 = jSONObject2.optInt("o", -1);
                        if (optInt2 != -1) {
                        }
                        if (jSONObject2.isNull("l")) {
                        }
                        java.lang.StringBuilder sb3222 = new java.lang.StringBuilder();
                        if (!android.text.TextUtils.isEmpty(str4)) {
                        }
                        if (!android.text.TextUtils.isEmpty(str5)) {
                        }
                        if (!android.text.TextUtils.isEmpty(concat)) {
                        }
                        sb = sb3222.toString();
                        java.lang.String str7222 = "SELECT " + string4 + " FROM user_value_placement";
                        if (!android.text.TextUtils.isEmpty(sb)) {
                        }
                        double[] a2222 = this.g.a(new java.lang.String[]{str2 + "(" + string4 + ")", "count(*)"}, "(" + str7222 + ")");
                        d2 = a2222[1];
                        if (d2 > 0.0d) {
                        }
                        return -1.0d;
                    }
                } catch (java.lang.Exception e4) {
                    e = e4;
                    e.getMessage();
                    return -1.0d;
                }
            }
            double[] a22222 = this.g.a(new java.lang.String[]{str2 + "(" + string4 + ")", "count(*)"}, "(" + str7222 + ")");
            d2 = a22222[1];
            if (d2 > 0.0d) {
            }
            return -1.0d;
        } catch (java.lang.Exception e5) {
            e = e5;
            e.getMessage();
            return -1.0d;
        }
        jSONObject = null;
        if (jSONObject == null) {
        }
        jSONObject2 = jSONObject;
        i2 = jSONObject2.getInt("f");
        java.lang.String str62 = "";
        if (i2 >= 0) {
        }
        str2 = "";
        java.lang.String string42 = jSONObject2.getString("q_f");
        optJSONArray = jSONObject2.optJSONArray("w_c_f");
        org.json.JSONArray optJSONArray222 = jSONObject2.optJSONArray("w_c_o");
        org.json.JSONArray optJSONArray322 = jSONObject2.optJSONArray("w_c_v");
        org.json.JSONArray optJSONArray422 = jSONObject2.optJSONArray("w_o");
        if (optJSONArray == null) {
        }
        str3 = "";
        str4 = str3;
        java.lang.String optString2222 = jSONObject2.optString("o_f");
        if (!android.text.TextUtils.isEmpty(optString2222)) {
        }
        optInt2 = jSONObject2.optInt("o", -1);
        if (optInt2 != -1) {
        }
        if (jSONObject2.isNull("l")) {
        }
        java.lang.StringBuilder sb32222 = new java.lang.StringBuilder();
        if (!android.text.TextUtils.isEmpty(str4)) {
        }
        if (!android.text.TextUtils.isEmpty(str5)) {
        }
        if (!android.text.TextUtils.isEmpty(concat)) {
        }
        sb = sb32222.toString();
        java.lang.String str72222 = "SELECT " + string42 + " FROM user_value_placement";
        if (!android.text.TextUtils.isEmpty(sb)) {
        }
    }
}
