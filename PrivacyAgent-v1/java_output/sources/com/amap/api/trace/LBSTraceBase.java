package com.amap.api.trace;

/* loaded from: classes12.dex */
public interface LBSTraceBase {
    void destroy();

    void queryProcessedTrace(int i, java.util.List<com.amap.api.trace.TraceLocation> list, int i2, com.amap.api.trace.TraceListener traceListener);

    void setLocationInterval(long j);

    void setTraceStatusInterval(int i);

    void startTrace(com.amap.api.trace.TraceStatusListener traceStatusListener);

    void stopTrace();
}
