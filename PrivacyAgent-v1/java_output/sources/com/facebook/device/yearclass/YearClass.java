package com.facebook.device.yearclass;

/* loaded from: classes22.dex */
public class YearClass {
    public static final int CLASS_2008 = 2008;
    public static final int CLASS_2009 = 2009;
    public static final int CLASS_2010 = 2010;
    public static final int CLASS_2011 = 2011;
    public static final int CLASS_2012 = 2012;
    public static final int CLASS_2013 = 2013;
    public static final int CLASS_2014 = 2014;
    public static final int CLASS_2015 = 2015;
    public static final int CLASS_2016 = 2016;
    public static final int CLASS_UNKNOWN = -1;
    public static volatile java.lang.Integer a;

    public static int a(android.content.Context context) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        c(arrayList, e());
        c(arrayList, d());
        c(arrayList, f(context));
        if (arrayList.isEmpty()) {
            return -1;
        }
        java.util.Collections.sort(arrayList);
        if ((arrayList.size() & 1) == 1) {
            return ((java.lang.Integer) arrayList.get(arrayList.size() / 2)).intValue();
        }
        int size = (arrayList.size() / 2) - 1;
        return ((java.lang.Integer) arrayList.get(size)).intValue() + ((((java.lang.Integer) arrayList.get(size + 1)).intValue() - ((java.lang.Integer) arrayList.get(size)).intValue()) / 2);
    }

    public static int b(android.content.Context context) {
        long totalMemory = com.facebook.device.yearclass.DeviceInfo.getTotalMemory(context);
        if (totalMemory == -1) {
            return a(context);
        }
        if (totalMemory <= 805306368) {
            return com.facebook.device.yearclass.DeviceInfo.getNumberOfCPUCores() <= 1 ? 2009 : 2010;
        }
        if (totalMemory <= 1073741824) {
            return com.facebook.device.yearclass.DeviceInfo.getCPUMaxFreqKHz() < 1300000 ? 2011 : 2012;
        }
        if (totalMemory <= tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_LAYOUT_STEREO_DOWNMIX) {
            return com.facebook.device.yearclass.DeviceInfo.getCPUMaxFreqKHz() < 1800000 ? 2012 : 2013;
        }
        if (totalMemory <= tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_WIDE_LEFT) {
            return 2013;
        }
        if (totalMemory <= 3221225472L) {
            return 2014;
        }
        return totalMemory <= com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_FILE_SIZE_LIMIT ? 2015 : 2016;
    }

    public static void c(java.util.ArrayList<java.lang.Integer> arrayList, int i) {
        if (i != -1) {
            arrayList.add(java.lang.Integer.valueOf(i));
        }
    }

    public static int d() {
        long cPUMaxFreqKHz = com.facebook.device.yearclass.DeviceInfo.getCPUMaxFreqKHz();
        if (cPUMaxFreqKHz == -1) {
            return -1;
        }
        if (cPUMaxFreqKHz <= 528000) {
            return 2008;
        }
        if (cPUMaxFreqKHz <= 620000) {
            return 2009;
        }
        if (cPUMaxFreqKHz <= 1020000) {
            return 2010;
        }
        if (cPUMaxFreqKHz <= 1220000) {
            return 2011;
        }
        if (cPUMaxFreqKHz <= 1520000) {
            return 2012;
        }
        return cPUMaxFreqKHz <= 2020000 ? 2013 : 2014;
    }

    public static int e() {
        int numberOfCPUCores = com.facebook.device.yearclass.DeviceInfo.getNumberOfCPUCores();
        if (numberOfCPUCores < 1) {
            return -1;
        }
        if (numberOfCPUCores == 1) {
            return 2008;
        }
        return numberOfCPUCores <= 3 ? 2011 : 2012;
    }

    public static int f(android.content.Context context) {
        long totalMemory = com.facebook.device.yearclass.DeviceInfo.getTotalMemory(context);
        if (totalMemory <= 0) {
            return -1;
        }
        if (totalMemory <= 201326592) {
            return 2008;
        }
        if (totalMemory <= 304087040) {
            return 2009;
        }
        if (totalMemory <= tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_STEREO_LEFT) {
            return 2010;
        }
        if (totalMemory <= 1073741824) {
            return 2011;
        }
        if (totalMemory <= tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_LAYOUT_STEREO_DOWNMIX) {
            return 2012;
        }
        return totalMemory <= tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_WIDE_LEFT ? 2013 : 2014;
    }

    public static int get(android.content.Context context) {
        if (a == null) {
            synchronized (com.facebook.device.yearclass.YearClass.class) {
                if (a == null) {
                    a = java.lang.Integer.valueOf(b(context));
                }
            }
        }
        return a.intValue();
    }
}
