import java.util.*;

public class IDedLinkedList<AnyType	extends IDedObject> 
{
   public IDedLinkedList()					 //Constructs and	empty	Linked List
   {
      clear();
   }
	 
   void clear()						//Sets default	values and size to zero
   {
      front = new Node<AnyType>(null, null);
      back = new Node<AnyType>(null, null);
      front.next = back;
   }
	 
	void makeEmpty()             //empties the list
   {
      front.next = back;
   }
   
   AnyType findID(int ID)      //Returns generic type if ID found, returns null if not found or list empty
   {
      Node<AnyType> current = front.next;
      while(current.data != null)
      {
         if(current.data.getID() == ID)
            return current.data;
         current = current.next;
      }
      return null;      
   }
   
   boolean insertAtFront(AnyType x)   //inserts x at front of list or returns false if ID already exists
   {
      if(findID(x.getID()) != null)
         return false;
      Node<AnyType> newNode = new Node<AnyType>(x, front.next);
      front.next = newNode;
      return true;
   }
   
   AnyType deleteFromFront()   //deletes node at front of list and returns record or returns null if empty
   {
      if(front.next.data == null)
         return null;
      AnyType val = front.next.data;
      front.next = front.next.next;
      return val;
   }
   
   AnyType delete(int ID)     //deletes node with given ID
   {
      Node<AnyType> current = front;
      while(current.next.data != null)
      {
         if(current.next.data.getID() == ID)
         {
            AnyType val = current.next.data;
            current.next = current.next.next;
            return val;
         }
         current = current.next;
      }
      return null;      
   }
   
   int printTotal()  //returns total of IDs and -1 if empty
   {
      int sum = 0;
      Node<AnyType> current = front.next;
      if(current.data == null)
         return -1;
      while(current.data != null)
      {
         sum += current.data.getID();
         current = current.next;
      }    
      return sum;
   }
    
   private static	class	Node<AnyType extends IDedObject>
   {
      public AnyType	data = null;
      public Node<AnyType>	next = null;
      
      public Node( AnyType	d,	Node<AnyType> n )
      {
         data	=	d; next	= n;
      }
   }
	
   private Node<AnyType> front;
   private Node<AnyType> back;
}

