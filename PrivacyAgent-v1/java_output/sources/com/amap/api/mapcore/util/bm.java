package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public interface bm {

    public enum a {
        amap_exception(-1),
        network_exception(-1),
        file_io_exception(0),
        success_no_exception(1),
        cancel_no_exception(2);

        private int f;

        a(int i) {
            this.f = i;
        }
    }

    void a(long j, long j2);

    void a(com.amap.api.mapcore.util.bm.a aVar);

    void m();

    void n();

    void o();
}
