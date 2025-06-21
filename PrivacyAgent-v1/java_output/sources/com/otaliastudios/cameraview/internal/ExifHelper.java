package com.otaliastudios.cameraview.internal;

/* loaded from: classes19.dex */
public class ExifHelper {
    public static int getExifOrientation(int i) {
        int i2 = (i + com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 90) {
            return 6;
        }
        if (i2 == 180) {
            return 3;
        }
        if (i2 == 270) {
            return 8;
        }
        throw new java.lang.IllegalArgumentException("Invalid orientation: " + i);
    }

    public static int getOrientation(int i) {
        switch (i) {
            case 1:
            case 2:
            default:
                return 0;
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
        }
    }
}
