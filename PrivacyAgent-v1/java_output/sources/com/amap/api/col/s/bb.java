package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class bb implements com.amap.api.services.interfaces.INearbySearch {
    public static long l;
    public java.lang.String b;
    public android.content.Context c;
    public com.amap.api.col.s.s d;
    public java.util.concurrent.ExecutorService e;
    public com.amap.api.services.nearby.UploadInfoCallback j;
    public java.util.TimerTask k;
    public java.util.List<com.amap.api.services.nearby.NearbySearch.NearbyListener> a = new java.util.ArrayList();
    public com.amap.api.services.core.LatLonPoint f = null;
    public java.lang.String g = null;
    public boolean h = false;
    public java.util.Timer i = new java.util.Timer();

    /* renamed from: com.amap.api.col.s.bb$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.bb.this.d.obtainMessage();
            obtainMessage.arg1 = 8;
            obtainMessage.obj = com.amap.api.col.s.bb.this.a;
            try {
                try {
                    com.amap.api.col.s.bb.this.a();
                    obtainMessage.what = 1000;
                    if (com.amap.api.col.s.bb.this.d == null) {
                        return;
                    }
                } catch (com.amap.api.services.core.AMapException e) {
                    obtainMessage.what = e.getErrorCode();
                    com.amap.api.col.s.i.a(e, "NearbySearch", "clearUserInfoAsyn");
                    if (com.amap.api.col.s.bb.this.d == null) {
                        return;
                    }
                }
                com.amap.api.col.s.bb.this.d.sendMessage(obtainMessage);
            } catch (java.lang.Throwable th) {
                if (com.amap.api.col.s.bb.this.d != null) {
                    com.amap.api.col.s.bb.this.d.sendMessage(obtainMessage);
                }
                throw th;
            }
        }
    }

    /* renamed from: com.amap.api.col.s.bb$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.nearby.UploadInfo n;

        public AnonymousClass2(com.amap.api.services.nearby.UploadInfo uploadInfo) {
            this.n = uploadInfo;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                android.os.Message obtainMessage = com.amap.api.col.s.bb.this.d.obtainMessage();
                obtainMessage.arg1 = 10;
                obtainMessage.obj = com.amap.api.col.s.bb.this.a;
                obtainMessage.what = com.amap.api.col.s.bb.this.c(this.n);
                com.amap.api.col.s.bb.this.d.sendMessage(obtainMessage);
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.i.a(th, "NearbySearch", "uploadNearbyInfoAsyn");
            }
        }
    }

    /* renamed from: com.amap.api.col.s.bb$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.nearby.NearbySearch.NearbyQuery n;

        public AnonymousClass3(com.amap.api.services.nearby.NearbySearch.NearbyQuery nearbyQuery) {
            this.n = nearbyQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.bb.this.d.obtainMessage();
            obtainMessage.arg1 = 9;
            com.amap.api.col.s.s.f fVar = new com.amap.api.col.s.s.f();
            fVar.a = com.amap.api.col.s.bb.this.a;
            obtainMessage.obj = fVar;
            try {
                try {
                    fVar.b = com.amap.api.col.s.bb.this.searchNearbyInfo(this.n);
                    obtainMessage.what = 1000;
                    if (com.amap.api.col.s.bb.this.d == null) {
                        return;
                    }
                } catch (com.amap.api.services.core.AMapException e) {
                    obtainMessage.what = e.getErrorCode();
                    com.amap.api.col.s.i.a(e, "NearbySearch", "searchNearbyInfoAsyn");
                    if (com.amap.api.col.s.bb.this.d == null) {
                        return;
                    }
                }
                com.amap.api.col.s.bb.this.d.sendMessage(obtainMessage);
            } catch (java.lang.Throwable th) {
                if (com.amap.api.col.s.bb.this.d != null) {
                    com.amap.api.col.s.bb.this.d.sendMessage(obtainMessage);
                }
                throw th;
            }
        }
    }

    public class a extends java.util.TimerTask {
        public a() {
        }

        public /* synthetic */ a(com.amap.api.col.s.bb bbVar, byte b) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            try {
                if (com.amap.api.col.s.bb.this.j != null) {
                    int h = com.amap.api.col.s.bb.this.h(com.amap.api.col.s.bb.this.j.OnUploadInfoCallback());
                    android.os.Message obtainMessage = com.amap.api.col.s.bb.this.d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = com.amap.api.col.s.bb.this.a;
                    obtainMessage.what = h;
                    com.amap.api.col.s.bb.this.d.sendMessage(obtainMessage);
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.i.a(th, "NearbySearch", "UpdateDataTask");
            }
        }
    }

    public bb(android.content.Context context) throws com.amap.api.services.core.AMapException {
        com.amap.api.col.s.bs a2 = com.amap.api.col.s.br.a(context, com.amap.api.col.s.h.a(false));
        if (a2.a != com.amap.api.col.s.br.c.SuccessCode) {
            java.lang.String str = a2.b;
            throw new com.amap.api.services.core.AMapException(str, 1, str, a2.a.a());
        }
        this.c = context.getApplicationContext();
        this.d = com.amap.api.col.s.s.a();
    }

    public static boolean e(com.amap.api.services.nearby.NearbySearch.NearbyQuery nearbyQuery) {
        return (nearbyQuery == null || nearbyQuery.getCenterPoint() == null) ? false : true;
    }

    public static boolean f(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return java.util.regex.Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(str).find();
    }

    public final int a() throws com.amap.api.services.core.AMapException {
        try {
            if (this.h) {
                throw new com.amap.api.services.core.AMapException(com.amap.api.services.core.AMapException.AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR);
            }
            if (!f(this.b)) {
                throw new com.amap.api.services.core.AMapException(com.amap.api.services.core.AMapException.AMAP_CLIENT_USERID_ILLEGAL);
            }
            com.amap.api.col.s.q.a(this.c);
            return new com.amap.api.col.s.t(this.c, this.b).b().intValue();
        } catch (com.amap.api.services.core.AMapException e) {
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void addNearbyListener(com.amap.api.services.nearby.NearbySearch.NearbyListener nearbyListener) {
        try {
            this.a.add(nearbyListener);
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "NearbySearch", "addNearbyListener");
        }
    }

    public final int c(com.amap.api.services.nearby.UploadInfo uploadInfo) {
        if (this.h) {
            return 2200;
        }
        return h(uploadInfo);
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void clearUserInfoAsyn() {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.bb.AnonymousClass1());
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "NearbySearch", "clearUserInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void destroy() {
        try {
            this.i.cancel();
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "NearbySearch", "destryoy");
        }
    }

    public final int h(com.amap.api.services.nearby.UploadInfo uploadInfo) {
        try {
            com.amap.api.col.s.q.a(this.c);
            if (uploadInfo == null) {
                return 2202;
            }
            long time = new java.util.Date().getTime();
            if (time - l < 6500) {
                return com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_UPLOAD_TOO_FREQUENT;
            }
            l = time;
            java.lang.String userID = uploadInfo.getUserID();
            if (!f(userID)) {
                return 2201;
            }
            if (android.text.TextUtils.isEmpty(this.g)) {
                this.g = userID;
            }
            if (!userID.equals(this.g)) {
                return 2201;
            }
            com.amap.api.services.core.LatLonPoint point = uploadInfo.getPoint();
            if (point != null && !point.equals(this.f)) {
                new com.amap.api.col.s.v(this.c, uploadInfo).b();
                this.f = point.copy();
                return 1000;
            }
            return com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_UPLOAD_LOCATION_ERROR;
        } catch (com.amap.api.services.core.AMapException e) {
            return e.getErrorCode();
        } catch (java.lang.Throwable unused) {
            return 1900;
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void removeNearbyListener(com.amap.api.services.nearby.NearbySearch.NearbyListener nearbyListener) {
        if (nearbyListener == null) {
            return;
        }
        try {
            this.a.remove(nearbyListener);
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "NearbySearch", "removeNearbyListener");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final com.amap.api.services.nearby.NearbySearchResult searchNearbyInfo(com.amap.api.services.nearby.NearbySearch.NearbyQuery nearbyQuery) throws com.amap.api.services.core.AMapException {
        try {
            com.amap.api.col.s.q.a(this.c);
            if (e(nearbyQuery)) {
                return new com.amap.api.col.s.u(this.c, nearbyQuery).b();
            }
            throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
        } catch (com.amap.api.services.core.AMapException e) {
            throw e;
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "NearbySearch", "searchNearbyInfo");
            throw new com.amap.api.services.core.AMapException(com.amap.api.services.core.AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void searchNearbyInfoAsyn(com.amap.api.services.nearby.NearbySearch.NearbyQuery nearbyQuery) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.bb.AnonymousClass3(nearbyQuery));
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "NearbySearch", "searchNearbyInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void setUserID(java.lang.String str) {
        this.b = str;
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void startUploadNearbyInfoAuto(com.amap.api.services.nearby.UploadInfoCallback uploadInfoCallback, int i) {
        java.util.TimerTask timerTask;
        if (i < 7000) {
            i = com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND;
        }
        try {
            this.j = uploadInfoCallback;
            if (this.h && (timerTask = this.k) != null) {
                timerTask.cancel();
            }
            this.h = true;
            com.amap.api.col.s.bb.a aVar = new com.amap.api.col.s.bb.a(this, (byte) 0);
            this.k = aVar;
            this.i.schedule(aVar, 0L, i);
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "NearbySearch", "startUploadNearbyInfoAuto");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void stopUploadNearbyInfoAuto() {
        try {
            java.util.TimerTask timerTask = this.k;
            if (timerTask != null) {
                timerTask.cancel();
            }
        } finally {
            this.h = false;
            this.k = null;
        }
        this.h = false;
        this.k = null;
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void uploadNearbyInfoAsyn(com.amap.api.services.nearby.UploadInfo uploadInfo) {
        if (this.e == null) {
            this.e = java.util.concurrent.Executors.newSingleThreadExecutor();
        }
        this.e.submit(new com.amap.api.col.s.bb.AnonymousClass2(uploadInfo));
    }
}
