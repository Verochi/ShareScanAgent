package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes22.dex */
public final class PsshAtomUtil {

    public static class PsshAtom {
        public final java.util.UUID a;
        public final int b;
        public final byte[] c;

        public PsshAtom(java.util.UUID uuid, int i, byte[] bArr) {
            this.a = uuid;
            this.b = i;
            this.c = bArr;
        }
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.PsshAtom a(byte[] bArr) {
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(bArr);
        if (parsableByteArray.limit() < 32) {
            return null;
        }
        parsableByteArray.setPosition(0);
        if (parsableByteArray.readInt() != parsableByteArray.bytesLeft() + 4 || parsableByteArray.readInt() != 1886614376) {
            return null;
        }
        int c = com.google.android.exoplayer2.extractor.mp4.Atom.c(parsableByteArray.readInt());
        if (c > 1) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(37);
            sb.append("Unsupported pssh version: ");
            sb.append(c);
            com.google.android.exoplayer2.util.Log.w("PsshAtomUtil", sb.toString());
            return null;
        }
        java.util.UUID uuid = new java.util.UUID(parsableByteArray.readLong(), parsableByteArray.readLong());
        if (c == 1) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedIntToInt() * 16);
        }
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt != parsableByteArray.bytesLeft()) {
            return null;
        }
        byte[] bArr2 = new byte[readUnsignedIntToInt];
        parsableByteArray.readBytes(bArr2, 0, readUnsignedIntToInt);
        return new com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.PsshAtom(uuid, c, bArr2);
    }

    public static byte[] buildPsshAtom(java.util.UUID uuid, @androidx.annotation.Nullable byte[] bArr) {
        return buildPsshAtom(uuid, null, bArr);
    }

    public static byte[] buildPsshAtom(java.util.UUID uuid, @androidx.annotation.Nullable java.util.UUID[] uuidArr, @androidx.annotation.Nullable byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1886614376);
        allocate.putInt(uuidArr != null ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (java.util.UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && bArr.length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static boolean isPsshAtom(byte[] bArr) {
        return a(bArr) != null;
    }

    @androidx.annotation.Nullable
    public static byte[] parseSchemeSpecificData(byte[] bArr, java.util.UUID uuid) {
        com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.PsshAtom a = a(bArr);
        if (a == null) {
            return null;
        }
        if (uuid == null || uuid.equals(a.a)) {
            return a.c;
        }
        java.lang.String valueOf = java.lang.String.valueOf(uuid);
        java.lang.String valueOf2 = java.lang.String.valueOf(a.a);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 33 + valueOf2.length());
        sb.append("UUID mismatch. Expected: ");
        sb.append(valueOf);
        sb.append(", got: ");
        sb.append(valueOf2);
        sb.append(".");
        com.google.android.exoplayer2.util.Log.w("PsshAtomUtil", sb.toString());
        return null;
    }

    @androidx.annotation.Nullable
    public static java.util.UUID parseUuid(byte[] bArr) {
        com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.PsshAtom a = a(bArr);
        if (a == null) {
            return null;
        }
        return a.a;
    }

    public static int parseVersion(byte[] bArr) {
        com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.PsshAtom a = a(bArr);
        if (a == null) {
            return -1;
        }
        return a.b;
    }
}
