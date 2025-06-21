package com.amap.api.services.share;

/* loaded from: classes12.dex */
public class ShareSearch {
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingNoHighWay = 3;
    public static final int DrivingNoHighWayAvoidCongestion = 6;
    public static final int DrivingNoHighWaySaveMoney = 5;
    public static final int DrivingNoHighWaySaveMoneyAvoidCongestion = 8;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 7;
    public static final int DrivingShortDistance = 2;
    public static final int NaviAvoidCongestion = 4;
    public static final int NaviDefault = 0;
    public static final int NaviNoHighWay = 3;
    public static final int NaviNoHighWayAvoidCongestion = 6;
    public static final int NaviNoHighWaySaveMoney = 5;
    public static final int NaviNoHighWaySaveMoneyAvoidCongestion = 8;
    public static final int NaviSaveMoney = 1;
    public static final int NaviSaveMoneyAvoidCongestion = 7;
    public static final int NaviShortDistance = 2;
    private com.amap.api.services.interfaces.IShareSearch a;

    public interface OnShareSearchListener {
        void onBusRouteShareUrlSearched(java.lang.String str, int i);

        void onDrivingRouteShareUrlSearched(java.lang.String str, int i);

        void onLocationShareUrlSearched(java.lang.String str, int i);

        void onNaviShareUrlSearched(java.lang.String str, int i);

        void onPoiShareUrlSearched(java.lang.String str, int i);

        void onWalkRouteShareUrlSearched(java.lang.String str, int i);
    }

    public static class ShareBusRouteQuery {
        private com.amap.api.services.share.ShareSearch.ShareFromAndTo a;
        private int b;

        public ShareBusRouteQuery(com.amap.api.services.share.ShareSearch.ShareFromAndTo shareFromAndTo, int i) {
            this.a = shareFromAndTo;
            this.b = i;
        }

        public int getBusMode() {
            return this.b;
        }

        public com.amap.api.services.share.ShareSearch.ShareFromAndTo getShareFromAndTo() {
            return this.a;
        }
    }

    public static class ShareDrivingRouteQuery {
        private com.amap.api.services.share.ShareSearch.ShareFromAndTo a;
        private int b;

        public ShareDrivingRouteQuery(com.amap.api.services.share.ShareSearch.ShareFromAndTo shareFromAndTo, int i) {
            this.a = shareFromAndTo;
            this.b = i;
        }

        public int getDrivingMode() {
            return this.b;
        }

        public com.amap.api.services.share.ShareSearch.ShareFromAndTo getShareFromAndTo() {
            return this.a;
        }
    }

    public static class ShareFromAndTo {
        private com.amap.api.services.core.LatLonPoint a;
        private com.amap.api.services.core.LatLonPoint b;
        private java.lang.String c = "起点";
        private java.lang.String d = "终点";

        public ShareFromAndTo(com.amap.api.services.core.LatLonPoint latLonPoint, com.amap.api.services.core.LatLonPoint latLonPoint2) {
            this.a = latLonPoint;
            this.b = latLonPoint2;
        }

        public com.amap.api.services.core.LatLonPoint getFrom() {
            return this.a;
        }

        public java.lang.String getFromName() {
            return this.c;
        }

        public com.amap.api.services.core.LatLonPoint getTo() {
            return this.b;
        }

        public java.lang.String getToName() {
            return this.d;
        }

        public void setFromName(java.lang.String str) {
            this.c = str;
        }

        public void setToName(java.lang.String str) {
            this.d = str;
        }
    }

    public static class ShareNaviQuery {
        private com.amap.api.services.share.ShareSearch.ShareFromAndTo a;
        private int b;

        public ShareNaviQuery(com.amap.api.services.share.ShareSearch.ShareFromAndTo shareFromAndTo, int i) {
            this.a = shareFromAndTo;
            this.b = i;
        }

        public com.amap.api.services.share.ShareSearch.ShareFromAndTo getFromAndTo() {
            return this.a;
        }

        public int getNaviMode() {
            return this.b;
        }
    }

    public static class ShareWalkRouteQuery {
        private com.amap.api.services.share.ShareSearch.ShareFromAndTo a;
        private int b;

        public ShareWalkRouteQuery(com.amap.api.services.share.ShareSearch.ShareFromAndTo shareFromAndTo, int i) {
            this.a = shareFromAndTo;
            this.b = i;
        }

        public com.amap.api.services.share.ShareSearch.ShareFromAndTo getShareFromAndTo() {
            return this.a;
        }

        public int getWalkMode() {
            return this.b;
        }
    }

    public ShareSearch(android.content.Context context) throws com.amap.api.services.core.AMapException {
        if (this.a == null) {
            try {
                this.a = new com.amap.api.col.s.bf(context);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                if (e instanceof com.amap.api.services.core.AMapException) {
                    throw ((com.amap.api.services.core.AMapException) e);
                }
            }
        }
    }

    public java.lang.String searchBusRouteShareUrl(com.amap.api.services.share.ShareSearch.ShareBusRouteQuery shareBusRouteQuery) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IShareSearch iShareSearch = this.a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchBusRouteShareUrl(shareBusRouteQuery);
        return null;
    }

    public void searchBusRouteShareUrlAsyn(com.amap.api.services.share.ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
        com.amap.api.services.interfaces.IShareSearch iShareSearch = this.a;
        if (iShareSearch != null) {
            iShareSearch.searchBusRouteShareUrlAsyn(shareBusRouteQuery);
        }
    }

    public java.lang.String searchDrivingRouteShareUrl(com.amap.api.services.share.ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IShareSearch iShareSearch = this.a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchDrivingRouteShareUrl(shareDrivingRouteQuery);
        return null;
    }

    public void searchDrivingRouteShareUrlAsyn(com.amap.api.services.share.ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
        com.amap.api.services.interfaces.IShareSearch iShareSearch = this.a;
        if (iShareSearch != null) {
            iShareSearch.searchDrivingRouteShareUrlAsyn(shareDrivingRouteQuery);
        }
    }

    public java.lang.String searchLocationShareUrl(com.amap.api.services.core.LatLonSharePoint latLonSharePoint) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IShareSearch iShareSearch = this.a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchLocationShareUrl(latLonSharePoint);
        return null;
    }

    public void searchLocationShareUrlAsyn(com.amap.api.services.core.LatLonSharePoint latLonSharePoint) {
        com.amap.api.services.interfaces.IShareSearch iShareSearch = this.a;
        if (iShareSearch != null) {
            iShareSearch.searchLocationShareUrlAsyn(latLonSharePoint);
        }
    }

    public java.lang.String searchNaviShareUrl(com.amap.api.services.share.ShareSearch.ShareNaviQuery shareNaviQuery) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IShareSearch iShareSearch = this.a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchNaviShareUrl(shareNaviQuery);
        return null;
    }

    public void searchNaviShareUrlAsyn(com.amap.api.services.share.ShareSearch.ShareNaviQuery shareNaviQuery) {
        com.amap.api.services.interfaces.IShareSearch iShareSearch = this.a;
        if (iShareSearch != null) {
            iShareSearch.searchNaviShareUrlAsyn(shareNaviQuery);
        }
    }

    public java.lang.String searchPoiShareUrl(com.amap.api.services.core.PoiItem poiItem) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IShareSearch iShareSearch = this.a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchPoiShareUrl(poiItem);
        return null;
    }

    public void searchPoiShareUrlAsyn(com.amap.api.services.core.PoiItem poiItem) {
        com.amap.api.services.interfaces.IShareSearch iShareSearch = this.a;
        if (iShareSearch != null) {
            iShareSearch.searchPoiShareUrlAsyn(poiItem);
        }
    }

    public java.lang.String searchWalkRouteShareUrl(com.amap.api.services.share.ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IShareSearch iShareSearch = this.a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchWalkRouteShareUrl(shareWalkRouteQuery);
        return null;
    }

    public void searchWalkRouteShareUrlAsyn(com.amap.api.services.share.ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
        com.amap.api.services.interfaces.IShareSearch iShareSearch = this.a;
        if (iShareSearch != null) {
            iShareSearch.searchWalkRouteShareUrlAsyn(shareWalkRouteQuery);
        }
    }

    public void setOnShareSearchListener(com.amap.api.services.share.ShareSearch.OnShareSearchListener onShareSearchListener) {
        com.amap.api.services.interfaces.IShareSearch iShareSearch = this.a;
        if (iShareSearch != null) {
            iShareSearch.setOnShareSearchListener(onShareSearchListener);
        }
    }
}
