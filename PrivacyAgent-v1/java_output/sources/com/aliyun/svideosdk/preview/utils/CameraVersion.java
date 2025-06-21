package com.aliyun.svideosdk.preview.utils;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class CameraVersion {
    private static final java.lang.String TAG = "CameraVersion";
    private static java.util.HashMap<java.lang.String, java.lang.Integer> mCameraHardLevelMap;
    private static java.util.HashMap<java.lang.String, android.graphics.Point> mCameraLensAngleMap;
    private static final java.util.HashMap<java.lang.Integer, java.lang.Integer> mHardLevelTable;
    private static int mHighestCamera2HardLevel;
    private static float mMaxLensAngle;

    @com.aliyun.Visible
    public enum Version {
        CAMERA2(1),
        CAMERA1(0);

        private int cameraVesion;

        Version(int i) {
            this.cameraVesion = i;
        }

        public int getVersion() {
            return this.cameraVesion;
        }
    }

    static {
        java.util.HashMap<java.lang.Integer, java.lang.Integer> hashMap = new java.util.HashMap<>();
        mHardLevelTable = hashMap;
        mCameraHardLevelMap = null;
        mCameraLensAngleMap = null;
        mHighestCamera2HardLevel = 0;
        mMaxLensAngle = 0.0f;
        hashMap.put(2, 0);
        hashMap.put(0, 1);
        hashMap.put(1, 2);
        hashMap.put(3, 3);
    }

    private static android.graphics.Point calculateSensorAngle(android.hardware.camera2.CameraCharacteristics cameraCharacteristics) {
        android.util.SizeF sizeF = (android.util.SizeF) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
        float[] fArr = (float[]) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
        float width = sizeF.getWidth() * 1.0f;
        float height = sizeF.getHeight() * 1.0f;
        android.graphics.Point point = new android.graphics.Point();
        float f = 0.0f;
        float f2 = 0.0f;
        for (float f3 : fArr) {
            float degrees = (float) java.lang.Math.toDegrees(java.lang.Math.atan(width / f3) * 2.0d);
            float degrees2 = (float) java.lang.Math.toDegrees(java.lang.Math.atan(height / f3) * 2.0d);
            if (degrees > f2 || degrees2 > f) {
                f = degrees2;
                f2 = degrees;
            }
        }
        point.set((int) f2, (int) f);
        return point;
    }

    public static int getCamera2HardLevel(android.content.Context context) {
        int i;
        if (context != null) {
            if (mCameraHardLevelMap == null) {
                getCameraInfo(context);
            }
            i = mHighestCamera2HardLevel;
        } else {
            i = 0;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("getCamera2HardLevel, highestLevel = ");
        sb.append(i);
        return i;
    }

    public static float getCamera2MaxLenAngle(android.content.Context context) {
        float f;
        if (context != null) {
            if (mCameraLensAngleMap == null) {
                getCameraInfo(context);
            }
            f = mMaxLensAngle;
        } else {
            f = 0.0f;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("getCamera2HardLevel, maxLensAngle = ");
        sb.append(f);
        return f;
    }

    public static void getCameraInfo(android.content.Context context) {
        if (context != null) {
            android.hardware.camera2.CameraManager cameraManager = (android.hardware.camera2.CameraManager) context.getSystemService(com.sensorsdata.sf.ui.view.UIProperty.action_type_camera);
            try {
                mCameraHardLevelMap = new java.util.HashMap<>();
                mCameraLensAngleMap = new java.util.HashMap<>();
                int i = 0;
                float f = 0.0f;
                for (java.lang.String str : cameraManager.getCameraIdList()) {
                    android.hardware.camera2.CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                    java.lang.Integer num = (java.lang.Integer) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                    mCameraHardLevelMap.put(str, num);
                    int intValue = mHardLevelTable.get(num).intValue();
                    if (intValue > i) {
                        i = intValue;
                    }
                    android.graphics.Point calculateSensorAngle = calculateSensorAngle(cameraCharacteristics);
                    if (calculateSensorAngle != null) {
                        mCameraLensAngleMap.put(str, calculateSensorAngle);
                        if (java.lang.Math.max(calculateSensorAngle.x, calculateSensorAngle.y) > f) {
                            f = java.lang.Math.max(calculateSensorAngle.x, calculateSensorAngle.y);
                        }
                    }
                }
                mHighestCamera2HardLevel = i;
                mMaxLensAngle = f;
            } catch (android.hardware.camera2.CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (com.aliyun.svideosdk.preview.utils.CameraVersion.mHighestCamera2HardLevel > 1) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isSupportCamera2(android.content.Context context) {
        boolean z;
        if (context != null) {
            if (mCameraHardLevelMap == null) {
                getCameraInfo(context);
            }
            z = true;
        }
        z = false;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("isSupportCamera2, bSupportCamera2 = ");
        sb.append(z);
        return z;
    }
}
