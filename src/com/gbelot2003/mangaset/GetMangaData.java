package com.gbelot2003.mangaset;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ajax
 */
public class GetMangaData {

        
    private String mangaTitle;
    private String mangaInfo;
    private String mangaImageInfo;
    private ArrayList<ChapterList> listUrl = new ArrayList<>();
    
    public GetMangaData(){}
    
    public String getMangaTitle() {
        return mangaTitle;
    }
    
    public String getMangaImageInfo() {
        return mangaImageInfo;
    }

    public String getMangaInfo() {
        return mangaInfo;
    }
    /**
     * Esta funcion no tiene set, agregamos directo a 
     * propiedad desde GetMangaInfo
     * @return 
     */
    public ArrayList<ChapterList> getChapterList(){
       return this.listUrl;     
    }
        
    protected void setMangaTitle(String mangaTitle) {
        this.mangaTitle = mangaTitle;
    }
    
    protected void setMangaInfo(String mangaInfo) {
        this.mangaInfo = mangaInfo;
    }
    
    protected void setMangaImageInfo(String mangaImageInfo) {
        this.mangaImageInfo = mangaImageInfo;
    }
          
    public void setMangaData(String UrlString) throws IOException{
          
        // Llamada a la pagia en concreto
        Document doc = Jsoup.connect(UrlString).get();
        
        // Divición de los elementos que necesitamos
        Element title = doc.select("h1.title-top").first();
        Element info = doc.select(".detail_info li span#hide").first();
        Elements infoImage = doc.select(".detail_info img");
        // Estos en particular son multiples, van a una ArraList
        Elements clinks = doc.select("ul.chapter_list li");
        
        // Instanciando los objetos de la clase
        this.setMangaTitle(title.text());
        this.setMangaImageInfo(infoImage.attr("src"));
        this.setMangaInfo(info.text());            
        
        for(Element el : clinks){
            // Ya creamos el prototipo de la info
            ChapterList links = new ChapterList();
           
            // Ahora llenamos los atributos del prototipo
            links.setSubTitle(el.select("a").text());
            links.setsubLink(el.select("a").attr("href"));
            links.setDate(el.select("span.time").text());
            
            // entregamos el objeto al ArrayList
            this.listUrl.add(links);
        } 
        
    }      

}
