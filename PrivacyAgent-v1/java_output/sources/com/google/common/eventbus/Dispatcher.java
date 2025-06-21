package com.google.common.eventbus;

/* loaded from: classes22.dex */
abstract class Dispatcher {

    public static final class ImmediateDispatcher extends com.google.common.eventbus.Dispatcher {
        public static final com.google.common.eventbus.Dispatcher.ImmediateDispatcher a = new com.google.common.eventbus.Dispatcher.ImmediateDispatcher();

        @Override // com.google.common.eventbus.Dispatcher
        public void a(java.lang.Object obj, java.util.Iterator<com.google.common.eventbus.Subscriber> it) {
            com.google.common.base.Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                it.next().e(obj);
            }
        }
    }

    public static final class LegacyAsyncDispatcher extends com.google.common.eventbus.Dispatcher {
        public final java.util.concurrent.ConcurrentLinkedQueue<com.google.common.eventbus.Dispatcher.LegacyAsyncDispatcher.EventWithSubscriber> a;

        public static final class EventWithSubscriber {
            public final java.lang.Object a;
            public final com.google.common.eventbus.Subscriber b;

            public EventWithSubscriber(java.lang.Object obj, com.google.common.eventbus.Subscriber subscriber) {
                this.a = obj;
                this.b = subscriber;
            }

            public /* synthetic */ EventWithSubscriber(java.lang.Object obj, com.google.common.eventbus.Subscriber subscriber, com.google.common.eventbus.Dispatcher.AnonymousClass1 anonymousClass1) {
                this(obj, subscriber);
            }
        }

        public LegacyAsyncDispatcher() {
            this.a = com.google.common.collect.Queues.newConcurrentLinkedQueue();
        }

        public /* synthetic */ LegacyAsyncDispatcher(com.google.common.eventbus.Dispatcher.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.eventbus.Dispatcher
        public void a(java.lang.Object obj, java.util.Iterator<com.google.common.eventbus.Subscriber> it) {
            com.google.common.base.Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                this.a.add(new com.google.common.eventbus.Dispatcher.LegacyAsyncDispatcher.EventWithSubscriber(obj, it.next(), null));
            }
            while (true) {
                com.google.common.eventbus.Dispatcher.LegacyAsyncDispatcher.EventWithSubscriber poll = this.a.poll();
                if (poll == null) {
                    return;
                } else {
                    poll.b.e(poll.a);
                }
            }
        }
    }

    public static final class PerThreadQueuedDispatcher extends com.google.common.eventbus.Dispatcher {
        public final java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event>> a;
        public final java.lang.ThreadLocal<java.lang.Boolean> b;

        /* renamed from: com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$1, reason: invalid class name */
        public class AnonymousClass1 extends java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event>> {
            public AnonymousClass1() {
            }

            @Override // java.lang.ThreadLocal
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public java.util.Queue<com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event> initialValue() {
                return com.google.common.collect.Queues.newArrayDeque();
            }
        }

        /* renamed from: com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$2, reason: invalid class name */
        public class AnonymousClass2 extends java.lang.ThreadLocal<java.lang.Boolean> {
            public AnonymousClass2() {
            }

            @Override // java.lang.ThreadLocal
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public java.lang.Boolean initialValue() {
                return java.lang.Boolean.FALSE;
            }
        }

        public static final class Event {
            public final java.lang.Object a;
            public final java.util.Iterator<com.google.common.eventbus.Subscriber> b;

            public Event(java.lang.Object obj, java.util.Iterator<com.google.common.eventbus.Subscriber> it) {
                this.a = obj;
                this.b = it;
            }

            public /* synthetic */ Event(java.lang.Object obj, java.util.Iterator it, com.google.common.eventbus.Dispatcher.AnonymousClass1 anonymousClass1) {
                this(obj, it);
            }
        }

        public PerThreadQueuedDispatcher() {
            this.a = new com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.AnonymousClass1();
            this.b = new com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.AnonymousClass2();
        }

        public /* synthetic */ PerThreadQueuedDispatcher(com.google.common.eventbus.Dispatcher.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.eventbus.Dispatcher
        public void a(java.lang.Object obj, java.util.Iterator<com.google.common.eventbus.Subscriber> it) {
            com.google.common.base.Preconditions.checkNotNull(obj);
            com.google.common.base.Preconditions.checkNotNull(it);
            java.util.Queue<com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event> queue = this.a.get();
            queue.offer(new com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event(obj, it, null));
            if (this.b.get().booleanValue()) {
                return;
            }
            this.b.set(java.lang.Boolean.TRUE);
            while (true) {
                try {
                    com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event poll = queue.poll();
                    if (poll == null) {
                        return;
                    }
                    while (poll.b.hasNext()) {
                        ((com.google.common.eventbus.Subscriber) poll.b.next()).e(poll.a);
                    }
                } finally {
                    this.b.remove();
                    this.a.remove();
                }
            }
        }
    }

    public static com.google.common.eventbus.Dispatcher b() {
        return new com.google.common.eventbus.Dispatcher.LegacyAsyncDispatcher(null);
    }

    public static com.google.common.eventbus.Dispatcher c() {
        return new com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher(null);
    }

    public abstract void a(java.lang.Object obj, java.util.Iterator<com.google.common.eventbus.Subscriber> it);
}
