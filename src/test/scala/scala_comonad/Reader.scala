package scala_comonad

import org.scalatest._

class ReaderSpec extends FreeSpec with Matchers {
  "Reader" - {
    "reads" in {
      Reader.ask should be(false)
    }
  }
}
