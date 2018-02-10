package arrow.free.instances

import arrow.Kind
import arrow.TC
import arrow.free.Cofree
import arrow.free.CofreeOf
import arrow.free.CofreePartialOf
import arrow.free.fix
import arrow.instance
import arrow.typeclasses.Comonad
import arrow.typeclasses.Functor

@instance(Cofree::class)
interface CofreeFunctorInstance<S> : Functor<CofreePartialOf<S>>, TC {
    override fun <A, B> map(fa: CofreeOf<S, A>, f: (A) -> B): Cofree<S, B> = fa.fix().map(f)
}

@instance(Cofree::class)
interface CofreeComonadInstance<S> : CofreeFunctorInstance<S>, Comonad<CofreePartialOf<S>>, TC {
    override fun <A, B> coflatMap(fa: CofreeOf<S, A>, f: (CofreeOf<S, A>) -> B): Cofree<S, B> = fa.fix().coflatMap(f)

    override fun <A> extractM(fa: CofreeOf<S, A>): A = fa.fix().extractM()

    override fun <A> duplicate(fa: CofreeOf<S, A>): Kind<CofreePartialOf<S>, Cofree<S, A>> = fa.fix().duplicate()
}
