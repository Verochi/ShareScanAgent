package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class OrderedSet<T> extends com.badlogic.gdx.utils.ObjectSet<T> {
    public final com.badlogic.gdx.utils.Array<T> D;
    public com.badlogic.gdx.utils.OrderedSet.OrderedSetIterator E;
    public com.badlogic.gdx.utils.OrderedSet.OrderedSetIterator F;

    public static class OrderedSetIterator<T> extends com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator<T> {
        public com.badlogic.gdx.utils.Array<T> w;

        public OrderedSetIterator(com.badlogic.gdx.utils.OrderedSet<T> orderedSet) {
            super(orderedSet);
            this.w = orderedSet.D;
        }

        @Override // com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator, java.util.Iterator
        public T next() {
            if (!this.hasNext) {
                throw new java.util.NoSuchElementException();
            }
            if (!this.v) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            T t = this.w.get(this.t);
            int i = this.t + 1;
            this.t = i;
            this.hasNext = i < this.n.size;
            return t;
        }

        @Override // com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator, java.util.Iterator
        public void remove() {
            int i = this.t;
            if (i < 0) {
                throw new java.lang.IllegalStateException("next must be called before remove.");
            }
            int i2 = i - 1;
            this.t = i2;
            this.n.remove(this.w.get(i2));
        }

        @Override // com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator
        public void reset() {
            this.t = 0;
            this.hasNext = this.n.size > 0;
        }
    }

    public OrderedSet() {
        this.D = new com.badlogic.gdx.utils.Array<>();
    }

    public OrderedSet(int i) {
        super(i);
        this.D = new com.badlogic.gdx.utils.Array<>(this.t);
    }

    public OrderedSet(int i, float f) {
        super(i, f);
        this.D = new com.badlogic.gdx.utils.Array<>(this.t);
    }

    public OrderedSet(com.badlogic.gdx.utils.OrderedSet orderedSet) {
        super(orderedSet);
        com.badlogic.gdx.utils.Array<T> array = new com.badlogic.gdx.utils.Array<>(this.t);
        this.D = array;
        array.addAll(orderedSet.D);
    }

    @Override // com.badlogic.gdx.utils.ObjectSet
    public boolean add(T t) {
        if (!super.add(t)) {
            return false;
        }
        this.D.add(t);
        return true;
    }

    public boolean add(T t, int i) {
        if (super.add(t)) {
            this.D.insert(i, t);
            return true;
        }
        this.D.removeValue(t, true);
        this.D.insert(i, t);
        return false;
    }

    @Override // com.badlogic.gdx.utils.ObjectSet
    public void clear() {
        this.D.clear();
        super.clear();
    }

    @Override // com.badlogic.gdx.utils.ObjectSet
    public void clear(int i) {
        this.D.clear();
        super.clear(i);
    }

    @Override // com.badlogic.gdx.utils.ObjectSet, java.lang.Iterable
    public com.badlogic.gdx.utils.OrderedSet.OrderedSetIterator<T> iterator() {
        if (this.E == null) {
            this.E = new com.badlogic.gdx.utils.OrderedSet.OrderedSetIterator(this);
            this.F = new com.badlogic.gdx.utils.OrderedSet.OrderedSetIterator(this);
        }
        com.badlogic.gdx.utils.OrderedSet.OrderedSetIterator orderedSetIterator = this.E;
        if (orderedSetIterator.v) {
            this.F.reset();
            com.badlogic.gdx.utils.OrderedSet.OrderedSetIterator<T> orderedSetIterator2 = this.F;
            orderedSetIterator2.v = true;
            this.E.v = false;
            return orderedSetIterator2;
        }
        orderedSetIterator.reset();
        com.badlogic.gdx.utils.OrderedSet.OrderedSetIterator<T> orderedSetIterator3 = this.E;
        orderedSetIterator3.v = true;
        this.F.v = false;
        return orderedSetIterator3;
    }

    public com.badlogic.gdx.utils.Array<T> orderedItems() {
        return this.D;
    }

    @Override // com.badlogic.gdx.utils.ObjectSet
    public boolean remove(T t) {
        this.D.removeValue(t, false);
        return super.remove(t);
    }

    @Override // com.badlogic.gdx.utils.ObjectSet
    public java.lang.String toString() {
        if (this.size == 0) {
            return "{}";
        }
        T[] tArr = this.D.items;
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append('{');
        stringBuilder.append(tArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(tArr[i]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override // com.badlogic.gdx.utils.ObjectSet
    public java.lang.String toString(java.lang.String str) {
        return this.D.toString(str);
    }
}
