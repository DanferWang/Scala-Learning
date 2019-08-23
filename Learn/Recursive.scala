package Danfer.Learn

object Recursive {
  def main(args: Array[String]): Unit = {
    printIt(4)
  }

  def printIt(n: Int): Unit = {
    if (n > 2) {
      printIt(n - 1)
    }
    println("n=" + n)
  }
}