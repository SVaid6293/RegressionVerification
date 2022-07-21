public class PatternsDefinition {

	//Defining patterns...
	static String policyPremium = "POLICY PREMIUM\\s*\\$\\s*\\d*\\,*\\d+\\.*\\d*";
	static String cpPremium= "COMMERCIAL PROPERTY\\s*\\$\\s*\\d*\\,*\\d*";
	static String cglPremium = "COMMERCIAL GENERAL LIABILITY\\s*\\$\\s*\\d*\\,*\\d*";
	static String crimePremium = "COMMERCIAL CRIME AND FIDELITY\\s*\\$\\s*\\d*\\,*\\d*";
	static String cimPremium = "COMMERCIAL INLAND MARINE\\s*\\$\\s*\\d*\\,*\\d*";
	static String autoPremium = "COMMERCIAL AUTO\\s*\\$\\s*\\d*\\,*\\d*";
	static String umbrellaPremium = "COMMERCIAL UMBRELLA\\s*\\$\\s*\\d*\\,*\\d*";
	static String fireSafetySurcharge="ADDITIONAL MINNESOTA FIRE SAFETY SURCHARGE\\s*\\$\\s*\\d*\\,*\\d*\\.*\\d*";
	static String totalPremium="TOTAL PREMIUM\\s*\\$\\s*\\d*\\,*\\d*\\.*\\d*";
	static String btmmPremium="BALANCE TO MEET MINIMUM PREMIUM\\s*\\$\\s*\\d*\\,*\\d*\\.*\\d*";
	static String crimePremium2 = "COMMERCIAL CRIME\\s*\\$\\s*\\d*\\,*\\d*";

	static String patternForForms="[A-Z]+[0-9]+\\s*\\d+\\-\\d+.{1,1000}";

	//Storing patterns..
	public static String[] decPagePatterns=new String[]{
			policyPremium,cpPremium,cglPremium,crimePremium,crimePremium2,cimPremium,autoPremium
			,umbrellaPremium,fireSafetySurcharge,totalPremium,btmmPremium
	};
	
	
	//Work-sheets

	//Commercial Property
	static String patternProperty="LOCATION#\\s*\\d+\\s*BUILDING#\\s*\\d+|\\d+\\s*Basic Grp I*|"
			+ "\\d+\\s*Special|"
			+ "PKG MOD FTR\\s*\\=\\s*\\d*\\.*\\d*|"
			+ "LCM\\s*\\=\\s*\\d*\\.*\\d*|"
			+ "DED FTR\\s*\\=\\s*\\d*\\.*\\d*|"
			+ "LC\\s*\\=\\s*\\d*\\.*\\d*";

	static String building = "BUILDING\\s*\\$\\s*\\d*\\,*\\d*";
	static String buildingIG = "BUILDING INFLATION GUARD\\s*\\$\\s*\\d*\\,*\\d*";
	static String pp = "PERSONAL PROPERTY\\s*\\$\\s*\\d*\\,*\\d*";
	static String ppIG = "PERSONAL PROPERTY INFLATION GUARD\\s*\\$\\s*\\d*\\,*\\d*";
	static String spoilage = "SPOILAGE\\s*\\$\\s*\\d*\\,*\\d*";
	static String bic = "BUSINESS INCOME COVERAGE\\s*\\$\\s*\\d*\\,*\\d*";
	static String op = "OPTIONAL PROVISIONS\\s*\\$\\s*\\d*\\,*\\d*";
	static String ttp = "TOTAL TRANSACTION PREMIUM\\s*\\$\\s*\\d*\\,*\\d*";
	static String tcpp = "TOTAL COMMERCIAL PROPERTY PREMIUM\\s*\\$\\s*\\d*\\,*\\d*";
	static String totalTransactionPremium = "Total Transaction Premium:\\s*\\$\\s*\\d*\\,*\\d*\\.*\\d*";
	static String surcharge = "Total Surcharge / Taxes / Fees:\\s*\\$\\s*\\d*\\,*\\d*\\.*\\d*";
	static String totPremium = "Total Premium:\\s*\\$\\s*\\d*\\,*\\d*\\.*\\d*";




	//General Liability
	static String patternGL="LOCATION\\s*#\\s*\\d+\\s|"
			+ "PKG MOD FTR\\s*\\=\\s*\\d*\\.*\\d*|"
			+ "LOSS COST MULTIPLIER\\s*\\=\\s*\\d*\\.*\\d*|"
			+ "DED FTR\\s*\\=\\s*\\d*\\.*\\d*|"
			+ "LOSS COST\\s*\\=\\s*\\d*\\.*\\d*";

	
	//Auto

	static String patternAuto="VEHICLE\\s*#\\s*\\d+\\s|"
			+ "[^0-9][0-9][0-9][0-9]\\/+[a-zA-Z]+|"
			+ "Liability|Personal Injury\\s*Protection Coverage|Uninsured Motorist\\s*Coverage|Comprehensive|Collision|Medical Payments|"
			+ "LCM\\s*\\=\\s*\\d*\\.*\\d|LC\\s*\\=\\s*\\d*\\.*\\d*|OCP_LC\\s*\\=\\s*\\d*\\.*\\d*";


	public static String[] worksheetPatternsCP=new String[]{
			patternProperty,
			building,
			buildingIG,
			pp,
			ppIG,
			spoilage,
			bic,
			op,
			ttp,
			tcpp,
			totalTransactionPremium,
			surcharge,
			totPremium

	};

	public static String[] worksheetPatternsGL=new String[]{
			patternGL,
			totalTransactionPremium,
			surcharge,
			totPremium
	};
	
	public static String[] worksheetPatternsAuto=new String[]{
			patternAuto,
			totalTransactionPremium,
			surcharge,
			totPremium
	};

	public static String[] worksheetPatternsCrime=new String[]{
			totalTransactionPremium,
			surcharge,
			totPremium
	};

	

	public static String[] worksheetPatternsIM=new String[]{
			totalTransactionPremium,
			surcharge,
			totPremium
	};
}

