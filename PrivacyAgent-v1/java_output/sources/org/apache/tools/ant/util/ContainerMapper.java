package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public abstract class ContainerMapper implements org.apache.tools.ant.util.FileNameMapper {
    public java.util.List n = new java.util.ArrayList();

    public synchronized void add(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        if (this != fileNameMapper) {
            if (!(fileNameMapper instanceof org.apache.tools.ant.util.ContainerMapper) || !((org.apache.tools.ant.util.ContainerMapper) fileNameMapper).contains(this)) {
                this.n.add(fileNameMapper);
            }
        }
        throw new java.lang.IllegalArgumentException("Circular mapper containment condition detected");
    }

    public void addConfigured(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        add(fileNameMapper);
    }

    public void addConfiguredMapper(org.apache.tools.ant.types.Mapper mapper) {
        add(mapper.getImplementation());
    }

    public synchronized boolean contains(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        boolean z;
        java.util.Iterator it = this.n.iterator();
        loop0: while (true) {
            z = false;
            while (it.hasNext() && !z) {
                org.apache.tools.ant.util.FileNameMapper fileNameMapper2 = (org.apache.tools.ant.util.FileNameMapper) it.next();
                if (fileNameMapper2 == fileNameMapper || ((fileNameMapper2 instanceof org.apache.tools.ant.util.ContainerMapper) && ((org.apache.tools.ant.util.ContainerMapper) fileNameMapper2).contains(fileNameMapper))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public synchronized java.util.List getMappers() {
        return java.util.Collections.unmodifiableList(this.n);
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public void setFrom(java.lang.String str) {
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public void setTo(java.lang.String str) {
    }
}
