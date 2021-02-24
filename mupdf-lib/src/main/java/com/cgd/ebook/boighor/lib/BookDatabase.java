package com.cgd.ebook.boighor.lib;

import java.util.ArrayList;
import java.util.List;

import com.cgd.ebook.boighor.model.BookMarkInfo;
import com.cgd.ebook.boighor.model.TempBook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
import android.database.sqlite.SQLiteOpenHelper;

public class BookDatabase extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_NAME = "BOOKDATA.db";
	
	private static final String TABLE_BOOKLIST = "BOOKLIST";
	private static final String TABLE_BOOKMARK = "BOOKMARK";	
	private static final String TABLE_TEMP = "TEMPLIST";
	
	private static final String KEY_ID = "id";
	private static final String KEY_LIST_ID = "book_id";
	private static final String KEY_LIST_NAME = "book_name";
	private static final String KEY_LIST_PRICE_BDT= "price_bdt";
	private static final String KEY_LIST_PRICE_GBP = "price_gbp";
	private static final String KEY_LIST_PRICE_USD = "price_usd";
	private static final String KEY_LIST_PRICE_VOLUME = "price_volume";
	private static final String KEY_LIST_BN_NAME = "book_bn_name";
	private static final String KEY_LIST_AUTHOR = "author";
	private static final String KEY_LIST_IMAGE = "image_name";
	private static final String KEY_LIST_CATEGORY = "category";
	private static final String KEY_LIST_PAGES = "pages";
	private static final String KEY_LIST_PURCHASE = "purchased";
	private static final String KEY_LIST_NEWBOOK = "newbook";
	private static final String KEY_LIST_PUBLISHER = "publisher";
	
	private static final String KEY_MARK_FILENAME = "filename";
	private static final String KEY_MARK_COMMENT = "comment";
	private static final String KEY_MARK_PAGE = "gotopage";
	
	
	private static final String CREATE_BOOK_LIST = "CREATE TABLE " + TABLE_BOOKLIST + 
			"(" + KEY_ID + " INTEGER PRIMERY KEY," + KEY_LIST_ID + " TEXT," + KEY_LIST_NAME + " TEXT," +
			KEY_LIST_BN_NAME + " TEXT," + KEY_LIST_AUTHOR + " TEXT," + KEY_LIST_CATEGORY + " TEXT," +
			KEY_LIST_IMAGE + " TEXT," + KEY_LIST_PRICE_BDT + " TEXT," + KEY_LIST_PRICE_GBP + " TEXT," +
			KEY_LIST_PRICE_USD + " TEXT," + KEY_LIST_PRICE_VOLUME + " TEXT," + KEY_LIST_PAGES + " TEXT," +
			KEY_LIST_PUBLISHER+ " TEXT," + KEY_LIST_PURCHASE + " INTEGER," + KEY_LIST_NEWBOOK + " INTEGER);";
	
	private static final String CREATE_BOOKMARK = "CREATE TABLE " + TABLE_BOOKMARK + 
			"(" + KEY_ID + " INTEGER PRIMERY KEY," + KEY_MARK_FILENAME + " TEXT," + KEY_MARK_PAGE + " INTEGER,"+
			KEY_MARK_COMMENT + " TEXT);";
	
	private static final String CREATE_TEMP_LIST = "CREATE TABLE " + TABLE_TEMP + 
			"(" + KEY_ID + " INTEGER PRIMERY KEY," + KEY_LIST_ID + " TEXT," + KEY_LIST_NAME + " TEXT," +
			KEY_LIST_BN_NAME + " TEXT," + KEY_LIST_AUTHOR + " TEXT," + KEY_LIST_CATEGORY + " TEXT," +
			KEY_LIST_IMAGE + " TEXT," + KEY_LIST_PRICE_BDT + " TEXT," + KEY_LIST_PRICE_GBP + " TEXT," +
			KEY_LIST_PRICE_USD + " TEXT," + KEY_LIST_PRICE_VOLUME + " TEXT," + KEY_LIST_PAGES + " TEXT," +
			KEY_LIST_PUBLISHER+ " TEXT," + KEY_LIST_PURCHASE + " INTEGER," + KEY_LIST_NEWBOOK + " INTEGER);";
	
	public BookDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_BOOK_LIST);
		db.execSQL(CREATE_BOOKMARK);
		db.execSQL(CREATE_TEMP_LIST);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKLIST);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKMARK);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEMP);
		onCreate(db);
	}
	
	public long createEmbededBook(TempBook bookinfo)
	{
		SQLiteDatabase p_db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_LIST_ID, bookinfo.getID());
		values.put(KEY_LIST_AUTHOR, bookinfo.getAuthur());
		values.put(KEY_LIST_BN_NAME, bookinfo.getBnName());
		values.put(KEY_LIST_CATEGORY, bookinfo.getCategory());
		values.put(KEY_LIST_IMAGE, bookinfo.getImageFileName());
		values.put(KEY_LIST_NAME, bookinfo.getEnName());
		values.put(KEY_LIST_PRICE_BDT, bookinfo.getPriceBDT());
		values.put(KEY_LIST_PRICE_GBP, bookinfo.getPriceGBP());
		values.put(KEY_LIST_PRICE_USD, bookinfo.getPriceUSD());
		values.put(KEY_LIST_PRICE_VOLUME, bookinfo.getPriceVolume());
		values.put(KEY_LIST_PAGES, bookinfo.getPages());
		values.put(KEY_LIST_PUBLISHER, bookinfo.getBn_publisher());
		if (bookinfo.getPurchased())
			values.put(KEY_LIST_PURCHASE, 1);
		else
			values.put(KEY_LIST_PURCHASE, 0);
		if (bookinfo.getNewOrNot())
			values.put(KEY_LIST_NEWBOOK, 1);
		else
			values.put(KEY_LIST_NEWBOOK, 0);
		
		long tableID = p_db.insert(TABLE_BOOKLIST, null, values);
		return tableID;
	}
	
	public long createTempBook(TempBook bookinfo)
	{
		SQLiteDatabase p_db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_LIST_ID, bookinfo.getID());
		values.put(KEY_LIST_AUTHOR, bookinfo.getAuthur());
		values.put(KEY_LIST_BN_NAME, bookinfo.getBnName());
		values.put(KEY_LIST_CATEGORY, bookinfo.getCategory());
		values.put(KEY_LIST_IMAGE, bookinfo.getImageFileName());
		values.put(KEY_LIST_NAME, bookinfo.getEnName());
		values.put(KEY_LIST_PRICE_BDT, bookinfo.getPriceBDT());
		values.put(KEY_LIST_PRICE_GBP, bookinfo.getPriceGBP());
		values.put(KEY_LIST_PRICE_USD, bookinfo.getPriceUSD());
		values.put(KEY_LIST_PRICE_VOLUME, bookinfo.getPriceVolume());
		values.put(KEY_LIST_PAGES, bookinfo.getPages());
		values.put(KEY_LIST_PUBLISHER, bookinfo.getBn_publisher());
		if (bookinfo.getPurchased())
			values.put(KEY_LIST_PURCHASE, 1);
		else
			values.put(KEY_LIST_PURCHASE, 0);
		if (bookinfo.getNewOrNot())
			values.put(KEY_LIST_NEWBOOK, 1);
		else
			values.put(KEY_LIST_NEWBOOK, 0);
		
		long tableID = p_db.insert(TABLE_TEMP, null, values);
		return tableID;
	}
	
	public long createBookMark(BookMarkInfo info)
	{
		SQLiteDatabase p_db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_MARK_FILENAME, info.getmFileName());
		values.put(KEY_MARK_PAGE, info.getPage());
		values.put(KEY_MARK_COMMENT, info.getmComment());
		
		long markID = p_db.insert(TABLE_BOOKMARK, null, values);
		return markID;
	}
	
	public boolean isExistsInTemp(String bookID)
	{
		SQLiteDatabase p_db = this.getReadableDatabase();
		
		String selectQuery = "SELECT * FROM " + TABLE_TEMP + " WHERE " + KEY_LIST_ID + " = '" + bookID + "'";
		Cursor cursor = p_db.rawQuery(selectQuery, null);
		if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
		cursor.close();
		return true;
	}
	
	public List<String> getAllAuthurs() 
	{
		SQLiteDatabase p_db = this.getWritableDatabase();
		List<String> authorlists = new ArrayList<String>();
		String selectQuery = "SELECT DISTINCT " + KEY_LIST_AUTHOR + " FROM " + TABLE_TEMP;
		
		Cursor cursor = p_db.rawQuery(selectQuery, null);
		
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					String author = cursor.getString(cursor.getColumnIndex(KEY_LIST_AUTHOR));
					authorlists.add(author);
				} while (cursor.moveToNext());
			}
		}
			
		
		return authorlists;
	}
	
	public List<String> getAllPublishers()
	{
		SQLiteDatabase p_db = this.getWritableDatabase();
		List<String> publisherLists = new ArrayList<String>();
		String selectQuery = "SELECT DISTINCT " + KEY_LIST_PUBLISHER + " FROM " + TABLE_TEMP;
		
		Cursor cursor = p_db.rawQuery(selectQuery, null);
		
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					String author = cursor.getString(cursor.getColumnIndex(KEY_LIST_PUBLISHER));
					publisherLists.add(author);
				} while (cursor.moveToNext());
			}
		}
			
		
		return publisherLists;
	}
	
	public List<String> getAllCategories() 
	{
		SQLiteDatabase p_db = this.getWritableDatabase();
		List<String> authorlists = new ArrayList<String>();
		String selectQuery = "SELECT DISTINCT " + KEY_LIST_CATEGORY + " FROM " + TABLE_TEMP;
		
		Cursor cursor = p_db.rawQuery(selectQuery, null);
		
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					String author = cursor.getString(cursor.getColumnIndex(KEY_LIST_CATEGORY));
					authorlists.add(author);
				} while (cursor.moveToNext());
			}
		}
			
		
		return authorlists;
	}
	
	public List<String> getAllBookNamesWithCategoryAndAuthorAndPublisher(String Category, String Author, String Publisher) 
	{
		SQLiteDatabase p_db = this.getWritableDatabase();
		List<String> authorlists = new ArrayList<String>();
		String selectQuery = "SELECT DISTINCT " + KEY_LIST_BN_NAME + " FROM " + TABLE_TEMP;
		
		if (Category.equals("all")) {
			if (Author.equals("all"))
			{
				if (!Publisher.equals("all"))
					selectQuery += " WHERE " + KEY_LIST_PUBLISHER + " = '" + Publisher + "'";
			} else {
				selectQuery += " WHERE " + KEY_LIST_AUTHOR + " = '" + Author + "'";
				if (!Publisher.equals("all")) 
					selectQuery += " AND " + KEY_LIST_PUBLISHER + " = '" + Publisher + "'";
			}
				
		} else if (Category.equals("Children's Book")) {
			selectQuery +=" WHERE " + KEY_LIST_CATEGORY + " LIKE \"Children%\"";
			if (!Author.equals("all"))
				selectQuery += " AND " + KEY_LIST_AUTHOR + " = '" + Author + "'";
			if (!Publisher.equals("all"))
				selectQuery += " AND " + KEY_LIST_PUBLISHER + " = '" + Publisher + "'";
		} else {
			selectQuery +=" WHERE " + KEY_LIST_CATEGORY + " = '" + Category + "'";
			if (!Author.equals("all"))
				selectQuery += " AND " + KEY_LIST_AUTHOR + " = '" + Author + "'";
			if (!Publisher.equals("all"))
				selectQuery += " AND " + KEY_LIST_PUBLISHER + " = '" + Publisher + "'";
		}
		
		Cursor cursor = p_db.rawQuery(selectQuery, null);
		
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					String author = cursor.getString(cursor.getColumnIndex(KEY_LIST_BN_NAME));
					authorlists.add(author);
				} while (cursor.moveToNext());
			}
		}
			
		
		return authorlists;
	}
	
	
	public TempBook getTempBooksWithTitle(String book_title)
	{
		List<TempBook> tmpBooks = new ArrayList<TempBook>();
		
		SQLiteDatabase p_db = this.getReadableDatabase();
		String selectQuery = "SELECT * FROM " + TABLE_TEMP + " WHERE " + KEY_LIST_NAME +
				" = '" + book_title + "'";
		
		Cursor cursor = p_db.rawQuery(selectQuery, null);
		
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					TempBook book = new TempBook();
					book.set_tableID(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
					book.setEnName(cursor.getString(cursor.getColumnIndex(KEY_LIST_NAME)));
					book.setID(cursor.getString(cursor.getColumnIndex(KEY_LIST_ID)));
					book.setBn_name(cursor.getString(cursor.getColumnIndex(KEY_LIST_BN_NAME)));
					book.setCategory(cursor.getString(cursor.getColumnIndex(KEY_LIST_CATEGORY)));
					book.setBnAuthur(cursor.getString(cursor.getColumnIndex(KEY_LIST_AUTHOR)));
					book.setImageName(cursor.getString(cursor.getColumnIndex(KEY_LIST_IMAGE)));
					book.setPages(cursor.getString(cursor.getColumnIndex(KEY_LIST_PAGES)));
					book.setPriceBDT(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_BDT)));
					book.setPriceGBP(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_GBP)));
					book.setPriceUSD(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_USD)));
					book.setPriceVolume(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_VOLUME)));
					book.setBn_publisher(cursor.getString(cursor.getColumnIndex(KEY_LIST_PUBLISHER)));
					if (cursor.getInt(cursor.getColumnIndex(KEY_LIST_PURCHASE)) == 1)
						book.setPurchased(true);
					else
						book.setPurchased(false);
					
					if (cursor.getInt(cursor.getColumnIndex(KEY_LIST_NEWBOOK)) == 1)
						book.setNewBook(true);
					else
						book.setNewBook(false);
					
					tmpBooks.add(book);
				} while (cursor.moveToNext());
			}
		}
		
		if (tmpBooks.size() > 0)
			return tmpBooks.get(0);
		else
			return null;
	}
	
	public boolean isExistsInEmbeded(String bookID)
	{
		SQLiteDatabase p_db = this.getReadableDatabase();
		
		String selectQuery = "SELECT * FROM " + TABLE_BOOKLIST + " WHERE " + KEY_LIST_ID + " = '" + bookID + "'";
		Cursor cursor = p_db.rawQuery(selectQuery, null);
		if(cursor.getCount() <= 0){
            cursor.close();
            return true;
        }
		cursor.close();
		return false;
	}
	
	public List<TempBook> getAllTempBooks() 
	{
		List<TempBook> tmpBooks = new ArrayList<TempBook>();
		
		SQLiteDatabase p_db = this.getReadableDatabase();
		String selectQuery = "SELECT * FROM " + TABLE_TEMP;
		
		Cursor cursor = p_db.rawQuery(selectQuery, null);
		
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					TempBook book = new TempBook();
					book.set_tableID(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
					book.setEnName(cursor.getString(cursor.getColumnIndex(KEY_LIST_NAME)));
					book.setID(cursor.getString(cursor.getColumnIndex(KEY_LIST_ID)));
					book.setBn_name(cursor.getString(cursor.getColumnIndex(KEY_LIST_BN_NAME)));
					book.setCategory(cursor.getString(cursor.getColumnIndex(KEY_LIST_CATEGORY)));
					book.setBnAuthur(cursor.getString(cursor.getColumnIndex(KEY_LIST_AUTHOR)));
					book.setImageName(cursor.getString(cursor.getColumnIndex(KEY_LIST_IMAGE)));
					book.setPages(cursor.getString(cursor.getColumnIndex(KEY_LIST_PAGES)));
					book.setPriceBDT(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_BDT)));
					book.setPriceGBP(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_GBP)));
					book.setPriceUSD(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_USD)));
					book.setPriceVolume(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_VOLUME)));
					book.setBn_publisher(cursor.getString(cursor.getColumnIndex(KEY_LIST_PUBLISHER)));
					if (cursor.getInt(cursor.getColumnIndex(KEY_LIST_PURCHASE)) == 1)
						book.setPurchased(true);
					else
						book.setPurchased(false);
					
					if (cursor.getInt(cursor.getColumnIndex(KEY_LIST_NEWBOOK)) == 1)
						book.setNewBook(true);
					else
						book.setNewBook(false);
					
					tmpBooks.add(book);
				} while (cursor.moveToNext());
			}
		}
		
		return tmpBooks;
	}
	
	public List<TempBook> getAllEmbededBooks()
	{
		List<TempBook> embedbooks = new ArrayList<TempBook>();
		
		SQLiteDatabase p_db = this.getReadableDatabase();
		String selectQuery = "SELECT * FROM " + TABLE_BOOKLIST;
		
		Cursor cursor = p_db.rawQuery(selectQuery, null);
		
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					TempBook book = new TempBook();
					book.set_tableID(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
					book.setEnName(cursor.getString(cursor.getColumnIndex(KEY_LIST_NAME)));
					book.setID(cursor.getString(cursor.getColumnIndex(KEY_LIST_ID)));
					book.setBn_name(cursor.getString(cursor.getColumnIndex(KEY_LIST_BN_NAME)));
					book.setCategory(cursor.getString(cursor.getColumnIndex(KEY_LIST_CATEGORY)));
					book.setBnAuthur(cursor.getString(cursor.getColumnIndex(KEY_LIST_AUTHOR)));
					book.setImageName(cursor.getString(cursor.getColumnIndex(KEY_LIST_IMAGE)));
					book.setPages(cursor.getString(cursor.getColumnIndex(KEY_LIST_PAGES)));
					book.setPriceBDT(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_BDT)));
					book.setPriceGBP(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_GBP)));
					book.setPriceUSD(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_USD)));
					book.setPriceVolume(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_VOLUME)));
					book.setBn_publisher(cursor.getString(cursor.getColumnIndex(KEY_LIST_PUBLISHER)));
					if (cursor.getInt(cursor.getColumnIndex(KEY_LIST_PURCHASE)) == 1)
						book.setPurchased(true);
					else
						book.setPurchased(false);
					
					if (cursor.getInt(cursor.getColumnIndex(KEY_LIST_NEWBOOK)) == 1)
						book.setNewBook(true);
					else
						book.setNewBook(false);
					
					embedbooks.add(book);
				} while (cursor.moveToNext());
			}
		}
		
		return embedbooks;
	}
	
	public List<BookMarkInfo> getAllBookMarks() 
	{
		List<BookMarkInfo> bookmarks = new ArrayList<BookMarkInfo>();
		
		SQLiteDatabase p_db = this.getReadableDatabase();
		String selectQuery = "SELECT * FROM " + TABLE_BOOKMARK;
		
		Cursor cursor = p_db.rawQuery(selectQuery, null);
		
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					BookMarkInfo bookmark = new BookMarkInfo();
					bookmark.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
					bookmark.setmFileName(cursor.getString(cursor.getColumnIndex(KEY_MARK_FILENAME)));
					bookmark.setmComment(cursor.getString(cursor.getColumnIndex(KEY_MARK_COMMENT)));
					bookmark.setPage(cursor.getInt(cursor.getColumnIndex(KEY_MARK_PAGE)));
					bookmarks.add(bookmark);
				} while (cursor.moveToNext());
			}
		}
		
		return bookmarks;
	}
	
	public List<TempBook> getTempBooksWithCategory(String category)
	{
		List<TempBook> tmpBooks = new ArrayList<TempBook>();
		
		SQLiteDatabase p_db = this.getReadableDatabase();
		String selectQuery = "SELECT * FROM " + TABLE_TEMP + " WHERE " + KEY_LIST_CATEGORY +
				" = '" + category + "'";
		
		Cursor cursor = p_db.rawQuery(selectQuery, null);
		
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					TempBook book = new TempBook();
					book.set_tableID(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
					book.setEnName(cursor.getString(cursor.getColumnIndex(KEY_LIST_NAME)));
					book.setID(cursor.getString(cursor.getColumnIndex(KEY_LIST_ID)));
					book.setBn_name(cursor.getString(cursor.getColumnIndex(KEY_LIST_BN_NAME)));
					book.setCategory(cursor.getString(cursor.getColumnIndex(KEY_LIST_CATEGORY)));
					book.setBnAuthur(cursor.getString(cursor.getColumnIndex(KEY_LIST_AUTHOR)));
					book.setImageName(cursor.getString(cursor.getColumnIndex(KEY_LIST_IMAGE)));
					book.setPages(cursor.getString(cursor.getColumnIndex(KEY_LIST_PAGES)));
					book.setPriceBDT(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_BDT)));
					book.setPriceGBP(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_GBP)));
					book.setPriceUSD(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_USD)));
					book.setPriceVolume(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_VOLUME)));
					book.setBn_publisher(cursor.getString(cursor.getColumnIndex(KEY_LIST_PUBLISHER)));
					if (cursor.getInt(cursor.getColumnIndex(KEY_LIST_PURCHASE)) == 1)
						book.setPurchased(true);
					else
						book.setPurchased(false);
					
					if (cursor.getInt(cursor.getColumnIndex(KEY_LIST_NEWBOOK)) == 1)
						book.setNewBook(true);
					else
						book.setNewBook(false);
					
					tmpBooks.add(book);
				} while (cursor.moveToNext());
			}
		}
		
		return tmpBooks;
	}
	
	public List<TempBook> getBooksWithCategoryAndAuthurAndPublisherAndBook(String category, String author, String Publisher, String bookname)
	{
		List<TempBook> tmpBooks = new ArrayList<TempBook>();
		
		SQLiteDatabase p_db = this.getReadableDatabase();
		String selectQuery = "SELECT * FROM " + TABLE_TEMP;
		
		if (category.equals("all"))
		{
			if (author.equals("all"))
			{
				if (Publisher.equals("all")) {
					if (!bookname.equals("all"))
						selectQuery += " WHERE " + KEY_LIST_BN_NAME + " = '" + bookname +"'";
				} else {
					selectQuery += " WHERE " + KEY_LIST_PUBLISHER + " = '" + Publisher +"'";
					if (!bookname.equals("all"))
						selectQuery += " AND " + KEY_LIST_BN_NAME + " = '" + bookname + "'";
				}
				
			} else {
				selectQuery += " WHERE " + KEY_LIST_AUTHOR + " = '" + author +"'";
				if (!Publisher.equals("all"))
					selectQuery += " AND " + KEY_LIST_PUBLISHER + " = '" + Publisher + "'";
				if (!bookname.equals("all"))
					selectQuery += " AND " + KEY_LIST_BN_NAME + " = '" + bookname + "'";
			}
		} else if (category.equals("Children's Book")){
			selectQuery += " WHERE " + KEY_LIST_CATEGORY + " LIKE \"Children%\"";
			if (!author.equals("all"))
				selectQuery += " AND " + KEY_LIST_AUTHOR + " = '" + author + "'";
			if (!Publisher.equals("all"))
				selectQuery += " AND " + KEY_LIST_PUBLISHER + " = '" + Publisher + "'";
			if (!bookname.equals("all"))
				selectQuery += " AND " + KEY_LIST_BN_NAME + " = '" + bookname + "'";
		} else {
			selectQuery += " WHERE " + KEY_LIST_CATEGORY + " = '" + category + "'";
			if (!author.equals("all"))
				selectQuery += " AND " + KEY_LIST_AUTHOR + " = '" + author + "'";
			if (!Publisher.equals("all"))
				selectQuery += " AND " + KEY_LIST_PUBLISHER + " = '" + Publisher + "'";
			if (!bookname.equals("all"))
				selectQuery += " AND " + KEY_LIST_BN_NAME + " = '" + bookname + "'";
		}
		
		Cursor cursor = p_db.rawQuery(selectQuery, null);
		
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					TempBook book = new TempBook();
					book.set_tableID(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
					book.setEnName(cursor.getString(cursor.getColumnIndex(KEY_LIST_NAME)));
					book.setID(cursor.getString(cursor.getColumnIndex(KEY_LIST_ID)));
					book.setBn_name(cursor.getString(cursor.getColumnIndex(KEY_LIST_BN_NAME)));
					book.setCategory(cursor.getString(cursor.getColumnIndex(KEY_LIST_CATEGORY)));
					book.setBnAuthur(cursor.getString(cursor.getColumnIndex(KEY_LIST_AUTHOR)));
					book.setImageName(cursor.getString(cursor.getColumnIndex(KEY_LIST_IMAGE)));
					book.setPages(cursor.getString(cursor.getColumnIndex(KEY_LIST_PAGES)));
					book.setPriceBDT(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_BDT)));
					book.setPriceGBP(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_GBP)));
					book.setPriceUSD(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_USD)));
					book.setPriceVolume(cursor.getString(cursor.getColumnIndex(KEY_LIST_PRICE_VOLUME)));
					book.setBn_publisher(cursor.getString(cursor.getColumnIndex(KEY_LIST_PUBLISHER)));
					if (cursor.getInt(cursor.getColumnIndex(KEY_LIST_PURCHASE)) == 1)
						book.setPurchased(true);
					else
						book.setPurchased(false);
					
					if (cursor.getInt(cursor.getColumnIndex(KEY_LIST_NEWBOOK)) == 1)
						book.setNewBook(true);
					else
						book.setNewBook(false);
					
					tmpBooks.add(book);
				} while (cursor.moveToNext());
			}
		}
		
		return tmpBooks;
	}
	
	public List<BookMarkInfo> getBookMarksWithFileName(String FileName) {
		List<BookMarkInfo> bookmarks = new ArrayList<BookMarkInfo>();
		
		SQLiteDatabase p_db = this.getReadableDatabase();
		String selectQuery = "SELECT * FROM " + TABLE_BOOKMARK + " WHERE " + KEY_MARK_FILENAME + " = '" + FileName + "'";
		
		Cursor cursor = p_db.rawQuery(selectQuery, null);
		
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					BookMarkInfo bookmark = new BookMarkInfo();
					bookmark.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
					bookmark.setmFileName(cursor.getString(cursor.getColumnIndex(KEY_MARK_FILENAME)));
					bookmark.setmComment(cursor.getString(cursor.getColumnIndex(KEY_MARK_COMMENT)));
					bookmark.setPage(cursor.getInt(cursor.getColumnIndex(KEY_MARK_PAGE)));
					bookmarks.add(bookmark);
				} while (cursor.moveToNext());
			}
		}
		
		return bookmarks;
	}
	
	public void deleteDownedBooks(TempBook book)
	{
		SQLiteDatabase p_db = getWritableDatabase();
		p_db.delete(TABLE_BOOKLIST, KEY_LIST_ID + " = ?", new String[] {book.getID()});
	}
	
	public void deleteTempBook(TempBook book)
	{
		SQLiteDatabase p_db = getWritableDatabase();
		p_db.delete(TABLE_TEMP, KEY_LIST_ID + " = ?", new String[]{book.getID()});
	}
	
	
	
	public int updateTempBook(TempBook book)
	{
		SQLiteDatabase p_db = getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_LIST_ID, book.getID());
		values.put(KEY_LIST_AUTHOR, book.getAuthur());
		values.put(KEY_LIST_BN_NAME, book.getBnName());
		values.put(KEY_LIST_CATEGORY, book.getCategory());
		values.put(KEY_LIST_IMAGE, book.getImageFileName());
		values.put(KEY_LIST_NAME, book.getEnName());
		values.put(KEY_LIST_PRICE_BDT, book.getPriceBDT());
		values.put(KEY_LIST_PRICE_GBP, book.getPriceGBP());
		values.put(KEY_LIST_PRICE_USD, book.getPriceUSD());
		values.put(KEY_LIST_PRICE_VOLUME, book.getPriceVolume());
		values.put(KEY_LIST_PAGES, book.getPages());
		values.put(KEY_LIST_PUBLISHER, book.getBn_publisher());
		if (book.getPurchased())
			values.put(KEY_LIST_PURCHASE, 1);
		else
			values.put(KEY_LIST_PURCHASE, 0);
		if (book.getNewOrNot())
			values.put(KEY_LIST_NEWBOOK, 1);
		else
			values.put(KEY_LIST_NEWBOOK, 0);
		
		return p_db.update(TABLE_TEMP, values, KEY_LIST_ID + " = ?", new String[] { book.getID()});
	}
	
	public void CloseDB() {
        SQLiteDatabase p_databse = this.getReadableDatabase();
        if (p_databse != null && p_databse.isOpen())
            p_databse.close();
    }
}
