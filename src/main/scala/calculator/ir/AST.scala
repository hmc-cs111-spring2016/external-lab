package calculator.ir

sealed abstract class Expr

case class Num(n: Int) extends Expr
case class Plus(left: Expr, right: Expr) extends Expr
case class Minus(left: Expr, right: Expr) extends Expr
case class Times(left: Expr, right: Expr) extends Expr
case class Divide(left: Expr, right: Expr) extends Expr
