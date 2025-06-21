package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class Resource extends org.apache.tools.ant.types.DataType implements java.lang.Comparable<org.apache.tools.ant.types.Resource>, org.apache.tools.ant.types.ResourceCollection {
    public static final long UNKNOWN_DATETIME = 0;
    public static final long UNKNOWN_SIZE = -1;
    public java.lang.String n;
    public java.lang.Boolean t;
    public java.lang.Long u;
    public java.lang.Boolean v;
    public java.lang.Long w;
    protected static final int MAGIC = getMagicNumber("Resource".getBytes());
    public static final int x = getMagicNumber("null name".getBytes());

    /* renamed from: org.apache.tools.ant.types.Resource$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Iterator<org.apache.tools.ant.types.Resource> {
        public boolean n = false;

        public AnonymousClass1() {
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public org.apache.tools.ant.types.Resource next() {
            if (this.n) {
                throw new java.util.NoSuchElementException();
            }
            this.n = true;
            return org.apache.tools.ant.types.Resource.this;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.n;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public Resource() {
        this.n = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
    }

    public Resource(java.lang.String str) {
        this(str, false, 0L, false);
    }

    public Resource(java.lang.String str, boolean z, long j) {
        this(str, z, j, false);
    }

    public Resource(java.lang.String str, boolean z, long j, boolean z2) {
        this(str, z, j, z2, -1L);
    }

    public Resource(java.lang.String str, boolean z, long j, boolean z2, long j2) {
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.n = str;
        setName(str);
        setExists(z);
        setLastModified(j);
        setDirectory(z2);
        setSize(j2);
    }

    public static int getMagicNumber(byte[] bArr) {
        return new java.math.BigInteger(bArr).intValue();
    }

    public <T> T as(java.lang.Class<T> cls) {
        if (cls.isAssignableFrom(getClass())) {
            return cls.cast(this);
        }
        return null;
    }

    @Override // org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException unused) {
            throw new java.lang.UnsupportedOperationException("CloneNotSupportedException for a Resource caught. Derived classes must support cloning.");
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(org.apache.tools.ant.types.Resource resource) {
        return isReference() ? ((org.apache.tools.ant.types.Resource) getCheckedRef()).compareTo(resource) : toString().compareTo(resource.toString());
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return isReference() ? getCheckedRef().equals(obj) : obj != null && obj.getClass().equals(getClass()) && compareTo((org.apache.tools.ant.types.Resource) obj) == 0;
    }

    public java.io.InputStream getInputStream() throws java.io.IOException {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getInputStream();
        }
        throw new java.lang.UnsupportedOperationException();
    }

    public long getLastModified() {
        java.lang.Long l;
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getLastModified();
        }
        if (!isExists() || (l = this.u) == null) {
            return 0L;
        }
        long longValue = l.longValue();
        if (longValue < 0) {
            return 0L;
        }
        return longValue;
    }

    public java.lang.String getName() {
        return isReference() ? ((org.apache.tools.ant.types.Resource) getCheckedRef()).getName() : this.n;
    }

    public java.io.OutputStream getOutputStream() throws java.io.IOException {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getOutputStream();
        }
        throw new java.lang.UnsupportedOperationException();
    }

    public long getSize() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getSize();
        }
        if (!isExists()) {
            return 0L;
        }
        java.lang.Long l = this.w;
        if (l != null) {
            return l.longValue();
        }
        return -1L;
    }

    public int hashCode() {
        if (isReference()) {
            return getCheckedRef().hashCode();
        }
        java.lang.String name = getName();
        return MAGIC * (name == null ? x : name.hashCode());
    }

    public boolean isDirectory() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).isDirectory();
        }
        java.lang.Boolean bool = this.v;
        return bool != null && bool.booleanValue();
    }

    public boolean isExists() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).isExists();
        }
        java.lang.Boolean bool = this.t;
        return bool == null || bool.booleanValue();
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public boolean isFilesystemOnly() {
        return (isReference() && ((org.apache.tools.ant.types.Resource) getCheckedRef()).isFilesystemOnly()) || as(org.apache.tools.ant.types.resources.FileProvider.class) != null;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        return isReference() ? ((org.apache.tools.ant.types.Resource) getCheckedRef()).iterator() : new org.apache.tools.ant.types.Resource.AnonymousClass1();
    }

    public void setDirectory(boolean z) {
        checkAttributesAllowed();
        this.v = z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE;
    }

    public void setExists(boolean z) {
        checkAttributesAllowed();
        this.t = z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE;
    }

    public void setLastModified(long j) {
        checkAttributesAllowed();
        this.u = new java.lang.Long(j);
    }

    public void setName(java.lang.String str) {
        checkAttributesAllowed();
        this.n = str;
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        if (this.n != null || this.t != null || this.u != null || this.v != null || this.w != null) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    public void setSize(long j) {
        checkAttributesAllowed();
        if (j <= -1) {
            j = -1;
        }
        this.w = new java.lang.Long(j);
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public int size() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).size();
        }
        return 1;
    }

    public final java.lang.String toLongString() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).toLongString();
        }
        return getDataTypeName() + " \"" + toString() + kotlin.text.Typography.quote;
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        java.lang.String name = getName();
        return name == null ? "(anonymous)" : name;
    }
}
