package com.bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Dao.BookDao;

public class MainApplication {

	public static void main(String[] args) {
		
               try
               {
            	  String bn,an;
            	  float p;
            	  int res,bid,ch;
            	  Book b;
            	  List<Book> l;
            	  
            	  BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
            	  
             	  do
                  {
               	     System.out.println("1:Insert\n2:Update\n3:Delete\n4:FetchAllRecords\n5:FetchByCondition\n6:Exit");
               	     System.out.println("Enter Your Choice");
               	     ch=Integer.parseInt(br.readLine());
               	     
               	     ApplicationContext a = new ClassPathXmlApplicationContext("SpringJT.xml");
               	     BookDao bd = (BookDao) a.getBean("bdao");
               	    		 
               	   switch(ch)
               	   {
               	       case 1:  //Insert
               		   System.out.println("Enter BookName,AuthorName And Price");
               		   b=new Book();
               		   b.setBookName(br.readLine());
               		   b.setAuthorName(br.readLine());
               		   b.setPrice(Float.parseFloat(br.readLine()));
               		   res=bd.insertBook(b);
               		   
               		   if(res>0)
               		   {
               			   System.out.println("Record added Successfully");
               		   }
               		   else
               		   {
               			   System.out.println("Try Again");
               		   }
               		   break;
               		   
               	       case 2: //update
               		   System.out.println("Enter BookName and Update Price::");
               		   bn=br.readLine();
               		   p=Float.parseFloat(br.readLine());
               		   res=bd.updateBook(bn,p);
               		   if(res>0)
              		   {
              			   System.out.println("Record added Successfully");
              		   }
              		   else
              		   {
              			   System.out.println("Try Again");
              		   }
              		   break;
              		   
               	        case 3://Delete
               	    	System.out.println("Enter BookName::");
               	        bn=br.readLine();
               	    	res=bd.deleteBook(bn);
               	    	if(res>0)
               		    {
               			   System.out.println("Record deleted Successfully");
               		    }
               		    else
               		    {
               			   System.out.println("Try Again");
               		    }
               		    break;
               		   
               	        case 4://FetchAllRecord
               	        l=bd.fetchall();//50Records
               	        for(Book b1:l)
               	        {
               	        	System.out.println(b1);
               	        }
               	        break;
               	        
               	        case 5://FetchAllRecordsByCondition
               	        System.out.println("Enter The BookId:");
               	        bid=Integer.parseInt(br.readLine());
               	        l=bd.fetchByCondition(bid);//condition
                	    for(Book b1:l)
                	    {
                	       System.out.println(b1);
                	    }
                	    break;

               	        case 6://Exit
               		    System.out.println("Thank You");
               		    System.exit(0);
               		    break;
               		   
               		    default:System.out.println("Enter Proper Choice");
               	      }
               	        System.out.println("Done");
               	     
                     }
            	        while(true);
            	  
                  }
               
                      catch(Exception e)
                      {
            	      System.out.println("Exception Occoured");
            	      e.printStackTrace();
                      }
	     }

}
