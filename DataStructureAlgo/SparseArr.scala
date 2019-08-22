package Danfer.DataStructureAlgo

import scala.collection.mutable.ArrayBuffer

object SparseArr {
  def main(args: Array[String]): Unit = {
    //定义地图
    var rowSize = 11
    var colSize = 11
    var originMap = Array.ofDim[Int](rowSize, colSize)

    //初始化地图
    originMap(1)(2) = 1
    originMap(2)(3) = 2

    //打印原始地图
    for (i <- originMap) {
      for (j <- i) {
        printf("%d\t", j)
      }
      println()
    }

    //创建稀疏数组
    //思路：达到数据压缩的效果
    //用class Node （row， col， value）保存位置和值
    //创建一个ArrayBuffer作为稀疏数组
    var sparseArr = ArrayBuffer[Node]()
    //定义首结点为原始地图尺寸及默认值
    var node = new Node(rowSize, colSize, 0)
    sparseArr.append(node)

    for (i <- 0 until originMap.length) {
      for (j <- 0 until originMap(i).length) {
        //判断该位置的值是否为零
        //若不为零，则保存
        if (originMap(i)(j) != 0) {
          //将有意义的数据以Node形式加入稀疏数组
          var node = new Node(i, j, originMap(i)(j))
          sparseArr.append(node)
        }
      }
    }
    //遍历稀疏数组
    println("压缩后，稀疏数组：")
    for (node <- sparseArr) {
      printf("在第%d行，第%d列，值为%d\n", node.row, node.col, node.value)
    }

    //存盘

    //读盘

    //由稀疏数组还原原始地图
    var backRowSize = sparseArr(0).row
    var backColSize = sparseArr(0).col
    var backMap = Array.ofDim[Int](backRowSize, backColSize)
    //还原默认值
    for (i <- 0 until backRowSize) {
      for (j <- 0 until backColSize) {
        backMap(i)(j) = sparseArr(0).value
      }
    }
    //还原有意义的值
    for (i <- 1 until sparseArr.length) {
      backMap(sparseArr(i).row)(sparseArr(i).col) = sparseArr(i).value
    }
    //遍历输出地图
    println("还原的地图：")
    for (i<- 0 until backRowSize){
      for (j<-0 until backColSize){
        printf("%d\t",backMap(i)(j))
      }
      println()
    }

  }

  class Node(var row: Int, var col: Int, var value: Int) {

  }

}
