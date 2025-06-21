package cn.shuzilm.core;

/* loaded from: classes.dex */
class l implements java.lang.Runnable {
    final /* synthetic */ int a;

    public l(int i) {
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.util.concurrent.locks.Lock lock;
        java.util.concurrent.locks.Lock lock2;
        java.util.concurrent.locks.Lock lock3;
        cn.shuzilm.core.AIClient aIClient;
        cn.shuzilm.core.AIClient aIClient2;
        lock = cn.shuzilm.core.DUHelper.f;
        if (lock.tryLock()) {
            try {
                aIClient = cn.shuzilm.core.DUHelper.c;
                if (aIClient == null) {
                    cn.shuzilm.core.AIClient unused = cn.shuzilm.core.DUHelper.c = new cn.shuzilm.core.AIClient(cn.shuzilm.core.DUHelper.mContext);
                }
                aIClient2 = cn.shuzilm.core.DUHelper.c;
                aIClient2.asynAI(this.a);
            } catch (java.lang.Exception unused2) {
            } catch (java.lang.Throwable th) {
                lock2 = cn.shuzilm.core.DUHelper.f;
                lock2.unlock();
                throw th;
            }
            lock3 = cn.shuzilm.core.DUHelper.f;
            lock3.unlock();
        }
    }
}
