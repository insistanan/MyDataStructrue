package 链表LInkedList;

import Handler.ananException;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的循环双向链表（没有头节点）
 *
 * @author insis
 * @date 2023/03/04
 */
public class xunhuanlianbiaoShuang {
    int val;
    xunhuanlianbiaoShuang prior;
    xunhuanlianbiaoShuang next;

    public xunhuanlianbiaoShuang() {
    }

    public xunhuanlianbiaoShuang(int val) {
        this.val = val;
    }
    public static xunhuanlianbiaoShuang init(){
        xunhuanlianbiaoShuang root = new xunhuanlianbiaoShuang(0);
        root.next = root;
        root.prior = root;
        return root;
    }

    /**
     * 得到长度
     *
     * @return int
     */
    public int getLength(){
        int length = 1;
        xunhuanlianbiaoShuang tmp = this;
        while(tmp.next != this){
            tmp = tmp.next;
            length++;
        }
        return length;
    }

    /**
     * 破坏链表
     *
     * @return {@link xunhuanlianbiaoShuang}
     */
    public xunhuanlianbiaoShuang destroyLinkedList(){
        this.next = this;
        this.prior = this;
        return this;
    }

    /**
     * 得到尾节点
     *
     * @return {@link xunhuanlianbiaoShuang}
     */
    public xunhuanlianbiaoShuang getTail(){
        return this.prior;
    }


    /**
     * 得到指定位置的节点
     *
     * @param index 位置
     * @return {@link xunhuanlianbiaoShuang}
     * @throws ananException 安安例外
     */
    public xunhuanlianbiaoShuang getByIndex(int index)throws ananException {
        if (index <=0 ){
            throw new ananException("此位置不合法");
        }
        int length = this.getLength();
        int n = index % length;
        if (n==0){
            return this.getTail();
        }
        else {
            xunhuanlianbiaoShuang tmp = this.getTail();
            for (int i = 0; i < n; i++) {
                tmp = tmp.next;
            }
            return tmp;
        }
    }

    /**
     * 得到指定值位置序号
     *
     * @param value 价值
     * @return {@link int[]}
     */
    public int[] getByValue(int value){
        int length = this.getLength();
        List<Integer> list = new ArrayList<>();
        int n = 1;
        xunhuanlianbiaoShuang tmp = this;
        for (int i = 0; i < length; i++) {
            if (tmp.val == value){
                list.add(n);
            }
            tmp = tmp.next;
            n++;
        }
        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    /**
     * 指定位置后插入
     *
     * @param index 指数
     * @param node  节点
     * @return {@link xunhuanlianbiaoShuang}
     * @throws ananException 安安例外
     */
    public xunhuanlianbiaoShuang insertByIndexTail(int index,xunhuanlianbiaoShuang node) throws  ananException{
        if (index < 0){
            throw new ananException("error,非法的位置");
        } else if (index == 0) {
            //在首节点之前插入
            this.getTail().next = node;
            node.prior = this.getTail();
            node.next = this;
            return node;
        }else {
            int n = index % this.getLength();
            xunhuanlianbiaoShuang tmp = this.getTail();
            for (int i = 0; i < n; i++) {
                //找到目标节点
                tmp = tmp.next;
            }
            //执行插入操作
            node.next = tmp.next;
            node.prior = tmp;
            tmp.next = node;
            return this;
        }
    }

}


