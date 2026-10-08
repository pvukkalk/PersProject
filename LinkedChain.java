public class LinkedChain {
    private Node head;  //reference to the first node
    private int numOfEntries;

    public LinkedChain(){
        numOfEntries = 0;
        head = null;
    }

    public boolean add(T toAdd){
        Node newNode = new Node(toAdd);
        if(head == null){
            head = newNode;
        } else {
            Node currentNode = head;
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        numOfEntries++;
        return true;
    }

    public T remove(T toRemove){
        if(head == null){
            return null;
        }
        if(head.getData().equals(toRemove)){
            T data = head.getData();
            head = head.getNext();
            numOfEntries--;
            return data;
        }
        Node currentNode = head;
        //removes the first occurrence of the specified 
        while(currentNode.getNext() != null){
            if(currentNode.getNext().getData().equals(toRemove)){
                T data = currentNode.getNext().getData();
                currentNode.setNext(currentNode.getNext().getNext());
                numOfEntries--;
                return data;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }
}
