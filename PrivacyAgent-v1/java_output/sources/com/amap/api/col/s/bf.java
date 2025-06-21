package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class bf implements com.amap.api.services.interfaces.IShareSearch {
    public static java.lang.String c = "http://wb.amap.com/?r=%f,%f,%s,%f,%f,%s,%d,%d,%d,%s,%s,%s&sourceapplication=openapi/0";
    public static java.lang.String d = "http://wb.amap.com/?q=%f,%f,%s&sourceapplication=openapi/0";
    public static java.lang.String e = "http://wb.amap.com/?n=%f,%f,%f,%f,%d&sourceapplication=openapi/0";
    public static java.lang.String f = "http://wb.amap.com/?p=%s,%f,%f,%s,%s&sourceapplication=openapi/0";
    public static final java.lang.String g = "";
    public android.content.Context a;
    public com.amap.api.services.share.ShareSearch.OnShareSearchListener b;

    /* renamed from: com.amap.api.col.s.bf$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.core.PoiItem n;

        public AnonymousClass1(com.amap.api.services.core.PoiItem poiItem) {
            this.n = poiItem;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.amap.api.col.s.bf.this.b == null) {
                return;
            }
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1100;
            obtainMessage.obj = com.amap.api.col.s.bf.this.b;
            try {
                try {
                    java.lang.String searchPoiShareUrl = com.amap.api.col.s.bf.this.searchPoiShareUrl(this.n);
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putString("shareurlkey", searchPoiShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (com.amap.api.services.core.AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                com.amap.api.col.s.s.a().sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.s.bf$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.share.ShareSearch.ShareBusRouteQuery n;

        public AnonymousClass2(com.amap.api.services.share.ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
            this.n = shareBusRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.amap.api.col.s.bf.this.b == null) {
                return;
            }
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = com.amap.api.services.core.AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT;
            obtainMessage.obj = com.amap.api.col.s.bf.this.b;
            try {
                try {
                    java.lang.String searchBusRouteShareUrl = com.amap.api.col.s.bf.this.searchBusRouteShareUrl(this.n);
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putString("shareurlkey", searchBusRouteShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (com.amap.api.services.core.AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                com.amap.api.col.s.s.a().sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.s.bf$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.share.ShareSearch.ShareWalkRouteQuery n;

        public AnonymousClass3(com.amap.api.services.share.ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
            this.n = shareWalkRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.amap.api.col.s.bf.this.b == null) {
                return;
            }
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1105;
            obtainMessage.obj = com.amap.api.col.s.bf.this.b;
            try {
                try {
                    java.lang.String searchWalkRouteShareUrl = com.amap.api.col.s.bf.this.searchWalkRouteShareUrl(this.n);
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putString("shareurlkey", searchWalkRouteShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (com.amap.api.services.core.AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                com.amap.api.col.s.s.a().sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.s.bf$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.share.ShareSearch.ShareDrivingRouteQuery n;

        public AnonymousClass4(com.amap.api.services.share.ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
            this.n = shareDrivingRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.amap.api.col.s.bf.this.b == null) {
                return;
            }
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1104;
            obtainMessage.obj = com.amap.api.col.s.bf.this.b;
            try {
                try {
                    java.lang.String searchDrivingRouteShareUrl = com.amap.api.col.s.bf.this.searchDrivingRouteShareUrl(this.n);
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putString("shareurlkey", searchDrivingRouteShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (com.amap.api.services.core.AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                com.amap.api.col.s.s.a().sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.s.bf$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.share.ShareSearch.ShareNaviQuery n;

        public AnonymousClass5(com.amap.api.services.share.ShareSearch.ShareNaviQuery shareNaviQuery) {
            this.n = shareNaviQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.amap.api.col.s.bf.this.b == null) {
                return;
            }
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = com.amap.api.services.core.AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT;
            obtainMessage.obj = com.amap.api.col.s.bf.this.b;
            try {
                try {
                    java.lang.String searchNaviShareUrl = com.amap.api.col.s.bf.this.searchNaviShareUrl(this.n);
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putString("shareurlkey", searchNaviShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (com.amap.api.services.core.AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                com.amap.api.col.s.s.a().sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.s.bf$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.core.LatLonSharePoint n;

        public AnonymousClass6(com.amap.api.services.core.LatLonSharePoint latLonSharePoint) {
            this.n = latLonSharePoint;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.amap.api.col.s.bf.this.b == null) {
                return;
            }
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = com.amap.api.services.core.AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR;
            obtainMessage.obj = com.amap.api.col.s.bf.this.b;
            try {
                try {
                    java.lang.String searchLocationShareUrl = com.amap.api.col.s.bf.this.searchLocationShareUrl(this.n);
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putString("shareurlkey", searchLocationShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (com.amap.api.services.core.AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                com.amap.api.col.s.s.a().sendMessage(obtainMessage);
            }
        }
    }

    public bf(android.content.Context context) throws com.amap.api.services.core.AMapException {
        com.amap.api.col.s.bs a = com.amap.api.col.s.br.a(context, com.amap.api.col.s.h.a(false));
        if (a.a == com.amap.api.col.s.br.c.SuccessCode) {
            this.a = context;
        } else {
            java.lang.String str = a.b;
            throw new com.amap.api.services.core.AMapException(str, 1, str, a.a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final java.lang.String searchBusRouteShareUrl(com.amap.api.services.share.ShareSearch.ShareBusRouteQuery shareBusRouteQuery) throws com.amap.api.services.core.AMapException {
        try {
            if (shareBusRouteQuery == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            int busMode = shareBusRouteQuery.getBusMode();
            com.amap.api.services.share.ShareSearch.ShareFromAndTo shareFromAndTo = shareBusRouteQuery.getShareFromAndTo();
            if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            com.amap.api.services.core.LatLonPoint from = shareFromAndTo.getFrom();
            com.amap.api.services.core.LatLonPoint to = shareFromAndTo.getTo();
            java.lang.String fromName = shareFromAndTo.getFromName();
            java.lang.String toName = shareFromAndTo.getToName();
            java.lang.String str = c;
            java.lang.String str2 = g;
            return new com.amap.api.col.s.ak(this.a, java.lang.String.format(str, java.lang.Double.valueOf(from.getLatitude()), java.lang.Double.valueOf(from.getLongitude()), fromName, java.lang.Double.valueOf(to.getLatitude()), java.lang.Double.valueOf(to.getLongitude()), toName, java.lang.Integer.valueOf(busMode), 1, 0, str2, str2, str2)).b();
        } catch (com.amap.api.services.core.AMapException e2) {
            com.amap.api.col.s.i.a(e2, "ShareSearch", "searchBusRouteShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchBusRouteShareUrlAsyn(com.amap.api.services.share.ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.bf.AnonymousClass2(shareBusRouteQuery));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final java.lang.String searchDrivingRouteShareUrl(com.amap.api.services.share.ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) throws com.amap.api.services.core.AMapException {
        try {
            if (shareDrivingRouteQuery == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            int drivingMode = shareDrivingRouteQuery.getDrivingMode();
            com.amap.api.services.share.ShareSearch.ShareFromAndTo shareFromAndTo = shareDrivingRouteQuery.getShareFromAndTo();
            if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            com.amap.api.services.core.LatLonPoint from = shareFromAndTo.getFrom();
            com.amap.api.services.core.LatLonPoint to = shareFromAndTo.getTo();
            java.lang.String fromName = shareFromAndTo.getFromName();
            java.lang.String toName = shareFromAndTo.getToName();
            java.lang.String str = c;
            java.lang.String str2 = g;
            return new com.amap.api.col.s.ak(this.a, java.lang.String.format(str, java.lang.Double.valueOf(from.getLatitude()), java.lang.Double.valueOf(from.getLongitude()), fromName, java.lang.Double.valueOf(to.getLatitude()), java.lang.Double.valueOf(to.getLongitude()), toName, java.lang.Integer.valueOf(drivingMode), 0, 0, str2, str2, str2)).b();
        } catch (com.amap.api.services.core.AMapException e2) {
            com.amap.api.col.s.i.a(e2, "ShareSearch", "searchDrivingRouteShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchDrivingRouteShareUrlAsyn(com.amap.api.services.share.ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.bf.AnonymousClass4(shareDrivingRouteQuery));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final java.lang.String searchLocationShareUrl(com.amap.api.services.core.LatLonSharePoint latLonSharePoint) throws com.amap.api.services.core.AMapException {
        try {
            if (latLonSharePoint != null) {
                return new com.amap.api.col.s.ak(this.a, java.lang.String.format(d, java.lang.Double.valueOf(latLonSharePoint.getLatitude()), java.lang.Double.valueOf(latLonSharePoint.getLongitude()), latLonSharePoint.getSharePointName())).b();
            }
            throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
        } catch (com.amap.api.services.core.AMapException e2) {
            com.amap.api.col.s.i.a(e2, "ShareSearch", "searchLocationShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchLocationShareUrlAsyn(com.amap.api.services.core.LatLonSharePoint latLonSharePoint) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.bf.AnonymousClass6(latLonSharePoint));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final java.lang.String searchNaviShareUrl(com.amap.api.services.share.ShareSearch.ShareNaviQuery shareNaviQuery) throws com.amap.api.services.core.AMapException {
        try {
            if (shareNaviQuery == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            com.amap.api.services.share.ShareSearch.ShareFromAndTo fromAndTo = shareNaviQuery.getFromAndTo();
            if (fromAndTo.getTo() == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            com.amap.api.services.core.LatLonPoint from = fromAndTo.getFrom();
            com.amap.api.services.core.LatLonPoint to = fromAndTo.getTo();
            int naviMode = shareNaviQuery.getNaviMode();
            return new com.amap.api.col.s.ak(this.a, fromAndTo.getFrom() == null ? java.lang.String.format(e, null, null, java.lang.Double.valueOf(to.getLatitude()), java.lang.Double.valueOf(to.getLongitude()), java.lang.Integer.valueOf(naviMode)) : java.lang.String.format(e, java.lang.Double.valueOf(from.getLatitude()), java.lang.Double.valueOf(from.getLongitude()), java.lang.Double.valueOf(to.getLatitude()), java.lang.Double.valueOf(to.getLongitude()), java.lang.Integer.valueOf(naviMode))).b();
        } catch (com.amap.api.services.core.AMapException e2) {
            com.amap.api.col.s.i.a(e2, "ShareSearch", "searchNaviShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchNaviShareUrlAsyn(com.amap.api.services.share.ShareSearch.ShareNaviQuery shareNaviQuery) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.bf.AnonymousClass5(shareNaviQuery));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final java.lang.String searchPoiShareUrl(com.amap.api.services.core.PoiItem poiItem) throws com.amap.api.services.core.AMapException {
        if (poiItem != null) {
            try {
                if (poiItem.getLatLonPoint() != null) {
                    com.amap.api.services.core.LatLonPoint latLonPoint = poiItem.getLatLonPoint();
                    return new com.amap.api.col.s.ak(this.a, java.lang.String.format(f, poiItem.getPoiId(), java.lang.Double.valueOf(latLonPoint.getLatitude()), java.lang.Double.valueOf(latLonPoint.getLongitude()), poiItem.getTitle(), poiItem.getSnippet())).b();
                }
            } catch (com.amap.api.services.core.AMapException e2) {
                com.amap.api.col.s.i.a(e2, "ShareSearch", "searchPoiShareUrl");
                throw e2;
            }
        }
        throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchPoiShareUrlAsyn(com.amap.api.services.core.PoiItem poiItem) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.bf.AnonymousClass1(poiItem));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final java.lang.String searchWalkRouteShareUrl(com.amap.api.services.share.ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) throws com.amap.api.services.core.AMapException {
        try {
            if (shareWalkRouteQuery == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            int walkMode = shareWalkRouteQuery.getWalkMode();
            com.amap.api.services.share.ShareSearch.ShareFromAndTo shareFromAndTo = shareWalkRouteQuery.getShareFromAndTo();
            if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            com.amap.api.services.core.LatLonPoint from = shareFromAndTo.getFrom();
            com.amap.api.services.core.LatLonPoint to = shareFromAndTo.getTo();
            java.lang.String fromName = shareFromAndTo.getFromName();
            java.lang.String toName = shareFromAndTo.getToName();
            java.lang.String str = c;
            java.lang.String str2 = g;
            return new com.amap.api.col.s.ak(this.a, java.lang.String.format(str, java.lang.Double.valueOf(from.getLatitude()), java.lang.Double.valueOf(from.getLongitude()), fromName, java.lang.Double.valueOf(to.getLatitude()), java.lang.Double.valueOf(to.getLongitude()), toName, java.lang.Integer.valueOf(walkMode), 2, 0, str2, str2, str2)).b();
        } catch (com.amap.api.services.core.AMapException e2) {
            com.amap.api.col.s.i.a(e2, "ShareSearch", "searchWalkRouteShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchWalkRouteShareUrlAsyn(com.amap.api.services.share.ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.bf.AnonymousClass3(shareWalkRouteQuery));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void setOnShareSearchListener(com.amap.api.services.share.ShareSearch.OnShareSearchListener onShareSearchListener) {
        this.b = onShareSearchListener;
    }
}
