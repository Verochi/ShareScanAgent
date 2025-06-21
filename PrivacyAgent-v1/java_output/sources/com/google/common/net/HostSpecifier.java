package com.google.common.net;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class HostSpecifier {
    public final java.lang.String a;

    public HostSpecifier(java.lang.String str) {
        this.a = str;
    }

    public static com.google.common.net.HostSpecifier from(java.lang.String str) throws java.text.ParseException {
        try {
            return fromValid(str);
        } catch (java.lang.IllegalArgumentException e) {
            java.text.ParseException parseException = new java.text.ParseException("Invalid host specifier: " + str, 0);
            parseException.initCause(e);
            throw parseException;
        }
    }

    public static com.google.common.net.HostSpecifier fromValid(java.lang.String str) {
        java.net.InetAddress inetAddress;
        com.google.common.net.HostAndPort fromString = com.google.common.net.HostAndPort.fromString(str);
        com.google.common.base.Preconditions.checkArgument(!fromString.hasPort());
        java.lang.String host = fromString.getHost();
        try {
            inetAddress = com.google.common.net.InetAddresses.forString(host);
        } catch (java.lang.IllegalArgumentException unused) {
            inetAddress = null;
        }
        if (inetAddress != null) {
            return new com.google.common.net.HostSpecifier(com.google.common.net.InetAddresses.toUriString(inetAddress));
        }
        com.google.common.net.InternetDomainName from = com.google.common.net.InternetDomainName.from(host);
        if (from.hasPublicSuffix()) {
            return new com.google.common.net.HostSpecifier(from.toString());
        }
        throw new java.lang.IllegalArgumentException("Domain name does not have a recognized public suffix: " + host);
    }

    public static boolean isValid(java.lang.String str) {
        try {
            fromValid(str);
            return true;
        } catch (java.lang.IllegalArgumentException unused) {
            return false;
        }
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof com.google.common.net.HostSpecifier) {
            return this.a.equals(((com.google.common.net.HostSpecifier) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public java.lang.String toString() {
        return this.a;
    }
}
