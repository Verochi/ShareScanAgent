package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public abstract class BaseResourceCollectionWrapper extends org.apache.tools.ant.types.resources.AbstractResourceCollectionWrapper {
    public java.util.Collection<org.apache.tools.ant.types.Resource> u = null;

    public final synchronized java.util.Collection<org.apache.tools.ant.types.Resource> c() {
        if (this.u == null || !isCache()) {
            this.u = getCollection();
        }
        return this.u;
    }

    @Override // org.apache.tools.ant.types.resources.AbstractResourceCollectionWrapper
    public java.util.Iterator<org.apache.tools.ant.types.Resource> createIterator() {
        return c().iterator();
    }

    public abstract java.util.Collection<org.apache.tools.ant.types.Resource> getCollection();

    @Override // org.apache.tools.ant.types.resources.AbstractResourceCollectionWrapper
    public int getSize() {
        return c().size();
    }
}
