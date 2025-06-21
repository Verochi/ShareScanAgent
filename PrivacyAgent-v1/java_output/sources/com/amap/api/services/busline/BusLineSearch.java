package com.amap.api.services.busline;

/* loaded from: classes12.dex */
public class BusLineSearch {
    public static final java.lang.String EXTENSIONS_ALL = "all";
    public static final java.lang.String EXTENSIONS_BASE = "base";
    private com.amap.api.services.interfaces.IBusLineSearch a;

    public interface OnBusLineSearchListener {
        void onBusLineSearched(com.amap.api.services.busline.BusLineResult busLineResult, int i);
    }

    public BusLineSearch(android.content.Context context, com.amap.api.services.busline.BusLineQuery busLineQuery) throws com.amap.api.services.core.AMapException {
        this.a = null;
        try {
            this.a = new com.amap.api.col.s.au(context, busLineQuery);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            if (e instanceof com.amap.api.services.core.AMapException) {
                throw ((com.amap.api.services.core.AMapException) e);
            }
        }
    }

    public com.amap.api.services.busline.BusLineQuery getQuery() {
        com.amap.api.services.interfaces.IBusLineSearch iBusLineSearch = this.a;
        if (iBusLineSearch != null) {
            return iBusLineSearch.getQuery();
        }
        return null;
    }

    public com.amap.api.services.busline.BusLineResult searchBusLine() throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IBusLineSearch iBusLineSearch = this.a;
        if (iBusLineSearch != null) {
            return iBusLineSearch.searchBusLine();
        }
        return null;
    }

    public void searchBusLineAsyn() {
        com.amap.api.services.interfaces.IBusLineSearch iBusLineSearch = this.a;
        if (iBusLineSearch != null) {
            iBusLineSearch.searchBusLineAsyn();
        }
    }

    public void setOnBusLineSearchListener(com.amap.api.services.busline.BusLineSearch.OnBusLineSearchListener onBusLineSearchListener) {
        com.amap.api.services.interfaces.IBusLineSearch iBusLineSearch = this.a;
        if (iBusLineSearch != null) {
            iBusLineSearch.setOnBusLineSearchListener(onBusLineSearchListener);
        }
    }

    public void setQuery(com.amap.api.services.busline.BusLineQuery busLineQuery) {
        com.amap.api.services.interfaces.IBusLineSearch iBusLineSearch = this.a;
        if (iBusLineSearch != null) {
            iBusLineSearch.setQuery(busLineQuery);
        }
    }
}
