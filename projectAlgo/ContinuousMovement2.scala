package Danfer.projectAlgo

import scala.collection.mutable.ArrayBuffer

object ContinuousMovement2 {
  def main(args: Array[String]): Unit = {
    val testArray = Array(0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1)
    var movement = new ArrayBuffer[(Int, Int)]
    var index = 0
    var head = 0
    var tail = 0
    var flag = true
    while (index < testArray.length) {
      if (testArray(index) == 1) {
        if (flag) {
          flag = false
          head = index
          tail = index
        }
        else {
          tail += 1
        }
      }
      else if (testArray(index) == 0 && !flag) {
        flag = true
        movement.append((head, tail))
      }
      index += 1
    }
    if (!flag) {
      movement.append((head, tail))
    }
    movement.foreach(println)
  }
}