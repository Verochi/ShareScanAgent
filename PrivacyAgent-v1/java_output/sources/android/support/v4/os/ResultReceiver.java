package android.support.v4.os;

@android.annotation.SuppressLint({"BanParcelableUsage"})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ResultReceiver implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<android.support.v4.os.ResultReceiver> CREATOR = new android.support.v4.os.ResultReceiver.AnonymousClass1();
    final android.os.Handler mHandler;
    final boolean mLocal;
    android.support.v4.os.IResultReceiver mReceiver;

    /* renamed from: android.support.v4.os.ResultReceiver$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<android.support.v4.os.ResultReceiver> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public android.support.v4.os.ResultReceiver createFromParcel(android.os.Parcel parcel) {
            return new android.support.v4.os.ResultReceiver(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public android.support.v4.os.ResultReceiver[] newArray(int i) {
            return new android.support.v4.os.ResultReceiver[i];
        }
    }

    public class MyResultReceiver extends android.support.v4.os.IResultReceiver.Stub {
        public MyResultReceiver() {
        }

        @Override // android.support.v4.os.IResultReceiver
        public void send(int i, android.os.Bundle bundle) {
            android.support.v4.os.ResultReceiver resultReceiver = android.support.v4.os.ResultReceiver.this;
            android.os.Handler handler = resultReceiver.mHandler;
            if (handler != null) {
                handler.post(resultReceiver.new MyRunnable(i, bundle));
            } else {
                resultReceiver.onReceiveResult(i, bundle);
            }
        }
    }

    public class MyRunnable implements java.lang.Runnable {
        final int mResultCode;
        final android.os.Bundle mResultData;

        public MyRunnable(int i, android.os.Bundle bundle) {
            this.mResultCode = i;
            this.mResultData = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.support.v4.os.ResultReceiver.this.onReceiveResult(this.mResultCode, this.mResultData);
        }
    }

    public ResultReceiver(android.os.Handler handler) {
        this.mLocal = true;
        this.mHandler = handler;
    }

    public ResultReceiver(android.os.Parcel parcel) {
        this.mLocal = false;
        this.mHandler = null;
        this.mReceiver = android.support.v4.os.IResultReceiver.Stub.asInterface(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void onReceiveResult(int i, android.os.Bundle bundle) {
    }

    public void send(int i, android.os.Bundle bundle) {
        if (this.mLocal) {
            android.os.Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new android.support.v4.os.ResultReceiver.MyRunnable(i, bundle));
                return;
            } else {
                onReceiveResult(i, bundle);
                return;
            }
        }
        android.support.v4.os.IResultReceiver iResultReceiver = this.mReceiver;
        if (iResultReceiver != null) {
            try {
                iResultReceiver.send(i, bundle);
            } catch (android.os.RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        synchronized (this) {
            if (this.mReceiver == null) {
                this.mReceiver = new android.support.v4.os.ResultReceiver.MyResultReceiver();
            }
            parcel.writeStrongBinder(this.mReceiver.asBinder());
        }
    }
}
