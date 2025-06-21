package com.google.common.net;

@com.google.errorprone.annotations.Immutable
@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class HostAndPort implements java.io.Serializable {
    private static final int NO_PORT = -1;
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final java.lang.String host;
    private final int port;

    private HostAndPort(java.lang.String str, int i, boolean z) {
        this.host = str;
        this.port = i;
        this.hasBracketlessColons = z;
    }

    public static com.google.common.net.HostAndPort fromHost(java.lang.String str) {
        com.google.common.net.HostAndPort fromString = fromString(str);
        com.google.common.base.Preconditions.checkArgument(!fromString.hasPort(), "Host has a port: %s", str);
        return fromString;
    }

    public static com.google.common.net.HostAndPort fromParts(java.lang.String str, int i) {
        com.google.common.base.Preconditions.checkArgument(isValidPort(i), "Port out of range: %s", i);
        com.google.common.net.HostAndPort fromString = fromString(str);
        com.google.common.base.Preconditions.checkArgument(!fromString.hasPort(), "Host has a port: %s", str);
        return new com.google.common.net.HostAndPort(fromString.host, i, fromString.hasBracketlessColons);
    }

    public static com.google.common.net.HostAndPort fromString(java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        com.google.common.base.Preconditions.checkNotNull(str);
        int i = -1;
        if (str.startsWith("[")) {
            java.lang.String[] hostAndPortFromBracketedHost = getHostAndPortFromBracketedHost(str);
            str3 = hostAndPortFromBracketedHost[0];
            str2 = hostAndPortFromBracketedHost[1];
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf >= 0) {
                int i2 = indexOf + 1;
                if (str.indexOf(58, i2) == -1) {
                    str3 = str.substring(0, indexOf);
                    str2 = str.substring(i2);
                }
            }
            r3 = indexOf >= 0;
            str2 = null;
            str3 = str;
        }
        if (!com.google.common.base.Strings.isNullOrEmpty(str2)) {
            com.google.common.base.Preconditions.checkArgument(!str2.startsWith("+"), "Unparseable port number: %s", str);
            try {
                i = java.lang.Integer.parseInt(str2);
                com.google.common.base.Preconditions.checkArgument(isValidPort(i), "Port number out of range: %s", str);
            } catch (java.lang.NumberFormatException unused) {
                throw new java.lang.IllegalArgumentException("Unparseable port number: " + str);
            }
        }
        return new com.google.common.net.HostAndPort(str3, i, r3);
    }

    private static java.lang.String[] getHostAndPortFromBracketedHost(java.lang.String str) {
        com.google.common.base.Preconditions.checkArgument(str.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", str);
        int indexOf = str.indexOf(58);
        int lastIndexOf = str.lastIndexOf(93);
        com.google.common.base.Preconditions.checkArgument(indexOf > -1 && lastIndexOf > indexOf, "Invalid bracketed host/port: %s", str);
        java.lang.String substring = str.substring(1, lastIndexOf);
        int i = lastIndexOf + 1;
        if (i == str.length()) {
            return new java.lang.String[]{substring, ""};
        }
        com.google.common.base.Preconditions.checkArgument(str.charAt(i) == ':', "Only a colon may follow a close bracket: %s", str);
        int i2 = lastIndexOf + 2;
        for (int i3 = i2; i3 < str.length(); i3++) {
            com.google.common.base.Preconditions.checkArgument(java.lang.Character.isDigit(str.charAt(i3)), "Port must be numeric: %s", str);
        }
        return new java.lang.String[]{substring, str.substring(i2)};
    }

    private static boolean isValidPort(int i) {
        return i >= 0 && i <= 65535;
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.common.net.HostAndPort)) {
            return false;
        }
        com.google.common.net.HostAndPort hostAndPort = (com.google.common.net.HostAndPort) obj;
        return com.google.common.base.Objects.equal(this.host, hostAndPort.host) && this.port == hostAndPort.port;
    }

    public java.lang.String getHost() {
        return this.host;
    }

    public int getPort() {
        com.google.common.base.Preconditions.checkState(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int i) {
        return hasPort() ? this.port : i;
    }

    public boolean hasPort() {
        return this.port >= 0;
    }

    public int hashCode() {
        return com.google.common.base.Objects.hashCode(this.host, java.lang.Integer.valueOf(this.port));
    }

    public com.google.common.net.HostAndPort requireBracketsForIPv6() {
        com.google.common.base.Preconditions.checkArgument(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) >= 0) {
            sb.append('[');
            sb.append(this.host);
            sb.append(']');
        } else {
            sb.append(this.host);
        }
        if (hasPort()) {
            sb.append(':');
            sb.append(this.port);
        }
        return sb.toString();
    }

    public com.google.common.net.HostAndPort withDefaultPort(int i) {
        com.google.common.base.Preconditions.checkArgument(isValidPort(i));
        return hasPort() ? this : new com.google.common.net.HostAndPort(this.host, i, this.hasBracketlessColons);
    }
}
