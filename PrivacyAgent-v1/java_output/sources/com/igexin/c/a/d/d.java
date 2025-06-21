package com.igexin.c.a.d;

/* loaded from: classes22.dex */
public final class d {
    private final java.util.concurrent.ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> a;
    private final java.util.concurrent.ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> b;
    private java.util.concurrent.ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> c;

    public d() {
        java.util.concurrent.ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> concurrentLinkedQueue = new java.util.concurrent.ConcurrentLinkedQueue<>();
        this.a = concurrentLinkedQueue;
        this.b = new java.util.concurrent.ConcurrentLinkedQueue<>();
        this.c = concurrentLinkedQueue;
    }

    private synchronized java.util.Iterator<com.igexin.c.a.d.a.e> e() {
        return this.c.iterator();
    }

    public final synchronized void a() {
        this.c = this.a;
    }

    public final synchronized void a(com.igexin.c.a.d.a.e eVar) {
        this.c.offer(eVar);
    }

    public final synchronized void b() {
        java.util.concurrent.ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> concurrentLinkedQueue = this.b;
        this.c = concurrentLinkedQueue;
        concurrentLinkedQueue.addAll(this.a);
        this.a.clear();
    }

    public final synchronized boolean c() {
        return this.c.isEmpty();
    }

    public final synchronized com.igexin.c.a.d.a.e d() {
        return this.c.poll();
    }
}
