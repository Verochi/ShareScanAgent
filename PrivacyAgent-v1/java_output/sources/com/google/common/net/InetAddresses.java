package com.google.common.net;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class InetAddresses {
    public static final com.google.common.base.Splitter a = com.google.common.base.Splitter.on('.').limit(4);
    public static final com.google.common.base.Splitter b = com.google.common.base.Splitter.on(':').limit(10);
    public static final java.net.Inet4Address c = (java.net.Inet4Address) forString("127.0.0.1");
    public static final java.net.Inet4Address d = (java.net.Inet4Address) forString("0.0.0.0");

    @com.google.common.annotations.Beta
    public static final class TeredoInfo {
        public final java.net.Inet4Address a;
        public final java.net.Inet4Address b;
        public final int c;
        public final int d;

        public TeredoInfo(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.net.Inet4Address inet4Address, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.net.Inet4Address inet4Address2, int i, int i2) {
            com.google.common.base.Preconditions.checkArgument(i >= 0 && i <= 65535, "port '%s' is out of range (0 <= port <= 0xffff)", i);
            com.google.common.base.Preconditions.checkArgument(i2 >= 0 && i2 <= 65535, "flags '%s' is out of range (0 <= flags <= 0xffff)", i2);
            this.a = (java.net.Inet4Address) com.google.common.base.MoreObjects.firstNonNull(inet4Address, com.google.common.net.InetAddresses.d);
            this.b = (java.net.Inet4Address) com.google.common.base.MoreObjects.firstNonNull(inet4Address2, com.google.common.net.InetAddresses.d);
            this.c = i;
            this.d = i2;
        }

        public java.net.Inet4Address getClient() {
            return this.b;
        }

        public int getFlags() {
            return this.d;
        }

        public int getPort() {
            return this.c;
        }

        public java.net.Inet4Address getServer() {
            return this.a;
        }
    }

    public static java.net.InetAddress b(byte[] bArr) {
        try {
            return java.net.InetAddress.getByAddress(bArr);
        } catch (java.net.UnknownHostException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public static void c(int[] iArr) {
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < iArr.length + 1; i4++) {
            if (i4 >= iArr.length || iArr[i4] != 0) {
                if (i3 >= 0) {
                    int i5 = i4 - i3;
                    if (i5 > i) {
                        i2 = i3;
                        i = i5;
                    }
                    i3 = -1;
                }
            } else if (i3 < 0) {
                i3 = i4;
            }
        }
        if (i >= 2) {
            java.util.Arrays.fill(iArr, i2, i + i2, -1);
        }
    }

    public static int coerceToInteger(java.net.InetAddress inetAddress) {
        return com.google.common.io.ByteStreams.newDataInput(getCoercedIPv4Address(inetAddress).getAddress()).readInt();
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static java.lang.String d(java.lang.String str) {
        int lastIndexOf = str.lastIndexOf(58) + 1;
        java.lang.String substring = str.substring(0, lastIndexOf);
        byte[] l = l(str.substring(lastIndexOf));
        if (l == null) {
            return null;
        }
        return substring + java.lang.Integer.toHexString(((l[0] & 255) << 8) | (l[1] & 255)) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + java.lang.Integer.toHexString((l[3] & 255) | ((l[2] & 255) << 8));
    }

    public static java.net.InetAddress decrement(java.net.InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (length >= 0 && address[length] == 0) {
            address[length] = -1;
            length--;
        }
        com.google.common.base.Preconditions.checkArgument(length >= 0, "Decrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] - 1);
        return b(address);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static java.net.InetAddress e(java.lang.String str) {
        int i;
        com.google.common.base.Preconditions.checkNotNull(str);
        if (str.startsWith("[") && str.endsWith("]")) {
            str = str.substring(1, str.length() - 1);
            i = 16;
        } else {
            i = 4;
        }
        byte[] i2 = i(str);
        if (i2 == null || i2.length != i) {
            return null;
        }
        return b(i2);
    }

    public static java.lang.IllegalArgumentException f(java.lang.String str, java.lang.Object... objArr) {
        return new java.lang.IllegalArgumentException(java.lang.String.format(java.util.Locale.ROOT, str, objArr));
    }

    public static java.net.InetAddress forString(java.lang.String str) {
        byte[] i = i(str);
        if (i != null) {
            return b(i);
        }
        throw f("'%s' is not an IP string literal.", str);
    }

    public static java.net.InetAddress forUriString(java.lang.String str) {
        java.net.InetAddress e = e(str);
        if (e != null) {
            return e;
        }
        throw f("Not a valid URI IP literal: '%s'", str);
    }

    public static java.net.Inet4Address fromInteger(int i) {
        return g(com.google.common.primitives.Ints.toByteArray(i));
    }

    public static java.net.InetAddress fromLittleEndianByteArray(byte[] bArr) throws java.net.UnknownHostException {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[(bArr.length - i) - 1];
        }
        return java.net.InetAddress.getByAddress(bArr2);
    }

    public static java.net.Inet4Address g(byte[] bArr) {
        com.google.common.base.Preconditions.checkArgument(bArr.length == 4, "Byte array has invalid length for an IPv4 address: %s != 4.", bArr.length);
        return (java.net.Inet4Address) b(bArr);
    }

    public static java.net.Inet4Address get6to4IPv4Address(java.net.Inet6Address inet6Address) {
        com.google.common.base.Preconditions.checkArgument(is6to4Address(inet6Address), "Address '%s' is not a 6to4 address.", toAddrString(inet6Address));
        return g(java.util.Arrays.copyOfRange(inet6Address.getAddress(), 2, 6));
    }

    public static java.net.Inet4Address getCoercedIPv4Address(java.net.InetAddress inetAddress) {
        boolean z;
        if (inetAddress instanceof java.net.Inet4Address) {
            return (java.net.Inet4Address) inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i = 0;
        while (true) {
            if (i >= 15) {
                z = true;
                break;
            }
            if (address[i] != 0) {
                z = false;
                break;
            }
            i++;
        }
        if (z && address[15] == 1) {
            return c;
        }
        if (z && address[15] == 0) {
            return d;
        }
        java.net.Inet6Address inet6Address = (java.net.Inet6Address) inetAddress;
        int asInt = com.google.common.hash.Hashing.murmur3_32().hashLong(hasEmbeddedIPv4ClientAddress(inet6Address) ? getEmbeddedIPv4ClientAddress(inet6Address).hashCode() : java.nio.ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong()).asInt() | (-536870912);
        if (asInt == -1) {
            asInt = -2;
        }
        return g(com.google.common.primitives.Ints.toByteArray(asInt));
    }

    public static java.net.Inet4Address getCompatIPv4Address(java.net.Inet6Address inet6Address) {
        com.google.common.base.Preconditions.checkArgument(isCompatIPv4Address(inet6Address), "Address '%s' is not IPv4-compatible.", toAddrString(inet6Address));
        return g(java.util.Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static java.net.Inet4Address getEmbeddedIPv4ClientAddress(java.net.Inet6Address inet6Address) {
        if (isCompatIPv4Address(inet6Address)) {
            return getCompatIPv4Address(inet6Address);
        }
        if (is6to4Address(inet6Address)) {
            return get6to4IPv4Address(inet6Address);
        }
        if (isTeredoAddress(inet6Address)) {
            return getTeredoInfo(inet6Address).getClient();
        }
        throw f("'%s' has no embedded IPv4 address.", toAddrString(inet6Address));
    }

    public static java.net.Inet4Address getIsatapIPv4Address(java.net.Inet6Address inet6Address) {
        com.google.common.base.Preconditions.checkArgument(isIsatapAddress(inet6Address), "Address '%s' is not an ISATAP address.", toAddrString(inet6Address));
        return g(java.util.Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static com.google.common.net.InetAddresses.TeredoInfo getTeredoInfo(java.net.Inet6Address inet6Address) {
        com.google.common.base.Preconditions.checkArgument(isTeredoAddress(inet6Address), "Address '%s' is not a Teredo address.", toAddrString(inet6Address));
        byte[] address = inet6Address.getAddress();
        java.net.Inet4Address g = g(java.util.Arrays.copyOfRange(address, 4, 8));
        int readShort = com.google.common.io.ByteStreams.newDataInput(address, 8).readShort() & kotlin.UShort.MAX_VALUE;
        int i = 65535 & (~com.google.common.io.ByteStreams.newDataInput(address, 10).readShort());
        byte[] copyOfRange = java.util.Arrays.copyOfRange(address, 12, 16);
        for (int i2 = 0; i2 < copyOfRange.length; i2++) {
            copyOfRange[i2] = (byte) (~copyOfRange[i2]);
        }
        return new com.google.common.net.InetAddresses.TeredoInfo(g, g(copyOfRange), i, readShort);
    }

    public static java.lang.String h(int[] iArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(39);
        int i = 0;
        boolean z = false;
        while (i < iArr.length) {
            boolean z2 = iArr[i] >= 0;
            if (z2) {
                if (z) {
                    sb.append(':');
                }
                sb.append(java.lang.Integer.toHexString(iArr[i]));
            } else if (i == 0 || z) {
                sb.append("::");
            }
            i++;
            z = z2;
        }
        return sb.toString();
    }

    public static boolean hasEmbeddedIPv4ClientAddress(java.net.Inet6Address inet6Address) {
        return isCompatIPv4Address(inet6Address) || is6to4Address(inet6Address) || isTeredoAddress(inet6Address);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static byte[] i(java.lang.String str) {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '.') {
                z2 = true;
            } else if (charAt == ':') {
                if (z2) {
                    return null;
                }
                z = true;
            } else if (java.lang.Character.digit(charAt, 16) == -1) {
                return null;
            }
        }
        if (!z) {
            if (z2) {
                return l(str);
            }
            return null;
        }
        if (z2 && (str = d(str)) == null) {
            return null;
        }
        return m(str);
    }

    public static java.net.InetAddress increment(java.net.InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (true) {
            if (length < 0 || address[length] != -1) {
                break;
            }
            address[length] = 0;
            length--;
        }
        com.google.common.base.Preconditions.checkArgument(length >= 0, "Incrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] + 1);
        return b(address);
    }

    public static boolean is6to4Address(java.net.Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        return address[0] == 32 && address[1] == 2;
    }

    public static boolean isCompatIPv4Address(java.net.Inet6Address inet6Address) {
        byte b2;
        if (!inet6Address.isIPv4CompatibleAddress()) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        return (address[12] == 0 && address[13] == 0 && address[14] == 0 && ((b2 = address[15]) == 0 || b2 == 1)) ? false : true;
    }

    public static boolean isInetAddress(java.lang.String str) {
        return i(str) != null;
    }

    public static boolean isIsatapAddress(java.net.Inet6Address inet6Address) {
        if (isTeredoAddress(inet6Address)) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        return (address[8] | 3) == 3 && address[9] == 0 && address[10] == 94 && address[11] == -2;
    }

    public static boolean isMappedIPv4Address(java.lang.String str) {
        byte[] i = i(str);
        if (i == null || i.length != 16) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= 10) {
                for (int i3 = 10; i3 < 12; i3++) {
                    if (i[i3] != -1) {
                        return false;
                    }
                }
                return true;
            }
            if (i[i2] != 0) {
                return false;
            }
            i2++;
        }
    }

    public static boolean isMaximum(java.net.InetAddress inetAddress) {
        for (byte b2 : inetAddress.getAddress()) {
            if (b2 != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTeredoAddress(java.net.Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        return address[0] == 32 && address[1] == 1 && address[2] == 0 && address[3] == 0;
    }

    public static boolean isUriInetAddress(java.lang.String str) {
        return e(str) != null;
    }

    public static short j(java.lang.String str) {
        int parseInt = java.lang.Integer.parseInt(str, 16);
        if (parseInt <= 65535) {
            return (short) parseInt;
        }
        throw new java.lang.NumberFormatException();
    }

    public static byte k(java.lang.String str) {
        int parseInt = java.lang.Integer.parseInt(str);
        if (parseInt > 255 || (str.startsWith("0") && str.length() > 1)) {
            throw new java.lang.NumberFormatException();
        }
        return (byte) parseInt;
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static byte[] l(java.lang.String str) {
        byte[] bArr = new byte[4];
        try {
            java.util.Iterator<java.lang.String> it = a.split(str).iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2 = i + 1;
                bArr[i] = k(it.next());
                i = i2;
            }
            if (i == 4) {
                return bArr;
            }
            return null;
        } catch (java.lang.NumberFormatException unused) {
            return null;
        }
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static byte[] m(java.lang.String str) {
        int size;
        int i;
        java.util.List<java.lang.String> splitToList = b.splitToList(str);
        if (splitToList.size() < 3 || splitToList.size() > 9) {
            return null;
        }
        int i2 = -1;
        for (int i3 = 1; i3 < splitToList.size() - 1; i3++) {
            if (splitToList.get(i3).length() == 0) {
                if (i2 >= 0) {
                    return null;
                }
                i2 = i3;
            }
        }
        if (i2 >= 0) {
            i = (splitToList.size() - i2) - 1;
            if (splitToList.get(0).length() == 0) {
                size = i2 - 1;
                if (size != 0) {
                    return null;
                }
            } else {
                size = i2;
            }
            if (((java.lang.String) com.google.common.collect.Iterables.getLast(splitToList)).length() == 0 && i - 1 != 0) {
                return null;
            }
        } else {
            size = splitToList.size();
            i = 0;
        }
        int i4 = 8 - (size + i);
        if (i2 < 0 ? i4 != 0 : i4 < 1) {
            return null;
        }
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(16);
        for (int i5 = 0; i5 < size; i5++) {
            try {
                allocate.putShort(j(splitToList.get(i5)));
            } catch (java.lang.NumberFormatException unused) {
                return null;
            }
        }
        for (int i6 = 0; i6 < i4; i6++) {
            allocate.putShort((short) 0);
        }
        while (i > 0) {
            allocate.putShort(j(splitToList.get(splitToList.size() - i)));
            i--;
        }
        return allocate.array();
    }

    public static java.lang.String toAddrString(java.net.InetAddress inetAddress) {
        com.google.common.base.Preconditions.checkNotNull(inetAddress);
        if (inetAddress instanceof java.net.Inet4Address) {
            return inetAddress.getHostAddress();
        }
        com.google.common.base.Preconditions.checkArgument(inetAddress instanceof java.net.Inet6Address);
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            int i2 = i * 2;
            iArr[i] = com.google.common.primitives.Ints.fromBytes((byte) 0, (byte) 0, address[i2], address[i2 + 1]);
        }
        c(iArr);
        return h(iArr);
    }

    public static java.lang.String toUriString(java.net.InetAddress inetAddress) {
        if (!(inetAddress instanceof java.net.Inet6Address)) {
            return toAddrString(inetAddress);
        }
        return "[" + toAddrString(inetAddress) + "]";
    }
}
