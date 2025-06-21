package androidx.fragment.app;

@android.annotation.SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class BackStackState implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<androidx.fragment.app.BackStackState> CREATOR = new androidx.fragment.app.BackStackState.AnonymousClass1();
    private static final java.lang.String TAG = "FragmentManager";
    final int mBreadCrumbShortTitleRes;
    final java.lang.CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final java.lang.CharSequence mBreadCrumbTitleText;
    final int[] mCurrentMaxLifecycleStates;
    final java.util.ArrayList<java.lang.String> mFragmentWhos;
    final int mIndex;
    final java.lang.String mName;
    final int[] mOldMaxLifecycleStates;
    final int[] mOps;
    final boolean mReorderingAllowed;
    final java.util.ArrayList<java.lang.String> mSharedElementSourceNames;
    final java.util.ArrayList<java.lang.String> mSharedElementTargetNames;
    final int mTransition;

    /* renamed from: androidx.fragment.app.BackStackState$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<androidx.fragment.app.BackStackState> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.fragment.app.BackStackState createFromParcel(android.os.Parcel parcel) {
            return new androidx.fragment.app.BackStackState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.fragment.app.BackStackState[] newArray(int i) {
            return new androidx.fragment.app.BackStackState[i];
        }
    }

    public BackStackState(android.os.Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mFragmentWhos = parcel.createStringArrayList();
        this.mOldMaxLifecycleStates = parcel.createIntArray();
        this.mCurrentMaxLifecycleStates = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (java.lang.CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (java.lang.CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
        this.mReorderingAllowed = parcel.readInt() != 0;
    }

    public BackStackState(androidx.fragment.app.BackStackRecord backStackRecord) {
        int size = backStackRecord.mOps.size();
        this.mOps = new int[size * 5];
        if (!backStackRecord.mAddToBackStack) {
            throw new java.lang.IllegalStateException("Not on back stack");
        }
        this.mFragmentWhos = new java.util.ArrayList<>(size);
        this.mOldMaxLifecycleStates = new int[size];
        this.mCurrentMaxLifecycleStates = new int[size];
        int i = 0;
        int i2 = 0;
        while (i < size) {
            androidx.fragment.app.FragmentTransaction.Op op = backStackRecord.mOps.get(i);
            int i3 = i2 + 1;
            this.mOps[i2] = op.mCmd;
            java.util.ArrayList<java.lang.String> arrayList = this.mFragmentWhos;
            androidx.fragment.app.Fragment fragment = op.mFragment;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.mOps;
            int i4 = i3 + 1;
            iArr[i3] = op.mEnterAnim;
            int i5 = i4 + 1;
            iArr[i4] = op.mExitAnim;
            int i6 = i5 + 1;
            iArr[i5] = op.mPopEnterAnim;
            iArr[i6] = op.mPopExitAnim;
            this.mOldMaxLifecycleStates[i] = op.mOldMaxState.ordinal();
            this.mCurrentMaxLifecycleStates[i] = op.mCurrentMaxState.ordinal();
            i++;
            i2 = i6 + 1;
        }
        this.mTransition = backStackRecord.mTransition;
        this.mName = backStackRecord.mName;
        this.mIndex = backStackRecord.mIndex;
        this.mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
        this.mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
        this.mSharedElementSourceNames = backStackRecord.mSharedElementSourceNames;
        this.mSharedElementTargetNames = backStackRecord.mSharedElementTargetNames;
        this.mReorderingAllowed = backStackRecord.mReorderingAllowed;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public androidx.fragment.app.BackStackRecord instantiate(androidx.fragment.app.FragmentManager fragmentManager) {
        androidx.fragment.app.BackStackRecord backStackRecord = new androidx.fragment.app.BackStackRecord(fragmentManager);
        int i = 0;
        int i2 = 0;
        while (i < this.mOps.length) {
            androidx.fragment.app.FragmentTransaction.Op op = new androidx.fragment.app.FragmentTransaction.Op();
            int i3 = i + 1;
            op.mCmd = this.mOps[i];
            if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Instantiate ");
                sb.append(backStackRecord);
                sb.append(" op #");
                sb.append(i2);
                sb.append(" base fragment #");
                sb.append(this.mOps[i3]);
            }
            java.lang.String str = this.mFragmentWhos.get(i2);
            if (str != null) {
                op.mFragment = fragmentManager.findActiveFragment(str);
            } else {
                op.mFragment = null;
            }
            op.mOldMaxState = androidx.lifecycle.Lifecycle.State.values()[this.mOldMaxLifecycleStates[i2]];
            op.mCurrentMaxState = androidx.lifecycle.Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[i2]];
            int[] iArr = this.mOps;
            int i4 = i3 + 1;
            int i5 = iArr[i3];
            op.mEnterAnim = i5;
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            op.mExitAnim = i7;
            int i8 = i6 + 1;
            int i9 = iArr[i6];
            op.mPopEnterAnim = i9;
            int i10 = iArr[i8];
            op.mPopExitAnim = i10;
            backStackRecord.mEnterAnim = i5;
            backStackRecord.mExitAnim = i7;
            backStackRecord.mPopEnterAnim = i9;
            backStackRecord.mPopExitAnim = i10;
            backStackRecord.addOp(op);
            i2++;
            i = i8 + 1;
        }
        backStackRecord.mTransition = this.mTransition;
        backStackRecord.mName = this.mName;
        backStackRecord.mIndex = this.mIndex;
        backStackRecord.mAddToBackStack = true;
        backStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        backStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        backStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        backStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        backStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
        backStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
        backStackRecord.mReorderingAllowed = this.mReorderingAllowed;
        backStackRecord.bumpBackStackNesting(1);
        return backStackRecord;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeIntArray(this.mOps);
        parcel.writeStringList(this.mFragmentWhos);
        parcel.writeIntArray(this.mOldMaxLifecycleStates);
        parcel.writeIntArray(this.mCurrentMaxLifecycleStates);
        parcel.writeInt(this.mTransition);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        android.text.TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        android.text.TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList(this.mSharedElementSourceNames);
        parcel.writeStringList(this.mSharedElementTargetNames);
        parcel.writeInt(this.mReorderingAllowed ? 1 : 0);
    }
}
