package com.amap.api.services.poisearch;

/* loaded from: classes12.dex */
public class PoiSearch {
    public static final java.lang.String CHINESE = "zh-CN";
    public static final java.lang.String ENGLISH = "en";
    public static final java.lang.String EXTENSIONS_ALL = "all";
    public static final java.lang.String EXTENSIONS_BASE = "base";
    private com.amap.api.services.interfaces.IPoiSearch a;

    public interface OnPoiSearchListener {
        void onPoiItemSearched(com.amap.api.services.core.PoiItem poiItem, int i);

        void onPoiSearched(com.amap.api.services.poisearch.PoiResult poiResult, int i);
    }

    public static class Query implements java.lang.Cloneable {
        private java.lang.String a;
        private java.lang.String b;
        private java.lang.String c;
        private int d;
        private int e;
        private java.lang.String f;
        private boolean g;
        private boolean h;
        private java.lang.String i;
        private boolean j;
        private com.amap.api.services.core.LatLonPoint k;
        private boolean l;
        private java.lang.String m;

        public Query(java.lang.String str, java.lang.String str2) {
            this(str, str2, null);
        }

        public Query(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.d = 1;
            this.e = 20;
            this.f = "zh-CN";
            this.g = false;
            this.h = false;
            this.j = true;
            this.l = true;
            this.m = "base";
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        private static java.lang.String a() {
            return "";
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public com.amap.api.services.poisearch.PoiSearch.Query m31clone() {
            try {
                super.clone();
            } catch (java.lang.CloneNotSupportedException e) {
                com.amap.api.col.s.i.a(e, "PoiSearch", "queryclone");
            }
            com.amap.api.services.poisearch.PoiSearch.Query query = new com.amap.api.services.poisearch.PoiSearch.Query(this.a, this.b, this.c);
            query.setPageNum(this.d);
            query.setPageSize(this.e);
            query.setQueryLanguage(this.f);
            query.setCityLimit(this.g);
            query.requireSubPois(this.h);
            query.setBuilding(this.i);
            query.setLocation(this.k);
            query.setDistanceSort(this.j);
            query.setSpecial(this.l);
            query.setExtensions(this.m);
            return query;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.amap.api.services.poisearch.PoiSearch.Query query = (com.amap.api.services.poisearch.PoiSearch.Query) obj;
            java.lang.String str = this.b;
            if (str == null) {
                if (query.b != null) {
                    return false;
                }
            } else if (!str.equals(query.b)) {
                return false;
            }
            java.lang.String str2 = this.c;
            if (str2 == null) {
                if (query.c != null) {
                    return false;
                }
            } else if (!str2.equals(query.c)) {
                return false;
            }
            java.lang.String str3 = this.f;
            if (str3 == null) {
                if (query.f != null) {
                    return false;
                }
            } else if (!str3.equals(query.f)) {
                return false;
            }
            if (this.d != query.d || this.e != query.e) {
                return false;
            }
            java.lang.String str4 = this.a;
            if (str4 == null) {
                if (query.a != null) {
                    return false;
                }
            } else if (!str4.equals(query.a)) {
                return false;
            }
            java.lang.String str5 = this.i;
            if (str5 == null) {
                if (query.i != null) {
                    return false;
                }
            } else if (!str5.equals(query.i)) {
                return false;
            }
            if (this.g != query.g || this.h != query.h || this.l != query.l) {
                return false;
            }
            java.lang.String str6 = this.m;
            if (str6 == null) {
                if (query.m != null) {
                    return false;
                }
            } else if (!str6.equals(query.m)) {
                return false;
            }
            return true;
        }

        public java.lang.String getBuilding() {
            return this.i;
        }

        public java.lang.String getCategory() {
            java.lang.String str = this.b;
            return (str == null || str.equals(org.apache.tools.tar.TarConstants.VERSION_POSIX) || this.b.equals("00|")) ? a() : this.b;
        }

        public java.lang.String getCity() {
            return this.c;
        }

        public boolean getCityLimit() {
            return this.g;
        }

        public java.lang.String getExtensions() {
            return this.m;
        }

        public com.amap.api.services.core.LatLonPoint getLocation() {
            return this.k;
        }

        public int getPageNum() {
            return this.d;
        }

        public int getPageSize() {
            return this.e;
        }

        public java.lang.String getQueryLanguage() {
            return this.f;
        }

        public java.lang.String getQueryString() {
            return this.a;
        }

        public int hashCode() {
            java.lang.String str = this.b;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            java.lang.String str2 = this.c;
            int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + (this.g ? 1231 : 1237)) * 31) + (this.h ? 1231 : 1237)) * 31;
            java.lang.String str3 = this.f;
            int hashCode3 = (((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.d) * 31) + this.e) * 31;
            java.lang.String str4 = this.a;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            java.lang.String str5 = this.i;
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.j;
        }

        public boolean isRequireSubPois() {
            return this.h;
        }

        public boolean isSpecial() {
            return this.l;
        }

        public boolean queryEquals(com.amap.api.services.poisearch.PoiSearch.Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return com.amap.api.services.poisearch.PoiSearch.b(query.a, this.a) && com.amap.api.services.poisearch.PoiSearch.b(query.b, this.b) && com.amap.api.services.poisearch.PoiSearch.b(query.f, this.f) && com.amap.api.services.poisearch.PoiSearch.b(query.c, this.c) && com.amap.api.services.poisearch.PoiSearch.b(query.m, this.m) && com.amap.api.services.poisearch.PoiSearch.b(query.i, this.i) && query.g == this.g && query.e == this.e && query.j == this.j && query.l == this.l;
        }

        public void requireSubPois(boolean z) {
            this.h = z;
        }

        public void setBuilding(java.lang.String str) {
            this.i = str;
        }

        public void setCityLimit(boolean z) {
            this.g = z;
        }

        public void setDistanceSort(boolean z) {
            this.j = z;
        }

        public void setExtensions(java.lang.String str) {
            this.m = str;
        }

        public void setLocation(com.amap.api.services.core.LatLonPoint latLonPoint) {
            this.k = latLonPoint;
        }

        public void setPageNum(int i) {
            if (i <= 0) {
                i = 1;
            }
            this.d = i;
        }

        public void setPageSize(int i) {
            if (i <= 0) {
                this.e = 20;
            } else if (i > 30) {
                this.e = 30;
            } else {
                this.e = i;
            }
        }

        public void setQueryLanguage(java.lang.String str) {
            if ("en".equals(str)) {
                this.f = "en";
            } else {
                this.f = "zh-CN";
            }
        }

        public void setSpecial(boolean z) {
            this.l = z;
        }
    }

    public static class SearchBound implements java.lang.Cloneable {
        public static final java.lang.String BOUND_SHAPE = "Bound";
        public static final java.lang.String ELLIPSE_SHAPE = "Ellipse";
        public static final java.lang.String POLYGON_SHAPE = "Polygon";
        public static final java.lang.String RECTANGLE_SHAPE = "Rectangle";
        private com.amap.api.services.core.LatLonPoint a;
        private com.amap.api.services.core.LatLonPoint b;
        private int c;
        private com.amap.api.services.core.LatLonPoint d;
        private java.lang.String e;
        private boolean f;
        private java.util.List<com.amap.api.services.core.LatLonPoint> g;

        public SearchBound(com.amap.api.services.core.LatLonPoint latLonPoint, int i) {
            this.f = true;
            this.e = "Bound";
            this.c = i;
            this.d = latLonPoint;
        }

        public SearchBound(com.amap.api.services.core.LatLonPoint latLonPoint, int i, boolean z) {
            this.e = "Bound";
            this.c = i;
            this.d = latLonPoint;
            this.f = z;
        }

        public SearchBound(com.amap.api.services.core.LatLonPoint latLonPoint, com.amap.api.services.core.LatLonPoint latLonPoint2) {
            this.c = 1500;
            this.f = true;
            this.e = "Rectangle";
            a(latLonPoint, latLonPoint2);
        }

        private SearchBound(com.amap.api.services.core.LatLonPoint latLonPoint, com.amap.api.services.core.LatLonPoint latLonPoint2, int i, com.amap.api.services.core.LatLonPoint latLonPoint3, java.lang.String str, java.util.List<com.amap.api.services.core.LatLonPoint> list, boolean z) {
            this.a = latLonPoint;
            this.b = latLonPoint2;
            this.c = i;
            this.d = latLonPoint3;
            this.e = str;
            this.g = list;
            this.f = z;
        }

        public SearchBound(java.util.List<com.amap.api.services.core.LatLonPoint> list) {
            this.c = 1500;
            this.f = true;
            this.e = "Polygon";
            this.g = list;
        }

        private void a(com.amap.api.services.core.LatLonPoint latLonPoint, com.amap.api.services.core.LatLonPoint latLonPoint2) {
            this.a = latLonPoint;
            this.b = latLonPoint2;
            if (latLonPoint.getLatitude() >= this.b.getLatitude() || this.a.getLongitude() >= this.b.getLongitude()) {
                new java.lang.IllegalArgumentException("invalid rect ").printStackTrace();
            }
            this.d = new com.amap.api.services.core.LatLonPoint((this.a.getLatitude() + this.b.getLatitude()) / 2.0d, (this.a.getLongitude() + this.b.getLongitude()) / 2.0d);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public com.amap.api.services.poisearch.PoiSearch.SearchBound m32clone() {
            try {
                super.clone();
            } catch (java.lang.CloneNotSupportedException e) {
                com.amap.api.col.s.i.a(e, "PoiSearch", "SearchBoundClone");
            }
            return new com.amap.api.services.poisearch.PoiSearch.SearchBound(this.a, this.b, this.c, this.d, this.e, this.g, this.f);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.amap.api.services.poisearch.PoiSearch.SearchBound searchBound = (com.amap.api.services.poisearch.PoiSearch.SearchBound) obj;
            com.amap.api.services.core.LatLonPoint latLonPoint = this.d;
            if (latLonPoint == null) {
                if (searchBound.d != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(searchBound.d)) {
                return false;
            }
            if (this.f != searchBound.f) {
                return false;
            }
            com.amap.api.services.core.LatLonPoint latLonPoint2 = this.a;
            if (latLonPoint2 == null) {
                if (searchBound.a != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(searchBound.a)) {
                return false;
            }
            com.amap.api.services.core.LatLonPoint latLonPoint3 = this.b;
            if (latLonPoint3 == null) {
                if (searchBound.b != null) {
                    return false;
                }
            } else if (!latLonPoint3.equals(searchBound.b)) {
                return false;
            }
            java.util.List<com.amap.api.services.core.LatLonPoint> list = this.g;
            if (list == null) {
                if (searchBound.g != null) {
                    return false;
                }
            } else if (!list.equals(searchBound.g)) {
                return false;
            }
            if (this.c != searchBound.c) {
                return false;
            }
            java.lang.String str = this.e;
            if (str == null) {
                if (searchBound.e != null) {
                    return false;
                }
            } else if (!str.equals(searchBound.e)) {
                return false;
            }
            return true;
        }

        public com.amap.api.services.core.LatLonPoint getCenter() {
            return this.d;
        }

        public com.amap.api.services.core.LatLonPoint getLowerLeft() {
            return this.a;
        }

        public java.util.List<com.amap.api.services.core.LatLonPoint> getPolyGonList() {
            return this.g;
        }

        public int getRange() {
            return this.c;
        }

        public java.lang.String getShape() {
            return this.e;
        }

        public com.amap.api.services.core.LatLonPoint getUpperRight() {
            return this.b;
        }

        public int hashCode() {
            com.amap.api.services.core.LatLonPoint latLonPoint = this.d;
            int hashCode = ((((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31) + (this.f ? 1231 : 1237)) * 31;
            com.amap.api.services.core.LatLonPoint latLonPoint2 = this.a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            com.amap.api.services.core.LatLonPoint latLonPoint3 = this.b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            java.util.List<com.amap.api.services.core.LatLonPoint> list = this.g;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.c) * 31;
            java.lang.String str = this.e;
            return hashCode4 + (str != null ? str.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f;
        }
    }

    public PoiSearch(android.content.Context context, com.amap.api.services.poisearch.PoiSearch.Query query) throws com.amap.api.services.core.AMapException {
        this.a = null;
        try {
            this.a = new com.amap.api.col.s.bc(context, query);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            if (e instanceof com.amap.api.services.core.AMapException) {
                throw ((com.amap.api.services.core.AMapException) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(java.lang.String str, java.lang.String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public com.amap.api.services.poisearch.PoiSearch.SearchBound getBound() {
        com.amap.api.services.interfaces.IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            return iPoiSearch.getBound();
        }
        return null;
    }

    public java.lang.String getLanguage() {
        com.amap.api.services.interfaces.IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            return iPoiSearch.getLanguage();
        }
        return null;
    }

    public com.amap.api.services.poisearch.PoiSearch.Query getQuery() {
        com.amap.api.services.interfaces.IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            return iPoiSearch.getQuery();
        }
        return null;
    }

    public com.amap.api.services.poisearch.PoiResult searchPOI() throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOI();
        }
        return null;
    }

    public void searchPOIAsyn() {
        com.amap.api.services.interfaces.IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIAsyn();
        }
    }

    public com.amap.api.services.core.PoiItem searchPOIId(java.lang.String str) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOIId(str);
        }
        return null;
    }

    public void searchPOIIdAsyn(java.lang.String str) {
        com.amap.api.services.interfaces.IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIIdAsyn(str);
        }
    }

    public void setBound(com.amap.api.services.poisearch.PoiSearch.SearchBound searchBound) {
        com.amap.api.services.interfaces.IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            iPoiSearch.setBound(searchBound);
        }
    }

    public void setLanguage(java.lang.String str) {
        com.amap.api.services.interfaces.IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            iPoiSearch.setLanguage(str);
        }
    }

    public void setOnPoiSearchListener(com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener onPoiSearchListener) {
        com.amap.api.services.interfaces.IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            iPoiSearch.setOnPoiSearchListener(onPoiSearchListener);
        }
    }

    public void setQuery(com.amap.api.services.poisearch.PoiSearch.Query query) {
        com.amap.api.services.interfaces.IPoiSearch iPoiSearch = this.a;
        if (iPoiSearch != null) {
            iPoiSearch.setQuery(query);
        }
    }
}
