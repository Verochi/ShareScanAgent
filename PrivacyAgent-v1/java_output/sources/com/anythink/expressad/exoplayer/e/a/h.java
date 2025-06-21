package com.anythink.expressad.exoplayer.e.a;

/* loaded from: classes12.dex */
public final class h {
    private static final java.lang.String a = "PsshAtomUtil";

    public static class a {
        private final java.util.UUID a;
        private final int b;
        private final byte[] c;

        public a(java.util.UUID uuid, int i, byte[] bArr) {
            this.a = uuid;
            this.b = i;
            this.c = bArr;
        }
    }

    private h() {
    }

    @androidx.annotation.Nullable
    public static java.util.UUID a(byte[] bArr) {
        com.anythink.expressad.exoplayer.e.a.h.a c = c(bArr);
        if (c == null) {
            return null;
        }
        return c.a;
    }

    private static byte[] a(java.util.UUID uuid, @androidx.annotation.Nullable byte[] bArr) {
        int length = bArr != null ? bArr.length : 0;
        int i = length + 32;
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(i);
        allocate.putInt(i);
        allocate.putInt(com.anythink.expressad.exoplayer.e.a.a.Z);
        allocate.putInt(0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    private static byte[] a(java.util.UUID uuid, @androidx.annotation.Nullable java.util.UUID[] uuidArr, @androidx.annotation.Nullable byte[] bArr) {
        boolean z = uuidArr != null;
        int length = bArr != null ? bArr.length : 0;
        int i = length + 32;
        if (z) {
            i += (uuidArr.length * 16) + 4;
        }
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(i);
        allocate.putInt(i);
        allocate.putInt(com.anythink.expressad.exoplayer.e.a.a.Z);
        allocate.putInt(z ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (z) {
            allocate.putInt(uuidArr.length);
            for (java.util.UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    @androidx.annotation.Nullable
    public static byte[] a(byte[] bArr, java.util.UUID uuid) {
        com.anythink.expressad.exoplayer.e.a.h.a c = c(bArr);
        if (c == null) {
            return null;
        }
        if (uuid == null || uuid.equals(c.a)) {
            return c.c;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("UUID mismatch. Expected: ");
        sb.append(uuid);
        sb.append(", got: ");
        sb.append(c.a);
        sb.append(".");
        return null;
    }

    public static int b(byte[] bArr) {
        com.anythink.expressad.exoplayer.e.a.h.a c = c(bArr);
        if (c == null) {
            return -1;
        }
        return c.b;
    }

    @androidx.annotation.Nullable
    private static com.anythink.expressad.exoplayer.e.a.h.a c(byte[] bArr) {
        com.anythink.expressad.exoplayer.k.s sVar = new com.anythink.expressad.exoplayer.k.s(bArr);
        if (sVar.b() < 32) {
            return null;
        }
        sVar.c(0);
        if (sVar.i() != sVar.a() + 4 || sVar.i() != com.anythink.expressad.exoplayer.e.a.a.Z) {
            return null;
        }
        int a2 = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
        if (a2 > 1) {
            "Unsupported pssh version: ".concat(java.lang.String.valueOf(a2));
            return null;
        }
        java.util.UUID uuid = new java.util.UUID(sVar.j(), sVar.j());
        if (a2 == 1) {
            sVar.d(sVar.m() * 16);
        }
        int m = sVar.m();
        if (m != sVar.a()) {
            return null;
        }
        byte[] bArr2 = new byte[m];
        sVar.a(bArr2, 0, m);
        return new com.anythink.expressad.exoplayer.e.a.h.a(uuid, a2, bArr2);
    }
}
