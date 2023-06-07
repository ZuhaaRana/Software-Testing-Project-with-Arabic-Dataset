package dal;

import javax.swing.JTextField;

import to.HadithTO;

public interface IDAL 
{
	public HadithTO SearchHadith(String num, String book_name);
	public String Find_sanad_length(String num, String book_name);
	public String GetSanad(String num_hadith, String book);
	public void UpdateHadith(String Num_hadith, String Book, String sanad_length);
	public Boolean DeleteHadith(String num, String book_name);
	public String TEST_Search(String hadith_num, String book_name);
	public String TEST_Find_Sanad_Length(String hadith_num, String book_name);
	public String TEST_Update(String hadith_num, String book_name);
	public Boolean TEST_Delete(String hadith_num, String book_name);
	public String From_Narattor(String S, String name,String book);
	public String LEVEL(String name, String S);
	public String To_Narattor(String S, String name,String book);
}
