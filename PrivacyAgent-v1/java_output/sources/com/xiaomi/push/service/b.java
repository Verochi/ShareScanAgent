package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public class b extends android.app.Service {
    static android.app.Service a;
    private android.os.IBinder b = null;

    @android.annotation.TargetApi(21)
    public static class a extends android.app.job.JobService {
        android.os.Binder a;
        private android.os.Handler b;

        /* renamed from: com.xiaomi.push.service.b$a$a, reason: collision with other inner class name */
        public static class HandlerC0534a extends android.os.Handler {
            android.app.job.JobService a;

            public HandlerC0534a(android.app.job.JobService jobService) {
                super(jobService.getMainLooper());
                this.a = jobService;
            }

            @Override // android.os.Handler
            public final void handleMessage(android.os.Message message) {
                if (message.what != 1) {
                    return;
                }
                android.app.job.JobParameters jobParameters = (android.app.job.JobParameters) message.obj;
                com.xiaomi.channel.commonutils.logger.b.a("Job finished " + jobParameters.getJobId());
                this.a.jobFinished(jobParameters, false);
                if (jobParameters.getJobId() == 1) {
                    com.xiaomi.push.du.a(false);
                }
            }
        }

        public a(android.app.Service service) {
            this.a = null;
            this.a = (android.os.Binder) com.xiaomi.push.aj.a((java.lang.Object) this, "onBind", new android.content.Intent());
            com.xiaomi.push.aj.a((java.lang.Object) this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public final boolean onStartJob(android.app.job.JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.a("Job started " + jobParameters.getJobId());
            android.content.Intent intent = new android.content.Intent(this, (java.lang.Class<?>) com.xiaomi.push.service.c.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.b == null) {
                this.b = new com.xiaomi.push.service.b.a.HandlerC0534a(this);
            }
            android.os.Handler handler = this.b;
            handler.sendMessage(android.os.Message.obtain(handler, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public final boolean onStopJob(android.app.job.JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        android.os.IBinder iBinder = this.b;
        return iBinder != null ? iBinder : new android.os.Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.b = new com.xiaomi.push.service.b.a(this).a;
        a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a = null;
    }
}
