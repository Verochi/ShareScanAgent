package androidx.work.impl.background.systemjob;

@android.annotation.TargetApi(21)
/* loaded from: classes.dex */
public class SystemJobService extends android.app.job.JobService {
    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        return 2;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(android.app.job.JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(android.app.job.JobParameters jobParameters) {
        return false;
    }
}
