package com.aliyun.vod.common.utils;

/* loaded from: classes12.dex */
public class MatrixUtil {
    public static float[] getTransform(android.graphics.Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr;
    }
}
