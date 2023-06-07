package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import to.HadithTO;

public class HadithDAO implements IDAL{
	
private Connection con, con_2;
	
	public HadithDAO() throws SQLException
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/hadith_updated?useSSL=false";
		String user = "root";
		String password = "";
		con = DriverManager.getConnection(url, user, password);
		

		String url_2 = "jdbc:mysql://localhost:3306/hadith_test_db?useSSL=false";
		con_2 = DriverManager.getConnection(url_2, user, password);
		//System.out.print("DB Connected");
	}
	
	public HadithDAO(Connection con) 
	{
		this.con = con;
	}
	
	/**
	 * Zuha Rana
	 * F19-0112
	 */
	
	
	protected String sanad_length;
	private String S_L,S, sanad,from,Level,To;
	
	public HadithTO SearchHadith(String Num_hadith, String Book)
	{
		HadithTO H = new HadithTO();
		try
		{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM hadith_dataset_updated WHERE Num_hadith = ? and Book = ?");
			ps.setString(1, Num_hadith);
			ps.setString(2, Book);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				H.setHadith(rs.getString("hadith"));
				H.setBook(rs.getString("book"));
				H.setNum_hadith(rs.getString("Num_hadith"));
				H.setMatn(rs.getString("matn"));
				H.setSanad(rs.getString("sanad"));
				H.setSanad_length(rs.getString("sanad_length"));
			}
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return H;
	}

	
	/**
	 * Zuha Rana
	 * F19-0112
	 */
	public String Find_sanad_length(String Num_hadith, String Book)
	{
		try
		{
			PreparedStatement ps = con.prepareStatement("SELECT Sanad_Length FROM hadith_dataset WHERE Num_hadith = ? AND Book = ?");
			ps.setString(1, Num_hadith);
			ps.setString(2, Book);
			ResultSet rs = ps.executeQuery();
			//System.out.println(rs);
			
			while(rs.next()) 
			{
				//System.out.println("Zuha");
				//System.out.println(rs.getString("Sanad_Length"));
				S_L = rs.getString("Sanad_Length");
				
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			//System.out.println(("Error"));
			e.printStackTrace();
		}
		return S_L;
	}
	
	
	/**
	 * Ali Amer
	 * F19-0191
	 */
	
	public void UpdateHadith(String Num_hadith, String Book, String sanad_length)
	{
		try
		{
			PreparedStatement ps = con_2.prepareStatement("UPDATE hadith_dataset SET Sanad_length = ? WHERE Num_hadith = ? AND Book = ?");
			ps.setString(1, sanad_length);
			ps.setString(2, Num_hadith);
			ps.setString(3, Book);
			ps.executeUpdate();
			
		} 
		
		catch (SQLException e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR!");
		}
	}

	
	/**
	 * Ali Hassan
	 * F19-0324
	 */
	public Boolean DeleteHadith(String Num_hadith, String Book)
	{
		
		try
		{
			PreparedStatement ps = con_2.prepareStatement("DELETE FROM hadith_dataset WHERE Num_hadith = ? AND Book = ?");
			ps.setString(1, Num_hadith);
			ps.setString(2, Book);
			ps.executeUpdate();
			return true;
		} 
		
		catch (SQLException e) 
		{
			 //TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR!");
			return false;
		}
	}
	
	
	/**
	 * Zuha Rana
	 * F19-0112
	 */
	
	public String GetSanad(String Num_hadith, String Book)
	{
		try
		{
			PreparedStatement ps = con_2.prepareStatement("SELECT Sanad FROM hadith_dataset WHERE Num_hadith = ? AND Book = ?");
			ps.setString(1, Num_hadith);
			ps.setString(2, Book);
			ResultSet rs = ps.executeQuery();
			
					while(rs.next()) 
					{
						//System.out.println(rs.getString("Sanad"));
						S = rs.getString("Sanad");
					}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();g
			System.out.println("ERROR!");
		}
		return S;
	}
	

	/**
	 * Zuha Rana
	 * F19-0112
	 * @return 
	 */

	public String From_Narattor(String S, String name, String book)
	{
		String[] from_narattors = new String[10];
		//String str = new String();  
		//String From_Narattors;  
		
		String[] res = S.split(",[ ]*", 0);
		
		 for(int i=0;i<res.length;i++)
	     {
	           if(res[i].equals(name))
	           {
	        	   
	        	   for(int j=0, x=0;j<i;j++,x++)
	        	   { 
	        		   from_narattors[x]=res[j];
	        	   }
	           }
	     } 
		 
		 StringBuilder builder = new StringBuilder();

		 for (int i = 0; i < from_narattors.length; i++) 
		 {
		     builder.append(from_narattors[i]);
		     builder.append(' ');
		 }

		 String stringWithSpaces = builder.toString().trim();
		 
		 String[] stringArray = new String[]{stringWithSpaces};
		 
		 StringBuilder sb = new StringBuilder();
		 for (String s : stringArray) 
		 {
			    sb.append(s);
		 }       
		 String newString = sb.toString();

		 String updatedString = newString.replaceAll("null", " ");
		 
		return updatedString;
		 
		
		 //System.out.println(updatedString);
		
	}
	//String SA = "عمرو بن علي, يحيى  وهو ابن سعيد, قرة بن خالد, حميد بن هلال, أبو بردة, أبي موسى";
	/**
	 * Zuha Rana
	 * F19-0112
	 * @return 
	 */
	public String LEVEL(String name, String S)
	{
		String level = null;
		
		String[] res = S.split(",[ ]*", 0);
		
		 for(int i=0;i<res.length;i++)
	       {
	           if(res[i].equals(name) )
	           {
	        	    //level = i;
	        	    //NarattorLevel.setText(""+i);
	        	    level = String.valueOf(i+1);
	        	   // System.out.println(level);
	           }
	       }
		 return level;
	}
	
	/**
	 * Zuha Rana
	 * F19-0112
	 */

	public String TEST_Search(String hadith_num, String book_name)
	{
		sanad_length = Find_sanad_length(hadith_num,book_name);
		System.out.println(sanad_length);

		//if(hadith_num == "2" && book_name == "سنن ابن ماجه")
			return sanad_length;
		//return "Wrong Sanad";
	}
	
	
	/**
	 * Zuha Rana
	 * F19-0112
	 */
	
	public String TEST_Find_Sanad_Length(String hadith_num, String book_name)
	{
		sanad_length = Find_sanad_length(hadith_num,book_name);
		System.out.println(sanad_length);

		//if(hadith_num == "2" && book_name == "سنن ابن ماجه")
			return sanad_length;
		//return "Wrong Sanad";
	}

	/**
	 * Ali Amer
	 * F19-0191
	 */
	public String TEST_Update(String hadith_num, String book_name)
	{
		sanad_length = Find_sanad_length(hadith_num,book_name);
			return sanad_length;
		
	}

	/**
	 * Ali Hassan
	 * F19-0324
	 */
	public Boolean TEST_Delete(String hadith_num, String book_name)
	{
		Boolean result = DeleteHadith(book_name, book_name);
		if(result)
			return true;
		else
			return false;
		
	}
	
	public String TEST_From_Narattors(String S, String name, String book)
	{
		from = From_Narattor(S, name, book);
		//System.out.println(from);
		return from;
	}
	
	/**
	 * Zuha Rana
	 * F19-0112
	 * @return 
	 */
	public String To_Narattor(String S, String name, String book)
	{
		String[] to_narattors = new String[5];
		String str = new String();  
		String To_Narattors;  
		
		String[] res = S.split(",[ ]*", 0);
		
		 for(int i=0;i<res.length;i++)
	       {
	           if(res[i].equals(name))
	           {
	        	   
	        	   for(int j=i+1, x=0;j<res.length;j++,x++)
	        	   { 
	        		   to_narattors[x]=res[j];
	        	   }
	           }
	       }
			 
		 StringBuilder builder = new StringBuilder();

		 for (int i = 0; i < to_narattors.length; i++) 
		 {
		     builder.append(to_narattors[i]);
		     builder.append(' ');
		 }

		 String stringWithSpaces = builder.toString().trim();
		 
		 String[] stringArray = new String[]{stringWithSpaces};
		 
		 StringBuilder sb = new StringBuilder();
		 for (String s : stringArray) 
		 {
			    sb.append(s);
		 }
		 String newString = sb.toString();

		 String updatedString = newString.replaceAll("null", " ");
		 return updatedString;
	}
	/**
	 * Ali Hassan
	 * F19-0324
	 */
	
	public String TEST_N_Level(String name)
	{
		Level = LEVEL(name, S);
		System.out.println(Level);
		return Level;
	}

	/**
	 * Ali Amer
	 * F19-0191
	 */

	public String TEST_To_Narattors(String S, String name, String book) {
		To = To_Narattor(S,name, book);
		return To;
	}
	
}



