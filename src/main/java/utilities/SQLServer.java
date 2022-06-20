package utilities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLServer {

	public static String createQuery(String table) {

		String strCompany=Util.get("Company");
		String strIndictedFaults=Util.get("Indicted Faults");
		String strWorkOrderType=Util.get("Work Order Type");
		String strSeverity=Util.get("Severity");

		if(strCompany.equalsIgnoreCase("All")) {
			strCompany = "";
		}

		if(strIndictedFaults.equalsIgnoreCase("All")) {
			strIndictedFaults = "";
		}

		if(strWorkOrderType.equalsIgnoreCase("All")) {
			strWorkOrderType = "";
		}

		if(strSeverity.equalsIgnoreCase("All")) {
			strSeverity = "";
		}

		String query = "DECLARE	@return_value int\r\n" + 
				"\r\n" + 
				"EXEC	@return_value = [dbo].["+table+"]\r\n" + 
				"		@currentUser = N'"+Util.get("Username").trim()+"',\r\n" + 
				"		@st_EventDate = N'2016-01-05',\r\n" + 
				"		@end_EventDate = N'2021-06-01',\r\n" + 
//				"		@status = NULL,\r\n" + 
				"		@CompanyCsv = N'"+strCompany+"',\r\n" + 
				"		@SeverityCsv = N'"+strSeverity+"',\r\n" + 
				"		@Indicated_FaultCsv = N'"+strIndictedFaults+"',\r\n" + 
				"		@Work_Order_TypeCsv = N'"+strWorkOrderType+"'\r\n" + 
				"\r\n" + 
				"SELECT	'Return Value' = @return_value\r\n" + 
				"";
		return query;
	}
	

	public static HashMap<String, String> retrieveEventStatusCount() {
		HashMap<String, String> dbMapStatus = new HashMap<String, String>();
		Connection con = null;
		try { 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			String url = "jdbc:sqlserver://devdbserver3391.database.windows.net:1433;database=HR_MANAGEMENT;user=DEVSERVER33911;password=DEV@SERVER@33911;";
			con = DriverManager.getConnection(url);

			String query = createQuery("Wind_GET_Event_Work_Order_Status_Summary_Data");

			CallableStatement cs = con.prepareCall(query,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = cs.executeQuery();
			List<Map<String, String>> dbData = resultSetToList(rs);
			for(Map<String, String> map : dbData) {
				String Key = map.get("event_case_status");
				String value = map.get("RecourdCount");
				dbMapStatus.put(Key, value);
			}
			con.close();
			return dbMapStatus;
		} catch (Exception e) {
			Util.Failed("Exception caught while retrieving data from Database : "+e.getMessage());
			return dbMapStatus;
		}
	}

	private static List<Map<String, String>> resultSetToList(ResultSet rs) throws SQLException {
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		List<Map<String, String>> rows = new ArrayList<Map<String, String>>();

		rs.beforeFirst();
		while (rs.next()){

			Map<String, String> row = new HashMap<String, String>(columns);
			for(int i = 1; i <= columns; ++i){
				String str;
				try {
					str = rs.getObject(i).toString();
				}catch(Exception e) {
					str = "";
				}
				row.put(md.getColumnName(i), str);
			}
			rows.add(row);

		}
		return rows;
	}

	private static  ArrayList<String> resultSetToOnlyList(ResultSet rs) throws SQLException {
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		ArrayList<String> rows = new ArrayList<String>();

		rs.beforeFirst();
		while (rs.next()){

			Map<String, String> row = new HashMap<String, String>(columns);
			for(int i = 1; i <= columns; ++i){
				rows.add(rs.getObject(i).toString().trim());
			}
		}
		return rows;
	}

}
