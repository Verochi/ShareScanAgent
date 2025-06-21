package com.google.android.exoplayer2.scheduler;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes22.dex */
public final class PlatformScheduler implements com.google.android.exoplayer2.scheduler.Scheduler {
    public static final int d;
    public final int a;
    public final android.content.ComponentName b;
    public final android.app.job.JobScheduler c;

    public static final class PlatformSchedulerService extends android.app.job.JobService {
        @Override // android.app.job.JobService
        public boolean onStartJob(android.app.job.JobParameters jobParameters) {
            android.os.PersistableBundle extras = jobParameters.getExtras();
            int notMetRequirements = new com.google.android.exoplayer2.scheduler.Requirements(extras.getInt(com.google.android.exoplayer2.offline.DownloadService.KEY_REQUIREMENTS)).getNotMetRequirements(this);
            if (notMetRequirements == 0) {
                java.lang.String str = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(extras.getString("service_action"));
                com.google.android.exoplayer2.util.Util.startForegroundService(this, new android.content.Intent(str).setPackage((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(extras.getString("service_package"))));
                return false;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(33);
            sb.append("Requirements not met: ");
            sb.append(notMetRequirements);
            com.google.android.exoplayer2.util.Log.w("PlatformScheduler", sb.toString());
            jobFinished(jobParameters, true);
            return false;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(android.app.job.JobParameters jobParameters) {
            return false;
        }
    }

    static {
        d = (com.google.android.exoplayer2.util.Util.SDK_INT >= 26 ? 16 : 0) | 15;
    }

    @androidx.annotation.RequiresPermission("android.permission.RECEIVE_BOOT_COMPLETED")
    public PlatformScheduler(android.content.Context context, int i) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.a = i;
        this.b = new android.content.ComponentName(applicationContext, (java.lang.Class<?>) com.google.android.exoplayer2.scheduler.PlatformScheduler.PlatformSchedulerService.class);
        this.c = (android.app.job.JobScheduler) com.google.android.exoplayer2.util.Assertions.checkNotNull((android.app.job.JobScheduler) applicationContext.getSystemService("jobscheduler"));
    }

    public static android.app.job.JobInfo a(int i, android.content.ComponentName componentName, com.google.android.exoplayer2.scheduler.Requirements requirements, java.lang.String str, java.lang.String str2) {
        com.google.android.exoplayer2.scheduler.Requirements filterRequirements = requirements.filterRequirements(d);
        if (!filterRequirements.equals(requirements)) {
            int requirements2 = filterRequirements.getRequirements() ^ requirements.getRequirements();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(46);
            sb.append("Ignoring unsupported requirements: ");
            sb.append(requirements2);
            com.google.android.exoplayer2.util.Log.w("PlatformScheduler", sb.toString());
        }
        android.app.job.JobInfo.Builder builder = new android.app.job.JobInfo.Builder(i, componentName);
        if (requirements.isUnmeteredNetworkRequired()) {
            builder.setRequiredNetworkType(2);
        } else if (requirements.isNetworkRequired()) {
            builder.setRequiredNetworkType(1);
        }
        builder.setRequiresDeviceIdle(requirements.isIdleRequired());
        builder.setRequiresCharging(requirements.isChargingRequired());
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 26 && requirements.isStorageNotLowRequired()) {
            builder.setRequiresStorageNotLow(true);
        }
        builder.setPersisted(true);
        android.os.PersistableBundle persistableBundle = new android.os.PersistableBundle();
        persistableBundle.putString("service_action", str);
        persistableBundle.putString("service_package", str2);
        persistableBundle.putInt(com.google.android.exoplayer2.offline.DownloadService.KEY_REQUIREMENTS, requirements.getRequirements());
        builder.setExtras(persistableBundle);
        return builder.build();
    }

    @Override // com.google.android.exoplayer2.scheduler.Scheduler
    public boolean cancel() {
        this.c.cancel(this.a);
        return true;
    }

    @Override // com.google.android.exoplayer2.scheduler.Scheduler
    public com.google.android.exoplayer2.scheduler.Requirements getSupportedRequirements(com.google.android.exoplayer2.scheduler.Requirements requirements) {
        return requirements.filterRequirements(d);
    }

    @Override // com.google.android.exoplayer2.scheduler.Scheduler
    public boolean schedule(com.google.android.exoplayer2.scheduler.Requirements requirements, java.lang.String str, java.lang.String str2) {
        return this.c.schedule(a(this.a, this.b, requirements, str2, str)) == 1;
    }
}
