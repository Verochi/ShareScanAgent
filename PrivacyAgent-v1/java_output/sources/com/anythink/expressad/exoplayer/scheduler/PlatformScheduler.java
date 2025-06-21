package com.anythink.expressad.exoplayer.scheduler;

@android.annotation.TargetApi(21)
/* loaded from: classes12.dex */
public final class PlatformScheduler implements com.anythink.expressad.exoplayer.scheduler.c {
    private static final java.lang.String b = "PlatformScheduler";
    private static final java.lang.String c = "service_action";
    private static final java.lang.String d = "service_package";
    private static final java.lang.String e = "requirements";
    private final int f;
    private final android.content.ComponentName g;
    private final android.app.job.JobScheduler h;

    public static final class PlatformSchedulerService extends android.app.job.JobService {
        @Override // android.app.job.JobService
        public final boolean onStartJob(android.app.job.JobParameters jobParameters) {
            android.os.PersistableBundle extras = jobParameters.getExtras();
            if (!new com.anythink.expressad.exoplayer.scheduler.a(extras.getInt("requirements")).a(this)) {
                jobFinished(jobParameters, true);
                return false;
            }
            java.lang.String string = extras.getString(com.anythink.expressad.exoplayer.scheduler.PlatformScheduler.c);
            com.anythink.expressad.exoplayer.k.af.a((android.content.Context) this, new android.content.Intent(string).setPackage(extras.getString(com.anythink.expressad.exoplayer.scheduler.PlatformScheduler.d)));
            return false;
        }

        @Override // android.app.job.JobService
        public final boolean onStopJob(android.app.job.JobParameters jobParameters) {
            return false;
        }
    }

    private PlatformScheduler(android.content.Context context, int i) {
        this.f = i;
        this.g = new android.content.ComponentName(context, (java.lang.Class<?>) com.anythink.expressad.exoplayer.scheduler.PlatformScheduler.PlatformSchedulerService.class);
        this.h = (android.app.job.JobScheduler) context.getSystemService("jobscheduler");
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    private static android.app.job.JobInfo a(int i, android.content.ComponentName componentName, com.anythink.expressad.exoplayer.scheduler.a aVar, java.lang.String str, java.lang.String str2) {
        int i2;
        android.app.job.JobInfo.Builder builder = new android.app.job.JobInfo.Builder(i, componentName);
        int a = aVar.a();
        if (a == 0) {
            i2 = 0;
        } else if (a != 1) {
            i2 = 2;
            if (a != 2) {
                i2 = 3;
                if (a != 3) {
                    i2 = 4;
                    if (a != 4) {
                        throw new java.lang.UnsupportedOperationException();
                    }
                    if (com.anythink.expressad.exoplayer.k.af.a < 26) {
                        throw new java.lang.UnsupportedOperationException();
                    }
                } else if (com.anythink.expressad.exoplayer.k.af.a < 24) {
                    throw new java.lang.UnsupportedOperationException();
                }
            }
        } else {
            i2 = 1;
        }
        builder.setRequiredNetworkType(i2);
        builder.setRequiresDeviceIdle(aVar.c());
        builder.setRequiresCharging(aVar.b());
        builder.setPersisted(true);
        android.os.PersistableBundle persistableBundle = new android.os.PersistableBundle();
        persistableBundle.putString(c, str);
        persistableBundle.putString(d, str2);
        persistableBundle.putInt("requirements", aVar.d());
        builder.setExtras(persistableBundle);
        return builder.build();
    }

    private static void b() {
    }

    private static /* synthetic */ void c() {
    }

    @Override // com.anythink.expressad.exoplayer.scheduler.c
    public final boolean a() {
        this.h.cancel(this.f);
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.scheduler.c
    public final boolean a(com.anythink.expressad.exoplayer.scheduler.a aVar, java.lang.String str, java.lang.String str2) {
        int i;
        android.app.job.JobInfo.Builder builder = new android.app.job.JobInfo.Builder(this.f, this.g);
        int a = aVar.a();
        if (a == 0) {
            i = 0;
        } else if (a != 1) {
            i = 2;
            if (a != 2) {
                i = 3;
                if (a != 3) {
                    i = 4;
                    if (a != 4) {
                        throw new java.lang.UnsupportedOperationException();
                    }
                    if (com.anythink.expressad.exoplayer.k.af.a < 26) {
                        throw new java.lang.UnsupportedOperationException();
                    }
                } else if (com.anythink.expressad.exoplayer.k.af.a < 24) {
                    throw new java.lang.UnsupportedOperationException();
                }
            }
        } else {
            i = 1;
        }
        builder.setRequiredNetworkType(i);
        builder.setRequiresDeviceIdle(aVar.c());
        builder.setRequiresCharging(aVar.b());
        builder.setPersisted(true);
        android.os.PersistableBundle persistableBundle = new android.os.PersistableBundle();
        persistableBundle.putString(c, str2);
        persistableBundle.putString(d, str);
        persistableBundle.putInt("requirements", aVar.d());
        builder.setExtras(persistableBundle);
        return this.h.schedule(builder.build()) == 1;
    }
}
