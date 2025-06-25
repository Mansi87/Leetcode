class LRUCache {
    class Node{
        int key, val;
        Node prev, next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))  return -1;
        Node node = map.get(key);
        delete(node);
        insertFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            delete(map.get(key));
        }
        Node newNode = new Node(key,value);
        insertFront(newNode);
        map.put(key, newNode);
        if(map.size() > capacity){
            Node lru = tail.prev;
            delete(lru);
            map.remove(lru.key);
        }
    }

    private void delete(Node node){
        node.prev.next = node.next;
        node.next.prev =  node.prev;
    }

    private void insertFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */