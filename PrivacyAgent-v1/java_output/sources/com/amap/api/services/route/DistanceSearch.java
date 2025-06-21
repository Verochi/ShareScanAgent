package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class DistanceSearch {
    public static final java.lang.String EXTENSIONS_ALL = "all";
    public static final java.lang.String EXTENSIONS_BASE = "base";
    public static final int TYPE_DISTANCE = 0;
    public static final int TYPE_DRIVING_DISTANCE = 1;
    public static final int TYPE_WALK_DISTANCE = 3;
    private com.amap.api.services.interfaces.IDistanceSearch a;

    public static class DistanceQuery implements android.os.Parcelable, java.lang.Cloneable {
        public static final android.os.Parcelable.Creator<com.amap.api.services.route.DistanceSearch.DistanceQuery> CREATOR = new com.amap.api.services.route.DistanceSearch.DistanceQuery.AnonymousClass1();
        private int a;
        private java.util.List<com.amap.api.services.core.LatLonPoint> b;
        private com.amap.api.services.core.LatLonPoint c;
        private java.lang.String d;
        private int e;

        /* renamed from: com.amap.api.services.route.DistanceSearch$DistanceQuery$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.DistanceSearch.DistanceQuery> {
            private static com.amap.api.services.route.DistanceSearch.DistanceQuery a(android.os.Parcel parcel) {
                return new com.amap.api.services.route.DistanceSearch.DistanceQuery(parcel);
            }

            private static com.amap.api.services.route.DistanceSearch.DistanceQuery[] a(int i) {
                return new com.amap.api.services.route.DistanceSearch.DistanceQuery[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.amap.api.services.route.DistanceSearch.DistanceQuery createFromParcel(android.os.Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.amap.api.services.route.DistanceSearch.DistanceQuery[] newArray(int i) {
                return a(i);
            }
        }

        public DistanceQuery() {
            this.a = 1;
            this.b = new java.util.ArrayList();
            this.d = "base";
            this.e = 4;
        }

        public DistanceQuery(android.os.Parcel parcel) {
            this.a = 1;
            this.b = new java.util.ArrayList();
            this.d = "base";
            this.e = 4;
            this.a = parcel.readInt();
            this.b = parcel.createTypedArrayList(com.amap.api.services.core.LatLonPoint.CREATOR);
            this.c = (com.amap.api.services.core.LatLonPoint) parcel.readParcelable(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
            this.d = parcel.readString();
            this.e = parcel.readInt();
        }

        public void addOrigins(com.amap.api.services.core.LatLonPoint... latLonPointArr) {
            for (com.amap.api.services.core.LatLonPoint latLonPoint : latLonPointArr) {
                if (latLonPoint != null) {
                    this.b.add(latLonPoint);
                }
            }
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public com.amap.api.services.route.DistanceSearch.DistanceQuery m33clone() {
            try {
                super.clone();
            } catch (java.lang.CloneNotSupportedException e) {
                com.amap.api.col.s.i.a(e, "DistanceSearch", "DistanceQueryclone");
            }
            com.amap.api.services.route.DistanceSearch.DistanceQuery distanceQuery = new com.amap.api.services.route.DistanceSearch.DistanceQuery();
            distanceQuery.setType(this.a);
            distanceQuery.setOrigins(this.b);
            distanceQuery.setDestination(this.c);
            distanceQuery.setExtensions(this.d);
            distanceQuery.setMode(this.e);
            return distanceQuery;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public com.amap.api.services.core.LatLonPoint getDestination() {
            return this.c;
        }

        public java.lang.String getExtensions() {
            return this.d;
        }

        public int getMode() {
            return this.e;
        }

        public java.util.List<com.amap.api.services.core.LatLonPoint> getOrigins() {
            return this.b;
        }

        public int getType() {
            return this.a;
        }

        public void setDestination(com.amap.api.services.core.LatLonPoint latLonPoint) {
            this.c = latLonPoint;
        }

        public void setExtensions(java.lang.String str) {
            this.d = str;
        }

        public void setMode(int i) {
            this.e = i;
        }

        public void setOrigins(java.util.List<com.amap.api.services.core.LatLonPoint> list) {
            if (list != null) {
                this.b = list;
            }
        }

        public void setType(int i) {
            this.a = i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeTypedList(this.b);
            parcel.writeParcelable(this.c, i);
            parcel.writeString(this.d);
            parcel.writeInt(this.e);
        }
    }

    public interface OnDistanceSearchListener {
        void onDistanceSearched(com.amap.api.services.route.DistanceResult distanceResult, int i);
    }

    public DistanceSearch(android.content.Context context) throws com.amap.api.services.core.AMapException {
        if (this.a == null) {
            try {
                this.a = new com.amap.api.col.s.ax(context);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                if (e instanceof com.amap.api.services.core.AMapException) {
                    throw ((com.amap.api.services.core.AMapException) e);
                }
            }
        }
    }

    public com.amap.api.services.route.DistanceResult calculateRouteDistance(com.amap.api.services.route.DistanceSearch.DistanceQuery distanceQuery) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IDistanceSearch iDistanceSearch = this.a;
        if (iDistanceSearch != null) {
            return iDistanceSearch.calculateRouteDistance(distanceQuery);
        }
        return null;
    }

    public void calculateRouteDistanceAsyn(com.amap.api.services.route.DistanceSearch.DistanceQuery distanceQuery) {
        com.amap.api.services.interfaces.IDistanceSearch iDistanceSearch = this.a;
        if (iDistanceSearch != null) {
            iDistanceSearch.calculateRouteDistanceAsyn(distanceQuery);
        }
    }

    public void setDistanceSearchListener(com.amap.api.services.route.DistanceSearch.OnDistanceSearchListener onDistanceSearchListener) {
        com.amap.api.services.interfaces.IDistanceSearch iDistanceSearch = this.a;
        if (iDistanceSearch != null) {
            iDistanceSearch.setDistanceSearchListener(onDistanceSearchListener);
        }
    }
}
