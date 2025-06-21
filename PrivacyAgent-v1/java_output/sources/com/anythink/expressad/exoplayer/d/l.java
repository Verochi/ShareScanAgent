package com.anythink.expressad.exoplayer.d;

@android.annotation.TargetApi(23)
/* loaded from: classes12.dex */
public final class l implements com.anythink.expressad.exoplayer.d.j<com.anythink.expressad.exoplayer.d.k> {
    private static final java.lang.String g = "cenc";
    private final java.util.UUID h;
    private final android.media.MediaDrm i;

    /* renamed from: com.anythink.expressad.exoplayer.d.l$1, reason: invalid class name */
    public class AnonymousClass1 implements android.media.MediaDrm.OnEventListener {
        final /* synthetic */ com.anythink.expressad.exoplayer.d.j.f a;

        public AnonymousClass1(com.anythink.expressad.exoplayer.d.j.f fVar) {
            this.a = fVar;
        }

        @Override // android.media.MediaDrm.OnEventListener
        public final void onEvent(@androidx.annotation.NonNull android.media.MediaDrm mediaDrm, @androidx.annotation.Nullable byte[] bArr, int i, int i2, byte[] bArr2) {
            this.a.a(bArr, i);
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.d.l$2, reason: invalid class name */
    public class AnonymousClass2 implements android.media.MediaDrm.OnKeyStatusChangeListener {
        final /* synthetic */ com.anythink.expressad.exoplayer.d.j.g a;

        public AnonymousClass2(com.anythink.expressad.exoplayer.d.j.g gVar) {
            this.a = gVar;
        }

        @Override // android.media.MediaDrm.OnKeyStatusChangeListener
        public final void onKeyStatusChange(@androidx.annotation.NonNull android.media.MediaDrm mediaDrm, @androidx.annotation.NonNull byte[] bArr, @androidx.annotation.NonNull java.util.List<android.media.MediaDrm.KeyStatus> list, boolean z) {
            int statusCode;
            byte[] keyId;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (android.media.MediaDrm.KeyStatus keyStatus : list) {
                statusCode = keyStatus.getStatusCode();
                keyId = keyStatus.getKeyId();
                arrayList.add(new com.anythink.expressad.exoplayer.d.j.b(statusCode, keyId));
            }
        }
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    private l(java.util.UUID uuid) {
        com.anythink.expressad.exoplayer.k.a.a(uuid);
        java.util.UUID uuid2 = com.anythink.expressad.exoplayer.b.bi;
        com.anythink.expressad.exoplayer.k.a.a(!uuid2.equals(uuid), "Use C.CLEARKEY_UUID instead");
        if (com.anythink.expressad.exoplayer.k.af.a < 27 && com.anythink.expressad.exoplayer.b.bj.equals(uuid)) {
            uuid = uuid2;
        }
        this.h = uuid;
        android.media.MediaDrm mediaDrm = new android.media.MediaDrm(uuid);
        this.i = mediaDrm;
        if (com.anythink.expressad.exoplayer.b.bk.equals(uuid) && "ASUS_Z00AD".equals(com.anythink.expressad.exoplayer.k.af.d)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    public static com.anythink.expressad.exoplayer.d.l a(java.util.UUID uuid) {
        try {
            return new com.anythink.expressad.exoplayer.d.l(uuid);
        } catch (java.lang.Exception e) {
            throw new com.anythink.expressad.exoplayer.d.o(e);
        }
    }

    private static boolean d() {
        return "ASUS_Z00AD".equals(com.anythink.expressad.exoplayer.k.af.d);
    }

    private com.anythink.expressad.exoplayer.d.k e(byte[] bArr) {
        return new com.anythink.expressad.exoplayer.d.k(new android.media.MediaCrypto(this.h, bArr), com.anythink.expressad.exoplayer.k.af.a < 21 && com.anythink.expressad.exoplayer.b.bk.equals(this.h) && "L3".equals(a("securityLevel")));
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x003c, code lost:
    
        if ("AFTM".equals(r1) == false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
    @Override // com.anythink.expressad.exoplayer.d.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.anythink.expressad.exoplayer.d.j.d a(byte[] bArr, byte[] bArr2, java.lang.String str, int i, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        byte[] bArr3;
        byte[] data;
        int i2 = com.anythink.expressad.exoplayer.k.af.a;
        if (i2 >= 21 || !com.anythink.expressad.exoplayer.b.bk.equals(this.h)) {
            if (com.anythink.expressad.exoplayer.b.bl.equals(this.h) && "Amazon".equals(com.anythink.expressad.exoplayer.k.af.c)) {
                java.lang.String str2 = com.anythink.expressad.exoplayer.k.af.d;
                if (!"AFTB".equals(str2)) {
                    if (!"AFTS".equals(str2)) {
                    }
                }
            }
            bArr3 = bArr2;
            if (i2 < 26 && com.anythink.expressad.exoplayer.b.bj.equals(this.h) && ("video/mp4".equals(str) || "audio/mp4".equals(str))) {
                str = "cenc";
            }
            android.media.MediaDrm.KeyRequest keyRequest = this.i.getKeyRequest(bArr, bArr3, str, i, hashMap);
            data = keyRequest.getData();
            if (com.anythink.expressad.exoplayer.b.bj.equals(this.h) && i2 < 27) {
                data = com.anythink.expressad.exoplayer.k.af.c(com.anythink.expressad.exoplayer.k.af.a(data).replace('+', '-').replace('/', '_'));
            }
            return new com.anythink.expressad.exoplayer.d.j.a(data, keyRequest.getDefaultUrl());
        }
        byte[] a = com.anythink.expressad.exoplayer.e.a.h.a(bArr2, this.h);
        if (a != null) {
            bArr3 = a;
            if (i2 < 26) {
                str = "cenc";
            }
            android.media.MediaDrm.KeyRequest keyRequest2 = this.i.getKeyRequest(bArr, bArr3, str, i, hashMap);
            data = keyRequest2.getData();
            if (com.anythink.expressad.exoplayer.b.bj.equals(this.h)) {
                data = com.anythink.expressad.exoplayer.k.af.c(com.anythink.expressad.exoplayer.k.af.a(data).replace('+', '-').replace('/', '_'));
            }
            return new com.anythink.expressad.exoplayer.d.j.a(data, keyRequest2.getDefaultUrl());
        }
        bArr3 = bArr2;
        if (i2 < 26) {
        }
        android.media.MediaDrm.KeyRequest keyRequest22 = this.i.getKeyRequest(bArr, bArr3, str, i, hashMap);
        data = keyRequest22.getData();
        if (com.anythink.expressad.exoplayer.b.bj.equals(this.h)) {
        }
        return new com.anythink.expressad.exoplayer.d.j.a(data, keyRequest22.getDefaultUrl());
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final java.lang.String a(java.lang.String str) {
        return this.i.getPropertyString(str);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void a(com.anythink.expressad.exoplayer.d.j.f<? super com.anythink.expressad.exoplayer.d.k> fVar) {
        this.i.setOnEventListener(new com.anythink.expressad.exoplayer.d.l.AnonymousClass1(fVar));
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void a(com.anythink.expressad.exoplayer.d.j.g<? super com.anythink.expressad.exoplayer.d.k> gVar) {
        if (com.anythink.expressad.exoplayer.k.af.a < 23) {
            throw new java.lang.UnsupportedOperationException();
        }
        this.i.setOnKeyStatusChangeListener(gVar == null ? null : new com.anythink.expressad.exoplayer.d.l.AnonymousClass2(gVar), (android.os.Handler) null);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void a(java.lang.String str, java.lang.String str2) {
        this.i.setPropertyString(str, str2);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void a(java.lang.String str, byte[] bArr) {
        this.i.setPropertyByteArray(str, bArr);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void a(byte[] bArr) {
        this.i.closeSession(bArr);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final byte[] a() {
        return this.i.openSession();
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        if (com.anythink.expressad.exoplayer.b.bj.equals(this.h)) {
            bArr2 = com.anythink.expressad.exoplayer.d.a.a(bArr2);
        }
        return this.i.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final com.anythink.expressad.exoplayer.d.j.h b() {
        android.media.MediaDrm.ProvisionRequest provisionRequest = this.i.getProvisionRequest();
        return new com.anythink.expressad.exoplayer.d.j.c(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void b(byte[] bArr) {
        this.i.provideProvisionResponse(bArr);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void b(byte[] bArr, byte[] bArr2) {
        this.i.restoreKeys(bArr, bArr2);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final byte[] b(java.lang.String str) {
        return this.i.getPropertyByteArray(str);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final java.util.Map<java.lang.String, java.lang.String> c(byte[] bArr) {
        return this.i.queryKeyStatus(bArr);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void c() {
        this.i.release();
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final /* synthetic */ com.anythink.expressad.exoplayer.d.k d(byte[] bArr) {
        return new com.anythink.expressad.exoplayer.d.k(new android.media.MediaCrypto(this.h, bArr), com.anythink.expressad.exoplayer.k.af.a < 21 && com.anythink.expressad.exoplayer.b.bk.equals(this.h) && "L3".equals(a("securityLevel")));
    }
}
