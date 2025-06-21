package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class be implements com.amap.api.services.interfaces.IRouteSearch {
    public com.amap.api.services.route.RouteSearch.OnRouteSearchListener a;
    public com.amap.api.services.route.RouteSearch.OnTruckRouteSearchListener b;
    public com.amap.api.services.route.RouteSearch.OnRoutePlanSearchListener c;
    public android.content.Context d;
    public android.os.Handler e;

    /* renamed from: com.amap.api.col.s.be$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.route.RouteSearch.WalkRouteQuery n;

        public AnonymousClass1(com.amap.api.services.route.RouteSearch.WalkRouteQuery walkRouteQuery) {
            this.n = walkRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            obtainMessage.what = 102;
            obtainMessage.arg1 = 1;
            android.os.Bundle bundle = new android.os.Bundle();
            com.amap.api.services.route.WalkRouteResult walkRouteResult = null;
            try {
                try {
                    walkRouteResult = com.amap.api.col.s.be.this.calculateWalkRoute(this.n);
                    bundle.putInt("errorCode", 1000);
                } catch (com.amap.api.services.core.AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = com.amap.api.col.s.be.this.a;
                bundle.putParcelable("result", walkRouteResult);
                obtainMessage.setData(bundle);
                com.amap.api.col.s.be.this.e.sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.s.be$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.route.RouteSearch.BusRouteQuery n;

        public AnonymousClass2(com.amap.api.services.route.RouteSearch.BusRouteQuery busRouteQuery) {
            this.n = busRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            obtainMessage.what = 100;
            obtainMessage.arg1 = 1;
            android.os.Bundle bundle = new android.os.Bundle();
            com.amap.api.services.route.BusRouteResult busRouteResult = null;
            try {
                try {
                    busRouteResult = com.amap.api.col.s.be.this.calculateBusRoute(this.n);
                    bundle.putInt("errorCode", 1000);
                } catch (com.amap.api.services.core.AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = com.amap.api.col.s.be.this.a;
                bundle.putParcelable("result", busRouteResult);
                obtainMessage.setData(bundle);
                com.amap.api.col.s.be.this.e.sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.s.be$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.route.RouteSearch.DriveRouteQuery n;

        public AnonymousClass3(com.amap.api.services.route.RouteSearch.DriveRouteQuery driveRouteQuery) {
            this.n = driveRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            obtainMessage.what = 101;
            obtainMessage.arg1 = 1;
            android.os.Bundle bundle = new android.os.Bundle();
            com.amap.api.services.route.DriveRouteResult driveRouteResult = null;
            try {
                try {
                    driveRouteResult = com.amap.api.col.s.be.this.calculateDriveRoute(this.n);
                    bundle.putInt("errorCode", 1000);
                } catch (com.amap.api.services.core.AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = com.amap.api.col.s.be.this.a;
                bundle.putParcelable("result", driveRouteResult);
                obtainMessage.setData(bundle);
                com.amap.api.col.s.be.this.e.sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.s.be$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.route.RouteSearch.RideRouteQuery n;

        public AnonymousClass4(com.amap.api.services.route.RouteSearch.RideRouteQuery rideRouteQuery) {
            this.n = rideRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            obtainMessage.what = 103;
            obtainMessage.arg1 = 1;
            android.os.Bundle bundle = new android.os.Bundle();
            com.amap.api.services.route.RideRouteResult rideRouteResult = null;
            try {
                try {
                    rideRouteResult = com.amap.api.col.s.be.this.calculateRideRoute(this.n);
                    bundle.putInt("errorCode", 1000);
                } catch (com.amap.api.services.core.AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = com.amap.api.col.s.be.this.a;
                bundle.putParcelable("result", rideRouteResult);
                obtainMessage.setData(bundle);
                com.amap.api.col.s.be.this.e.sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.s.be$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.route.RouteSearch.TruckRouteQuery n;

        public AnonymousClass5(com.amap.api.services.route.RouteSearch.TruckRouteQuery truckRouteQuery) {
            this.n = truckRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            obtainMessage.what = 104;
            obtainMessage.arg1 = 17;
            android.os.Bundle bundle = new android.os.Bundle();
            com.amap.api.services.route.TruckRouteRestult truckRouteRestult = null;
            try {
                try {
                    truckRouteRestult = com.amap.api.col.s.be.this.calculateTruckRoute(this.n);
                    bundle.putInt("errorCode", 1000);
                } catch (com.amap.api.services.core.AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = com.amap.api.col.s.be.this.b;
                bundle.putParcelable("result", truckRouteRestult);
                obtainMessage.setData(bundle);
                com.amap.api.col.s.be.this.e.sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.s.be$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.route.RouteSearch.DrivePlanQuery n;

        public AnonymousClass6(com.amap.api.services.route.RouteSearch.DrivePlanQuery drivePlanQuery) {
            this.n = drivePlanQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            obtainMessage.what = 105;
            obtainMessage.arg1 = 18;
            android.os.Bundle bundle = new android.os.Bundle();
            com.amap.api.services.route.DriveRoutePlanResult driveRoutePlanResult = null;
            try {
                try {
                    driveRoutePlanResult = com.amap.api.col.s.be.this.calculateDrivePlan(this.n);
                    bundle.putInt("errorCode", 1000);
                } catch (com.amap.api.services.core.AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = com.amap.api.col.s.be.this.c;
                bundle.putParcelable("result", driveRoutePlanResult);
                obtainMessage.setData(bundle);
                com.amap.api.col.s.be.this.e.sendMessage(obtainMessage);
            }
        }
    }

    public be(android.content.Context context) throws com.amap.api.services.core.AMapException {
        com.amap.api.col.s.bs a = com.amap.api.col.s.br.a(context, com.amap.api.col.s.h.a(false));
        if (a.a != com.amap.api.col.s.br.c.SuccessCode) {
            java.lang.String str = a.b;
            throw new com.amap.api.services.core.AMapException(str, 1, str, a.a.a());
        }
        this.d = context.getApplicationContext();
        this.e = com.amap.api.col.s.s.a();
    }

    public static boolean b(com.amap.api.services.route.RouteSearch.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final com.amap.api.services.route.BusRouteResult calculateBusRoute(com.amap.api.services.route.RouteSearch.BusRouteQuery busRouteQuery) throws com.amap.api.services.core.AMapException {
        try {
            com.amap.api.col.s.q.a(this.d);
            if (busRouteQuery == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(busRouteQuery.getFromAndTo())) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            com.amap.api.services.route.RouteSearch.BusRouteQuery m34clone = busRouteQuery.m34clone();
            com.amap.api.services.route.BusRouteResult b = new com.amap.api.col.s.c(this.d, m34clone).b();
            if (b != null) {
                b.setBusQuery(m34clone);
            }
            return b;
        } catch (com.amap.api.services.core.AMapException e) {
            com.amap.api.col.s.i.a(e, "RouteSearch", "calculateBusRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateBusRouteAsyn(com.amap.api.services.route.RouteSearch.BusRouteQuery busRouteQuery) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.be.AnonymousClass2(busRouteQuery));
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final com.amap.api.services.route.DriveRoutePlanResult calculateDrivePlan(com.amap.api.services.route.RouteSearch.DrivePlanQuery drivePlanQuery) throws com.amap.api.services.core.AMapException {
        try {
            com.amap.api.col.s.q.a(this.d);
            if (drivePlanQuery == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(drivePlanQuery.getFromAndTo())) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            com.amap.api.services.route.DriveRoutePlanResult b = new com.amap.api.col.s.l(this.d, drivePlanQuery.m35clone()).b();
            if (b != null) {
                b.setDrivePlanQuery(drivePlanQuery);
            }
            return b;
        } catch (com.amap.api.services.core.AMapException e) {
            com.amap.api.col.s.i.a(e, "RouteSearch", "calculateDrivePlan");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDrivePlanAsyn(com.amap.api.services.route.RouteSearch.DrivePlanQuery drivePlanQuery) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.be.AnonymousClass6(drivePlanQuery));
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final com.amap.api.services.route.DriveRouteResult calculateDriveRoute(com.amap.api.services.route.RouteSearch.DriveRouteQuery driveRouteQuery) throws com.amap.api.services.core.AMapException {
        try {
            com.amap.api.col.s.q.a(this.d);
            if (driveRouteQuery == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(driveRouteQuery.getFromAndTo())) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            com.amap.api.col.s.ag.a().a(driveRouteQuery.getPassedByPoints());
            com.amap.api.col.s.ag.a().b(driveRouteQuery.getAvoidpolygons());
            com.amap.api.services.route.RouteSearch.DriveRouteQuery m36clone = driveRouteQuery.m36clone();
            com.amap.api.services.route.DriveRouteResult b = new com.amap.api.col.s.m(this.d, m36clone).b();
            if (b != null) {
                b.setDriveQuery(m36clone);
            }
            return b;
        } catch (com.amap.api.services.core.AMapException e) {
            com.amap.api.col.s.i.a(e, "RouteSearch", "calculateDriveRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDriveRouteAsyn(com.amap.api.services.route.RouteSearch.DriveRouteQuery driveRouteQuery) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.be.AnonymousClass3(driveRouteQuery));
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final com.amap.api.services.route.RideRouteResult calculateRideRoute(com.amap.api.services.route.RouteSearch.RideRouteQuery rideRouteQuery) throws com.amap.api.services.core.AMapException {
        try {
            com.amap.api.col.s.q.a(this.d);
            if (rideRouteQuery == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(rideRouteQuery.getFromAndTo())) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            com.amap.api.col.s.ag.a().a(rideRouteQuery.getFromAndTo());
            com.amap.api.services.route.RouteSearch.RideRouteQuery m38clone = rideRouteQuery.m38clone();
            com.amap.api.services.route.RideRouteResult b = new com.amap.api.col.s.ai(this.d, m38clone).b();
            if (b != null) {
                b.setRideQuery(m38clone);
            }
            return b;
        } catch (com.amap.api.services.core.AMapException e) {
            com.amap.api.col.s.i.a(e, "RouteSearch", "calculaterideRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateRideRouteAsyn(com.amap.api.services.route.RouteSearch.RideRouteQuery rideRouteQuery) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.be.AnonymousClass4(rideRouteQuery));
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final com.amap.api.services.route.TruckRouteRestult calculateTruckRoute(com.amap.api.services.route.RouteSearch.TruckRouteQuery truckRouteQuery) throws com.amap.api.services.core.AMapException {
        try {
            com.amap.api.col.s.q.a(this.d);
            if (truckRouteQuery == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(truckRouteQuery.getFromAndTo())) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            com.amap.api.col.s.ag.a().a(truckRouteQuery.getFromAndTo(), truckRouteQuery.getPassedByPoints());
            com.amap.api.col.s.ag.a().a(truckRouteQuery.getPassedByPoints());
            com.amap.api.services.route.RouteSearch.TruckRouteQuery m39clone = truckRouteQuery.m39clone();
            com.amap.api.services.route.TruckRouteRestult b = new com.amap.api.col.s.ao(this.d, m39clone).b();
            if (b != null) {
                b.setTruckQuery(m39clone);
            }
            return b;
        } catch (com.amap.api.services.core.AMapException e) {
            com.amap.api.col.s.i.a(e, "RouteSearch", "calculateDriveRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateTruckRouteAsyn(com.amap.api.services.route.RouteSearch.TruckRouteQuery truckRouteQuery) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.be.AnonymousClass5(truckRouteQuery));
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final com.amap.api.services.route.WalkRouteResult calculateWalkRoute(com.amap.api.services.route.RouteSearch.WalkRouteQuery walkRouteQuery) throws com.amap.api.services.core.AMapException {
        try {
            com.amap.api.col.s.q.a(this.d);
            if (walkRouteQuery == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(walkRouteQuery.getFromAndTo())) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            com.amap.api.col.s.ag.a().b(walkRouteQuery.getFromAndTo());
            com.amap.api.services.route.RouteSearch.WalkRouteQuery m40clone = walkRouteQuery.m40clone();
            com.amap.api.services.route.WalkRouteResult b = new com.amap.api.col.s.ap(this.d, m40clone).b();
            if (b != null) {
                b.setWalkQuery(m40clone);
            }
            return b;
        } catch (com.amap.api.services.core.AMapException e) {
            com.amap.api.col.s.i.a(e, "RouteSearch", "calculateWalkRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateWalkRouteAsyn(com.amap.api.services.route.RouteSearch.WalkRouteQuery walkRouteQuery) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.be.AnonymousClass1(walkRouteQuery));
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnRoutePlanSearchListener(com.amap.api.services.route.RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener) {
        this.c = onRoutePlanSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnTruckRouteSearchListener(com.amap.api.services.route.RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener) {
        this.b = onTruckRouteSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setRouteSearchListener(com.amap.api.services.route.RouteSearch.OnRouteSearchListener onRouteSearchListener) {
        this.a = onRouteSearchListener;
    }
}
