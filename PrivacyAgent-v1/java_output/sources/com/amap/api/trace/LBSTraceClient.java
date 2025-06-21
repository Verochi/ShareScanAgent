package com.amap.api.trace;

/* loaded from: classes12.dex */
public class LBSTraceClient {
    public static final java.lang.String LOCATE_TIMEOUT_ERROR = "定位超时";
    public static final java.lang.String MIN_GRASP_POINT_ERROR = "轨迹点太少或距离太近,轨迹纠偏失败";
    public static final java.lang.String TRACE_SUCCESS = "纠偏成功";
    public static final int TYPE_AMAP = 1;
    public static final int TYPE_BAIDU = 3;
    public static final int TYPE_GPS = 2;
    private static com.amap.api.trace.LBSTraceBase a;
    private static volatile com.amap.api.trace.LBSTraceClient b;

    private LBSTraceClient() {
    }

    public LBSTraceClient(android.content.Context context) throws java.lang.Exception {
        a(context);
    }

    private static void a() {
        a = null;
        b = null;
    }

    private static void a(android.content.Context context) throws java.lang.Exception {
        com.amap.api.mapcore.util.ff a2 = com.amap.api.mapcore.util.fe.a(context, com.amap.api.mapcore.util.dl.a());
        if (a2.a != com.amap.api.mapcore.util.fe.c.SuccessCode) {
            throw new java.lang.Exception(a2.b);
        }
        if (context != null) {
            a = new com.amap.api.mapcore.util.er(context.getApplicationContext());
        }
    }

    public static com.amap.api.trace.LBSTraceClient getInstance(android.content.Context context) throws java.lang.Exception {
        if (b == null) {
            synchronized (com.amap.api.trace.LBSTraceClient.class) {
                if (b == null) {
                    a(context);
                    b = new com.amap.api.trace.LBSTraceClient();
                }
            }
        }
        return b;
    }

    public void destroy() {
        com.amap.api.trace.LBSTraceBase lBSTraceBase = a;
        if (lBSTraceBase != null) {
            lBSTraceBase.destroy();
            a();
        }
    }

    public void queryProcessedTrace(int i, java.util.List<com.amap.api.trace.TraceLocation> list, int i2, com.amap.api.trace.TraceListener traceListener) {
        com.amap.api.trace.LBSTraceBase lBSTraceBase = a;
        if (lBSTraceBase != null) {
            lBSTraceBase.queryProcessedTrace(i, list, i2, traceListener);
        }
    }

    public void startTrace(com.amap.api.trace.TraceStatusListener traceStatusListener) {
        com.amap.api.trace.LBSTraceBase lBSTraceBase = a;
        if (lBSTraceBase != null) {
            lBSTraceBase.startTrace(traceStatusListener);
        }
    }

    public void stopTrace() {
        com.amap.api.trace.LBSTraceBase lBSTraceBase = a;
        if (lBSTraceBase != null) {
            lBSTraceBase.stopTrace();
        }
    }
}
