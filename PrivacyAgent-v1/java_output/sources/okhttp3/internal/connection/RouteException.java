package okhttp3.internal.connection;

/* loaded from: classes23.dex */
public final class RouteException extends java.lang.RuntimeException {
    private java.io.IOException firstException;
    private java.io.IOException lastException;

    public RouteException(java.io.IOException iOException) {
        super(iOException);
        this.firstException = iOException;
        this.lastException = iOException;
    }

    public void addConnectException(java.io.IOException iOException) {
        okhttp3.internal.Util.addSuppressedIfPossible(this.firstException, iOException);
        this.lastException = iOException;
    }

    public java.io.IOException getFirstConnectException() {
        return this.firstException;
    }

    public java.io.IOException getLastConnectException() {
        return this.lastException;
    }
}
