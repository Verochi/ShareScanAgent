package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final class PlayerMessage {
    public final com.google.android.exoplayer2.PlayerMessage.Target a;
    public final com.google.android.exoplayer2.PlayerMessage.Sender b;
    public final com.google.android.exoplayer2.Timeline c;
    public int d;

    @androidx.annotation.Nullable
    public java.lang.Object e;
    public android.os.Handler f;
    public int g;
    public long h = -9223372036854775807L;
    public boolean i = true;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;

    public interface Sender {
        void sendMessage(com.google.android.exoplayer2.PlayerMessage playerMessage);
    }

    public interface Target {
        void handleMessage(int i, @androidx.annotation.Nullable java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException;
    }

    public PlayerMessage(com.google.android.exoplayer2.PlayerMessage.Sender sender, com.google.android.exoplayer2.PlayerMessage.Target target, com.google.android.exoplayer2.Timeline timeline, int i, android.os.Handler handler) {
        this.b = sender;
        this.a = target;
        this.c = timeline;
        this.f = handler;
        this.g = i;
    }

    @androidx.annotation.VisibleForTesting
    public synchronized boolean a(long j, com.google.android.exoplayer2.util.Clock clock) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        boolean z;
        com.google.android.exoplayer2.util.Assertions.checkState(this.j);
        com.google.android.exoplayer2.util.Assertions.checkState(this.f.getLooper().getThread() != java.lang.Thread.currentThread());
        long elapsedRealtime = clock.elapsedRealtime() + j;
        while (true) {
            z = this.l;
            if (z || j <= 0) {
                break;
            }
            wait(j);
            j = elapsedRealtime - clock.elapsedRealtime();
        }
        if (!z) {
            throw new java.util.concurrent.TimeoutException("Message delivery timed out.");
        }
        return this.k;
    }

    public synchronized boolean blockUntilDelivered() throws java.lang.InterruptedException {
        com.google.android.exoplayer2.util.Assertions.checkState(this.j);
        com.google.android.exoplayer2.util.Assertions.checkState(this.f.getLooper().getThread() != java.lang.Thread.currentThread());
        while (!this.l) {
            wait();
        }
        return this.k;
    }

    public synchronized com.google.android.exoplayer2.PlayerMessage cancel() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.j);
        this.m = true;
        markAsProcessed(false);
        return this;
    }

    public synchronized boolean experimentalBlockUntilDelivered(long j) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        return a(j, com.google.android.exoplayer2.util.Clock.DEFAULT);
    }

    public boolean getDeleteAfterDelivery() {
        return this.i;
    }

    public android.os.Handler getHandler() {
        return this.f;
    }

    @androidx.annotation.Nullable
    public java.lang.Object getPayload() {
        return this.e;
    }

    public long getPositionMs() {
        return this.h;
    }

    public com.google.android.exoplayer2.PlayerMessage.Target getTarget() {
        return this.a;
    }

    public com.google.android.exoplayer2.Timeline getTimeline() {
        return this.c;
    }

    public int getType() {
        return this.d;
    }

    public int getWindowIndex() {
        return this.g;
    }

    public synchronized boolean isCanceled() {
        return this.m;
    }

    public synchronized void markAsProcessed(boolean z) {
        this.k = z | this.k;
        this.l = true;
        notifyAll();
    }

    public com.google.android.exoplayer2.PlayerMessage send() {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        if (this.h == -9223372036854775807L) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(this.i);
        }
        this.j = true;
        this.b.sendMessage(this);
        return this;
    }

    public com.google.android.exoplayer2.PlayerMessage setDeleteAfterDelivery(boolean z) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        this.i = z;
        return this;
    }

    public com.google.android.exoplayer2.PlayerMessage setHandler(android.os.Handler handler) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        this.f = handler;
        return this;
    }

    public com.google.android.exoplayer2.PlayerMessage setPayload(@androidx.annotation.Nullable java.lang.Object obj) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        this.e = obj;
        return this;
    }

    public com.google.android.exoplayer2.PlayerMessage setPosition(int i, long j) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        com.google.android.exoplayer2.util.Assertions.checkArgument(j != -9223372036854775807L);
        if (i < 0 || (!this.c.isEmpty() && i >= this.c.getWindowCount())) {
            throw new com.google.android.exoplayer2.IllegalSeekPositionException(this.c, i, j);
        }
        this.g = i;
        this.h = j;
        return this;
    }

    public com.google.android.exoplayer2.PlayerMessage setPosition(long j) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        this.h = j;
        return this;
    }

    public com.google.android.exoplayer2.PlayerMessage setType(int i) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
        this.d = i;
        return this;
    }
}
