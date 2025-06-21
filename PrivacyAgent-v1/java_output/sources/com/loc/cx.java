package com.loc;

/* loaded from: classes23.dex */
public abstract class cx {
    com.loc.cz a;
    private java.nio.ByteBuffer b;

    public cx(int i) {
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(i);
        this.b = allocate;
        allocate.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        this.a = new com.loc.cz(this.b);
    }

    public final com.loc.cx a() {
        this.a.a(this.b);
        return this;
    }
}
