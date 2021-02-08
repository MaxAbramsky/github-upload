import java.util.*;

public class MyItem implements IDedObject 
{
   private int itemID = 0;
   private int itemPrice = 0;
   private List<Integer> itemDescription = new LinkedList<>();
   
   public MyItem(int id, int pr, List<Integer> desc) {
      itemID = id;
      itemPrice = pr;
      for(Integer e:desc)
         itemDescription.add(e);
   }
   
   public int getID() {
      return itemID;
   }
   
   public String printID() {
      String res = "";
      res = itemID + " " + itemPrice + " ";
      for(int i = 0; i < itemDescription.size(); i++)
         res = res + itemDescription.get(i) + " ";
      return res;
   }
}