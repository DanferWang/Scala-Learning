package Danfer.Learn

import scala.collection.immutable.ListMap
import scala.io.StdIn

object CharCounter {
  def main(args: Array[String]): Unit = {
    println("Input the Content You Want To Count: ")
    var sentence = " "
    sentence = StdIn.readLine()
    var countMap = new ListMap[Char, Int]
    var map1 = sentence.toList
    var map2 = map1.foldLeft(countMap)(count)
    var map3 = ListMap(map2.toSeq.sortWith(_._2 > _._2): _*)
    var map4 = map3.removed(' ')
    println("The Counted Result is as Follow:")
    for (t <- map4) {
      println(t)
    }

  }

  def count(map: ListMap[Char, Int], c: Char): ListMap[Char, Int] = {
    map + (c -> (map.getOrElse(c, 0) + 1))
  }
}