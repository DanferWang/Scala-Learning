package Danfer.Search

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object BinaryTree {
  def main(args: Array[String]): Unit = {
    //土方法添加节点
    var root = new Node(1, "Danfer")
    var tomo1 = new Node(2, "Timovt")
    var tomo2 = new Node(3, "Ming")
    var tomo3 = new Node(4, "OG")
    var tomo4 = new Node(5, "Zhang")
    var tomo5 = new Node(3, "Xiao Ming")

    val binaryTreeW = new BinaryTreeW
    binaryTreeW.root = root
    root.left = tomo1
    root.right = tomo3
    tomo3.left = tomo2
    tomo3.right = tomo4
    tomo4.right = tomo5

    //前序遍历
    println("前序遍历：")
    binaryTreeW.preOrder()
    //中序遍历
    println("中序遍历：")
    binaryTreeW.midOrder()
    //后序遍历
    println("后序遍历：")
    binaryTreeW.postOrder()

    println("前序查找：输入序号")
    var id = StdIn.readInt()
    //前序查找
    binaryTreeW.preSearch(id)
    //中序查找
    binaryTreeW.midSearch(id)
    //后序查找
    binaryTreeW.postSearch(id)

  }

}

//定义结点ss
class Node(hNo: Int, hName: String) {
  var no = hNo
  var name = hName
  var left: Node = null
  var right: Node = null

  //前序遍历
  def preOrder(): Unit = {
    //先输出当前节点
    printf("no:%d\tname=%s\n", no, name)
    if (left != null) { //向左递归,输出左子树
      left.preOrder()
    }
    if (right != null) { //向右递归，输出右子树
      right.preOrder()
    }
  }

  //中序遍历
  def midOrder(): Unit = {
    if (left != null) { //先向左递归，输出左子树
      left.midOrder()
    }
    //输出父节点
    printf("no=%d\tname=%s\n", no, name)
    if (right != null) { //向右递归，输出右子树
      right.midOrder()
    }
  }

  //后序遍历
  def postOrder(): Unit = {
    if (left != null) { //先向左递归，输出左子树
      left.postOrder()
    }
    if (right != null) { //向右递归，输出右子树
      right.postOrder()
    }
    //输出父节点
    printf("no=%d\tname=%s\n", no, name)
  }

  //前序查找
  def preSearch(id: Int, outCome: ArrayBuffer[Node]): ArrayBuffer[Node] = {
    if (no == id) { //先查找父节点
      outCome.append(this) //若匹配则加入
    }
    if (left != null) { //向左递归，在左子树中查找
      left.preSearch(id, outCome)
    }
    if (right != null) { //向右递归，在右子树中查找
      right.preSearch(id, outCome)
    }
    return outCome
  }

  //中序查找
  def midSearch(id: Int, outCome: ArrayBuffer[Node]): ArrayBuffer[Node] = {
    if (left != null) { //先向左递归，在左子树中查找
      left.preSearch(id, outCome)
    }
    if (no == id) { //查找父节点
      outCome.append(this) //若匹配则加入
    }
    if (right != null) { //向右递归，在右子树中查找
      right.preSearch(id, outCome)
    }
    return outCome
  }

  //后序查找
  def postSearch(id: Int, outCome: ArrayBuffer[Node]): ArrayBuffer[Node] = {
    if (left != null) {
      left.preSearch(id, outCome) //向左递归，在左子树中查找
    }
    if (right != null) {
      right.preSearch(id, outCome) //向右递归，在右子树中查找
    }
    if (no == id) { //查找父节点
      outCome.append(this) //若匹配则加入
    }
    return outCome
  }
}

//定义二叉树
class BinaryTreeW {
  var root: Node = null

  //前序遍历
  def preOrder(): Unit = {
    if (root != null) {
      root.preOrder()
    }
    else {
      println("树为空，无须遍历")
    }
  }

  //中序遍历
  def midOrder(): Unit = {
    if (root != null) {
      root.midOrder()
    }
    else {
      println("树为空，无须遍历")
    }
  }

  //后序遍历
  def postOrder(): Unit = {
    if (root != null) {
      root.postOrder()
    }
    else {
      println("树为空，无须遍历")
    }
  }

  //前序查找
  def preSearch(id: Int): Unit = {
    if (root != null) {
      var tempBuffer = new ArrayBuffer[Node]
      var outCome = root.preSearch(id, tempBuffer)
      if (outCome.isEmpty) {
        println("查找完成，无此人")
      }
      else {
        println("查找完成：")
        for (item <- outCome) {
          printf("no=%d\tname=%s\n", item.no, item.name)
        }
      }
    }
    else {
      println("树为空，查询无效")
    }
  }

  //中序查找
  def midSearch(id: Int): Unit = {
    if (root != null) {
      var tempBuffer = new ArrayBuffer[Node]
      var outCome = root.preSearch(id, tempBuffer)
      if (outCome.isEmpty) {
        println("查找完成，无此人")
      }
      else {
        println("查找完成：")
        for (item <- outCome) {
          printf("no=%d\tname=%s\n", item.no, item.name)
        }
      }
    }
    else {
      println("树为空，查询无效")
    }
  }

  //后序查找
  def postSearch(id: Int): Unit = {
    if (root != null) {
      var tempBuffer = new ArrayBuffer[Node]
      var outCome = root.preSearch(id, tempBuffer)
      if (outCome.isEmpty) {
        println("查找完成，无此人")
      }
      else {
        println("查找完成：")
        for (item <- outCome) {
          printf("no=%d\tname=%s\n", item.no, item.name)
        }
      }
    }
    else {
      println("树为空，查询无效")
    }
  }
}