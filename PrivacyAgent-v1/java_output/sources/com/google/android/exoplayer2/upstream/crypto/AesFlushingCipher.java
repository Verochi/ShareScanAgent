package com.google.android.exoplayer2.upstream.crypto;

/* loaded from: classes22.dex */
public final class AesFlushingCipher {
    public final javax.crypto.Cipher a;
    public final int b;
    public final byte[] c;
    public final byte[] d;
    public int e;

    public AesFlushingCipher(int i, byte[] bArr, long j, long j2) {
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CTR/NoPadding");
            this.a = cipher;
            int blockSize = cipher.getBlockSize();
            this.b = blockSize;
            this.c = new byte[blockSize];
            this.d = new byte[blockSize];
            int i2 = (int) (j2 % blockSize);
            cipher.init(i, new javax.crypto.spec.SecretKeySpec(bArr, com.google.android.exoplayer2.util.Util.splitAtFirst(cipher.getAlgorithm(), net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)[0]), new javax.crypto.spec.IvParameterSpec(a(j, j2 / blockSize)));
            if (i2 != 0) {
                updateInPlace(new byte[i2], 0, i2);
            }
        } catch (java.security.InvalidAlgorithmParameterException | java.security.InvalidKeyException | java.security.NoSuchAlgorithmException | javax.crypto.NoSuchPaddingException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public final byte[] a(long j, long j2) {
        return java.nio.ByteBuffer.allocate(16).putLong(j).putLong(j2).array();
    }

    public final int b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        try {
            return this.a.update(bArr, i, i2, bArr2, i3);
        } catch (javax.crypto.ShortBufferException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public void update(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = i;
        do {
            int i5 = this.e;
            if (i5 <= 0) {
                int b = b(bArr, i4, i2, bArr2, i3);
                if (i2 == b) {
                    return;
                }
                int i6 = i2 - b;
                int i7 = 0;
                com.google.android.exoplayer2.util.Assertions.checkState(i6 < this.b);
                int i8 = i3 + b;
                int i9 = this.b - i6;
                this.e = i9;
                com.google.android.exoplayer2.util.Assertions.checkState(b(this.c, 0, i9, this.d, 0) == this.b);
                while (i7 < i6) {
                    bArr2[i8] = this.d[i7];
                    i7++;
                    i8++;
                }
                return;
            }
            bArr2[i3] = (byte) (bArr[i4] ^ this.d[this.b - i5]);
            i3++;
            i4++;
            this.e = i5 - 1;
            i2--;
        } while (i2 != 0);
    }

    public void updateInPlace(byte[] bArr, int i, int i2) {
        update(bArr, i, i2, bArr, i);
    }
}
