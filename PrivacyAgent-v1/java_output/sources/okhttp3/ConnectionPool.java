package okhttp3;

/* loaded from: classes23.dex */
public final class ConnectionPool {
    public final okhttp3.internal.connection.RealConnectionPool a;

    public ConnectionPool() {
        this(5, 5L, java.util.concurrent.TimeUnit.MINUTES);
    }

    public ConnectionPool(int i, long j, java.util.concurrent.TimeUnit timeUnit) {
        this.a = new okhttp3.internal.connection.RealConnectionPool(i, j, timeUnit);
    }

    public int connectionCount() {
        return this.a.connectionCount();
    }

    public void evictAll() {
        this.a.evictAll();
    }

    public int idleConnectionCount() {
        return this.a.idleConnectionCount();
    }
}
