class LFUCache {
    class Node{
        int key, value,freq;
        Node prev, next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
    class DoublyLinkedList{
        Node head, tail;
        DoublyLinkedList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }

        void addNode(Node node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        void deleteNode(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        boolean isEmpty(){
            return head.next == tail;
        }
        Node deleteLast(){
            if(isEmpty())  return null;
            Node node = tail.prev;
            deleteNode(node);
            return node;
        }
    }
    int capacity,minFreq;
    Map<Integer, Node> keyNodeMap;
    Map<Integer, DoublyLinkedList> freqListMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyNodeMap = new HashMap<>();
        freqListMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!keyNodeMap.containsKey(key))  return -1;
        Node node = keyNodeMap.get(key);
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity==0)  return;
        if(keyNodeMap.containsKey(key)){
            Node node = keyNodeMap.get(key);
            node.value = value;
            updateFreq(node);
        }
        else{
            if(keyNodeMap.size()==capacity){
                DoublyLinkedList minList = freqListMap.get(minFreq);
                Node toRemove = minList.deleteLast();
                keyNodeMap.remove(toRemove.key);
            }
            Node newNode = new Node(key, value);
            keyNodeMap.put(key, newNode);
            minFreq = 1;

            DoublyLinkedList list = freqListMap.getOrDefault(1, new DoublyLinkedList());
            list.addNode(newNode);
            freqListMap.put(1, list);
        }
    }

    private void updateFreq(Node node){
        int freq = node.freq;
        DoublyLinkedList list = freqListMap.get(freq);
        list.deleteNode(node);
        if(freq == minFreq && list.isEmpty()){
            minFreq++;
        }
        node.freq++;
        DoublyLinkedList newList = freqListMap.getOrDefault(node.freq, new DoublyLinkedList());
        newList.addNode(node);
        freqListMap.put(node.freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */