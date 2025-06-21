package org.greenrobot.eventbus;

/* loaded from: classes26.dex */
public class EventBus {
    public static java.lang.String TAG = "EventBus";

    /* renamed from: s, reason: collision with root package name */
    public static volatile org.greenrobot.eventbus.EventBus f506s;
    public static final org.greenrobot.eventbus.EventBusBuilder t = new org.greenrobot.eventbus.EventBusBuilder();
    public static final java.util.Map<java.lang.Class<?>, java.util.List<java.lang.Class<?>>> u = new java.util.HashMap();
    public final java.util.Map<java.lang.Class<?>, java.util.concurrent.CopyOnWriteArrayList<org.greenrobot.eventbus.Subscription>> a;
    public final java.util.Map<java.lang.Object, java.util.List<java.lang.Class<?>>> b;
    public final java.util.Map<java.lang.Class<?>, java.lang.Object> c;
    public final java.lang.ThreadLocal<org.greenrobot.eventbus.EventBus.PostingThreadState> d;
    public final org.greenrobot.eventbus.MainThreadSupport e;
    public final org.greenrobot.eventbus.Poster f;
    public final org.greenrobot.eventbus.BackgroundPoster g;
    public final org.greenrobot.eventbus.AsyncPoster h;
    public final org.greenrobot.eventbus.SubscriberMethodFinder i;
    public final java.util.concurrent.ExecutorService j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final int q;
    public final org.greenrobot.eventbus.Logger r;

    /* renamed from: org.greenrobot.eventbus.EventBus$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.ThreadLocal<org.greenrobot.eventbus.EventBus.PostingThreadState> {
        public AnonymousClass1() {
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public org.greenrobot.eventbus.EventBus.PostingThreadState initialValue() {
            return new org.greenrobot.eventbus.EventBus.PostingThreadState();
        }
    }

    /* renamed from: org.greenrobot.eventbus.EventBus$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[org.greenrobot.eventbus.ThreadMode.values().length];
            a = iArr;
            try {
                iArr[org.greenrobot.eventbus.ThreadMode.POSTING.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[org.greenrobot.eventbus.ThreadMode.MAIN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[org.greenrobot.eventbus.ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[org.greenrobot.eventbus.ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[org.greenrobot.eventbus.ThreadMode.ASYNC.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public interface PostCallback {
    }

    public static final class PostingThreadState {
        public final java.util.List<java.lang.Object> a = new java.util.ArrayList();
        public boolean b;
        public boolean c;
        public org.greenrobot.eventbus.Subscription d;
        public java.lang.Object e;
        public boolean f;
    }

    public EventBus() {
        this(t);
    }

    public EventBus(org.greenrobot.eventbus.EventBusBuilder eventBusBuilder) {
        this.d = new org.greenrobot.eventbus.EventBus.AnonymousClass1();
        this.r = eventBusBuilder.b();
        this.a = new java.util.HashMap();
        this.b = new java.util.HashMap();
        this.c = new java.util.concurrent.ConcurrentHashMap();
        org.greenrobot.eventbus.MainThreadSupport c = eventBusBuilder.c();
        this.e = c;
        this.f = c != null ? c.createPoster(this) : null;
        this.g = new org.greenrobot.eventbus.BackgroundPoster(this);
        this.h = new org.greenrobot.eventbus.AsyncPoster(this);
        java.util.List<org.greenrobot.eventbus.meta.SubscriberInfoIndex> list = eventBusBuilder.k;
        this.q = list != null ? list.size() : 0;
        this.i = new org.greenrobot.eventbus.SubscriberMethodFinder(eventBusBuilder.k, eventBusBuilder.h, eventBusBuilder.g);
        this.l = eventBusBuilder.a;
        this.m = eventBusBuilder.b;
        this.n = eventBusBuilder.c;
        this.o = eventBusBuilder.d;
        this.k = eventBusBuilder.e;
        this.p = eventBusBuilder.f;
        this.j = eventBusBuilder.i;
    }

    public static void a(java.util.List<java.lang.Class<?>> list, java.lang.Class<?>[] clsArr) {
        for (java.lang.Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public static org.greenrobot.eventbus.EventBusBuilder builder() {
        return new org.greenrobot.eventbus.EventBusBuilder();
    }

    public static void clearCaches() {
        org.greenrobot.eventbus.SubscriberMethodFinder.a();
        u.clear();
    }

    public static org.greenrobot.eventbus.EventBus getDefault() {
        org.greenrobot.eventbus.EventBus eventBus = f506s;
        if (eventBus == null) {
            synchronized (org.greenrobot.eventbus.EventBus.class) {
                eventBus = f506s;
                if (eventBus == null) {
                    eventBus = new org.greenrobot.eventbus.EventBus();
                    f506s = eventBus;
                }
            }
        }
        return eventBus;
    }

    public static java.util.List<java.lang.Class<?>> h(java.lang.Class<?> cls) {
        java.util.List<java.lang.Class<?>> list;
        java.util.Map<java.lang.Class<?>, java.util.List<java.lang.Class<?>>> map = u;
        synchronized (map) {
            list = map.get(cls);
            if (list == null) {
                list = new java.util.ArrayList<>();
                for (java.lang.Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                u.put(cls, list);
            }
        }
        return list;
    }

    public final void b(org.greenrobot.eventbus.Subscription subscription, java.lang.Object obj) {
        if (obj != null) {
            k(subscription, obj, g());
        }
    }

    public java.util.concurrent.ExecutorService c() {
        return this.j;
    }

    public void cancelEventDelivery(java.lang.Object obj) {
        org.greenrobot.eventbus.EventBus.PostingThreadState postingThreadState = this.d.get();
        if (!postingThreadState.b) {
            throw new org.greenrobot.eventbus.EventBusException("This method may only be called from inside event handling methods on the posting thread");
        }
        if (obj == null) {
            throw new org.greenrobot.eventbus.EventBusException("Event may not be null");
        }
        if (postingThreadState.e != obj) {
            throw new org.greenrobot.eventbus.EventBusException("Only the currently handled event may be aborted");
        }
        if (postingThreadState.d.b.b != org.greenrobot.eventbus.ThreadMode.POSTING) {
            throw new org.greenrobot.eventbus.EventBusException(" event handlers may only abort the incoming event");
        }
        postingThreadState.f = true;
    }

    public final void d(org.greenrobot.eventbus.Subscription subscription, java.lang.Object obj, java.lang.Throwable th) {
        if (!(obj instanceof org.greenrobot.eventbus.SubscriberExceptionEvent)) {
            if (this.k) {
                throw new org.greenrobot.eventbus.EventBusException("Invoking subscriber failed", th);
            }
            if (this.l) {
                this.r.log(java.util.logging.Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + subscription.a.getClass(), th);
            }
            if (this.n) {
                post(new org.greenrobot.eventbus.SubscriberExceptionEvent(this, th, obj, subscription.a));
                return;
            }
            return;
        }
        if (this.l) {
            org.greenrobot.eventbus.Logger logger = this.r;
            java.util.logging.Level level = java.util.logging.Level.SEVERE;
            logger.log(level, "SubscriberExceptionEvent subscriber " + subscription.a.getClass() + " threw an exception", th);
            org.greenrobot.eventbus.SubscriberExceptionEvent subscriberExceptionEvent = (org.greenrobot.eventbus.SubscriberExceptionEvent) obj;
            this.r.log(level, "Initial event " + subscriberExceptionEvent.causingEvent + " caused exception in " + subscriberExceptionEvent.causingSubscriber, subscriberExceptionEvent.throwable);
        }
    }

    public void e(org.greenrobot.eventbus.PendingPost pendingPost) {
        java.lang.Object obj = pendingPost.a;
        org.greenrobot.eventbus.Subscription subscription = pendingPost.b;
        org.greenrobot.eventbus.PendingPost.b(pendingPost);
        if (subscription.c) {
            f(subscription, obj);
        }
    }

    public void f(org.greenrobot.eventbus.Subscription subscription, java.lang.Object obj) {
        try {
            subscription.b.a.invoke(subscription.a, obj);
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.IllegalStateException("Unexpected exception", e);
        } catch (java.lang.reflect.InvocationTargetException e2) {
            d(subscription, obj, e2.getCause());
        }
    }

    public final boolean g() {
        org.greenrobot.eventbus.MainThreadSupport mainThreadSupport = this.e;
        return mainThreadSupport == null || mainThreadSupport.isMainThread();
    }

    public org.greenrobot.eventbus.Logger getLogger() {
        return this.r;
    }

    public <T> T getStickyEvent(java.lang.Class<T> cls) {
        T cast;
        synchronized (this.c) {
            cast = cls.cast(this.c.get(cls));
        }
        return cast;
    }

    public boolean hasSubscriberForEvent(java.lang.Class<?> cls) {
        java.util.concurrent.CopyOnWriteArrayList<org.greenrobot.eventbus.Subscription> copyOnWriteArrayList;
        java.util.List<java.lang.Class<?>> h = h(cls);
        if (h != null) {
            int size = h.size();
            for (int i = 0; i < size; i++) {
                java.lang.Class<?> cls2 = h.get(i);
                synchronized (this) {
                    copyOnWriteArrayList = this.a.get(cls2);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void i(java.lang.Object obj, org.greenrobot.eventbus.EventBus.PostingThreadState postingThreadState) throws java.lang.Error {
        boolean j;
        java.lang.Class<?> cls = obj.getClass();
        if (this.p) {
            java.util.List<java.lang.Class<?>> h = h(cls);
            int size = h.size();
            j = false;
            for (int i = 0; i < size; i++) {
                j |= j(obj, postingThreadState, h.get(i));
            }
        } else {
            j = j(obj, postingThreadState, cls);
        }
        if (j) {
            return;
        }
        if (this.m) {
            this.r.log(java.util.logging.Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.o || cls == org.greenrobot.eventbus.NoSubscriberEvent.class || cls == org.greenrobot.eventbus.SubscriberExceptionEvent.class) {
            return;
        }
        post(new org.greenrobot.eventbus.NoSubscriberEvent(this, obj));
    }

    public synchronized boolean isRegistered(java.lang.Object obj) {
        return this.b.containsKey(obj);
    }

    public final boolean j(java.lang.Object obj, org.greenrobot.eventbus.EventBus.PostingThreadState postingThreadState, java.lang.Class<?> cls) {
        java.util.concurrent.CopyOnWriteArrayList<org.greenrobot.eventbus.Subscription> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        java.util.Iterator<org.greenrobot.eventbus.Subscription> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            org.greenrobot.eventbus.Subscription next = it.next();
            postingThreadState.e = obj;
            postingThreadState.d = next;
            try {
                k(next, obj, postingThreadState.c);
                if (postingThreadState.f) {
                    return true;
                }
            } finally {
                postingThreadState.e = null;
                postingThreadState.d = null;
                postingThreadState.f = false;
            }
        }
        return true;
    }

    public final void k(org.greenrobot.eventbus.Subscription subscription, java.lang.Object obj, boolean z) {
        int i = org.greenrobot.eventbus.EventBus.AnonymousClass2.a[subscription.b.b.ordinal()];
        if (i == 1) {
            f(subscription, obj);
            return;
        }
        if (i == 2) {
            if (z) {
                f(subscription, obj);
                return;
            } else {
                this.f.enqueue(subscription, obj);
                return;
            }
        }
        if (i == 3) {
            org.greenrobot.eventbus.Poster poster = this.f;
            if (poster != null) {
                poster.enqueue(subscription, obj);
                return;
            } else {
                f(subscription, obj);
                return;
            }
        }
        if (i == 4) {
            if (z) {
                this.g.enqueue(subscription, obj);
                return;
            } else {
                f(subscription, obj);
                return;
            }
        }
        if (i == 5) {
            this.h.enqueue(subscription, obj);
            return;
        }
        throw new java.lang.IllegalStateException("Unknown thread mode: " + subscription.b.b);
    }

    public final void l(java.lang.Object obj, org.greenrobot.eventbus.SubscriberMethod subscriberMethod) {
        java.lang.Class<?> cls = subscriberMethod.c;
        org.greenrobot.eventbus.Subscription subscription = new org.greenrobot.eventbus.Subscription(obj, subscriberMethod);
        java.util.concurrent.CopyOnWriteArrayList<org.greenrobot.eventbus.Subscription> copyOnWriteArrayList = this.a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new java.util.concurrent.CopyOnWriteArrayList<>();
            this.a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(subscription)) {
            throw new org.greenrobot.eventbus.EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || subscriberMethod.d > copyOnWriteArrayList.get(i).b.d) {
                copyOnWriteArrayList.add(i, subscription);
                break;
            }
        }
        java.util.List<java.lang.Class<?>> list = this.b.get(obj);
        if (list == null) {
            list = new java.util.ArrayList<>();
            this.b.put(obj, list);
        }
        list.add(cls);
        if (subscriberMethod.e) {
            if (!this.p) {
                b(subscription, this.c.get(cls));
                return;
            }
            for (java.util.Map.Entry<java.lang.Class<?>, java.lang.Object> entry : this.c.entrySet()) {
                if (cls.isAssignableFrom(entry.getKey())) {
                    b(subscription, entry.getValue());
                }
            }
        }
    }

    public final void m(java.lang.Object obj, java.lang.Class<?> cls) {
        java.util.concurrent.CopyOnWriteArrayList<org.greenrobot.eventbus.Subscription> copyOnWriteArrayList = this.a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                org.greenrobot.eventbus.Subscription subscription = copyOnWriteArrayList.get(i);
                if (subscription.a == obj) {
                    subscription.c = false;
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    public void post(java.lang.Object obj) {
        org.greenrobot.eventbus.EventBus.PostingThreadState postingThreadState = this.d.get();
        java.util.List<java.lang.Object> list = postingThreadState.a;
        list.add(obj);
        if (postingThreadState.b) {
            return;
        }
        postingThreadState.c = g();
        postingThreadState.b = true;
        if (postingThreadState.f) {
            throw new org.greenrobot.eventbus.EventBusException("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                } else {
                    i(list.remove(0), postingThreadState);
                }
            } finally {
                postingThreadState.b = false;
                postingThreadState.c = false;
            }
        }
    }

    public void postSticky(java.lang.Object obj) {
        synchronized (this.c) {
            this.c.put(obj.getClass(), obj);
        }
        post(obj);
    }

    public void register(java.lang.Object obj) {
        java.util.List<org.greenrobot.eventbus.SubscriberMethod> b = this.i.b(obj.getClass());
        synchronized (this) {
            java.util.Iterator<org.greenrobot.eventbus.SubscriberMethod> it = b.iterator();
            while (it.hasNext()) {
                l(obj, it.next());
            }
        }
    }

    public void removeAllStickyEvents() {
        synchronized (this.c) {
            this.c.clear();
        }
    }

    public <T> T removeStickyEvent(java.lang.Class<T> cls) {
        T cast;
        synchronized (this.c) {
            cast = cls.cast(this.c.remove(cls));
        }
        return cast;
    }

    public boolean removeStickyEvent(java.lang.Object obj) {
        synchronized (this.c) {
            java.lang.Class<?> cls = obj.getClass();
            if (!obj.equals(this.c.get(cls))) {
                return false;
            }
            this.c.remove(cls);
            return true;
        }
    }

    public java.lang.String toString() {
        return "EventBus[indexCount=" + this.q + ", eventInheritance=" + this.p + "]";
    }

    public synchronized void unregister(java.lang.Object obj) {
        java.util.List<java.lang.Class<?>> list = this.b.get(obj);
        if (list != null) {
            java.util.Iterator<java.lang.Class<?>> it = list.iterator();
            while (it.hasNext()) {
                m(obj, it.next());
            }
            this.b.remove(obj);
        } else {
            this.r.log(java.util.logging.Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }
}
