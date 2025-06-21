package com.huawei.hms.common.data;

/* loaded from: classes22.dex */
public final class DataBufferUtils {
    public static final int ARGS_BUNDLE = 4;
    public static final int ARGS_COLUMN = 1;
    public static final int ARGS_CURSOR = 2;
    public static final int ARGS_STATUS = 3;
    public static final int ARGS_VERSION = 1000;
    public static final java.lang.String NEXT_PAGE = "next_page";
    public static final java.lang.String PREV_PAGE = "prev_page";

    private DataBufferUtils() {
    }

    private static boolean containKey(android.os.Bundle bundle, java.lang.String str) {
        return (bundle == null || bundle.getString(str) == null) ? false : true;
    }

    public static <T, E extends com.huawei.hms.common.data.Freezable<T>> java.util.ArrayList<T> freezeAndClose(com.huawei.hms.common.data.DataBuffer<E> dataBuffer) {
        com.xiaomi.push.service.cd cdVar = (java.util.ArrayList<T>) new java.util.ArrayList(dataBuffer.getCount());
        java.util.Iterator<E> it = dataBuffer.iterator();
        while (it.hasNext()) {
            cdVar.add(it.next().freeze());
        }
        dataBuffer.release();
        return cdVar;
    }

    public static boolean hasData(com.huawei.hms.common.data.DataBuffer<?> dataBuffer) {
        return dataBuffer != null && dataBuffer.getCount() > 0;
    }

    public static boolean hasNextPage(com.huawei.hms.common.data.DataBuffer<?> dataBuffer) {
        return containKey(dataBuffer.getMetadata(), NEXT_PAGE);
    }

    public static boolean hasPrevPage(com.huawei.hms.common.data.DataBuffer<?> dataBuffer) {
        return containKey(dataBuffer.getMetadata(), PREV_PAGE);
    }
}
