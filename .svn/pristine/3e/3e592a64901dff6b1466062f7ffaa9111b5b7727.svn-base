package com.bachk.ssys.fcl.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Service;



import com.bachk.ssys.fcl.model.SMSModel;
import com.bachk.ssys.fcl.model.SelectItem;
@Service
@RemotingDestination
public class SelectNetwork {
	
	private String opentPath;
	private String outPath;
	private 	BufferedReader in;
	private boolean hasOutput = false;
	private  int k =1;
	private  BufferedWriter bw;
	 BufferedDataInputer bdi;
	 private  ArrayList<SMSModel> list = new ArrayList<SMSModel>();
	 private  ArrayList<SMSModel> list1 = new ArrayList<SMSModel>();

	 private  ArrayList<SMSModel> newList = new ArrayList<SMSModel>();
	 
	 private  ArrayList<SMSModel> newList1 = new ArrayList<SMSModel>();

	private Map options;
	@RemotingInclude
	public void init(Map newoptions,String path,String output)
	{
		this.options = newoptions;
		this.opentPath = path;
		this.outPath = output;
	}
	
	public void openoutFile(){
		try{
			File files = new File(outPath);  
			if (!files.exists() != false) {  
	            try {  
	            	files.createNewFile();  
	                  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
			}
			
			bw = new BufferedWriter(new FileWriter(files));  
		} catch (IOException e) {  
            e.printStackTrace();  
        }  
			
	          
		
	}
	
	public void openinFile(){
		
		
		try{
	    FileReader file = new FileReader(opentPath);
			//FileReader file = new FileReader(opentPath);
		    in = new BufferedReader(file);
		    bdi = new BufferedDataInputer(10, in);
		
		}    catch (IOException e) {  
				e.printStackTrace();  
		}    
	
}

	@RemotingInclude
	public  void SelectNetwork1(){
		
	
		this.openoutFile();
		this.openinFile();
	    SMSModel data;
     

	    SelectItem newSelect = new SelectItem((String)options.get("property"),(String)options.get("value"));
	        try {  
	     
	        	while (((data = (SMSModel) bdi.readNextData()) != null) ) {
	        		list1.add(data);
	        		if( newSelect.selectItem(data,(String)options.get("operater")) == true ){
	        		
	        				list.add(data);
	        		
	        				bw.write(data.toString());
	        				bw.newLine();//»»ÐÐ  
	        				bw.flush();  
	        		}
   		    }
         
     
	        } catch (Exception e) {  
	        	e.printStackTrace();  
	        }
  
		

	

    }
	
	
	
	@RemotingInclude
	public List<SMSModel> getNext100(){
		
		if(list.size() >= 10*k){
			newList.clear();
			for(int i= 10*k-10; i<=10*k-1;i++){
				
				newList.add(0,list.get(i));
			}
			
			k++;
		
			return newList;
		}
		return null;
		  
  }
	
	@RemotingInclude
	public List<SMSModel> getNext1000(){
		
		if(list1.size() >= 10*k){
			newList1.clear();
			for(int i= 10*k-10; i<=10*k-1;i++){
				
				newList1.add(0,list1.get(i));
			}
			
			k++;
		
			return newList1;
		}
		return null;
		  
		



    }
}
