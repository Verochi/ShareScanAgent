package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public interface Predicate<T> {

    public static class PredicateIterable<T> implements java.lang.Iterable<T> {
        public java.lang.Iterable<T> iterable;
        public com.badlogic.gdx.utils.Predicate.PredicateIterator<T> iterator = null;
        public com.badlogic.gdx.utils.Predicate<T> predicate;

        public PredicateIterable(java.lang.Iterable<T> iterable, com.badlogic.gdx.utils.Predicate<T> predicate) {
            set(iterable, predicate);
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            com.badlogic.gdx.utils.Predicate.PredicateIterator<T> predicateIterator = this.iterator;
            if (predicateIterator == null) {
                this.iterator = new com.badlogic.gdx.utils.Predicate.PredicateIterator<>(this.iterable.iterator(), this.predicate);
            } else {
                predicateIterator.set(this.iterable.iterator(), this.predicate);
            }
            return this.iterator;
        }

        public void set(java.lang.Iterable<T> iterable, com.badlogic.gdx.utils.Predicate<T> predicate) {
            this.iterable = iterable;
            this.predicate = predicate;
        }
    }

    public static class PredicateIterator<T> implements java.util.Iterator<T> {
        public boolean end;
        public java.util.Iterator<T> iterator;
        public T next;
        public boolean peeked;
        public com.badlogic.gdx.utils.Predicate<T> predicate;

        public PredicateIterator(java.lang.Iterable<T> iterable, com.badlogic.gdx.utils.Predicate<T> predicate) {
            this(iterable.iterator(), predicate);
        }

        public PredicateIterator(java.util.Iterator<T> it, com.badlogic.gdx.utils.Predicate<T> predicate) {
            this.end = false;
            this.peeked = false;
            this.next = null;
            set(it, predicate);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.end) {
                return false;
            }
            if (this.next != null) {
                return true;
            }
            this.peeked = true;
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (this.predicate.evaluate(next)) {
                    this.next = next;
                    return true;
                }
            }
            this.end = true;
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.next == null && !hasNext()) {
                return null;
            }
            T t = this.next;
            this.next = null;
            this.peeked = false;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.peeked) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot remove between a call to hasNext() and next().");
            }
            this.iterator.remove();
        }

        public void set(java.lang.Iterable<T> iterable, com.badlogic.gdx.utils.Predicate<T> predicate) {
            set(iterable.iterator(), predicate);
        }

        public void set(java.util.Iterator<T> it, com.badlogic.gdx.utils.Predicate<T> predicate) {
            this.iterator = it;
            this.predicate = predicate;
            this.peeked = false;
            this.end = false;
            this.next = null;
        }
    }

    boolean evaluate(T t);
}
