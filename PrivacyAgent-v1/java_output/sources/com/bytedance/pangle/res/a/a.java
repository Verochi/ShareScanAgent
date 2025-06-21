package com.bytedance.pangle.res.a;

/* loaded from: classes.dex */
public class a {
    private static final java.util.logging.Logger f = java.util.logging.Logger.getLogger(com.bytedance.pangle.res.a.a.class.getName());
    private final byte[] a;
    private final com.bytedance.pangle.res.a.h b;
    private final com.bytedance.pangle.res.a.g c;
    private final com.bytedance.pangle.res.a.e d;
    private com.bytedance.pangle.res.a.a.C0272a e;

    /* renamed from: com.bytedance.pangle.res.a.a$a, reason: collision with other inner class name */
    public static class C0272a {
        public final short a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        private C0272a(short s2, int i, int i2, int i3) {
            this.a = s2;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i3 + i2;
        }

        public static com.bytedance.pangle.res.a.a.C0272a a(com.bytedance.pangle.res.a.g gVar, com.bytedance.pangle.res.a.e eVar) {
            int a = eVar.a();
            try {
                return new com.bytedance.pangle.res.a.a.C0272a(gVar.readShort(), gVar.readShort(), gVar.readInt(), a);
            } catch (java.io.EOFException unused) {
                return new com.bytedance.pangle.res.a.a.C0272a((short) -1, 0, 0, eVar.a());
            }
        }
    }

    public a(byte[] bArr, com.bytedance.pangle.res.a.h hVar) {
        com.bytedance.pangle.res.a.e eVar = new com.bytedance.pangle.res.a.e(new java.io.ByteArrayInputStream(bArr));
        this.d = eVar;
        this.c = new com.bytedance.pangle.res.a.g(new com.bytedance.pangle.res.a.i(eVar));
        this.a = bArr;
        this.b = hVar;
    }

    private java.lang.String a(int i) {
        int i2;
        short s2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(16);
        while (true) {
            i2 = i - 1;
            if (i == 0 || this.c.readByte() == 0) {
                break;
            }
            sb.append((char) s2);
            i = i2;
        }
        this.c.skipBytes(i2);
        return sb.toString();
    }

    private void b() {
        b(com.badlogic.gdx.graphics.GL20.GL_LEQUAL);
        int readInt = this.c.readInt();
        for (int i = 0; i < readInt; i++) {
            this.c.readInt();
            this.c.skipBytes(256);
        }
        while (j().a == 513) {
            c();
        }
    }

    private void b(int i) {
        if (this.e.a != i) {
            throw new java.lang.RuntimeException(java.lang.String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", java.lang.Integer.valueOf(i), java.lang.Short.valueOf(this.e.a)));
        }
    }

    private void c() {
        d();
        short s2 = j().a;
        while (s2 == 514) {
            d();
            s2 = j().a;
        }
        while (s2 == 513) {
            e();
            if (this.d.a() < this.e.e) {
                f.warning("Unknown data detected. Skipping: " + (this.e.e - this.d.a()) + " byte(s)");
                com.bytedance.pangle.res.a.e eVar = this.d;
                eVar.skip((long) (this.e.e - eVar.a()));
            }
            s2 = j().a;
        }
    }

    private void d() {
        b(com.badlogic.gdx.graphics.GL20.GL_EQUAL);
        this.c.readUnsignedByte();
        this.c.skipBytes(3);
        this.c.skipBytes(this.c.readInt() * 4);
    }

    private void e() {
        b(513);
        this.c.readUnsignedByte();
        this.c.readByte();
        this.c.skipBytes(2);
        int readInt = this.c.readInt();
        int readInt2 = this.c.readInt();
        i();
        int i = (this.e.d + readInt2) - (readInt * 4);
        if (i != this.d.a()) {
            f.warning("Invalid data detected. Skipping: " + (i - this.d.a()) + " byte(s)");
            this.c.skipBytes(i - this.d.a());
        }
        int[] a = this.c.a(readInt);
        java.util.HashSet hashSet = new java.util.HashSet();
        for (int i2 : a) {
            if (i2 != -1 && !hashSet.contains(java.lang.Integer.valueOf(i2))) {
                f();
                hashSet.add(java.lang.Integer.valueOf(i2));
            }
        }
    }

    private void f() {
        if (this.c.readShort() < 0) {
            throw new java.lang.RuntimeException("Entry size is under 0 bytes.");
        }
        short readShort = this.c.readShort();
        this.c.readInt();
        if ((readShort & 1) == 0) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        int a = com.bytedance.pangle.res.a.k.a(this.c);
        com.bytedance.pangle.res.a.k.a(this.a, this.c.readInt(), a, this.b);
        int readInt = this.c.readInt();
        for (int i = 0; i < readInt; i++) {
            int a2 = com.bytedance.pangle.res.a.k.a(this.c);
            com.bytedance.pangle.res.a.k.a(this.a, this.c.readInt(), a2, this.b);
            h();
        }
    }

    private void h() {
        this.c.a();
        this.c.b();
        byte readByte = this.c.readByte();
        int a = com.bytedance.pangle.res.a.k.a(this.c);
        int readInt = this.c.readInt();
        if (readByte == 1) {
            com.bytedance.pangle.res.a.k.a(this.a, readInt, a, this.b);
        }
        if (readByte == 2) {
            com.bytedance.pangle.res.a.k.a(this.a, readInt, a, this.b);
        }
    }

    private void i() {
        int readInt = this.c.readInt();
        int i = 28;
        if (readInt < 28) {
            throw new java.lang.RuntimeException("Config size < 28");
        }
        this.c.readShort();
        this.c.readShort();
        this.c.readByte();
        this.c.readByte();
        this.c.readByte();
        this.c.readByte();
        this.c.readByte();
        this.c.readByte();
        this.c.readUnsignedShort();
        this.c.readByte();
        this.c.readByte();
        this.c.readByte();
        this.c.skipBytes(1);
        this.c.readShort();
        this.c.readShort();
        this.c.readShort();
        this.c.skipBytes(2);
        if (readInt >= 32) {
            this.c.readByte();
            this.c.readByte();
            this.c.readShort();
            i = 32;
        }
        if (readInt >= 36) {
            this.c.readShort();
            this.c.readShort();
            i = 36;
        }
        if (readInt >= 48) {
            a(4).toCharArray();
            a(8).toCharArray();
            i = 48;
        }
        if (readInt >= 52) {
            this.c.readByte();
            this.c.readByte();
            this.c.skipBytes(2);
            i = 52;
        }
        if (readInt >= 56) {
            this.c.skipBytes(4);
            i = 56;
        }
        int i2 = readInt - 56;
        if (i2 > 0) {
            byte[] bArr = new byte[i2];
            i += i2;
            this.c.readFully(bArr);
            java.math.BigInteger bigInteger = new java.math.BigInteger(1, bArr);
            if (bigInteger.equals(java.math.BigInteger.ZERO)) {
                f.fine(java.lang.String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
            } else {
                f.warning(java.lang.String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, java.lang.Integer.valueOf(readInt), bigInteger));
            }
        }
        int i3 = readInt - i;
        if (i3 > 0) {
            this.c.skipBytes(i3);
        }
    }

    private com.bytedance.pangle.res.a.a.C0272a j() {
        com.bytedance.pangle.res.a.a.C0272a a = com.bytedance.pangle.res.a.a.C0272a.a(this.c, this.d);
        this.e = a;
        return a;
    }

    public final void a() {
        j();
        b(2);
        int readInt = this.c.readInt();
        com.bytedance.pangle.res.a.l.a(this.c);
        j();
        for (int i = 0; i < readInt; i++) {
            b(512);
            this.c.readInt();
            this.c.skipBytes(256);
            this.c.skipBytes(4);
            this.c.skipBytes(4);
            this.c.skipBytes(4);
            this.c.skipBytes(4);
            if (this.e.b == 288 && this.c.readInt() > 0) {
                throw new java.lang.RuntimeException("don't support");
            }
            com.bytedance.pangle.res.a.l.a(this.c);
            com.bytedance.pangle.res.a.l.a(this.c);
            j();
            boolean z = true;
            while (z) {
                short s2 = this.e.a;
                if (s2 == 514) {
                    c();
                } else if (s2 != 515) {
                    z = false;
                } else {
                    b();
                }
            }
        }
    }
}
