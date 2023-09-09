package com.google;

public class KnightInBoard {
	
	public static void main(String[] args) {
		KnightInBoard knight = new KnightInBoard();
		knight.knightProbability(3,3,0,0);
		System.out.println(knight.totalProb);
	}
	
	double totalProb = 0.0;
	public double knightProbability(int n, int k, int row, int column) {
        if(k == 0) {
            return 1.0;
        }
        
        findProbability(n,k,row,column);
        return totalProb;
    }
    
    public double findProbability(int n,int k,int row, int col){
    	System.out.println("KK K ::: " + k);
         if(k>1) {
        	 if(row-2>=0 && col-1>=0){
        		 System.out.println("in 1::: " + totalProb);
        		 totalProb += (1/8.0)*findProbability(n,k-1,row-2,col-1);
             }
             if(row-2>=0 && col+1<n){
            	 System.out.println("in 2::: " + totalProb);        		 
            	 totalProb +=(1/8.0)*findProbability(n,k-1,row-2,col+1);
             }
             if(row-1>=0 && col+2 <n){
            	 System.out.println("in 3::: " + totalProb);        		 
            	 totalProb += (1/8.0)*findProbability(n,k-1,row-1,col+2);
             }
              if(row+1<n && col+2 <n){
            	  
            	  totalProb += (1/8.0)*findProbability(n,k-1, row+1,col+2);
            	  System.out.println("in 4::: "  + " k ::: " + k);
          		 
             }
                                                    
              if(row+2<n && col+1 <n){
            	  totalProb += (1/8.0)*findProbability(n,k-1, row+2,col+1);
            	  System.out.println("in 5::: " + totalProb + " k = " + k);
          		 
             }
              if(row+2<n && col-1 >=0){
            	  System.out.println("in 6::: " + totalProb);         		 
            	  totalProb += (1/8.0)*findProbability(n,k-1,row+2,col-1);
             }
              if(row-1>=0 && col-2 >=0){
            	  System.out.println("in 7::: " + totalProb);         		 
            	  totalProb += (1/8.0)*findProbability(n,k-1,row-1,col-2);
             }
              if(row+1<n && col-2 >=0){
            	  System.out.println("in 8::: " + totalProb);         		 
            	  totalProb += (1/8.0)*findProbability(n,k-1,row+2,col-2);
             } 
             return totalProb; 
             
        } else if(k == 0) {
        	return 0;
        } else {
        	float probability = checkProbability(n,row,col);
        	
        	return probability;
        }
        
    }
       
    
    public float checkProbability(int n, int row, int col) {
    	
    	int successCt =0;
    	
    	 if(row-2>=0 && col-1>=0){
    		 successCt++;
    	 }
         if(row-2>=0 && col+1<n){
        	 successCt++;
         }
         if(row-1>=0 && col+2 <n){
        	 successCt++;
         }
          if(row+1<n && col+2 <n){
        	  successCt++;
          }
                                                
          if(row+2<n && col+1 <n){
        	  successCt++;
          }
          if(row+2<n && col-1 >=0){
        	  successCt++;
          }
          if(row-1>=0 && col-2>=0){
        	  successCt++;
          }
          if(row+1<n && col-2 >=0){
        	  successCt++;
          } 
          System.out.println("success ::: " + successCt + "row ::" + row + " col ::: " + col);
          return successCt/8.0f;
    }

}
