package Danfer.Search

object BST {
  def main(args: Array[String]): Unit = {
    var array=Array(7, 3, 10, 12, 5, 1, 9)

    var binarySortedTree = new BinarySortedTree
    for (item <- array){
      binarySortedTree.add(new BSTNode(item))
    }
    binarySortedTree.midOrder()
  }

}

class BSTNode(var value: Int) {
  var left: BSTNode = null
  var right: BSTNode = null

  def add(node:BSTNode): Unit = {
    if (node == null) {
      return
    }
    //添加节点小于当前节点，放入左子树
    if (node.value < this.value) {
      if (this.left == null) { //若左子树为空，则添加
        this.left = node
      }
      else { //若左子树非空，则递归
        this.left.add(node)
      }
    }
    //添加节点大于等于当前节点，放入右子树
    else {
      if (this.right == null) { //若右子树为空，则添加
        this.right = node
      }
      else { //若右子树非空，则递归
        this.right.add(node)
      }
    }
  }

  def midOrder(): Unit = {
    if (left != null) { //先向左递归，输出左子树
      left.midOrder()
    }
    //输出父节点
    printf(value + "\t")
    if (right != null) { //向右递归，输出右子树
      right.midOrder()
    }
  }
}

class BinarySortedTree {
  var root: BSTNode = null

  def add(node: BSTNode): Unit = {
    if (root == null) {
      root = node
    }
    else {
      root.add(node)
    }
  }

  def midOrder(): Unit = {
    if (root != null) {
      root.midOrder()
    }
    else {
      println("树为空，无须遍历")
    }
  }
}