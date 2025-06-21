package com.amap.api.services.nearby;

/* loaded from: classes12.dex */
public class NearbySearch {
    public static final int AMAP = 1;
    public static final int GPS = 0;
    private static com.amap.api.services.nearby.NearbySearch a;
    private com.amap.api.services.interfaces.INearbySearch b;

    /* renamed from: com.amap.api.services.nearby.NearbySearch$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.amap.api.services.nearby.NearbySearchFunctionType.values().length];
            a = iArr;
            try {
                iArr[com.amap.api.services.nearby.NearbySearchFunctionType.DISTANCE_SEARCH.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.amap.api.services.nearby.NearbySearchFunctionType.DRIVING_DISTANCE_SEARCH.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public interface NearbyListener {
        void onNearbyInfoSearched(com.amap.api.services.nearby.NearbySearchResult nearbySearchResult, int i);

        void onNearbyInfoUploaded(int i);

        void onUserInfoCleared(int i);
    }

    public static class NearbyQuery {
        private com.amap.api.services.core.LatLonPoint a;
        private com.amap.api.services.nearby.NearbySearchFunctionType b = com.amap.api.services.nearby.NearbySearchFunctionType.DISTANCE_SEARCH;
        private int c = 1000;
        private int d = 1800;
        private int e = 1;

        public com.amap.api.services.core.LatLonPoint getCenterPoint() {
            return this.a;
        }

        public int getCoordType() {
            return this.e;
        }

        public int getRadius() {
            return this.c;
        }

        public int getTimeRange() {
            return this.d;
        }

        public int getType() {
            int i = com.amap.api.services.nearby.NearbySearch.AnonymousClass1.a[this.b.ordinal()];
            return (i == 1 || i != 2) ? 0 : 1;
        }

        public void setCenterPoint(com.amap.api.services.core.LatLonPoint latLonPoint) {
            this.a = latLonPoint;
        }

        public void setCoordType(int i) {
            if (i == 0 || i == 1) {
                this.e = i;
            } else {
                this.e = 1;
            }
        }

        public void setRadius(int i) {
            if (i > 10000) {
                i = 10000;
            }
            this.c = i;
        }

        public void setTimeRange(int i) {
            if (i < 5) {
                i = 5;
            } else if (i > 86400) {
                i = 86400;
            }
            this.d = i;
        }

        public void setType(com.amap.api.services.nearby.NearbySearchFunctionType nearbySearchFunctionType) {
            this.b = nearbySearchFunctionType;
        }
    }

    private NearbySearch(android.content.Context context) throws com.amap.api.services.core.AMapException {
        if (this.b == null) {
            try {
                this.b = new com.amap.api.col.s.bb(context);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                if (e instanceof com.amap.api.services.core.AMapException) {
                    throw ((com.amap.api.services.core.AMapException) e);
                }
            }
        }
    }

    private void a() {
        com.amap.api.services.interfaces.INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.destroy();
        }
        this.b = null;
    }

    public static synchronized void destroy() {
        synchronized (com.amap.api.services.nearby.NearbySearch.class) {
            com.amap.api.services.nearby.NearbySearch nearbySearch = a;
            if (nearbySearch != null) {
                try {
                    nearbySearch.a();
                } catch (java.lang.Throwable th) {
                    com.amap.api.col.s.i.a(th, "NearbySearch", "destryoy");
                }
            }
            a = null;
        }
    }

    public static synchronized com.amap.api.services.nearby.NearbySearch getInstance(android.content.Context context) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.nearby.NearbySearch nearbySearch;
        synchronized (com.amap.api.services.nearby.NearbySearch.class) {
            if (a == null) {
                try {
                    a = new com.amap.api.services.nearby.NearbySearch(context);
                } catch (com.amap.api.services.core.AMapException e) {
                    throw e;
                }
            }
            nearbySearch = a;
        }
        return nearbySearch;
    }

    public synchronized void addNearbyListener(com.amap.api.services.nearby.NearbySearch.NearbyListener nearbyListener) {
        com.amap.api.services.interfaces.INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.addNearbyListener(nearbyListener);
        }
    }

    public void clearUserInfoAsyn() {
        com.amap.api.services.interfaces.INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.clearUserInfoAsyn();
        }
    }

    public synchronized void removeNearbyListener(com.amap.api.services.nearby.NearbySearch.NearbyListener nearbyListener) {
        com.amap.api.services.interfaces.INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.removeNearbyListener(nearbyListener);
        }
    }

    public com.amap.api.services.nearby.NearbySearchResult searchNearbyInfo(com.amap.api.services.nearby.NearbySearch.NearbyQuery nearbyQuery) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            return iNearbySearch.searchNearbyInfo(nearbyQuery);
        }
        return null;
    }

    public void searchNearbyInfoAsyn(com.amap.api.services.nearby.NearbySearch.NearbyQuery nearbyQuery) {
        com.amap.api.services.interfaces.INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.searchNearbyInfoAsyn(nearbyQuery);
        }
    }

    public void setUserID(java.lang.String str) {
        com.amap.api.services.interfaces.INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.setUserID(str);
        }
    }

    public synchronized void startUploadNearbyInfoAuto(com.amap.api.services.nearby.UploadInfoCallback uploadInfoCallback, int i) {
        com.amap.api.services.interfaces.INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.startUploadNearbyInfoAuto(uploadInfoCallback, i);
        }
    }

    public synchronized void stopUploadNearbyInfoAuto() {
        com.amap.api.services.interfaces.INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.stopUploadNearbyInfoAuto();
        }
    }

    public void uploadNearbyInfoAsyn(com.amap.api.services.nearby.UploadInfo uploadInfo) {
        com.amap.api.services.interfaces.INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.uploadNearbyInfoAsyn(uploadInfo);
        }
    }
}
