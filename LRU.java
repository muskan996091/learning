import java.util.*; 
  
public class LRU { 
      
    // Driver method 
    public static void main(String[] args) { 
	Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of pages");
	int n=sc.nextInt();
        int arr[] = new int[n];

	System.out.println("Enter the capacity: "); 
        int capacity = sc.nextInt(); 

   	System.out.println("Enter the frames: "); 
	for(int i=0;i<n;i++)
	{
		arr[i]=sc.nextInt();
	} 
          
        // To represent set of current pages.We use 
        // an Arraylist 
        ArrayList<Integer> s=new ArrayList<>(capacity); 
        int count=0; 
        int page_faults=0; 
        for(int i:arr) 
        { 
            // Insert it into set if not present 
            // already which represents page fault 
            if(!s.contains(i)) 
            { 
              
            // Check if the set can hold equal pages 
            if(s.size()==capacity) 
            { 
                s.remove(0); 
                s.add(capacity-1,i); 
            } 
            else
                s.add(count,i); 
                // Increment page faults 
                page_faults++; 
                ++count; 
          
            } 
            else
            { 
                // Remove the indexes page 
                s.remove((Object)i); 
                // insert the current page 
                s.add(s.size(),i);          
            } 
          
        } 
System.out.println("No. of page faults:");
        System.out.println(page_faults); 
    } 
} 