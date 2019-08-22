package Danfer.Learn

import scala.io.StdIn

object Input {
  def main(args: Array[String]): Unit = {
    //input
    println("input your name: ")
    val name=StdIn.readLine()
    println("input your age: ")
    val age=StdIn.readInt()

    //output
    printf("Your name is %s. and your age is %d",name,age)

  }

}
