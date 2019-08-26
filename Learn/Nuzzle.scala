package Danfer.Learn

object Nuzzle {
  def main(args: Array[String]): Unit = {
    //创建地图
    var map = Array.ofDim[Int](8, 7)
    //墙
    for (i <- 0 until 7) {
      map(0)(i) = 1
      map(7)(i) = 1
    }
    for (i <- 0 until 8) {
      map(i)(0) = 1
      map(i)(6) = 1
    }
    //障碍
    map(3)(1) = 1
    map(3)(2) = 1
    //打印地图
    println("原始地图为：")
    for (i <- 0 to 7) {
      for (j <- 0 to 6) {
        print(map(i)(j) + "\t")
      }
      println()
    }
    //递归回溯寻找通路
    setWay(map, 1, 1)
    //再输出地图，检查是否有通路
    println("寻找通路为：")
    for (i <- 0 to 7) {
      for (j <- 0 to 6) {
        print(map(i)(j) + "\t")
      }
      println()
    }
  }

  //递归回溯寻找通路
  //map是地图
  //（i，j）是起点
  def setWay(map: Array[Array[Int]], i: Int, j: Int): Boolean = {
    if (map(6)(5) == 2) { //找到通路
      return true
    }
    else {
      if (map(i)(j) == 0) { //当前路径没有走过
        //开始递归回溯
        map(i)(j) = 2 //认为该点是可以走通的，不一定能走通
        //注意策略
        if (setWay(map, i + 1, j)) { //向下走
          return true
        }
        else if (setWay(map, i, j + 1)) { //向右走
          return true
        }
        else if (setWay(map, i - 1, j)) { //向上走
          return true
        }
        else if (setWay(map, i, j - 1)) { //向左走
          return true
        }
        else { //走不通
          map(i)(j) = 3
          return false
        }
      }
      else { //map(i)(j)!=0,则其值为1（墙，不能走），2（走过，判断过为通路），3（走过，判断过为死路）
        return false
      }
    }
  }
}
