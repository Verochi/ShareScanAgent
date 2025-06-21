package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public final class RuntimeRemoteException extends java.lang.RuntimeException {
    private static final long serialVersionUID = -3541841807100437802L;

    public RuntimeRemoteException(android.os.RemoteException remoteException) {
        super(remoteException);
    }

    public RuntimeRemoteException(java.lang.String str) {
        super(str);
    }
}
