package com.google.android.exoplayer2.drm;

@androidx.annotation.RequiresApi(18)
/* loaded from: classes22.dex */
public final class FrameworkMediaDrm implements com.google.android.exoplayer2.drm.ExoMediaDrm {
    public static final com.google.android.exoplayer2.drm.ExoMediaDrm.Provider DEFAULT_PROVIDER = new defpackage.ri0();
    public final java.util.UUID a;
    public final android.media.MediaDrm b;
    public int c;

    public FrameworkMediaDrm(java.util.UUID uuid) throws android.media.UnsupportedSchemeException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(uuid);
        com.google.android.exoplayer2.util.Assertions.checkArgument(!com.google.android.exoplayer2.C.COMMON_PSSH_UUID.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.a = uuid;
        android.media.MediaDrm mediaDrm = new android.media.MediaDrm(i(uuid));
        this.b = mediaDrm;
        this.c = 1;
        if (com.google.android.exoplayer2.C.WIDEVINE_UUID.equals(uuid) && p()) {
            j(mediaDrm);
        }
    }

    public static byte[] e(byte[] bArr) {
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(bArr);
        int readLittleEndianInt = parsableByteArray.readLittleEndianInt();
        short readLittleEndianShort = parsableByteArray.readLittleEndianShort();
        short readLittleEndianShort2 = parsableByteArray.readLittleEndianShort();
        if (readLittleEndianShort != 1 || readLittleEndianShort2 != 1) {
            com.google.android.exoplayer2.util.Log.i("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        short readLittleEndianShort3 = parsableByteArray.readLittleEndianShort();
        java.nio.charset.Charset charset = com.google.common.base.Charsets.UTF_16LE;
        java.lang.String readString = parsableByteArray.readString(readLittleEndianShort3, charset);
        if (readString.contains("<LA_URL>")) {
            return bArr;
        }
        int indexOf = readString.indexOf("</DATA>");
        if (indexOf == -1) {
            com.google.android.exoplayer2.util.Log.w("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        java.lang.String substring = readString.substring(0, indexOf);
        java.lang.String substring2 = readString.substring(indexOf);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(substring).length() + 26 + java.lang.String.valueOf(substring2).length());
        sb.append(substring);
        sb.append("<LA_URL>https://x</LA_URL>");
        sb.append(substring2);
        java.lang.String sb2 = sb.toString();
        int i = readLittleEndianInt + 52;
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(i);
        allocate.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(i);
        allocate.putShort(readLittleEndianShort);
        allocate.putShort(readLittleEndianShort2);
        allocate.putShort((short) (sb2.length() * 2));
        allocate.put(sb2.getBytes(charset));
        return allocate.array();
    }

    public static byte[] f(java.util.UUID uuid, byte[] bArr) {
        return com.google.android.exoplayer2.C.CLEARKEY_UUID.equals(uuid) ? com.google.android.exoplayer2.drm.ClearKeyUtil.a(bArr) : bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        if ("AFTT".equals(r0) == false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] g(java.util.UUID uuid, byte[] bArr) {
        java.util.UUID uuid2 = com.google.android.exoplayer2.C.PLAYREADY_UUID;
        if (uuid2.equals(uuid)) {
            byte[] parseSchemeSpecificData = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.parseSchemeSpecificData(bArr, uuid);
            if (parseSchemeSpecificData != null) {
                bArr = parseSchemeSpecificData;
            }
            bArr = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.buildPsshAtom(uuid2, e(bArr));
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 23 || !com.google.android.exoplayer2.C.WIDEVINE_UUID.equals(uuid)) {
            if (uuid2.equals(uuid) && "Amazon".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER)) {
                java.lang.String str = com.google.android.exoplayer2.util.Util.MODEL;
                if (!"AFTB".equals(str)) {
                    if (!"AFTS".equals(str)) {
                        if (!"AFTM".equals(str)) {
                        }
                    }
                }
            }
        }
        byte[] parseSchemeSpecificData2 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.parseSchemeSpecificData(bArr, uuid);
        return parseSchemeSpecificData2 != null ? parseSchemeSpecificData2 : bArr;
    }

    public static java.lang.String h(java.util.UUID uuid, java.lang.String str) {
        return (com.google.android.exoplayer2.util.Util.SDK_INT < 26 && com.google.android.exoplayer2.C.CLEARKEY_UUID.equals(uuid) && ("video/mp4".equals(str) || "audio/mp4".equals(str))) ? "cenc" : str;
    }

    public static java.util.UUID i(java.util.UUID uuid) {
        return (com.google.android.exoplayer2.util.Util.SDK_INT >= 27 || !com.google.android.exoplayer2.C.CLEARKEY_UUID.equals(uuid)) ? uuid : com.google.android.exoplayer2.C.COMMON_PSSH_UUID;
    }

    public static boolean isCryptoSchemeSupported(java.util.UUID uuid) {
        return android.media.MediaDrm.isCryptoSchemeSupported(i(uuid));
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    public static void j(android.media.MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    public static com.google.android.exoplayer2.drm.DrmInitData.SchemeData k(java.util.UUID uuid, java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list) {
        boolean z;
        if (!com.google.android.exoplayer2.C.WIDEVINE_UUID.equals(uuid)) {
            return list.get(0);
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 28 && list.size() > 1) {
            com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData = list.get(0);
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData2 = list.get(i2);
                byte[] bArr = (byte[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(schemeData2.data);
                if (!com.google.android.exoplayer2.util.Util.areEqual(schemeData2.mimeType, schemeData.mimeType) || !com.google.android.exoplayer2.util.Util.areEqual(schemeData2.licenseServerUrl, schemeData.licenseServerUrl) || !com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.isPsshAtom(bArr)) {
                    z = false;
                    break;
                }
                i += bArr.length;
            }
            z = true;
            if (z) {
                byte[] bArr2 = new byte[i];
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    byte[] bArr3 = (byte[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(list.get(i4).data);
                    int length = bArr3.length;
                    java.lang.System.arraycopy(bArr3, 0, bArr2, i3, length);
                    i3 += length;
                }
                return schemeData.copyWithData(bArr2);
            }
        }
        for (int i5 = 0; i5 < list.size(); i5++) {
            com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData3 = list.get(i5);
            int parseVersion = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.parseVersion((byte[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(schemeData3.data));
            int i6 = com.google.android.exoplayer2.util.Util.SDK_INT;
            if (i6 < 23 && parseVersion == 0) {
                return schemeData3;
            }
            if (i6 >= 23 && parseVersion == 1) {
                return schemeData3;
            }
        }
        return list.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener onEventListener, android.media.MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        onEventListener.onEvent(this, bArr, i, i2, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(com.google.android.exoplayer2.drm.ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener, android.media.MediaDrm mediaDrm, byte[] bArr, long j) {
        onExpirationUpdateListener.onExpirationUpdate(this, bArr, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(com.google.android.exoplayer2.drm.ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener, android.media.MediaDrm mediaDrm, byte[] bArr, java.util.List list, boolean z) {
        int statusCode;
        byte[] keyId;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            android.media.MediaDrm.KeyStatus keyStatus = (android.media.MediaDrm.KeyStatus) it.next();
            statusCode = keyStatus.getStatusCode();
            keyId = keyStatus.getKeyId();
            arrayList.add(new com.google.android.exoplayer2.drm.ExoMediaDrm.KeyStatus(statusCode, keyId));
        }
        onKeyStatusChangeListener.onKeyStatusChange(this, bArr, arrayList, z);
    }

    public static com.google.android.exoplayer2.drm.FrameworkMediaDrm newInstance(java.util.UUID uuid) throws com.google.android.exoplayer2.drm.UnsupportedDrmException {
        try {
            return new com.google.android.exoplayer2.drm.FrameworkMediaDrm(uuid);
        } catch (android.media.UnsupportedSchemeException e) {
            throw new com.google.android.exoplayer2.drm.UnsupportedDrmException(1, e);
        } catch (java.lang.Exception e2) {
            throw new com.google.android.exoplayer2.drm.UnsupportedDrmException(2, e2);
        }
    }

    public static /* synthetic */ com.google.android.exoplayer2.drm.ExoMediaDrm o(java.util.UUID uuid) {
        try {
            return newInstance(uuid);
        } catch (com.google.android.exoplayer2.drm.UnsupportedDrmException unused) {
            java.lang.String valueOf = java.lang.String.valueOf(uuid);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 53);
            sb.append("Failed to instantiate a FrameworkMediaDrm for uuid: ");
            sb.append(valueOf);
            sb.append(".");
            com.google.android.exoplayer2.util.Log.e("FrameworkMediaDrm", sb.toString());
            return new com.google.android.exoplayer2.drm.DummyExoMediaDrm();
        }
    }

    public static boolean p() {
        return "ASUS_Z00AD".equals(com.google.android.exoplayer2.util.Util.MODEL);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public synchronized void acquire() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.c > 0);
        this.c++;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void closeSession(byte[] bArr) {
        this.b.closeSession(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public com.google.android.exoplayer2.drm.FrameworkMediaCrypto createMediaCrypto(byte[] bArr) throws android.media.MediaCryptoException {
        return new com.google.android.exoplayer2.drm.FrameworkMediaCrypto(i(this.a), bArr, com.google.android.exoplayer2.util.Util.SDK_INT < 21 && com.google.android.exoplayer2.C.WIDEVINE_UUID.equals(this.a) && "L3".equals(getPropertyString("securityLevel")));
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public java.lang.Class<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> getExoMediaCryptoType() {
        return com.google.android.exoplayer2.drm.FrameworkMediaCrypto.class;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest getKeyRequest(byte[] bArr, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list, int i, @androidx.annotation.Nullable java.util.HashMap<java.lang.String, java.lang.String> hashMap) throws android.media.NotProvisionedException {
        com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData;
        byte[] bArr2;
        java.lang.String str;
        if (list != null) {
            schemeData = k(this.a, list);
            bArr2 = g(this.a, (byte[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(schemeData.data));
            str = h(this.a, schemeData.mimeType);
        } else {
            schemeData = null;
            bArr2 = null;
            str = null;
        }
        android.media.MediaDrm.KeyRequest keyRequest = this.b.getKeyRequest(bArr, bArr2, str, i, hashMap);
        byte[] f = f(this.a, keyRequest.getData());
        java.lang.String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (android.text.TextUtils.isEmpty(defaultUrl) && schemeData != null && !android.text.TextUtils.isEmpty(schemeData.licenseServerUrl)) {
            defaultUrl = schemeData.licenseServerUrl;
        }
        return new com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest(f, defaultUrl);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @androidx.annotation.Nullable
    public android.os.PersistableBundle getMetrics() {
        android.os.PersistableBundle metrics;
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 28) {
            return null;
        }
        metrics = this.b.getMetrics();
        return metrics;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] getPropertyByteArray(java.lang.String str) {
        return this.b.getPropertyByteArray(str);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public java.lang.String getPropertyString(java.lang.String str) {
        return this.b.getPropertyString(str);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest getProvisionRequest() {
        android.media.MediaDrm.ProvisionRequest provisionRequest = this.b.getProvisionRequest();
        return new com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] openSession() throws android.media.MediaDrmException {
        return this.b.openSession();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @androidx.annotation.Nullable
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws android.media.NotProvisionedException, android.media.DeniedByServerException {
        if (com.google.android.exoplayer2.C.CLEARKEY_UUID.equals(this.a)) {
            bArr2 = com.google.android.exoplayer2.drm.ClearKeyUtil.b(bArr2);
        }
        return this.b.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void provideProvisionResponse(byte[] bArr) throws android.media.DeniedByServerException {
        this.b.provideProvisionResponse(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public java.util.Map<java.lang.String, java.lang.String> queryKeyStatus(byte[] bArr) {
        return this.b.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public synchronized void release() {
        int i = this.c - 1;
        this.c = i;
        if (i == 0) {
            this.b.release();
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.b.restoreKeys(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnEventListener(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener onEventListener) {
        this.b.setOnEventListener(onEventListener == null ? null : new defpackage.qi0(this, onEventListener));
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @androidx.annotation.RequiresApi(23)
    public void setOnExpirationUpdateListener(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 23) {
            throw new java.lang.UnsupportedOperationException();
        }
        this.b.setOnExpirationUpdateListener(onExpirationUpdateListener == null ? null : new defpackage.pi0(this, onExpirationUpdateListener), (android.os.Handler) null);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @androidx.annotation.RequiresApi(23)
    public void setOnKeyStatusChangeListener(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 23) {
            throw new java.lang.UnsupportedOperationException();
        }
        this.b.setOnKeyStatusChangeListener(onKeyStatusChangeListener == null ? null : new defpackage.si0(this, onKeyStatusChangeListener), (android.os.Handler) null);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyByteArray(java.lang.String str, byte[] bArr) {
        this.b.setPropertyByteArray(str, bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyString(java.lang.String str, java.lang.String str2) {
        this.b.setPropertyString(str, str2);
    }
}
