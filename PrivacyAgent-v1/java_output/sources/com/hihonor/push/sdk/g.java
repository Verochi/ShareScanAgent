package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public class g implements android.os.Handler.Callback {
    public static final com.hihonor.push.sdk.g c = new com.hihonor.push.sdk.g();
    public final android.os.Handler a;
    public final java.util.Map<com.hihonor.push.sdk.d, com.hihonor.push.sdk.g.a> b = new java.util.concurrent.ConcurrentHashMap(5, 0.75f, 1);

    public class a implements com.hihonor.push.sdk.h.a {
        public final com.hihonor.push.sdk.h c;
        public final android.content.Context d;
        public final com.hihonor.push.sdk.d f;
        public final java.util.Queue<com.hihonor.push.sdk.tasks.task.TaskApiCall<?>> a = new java.util.LinkedList();
        public final java.util.Queue<com.hihonor.push.sdk.tasks.task.TaskApiCall<?>> b = new java.util.LinkedList();
        public com.hihonor.push.sdk.common.data.ErrorEnum e = null;

        public a(android.content.Context context, com.hihonor.push.sdk.d dVar) {
            this.d = context;
            this.c = new com.hihonor.push.sdk.j(context, this);
            this.f = dVar;
        }

        public void a() {
            com.hihonor.push.sdk.utils.Preconditions.assertHandlerThread(com.hihonor.push.sdk.g.this.a);
            com.hihonor.push.sdk.j jVar = (com.hihonor.push.sdk.j) this.c;
            int i = jVar.a.get();
            com.hihonor.push.sdk.common.logger.Logger.i("PushConnectionClient", "enter disconnect, connection Status: ".concat(java.lang.String.valueOf(i)));
            if (i != 3) {
                if (i == 5) {
                    jVar.a.set(4);
                }
            } else {
                com.hihonor.push.sdk.l lVar = jVar.e;
                if (lVar != null) {
                    lVar.b();
                }
                jVar.a.set(1);
            }
        }

        public final synchronized void a(com.hihonor.push.sdk.common.data.ErrorEnum errorEnum) {
            com.hihonor.push.sdk.common.logger.Logger.i("HonorApiManager", "onConnectionFailed");
            com.hihonor.push.sdk.utils.Preconditions.assertHandlerThread(com.hihonor.push.sdk.g.this.a);
            java.util.Iterator<com.hihonor.push.sdk.tasks.task.TaskApiCall<?>> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onResponse(this.d, errorEnum.toApiException(), null);
            }
            this.a.clear();
            this.e = errorEnum;
            a();
            com.hihonor.push.sdk.g.this.b.remove(this.f);
        }

        public final synchronized void a(com.hihonor.push.sdk.tasks.task.TaskApiCall<?> taskApiCall) {
            this.b.add(taskApiCall);
            com.hihonor.push.sdk.j jVar = (com.hihonor.push.sdk.j) this.c;
            com.hihonor.push.sdk.n nVar = new com.hihonor.push.sdk.n(jVar.b, taskApiCall.newResponseInstance(), new com.hihonor.push.sdk.g.b(taskApiCall));
            com.hihonor.push.sdk.common.logger.Logger.i("IPCTransport", "start transport parse.");
            com.hihonor.push.sdk.common.logger.Logger.d("IPCTransport", "start transport parse. " + taskApiCall.getEventType());
            com.hihonor.push.framework.aidl.IPushInvoke iPushInvoke = jVar.c;
            java.lang.String eventType = taskApiCall.getEventType();
            com.hihonor.push.framework.aidl.entity.RequestHeader requestHeader = taskApiCall.getRequestHeader();
            com.hihonor.push.framework.aidl.IMessageEntity requestBody = taskApiCall.getRequestBody();
            android.os.Bundle bundle = new android.os.Bundle();
            android.os.Bundle bundle2 = new android.os.Bundle();
            com.hihonor.push.framework.aidl.MessageCodec.formMessageEntity(requestHeader, bundle);
            com.hihonor.push.framework.aidl.MessageCodec.formMessageEntity(requestBody, bundle2);
            com.hihonor.push.framework.aidl.DataBuffer dataBuffer = new com.hihonor.push.framework.aidl.DataBuffer(eventType, bundle, bundle2);
            if (iPushInvoke != null) {
                try {
                    iPushInvoke.call(dataBuffer, nVar);
                } catch (java.lang.Exception e) {
                    com.hihonor.push.sdk.common.logger.Logger.e("IPCTransport", "transport remote error. " + e);
                }
            }
            com.hihonor.push.sdk.common.logger.Logger.i("IPCTransport", "end transport parse.");
        }

        public final synchronized void b() {
            com.hihonor.push.sdk.common.logger.Logger.i("HonorApiManager", "onConnected");
            com.hihonor.push.sdk.utils.Preconditions.assertHandlerThread(com.hihonor.push.sdk.g.this.a);
            this.e = null;
            java.util.Iterator<com.hihonor.push.sdk.tasks.task.TaskApiCall<?>> it = this.a.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            this.a.clear();
        }
    }

    public static class b implements com.hihonor.push.sdk.o {
        public com.hihonor.push.sdk.tasks.task.TaskApiCall<?> a;

        public b(com.hihonor.push.sdk.tasks.task.TaskApiCall<?> taskApiCall) {
            this.a = taskApiCall;
        }
    }

    public g() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("HonorApiManager");
        handlerThread.start();
        this.a = new android.os.Handler(handlerThread.getLooper(), this);
    }

    public static com.hihonor.push.sdk.g a() {
        return c;
    }

    public <TResult> com.hihonor.push.sdk.tasks.Task<TResult> a(com.hihonor.push.sdk.tasks.task.TaskApiCall<TResult> taskApiCall) {
        com.hihonor.push.sdk.tasks.TaskCompletionSource<TResult> taskCompletionSource = new com.hihonor.push.sdk.tasks.TaskCompletionSource<>();
        if (taskApiCall == null) {
            com.hihonor.push.sdk.common.logger.Logger.i("HonorApiManager", "doWrite taskApiCall is null.");
            taskCompletionSource.setException(com.hihonor.push.sdk.common.data.ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
        } else {
            taskApiCall.setTaskCompletionSource(taskCompletionSource);
            com.hihonor.push.sdk.common.logger.Logger.i("HonorApiManager", "sendRequest start");
            android.os.Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, taskApiCall));
        }
        return taskCompletionSource.getTask();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        com.hihonor.push.sdk.g.a aVar;
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            com.hihonor.push.sdk.tasks.task.TaskApiCall taskApiCall = (com.hihonor.push.sdk.tasks.task.TaskApiCall) message.obj;
            com.hihonor.push.sdk.d connectionManagerKey = taskApiCall.getConnectionManagerKey();
            if (connectionManagerKey != null && this.b.containsKey(connectionManagerKey) && (aVar = this.b.get(connectionManagerKey)) != null) {
                synchronized (aVar) {
                    com.hihonor.push.sdk.common.logger.Logger.d("HonorApiManager", "resolveResult apiCall " + taskApiCall.getEventType());
                    aVar.b.remove(taskApiCall);
                    if (aVar.a.peek() == null || aVar.b.peek() == null) {
                        aVar.a();
                        com.hihonor.push.sdk.g.this.b.remove(aVar.f);
                    }
                }
            }
            return true;
        }
        com.hihonor.push.sdk.tasks.task.TaskApiCall<?> taskApiCall2 = (com.hihonor.push.sdk.tasks.task.TaskApiCall) message.obj;
        com.hihonor.push.sdk.d connectionManagerKey2 = taskApiCall2.getConnectionManagerKey();
        android.content.Context context = taskApiCall2.getContext();
        com.hihonor.push.sdk.g.a aVar2 = this.b.get(connectionManagerKey2);
        if (aVar2 == null) {
            com.hihonor.push.sdk.common.logger.Logger.i("HonorApiManager", "connect and send request, create new connection manager.");
            aVar2 = new com.hihonor.push.sdk.g.a(context, connectionManagerKey2);
            this.b.put(connectionManagerKey2, aVar2);
        }
        synchronized (aVar2) {
            com.hihonor.push.sdk.utils.Preconditions.assertHandlerThread(com.hihonor.push.sdk.g.this.a);
            com.hihonor.push.sdk.common.logger.Logger.d("HonorApiManager", "sendRequest " + taskApiCall2.getEventType());
            if (((com.hihonor.push.sdk.j) aVar2.c).a()) {
                aVar2.a(taskApiCall2);
            } else {
                aVar2.a.add(taskApiCall2);
                com.hihonor.push.sdk.common.data.ErrorEnum errorEnum = aVar2.e;
                if (errorEnum == null || errorEnum.getErrorCode() == 0) {
                    synchronized (aVar2) {
                        com.hihonor.push.sdk.utils.Preconditions.assertHandlerThread(com.hihonor.push.sdk.g.this.a);
                        if (((com.hihonor.push.sdk.j) aVar2.c).a()) {
                            com.hihonor.push.sdk.common.logger.Logger.i("HonorApiManager", "client is connected");
                        } else {
                            if (((com.hihonor.push.sdk.j) aVar2.c).a.get() == 5) {
                                com.hihonor.push.sdk.common.logger.Logger.i("HonorApiManager", "client is isConnecting");
                            } else {
                                com.hihonor.push.sdk.j jVar = (com.hihonor.push.sdk.j) aVar2.c;
                                jVar.getClass();
                                com.hihonor.push.sdk.common.logger.Logger.i("PushConnectionClient", "  ====  PUSHSDK VERSION 60004200 ====");
                                int i2 = jVar.a.get();
                                com.hihonor.push.sdk.common.logger.Logger.i("PushConnectionClient", "enter connect, connection Status: ".concat(java.lang.String.valueOf(i2)));
                                if (i2 != 3 && i2 != 5 && i2 != 4) {
                                    int isHonorMobileServicesAvailable = com.hihonor.push.sdk.ipc.HonorApiAvailability.isHonorMobileServicesAvailable(jVar.b);
                                    if (isHonorMobileServicesAvailable == com.hihonor.push.sdk.common.data.ErrorEnum.SUCCESS.getErrorCode()) {
                                        jVar.a.set(5);
                                        com.hihonor.push.sdk.bean.RemoteServiceBean a2 = com.hihonor.push.sdk.ipc.HonorApiAvailability.a(jVar.b);
                                        com.hihonor.push.sdk.common.logger.Logger.i("PushConnectionClient", "enter bindCoreService.");
                                        com.hihonor.push.sdk.common.logger.Logger.d("PushConnectionClient", "enter bindCoreService, ".concat(java.lang.String.valueOf(a2)));
                                        com.hihonor.push.sdk.l lVar = new com.hihonor.push.sdk.l(jVar.b, a2);
                                        jVar.e = lVar;
                                        lVar.c = new com.hihonor.push.sdk.i(jVar);
                                        if (a2.checkServiceInfo()) {
                                            android.content.Intent intent = new android.content.Intent();
                                            java.lang.String packageName = lVar.a.getPackageName();
                                            java.lang.String packageAction = lVar.a.getPackageAction();
                                            java.lang.String packageServiceName = lVar.a.getPackageServiceName();
                                            if (android.text.TextUtils.isEmpty(packageServiceName)) {
                                                intent.setAction(packageAction);
                                                intent.setPackage(packageName);
                                            } else {
                                                intent.setComponent(new android.content.ComponentName(packageName, packageServiceName));
                                            }
                                            synchronized (com.hihonor.push.sdk.l.e) {
                                                if (lVar.b.bindService(intent, lVar, 1)) {
                                                    android.os.Handler handler = lVar.d;
                                                    if (handler != null) {
                                                        handler.removeMessages(1001);
                                                    } else {
                                                        lVar.d = new android.os.Handler(android.os.Looper.getMainLooper(), new com.hihonor.push.sdk.k(lVar));
                                                    }
                                                    lVar.d.sendEmptyMessageDelayed(1001, 5000L);
                                                } else {
                                                    com.hihonor.push.sdk.common.logger.Logger.e("AIDLSrvConnection", "bind core service fail");
                                                    lVar.a(com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_BIND_SERVICE);
                                                }
                                            }
                                        } else {
                                            com.hihonor.push.sdk.common.logger.Logger.e("AIDLSrvConnection", "bind core : " + lVar.a);
                                            lVar.a(com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_SERVICE_ARGUMENTS_INVALID);
                                        }
                                    } else {
                                        jVar.a(isHonorMobileServicesAvailable);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    aVar2.a(aVar2.e);
                }
            }
        }
        return true;
    }
}
