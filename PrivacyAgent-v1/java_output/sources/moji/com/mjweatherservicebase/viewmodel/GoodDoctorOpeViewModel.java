package moji.com.mjweatherservicebase.viewmodel;

/* loaded from: classes20.dex */
public class GoodDoctorOpeViewModel extends androidx.lifecycle.ViewModel {
    public moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData n;

    public static class LiveData extends androidx.lifecycle.MediatorLiveData<moji.com.mjweatherservicebase.data.AllergyOperationData> {
        public boolean a;
        public boolean b;
        public boolean c;
        public moji.com.mjweatherservicebase.data.AllergyOperationData d = new moji.com.mjweatherservicebase.data.AllergyOperationData();

        /* renamed from: moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel$LiveData$1, reason: invalid class name */
        public class AnonymousClass1 implements androidx.lifecycle.Observer<com.moji.opevent.model.OperationEvent> {
            public AnonymousClass1() {
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(com.moji.opevent.model.OperationEvent operationEvent) {
                moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData.this.d.mDoctorBanner = moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData.this.getValidOperationEvent(operationEvent);
                moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData.this.a = true;
                moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData.this.f();
            }
        }

        /* renamed from: moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel$LiveData$2, reason: invalid class name */
        public class AnonymousClass2 implements androidx.lifecycle.Observer<com.moji.opevent.model.OperationEvent> {
            public AnonymousClass2() {
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(com.moji.opevent.model.OperationEvent operationEvent) {
                moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData.this.d.mChineseMedicine = moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData.this.getValidOperationEvent(operationEvent);
                moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData.this.b = true;
                moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData.this.f();
            }
        }

        /* renamed from: moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel$LiveData$3, reason: invalid class name */
        public class AnonymousClass3 implements androidx.lifecycle.Observer<com.moji.opevent.model.OperationEvent> {
            public AnonymousClass3() {
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(com.moji.opevent.model.OperationEvent operationEvent) {
                moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData.this.d.mBodySelfTesting = moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData.this.getValidOperationEvent(operationEvent);
                moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData.this.c = true;
                moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData.this.f();
            }
        }

        public LiveData(com.moji.opevent.OperationEventPage operationEventPage) {
            com.moji.opevent.FixedCityOperationEventRepository fixedCityOperationEventRepository = new com.moji.opevent.FixedCityOperationEventRepository(com.moji.areamanagement.MJAreaManager.getCurrentArea(), operationEventPage);
            addSource(fixedCityOperationEventRepository.operationEventLiveData(com.moji.opevent.model.OperationEventRegion.R_FLU_BANNER1), new moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData.AnonymousClass1());
            addSource(fixedCityOperationEventRepository.operationEventLiveData(com.moji.opevent.model.OperationEventRegion.R_FLU_ITEM1), new moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData.AnonymousClass2());
            addSource(fixedCityOperationEventRepository.operationEventLiveData(com.moji.opevent.model.OperationEventRegion.R_FLU_ITEM2), new moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData.AnonymousClass3());
        }

        public final void f() {
            if (this.a && this.b && this.c) {
                setValue(this.d);
            }
        }

        public com.moji.opevent.model.OperationEvent getValidOperationEvent(com.moji.opevent.model.OperationEvent operationEvent) {
            java.util.ArrayList arrayList;
            if (operationEvent == null || (arrayList = operationEvent.entrance_res_list) == null || arrayList.isEmpty()) {
                return null;
            }
            return operationEvent;
        }
    }

    public moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData getLiveData(com.moji.opevent.OperationEventPage operationEventPage) {
        if (this.n == null) {
            this.n = new moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.LiveData(operationEventPage);
        }
        return this.n;
    }
}
