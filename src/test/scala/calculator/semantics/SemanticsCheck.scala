package calculator.semantics

import scala.language.implicitConversions
import org.scalacheck._
import org.scalacheck.Prop.{forAll,BooleanOperators,throws}
import Gen._
import Arbitrary.arbitrary
import calculator.ir._

object CalcInterpreterSpec extends Properties("Interpreter") with CalcSugar {

    // some syntactic sugar for expressing interpreter tests
    implicit class TreeChecker(input: Expr) {
      def ~>(output: Int) = {
        val result = eval(input)
        result == output
      }
      
      def ~/~>[T <: Throwable](c: Class[T]) = {
        throws(c){eval(input)}
      }
    }
    
    property("numbers") = forAll { (n: Int) ⇒
      Num(n) ~> n
    } 
    
    property("addition") = forAll { (n1: Int, n2: Int) ⇒
      (n1 |+| n2) ~> (n1 + n2)   
    } 
    
    property("subtraction") = forAll { (n1: Int, n2: Int) ⇒
      (n1 |-| n2) ~> (n1 - n2)   
    } 
    
    property("multiplication") = forAll { (n1: Int, n2: Int) ⇒
      (n1 |*| n2) ~> (n1 * n2)   
    } 
    
    property("division") = forAll { (n1: Int, n2: Int) ⇒
      val expr = n1 |/| n2
      if (n2 == 0)
        expr ~/~> classOf[ArithmeticException]
      else
        expr ~> (n1 / n2)
    }
}