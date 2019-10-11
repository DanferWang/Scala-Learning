package Danfer.projectAlgo

import scala.collection.mutable.ArrayBuffer
import util.control.Breaks._

object ContinuousMovement {
  def main(args: Array[String]): Unit = {
    val testArray = Array(0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1) //测试数组，1：true，0：false
    val withIndex = testArray.zipWithIndex //添加下标
    //testArray.zipWithIndex.foreach(println)
    var a = withIndex.filter(_._1 == 1) //过滤得到1：true
    //a.foreach(println)
    var movement = new ArrayBuffer[(Int, Int)] //new一个buffer来存放（起点，终点）
    var i = 0
    while (i < a.length - 1) { //遍历过滤后的a:Array[Int,Int]，除去最后一个
      var end = i
      var start = i
      breakable {
        while (true) { //判断1：true的下标是否连续
          if (i < a.length - 1 && a(i)._2 + 1 == a(i + 1)._2) {
            end += 1
            i += 1
          }
          else {
            movement.append((a(start)._2, a(end)._2)) //开始不连续，则得到（起点，终点），加入buffer
            break()
          }
        }
      }
      //处理0，1
      if (i==a.length -2 && a.last._2 > (movement.last._2 + 1)) { //若与倒数第二个下标状态一致，则更新终点
        movement.append((a.last._2, a.last._2))
      }
      i += 1
    }
    movement.foreach(println) //输出运动
  }
}
