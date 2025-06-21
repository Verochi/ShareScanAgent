package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public interface BandwidthMeter {

    public interface EventListener {

        public static final class EventDispatcher {
            public final java.util.concurrent.CopyOnWriteArrayList<com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener> a = new java.util.concurrent.CopyOnWriteArrayList<>();

            public static final class HandlerAndListener {
                public final android.os.Handler a;
                public final com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener b;
                public boolean c;

                public HandlerAndListener(android.os.Handler handler, com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener eventListener) {
                    this.a = handler;
                    this.b = eventListener;
                }

                public void d() {
                    this.c = true;
                }
            }

            public static /* synthetic */ void b(com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener handlerAndListener, int i, long j, long j2) {
                handlerAndListener.b.onBandwidthSample(i, j, j2);
            }

            public void addListener(android.os.Handler handler, com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener eventListener) {
                com.google.android.exoplayer2.util.Assertions.checkNotNull(handler);
                com.google.android.exoplayer2.util.Assertions.checkNotNull(eventListener);
                removeListener(eventListener);
                this.a.add(new com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener(handler, eventListener));
            }

            public void bandwidthSample(int i, long j, long j2) {
                java.util.Iterator<com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener> it = this.a.iterator();
                while (it.hasNext()) {
                    com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener next = it.next();
                    if (!next.c) {
                        next.a.post(new com.google.android.exoplayer2.upstream.a(next, i, j, j2));
                    }
                }
            }

            public void removeListener(com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener eventListener) {
                java.util.Iterator<com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener> it = this.a.iterator();
                while (it.hasNext()) {
                    com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener next = it.next();
                    if (next.b == eventListener) {
                        next.d();
                        this.a.remove(next);
                    }
                }
            }
        }

        void onBandwidthSample(int i, long j, long j2);
    }

    void addEventListener(android.os.Handler handler, com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener eventListener);

    long getBitrateEstimate();

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.upstream.TransferListener getTransferListener();

    void removeEventListener(com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener eventListener);
}
