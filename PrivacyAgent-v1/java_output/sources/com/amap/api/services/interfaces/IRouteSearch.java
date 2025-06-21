package com.amap.api.services.interfaces;

/* loaded from: classes12.dex */
public interface IRouteSearch {
    com.amap.api.services.route.BusRouteResult calculateBusRoute(com.amap.api.services.route.RouteSearch.BusRouteQuery busRouteQuery) throws com.amap.api.services.core.AMapException;

    void calculateBusRouteAsyn(com.amap.api.services.route.RouteSearch.BusRouteQuery busRouteQuery);

    com.amap.api.services.route.DriveRoutePlanResult calculateDrivePlan(com.amap.api.services.route.RouteSearch.DrivePlanQuery drivePlanQuery) throws com.amap.api.services.core.AMapException;

    void calculateDrivePlanAsyn(com.amap.api.services.route.RouteSearch.DrivePlanQuery drivePlanQuery);

    com.amap.api.services.route.DriveRouteResult calculateDriveRoute(com.amap.api.services.route.RouteSearch.DriveRouteQuery driveRouteQuery) throws com.amap.api.services.core.AMapException;

    void calculateDriveRouteAsyn(com.amap.api.services.route.RouteSearch.DriveRouteQuery driveRouteQuery);

    com.amap.api.services.route.RideRouteResult calculateRideRoute(com.amap.api.services.route.RouteSearch.RideRouteQuery rideRouteQuery) throws com.amap.api.services.core.AMapException;

    void calculateRideRouteAsyn(com.amap.api.services.route.RouteSearch.RideRouteQuery rideRouteQuery);

    com.amap.api.services.route.TruckRouteRestult calculateTruckRoute(com.amap.api.services.route.RouteSearch.TruckRouteQuery truckRouteQuery) throws com.amap.api.services.core.AMapException;

    void calculateTruckRouteAsyn(com.amap.api.services.route.RouteSearch.TruckRouteQuery truckRouteQuery);

    com.amap.api.services.route.WalkRouteResult calculateWalkRoute(com.amap.api.services.route.RouteSearch.WalkRouteQuery walkRouteQuery) throws com.amap.api.services.core.AMapException;

    void calculateWalkRouteAsyn(com.amap.api.services.route.RouteSearch.WalkRouteQuery walkRouteQuery);

    void setOnRoutePlanSearchListener(com.amap.api.services.route.RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener);

    void setOnTruckRouteSearchListener(com.amap.api.services.route.RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener);

    void setRouteSearchListener(com.amap.api.services.route.RouteSearch.OnRouteSearchListener onRouteSearchListener);
}
