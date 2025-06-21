package com.aliyun.utils;

/* loaded from: classes12.dex */
public abstract class b {
    public static final java.lang.String DATA_KEY_EXTRA = "data_extra";
    public static final int WHAT_FAIL = 0;
    public static final int WHAT_SUCCESS = 1;
    private static java.util.concurrent.ExecutorService sThreadPool = java.util.concurrent.Executors.newCachedThreadPool();
    public java.lang.ref.WeakReference<android.content.Context> mContextWeak;
    private com.aliyun.utils.b.d outerListener;
    protected boolean wantStop = false;
    private com.aliyun.utils.b.c handler = null;
    private com.aliyun.utils.b.d innerListener = new com.aliyun.utils.b.a();

    public class a implements com.aliyun.utils.b.d {
        public a() {
        }

        @Override // com.aliyun.utils.b.d
        public void onFail(int i, java.lang.String str, java.lang.String str2) {
            if (com.aliyun.utils.b.this.outerListener != null) {
                com.aliyun.utils.b.this.outerListener.onFail(i, str, str2);
            }
        }

        @Override // com.aliyun.utils.b.d
        public void onSuccess(java.lang.Object obj, java.lang.String str) {
            if (com.aliyun.utils.b.this.outerListener != null) {
                com.aliyun.utils.b.this.outerListener.onSuccess(obj, str);
            }
        }
    }

    /* renamed from: com.aliyun.utils.b$b, reason: collision with other inner class name */
    public class RunnableC0112b implements java.lang.Runnable {
        public RunnableC0112b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.utils.b.this.runInBackground();
        }
    }

    public static class c extends android.os.Handler {
        private com.aliyun.utils.b a;

        public c(com.aliyun.utils.b bVar) {
            this.a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            com.aliyun.utils.b bVar = this.a;
            if (bVar != null) {
                bVar.dealMsg(message);
            }
        }
    }

    public interface d<Result> {
        void onFail(int i, java.lang.String str, java.lang.String str2);

        void onSuccess(Result result, java.lang.String str);
    }

    public b(android.content.Context context, com.aliyun.utils.b.d dVar) {
        this.outerListener = null;
        this.mContextWeak = new java.lang.ref.WeakReference<>(context);
        this.outerListener = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealMsg(android.os.Message message) {
        android.os.Bundle data = message.getData();
        java.lang.String string = data != null ? data.getString("data_extra", "") : "";
        int i = message.what;
        if (i == 1) {
            this.innerListener.onSuccess(message.obj, string);
        } else if (i == 0) {
            this.innerListener.onFail(message.arg1, (java.lang.String) message.obj, string);
        }
    }

    public void getAsync() {
        this.handler = new com.aliyun.utils.b.c(this);
        sThreadPool.execute(new com.aliyun.utils.b.RunnableC0112b());
    }

    public void getSync() {
        runInBackground();
    }

    public abstract void runInBackground();

    public void sendFailResult(int i, java.lang.String str, java.lang.String str2) {
        if (this.wantStop) {
            return;
        }
        com.aliyun.utils.b.c cVar = this.handler;
        if (cVar == null) {
            this.innerListener.onFail(i, str, str2);
            return;
        }
        android.os.Message obtainMessage = cVar.obtainMessage(0);
        obtainMessage.what = 0;
        obtainMessage.arg1 = i;
        obtainMessage.obj = str;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("data_extra", str2);
        obtainMessage.setData(bundle);
        this.handler.sendMessage(obtainMessage);
    }

    public void sendSuccessResult(java.lang.Object obj, java.lang.String str) {
        if (this.wantStop) {
            return;
        }
        com.aliyun.utils.b.c cVar = this.handler;
        if (cVar == null) {
            this.innerListener.onSuccess(obj, str);
            return;
        }
        android.os.Message obtainMessage = cVar.obtainMessage(1);
        obtainMessage.obj = obj;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("data_extra", str);
        obtainMessage.setData(bundle);
        this.handler.sendMessage(obtainMessage);
    }

    public void stop() {
        this.wantStop = true;
        stopInner();
    }

    public abstract void stopInner();
}
