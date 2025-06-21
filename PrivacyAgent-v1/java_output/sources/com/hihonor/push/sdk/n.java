package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public class n extends com.hihonor.push.framework.aidl.IPushCallback.Stub {
    public final android.content.Context a;
    public final java.lang.Object b;
    public final com.hihonor.push.sdk.o c;

    public class a implements java.lang.Runnable {
        public final /* synthetic */ com.hihonor.push.framework.aidl.DataBuffer a;

        public a(com.hihonor.push.framework.aidl.DataBuffer dataBuffer) {
            this.a = dataBuffer;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.hihonor.push.sdk.common.logger.Logger.i("IPCCallback", "onResult parse start.");
            android.os.Bundle header = this.a.getHeader();
            android.os.Bundle body = this.a.getBody();
            com.hihonor.push.framework.aidl.entity.ResponseHeader responseHeader = new com.hihonor.push.framework.aidl.entity.ResponseHeader();
            com.hihonor.push.framework.aidl.MessageCodec.parseMessageEntity(header, responseHeader);
            java.lang.Object obj = com.hihonor.push.sdk.n.this.b;
            if (obj instanceof com.hihonor.push.framework.aidl.IMessageEntity) {
                com.hihonor.push.framework.aidl.MessageCodec.parseMessageEntity(body, (com.hihonor.push.framework.aidl.IMessageEntity) obj);
            }
            com.hihonor.push.sdk.n nVar = com.hihonor.push.sdk.n.this;
            com.hihonor.push.sdk.o oVar = nVar.c;
            android.content.Context context = nVar.a;
            com.hihonor.push.sdk.common.data.ApiException apiException = new com.hihonor.push.sdk.common.data.ApiException(responseHeader.getStatusCode(), responseHeader.getStatusMessage());
            java.lang.Object obj2 = com.hihonor.push.sdk.n.this.b;
            com.hihonor.push.sdk.g.b bVar = (com.hihonor.push.sdk.g.b) oVar;
            bVar.getClass();
            com.hihonor.push.sdk.g gVar = com.hihonor.push.sdk.g.c;
            com.hihonor.push.sdk.tasks.task.TaskApiCall<?> taskApiCall = bVar.a;
            gVar.getClass();
            com.hihonor.push.sdk.common.logger.Logger.i("HonorApiManager", "sendResolveResult start");
            android.os.Handler handler = gVar.a;
            handler.sendMessage(handler.obtainMessage(2, taskApiCall));
            bVar.a.onResponse(context, apiException, obj2);
            com.hihonor.push.sdk.common.logger.Logger.i("IPCCallback", "onResult parse end.");
        }
    }

    public n(android.content.Context context, java.lang.Object obj, com.hihonor.push.sdk.o oVar) {
        this.a = context;
        this.b = obj;
        this.c = oVar;
    }

    @Override // com.hihonor.push.framework.aidl.IPushCallback
    public void onResult(com.hihonor.push.framework.aidl.DataBuffer dataBuffer) {
        java.util.concurrent.Executors.newCachedThreadPool().submit(new com.hihonor.push.sdk.n.a(dataBuffer));
    }
}
