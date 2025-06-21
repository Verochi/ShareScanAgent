package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class s extends android.os.Handler {
    public static com.amap.api.col.s.s a;

    public static class a {
        public com.amap.api.services.busline.BusLineResult a;
        public com.amap.api.services.busline.BusLineSearch.OnBusLineSearchListener b;
    }

    public static class b {
        public com.amap.api.services.busline.BusStationResult a;
        public com.amap.api.services.busline.BusStationSearch.OnBusStationSearchListener b;
    }

    public static class c {
        public com.amap.api.services.cloud.CloudItemDetail a;
        public com.amap.api.services.cloud.CloudSearch.OnCloudSearchListener b;
    }

    public static class d {
        public com.amap.api.services.cloud.CloudResult a;
        public com.amap.api.services.cloud.CloudSearch.OnCloudSearchListener b;
    }

    public static class e {
        public com.amap.api.services.geocoder.GeocodeResult a;
        public com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener b;
    }

    public static class f {
        public java.util.List<com.amap.api.services.nearby.NearbySearch.NearbyListener> a;
        public com.amap.api.services.nearby.NearbySearchResult b;
    }

    public static class g {
        public com.amap.api.services.core.PoiItem a;
        public com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener b;
    }

    public static class h {
        public com.amap.api.services.poisearch.PoiResult a;
        public com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener b;
    }

    public static class i {
        public com.amap.api.services.geocoder.RegeocodeResult a;
        public com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener b;
    }

    public static class j {
        public com.amap.api.services.routepoisearch.RoutePOISearchResult a;
        public com.amap.api.services.routepoisearch.RoutePOISearch.OnRoutePOISearchListener b;
    }

    public static class k {
        public com.amap.api.services.weather.LocalWeatherForecastResult a;
        public com.amap.api.services.weather.WeatherSearch.OnWeatherSearchListener b;
    }

    public static class l {
        public com.amap.api.services.weather.LocalWeatherLiveResult a;
        public com.amap.api.services.weather.WeatherSearch.OnWeatherSearchListener b;
    }

    public s() {
    }

    public s(android.os.Looper looper) {
        super(looper);
    }

    public static synchronized com.amap.api.col.s.s a() {
        com.amap.api.col.s.s sVar;
        synchronized (com.amap.api.col.s.s.class) {
            if (a == null) {
                if (android.os.Looper.myLooper() != null && android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                    a = new com.amap.api.col.s.s();
                }
                a = new com.amap.api.col.s.s(android.os.Looper.getMainLooper());
            }
            sVar = a;
        }
        return sVar;
    }

    public static void b(android.os.Message message) {
        int i2 = message.arg2;
        com.amap.api.services.share.ShareSearch.OnShareSearchListener onShareSearchListener = (com.amap.api.services.share.ShareSearch.OnShareSearchListener) message.obj;
        java.lang.String string = message.getData().getString("shareurlkey");
        if (onShareSearchListener == null) {
        }
        switch (message.what) {
            case 1100:
                onShareSearchListener.onPoiShareUrlSearched(string, i2);
                break;
            case com.amap.api.services.core.AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR /* 1101 */:
                onShareSearchListener.onLocationShareUrlSearched(string, i2);
                break;
            case com.amap.api.services.core.AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT /* 1102 */:
                onShareSearchListener.onNaviShareUrlSearched(string, i2);
                break;
            case com.amap.api.services.core.AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT /* 1103 */:
                onShareSearchListener.onBusRouteShareUrlSearched(string, i2);
                break;
            case 1104:
                onShareSearchListener.onDrivingRouteShareUrlSearched(string, i2);
                break;
            case 1105:
                onShareSearchListener.onWalkRouteShareUrlSearched(string, i2);
                break;
        }
    }

    public static void c(android.os.Message message) {
        java.util.List list = (java.util.List) message.obj;
        if (list == null || list.size() == 0) {
            return;
        }
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            ((com.amap.api.services.nearby.NearbySearch.NearbyListener) it.next()).onNearbyInfoUploaded(message.what);
        }
    }

    public static void d(android.os.Message message) {
        java.util.List<com.amap.api.services.nearby.NearbySearch.NearbyListener> list;
        com.amap.api.col.s.s.f fVar = (com.amap.api.col.s.s.f) message.obj;
        if (fVar == null || (list = fVar.a) == null || list.size() == 0) {
            return;
        }
        com.amap.api.services.nearby.NearbySearchResult nearbySearchResult = message.what == 1000 ? fVar.b : null;
        java.util.Iterator<com.amap.api.services.nearby.NearbySearch.NearbyListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().onNearbyInfoSearched(nearbySearchResult, message.what);
        }
    }

    public static void e(android.os.Message message) {
        java.util.List list = (java.util.List) message.obj;
        if (list == null || list.size() == 0) {
            return;
        }
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            ((com.amap.api.services.nearby.NearbySearch.NearbyListener) it.next()).onUserInfoCleared(message.what);
        }
    }

    public static void f(android.os.Message message) {
        com.amap.api.services.busline.BusStationSearch.OnBusStationSearchListener onBusStationSearchListener;
        com.amap.api.col.s.s.b bVar = (com.amap.api.col.s.s.b) message.obj;
        if (bVar == null || (onBusStationSearchListener = bVar.b) == null) {
            return;
        }
        int i2 = message.what;
        onBusStationSearchListener.onBusStationSearched(i2 == 1000 ? bVar.a : null, i2);
    }

    public static void g(android.os.Message message) {
        com.amap.api.col.s.s.g gVar;
        com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener onPoiSearchListener;
        android.os.Bundle data;
        int i2 = message.what;
        if (i2 == 600) {
            com.amap.api.col.s.s.h hVar = (com.amap.api.col.s.s.h) message.obj;
            if (hVar == null || (onPoiSearchListener = hVar.b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onPoiSearched(hVar.a, data.getInt("errorCode"));
            return;
        }
        if (i2 != 602 || (gVar = (com.amap.api.col.s.s.g) message.obj) == null) {
            return;
        }
        com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener onPoiSearchListener2 = gVar.b;
        android.os.Bundle data2 = message.getData();
        if (data2 != null) {
            onPoiSearchListener2.onPoiItemSearched(gVar.a, data2.getInt("errorCode"));
        }
    }

    public static void h(android.os.Message message) {
        com.amap.api.services.help.Inputtips.InputtipsListener inputtipsListener = (com.amap.api.services.help.Inputtips.InputtipsListener) message.obj;
        if (inputtipsListener == null) {
            return;
        }
        inputtipsListener.onGetInputtips(message.what == 1000 ? message.getData().getParcelableArrayList("result") : null, message.what);
    }

    public static void i(android.os.Message message) {
        com.amap.api.col.s.s.e eVar;
        com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener;
        com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener2;
        int i2 = message.what;
        if (i2 == 201) {
            com.amap.api.col.s.s.i iVar = (com.amap.api.col.s.s.i) message.obj;
            if (iVar == null || (onGeocodeSearchListener2 = iVar.b) == null) {
                return;
            }
            onGeocodeSearchListener2.onRegeocodeSearched(iVar.a, message.arg2);
            return;
        }
        if (i2 != 200 || (eVar = (com.amap.api.col.s.s.e) message.obj) == null || (onGeocodeSearchListener = eVar.b) == null) {
            return;
        }
        onGeocodeSearchListener.onGeocodeSearched(eVar.a, message.arg2);
    }

    public static void j(android.os.Message message) {
        com.amap.api.services.district.DistrictSearch.OnDistrictSearchListener onDistrictSearchListener = (com.amap.api.services.district.DistrictSearch.OnDistrictSearchListener) message.obj;
        if (onDistrictSearchListener == null) {
            return;
        }
        onDistrictSearchListener.onDistrictSearched((com.amap.api.services.district.DistrictResult) message.getData().getParcelable("result"));
    }

    public static void k(android.os.Message message) {
        com.amap.api.services.busline.BusLineSearch.OnBusLineSearchListener onBusLineSearchListener;
        com.amap.api.col.s.s.a aVar = (com.amap.api.col.s.s.a) message.obj;
        if (aVar == null || (onBusLineSearchListener = aVar.b) == null) {
            return;
        }
        int i2 = message.what;
        onBusLineSearchListener.onBusLineSearched(i2 == 1000 ? aVar.a : null, i2);
    }

    public static void l(android.os.Message message) {
        android.os.Bundle data;
        com.amap.api.services.route.RouteSearch.OnRouteSearchListener onRouteSearchListener = (com.amap.api.services.route.RouteSearch.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        int i2 = message.what;
        if (i2 == 100) {
            android.os.Bundle data2 = message.getData();
            if (data2 != null) {
                onRouteSearchListener.onBusRouteSearched((com.amap.api.services.route.BusRouteResult) message.getData().getParcelable("result"), data2.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i2 == 101) {
            android.os.Bundle data3 = message.getData();
            if (data3 != null) {
                onRouteSearchListener.onDriveRouteSearched((com.amap.api.services.route.DriveRouteResult) message.getData().getParcelable("result"), data3.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i2 == 102) {
            android.os.Bundle data4 = message.getData();
            if (data4 != null) {
                onRouteSearchListener.onWalkRouteSearched((com.amap.api.services.route.WalkRouteResult) message.getData().getParcelable("result"), data4.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i2 == 103) {
            android.os.Bundle data5 = message.getData();
            if (data5 != null) {
                onRouteSearchListener.onRideRouteSearched((com.amap.api.services.route.RideRouteResult) message.getData().getParcelable("result"), data5.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i2 != 104 || (data = message.getData()) == null) {
            return;
        }
        onRouteSearchListener.onRideRouteSearched((com.amap.api.services.route.RideRouteResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    public static void m(android.os.Message message) {
        android.os.Bundle data;
        com.amap.api.services.route.RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener = (com.amap.api.services.route.RouteSearch.OnTruckRouteSearchListener) message.obj;
        if (onTruckRouteSearchListener == null || message.what != 104 || (data = message.getData()) == null) {
            return;
        }
        onTruckRouteSearchListener.onTruckRouteSearched((com.amap.api.services.route.TruckRouteRestult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    public static void n(android.os.Message message) {
        android.os.Bundle data;
        com.amap.api.services.route.RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener = (com.amap.api.services.route.RouteSearch.OnRoutePlanSearchListener) message.obj;
        if (onRoutePlanSearchListener == null || message.what != 105 || (data = message.getData()) == null) {
            return;
        }
        onRoutePlanSearchListener.onDriveRoutePlanSearched((com.amap.api.services.route.DriveRoutePlanResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    public static void o(android.os.Message message) {
        com.amap.api.col.s.s.c cVar;
        int i2 = message.what;
        if (i2 == 700) {
            com.amap.api.col.s.s.d dVar = (com.amap.api.col.s.s.d) message.obj;
            if (dVar == null) {
                return;
            }
            dVar.b.onCloudSearched(dVar.a, message.arg2);
            return;
        }
        if (i2 != 701 || (cVar = (com.amap.api.col.s.s.c) message.obj) == null) {
            return;
        }
        cVar.b.onCloudItemDetailSearched(cVar.a, message.arg2);
    }

    public static void p(android.os.Message message) {
        com.amap.api.col.s.s.k kVar;
        com.amap.api.services.weather.WeatherSearch.OnWeatherSearchListener onWeatherSearchListener;
        android.os.Bundle data;
        com.amap.api.services.weather.WeatherSearch.OnWeatherSearchListener onWeatherSearchListener2;
        android.os.Bundle data2;
        int i2 = message.what;
        if (i2 == 1301) {
            com.amap.api.col.s.s.l lVar = (com.amap.api.col.s.s.l) message.obj;
            if (lVar == null || (onWeatherSearchListener2 = lVar.b) == null || (data2 = message.getData()) == null) {
                return;
            }
            onWeatherSearchListener2.onWeatherLiveSearched(lVar.a, data2.getInt("errorCode"));
            return;
        }
        if (i2 != 1302 || (kVar = (com.amap.api.col.s.s.k) message.obj) == null || (onWeatherSearchListener = kVar.b) == null || (data = message.getData()) == null) {
            return;
        }
        onWeatherSearchListener.onWeatherForecastSearched(kVar.a, data.getInt("errorCode"));
    }

    public static void q(android.os.Message message) {
        com.amap.api.services.routepoisearch.RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener;
        android.os.Bundle data;
        com.amap.api.col.s.s.j jVar = (com.amap.api.col.s.s.j) message.obj;
        if (jVar == null || (onRoutePOISearchListener = jVar.b) == null || (data = message.getData()) == null) {
            return;
        }
        onRoutePOISearchListener.onRoutePoiSearched(jVar.a, data.getInt("errorCode"));
    }

    public static void r(android.os.Message message) {
        android.os.Bundle data;
        com.amap.api.services.route.DistanceSearch.OnDistanceSearchListener onDistanceSearchListener = (com.amap.api.services.route.DistanceSearch.OnDistanceSearchListener) message.obj;
        if (onDistanceSearchListener == null || message.what != 400 || (data = message.getData()) == null) {
            return;
        }
        onDistanceSearchListener.onDistanceSearched((com.amap.api.services.route.DistanceResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    @Override // android.os.Handler
    public final void handleMessage(android.os.Message message) {
        try {
            switch (message.arg1) {
                case 1:
                    l(message);
                    break;
                case 2:
                    i(message);
                    break;
                case 3:
                    k(message);
                    break;
                case 4:
                    j(message);
                    break;
                case 5:
                    h(message);
                    break;
                case 6:
                    g(message);
                    break;
                case 7:
                    f(message);
                    break;
                case 8:
                    e(message);
                    break;
                case 9:
                    d(message);
                    break;
                case 10:
                    c(message);
                    break;
                case 11:
                    b(message);
                    break;
                case 12:
                    o(message);
                    break;
                case 13:
                    p(message);
                    break;
                case 14:
                    q(message);
                    break;
                case 16:
                    r(message);
                    break;
                case 17:
                    m(message);
                    break;
                case 18:
                    n(message);
                    break;
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "MessageHandler", "handleMessage");
        }
    }
}
