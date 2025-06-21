package com.amap.api.maps.utils.overlay;

/* loaded from: classes12.dex */
public class SmoothMoveMarker {
    public static final float MIN_OFFSET_DISTANCE = 5.0f;
    private com.amap.api.maps.model.BitmapDescriptor descriptor;
    private com.amap.api.maps.AMap mAMap;
    private com.amap.api.maps.utils.overlay.SmoothMoveMarker.MoveListener moveListener;
    private long pauseMillis;
    private long duration = 10000;
    private long mStepDuration = 20;
    private java.util.LinkedList<com.amap.api.maps.model.LatLng> points = new java.util.LinkedList<>();
    private java.util.LinkedList<java.lang.Double> eachDistance = new java.util.LinkedList<>();
    private double totalDistance = 0.0d;
    private double remainDistance = 0.0d;
    private java.lang.Object mLock = new java.lang.Object();
    private com.amap.api.maps.model.Marker marker = null;
    private int index = 0;
    private boolean useDefaultDescriptor = false;
    java.util.concurrent.atomic.AtomicBoolean exitFlag = new java.util.concurrent.atomic.AtomicBoolean(false);
    private com.amap.api.maps.utils.overlay.SmoothMoveMarker.a moveStatus = com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_UNKNOWN;
    private long mAnimationBeginTime = java.lang.System.currentTimeMillis();
    private com.amap.api.mapcore.util.ii mThreadPools = com.amap.api.mapcore.util.dk.a("AMapSmoothMoveMarkerThread");

    public interface MoveListener {
        void move(double d);
    }

    public enum a {
        ACTION_UNKNOWN,
        ACTION_START,
        ACTION_RUNNING,
        ACTION_PAUSE,
        ACTION_STOP
    }

    public class b extends com.amap.api.mapcore.util.ij {
        private b() {
        }

        public /* synthetic */ b(com.amap.api.maps.utils.overlay.SmoothMoveMarker smoothMoveMarker, byte b) {
            this();
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            try {
                com.amap.api.maps.utils.overlay.SmoothMoveMarker.this.mAnimationBeginTime = java.lang.System.currentTimeMillis();
                com.amap.api.maps.utils.overlay.SmoothMoveMarker.this.moveStatus = com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_START;
                com.amap.api.maps.utils.overlay.SmoothMoveMarker.this.exitFlag.set(false);
                while (!com.amap.api.maps.utils.overlay.SmoothMoveMarker.this.exitFlag.get() && com.amap.api.maps.utils.overlay.SmoothMoveMarker.this.index <= com.amap.api.maps.utils.overlay.SmoothMoveMarker.this.points.size() - 1) {
                    synchronized (com.amap.api.maps.utils.overlay.SmoothMoveMarker.this.mLock) {
                        if (com.amap.api.maps.utils.overlay.SmoothMoveMarker.this.exitFlag.get()) {
                            return;
                        }
                        if (com.amap.api.maps.utils.overlay.SmoothMoveMarker.this.moveStatus != com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_PAUSE) {
                            com.autonavi.amap.mapcore.IPoint curPosition = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this.getCurPosition(java.lang.System.currentTimeMillis() - com.amap.api.maps.utils.overlay.SmoothMoveMarker.this.mAnimationBeginTime);
                            if (com.amap.api.maps.utils.overlay.SmoothMoveMarker.this.marker != null) {
                                com.amap.api.maps.utils.overlay.SmoothMoveMarker.this.marker.setGeoPoint(curPosition);
                            }
                            com.amap.api.maps.utils.overlay.SmoothMoveMarker.this.moveStatus = com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_RUNNING;
                        }
                    }
                    java.lang.Thread.sleep(com.amap.api.maps.utils.overlay.SmoothMoveMarker.this.mStepDuration);
                }
                com.amap.api.maps.utils.overlay.SmoothMoveMarker.this.moveStatus = com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_STOP;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public SmoothMoveMarker(com.amap.api.maps.AMap aMap) {
        this.mAMap = aMap;
    }

    private void checkMarkerIcon() {
        if (this.useDefaultDescriptor) {
            com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor = this.descriptor;
            if (bitmapDescriptor == null) {
                this.useDefaultDescriptor = true;
            } else {
                this.marker.setIcon(bitmapDescriptor);
                this.useDefaultDescriptor = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.autonavi.amap.mapcore.IPoint getCurPosition(long j) {
        double d;
        com.amap.api.maps.model.CameraPosition cameraPosition;
        com.amap.api.maps.utils.overlay.SmoothMoveMarker.MoveListener moveListener;
        long j2 = this.duration;
        int i = 0;
        if (j > j2) {
            this.exitFlag.set(true);
            com.autonavi.amap.mapcore.IPoint iPoint = new com.autonavi.amap.mapcore.IPoint();
            int size = this.points.size() - 1;
            this.index = size;
            com.amap.api.maps.model.LatLng latLng = this.points.get(size);
            int i2 = this.index - 1;
            this.index = i2;
            this.index = java.lang.Math.max(i2, 0);
            this.remainDistance = 0.0d;
            com.autonavi.amap.mapcore.MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
            com.amap.api.maps.utils.overlay.SmoothMoveMarker.MoveListener moveListener2 = this.moveListener;
            if (moveListener2 != null) {
                moveListener2.move(this.remainDistance);
            }
            return iPoint;
        }
        double d2 = this.totalDistance;
        double d3 = (j * d2) / j2;
        this.remainDistance = d2 - d3;
        int i3 = 0;
        while (true) {
            if (i3 >= this.eachDistance.size()) {
                break;
            }
            double doubleValue = this.eachDistance.get(i3).doubleValue();
            if (d3 > doubleValue) {
                d3 -= doubleValue;
                i3++;
            } else {
                d = doubleValue > 0.0d ? d3 / doubleValue : 1.0d;
                i = i3;
            }
        }
        if (i != this.index && (moveListener = this.moveListener) != null) {
            moveListener.move(this.remainDistance);
        }
        this.index = i;
        com.amap.api.maps.model.LatLng latLng2 = this.points.get(i);
        com.amap.api.maps.model.LatLng latLng3 = this.points.get(i + 1);
        com.autonavi.amap.mapcore.IPoint iPoint2 = new com.autonavi.amap.mapcore.IPoint();
        com.autonavi.amap.mapcore.MapProjection.lonlat2Geo(latLng2.longitude, latLng2.latitude, iPoint2);
        com.autonavi.amap.mapcore.IPoint iPoint3 = new com.autonavi.amap.mapcore.IPoint();
        com.autonavi.amap.mapcore.MapProjection.lonlat2Geo(latLng3.longitude, latLng3.latitude, iPoint3);
        int i4 = ((android.graphics.Point) iPoint3).x - ((android.graphics.Point) iPoint2).x;
        int i5 = ((android.graphics.Point) iPoint3).y - ((android.graphics.Point) iPoint2).y;
        if (com.amap.api.maps.AMapUtils.calculateLineDistance(latLng2, latLng3) > 5.0f) {
            float rotate = getRotate(iPoint2, iPoint3);
            com.amap.api.maps.AMap aMap = this.mAMap;
            if (aMap != null && (cameraPosition = aMap.getCameraPosition()) != null) {
                this.marker.setRotateAngle((360.0f - rotate) + cameraPosition.bearing);
            }
        }
        return new com.autonavi.amap.mapcore.IPoint((int) (((android.graphics.Point) iPoint2).x + (i4 * d)), (int) (((android.graphics.Point) iPoint2).y + (i5 * d)));
    }

    private float getRotate(com.autonavi.amap.mapcore.IPoint iPoint, com.autonavi.amap.mapcore.IPoint iPoint2) {
        if (iPoint == null || iPoint2 == null) {
            return 0.0f;
        }
        double d = ((android.graphics.Point) iPoint2).y;
        return (float) ((java.lang.Math.atan2(((android.graphics.Point) iPoint2).x - ((android.graphics.Point) iPoint).x, ((android.graphics.Point) iPoint).y - d) / 3.141592653589793d) * 180.0d);
    }

    private void reset() {
        try {
            com.amap.api.maps.utils.overlay.SmoothMoveMarker.a aVar = this.moveStatus;
            if (aVar == com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_RUNNING || aVar == com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_PAUSE) {
                this.exitFlag.set(true);
                this.mThreadPools.a(this.mStepDuration + 20, java.util.concurrent.TimeUnit.MILLISECONDS);
                com.amap.api.maps.model.Marker marker = this.marker;
                if (marker != null) {
                    marker.setAnimation(null);
                }
                this.moveStatus = com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_UNKNOWN;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            reset();
            this.mThreadPools.d();
            com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor = this.descriptor;
            if (bitmapDescriptor != null) {
                bitmapDescriptor.recycle();
            }
            com.amap.api.maps.model.Marker marker = this.marker;
            if (marker != null) {
                marker.destroy();
                this.marker = null;
            }
            synchronized (this.mLock) {
                this.points.clear();
                this.eachDistance.clear();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public int getIndex() {
        return this.index;
    }

    public com.amap.api.maps.model.Marker getMarker() {
        return this.marker;
    }

    public com.amap.api.maps.model.LatLng getPosition() {
        com.amap.api.maps.model.Marker marker = this.marker;
        if (marker == null) {
            return null;
        }
        return marker.getPosition();
    }

    public void removeMarker() {
        com.amap.api.maps.model.Marker marker = this.marker;
        if (marker != null) {
            marker.remove();
            this.marker = null;
        }
        this.points.clear();
        this.eachDistance.clear();
    }

    public void resetIndex() {
        this.index = 0;
    }

    public void setDescriptor(com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor) {
        com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor2 = this.descriptor;
        if (bitmapDescriptor2 != null) {
            bitmapDescriptor2.recycle();
        }
        this.descriptor = bitmapDescriptor;
        com.amap.api.maps.model.Marker marker = this.marker;
        if (marker != null) {
            marker.setIcon(bitmapDescriptor);
        }
    }

    public void setMoveListener(com.amap.api.maps.utils.overlay.SmoothMoveMarker.MoveListener moveListener) {
        this.moveListener = moveListener;
    }

    public void setPoints(java.util.List<com.amap.api.maps.model.LatLng> list) {
        synchronized (this.mLock) {
            if (list != null) {
                try {
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                if (list.size() >= 2) {
                    stopMove();
                    this.points.clear();
                    for (com.amap.api.maps.model.LatLng latLng : list) {
                        if (latLng != null) {
                            this.points.add(latLng);
                        }
                    }
                    this.eachDistance.clear();
                    this.totalDistance = 0.0d;
                    int i = 0;
                    while (i < this.points.size() - 1) {
                        com.amap.api.maps.model.LatLng latLng2 = this.points.get(i);
                        i++;
                        double calculateLineDistance = com.amap.api.maps.AMapUtils.calculateLineDistance(latLng2, this.points.get(i));
                        this.eachDistance.add(java.lang.Double.valueOf(calculateLineDistance));
                        this.totalDistance += calculateLineDistance;
                    }
                    this.remainDistance = this.totalDistance;
                    com.amap.api.maps.model.LatLng latLng3 = this.points.get(0);
                    com.amap.api.maps.model.Marker marker = this.marker;
                    if (marker != null) {
                        marker.setPosition(latLng3);
                        checkMarkerIcon();
                    } else {
                        if (this.descriptor == null) {
                            this.useDefaultDescriptor = true;
                        }
                        this.marker = this.mAMap.addMarker(new com.amap.api.maps.model.MarkerOptions().belowMaskLayer(true).position(latLng3).icon(this.descriptor).title("").anchor(0.5f, 0.5f));
                    }
                    reset();
                }
            }
        }
    }

    public void setPosition(com.amap.api.maps.model.LatLng latLng) {
        com.amap.api.maps.model.Marker marker = this.marker;
        if (marker != null) {
            marker.setPosition(latLng);
            checkMarkerIcon();
        } else {
            if (this.descriptor == null) {
                this.useDefaultDescriptor = true;
            }
            this.marker = this.mAMap.addMarker(new com.amap.api.maps.model.MarkerOptions().belowMaskLayer(true).position(latLng).icon(this.descriptor).title("").anchor(0.5f, 0.5f));
        }
    }

    public void setRotate(float f) {
        com.amap.api.maps.AMap aMap;
        com.amap.api.maps.model.CameraPosition cameraPosition;
        if (this.marker == null || (aMap = this.mAMap) == null || aMap == null || (cameraPosition = aMap.getCameraPosition()) == null) {
            return;
        }
        this.marker.setRotateAngle((360.0f - f) + cameraPosition.bearing);
    }

    public void setTotalDuration(int i) {
        this.duration = i * 1000;
    }

    public void setVisible(boolean z) {
        com.amap.api.maps.model.Marker marker = this.marker;
        if (marker != null) {
            marker.setVisible(z);
        }
    }

    public void startSmoothMove() {
        com.amap.api.maps.utils.overlay.SmoothMoveMarker.a aVar = this.moveStatus;
        if (aVar == com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_PAUSE) {
            this.moveStatus = com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_RUNNING;
            this.mAnimationBeginTime += java.lang.System.currentTimeMillis() - this.pauseMillis;
        } else if ((aVar == com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_UNKNOWN || aVar == com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_STOP) && this.points.size() > 0) {
            this.index = 0;
            try {
                this.mThreadPools.a(new com.amap.api.maps.utils.overlay.SmoothMoveMarker.b(this, (byte) 0));
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void stopMove() {
        if (this.moveStatus == com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_RUNNING) {
            this.moveStatus = com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_PAUSE;
            this.pauseMillis = java.lang.System.currentTimeMillis();
        }
    }
}
