package com.commonsware.cwac.netsecurity.conscrypt;

/* loaded from: classes22.dex */
public class PinListEntry {
    private final com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore certStore;

    /* renamed from: cn, reason: collision with root package name */
    private final java.lang.String f303cn;
    private final boolean enforcing;
    private final java.util.Set<java.lang.String> pinnedFingerprints = new java.util.HashSet();

    public PinListEntry(java.lang.String str, com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore trustedCertificateStore) throws com.commonsware.cwac.netsecurity.conscrypt.PinEntryException {
        if (str == null) {
            throw new java.lang.NullPointerException("entry == null");
        }
        this.certStore = trustedCertificateStore;
        java.lang.String[] split = str.split("[=,|]");
        if (split.length < 3) {
            throw new com.commonsware.cwac.netsecurity.conscrypt.PinEntryException("Received malformed pin entry");
        }
        this.f303cn = split[0];
        this.enforcing = enforcementValueFromString(split[1]);
        addPins((java.lang.String[]) java.util.Arrays.copyOfRange(split, 2, split.length));
    }

    private void addPins(java.lang.String[] strArr) {
        for (java.lang.String str : strArr) {
            validatePin(str);
        }
        java.util.Collections.addAll(this.pinnedFingerprints, strArr);
    }

    private boolean chainContainsUserCert(java.util.List<java.security.cert.X509Certificate> list) {
        return false;
    }

    private static boolean enforcementValueFromString(java.lang.String str) throws com.commonsware.cwac.netsecurity.conscrypt.PinEntryException {
        if (str.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE)) {
            return true;
        }
        if (str.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
            return false;
        }
        throw new com.commonsware.cwac.netsecurity.conscrypt.PinEntryException("Enforcement status is not a valid value");
    }

    private static java.lang.String getFingerprint(java.security.cert.X509Certificate x509Certificate) {
        try {
            return com.commonsware.cwac.netsecurity.conscrypt.Hex.bytesToHexString(java.security.MessageDigest.getInstance("SHA512").digest(x509Certificate.getPublicKey().getEncoded()));
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    private void logPinFailure(java.util.List<java.security.cert.X509Certificate> list, boolean z) {
        com.commonsware.cwac.netsecurity.conscrypt.PinFailureLogger.log(this.f303cn, z, this.enforcing, list);
    }

    private static void validatePin(java.lang.String str) {
        if (str.length() != 128) {
            throw new java.lang.IllegalArgumentException("Pin is not a valid length");
        }
        try {
            new java.math.BigInteger(str, 16);
        } catch (java.lang.NumberFormatException e) {
            throw new java.lang.IllegalArgumentException("Pin is not a valid hex string", e);
        }
    }

    public java.lang.String getCommonName() {
        return this.f303cn;
    }

    public boolean getEnforcing() {
        return this.enforcing;
    }

    public boolean isChainValid(java.util.List<java.security.cert.X509Certificate> list) {
        boolean chainContainsUserCert = chainContainsUserCert(list);
        if (!chainContainsUserCert) {
            java.util.Iterator<java.security.cert.X509Certificate> it = list.iterator();
            while (it.hasNext()) {
                if (this.pinnedFingerprints.contains(getFingerprint(it.next()))) {
                    return true;
                }
            }
        }
        logPinFailure(list, chainContainsUserCert);
        return !this.enforcing || chainContainsUserCert;
    }
}
