package 哈希表HashMap;
import java.util.ArrayList;
import java.util.List;

/* 键值对 int->String */
class Entry {
    public int key;
    public String val;
    public Entry(int key, String val) {
        this.key = key;
        this.val = val;
    }
}

/* 基于数组简易实现的哈希表 */
class MyHashMap {
    private List<Entry> bucket;
    public MyHashMap() {
        // 初始化一个长度为 100 的桶（数组）
        bucket = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            bucket.add(null);
        }
    }

    /* 哈希函数 */
    private int hashFunc(int key) {
        int index = key % 100;
        return index;
    }

    /* 查询操作 */
    public String get(int key) {
        int index = hashFunc(key);
        Entry pair = bucket.get(index);
        if (pair == null) {return null;}
        return pair.val;
    }

    /* 添加操作 */
    public void put(int key, String val) {
        Entry pair = new Entry(key, val);
        int index = hashFunc(key);
        bucket.set(index, pair);
    }

    /* 删除操作 */
    public void remove(int key) {
        int index = hashFunc(key);
        // 置为 null ，代表删除
        bucket.set(index, null);
    }

    /* 获取所有键值对 */
    public List<Entry> entrySet() {
        List<Entry> entrySet = new ArrayList<>();
        for (Entry pair : bucket) {
            if (pair != null) {
                entrySet.add(pair);
            }
        }
        return entrySet;
    }

    /* 获取所有键 */
    public List<Integer> keySet() {
        List<Integer> keySet = new ArrayList<>();
        for (Entry pair : bucket) {
            if (pair != null) {
                keySet.add(pair.key);
            }
        }
        return keySet;
    }

    /* 获取所有值 */
    public List<String> valueSet() {
        List<String> valueSet = new ArrayList<>();
        for (Entry pair : bucket) {
            if (pair != null) {
                valueSet.add(pair.val);
            }
        }
        return valueSet;
    }

    /* 打印哈希表 */
    public void print() {
        for (Entry kv: entrySet()) {
            System.out.println(kv.key + " -> " + kv.val);
        }
    }
}
