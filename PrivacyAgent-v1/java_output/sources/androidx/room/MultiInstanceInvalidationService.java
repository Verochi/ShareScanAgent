package androidx.room;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends android.app.Service {
    int mMaxClientId = 0;
    final java.util.HashMap<java.lang.Integer, java.lang.String> mClientNames = new java.util.HashMap<>();
    final android.os.RemoteCallbackList<androidx.room.IMultiInstanceInvalidationCallback> mCallbackList = new androidx.room.MultiInstanceInvalidationService.AnonymousClass1();
    private final androidx.room.IMultiInstanceInvalidationService.Stub mBinder = new androidx.room.MultiInstanceInvalidationService.AnonymousClass2();

    /* renamed from: androidx.room.MultiInstanceInvalidationService$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.RemoteCallbackList<androidx.room.IMultiInstanceInvalidationCallback> {
        public AnonymousClass1() {
        }

        @Override // android.os.RemoteCallbackList
        public void onCallbackDied(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, java.lang.Object obj) {
            androidx.room.MultiInstanceInvalidationService.this.mClientNames.remove(java.lang.Integer.valueOf(((java.lang.Integer) obj).intValue()));
        }
    }

    /* renamed from: androidx.room.MultiInstanceInvalidationService$2, reason: invalid class name */
    public class AnonymousClass2 extends androidx.room.IMultiInstanceInvalidationService.Stub {
        public AnonymousClass2() {
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void broadcastInvalidation(int i, java.lang.String[] strArr) {
            synchronized (androidx.room.MultiInstanceInvalidationService.this.mCallbackList) {
                java.lang.String str = androidx.room.MultiInstanceInvalidationService.this.mClientNames.get(java.lang.Integer.valueOf(i));
                if (str == null) {
                    return;
                }
                int beginBroadcast = androidx.room.MultiInstanceInvalidationService.this.mCallbackList.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    try {
                        int intValue = ((java.lang.Integer) androidx.room.MultiInstanceInvalidationService.this.mCallbackList.getBroadcastCookie(i2)).intValue();
                        java.lang.String str2 = androidx.room.MultiInstanceInvalidationService.this.mClientNames.get(java.lang.Integer.valueOf(intValue));
                        if (i != intValue && str.equals(str2)) {
                            try {
                                androidx.room.MultiInstanceInvalidationService.this.mCallbackList.getBroadcastItem(i2).onInvalidation(strArr);
                            } catch (android.os.RemoteException unused) {
                            }
                        }
                    } finally {
                        androidx.room.MultiInstanceInvalidationService.this.mCallbackList.finishBroadcast();
                    }
                }
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public int registerCallback(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, java.lang.String str) {
            if (str == null) {
                return 0;
            }
            synchronized (androidx.room.MultiInstanceInvalidationService.this.mCallbackList) {
                androidx.room.MultiInstanceInvalidationService multiInstanceInvalidationService = androidx.room.MultiInstanceInvalidationService.this;
                int i = multiInstanceInvalidationService.mMaxClientId + 1;
                multiInstanceInvalidationService.mMaxClientId = i;
                if (multiInstanceInvalidationService.mCallbackList.register(iMultiInstanceInvalidationCallback, java.lang.Integer.valueOf(i))) {
                    androidx.room.MultiInstanceInvalidationService.this.mClientNames.put(java.lang.Integer.valueOf(i), str);
                    return i;
                }
                androidx.room.MultiInstanceInvalidationService multiInstanceInvalidationService2 = androidx.room.MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.mMaxClientId--;
                return 0;
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void unregisterCallback(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i) {
            synchronized (androidx.room.MultiInstanceInvalidationService.this.mCallbackList) {
                androidx.room.MultiInstanceInvalidationService.this.mCallbackList.unregister(iMultiInstanceInvalidationCallback);
                androidx.room.MultiInstanceInvalidationService.this.mClientNames.remove(java.lang.Integer.valueOf(i));
            }
        }
    }

    @Override // android.app.Service
    @androidx.annotation.Nullable
    public android.os.IBinder onBind(android.content.Intent intent) {
        return this.mBinder;
    }
}
