package com.autonavi.amap.mapcore;

/* loaded from: classes12.dex */
public class Inner_3dMap_location extends android.location.Location implements java.lang.Cloneable {
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CELL = 11;
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
    public static final int ERROR_CODE_SERVICE_FAIL = 10;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int GPS_ACCURACY_BAD = 0;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_UNKNOWN = -1;
    public static final int LOCATION_SUCCESS = 0;
    public static final int LOCATION_TYPE_AMAP = 7;
    public static final int LOCATION_TYPE_CELL = 6;
    public static final int LOCATION_TYPE_FAST = 3;
    public static final int LOCATION_TYPE_FIX_CACHE = 4;
    public static final int LOCATION_TYPE_GPS = 1;
    public static final int LOCATION_TYPE_OFFLINE = 8;
    public static final int LOCATION_TYPE_SAME_REQ = 2;
    public static final int LOCATION_TYPE_WIFI = 5;
    private java.lang.String adCode;
    private java.lang.String address;
    private java.lang.String aoiName;
    protected java.lang.String buildingId;
    private java.lang.String city;
    private java.lang.String cityCode;
    private java.lang.String country;
    protected java.lang.String desc;
    private java.lang.String district;
    private int errorCode;
    private java.lang.String errorInfo;
    protected java.lang.String floor;
    private boolean isOffset;
    private double latitude;
    private java.lang.String locationDetail;
    private int locationType;
    private double longitude;
    private java.lang.String number;
    private java.lang.String poiName;
    private java.lang.String province;
    private java.lang.String road;
    private int satellites;
    private int signalIntensity;
    private java.lang.String street;

    public Inner_3dMap_location(android.location.Location location) {
        super(location);
        this.province = "";
        this.city = "";
        this.district = "";
        this.cityCode = "";
        this.adCode = "";
        this.address = "";
        this.poiName = "";
        this.country = "";
        this.road = "";
        this.street = "";
        this.number = "";
        this.isOffset = true;
        this.errorCode = 0;
        this.errorInfo = "success";
        this.locationDetail = "";
        this.locationType = 0;
        this.latitude = 0.0d;
        this.longitude = 0.0d;
        this.satellites = 0;
        this.aoiName = "";
        this.signalIntensity = -1;
        this.buildingId = "";
        this.floor = "";
        this.desc = "";
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
    }

    public Inner_3dMap_location(java.lang.String str) {
        super(str);
        this.province = "";
        this.city = "";
        this.district = "";
        this.cityCode = "";
        this.adCode = "";
        this.address = "";
        this.poiName = "";
        this.country = "";
        this.road = "";
        this.street = "";
        this.number = "";
        this.isOffset = true;
        this.errorCode = 0;
        this.errorInfo = "success";
        this.locationDetail = "";
        this.locationType = 0;
        this.latitude = 0.0d;
        this.longitude = 0.0d;
        this.satellites = 0;
        this.aoiName = "";
        this.signalIntensity = -1;
        this.buildingId = "";
        this.floor = "";
        this.desc = "";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.autonavi.amap.mapcore.Inner_3dMap_location m43clone() {
        try {
            super.clone();
        } catch (java.lang.Throwable unused) {
        }
        com.autonavi.amap.mapcore.Inner_3dMap_location inner_3dMap_location = new com.autonavi.amap.mapcore.Inner_3dMap_location(this);
        inner_3dMap_location.setProvince(this.province);
        inner_3dMap_location.setCity(this.city);
        inner_3dMap_location.setDistrict(this.district);
        inner_3dMap_location.setCityCode(this.cityCode);
        inner_3dMap_location.setAdCode(this.adCode);
        inner_3dMap_location.setAddress(this.address);
        inner_3dMap_location.setPoiName(this.poiName);
        inner_3dMap_location.setCountry(this.country);
        inner_3dMap_location.setRoad(this.road);
        inner_3dMap_location.setStreet(this.street);
        inner_3dMap_location.setNumber(this.number);
        inner_3dMap_location.setOffset(this.isOffset);
        inner_3dMap_location.setErrorCode(this.errorCode);
        inner_3dMap_location.setErrorInfo(this.errorInfo);
        inner_3dMap_location.setLocationDetail(this.locationDetail);
        inner_3dMap_location.setLocationType(this.locationType);
        inner_3dMap_location.setLatitude(this.latitude);
        inner_3dMap_location.setLongitude(this.longitude);
        inner_3dMap_location.setSatellites(this.satellites);
        inner_3dMap_location.setAoiName(this.aoiName);
        inner_3dMap_location.setBuildingId(this.buildingId);
        inner_3dMap_location.setFloor(this.floor);
        inner_3dMap_location.setGpsAccuracyStatus(this.signalIntensity);
        inner_3dMap_location.setExtras(getExtras());
        return inner_3dMap_location;
    }

    @Override // android.location.Location
    public float getAccuracy() {
        return super.getAccuracy();
    }

    public java.lang.String getAdCode() {
        return this.adCode;
    }

    public java.lang.String getAddress() {
        return this.address;
    }

    @Override // android.location.Location
    public double getAltitude() {
        return super.getAltitude();
    }

    public java.lang.String getAoiName() {
        return this.aoiName;
    }

    @Override // android.location.Location
    public float getBearing() {
        return super.getBearing();
    }

    public java.lang.String getBuildingId() {
        return this.buildingId;
    }

    public java.lang.String getCity() {
        return this.city;
    }

    public java.lang.String getCityCode() {
        return this.cityCode;
    }

    public java.lang.String getCountry() {
        return this.country;
    }

    public java.lang.String getDistrict() {
        return this.district;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public java.lang.String getErrorInfo() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.errorInfo);
        if (this.errorCode != 0) {
            sb.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
            sb.append(",错误详细信息:" + this.locationDetail);
        }
        java.lang.String sb2 = sb.toString();
        this.errorInfo = sb2;
        return sb2;
    }

    public java.lang.String getFloor() {
        return this.floor;
    }

    public int getGpsAccuracyStatus() {
        return this.signalIntensity;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.latitude;
    }

    public java.lang.String getLocationDetail() {
        return this.locationDetail;
    }

    public int getLocationType() {
        return this.locationType;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.longitude;
    }

    public java.lang.String getPoiName() {
        return this.poiName;
    }

    @Override // android.location.Location
    public java.lang.String getProvider() {
        return super.getProvider();
    }

    public java.lang.String getProvince() {
        return this.province;
    }

    public java.lang.String getRoad() {
        return this.road;
    }

    public int getSatellites() {
        return this.satellites;
    }

    @Override // android.location.Location
    public float getSpeed() {
        return super.getSpeed();
    }

    public java.lang.String getStreet() {
        return this.street;
    }

    public java.lang.String getStreetNum() {
        return this.number;
    }

    public boolean isOffset() {
        return this.isOffset;
    }

    public void setAdCode(java.lang.String str) {
        this.adCode = str;
    }

    public void setAddress(java.lang.String str) {
        this.address = str;
    }

    public void setAoiName(java.lang.String str) {
        this.aoiName = str;
    }

    public void setBuildingId(java.lang.String str) {
        this.buildingId = str;
    }

    public void setCity(java.lang.String str) {
        this.city = str;
    }

    public void setCityCode(java.lang.String str) {
        this.cityCode = str;
    }

    public void setCountry(java.lang.String str) {
        this.country = str;
    }

    public void setDistrict(java.lang.String str) {
        this.district = str;
    }

    public void setErrorCode(int i) {
        if (this.errorCode != 0) {
            return;
        }
        this.errorInfo = com.amap.api.mapcore.util.ix.b(i);
        this.errorCode = i;
    }

    public void setErrorInfo(java.lang.String str) {
        this.errorInfo = str;
    }

    public void setFloor(java.lang.String str) {
        this.floor = str;
    }

    public void setGpsAccuracyStatus(int i) {
        this.signalIntensity = i;
    }

    @Override // android.location.Location
    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLocationDetail(java.lang.String str) {
        this.locationDetail = str;
    }

    public void setLocationType(int i) {
        this.locationType = i;
    }

    @Override // android.location.Location
    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setNumber(java.lang.String str) {
        this.number = str;
    }

    public void setOffset(boolean z) {
        this.isOffset = z;
    }

    public void setPoiName(java.lang.String str) {
        this.poiName = str;
    }

    public void setProvince(java.lang.String str) {
        this.province = str;
    }

    public void setRoad(java.lang.String str) {
        this.road = str;
    }

    public void setSatellites(int i) {
        this.satellites = i;
    }

    public void setStreet(java.lang.String str) {
        this.street = str;
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
                jSONObject.put("citycode", this.cityCode);
                jSONObject.put("desc", this.desc);
                jSONObject.put("adcode", this.adCode);
                jSONObject.put("country", this.country);
                jSONObject.put(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_PROVINCE, this.province);
                jSONObject.put(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY, this.city);
                jSONObject.put(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_DISTRICT, this.district);
                jSONObject.put("road", this.road);
                jSONObject.put("street", this.street);
                jSONObject.put("number", this.number);
                jSONObject.put("poiname", this.poiName);
                jSONObject.put("errorCode", this.errorCode);
                jSONObject.put(com.amap.api.maps.model.MyLocationStyle.ERROR_INFO, this.errorInfo);
                jSONObject.put(com.amap.api.maps.model.MyLocationStyle.LOCATION_TYPE, this.locationType);
                jSONObject.put("locationDetail", this.locationDetail);
                jSONObject.put("aoiname", this.aoiName);
                jSONObject.put("address", this.address);
                jSONObject.put("poiid", this.buildingId);
                jSONObject.put("floor", this.floor);
            } else if (i != 2) {
                if (i != 3) {
                    return jSONObject;
                }
                jSONObject.put(com.umeng.analytics.pro.f.M, getProvider());
                jSONObject.put(com.anythink.core.common.h.c.C, getLongitude());
                jSONObject.put("lat", getLatitude());
                jSONObject.put("accuracy", getAccuracy());
                jSONObject.put("isOffset", this.isOffset);
                return jSONObject;
            }
            jSONObject.put("time", getTime());
            jSONObject.put(com.umeng.analytics.pro.f.M, getProvider());
            jSONObject.put(com.anythink.core.common.h.c.C, getLongitude());
            jSONObject.put("lat", getLatitude());
            jSONObject.put("accuracy", getAccuracy());
            jSONObject.put("isOffset", this.isOffset);
            return jSONObject;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "AmapLoc", "toStr");
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
            com.amap.api.mapcore.util.it.a(th, "AMapLocation", "toStr part2");
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
            stringBuffer.append("latitude=" + this.latitude + "#");
            stringBuffer.append("longitude=" + this.longitude + "#");
            stringBuffer.append("province=" + this.province + "#");
            stringBuffer.append("city=" + this.city + "#");
            stringBuffer.append("district=" + this.district + "#");
            stringBuffer.append("cityCode=" + this.cityCode + "#");
            stringBuffer.append("adCode=" + this.adCode + "#");
            stringBuffer.append("address=" + this.address + "#");
            stringBuffer.append("country=" + this.country + "#");
            stringBuffer.append("road=" + this.road + "#");
            stringBuffer.append("poiName=" + this.poiName + "#");
            stringBuffer.append("street=" + this.street + "#");
            stringBuffer.append("streetNum=" + this.number + "#");
            stringBuffer.append("aoiName=" + this.aoiName + "#");
            stringBuffer.append("poiid=" + this.buildingId + "#");
            stringBuffer.append("floor=" + this.floor + "#");
            stringBuffer.append("errorCode=" + this.errorCode + "#");
            stringBuffer.append("errorInfo=" + this.errorInfo + "#");
            stringBuffer.append("locationDetail=" + this.locationDetail + "#");
            java.lang.StringBuilder sb = new java.lang.StringBuilder("locationType=");
            sb.append(this.locationType);
            stringBuffer.append(sb.toString());
        } catch (java.lang.Throwable unused) {
        }
        return stringBuffer.toString();
    }
}
