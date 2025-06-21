package com.amap.api.services.route;

/* loaded from: classes12.dex */
public class BusStep implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.route.BusStep> CREATOR = new com.amap.api.services.route.BusStep.AnonymousClass1();
    private com.amap.api.services.route.RouteBusWalkItem a;
    private java.util.List<com.amap.api.services.route.RouteBusLineItem> b;
    private com.amap.api.services.route.Doorway c;
    private com.amap.api.services.route.Doorway d;
    private com.amap.api.services.route.RouteRailwayItem e;
    private com.amap.api.services.route.TaxiItem f;

    /* renamed from: com.amap.api.services.route.BusStep$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.route.BusStep> {
        private static com.amap.api.services.route.BusStep a(android.os.Parcel parcel) {
            return new com.amap.api.services.route.BusStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.route.BusStep createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.route.BusStep[] newArray(int i) {
            return null;
        }
    }

    public BusStep() {
        this.b = new java.util.ArrayList();
    }

    public BusStep(android.os.Parcel parcel) {
        this.b = new java.util.ArrayList();
        this.a = (com.amap.api.services.route.RouteBusWalkItem) parcel.readParcelable(com.amap.api.services.route.RouteBusWalkItem.class.getClassLoader());
        this.b = parcel.createTypedArrayList(com.amap.api.services.route.RouteBusLineItem.CREATOR);
        this.c = (com.amap.api.services.route.Doorway) parcel.readParcelable(com.amap.api.services.route.Doorway.class.getClassLoader());
        this.d = (com.amap.api.services.route.Doorway) parcel.readParcelable(com.amap.api.services.route.Doorway.class.getClassLoader());
        this.e = (com.amap.api.services.route.RouteRailwayItem) parcel.readParcelable(com.amap.api.services.route.RouteRailwayItem.class.getClassLoader());
        this.f = (com.amap.api.services.route.TaxiItem) parcel.readParcelable(com.amap.api.services.route.TaxiItem.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @java.lang.Deprecated
    public com.amap.api.services.route.RouteBusLineItem getBusLine() {
        java.util.List<com.amap.api.services.route.RouteBusLineItem> list = this.b;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.b.get(0);
    }

    public java.util.List<com.amap.api.services.route.RouteBusLineItem> getBusLines() {
        return this.b;
    }

    public com.amap.api.services.route.Doorway getEntrance() {
        return this.c;
    }

    public com.amap.api.services.route.Doorway getExit() {
        return this.d;
    }

    public com.amap.api.services.route.RouteRailwayItem getRailway() {
        return this.e;
    }

    public com.amap.api.services.route.TaxiItem getTaxi() {
        return this.f;
    }

    public com.amap.api.services.route.RouteBusWalkItem getWalk() {
        return this.a;
    }

    @java.lang.Deprecated
    public void setBusLine(com.amap.api.services.route.RouteBusLineItem routeBusLineItem) {
        java.util.List<com.amap.api.services.route.RouteBusLineItem> list = this.b;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            this.b.add(routeBusLineItem);
        }
        this.b.set(0, routeBusLineItem);
    }

    public void setBusLines(java.util.List<com.amap.api.services.route.RouteBusLineItem> list) {
        this.b = list;
    }

    public void setEntrance(com.amap.api.services.route.Doorway doorway) {
        this.c = doorway;
    }

    public void setExit(com.amap.api.services.route.Doorway doorway) {
        this.d = doorway;
    }

    public void setRailway(com.amap.api.services.route.RouteRailwayItem routeRailwayItem) {
        this.e = routeRailwayItem;
    }

    public void setTaxi(com.amap.api.services.route.TaxiItem taxiItem) {
        this.f = taxiItem;
    }

    public void setWalk(com.amap.api.services.route.RouteBusWalkItem routeBusWalkItem) {
        this.a = routeBusWalkItem;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeParcelable(this.d, i);
        parcel.writeParcelable(this.e, i);
        parcel.writeParcelable(this.f, i);
    }
}
