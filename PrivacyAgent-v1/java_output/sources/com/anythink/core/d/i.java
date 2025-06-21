package com.anythink.core.d;

/* loaded from: classes12.dex */
public final class i {
    private static final java.lang.String a = "PrePlacementStrategy";
    private java.lang.String b;

    private java.lang.String c(java.lang.String str) {
        int parseInt;
        int parseInt2;
        android.content.Context f = com.anythink.core.common.b.o.a().f();
        if (f != null && !android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(this.b)) {
            try {
                try {
                    java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(f.getResources().getAssets().open(this.b + java.io.File.separator + str + ".json")));
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    while (true) {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    org.json.JSONObject jSONObject = new org.json.JSONObject(com.anythink.core.common.o.d.b(sb.toString()));
                    if (!jSONObject.isNull("sdk_ver")) {
                        java.lang.String string = jSONObject.getString("sdk_ver");
                        if (!android.text.TextUtils.isEmpty(string) && (parseInt2 = java.lang.Integer.parseInt(com.anythink.core.common.o.h.a().replace("UA_", "").replace(".", ""))) < (parseInt = java.lang.Integer.parseInt(string.replace(".", "")))) {
                            java.lang.String.format("The sdk version(%s) must be greater than or equal to the version(%s) in the placement strategy.", java.lang.Integer.valueOf(parseInt2), java.lang.Integer.valueOf(parseInt));
                            return "";
                        }
                    }
                    if (!jSONObject.isNull("pl_id")) {
                        java.lang.String string2 = jSONObject.getString("pl_id");
                        if (!android.text.TextUtils.isEmpty(string2) && !str.equals(string2)) {
                            return "";
                        }
                    }
                    if (!jSONObject.isNull("pl_data")) {
                        return jSONObject.getJSONObject("pl_data").toString();
                    }
                } catch (java.io.IOException unused) {
                    return "";
                }
            } catch (java.lang.Exception e) {
                new java.lang.StringBuilder("Get pre placement strategy failed: ").append(e.getMessage());
            }
        }
        return "";
    }

    public final void a(java.lang.String str) {
        this.b = str;
    }

    public final com.anythink.core.d.e b(java.lang.String str) {
        java.lang.String c = c(str);
        if (android.text.TextUtils.isEmpty(c)) {
            return null;
        }
        try {
            com.anythink.core.d.e a2 = com.anythink.core.d.e.a(new org.json.JSONObject(c));
            a2.a(1);
            return a2;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
