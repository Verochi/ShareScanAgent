package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class p {
    public static java.lang.String[] a = {"010", "021", "022", "023", "1852", "1853"};

    public static void A(com.amap.api.services.route.Path path, java.util.List<com.amap.api.services.route.DriveStep> list) {
        java.util.List<com.amap.api.services.core.LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new java.util.ArrayList<>();
        }
        for (com.amap.api.services.route.DriveStep driveStep : list) {
            if (driveStep != null && driveStep.getPolyline() != null) {
                polyline.addAll(driveStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    public static void B(com.amap.api.services.route.TruckStep truckStep, org.json.JSONObject jSONObject) throws com.amap.api.services.core.AMapException {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray == null) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                com.amap.api.services.route.TMC tmc = new com.amap.api.services.route.TMC();
                org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    tmc.setDistance(P(a(optJSONObject, "distance")));
                    tmc.setStatus(a(optJSONObject, "status"));
                    tmc.setPolyline(C(optJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
            }
            truckStep.setTMCs(arrayList);
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "JSONHelper", "parseTMCs");
            throw new com.amap.api.services.core.AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static java.util.ArrayList<com.amap.api.services.core.LatLonPoint> C(org.json.JSONObject jSONObject, java.lang.String str) throws org.json.JSONException {
        if (jSONObject.has(str)) {
            return K(jSONObject.optString(str));
        }
        return null;
    }

    public static void D(com.amap.api.services.route.Path path, java.util.List<com.amap.api.services.route.RideStep> list) {
        java.util.List<com.amap.api.services.core.LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new java.util.ArrayList<>();
        }
        for (com.amap.api.services.route.RideStep rideStep : list) {
            if (rideStep != null && rideStep.getPolyline() != null) {
                polyline.addAll(rideStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    public static com.amap.api.services.poisearch.IndoorData E(org.json.JSONObject jSONObject, java.lang.String str) throws org.json.JSONException {
        java.lang.String str2;
        int i;
        java.lang.String str3;
        org.json.JSONObject optJSONObject;
        if (jSONObject.has(str) && (optJSONObject = jSONObject.optJSONObject(str)) != null && optJSONObject.has("cpid") && optJSONObject.has("floor")) {
            str2 = a(optJSONObject, "cpid");
            i = P(a(optJSONObject, "floor"));
            str3 = a(optJSONObject, "truefloor");
        } else {
            str2 = "";
            i = 0;
            str3 = "";
        }
        return new com.amap.api.services.poisearch.IndoorData(str2, i, str3);
    }

    public static com.amap.api.services.poisearch.PoiItemExtension F(org.json.JSONObject jSONObject, java.lang.String str) throws org.json.JSONException {
        java.lang.String str2;
        java.lang.String str3;
        org.json.JSONObject optJSONObject;
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            str2 = "";
            str3 = "";
        } else {
            str2 = a(optJSONObject, "open_time");
            str3 = a(optJSONObject, com.anythink.expressad.foundation.d.c.Y);
        }
        return new com.amap.api.services.poisearch.PoiItemExtension(str2, str3);
    }

    public static com.amap.api.services.poisearch.SubPoiItem G(org.json.JSONObject jSONObject) throws org.json.JSONException {
        com.amap.api.services.poisearch.SubPoiItem subPoiItem = new com.amap.api.services.poisearch.SubPoiItem(a(jSONObject, "id"), y(jSONObject, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION), a(jSONObject, "name"), a(jSONObject, "address"));
        subPoiItem.setSubName(a(jSONObject, "sname"));
        subPoiItem.setSubTypeDes(a(jSONObject, com.aliyun.svideo.downloader.FileDownloaderModel.SUBTYPE));
        if (jSONObject.has("distance")) {
            java.lang.String a2 = a(jSONObject, "distance");
            if (!f(a2)) {
                try {
                    subPoiItem.setDistance((int) java.lang.Float.parseFloat(a2));
                } catch (java.lang.NumberFormatException e) {
                    com.amap.api.col.s.i.a(e, "JSONHelper", "parseSubPoiItem");
                } catch (java.lang.Exception e2) {
                    com.amap.api.col.s.i.a(e2, "JSONHelper", "parseSubPoiItem");
                }
            }
        }
        return subPoiItem;
    }

    public static com.amap.api.services.busline.BusStationItem H(org.json.JSONObject jSONObject) throws org.json.JSONException {
        com.amap.api.services.busline.BusStationItem J = J(jSONObject);
        J.setAdCode(a(jSONObject, "adcode"));
        J.setCityCode(a(jSONObject, "citycode"));
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (optJSONArray == null) {
            J.setBusLineItems(arrayList);
            return J;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(L(optJSONObject));
            }
        }
        J.setBusLineItems(arrayList);
        return J;
    }

    public static boolean I(java.lang.String str) {
        if (str != null && str.length() > 0) {
            for (java.lang.String str2 : a) {
                if (str.trim().equals(str2.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static com.amap.api.services.busline.BusStationItem J(org.json.JSONObject jSONObject) throws org.json.JSONException {
        com.amap.api.services.busline.BusStationItem busStationItem = new com.amap.api.services.busline.BusStationItem();
        busStationItem.setBusStationId(a(jSONObject, "id"));
        busStationItem.setLatLonPoint(y(jSONObject, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION));
        busStationItem.setBusStationName(a(jSONObject, "name"));
        return busStationItem;
    }

    public static java.util.ArrayList<com.amap.api.services.core.LatLonPoint> K(java.lang.String str) {
        java.util.ArrayList<com.amap.api.services.core.LatLonPoint> arrayList = new java.util.ArrayList<>();
        for (java.lang.String str2 : str.split(com.alipay.sdk.m.u.i.b)) {
            arrayList.add(M(str2));
        }
        return arrayList;
    }

    public static com.amap.api.services.busline.BusLineItem L(org.json.JSONObject jSONObject) throws org.json.JSONException {
        com.amap.api.services.busline.BusLineItem busLineItem = new com.amap.api.services.busline.BusLineItem();
        busLineItem.setBusLineId(a(jSONObject, "id"));
        busLineItem.setBusLineType(a(jSONObject, "type"));
        busLineItem.setBusLineName(a(jSONObject, "name"));
        busLineItem.setDirectionsCoordinates(C(jSONObject, "polyline"));
        busLineItem.setCityCode(a(jSONObject, "citycode"));
        busLineItem.setOriginatingStation(a(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(a(jSONObject, "end_stop"));
        return busLineItem;
    }

    public static com.amap.api.services.core.LatLonPoint M(java.lang.String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return null;
        }
        java.lang.String[] split = str.split(",| ");
        if (split.length != 2) {
            return null;
        }
        return new com.amap.api.services.core.LatLonPoint(java.lang.Double.parseDouble(split[1]), java.lang.Double.parseDouble(split[0]));
    }

    public static com.amap.api.services.busline.BusLineItem N(org.json.JSONObject jSONObject) throws org.json.JSONException {
        com.amap.api.services.busline.BusLineItem L = L(jSONObject);
        L.setFirstBusTime(com.amap.api.col.s.i.d(a(jSONObject, "start_time")));
        L.setLastBusTime(com.amap.api.col.s.i.d(a(jSONObject, "end_time")));
        L.setBusCompany(a(jSONObject, "company"));
        L.setDistance(R(a(jSONObject, "distance")));
        L.setBasicPrice(R(a(jSONObject, "basic_price")));
        L.setTotalPrice(R(a(jSONObject, "total_price")));
        L.setBounds(C(jSONObject, "bounds"));
        java.util.ArrayList arrayList = new java.util.ArrayList();
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null) {
            L.setBusStations(arrayList);
            return L;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(J(optJSONObject));
            }
        }
        L.setBusStations(arrayList);
        return L;
    }

    public static boolean O(java.lang.String str) {
        return str == null || str.equals("") || str.equals("0");
    }

    public static int P(java.lang.String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0;
        }
        try {
            return java.lang.Integer.parseInt(str);
        } catch (java.lang.NumberFormatException e) {
            com.amap.api.col.s.i.a(e, "JSONHelper", "str2int");
            return 0;
        }
    }

    public static com.amap.api.services.district.DistrictItem Q(org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.lang.String optString;
        com.amap.api.services.district.DistrictItem districtItem = new com.amap.api.services.district.DistrictItem();
        districtItem.setCitycode(a(jSONObject, "citycode"));
        districtItem.setAdcode(a(jSONObject, "adcode"));
        districtItem.setName(a(jSONObject, "name"));
        districtItem.setLevel(a(jSONObject, com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL));
        districtItem.setCenter(y(jSONObject, "center"));
        if (jSONObject.has("polyline") && (optString = jSONObject.optString("polyline")) != null && optString.length() > 0) {
            districtItem.setDistrictBoundary(optString.split("\\|"));
        }
        a(jSONObject.optJSONArray("districts"), new java.util.ArrayList(), districtItem);
        return districtItem;
    }

    public static float R(java.lang.String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0.0f;
        }
        try {
            return java.lang.Float.parseFloat(str);
        } catch (java.lang.NumberFormatException e) {
            com.amap.api.col.s.i.a(e, "JSONHelper", "str2float");
            return 0.0f;
        }
    }

    public static java.util.List<com.amap.api.services.geocoder.BusinessArea> S(org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("businessAreas");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                com.amap.api.services.geocoder.BusinessArea businessArea = new com.amap.api.services.geocoder.BusinessArea();
                org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    businessArea.setCenterPoint(y(optJSONObject, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION));
                    businessArea.setName(a(optJSONObject, "name"));
                    arrayList.add(businessArea);
                }
            }
        }
        return arrayList;
    }

    public static double T(java.lang.String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0.0d;
        }
        try {
            return java.lang.Double.parseDouble(str);
        } catch (java.lang.NumberFormatException e) {
            com.amap.api.col.s.i.a(e, "JSONHelper", "str2float");
            return 0.0d;
        }
    }

    public static com.amap.api.services.route.BusStep U(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject == null) {
            return null;
        }
        com.amap.api.services.route.BusStep busStep = new com.amap.api.services.route.BusStep();
        org.json.JSONObject optJSONObject = jSONObject.optJSONObject("walking");
        if (optJSONObject != null) {
            busStep.setWalk(W(optJSONObject));
        }
        org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject("bus");
        if (optJSONObject2 != null) {
            busStep.setBusLines(X(optJSONObject2));
        }
        org.json.JSONObject optJSONObject3 = jSONObject.optJSONObject(com.aliyun.svideo.base.AlivcSvideoEditParam.INTENT_PARAM_KEY_ENTRANCE);
        if (optJSONObject3 != null) {
            busStep.setEntrance(Z(optJSONObject3));
        }
        org.json.JSONObject optJSONObject4 = jSONObject.optJSONObject(com.alipay.sdk.m.x.d.z);
        if (optJSONObject4 != null) {
            busStep.setExit(Z(optJSONObject4));
        }
        org.json.JSONObject optJSONObject5 = jSONObject.optJSONObject("railway");
        if (optJSONObject5 != null) {
            busStep.setRailway(e0(optJSONObject5));
        }
        org.json.JSONObject optJSONObject6 = jSONObject.optJSONObject("taxi");
        if (optJSONObject6 != null) {
            busStep.setTaxi(n(optJSONObject6));
        }
        if ((busStep.getWalk() == null || busStep.getWalk().getSteps().size() == 0) && busStep.getBusLines().size() == 0 && busStep.getRailway() == null && busStep.getTaxi() == null) {
            return null;
        }
        return busStep;
    }

    public static long V(java.lang.String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0L;
        }
        try {
            return java.lang.Long.parseLong(str);
        } catch (java.lang.NumberFormatException e) {
            com.amap.api.col.s.i.a(e, "JSONHelper", "str2long");
            return 0L;
        }
    }

    public static com.amap.api.services.route.RouteBusWalkItem W(org.json.JSONObject jSONObject) throws org.json.JSONException {
        org.json.JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        com.amap.api.services.route.RouteBusWalkItem routeBusWalkItem = new com.amap.api.services.route.RouteBusWalkItem();
        routeBusWalkItem.setOrigin(y(jSONObject, "origin"));
        routeBusWalkItem.setDestination(y(jSONObject, "destination"));
        routeBusWalkItem.setDistance(R(a(jSONObject, "distance")));
        routeBusWalkItem.setDuration(V(a(jSONObject, "duration")));
        if (!jSONObject.has("steps") || (optJSONArray = jSONObject.optJSONArray("steps")) == null) {
            return routeBusWalkItem;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(a0(optJSONObject));
            }
        }
        routeBusWalkItem.setSteps(arrayList);
        v(routeBusWalkItem, arrayList);
        return routeBusWalkItem;
    }

    public static java.util.List<com.amap.api.services.route.RouteBusLineItem> X(org.json.JSONObject jSONObject) throws org.json.JSONException {
        org.json.JSONArray optJSONArray;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("buslines")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(b0(optJSONObject));
            }
        }
        return arrayList;
    }

    public static boolean Y(java.lang.String str) {
        return (str == null || str.equals("") || str.equals("[]") || str.equals("0") || !str.equals("1")) ? false : true;
    }

    public static com.amap.api.services.route.Doorway Z(org.json.JSONObject jSONObject) throws org.json.JSONException {
        com.amap.api.services.route.Doorway doorway = new com.amap.api.services.route.Doorway();
        doorway.setName(a(jSONObject, "name"));
        doorway.setLatLonPoint(y(jSONObject, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION));
        return doorway;
    }

    public static com.amap.api.services.route.BusRouteResult a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        org.json.JSONArray optJSONArray;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            com.amap.api.services.route.BusRouteResult busRouteResult = new com.amap.api.services.route.BusRouteResult();
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject == null) {
                return busRouteResult;
            }
            busRouteResult.setStartPos(y(optJSONObject, "origin"));
            busRouteResult.setTargetPos(y(optJSONObject, "destination"));
            busRouteResult.setTaxiCost(R(a(optJSONObject, "taxi_cost")));
            if (!optJSONObject.has("transits") || (optJSONArray = optJSONObject.optJSONArray("transits")) == null) {
                return busRouteResult;
            }
            busRouteResult.setPaths(r(optJSONArray));
            return busRouteResult;
        } catch (org.json.JSONException unused) {
            throw new com.amap.api.services.core.AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static java.lang.String a(org.json.JSONObject jSONObject, java.lang.String str) throws org.json.JSONException {
        return (jSONObject == null || !jSONObject.has(str) || jSONObject.optString(str).equals("[]")) ? "" : jSONObject.optString(str).trim();
    }

    public static java.util.ArrayList<com.amap.api.services.core.SuggestionCity> a(org.json.JSONObject jSONObject) throws org.json.JSONException, java.lang.NumberFormatException {
        org.json.JSONArray optJSONArray;
        java.util.ArrayList<com.amap.api.services.core.SuggestionCity> arrayList = new java.util.ArrayList<>();
        if (!jSONObject.has("cities") || (optJSONArray = jSONObject.optJSONArray("cities")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new com.amap.api.services.core.SuggestionCity(a(optJSONObject, "name"), a(optJSONObject, "citycode"), a(optJSONObject, "adcode"), P(a(optJSONObject, "num"))));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.ArrayList<com.amap.api.services.nearby.NearbyInfo> a(org.json.JSONObject jSONObject, boolean z) throws org.json.JSONException {
        double d;
        double d2;
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("datas");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return new java.util.ArrayList<>();
        }
        java.util.ArrayList<com.amap.api.services.nearby.NearbyInfo> arrayList = new java.util.ArrayList<>();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            java.lang.String a2 = a(optJSONObject, "userid");
            java.lang.String a3 = a(optJSONObject, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
            if (a3 != null) {
                java.lang.String[] split = a3.split(",");
                if (split.length == 2) {
                    d = T(split[0]);
                    d2 = T(split[1]);
                    java.lang.String a4 = a(optJSONObject, "distance");
                    long V = V(a(optJSONObject, "updatetime"));
                    int P = P(a4);
                    com.amap.api.services.core.LatLonPoint latLonPoint = new com.amap.api.services.core.LatLonPoint(d2, d);
                    com.amap.api.services.nearby.NearbyInfo nearbyInfo = new com.amap.api.services.nearby.NearbyInfo();
                    nearbyInfo.setUserID(a2);
                    nearbyInfo.setTimeStamp(V);
                    nearbyInfo.setPoint(latLonPoint);
                    if (z) {
                        nearbyInfo.setDistance(P);
                    } else {
                        nearbyInfo.setDrivingDistance(P);
                    }
                    arrayList.add(nearbyInfo);
                }
            }
            d = 0.0d;
            d2 = 0.0d;
            java.lang.String a42 = a(optJSONObject, "distance");
            long V2 = V(a(optJSONObject, "updatetime"));
            int P2 = P(a42);
            com.amap.api.services.core.LatLonPoint latLonPoint2 = new com.amap.api.services.core.LatLonPoint(d2, d);
            com.amap.api.services.nearby.NearbyInfo nearbyInfo2 = new com.amap.api.services.nearby.NearbyInfo();
            nearbyInfo2.setUserID(a2);
            nearbyInfo2.setTimeStamp(V2);
            nearbyInfo2.setPoint(latLonPoint2);
            if (z) {
            }
            arrayList.add(nearbyInfo2);
        }
        return arrayList;
    }

    public static void a(org.json.JSONArray jSONArray, com.amap.api.services.geocoder.RegeocodeAddress regeocodeAddress) throws org.json.JSONException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            com.amap.api.services.road.Crossroad crossroad = new com.amap.api.services.road.Crossroad();
            org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                crossroad.setId(a(optJSONObject, "id"));
                crossroad.setDirection(a(optJSONObject, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
                crossroad.setDistance(R(a(optJSONObject, "distance")));
                crossroad.setCenterPoint(y(optJSONObject, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION));
                crossroad.setFirstRoadId(a(optJSONObject, "first_id"));
                crossroad.setFirstRoadName(a(optJSONObject, "first_name"));
                crossroad.setSecondRoadId(a(optJSONObject, "second_id"));
                crossroad.setSecondRoadName(a(optJSONObject, "second_name"));
                arrayList.add(crossroad);
            }
        }
        regeocodeAddress.setCrossroads(arrayList);
    }

    public static void a(org.json.JSONArray jSONArray, java.util.ArrayList<com.amap.api.services.district.DistrictItem> arrayList, com.amap.api.services.district.DistrictItem districtItem) throws org.json.JSONException {
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(Q(optJSONObject));
            }
        }
        if (districtItem != null) {
            districtItem.setSubDistrict(arrayList);
        }
    }

    public static void a(org.json.JSONObject jSONObject, com.amap.api.services.geocoder.RegeocodeAddress regeocodeAddress) throws org.json.JSONException {
        regeocodeAddress.setCountry(a(jSONObject, "country"));
        regeocodeAddress.setCountryCode(a(jSONObject, "countrycode"));
        regeocodeAddress.setProvince(a(jSONObject, com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_PROVINCE));
        regeocodeAddress.setCity(a(jSONObject, com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY));
        regeocodeAddress.setCityCode(a(jSONObject, "citycode"));
        regeocodeAddress.setAdCode(a(jSONObject, "adcode"));
        regeocodeAddress.setDistrict(a(jSONObject, com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_DISTRICT));
        regeocodeAddress.setTownship(a(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(a(jSONObject.optJSONObject("neighborhood"), "name"));
        regeocodeAddress.setBuilding(a(jSONObject.optJSONObject("building"), "name"));
        com.amap.api.services.geocoder.StreetNumber streetNumber = new com.amap.api.services.geocoder.StreetNumber();
        org.json.JSONObject optJSONObject = jSONObject.optJSONObject("streetNumber");
        streetNumber.setStreet(a(optJSONObject, "street"));
        streetNumber.setNumber(a(optJSONObject, "number"));
        streetNumber.setLatLonPoint(y(optJSONObject, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION));
        streetNumber.setDirection(a(optJSONObject, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
        streetNumber.setDistance(R(a(optJSONObject, "distance")));
        regeocodeAddress.setStreetNumber(streetNumber);
        regeocodeAddress.setBusinessAreas(S(jSONObject));
        regeocodeAddress.setTowncode(a(jSONObject, "towncode"));
        t(regeocodeAddress);
    }

    public static com.amap.api.services.route.WalkStep a0(org.json.JSONObject jSONObject) throws org.json.JSONException {
        com.amap.api.services.route.WalkStep walkStep = new com.amap.api.services.route.WalkStep();
        walkStep.setInstruction(a(jSONObject, "instruction"));
        walkStep.setOrientation(a(jSONObject, "orientation"));
        walkStep.setRoad(a(jSONObject, "road"));
        walkStep.setDistance(R(a(jSONObject, "distance")));
        walkStep.setDuration(R(a(jSONObject, "duration")));
        walkStep.setPolyline(C(jSONObject, "polyline"));
        walkStep.setAction(a(jSONObject, "action"));
        walkStep.setAssistantAction(a(jSONObject, "assistant_action"));
        return walkStep;
    }

    public static com.amap.api.services.route.DriveRouteResult b(java.lang.String str) throws com.amap.api.services.core.AMapException {
        org.json.JSONArray optJSONArray;
        org.json.JSONArray jSONArray;
        org.json.JSONArray jSONArray2;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            com.amap.api.services.route.DriveRouteResult driveRouteResult = new com.amap.api.services.route.DriveRouteResult();
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject == null) {
                return driveRouteResult;
            }
            driveRouteResult.setStartPos(y(optJSONObject, "origin"));
            driveRouteResult.setTargetPos(y(optJSONObject, "destination"));
            driveRouteResult.setTaxiCost(R(a(optJSONObject, "taxi_cost")));
            if (!optJSONObject.has("paths") || (optJSONArray = optJSONObject.optJSONArray("paths")) == null) {
                return driveRouteResult;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int i = 0;
            while (i < optJSONArray.length()) {
                com.amap.api.services.route.DrivePath drivePath = new com.amap.api.services.route.DrivePath();
                org.json.JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    drivePath.setDistance(R(a(optJSONObject2, "distance")));
                    drivePath.setDuration(V(a(optJSONObject2, "duration")));
                    drivePath.setStrategy(a(optJSONObject2, "strategy"));
                    drivePath.setTolls(R(a(optJSONObject2, "tolls")));
                    drivePath.setTollDistance(R(a(optJSONObject2, "toll_distance")));
                    drivePath.setTotalTrafficlights(P(a(optJSONObject2, "traffic_lights")));
                    drivePath.setRestriction(P(a(optJSONObject2, "restriction")));
                    org.json.JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                    if (optJSONArray2 != null) {
                        java.util.ArrayList arrayList2 = new java.util.ArrayList();
                        int i2 = 0;
                        while (i2 < optJSONArray2.length()) {
                            com.amap.api.services.route.DriveStep driveStep = new com.amap.api.services.route.DriveStep();
                            org.json.JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                            if (optJSONObject3 != null) {
                                jSONArray2 = optJSONArray;
                                driveStep.setInstruction(a(optJSONObject3, "instruction"));
                                driveStep.setOrientation(a(optJSONObject3, "orientation"));
                                driveStep.setRoad(a(optJSONObject3, "road"));
                                driveStep.setDistance(R(a(optJSONObject3, "distance")));
                                driveStep.setTolls(R(a(optJSONObject3, "tolls")));
                                driveStep.setTollDistance(R(a(optJSONObject3, "toll_distance")));
                                driveStep.setTollRoad(a(optJSONObject3, "toll_road"));
                                driveStep.setDuration(R(a(optJSONObject3, "duration")));
                                driveStep.setPolyline(C(optJSONObject3, "polyline"));
                                driveStep.setAction(a(optJSONObject3, "action"));
                                driveStep.setAssistantAction(a(optJSONObject3, "assistant_action"));
                                z(driveStep, optJSONObject3);
                                u(driveStep, optJSONObject3);
                                arrayList2.add(driveStep);
                            } else {
                                jSONArray2 = optJSONArray;
                            }
                            i2++;
                            optJSONArray = jSONArray2;
                        }
                        jSONArray = optJSONArray;
                        drivePath.setSteps(arrayList2);
                        A(drivePath, arrayList2);
                        arrayList.add(drivePath);
                        i++;
                        optJSONArray = jSONArray;
                    }
                }
                jSONArray = optJSONArray;
                i++;
                optJSONArray = jSONArray;
            }
            driveRouteResult.setPaths(arrayList);
            return driveRouteResult;
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "JSONHelper", "parseDriveRoute");
            throw new com.amap.api.services.core.AMapException("协议解析错误 - ProtocolException");
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new com.amap.api.services.core.AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static java.util.ArrayList<java.lang.String> b(org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.optString(i));
        }
        return arrayList;
    }

    public static void b(org.json.JSONArray jSONArray, com.amap.api.services.geocoder.RegeocodeAddress regeocodeAddress) throws org.json.JSONException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            com.amap.api.services.geocoder.RegeocodeRoad regeocodeRoad = new com.amap.api.services.geocoder.RegeocodeRoad();
            org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                regeocodeRoad.setId(a(optJSONObject, "id"));
                regeocodeRoad.setName(a(optJSONObject, "name"));
                regeocodeRoad.setLatLngPoint(y(optJSONObject, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION));
                regeocodeRoad.setDirection(a(optJSONObject, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
                regeocodeRoad.setDistance(R(a(optJSONObject, "distance")));
                arrayList.add(regeocodeRoad);
            }
        }
        regeocodeAddress.setRoads(arrayList);
    }

    public static com.amap.api.services.route.RouteBusLineItem b0(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject == null) {
            return null;
        }
        com.amap.api.services.route.RouteBusLineItem routeBusLineItem = new com.amap.api.services.route.RouteBusLineItem();
        routeBusLineItem.setDepartureBusStation(d0(jSONObject.optJSONObject("departure_stop")));
        routeBusLineItem.setArrivalBusStation(d0(jSONObject.optJSONObject("arrival_stop")));
        routeBusLineItem.setBusLineName(a(jSONObject, "name"));
        routeBusLineItem.setBusLineId(a(jSONObject, "id"));
        routeBusLineItem.setBusLineType(a(jSONObject, "type"));
        routeBusLineItem.setDistance(R(a(jSONObject, "distance")));
        routeBusLineItem.setDuration(R(a(jSONObject, "duration")));
        routeBusLineItem.setPolyline(C(jSONObject, "polyline"));
        routeBusLineItem.setFirstBusTime(com.amap.api.col.s.i.d(a(jSONObject, "start_time")));
        routeBusLineItem.setLastBusTime(com.amap.api.col.s.i.d(a(jSONObject, "end_time")));
        routeBusLineItem.setPassStationNum(P(a(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(c0(jSONObject));
        return routeBusLineItem;
    }

    public static com.amap.api.services.route.WalkRouteResult c(java.lang.String str) throws com.amap.api.services.core.AMapException {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            com.amap.api.services.route.WalkRouteResult walkRouteResult = new com.amap.api.services.route.WalkRouteResult();
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("route");
            walkRouteResult.setStartPos(y(optJSONObject, "origin"));
            walkRouteResult.setTargetPos(y(optJSONObject, "destination"));
            if (!optJSONObject.has("paths")) {
                return walkRouteResult;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            org.json.JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
            if (optJSONArray == null) {
                walkRouteResult.setPaths(arrayList);
                return walkRouteResult;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                com.amap.api.services.route.WalkPath walkPath = new com.amap.api.services.route.WalkPath();
                org.json.JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    walkPath.setDistance(R(a(optJSONObject2, "distance")));
                    walkPath.setDuration(V(a(optJSONObject2, "duration")));
                    if (optJSONObject2.has("steps")) {
                        org.json.JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                        java.util.ArrayList arrayList2 = new java.util.ArrayList();
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                com.amap.api.services.route.WalkStep walkStep = new com.amap.api.services.route.WalkStep();
                                org.json.JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                                if (optJSONObject3 != null) {
                                    walkStep.setInstruction(a(optJSONObject3, "instruction"));
                                    walkStep.setOrientation(a(optJSONObject3, "orientation"));
                                    walkStep.setRoad(a(optJSONObject3, "road"));
                                    walkStep.setDistance(R(a(optJSONObject3, "distance")));
                                    walkStep.setDuration(R(a(optJSONObject3, "duration")));
                                    walkStep.setPolyline(C(optJSONObject3, "polyline"));
                                    walkStep.setAction(a(optJSONObject3, "action"));
                                    walkStep.setAssistantAction(a(optJSONObject3, "assistant_action"));
                                    arrayList2.add(walkStep);
                                }
                            }
                            walkPath.setSteps(arrayList2);
                            v(walkPath, arrayList2);
                        }
                    }
                    arrayList.add(walkPath);
                }
            }
            walkRouteResult.setPaths(arrayList);
            return walkRouteResult;
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "JSONHelper", "parseWalkRoute");
            throw new com.amap.api.services.core.AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static java.util.ArrayList<com.amap.api.services.core.PoiItem> c(org.json.JSONObject jSONObject) throws org.json.JSONException {
        org.json.JSONArray optJSONArray;
        java.util.ArrayList<com.amap.api.services.core.PoiItem> arrayList = new java.util.ArrayList<>();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("pois")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(d(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static void c(org.json.JSONArray jSONArray, com.amap.api.services.geocoder.RegeocodeAddress regeocodeAddress) throws org.json.JSONException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            com.amap.api.services.geocoder.AoiItem aoiItem = new com.amap.api.services.geocoder.AoiItem();
            org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                aoiItem.setId(a(optJSONObject, "id"));
                aoiItem.setName(a(optJSONObject, "name"));
                aoiItem.setAdcode(a(optJSONObject, "adcode"));
                aoiItem.setLocation(y(optJSONObject, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION));
                aoiItem.setArea(java.lang.Float.valueOf(R(a(optJSONObject, "area"))));
                arrayList.add(aoiItem);
            }
        }
        regeocodeAddress.setAois(arrayList);
    }

    public static java.util.List<com.amap.api.services.busline.BusStationItem> c0(org.json.JSONObject jSONObject) throws org.json.JSONException {
        org.json.JSONArray optJSONArray;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("via_stops")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(d0(optJSONObject));
            }
        }
        return arrayList;
    }

    public static com.amap.api.services.core.PoiItem d(org.json.JSONObject jSONObject) throws org.json.JSONException {
        com.amap.api.services.core.PoiItem poiItem = new com.amap.api.services.core.PoiItem(a(jSONObject, "id"), y(jSONObject, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION), a(jSONObject, "name"), a(jSONObject, "address"));
        poiItem.setAdCode(a(jSONObject, "adcode"));
        poiItem.setProvinceName(a(jSONObject, "pname"));
        poiItem.setCityName(a(jSONObject, "cityname"));
        poiItem.setAdName(a(jSONObject, "adname"));
        poiItem.setCityCode(a(jSONObject, "citycode"));
        poiItem.setProvinceCode(a(jSONObject, "pcode"));
        poiItem.setDirection(a(jSONObject, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
        if (jSONObject.has("distance")) {
            java.lang.String a2 = a(jSONObject, "distance");
            if (!f(a2)) {
                try {
                    poiItem.setDistance((int) java.lang.Float.parseFloat(a2));
                } catch (java.lang.NumberFormatException e) {
                    com.amap.api.col.s.i.a(e, "JSONHelper", "parseBasePoi");
                } catch (java.lang.Exception e2) {
                    com.amap.api.col.s.i.a(e2, "JSONHelper", "parseBasePoi");
                }
            }
        }
        poiItem.setTel(a(jSONObject, com.sensorsdata.sf.ui.view.UIProperty.action_type_tel));
        poiItem.setTypeDes(a(jSONObject, "type"));
        poiItem.setEnter(y(jSONObject, "entr_location"));
        poiItem.setExit(y(jSONObject, "exit_location"));
        poiItem.setWebsite(a(jSONObject, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_WEBSITE));
        poiItem.setPostcode(a(jSONObject, "postcode"));
        java.lang.String a3 = a(jSONObject, "business_area");
        if (f(a3)) {
            a3 = a(jSONObject, "businessarea");
        }
        poiItem.setBusinessArea(a3);
        poiItem.setEmail(a(jSONObject, "email"));
        if (O(a(jSONObject, "indoor_map"))) {
            poiItem.setIndoorMap(false);
        } else {
            poiItem.setIndoorMap(true);
        }
        poiItem.setParkingType(a(jSONObject, "parking_type"));
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONObject.has("children")) {
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        arrayList.add(G(optJSONObject));
                    }
                }
            }
            poiItem.setSubPois(arrayList);
        }
        poiItem.setIndoorDate(E(jSONObject, "indoor_data"));
        poiItem.setPoiExtension(F(jSONObject, "biz_ext"));
        poiItem.setTypeCode(a(jSONObject, "typecode"));
        poiItem.setShopID(a(jSONObject, "shopid"));
        s(poiItem, jSONObject);
        return poiItem;
    }

    public static com.amap.api.services.weather.LocalWeatherLive d(java.lang.String str) throws com.amap.api.services.core.AMapException {
        org.json.JSONObject optJSONObject;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (!jSONObject.has("lives")) {
                return null;
            }
            com.amap.api.services.weather.LocalWeatherLive localWeatherLive = new com.amap.api.services.weather.LocalWeatherLive();
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray("lives");
            if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                return localWeatherLive;
            }
            localWeatherLive.setAdCode(a(optJSONObject, "adcode"));
            localWeatherLive.setProvince(a(optJSONObject, com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_PROVINCE));
            localWeatherLive.setCity(a(optJSONObject, com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY));
            localWeatherLive.setWeather(a(optJSONObject, "weather"));
            localWeatherLive.setTemperature(a(optJSONObject, "temperature"));
            localWeatherLive.setWindDirection(a(optJSONObject, "winddirection"));
            localWeatherLive.setWindPower(a(optJSONObject, "windpower"));
            localWeatherLive.setHumidity(a(optJSONObject, "humidity"));
            localWeatherLive.setReportTime(a(optJSONObject, "reporttime"));
            return localWeatherLive;
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "JSONHelper", "WeatherForecastResult");
            throw new com.amap.api.services.core.AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static com.amap.api.services.busline.BusStationItem d0(org.json.JSONObject jSONObject) throws org.json.JSONException {
        com.amap.api.services.busline.BusStationItem busStationItem = new com.amap.api.services.busline.BusStationItem();
        busStationItem.setBusStationName(a(jSONObject, "name"));
        busStationItem.setBusStationId(a(jSONObject, "id"));
        busStationItem.setLatLonPoint(y(jSONObject, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION));
        return busStationItem;
    }

    public static com.amap.api.services.weather.LocalWeatherForecast e(java.lang.String str) throws com.amap.api.services.core.AMapException {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (!jSONObject.has("forecasts")) {
                return null;
            }
            com.amap.api.services.weather.LocalWeatherForecast localWeatherForecast = new com.amap.api.services.weather.LocalWeatherForecast();
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("forecasts");
            if (jSONArray != null && jSONArray.length() > 0) {
                org.json.JSONObject optJSONObject = jSONArray.optJSONObject(0);
                if (optJSONObject == null) {
                    return localWeatherForecast;
                }
                localWeatherForecast.setCity(a(optJSONObject, com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY));
                localWeatherForecast.setAdCode(a(optJSONObject, "adcode"));
                localWeatherForecast.setProvince(a(optJSONObject, com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_PROVINCE));
                localWeatherForecast.setReportTime(a(optJSONObject, "reporttime"));
                if (!optJSONObject.has("casts")) {
                    return localWeatherForecast;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                org.json.JSONArray optJSONArray = optJSONObject.optJSONArray("casts");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        com.amap.api.services.weather.LocalDayWeatherForecast localDayWeatherForecast = new com.amap.api.services.weather.LocalDayWeatherForecast();
                        org.json.JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            localDayWeatherForecast.setDate(a(optJSONObject2, "date"));
                            localDayWeatherForecast.setWeek(a(optJSONObject2, org.apache.tools.ant.taskdefs.WaitFor.Unit.WEEK));
                            localDayWeatherForecast.setDayWeather(a(optJSONObject2, "dayweather"));
                            localDayWeatherForecast.setNightWeather(a(optJSONObject2, "nightweather"));
                            localDayWeatherForecast.setDayTemp(a(optJSONObject2, "daytemp"));
                            localDayWeatherForecast.setNightTemp(a(optJSONObject2, "nighttemp"));
                            localDayWeatherForecast.setDayWindDirection(a(optJSONObject2, "daywind"));
                            localDayWeatherForecast.setNightWindDirection(a(optJSONObject2, "nightwind"));
                            localDayWeatherForecast.setDayWindPower(a(optJSONObject2, "daypower"));
                            localDayWeatherForecast.setNightWindPower(a(optJSONObject2, "nightpower"));
                            arrayList.add(localDayWeatherForecast);
                        }
                    }
                    localWeatherForecast.setWeatherForecast(arrayList);
                    return localWeatherForecast;
                }
                localWeatherForecast.setWeatherForecast(arrayList);
            }
            return localWeatherForecast;
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "JSONHelper", "WeatherForecastResult");
            throw new com.amap.api.services.core.AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static java.util.ArrayList<com.amap.api.services.busline.BusStationItem> e(org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.util.ArrayList<com.amap.api.services.busline.BusStationItem> arrayList = new java.util.ArrayList<>();
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(H(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static com.amap.api.services.route.RouteRailwayItem e0(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject == null || !jSONObject.has("id") || !jSONObject.has("name")) {
            return null;
        }
        com.amap.api.services.route.RouteRailwayItem routeRailwayItem = new com.amap.api.services.route.RouteRailwayItem();
        routeRailwayItem.setID(a(jSONObject, "id"));
        routeRailwayItem.setName(a(jSONObject, "name"));
        routeRailwayItem.setTime(a(jSONObject, "time"));
        routeRailwayItem.setTrip(a(jSONObject, "trip"));
        routeRailwayItem.setDistance(R(a(jSONObject, "distance")));
        routeRailwayItem.setType(a(jSONObject, "type"));
        routeRailwayItem.setDeparturestop(f0(jSONObject.optJSONObject("departure_stop")));
        routeRailwayItem.setArrivalstop(f0(jSONObject.optJSONObject("arrival_stop")));
        routeRailwayItem.setViastops(j(jSONObject));
        routeRailwayItem.setAlters(k(jSONObject));
        routeRailwayItem.setSpaces(l(jSONObject));
        return routeRailwayItem;
    }

    public static java.util.ArrayList<com.amap.api.services.busline.BusLineItem> f(org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.util.ArrayList<com.amap.api.services.busline.BusLineItem> arrayList = new java.util.ArrayList<>();
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(N(optJSONObject));
            }
        }
        return arrayList;
    }

    public static boolean f(java.lang.String str) {
        return str == null || str.equals("");
    }

    public static com.amap.api.services.route.RailwayStationItem f0(org.json.JSONObject jSONObject) throws org.json.JSONException {
        com.amap.api.services.route.RailwayStationItem railwayStationItem = new com.amap.api.services.route.RailwayStationItem();
        railwayStationItem.setID(a(jSONObject, "id"));
        railwayStationItem.setName(a(jSONObject, "name"));
        railwayStationItem.setLocation(y(jSONObject, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION));
        railwayStationItem.setAdcode(a(jSONObject, "adcode"));
        railwayStationItem.setTime(a(jSONObject, "time"));
        railwayStationItem.setisStart(Y(a(jSONObject, com.anythink.expressad.foundation.d.c.bT)));
        railwayStationItem.setisEnd(Y(a(jSONObject, "end")));
        railwayStationItem.setWait(R(a(jSONObject, "wait")));
        return railwayStationItem;
    }

    public static com.amap.api.services.route.RideRouteResult g(java.lang.String str) throws com.amap.api.services.core.AMapException {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            com.amap.api.services.route.RideRouteResult rideRouteResult = new com.amap.api.services.route.RideRouteResult();
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            rideRouteResult.setStartPos(y(optJSONObject, "origin"));
            rideRouteResult.setTargetPos(y(optJSONObject, "destination"));
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.lang.Object opt = optJSONObject.opt("paths");
            if (opt == null) {
                rideRouteResult.setPaths(arrayList);
                return rideRouteResult;
            }
            if (opt instanceof org.json.JSONArray) {
                org.json.JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.amap.api.services.route.RidePath q = q(optJSONArray.optJSONObject(i));
                    if (q != null) {
                        arrayList.add(q);
                    }
                }
            } else if (opt instanceof org.json.JSONObject) {
                org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("paths");
                if (!optJSONObject2.has("path")) {
                    rideRouteResult.setPaths(arrayList);
                    return rideRouteResult;
                }
                com.amap.api.services.route.RidePath q2 = q(optJSONObject2.optJSONObject("path"));
                if (q2 != null) {
                    arrayList.add(q2);
                }
            }
            rideRouteResult.setPaths(arrayList);
            return rideRouteResult;
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "JSONHelper", "parseRideRoute");
            throw new com.amap.api.services.core.AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static java.util.ArrayList<com.amap.api.services.geocoder.GeocodeAddress> g(org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.util.ArrayList<com.amap.api.services.geocoder.GeocodeAddress> arrayList = new java.util.ArrayList<>();
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("geocodes");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    com.amap.api.services.geocoder.GeocodeAddress geocodeAddress = new com.amap.api.services.geocoder.GeocodeAddress();
                    geocodeAddress.setFormatAddress(a(optJSONObject, "formatted_address"));
                    geocodeAddress.setProvince(a(optJSONObject, com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_PROVINCE));
                    geocodeAddress.setCity(a(optJSONObject, com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY));
                    geocodeAddress.setDistrict(a(optJSONObject, com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_DISTRICT));
                    geocodeAddress.setTownship(a(optJSONObject, "township"));
                    geocodeAddress.setNeighborhood(a(optJSONObject.optJSONObject("neighborhood"), "name"));
                    geocodeAddress.setBuilding(a(optJSONObject.optJSONObject("building"), "name"));
                    geocodeAddress.setAdcode(a(optJSONObject, "adcode"));
                    geocodeAddress.setLatLonPoint(y(optJSONObject, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION));
                    geocodeAddress.setLevel(a(optJSONObject, com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL));
                    geocodeAddress.setCountry(a(optJSONObject, "country"));
                    geocodeAddress.setPostcode(a(optJSONObject, "postcode"));
                    arrayList.add(geocodeAddress);
                }
            }
        }
        return arrayList;
    }

    public static com.amap.api.services.route.DistanceResult h(java.lang.String str) throws com.amap.api.services.core.AMapException {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (!jSONObject.has("results")) {
                return null;
            }
            com.amap.api.services.route.DistanceResult distanceResult = new com.amap.api.services.route.DistanceResult();
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray("results");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                com.amap.api.services.route.DistanceItem distanceItem = new com.amap.api.services.route.DistanceItem();
                org.json.JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                distanceItem.setOriginId(P(a(jSONObject2, "origin_id")));
                distanceItem.setDestId(P(a(jSONObject2, "dest_id")));
                distanceItem.setDistance(R(a(jSONObject2, "distance")));
                distanceItem.setDuration(R(a(jSONObject2, "duration")));
                java.lang.String a2 = a(jSONObject2, "info");
                if (!android.text.TextUtils.isEmpty(a2)) {
                    distanceItem.setErrorInfo(a2);
                    distanceItem.setErrorCode(P(a(jSONObject2, "code")));
                }
                arrayList.add(distanceItem);
            }
            distanceResult.setDistanceResults(arrayList);
            return distanceResult;
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "JSONHelper", "parseRouteDistance");
            throw new com.amap.api.services.core.AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static java.util.ArrayList<com.amap.api.services.help.Tip> h(org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.util.ArrayList<com.amap.api.services.help.Tip> arrayList = new java.util.ArrayList<>();
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("tips");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            com.amap.api.services.help.Tip tip = new com.amap.api.services.help.Tip();
            org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                tip.setName(a(optJSONObject, "name"));
                tip.setDistrict(a(optJSONObject, com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_DISTRICT));
                tip.setAdcode(a(optJSONObject, "adcode"));
                tip.setID(a(optJSONObject, "id"));
                tip.setAddress(a(optJSONObject, "address"));
                tip.setTypeCode(a(optJSONObject, "typecode"));
                java.lang.String a2 = a(optJSONObject, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
                if (!android.text.TextUtils.isEmpty(a2)) {
                    java.lang.String[] split = a2.split(",");
                    if (split.length == 2) {
                        tip.setPostion(new com.amap.api.services.core.LatLonPoint(java.lang.Double.parseDouble(split[1]), java.lang.Double.parseDouble(split[0])));
                    }
                }
                arrayList.add(tip);
            }
        }
        return arrayList;
    }

    public static com.amap.api.services.route.TruckRouteRestult i(java.lang.String str) throws com.amap.api.services.core.AMapException {
        org.json.JSONArray optJSONArray;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            com.amap.api.services.route.TruckRouteRestult truckRouteRestult = new com.amap.api.services.route.TruckRouteRestult();
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject("route");
            truckRouteRestult.setStartPos(y(optJSONObject, "origin"));
            truckRouteRestult.setTargetPos(y(optJSONObject, "destination"));
            if (!optJSONObject.has("paths") || (optJSONArray = optJSONObject.optJSONArray("paths")) == null) {
                return truckRouteRestult;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                com.amap.api.services.route.TruckPath truckPath = new com.amap.api.services.route.TruckPath();
                org.json.JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                truckPath.setDistance(R(a(jSONObject2, "distance")));
                truckPath.setDuration(V(a(jSONObject2, "duration")));
                truckPath.setStrategy(a(jSONObject2, "strategy"));
                truckPath.setTolls(R(a(jSONObject2, "tolls")));
                truckPath.setTollDistance(R(a(jSONObject2, "toll_distance")));
                truckPath.setTotalTrafficlights(P(a(jSONObject2, "traffic_lights")));
                truckPath.setRestriction(P(a(jSONObject2, "restriction")));
                org.json.JSONArray optJSONArray2 = jSONObject2.optJSONArray("steps");
                if (optJSONArray2 != null) {
                    java.util.ArrayList arrayList2 = new java.util.ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        com.amap.api.services.route.TruckStep truckStep = new com.amap.api.services.route.TruckStep();
                        org.json.JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            truckStep.setInstruction(a(optJSONObject2, "instruction"));
                            truckStep.setOrientation(a(optJSONObject2, "orientation"));
                            truckStep.setRoad(a(optJSONObject2, "road"));
                            truckStep.setDistance(R(a(optJSONObject2, "distance")));
                            truckStep.setTolls(R(a(optJSONObject2, "tolls")));
                            truckStep.setTollDistance(R(a(optJSONObject2, "toll_distance")));
                            truckStep.setTollRoad(a(optJSONObject2, "toll_road"));
                            truckStep.setDuration(R(a(optJSONObject2, "duration")));
                            truckStep.setPolyline(C(optJSONObject2, "polyline"));
                            truckStep.setAction(a(optJSONObject2, "action"));
                            truckStep.setAssistantAction(a(optJSONObject2, "assistant_action"));
                            x(truckStep, optJSONObject2);
                            B(truckStep, optJSONObject2);
                            arrayList2.add(truckStep);
                        }
                    }
                    truckPath.setSteps(arrayList2);
                    arrayList.add(truckPath);
                }
            }
            truckRouteRestult.setPaths(arrayList);
            return truckRouteRestult;
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "JSONHelper", "parseTruckRoute");
            throw new com.amap.api.services.core.AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static java.util.ArrayList<com.amap.api.services.routepoisearch.RoutePOIItem> i(org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.util.ArrayList<com.amap.api.services.routepoisearch.RoutePOIItem> arrayList = new java.util.ArrayList<>();
        java.lang.Object opt = jSONObject.opt("pois");
        if (opt instanceof org.json.JSONArray) {
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray("pois");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return arrayList;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(p(optJSONObject));
                }
            }
        } else if (opt instanceof org.json.JSONObject) {
            arrayList.add(p(((org.json.JSONObject) opt).optJSONObject("poi")));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x01a4 A[Catch: all -> 0x021b, JSONException -> 0x021d, TryCatch #3 {JSONException -> 0x021d, all -> 0x021b, blocks: (B:37:0x00cf, B:39:0x00e2, B:51:0x00eb, B:53:0x00fa, B:57:0x0102, B:60:0x010f, B:63:0x0116, B:64:0x011c, B:66:0x0122, B:68:0x012d, B:70:0x0134, B:72:0x0147, B:73:0x014d, B:75:0x0153, B:77:0x015e, B:83:0x0199, B:85:0x01a4, B:86:0x01ac, B:88:0x01b2, B:90:0x01bf, B:92:0x01e2, B:96:0x01e9, B:98:0x01f6, B:103:0x01ff, B:105:0x020e, B:111:0x0217), top: B:36:0x00cf }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.amap.api.services.route.DriveRoutePlanResult j(java.lang.String str) throws com.amap.api.services.core.AMapException {
        java.lang.String str2;
        java.lang.String str3;
        org.json.JSONArray optJSONArray;
        org.json.JSONArray optJSONArray2;
        java.lang.String str4;
        org.json.JSONArray jSONArray;
        java.lang.String str5;
        org.json.JSONArray jSONArray2;
        int i;
        org.json.JSONArray optJSONArray3;
        org.json.JSONArray jSONArray3;
        org.json.JSONArray jSONArray4;
        java.lang.String str6;
        org.json.JSONArray jSONArray5;
        java.lang.String str7 = "starttime";
        java.lang.String str8 = "协议解析错误 - ProtocolException";
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (jSONObject.has("errcode")) {
                jSONObject.optInt("errcode");
                jSONObject.optString("errmsg");
                jSONObject.optString("errdetail");
            }
            if (!jSONObject.has("data")) {
                return null;
            }
            com.amap.api.services.route.DriveRoutePlanResult driveRoutePlanResult = new com.amap.api.services.route.DriveRoutePlanResult();
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null || !optJSONObject.has("paths") || (optJSONArray = optJSONObject.optJSONArray("paths")) == null) {
                return driveRoutePlanResult;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int i2 = 0;
            while (i2 < optJSONArray.length()) {
                com.amap.api.services.route.DrivePlanPath drivePlanPath = new com.amap.api.services.route.DrivePlanPath();
                org.json.JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                if (optJSONObject2 != null) {
                    drivePlanPath.setDistance(R(a(optJSONObject2, "distance")));
                    drivePlanPath.setTrafficLights(P(a(optJSONObject2, "traffic_lights")));
                    org.json.JSONArray optJSONArray4 = optJSONObject2.optJSONArray("steps");
                    if (optJSONArray4 != null) {
                        java.util.ArrayList arrayList2 = new java.util.ArrayList();
                        int i3 = 0;
                        while (i3 < optJSONArray4.length()) {
                            com.amap.api.services.route.DrivePlanStep drivePlanStep = new com.amap.api.services.route.DrivePlanStep();
                            org.json.JSONArray jSONArray6 = optJSONArray;
                            org.json.JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i3);
                            if (optJSONObject3 != null) {
                                jSONArray5 = optJSONArray4;
                                drivePlanStep.setAdCode(a(optJSONObject3, "adcode"));
                                drivePlanStep.setRoad(a(optJSONObject3, "road"));
                                drivePlanStep.setDistance(R(a(optJSONObject3, "distance")));
                                str2 = str8;
                                try {
                                    drivePlanStep.setToll(P(a(optJSONObject3, com.amap.api.services.route.RouteSearch.DRIVING_EXCLUDE_TOLL)) == 1);
                                    drivePlanStep.setPolyline(C(optJSONObject3, "polyline"));
                                    arrayList2.add(drivePlanStep);
                                } catch (org.json.JSONException e) {
                                    e = e;
                                    str3 = str2;
                                    com.amap.api.col.s.i.a(e, "JSONHelper", "parseDriveRoute");
                                    throw new com.amap.api.services.core.AMapException(str3);
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    com.amap.api.col.s.i.a(th, "JSONHelper", "parseDriveRouteThrowable");
                                    throw new com.amap.api.services.core.AMapException(str2);
                                }
                            } else {
                                str2 = str8;
                                jSONArray5 = optJSONArray4;
                            }
                            i3++;
                            optJSONArray = jSONArray6;
                            optJSONArray4 = jSONArray5;
                            str8 = str2;
                        }
                        jSONArray4 = optJSONArray;
                        str6 = str8;
                        drivePlanPath.setSteps(arrayList2);
                        arrayList.add(drivePlanPath);
                        i2++;
                        optJSONArray = jSONArray4;
                        str8 = str6;
                    }
                }
                jSONArray4 = optJSONArray;
                str6 = str8;
                i2++;
                optJSONArray = jSONArray4;
                str8 = str6;
            }
            str2 = str8;
            driveRoutePlanResult.setPaths(arrayList);
            if (!optJSONObject.has("time_infos") || (optJSONArray2 = optJSONObject.optJSONArray("time_infos")) == null) {
                return driveRoutePlanResult;
            }
            java.util.ArrayList arrayList3 = new java.util.ArrayList();
            int i4 = 0;
            while (i4 < optJSONArray2.length()) {
                com.amap.api.services.route.TimeInfo timeInfo = new com.amap.api.services.route.TimeInfo();
                org.json.JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i4);
                if (optJSONObject4 != null) {
                    if (!optJSONObject4.has(str7)) {
                        return driveRoutePlanResult;
                    }
                    timeInfo.setStartTime(V(a(optJSONObject4, str7)));
                    org.json.JSONArray optJSONArray5 = optJSONObject4.optJSONArray("elements");
                    if (optJSONArray5 != null) {
                        java.util.ArrayList arrayList4 = new java.util.ArrayList();
                        int i5 = 0;
                        while (i5 < optJSONArray5.length()) {
                            com.amap.api.services.route.TimeInfosElement timeInfosElement = new com.amap.api.services.route.TimeInfosElement();
                            org.json.JSONObject optJSONObject5 = optJSONArray5.optJSONObject(i5);
                            if (optJSONObject5 != null) {
                                timeInfosElement.setPathindex(P(a(optJSONObject5, "pathindex")));
                                timeInfosElement.setDuration(R(a(optJSONObject5, "duration")));
                                timeInfosElement.setTolls(R(a(optJSONObject5, "tolls")));
                                int P = P(a(optJSONObject5, "restriction"));
                                if (P != 2 && P != -1) {
                                    i = 1;
                                    timeInfosElement.setRestriction(i);
                                    optJSONArray3 = optJSONObject5.optJSONArray("tmcs");
                                    if (optJSONArray3 != null) {
                                        java.util.ArrayList arrayList5 = new java.util.ArrayList();
                                        str5 = str7;
                                        int i6 = 0;
                                        while (i6 < optJSONArray3.length()) {
                                            com.amap.api.services.route.TMC tmc = new com.amap.api.services.route.TMC();
                                            org.json.JSONArray jSONArray7 = optJSONArray2;
                                            org.json.JSONObject optJSONObject6 = optJSONArray3.optJSONObject(i6);
                                            if (optJSONObject6 != null) {
                                                jSONArray3 = optJSONArray3;
                                                tmc.setStatus(a(optJSONObject6, "status"));
                                                tmc.setDistance(P(a(optJSONObject6, "distance")));
                                                tmc.setPolyline(C(optJSONObject6, "polyline"));
                                                arrayList5.add(tmc);
                                            } else {
                                                jSONArray3 = optJSONArray3;
                                            }
                                            i6++;
                                            optJSONArray2 = jSONArray7;
                                            optJSONArray3 = jSONArray3;
                                        }
                                        jSONArray2 = optJSONArray2;
                                        timeInfosElement.setTMCs(arrayList5);
                                        arrayList4.add(timeInfosElement);
                                        i5++;
                                        str7 = str5;
                                        optJSONArray2 = jSONArray2;
                                    }
                                }
                                i = 0;
                                timeInfosElement.setRestriction(i);
                                optJSONArray3 = optJSONObject5.optJSONArray("tmcs");
                                if (optJSONArray3 != null) {
                                }
                            }
                            str5 = str7;
                            jSONArray2 = optJSONArray2;
                            i5++;
                            str7 = str5;
                            optJSONArray2 = jSONArray2;
                        }
                        str4 = str7;
                        jSONArray = optJSONArray2;
                        timeInfo.setElements(arrayList4);
                        arrayList3.add(timeInfo);
                        i4++;
                        str7 = str4;
                        optJSONArray2 = jSONArray;
                    }
                }
                str4 = str7;
                jSONArray = optJSONArray2;
                i4++;
                str7 = str4;
                optJSONArray2 = jSONArray;
            }
            driveRoutePlanResult.setTimeInfos(arrayList3);
            return driveRoutePlanResult;
        } catch (org.json.JSONException e2) {
            e = e2;
            str3 = str8;
        } catch (java.lang.Throwable th2) {
            th = th2;
            str2 = str8;
        }
    }

    public static java.util.List<com.amap.api.services.route.RailwayStationItem> j(org.json.JSONObject jSONObject) throws org.json.JSONException {
        org.json.JSONArray optJSONArray;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("via_stops")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(f0(optJSONObject));
            }
        }
        return arrayList;
    }

    public static java.util.List<com.amap.api.services.route.Railway> k(org.json.JSONObject jSONObject) throws org.json.JSONException {
        org.json.JSONArray optJSONArray;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("alters")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                com.amap.api.services.route.Railway railway = new com.amap.api.services.route.Railway();
                railway.setID(a(optJSONObject, "id"));
                railway.setName(a(optJSONObject, "name"));
                arrayList.add(railway);
            }
        }
        return arrayList;
    }

    public static java.util.List<com.amap.api.services.route.RailwaySpace> l(org.json.JSONObject jSONObject) throws org.json.JSONException {
        org.json.JSONArray optJSONArray;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("spaces")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m(optJSONObject));
            }
        }
        return arrayList;
    }

    public static com.amap.api.services.route.RailwaySpace m(org.json.JSONObject jSONObject) throws org.json.JSONException {
        return new com.amap.api.services.route.RailwaySpace(a(jSONObject, "code"), R(a(jSONObject, "cost")));
    }

    public static com.amap.api.services.route.TaxiItem n(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject == null) {
            return null;
        }
        com.amap.api.services.route.TaxiItem taxiItem = new com.amap.api.services.route.TaxiItem();
        taxiItem.setOrigin(y(jSONObject, "origin"));
        taxiItem.setDestination(y(jSONObject, "destination"));
        taxiItem.setDistance(R(a(jSONObject, "distance")));
        taxiItem.setDuration(R(a(jSONObject, "duration")));
        taxiItem.setSname(a(jSONObject, "sname"));
        taxiItem.setTname(a(jSONObject, "tname"));
        return taxiItem;
    }

    public static java.util.List<com.amap.api.services.poisearch.Photo> o(org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONObject == null || !jSONObject.has("photos")) {
            return arrayList;
        }
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("photos");
        for (int i = 0; i < optJSONArray.length(); i++) {
            org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            com.amap.api.services.poisearch.Photo photo = new com.amap.api.services.poisearch.Photo();
            photo.setTitle(a(optJSONObject, "title"));
            photo.setUrl(a(optJSONObject, "url"));
            arrayList.add(photo);
        }
        return arrayList;
    }

    public static com.amap.api.services.routepoisearch.RoutePOIItem p(org.json.JSONObject jSONObject) throws org.json.JSONException {
        com.amap.api.services.routepoisearch.RoutePOIItem routePOIItem = new com.amap.api.services.routepoisearch.RoutePOIItem();
        routePOIItem.setID(a(jSONObject, "id"));
        routePOIItem.setTitle(a(jSONObject, "name"));
        routePOIItem.setPoint(y(jSONObject, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION));
        routePOIItem.setDistance(R(a(jSONObject, "distance")));
        routePOIItem.setDuration(R(a(jSONObject, "duration")));
        return routePOIItem;
    }

    public static com.amap.api.services.route.RidePath q(org.json.JSONObject jSONObject) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.route.RidePath ridePath = new com.amap.api.services.route.RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(R(a(jSONObject, "distance")));
            ridePath.setDuration(V(a(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                org.json.JSONArray optJSONArray = jSONObject.optJSONArray("steps");
                java.util.ArrayList arrayList = new java.util.ArrayList();
                if (optJSONArray == null) {
                    return null;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.amap.api.services.route.RideStep rideStep = new com.amap.api.services.route.RideStep();
                    org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        rideStep.setInstruction(a(optJSONObject, "instruction"));
                        rideStep.setOrientation(a(optJSONObject, "orientation"));
                        rideStep.setRoad(a(optJSONObject, "road"));
                        rideStep.setDistance(R(a(optJSONObject, "distance")));
                        rideStep.setDuration(R(a(optJSONObject, "duration")));
                        rideStep.setPolyline(C(optJSONObject, "polyline"));
                        rideStep.setAction(a(optJSONObject, "action"));
                        rideStep.setAssistantAction(a(optJSONObject, "assistant_action"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
                D(ridePath, arrayList);
            }
            return ridePath;
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "JSONHelper", "parseRidePath");
            throw new com.amap.api.services.core.AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static java.util.List<com.amap.api.services.route.BusPath> r(org.json.JSONArray jSONArray) throws org.json.JSONException {
        com.amap.api.services.route.BusStep U;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            com.amap.api.services.route.BusPath busPath = new com.amap.api.services.route.BusPath();
            org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                busPath.setCost(R(a(optJSONObject, "cost")));
                busPath.setDuration(V(a(optJSONObject, "duration")));
                busPath.setNightBus(Y(a(optJSONObject, "nightflag")));
                busPath.setWalkDistance(R(a(optJSONObject, "walking_distance")));
                busPath.setDistance(R(a(optJSONObject, "distance")));
                org.json.JSONArray optJSONArray = optJSONObject.optJSONArray(com.ss.android.socialbase.downloader.constants.DBDefinition.SEGMENT_TABLE_NAME);
                if (optJSONArray != null) {
                    java.util.ArrayList arrayList2 = new java.util.ArrayList();
                    float f = 0.0f;
                    float f2 = 0.0f;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        org.json.JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null && (U = U(optJSONObject2)) != null) {
                            arrayList2.add(U);
                            if (U.getWalk() != null) {
                                f2 += U.getWalk().getDistance();
                            }
                            if (U.getBusLines() != null && U.getBusLines().size() > 0) {
                                f += U.getBusLines().get(0).getDistance();
                            }
                        }
                    }
                    busPath.setSteps(arrayList2);
                    busPath.setBusDistance(f);
                    busPath.setWalkDistance(f2);
                    arrayList.add(busPath);
                }
            }
        }
        return arrayList;
    }

    public static void s(com.amap.api.services.core.PoiItem poiItem, org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.util.List<com.amap.api.services.poisearch.Photo> o = o(jSONObject.optJSONObject("deep_info"));
        if (o.size() == 0) {
            o = o(jSONObject);
        }
        poiItem.setPhotos(o);
    }

    public static void t(com.amap.api.services.geocoder.RegeocodeAddress regeocodeAddress) {
        if ((regeocodeAddress.getCity() == null || regeocodeAddress.getCity().length() <= 0) && I(regeocodeAddress.getCityCode())) {
            regeocodeAddress.setCity(regeocodeAddress.getProvince());
        }
    }

    public static void u(com.amap.api.services.route.DriveStep driveStep, org.json.JSONObject jSONObject) throws com.amap.api.services.core.AMapException {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray == null) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                com.amap.api.services.route.TMC tmc = new com.amap.api.services.route.TMC();
                org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    tmc.setDistance(P(a(optJSONObject, "distance")));
                    tmc.setStatus(a(optJSONObject, "status"));
                    tmc.setPolyline(C(optJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
            }
            driveStep.setTMCs(arrayList);
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "JSONHelper", "parseTMCs");
            throw new com.amap.api.services.core.AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void v(com.amap.api.services.route.Path path, java.util.List<com.amap.api.services.route.WalkStep> list) {
        java.util.List<com.amap.api.services.core.LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new java.util.ArrayList<>();
        }
        for (com.amap.api.services.route.WalkStep walkStep : list) {
            if (walkStep != null && walkStep.getPolyline() != null) {
                polyline.addAll(walkStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    public static void w(com.amap.api.services.route.RouteSearchCity routeSearchCity, org.json.JSONObject jSONObject) throws com.amap.api.services.core.AMapException {
        if (jSONObject.has("districts")) {
            try {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                org.json.JSONArray optJSONArray = jSONObject.optJSONArray("districts");
                if (optJSONArray == null) {
                    routeSearchCity.setDistricts(arrayList);
                    return;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.amap.api.services.route.District district = new com.amap.api.services.route.District();
                    org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        district.setDistrictName(a(optJSONObject, "name"));
                        district.setDistrictAdcode(a(optJSONObject, "adcode"));
                        arrayList.add(district);
                    }
                }
                routeSearchCity.setDistricts(arrayList);
            } catch (org.json.JSONException e) {
                com.amap.api.col.s.i.a(e, "JSONHelper", "parseCrossDistricts");
                throw new com.amap.api.services.core.AMapException("协议解析错误 - ProtocolException");
            }
        }
    }

    public static void x(com.amap.api.services.route.TruckStep truckStep, org.json.JSONObject jSONObject) throws com.amap.api.services.core.AMapException {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray == null) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                com.amap.api.services.route.RouteSearchCity routeSearchCity = new com.amap.api.services.route.RouteSearchCity();
                org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(a(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(a(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(a(optJSONObject, "adcode"));
                    w(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            truckStep.setRouteSearchCityList(arrayList);
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "JSONHelper", "parseCrossCity");
            throw new com.amap.api.services.core.AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static com.amap.api.services.core.LatLonPoint y(org.json.JSONObject jSONObject, java.lang.String str) throws org.json.JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return M(jSONObject.optString(str));
        }
        return null;
    }

    public static void z(com.amap.api.services.route.DriveStep driveStep, org.json.JSONObject jSONObject) throws com.amap.api.services.core.AMapException {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray == null) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                com.amap.api.services.route.RouteSearchCity routeSearchCity = new com.amap.api.services.route.RouteSearchCity();
                org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(a(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(a(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(a(optJSONObject, "adcode"));
                    w(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            driveStep.setRouteSearchCityList(arrayList);
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "JSONHelper", "parseCrossCity");
            throw new com.amap.api.services.core.AMapException("协议解析错误 - ProtocolException");
        }
    }
}
