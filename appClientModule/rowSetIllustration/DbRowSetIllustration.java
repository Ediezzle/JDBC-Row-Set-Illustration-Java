package rowSetIllustration;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DbRowSetIllustration
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/addressBook";
		String userName = "root";
		String password = "";
		try 
		{
			// first, create a factory object for rowset
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			// create a JDBC rowset from the factory
			JdbcRowSet rowSet = rowSetFactory.createJdbcRowSet();
			rowSet.setUrl(url);
			rowSet.setUsername(userName);
			rowSet.setPassword(password);
			rowSet.setCommand("SELECT * FROM contact");
			rowSet.execute();
			System.out.println("id \tfName \tlName \temail \t\tphoneNo");
			
			while (rowSet.next())
			{
				System.out.println(rowSet.getInt("id") + "\t"
				+ rowSet.getString("firstName") + "\t"
				+ rowSet.getString("lastName") + "\t"
				+ rowSet.getString("email") + "\t"
				+ rowSet.getString("phoneNo"));
				}
		}  
		
		catch (SQLException sqle) 
		{
			sqle.printStackTrace();
		}

	}

}
