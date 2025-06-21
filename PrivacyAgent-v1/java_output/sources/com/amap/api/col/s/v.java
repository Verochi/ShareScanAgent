package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class v extends com.amap.api.col.s.b<com.amap.api.services.nearby.UploadInfo, java.lang.Integer> {
    public android.content.Context t;
    public com.amap.api.services.nearby.UploadInfo u;

    public v(android.content.Context context, com.amap.api.services.nearby.UploadInfo uploadInfo) {
        super(context, uploadInfo);
        this.t = context;
        this.u = uploadInfo;
    }

    public static java.lang.Integer G() throws com.amap.api.services.core.AMapException {
        return 0;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ java.lang.Object a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        return G();
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final java.lang.String a_() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(com.amap.api.col.s.bi.f(this.t));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.u.getUserID());
        com.amap.api.services.core.LatLonPoint point = this.u.getPoint();
        int longitude = (int) (point.getLongitude() * 1000000.0d);
        int latitude = (int) (point.getLatitude() * 1000000.0d);
        stringBuffer.append("&location=");
        stringBuffer.append(longitude / 1000000.0f);
        stringBuffer.append(",");
        stringBuffer.append(latitude / 1000000.0f);
        stringBuffer.append("&coordtype=");
        stringBuffer.append(this.u.getCoordType());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.c() + "/nearby/data/create";
    }
}
