package seleniumSection15;

public class PracticeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int arr[]= {5,2,-1,6,-9,0,7,2};
		
		int temp;
		for (int i=0;i<arr.length;i++) {
			for(int j=i+1; j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					
					
				}
				
			}
			
		}
		
		for(int i=0;i<arr.length;i++) {
			
			System.out.print(arr[i]+ " ");
			
		}
		
		System.out.println("Second largest number is: "+arr[arr.length-2]);
		
		
		
		
	}

}
