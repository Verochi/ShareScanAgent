package com.anythink.core.common.o.b;

/* loaded from: classes12.dex */
public class a {
    private static final java.lang.String a = "TaskBusinessThreads";
    private final java.util.concurrent.ExecutorService b;
    private final java.util.concurrent.ExecutorService c;
    private final java.util.concurrent.ExecutorService d;
    private volatile java.util.concurrent.ExecutorService e;
    private volatile java.util.concurrent.ExecutorService f;
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, android.os.Handler> g = new java.util.concurrent.ConcurrentHashMap<>();

    /* renamed from: com.anythink.core.common.o.b.a$a, reason: collision with other inner class name */
    public class RejectedExecutionHandlerC0167a implements java.util.concurrent.RejectedExecutionHandler {
        private RejectedExecutionHandlerC0167a() {
        }

        public /* synthetic */ RejectedExecutionHandlerC0167a(com.anythink.core.common.o.b.a aVar, byte b) {
            this();
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
            java.util.Objects.toString(threadPoolExecutor);
            com.anythink.core.common.o.b.a.this.b.execute(runnable);
        }
    }

    public a() {
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.SECONDS;
        this.b = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, timeUnit, new java.util.concurrent.SynchronousQueue(), new com.anythink.core.common.o.b.c());
        int availableProcessors = java.lang.Runtime.getRuntime().availableProcessors();
        this.c = new java.util.concurrent.ThreadPoolExecutor(availableProcessors + 1, availableProcessors * 2, 60L, timeUnit, new java.util.concurrent.LinkedBlockingQueue(100), new com.anythink.core.common.o.b.c(), new com.anythink.core.common.o.b.a.RejectedExecutionHandlerC0167a(this, (byte) 0));
        this.d = new java.util.concurrent.ThreadPoolExecutor(0, 5, 60L, timeUnit, new java.util.concurrent.LinkedBlockingQueue(), new com.anythink.core.common.o.b.c(), new com.anythink.core.common.o.b.a.RejectedExecutionHandlerC0167a(this, (byte) 0));
    }

    private android.os.Handler a(java.lang.String str) {
        return b(str);
    }

    private static void a() {
    }

    private void a(com.anythink.core.common.o.b.d dVar, java.lang.String str) {
        android.os.Handler b = b(str);
        if (b != null) {
            b.post(dVar);
        }
    }

    private android.os.Handler b(java.lang.String str) {
        android.os.Handler handler = this.g.get(str);
        if (handler == null) {
            synchronized (com.anythink.core.common.o.b.a.class) {
                try {
                    android.os.HandlerThread handlerThread = new android.os.HandlerThread(str);
                    handlerThread.setPriority(5);
                    handlerThread.start();
                    java.lang.Thread.currentThread().getId();
                    java.lang.Thread.currentThread().getName();
                    android.os.Handler handler2 = new android.os.Handler(handlerThread.getLooper());
                    try {
                        this.g.put(str, handler2);
                        handler = handler2;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        handler = handler2;
                        th.getMessage();
                        return handler;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            }
        }
        return handler;
    }

    public static java.lang.String b(int i) {
        java.lang.String concat = "default_thread_".concat(java.lang.String.valueOf(i));
        switch (i) {
            case 1:
                concat = "single_pool";
                break;
            case 2:
                concat = "normal_pool";
                break;
            case 3:
                concat = "handler_tcp_log";
                break;
            case 4:
                concat = "image_poll";
                break;
            case 5:
                concat = "single_pool_preload_task";
                break;
            case 6:
                concat = "normal_pool_network_request";
                break;
            case 7:
                concat = "limit_pool_sdk_init";
                break;
            case 8:
                concat = "handler_agent_event";
                break;
            case 9:
                concat = "handler_agent_tk";
                break;
            case 10:
                concat = "normal_pool_http_request";
                break;
            case 11:
                concat = "handler_placement_statistics";
                break;
            case 12:
                concat = "handler_timeout";
                break;
            case 13:
                concat = "limit_pool_on_sub_thread";
                break;
            case 14:
                concat = "handler_application_lifecycle";
                break;
            case 15:
                concat = "handler_shared_placement";
                break;
            case 16:
                concat = "single_pool_save_request_failed_info";
                break;
        }
        return java.lang.String.format("%s_type_%s", "anythink", concat);
    }

    private static void b() {
    }

    public final android.os.Handler a(int i) {
        return b(b(i));
    }

    public final void a(com.anythink.core.common.o.b.d dVar, int i) {
        java.lang.String b = b(i);
        dVar.a(b);
        if (i != 1) {
            if (i != 13) {
                if (i == 16) {
                    if (this.f == null) {
                        synchronized (com.anythink.core.common.o.b.a.class) {
                            if (this.f == null) {
                                this.f = new java.util.concurrent.ThreadPoolExecutor(0, 1, 30L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.anythink.core.common.o.b.c());
                            }
                        }
                    }
                    this.f.execute(dVar);
                    return;
                }
                if (i != 3) {
                    if (i == 4) {
                        this.d.execute(dVar);
                        return;
                    } else if (i != 5) {
                        if (i != 7) {
                            if (i != 8) {
                                this.b.execute(dVar);
                                return;
                            }
                        }
                    }
                }
                android.os.Handler b2 = b(b);
                if (b2 != null) {
                    b2.post(dVar);
                    return;
                }
                return;
            }
            this.c.execute(dVar);
            return;
        }
        if (this.e == null) {
            synchronized (com.anythink.core.common.o.b.a.class) {
                if (this.e == null) {
                    this.e = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.anythink.core.common.o.b.c());
                }
            }
        }
        this.e.execute(dVar);
    }
}
