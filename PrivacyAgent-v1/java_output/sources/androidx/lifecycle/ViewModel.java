package androidx.lifecycle;

/* loaded from: classes.dex */
public abstract class ViewModel {

    @androidx.annotation.Nullable
    private final java.util.Map<java.lang.String, java.lang.Object> mBagOfTags = new java.util.HashMap();
    private volatile boolean mCleared = false;

    private static void closeWithRuntimeException(java.lang.Object obj) {
        if (obj instanceof java.io.Closeable) {
            try {
                ((java.io.Closeable) obj).close();
            } catch (java.io.IOException e) {
                throw new java.lang.RuntimeException(e);
            }
        }
    }

    @androidx.annotation.MainThread
    final void clear() {
        this.mCleared = true;
        java.util.Map<java.lang.String, java.lang.Object> map = this.mBagOfTags;
        if (map != null) {
            synchronized (map) {
                java.util.Iterator<java.lang.Object> it = this.mBagOfTags.values().iterator();
                while (it.hasNext()) {
                    closeWithRuntimeException(it.next());
                }
            }
        }
        onCleared();
    }

    public <T> T getTag(java.lang.String str) {
        T t;
        java.util.Map<java.lang.String, java.lang.Object> map = this.mBagOfTags;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = (T) this.mBagOfTags.get(str);
        }
        return t;
    }

    public void onCleared() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T setTagIfAbsent(java.lang.String str, T t) {
        java.lang.Object obj;
        synchronized (this.mBagOfTags) {
            obj = this.mBagOfTags.get(str);
            if (obj == 0) {
                this.mBagOfTags.put(str, t);
            }
        }
        if (obj != 0) {
            t = obj;
        }
        if (this.mCleared) {
            closeWithRuntimeException(t);
        }
        return t;
    }
}
