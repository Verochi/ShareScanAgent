package com.bumptech.glide.util.pool;

/* loaded from: classes.dex */
public abstract class StateVerifier {
    private static final boolean DEBUG = false;

    public static class DebugStateVerifier extends com.bumptech.glide.util.pool.StateVerifier {
        private volatile java.lang.RuntimeException recycledAtStackTraceException;

        public DebugStateVerifier() {
            super(null);
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean z) {
            if (z) {
                this.recycledAtStackTraceException = new java.lang.RuntimeException("Released");
            } else {
                this.recycledAtStackTraceException = null;
            }
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.recycledAtStackTraceException != null) {
                throw new java.lang.IllegalStateException("Already released", this.recycledAtStackTraceException);
            }
        }
    }

    public static class DefaultStateVerifier extends com.bumptech.glide.util.pool.StateVerifier {
        private volatile boolean isReleased;

        public DefaultStateVerifier() {
            super(null);
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean z) {
            this.isReleased = z;
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.isReleased) {
                throw new java.lang.IllegalStateException("Already released");
            }
        }
    }

    private StateVerifier() {
    }

    public /* synthetic */ StateVerifier(com.bumptech.glide.util.pool.StateVerifier.AnonymousClass1 anonymousClass1) {
        this();
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.util.pool.StateVerifier newInstance() {
        return new com.bumptech.glide.util.pool.StateVerifier.DefaultStateVerifier();
    }

    public abstract void setRecycled(boolean z);

    public abstract void throwIfRecycled();
}
