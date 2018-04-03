package scala_comonad

object Main extends App {
  println("Run the tests with sbt test")
}

trait Functor[F[_]] {
  def map[A,B](x: F[A])(f: A => B): F[B]
}

trait Monad[M[_]] extends Functor[M] {
  def unit[A](a: A): M[A]
  def join[A](mma: M[M[A]]): M[A]
}

case class Reader[R,A](run: R => A)

object Reader {
  def ask[R]: Reader[R,R] = Reader(r => r)
  def join[R,A](r: Reader[R,Reader[R,A]]) =
    Reader((c: R) => r.run(c).run(c))
}
