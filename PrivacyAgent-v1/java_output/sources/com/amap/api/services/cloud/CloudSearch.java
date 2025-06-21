package com.amap.api.services.cloud;

/* loaded from: classes12.dex */
public class CloudSearch {
    private com.amap.api.services.interfaces.ICloudSearch a;

    public interface OnCloudSearchListener {
        void onCloudItemDetailSearched(com.amap.api.services.cloud.CloudItemDetail cloudItemDetail, int i);

        void onCloudSearched(com.amap.api.services.cloud.CloudResult cloudResult, int i);
    }

    public static class Query implements java.lang.Cloneable {
        private java.lang.String a;
        private java.lang.String d;
        private com.amap.api.services.cloud.CloudSearch.SearchBound e;
        private com.amap.api.services.cloud.CloudSearch.Sortingrules f;
        private int b = 1;
        private int c = 20;
        private java.util.ArrayList<com.amap.api.col.s.z> g = new java.util.ArrayList<>();
        private java.util.List<java.lang.String> h = new java.util.ArrayList();

        private Query() {
        }

        public Query(java.lang.String str, java.lang.String str2, com.amap.api.services.cloud.CloudSearch.SearchBound searchBound) throws com.amap.api.services.core.AMapException {
            if (com.amap.api.col.s.i.a(str) || searchBound == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            this.d = str;
            this.a = str2;
            this.e = searchBound;
        }

        private java.util.ArrayList<com.amap.api.col.s.z> a() {
            if (this.g == null) {
                return null;
            }
            java.util.ArrayList<com.amap.api.col.s.z> arrayList = new java.util.ArrayList<>();
            arrayList.addAll(this.g);
            return arrayList;
        }

        private static boolean a(com.amap.api.services.cloud.CloudSearch.SearchBound searchBound, com.amap.api.services.cloud.CloudSearch.SearchBound searchBound2) {
            if (searchBound == null && searchBound2 == null) {
                return true;
            }
            if (searchBound == null || searchBound2 == null) {
                return false;
            }
            return searchBound.equals(searchBound2);
        }

        private static boolean a(com.amap.api.services.cloud.CloudSearch.Sortingrules sortingrules, com.amap.api.services.cloud.CloudSearch.Sortingrules sortingrules2) {
            if (sortingrules == null && sortingrules2 == null) {
                return true;
            }
            if (sortingrules == null || sortingrules2 == null) {
                return false;
            }
            return sortingrules.equals(sortingrules2);
        }

        private java.util.ArrayList<java.lang.String> b() {
            if (this.h == null) {
                return null;
            }
            java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
            arrayList.addAll(this.h);
            return arrayList;
        }

        public void addFilterNum(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.g.add(new com.amap.api.col.s.z(str, str2, str3));
        }

        public void addFilterString(java.lang.String str, java.lang.String str2) {
            if (str == null || str2 == null) {
                return;
            }
            this.h.add(str + str2);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0043 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x003d  */
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.amap.api.services.cloud.CloudSearch.Query m28clone() {
            com.amap.api.services.cloud.CloudSearch.Query query;
            com.amap.api.services.core.AMapException e;
            try {
                super.clone();
            } catch (java.lang.CloneNotSupportedException e2) {
                e2.printStackTrace();
            }
            try {
                query = new com.amap.api.services.cloud.CloudSearch.Query(this.d, this.a, this.e);
                try {
                    query.setPageNum(this.b);
                    query.setPageSize(this.c);
                    query.setSortingrules(getSortingrules());
                    query.g = a();
                    query.h = b();
                } catch (com.amap.api.services.core.AMapException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (query != null) {
                    }
                }
            } catch (com.amap.api.services.core.AMapException e4) {
                query = null;
                e = e4;
            }
            return query != null ? new com.amap.api.services.cloud.CloudSearch.Query() : query;
        }

        public boolean equals(java.lang.Object obj) {
            if (obj != null && (obj instanceof com.amap.api.services.cloud.CloudSearch.Query)) {
                if (obj == this) {
                    return true;
                }
                com.amap.api.services.cloud.CloudSearch.Query query = (com.amap.api.services.cloud.CloudSearch.Query) obj;
                if (queryEquals(query) && query.b == this.b) {
                    return true;
                }
            }
            return false;
        }

        public com.amap.api.services.cloud.CloudSearch.SearchBound getBound() {
            return this.e;
        }

        public java.lang.String getFilterNumString() {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            try {
                int size = this.g.size();
                for (int i = 0; i < size; i++) {
                    com.amap.api.col.s.z zVar = this.g.get(i);
                    stringBuffer.append(zVar.a());
                    stringBuffer.append(">=");
                    stringBuffer.append(zVar.b());
                    stringBuffer.append("&&");
                    stringBuffer.append(zVar.a());
                    stringBuffer.append("<=");
                    stringBuffer.append(zVar.c());
                    if (i != size - 1) {
                        stringBuffer.append("&&");
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public java.lang.String getFilterString() {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            try {
                int size = this.h.size();
                for (int i = 0; i < size; i++) {
                    stringBuffer.append(this.h.get(i));
                    if (i != size - 1) {
                        stringBuffer.append("&&");
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public int getPageNum() {
            return this.b;
        }

        public int getPageSize() {
            return this.c;
        }

        public java.lang.String getQueryString() {
            return this.a;
        }

        public com.amap.api.services.cloud.CloudSearch.Sortingrules getSortingrules() {
            return this.f;
        }

        public java.lang.String getTableID() {
            return this.d;
        }

        public int hashCode() {
            java.util.ArrayList<com.amap.api.col.s.z> arrayList = this.g;
            int hashCode = ((arrayList == null ? 0 : arrayList.hashCode()) + 31) * 31;
            java.util.List<java.lang.String> list = this.h;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            com.amap.api.services.cloud.CloudSearch.SearchBound searchBound = this.e;
            int hashCode3 = (((((hashCode2 + (searchBound == null ? 0 : searchBound.hashCode())) * 31) + this.b) * 31) + this.c) * 31;
            java.lang.String str = this.a;
            int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            com.amap.api.services.cloud.CloudSearch.Sortingrules sortingrules = this.f;
            int hashCode5 = (hashCode4 + (sortingrules == null ? 0 : sortingrules.hashCode())) * 31;
            java.lang.String str2 = this.d;
            return hashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        public boolean queryEquals(com.amap.api.services.cloud.CloudSearch.Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return com.amap.api.services.cloud.CloudSearch.b(query.a, this.a) && com.amap.api.services.cloud.CloudSearch.b(query.getTableID(), getTableID()) && com.amap.api.services.cloud.CloudSearch.b(query.getFilterString(), getFilterString()) && com.amap.api.services.cloud.CloudSearch.b(query.getFilterNumString(), getFilterNumString()) && query.c == this.c && a(query.getBound(), getBound()) && a(query.getSortingrules(), getSortingrules());
        }

        public void setBound(com.amap.api.services.cloud.CloudSearch.SearchBound searchBound) {
            this.e = searchBound;
        }

        public void setPageNum(int i) {
            this.b = i;
        }

        public void setPageSize(int i) {
            if (i <= 0) {
                this.c = 20;
            } else if (i > 100) {
                this.c = 100;
            } else {
                this.c = i;
            }
        }

        public void setSortingrules(com.amap.api.services.cloud.CloudSearch.Sortingrules sortingrules) {
            this.f = sortingrules;
        }

        public void setTableID(java.lang.String str) {
            this.d = str;
        }
    }

    public static class SearchBound implements java.lang.Cloneable {
        public static final java.lang.String BOUND_SHAPE = "Bound";
        public static final java.lang.String LOCAL_SHAPE = "Local";
        public static final java.lang.String POLYGON_SHAPE = "Polygon";
        public static final java.lang.String RECTANGLE_SHAPE = "Rectangle";
        private com.amap.api.services.core.LatLonPoint a;
        private com.amap.api.services.core.LatLonPoint b;
        private int c;
        private com.amap.api.services.core.LatLonPoint d;
        private java.lang.String e;
        private java.util.List<com.amap.api.services.core.LatLonPoint> f;
        private java.lang.String g;

        public SearchBound(com.amap.api.services.core.LatLonPoint latLonPoint, int i) {
            this.e = "Bound";
            this.c = i;
            this.d = latLonPoint;
        }

        public SearchBound(com.amap.api.services.core.LatLonPoint latLonPoint, com.amap.api.services.core.LatLonPoint latLonPoint2) {
            this.e = "Rectangle";
            if (a(latLonPoint, latLonPoint2)) {
                return;
            }
            new java.lang.IllegalArgumentException("invalid rect ").printStackTrace();
        }

        public SearchBound(java.lang.String str) {
            this.e = LOCAL_SHAPE;
            this.g = str;
        }

        public SearchBound(java.util.List<com.amap.api.services.core.LatLonPoint> list) {
            this.e = "Polygon";
            this.f = list;
        }

        private java.util.List<com.amap.api.services.core.LatLonPoint> a() {
            if (this.f == null) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (com.amap.api.services.core.LatLonPoint latLonPoint : this.f) {
                arrayList.add(new com.amap.api.services.core.LatLonPoint(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
            }
            return arrayList;
        }

        private boolean a(com.amap.api.services.core.LatLonPoint latLonPoint, com.amap.api.services.core.LatLonPoint latLonPoint2) {
            this.a = latLonPoint;
            this.b = latLonPoint2;
            return latLonPoint != null && latLonPoint2 != null && latLonPoint.getLatitude() < this.b.getLatitude() && this.a.getLongitude() < this.b.getLongitude();
        }

        private static boolean a(java.util.List<com.amap.api.services.core.LatLonPoint> list, java.util.List<com.amap.api.services.core.LatLonPoint> list2) {
            if (list == null && list2 == null) {
                return true;
            }
            if (list == null || list2 == null || list.size() != list2.size()) {
                return false;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (!list.get(i).equals(list2.get(i))) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public com.amap.api.services.cloud.CloudSearch.SearchBound m29clone() {
            try {
                super.clone();
            } catch (java.lang.CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return getShape().equals("Bound") ? new com.amap.api.services.cloud.CloudSearch.SearchBound(this.d, this.c) : getShape().equals("Polygon") ? new com.amap.api.services.cloud.CloudSearch.SearchBound(a()) : getShape().equals(LOCAL_SHAPE) ? new com.amap.api.services.cloud.CloudSearch.SearchBound(this.g) : new com.amap.api.services.cloud.CloudSearch.SearchBound(this.a, this.b);
        }

        public boolean equals(java.lang.Object obj) {
            if (obj != null && (obj instanceof com.amap.api.services.cloud.CloudSearch.SearchBound)) {
                com.amap.api.services.cloud.CloudSearch.SearchBound searchBound = (com.amap.api.services.cloud.CloudSearch.SearchBound) obj;
                if (!getShape().equalsIgnoreCase(searchBound.getShape())) {
                    return false;
                }
                if (getShape().equals("Bound")) {
                    return searchBound.d.equals(this.d) && searchBound.c == this.c;
                }
                if (getShape().equals("Polygon")) {
                    return a(searchBound.f, this.f);
                }
                if (getShape().equals(LOCAL_SHAPE)) {
                    return searchBound.g.equals(this.g);
                }
                if (searchBound.a.equals(this.a) && searchBound.b.equals(this.b)) {
                    return true;
                }
            }
            return false;
        }

        public com.amap.api.services.core.LatLonPoint getCenter() {
            return this.d;
        }

        public java.lang.String getCity() {
            return this.g;
        }

        public com.amap.api.services.core.LatLonPoint getLowerLeft() {
            return this.a;
        }

        public java.util.List<com.amap.api.services.core.LatLonPoint> getPolyGonList() {
            return this.f;
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
            int hashCode = ((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31;
            com.amap.api.services.core.LatLonPoint latLonPoint2 = this.a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            com.amap.api.services.core.LatLonPoint latLonPoint3 = this.b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            java.util.List<com.amap.api.services.core.LatLonPoint> list = this.f;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.c) * 31;
            java.lang.String str = this.e;
            int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
            java.lang.String str2 = this.g;
            return hashCode5 + (str2 != null ? str2.hashCode() : 0);
        }
    }

    public static class Sortingrules {
        public static final int DISTANCE = 1;
        public static final int WEIGHT = 0;
        private int a;
        private java.lang.String b;
        private boolean c;

        public Sortingrules(int i) {
            this.c = true;
            this.a = i;
        }

        public Sortingrules(java.lang.String str, boolean z) {
            this.a = 0;
            this.b = str;
            this.c = z;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.amap.api.services.cloud.CloudSearch.Sortingrules sortingrules = (com.amap.api.services.cloud.CloudSearch.Sortingrules) obj;
            if (this.c != sortingrules.c) {
                return false;
            }
            java.lang.String str = this.b;
            if (str == null) {
                if (sortingrules.b != null) {
                    return false;
                }
            } else if (!str.equals(sortingrules.b)) {
                return false;
            }
            return this.a == sortingrules.a;
        }

        public int hashCode() {
            int i = ((this.c ? 1231 : 1237) + 31) * 31;
            java.lang.String str = this.b;
            return ((i + (str == null ? 0 : str.hashCode())) * 31) + this.a;
        }

        public java.lang.String toString() {
            if (com.amap.api.col.s.i.a(this.b)) {
                int i = this.a;
                return i == 0 ? "_weight:desc" : i == 1 ? "_distance:asc" : "";
            }
            if (this.c) {
                return this.b + ":asc";
            }
            return this.b + ":desc";
        }
    }

    public CloudSearch(android.content.Context context) throws com.amap.api.services.core.AMapException {
        if (this.a == null) {
            try {
                this.a = new com.amap.api.col.s.aw(context);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                if (e instanceof com.amap.api.services.core.AMapException) {
                    throw ((com.amap.api.services.core.AMapException) e);
                }
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

    public void searchCloudAsyn(com.amap.api.services.cloud.CloudSearch.Query query) {
        com.amap.api.services.interfaces.ICloudSearch iCloudSearch = this.a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudAsyn(query);
        }
    }

    public void searchCloudDetailAsyn(java.lang.String str, java.lang.String str2) {
        com.amap.api.services.interfaces.ICloudSearch iCloudSearch = this.a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudDetailAsyn(str, str2);
        }
    }

    public void setOnCloudSearchListener(com.amap.api.services.cloud.CloudSearch.OnCloudSearchListener onCloudSearchListener) {
        com.amap.api.services.interfaces.ICloudSearch iCloudSearch = this.a;
        if (iCloudSearch != null) {
            iCloudSearch.setOnCloudSearchListener(onCloudSearchListener);
        }
    }
}
