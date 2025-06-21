package androidx.appcompat.widget;

/* loaded from: classes.dex */
class ActivityChooserModel extends android.database.DataSetObservable {
    static final java.lang.String ATTRIBUTE_ACTIVITY = "activity";
    static final java.lang.String ATTRIBUTE_TIME = "time";
    static final java.lang.String ATTRIBUTE_WEIGHT = "weight";
    static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final java.lang.String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final java.lang.String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    static final java.lang.String LOG_TAG = "ActivityChooserModel";
    static final java.lang.String TAG_HISTORICAL_RECORD = "historical-record";
    static final java.lang.String TAG_HISTORICAL_RECORDS = "historical-records";
    private androidx.appcompat.widget.ActivityChooserModel.OnChooseActivityListener mActivityChoserModelPolicy;
    final android.content.Context mContext;
    final java.lang.String mHistoryFileName;
    private android.content.Intent mIntent;
    private static final java.lang.Object sRegistryLock = new java.lang.Object();
    private static final java.util.Map<java.lang.String, androidx.appcompat.widget.ActivityChooserModel> sDataModelRegistry = new java.util.HashMap();
    private final java.lang.Object mInstanceLock = new java.lang.Object();
    private final java.util.List<androidx.appcompat.widget.ActivityChooserModel.ActivityResolveInfo> mActivities = new java.util.ArrayList();
    private final java.util.List<androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord> mHistoricalRecords = new java.util.ArrayList();
    private androidx.appcompat.widget.ActivityChooserModel.ActivitySorter mActivitySorter = new androidx.appcompat.widget.ActivityChooserModel.DefaultSorter();
    private int mHistoryMaxSize = 50;
    boolean mCanReadHistoricalData = true;
    private boolean mReadShareHistoryCalled = false;
    private boolean mHistoricalRecordsChanged = true;
    private boolean mReloadActivities = false;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(androidx.appcompat.widget.ActivityChooserModel activityChooserModel);
    }

    public static final class ActivityResolveInfo implements java.lang.Comparable<androidx.appcompat.widget.ActivityChooserModel.ActivityResolveInfo> {
        public final android.content.pm.ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(android.content.pm.ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        @Override // java.lang.Comparable
        public int compareTo(androidx.appcompat.widget.ActivityChooserModel.ActivityResolveInfo activityResolveInfo) {
            return java.lang.Float.floatToIntBits(activityResolveInfo.weight) - java.lang.Float.floatToIntBits(this.weight);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && androidx.appcompat.widget.ActivityChooserModel.ActivityResolveInfo.class == obj.getClass() && java.lang.Float.floatToIntBits(this.weight) == java.lang.Float.floatToIntBits(((androidx.appcompat.widget.ActivityChooserModel.ActivityResolveInfo) obj).weight);
        }

        public int hashCode() {
            return java.lang.Float.floatToIntBits(this.weight) + 31;
        }

        public java.lang.String toString() {
            return "[resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new java.math.BigDecimal(this.weight) + "]";
        }
    }

    public interface ActivitySorter {
        void sort(android.content.Intent intent, java.util.List<androidx.appcompat.widget.ActivityChooserModel.ActivityResolveInfo> list, java.util.List<androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord> list2);
    }

    public static final class DefaultSorter implements androidx.appcompat.widget.ActivityChooserModel.ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        private final java.util.Map<android.content.ComponentName, androidx.appcompat.widget.ActivityChooserModel.ActivityResolveInfo> mPackageNameToActivityMap = new java.util.HashMap();

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public void sort(android.content.Intent intent, java.util.List<androidx.appcompat.widget.ActivityChooserModel.ActivityResolveInfo> list, java.util.List<androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord> list2) {
            java.util.Map<android.content.ComponentName, androidx.appcompat.widget.ActivityChooserModel.ActivityResolveInfo> map = this.mPackageNameToActivityMap;
            map.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                androidx.appcompat.widget.ActivityChooserModel.ActivityResolveInfo activityResolveInfo = list.get(i);
                activityResolveInfo.weight = 0.0f;
                android.content.pm.ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
                map.put(new android.content.ComponentName(activityInfo.packageName, activityInfo.name), activityResolveInfo);
            }
            float f = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord historicalRecord = list2.get(size2);
                androidx.appcompat.widget.ActivityChooserModel.ActivityResolveInfo activityResolveInfo2 = map.get(historicalRecord.activity);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.weight += historicalRecord.weight * f;
                    f *= 0.95f;
                }
            }
            java.util.Collections.sort(list);
        }
    }

    public static final class HistoricalRecord {
        public final android.content.ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(android.content.ComponentName componentName, long j, float f) {
            this.activity = componentName;
            this.time = j;
            this.weight = f;
        }

        public HistoricalRecord(java.lang.String str, long j, float f) {
            this(android.content.ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord.class != obj.getClass()) {
                return false;
            }
            androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord historicalRecord = (androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord) obj;
            android.content.ComponentName componentName = this.activity;
            if (componentName == null) {
                if (historicalRecord.activity != null) {
                    return false;
                }
            } else if (!componentName.equals(historicalRecord.activity)) {
                return false;
            }
            return this.time == historicalRecord.time && java.lang.Float.floatToIntBits(this.weight) == java.lang.Float.floatToIntBits(historicalRecord.weight);
        }

        public int hashCode() {
            android.content.ComponentName componentName = this.activity;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.time;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + java.lang.Float.floatToIntBits(this.weight);
        }

        public java.lang.String toString() {
            return "[; activity:" + this.activity + "; time:" + this.time + "; weight:" + new java.math.BigDecimal(this.weight) + "]";
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(androidx.appcompat.widget.ActivityChooserModel activityChooserModel, android.content.Intent intent);
    }

    public final class PersistHistoryAsyncTask extends android.os.AsyncTask<java.lang.Object, java.lang.Void, java.lang.Void> {
        public PersistHistoryAsyncTask() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x006d, code lost:
        
            if (r15 != null) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:
        
            r15.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00a2, code lost:
        
            if (r15 == null) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x008a, code lost:
        
            if (r15 == null) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00ba, code lost:
        
            if (r15 == null) goto L27;
         */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public java.lang.Void doInBackground(java.lang.Object... objArr) {
            java.util.List list = (java.util.List) objArr[0];
            java.lang.String str = (java.lang.String) objArr[1];
            try {
                java.io.FileOutputStream openFileOutput = androidx.appcompat.widget.ActivityChooserModel.this.mContext.openFileOutput(str, 0);
                org.xmlpull.v1.XmlSerializer newSerializer = android.util.Xml.newSerializer();
                try {
                    try {
                        try {
                            newSerializer.setOutput(openFileOutput, null);
                            newSerializer.startDocument("UTF-8", java.lang.Boolean.TRUE);
                            newSerializer.startTag(null, androidx.appcompat.widget.ActivityChooserModel.TAG_HISTORICAL_RECORDS);
                            int size = list.size();
                            for (int i = 0; i < size; i++) {
                                androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord historicalRecord = (androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord) list.remove(0);
                                newSerializer.startTag(null, androidx.appcompat.widget.ActivityChooserModel.TAG_HISTORICAL_RECORD);
                                newSerializer.attribute(null, "activity", historicalRecord.activity.flattenToString());
                                newSerializer.attribute(null, "time", java.lang.String.valueOf(historicalRecord.time));
                                newSerializer.attribute(null, androidx.appcompat.widget.ActivityChooserModel.ATTRIBUTE_WEIGHT, java.lang.String.valueOf(historicalRecord.weight));
                                newSerializer.endTag(null, androidx.appcompat.widget.ActivityChooserModel.TAG_HISTORICAL_RECORD);
                            }
                            newSerializer.endTag(null, androidx.appcompat.widget.ActivityChooserModel.TAG_HISTORICAL_RECORDS);
                            newSerializer.endDocument();
                            androidx.appcompat.widget.ActivityChooserModel.this.mCanReadHistoricalData = true;
                        } catch (java.lang.Throwable th) {
                            androidx.appcompat.widget.ActivityChooserModel.this.mCanReadHistoricalData = true;
                            if (openFileOutput != null) {
                                try {
                                    openFileOutput.close();
                                } catch (java.io.IOException unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (java.lang.IllegalStateException unused2) {
                        java.lang.String str2 = androidx.appcompat.widget.ActivityChooserModel.DEFAULT_HISTORY_FILE_NAME;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("Error writing historical record file: ");
                        sb.append(androidx.appcompat.widget.ActivityChooserModel.this.mHistoryFileName);
                        androidx.appcompat.widget.ActivityChooserModel.this.mCanReadHistoricalData = true;
                    }
                } catch (java.io.IOException unused3) {
                    java.lang.String str3 = androidx.appcompat.widget.ActivityChooserModel.DEFAULT_HISTORY_FILE_NAME;
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("Error writing historical record file: ");
                    sb2.append(androidx.appcompat.widget.ActivityChooserModel.this.mHistoryFileName);
                    androidx.appcompat.widget.ActivityChooserModel.this.mCanReadHistoricalData = true;
                } catch (java.lang.IllegalArgumentException unused4) {
                    java.lang.String str4 = androidx.appcompat.widget.ActivityChooserModel.DEFAULT_HISTORY_FILE_NAME;
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    sb3.append("Error writing historical record file: ");
                    sb3.append(androidx.appcompat.widget.ActivityChooserModel.this.mHistoryFileName);
                    androidx.appcompat.widget.ActivityChooserModel.this.mCanReadHistoricalData = true;
                }
                return null;
            } catch (java.io.FileNotFoundException unused5) {
                java.lang.String str5 = androidx.appcompat.widget.ActivityChooserModel.DEFAULT_HISTORY_FILE_NAME;
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append("Error writing historical record file: ");
                sb4.append(str);
                return null;
            }
        }
    }

    private ActivityChooserModel(android.content.Context context, java.lang.String str) {
        this.mContext = context.getApplicationContext();
        if (android.text.TextUtils.isEmpty(str) || str.endsWith(HISTORY_FILE_EXTENSION)) {
            this.mHistoryFileName = str;
            return;
        }
        this.mHistoryFileName = str + HISTORY_FILE_EXTENSION;
    }

    private boolean addHistoricalRecord(androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord historicalRecord) {
        boolean add = this.mHistoricalRecords.add(historicalRecord);
        if (add) {
            this.mHistoricalRecordsChanged = true;
            pruneExcessiveHistoricalRecordsIfNeeded();
            persistHistoricalDataIfNeeded();
            sortActivitiesIfNeeded();
            notifyChanged();
        }
        return add;
    }

    private void ensureConsistentState() {
        boolean loadActivitiesIfNeeded = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (loadActivitiesIfNeeded) {
            sortActivitiesIfNeeded();
            notifyChanged();
        }
    }

    public static androidx.appcompat.widget.ActivityChooserModel get(android.content.Context context, java.lang.String str) {
        androidx.appcompat.widget.ActivityChooserModel activityChooserModel;
        synchronized (sRegistryLock) {
            java.util.Map<java.lang.String, androidx.appcompat.widget.ActivityChooserModel> map = sDataModelRegistry;
            activityChooserModel = map.get(str);
            if (activityChooserModel == null) {
                activityChooserModel = new androidx.appcompat.widget.ActivityChooserModel(context, str);
                map.put(str, activityChooserModel);
            }
        }
        return activityChooserModel;
    }

    private boolean loadActivitiesIfNeeded() {
        if (!this.mReloadActivities || this.mIntent == null) {
            return false;
        }
        this.mReloadActivities = false;
        this.mActivities.clear();
        java.util.List<android.content.pm.ResolveInfo> queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.mActivities.add(new androidx.appcompat.widget.ActivityChooserModel.ActivityResolveInfo(queryIntentActivities.get(i)));
        }
        return true;
    }

    private void persistHistoricalDataIfNeeded() {
        if (!this.mReadShareHistoryCalled) {
            throw new java.lang.IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.mHistoricalRecordsChanged) {
            this.mHistoricalRecordsChanged = false;
            if (android.text.TextUtils.isEmpty(this.mHistoryFileName)) {
                return;
            }
            new androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask().executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.util.ArrayList(this.mHistoricalRecords), this.mHistoryFileName);
        }
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int size = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (size <= 0) {
            return;
        }
        this.mHistoricalRecordsChanged = true;
        for (int i = 0; i < size; i++) {
            this.mHistoricalRecords.remove(0);
        }
    }

    private boolean readHistoricalDataIfNeeded() {
        if (!this.mCanReadHistoricalData || !this.mHistoricalRecordsChanged || android.text.TextUtils.isEmpty(this.mHistoryFileName)) {
            return false;
        }
        this.mCanReadHistoricalData = false;
        this.mReadShareHistoryCalled = true;
        readHistoricalDataImpl();
        return true;
    }

    private void readHistoricalDataImpl() {
        java.io.FileInputStream openFileInput;
        org.xmlpull.v1.XmlPullParser newPullParser;
        try {
            try {
                openFileInput = this.mContext.openFileInput(this.mHistoryFileName);
                try {
                    newPullParser = android.util.Xml.newPullParser();
                    newPullParser.setInput(openFileInput, "UTF-8");
                    for (int i = 0; i != 1 && i != 2; i = newPullParser.next()) {
                    }
                } catch (java.io.IOException unused) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Error reading historical recrod file: ");
                    sb.append(this.mHistoryFileName);
                    if (openFileInput == null) {
                        return;
                    }
                } catch (org.xmlpull.v1.XmlPullParserException unused2) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("Error reading historical recrod file: ");
                    sb2.append(this.mHistoryFileName);
                    if (openFileInput == null) {
                        return;
                    }
                }
                if (!TAG_HISTORICAL_RECORDS.equals(newPullParser.getName())) {
                    throw new org.xmlpull.v1.XmlPullParserException("Share records file does not start with historical-records tag.");
                }
                java.util.List<androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord> list = this.mHistoricalRecords;
                list.clear();
                while (true) {
                    int next = newPullParser.next();
                    if (next == 1) {
                        if (openFileInput == null) {
                            return;
                        }
                    } else if (next != 3 && next != 4) {
                        if (!TAG_HISTORICAL_RECORD.equals(newPullParser.getName())) {
                            throw new org.xmlpull.v1.XmlPullParserException("Share records file not well-formed.");
                        }
                        list.add(new androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord(newPullParser.getAttributeValue(null, "activity"), java.lang.Long.parseLong(newPullParser.getAttributeValue(null, "time")), java.lang.Float.parseFloat(newPullParser.getAttributeValue(null, ATTRIBUTE_WEIGHT))));
                    }
                }
                try {
                    openFileInput.close();
                } catch (java.io.IOException unused3) {
                }
            } catch (java.io.FileNotFoundException unused4) {
            }
        } catch (java.lang.Throwable th) {
            if (openFileInput != null) {
                try {
                    openFileInput.close();
                } catch (java.io.IOException unused5) {
                }
            }
            throw th;
        }
    }

    private boolean sortActivitiesIfNeeded() {
        if (this.mActivitySorter == null || this.mIntent == null || this.mActivities.isEmpty() || this.mHistoricalRecords.isEmpty()) {
            return false;
        }
        this.mActivitySorter.sort(this.mIntent, this.mActivities, java.util.Collections.unmodifiableList(this.mHistoricalRecords));
        return true;
    }

    public android.content.Intent chooseActivity(int i) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == null) {
                return null;
            }
            ensureConsistentState();
            android.content.pm.ActivityInfo activityInfo = this.mActivities.get(i).resolveInfo.activityInfo;
            android.content.ComponentName componentName = new android.content.ComponentName(activityInfo.packageName, activityInfo.name);
            android.content.Intent intent = new android.content.Intent(this.mIntent);
            intent.setComponent(componentName);
            if (this.mActivityChoserModelPolicy != null) {
                if (this.mActivityChoserModelPolicy.onChooseActivity(this, new android.content.Intent(intent))) {
                    return null;
                }
            }
            addHistoricalRecord(new androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord(componentName, java.lang.System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public android.content.pm.ResolveInfo getActivity(int i) {
        android.content.pm.ResolveInfo resolveInfo;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            resolveInfo = this.mActivities.get(i).resolveInfo;
        }
        return resolveInfo;
    }

    public int getActivityCount() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mActivities.size();
        }
        return size;
    }

    public int getActivityIndex(android.content.pm.ResolveInfo resolveInfo) {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            java.util.List<androidx.appcompat.widget.ActivityChooserModel.ActivityResolveInfo> list = this.mActivities;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public android.content.pm.ResolveInfo getDefaultActivity() {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            if (this.mActivities.isEmpty()) {
                return null;
            }
            return this.mActivities.get(0).resolveInfo;
        }
    }

    public int getHistoryMaxSize() {
        int i;
        synchronized (this.mInstanceLock) {
            i = this.mHistoryMaxSize;
        }
        return i;
    }

    public int getHistorySize() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mHistoricalRecords.size();
        }
        return size;
    }

    public android.content.Intent getIntent() {
        android.content.Intent intent;
        synchronized (this.mInstanceLock) {
            intent = this.mIntent;
        }
        return intent;
    }

    public void setActivitySorter(androidx.appcompat.widget.ActivityChooserModel.ActivitySorter activitySorter) {
        synchronized (this.mInstanceLock) {
            if (this.mActivitySorter == activitySorter) {
                return;
            }
            this.mActivitySorter = activitySorter;
            if (sortActivitiesIfNeeded()) {
                notifyChanged();
            }
        }
    }

    public void setDefaultActivity(int i) {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            androidx.appcompat.widget.ActivityChooserModel.ActivityResolveInfo activityResolveInfo = this.mActivities.get(i);
            androidx.appcompat.widget.ActivityChooserModel.ActivityResolveInfo activityResolveInfo2 = this.mActivities.get(0);
            float f = activityResolveInfo2 != null ? (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f : 1.0f;
            android.content.pm.ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
            addHistoricalRecord(new androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord(new android.content.ComponentName(activityInfo.packageName, activityInfo.name), java.lang.System.currentTimeMillis(), f));
        }
    }

    public void setHistoryMaxSize(int i) {
        synchronized (this.mInstanceLock) {
            if (this.mHistoryMaxSize == i) {
                return;
            }
            this.mHistoryMaxSize = i;
            pruneExcessiveHistoricalRecordsIfNeeded();
            if (sortActivitiesIfNeeded()) {
                notifyChanged();
            }
        }
    }

    public void setIntent(android.content.Intent intent) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == intent) {
                return;
            }
            this.mIntent = intent;
            this.mReloadActivities = true;
            ensureConsistentState();
        }
    }

    public void setOnChooseActivityListener(androidx.appcompat.widget.ActivityChooserModel.OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.mInstanceLock) {
            this.mActivityChoserModelPolicy = onChooseActivityListener;
        }
    }
}
