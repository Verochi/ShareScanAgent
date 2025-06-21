package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
abstract class CollectionFuture<V, C> extends com.google.common.util.concurrent.AggregateFuture<V, C> {

    public abstract class CollectionFutureRunningState extends com.google.common.util.concurrent.AggregateFuture<V, C>.RunningState {
        public java.util.List<com.google.common.base.Optional<V>> A;

        public CollectionFutureRunningState(com.google.common.collect.ImmutableCollection<? extends com.google.common.util.concurrent.ListenableFuture<? extends V>> immutableCollection, boolean z) {
            super(immutableCollection, z, true);
            this.A = immutableCollection.isEmpty() ? com.google.common.collect.ImmutableList.of() : com.google.common.collect.Lists.newArrayListWithCapacity(immutableCollection.size());
            for (int i = 0; i < immutableCollection.size(); i++) {
                this.A.add(null);
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public final void l(boolean z, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            java.util.List<com.google.common.base.Optional<V>> list = this.A;
            if (list != null) {
                list.set(i, com.google.common.base.Optional.fromNullable(v));
            } else {
                com.google.common.base.Preconditions.checkState(z || com.google.common.util.concurrent.CollectionFuture.this.isCancelled(), "Future was done before all dependencies completed");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public final void n() {
            java.util.List<com.google.common.base.Optional<V>> list = this.A;
            if (list != null) {
                com.google.common.util.concurrent.CollectionFuture.this.set(u(list));
            } else {
                com.google.common.base.Preconditions.checkState(com.google.common.util.concurrent.CollectionFuture.this.isDone());
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void t() {
            super.t();
            this.A = null;
        }

        public abstract C u(java.util.List<com.google.common.base.Optional<V>> list);
    }

    public static final class ListFuture<V> extends com.google.common.util.concurrent.CollectionFuture<V, java.util.List<V>> {

        public final class ListFutureRunningState extends com.google.common.util.concurrent.CollectionFuture<V, java.util.List<V>>.CollectionFutureRunningState {
            public ListFutureRunningState(com.google.common.collect.ImmutableCollection<? extends com.google.common.util.concurrent.ListenableFuture<? extends V>> immutableCollection, boolean z) {
                super(immutableCollection, z);
            }

            @Override // com.google.common.util.concurrent.CollectionFuture.CollectionFutureRunningState
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            public java.util.List<V> u(java.util.List<com.google.common.base.Optional<V>> list) {
                java.util.ArrayList newArrayListWithCapacity = com.google.common.collect.Lists.newArrayListWithCapacity(list.size());
                java.util.Iterator<com.google.common.base.Optional<V>> it = list.iterator();
                while (it.hasNext()) {
                    com.google.common.base.Optional<V> next = it.next();
                    newArrayListWithCapacity.add(next != null ? next.orNull() : null);
                }
                return java.util.Collections.unmodifiableList(newArrayListWithCapacity);
            }
        }

        public ListFuture(com.google.common.collect.ImmutableCollection<? extends com.google.common.util.concurrent.ListenableFuture<? extends V>> immutableCollection, boolean z) {
            A(new com.google.common.util.concurrent.CollectionFuture.ListFuture.ListFutureRunningState(immutableCollection, z));
        }
    }
}
