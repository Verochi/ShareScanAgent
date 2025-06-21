package androidx.core.net;

/* loaded from: classes.dex */
class DatagramSocketWrapper extends java.net.Socket {

    public static class DatagramSocketImplWrapper extends java.net.SocketImpl {
        public DatagramSocketImplWrapper(java.net.DatagramSocket datagramSocket, java.io.FileDescriptor fileDescriptor) {
            ((java.net.SocketImpl) this).localport = datagramSocket.getLocalPort();
            ((java.net.SocketImpl) this).fd = fileDescriptor;
        }

        @Override // java.net.SocketImpl
        public void accept(java.net.SocketImpl socketImpl) throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public int available() throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public void bind(java.net.InetAddress inetAddress, int i) throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public void close() throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public void connect(java.lang.String str, int i) throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public void connect(java.net.InetAddress inetAddress, int i) throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public void connect(java.net.SocketAddress socketAddress, int i) throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public void create(boolean z) throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public java.io.InputStream getInputStream() throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.net.SocketOptions
        public java.lang.Object getOption(int i) throws java.net.SocketException {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public java.io.OutputStream getOutputStream() throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public void listen(int i) throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.net.SocketImpl
        public void sendUrgentData(int i) throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.net.SocketOptions
        public void setOption(int i, java.lang.Object obj) throws java.net.SocketException {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public DatagramSocketWrapper(java.net.DatagramSocket datagramSocket, java.io.FileDescriptor fileDescriptor) throws java.net.SocketException {
        super(new androidx.core.net.DatagramSocketWrapper.DatagramSocketImplWrapper(datagramSocket, fileDescriptor));
    }
}
