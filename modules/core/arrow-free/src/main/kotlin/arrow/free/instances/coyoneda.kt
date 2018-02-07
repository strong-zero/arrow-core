package arrow.free.instances

import arrow.*
import arrow.free.*
import arrow.typeclasses.Functor

@instance(Coyoneda::class)
interface CoyonedaFunctorInstance<F, G> : Functor<CoyonedaKindPartial<F, G>> {
    override fun <A, B> map(fa: CoyonedaKind<F, G, A>, f: (A) -> B): Coyoneda<F, G, B> = fa.reify().map(f)
}
