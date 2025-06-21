package com.badlogic.gdx.graphics;

/* loaded from: classes12.dex */
public final class VertexAttributes implements java.lang.Iterable<com.badlogic.gdx.graphics.VertexAttribute>, java.lang.Comparable<com.badlogic.gdx.graphics.VertexAttributes> {
    public final com.badlogic.gdx.graphics.VertexAttribute[] n;
    public long t = -1;
    public com.badlogic.gdx.graphics.VertexAttributes.ReadonlyIterable<com.badlogic.gdx.graphics.VertexAttribute> u;
    public final int vertexSize;

    public static class ReadonlyIterable<T> implements java.lang.Iterable<T> {
        public final T[] n;
        public com.badlogic.gdx.graphics.VertexAttributes.ReadonlyIterator t;
        public com.badlogic.gdx.graphics.VertexAttributes.ReadonlyIterator u;

        public ReadonlyIterable(T[] tArr) {
            this.n = tArr;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            if (this.t == null) {
                this.t = new com.badlogic.gdx.graphics.VertexAttributes.ReadonlyIterator(this.n);
                this.u = new com.badlogic.gdx.graphics.VertexAttributes.ReadonlyIterator(this.n);
            }
            com.badlogic.gdx.graphics.VertexAttributes.ReadonlyIterator readonlyIterator = this.t;
            if (!readonlyIterator.u) {
                readonlyIterator.t = 0;
                readonlyIterator.u = true;
                this.u.u = false;
                return readonlyIterator;
            }
            com.badlogic.gdx.graphics.VertexAttributes.ReadonlyIterator readonlyIterator2 = this.u;
            readonlyIterator2.t = 0;
            readonlyIterator2.u = true;
            readonlyIterator.u = false;
            return readonlyIterator2;
        }
    }

    public static class ReadonlyIterator<T> implements java.util.Iterator<T>, java.lang.Iterable<T> {
        public final T[] n;
        public int t;
        public boolean u = true;

        public ReadonlyIterator(T[] tArr) {
            this.n = tArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.u) {
                return this.t < this.n.length;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            return this;
        }

        @Override // java.util.Iterator
        public T next() {
            int i = this.t;
            T[] tArr = this.n;
            if (i >= tArr.length) {
                throw new java.util.NoSuchElementException(java.lang.String.valueOf(this.t));
            }
            if (!this.u) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            this.t = i + 1;
            return tArr[i];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Remove not allowed.");
        }
    }

    public static final class Usage {
        public static final int BiNormal = 256;
        public static final int BoneWeight = 64;
        public static final int ColorPacked = 4;
        public static final int ColorUnpacked = 2;
        public static final int Generic = 32;
        public static final int Normal = 8;
        public static final int Position = 1;
        public static final int Tangent = 128;
        public static final int TextureCoordinates = 16;
    }

    public VertexAttributes(com.badlogic.gdx.graphics.VertexAttribute... vertexAttributeArr) {
        if (vertexAttributeArr.length == 0) {
            throw new java.lang.IllegalArgumentException("attributes must be >= 1");
        }
        com.badlogic.gdx.graphics.VertexAttribute[] vertexAttributeArr2 = new com.badlogic.gdx.graphics.VertexAttribute[vertexAttributeArr.length];
        for (int i = 0; i < vertexAttributeArr.length; i++) {
            vertexAttributeArr2[i] = vertexAttributeArr[i];
        }
        this.n = vertexAttributeArr2;
        this.vertexSize = a();
    }

    public final int a() {
        int i = 0;
        int i2 = 0;
        while (true) {
            com.badlogic.gdx.graphics.VertexAttribute[] vertexAttributeArr = this.n;
            if (i >= vertexAttributeArr.length) {
                return i2;
            }
            com.badlogic.gdx.graphics.VertexAttribute vertexAttribute = vertexAttributeArr[i];
            vertexAttribute.offset = i2;
            i2 += vertexAttribute.getSizeInBytes();
            i++;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(com.badlogic.gdx.graphics.VertexAttributes vertexAttributes) {
        com.badlogic.gdx.graphics.VertexAttribute[] vertexAttributeArr = this.n;
        int length = vertexAttributeArr.length;
        com.badlogic.gdx.graphics.VertexAttribute[] vertexAttributeArr2 = vertexAttributes.n;
        if (length != vertexAttributeArr2.length) {
            return vertexAttributeArr.length - vertexAttributeArr2.length;
        }
        long mask = getMask();
        long mask2 = vertexAttributes.getMask();
        if (mask != mask2) {
            return mask < mask2 ? -1 : 1;
        }
        for (int length2 = this.n.length - 1; length2 >= 0; length2--) {
            com.badlogic.gdx.graphics.VertexAttribute vertexAttribute = this.n[length2];
            com.badlogic.gdx.graphics.VertexAttribute vertexAttribute2 = vertexAttributes.n[length2];
            int i = vertexAttribute.usage;
            int i2 = vertexAttribute2.usage;
            if (i != i2) {
                return i - i2;
            }
            int i3 = vertexAttribute.unit;
            int i4 = vertexAttribute2.unit;
            if (i3 != i4) {
                return i3 - i4;
            }
            int i5 = vertexAttribute.numComponents;
            int i6 = vertexAttribute2.numComponents;
            if (i5 != i6) {
                return i5 - i6;
            }
            boolean z = vertexAttribute.normalized;
            if (z != vertexAttribute2.normalized) {
                return z ? 1 : -1;
            }
            int i7 = vertexAttribute.type;
            int i8 = vertexAttribute2.type;
            if (i7 != i8) {
                return i7 - i8;
            }
        }
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.badlogic.gdx.graphics.VertexAttributes)) {
            return false;
        }
        com.badlogic.gdx.graphics.VertexAttributes vertexAttributes = (com.badlogic.gdx.graphics.VertexAttributes) obj;
        if (this.n.length != vertexAttributes.n.length) {
            return false;
        }
        int i = 0;
        while (true) {
            com.badlogic.gdx.graphics.VertexAttribute[] vertexAttributeArr = this.n;
            if (i >= vertexAttributeArr.length) {
                return true;
            }
            if (!vertexAttributeArr[i].equals(vertexAttributes.n[i])) {
                return false;
            }
            i++;
        }
    }

    public com.badlogic.gdx.graphics.VertexAttribute findByUsage(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (get(i2).usage == i) {
                return get(i2);
            }
        }
        return null;
    }

    public com.badlogic.gdx.graphics.VertexAttribute get(int i) {
        return this.n[i];
    }

    public long getMask() {
        if (this.t == -1) {
            long j = 0;
            int i = 0;
            while (true) {
                if (i >= this.n.length) {
                    break;
                }
                j |= r3[i].usage;
                i++;
            }
            this.t = j;
        }
        return this.t;
    }

    public int getOffset(int i) {
        return getOffset(i, 0);
    }

    public int getOffset(int i, int i2) {
        com.badlogic.gdx.graphics.VertexAttribute findByUsage = findByUsage(i);
        return findByUsage == null ? i2 : findByUsage.offset / 4;
    }

    public int hashCode() {
        long length = this.n.length * 61;
        int i = 0;
        while (true) {
            if (i >= this.n.length) {
                return (int) (length ^ (length >> 32));
            }
            length = (length * 61) + r3[i].hashCode();
            i++;
        }
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<com.badlogic.gdx.graphics.VertexAttribute> iterator() {
        if (this.u == null) {
            this.u = new com.badlogic.gdx.graphics.VertexAttributes.ReadonlyIterable<>(this.n);
        }
        return this.u.iterator();
    }

    public int size() {
        return this.n.length;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.n.length; i++) {
            sb.append("(");
            sb.append(this.n[i].alias);
            sb.append(", ");
            sb.append(this.n[i].usage);
            sb.append(", ");
            sb.append(this.n[i].numComponents);
            sb.append(", ");
            sb.append(this.n[i].offset);
            sb.append(")");
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
