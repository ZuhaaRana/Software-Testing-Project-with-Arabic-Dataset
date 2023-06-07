package dal;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class HadithDAOTests extends HadithDAO {
	private static Connection con;

	public HadithDAOTests() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static HadithDAO hDAO;
	
	@BeforeAll
	static void coldStart() throws SQLException
	{

		String url = "jdbc:mysql://localhost:3306/hadith_test_db?useSSL=false";
		String user = "root";
		String password = "";
		con = DriverManager.getConnection(url, user, password);
		hDAO = new HadithDAO(con);
	}

	/**
	 * Zuha Rana
	 * F19-0112
	 */
	@Test
	@DisplayName("Search Hadith Test Case")
	void test_Search() 
	{
		String sanad_length = hDAO.TEST_Search("4","سنن النسائى الصغرى");
		Assertions.assertTrue(sanad_length.matches("6"));
		
	}
	
	/**
	 * Zuha Rana
	 * F19-0112
	 */
	
	@Test
	@DisplayName("Find Sanad Length Test Case")
	void test_find_sanad_length() 
	{
		
		String sanad_length = hDAO.TEST_Find_Sanad_Length("4","سنن النسائى الصغرى");
		Assertions.assertTrue(sanad_length.matches("6"));
	}
	
	

	//	@Test
	@DisplayName("Update Hadith Test Case")
	void test_update()
	{
		String sanad_length = hDAO.TEST_Update("4","سنن النسائى الصغرى");
		System.out.println(sanad_length);
		Assertions.assertTrue(sanad_length.matches("6"));
	}
	

	
	@Test
	@DisplayName("Delete Hadith Test Case")
	void test_Delete() 
	{
		
		hDAO.TEST_Delete("1","سنن النسائى الصغرى");
		Assertions.assertTrue(true);
	}
	
	
	@Test
    @DisplayName("Test successful deletion of hadith")
    void testDeleteHadithSuccess() throws SQLException, ClassNotFoundException {
        // Arrange
        String num = "10";
        String bookName = "سنن النسائى الصغرى";
        
        HadithDAO iDAL = new HadithDAO();
		// Act
        boolean result = iDAL.DeleteHadith(num, bookName);   
        // Assert
        Assertions.assertTrue(true);
    }

	
	/**
	 * Zuha Rana
	 * F19-0112
	 */
	@Test
	@DisplayName("Search Hadith Test Case")
	void test_Search_2() 
	{
		String sanad_length = hDAO.TEST_Search("4","سنن النسائى الصغرى");
		Assertions.assertTrue(sanad_length.matches("7"));
		
	}
	
	/**
	 * Zuha Rana
	 * F19-0112
	 */
	
	@Test
	@DisplayName("Find Sanad Length Test Case")
	void test_find_sanad_length_2() 
	{
		
		String sanad_length = hDAO.TEST_Find_Sanad_Length("4","سنن النسائى الصغرى");
		Assertions.assertTrue(sanad_length.matches("7"));
	}
	
	
		@Test
	@DisplayName("Update Hadith Test Case")
	void test_update_2()
	{
		String sanad_length = hDAO.TEST_Update("4","سنن النسائى الصغرى");
		System.out.println(sanad_length);
		Assertions.assertTrue(sanad_length.matches("7"));
	}
	
	/**
	 * Zuha Rana
	 * F19-0112
	 */
	@Test
	@DisplayName("From Narattors Test Case")
	void test_From_Narattors()
	{
			
			String from = hDAO.TEST_From_Narattors("سنن النسائى الصغرى","4","قرة بن خالد");
			System.out.println(from);
			Assertions.assertFalse(from.matches("عمرو بن علي يحيى"));	
	}
	/**
	 * Zuha Rana
	 * F19-0112
	 */
	@Test
	@DisplayName("To Narattors Test Case")
	void test_To_Narattors()
	{
			
			String from = hDAO.TEST_To_Narattors("سنن النسائى الصغرى","4","قرة بن خالد");
			System.out.println(from);
			Assertions.assertFalse(from.matches(""));	
	}
	
	
	@Test
	@DisplayName("N Level Test Case")
	void test_N_Level()
	{

			String from = hDAO.TEST_N_Level("قرة بن خالد");
			System.out.println(from);
			Assertions.assertTrue(from.matches("3"));	
	}
	
	
	@Test
	@DisplayName("N Level Test Case")
	void test_N_Level_2()
	{

			String from = hDAO.TEST_N_Level("قرة بن خالد");
			System.out.println(from);
			Assertions.assertTrue(from.matches(""));	
	}
	
}