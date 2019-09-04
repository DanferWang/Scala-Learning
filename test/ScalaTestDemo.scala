package Danfer.test

import scala.collection.immutable.ListMap
import scala.collection.mutable.ArrayBuffer
import util.control.Breaks._

object ScalaTestDemo {
  def main(args: Array[String]): Unit = {
    var array = Array[Int](2, 4, 8, 9, 1, 3, 5, 7, 6, 0)
    //1 将数字全部加1输出
    println("result 1:")
    for (i <- 0 until array.length) { //对数组遍历+1
      printf("%d\t", array(i) + 1)
    }
    println()

    //2 求数组的和
    println("result 2:")
    var sum = 0
    for (i <- 0 until array.length) { //对数组遍历累加
      sum += array(i)
    }
    println("数组和为" + sum)

    //3 求数组中的最大值
    println("result 3:\n数组最大值" + array.max) //直接调用自有方法.max()

    //4 求最小值
    println("result 4:\n数组最小值" + array.min) //直接调用自有方法.min()

    //5 求数组中所有的元素的个数
    println("result 5:\n数组元素个数" + array.length) //直接调用自有方法.length()

    //6 求数组中的偶数的个数
    var even = 0
    for (i <- 0 until array.length) { //遍历数组
      if (array(i) % 2 == 0) { //判断元素是否可被2整除，true则累加
        even += 1
      }
    }
    println("result 6:\n数组中偶数的个数为" + even)

    //7 过滤掉数组中的所有的奇数,得到所有的偶数
    var evenBuffer = new ArrayBuffer[Int]
    for (i <- 0 until array.length) { //遍历数组
      if (array(i) % 2 == 0) { //判断元素是否可被2整除，true则添加到evenBuffer
        evenBuffer.append(array(i))
      }
    }
    printf("result 7:\n数组中所有偶数：")
    for (item <- evenBuffer) { //遍历输出
      print(item + "  ")
    }
    println()

    //8 保留3的倍数的数字,但是不要0
    var triBuffer = new ArrayBuffer[Int]
    for (i <- 0 until array.length) { //遍历数组
      if (array(i) % 3 == 0 && array(i) != 0) { //判断元素是否非零且是否可被3整除，true则添加到evenBuffer
        triBuffer.append(array(i))
      }
    }
    printf("result 3:\n数组中除0外所有3的倍数：")
    for (item <- triBuffer) { //遍历输出
      print(item + "  ")
    }
    println()

    //9  升序排列并打印
    print("result 9:对数组升序排列:\n")
    var arrayIncrease = array.sorted //调用自有方法.sorted()
    for (i <- 0 until arrayIncrease.length) { //对排好序的数组遍历
      printf("%d\t", arrayIncrease(i))
    }
    println()

    //10 降序排列并打印
    print("result 10:对数组降序排列:\n")
    for (i <- 0 until arrayIncrease.length reverse) { //对排序好的数组倒序遍历
      printf("%d\t", arrayIncrease(i))
    }
    println()

    //11 求数组array的平均值
    var avr: Double = 0
    avr = sum.toDouble / array.length.toDouble //之前sum已有计算，元素长度也有
    println("result 11:\n数组array的平均值为" + avr)

    //12 打印九九乘法表
    println("九九乘法表：")
    for (i <- 1 to 9) {
      for (j <- 1 to i) {
        printf("%d*%d=%d\t", i, j, i * j)
      }
      printf("\n")
    }
    println()


    var array_str = Array("a b c", "a b", "a")
    //13 计算数组中的wordCount
    var countMap = new ListMap[String, Int] //创建map
    var arrString = array_str.toList //将array转换为list，成员为单词
    var map2 = arrString.foldLeft(countMap)(count) //从左到右折叠执行count方法
    var map3 = ListMap(map2.toSeq.sortWith(_._2 > _._2): _*) //按照词频对map排序
    println("result 13&14:\n单词统计:")
    for (t <- map3) { //遍历输出map
      println(t)
    }

    //14 按照出现次数的多少进行升序排列
    var arrStr = array_str.mkString //将array重建为string
    var countMapW = new ListMap[Char, Int] //创建map
    var arrStringW = arrStr.toList //将string转换为list，为了沿用用单词统计的思路
    var map2W = arrStringW.foldLeft(countMapW)(countW) //同单词统计，对list从左到右执行countW方法
    var map3W = map2W.removed(' ') //排除空格
    var map4W = ListMap(map3W.toSeq.sortWith(_._2 > _._2): _*) //按照词频排序
    println("字母统计:")
    for (t <- map4W) {
      println(t)
    }
    println()


    val list1 = List(1, 2, 3, -1, -2, -3)
    //15 保留所有的正数
    var list15 = list1.sorted //先对list排序
    list15 = list15.dropWhile(_ < 0) //从左到右移除小于0的元素
    println("result 15:\n" + "保留所有正数" + list15)

    //16 移除list1中的第一个负数得到List(1,2,3,-2,-3)
    var arrList = list1.toBuffer //转换成arraybuffer，方便动态操作
    var i = 0
    breakable {
      while (true) { //循环判断
        if (arrList(i) < 0) { //直到第一个小于0的数，退出
          arrList.remove(i)
          break()
        }
        i += 1
      }
    }
    var listArr = arrList.toList //转换回list
    println("result 16:\n" + "移除list1中的第一个负数" + listArr)

    //17 移除除第一个负数外的所有负数List(1,2,3,-1)
    var list17 = list15 :+ list1(3)
    //直接将所有正数和第一个负数拼接
    println("result 17:\n" + "移除除第一个负数外的所有负数" + list17)

  }

  def count(map: ListMap[String, Int], c: String): ListMap[String, Int] = {
    map + (c -> (map.getOrElse(c, 0) + 1))
  }

  def countW(map: ListMap[Char, Int], c: Char): ListMap[Char, Int] = {
    map + (c -> (map.getOrElse(c, 0) + 1))
  }

}
