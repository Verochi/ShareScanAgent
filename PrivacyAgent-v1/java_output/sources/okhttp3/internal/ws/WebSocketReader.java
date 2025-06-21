package okhttp3.internal.ws;

/* loaded from: classes24.dex */
final class WebSocketReader {
    public final boolean a;
    public final okio.BufferedSource b;
    public final okhttp3.internal.ws.WebSocketReader.FrameCallback c;
    public boolean d;
    public int e;
    public long f;
    public boolean g;
    public boolean h;
    public final okio.Buffer i = new okio.Buffer();
    public final okio.Buffer j = new okio.Buffer();
    public final byte[] k;
    public final okio.Buffer.UnsafeCursor l;

    public interface FrameCallback {
        void onReadClose(int i, java.lang.String str);

        void onReadMessage(java.lang.String str) throws java.io.IOException;

        void onReadMessage(okio.ByteString byteString) throws java.io.IOException;

        void onReadPing(okio.ByteString byteString);

        void onReadPong(okio.ByteString byteString);
    }

    public WebSocketReader(boolean z, okio.BufferedSource bufferedSource, okhttp3.internal.ws.WebSocketReader.FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new java.lang.NullPointerException("source == null");
        }
        if (frameCallback == null) {
            throw new java.lang.NullPointerException("frameCallback == null");
        }
        this.a = z;
        this.b = bufferedSource;
        this.c = frameCallback;
        this.k = z ? null : new byte[4];
        this.l = z ? null : new okio.Buffer.UnsafeCursor();
    }

    public void a() throws java.io.IOException {
        c();
        if (this.h) {
            b();
        } else {
            e();
        }
    }

    public final void b() throws java.io.IOException {
        short s2;
        java.lang.String str;
        long j = this.f;
        if (j > 0) {
            this.b.readFully(this.i, j);
            if (!this.a) {
                this.i.readAndWriteUnsafe(this.l);
                this.l.seek(0L);
                okhttp3.internal.ws.WebSocketProtocol.b(this.l, this.k);
                this.l.close();
            }
        }
        switch (this.e) {
            case 8:
                long size = this.i.size();
                if (size == 1) {
                    throw new java.net.ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    s2 = this.i.readShort();
                    str = this.i.readUtf8();
                    java.lang.String a = okhttp3.internal.ws.WebSocketProtocol.a(s2);
                    if (a != null) {
                        throw new java.net.ProtocolException(a);
                    }
                } else {
                    s2 = 1005;
                    str = "";
                }
                this.c.onReadClose(s2, str);
                this.d = true;
                return;
            case 9:
                this.c.onReadPing(this.i.readByteString());
                return;
            case 10:
                this.c.onReadPong(this.i.readByteString());
                return;
            default:
                throw new java.net.ProtocolException("Unknown control opcode: " + java.lang.Integer.toHexString(this.e));
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void c() throws java.io.IOException {
        if (this.d) {
            throw new java.io.IOException("closed");
        }
        long timeoutNanos = this.b.timeout().timeoutNanos();
        this.b.timeout().clearTimeout();
        try {
            int readByte = this.b.readByte() & 255;
            this.b.timeout().timeout(timeoutNanos, java.util.concurrent.TimeUnit.NANOSECONDS);
            this.e = readByte & 15;
            boolean z = (readByte & 128) != 0;
            this.g = z;
            boolean z2 = (readByte & 8) != 0;
            this.h = z2;
            if (z2 && !z) {
                throw new java.net.ProtocolException("Control frames must be final.");
            }
            boolean z3 = (readByte & 64) != 0;
            boolean z4 = (readByte & 32) != 0;
            boolean z5 = (readByte & 16) != 0;
            if (z3 || z4 || z5) {
                throw new java.net.ProtocolException("Reserved flags are unsupported.");
            }
            int readByte2 = this.b.readByte() & 255;
            boolean z6 = (readByte2 & 128) != 0;
            if (z6 == this.a) {
                throw new java.net.ProtocolException(this.a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = readByte2 & 127;
            this.f = j;
            if (j == 126) {
                this.f = this.b.readShort() & 65535;
            } else if (j == 127) {
                long readLong = this.b.readLong();
                this.f = readLong;
                if (readLong < 0) {
                    throw new java.net.ProtocolException("Frame length 0x" + java.lang.Long.toHexString(this.f) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.h && this.f > 125) {
                throw new java.net.ProtocolException("Control frame must be less than 125B.");
            }
            if (z6) {
                this.b.readFully(this.k);
            }
        } catch (java.lang.Throwable th) {
            this.b.timeout().timeout(timeoutNanos, java.util.concurrent.TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    public final void d() throws java.io.IOException {
        while (!this.d) {
            long j = this.f;
            if (j > 0) {
                this.b.readFully(this.j, j);
                if (!this.a) {
                    this.j.readAndWriteUnsafe(this.l);
                    this.l.seek(this.j.size() - this.f);
                    okhttp3.internal.ws.WebSocketProtocol.b(this.l, this.k);
                    this.l.close();
                }
            }
            if (this.g) {
                return;
            }
            f();
            if (this.e != 0) {
                throw new java.net.ProtocolException("Expected continuation opcode. Got: " + java.lang.Integer.toHexString(this.e));
            }
        }
        throw new java.io.IOException("closed");
    }

    public final void e() throws java.io.IOException {
        int i = this.e;
        if (i != 1 && i != 2) {
            throw new java.net.ProtocolException("Unknown opcode: " + java.lang.Integer.toHexString(i));
        }
        d();
        if (i == 1) {
            this.c.onReadMessage(this.j.readUtf8());
        } else {
            this.c.onReadMessage(this.j.readByteString());
        }
    }

    public final void f() throws java.io.IOException {
        while (!this.d) {
            c();
            if (!this.h) {
                return;
            } else {
                b();
            }
        }
    }
}
