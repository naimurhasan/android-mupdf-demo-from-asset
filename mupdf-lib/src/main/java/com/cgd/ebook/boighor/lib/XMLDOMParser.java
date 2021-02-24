package com.cgd.ebook.boighor.lib;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.cgd.ebook.boighor.model.TempBook;

import android.util.Log;

public class XMLDOMParser 
{
	public List<TempBook> parseXML(InputStream xmlStream)
	{
		List<TempBook> ebookList = new ArrayList<TempBook>();
		try
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();			
			//Get the DOM Builder
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    
		    Document document = builder.parse(xmlStream);	
		    
		    NodeList nodeList = document.getDocumentElement().getChildNodes();
		    int nodeListLen = nodeList.getLength();
		    TempBook ebookInfo;
		    
		    for (int indx = 0; indx < nodeListLen; indx++) 
		    {
		    	Node node = nodeList.item(indx);
		    	if (node instanceof Element) 
		    	{	
		    		ebookInfo = new TempBook();
		    		ebookInfo.setID(node.getAttributes().getNamedItem("id").getNodeValue());
    				ebookInfo.setEnName(node.getAttributes().getNamedItem("name").getNodeValue());
    				ebookInfo.setCategory(node.getAttributes().getNamedItem("category").getNodeValue());
    				ebookInfo.setBn_name(node.getAttributes().getNamedItem("bnname").getNodeValue());
    				ebookInfo.setPriceBDT(node.getAttributes().getNamedItem("price_bdt").getNodeValue());
    				ebookInfo.setPriceUSD(node.getAttributes().getNamedItem("price_usd").getNodeValue());
    				ebookInfo.setPriceVolume(node.getAttributes().getNamedItem("price_volume").getNodeValue());
    				ebookInfo.setPriceGBP(node.getAttributes().getNamedItem("price_gbp").getNodeValue());
    				ebookInfo.setImageName(node.getAttributes().getNamedItem("image_name").getNodeValue());
    				ebookInfo.setBnAuthur(node.getAttributes().getNamedItem("bn_authur").getNodeValue());
    				if (node.getAttributes().getNamedItem("purchased").getNodeValue().equals("true"))
    					ebookInfo.setPurchased(true);
    				ebookInfo.setPages(node.getAttributes().getNamedItem("pages").getNodeValue());
    				ebookList.add(ebookInfo);
		    	}
		    }
		}
		catch(Exception ex)
		{
			System.out.println("Error: "+ex.getMessage());
			ex.printStackTrace();
		}
		return ebookList;
	}
}