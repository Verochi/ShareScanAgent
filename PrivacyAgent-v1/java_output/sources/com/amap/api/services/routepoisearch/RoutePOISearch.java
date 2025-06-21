package com.amap.api.services.routepoisearch;

/* loaded from: classes12.dex */
public class RoutePOISearch {
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;
    private com.amap.api.services.interfaces.IRoutePOISearch a;

    public interface OnRoutePOISearchListener {
        void onRoutePoiSearched(com.amap.api.services.routepoisearch.RoutePOISearchResult routePOISearchResult, int i);
    }

    public enum RoutePOISearchType {
        TypeGasStation,
        TypeMaintenanceStation,
        TypeATM,
        TypeToilet,
        TypeFillingStation,
        TypeServiceArea
    }

    public RoutePOISearch(android.content.Context context, com.amap.api.services.routepoisearch.RoutePOISearchQuery routePOISearchQuery) throws com.amap.api.services.core.AMapException {
        if (this.a == null) {
            try {
                this.a = new com.amap.api.col.s.bd(context, routePOISearchQuery);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                if (e instanceof com.amap.api.services.core.AMapException) {
                    throw ((com.amap.api.services.core.AMapException) e);
                }
            }
        }
    }

    public com.amap.api.services.routepoisearch.RoutePOISearchResult searchRoutePOI() throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IRoutePOISearch iRoutePOISearch = this.a;
        if (iRoutePOISearch != null) {
            return iRoutePOISearch.searchRoutePOI();
        }
        return null;
    }

    public void searchRoutePOIAsyn() {
        com.amap.api.services.interfaces.IRoutePOISearch iRoutePOISearch = this.a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.searchRoutePOIAsyn();
        }
    }

    public void setPoiSearchListener(com.amap.api.services.routepoisearch.RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener) {
        com.amap.api.services.interfaces.IRoutePOISearch iRoutePOISearch = this.a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.setRoutePOISearchListener(onRoutePOISearchListener);
        }
    }

    public void setQuery(com.amap.api.services.routepoisearch.RoutePOISearchQuery routePOISearchQuery) {
        com.amap.api.services.interfaces.IRoutePOISearch iRoutePOISearch = this.a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.setQuery(routePOISearchQuery);
        }
    }
}
