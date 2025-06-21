package com.hbzhou.open.flowcamera.util;

/* loaded from: classes22.dex */
public class CameraParamUtil {
    public static com.hbzhou.open.flowcamera.util.CameraParamUtil b;
    public com.hbzhou.open.flowcamera.util.CameraParamUtil.CameraSizeComparator a = new com.hbzhou.open.flowcamera.util.CameraParamUtil.CameraSizeComparator(this, null);

    public class CameraSizeComparator implements java.util.Comparator<android.hardware.Camera.Size> {
        public CameraSizeComparator() {
        }

        public /* synthetic */ CameraSizeComparator(com.hbzhou.open.flowcamera.util.CameraParamUtil cameraParamUtil, defpackage.gk gkVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(android.hardware.Camera.Size size, android.hardware.Camera.Size size2) {
            int i = size.width;
            int i2 = size2.width;
            if (i == i2) {
                return 0;
            }
            return i > i2 ? 1 : -1;
        }
    }

    public static com.hbzhou.open.flowcamera.util.CameraParamUtil getInstance() {
        com.hbzhou.open.flowcamera.util.CameraParamUtil cameraParamUtil = b;
        if (cameraParamUtil != null) {
            return cameraParamUtil;
        }
        com.hbzhou.open.flowcamera.util.CameraParamUtil cameraParamUtil2 = new com.hbzhou.open.flowcamera.util.CameraParamUtil();
        b = cameraParamUtil2;
        return cameraParamUtil2;
    }

    public final boolean a(android.hardware.Camera.Size size, float f) {
        return ((double) java.lang.Math.abs((((float) size.width) / ((float) size.height)) - f)) <= 0.2d;
    }

    public final android.hardware.Camera.Size b(java.util.List<android.hardware.Camera.Size> list, float f) {
        float f2 = 100.0f;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            android.hardware.Camera.Size size = list.get(i2);
            float f3 = f - (size.width / size.height);
            if (java.lang.Math.abs(f3) < f2) {
                f2 = java.lang.Math.abs(f3);
                i = i2;
            }
        }
        return list.get(i);
    }

    public int getCameraDisplayOrientation(android.content.Context context, int i) {
        android.hardware.Camera.CameraInfo cameraInfo = new android.hardware.Camera.CameraInfo();
        android.hardware.Camera.getCameraInfo(i, cameraInfo);
        int rotation = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        int i2 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i2 = 90;
            } else if (rotation == 2) {
                i2 = 180;
            } else if (rotation == 3) {
                i2 = 270;
            }
        }
        return cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i2) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE)) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE : ((cameraInfo.orientation - i2) + com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
    }

    public android.hardware.Camera.Size getPictureSize(java.util.List<android.hardware.Camera.Size> list, int i, float f) {
        java.util.Collections.sort(list, this.a);
        java.util.Iterator<android.hardware.Camera.Size> it = list.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            android.hardware.Camera.Size next = it.next();
            if (next.width > i && a(next, f)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("MakeSure Picture :w = ");
                sb.append(next.width);
                sb.append(" h = ");
                sb.append(next.height);
                break;
            }
            i2++;
        }
        return i2 == list.size() ? b(list, f) : list.get(i2);
    }

    public android.hardware.Camera.Size getPreviewSize(java.util.List<android.hardware.Camera.Size> list, int i, float f) {
        java.util.Collections.sort(list, this.a);
        java.util.Iterator<android.hardware.Camera.Size> it = list.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            android.hardware.Camera.Size next = it.next();
            if (next.width > i && a(next, f)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("MakeSure Preview :w = ");
                sb.append(next.width);
                sb.append(" h = ");
                sb.append(next.height);
                break;
            }
            i2++;
        }
        return i2 == list.size() ? b(list, f) : list.get(i2);
    }

    public boolean isSupportedFocusMode(java.util.List<java.lang.String> list, java.lang.String str) {
        for (int i = 0; i < list.size(); i++) {
            if (str.equals(list.get(i))) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("FocusMode supported ");
                sb.append(str);
                return true;
            }
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("FocusMode not supported ");
        sb2.append(str);
        return false;
    }

    public boolean isSupportedPictureFormats(java.util.List<java.lang.Integer> list, int i) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i == list.get(i2).intValue()) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Formats supported ");
                sb.append(i);
                return true;
            }
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("Formats not supported ");
        sb2.append(i);
        return false;
    }
}
