package 栈Stack;

import Handler.ananException;

import java.util.ArrayList;
import java.util.List;

public class MyStackByArray {
    //初始化一个ArrayList当作栈（List能够自动扩容，数组不行）
    private List<Integer> stack;
    public MyStackByArray(){
        stack = new ArrayList<>();
    }

    /**
     * 得到长度
     *
     * @return int
     */
    public int getLength(){
        return stack.size();
    }

    /**
     * 是空
     *
     * @return boolean
     */
    public boolean isEmpty(){
        return getLength() == 0;
    }

    /**
     * 入栈
     *
     * @param num 全国矿工工会
     */
    public void push(int num){
        stack.add(num);
    }

    /**
     * 出栈
     *
     * @return int
     * @throws ananException 安安例外
     */
    public int pop() throws  ananException{
        if (isEmpty()){
            throw new ananException("EmptyStackException");
        }
        return stack.remove(getLength()-1);
    }

    /**
     * 访问栈顶元素
     *
     * @return int
     * @throws ananException 安安例外
     */
    public int peek()throws  ananException{
        if (isEmpty()){
            throw new ananException("EmptyStackException");
        }
        return stack.get(getLength()-1);
    }

    /**
     * 转换到数组返回
     *
     * @return {@link Object[]}
     */
    public Object[] toArray(){
        return stack.toArray();
    }

}
