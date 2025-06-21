package com.tanx.exposer;

/* loaded from: classes19.dex */
public class tanxc_if extends org.json.JSONObject {

    public static class tanxc_do {
        public org.json.JSONObject a;
        public org.json.JSONObject b;
        public java.lang.String c;
        public java.lang.String d;

        public com.tanx.exposer.tanxc_if.tanxc_do tanxc_do(java.lang.String str) {
            this.c = str;
            return this;
        }

        public com.tanx.exposer.tanxc_if.tanxc_do tanxc_do(org.json.JSONObject jSONObject) {
            this.a = jSONObject;
            return this;
        }

        public com.tanx.exposer.tanxc_if tanxc_do() {
            return new com.tanx.exposer.tanxc_if(this);
        }

        public com.tanx.exposer.tanxc_if.tanxc_do tanxc_if(java.lang.String str) {
            this.d = str;
            return this;
        }
    }

    public tanxc_if(com.tanx.exposer.tanxc_if.tanxc_do tanxc_doVar) {
        try {
            put("pid", tanxc_doVar.d);
            put("nameSpace", tanxc_doVar.c);
            put("macroArgs", tanxc_doVar.b);
            put("utArgs", tanxc_doVar.a);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public tanxc_if(java.lang.String str) throws org.json.JSONException {
        super(str);
    }

    public org.json.JSONObject tanxc_do() {
        return optJSONObject("utArgs");
    }

    public org.json.JSONObject tanxc_if() {
        return optJSONObject("macroArgs");
    }
}
