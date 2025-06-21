package androidx.fragment.app;

@android.annotation.SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentManagerState implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<androidx.fragment.app.FragmentManagerState> CREATOR = new androidx.fragment.app.FragmentManagerState.AnonymousClass1();
    java.util.ArrayList<androidx.fragment.app.FragmentState> mActive;
    java.util.ArrayList<java.lang.String> mAdded;
    androidx.fragment.app.BackStackState[] mBackStack;
    int mBackStackIndex;
    java.util.ArrayList<androidx.fragment.app.FragmentManager.LaunchedFragmentInfo> mLaunchedFragments;
    java.lang.String mPrimaryNavActiveWho;
    java.util.ArrayList<java.lang.String> mResultKeys;
    java.util.ArrayList<android.os.Bundle> mResults;

    /* renamed from: androidx.fragment.app.FragmentManagerState$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<androidx.fragment.app.FragmentManagerState> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.fragment.app.FragmentManagerState createFromParcel(android.os.Parcel parcel) {
            return new androidx.fragment.app.FragmentManagerState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.fragment.app.FragmentManagerState[] newArray(int i) {
            return new androidx.fragment.app.FragmentManagerState[i];
        }
    }

    public FragmentManagerState() {
        this.mPrimaryNavActiveWho = null;
        this.mResultKeys = new java.util.ArrayList<>();
        this.mResults = new java.util.ArrayList<>();
    }

    public FragmentManagerState(android.os.Parcel parcel) {
        this.mPrimaryNavActiveWho = null;
        this.mResultKeys = new java.util.ArrayList<>();
        this.mResults = new java.util.ArrayList<>();
        this.mActive = parcel.createTypedArrayList(androidx.fragment.app.FragmentState.CREATOR);
        this.mAdded = parcel.createStringArrayList();
        this.mBackStack = (androidx.fragment.app.BackStackState[]) parcel.createTypedArray(androidx.fragment.app.BackStackState.CREATOR);
        this.mBackStackIndex = parcel.readInt();
        this.mPrimaryNavActiveWho = parcel.readString();
        this.mResultKeys = parcel.createStringArrayList();
        this.mResults = parcel.createTypedArrayList(android.os.Bundle.CREATOR);
        this.mLaunchedFragments = parcel.createTypedArrayList(androidx.fragment.app.FragmentManager.LaunchedFragmentInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeTypedList(this.mActive);
        parcel.writeStringList(this.mAdded);
        parcel.writeTypedArray(this.mBackStack, i);
        parcel.writeInt(this.mBackStackIndex);
        parcel.writeString(this.mPrimaryNavActiveWho);
        parcel.writeStringList(this.mResultKeys);
        parcel.writeTypedList(this.mResults);
        parcel.writeTypedList(this.mLaunchedFragments);
    }
}
