package com.cgd.ebook.boighor.model;

public class TempBook {
	private String id, en_name, bn_name, price_bdt, pages, category, bn_auther, bn_publisher;
	private boolean purchased = false;
	private boolean newbook = false;
	private int _tableID;
	private String price_usd, price_gbp, price_volume, image_name;
	public TempBook() {
		// TODO Auto-generated constructor stub
	}
	public void setID(String _id)
	{
		id = _id;
	}
	
	public void setEnName(String _en_name)
	{
		en_name = _en_name;
	}
	public void setBn_name(String _bn_name)
	{
		bn_name = _bn_name;
	}
	public void setPriceBDT(String bdt)
	{
		price_bdt = bdt;
	}
	public void setPages(String _basebitmap)
	{
		pages = _basebitmap;
	}
	public void setBnAuthur(String authur) {
		bn_auther = authur;
	}
	public void setCategory(String _cate)
	{
		category = _cate;
	}
	public void setPurchased(boolean flag) {
		purchased = flag;
	}
	public void setNewBook(boolean flag) {
		newbook = flag;
	}
	public void setImageName(String image) {
		image_name = image;
	}
	public void setPriceUSD(String usd) {
		price_usd = usd;
	}
	public void setPriceGBP(String gbp) {
		price_gbp = gbp;
	}
	public void setPriceVolume(String volume) {
		price_volume = volume;
	}
	public String getID() {
		return id;
	}
	public String getEnName() {
		return en_name;
	}
	public String getBnName() {
		return bn_name;
	}
	public String getPriceBDT() {
		return price_bdt;
	}
	public String getPages() {
		return pages;
	}
	public boolean getPurchased() {
		return purchased;
	}
	public boolean getNewOrNot() {
		return newbook;
	}
	public String getCategory() {
		return category;
	}
	public String getPriceVolume() {
		return price_volume;
	}
	public String getPriceUSD() {
		return price_usd;
	}
	public String getPriceGBP() {
		return price_gbp;
	}
	public String getImageFileName() {
		return image_name;
	}
	public String getAuthur() {
		return bn_auther;
	}
	public int get_tableID() {
		return _tableID;
	}
	public void set_tableID(int _tableID) {
		this._tableID = _tableID;
	}
	public String getBn_publisher() {
		return bn_publisher;
	}
	public void setBn_publisher(String bn_publisher) {
		this.bn_publisher = bn_publisher;
	}
}
