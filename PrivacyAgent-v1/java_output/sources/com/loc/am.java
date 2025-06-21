package com.loc;

/* loaded from: classes23.dex */
public final class am {
    private static final java.lang.String a = com.loc.y.c("SRFZHZUVZT3BOa0ZiemZRQQ");
    private static final java.lang.String b = com.loc.y.c("FbGJzX3Nkaw");
    private static final java.lang.String c = com.loc.y.c("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
    private static final java.lang.String d = com.loc.y.c("FQU5EU0RLMTA");
    private static final java.lang.String e = com.loc.y.c("FMTAw");
    private static boolean f = false;
    private java.lang.String g = "";

    /* renamed from: com.loc.am$1, reason: invalid class name */
    public class AnonymousClass1 implements com.loc.p.a {
        private com.loc.am a = new com.loc.am();

        @Override // com.loc.p.a
        public final com.loc.bu a(byte[] bArr, java.util.Map<java.lang.String, java.lang.String> map) {
            return new com.loc.bo(bArr, map);
        }

        @Override // com.loc.p.a
        public final java.lang.String a() {
            return com.loc.am.c();
        }

        @Override // com.loc.p.a
        public final java.lang.String a(android.content.Context context, java.lang.String str) {
            return com.loc.am.a(context, str);
        }

        @Override // com.loc.p.a
        public final java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            return this.a.a(str, str2, str3, str4);
        }

        @Override // com.loc.p.a
        public final java.util.Map<java.lang.String, java.lang.String> b() {
            return this.a.b();
        }
    }

    public static com.loc.p.a a() {
        return new com.loc.am.AnonymousClass1();
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (jSONObject.optInt(com.loc.y.c("UY29kZQ")) != 1) {
                return "";
            }
            java.lang.String optString = new org.json.JSONObject(jSONObject.optString(com.loc.y.c("FZGF0YQ"))).optString(com.loc.y.c("FYWRpdQ"));
            if (android.text.TextUtils.isEmpty(optString)) {
                return "";
            }
            com.loc.an.a(optString);
            com.loc.ai.a(context).a(optString);
            return optString;
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static java.lang.String c() {
        return com.loc.an.a();
    }

    private java.lang.String d() {
        if (!android.text.TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        java.lang.String a2 = com.loc.q.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < a2.length(); i++) {
            stringBuffer.append((char) (a2.charAt(i) - (i % 48)));
        }
        java.lang.String stringBuffer2 = stringBuffer.toString();
        java.lang.StringBuffer stringBuffer3 = new java.lang.StringBuffer();
        for (int i2 = 0; i2 < stringBuffer2.length() / 2; i2++) {
            stringBuffer3.append((char) ((stringBuffer2.charAt(i2) + stringBuffer2.charAt((stringBuffer2.length() - 1) - i2)) / 2));
        }
        java.lang.String stringBuffer4 = stringBuffer3.toString();
        this.g = stringBuffer4;
        return stringBuffer4;
    }

    public final java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.loc.y.c("LdGlk"), str);
            jSONObject.put(com.loc.y.c("FZGl1"), str2);
            jSONObject.put(com.loc.y.c("AZGl1Mg"), str3);
            jSONObject.put(com.loc.y.c("EZGl1Mw"), str4);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        java.lang.String jSONObject2 = jSONObject.toString();
        if (android.text.TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        java.lang.String a2 = com.loc.ap.a();
        if (!android.text.TextUtils.isEmpty(a2)) {
            java.lang.String a3 = com.loc.ak.a(com.loc.bl.a((jSONObject2 + "\u0000").getBytes(), a2.getBytes()));
            if (!android.text.TextUtils.isEmpty(a3)) {
                try {
                    return com.loc.y.c("Fa2V5PQ") + java.net.URLEncoder.encode(com.loc.ak.a(com.loc.ao.a(a2.getBytes("utf-8"), com.loc.ao.a(d())))) + com.loc.y.c("SJmRhdGE9") + java.net.URLEncoder.encode(a3);
                } catch (java.lang.Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    public final synchronized java.util.Map<java.lang.String, java.lang.String> b() {
        if (f) {
            return null;
        }
        f = true;
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.loc.y.c("FZW50"), com.loc.y.c("FMg"));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.loc.y.c("SY2hhbm5lbD0"));
        java.lang.String str = b;
        sb.append(str);
        sb.append(com.loc.y.c("SJmRpdj0"));
        java.lang.String str2 = d;
        sb.append(str2);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(com.loc.y.c("FQA"));
        stringBuffer.append(c);
        java.lang.String a2 = com.loc.ap.a(stringBuffer.toString());
        sb.append(com.loc.y.c("FJnNpZ249"));
        sb.append(a2.toUpperCase(java.util.Locale.US));
        sb.append(com.loc.y.c("SJm91dHB1dD1qc29u") + "\u0000");
        hashMap.put(com.loc.y.c("FaW4"), com.loc.ak.a(com.loc.bl.a(sb.toString().getBytes(), a.getBytes())));
        hashMap.put(com.loc.y.c("Sa2V5dA"), e);
        return hashMap;
    }
}
