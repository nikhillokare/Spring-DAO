package com.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.bean.Book;

public class BookDao {
	
	private JdbcTemplate jt;

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	//Insert
	public int insertBook(Book b)
	{
		String sql = "insert into JTBookDetails values(?,?,?,?)";
		Object[] values = {b.getBid(),b.getBookName(),b.getAuthorName(),b.getPrice()};
		System.out.println("Record added successfully");
		return jt.update(sql, values);
	}
	//Update
	public int updateBook(String bn,float p)
	{
		String sql = "Update JTBookDetails set price='"+p+"' where bookName='"+bn+"'";
		return jt.update(sql);
		
	}
	//Delete
	public int deleteBook(String bn)
	{
		String sql = "Delete from JTBookDetails  where bookName='"+bn+"'";
		return jt.update(sql);

    }
	//FetchAll
	public List<Book> fetchall()
	{
		String sql = "Select * from JTBookDetails";
		List<Book> lBook=jt.query(sql, new RowMapper(){
			@Override 
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				Book book = new Book();
				book.setBid(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthorName(rs.getString(3));
				book.setPrice(rs.getFloat(4));
			return book; 
			}
		 });
		return lBook;
	}
	public List<Book> fetchByCondition(int bookId)
	{
		String sql = "Select * from JTBookDetails where bid=?";
		Object[] values= {bookId};
		List<Book> book = (List<Book>) jt.query(sql, values, new ResultSetExtractor() {

			@Override
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Book> l = new ArrayList<>();	
				while(rs.next())
				{
					Book book=new Book();
					book.setBid(rs.getInt(1));
					book.setBookName(rs.getString(2));
					book.setAuthorName(rs.getString(3));
					book.setPrice(rs.getFloat(4));
					l.add(book);
				}
				return l;
			}
			
		});
		return book;
		
	}
	
}	
