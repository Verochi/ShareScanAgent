package kotlin.contracts;

@kotlin.SinceKotlin(version = "1.3")
@kotlin.internal.ContractsDsl
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH'J\b\u0010\t\u001a\u00020\nH'J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'J\b\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, d2 = {"Lkotlin/contracts/ContractBuilder;", "", "callsInPlace", "Lkotlin/contracts/CallsInPlace;", "R", "lambda", "Lkotlin/Function;", "kind", "Lkotlin/contracts/InvocationKind;", "returns", "Lkotlin/contracts/Returns;", "value", "returnsNotNull", "Lkotlin/contracts/ReturnsNotNull;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.contracts.ExperimentalContracts
/* loaded from: classes14.dex */
public interface ContractBuilder {

    @kotlin.Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ kotlin.contracts.CallsInPlace callsInPlace$default(kotlin.contracts.ContractBuilder contractBuilder, kotlin.Function function, kotlin.contracts.InvocationKind invocationKind, int i, java.lang.Object obj) {
            if (obj != null) {
                throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
            }
            if ((i & 2) != 0) {
                invocationKind = kotlin.contracts.InvocationKind.UNKNOWN;
            }
            return contractBuilder.callsInPlace(function, invocationKind);
        }
    }

    @kotlin.internal.ContractsDsl
    @org.jetbrains.annotations.NotNull
    <R> kotlin.contracts.CallsInPlace callsInPlace(@org.jetbrains.annotations.NotNull kotlin.Function<? extends R> lambda, @org.jetbrains.annotations.NotNull kotlin.contracts.InvocationKind kind);

    @kotlin.internal.ContractsDsl
    @org.jetbrains.annotations.NotNull
    kotlin.contracts.Returns returns();

    @kotlin.internal.ContractsDsl
    @org.jetbrains.annotations.NotNull
    kotlin.contracts.Returns returns(@org.jetbrains.annotations.Nullable java.lang.Object value);

    @kotlin.internal.ContractsDsl
    @org.jetbrains.annotations.NotNull
    kotlin.contracts.ReturnsNotNull returnsNotNull();
}
