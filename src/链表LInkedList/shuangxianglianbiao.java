package 链表LInkedList;

import Handler.ananException;

/**
 * 我的双向链表
 *
 * @author insis
 * @date 2023/03/04
 */
public class shuangxianglianbiao {
    //节点值
    int val;
    //前驱
    shuangxianglianbiao prior;
    //后继
    shuangxianglianbiao next;

    public shuangxianglianbiao() {
    }

    public shuangxianglianbiao(int val) {
        this.val = val;
    }

    /**
     * 初始化一个空的双向链表
     *
     * @return {@link shuangxianglianbiao}
     */
    public static shuangxianglianbiao init(){
        shuangxianglianbiao root = new shuangxianglianbiao(0);
        root.prior = null;
        root.next = null;
        return root;
    }

    /**
     * 得到长度
     *
     * @return int
     */
    public int getLength(){
        shuangxianglianbiao tmp = this;
        int length = 0;
        while(tmp.next != null){
            tmp = tmp.next;
            length++;
        }
        return length;
    }

    /**
     * 得到首节点
     *
     * @return {@link shuangxianglianbiao}
     */
    public shuangxianglianbiao getHead(){
        return this.next;
    }

    /**
     * 得到尾节点
     *
     * @return {@link shuangxianglianbiao}
     */
    public shuangxianglianbiao getTail(){
        shuangxianglianbiao tmp = this.next;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        return tmp;
    }

    /**
     * 判断链表是否为空
     *
     * @return boolean
     */
    public boolean linkedListIsEmpty(){
        if (this.next == null && this.prior == null){
            //为空
            return true;
        }
        //非空
        return false;
    }
    /**
     * 清空链表
     *
     */
    public void destroyLinkedList(){
        this.next = null;
        this.prior = null;
        //Java垃圾回收自动帮我们处理垃圾
    }
    /**
     * 得到指定位置的节点的值
     *
     * @param index 指数
     * @return int
     * @throws ananException 安安例外
     */
    public int getNode(int index) throws ananException {
        if (index > this.getLength() || index <= 0){
            throw new ananException("error,可能是链表没有那么长，或者输入位置为0或负数");
        }
        int value = 0;
        shuangxianglianbiao tmp = this.next;
        for (int i = 0; i < index; i++) {
            value = tmp.val;
            tmp = tmp.next;
        }
        return value;
    }

    /**
     * 根据值查找节点序号
     *
     * @param value 价值
     * @return int 如果找不到，返回-1
     */
    public int getNodeIndexByValue(int value){
        int result = 1;
        shuangxianglianbiao tmp = this.next;
        while(tmp != null){
            if (tmp.val == value){
                //返回位置序号
                return result;
            }
            else {
                tmp = tmp.next;
            }
        }
        //如果查到尾还没找到，返回-1
        return -1;
    }

    /**
     * 根据值得到节点
     *
     * @param value 价值
     * @return {@link shuangxianglianbiao}
     */
    public shuangxianglianbiao getNodeByValue(int value){
        shuangxianglianbiao tmp = this.next;
        while(tmp != null){
            if (tmp.val == value){
                return tmp;
            }
            tmp = tmp.next;
        }
        //如果找不到，返回null
        return null;
    }

    /**
     * 遍历链表
     */
    public void ergodic(){
        shuangxianglianbiao tmp = this.next;
        while (tmp != null){
            System.out.print(tmp.val+"->");
            tmp = tmp.next;
        }
    }

    /**
     * 由数组创建双向链表
     *
     * @param arr 加勒比海盗
     */
    public shuangxianglianbiao createLinkedListByArr(int[] arr){
        shuangxianglianbiao root = this;
        for (int i = 0; i < arr.length; i++) {
            shuangxianglianbiao tmp = new shuangxianglianbiao(arr[i]);
            tmp.prior = root;
            root.next = tmp;
            root = tmp;
        }
        return this;
    }

    /**
     * 指定索引后插入节点
     *
     * @param index 指数
     */
    public void insertByIndexTail(shuangxianglianbiao node,int index) throws ananException{
        if (index < 0 || this.getLength() < index ){
            throw new ananException("error,可能是链表没有那么长，或者输入位置为负数");
        }
        shuangxianglianbiao tmp = this;
        //找到目标节点
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        //执行插入操作
        node.next = tmp.next;
        node.prior = tmp;
        tmp.next = node;
    }

    /**
     * 指定索引后插入节点（链式调用）
     *
     * @param index 指数
     */
    public shuangxianglianbiao insertByIndexTailL(shuangxianglianbiao node,int index) throws ananException{
        if (index < 0 || this.getLength() < index ){
            throw new ananException("error,可能是链表没有那么长，或者输入位置为负数");
        }
        shuangxianglianbiao tmp = this;
        //找到目标节点
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        //执行插入操作
        node.next = tmp.next;
        node.prior = tmp;
        tmp.next = node;
        return this;
    }

    /**
     * 指定索引前插入节点
     *
     * @param index 指数
     */
    public void insertByIndexHead(shuangxianglianbiao node,int index) throws ananException{
        if (index < 0 || this.getLength() < index ){
            throw new ananException("error,可能是链表没有那么长，或者输入位置为负数");
        }
        shuangxianglianbiao tmp = this;
        //找到目标节点
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        //执行插入操作
        node.prior = tmp.prior;
        node.next = tmp;
        tmp.prior = node;

    }
    /**
     * 指定索引前插入节点（链式调用）
     *
     * @param index 指数
     */
    public shuangxianglianbiao insertByIndexHeadL(shuangxianglianbiao node,int index) throws ananException{
        if (index < 0 || this.getLength() < index ){
            throw new ananException("error,可能是链表没有那么长，或者输入位置为负数");
        }
        shuangxianglianbiao tmp = this;
        //找到目标节点
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        //执行插入操作
        node.prior = tmp.prior;
        node.next = tmp;
        tmp.prior = node;
        return this;
    }

    /**
     * 通过索引删除节点
     *
     * @param index 指数
     */
    public void deleteNodeByIndex(int index) throws  ananException{
        if (index <= 0 || this.getLength() < index ){
            throw new ananException("error,可能是链表没有那么长，或者输入位置为0或负数");
        }
        shuangxianglianbiao tmp = this;
        //找到目标位置前一个节点
        for (int i = 0; i < index-1; i++) {
            tmp = tmp.next;
        }
        //执行删除操作
        tmp.next = tmp.next.next;
    }

    /**
     * 通过索引删除节点（链式调用）
     *
     * @param index 指数
     */
    public shuangxianglianbiao deleteNodeByIndexL(int index) throws  ananException{
        if (index <= 0 || this.getLength() < index ){
            throw new ananException("error,可能是链表没有那么长，或者输入位置为0或负数");
        }
        shuangxianglianbiao tmp = this;
        //找到目标位置前一个节点
        for (int i = 0; i < index-1; i++) {
            tmp = tmp.next;
        }
        //执行删除操作
        tmp.next = tmp.next.next;
        return this;
    }

    /**
     * 通过值删除节点（删一个）
     *
     * @param value 价值
     * @throws ananException 安安例外
     */
    public void deleteNodeByValue (int value) throws ananException{
        shuangxianglianbiao tmp = this;
        while (tmp.next != null){
            if (tmp.next.val == value){
                tmp.next = tmp.next.next;
                break;
            }
            tmp = tmp.next;
        }
    }

    /**
     * 通过值删除节点（删全部为目标值的节点）
     *
     * @param value 价值
     * @throws ananException 安安例外
     */
    public void deleteNodeByValueAll (int value) throws ananException{
        shuangxianglianbiao tmp = this;
        while (tmp.next != null){
            if (tmp.next.val == value){
                tmp.next = tmp.next.next;
            }
            tmp = tmp.next;
        }
    }

    /**
     * 通过值删除节点（链式调用）
     *
     * @param value 价值
     * @throws ananException 安安例外
     */
    public shuangxianglianbiao deleteNodeByValueL (int value) throws ananException{
        shuangxianglianbiao tmp = this;
        while (tmp.next != null){
            if (tmp.next.val == value){
                tmp.next = tmp.next.next;
                return this;
            }
            tmp = tmp.next;
        }
        return this;
    }

}
