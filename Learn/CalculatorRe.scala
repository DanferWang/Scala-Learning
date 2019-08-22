package Danfer.Learn

import scala.io.StdIn

object CalculatorRe {
  var full: String = " "

  def main(args: Array[String]): Unit = {
    while (true) {
      var a: Double = 0
      var b: Double = 0
      var op: String = " "
      var result: Double = 0

      println("input the formula you want to calculate: ")
      println("the first figure:")
      a = StdIn.readDouble()
      println("the operation symbol:")
      op = StdIn.readLine()
      println("the second figure:")
      b = StdIn.readDouble()
      full = a + op + b

      if (op == "+") add(a, b)
      else if (op == "-") minus(a, b)
      else if (op == "*") multi(a, b)
      else if (op == "/") div(a, b)

    }
  }

  def add(a: Double, b: Double): Unit = {
    var res: Double = a + b
    printf("the result is %s=%f \n", full, res)
  }

  def minus(a: Double, b: Double): Unit = {
    var res: Double = a - b
    printf("the result is %s=%f \n", full, res)
  }

  def multi(a: Double, b: Double): Unit = {
    var res: Double = a * b
    printf("the result is %s=%f \n", full, res)
  }

  def div(a: Double, b: Double): Unit = {
    if (b != 0) {
      var res: Double = a / b
      printf("the result is %s=%f \n", full, res)
    }
    else {
      println("there is something going wrong!")
    }
  }
}
