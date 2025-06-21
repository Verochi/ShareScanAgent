package okhttp3.internal.connection;

/* loaded from: classes23.dex */
final class RouteDatabase {
    public final java.util.Set<okhttp3.Route> a = new java.util.LinkedHashSet();

    public synchronized void a(okhttp3.Route route) {
        this.a.remove(route);
    }

    public synchronized void b(okhttp3.Route route) {
        this.a.add(route);
    }

    public synchronized boolean c(okhttp3.Route route) {
        return this.a.contains(route);
    }
}
