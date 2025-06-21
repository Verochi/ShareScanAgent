package com.commonsware.cwac.netsecurity.config;

/* loaded from: classes22.dex */
public final class Pin {
    public final byte[] digest;
    public final java.lang.String digestAlgorithm;
    private final int mHashCode;

    public Pin(java.lang.String str, byte[] bArr) {
        this.digestAlgorithm = str;
        this.digest = bArr;
        this.mHashCode = str.hashCode() ^ java.util.Arrays.hashCode(bArr);
    }

    public static int getDigestLength(java.lang.String str) {
        if ("SHA-256".equalsIgnoreCase(str)) {
            return 32;
        }
        throw new java.lang.IllegalArgumentException("Unsupported digest algorithm: " + str);
    }

    public static boolean isSupportedDigestAlgorithm(java.lang.String str) {
        return "SHA-256".equalsIgnoreCase(str);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.commonsware.cwac.netsecurity.config.Pin)) {
            return false;
        }
        com.commonsware.cwac.netsecurity.config.Pin pin = (com.commonsware.cwac.netsecurity.config.Pin) obj;
        return pin.hashCode() == this.mHashCode && java.util.Arrays.equals(this.digest, pin.digest) && this.digestAlgorithm.equals(pin.digestAlgorithm);
    }

    public int hashCode() {
        return this.mHashCode;
    }
}
