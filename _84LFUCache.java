//Leetcode - 

//Solution - using 2 HashMaps & Doubly LinkedList
//time comp - get O(1) & put O(1)

class LFUCache {
    //doubly linked list node
    class DLLNode{
        int key, val, freq;
        DLLNode prev, next;
        public DLLNode(int key, int val){
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }
    class DoubleLinkedList{
        int listSize;
        DLLNode head, tail;
        public DoubleLinkedList(){
            this.listSize = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        //add node at front after head & inc the size by 1
        public void addNode(DLLNode currNode){
            DLLNode headNext = head.next;
            head.next = currNode;
            currNode.prev = head;
            currNode.next = headNext;
            headNext.prev = currNode;
            listSize++;
        }
        
        //remove node before tail & dec the size by 1
        public void removeNode(DLLNode currNode){
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            listSize--;
        }
    }

    //LFU starts
    final int cap; //capacity
    int currSize;
    int minFreq;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> freqMap;
    
    public LFUCache(int capacity) {
        this.cap = capacity;
        this.currSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    //get node value by key, then update node freq also relocate that node
    public int get(int key) {
        DLLNode currNode = cache.get(key);
        if(currNode == null)
            return -1;
        
        //updateNode will relocate that node also inc its freq
        updateNode(currNode);
        return currNode.val;
    }
    
    public void put(int key, int value) {
        //corner case : check cache capacity initialization
        if(cap == 0)
            return;
        if(cache.containsKey(key)){
            DLLNode currNode = cache.get(key);
            currNode.val = value; // update the value
            updateNode(currNode);
        }
        else{
            currSize++; //new ele is adding so
            if(currSize > cap){
                //get minimum freqList
                DoubleLinkedList minFreqList = freqMap.get(minFreq);
                // remove LRU from cache DS
                cache.remove(minFreqList.tail.prev.key);
                // remove LRU from list
                minFreqList.removeNode(minFreqList.tail.prev);
                currSize--;
            }
            //rest minFreq to 1 cos of adding new Node - only new node will come in this code block
            minFreq = 1;
            DLLNode newNode = new DLLNode(key, value);
            //get the list with freq 1, & then add new Node into the list, as well as into the LFU cache
            DoubleLinkedList currList = freqMap.getOrDefault(1, new DoubleLinkedList());
            currList.addNode(newNode);
            freqMap.put(1, currList);
            cache.put(key, newNode);
        }
    }
    
    public void updateNode(DLLNode currNode){
        int currFreq = currNode.freq;
        //took out list belong to that freq
        DoubleLinkedList currList = freqMap.get(currFreq);
        currList.removeNode(currNode);
        //if currList is the list which has lowest freq & currNode is the only node in that list
        //so in that case, we need to remove the entire list & then inc. minimum freq.value by 1
        if(currFreq == minFreq && currList.listSize == 0)
            minFreq++;
        currNode.freq++;
        //add currNode to another list has curr freq + 1;
        //if we do not have the list with freq, initialize it
        DoubleLinkedList newList = freqMap.getOrDefault(currNode.freq, new DoubleLinkedList());
        newList.addNode(currNode);
        freqMap.put(currNode.freq, newList);
    }
}