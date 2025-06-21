package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class IdentityStack<E> extends java.util.Stack<E> {
    private static final long serialVersionUID = -5555522620060077046L;

    public IdentityStack() {
    }

    public IdentityStack(E e) {
        push(e);
    }

    public static <E> org.apache.tools.ant.util.IdentityStack<E> getInstance(java.util.Stack<E> stack) {
        if (stack instanceof org.apache.tools.ant.util.IdentityStack) {
            return (org.apache.tools.ant.util.IdentityStack) stack;
        }
        org.apache.tools.ant.util.IdentityStack<E> identityStack = new org.apache.tools.ant.util.IdentityStack<>();
        if (stack != null) {
            identityStack.addAll(stack);
        }
        return identityStack;
    }

    @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
    public synchronized boolean contains(java.lang.Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
    public synchronized boolean containsAll(java.util.Collection<?> collection) {
        java.util.IdentityHashMap identityHashMap;
        identityHashMap = new java.util.IdentityHashMap();
        java.util.Iterator<E> it = iterator();
        while (it.hasNext()) {
            identityHashMap.put(it.next(), java.lang.Boolean.TRUE);
        }
        return identityHashMap.keySet().containsAll(collection);
    }

    @Override // java.util.Vector
    public synchronized int indexOf(java.lang.Object obj, int i) {
        int size = size();
        while (i < size) {
            if (get(i) == obj) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // java.util.Vector
    public synchronized int lastIndexOf(java.lang.Object obj, int i) {
        while (i >= 0) {
            if (get(i) == obj) {
                return i;
            }
            i--;
        }
        return -1;
    }

    @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
    public synchronized boolean removeAll(java.util.Collection<?> collection) {
        if (!(collection instanceof java.util.Set)) {
            collection = new java.util.HashSet((java.util.Collection<? extends java.lang.Object>) collection);
        }
        return super.removeAll(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
    public synchronized boolean retainAll(java.util.Collection collection) {
        if (!(collection instanceof java.util.Set)) {
            collection = new java.util.HashSet(collection);
        }
        return super.retainAll(collection);
    }
}
