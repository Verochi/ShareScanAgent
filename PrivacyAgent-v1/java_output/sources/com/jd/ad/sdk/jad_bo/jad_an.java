package com.jd.ad.sdk.jad_bo;

/* loaded from: classes23.dex */
public class jad_an {
    public static final byte[] jad_cn;
    public static final byte[] jad_do;
    public static final byte[] jad_ep;
    public static final java.lang.String[] jad_fq;
    public static final int[] jad_gr;
    public static final byte[] jad_hs;
    public static final com.jd.ad.sdk.jad_bo.jad_an.jad_dq jad_it;
    public static final com.jd.ad.sdk.jad_bo.jad_an.jad_dq[][] jad_ju;
    public static final com.jd.ad.sdk.jad_bo.jad_an.jad_dq[] jad_kv;
    public static final java.util.HashMap<java.lang.Integer, com.jd.ad.sdk.jad_bo.jad_an.jad_dq>[] jad_lw;
    public static final java.util.HashMap<java.lang.String, com.jd.ad.sdk.jad_bo.jad_an.jad_dq>[] jad_mx;
    public static final boolean jad_na = android.util.Log.isLoggable("ExifInterface", 3);
    public static final java.util.HashSet<java.lang.String> jad_ny;
    public static final int[] jad_ob;
    public static final java.util.HashMap<java.lang.Integer, java.lang.Integer> jad_oz;
    public static final java.nio.charset.Charset jad_pa;
    public static final int[] jad_pc;
    public static final byte[] jad_qb;
    public static final byte[] jad_qd;
    public static final byte[] jad_rc;
    public static final byte[] jad_re;
    public static final byte[] jad_sf;
    public static final byte[] jad_tg;
    public static final byte[] jad_uh;
    public static final byte[] jad_vi;
    public static final byte[] jad_wj;
    public static final byte[] jad_xk;
    public static final byte[] jad_yl;
    public static final byte[] jad_zm;
    public java.io.FileDescriptor jad_an;
    public android.content.res.AssetManager.AssetInputStream jad_bo;
    public int jad_cp;
    public boolean jad_dq;
    public final java.util.HashMap<java.lang.String, com.jd.ad.sdk.jad_bo.jad_an.jad_cp>[] jad_er;
    public java.util.Set<java.lang.Integer> jad_fs;
    public boolean jad_hu;
    public int jad_iv;
    public java.nio.ByteOrder jad_jt;
    public int jad_jw;
    public int jad_kx;
    public int jad_ly;
    public int jad_mz;

    /* renamed from: com.jd.ad.sdk.jad_bo.jad_an$jad_an, reason: collision with other inner class name */
    public class C0377jad_an extends android.media.MediaDataSource {
        public long jad_an;
        public final /* synthetic */ com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_bo;

        public C0377jad_an(com.jd.ad.sdk.jad_bo.jad_an jad_anVar, com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar) {
            this.jad_bo = jad_boVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j, byte[] bArr, int i, int i2) {
            if (i2 == 0) {
                return 0;
            }
            if (j < 0) {
                return -1;
            }
            try {
                long j2 = this.jad_an;
                if (j2 != j) {
                    if (j2 >= 0 && j >= j2 + this.jad_bo.jad_an.available()) {
                        return -1;
                    }
                    this.jad_bo.jad_bo(j);
                    this.jad_an = j;
                }
                if (i2 > this.jad_bo.jad_an.available()) {
                    i2 = this.jad_bo.jad_an.available();
                }
                com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar = this.jad_bo;
                int read = jad_boVar.jad_an.read(bArr, i, i2);
                jad_boVar.jad_dq += read;
                if (read >= 0) {
                    this.jad_an += read;
                    return read;
                }
            } catch (java.io.IOException unused) {
            }
            this.jad_an = -1L;
            return -1;
        }
    }

    public static class jad_bo extends java.io.InputStream implements java.io.DataInput {
        public static final java.nio.ByteOrder jad_er = java.nio.ByteOrder.LITTLE_ENDIAN;
        public static final java.nio.ByteOrder jad_fs = java.nio.ByteOrder.BIG_ENDIAN;
        public java.io.DataInputStream jad_an;
        public java.nio.ByteOrder jad_bo;
        public final int jad_cp;
        public int jad_dq;

        public jad_bo(java.io.InputStream inputStream) {
            this(inputStream, java.nio.ByteOrder.BIG_ENDIAN);
        }

        public jad_bo(java.io.InputStream inputStream, java.nio.ByteOrder byteOrder) {
            this.jad_bo = java.nio.ByteOrder.BIG_ENDIAN;
            java.io.DataInputStream dataInputStream = new java.io.DataInputStream(inputStream);
            this.jad_an = dataInputStream;
            int available = dataInputStream.available();
            this.jad_cp = available;
            this.jad_dq = 0;
            this.jad_an.mark(available);
            this.jad_bo = byteOrder;
        }

        public jad_bo(byte[] bArr) {
            this(new java.io.ByteArrayInputStream(bArr));
        }

        @Override // java.io.InputStream
        public int available() {
            return this.jad_an.available();
        }

        public long jad_bo() {
            return readInt() & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
        }

        public void jad_bo(long j) {
            long j2 = this.jad_dq;
            if (j2 > j) {
                this.jad_dq = 0;
                this.jad_an.reset();
                this.jad_an.mark(this.jad_cp);
            } else {
                j -= j2;
            }
            int i = (int) j;
            if (skipBytes(i) != i) {
                throw new java.io.IOException("Couldn't seek up to the byteCount");
            }
        }

        @Override // java.io.InputStream
        public int read() {
            this.jad_dq++;
            return this.jad_an.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read = this.jad_an.read(bArr, i, i2);
            this.jad_dq += read;
            return read;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.jad_dq++;
            return this.jad_an.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() {
            int i = this.jad_dq + 1;
            this.jad_dq = i;
            if (i > this.jad_cp) {
                throw new java.io.EOFException();
            }
            int read = this.jad_an.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new java.io.EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.jad_dq += 2;
            return this.jad_an.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return java.lang.Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return java.lang.Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) {
            int length = this.jad_dq + bArr.length;
            this.jad_dq = length;
            if (length > this.jad_cp) {
                throw new java.io.EOFException();
            }
            if (this.jad_an.read(bArr, 0, bArr.length) != bArr.length) {
                throw new java.io.IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) {
            int i3 = this.jad_dq + i2;
            this.jad_dq = i3;
            if (i3 > this.jad_cp) {
                throw new java.io.EOFException();
            }
            if (this.jad_an.read(bArr, i, i2) != i2) {
                throw new java.io.IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public int readInt() {
            int i = this.jad_dq + 4;
            this.jad_dq = i;
            if (i > this.jad_cp) {
                throw new java.io.EOFException();
            }
            int read = this.jad_an.read();
            int read2 = this.jad_an.read();
            int read3 = this.jad_an.read();
            int read4 = this.jad_an.read();
            if ((read | read2 | read3 | read4) < 0) {
                throw new java.io.EOFException();
            }
            java.nio.ByteOrder byteOrder = this.jad_bo;
            if (byteOrder == jad_er) {
                return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == jad_fs) {
                return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
            }
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid byte order: ");
            jad_an.append(this.jad_bo);
            throw new java.io.IOException(jad_an.toString());
        }

        @Override // java.io.DataInput
        public java.lang.String readLine() {
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() {
            int i = this.jad_dq + 8;
            this.jad_dq = i;
            if (i > this.jad_cp) {
                throw new java.io.EOFException();
            }
            int read = this.jad_an.read();
            int read2 = this.jad_an.read();
            int read3 = this.jad_an.read();
            int read4 = this.jad_an.read();
            int read5 = this.jad_an.read();
            int read6 = this.jad_an.read();
            int read7 = this.jad_an.read();
            int read8 = this.jad_an.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
                throw new java.io.EOFException();
            }
            java.nio.ByteOrder byteOrder = this.jad_bo;
            if (byteOrder == jad_er) {
                return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == jad_fs) {
                return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
            }
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid byte order: ");
            jad_an.append(this.jad_bo);
            throw new java.io.IOException(jad_an.toString());
        }

        @Override // java.io.DataInput
        public short readShort() {
            int i = this.jad_dq + 2;
            this.jad_dq = i;
            if (i > this.jad_cp) {
                throw new java.io.EOFException();
            }
            int read = this.jad_an.read();
            int read2 = this.jad_an.read();
            if ((read | read2) < 0) {
                throw new java.io.EOFException();
            }
            java.nio.ByteOrder byteOrder = this.jad_bo;
            if (byteOrder == jad_er) {
                return (short) ((read2 << 8) + read);
            }
            if (byteOrder == jad_fs) {
                return (short) ((read << 8) + read2);
            }
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid byte order: ");
            jad_an.append(this.jad_bo);
            throw new java.io.IOException(jad_an.toString());
        }

        @Override // java.io.DataInput
        public java.lang.String readUTF() {
            this.jad_dq += 2;
            return this.jad_an.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.jad_dq++;
            return this.jad_an.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() {
            int i = this.jad_dq + 2;
            this.jad_dq = i;
            if (i > this.jad_cp) {
                throw new java.io.EOFException();
            }
            int read = this.jad_an.read();
            int read2 = this.jad_an.read();
            if ((read | read2) < 0) {
                throw new java.io.EOFException();
            }
            java.nio.ByteOrder byteOrder = this.jad_bo;
            if (byteOrder == jad_er) {
                return (read2 << 8) + read;
            }
            if (byteOrder == jad_fs) {
                return (read << 8) + read2;
            }
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid byte order: ");
            jad_an.append(this.jad_bo);
            throw new java.io.IOException(jad_an.toString());
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) {
            int min = java.lang.Math.min(i, this.jad_cp - this.jad_dq);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.jad_an.skipBytes(min - i2);
            }
            this.jad_dq += i2;
            return i2;
        }
    }

    public static class jad_cp {
        public final int jad_an;
        public final int jad_bo;
        public final byte[] jad_cp;

        public jad_cp(int i, int i2, long j, byte[] bArr) {
            this.jad_an = i;
            this.jad_bo = i2;
            this.jad_cp = bArr;
        }

        public static com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_an(int i, java.nio.ByteOrder byteOrder) {
            int[] iArr = {i};
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(new byte[com.jd.ad.sdk.jad_bo.jad_an.jad_gr[3] * 1]);
            wrap.order(byteOrder);
            wrap.putShort((short) iArr[0]);
            return new com.jd.ad.sdk.jad_bo.jad_an.jad_cp(3, 1, -1L, wrap.array());
        }

        public static com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_an(long j, java.nio.ByteOrder byteOrder) {
            long[] jArr = {j};
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(new byte[com.jd.ad.sdk.jad_bo.jad_an.jad_gr[4] * 1]);
            wrap.order(byteOrder);
            wrap.putInt((int) jArr[0]);
            return new com.jd.ad.sdk.jad_bo.jad_an.jad_cp(4, 1, -1L, wrap.array());
        }

        public static com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_an(com.jd.ad.sdk.jad_bo.jad_an.jad_er jad_erVar, java.nio.ByteOrder byteOrder) {
            com.jd.ad.sdk.jad_bo.jad_an.jad_er[] jad_erVarArr = {jad_erVar};
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(new byte[com.jd.ad.sdk.jad_bo.jad_an.jad_gr[5] * 1]);
            wrap.order(byteOrder);
            com.jd.ad.sdk.jad_bo.jad_an.jad_er jad_erVar2 = jad_erVarArr[0];
            wrap.putInt((int) jad_erVar2.jad_an);
            wrap.putInt((int) jad_erVar2.jad_bo);
            return new com.jd.ad.sdk.jad_bo.jad_an.jad_cp(5, 1, -1L, wrap.array());
        }

        public static com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_an(java.lang.String str) {
            byte[] bytes = (str + (char) 0).getBytes(com.jd.ad.sdk.jad_bo.jad_an.jad_pa);
            return new com.jd.ad.sdk.jad_bo.jad_an.jad_cp(2, bytes.length, -1L, bytes);
        }

        public double jad_an(java.nio.ByteOrder byteOrder) {
            java.lang.Object jad_dq = jad_dq(byteOrder);
            if (jad_dq == null) {
                throw new java.lang.NumberFormatException("NULL can't be converted to a double value");
            }
            if (jad_dq instanceof java.lang.String) {
                return java.lang.Double.parseDouble((java.lang.String) jad_dq);
            }
            if (jad_dq instanceof long[]) {
                if (((long[]) jad_dq).length == 1) {
                    return r5[0];
                }
                throw new java.lang.NumberFormatException("There are more than one component");
            }
            if (jad_dq instanceof int[]) {
                if (((int[]) jad_dq).length == 1) {
                    return r5[0];
                }
                throw new java.lang.NumberFormatException("There are more than one component");
            }
            if (jad_dq instanceof double[]) {
                double[] dArr = (double[]) jad_dq;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new java.lang.NumberFormatException("There are more than one component");
            }
            if (!(jad_dq instanceof com.jd.ad.sdk.jad_bo.jad_an.jad_er[])) {
                throw new java.lang.NumberFormatException("Couldn't find a double value");
            }
            com.jd.ad.sdk.jad_bo.jad_an.jad_er[] jad_erVarArr = (com.jd.ad.sdk.jad_bo.jad_an.jad_er[]) jad_dq;
            if (jad_erVarArr.length != 1) {
                throw new java.lang.NumberFormatException("There are more than one component");
            }
            com.jd.ad.sdk.jad_bo.jad_an.jad_er jad_erVar = jad_erVarArr[0];
            return jad_erVar.jad_an / jad_erVar.jad_bo;
        }

        public int jad_bo(java.nio.ByteOrder byteOrder) {
            java.lang.Object jad_dq = jad_dq(byteOrder);
            if (jad_dq == null) {
                throw new java.lang.NumberFormatException("NULL can't be converted to a integer value");
            }
            if (jad_dq instanceof java.lang.String) {
                return java.lang.Integer.parseInt((java.lang.String) jad_dq);
            }
            if (jad_dq instanceof long[]) {
                long[] jArr = (long[]) jad_dq;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new java.lang.NumberFormatException("There are more than one component");
            }
            if (!(jad_dq instanceof int[])) {
                throw new java.lang.NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) jad_dq;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new java.lang.NumberFormatException("There are more than one component");
        }

        public java.lang.String jad_cp(java.nio.ByteOrder byteOrder) {
            java.lang.Object jad_dq = jad_dq(byteOrder);
            if (jad_dq == null) {
                return null;
            }
            if (jad_dq instanceof java.lang.String) {
                return (java.lang.String) jad_dq;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i = 0;
            if (jad_dq instanceof long[]) {
                long[] jArr = (long[]) jad_dq;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (jad_dq instanceof int[]) {
                int[] iArr = (int[]) jad_dq;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (jad_dq instanceof double[]) {
                double[] dArr = (double[]) jad_dq;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(jad_dq instanceof com.jd.ad.sdk.jad_bo.jad_an.jad_er[])) {
                return null;
            }
            com.jd.ad.sdk.jad_bo.jad_an.jad_er[] jad_erVarArr = (com.jd.ad.sdk.jad_bo.jad_an.jad_er[]) jad_dq;
            while (i < jad_erVarArr.length) {
                sb.append(jad_erVarArr[i].jad_an);
                sb.append('/');
                sb.append(jad_erVarArr[i].jad_bo);
                i++;
                if (i != jad_erVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        public java.lang.Object jad_dq(java.nio.ByteOrder byteOrder) {
            com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar;
            byte b;
            byte b2;
            byte[] bArr;
            com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar2 = null;
            try {
                jad_boVar = new com.jd.ad.sdk.jad_bo.jad_an.jad_bo(this.jad_cp);
                try {
                    jad_boVar.jad_bo = byteOrder;
                    int i = 0;
                    boolean z = true;
                    switch (this.jad_an) {
                        case 1:
                        case 6:
                            byte[] bArr2 = this.jad_cp;
                            if (bArr2.length != 1 || (b = bArr2[0]) < 0 || b > 1) {
                                java.lang.String str = new java.lang.String(bArr2, com.jd.ad.sdk.jad_bo.jad_an.jad_pa);
                                try {
                                    jad_boVar.close();
                                } catch (java.io.IOException unused) {
                                }
                                return str;
                            }
                            java.lang.String str2 = new java.lang.String(new char[]{(char) (b + org.apache.tools.tar.TarConstants.LF_NORMAL)});
                            try {
                                jad_boVar.close();
                            } catch (java.io.IOException unused2) {
                            }
                            return str2;
                        case 2:
                        case 7:
                            if (this.jad_bo >= com.jd.ad.sdk.jad_bo.jad_an.jad_hs.length) {
                                int i2 = 0;
                                while (true) {
                                    bArr = com.jd.ad.sdk.jad_bo.jad_an.jad_hs;
                                    if (i2 < bArr.length) {
                                        if (this.jad_cp[i2] != bArr[i2]) {
                                            z = false;
                                        } else {
                                            i2++;
                                        }
                                    }
                                }
                                if (z) {
                                    i = bArr.length;
                                }
                            }
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            while (i < this.jad_bo && (b2 = this.jad_cp[i]) != 0) {
                                if (b2 >= 32) {
                                    sb.append((char) b2);
                                } else {
                                    sb.append('?');
                                }
                                i++;
                            }
                            java.lang.String sb2 = sb.toString();
                            try {
                                jad_boVar.close();
                            } catch (java.io.IOException unused3) {
                            }
                            return sb2;
                        case 3:
                            int[] iArr = new int[this.jad_bo];
                            while (i < this.jad_bo) {
                                iArr[i] = jad_boVar.readUnsignedShort();
                                i++;
                            }
                            try {
                                jad_boVar.close();
                            } catch (java.io.IOException unused4) {
                            }
                            return iArr;
                        case 4:
                            long[] jArr = new long[this.jad_bo];
                            while (i < this.jad_bo) {
                                jArr[i] = jad_boVar.jad_bo();
                                i++;
                            }
                            try {
                                jad_boVar.close();
                            } catch (java.io.IOException unused5) {
                            }
                            return jArr;
                        case 5:
                            com.jd.ad.sdk.jad_bo.jad_an.jad_er[] jad_erVarArr = new com.jd.ad.sdk.jad_bo.jad_an.jad_er[this.jad_bo];
                            while (i < this.jad_bo) {
                                jad_erVarArr[i] = new com.jd.ad.sdk.jad_bo.jad_an.jad_er(jad_boVar.jad_bo(), jad_boVar.jad_bo());
                                i++;
                            }
                            try {
                                jad_boVar.close();
                            } catch (java.io.IOException unused6) {
                            }
                            return jad_erVarArr;
                        case 8:
                            int[] iArr2 = new int[this.jad_bo];
                            while (i < this.jad_bo) {
                                iArr2[i] = jad_boVar.readShort();
                                i++;
                            }
                            try {
                                jad_boVar.close();
                            } catch (java.io.IOException unused7) {
                            }
                            return iArr2;
                        case 9:
                            int[] iArr3 = new int[this.jad_bo];
                            while (i < this.jad_bo) {
                                iArr3[i] = jad_boVar.readInt();
                                i++;
                            }
                            try {
                                jad_boVar.close();
                            } catch (java.io.IOException unused8) {
                            }
                            return iArr3;
                        case 10:
                            com.jd.ad.sdk.jad_bo.jad_an.jad_er[] jad_erVarArr2 = new com.jd.ad.sdk.jad_bo.jad_an.jad_er[this.jad_bo];
                            while (i < this.jad_bo) {
                                jad_erVarArr2[i] = new com.jd.ad.sdk.jad_bo.jad_an.jad_er(jad_boVar.readInt(), jad_boVar.readInt());
                                i++;
                            }
                            try {
                                jad_boVar.close();
                            } catch (java.io.IOException unused9) {
                            }
                            return jad_erVarArr2;
                        case 11:
                            double[] dArr = new double[this.jad_bo];
                            while (i < this.jad_bo) {
                                dArr[i] = java.lang.Float.intBitsToFloat(jad_boVar.readInt());
                                i++;
                            }
                            try {
                                jad_boVar.close();
                            } catch (java.io.IOException unused10) {
                            }
                            return dArr;
                        case 12:
                            double[] dArr2 = new double[this.jad_bo];
                            while (i < this.jad_bo) {
                                dArr2[i] = java.lang.Double.longBitsToDouble(jad_boVar.readLong());
                                i++;
                            }
                            try {
                                jad_boVar.close();
                            } catch (java.io.IOException unused11) {
                            }
                            return dArr2;
                        default:
                            try {
                                jad_boVar.close();
                            } catch (java.io.IOException unused12) {
                            }
                            return null;
                    }
                } catch (java.io.IOException unused13) {
                    if (jad_boVar != null) {
                        try {
                            jad_boVar.close();
                        } catch (java.io.IOException unused14) {
                        }
                    }
                    return null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    jad_boVar2 = jad_boVar;
                    if (jad_boVar2 != null) {
                        try {
                            jad_boVar2.close();
                        } catch (java.io.IOException unused15) {
                        }
                    }
                    throw th;
                }
            } catch (java.io.IOException unused16) {
                jad_boVar = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }

        public java.lang.String toString() {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("(");
            jad_an.append(com.jd.ad.sdk.jad_bo.jad_an.jad_fq[this.jad_an]);
            jad_an.append(", data length:");
            jad_an.append(this.jad_cp.length);
            jad_an.append(")");
            return jad_an.toString();
        }
    }

    public static class jad_dq {
        public final int jad_an;
        public final java.lang.String jad_bo;
        public final int jad_cp;
        public final int jad_dq;

        public jad_dq(java.lang.String str, int i, int i2) {
            this.jad_bo = str;
            this.jad_an = i;
            this.jad_cp = i2;
            this.jad_dq = -1;
        }

        public jad_dq(java.lang.String str, int i, int i2, int i3) {
            this.jad_bo = str;
            this.jad_an = i;
            this.jad_cp = i2;
            this.jad_dq = i3;
        }
    }

    public static class jad_er {
        public final long jad_an;
        public final long jad_bo;

        public jad_er(long j, long j2) {
            if (j2 == 0) {
                this.jad_an = 0L;
                this.jad_bo = 1L;
            } else {
                this.jad_an = j;
                this.jad_bo = j2;
            }
        }

        public java.lang.String toString() {
            return this.jad_an + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + this.jad_bo;
        }
    }

    static {
        java.util.Arrays.asList(1, 6, 3, 8);
        java.util.Arrays.asList(2, 7, 4, 5);
        jad_ob = new int[]{8, 8, 8};
        jad_pc = new int[]{8};
        jad_qd = new byte[]{-1, -40, -1};
        jad_re = new byte[]{102, 116, 121, 112};
        jad_sf = new byte[]{109, 105, 102, org.apache.tools.tar.TarConstants.LF_LINK};
        jad_tg = new byte[]{104, 101, 105, 99};
        jad_uh = new byte[]{79, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 89, 77, 80, 0};
        jad_vi = new byte[]{79, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 89, 77, 80, 85, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 0, 73, 73};
        jad_wj = new byte[]{-119, 80, 78, 71, 13, 10, com.google.common.base.Ascii.SUB, 10};
        jad_xk = new byte[]{101, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 73, 102};
        jad_yl = new byte[]{73, 72, 68, 82};
        jad_zm = new byte[]{73, 69, 78, 68};
        jad_cn = new byte[]{82, 73, 70, 70};
        jad_do = new byte[]{87, 69, 66, 80};
        jad_ep = new byte[]{69, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 73, 70};
        "VP8X".getBytes(java.nio.charset.Charset.defaultCharset());
        "VP8L".getBytes(java.nio.charset.Charset.defaultCharset());
        "VP8 ".getBytes(java.nio.charset.Charset.defaultCharset());
        "ANIM".getBytes(java.nio.charset.Charset.defaultCharset());
        "ANMF".getBytes(java.nio.charset.Charset.defaultCharset());
        "XMP ".getBytes(java.nio.charset.Charset.defaultCharset());
        jad_fq = new java.lang.String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        jad_gr = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        jad_hs = new byte[]{65, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 67, 73, 73, 0, 0, 0};
        com.jd.ad.sdk.jad_bo.jad_an.jad_dq[] jad_dqVarArr = {new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_NEW_SUBFILE_TYPE, com.getui.gtc.extension.distribution.gbd.d.g.aI, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SUBFILE_TYPE, 255, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, 256, 3, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, 257, 3, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_BITS_PER_SAMPLE, 258, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_COMPRESSION, 259, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_DESCRIPTION, 270, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_MAKE, 271, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_MODEL, 272, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_STRIP_OFFSETS, 273, 3, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 274, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SAMPLES_PER_PIXEL, 277, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_ROWS_PER_STRIP, com.anythink.expressad.foundation.g.a.aS, 3, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_STRIP_BYTE_COUNTS, com.anythink.expressad.foundation.g.a.aT, 3, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_X_RESOLUTION, 282, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_Y_RESOLUTION, 283, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_PLANAR_CONFIGURATION, 284, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_RESOLUTION_UNIT, com.anythink.expressad.foundation.g.a.aP, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_TRANSFER_FUNCTION, 301, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SOFTWARE, com.umeng.ccg.c.f452s, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_DATETIME, 306, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_ARTIST, 315, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_WHITE_POINT, 318, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_PRIMARY_CHROMATICITIES, 319, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq("SubIFDPointer", 330, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, com.badlogic.gdx.graphics.GL20.GL_EQUAL, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_Y_CB_CR_POSITIONING, 531, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_REFERENCE_BLACK_WHITE, 532, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_COPYRIGHT, 33432, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq("ExifIFDPointer", 34665, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq("GPSInfoIFDPointer", com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER0, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_RW2_ISO, 23, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_RW2_JPG_FROM_RAW, 46, 7), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_XMP, 700, 1)};
        com.jd.ad.sdk.jad_bo.jad_an.jad_dq[] jad_dqVarArr2 = {new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_EXPOSURE_TIME, 33434, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_F_NUMBER, 33437, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_EXPOSURE_PROGRAM, 34850, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SPECTRAL_SENSITIVITY, com.badlogic.gdx.graphics.GL30.GL_MAX_DRAW_BUFFERS, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER2, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_OECF, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER3, 7), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SENSITIVITY_TYPE, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER11, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_STANDARD_OUTPUT_SENSITIVITY, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER12, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_RECOMMENDED_EXPOSURE_INDEX, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER13, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_ISO_SPEED, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER14, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_ISO_SPEED_LATITUDE_YYY, com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER15, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_EXIF_VERSION, 36864, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_DATETIME_ORIGINAL, 36867, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_DATETIME_DIGITIZED, 36868, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_OFFSET_TIME, 36880, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_OFFSET_TIME_ORIGINAL, 36881, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_OFFSET_TIME_DIGITIZED, 36882, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_COMPONENTS_CONFIGURATION, 37121, 7), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SHUTTER_SPEED_VALUE, 37377, 10), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_APERTURE_VALUE, 37378, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_BRIGHTNESS_VALUE, 37379, 10), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_MAX_APERTURE_VALUE, 37381, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SUBJECT_DISTANCE, 37382, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_METERING_MODE, 37383, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_LIGHT_SOURCE, 37384, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_FLASH, 37385, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_FOCAL_LENGTH, 37386, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SUBJECT_AREA, 37396, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_MAKER_NOTE, 37500, 7), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_USER_COMMENT, 37510, 7), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME, 37520, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_FLASHPIX_VERSION, org.apache.tools.zip.UnixStat.LINK_FLAG, 7), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_COLOR_SPACE, 40961, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_RELATED_SOUND_FILE, 40964, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq("InteroperabilityIFDPointer", 40965, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_FLASH_ENERGY, 41483, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SUBJECT_LOCATION, 41492, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_EXPOSURE_INDEX, 41493, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SENSING_METHOD, 41495, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_FILE_SOURCE, 41728, 7), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SCENE_TYPE, 41729, 7), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_CFA_PATTERN, 41730, 7), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_CUSTOM_RENDERED, 41985, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_EXPOSURE_MODE, 41986, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_WHITE_BALANCE, 41987, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SCENE_CAPTURE_TYPE, 41990, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GAIN_CONTROL, 41991, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_CONTRAST, 41992, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SATURATION, 41993, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SHARPNESS, 41994, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_UNIQUE_ID, 42016, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq("CameraOwnerName", 42032, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_BODY_SERIAL_NUMBER, 42033, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_LENS_SPECIFICATION, 42034, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_LENS_MAKE, 42035, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_LENS_MODEL, 42036, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GAMMA, 42240, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_DNG_VERSION, 50706, 1), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        com.jd.ad.sdk.jad_bo.jad_an.jad_dq[] jad_dqVarArr3 = {new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_VERSION_ID, 0, 1), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE_REF, 1, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE, 2, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE_REF, 3, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE, 4, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_ALTITUDE_REF, 5, 1), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_ALTITUDE, 6, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_TIMESTAMP, 7, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_SATELLITES, 8, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_STATUS, 9, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_MEASURE_MODE, 10, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_DOP, 11, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_SPEED_REF, 12, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_SPEED, 13, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_TRACK_REF, 14, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_TRACK, 15, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_IMG_DIRECTION_REF, 16, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_IMG_DIRECTION, 17, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_MAP_DATUM, 18, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_DEST_LATITUDE_REF, 19, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_DEST_LATITUDE, 20, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_DEST_LONGITUDE, 22, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_DEST_BEARING_REF, 23, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_DEST_BEARING, 24, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_DEST_DISTANCE_REF, 25, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_DEST_DISTANCE, 26, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_PROCESSING_METHOD, 27, 7), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_AREA_INFORMATION, 28, 7), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_DATESTAMP, 29, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_DIFFERENTIAL, 30, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_GPS_H_POSITIONING_ERROR, 31, 5)};
        com.jd.ad.sdk.jad_bo.jad_an.jad_dq[] jad_dqVarArr4 = {new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_INTEROPERABILITY_INDEX, 1, 2)};
        com.jd.ad.sdk.jad_bo.jad_an.jad_dq[] jad_dqVarArr5 = {new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_NEW_SUBFILE_TYPE, com.getui.gtc.extension.distribution.gbd.d.g.aI, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SUBFILE_TYPE, 255, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_BITS_PER_SAMPLE, 258, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_COMPRESSION, 259, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_DESCRIPTION, 270, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_MAKE, 271, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_MODEL, 272, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_STRIP_OFFSETS, 273, 3, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_THUMBNAIL_ORIENTATION, 274, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SAMPLES_PER_PIXEL, 277, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_ROWS_PER_STRIP, com.anythink.expressad.foundation.g.a.aS, 3, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_STRIP_BYTE_COUNTS, com.anythink.expressad.foundation.g.a.aT, 3, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_X_RESOLUTION, 282, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_Y_RESOLUTION, 283, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_PLANAR_CONFIGURATION, 284, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_RESOLUTION_UNIT, com.anythink.expressad.foundation.g.a.aP, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_TRANSFER_FUNCTION, 301, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_SOFTWARE, com.umeng.ccg.c.f452s, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_DATETIME, 306, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_ARTIST, 315, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_WHITE_POINT, 318, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_PRIMARY_CHROMATICITIES, 319, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq("SubIFDPointer", 330, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, com.badlogic.gdx.graphics.GL20.GL_EQUAL, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_Y_CB_CR_POSITIONING, 531, 3), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_REFERENCE_BLACK_WHITE, 532, 5), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_COPYRIGHT, 33432, 2), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq("ExifIFDPointer", 34665, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq("GPSInfoIFDPointer", com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER0, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_DNG_VERSION, 50706, 1), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        jad_it = new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_STRIP_OFFSETS, 273, 3);
        jad_ju = new com.jd.ad.sdk.jad_bo.jad_an.jad_dq[][]{jad_dqVarArr, jad_dqVarArr2, jad_dqVarArr3, jad_dqVarArr4, jad_dqVarArr5, jad_dqVarArr, new com.jd.ad.sdk.jad_bo.jad_an.jad_dq[]{new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq("CameraSettingsIFDPointer", 8224, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq("ImageProcessingIFDPointer", 8256, 4)}, new com.jd.ad.sdk.jad_bo.jad_an.jad_dq[]{new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)}, new com.jd.ad.sdk.jad_bo.jad_an.jad_dq[]{new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_ORF_ASPECT_FRAME, 4371, 3)}, new com.jd.ad.sdk.jad_bo.jad_an.jad_dq[]{new com.jd.ad.sdk.jad_bo.jad_an.jad_dq(androidx.exifinterface.media.ExifInterface.TAG_COLOR_SPACE, 55, 3)}};
        jad_kv = new com.jd.ad.sdk.jad_bo.jad_an.jad_dq[]{new com.jd.ad.sdk.jad_bo.jad_an.jad_dq("SubIFDPointer", 330, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq("ExifIFDPointer", 34665, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq("GPSInfoIFDPointer", com.badlogic.gdx.graphics.GL30.GL_DRAW_BUFFER0, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq("InteroperabilityIFDPointer", 40965, 4), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq("CameraSettingsIFDPointer", 8224, 1), new com.jd.ad.sdk.jad_bo.jad_an.jad_dq("ImageProcessingIFDPointer", 8256, 1)};
        jad_lw = new java.util.HashMap[10];
        jad_mx = new java.util.HashMap[10];
        jad_ny = new java.util.HashSet<>(java.util.Arrays.asList(androidx.exifinterface.media.ExifInterface.TAG_F_NUMBER, androidx.exifinterface.media.ExifInterface.TAG_DIGITAL_ZOOM_RATIO, androidx.exifinterface.media.ExifInterface.TAG_EXPOSURE_TIME, androidx.exifinterface.media.ExifInterface.TAG_SUBJECT_DISTANCE, androidx.exifinterface.media.ExifInterface.TAG_GPS_TIMESTAMP));
        jad_oz = new java.util.HashMap<>();
        java.nio.charset.Charset forName = java.nio.charset.Charset.forName("US-ASCII");
        jad_pa = forName;
        jad_qb = "Exif\u0000\u0000".getBytes(forName);
        jad_rc = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        new java.text.SimpleDateFormat("yyyy:MM:dd HH:mm:ss").setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            com.jd.ad.sdk.jad_bo.jad_an.jad_dq[][] jad_dqVarArr6 = jad_ju;
            if (i >= jad_dqVarArr6.length) {
                java.util.HashMap<java.lang.Integer, java.lang.Integer> hashMap = jad_oz;
                com.jd.ad.sdk.jad_bo.jad_an.jad_dq[] jad_dqVarArr7 = jad_kv;
                hashMap.put(java.lang.Integer.valueOf(jad_dqVarArr7[0].jad_an), 5);
                hashMap.put(java.lang.Integer.valueOf(jad_dqVarArr7[1].jad_an), 1);
                hashMap.put(java.lang.Integer.valueOf(jad_dqVarArr7[2].jad_an), 2);
                hashMap.put(java.lang.Integer.valueOf(jad_dqVarArr7[3].jad_an), 3);
                hashMap.put(java.lang.Integer.valueOf(jad_dqVarArr7[4].jad_an), 7);
                hashMap.put(java.lang.Integer.valueOf(jad_dqVarArr7[5].jad_an), 8);
                java.util.regex.Pattern.compile(".*[1-9].*");
                java.util.regex.Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
            jad_lw[i] = new java.util.HashMap<>();
            jad_mx[i] = new java.util.HashMap<>();
            for (com.jd.ad.sdk.jad_bo.jad_an.jad_dq jad_dqVar : jad_dqVarArr6[i]) {
                jad_lw[i].put(java.lang.Integer.valueOf(jad_dqVar.jad_an), jad_dqVar);
                jad_mx[i].put(jad_dqVar.jad_bo, jad_dqVar);
            }
            i++;
        }
    }

    public jad_an(@androidx.annotation.NonNull java.io.InputStream inputStream, boolean z) {
        com.jd.ad.sdk.jad_bo.jad_an.jad_dq[][] jad_dqVarArr = jad_ju;
        this.jad_er = new java.util.HashMap[jad_dqVarArr.length];
        this.jad_fs = new java.util.HashSet(jad_dqVarArr.length);
        this.jad_jt = java.nio.ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new java.lang.NullPointerException("inputStream cannot be null");
        }
        if (z) {
            java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(inputStream, 5000);
            if (!jad_bo(bufferedInputStream)) {
                return;
            }
            this.jad_dq = true;
            this.jad_bo = null;
            this.jad_an = null;
            inputStream = bufferedInputStream;
        } else if (inputStream instanceof android.content.res.AssetManager.AssetInputStream) {
            this.jad_bo = (android.content.res.AssetManager.AssetInputStream) inputStream;
            this.jad_an = null;
        } else {
            if (inputStream instanceof java.io.FileInputStream) {
                java.io.FileInputStream fileInputStream = (java.io.FileInputStream) inputStream;
                if (jad_an(fileInputStream.getFD())) {
                    this.jad_bo = null;
                    this.jad_an = fileInputStream.getFD();
                }
            }
            this.jad_bo = null;
            this.jad_an = null;
        }
        jad_an(inputStream);
    }

    public static java.lang.String jad_an(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(java.lang.String.format("%02x", java.lang.Byte.valueOf(b)));
        }
        return sb.toString();
    }

    public static boolean jad_an(java.io.FileDescriptor fileDescriptor) {
        try {
            android.system.Os.lseek(fileDescriptor, 0L, android.system.OsConstants.SEEK_CUR);
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean jad_an(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static long[] jad_an(java.lang.Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = iArr[i];
        }
        return jArr;
    }

    public static boolean jad_bo(java.io.BufferedInputStream bufferedInputStream) {
        byte[] bArr = jad_qb;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr3 = jad_qb;
            if (i >= bArr3.length) {
                return true;
            }
            if (bArr2[i] != bArr3[i]) {
                return false;
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int jad_an(java.io.BufferedInputStream bufferedInputStream) {
        boolean z;
        boolean z2;
        boolean z3;
        com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar;
        boolean z4;
        boolean z5;
        long readInt;
        byte[] bArr;
        long j;
        bufferedInputStream.mark(5000);
        byte[] bArr2 = new byte[5000];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr3 = jad_qd;
            z = true;
            if (i >= bArr3.length) {
                z2 = true;
                break;
            }
            if (bArr2[i] != bArr3[i]) {
                z2 = false;
                break;
            }
            i++;
        }
        if (z2) {
            return 4;
        }
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(java.nio.charset.Charset.defaultCharset());
        int i2 = 0;
        while (true) {
            if (i2 >= bytes.length) {
                z3 = true;
                break;
            }
            if (bArr2[i2] != bytes[i2]) {
                z3 = false;
                break;
            }
            i2++;
        }
        if (z3) {
            return 9;
        }
        com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar2 = null;
        try {
            try {
                jad_boVar = new com.jd.ad.sdk.jad_bo.jad_an.jad_bo(bArr2);
            } catch (java.lang.Exception unused) {
            }
        } catch (java.lang.Throwable th) {
            th = th;
            jad_boVar = jad_boVar2;
        }
        try {
            readInt = jad_boVar.readInt();
            bArr = new byte[4];
            jad_boVar.read(bArr);
        } catch (java.lang.Exception unused2) {
            jad_boVar2 = jad_boVar;
            boolean z6 = jad_na;
            if (jad_boVar2 != null) {
                jad_boVar2.close();
            }
            z4 = false;
            if (z4) {
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (jad_boVar != null) {
                jad_boVar.close();
            }
            throw th;
        }
        if (java.util.Arrays.equals(bArr, jad_re)) {
            if (readInt == 1) {
                readInt = jad_boVar.readLong();
                j = 16;
                if (readInt < 16) {
                }
            } else {
                j = 8;
            }
            long j2 = 5000;
            if (readInt > j2) {
                readInt = j2;
            }
            long j3 = readInt - j;
            if (j3 >= 8) {
                byte[] bArr4 = new byte[4];
                boolean z7 = false;
                boolean z8 = false;
                for (long j4 = 0; j4 < j3 / 4; j4++) {
                    if (jad_boVar.read(bArr4) == 4) {
                        if (j4 != 1) {
                            if (java.util.Arrays.equals(bArr4, jad_sf)) {
                                z7 = true;
                            } else if (java.util.Arrays.equals(bArr4, jad_tg)) {
                                z8 = true;
                            }
                            if (z7 && z8) {
                                jad_boVar.close();
                                z4 = true;
                                break;
                            }
                        }
                    }
                }
                jad_boVar.close();
                z4 = false;
                if (z4) {
                    return 12;
                }
                if (jad_bo(bArr2)) {
                    return 7;
                }
                if (jad_cp(bArr2)) {
                    return 10;
                }
                int i3 = 0;
                while (true) {
                    byte[] bArr5 = jad_wj;
                    if (i3 >= bArr5.length) {
                        z5 = true;
                        break;
                    }
                    if (bArr2[i3] != bArr5[i3]) {
                        z5 = false;
                        break;
                    }
                    i3++;
                }
                if (z5) {
                    return 13;
                }
                int i4 = 0;
                while (true) {
                    byte[] bArr6 = jad_cn;
                    if (i4 >= bArr6.length) {
                        int i5 = 0;
                        while (true) {
                            byte[] bArr7 = jad_do;
                            if (i5 >= bArr7.length) {
                                break;
                            }
                            if (bArr2[jad_cn.length + i5 + 4] != bArr7[i5]) {
                                break;
                            }
                            i5++;
                        }
                    } else {
                        if (bArr2[i4] != bArr6[i4]) {
                            break;
                        }
                        i4++;
                    }
                }
                z = false;
                return z ? 14 : 0;
            }
        }
        jad_boVar.close();
        z4 = false;
        if (z4) {
        }
    }

    @androidx.annotation.Nullable
    public java.lang.String jad_an(@androidx.annotation.NonNull java.lang.String str) {
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_bo2 = jad_bo(str);
        if (jad_bo2 != null) {
            if (!jad_ny.contains(str)) {
                return jad_bo2.jad_cp(this.jad_jt);
            }
            if (str.equals(androidx.exifinterface.media.ExifInterface.TAG_GPS_TIMESTAMP)) {
                int i = jad_bo2.jad_an;
                if (i != 5 && i != 10) {
                    com.jd.ad.sdk.jad_bo.jad_bo.jad_an("GPS Timestamp format is not rational. format=").append(jad_bo2.jad_an);
                    return null;
                }
                com.jd.ad.sdk.jad_bo.jad_an.jad_er[] jad_erVarArr = (com.jd.ad.sdk.jad_bo.jad_an.jad_er[]) jad_bo2.jad_dq(this.jad_jt);
                if (jad_erVarArr == null || jad_erVarArr.length != 3) {
                    com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid GPS Timestamp array. array=").append(java.util.Arrays.toString(jad_erVarArr));
                    return null;
                }
                com.jd.ad.sdk.jad_bo.jad_an.jad_er jad_erVar = jad_erVarArr[0];
                com.jd.ad.sdk.jad_bo.jad_an.jad_er jad_erVar2 = jad_erVarArr[1];
                com.jd.ad.sdk.jad_bo.jad_an.jad_er jad_erVar3 = jad_erVarArr[2];
                return java.lang.String.format("%02d:%02d:%02d", java.lang.Integer.valueOf((int) (jad_erVar.jad_an / jad_erVar.jad_bo)), java.lang.Integer.valueOf((int) (jad_erVar2.jad_an / jad_erVar2.jad_bo)), java.lang.Integer.valueOf((int) (jad_erVar3.jad_an / jad_erVar3.jad_bo)));
            }
            try {
                return java.lang.Double.toString(jad_bo2.jad_an(this.jad_jt));
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        return null;
    }

    public final void jad_an() {
        java.lang.String jad_an = jad_an(androidx.exifinterface.media.ExifInterface.TAG_DATETIME_ORIGINAL);
        if (jad_an != null && jad_an(androidx.exifinterface.media.ExifInterface.TAG_DATETIME) == null) {
            this.jad_er[0].put(androidx.exifinterface.media.ExifInterface.TAG_DATETIME, com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(jad_an));
        }
        if (jad_an(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH) == null) {
            this.jad_er[0].put(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(0L, this.jad_jt));
        }
        if (jad_an(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH) == null) {
            this.jad_er[0].put(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(0L, this.jad_jt));
        }
        if (jad_an(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION) == null) {
            this.jad_er[0].put(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(0L, this.jad_jt));
        }
        if (jad_an(androidx.exifinterface.media.ExifInterface.TAG_LIGHT_SOURCE) == null) {
            this.jad_er[1].put(androidx.exifinterface.media.ExifInterface.TAG_LIGHT_SOURCE, com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(0L, this.jad_jt));
        }
    }

    public final void jad_an(int i, int i2) {
        if (this.jad_er[i].isEmpty() || this.jad_er[i2].isEmpty()) {
            return;
        }
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar = this.jad_er[i].get(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar2 = this.jad_er[i].get(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar3 = this.jad_er[i2].get(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar4 = this.jad_er[i2].get(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH);
        if (jad_cpVar == null || jad_cpVar2 == null || jad_cpVar3 == null || jad_cpVar4 == null) {
            return;
        }
        int jad_bo2 = jad_cpVar.jad_bo(this.jad_jt);
        int jad_bo3 = jad_cpVar2.jad_bo(this.jad_jt);
        int jad_bo4 = jad_cpVar3.jad_bo(this.jad_jt);
        int jad_bo5 = jad_cpVar4.jad_bo(this.jad_jt);
        if (jad_bo2 >= jad_bo4 || jad_bo3 >= jad_bo5) {
            return;
        }
        java.util.HashMap<java.lang.String, com.jd.ad.sdk.jad_bo.jad_an.jad_cp>[] hashMapArr = this.jad_er;
        java.util.HashMap<java.lang.String, com.jd.ad.sdk.jad_bo.jad_an.jad_cp> hashMap = hashMapArr[i];
        hashMapArr[i] = hashMapArr[i2];
        hashMapArr[i2] = hashMap;
    }

    public final void jad_an(com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
        try {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                mediaMetadataRetriever.setDataSource(new com.jd.ad.sdk.jad_bo.jad_an.C0377jad_an(this, jad_boVar));
            } else {
                java.io.FileDescriptor fileDescriptor = this.jad_an;
                if (fileDescriptor == null) {
                    return;
                } else {
                    mediaMetadataRetriever.setDataSource(fileDescriptor);
                }
            }
            java.lang.String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
            java.lang.String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
            java.lang.String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
            java.lang.String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
            if ("yes".equals(extractMetadata3)) {
                str = mediaMetadataRetriever.extractMetadata(29);
                str2 = mediaMetadataRetriever.extractMetadata(30);
                str3 = mediaMetadataRetriever.extractMetadata(31);
            } else if ("yes".equals(extractMetadata4)) {
                str = mediaMetadataRetriever.extractMetadata(18);
                str2 = mediaMetadataRetriever.extractMetadata(19);
                str3 = mediaMetadataRetriever.extractMetadata(24);
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            if (str != null) {
                this.jad_er[0].put(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(java.lang.Integer.parseInt(str), this.jad_jt));
            }
            if (str2 != null) {
                this.jad_er[0].put(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(java.lang.Integer.parseInt(str2), this.jad_jt));
            }
            if (str3 != null) {
                int parseInt = java.lang.Integer.parseInt(str3);
                this.jad_er[0].put(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(parseInt != 90 ? parseInt != 180 ? parseInt != 270 ? 1 : 8 : 3 : 6, this.jad_jt));
            }
            if (extractMetadata != null && extractMetadata2 != null) {
                int parseInt2 = java.lang.Integer.parseInt(extractMetadata);
                int parseInt3 = java.lang.Integer.parseInt(extractMetadata2);
                if (parseInt3 <= 6) {
                    throw new java.io.IOException("Invalid exif length");
                }
                jad_boVar.jad_bo(parseInt2);
                byte[] bArr = new byte[6];
                if (jad_boVar.read(bArr) != 6) {
                    throw new java.io.IOException("Can't read identifier");
                }
                int i = parseInt2 + 6;
                int i2 = parseInt3 - 6;
                if (!java.util.Arrays.equals(bArr, jad_qb)) {
                    throw new java.io.IOException("Invalid identifier");
                }
                byte[] bArr2 = new byte[i2];
                if (jad_boVar.read(bArr2) != i2) {
                    throw new java.io.IOException("Can't read exif");
                }
                this.jad_iv = i;
                jad_an(bArr2, 0);
            }
            if (jad_na) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Heif meta: ");
                sb.append(str);
                sb.append("x");
                sb.append(str2);
                sb.append(", rotation ");
                sb.append(str3);
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public final void jad_an(com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar, int i) {
        java.nio.ByteOrder jad_iv = jad_iv(jad_boVar);
        this.jad_jt = jad_iv;
        jad_boVar.jad_bo = jad_iv;
        int readUnsignedShort = jad_boVar.readUnsignedShort();
        int i2 = this.jad_cp;
        if (i2 != 7 && i2 != 10 && readUnsignedShort != 42) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid start code: ");
            jad_an.append(java.lang.Integer.toHexString(readUnsignedShort));
            throw new java.io.IOException(jad_an.toString());
        }
        int readInt = jad_boVar.readInt();
        if (readInt < 8 || readInt >= i) {
            throw new java.io.IOException("Invalid first Ifd offset: " + readInt);
        }
        int i3 = readInt - 8;
        if (i3 <= 0 || jad_boVar.skipBytes(i3) == i3) {
            return;
        }
        throw new java.io.IOException("Couldn't jump to first Ifd: " + i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0172, code lost:
    
        r19.jad_bo = r18.jad_jt;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0176, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0166 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a0 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void jad_an(com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar, int i, int i2) {
        if (jad_na) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getJpegAttributes starting with: ");
            sb.append(jad_boVar);
        }
        jad_boVar.jad_bo = java.nio.ByteOrder.BIG_ENDIAN;
        jad_boVar.jad_bo(i);
        byte readByte = jad_boVar.readByte();
        if (readByte != -1) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid marker: ");
            jad_an.append(java.lang.Integer.toHexString(readByte & 255));
            throw new java.io.IOException(jad_an.toString());
        }
        int i3 = i + 1;
        if (jad_boVar.readByte() != -40) {
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid marker: ");
            jad_an2.append(java.lang.Integer.toHexString(readByte & 255));
            throw new java.io.IOException(jad_an2.toString());
        }
        int i4 = i3 + 1;
        while (true) {
            byte readByte2 = jad_boVar.readByte();
            if (readByte2 != -1) {
                java.lang.StringBuilder jad_an3 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid marker:");
                jad_an3.append(java.lang.Integer.toHexString(readByte2 & 255));
                throw new java.io.IOException(jad_an3.toString());
            }
            int i5 = i4 + 1;
            byte readByte3 = jad_boVar.readByte();
            boolean z = jad_na;
            if (z) {
                com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Found JPEG segment indicator: ").append(java.lang.Integer.toHexString(readByte3 & 255));
            }
            int i6 = i5 + 1;
            if (readByte3 != -39 && readByte3 != -38) {
                int readUnsignedShort = jad_boVar.readUnsignedShort() - 2;
                int i7 = i6 + 2;
                if (z) {
                    java.lang.StringBuilder jad_an4 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("JPEG segment: ");
                    jad_an4.append(java.lang.Integer.toHexString(readByte3 & 255));
                    jad_an4.append(" (length: ");
                    jad_an4.append(readUnsignedShort + 2);
                    jad_an4.append(")");
                }
                if (readUnsignedShort < 0) {
                    throw new java.io.IOException("Invalid length");
                }
                if (readByte3 == -31) {
                    byte[] bArr = new byte[readUnsignedShort];
                    jad_boVar.readFully(bArr);
                    int i8 = i7 + readUnsignedShort;
                    byte[] bArr2 = jad_qb;
                    if (jad_an(bArr, bArr2)) {
                        int length = i7 + bArr2.length;
                        byte[] copyOfRange = java.util.Arrays.copyOfRange(bArr, bArr2.length, readUnsignedShort);
                        this.jad_iv = length;
                        jad_an(copyOfRange, i2);
                    } else {
                        byte[] bArr3 = jad_rc;
                        if (jad_an(bArr, bArr3)) {
                            int length2 = i7 + bArr3.length;
                            byte[] copyOfRange2 = java.util.Arrays.copyOfRange(bArr, bArr3.length, readUnsignedShort);
                            if (jad_an(androidx.exifinterface.media.ExifInterface.TAG_XMP) == null) {
                                this.jad_er[0].put(androidx.exifinterface.media.ExifInterface.TAG_XMP, new com.jd.ad.sdk.jad_bo.jad_an.jad_cp(1, copyOfRange2.length, length2, copyOfRange2));
                            }
                        }
                    }
                    i7 = i8;
                } else if (readByte3 != -2) {
                    switch (readByte3) {
                        default:
                            switch (readByte3) {
                                default:
                                    switch (readByte3) {
                                        default:
                                            switch (readByte3) {
                                            }
                                        case -55:
                                        case -54:
                                        case -53:
                                            if (jad_boVar.skipBytes(1) != 1) {
                                                throw new java.io.IOException("Invalid SOFx");
                                            }
                                            this.jad_er[i2].put(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(jad_boVar.readUnsignedShort(), this.jad_jt));
                                            this.jad_er[i2].put(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(jad_boVar.readUnsignedShort(), this.jad_jt));
                                            readUnsignedShort -= 5;
                                            break;
                                    }
                                case -59:
                                case -58:
                                case -57:
                                    break;
                            }
                        case -64:
                        case -63:
                        case -62:
                        case -61:
                            break;
                    }
                    if (readUnsignedShort >= 0) {
                        throw new java.io.IOException("Invalid length");
                    }
                    if (jad_boVar.skipBytes(readUnsignedShort) != readUnsignedShort) {
                        throw new java.io.IOException("Invalid JPEG segment");
                    }
                    i4 = i7 + readUnsignedShort;
                } else {
                    byte[] bArr4 = new byte[readUnsignedShort];
                    if (jad_boVar.read(bArr4) != readUnsignedShort) {
                        throw new java.io.IOException("Invalid exif");
                    }
                    if (jad_an(androidx.exifinterface.media.ExifInterface.TAG_USER_COMMENT) == null) {
                        this.jad_er[1].put(androidx.exifinterface.media.ExifInterface.TAG_USER_COMMENT, com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(new java.lang.String(bArr4, jad_pa)));
                    }
                }
                readUnsignedShort = 0;
                if (readUnsignedShort >= 0) {
                }
            }
        }
    }

    public final void jad_an(com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar, java.util.HashMap hashMap) {
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar = (com.jd.ad.sdk.jad_bo.jad_an.jad_cp) hashMap.get(androidx.exifinterface.media.ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar2 = (com.jd.ad.sdk.jad_bo.jad_an.jad_cp) hashMap.get(androidx.exifinterface.media.ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (jad_cpVar == null || jad_cpVar2 == null) {
            return;
        }
        int jad_bo2 = jad_cpVar.jad_bo(this.jad_jt);
        int jad_bo3 = jad_cpVar2.jad_bo(this.jad_jt);
        if (this.jad_cp == 7) {
            jad_bo2 += this.jad_jw;
        }
        int min = java.lang.Math.min(jad_bo3, jad_boVar.jad_cp - jad_bo2);
        if (jad_bo2 > 0 && min > 0) {
            int i = this.jad_iv + jad_bo2;
            if (this.jad_bo == null && this.jad_an == null) {
                jad_boVar.jad_bo(i);
                jad_boVar.readFully(new byte[min]);
            }
        }
        if (jad_na) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Setting thumbnail attributes with offset: ");
            sb.append(jad_bo2);
            sb.append(", length: ");
            sb.append(min);
        }
    }

    public final void jad_an(@androidx.annotation.NonNull java.io.InputStream inputStream) {
        if (inputStream == null) {
            throw new java.lang.NullPointerException("inputstream shouldn't be null");
        }
        for (int i = 0; i < jad_ju.length; i++) {
            try {
                try {
                    this.jad_er[i] = new java.util.HashMap<>();
                } catch (java.io.IOException unused) {
                    boolean z = jad_na;
                    jad_an();
                    if (!z) {
                        return;
                    }
                }
            } finally {
                jad_an();
                if (jad_na) {
                    jad_bo();
                }
            }
        }
        if (!this.jad_dq) {
            java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(inputStream, 5000);
            this.jad_cp = jad_an(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar = new com.jd.ad.sdk.jad_bo.jad_an.jad_bo(inputStream, java.nio.ByteOrder.BIG_ENDIAN);
        if (!this.jad_dq) {
            switch (this.jad_cp) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 5:
                case 6:
                case 8:
                case 11:
                    jad_er(jad_boVar);
                    break;
                case 4:
                    jad_an(jad_boVar, 0, 0);
                    break;
                case 7:
                    jad_bo(jad_boVar);
                    break;
                case 9:
                    jad_dq(jad_boVar);
                    break;
                case 10:
                    jad_fs(jad_boVar);
                    break;
                case 12:
                    jad_an(jad_boVar);
                    break;
                case 13:
                    jad_cp(jad_boVar);
                    break;
                case 14:
                    jad_hu(jad_boVar);
                    break;
            }
        } else {
            jad_jt(jad_boVar);
        }
        jad_jw(jad_boVar);
    }

    public final void jad_an(byte[] bArr, int i) {
        com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar = new com.jd.ad.sdk.jad_bo.jad_an.jad_bo(bArr);
        jad_an(jad_boVar, bArr.length);
        jad_bo(jad_boVar, i);
    }

    public final boolean jad_an(java.util.HashMap hashMap) {
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar = (com.jd.ad.sdk.jad_bo.jad_an.jad_cp) hashMap.get(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar2 = (com.jd.ad.sdk.jad_bo.jad_an.jad_cp) hashMap.get(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH);
        if (jad_cpVar == null || jad_cpVar2 == null) {
            return false;
        }
        return jad_cpVar.jad_bo(this.jad_jt) <= 512 && jad_cpVar2.jad_bo(this.jad_jt) <= 512;
    }

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_bo(@androidx.annotation.NonNull java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("tag shouldn't be null");
        }
        if (androidx.exifinterface.media.ExifInterface.TAG_ISO_SPEED_RATINGS.equals(str)) {
            str = androidx.exifinterface.media.ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        for (int i = 0; i < jad_ju.length; i++) {
            com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar = this.jad_er[i].get(str);
            if (jad_cpVar != null) {
                return jad_cpVar;
            }
        }
        return null;
    }

    public final void jad_bo() {
        for (int i = 0; i < this.jad_er.length; i++) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("The size of tag group[");
            sb.append(i);
            sb.append("]: ");
            sb.append(this.jad_er[i].size());
            for (java.util.Map.Entry<java.lang.String, com.jd.ad.sdk.jad_bo.jad_an.jad_cp> entry : this.jad_er[i].entrySet()) {
                com.jd.ad.sdk.jad_bo.jad_an.jad_cp value = entry.getValue();
                java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("tagName: ");
                jad_an.append(entry.getKey());
                jad_an.append(", tagType: ");
                jad_an.append(value.toString());
                jad_an.append(", tagValue: '");
                jad_an.append(value.jad_cp(this.jad_jt));
                jad_an.append("'");
            }
        }
    }

    public final void jad_bo(com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar) {
        int i;
        int i2;
        jad_er(jad_boVar);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar = this.jad_er[1].get(androidx.exifinterface.media.ExifInterface.TAG_MAKER_NOTE);
        if (jad_cpVar != null) {
            com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar2 = new com.jd.ad.sdk.jad_bo.jad_an.jad_bo(jad_cpVar.jad_cp);
            jad_boVar2.jad_bo = this.jad_jt;
            byte[] bArr = jad_uh;
            byte[] bArr2 = new byte[bArr.length];
            jad_boVar2.readFully(bArr2);
            jad_boVar2.jad_bo(0L);
            byte[] bArr3 = jad_vi;
            byte[] bArr4 = new byte[bArr3.length];
            jad_boVar2.readFully(bArr4);
            if (java.util.Arrays.equals(bArr2, bArr)) {
                jad_boVar2.jad_bo(8L);
            } else if (java.util.Arrays.equals(bArr4, bArr3)) {
                jad_boVar2.jad_bo(12L);
            }
            jad_bo(jad_boVar2, 6);
            com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar2 = this.jad_er[7].get(androidx.exifinterface.media.ExifInterface.TAG_ORF_PREVIEW_IMAGE_START);
            com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar3 = this.jad_er[7].get(androidx.exifinterface.media.ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (jad_cpVar2 != null && jad_cpVar3 != null) {
                this.jad_er[5].put(androidx.exifinterface.media.ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, jad_cpVar2);
                this.jad_er[5].put(androidx.exifinterface.media.ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, jad_cpVar3);
            }
            com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar4 = this.jad_er[8].get(androidx.exifinterface.media.ExifInterface.TAG_ORF_ASPECT_FRAME);
            if (jad_cpVar4 != null) {
                int[] iArr = (int[]) jad_cpVar4.jad_dq(this.jad_jt);
                if (iArr == null || iArr.length != 4) {
                    com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid aspect frame values. frame=").append(java.util.Arrays.toString(iArr));
                    return;
                }
                int i3 = iArr[2];
                int i4 = iArr[0];
                if (i3 <= i4 || (i = iArr[3]) <= (i2 = iArr[1])) {
                    return;
                }
                int i5 = (i3 - i4) + 1;
                int i6 = (i - i2) + 1;
                if (i5 < i6) {
                    int i7 = i5 + i6;
                    i6 = i7 - i6;
                    i5 = i7 - i6;
                }
                com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_an = com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(i5, this.jad_jt);
                com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_an2 = com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(i6, this.jad_jt);
                this.jad_er[0].put(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, jad_an);
                this.jad_er[0].put(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, jad_an2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void jad_bo(com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar, int i) {
        short s2;
        long j;
        boolean z;
        int i2;
        short s3;
        short s4;
        int i3;
        int i4;
        int i5;
        int readUnsignedShort;
        long j2;
        int i6 = i;
        this.jad_fs.add(java.lang.Integer.valueOf(jad_boVar.jad_dq));
        if (jad_boVar.jad_dq + 2 > jad_boVar.jad_cp) {
            return;
        }
        short readShort = jad_boVar.readShort();
        if (jad_na) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("numberOfDirectoryEntry: ");
            sb.append((int) readShort);
        }
        if ((readShort * 12) + jad_boVar.jad_dq > jad_boVar.jad_cp || readShort <= 0) {
            return;
        }
        char c = 0;
        short s5 = 0;
        while (s5 < readShort) {
            int readUnsignedShort2 = jad_boVar.readUnsignedShort();
            int readUnsignedShort3 = jad_boVar.readUnsignedShort();
            int readInt = jad_boVar.readInt();
            long j3 = jad_boVar.jad_dq + 4;
            com.jd.ad.sdk.jad_bo.jad_an.jad_dq jad_dqVar = jad_lw[i6].get(java.lang.Integer.valueOf(readUnsignedShort2));
            boolean z2 = jad_na;
            if (z2) {
                java.lang.Object[] objArr = new java.lang.Object[5];
                objArr[c] = java.lang.Integer.valueOf(i);
                objArr[1] = java.lang.Integer.valueOf(readUnsignedShort2);
                objArr[2] = jad_dqVar != null ? jad_dqVar.jad_bo : null;
                objArr[3] = java.lang.Integer.valueOf(readUnsignedShort3);
                objArr[4] = java.lang.Integer.valueOf(readInt);
                java.lang.String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", objArr);
            }
            if (jad_dqVar != null) {
                if (readUnsignedShort3 > 0) {
                    if (readUnsignedShort3 < jad_gr.length) {
                        int i7 = jad_dqVar.jad_cp;
                        if (i7 == 7 || readUnsignedShort3 == 7 || i7 == readUnsignedShort3 || (i2 = jad_dqVar.jad_dq) == readUnsignedShort3 || ((i7 == 4 || i2 == 4) && readUnsignedShort3 == 3) || (((i7 == 9 || i2 == 9) && readUnsignedShort3 == 8) || ((i7 == 12 || i2 == 12) && readUnsignedShort3 == 11))) {
                            if (readUnsignedShort3 == 7) {
                                readUnsignedShort3 = i7;
                            }
                            s2 = s5;
                            j = readInt * r7[readUnsignedShort3];
                            if (j < 0 || j > 2147483647L) {
                                if (z2) {
                                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                                    sb2.append("Skip the tag entry since the number of components is invalid: ");
                                    sb2.append(readInt);
                                }
                                z = false;
                                if (z) {
                                    jad_boVar.jad_bo(j3);
                                    s3 = readShort;
                                    s4 = s2;
                                } else {
                                    if (j > 4) {
                                        int readInt2 = jad_boVar.readInt();
                                        s3 = readShort;
                                        if (z2) {
                                            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                                            s4 = s2;
                                            sb3.append("seek to data offset: ");
                                            sb3.append(readInt2);
                                        } else {
                                            s4 = s2;
                                        }
                                        int i8 = this.jad_cp;
                                        if (i8 == 7) {
                                            if (androidx.exifinterface.media.ExifInterface.TAG_MAKER_NOTE.equals(jad_dqVar.jad_bo)) {
                                                this.jad_jw = readInt2;
                                            } else if (i6 == 6 && androidx.exifinterface.media.ExifInterface.TAG_ORF_THUMBNAIL_IMAGE.equals(jad_dqVar.jad_bo)) {
                                                this.jad_kx = readInt2;
                                                this.jad_ly = readInt;
                                                com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_an = com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(6, this.jad_jt);
                                                i3 = readUnsignedShort2;
                                                i4 = readUnsignedShort3;
                                                com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_an2 = com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(this.jad_kx, this.jad_jt);
                                                i5 = readInt;
                                                com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_an3 = com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(this.jad_ly, this.jad_jt);
                                                this.jad_er[4].put(androidx.exifinterface.media.ExifInterface.TAG_COMPRESSION, jad_an);
                                                this.jad_er[4].put(androidx.exifinterface.media.ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, jad_an2);
                                                this.jad_er[4].put(androidx.exifinterface.media.ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, jad_an3);
                                            }
                                            i3 = readUnsignedShort2;
                                            i4 = readUnsignedShort3;
                                            i5 = readInt;
                                        } else {
                                            i3 = readUnsignedShort2;
                                            i4 = readUnsignedShort3;
                                            i5 = readInt;
                                            if (i8 == 10 && androidx.exifinterface.media.ExifInterface.TAG_RW2_JPG_FROM_RAW.equals(jad_dqVar.jad_bo)) {
                                                this.jad_mz = readInt2;
                                            }
                                        }
                                        long j4 = readInt2;
                                        if (j4 + j <= jad_boVar.jad_cp) {
                                            jad_boVar.jad_bo(j4);
                                        } else {
                                            if (z2) {
                                                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                                                sb4.append("Skip the tag entry since data offset is invalid: ");
                                                sb4.append(readInt2);
                                            }
                                            jad_boVar.jad_bo(j3);
                                        }
                                    } else {
                                        s3 = readShort;
                                        s4 = s2;
                                        i3 = readUnsignedShort2;
                                        i4 = readUnsignedShort3;
                                        i5 = readInt;
                                    }
                                    java.lang.Integer num = jad_oz.get(java.lang.Integer.valueOf(i3));
                                    if (z2) {
                                        java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                                        sb5.append("nextIfdType: ");
                                        sb5.append(num);
                                        sb5.append(" byteCount: ");
                                        sb5.append(j);
                                    }
                                    if (num != null) {
                                        int i9 = i4;
                                        if (i9 != 3) {
                                            if (i9 == 4) {
                                                j2 = jad_boVar.jad_bo();
                                            } else if (i9 == 8) {
                                                readUnsignedShort = jad_boVar.readShort();
                                            } else if (i9 == 9 || i9 == 13) {
                                                readUnsignedShort = jad_boVar.readInt();
                                            } else {
                                                j2 = -1;
                                            }
                                            if (z2) {
                                                java.lang.String.format("Offset: %d, tagName: %s", java.lang.Long.valueOf(j2), jad_dqVar.jad_bo);
                                            }
                                            if (j2 > 0 || j2 >= jad_boVar.jad_cp) {
                                                if (z2) {
                                                    java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                                                    sb6.append("Skip jump into the IFD since its offset is invalid: ");
                                                    sb6.append(j2);
                                                }
                                            } else if (!this.jad_fs.contains(java.lang.Integer.valueOf((int) j2))) {
                                                jad_boVar.jad_bo(j2);
                                                jad_bo(jad_boVar, num.intValue());
                                            } else if (z2) {
                                                java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
                                                sb7.append("Skip jump into the IFD since it has already been read: IfdType ");
                                                sb7.append(num);
                                                sb7.append(" (at ");
                                                sb7.append(j2);
                                                sb7.append(")");
                                            }
                                            jad_boVar.jad_bo(j3);
                                        } else {
                                            readUnsignedShort = jad_boVar.readUnsignedShort();
                                        }
                                        j2 = readUnsignedShort;
                                        if (z2) {
                                        }
                                        if (j2 > 0) {
                                        }
                                        if (z2) {
                                        }
                                        jad_boVar.jad_bo(j3);
                                    } else {
                                        int i10 = jad_boVar.jad_dq + this.jad_iv;
                                        byte[] bArr = new byte[(int) j];
                                        jad_boVar.readFully(bArr);
                                        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar = new com.jd.ad.sdk.jad_bo.jad_an.jad_cp(i4, i5, i10, bArr);
                                        this.jad_er[i].put(jad_dqVar.jad_bo, jad_cpVar);
                                        if (androidx.exifinterface.media.ExifInterface.TAG_DNG_VERSION.equals(jad_dqVar.jad_bo)) {
                                            this.jad_cp = 3;
                                        }
                                        if (((androidx.exifinterface.media.ExifInterface.TAG_MAKE.equals(jad_dqVar.jad_bo) || androidx.exifinterface.media.ExifInterface.TAG_MODEL.equals(jad_dqVar.jad_bo)) && jad_cpVar.jad_cp(this.jad_jt).contains("PENTAX")) || (androidx.exifinterface.media.ExifInterface.TAG_COMPRESSION.equals(jad_dqVar.jad_bo) && jad_cpVar.jad_bo(this.jad_jt) == 65535)) {
                                            this.jad_cp = 8;
                                        }
                                        if (jad_boVar.jad_dq != j3) {
                                            jad_boVar.jad_bo(j3);
                                        }
                                    }
                                    s5 = (short) (s4 + 1);
                                    i6 = i;
                                    readShort = s3;
                                    c = 0;
                                }
                                s5 = (short) (s4 + 1);
                                i6 = i;
                                readShort = s3;
                                c = 0;
                            } else {
                                z = true;
                                if (z) {
                                }
                                s5 = (short) (s4 + 1);
                                i6 = i;
                                readShort = s3;
                                c = 0;
                            }
                        } else if (z2) {
                            java.lang.StringBuilder jad_an4 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Skip the tag entry since data format (");
                            jad_an4.append(jad_fq[readUnsignedShort3]);
                            jad_an4.append(") is unexpected for tag: ");
                            jad_an4.append(jad_dqVar.jad_bo);
                        }
                    }
                }
                s2 = s5;
                if (z2) {
                    java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
                    sb8.append("Skip the tag entry since data format is invalid: ");
                    sb8.append(readUnsignedShort3);
                }
                j = 0;
                z = false;
                if (z) {
                }
                s5 = (short) (s4 + 1);
                i6 = i;
                readShort = s3;
                c = 0;
            } else if (z2) {
                java.lang.StringBuilder sb9 = new java.lang.StringBuilder();
                sb9.append("Skip the tag entry since tag number is not defined: ");
                sb9.append(readUnsignedShort2);
            }
            s2 = s5;
            j = 0;
            z = false;
            if (z) {
            }
            s5 = (short) (s4 + 1);
            i6 = i;
            readShort = s3;
            c = 0;
        }
        if (jad_boVar.jad_dq + 4 <= jad_boVar.jad_cp) {
            int readInt3 = jad_boVar.readInt();
            boolean z3 = jad_na;
            if (z3) {
                java.lang.String.format("nextIfdOffset: %d", java.lang.Integer.valueOf(readInt3));
            }
            long j5 = readInt3;
            if (j5 <= 0 || readInt3 >= jad_boVar.jad_cp) {
                if (z3) {
                    java.lang.StringBuilder sb10 = new java.lang.StringBuilder();
                    sb10.append("Stop reading file since a wrong offset may cause an infinite loop: ");
                    sb10.append(readInt3);
                    return;
                }
                return;
            }
            if (this.jad_fs.contains(java.lang.Integer.valueOf(readInt3))) {
                if (z3) {
                    java.lang.StringBuilder sb11 = new java.lang.StringBuilder();
                    sb11.append("Stop reading file since re-reading an IFD may cause an infinite loop: ");
                    sb11.append(readInt3);
                    return;
                }
                return;
            }
            jad_boVar.jad_bo(j5);
            if (this.jad_er[4].isEmpty()) {
                jad_bo(jad_boVar, 4);
            } else if (this.jad_er[5].isEmpty()) {
                jad_bo(jad_boVar, 5);
            }
        }
    }

    public final boolean jad_bo(byte[] bArr) {
        com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar = null;
        try {
            com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar2 = new com.jd.ad.sdk.jad_bo.jad_an.jad_bo(bArr);
            try {
                java.nio.ByteOrder jad_iv = jad_iv(jad_boVar2);
                this.jad_jt = jad_iv;
                jad_boVar2.jad_bo = jad_iv;
                short readShort = jad_boVar2.readShort();
                boolean z = readShort == 20306 || readShort == 21330;
                jad_boVar2.close();
                return z;
            } catch (java.lang.Exception unused) {
                jad_boVar = jad_boVar2;
                if (jad_boVar != null) {
                    jad_boVar.close();
                }
                return false;
            } catch (java.lang.Throwable th) {
                th = th;
                jad_boVar = jad_boVar2;
                if (jad_boVar != null) {
                    jad_boVar.close();
                }
                throw th;
            }
        } catch (java.lang.Exception unused2) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public final void jad_cp() {
        jad_an(0, 5);
        jad_an(0, 4);
        jad_an(5, 4);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar = this.jad_er[1].get(androidx.exifinterface.media.ExifInterface.TAG_PIXEL_X_DIMENSION);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar2 = this.jad_er[1].get(androidx.exifinterface.media.ExifInterface.TAG_PIXEL_Y_DIMENSION);
        if (jad_cpVar != null && jad_cpVar2 != null) {
            this.jad_er[0].put(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, jad_cpVar);
            this.jad_er[0].put(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, jad_cpVar2);
        }
        if (this.jad_er[4].isEmpty() && jad_an((java.util.HashMap) this.jad_er[5])) {
            java.util.HashMap<java.lang.String, com.jd.ad.sdk.jad_bo.jad_an.jad_cp>[] hashMapArr = this.jad_er;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new java.util.HashMap<>();
        }
        jad_an((java.util.HashMap) this.jad_er[4]);
    }

    public final void jad_cp(com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar) {
        if (jad_na) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getPngAttributes starting with: ");
            sb.append(jad_boVar);
        }
        jad_boVar.jad_bo = java.nio.ByteOrder.BIG_ENDIAN;
        byte[] bArr = jad_wj;
        jad_boVar.skipBytes(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = jad_boVar.readInt();
                int i = length + 4;
                byte[] bArr2 = new byte[4];
                if (jad_boVar.read(bArr2) != 4) {
                    throw new java.io.IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i2 = i + 4;
                if (i2 == 16 && !java.util.Arrays.equals(bArr2, jad_yl)) {
                    throw new java.io.IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (java.util.Arrays.equals(bArr2, jad_zm)) {
                    return;
                }
                if (java.util.Arrays.equals(bArr2, jad_xk)) {
                    byte[] bArr3 = new byte[readInt];
                    if (jad_boVar.read(bArr3) != readInt) {
                        throw new java.io.IOException("Failed to read given length for given PNG chunk type: " + jad_an(bArr2));
                    }
                    int readInt2 = jad_boVar.readInt();
                    java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == readInt2) {
                        this.jad_iv = i2;
                        jad_an(bArr3, 0);
                        jad_cp();
                        return;
                    } else {
                        throw new java.io.IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                    }
                }
                int i3 = readInt + 4;
                jad_boVar.skipBytes(i3);
                length = i2 + i3;
            } catch (java.io.EOFException unused) {
                throw new java.io.IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void jad_cp(com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar, int i) {
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar;
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar2 = this.jad_er[i].get(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar3 = this.jad_er[i].get(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH);
        if ((jad_cpVar2 == null || jad_cpVar3 == null) && (jad_cpVar = this.jad_er[i].get(androidx.exifinterface.media.ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT)) != null) {
            jad_an(jad_boVar, jad_cpVar.jad_bo(this.jad_jt), i);
        }
    }

    public final boolean jad_cp(byte[] bArr) {
        com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar = null;
        try {
            com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar2 = new com.jd.ad.sdk.jad_bo.jad_an.jad_bo(bArr);
            try {
                java.nio.ByteOrder jad_iv = jad_iv(jad_boVar2);
                this.jad_jt = jad_iv;
                jad_boVar2.jad_bo = jad_iv;
                boolean z = jad_boVar2.readShort() == 85;
                jad_boVar2.close();
                return z;
            } catch (java.lang.Exception unused) {
                jad_boVar = jad_boVar2;
                if (jad_boVar != null) {
                    jad_boVar.close();
                }
                return false;
            } catch (java.lang.Throwable th) {
                th = th;
                jad_boVar = jad_boVar2;
                if (jad_boVar != null) {
                    jad_boVar.close();
                }
                throw th;
            }
        } catch (java.lang.Exception unused2) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public final void jad_dq(com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar) {
        jad_boVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        jad_boVar.read(bArr);
        jad_boVar.skipBytes(4);
        jad_boVar.read(bArr2);
        int i = java.nio.ByteBuffer.wrap(bArr).getInt();
        int i2 = java.nio.ByteBuffer.wrap(bArr2).getInt();
        jad_an(jad_boVar, i, 5);
        jad_boVar.jad_bo(i2);
        jad_boVar.jad_bo = java.nio.ByteOrder.BIG_ENDIAN;
        int readInt = jad_boVar.readInt();
        if (jad_na) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("numberOfDirectoryEntry: ");
            sb.append(readInt);
        }
        for (int i3 = 0; i3 < readInt; i3++) {
            int readUnsignedShort = jad_boVar.readUnsignedShort();
            int readUnsignedShort2 = jad_boVar.readUnsignedShort();
            if (readUnsignedShort == jad_it.jad_an) {
                short readShort = jad_boVar.readShort();
                short readShort2 = jad_boVar.readShort();
                com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_an = com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an((int) readShort, this.jad_jt);
                com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_an2 = com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an((int) readShort2, this.jad_jt);
                this.jad_er[0].put(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, jad_an);
                this.jad_er[0].put(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, jad_an2);
                if (jad_na) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("Updated to length: ");
                    sb2.append((int) readShort);
                    sb2.append(", width: ");
                    sb2.append((int) readShort2);
                    return;
                }
                return;
            }
            jad_boVar.skipBytes(readUnsignedShort2);
        }
    }

    public final void jad_dq(com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar, int i) {
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_an;
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_an2;
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar = this.jad_er[i].get(androidx.exifinterface.media.ExifInterface.TAG_DEFAULT_CROP_SIZE);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar2 = this.jad_er[i].get(androidx.exifinterface.media.ExifInterface.TAG_RW2_SENSOR_TOP_BORDER);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar3 = this.jad_er[i].get(androidx.exifinterface.media.ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar4 = this.jad_er[i].get(androidx.exifinterface.media.ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar5 = this.jad_er[i].get(androidx.exifinterface.media.ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER);
        if (jad_cpVar != null) {
            if (jad_cpVar.jad_an == 5) {
                com.jd.ad.sdk.jad_bo.jad_an.jad_er[] jad_erVarArr = (com.jd.ad.sdk.jad_bo.jad_an.jad_er[]) jad_cpVar.jad_dq(this.jad_jt);
                if (jad_erVarArr == null || jad_erVarArr.length != 2) {
                    com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid crop size values. cropSize=").append(java.util.Arrays.toString(jad_erVarArr));
                    return;
                } else {
                    jad_an = com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(jad_erVarArr[0], this.jad_jt);
                    jad_an2 = com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(jad_erVarArr[1], this.jad_jt);
                }
            } else {
                int[] iArr = (int[]) jad_cpVar.jad_dq(this.jad_jt);
                if (iArr == null || iArr.length != 2) {
                    com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid crop size values. cropSize=").append(java.util.Arrays.toString(iArr));
                    return;
                } else {
                    jad_an = com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(iArr[0], this.jad_jt);
                    jad_an2 = com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(iArr[1], this.jad_jt);
                }
            }
            this.jad_er[i].put(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, jad_an);
            this.jad_er[i].put(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, jad_an2);
            return;
        }
        if (jad_cpVar2 == null || jad_cpVar3 == null || jad_cpVar4 == null || jad_cpVar5 == null) {
            jad_cp(jad_boVar, i);
            return;
        }
        int jad_bo2 = jad_cpVar2.jad_bo(this.jad_jt);
        int jad_bo3 = jad_cpVar4.jad_bo(this.jad_jt);
        int jad_bo4 = jad_cpVar5.jad_bo(this.jad_jt);
        int jad_bo5 = jad_cpVar3.jad_bo(this.jad_jt);
        if (jad_bo3 <= jad_bo2 || jad_bo4 <= jad_bo5) {
            return;
        }
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_an3 = com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(jad_bo3 - jad_bo2, this.jad_jt);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_an4 = com.jd.ad.sdk.jad_bo.jad_an.jad_cp.jad_an(jad_bo4 - jad_bo5, this.jad_jt);
        this.jad_er[i].put(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, jad_an3);
        this.jad_er[i].put(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, jad_an4);
    }

    public final void jad_er(com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar) {
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar;
        jad_an(jad_boVar, jad_boVar.jad_an.available());
        jad_bo(jad_boVar, 0);
        jad_dq(jad_boVar, 0);
        jad_dq(jad_boVar, 5);
        jad_dq(jad_boVar, 4);
        jad_cp();
        if (this.jad_cp != 8 || (jad_cpVar = this.jad_er[1].get(androidx.exifinterface.media.ExifInterface.TAG_MAKER_NOTE)) == null) {
            return;
        }
        com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar2 = new com.jd.ad.sdk.jad_bo.jad_an.jad_bo(jad_cpVar.jad_cp);
        jad_boVar2.jad_bo = this.jad_jt;
        jad_boVar2.jad_bo(6L);
        jad_bo(jad_boVar2, 9);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar2 = this.jad_er[9].get(androidx.exifinterface.media.ExifInterface.TAG_COLOR_SPACE);
        if (jad_cpVar2 != null) {
            this.jad_er[1].put(androidx.exifinterface.media.ExifInterface.TAG_COLOR_SPACE, jad_cpVar2);
        }
    }

    public final void jad_fs(com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar) {
        jad_er(jad_boVar);
        if (this.jad_er[0].get(androidx.exifinterface.media.ExifInterface.TAG_RW2_JPG_FROM_RAW) != null) {
            jad_an(jad_boVar, this.jad_mz, 5);
        }
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar = this.jad_er[0].get(androidx.exifinterface.media.ExifInterface.TAG_RW2_ISO);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar2 = this.jad_er[1].get(androidx.exifinterface.media.ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (jad_cpVar == null || jad_cpVar2 != null) {
            return;
        }
        this.jad_er[1].put(androidx.exifinterface.media.ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, jad_cpVar);
    }

    public final void jad_hu(com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar) {
        if (jad_na) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getWebpAttributes starting with: ");
            sb.append(jad_boVar);
        }
        jad_boVar.jad_bo = java.nio.ByteOrder.LITTLE_ENDIAN;
        jad_boVar.skipBytes(jad_cn.length);
        int readInt = jad_boVar.readInt() + 8;
        int skipBytes = jad_boVar.skipBytes(jad_do.length) + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (jad_boVar.read(bArr) != 4) {
                    throw new java.io.IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int readInt2 = jad_boVar.readInt();
                int i = skipBytes + 4 + 4;
                if (java.util.Arrays.equals(jad_ep, bArr)) {
                    byte[] bArr2 = new byte[readInt2];
                    if (jad_boVar.read(bArr2) == readInt2) {
                        this.jad_iv = i;
                        jad_an(bArr2, 0);
                        this.jad_iv = i;
                        return;
                    } else {
                        throw new java.io.IOException("Failed to read given length for given PNG chunk type: " + jad_an(bArr));
                    }
                }
                if (readInt2 % 2 == 1) {
                    readInt2++;
                }
                int i2 = i + readInt2;
                if (i2 == readInt) {
                    return;
                }
                if (i2 > readInt) {
                    throw new java.io.IOException("Encountered WebP file with invalid chunk size");
                }
                int skipBytes2 = jad_boVar.skipBytes(readInt2);
                if (skipBytes2 != readInt2) {
                    throw new java.io.IOException("Encountered WebP file with invalid chunk size");
                }
                skipBytes = i + skipBytes2;
            } catch (java.io.EOFException unused) {
                throw new java.io.IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final java.nio.ByteOrder jad_iv(com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar) {
        short readShort = jad_boVar.readShort();
        if (readShort == 18761) {
            return java.nio.ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return java.nio.ByteOrder.BIG_ENDIAN;
        }
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid byte order: ");
        jad_an.append(java.lang.Integer.toHexString(readShort));
        throw new java.io.IOException(jad_an.toString());
    }

    public final void jad_jt(com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar) {
        byte[] bArr = jad_qb;
        jad_boVar.skipBytes(bArr.length);
        byte[] bArr2 = new byte[jad_boVar.jad_an.available()];
        jad_boVar.readFully(bArr2);
        this.jad_iv = bArr.length;
        jad_an(bArr2, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void jad_jw(com.jd.ad.sdk.jad_bo.jad_an.jad_bo jad_boVar) {
        boolean z;
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar;
        int jad_bo2;
        java.util.HashMap<java.lang.String, com.jd.ad.sdk.jad_bo.jad_an.jad_cp> hashMap = this.jad_er[4];
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar2 = hashMap.get(androidx.exifinterface.media.ExifInterface.TAG_COMPRESSION);
        if (jad_cpVar2 == null) {
            jad_an(jad_boVar, hashMap);
            return;
        }
        int jad_bo3 = jad_cpVar2.jad_bo(this.jad_jt);
        if (jad_bo3 != 1) {
            if (jad_bo3 == 6) {
                jad_an(jad_boVar, hashMap);
                return;
            } else if (jad_bo3 != 7) {
                return;
            }
        }
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar3 = hashMap.get(androidx.exifinterface.media.ExifInterface.TAG_BITS_PER_SAMPLE);
        if (jad_cpVar3 != null) {
            int[] iArr = (int[]) jad_cpVar3.jad_dq(this.jad_jt);
            int[] iArr2 = jad_ob;
            if (java.util.Arrays.equals(iArr2, iArr) || (this.jad_cp == 3 && (jad_cpVar = hashMap.get(androidx.exifinterface.media.ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION)) != null && (((jad_bo2 = jad_cpVar.jad_bo(this.jad_jt)) == 1 && java.util.Arrays.equals(iArr, jad_pc)) || (jad_bo2 == 6 && java.util.Arrays.equals(iArr, iArr2))))) {
                z = true;
                if (z) {
                    return;
                }
                com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar4 = hashMap.get(androidx.exifinterface.media.ExifInterface.TAG_STRIP_OFFSETS);
                com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVar5 = hashMap.get(androidx.exifinterface.media.ExifInterface.TAG_STRIP_BYTE_COUNTS);
                if (jad_cpVar4 == null || jad_cpVar5 == null) {
                    return;
                }
                long[] jad_an = jad_an(jad_cpVar4.jad_dq(this.jad_jt));
                long[] jad_an2 = jad_an(jad_cpVar5.jad_dq(this.jad_jt));
                if (jad_an == null || jad_an.length == 0 || jad_an2 == null || jad_an2.length == 0 || jad_an.length != jad_an2.length) {
                    return;
                }
                long j = 0;
                for (long j2 : jad_an2) {
                    j += j2;
                }
                byte[] bArr = new byte[(int) j];
                this.jad_hu = true;
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < jad_an.length; i3++) {
                    int i4 = (int) jad_an[i3];
                    int i5 = (int) jad_an2[i3];
                    if (i3 < jad_an.length - 1 && i4 + i5 != jad_an[i3 + 1]) {
                        this.jad_hu = false;
                    }
                    int i6 = i4 - i;
                    jad_boVar.jad_bo(i6);
                    int i7 = i + i6;
                    byte[] bArr2 = new byte[i5];
                    jad_boVar.read(bArr2);
                    i = i7 + i5;
                    java.lang.System.arraycopy(bArr2, 0, bArr, i2, i5);
                    i2 += i5;
                }
                if (this.jad_hu) {
                    long j3 = jad_an[0];
                    return;
                }
                return;
            }
        }
        z = false;
        if (z) {
        }
    }
}
