package javaCollect.mySqlConnect;

import javaCollect.base.Log;

public class SQL {
	private static Log logclass = new Log();

	private SQL() {	}

	public static final String WHERE = " WHERE ";
	public static final String JOIN = " JOIN ";

	public static final String AND = " AND ";
	public static final String OR = " OR ";

	public static final String ON = " ON ";
	public static final String COMMA = " , ";
	public static final String GAP = "  ";
	public static final String SAME = " = ";
	public static final String ALL = " * ";

	// 1. INSET INTO table( col , col , col , col ) VALUSE('','','','')
	public static String INSERT(String table, String col, String var) {
		return String.format("INSERT INTO %s (%s ) VALUES (%s )", table, col, var);
	}

	// 2. UPDATE table SET col = ''
	public static String UPDATE(String table, String data) {
		return String.format("UPDATE %s %s", table, data);
	}

	public static String UPDATE(String table, String col, String data) {
		return String.format("UPDATE %s SET %s = '%s'", table, col, data);
	}

	// 3. SELECT * FROM TABLE
	public static String SELECT(String table) {
		return String.format("SELECT * FROM %s", table);
	}

	public static String SELECT(String table, String col) {
		return String.format("SELECT %s FROM %s", col, table);
	}
		
	
	public static String DELETE(String table, String where) {
		return String.format("DELETE FROM %s %s", table, where);
	}

	public static String DELETE(String table, String col, String data) {
		return String.format("DELETE FROM %s WHERE %s = '%s'", table, col, data);
	}

	// 3 table
	// SELECT * FROM table
	// DELETE FROM table
//	public static String INTO(String col, String data) {
//		return String.format(" WHERE %s = '%s'", col, data);
//	}

	public static String VALUES(String data) {
		return String.format(" VALUES (%s)", data);
	}

	public static String WHERE(String col, String data) {
		return String.format(" WHERE %s = '%s'", col, data);
	}

	public static String WHERE(String data) {
		return String.format(" WHERE %s ", data);
	}
	
	public static String ORDERBY(String col) {
		return String.format(" ORDER BY %s ", col);
	}
	
	public static String ORDERBY(String col , String desc) {
		return String.format(" ORDER BY %s %s", col , desc);
	}

	public static String JOIN(String table, String col1, String col2) {
		return String.format(" JOIN %s ON %s = %s",table, col1, col2);
	}
	
	public static String SET(String col, String data) {
		return String.format(" SET %s = '%s'", col, data);
	}

	public static String SET(String data) {
		return String.format(" SET %s", data);
	}

	public static String SET(String col, int data) {
		return String.format(" SET %s = '%d'", col, data);
	}

	public static String ADDCOL(String col, String data, String Gap, String Divide) {
		return String.format(" %s %s %s '%s'", Divide, col, Gap, data);
	}

	public static String ADDCOL(String col, String data, String Gap) {
		return String.format(" %s %s '%s'", col, Gap, data);
	}

	public static String ADDCOL(String col, String Gap) {
		return String.format(" %s %s", Gap, col);
	}

	public static String ADDDATA(String data, String Gap) {
		return String.format(" %s '%s'", Gap, data);
	}

}

//type
// Integer , String , Time

// col , 변수이 연동되어 있어야 된다.
// column 단위
// 1. Class <T> 생성 Column

// 상수 
// 2. hashMap <String ,String> , <String , Integer>

// String table명[col명]  
// 3. ArrayList<String[]{col명,(String)변수}>

// 4. String[col][(String)변수]

// Table 단위
// 1. Table Class 생성 + 필드 ( Column단위 생성 )
// 2. hashmap(table , hashmap(col명 , 변수) )
// 3. 

// 함수의 매개변수 : table , col , 변수 삽입받아서 처릴
// 1. ( table  , col[] , 변수[]  )
// 2. ( table  ,(col,변수)[] )
// 3. ( (table,col,변수) ) 
