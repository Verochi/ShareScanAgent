package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class v {
    private final java.lang.Object a = new java.lang.Object();
    private final java.util.PriorityQueue<java.lang.Integer> b = new java.util.PriorityQueue<>(10, java.util.Collections.reverseOrder());
    private int c = Integer.MIN_VALUE;

    public static class a extends java.io.IOException {
        public a(int i, int i2) {
            super("Priority too low [priority=" + i + ", highest=" + i2 + "]");
        }
    }

    private boolean b(int i) {
        boolean z;
        synchronized (this.a) {
            z = this.c == i;
        }
        return z;
    }

    public final void a() {
        synchronized (this.a) {
            this.b.add(0);
            this.c = java.lang.Math.max(this.c, 0);
        }
    }

    public final void a(int i) {
        synchronized (this.a) {
            if (this.c != i) {
                throw new com.anythink.expressad.exoplayer.k.v.a(i, this.c);
            }
        }
    }

    public final void b() {
        synchronized (this.a) {
            while (this.c != 0) {
                this.a.wait();
            }
        }
    }

    public final void c() {
        synchronized (this.a) {
            this.b.remove(0);
            this.c = this.b.isEmpty() ? Integer.MIN_VALUE : this.b.peek().intValue();
            this.a.notifyAll();
        }
    }
}
