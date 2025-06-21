package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class UdpDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource {
    public static final int DEFAULT_MAX_PACKET_SIZE = 2000;
    public static final int DEFAULT_SOCKET_TIMEOUT_MILLIS = 8000;
    public final int e;
    public final byte[] f;
    public final java.net.DatagramPacket g;

    @androidx.annotation.Nullable
    public android.net.Uri h;

    @androidx.annotation.Nullable
    public java.net.DatagramSocket i;

    @androidx.annotation.Nullable
    public java.net.MulticastSocket j;

    @androidx.annotation.Nullable
    public java.net.InetAddress k;

    @androidx.annotation.Nullable
    public java.net.InetSocketAddress l;
    public boolean m;
    public int n;

    public static final class UdpDataSourceException extends java.io.IOException {
        public UdpDataSourceException(java.io.IOException iOException) {
            super(iOException);
        }
    }

    public UdpDataSource() {
        this(2000);
    }

    public UdpDataSource(int i) {
        this(i, 8000);
    }

    public UdpDataSource(int i, int i2) {
        super(true);
        this.e = i2;
        byte[] bArr = new byte[i];
        this.f = bArr;
        this.g = new java.net.DatagramPacket(bArr, 0, i);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.h = null;
        java.net.MulticastSocket multicastSocket = this.j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(this.k);
            } catch (java.io.IOException unused) {
            }
            this.j = null;
        }
        java.net.DatagramSocket datagramSocket = this.i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.i = null;
        }
        this.k = null;
        this.l = null;
        this.n = 0;
        if (this.m) {
            this.m = false;
            transferEnded();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @androidx.annotation.Nullable
    public android.net.Uri getUri() {
        return this.h;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws com.google.android.exoplayer2.upstream.UdpDataSource.UdpDataSourceException {
        android.net.Uri uri = dataSpec.uri;
        this.h = uri;
        java.lang.String host = uri.getHost();
        int port = this.h.getPort();
        transferInitializing(dataSpec);
        try {
            this.k = java.net.InetAddress.getByName(host);
            this.l = new java.net.InetSocketAddress(this.k, port);
            if (this.k.isMulticastAddress()) {
                java.net.MulticastSocket multicastSocket = new java.net.MulticastSocket(this.l);
                this.j = multicastSocket;
                multicastSocket.joinGroup(this.k);
                this.i = this.j;
            } else {
                this.i = new java.net.DatagramSocket(this.l);
            }
            try {
                this.i.setSoTimeout(this.e);
                this.m = true;
                transferStarted(dataSpec);
                return -1L;
            } catch (java.net.SocketException e) {
                throw new com.google.android.exoplayer2.upstream.UdpDataSource.UdpDataSourceException(e);
            }
        } catch (java.io.IOException e2) {
            throw new com.google.android.exoplayer2.upstream.UdpDataSource.UdpDataSourceException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws com.google.android.exoplayer2.upstream.UdpDataSource.UdpDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        if (this.n == 0) {
            try {
                this.i.receive(this.g);
                int length = this.g.getLength();
                this.n = length;
                bytesTransferred(length);
            } catch (java.io.IOException e) {
                throw new com.google.android.exoplayer2.upstream.UdpDataSource.UdpDataSourceException(e);
            }
        }
        int length2 = this.g.getLength();
        int i3 = this.n;
        int min = java.lang.Math.min(i3, i2);
        java.lang.System.arraycopy(this.f, length2 - i3, bArr, i, min);
        this.n -= min;
        return min;
    }
}
