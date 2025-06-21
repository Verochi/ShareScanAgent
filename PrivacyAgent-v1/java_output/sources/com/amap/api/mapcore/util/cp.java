package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public abstract class cp extends com.amap.api.mapcore.util.hi {
    protected boolean isPostFlag = true;

    @Override // com.amap.api.mapcore.util.hi
    public java.util.Map<java.lang.String, java.lang.String> getParams() {
        return null;
    }

    public byte[] makeHttpRequest() throws com.amap.api.mapcore.util.eu {
        com.amap.api.mapcore.util.hj makeHttpRequestNeedHeader = makeHttpRequestNeedHeader();
        if (makeHttpRequestNeedHeader != null) {
            return makeHttpRequestNeedHeader.a;
        }
        return null;
    }

    public com.amap.api.mapcore.util.hj makeHttpRequestNeedHeader() throws com.amap.api.mapcore.util.eu {
        if (com.amap.api.mapcore.util.p.a != null && com.amap.api.mapcore.util.fe.a(com.amap.api.mapcore.util.p.a, com.amap.api.mapcore.util.dl.a()).a != com.amap.api.mapcore.util.fe.c.SuccessCode) {
            return null;
        }
        setHttpProtocol(com.amap.api.maps.MapsInitializer.getProtocol() == 1 ? com.amap.api.mapcore.util.hi.c.HTTP : com.amap.api.mapcore.util.hi.c.HTTPS);
        com.amap.api.mapcore.util.hh.c();
        return this.isPostFlag ? com.amap.api.mapcore.util.hb.b(this) : com.amap.api.mapcore.util.hh.f(this);
    }

    public byte[] makeHttpRequestWithInterrupted() throws com.amap.api.mapcore.util.eu {
        setDegradeAbility(com.amap.api.mapcore.util.hi.a.INTERRUPT_IO);
        return makeHttpRequest();
    }
}
