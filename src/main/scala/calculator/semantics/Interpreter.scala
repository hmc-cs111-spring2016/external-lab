package calculator

import calculator.ir._

package object semantics {
  def eval(expr: Expr): Int = expr match {
    case Num(i) ⇒ i
    case Plus(left, right) ⇒ eval(left) + eval(right)
    case Minus(left, right) => eval(left) - eval(right)
    case Mult(left, right) => eval(left) * eval(right)
    case Div(left, right) => eval(left) / eval(right)
    case Paren(expr) => eval(expr)
  }
}