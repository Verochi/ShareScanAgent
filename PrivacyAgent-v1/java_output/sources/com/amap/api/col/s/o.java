package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class o extends com.amap.api.col.s.b<com.amap.api.services.help.InputtipsQuery, java.util.ArrayList<com.amap.api.services.help.Tip>> {
    public o(android.content.Context context, com.amap.api.services.help.InputtipsQuery inputtipsQuery) {
        super(context, inputtipsQuery);
    }

    public static java.util.ArrayList<com.amap.api.services.help.Tip> G(java.lang.String str) throws com.amap.api.services.core.AMapException {
        try {
            return com.amap.api.col.s.p.h(new org.json.JSONObject(str));
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "InputtipsHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ java.lang.Object a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        return G(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final java.lang.String a_() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("output=json");
        java.lang.String b = com.amap.api.col.s.b.b(((com.amap.api.services.help.InputtipsQuery) this.b).getKeyword());
        if (!android.text.TextUtils.isEmpty(b)) {
            stringBuffer.append("&keywords=");
            stringBuffer.append(b);
        }
        java.lang.String city = ((com.amap.api.services.help.InputtipsQuery) this.b).getCity();
        if (!com.amap.api.col.s.p.f(city)) {
            java.lang.String b2 = com.amap.api.col.s.b.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b2);
        }
        java.lang.String type = ((com.amap.api.services.help.InputtipsQuery) this.b).getType();
        if (!com.amap.api.col.s.p.f(type)) {
            java.lang.String b3 = com.amap.api.col.s.b.b(type);
            stringBuffer.append("&type=");
            stringBuffer.append(b3);
        }
        if (((com.amap.api.services.help.InputtipsQuery) this.b).getCityLimit()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        com.amap.api.services.core.LatLonPoint location = ((com.amap.api.services.help.InputtipsQuery) this.b).getLocation();
        if (location != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(location.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(location.getLatitude());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(com.amap.api.col.s.bi.f(this.e));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.a() + "/assistant/inputtips?";
    }
}
