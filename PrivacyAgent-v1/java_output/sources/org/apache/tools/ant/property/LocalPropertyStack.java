package org.apache.tools.ant.property;

/* loaded from: classes25.dex */
public class LocalPropertyStack {
    public final java.util.LinkedList<java.util.Map<java.lang.String, java.lang.Object>> a = new java.util.LinkedList<>();
    public final java.lang.Object b = new java.lang.Object();

    public final java.util.Map<java.lang.String, java.lang.Object> a(java.lang.String str) {
        synchronized (this.b) {
            java.util.Iterator<java.util.Map<java.lang.String, java.lang.Object>> it = this.a.iterator();
            while (it.hasNext()) {
                java.util.Map<java.lang.String, java.lang.Object> next = it.next();
                if (next.get(str) != null) {
                    return next;
                }
            }
            return null;
        }
    }

    public void addLocal(java.lang.String str) {
        synchronized (this.b) {
            java.util.Map<java.lang.String, java.lang.Object> peek = this.a.peek();
            if (peek != null) {
                peek.put(str, org.apache.tools.ant.property.NullReturn.NULL);
            }
        }
    }

    public org.apache.tools.ant.property.LocalPropertyStack copy() {
        org.apache.tools.ant.property.LocalPropertyStack localPropertyStack;
        synchronized (this.b) {
            localPropertyStack = new org.apache.tools.ant.property.LocalPropertyStack();
            localPropertyStack.a.addAll(this.a);
        }
        return localPropertyStack;
    }

    public void enterScope() {
        synchronized (this.b) {
            this.a.addFirst(new java.util.concurrent.ConcurrentHashMap());
        }
    }

    public java.lang.Object evaluate(java.lang.String str, org.apache.tools.ant.PropertyHelper propertyHelper) {
        synchronized (this.b) {
            java.util.Iterator<java.util.Map<java.lang.String, java.lang.Object>> it = this.a.iterator();
            while (it.hasNext()) {
                java.lang.Object obj = it.next().get(str);
                if (obj != null) {
                    return obj;
                }
            }
            return null;
        }
    }

    public void exitScope() {
        synchronized (this.b) {
            this.a.removeFirst().clear();
        }
    }

    public boolean set(java.lang.String str, java.lang.Object obj, org.apache.tools.ant.PropertyHelper propertyHelper) {
        java.util.Map<java.lang.String, java.lang.Object> a = a(str);
        if (a == null) {
            return false;
        }
        a.put(str, obj);
        return true;
    }

    public boolean setNew(java.lang.String str, java.lang.Object obj, org.apache.tools.ant.PropertyHelper propertyHelper) {
        java.util.Map<java.lang.String, java.lang.Object> a = a(str);
        if (a == null) {
            return false;
        }
        if (a.get(str) != org.apache.tools.ant.property.NullReturn.NULL) {
            return true;
        }
        a.put(str, obj);
        return true;
    }
}
