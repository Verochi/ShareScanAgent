package androidx.core.app;

/* loaded from: classes.dex */
public abstract class JobIntentService extends android.app.Service {
    static final boolean DEBUG = false;
    static final java.lang.String TAG = "JobIntentService";
    final java.util.ArrayList<androidx.core.app.JobIntentService.CompatWorkItem> mCompatQueue;
    androidx.core.app.JobIntentService.WorkEnqueuer mCompatWorkEnqueuer;
    androidx.core.app.JobIntentService.CommandProcessor mCurProcessor;
    androidx.core.app.JobIntentService.CompatJobEngine mJobImpl;
    static final java.lang.Object sLock = new java.lang.Object();
    static final java.util.HashMap<android.content.ComponentName, androidx.core.app.JobIntentService.WorkEnqueuer> sClassWorkEnqueuer = new java.util.HashMap<>();
    boolean mInterruptIfStopped = false;
    boolean mStopped = false;
    boolean mDestroyed = false;

    public final class CommandProcessor extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Void> {
        public CommandProcessor() {
        }

        @Override // android.os.AsyncTask
        public java.lang.Void doInBackground(java.lang.Void... voidArr) {
            while (true) {
                androidx.core.app.JobIntentService.GenericWorkItem dequeueWork = androidx.core.app.JobIntentService.this.dequeueWork();
                if (dequeueWork == null) {
                    return null;
                }
                androidx.core.app.JobIntentService.this.onHandleWork(dequeueWork.getIntent());
                dequeueWork.complete();
            }
        }

        @Override // android.os.AsyncTask
        public void onCancelled(java.lang.Void r1) {
            androidx.core.app.JobIntentService.this.processorFinished();
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(java.lang.Void r1) {
            androidx.core.app.JobIntentService.this.processorFinished();
        }
    }

    public interface CompatJobEngine {
        android.os.IBinder compatGetBinder();

        androidx.core.app.JobIntentService.GenericWorkItem dequeueWork();
    }

    public static final class CompatWorkEnqueuer extends androidx.core.app.JobIntentService.WorkEnqueuer {
        private final android.content.Context mContext;
        private final android.os.PowerManager.WakeLock mLaunchWakeLock;
        boolean mLaunchingService;
        private final android.os.PowerManager.WakeLock mRunWakeLock;
        boolean mServiceProcessing;

        public CompatWorkEnqueuer(android.content.Context context, android.content.ComponentName componentName) {
            super(componentName);
            this.mContext = context.getApplicationContext();
            android.os.PowerManager powerManager = (android.os.PowerManager) context.getSystemService("power");
            android.os.PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.mLaunchWakeLock = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            android.os.PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.mRunWakeLock = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void enqueueWork(android.content.Intent intent) {
            android.content.Intent intent2 = new android.content.Intent(intent);
            intent2.setComponent(this.mComponentName);
            if (this.mContext.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.mLaunchingService) {
                        this.mLaunchingService = true;
                        if (!this.mServiceProcessing) {
                            this.mLaunchWakeLock.acquire(60000L);
                        }
                    }
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingFinished() {
            synchronized (this) {
                if (this.mServiceProcessing) {
                    if (this.mLaunchingService) {
                        this.mLaunchWakeLock.acquire(60000L);
                    }
                    this.mServiceProcessing = false;
                    this.mRunWakeLock.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingStarted() {
            synchronized (this) {
                if (!this.mServiceProcessing) {
                    this.mServiceProcessing = true;
                    this.mRunWakeLock.acquire(600000L);
                    this.mLaunchWakeLock.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceStartReceived() {
            synchronized (this) {
                this.mLaunchingService = false;
            }
        }
    }

    public final class CompatWorkItem implements androidx.core.app.JobIntentService.GenericWorkItem {
        final android.content.Intent mIntent;
        final int mStartId;

        public CompatWorkItem(android.content.Intent intent, int i) {
            this.mIntent = intent;
            this.mStartId = i;
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public void complete() {
            androidx.core.app.JobIntentService.this.stopSelf(this.mStartId);
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public android.content.Intent getIntent() {
            return this.mIntent;
        }
    }

    public interface GenericWorkItem {
        void complete();

        android.content.Intent getIntent();
    }

    @androidx.annotation.RequiresApi(26)
    public static final class JobServiceEngineImpl extends android.app.job.JobServiceEngine implements androidx.core.app.JobIntentService.CompatJobEngine {
        static final boolean DEBUG = false;
        static final java.lang.String TAG = "JobServiceEngineImpl";
        final java.lang.Object mLock;
        android.app.job.JobParameters mParams;
        final androidx.core.app.JobIntentService mService;

        public final class WrapperWorkItem implements androidx.core.app.JobIntentService.GenericWorkItem {
            final android.app.job.JobWorkItem mJobWork;

            public WrapperWorkItem(android.app.job.JobWorkItem jobWorkItem) {
                this.mJobWork = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public void complete() {
                synchronized (androidx.core.app.JobIntentService.JobServiceEngineImpl.this.mLock) {
                    android.app.job.JobParameters jobParameters = androidx.core.app.JobIntentService.JobServiceEngineImpl.this.mParams;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.mJobWork);
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public android.content.Intent getIntent() {
                android.content.Intent intent;
                intent = this.mJobWork.getIntent();
                return intent;
            }
        }

        public JobServiceEngineImpl(androidx.core.app.JobIntentService jobIntentService) {
            super(jobIntentService);
            this.mLock = new java.lang.Object();
            this.mService = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public android.os.IBinder compatGetBinder() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public androidx.core.app.JobIntentService.GenericWorkItem dequeueWork() {
            android.app.job.JobWorkItem dequeueWork;
            android.content.Intent intent;
            synchronized (this.mLock) {
                android.app.job.JobParameters jobParameters = this.mParams;
                if (jobParameters == null) {
                    return null;
                }
                dequeueWork = jobParameters.dequeueWork();
                if (dequeueWork == null) {
                    return null;
                }
                intent = dequeueWork.getIntent();
                intent.setExtrasClassLoader(this.mService.getClassLoader());
                return new androidx.core.app.JobIntentService.JobServiceEngineImpl.WrapperWorkItem(dequeueWork);
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(android.app.job.JobParameters jobParameters) {
            this.mParams = jobParameters;
            this.mService.ensureProcessorRunningLocked(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(android.app.job.JobParameters jobParameters) {
            boolean doStopCurrentWork = this.mService.doStopCurrentWork();
            synchronized (this.mLock) {
                this.mParams = null;
            }
            return doStopCurrentWork;
        }
    }

    @androidx.annotation.RequiresApi(26)
    public static final class JobWorkEnqueuer extends androidx.core.app.JobIntentService.WorkEnqueuer {
        private final android.app.job.JobInfo mJobInfo;
        private final android.app.job.JobScheduler mJobScheduler;

        public JobWorkEnqueuer(android.content.Context context, android.content.ComponentName componentName, int i) {
            super(componentName);
            ensureJobId(i);
            this.mJobInfo = new android.app.job.JobInfo.Builder(i, this.mComponentName).setOverrideDeadline(0L).build();
            this.mJobScheduler = (android.app.job.JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void enqueueWork(android.content.Intent intent) {
            this.mJobScheduler.enqueue(this.mJobInfo, new android.app.job.JobWorkItem(intent));
        }
    }

    public static abstract class WorkEnqueuer {
        final android.content.ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;

        public WorkEnqueuer(android.content.ComponentName componentName) {
            this.mComponentName = componentName;
        }

        public abstract void enqueueWork(android.content.Intent intent);

        public void ensureJobId(int i) {
            if (!this.mHasJobId) {
                this.mHasJobId = true;
                this.mJobId = i;
            } else {
                if (this.mJobId == i) {
                    return;
                }
                throw new java.lang.IllegalArgumentException("Given job ID " + i + " is different than previous " + this.mJobId);
            }
        }

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }
    }

    public JobIntentService() {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mCompatQueue = null;
        } else {
            this.mCompatQueue = new java.util.ArrayList<>();
        }
    }

    public static void enqueueWork(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.ComponentName componentName, int i, @androidx.annotation.NonNull android.content.Intent intent) {
        if (intent == null) {
            throw new java.lang.IllegalArgumentException("work must not be null");
        }
        synchronized (sLock) {
            androidx.core.app.JobIntentService.WorkEnqueuer workEnqueuer = getWorkEnqueuer(context, componentName, true, i);
            workEnqueuer.ensureJobId(i);
            workEnqueuer.enqueueWork(intent);
        }
    }

    public static void enqueueWork(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.Class<?> cls, int i, @androidx.annotation.NonNull android.content.Intent intent) {
        enqueueWork(context, new android.content.ComponentName(context, cls), i, intent);
    }

    public static androidx.core.app.JobIntentService.WorkEnqueuer getWorkEnqueuer(android.content.Context context, android.content.ComponentName componentName, boolean z, int i) {
        androidx.core.app.JobIntentService.WorkEnqueuer compatWorkEnqueuer;
        java.util.HashMap<android.content.ComponentName, androidx.core.app.JobIntentService.WorkEnqueuer> hashMap = sClassWorkEnqueuer;
        androidx.core.app.JobIntentService.WorkEnqueuer workEnqueuer = hashMap.get(componentName);
        if (workEnqueuer != null) {
            return workEnqueuer;
        }
        if (android.os.Build.VERSION.SDK_INT < 26) {
            compatWorkEnqueuer = new androidx.core.app.JobIntentService.CompatWorkEnqueuer(context, componentName);
        } else {
            if (!z) {
                throw new java.lang.IllegalArgumentException("Can't be here without a job id");
            }
            compatWorkEnqueuer = new androidx.core.app.JobIntentService.JobWorkEnqueuer(context, componentName, i);
        }
        androidx.core.app.JobIntentService.WorkEnqueuer workEnqueuer2 = compatWorkEnqueuer;
        hashMap.put(componentName, workEnqueuer2);
        return workEnqueuer2;
    }

    public androidx.core.app.JobIntentService.GenericWorkItem dequeueWork() {
        androidx.core.app.JobIntentService.CompatJobEngine compatJobEngine = this.mJobImpl;
        if (compatJobEngine != null) {
            return compatJobEngine.dequeueWork();
        }
        synchronized (this.mCompatQueue) {
            if (this.mCompatQueue.size() <= 0) {
                return null;
            }
            return this.mCompatQueue.remove(0);
        }
    }

    public boolean doStopCurrentWork() {
        androidx.core.app.JobIntentService.CommandProcessor commandProcessor = this.mCurProcessor;
        if (commandProcessor != null) {
            commandProcessor.cancel(this.mInterruptIfStopped);
        }
        this.mStopped = true;
        return onStopCurrentWork();
    }

    public void ensureProcessorRunningLocked(boolean z) {
        if (this.mCurProcessor == null) {
            this.mCurProcessor = new androidx.core.app.JobIntentService.CommandProcessor();
            androidx.core.app.JobIntentService.WorkEnqueuer workEnqueuer = this.mCompatWorkEnqueuer;
            if (workEnqueuer != null && z) {
                workEnqueuer.serviceProcessingStarted();
            }
            this.mCurProcessor.executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
        }
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(@androidx.annotation.NonNull android.content.Intent intent) {
        androidx.core.app.JobIntentService.CompatJobEngine compatJobEngine = this.mJobImpl;
        if (compatJobEngine != null) {
            return compatJobEngine.compatGetBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mJobImpl = new androidx.core.app.JobIntentService.JobServiceEngineImpl(this);
            this.mCompatWorkEnqueuer = null;
        } else {
            this.mJobImpl = null;
            this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new android.content.ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        java.util.ArrayList<androidx.core.app.JobIntentService.CompatWorkItem> arrayList = this.mCompatQueue;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mDestroyed = true;
                this.mCompatWorkEnqueuer.serviceProcessingFinished();
            }
        }
    }

    public abstract void onHandleWork(@androidx.annotation.NonNull android.content.Intent intent);

    @Override // android.app.Service
    public int onStartCommand(@androidx.annotation.Nullable android.content.Intent intent, int i, int i2) {
        if (this.mCompatQueue == null) {
            return 2;
        }
        this.mCompatWorkEnqueuer.serviceStartReceived();
        synchronized (this.mCompatQueue) {
            java.util.ArrayList<androidx.core.app.JobIntentService.CompatWorkItem> arrayList = this.mCompatQueue;
            if (intent == null) {
                intent = new android.content.Intent();
            }
            arrayList.add(new androidx.core.app.JobIntentService.CompatWorkItem(intent, i2));
            ensureProcessorRunningLocked(true);
        }
        return 3;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void processorFinished() {
        java.util.ArrayList<androidx.core.app.JobIntentService.CompatWorkItem> arrayList = this.mCompatQueue;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mCurProcessor = null;
                java.util.ArrayList<androidx.core.app.JobIntentService.CompatWorkItem> arrayList2 = this.mCompatQueue;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    ensureProcessorRunningLocked(false);
                } else if (!this.mDestroyed) {
                    this.mCompatWorkEnqueuer.serviceProcessingFinished();
                }
            }
        }
    }

    public void setInterruptIfStopped(boolean z) {
        this.mInterruptIfStopped = z;
    }
}
