package moji.com.mjwallet.qa;

@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"Lmoji/com/mjwallet/qa/QAViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "getQAList", "", "Lmoji/com/mjwallet/qa/QAModel;", "MJWallet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class QAViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    public final java.util.List<moji.com.mjwallet.qa.QAModel> getQAList() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new moji.com.mjwallet.qa.QAModel("提现目前支持的收款账户类型有哪些？", "目前仅支持支付宝一种类型，若您还没有支付宝账户，需要去支付宝app进行注册开通。", true));
        arrayList.add(new moji.com.mjwallet.qa.QAModel("提现为什么必须填写收款账号实名？", "支付宝系统打款时验证姓名和收款账号是一一对应才能打款成功。", false, 4, null));
        arrayList.add(new moji.com.mjwallet.qa.QAModel("单笔提现最高金额是多少？", "目前单笔最高提现金额不能超过50元。", false, 4, null));
        arrayList.add(new moji.com.mjwallet.qa.QAModel("提现会收手续费吗？", "提现免收手续费，但提现金额至少10元。", false, 4, null));
        arrayList.add(new moji.com.mjwallet.qa.QAModel("怎么查看提现申请的进度？", "查看方法：墨迹钱包首页-提现进度-根据时间查看对应的提现记录信息，包括提现金额、收款账号。", false, 4, null));
        arrayList.add(new moji.com.mjwallet.qa.QAModel("提现申请提交成功后，多久可以到账？", "正常情况下1-3个工作日到账，特殊情况请关注墨迹钱包首页公告通知。", false, 4, null));
        arrayList.add(new moji.com.mjwallet.qa.QAModel("提现不成功会有哪些情况？", "支付宝收款账号有误或不存在；提现不成功，提现的金额会返回到墨迹钱包余额中。", false, 4, null));
        arrayList.add(new moji.com.mjwallet.qa.QAModel("若有1笔提现订单没有完成，是否可以继续提现？", "当有1笔提现订单正在处理中时，为了订单的处理效率和质量，不允许再次提现，需要等当前订单处理完成之后才能继续提现。", false, 4, null));
        arrayList.add(new moji.com.mjwallet.qa.QAModel("提现的收款账号可以更换吗？", "支持更换。", false, 4, null));
        arrayList.add(new moji.com.mjwallet.qa.QAModel("一个支付宝账号可以绑定多个墨迹账号吗？", "不能，一个支付宝账号只能绑定一个墨迹账号。", false, 4, null));
        arrayList.add(new moji.com.mjwallet.qa.QAModel("一天最多可以提现几次？", " 一天最多可提现1次", false, 4, null));
        return arrayList;
    }
}
