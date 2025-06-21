package com.commonsware.cwac.netsecurity.config;

/* loaded from: classes22.dex */
public final class PinSet {
    public static final com.commonsware.cwac.netsecurity.config.PinSet EMPTY_PINSET = new com.commonsware.cwac.netsecurity.config.PinSet(java.util.Collections.emptySet(), Long.MAX_VALUE);
    public final long expirationTime;
    public final java.util.Set<com.commonsware.cwac.netsecurity.config.Pin> pins;

    public PinSet(java.util.Set<com.commonsware.cwac.netsecurity.config.Pin> set, long j) {
        if (set == null) {
            throw new java.lang.NullPointerException("pins must not be null");
        }
        this.pins = set;
        this.expirationTime = j;
    }

    public java.util.Set<java.lang.String> getPinAlgorithms() {
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator<com.commonsware.cwac.netsecurity.config.Pin> it = this.pins.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().digestAlgorithm);
        }
        return hashSet;
    }
}
