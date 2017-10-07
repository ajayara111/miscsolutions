package my.experiment.code;

import java.util.Arrays;

//void add(Object o) - Add and object
//Object[] values() - Get all the values 
//Object get(int index) - get a single value, return null if not found
//Object remove(int index) - remove and object



//https://www.youtube.com/results?search_query=vrealize+network+insight
public class InterviewQuestion {
	 
    private Object[] myValues;
    private int myLength = 0;
    private int sizeMultiple;
    //Configurable size for the application need  
    public InterviewQuestion(int arraySize, int sizeMultiple){
    	myValues = new Object[arraySize];
    	this.sizeMultiple = sizeMultiple;
    }
     
    public Object get(int index){
    	if (index < 0 || index > myLength){
    		return null;
    	}
    	else{
            return myValues[index];
    	}
    }
     
    public void add(Object obj){
    	//Reaching the threashold so increase the size
        if(myValues.length-myLength <= 1){
            increaseListSize();
        }
        System.out.println("Added " + obj);
        myValues[myLength++] = obj;
    }
     
    public Object remove(int index){
     	if (index < 0 || index > myLength){
    		return null;
    	}else{
        
            Object obj = myValues[index];
            System.out.println("About to remove " + myValues[index]);
            myValues[index] = null;
            int tmp = index;
            while(tmp < myLength){
                myValues[tmp] = myValues[tmp+1];
                myValues[tmp+1] = null;
                tmp++;
            }
            myLength--;
           
            return obj;
        } 
    }
     
 
    private void increaseListSize(){
        myValues = Arrays.copyOf(myValues, myValues.length * sizeMultiple);
        System.out.println("\nNew length: "+myValues.length);
    }
     
    public static void main(String a[]){
    	InterviewQuestion iq = new InterviewQuestion(3,2);
        iq.add("ajay");
        iq.add("maori");
        iq.add("mukul");
        iq.add("trump");
        iq.add("hillary");
        iq.add("Kaine");
        iq.add("pence");
        iq.add("romney");
        System.out.println("Get the index " + iq.get(5));
        System.out.println(iq.remove(7));
 
    }
}
