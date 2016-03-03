/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */
	

	import java.io.IOException;
	import java.text.DecimalFormat;

	/**
	 *
	 * @author David
	 */
	public class CurrencyConverter {
		 DecimalFormat money = new DecimalFormat("#.00");
	      private  double userAmount = 0;  //Amount entered by user in the entAmount JTextField
	       private int fromCurrency = 0;   
	        private int toCurrency = 0;
	        private String userFrom = null; //The currency selection from the From drop-down box
	        private String userTo = null;   //The currency selection from the To drop-down box
	 
	        public CurrencyConverter(double userAmount,int fromCurrency, int toCurrency, String userFrom, String userTo){
	        	this.userAmount = userAmount;
	        	this.fromCurrency = fromCurrency;
	        	this.toCurrency = toCurrency;
	        	this.userFrom = userFrom;
	        	this.userTo = userTo;
	        }
	        
	    
	    public double Convert(){
	       

	        String[] iCurrencyVault = new String[6];
	        
	        GetCurrencies(iCurrencyVault);
	        
	        double[][] iCurrencyMatrix = new double[][]{
	            {1.0000, 0.7500, 0.0083, 1.1300, 0.1600, 0.0600},
	            {1.3200, 1.0000, 0.0110, 1.4900, 0.2100, 0.0790},
	            {120.31, 90.830, 1.0000, 135.68, 18.890, 7.2000},
	            {0.8900, 0.6700, 0.0074, 1.0000, 0.1400, 0.0530},
	            {6.3700, 4.8100, 0.0530, 7.1800, 1.0000, 0.3800},
	            {16.700, 12.610, 0.1400, 18.820, 2.6200, 1.0000}
	        };
	        
	        //ListExchangeRates(iCurrencyVault, iCurrencyMatrix); //For my reference when entering exchange rates

	        for(int i = 0; i < iCurrencyVault.length; i++)
	        {
	            if(userFrom == iCurrencyVault[i])
	                fromCurrency = i;
	            if(userTo == iCurrencyVault[i])
	                toCurrency = i;
	        }
	        
	        double iExchangeRate = iCurrencyMatrix[toCurrency][fromCurrency];
	        
	        double iResult = userAmount*iExchangeRate;
	        
	        return iResult;
	    }
	    
	    
	    public static String[] GetCurrencies(String[] iCurrencyVault){
	        String[] iA = new String[] {"United States of America (U.S. Dollar)", "Canada (Canadian Dollar)", "Japan (Yen)", "European Union (Euro)", "China (Yuan)", "Mexico (Pesos)"};
	        
	        for(int i = 0; i < iA.length; i++)
	            iCurrencyVault[i] = iA[i];
	        
	        return iCurrencyVault;
	    }
	    
	    
	    public static void ListExchangeRates(String[] iA, double[][] iB){
	        System.out.print("      ");
	        
	        for(int i = 0; i < iA.length; i++)
	        {
	            System.out.print(iA[i] + "     ");
	        }
	        System.out.print("\n");
	        
	        for(int i = 0; i < iA.length; i++)
	        {
	            System.out.print(iA[i] + "     ");
	            for(int j = 0; j < iB[i].length; j++)
	                System.out.print(iB[i][j] + "     ");
	            System.out.println();
	        }
	        
	    }


		public double getUserAmount() {
			return userAmount;
		}


		public void setUserAmount(double userAmount) {
			this.userAmount = userAmount;
		}


		public int getFromCurrency() {
			return fromCurrency;
		}


		public void setFromCurrency(int fromCurrency) {
			this.fromCurrency = fromCurrency;
		}


		public int getToCurrency() {
			return toCurrency;
		}


		public void setToCurrency(int toCurrency) {
			this.toCurrency = toCurrency;
		}


		public String getUserFrom() {
			return userFrom;
		}


		public void setUserFrom(String userFrom) {
			this.userFrom = userFrom;
		}


		public String getUserTo() {
			return userTo;
		}


		public void setUserTo(String userTo) {
			this.userTo = userTo;
		}
	   
	}

