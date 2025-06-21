package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class bz {
    public static final java.lang.String b = com.amap.api.col.s.bu.c("SRFZHZUVZT3BOa0ZiemZRQQ");
    public static final java.lang.String c = com.amap.api.col.s.bu.c("FbGJzX3Nkaw");
    public static final java.lang.String d = com.amap.api.col.s.bu.c("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
    public static final java.lang.String e = com.amap.api.col.s.bu.c("FQU5EU0RLMTA");
    public static final java.lang.String f = com.amap.api.col.s.bu.c("FMTAw");
    public static boolean g = false;
    public java.lang.String a = "";

    /* renamed from: com.amap.api.col.s.bz$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.amap.api.col.s.bm.a {
        public com.amap.api.col.s.bz a = new com.amap.api.col.s.bz();

        @Override // com.amap.api.col.s.bm.a
        public final com.amap.api.col.s.dd a(byte[] bArr, java.util.Map<java.lang.String, java.lang.String> map) {
            return new com.amap.api.col.s.cw(bArr, map);
        }

        @Override // com.amap.api.col.s.bm.a
        public final java.lang.String a() {
            return com.amap.api.col.s.bz.c();
        }

        @Override // com.amap.api.col.s.bm.a
        public final java.lang.String a(android.content.Context context, java.lang.String str) {
            return com.amap.api.col.s.bz.a(context, str);
        }

        @Override // com.amap.api.col.s.bm.a
        public final java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            return this.a.a(str, str2, str3, str4);
        }

        @Override // com.amap.api.col.s.bm.a
        public final java.util.Map<java.lang.String, java.lang.String> b() {
            return this.a.b();
        }
    }

    public static com.amap.api.col.s.bm.a a() {
        return new com.amap.api.col.s.bz.AnonymousClass1();
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (jSONObject.optInt(com.amap.api.col.s.bu.c("UY29kZQ")) != 1) {
                return "";
            }
            java.lang.String optString = new org.json.JSONObject(jSONObject.optString(com.amap.api.col.s.bu.c("FZGF0YQ"))).optString(com.amap.api.col.s.bu.c("FYWRpdQ"));
            if (android.text.TextUtils.isEmpty(optString)) {
                return "";
            }
            com.amap.api.col.s.ca.a(optString);
            com.amap.api.col.s.bv.a(context).a(optString);
            return optString;
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static java.lang.String c() {
        return com.amap.api.col.s.ca.a();
    }

    public final java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.amap.api.col.s.bu.c("LdGlk"), str);
            jSONObject.put(com.amap.api.col.s.bu.c("FZGl1"), str2);
            jSONObject.put(com.amap.api.col.s.bu.c("AZGl1Mg"), str3);
            jSONObject.put(com.amap.api.col.s.bu.c("EZGl1Mw"), str4);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        java.lang.String jSONObject2 = jSONObject.toString();
        if (android.text.TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        java.lang.String a = com.amap.api.col.s.cc.a();
        if (!android.text.TextUtils.isEmpty(a)) {
            java.lang.String a2 = com.amap.api.col.s.bx.a(com.amap.api.col.s.ct.a((jSONObject2 + "\u0000").getBytes(), a.getBytes()));
            if (!android.text.TextUtils.isEmpty(a2)) {
                try {
                    return com.amap.api.col.s.bu.c("Fa2V5PQ") + java.net.URLEncoder.encode(com.amap.api.col.s.bx.a(com.amap.api.col.s.cb.a(a.getBytes("utf-8"), com.amap.api.col.s.cb.a(d())))) + com.amap.api.col.s.bu.c("SJmRhdGE9") + java.net.URLEncoder.encode(a2);
                } catch (java.lang.Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    public final synchronized java.util.Map<java.lang.String, java.lang.String> b() {
        if (g) {
            return null;
        }
        g = true;
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.amap.api.col.s.bu.c("FZW50"), com.amap.api.col.s.bu.c("FMg"));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.amap.api.col.s.bu.c("SY2hhbm5lbD0"));
        java.lang.String str = c;
        sb.append(str);
        sb.append(com.amap.api.col.s.bu.c("SJmRpdj0"));
        java.lang.String str2 = e;
        sb.append(str2);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(com.amap.api.col.s.bu.c("FQA"));
        stringBuffer.append(d);
        java.lang.String a = com.amap.api.col.s.cc.a(stringBuffer.toString());
        sb.append(com.amap.api.col.s.bu.c("FJnNpZ249"));
        sb.append(a.toUpperCase(java.util.Locale.US));
        sb.append(com.amap.api.col.s.bu.c("SJm91dHB1dD1qc29u") + "\u0000");
        hashMap.put(com.amap.api.col.s.bu.c("FaW4"), com.amap.api.col.s.bx.a(com.amap.api.col.s.ct.a(sb.toString().getBytes(), b.getBytes())));
        hashMap.put(com.amap.api.col.s.bu.c("Sa2V5dA"), f);
        return hashMap;
    }

    public final java.lang.String d() {
        if (!android.text.TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        java.lang.String a = com.amap.api.col.s.bn.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < a.length(); i++) {
            stringBuffer.append((char) (a.charAt(i) - (i % 48)));
        }
        java.lang.String stringBuffer2 = stringBuffer.toString();
        java.lang.StringBuffer stringBuffer3 = new java.lang.StringBuffer();
        for (int i2 = 0; i2 < stringBuffer2.length() / 2; i2++) {
            stringBuffer3.append((char) ((stringBuffer2.charAt(i2) + stringBuffer2.charAt((stringBuffer2.length() - 1) - i2)) / 2));
        }
        java.lang.String stringBuffer4 = stringBuffer3.toString();
        this.a = stringBuffer4;
        return stringBuffer4;
    }
}
