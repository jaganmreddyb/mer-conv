package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class HolidayRequest {

	/*
	 * public static void main(String[] args) {
	 * 
	 * int capacity=7;
	 * 
	 * List<List<Integer>> fList=new ArrayList<List<Integer>>();
	 * fList.add(Arrays.asList(1,2)); fList.add(Arrays.asList(2,4));
	 * fList.add(Arrays.asList(3,6));
	 * 
	 * List<List<Integer>> bList=new ArrayList<List<Integer>>();
	 * 
	 * bList.add(Arrays.asList(1,2));
	 * 
	 * for(List<Integer> list:getList(capacity,fList,bList)) {
	 * System.out.println(list.get(0)); System.out.println(list.get(1)); }
	 * 
	 * }
	 */	
	
	public static List<List<Integer>> getList(int capacity,List<List<Integer>> fList,List<List<Integer>> bList ){
		System.out.println("lenghts:"+fList.size()+":"+bList.size());
		
		List<List<Integer>> outPutList=new ArrayList<List<Integer>>();
        for(List<Integer> fl:fList){
            int currentCapacity=0;
            int sum=0;
            List<Integer> temp= new ArrayList();
            List<Integer> rList=null;
            Iterator<List<Integer>> it= bList.iterator();
            
            while(it.hasNext()){
            	List<Integer> bl=it.next();
                 sum=fl.get(1)+bl.get(1);
                 System.out.println(sum);
                if((currentCapacity<sum&&sum==capacity)||(currentCapacity<sum&&sum<capacity)){
                    currentCapacity=sum;
                    temp.clear();
                    temp.add(fl.get(0));
                    temp.add(bl.get(0));
                    System.out.println("index:"+fl.get(0)+":"+bl.get(0));
                    outPutList.add(temp);
                    rList=bl;
                    if(currentCapacity==capacity)
                    	break;
                }
                
            }
            bList.remove(rList);
            
        }
		
		return outPutList;
	}

}
