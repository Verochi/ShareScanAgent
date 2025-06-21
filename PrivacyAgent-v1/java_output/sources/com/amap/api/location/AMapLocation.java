package com.amap.api.location;

/* loaded from: classes12.dex */
public class AMapLocation extends android.location.Location implements android.os.Parcelable, java.lang.Cloneable {
    public static final java.lang.String COORD_TYPE_GCJ02 = "GCJ02";
    public static final java.lang.String COORD_TYPE_WGS84 = "WGS84";
    public static final android.os.Parcelable.Creator<com.amap.api.location.AMapLocation> CREATOR = new com.amap.api.location.AMapLocation.AnonymousClass1();
    public static final int ERROR_CODE_AIRPLANEMODE_WIFIOFF = 18;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CELL = 11;
    public static final int ERROR_CODE_FAILURE_COARSE_LOCATION = 20;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_INIT = 9;
    public static final int ERROR_CODE_FAILURE_LOCATION = 6;
    public static final int ERROR_CODE_FAILURE_LOCATION_PARAMETER = 3;
    public static final int ERROR_CODE_FAILURE_LOCATION_PERMISSION = 12;
    public static final int ERROR_CODE_FAILURE_NOENOUGHSATELLITES = 14;
    public static final int ERROR_CODE_FAILURE_NOWIFIANDAP = 13;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_FAILURE_SIMULATION_LOCATION = 15;
    public static final int ERROR_CODE_FAILURE_WIFI_INFO = 2;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_NOCGI_WIFIOFF = 19;
    public static final int ERROR_CODE_NO_COMPENSATION_CACHE = 33;
    public static final int ERROR_CODE_SERVICE_FAIL = 10;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int GPS_ACCURACY_BAD = 0;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_UNKNOWN = -1;
    public static final int LOCATION_COMPENSATION = 10;
    public static final int LOCATION_SUCCESS = 0;
    public static final int LOCATION_TYPE_AMAP = 7;
    public static final int LOCATION_TYPE_CELL = 6;
    public static final int LOCATION_TYPE_COARSE_LOCATION = 11;
    public static final int LOCATION_TYPE_FAST = 3;
    public static final int LOCATION_TYPE_FIX_CACHE = 4;
    public static final int LOCATION_TYPE_GPS = 1;
    public static final int LOCATION_TYPE_LAST_LOCATION_CACHE = 9;
    public static final int LOCATION_TYPE_NETWORK = 12;
    public static final int LOCATION_TYPE_OFFLINE = 8;
    public static final int LOCATION_TYPE_SAME_REQ = 2;
    public static final int LOCATION_TYPE_WIFI = 5;
    public static final int TRUSTED_LEVEL_BAD = 4;
    public static final int TRUSTED_LEVEL_HIGH = 1;
    public static final int TRUSTED_LEVEL_LOW = 3;
    public static final int TRUSTED_LEVEL_NORMAL = 2;
    private int A;
    private java.lang.String B;
    private int C;
    private boolean D;
    private java.lang.String E;
    private boolean F;
    private java.lang.String G;
    private int H;
    private int I;
    protected java.lang.String a;
    protected java.lang.String b;
    com.amap.api.location.AMapLocationQualityReport c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private java.lang.String i;
    private java.lang.String j;
    private java.lang.String k;
    private java.lang.String l;
    private java.lang.String m;
    private java.lang.String n;
    private boolean o;
    private int p;
    private java.lang.String q;
    private java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    private int f114s;
    private double t;
    private double u;
    private double v;
    private float w;
    private float x;
    private android.os.Bundle y;
    private java.lang.String z;

    /* renamed from: com.amap.api.location.AMapLocation$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.location.AMapLocation> {
        private static com.amap.api.location.AMapLocation a(android.os.Parcel parcel) {
            com.amap.api.location.AMapLocation aMapLocation = new com.amap.api.location.AMapLocation((android.location.Location) android.location.Location.CREATOR.createFromParcel(parcel));
            aMapLocation.h = parcel.readString();
            aMapLocation.i = parcel.readString();
            aMapLocation.B = parcel.readString();
            aMapLocation.a = parcel.readString();
            aMapLocation.e = parcel.readString();
            aMapLocation.g = parcel.readString();
            aMapLocation.k = parcel.readString();
            aMapLocation.f = parcel.readString();
            aMapLocation.p = parcel.readInt();
            aMapLocation.q = parcel.readString();
            aMapLocation.b = parcel.readString();
            aMapLocation.F = parcel.readInt() != 0;
            aMapLocation.o = parcel.readInt() != 0;
            aMapLocation.t = parcel.readDouble();
            aMapLocation.r = parcel.readString();
            aMapLocation.f114s = parcel.readInt();
            aMapLocation.u = parcel.readDouble();
            aMapLocation.D = parcel.readInt() != 0;
            aMapLocation.n = parcel.readString();
            aMapLocation.j = parcel.readString();
            aMapLocation.d = parcel.readString();
            aMapLocation.l = parcel.readString();
            aMapLocation.A = parcel.readInt();
            aMapLocation.C = parcel.readInt();
            aMapLocation.m = parcel.readString();
            aMapLocation.E = parcel.readString();
            aMapLocation.G = parcel.readString();
            aMapLocation.H = parcel.readInt();
            aMapLocation.I = parcel.readInt();
            return aMapLocation;
        }

        private static com.amap.api.location.AMapLocation[] a(int i) {
            return new com.amap.api.location.AMapLocation[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.location.AMapLocation createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.location.AMapLocation[] newArray(int i) {
            return a(i);
        }
    }

    public AMapLocation(android.location.Location location) {
        super(location);
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = true;
        this.p = 0;
        this.q = "success";
        this.r = "";
        this.f114s = 0;
        this.t = 0.0d;
        this.u = 0.0d;
        this.v = 0.0d;
        this.w = 0.0f;
        this.x = 0.0f;
        this.y = null;
        this.A = 0;
        this.B = "";
        this.C = -1;
        this.D = false;
        this.E = "";
        this.F = false;
        this.a = "";
        this.b = "";
        this.c = new com.amap.api.location.AMapLocationQualityReport();
        this.G = "GCJ02";
        this.H = 1;
        this.t = location.getLatitude();
        this.u = location.getLongitude();
        this.v = location.getAltitude();
        this.x = location.getBearing();
        this.w = location.getSpeed();
        this.z = location.getProvider();
        this.y = location.getExtras() != null ? new android.os.Bundle(location.getExtras()) : null;
    }

    public AMapLocation(java.lang.String str) {
        super(str);
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = true;
        this.p = 0;
        this.q = "success";
        this.r = "";
        this.f114s = 0;
        this.t = 0.0d;
        this.u = 0.0d;
        this.v = 0.0d;
        this.w = 0.0f;
        this.x = 0.0f;
        this.y = null;
        this.A = 0;
        this.B = "";
        this.C = -1;
        this.D = false;
        this.E = "";
        this.F = false;
        this.a = "";
        this.b = "";
        this.c = new com.amap.api.location.AMapLocationQualityReport();
        this.G = "GCJ02";
        this.H = 1;
        this.z = str;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.amap.api.location.AMapLocation m13clone() {
        try {
            super.clone();
        } catch (java.lang.Throwable unused) {
        }
        com.amap.api.location.AMapLocation aMapLocation = new com.amap.api.location.AMapLocation(this);
        try {
            aMapLocation.setLatitude(this.t);
            aMapLocation.setLongitude(this.u);
            aMapLocation.setAdCode(this.h);
            aMapLocation.setAddress(this.i);
            aMapLocation.setAoiName(this.B);
            aMapLocation.setBuildingId(this.a);
            aMapLocation.setCity(this.e);
            aMapLocation.setCityCode(this.g);
            aMapLocation.setCountry(this.k);
            aMapLocation.setDistrict(this.f);
            aMapLocation.setErrorCode(this.p);
            aMapLocation.setErrorInfo(this.q);
            aMapLocation.setFloor(this.b);
            aMapLocation.setFixLastLocation(this.F);
            aMapLocation.setOffset(this.o);
            aMapLocation.setLocationDetail(this.r);
            aMapLocation.setLocationType(this.f114s);
            aMapLocation.setMock(this.D);
            aMapLocation.setNumber(this.n);
            aMapLocation.setPoiName(this.j);
            aMapLocation.setProvince(this.d);
            aMapLocation.setRoad(this.l);
            aMapLocation.setSatellites(this.A);
            aMapLocation.setGpsAccuracyStatus(this.C);
            aMapLocation.setStreet(this.m);
            aMapLocation.setDescription(this.E);
            aMapLocation.setExtras(getExtras());
            com.amap.api.location.AMapLocationQualityReport aMapLocationQualityReport = this.c;
            if (aMapLocationQualityReport != null) {
                aMapLocation.setLocationQualityReport(aMapLocationQualityReport.m15clone());
            }
            aMapLocation.setCoordType(this.G);
            aMapLocation.setTrustedLevel(this.H);
            aMapLocation.setConScenario(this.I);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMapLocation", "clone");
        }
        return aMapLocation;
    }

    @Override // android.location.Location, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.location.Location
    public float getAccuracy() {
        return super.getAccuracy();
    }

    public java.lang.String getAdCode() {
        return this.h;
    }

    public java.lang.String getAddress() {
        return this.i;
    }

    @Override // android.location.Location
    public double getAltitude() {
        return this.v;
    }

    public java.lang.String getAoiName() {
        return this.B;
    }

    @Override // android.location.Location
    public float getBearing() {
        return this.x;
    }

    public java.lang.String getBuildingId() {
        return this.a;
    }

    public java.lang.String getCity() {
        return this.e;
    }

    public java.lang.String getCityCode() {
        return this.g;
    }

    public int getConScenario() {
        return this.I;
    }

    public java.lang.String getCoordType() {
        return this.G;
    }

    public java.lang.String getCountry() {
        return this.k;
    }

    public java.lang.String getDescription() {
        return this.E;
    }

    public java.lang.String getDistrict() {
        return this.f;
    }

    public int getErrorCode() {
        return this.p;
    }

    public java.lang.String getErrorInfo() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.q);
        if (this.p != 0) {
            sb.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
            sb.append(",错误详细信息:" + this.r);
        }
        return sb.toString();
    }

    @Override // android.location.Location
    public android.os.Bundle getExtras() {
        return this.y;
    }

    public java.lang.String getFloor() {
        return this.b;
    }

    public int getGpsAccuracyStatus() {
        return this.C;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.t;
    }

    public java.lang.String getLocationDetail() {
        return this.r;
    }

    public com.amap.api.location.AMapLocationQualityReport getLocationQualityReport() {
        return this.c;
    }

    public int getLocationType() {
        return this.f114s;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.u;
    }

    public java.lang.String getPoiName() {
        return this.j;
    }

    @Override // android.location.Location
    public java.lang.String getProvider() {
        return this.z;
    }

    public java.lang.String getProvince() {
        return this.d;
    }

    public java.lang.String getRoad() {
        return this.l;
    }

    public int getSatellites() {
        return this.A;
    }

    @Override // android.location.Location
    public float getSpeed() {
        return this.w;
    }

    public java.lang.String getStreet() {
        return this.m;
    }

    public java.lang.String getStreetNum() {
        return this.n;
    }

    public int getTrustedLevel() {
        return this.H;
    }

    public boolean isFixLastLocation() {
        return this.F;
    }

    @Override // android.location.Location
    public boolean isMock() {
        return this.D;
    }

    public boolean isOffset() {
        return this.o;
    }

    public void setAdCode(java.lang.String str) {
        this.h = str;
    }

    public void setAddress(java.lang.String str) {
        this.i = str;
    }

    @Override // android.location.Location
    public void setAltitude(double d) {
        super.setAltitude(d);
        this.v = d;
    }

    public void setAoiName(java.lang.String str) {
        this.B = str;
    }

    @Override // android.location.Location
    public void setBearing(float f) {
        super.setBearing(f);
        while (f < 0.0f) {
            f += 360.0f;
        }
        while (f >= 360.0f) {
            f -= 360.0f;
        }
        this.x = f;
    }

    public void setBuildingId(java.lang.String str) {
        this.a = str;
    }

    public void setCity(java.lang.String str) {
        this.e = str;
    }

    public void setCityCode(java.lang.String str) {
        this.g = str;
    }

    public void setConScenario(int i) {
        this.I = i;
    }

    public void setCoordType(java.lang.String str) {
        this.G = str;
    }

    public void setCountry(java.lang.String str) {
        this.k = str;
    }

    public void setDescription(java.lang.String str) {
        this.E = str;
    }

    public void setDistrict(java.lang.String str) {
        this.f = str;
    }

    public void setErrorCode(int i) {
        if (this.p != 0) {
            return;
        }
        this.q = com.loc.gd.a(i);
        this.p = i;
    }

    public void setErrorInfo(java.lang.String str) {
        this.q = str;
    }

    @Override // android.location.Location
    public void setExtras(android.os.Bundle bundle) {
        super.setExtras(bundle);
        this.y = bundle == null ? null : new android.os.Bundle(bundle);
    }

    public void setFixLastLocation(boolean z) {
        this.F = z;
    }

    public void setFloor(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                java.lang.Integer.parseInt(str);
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "AmapLoc", "setFloor");
                str = null;
            }
        }
        this.b = str;
    }

    public void setGpsAccuracyStatus(int i) {
        this.C = i;
    }

    @Override // android.location.Location
    public void setLatitude(double d) {
        this.t = d;
    }

    public void setLocationDetail(java.lang.String str) {
        this.r = str;
    }

    public void setLocationQualityReport(com.amap.api.location.AMapLocationQualityReport aMapLocationQualityReport) {
        if (aMapLocationQualityReport == null) {
            return;
        }
        this.c = aMapLocationQualityReport;
    }

    public void setLocationType(int i) {
        this.f114s = i;
    }

    @Override // android.location.Location
    public void setLongitude(double d) {
        this.u = d;
    }

    @Override // android.location.Location
    public void setMock(boolean z) {
        this.D = z;
    }

    public void setNumber(java.lang.String str) {
        this.n = str;
    }

    public void setOffset(boolean z) {
        this.o = z;
    }

    public void setPoiName(java.lang.String str) {
        this.j = str;
    }

    @Override // android.location.Location
    public void setProvider(java.lang.String str) {
        super.setProvider(str);
        this.z = str;
    }

    public void setProvince(java.lang.String str) {
        this.d = str;
    }

    public void setRoad(java.lang.String str) {
        this.l = str;
    }

    public void setSatellites(int i) {
        this.A = i;
    }

    @Override // android.location.Location
    public void setSpeed(float f) {
        super.setSpeed(f);
        this.w = f;
    }

    public void setStreet(java.lang.String str) {
        this.m = str;
    }

    public void setTrustedLevel(int i) {
        this.H = i;
    }

    public org.json.JSONObject toJson(int i) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            if (i == 1) {
                try {
                    jSONObject.put("altitude", getAltitude());
                    jSONObject.put("speed", getSpeed());
                    jSONObject.put("bearing", getBearing());
                } catch (java.lang.Throwable unused) {
                }
                jSONObject.put("citycode", this.g);
                jSONObject.put("adcode", this.h);
                jSONObject.put("country", this.k);
                jSONObject.put(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_PROVINCE, this.d);
                jSONObject.put(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY, this.e);
                jSONObject.put(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_DISTRICT, this.f);
                jSONObject.put("road", this.l);
                jSONObject.put("street", this.m);
                jSONObject.put("number", this.n);
                jSONObject.put("poiname", this.j);
                jSONObject.put("errorCode", this.p);
                jSONObject.put(com.amap.api.maps.model.MyLocationStyle.ERROR_INFO, this.q);
                jSONObject.put(com.amap.api.maps.model.MyLocationStyle.LOCATION_TYPE, this.f114s);
                jSONObject.put("locationDetail", this.r);
                jSONObject.put("aoiname", this.B);
                jSONObject.put("address", this.i);
                jSONObject.put("poiid", this.a);
                jSONObject.put("floor", this.b);
                jSONObject.put("description", this.E);
            } else if (i != 2) {
                if (i != 3) {
                    return jSONObject;
                }
                jSONObject.put(com.umeng.analytics.pro.f.M, getProvider());
                jSONObject.put(com.anythink.core.common.h.c.C, getLongitude());
                jSONObject.put("lat", getLatitude());
                jSONObject.put("accuracy", getAccuracy());
                jSONObject.put("isOffset", this.o);
                jSONObject.put("isFixLastLocation", this.F);
                jSONObject.put("coordType", this.G);
                return jSONObject;
            }
            jSONObject.put("time", getTime());
            jSONObject.put(com.umeng.analytics.pro.f.M, getProvider());
            jSONObject.put(com.anythink.core.common.h.c.C, getLongitude());
            jSONObject.put("lat", getLatitude());
            jSONObject.put("accuracy", getAccuracy());
            jSONObject.put("isOffset", this.o);
            jSONObject.put("isFixLastLocation", this.F);
            jSONObject.put("coordType", this.G);
            return jSONObject;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    public java.lang.String toStr() {
        return toStr(1);
    }

    public java.lang.String toStr(int i) {
        org.json.JSONObject jSONObject;
        try {
            jSONObject = toJson(i);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    @Override // android.location.Location
    public java.lang.String toString() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        try {
            stringBuffer.append("latitude=" + this.t + "#");
            stringBuffer.append("longitude=" + this.u + "#");
            stringBuffer.append("province=" + this.d + "#");
            stringBuffer.append("coordType=" + this.G + "#");
            stringBuffer.append("city=" + this.e + "#");
            stringBuffer.append("district=" + this.f + "#");
            stringBuffer.append("cityCode=" + this.g + "#");
            stringBuffer.append("adCode=" + this.h + "#");
            stringBuffer.append("address=" + this.i + "#");
            stringBuffer.append("country=" + this.k + "#");
            stringBuffer.append("road=" + this.l + "#");
            stringBuffer.append("poiName=" + this.j + "#");
            stringBuffer.append("street=" + this.m + "#");
            stringBuffer.append("streetNum=" + this.n + "#");
            stringBuffer.append("aoiName=" + this.B + "#");
            stringBuffer.append("poiid=" + this.a + "#");
            stringBuffer.append("floor=" + this.b + "#");
            stringBuffer.append("errorCode=" + this.p + "#");
            stringBuffer.append("errorInfo=" + this.q + "#");
            stringBuffer.append("locationDetail=" + this.r + "#");
            stringBuffer.append("description=" + this.E + "#");
            stringBuffer.append("locationType=" + this.f114s + "#");
            java.lang.StringBuilder sb = new java.lang.StringBuilder("conScenario=");
            sb.append(this.I);
            stringBuffer.append(sb.toString());
        } catch (java.lang.Throwable unused) {
        }
        return stringBuffer.toString();
    }

    @Override // android.location.Location, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        try {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.h);
            parcel.writeString(this.i);
            parcel.writeString(this.B);
            parcel.writeString(this.a);
            parcel.writeString(this.e);
            parcel.writeString(this.g);
            parcel.writeString(this.k);
            parcel.writeString(this.f);
            parcel.writeInt(this.p);
            parcel.writeString(this.q);
            parcel.writeString(this.b);
            int i2 = 1;
            parcel.writeInt(this.F ? 1 : 0);
            parcel.writeInt(this.o ? 1 : 0);
            parcel.writeDouble(this.t);
            parcel.writeString(this.r);
            parcel.writeInt(this.f114s);
            parcel.writeDouble(this.u);
            if (!this.D) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeString(this.n);
            parcel.writeString(this.j);
            parcel.writeString(this.d);
            parcel.writeString(this.l);
            parcel.writeInt(this.A);
            parcel.writeInt(this.C);
            parcel.writeString(this.m);
            parcel.writeString(this.E);
            parcel.writeString(this.G);
            parcel.writeInt(this.H);
            parcel.writeInt(this.I);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMapLocation", "writeToParcel");
        }
    }
}
