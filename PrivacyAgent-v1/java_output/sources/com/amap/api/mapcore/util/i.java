package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class i extends com.amap.api.mapcore.util.en<java.lang.String, com.amap.api.mapcore.util.i.a> {
    private boolean j;
    private int[] k;

    public static class a {
        public java.lang.String b;
        public java.lang.String c;
        public int a = -1;
        public boolean d = false;
    }

    public i(android.content.Context context, java.lang.String str) {
        super(context, str);
        this.k = new int[]{10000, 0, 10018, 10019, 10020, 10021, 10022, 10023};
        ((com.amap.api.mapcore.util.en) this).h = "/feedback";
        this.isPostFlag = false;
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
    
        r2.d = true;
     */
    @Override // com.amap.api.mapcore.util.en
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.amap.api.mapcore.util.i.a a(java.lang.String str) throws com.amap.api.mapcore.util.em {
        java.lang.String str2;
        int i;
        java.lang.String str3;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (jSONObject.has("errcode")) {
                i = jSONObject.optInt("errcode");
                str2 = jSONObject.optString("errmsg");
                str3 = jSONObject.optString("errdetail");
            } else {
                str2 = "";
                i = -1;
                str3 = "";
            }
            com.amap.api.mapcore.util.i.a aVar = new com.amap.api.mapcore.util.i.a();
            aVar.a = i;
            aVar.b = str2;
            aVar.c = str3;
            int i2 = 0;
            aVar.d = false;
            int[] iArr = this.k;
            int length = iArr.length;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (iArr[i2] == i) {
                    break;
                }
                i2++;
            }
            return aVar;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.mapcore.util.en
    public final java.lang.String c() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getIPV6URL() {
        return com.amap.api.mapcore.util.dl.a(getURL());
    }

    @Override // com.amap.api.mapcore.util.cp, com.amap.api.mapcore.util.hi
    public final java.util.Map<java.lang.String, java.lang.String> getParams() {
        java.util.Hashtable hashtable = new java.util.Hashtable(16);
        hashtable.put("key", com.amap.api.mapcore.util.ev.f(((com.amap.api.mapcore.util.en) this).g));
        if (this.j) {
            hashtable.put("pname", "3dmap");
        }
        java.lang.String a2 = com.amap.api.mapcore.util.ey.a();
        java.lang.String a3 = com.amap.api.mapcore.util.ey.a(((com.amap.api.mapcore.util.en) this).g, a2, com.amap.api.mapcore.util.fi.b(hashtable));
        hashtable.put("ts", a2);
        hashtable.put("scode", a3);
        return hashtable;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getURL() {
        return "http://restsdk.amap.com/v4" + ((com.amap.api.mapcore.util.en) this).h;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final boolean isSupportIPV6() {
        return true;
    }
}
