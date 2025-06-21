package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class CopyOnWriteMultiset<E> implements java.lang.Iterable<E> {
    public final java.lang.Object n = new java.lang.Object();

    @androidx.annotation.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public final java.util.Map<E, java.lang.Integer> t = new java.util.HashMap();

    @androidx.annotation.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public java.util.Set<E> u = java.util.Collections.emptySet();

    @androidx.annotation.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public java.util.List<E> v = java.util.Collections.emptyList();

    public void add(E e) {
        synchronized (this.n) {
            java.util.ArrayList arrayList = new java.util.ArrayList(this.v);
            arrayList.add(e);
            this.v = java.util.Collections.unmodifiableList(arrayList);
            java.lang.Integer num = this.t.get(e);
            if (num == null) {
                java.util.HashSet hashSet = new java.util.HashSet(this.u);
                hashSet.add(e);
                this.u = java.util.Collections.unmodifiableSet(hashSet);
            }
            this.t.put(e, java.lang.Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    public java.util.Set<E> elementSet() {
        java.util.Set<E> set;
        synchronized (this.n) {
            set = this.u;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<E> iterator() {
        java.util.Iterator<E> it;
        synchronized (this.n) {
            it = this.v.iterator();
        }
        return it;
    }

    public void remove(E e) {
        synchronized (this.n) {
            java.lang.Integer num = this.t.get(e);
            if (num == null) {
                return;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(this.v);
            arrayList.remove(e);
            this.v = java.util.Collections.unmodifiableList(arrayList);
            if (num.intValue() == 1) {
                this.t.remove(e);
                java.util.HashSet hashSet = new java.util.HashSet(this.u);
                hashSet.remove(e);
                this.u = java.util.Collections.unmodifiableSet(hashSet);
            } else {
                this.t.put(e, java.lang.Integer.valueOf(num.intValue() - 1));
            }
        }
    }
}
