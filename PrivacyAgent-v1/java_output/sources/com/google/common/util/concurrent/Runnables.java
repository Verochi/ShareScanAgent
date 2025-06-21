package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class Runnables {
    public static final java.lang.Runnable a = new com.google.common.util.concurrent.Runnables.AnonymousClass1();

    /* renamed from: com.google.common.util.concurrent.Runnables$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public static java.lang.Runnable doNothing() {
        return a;
    }
}
