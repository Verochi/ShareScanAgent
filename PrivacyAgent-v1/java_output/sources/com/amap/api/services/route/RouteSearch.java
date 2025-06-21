package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class RouteSearch {
    public static final int BUS_COMFORTABLE = 4;
    public static final int BUS_DEFAULT = 0;
    public static final int BUS_LEASE_CHANGE = 2;
    public static final int BUS_LEASE_WALK = 3;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_SAVE_MONEY = 1;
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_CHOICE_HIGHWAY = 9;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_FASTEST_SAVE_MONEY = 11;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_NO_HIGHWAY = 4;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_SAVE_MONEY = 6;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_SAVE_MONEY_NO_HIGHWAY = 7;
    public static final int DRIVEING_PLAN_CHOICE_HIGHWAY = 8;
    public static final int DRIVEING_PLAN_DEFAULT = 1;
    public static final int DRIVEING_PLAN_FASTEST_SHORTEST = 10;
    public static final int DRIVEING_PLAN_NO_HIGHWAY = 2;
    public static final int DRIVEING_PLAN_SAVE_MONEY = 3;
    public static final int DRIVEING_PLAN_SAVE_MONEY_NO_HIGHWAY = 5;
    public static final java.lang.String DRIVING_EXCLUDE_FERRY = "ferry";
    public static final java.lang.String DRIVING_EXCLUDE_MOTORWAY = "motorway";
    public static final java.lang.String DRIVING_EXCLUDE_TOLL = "toll";
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION = 12;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY = 15;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY_SAVE_MONEY = 18;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_SAVE_MONEY = 17;
    public static final int DRIVING_MULTI_CHOICE_HIGHWAY = 19;
    public static final int DRIVING_MULTI_CHOICE_HIGHWAY_AVOID_CONGESTION = 20;
    public static final int DRIVING_MULTI_CHOICE_NO_HIGHWAY = 13;
    public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY = 14;
    public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY_NO_HIGHWAY = 16;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SAVE_MONEY_SHORTEST = 5;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST = 11;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST_AVOID_CONGESTION = 10;
    public static final int DRIVING_NORMAL_CAR = 0;
    public static final int DRIVING_PLUGIN_HYBRID_CAR = 2;
    public static final int DRIVING_PURE_ELECTRIC_VEHICLE = 1;
    public static final int DRIVING_SINGLE_AVOID_CONGESTION = 4;
    public static final int DRIVING_SINGLE_DEFAULT = 0;
    public static final int DRIVING_SINGLE_NO_EXPRESSWAYS = 3;
    public static final int DRIVING_SINGLE_NO_HIGHWAY = 6;
    public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY = 7;
    public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 9;
    public static final int DRIVING_SINGLE_SAVE_MONEY = 1;
    public static final int DRIVING_SINGLE_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SINGLE_SHORTEST = 2;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingMultiStrategy = 5;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;
    public static final java.lang.String EXTENSIONS_ALL = "all";
    public static final java.lang.String EXTENSIONS_BASE = "base";
    public static final int RIDING_DEFAULT = 0;
    public static final int RIDING_FAST = 2;
    public static final int RIDING_RECOMMEND = 1;
    public static final int RidingDefault = 0;
    public static final int RidingFast = 2;
    public static final int RidingRecommend = 1;
    public static final int TRUCK_AVOID_CONGESTION = 1;
    public static final int TRUCK_AVOID_CONGESTION_CHOICE_HIGHWAY = 9;
    public static final int TRUCK_AVOID_CONGESTION_NO_HIGHWAY = 4;
    public static final int TRUCK_AVOID_CONGESTION__SAVE_MONEY = 6;
    public static final int TRUCK_AVOID_CONGESTION__SAVE_MONEY_NO_HIGHWAY = 7;
    public static final int TRUCK_CHOICE_HIGHWAY = 8;
    public static final int TRUCK_NO_HIGHWAY = 2;
    public static final int TRUCK_SAVE_MONEY = 3;
    public static final int TRUCK_SAVE_MONEY_NO_HIGHWAY = 5;
    public static final int TRUCK_SIZE_HEAVY = 4;
    public static final int TRUCK_SIZE_LIGHT = 2;
    public static final int TRUCK_SIZE_MEDIUM = 3;
    public static final int TRUCK_SIZE_MINI = 1;
    public static final int WALK_DEFAULT = 0;
    public static final int WALK_MULTI_PATH = 1;
    public static final int WalkDefault = 0;
    public static final int WalkMultipath = 1;
    private com.amap.api.services.interfaces.IRouteSearch a;

    public static class BusRouteQuery implements android.os.Parcelable, java.lang.Cloneable {
        public static final android.os.Parcelable.Creator<com.amap.api.services.route.RouteSearch.BusRouteQuery> CREATOR = new com.amap.api.services.route.RouteSearch.BusRouteQuery.AnonymousClass1();
        private com.amap.api.services.route.RouteSearch.FromAndTo a;
        private int b;
        private java.lang.String c;
        private java.lang.String d;
        private int e;
        private java.lang.String f;

        /* renamed from: com.amap.api.services.route.RouteSearch$BusRouteQuery$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.RouteSearch.BusRouteQuery> {
            private static com.amap.api.services.route.RouteSearch.BusRouteQuery a(android.os.Parcel parcel) {
                return new com.amap.api.services.route.RouteSearch.BusRouteQuery(parcel);
            }

            private static com.amap.api.services.route.RouteSearch.BusRouteQuery[] a(int i) {
                return new com.amap.api.services.route.RouteSearch.BusRouteQuery[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.amap.api.services.route.RouteSearch.BusRouteQuery createFromParcel(android.os.Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.amap.api.services.route.RouteSearch.BusRouteQuery[] newArray(int i) {
                return a(i);
            }
        }

        public BusRouteQuery() {
            this.f = "base";
        }

        public BusRouteQuery(android.os.Parcel parcel) {
            this.f = "base";
            this.a = (com.amap.api.services.route.RouteSearch.FromAndTo) parcel.readParcelable(com.amap.api.services.route.RouteSearch.FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.readString();
            this.e = parcel.readInt();
            this.d = parcel.readString();
            this.f = parcel.readString();
        }

        public BusRouteQuery(com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo, int i, java.lang.String str, int i2) {
            this.f = "base";
            this.a = fromAndTo;
            this.b = i;
            this.c = str;
            this.e = i2;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public com.amap.api.services.route.RouteSearch.BusRouteQuery m34clone() {
            try {
                super.clone();
            } catch (java.lang.CloneNotSupportedException e) {
                com.amap.api.col.s.i.a(e, "RouteSearch", "BusRouteQueryclone");
            }
            com.amap.api.services.route.RouteSearch.BusRouteQuery busRouteQuery = new com.amap.api.services.route.RouteSearch.BusRouteQuery(this.a, this.b, this.c, this.e);
            busRouteQuery.setCityd(this.d);
            busRouteQuery.setExtensions(this.f);
            return busRouteQuery;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.amap.api.services.route.RouteSearch.BusRouteQuery busRouteQuery = (com.amap.api.services.route.RouteSearch.BusRouteQuery) obj;
            java.lang.String str = this.c;
            if (str == null) {
                if (busRouteQuery.c != null) {
                    return false;
                }
            } else if (!str.equals(busRouteQuery.c)) {
                return false;
            }
            java.lang.String str2 = this.d;
            if (str2 == null) {
                if (busRouteQuery.d != null) {
                    return false;
                }
            } else if (!str2.equals(busRouteQuery.d)) {
                return false;
            }
            java.lang.String str3 = this.f;
            if (str3 == null) {
                if (busRouteQuery.f != null) {
                    return false;
                }
            } else if (!str3.equals(busRouteQuery.f)) {
                return false;
            }
            com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo = this.a;
            if (fromAndTo == null) {
                if (busRouteQuery.a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(busRouteQuery.a)) {
                return false;
            }
            return this.b == busRouteQuery.b && this.e == busRouteQuery.e;
        }

        public java.lang.String getCity() {
            return this.c;
        }

        public java.lang.String getCityd() {
            return this.d;
        }

        public java.lang.String getExtensions() {
            return this.f;
        }

        public com.amap.api.services.route.RouteSearch.FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.b;
        }

        public int getNightFlag() {
            return this.e;
        }

        public int hashCode() {
            java.lang.String str = this.c;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo = this.a;
            int hashCode2 = (((((hashCode + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.b) * 31) + this.e) * 31;
            java.lang.String str2 = this.d;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public void setCityd(java.lang.String str) {
            this.d = str;
        }

        public void setExtensions(java.lang.String str) {
            this.f = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
            parcel.writeString(this.c);
            parcel.writeInt(this.e);
            parcel.writeString(this.d);
            parcel.writeString(this.f);
        }
    }

    public static class DrivePlanQuery implements android.os.Parcelable, java.lang.Cloneable {
        public static final android.os.Parcelable.Creator<com.amap.api.services.route.RouteSearch.DrivePlanQuery> CREATOR = new com.amap.api.services.route.RouteSearch.DrivePlanQuery.AnonymousClass1();
        private com.amap.api.services.route.RouteSearch.FromAndTo a;
        private java.lang.String b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;

        /* renamed from: com.amap.api.services.route.RouteSearch$DrivePlanQuery$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.RouteSearch.DrivePlanQuery> {
            private static com.amap.api.services.route.RouteSearch.DrivePlanQuery a(android.os.Parcel parcel) {
                return new com.amap.api.services.route.RouteSearch.DrivePlanQuery(parcel);
            }

            private static com.amap.api.services.route.RouteSearch.DrivePlanQuery[] a(int i) {
                return new com.amap.api.services.route.RouteSearch.DrivePlanQuery[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.amap.api.services.route.RouteSearch.DrivePlanQuery createFromParcel(android.os.Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.amap.api.services.route.RouteSearch.DrivePlanQuery[] newArray(int i) {
                return a(i);
            }
        }

        public DrivePlanQuery() {
            this.c = 1;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 48;
        }

        public DrivePlanQuery(android.os.Parcel parcel) {
            this.c = 1;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 48;
            this.a = (com.amap.api.services.route.RouteSearch.FromAndTo) parcel.readParcelable(com.amap.api.services.route.RouteSearch.FromAndTo.class.getClassLoader());
            this.b = parcel.readString();
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }

        public DrivePlanQuery(com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo, int i, int i2, int i3) {
            this.c = 1;
            this.d = 0;
            this.a = fromAndTo;
            this.e = i;
            this.f = i2;
            this.g = i3;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public com.amap.api.services.route.RouteSearch.DrivePlanQuery m35clone() {
            try {
                super.clone();
            } catch (java.lang.CloneNotSupportedException e) {
                com.amap.api.col.s.i.a(e, "RouteSearch", "DriveRouteQueryclone");
            }
            com.amap.api.services.route.RouteSearch.DrivePlanQuery drivePlanQuery = new com.amap.api.services.route.RouteSearch.DrivePlanQuery(this.a, this.e, this.f, this.g);
            drivePlanQuery.setDestParentPoiID(this.b);
            drivePlanQuery.setMode(this.c);
            drivePlanQuery.setCarType(this.d);
            return drivePlanQuery;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.amap.api.services.route.RouteSearch.DrivePlanQuery drivePlanQuery = (com.amap.api.services.route.RouteSearch.DrivePlanQuery) obj;
            com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo = this.a;
            if (fromAndTo == null) {
                if (drivePlanQuery.a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(drivePlanQuery.a)) {
                return false;
            }
            java.lang.String str = this.b;
            if (str == null) {
                if (drivePlanQuery.b != null) {
                    return false;
                }
            } else if (!str.equals(drivePlanQuery.b)) {
                return false;
            }
            return this.c == drivePlanQuery.c && this.d == drivePlanQuery.d && this.e == drivePlanQuery.e && this.f == drivePlanQuery.f && this.g == drivePlanQuery.g;
        }

        public int getCarType() {
            return this.d;
        }

        public int getCount() {
            return this.g;
        }

        public java.lang.String getDestParentPoiID() {
            return this.b;
        }

        public int getFirstTime() {
            return this.e;
        }

        public com.amap.api.services.route.RouteSearch.FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getInterval() {
            return this.f;
        }

        public int getMode() {
            return this.c;
        }

        public int hashCode() {
            com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo = this.a;
            int hashCode = ((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31;
            java.lang.String str = this.b;
            return ((((((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g;
        }

        public void setCarType(int i) {
            this.d = i;
        }

        public void setDestParentPoiID(java.lang.String str) {
            this.b = str;
        }

        public void setMode(int i) {
            this.c = i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeString(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
        }
    }

    public static class DriveRouteQuery implements android.os.Parcelable, java.lang.Cloneable {
        public static final android.os.Parcelable.Creator<com.amap.api.services.route.RouteSearch.DriveRouteQuery> CREATOR = new com.amap.api.services.route.RouteSearch.DriveRouteQuery.AnonymousClass1();
        private com.amap.api.services.route.RouteSearch.FromAndTo a;
        private int b;
        private java.util.List<com.amap.api.services.core.LatLonPoint> c;
        private java.util.List<java.util.List<com.amap.api.services.core.LatLonPoint>> d;
        private java.lang.String e;
        private boolean f;
        private int g;
        private java.lang.String h;
        private java.lang.String i;

        /* renamed from: com.amap.api.services.route.RouteSearch$DriveRouteQuery$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.RouteSearch.DriveRouteQuery> {
            private static com.amap.api.services.route.RouteSearch.DriveRouteQuery a(android.os.Parcel parcel) {
                return new com.amap.api.services.route.RouteSearch.DriveRouteQuery(parcel);
            }

            private static com.amap.api.services.route.RouteSearch.DriveRouteQuery[] a(int i) {
                return new com.amap.api.services.route.RouteSearch.DriveRouteQuery[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.amap.api.services.route.RouteSearch.DriveRouteQuery createFromParcel(android.os.Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.amap.api.services.route.RouteSearch.DriveRouteQuery[] newArray(int i) {
                return a(i);
            }
        }

        public DriveRouteQuery() {
            this.f = true;
            this.g = 0;
            this.h = null;
            this.i = "base";
        }

        public DriveRouteQuery(android.os.Parcel parcel) {
            this.f = true;
            this.g = 0;
            this.h = null;
            this.i = "base";
            this.a = (com.amap.api.services.route.RouteSearch.FromAndTo) parcel.readParcelable(com.amap.api.services.route.RouteSearch.FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.createTypedArrayList(com.amap.api.services.core.LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.d = null;
            } else {
                this.d = new java.util.ArrayList();
            }
            for (int i = 0; i < readInt; i++) {
                this.d.add(parcel.createTypedArrayList(com.amap.api.services.core.LatLonPoint.CREATOR));
            }
            this.e = parcel.readString();
            this.f = parcel.readInt() == 1;
            this.g = parcel.readInt();
            this.h = parcel.readString();
            this.i = parcel.readString();
        }

        public DriveRouteQuery(com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo, int i, java.util.List<com.amap.api.services.core.LatLonPoint> list, java.util.List<java.util.List<com.amap.api.services.core.LatLonPoint>> list2, java.lang.String str) {
            this.f = true;
            this.g = 0;
            this.h = null;
            this.i = "base";
            this.a = fromAndTo;
            this.b = i;
            this.c = list;
            this.d = list2;
            this.e = str;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public com.amap.api.services.route.RouteSearch.DriveRouteQuery m36clone() {
            try {
                super.clone();
            } catch (java.lang.CloneNotSupportedException e) {
                com.amap.api.col.s.i.a(e, "RouteSearch", "DriveRouteQueryclone");
            }
            com.amap.api.services.route.RouteSearch.DriveRouteQuery driveRouteQuery = new com.amap.api.services.route.RouteSearch.DriveRouteQuery(this.a, this.b, this.c, this.d, this.e);
            driveRouteQuery.setUseFerry(this.f);
            driveRouteQuery.setCarType(this.g);
            driveRouteQuery.setExclude(this.h);
            driveRouteQuery.setExtensions(this.i);
            return driveRouteQuery;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.amap.api.services.route.RouteSearch.DriveRouteQuery driveRouteQuery = (com.amap.api.services.route.RouteSearch.DriveRouteQuery) obj;
            java.lang.String str = this.e;
            if (str == null) {
                if (driveRouteQuery.e != null) {
                    return false;
                }
            } else if (!str.equals(driveRouteQuery.e)) {
                return false;
            }
            java.util.List<java.util.List<com.amap.api.services.core.LatLonPoint>> list = this.d;
            if (list == null) {
                if (driveRouteQuery.d != null) {
                    return false;
                }
            } else if (!list.equals(driveRouteQuery.d)) {
                return false;
            }
            com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo = this.a;
            if (fromAndTo == null) {
                if (driveRouteQuery.a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(driveRouteQuery.a)) {
                return false;
            }
            if (this.b != driveRouteQuery.b) {
                return false;
            }
            java.util.List<com.amap.api.services.core.LatLonPoint> list2 = this.c;
            if (list2 == null) {
                if (driveRouteQuery.c != null) {
                    return false;
                }
            } else if (!list2.equals(driveRouteQuery.c) || this.f != driveRouteQuery.isUseFerry() || this.g != driveRouteQuery.g) {
                return false;
            }
            java.lang.String str2 = this.i;
            if (str2 == null) {
                if (driveRouteQuery.i != null) {
                    return false;
                }
            } else if (!str2.equals(driveRouteQuery.i)) {
                return false;
            }
            return true;
        }

        public java.lang.String getAvoidRoad() {
            return this.e;
        }

        public java.util.List<java.util.List<com.amap.api.services.core.LatLonPoint>> getAvoidpolygons() {
            return this.d;
        }

        public java.lang.String getAvoidpolygonsStr() {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            java.util.List<java.util.List<com.amap.api.services.core.LatLonPoint>> list = this.d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.d.size(); i++) {
                java.util.List<com.amap.api.services.core.LatLonPoint> list2 = this.d.get(i);
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    com.amap.api.services.core.LatLonPoint latLonPoint = list2.get(i2);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(",");
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i2 < list2.size() - 1) {
                        stringBuffer.append(com.alipay.sdk.m.u.i.b);
                    }
                }
                if (i < this.d.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public int getCarType() {
            return this.g;
        }

        public java.lang.String getExclude() {
            return this.h;
        }

        public java.lang.String getExtensions() {
            return this.i;
        }

        public com.amap.api.services.route.RouteSearch.FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.b;
        }

        public java.util.List<com.amap.api.services.core.LatLonPoint> getPassedByPoints() {
            return this.c;
        }

        public java.lang.String getPassedPointStr() {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            java.util.List<com.amap.api.services.core.LatLonPoint> list = this.c;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.c.size(); i++) {
                com.amap.api.services.core.LatLonPoint latLonPoint = this.c.get(i);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i < this.c.size() - 1) {
                    stringBuffer.append(com.alipay.sdk.m.u.i.b);
                }
            }
            return stringBuffer.toString();
        }

        public boolean hasAvoidRoad() {
            return !com.amap.api.col.s.i.a(getAvoidRoad());
        }

        public boolean hasAvoidpolygons() {
            return !com.amap.api.col.s.i.a(getAvoidpolygonsStr());
        }

        public boolean hasPassPoint() {
            return !com.amap.api.col.s.i.a(getPassedPointStr());
        }

        public int hashCode() {
            java.lang.String str = this.e;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            java.util.List<java.util.List<com.amap.api.services.core.LatLonPoint>> list = this.d;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo = this.a;
            int hashCode3 = (((hashCode2 + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.b) * 31;
            java.util.List<com.amap.api.services.core.LatLonPoint> list2 = this.c;
            return ((hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.g;
        }

        public boolean isUseFerry() {
            return this.f;
        }

        public void setCarType(int i) {
            this.g = i;
        }

        public void setExclude(java.lang.String str) {
            this.h = str;
        }

        public void setExtensions(java.lang.String str) {
            this.i = str;
        }

        public void setUseFerry(boolean z) {
            this.f = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
            parcel.writeTypedList(this.c);
            java.util.List<java.util.List<com.amap.api.services.core.LatLonPoint>> list = this.d;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                java.util.Iterator<java.util.List<com.amap.api.services.core.LatLonPoint>> it = this.d.iterator();
                while (it.hasNext()) {
                    parcel.writeTypedList(it.next());
                }
            }
            parcel.writeString(this.e);
            parcel.writeInt(this.f ? 1 : 0);
            parcel.writeInt(this.g);
            parcel.writeString(this.h);
            parcel.writeString(this.i);
        }
    }

    public static class FromAndTo implements android.os.Parcelable, java.lang.Cloneable {
        public static final android.os.Parcelable.Creator<com.amap.api.services.route.RouteSearch.FromAndTo> CREATOR = new com.amap.api.services.route.RouteSearch.FromAndTo.AnonymousClass1();
        private com.amap.api.services.core.LatLonPoint a;
        private com.amap.api.services.core.LatLonPoint b;
        private java.lang.String c;
        private java.lang.String d;
        private java.lang.String e;
        private java.lang.String f;
        private java.lang.String g;
        private java.lang.String h;

        /* renamed from: com.amap.api.services.route.RouteSearch$FromAndTo$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.RouteSearch.FromAndTo> {
            private static com.amap.api.services.route.RouteSearch.FromAndTo a(android.os.Parcel parcel) {
                return new com.amap.api.services.route.RouteSearch.FromAndTo(parcel);
            }

            private static com.amap.api.services.route.RouteSearch.FromAndTo[] a(int i) {
                return new com.amap.api.services.route.RouteSearch.FromAndTo[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.amap.api.services.route.RouteSearch.FromAndTo createFromParcel(android.os.Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.amap.api.services.route.RouteSearch.FromAndTo[] newArray(int i) {
                return a(i);
            }
        }

        public FromAndTo() {
        }

        public FromAndTo(android.os.Parcel parcel) {
            this.a = (com.amap.api.services.core.LatLonPoint) parcel.readParcelable(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
            this.b = (com.amap.api.services.core.LatLonPoint) parcel.readParcelable(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readString();
            this.f = parcel.readString();
        }

        public FromAndTo(com.amap.api.services.core.LatLonPoint latLonPoint, com.amap.api.services.core.LatLonPoint latLonPoint2) {
            this.a = latLonPoint;
            this.b = latLonPoint2;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public com.amap.api.services.route.RouteSearch.FromAndTo m37clone() {
            try {
                super.clone();
            } catch (java.lang.CloneNotSupportedException e) {
                com.amap.api.col.s.i.a(e, "RouteSearch", "FromAndToclone");
            }
            com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo = new com.amap.api.services.route.RouteSearch.FromAndTo(this.a, this.b);
            fromAndTo.setStartPoiID(this.c);
            fromAndTo.setDestinationPoiID(this.d);
            fromAndTo.setOriginType(this.e);
            fromAndTo.setDestinationType(this.f);
            return fromAndTo;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo = (com.amap.api.services.route.RouteSearch.FromAndTo) obj;
            java.lang.String str = this.d;
            if (str == null) {
                if (fromAndTo.d != null) {
                    return false;
                }
            } else if (!str.equals(fromAndTo.d)) {
                return false;
            }
            com.amap.api.services.core.LatLonPoint latLonPoint = this.a;
            if (latLonPoint == null) {
                if (fromAndTo.a != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(fromAndTo.a)) {
                return false;
            }
            java.lang.String str2 = this.c;
            if (str2 == null) {
                if (fromAndTo.c != null) {
                    return false;
                }
            } else if (!str2.equals(fromAndTo.c)) {
                return false;
            }
            com.amap.api.services.core.LatLonPoint latLonPoint2 = this.b;
            if (latLonPoint2 == null) {
                if (fromAndTo.b != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(fromAndTo.b)) {
                return false;
            }
            java.lang.String str3 = this.e;
            if (str3 == null) {
                if (fromAndTo.e != null) {
                    return false;
                }
            } else if (!str3.equals(fromAndTo.e)) {
                return false;
            }
            java.lang.String str4 = this.f;
            if (str4 == null) {
                if (fromAndTo.f != null) {
                    return false;
                }
            } else if (!str4.equals(fromAndTo.f)) {
                return false;
            }
            return true;
        }

        public java.lang.String getDestinationPoiID() {
            return this.d;
        }

        public java.lang.String getDestinationType() {
            return this.f;
        }

        public com.amap.api.services.core.LatLonPoint getFrom() {
            return this.a;
        }

        public java.lang.String getOriginType() {
            return this.e;
        }

        public java.lang.String getPlateNumber() {
            return this.h;
        }

        public java.lang.String getPlateProvince() {
            return this.g;
        }

        public java.lang.String getStartPoiID() {
            return this.c;
        }

        public com.amap.api.services.core.LatLonPoint getTo() {
            return this.b;
        }

        public int hashCode() {
            java.lang.String str = this.d;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            com.amap.api.services.core.LatLonPoint latLonPoint = this.a;
            int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
            java.lang.String str2 = this.c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            com.amap.api.services.core.LatLonPoint latLonPoint2 = this.b;
            int hashCode4 = (hashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            java.lang.String str3 = this.e;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            java.lang.String str4 = this.f;
            return hashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public void setDestinationPoiID(java.lang.String str) {
            this.d = str;
        }

        public void setDestinationType(java.lang.String str) {
            this.f = str;
        }

        public void setOriginType(java.lang.String str) {
            this.e = str;
        }

        public void setPlateNumber(java.lang.String str) {
            this.h = str;
        }

        public void setPlateProvince(java.lang.String str) {
            this.g = str;
        }

        public void setStartPoiID(java.lang.String str) {
            this.c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeParcelable(this.b, i);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
        }
    }

    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(com.amap.api.services.route.DriveRoutePlanResult driveRoutePlanResult, int i);
    }

    public interface OnRouteSearchListener {
        void onBusRouteSearched(com.amap.api.services.route.BusRouteResult busRouteResult, int i);

        void onDriveRouteSearched(com.amap.api.services.route.DriveRouteResult driveRouteResult, int i);

        void onRideRouteSearched(com.amap.api.services.route.RideRouteResult rideRouteResult, int i);

        void onWalkRouteSearched(com.amap.api.services.route.WalkRouteResult walkRouteResult, int i);
    }

    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(com.amap.api.services.route.TruckRouteRestult truckRouteRestult, int i);
    }

    public static class RideRouteQuery implements android.os.Parcelable, java.lang.Cloneable {
        public static final android.os.Parcelable.Creator<com.amap.api.services.route.RouteSearch.RideRouteQuery> CREATOR = new com.amap.api.services.route.RouteSearch.RideRouteQuery.AnonymousClass1();
        private com.amap.api.services.route.RouteSearch.FromAndTo a;
        private int b;
        private java.lang.String c;

        /* renamed from: com.amap.api.services.route.RouteSearch$RideRouteQuery$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.RouteSearch.RideRouteQuery> {
            private static com.amap.api.services.route.RouteSearch.RideRouteQuery a(android.os.Parcel parcel) {
                return new com.amap.api.services.route.RouteSearch.RideRouteQuery(parcel);
            }

            private static com.amap.api.services.route.RouteSearch.RideRouteQuery[] a(int i) {
                return new com.amap.api.services.route.RouteSearch.RideRouteQuery[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.amap.api.services.route.RouteSearch.RideRouteQuery createFromParcel(android.os.Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.amap.api.services.route.RouteSearch.RideRouteQuery[] newArray(int i) {
                return a(i);
            }
        }

        public RideRouteQuery() {
            this.c = "base";
        }

        public RideRouteQuery(android.os.Parcel parcel) {
            this.c = "base";
            this.a = (com.amap.api.services.route.RouteSearch.FromAndTo) parcel.readParcelable(com.amap.api.services.route.RouteSearch.FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.readString();
        }

        public RideRouteQuery(com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo) {
            this.c = "base";
            this.a = fromAndTo;
        }

        public RideRouteQuery(com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo, int i) {
            this.c = "base";
            this.a = fromAndTo;
            this.b = i;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public com.amap.api.services.route.RouteSearch.RideRouteQuery m38clone() {
            try {
                super.clone();
            } catch (java.lang.CloneNotSupportedException e) {
                com.amap.api.col.s.i.a(e, "RouteSearch", "RideRouteQueryclone");
            }
            com.amap.api.services.route.RouteSearch.RideRouteQuery rideRouteQuery = new com.amap.api.services.route.RouteSearch.RideRouteQuery(this.a);
            rideRouteQuery.setExtensions(this.c);
            return rideRouteQuery;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.amap.api.services.route.RouteSearch.RideRouteQuery rideRouteQuery = (com.amap.api.services.route.RouteSearch.RideRouteQuery) obj;
            com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo = this.a;
            if (fromAndTo == null) {
                if (rideRouteQuery.a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(rideRouteQuery.a)) {
                return false;
            }
            return this.b == rideRouteQuery.b;
        }

        public java.lang.String getExtensions() {
            return this.c;
        }

        public com.amap.api.services.route.RouteSearch.FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.b;
        }

        public int hashCode() {
            com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo = this.a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.b;
        }

        public void setExtensions(java.lang.String str) {
            this.c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
            parcel.writeString(this.c);
        }
    }

    public static class TruckRouteQuery implements android.os.Parcelable, java.lang.Cloneable {
        public static final android.os.Parcelable.Creator<com.amap.api.services.route.RouteSearch.TruckRouteQuery> CREATOR = new com.amap.api.services.route.RouteSearch.TruckRouteQuery.AnonymousClass1();
        private com.amap.api.services.route.RouteSearch.FromAndTo a;
        private int b;
        private int c;
        private java.util.List<com.amap.api.services.core.LatLonPoint> d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;
        private java.lang.String j;

        /* renamed from: com.amap.api.services.route.RouteSearch$TruckRouteQuery$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.RouteSearch.TruckRouteQuery> {
            private static com.amap.api.services.route.RouteSearch.TruckRouteQuery a(android.os.Parcel parcel) {
                return new com.amap.api.services.route.RouteSearch.TruckRouteQuery(parcel);
            }

            private static com.amap.api.services.route.RouteSearch.TruckRouteQuery[] a(int i) {
                return new com.amap.api.services.route.RouteSearch.TruckRouteQuery[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.amap.api.services.route.RouteSearch.TruckRouteQuery createFromParcel(android.os.Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.amap.api.services.route.RouteSearch.TruckRouteQuery[] newArray(int i) {
                return a(i);
            }
        }

        public TruckRouteQuery(android.os.Parcel parcel) {
            this.b = 2;
            this.j = "base";
            this.a = (com.amap.api.services.route.RouteSearch.FromAndTo) parcel.readParcelable(com.amap.api.services.route.RouteSearch.FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.d = parcel.createTypedArrayList(com.amap.api.services.core.LatLonPoint.CREATOR);
            this.e = parcel.readFloat();
            this.f = parcel.readFloat();
            this.g = parcel.readFloat();
            this.h = parcel.readFloat();
            this.i = parcel.readFloat();
            this.j = parcel.readString();
        }

        public TruckRouteQuery(com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo, int i, java.util.List<com.amap.api.services.core.LatLonPoint> list, int i2) {
            this.j = "base";
            this.a = fromAndTo;
            this.c = i;
            this.d = list;
            this.b = i2;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public com.amap.api.services.route.RouteSearch.TruckRouteQuery m39clone() {
            try {
                super.clone();
            } catch (java.lang.CloneNotSupportedException e) {
                com.amap.api.col.s.i.a(e, "RouteSearch", "TruckRouteQueryclone");
            }
            com.amap.api.services.route.RouteSearch.TruckRouteQuery truckRouteQuery = new com.amap.api.services.route.RouteSearch.TruckRouteQuery(this.a, this.c, this.d, this.b);
            truckRouteQuery.setExtensions(this.j);
            return truckRouteQuery;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public java.lang.String getExtensions() {
            return this.j;
        }

        public com.amap.api.services.route.RouteSearch.FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.c;
        }

        public java.util.List<com.amap.api.services.core.LatLonPoint> getPassedByPoints() {
            return this.d;
        }

        public java.lang.String getPassedPointStr() {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            java.util.List<com.amap.api.services.core.LatLonPoint> list = this.d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.d.size(); i++) {
                com.amap.api.services.core.LatLonPoint latLonPoint = this.d.get(i);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i < this.d.size() - 1) {
                    stringBuffer.append(com.alipay.sdk.m.u.i.b);
                }
            }
            return stringBuffer.toString();
        }

        public float getTruckAxis() {
            return this.i;
        }

        public float getTruckHeight() {
            return this.e;
        }

        public float getTruckLoad() {
            return this.g;
        }

        public int getTruckSize() {
            return this.b;
        }

        public float getTruckWeight() {
            return this.h;
        }

        public float getTruckWidth() {
            return this.f;
        }

        public boolean hasPassPoint() {
            return !com.amap.api.col.s.i.a(getPassedPointStr());
        }

        public void setExtensions(java.lang.String str) {
            this.j = str;
        }

        public void setMode(int i) {
            this.c = i;
        }

        public void setTruckAxis(float f) {
            this.i = f;
        }

        public void setTruckHeight(float f) {
            this.e = f;
        }

        public void setTruckLoad(float f) {
            this.g = f;
        }

        public void setTruckSize(int i) {
            this.b = i;
        }

        public void setTruckWeight(float f) {
            this.h = f;
        }

        public void setTruckWidth(float f) {
            this.f = f;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeTypedList(this.d);
            parcel.writeFloat(this.e);
            parcel.writeFloat(this.f);
            parcel.writeFloat(this.g);
            parcel.writeFloat(this.h);
            parcel.writeFloat(this.i);
            parcel.writeString(this.j);
        }
    }

    public static class WalkRouteQuery implements android.os.Parcelable, java.lang.Cloneable {
        public static final android.os.Parcelable.Creator<com.amap.api.services.route.RouteSearch.WalkRouteQuery> CREATOR = new com.amap.api.services.route.RouteSearch.WalkRouteQuery.AnonymousClass1();
        private com.amap.api.services.route.RouteSearch.FromAndTo a;
        private int b;
        private java.lang.String c;

        /* renamed from: com.amap.api.services.route.RouteSearch$WalkRouteQuery$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.RouteSearch.WalkRouteQuery> {
            private static com.amap.api.services.route.RouteSearch.WalkRouteQuery a(android.os.Parcel parcel) {
                return new com.amap.api.services.route.RouteSearch.WalkRouteQuery(parcel);
            }

            private static com.amap.api.services.route.RouteSearch.WalkRouteQuery[] a(int i) {
                return new com.amap.api.services.route.RouteSearch.WalkRouteQuery[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.amap.api.services.route.RouteSearch.WalkRouteQuery createFromParcel(android.os.Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.amap.api.services.route.RouteSearch.WalkRouteQuery[] newArray(int i) {
                return a(i);
            }
        }

        public WalkRouteQuery() {
            this.c = "base";
        }

        public WalkRouteQuery(android.os.Parcel parcel) {
            this.c = "base";
            this.a = (com.amap.api.services.route.RouteSearch.FromAndTo) parcel.readParcelable(com.amap.api.services.route.RouteSearch.FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.readString();
        }

        public WalkRouteQuery(com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo) {
            this.c = "base";
            this.a = fromAndTo;
        }

        public WalkRouteQuery(com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo, int i) {
            this.c = "base";
            this.a = fromAndTo;
            this.b = i;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public com.amap.api.services.route.RouteSearch.WalkRouteQuery m40clone() {
            try {
                super.clone();
            } catch (java.lang.CloneNotSupportedException e) {
                com.amap.api.col.s.i.a(e, "RouteSearch", "WalkRouteQueryclone");
            }
            com.amap.api.services.route.RouteSearch.WalkRouteQuery walkRouteQuery = new com.amap.api.services.route.RouteSearch.WalkRouteQuery(this.a);
            walkRouteQuery.setExtensions(this.c);
            return walkRouteQuery;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.amap.api.services.route.RouteSearch.WalkRouteQuery walkRouteQuery = (com.amap.api.services.route.RouteSearch.WalkRouteQuery) obj;
            com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo = this.a;
            if (fromAndTo == null) {
                if (walkRouteQuery.a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(walkRouteQuery.a)) {
                return false;
            }
            java.lang.String str = this.c;
            if (str == null) {
                if (walkRouteQuery.c != null) {
                    return false;
                }
            } else if (!str.equals(walkRouteQuery.c)) {
                return false;
            }
            return this.b == walkRouteQuery.b;
        }

        public java.lang.String getExtensions() {
            return this.c;
        }

        public com.amap.api.services.route.RouteSearch.FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.b;
        }

        public int hashCode() {
            com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo = this.a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.b;
        }

        public void setExtensions(java.lang.String str) {
            this.c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
            parcel.writeString(this.c);
        }
    }

    public RouteSearch(android.content.Context context) throws com.amap.api.services.core.AMapException {
        if (this.a == null) {
            try {
                this.a = new com.amap.api.col.s.be(context);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                if (e instanceof com.amap.api.services.core.AMapException) {
                    throw ((com.amap.api.services.core.AMapException) e);
                }
            }
        }
    }

    public com.amap.api.services.route.BusRouteResult calculateBusRoute(com.amap.api.services.route.RouteSearch.BusRouteQuery busRouteQuery) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateBusRoute(busRouteQuery);
        }
        return null;
    }

    public void calculateBusRouteAsyn(com.amap.api.services.route.RouteSearch.BusRouteQuery busRouteQuery) {
        com.amap.api.services.interfaces.IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateBusRouteAsyn(busRouteQuery);
        }
    }

    public com.amap.api.services.route.DriveRoutePlanResult calculateDrivePlan(com.amap.api.services.route.RouteSearch.DrivePlanQuery drivePlanQuery) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDrivePlan(drivePlanQuery);
        }
        return null;
    }

    public void calculateDrivePlanAsyn(com.amap.api.services.route.RouteSearch.DrivePlanQuery drivePlanQuery) {
        com.amap.api.services.interfaces.IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDrivePlanAsyn(drivePlanQuery);
        }
    }

    public com.amap.api.services.route.DriveRouteResult calculateDriveRoute(com.amap.api.services.route.RouteSearch.DriveRouteQuery driveRouteQuery) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(com.amap.api.services.route.RouteSearch.DriveRouteQuery driveRouteQuery) {
        com.amap.api.services.interfaces.IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public com.amap.api.services.route.RideRouteResult calculateRideRoute(com.amap.api.services.route.RouteSearch.RideRouteQuery rideRouteQuery) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateRideRoute(rideRouteQuery);
        }
        return null;
    }

    public void calculateRideRouteAsyn(com.amap.api.services.route.RouteSearch.RideRouteQuery rideRouteQuery) {
        com.amap.api.services.interfaces.IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateRideRouteAsyn(rideRouteQuery);
        }
    }

    public com.amap.api.services.route.TruckRouteRestult calculateTruckRoute(com.amap.api.services.route.RouteSearch.TruckRouteQuery truckRouteQuery) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateTruckRoute(truckRouteQuery);
        }
        return null;
    }

    public void calculateTruckRouteAsyn(com.amap.api.services.route.RouteSearch.TruckRouteQuery truckRouteQuery) {
        com.amap.api.services.interfaces.IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateTruckRouteAsyn(truckRouteQuery);
        }
    }

    public com.amap.api.services.route.WalkRouteResult calculateWalkRoute(com.amap.api.services.route.RouteSearch.WalkRouteQuery walkRouteQuery) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateWalkRoute(walkRouteQuery);
        }
        return null;
    }

    public void calculateWalkRouteAsyn(com.amap.api.services.route.RouteSearch.WalkRouteQuery walkRouteQuery) {
        com.amap.api.services.interfaces.IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateWalkRouteAsyn(walkRouteQuery);
        }
    }

    public void setOnRoutePlanSearchListener(com.amap.api.services.route.RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener) {
        com.amap.api.services.interfaces.IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnRoutePlanSearchListener(onRoutePlanSearchListener);
        }
    }

    public void setOnTruckRouteSearchListener(com.amap.api.services.route.RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener) {
        com.amap.api.services.interfaces.IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnTruckRouteSearchListener(onTruckRouteSearchListener);
        }
    }

    public void setRouteSearchListener(com.amap.api.services.route.RouteSearch.OnRouteSearchListener onRouteSearchListener) {
        com.amap.api.services.interfaces.IRouteSearch iRouteSearch = this.a;
        if (iRouteSearch != null) {
            iRouteSearch.setRouteSearchListener(onRouteSearchListener);
        }
    }
}
